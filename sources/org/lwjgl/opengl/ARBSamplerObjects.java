package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class ARBSamplerObjects {
    public static final int GL_SAMPLER_BINDING = 35097;

    private ARBSamplerObjects() {
    }

    public static void glBindSampler(int i, int i2) {
        GL33.glBindSampler(i, i2);
    }

    public static void glDeleteSamplers(int i) {
        GL33.glDeleteSamplers(i);
    }

    public static void glDeleteSamplers(IntBuffer intBuffer) {
        GL33.glDeleteSamplers(intBuffer);
    }

    public static int glGenSamplers() {
        return GL33.glGenSamplers();
    }

    public static void glGenSamplers(IntBuffer intBuffer) {
        GL33.glGenSamplers(intBuffer);
    }

    public static void glGetSamplerParameter(int i, int i2, FloatBuffer floatBuffer) {
        GL33.glGetSamplerParameter(i, i2, floatBuffer);
    }

    public static void glGetSamplerParameter(int i, int i2, IntBuffer intBuffer) {
        GL33.glGetSamplerParameter(i, i2, intBuffer);
    }

    public static void glGetSamplerParameterI(int i, int i2, IntBuffer intBuffer) {
        GL33.glGetSamplerParameterI(i, i2, intBuffer);
    }

    public static int glGetSamplerParameterIi(int i, int i2) {
        return GL33.glGetSamplerParameterIi(i, i2);
    }

    public static void glGetSamplerParameterIu(int i, int i2, IntBuffer intBuffer) {
        GL33.glGetSamplerParameterIu(i, i2, intBuffer);
    }

    public static int glGetSamplerParameterIui(int i, int i2) {
        return GL33.glGetSamplerParameterIui(i, i2);
    }

    public static float glGetSamplerParameterf(int i, int i2) {
        return GL33.glGetSamplerParameterf(i, i2);
    }

    public static int glGetSamplerParameteri(int i, int i2) {
        return GL33.glGetSamplerParameteri(i, i2);
    }

    public static boolean glIsSampler(int i) {
        return GL33.glIsSampler(i);
    }

    public static void glSamplerParameter(int i, int i2, FloatBuffer floatBuffer) {
        GL33.glSamplerParameter(i, i2, floatBuffer);
    }

    public static void glSamplerParameter(int i, int i2, IntBuffer intBuffer) {
        GL33.glSamplerParameter(i, i2, intBuffer);
    }

    public static void glSamplerParameterI(int i, int i2, IntBuffer intBuffer) {
        GL33.glSamplerParameterI(i, i2, intBuffer);
    }

    public static void glSamplerParameterIu(int i, int i2, IntBuffer intBuffer) {
        GL33.glSamplerParameterIu(i, i2, intBuffer);
    }

    public static void glSamplerParameterf(int i, int i2, float f) {
        GL33.glSamplerParameterf(i, i2, f);
    }

    public static void glSamplerParameteri(int i, int i2, int i3) {
        GL33.glSamplerParameteri(i, i2, i3);
    }
}
