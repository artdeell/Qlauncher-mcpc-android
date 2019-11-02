package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVExplicitMultisample {
    public static final int GL_INT_SAMPLER_RENDERBUFFER_NV = 36439;
    public static final int GL_MAX_SAMPLE_MASK_WORDS_NV = 36441;
    public static final int GL_SAMPLER_RENDERBUFFER_NV = 36438;
    public static final int GL_SAMPLE_MASK_NV = 36433;
    public static final int GL_SAMPLE_MASK_VALUE_NV = 36434;
    public static final int GL_SAMPLE_POSITION_NV = 36432;
    public static final int GL_TEXTURE_BINDING_RENDERBUFFER_NV = 36435;
    public static final int GL_TEXTURE_RENDERBUFFER_DATA_STORE_BINDING_NV = 36436;
    public static final int GL_TEXTURE_RENDERBUFFER_NV = 36437;
    public static final int GL_UNSIGNED_INT_SAMPLER_RENDERBUFFER_NV = 36440;

    private NVExplicitMultisample() {
    }

    public static void glGetBooleanIndexedEXT(int i, int i2, ByteBuffer byteBuffer) {
        EXTDrawBuffers2.glGetBooleanIndexedEXT(i, i2, byteBuffer);
    }

    public static boolean glGetBooleanIndexedEXT(int i, int i2) {
        return EXTDrawBuffers2.glGetBooleanIndexedEXT(i, i2);
    }

    public static int glGetIntegerIndexedEXT(int i, int i2) {
        return EXTDrawBuffers2.glGetIntegerIndexedEXT(i, i2);
    }

    public static void glGetIntegerIndexedEXT(int i, int i2, IntBuffer intBuffer) {
        EXTDrawBuffers2.glGetIntegerIndexedEXT(i, i2, intBuffer);
    }

    public static void glGetMultisampleNV(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetMultisamplefvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 2);
        nglGetMultisamplefvNV(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glSampleMaskIndexedNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glSampleMaskIndexedNV;
        BufferChecks.checkFunctionAddress(j);
        nglSampleMaskIndexedNV(i3, i4, j);
    }

    public static void glTexRenderbufferNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glTexRenderbufferNV;
        BufferChecks.checkFunctionAddress(j);
        nglTexRenderbufferNV(i3, i4, j);
    }

    static native void nglGetMultisamplefvNV(int i, int i2, long j, long j2);

    static native void nglSampleMaskIndexedNV(int i, int i2, long j);

    static native void nglTexRenderbufferNV(int i, int i2, long j);
}
