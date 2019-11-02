package org.lwjgl.test.opengl.shaders;

import java.io.PrintStream;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBUniformBufferObject;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.Util;

final class ShaderUNI extends Shader {
    final FloatBuffer buffer;
    final int bufferID;
    final String file;
    final int programID;
    final int shaderID = GL20.glCreateShader(35633);
    final String source;
    final int uniformA_index;
    final int uniformA_offset;
    final int uniformB_index;
    final int uniformB_offset;

    ShaderUNI(String str) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        String str2 = str;
        this.file = str2;
        this.source = getShaderText(str2);
        GL20.glShaderSource(this.shaderID, (CharSequence) this.source);
        GL20.glCompileShader(this.shaderID);
        printShaderObjectInfoLog(this.file, this.shaderID);
        if (GL20.glGetShaderi(this.shaderID, 35713) == 0) {
            ShadersTest.kill("A compilation error occured in a vertex shader.");
        }
        this.programID = GL20.glCreateProgram();
        GL20.glAttachShader(this.programID, this.shaderID);
        GL20.glLinkProgram(this.programID);
        printShaderProgramInfoLog(this.programID);
        if (GL20.glGetProgrami(this.programID, 35714) == 0) {
            ShadersTest.kill("A linking error occured in a shader program.");
        }
        String[] strArr = new String[2];
        String[] strArr2 = strArr;
        strArr[0] = "uniformA";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "uniformB";
        String[] strArr5 = strArr4;
        int glGetUniformBlockIndex = ARBUniformBufferObject.glGetUniformBlockIndex(this.programID, (CharSequence) "test");
        int glGetActiveUniformBlocki = ARBUniformBufferObject.glGetActiveUniformBlocki(this.programID, glGetUniformBlockIndex, 35392);
        PrintStream printStream = System.out;
        StringBuilder sb6 = sb;
        StringBuilder sb7 = new StringBuilder();
        printStream.println(sb6.append("blockSize = ").append(glGetActiveUniformBlocki).toString());
        this.bufferID = GL15.glGenBuffers();
        GL15.glBindBuffer(35345, this.bufferID);
        GL15.glBufferData(35345, (long) glGetActiveUniformBlocki, 35048);
        this.buffer = BufferUtils.createFloatBuffer(glGetActiveUniformBlocki);
        ARBUniformBufferObject.glBindBufferBase(35345, 0, this.bufferID);
        ARBUniformBufferObject.glUniformBlockBinding(this.programID, glGetUniformBlockIndex, 0);
        IntBuffer createIntBuffer = BufferUtils.createIntBuffer(strArr5.length);
        IntBuffer createIntBuffer2 = BufferUtils.createIntBuffer(strArr5.length);
        ARBUniformBufferObject.glGetUniformIndices(this.programID, (CharSequence[]) strArr5, createIntBuffer);
        this.uniformA_index = createIntBuffer.get(0);
        this.uniformB_index = createIntBuffer.get(1);
        ARBUniformBufferObject.glGetActiveUniforms(this.programID, createIntBuffer, 35387, createIntBuffer2);
        this.uniformA_offset = createIntBuffer2.get(0);
        this.uniformB_offset = createIntBuffer2.get(1);
        PrintStream printStream2 = System.out;
        StringBuilder sb8 = sb2;
        StringBuilder sb9 = new StringBuilder();
        printStream2.println(sb8.append("\nuniformA index = ").append(this.uniformA_index).toString());
        PrintStream printStream3 = System.out;
        StringBuilder sb10 = sb3;
        StringBuilder sb11 = new StringBuilder();
        printStream3.println(sb10.append("uniformB index = ").append(this.uniformB_index).toString());
        PrintStream printStream4 = System.out;
        StringBuilder sb12 = sb4;
        StringBuilder sb13 = new StringBuilder();
        printStream4.println(sb12.append("\nuniformA offset = ").append(this.uniformA_offset).append(" - should be 0 for std140").toString());
        PrintStream printStream5 = System.out;
        StringBuilder sb14 = sb5;
        StringBuilder sb15 = new StringBuilder();
        printStream5.println(sb14.append("uniformB offset = ").append(this.uniformB_offset).append(" - should be 16 for std140").toString());
        Util.checkGLError();
    }

    /* access modifiers changed from: 0000 */
    public void cleanup() {
        GL15.glDeleteBuffers(this.bufferID);
        GL20.glDetachShader(this.programID, this.shaderID);
        GL20.glDeleteShader(this.shaderID);
        GL20.glDeleteProgram(this.programID);
    }

    /* access modifiers changed from: 0000 */
    public void render() {
        GL20.glUseProgram(this.programID);
        FloatBuffer put = this.buffer.put(0, ShadersTest.getSin()).put(1, 8.0f * ((float) ShadersTest.getSpecularity()));
        FloatBuffer put2 = this.buffer.put(4, 0.0f).put(5, 0.7f).put(6, 0.0f);
        GL15.glBindBuffer(35345, this.bufferID);
        GL15.glBufferData(35345, this.buffer, 35048);
        ShadersTest.renderObject();
        GL20.glUseProgram(0);
    }
}
