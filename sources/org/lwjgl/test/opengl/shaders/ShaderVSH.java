package org.lwjgl.test.opengl.shaders;

import org.lwjgl.opengl.ARBShaderObjects;

final class ShaderVSH extends Shader {
    final String file;
    final int programID;
    final int shaderID = ARBShaderObjects.glCreateShaderObjectARB(35633);
    final String source;
    final int uniformLocation;

    ShaderVSH(String str) {
        String str2 = str;
        this.file = str2;
        this.source = getShaderText(str2);
        ARBShaderObjects.glShaderSourceARB(this.shaderID, (CharSequence) this.source);
        ARBShaderObjects.glCompileShaderARB(this.shaderID);
        printShaderObjectInfoLog(this.file, this.shaderID);
        if (ARBShaderObjects.glGetObjectParameteriARB(this.shaderID, 35713) == 0) {
            ShadersTest.kill("A compilation error occured in a vertex shader.");
        }
        this.programID = ARBShaderObjects.glCreateProgramObjectARB();
        ARBShaderObjects.glAttachObjectARB(this.programID, this.shaderID);
        ARBShaderObjects.glLinkProgramARB(this.programID);
        printShaderProgramInfoLog(this.programID);
        if (ARBShaderObjects.glGetObjectParameteriARB(this.programID, 35714) == 0) {
            ShadersTest.kill("A linking error occured in a shader program.");
        }
        this.uniformLocation = getUniformLocation(this.programID, "UNIFORMS");
    }

    /* access modifiers changed from: 0000 */
    public void cleanup() {
        ARBShaderObjects.glDetachObjectARB(this.programID, this.shaderID);
        ARBShaderObjects.glDeleteObjectARB(this.shaderID);
        ARBShaderObjects.glDeleteObjectARB(this.programID);
    }

    /* access modifiers changed from: 0000 */
    public void render() {
        ARBShaderObjects.glUseProgramObjectARB(this.programID);
        ARBShaderObjects.glUniform2fARB(this.uniformLocation, ShadersTest.getSin(), 8.0f * ((float) ShadersTest.getSpecularity()));
        ShadersTest.renderObject();
        ARBShaderObjects.glUseProgramObjectARB(0);
    }
}
