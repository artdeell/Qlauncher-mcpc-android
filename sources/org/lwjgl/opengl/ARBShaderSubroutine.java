package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class ARBShaderSubroutine {
    public static final int GL_ACTIVE_SUBROUTINES = 36325;
    public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 36424;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 36326;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 36423;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 36425;
    public static final int GL_COMPATIBLE_SUBROUTINES = 36427;
    public static final int GL_MAX_SUBROUTINES = 36327;
    public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 36328;
    public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 36426;
    public static final int GL_UNIFORM_NAME_LENGTH = 35385;
    public static final int GL_UNIFORM_SIZE = 35384;

    private ARBShaderSubroutine() {
    }

    public static String glGetActiveSubroutineName(int i, int i2, int i3, int i4) {
        return GL40.glGetActiveSubroutineName(i, i2, i3, i4);
    }

    public static void glGetActiveSubroutineName(int i, int i2, int i3, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        GL40.glGetActiveSubroutineName(i, i2, i3, intBuffer, byteBuffer);
    }

    public static void glGetActiveSubroutineUniform(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        GL40.glGetActiveSubroutineUniform(i, i2, i3, i4, intBuffer);
    }

    public static String glGetActiveSubroutineUniformName(int i, int i2, int i3, int i4) {
        return GL40.glGetActiveSubroutineUniformName(i, i2, i3, i4);
    }

    public static void glGetActiveSubroutineUniformName(int i, int i2, int i3, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        GL40.glGetActiveSubroutineUniformName(i, i2, i3, intBuffer, byteBuffer);
    }

    public static int glGetActiveSubroutineUniformi(int i, int i2, int i3, int i4) {
        return GL40.glGetActiveSubroutineUniformi(i, i2, i3, i4);
    }

    public static void glGetProgramStage(int i, int i2, int i3, IntBuffer intBuffer) {
        GL40.glGetProgramStage(i, i2, i3, intBuffer);
    }

    public static int glGetProgramStagei(int i, int i2, int i3) {
        return GL40.glGetProgramStagei(i, i2, i3);
    }

    public static int glGetSubroutineIndex(int i, int i2, CharSequence charSequence) {
        return GL40.glGetSubroutineIndex(i, i2, charSequence);
    }

    public static int glGetSubroutineIndex(int i, int i2, ByteBuffer byteBuffer) {
        return GL40.glGetSubroutineIndex(i, i2, byteBuffer);
    }

    public static int glGetSubroutineUniformLocation(int i, int i2, CharSequence charSequence) {
        return GL40.glGetSubroutineUniformLocation(i, i2, charSequence);
    }

    public static int glGetSubroutineUniformLocation(int i, int i2, ByteBuffer byteBuffer) {
        return GL40.glGetSubroutineUniformLocation(i, i2, byteBuffer);
    }

    public static void glGetUniformSubroutineu(int i, int i2, IntBuffer intBuffer) {
        GL40.glGetUniformSubroutineu(i, i2, intBuffer);
    }

    public static int glGetUniformSubroutineui(int i, int i2) {
        return GL40.glGetUniformSubroutineui(i, i2);
    }

    public static void glUniformSubroutinesu(int i, IntBuffer intBuffer) {
        GL40.glUniformSubroutinesu(i, intBuffer);
    }
}
