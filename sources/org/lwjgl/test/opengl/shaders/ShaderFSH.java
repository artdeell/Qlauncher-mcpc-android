package org.lwjgl.test.opengl.shaders;

import org.lwjgl.opengl.ARBShaderObjects;

final class ShaderFSH extends Shader {
    final String fshFile;
    final int fshID;
    final String fshSource;
    final int programID;
    final int uniformLocation;
    final String vshFile;
    final int vshID = ARBShaderObjects.glCreateShaderObjectARB(35633);
    final String vshSource;

    ShaderFSH(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        this.vshFile = str3;
        this.vshSource = getShaderText(str3);
        ARBShaderObjects.glShaderSourceARB(this.vshID, (CharSequence) this.vshSource);
        ARBShaderObjects.glCompileShaderARB(this.vshID);
        printShaderObjectInfoLog(this.vshFile, this.vshID);
        if (ARBShaderObjects.glGetObjectParameteriARB(this.vshID, 35713) == 0) {
            ShadersTest.kill("A compilation error occured in a vertex shader.");
        }
        this.fshFile = str4;
        this.fshSource = getShaderText(str4);
        this.fshID = ARBShaderObjects.glCreateShaderObjectARB(35632);
        ARBShaderObjects.glShaderSourceARB(this.fshID, (CharSequence) this.fshSource);
        ARBShaderObjects.glCompileShaderARB(this.fshID);
        printShaderObjectInfoLog(this.fshFile, this.fshID);
        if (ARBShaderObjects.glGetObjectParameteriARB(this.fshID, 35713) == 0) {
            ShadersTest.kill("A compilation error occured in a fragment shader.");
        }
        this.programID = ARBShaderObjects.glCreateProgramObjectARB();
        ARBShaderObjects.glAttachObjectARB(this.programID, this.vshID);
        ARBShaderObjects.glAttachObjectARB(this.programID, this.fshID);
        ARBShaderObjects.glLinkProgramARB(this.programID);
        printShaderProgramInfoLog(this.programID);
        if (ARBShaderObjects.glGetObjectParameteriARB(this.programID, 35714) == 0) {
            ShadersTest.kill("A linking error occured in a shader program.");
        }
        this.uniformLocation = getUniformLocation(this.programID, "UNIFORMS");
    }

    /* access modifiers changed from: 0000 */
    public void cleanup() {
        ARBShaderObjects.glDetachObjectARB(this.programID, this.vshID);
        ARBShaderObjects.glDetachObjectARB(this.programID, this.fshID);
        ARBShaderObjects.glDeleteObjectARB(this.vshID);
        ARBShaderObjects.glDeleteObjectARB(this.fshID);
        ARBShaderObjects.glDeleteObjectARB(this.programID);
    }

    /* access modifiers changed from: 0000 */
    public void render() {
        ARBShaderObjects.glUseProgramObjectARB(this.programID);
        ARBShaderObjects.glUniform4fARB(this.uniformLocation, ShadersTest.getSin(), 8.0f * ((float) ShadersTest.getSpecularity()), 0.5f * ((float) (-ShadersTest.getDisplayWidth())), 0.5f * ((float) (-ShadersTest.getDisplayHeight())));
        ShadersTest.renderObject();
        ARBShaderObjects.glUseProgramObjectARB(0);
    }
}
