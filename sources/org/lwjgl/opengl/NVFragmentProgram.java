package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVFragmentProgram extends NVProgram {
    public static final int GL_FRAGMENT_PROGRAM_BINDING_NV = 34931;
    public static final int GL_FRAGMENT_PROGRAM_NV = 34928;
    public static final int GL_MAX_FRAGMENT_PROGRAM_LOCAL_PARAMETERS_NV = 34920;
    public static final int GL_MAX_TEXTURE_COORDS_NV = 34929;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS_NV = 34930;

    private NVFragmentProgram() {
    }

    public static void glGetProgramNamedParameterNV(int i, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetProgramNamedParameterdvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglGetProgramNamedParameterdvNV(i2, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetProgramNamedParameterNV(int i, ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetProgramNamedParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetProgramNamedParameterfvNV(i2, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramNamedParameter4dNV(int i, ByteBuffer byteBuffer, double d, double d2, double d3, double d4) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glProgramNamedParameter4dNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglProgramNamedParameter4dNV(i2, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), d5, d6, d7, d8, j);
    }

    public static void glProgramNamedParameter4fNV(int i, ByteBuffer byteBuffer, float f, float f2, float f3, float f4) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glProgramNamedParameter4fNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglProgramNamedParameter4fNV(i2, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), f5, f6, f7, f8, j);
    }

    static native void nglGetProgramNamedParameterdvNV(int i, int i2, long j, long j2, long j3);

    static native void nglGetProgramNamedParameterfvNV(int i, int i2, long j, long j2, long j3);

    static native void nglProgramNamedParameter4dNV(int i, int i2, long j, double d, double d2, double d3, double d4, long j2);

    static native void nglProgramNamedParameter4fNV(int i, int i2, long j, float f, float f2, float f3, float f4, long j2);
}
