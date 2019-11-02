package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVFence {
    public static final int GL_ALL_COMPLETED_NV = 34034;
    public static final int GL_FENCE_CONDITION_NV = 34036;
    public static final int GL_FENCE_STATUS_NV = 34035;

    private NVFence() {
    }

    public static void glDeleteFencesNV(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteFencesNV;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteFencesNV(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteFencesNV(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteFencesNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteFencesNV(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glFinishFenceNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glFinishFenceNV;
        BufferChecks.checkFunctionAddress(j);
        nglFinishFenceNV(i2, j);
    }

    public static int glGenFencesNV() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenFencesNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenFencesNV(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenFencesNV(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenFencesNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenFencesNV(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetFenceivNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetFenceivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetFenceivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static boolean glIsFenceNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsFenceNV;
        BufferChecks.checkFunctionAddress(j);
        return nglIsFenceNV(i2, j);
    }

    public static void glSetFenceNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glSetFenceNV;
        BufferChecks.checkFunctionAddress(j);
        nglSetFenceNV(i3, i4, j);
    }

    public static boolean glTestFenceNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glTestFenceNV;
        BufferChecks.checkFunctionAddress(j);
        return nglTestFenceNV(i2, j);
    }

    static native void nglDeleteFencesNV(int i, long j, long j2);

    static native void nglFinishFenceNV(int i, long j);

    static native void nglGenFencesNV(int i, long j, long j2);

    static native void nglGetFenceivNV(int i, int i2, long j, long j2);

    static native boolean nglIsFenceNV(int i, long j);

    static native void nglSetFenceNV(int i, int i2, long j);

    static native boolean nglTestFenceNV(int i, long j);
}
