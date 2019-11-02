package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class APPLEFence {
    public static final int GL_DRAW_PIXELS_APPLE = 35338;
    public static final int GL_FENCE_APPLE = 35339;

    private APPLEFence() {
    }

    public static void glDeleteFencesAPPLE(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteFencesAPPLE;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteFencesAPPLE(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteFencesAPPLE(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteFencesAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteFencesAPPLE(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glFinishFenceAPPLE(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glFinishFenceAPPLE;
        BufferChecks.checkFunctionAddress(j);
        nglFinishFenceAPPLE(i2, j);
    }

    public static void glFinishObjectAPPLE(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glFinishObjectAPPLE;
        BufferChecks.checkFunctionAddress(j);
        nglFinishObjectAPPLE(i3, i4, j);
    }

    public static int glGenFencesAPPLE() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenFencesAPPLE;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenFencesAPPLE(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenFencesAPPLE(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenFencesAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenFencesAPPLE(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static boolean glIsFenceAPPLE(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsFenceAPPLE;
        BufferChecks.checkFunctionAddress(j);
        return nglIsFenceAPPLE(i2, j);
    }

    public static void glSetFenceAPPLE(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glSetFenceAPPLE;
        BufferChecks.checkFunctionAddress(j);
        nglSetFenceAPPLE(i2, j);
    }

    public static boolean glTestFenceAPPLE(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glTestFenceAPPLE;
        BufferChecks.checkFunctionAddress(j);
        return nglTestFenceAPPLE(i2, j);
    }

    public static boolean glTestObjectAPPLE(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glTestObjectAPPLE;
        BufferChecks.checkFunctionAddress(j);
        return nglTestObjectAPPLE(i3, i4, j);
    }

    static native void nglDeleteFencesAPPLE(int i, long j, long j2);

    static native void nglFinishFenceAPPLE(int i, long j);

    static native void nglFinishObjectAPPLE(int i, int i2, long j);

    static native void nglGenFencesAPPLE(int i, long j, long j2);

    static native boolean nglIsFenceAPPLE(int i, long j);

    static native void nglSetFenceAPPLE(int i, long j);

    static native boolean nglTestFenceAPPLE(int i, long j);

    static native boolean nglTestObjectAPPLE(int i, int i2, long j);
}
