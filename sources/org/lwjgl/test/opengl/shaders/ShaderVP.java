package org.lwjgl.test.opengl.shaders;

import org.lwjgl.opengl.ARBProgram;
import org.lwjgl.opengl.ARBVertexProgram;
import org.lwjgl.opengl.GL11;

final class ShaderVP extends Shader {

    /* renamed from: ID */
    final int f219ID = ARBVertexProgram.glGenProgramsARB();
    final String file;
    final String source;

    ShaderVP(String str) {
        String str2 = str;
        this.file = str2;
        this.source = getShaderText(str2);
        ARBVertexProgram.glBindProgramARB(34336, this.f219ID);
        ARBVertexProgram.glProgramStringARB(34336, (int) ARBProgram.GL_PROGRAM_FORMAT_ASCII_ARB, (CharSequence) this.source);
        checkProgramError(this.file, this.source);
    }

    /* access modifiers changed from: 0000 */
    public void cleanup() {
        ARBVertexProgram.glDeleteProgramsARB(this.f219ID);
    }

    /* access modifiers changed from: 0000 */
    public void render() {
        GL11.glEnable(34336);
        ARBVertexProgram.glBindProgramARB(34336, this.f219ID);
        ARBVertexProgram.glProgramLocalParameter4fARB(34336, 0, ShadersTest.getSin(), 8.0f * ((float) ShadersTest.getSpecularity()), 0.0f, 0.0f);
        ShadersTest.renderObject();
        GL11.glDisable(34336);
    }
}
