package org.lwjgl.test.opengl.shaders;

import org.lwjgl.opengl.ARBFragmentProgram;
import org.lwjgl.opengl.ARBProgram;
import org.lwjgl.opengl.GL11;

final class ShaderFP extends Shader {
    final String fpFile;
    final int fpID;
    final String fpSource;
    final String vpFile;
    final int vpID = ARBProgram.glGenProgramsARB();
    final String vpSource;

    ShaderFP(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        this.vpFile = str3;
        this.vpSource = getShaderText(str3);
        ARBProgram.glBindProgramARB(34336, this.vpID);
        ARBProgram.glProgramStringARB(34336, (int) ARBProgram.GL_PROGRAM_FORMAT_ASCII_ARB, (CharSequence) this.vpSource);
        checkProgramError(this.vpFile, this.vpSource);
        this.fpFile = str4;
        this.fpSource = getShaderText(str4);
        this.fpID = ARBProgram.glGenProgramsARB();
        ARBProgram.glBindProgramARB(ARBFragmentProgram.GL_FRAGMENT_PROGRAM_ARB, this.fpID);
        ARBProgram.glProgramStringARB((int) ARBFragmentProgram.GL_FRAGMENT_PROGRAM_ARB, (int) ARBProgram.GL_PROGRAM_FORMAT_ASCII_ARB, (CharSequence) this.fpSource);
        checkProgramError(this.fpFile, this.fpSource);
    }

    /* access modifiers changed from: 0000 */
    public void cleanup() {
        ARBProgram.glDeleteProgramsARB(this.vpID);
        ARBProgram.glDeleteProgramsARB(this.fpID);
    }

    /* access modifiers changed from: 0000 */
    public void render() {
        GL11.glEnable(34336);
        ARBProgram.glBindProgramARB(34336, this.vpID);
        GL11.glEnable(ARBFragmentProgram.GL_FRAGMENT_PROGRAM_ARB);
        ARBProgram.glBindProgramARB(ARBFragmentProgram.GL_FRAGMENT_PROGRAM_ARB, this.fpID);
        ARBProgram.glProgramLocalParameter4fARB(34336, 0, ShadersTest.getSin(), 8.0f * ((float) ShadersTest.getSpecularity()), 0.0f, 0.0f);
        ARBProgram.glProgramLocalParameter4fARB(ARBFragmentProgram.GL_FRAGMENT_PROGRAM_ARB, 0, ShadersTest.getSin(), 8.0f * ((float) ShadersTest.getSpecularity()), 0.5f * ((float) (-ShadersTest.getDisplayWidth())), 0.5f * ((float) (-ShadersTest.getDisplayHeight())));
        ShadersTest.renderObject();
        GL11.glDisable(34336);
        GL11.glDisable(ARBFragmentProgram.GL_FRAGMENT_PROGRAM_ARB);
    }
}
