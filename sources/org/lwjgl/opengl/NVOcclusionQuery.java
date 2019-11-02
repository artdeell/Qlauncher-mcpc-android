package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVOcclusionQuery {
    public static final int GL_CURRENT_OCCLUSION_QUERY_ID_NV = 34917;
    public static final int GL_OCCLUSION_TEST_HP = 33125;
    public static final int GL_OCCLUSION_TEST_RESULT_HP = 33126;
    public static final int GL_PIXEL_COUNTER_BITS_NV = 34916;
    public static final int GL_PIXEL_COUNT_AVAILABLE_NV = 34919;
    public static final int GL_PIXEL_COUNT_NV = 34918;

    private NVOcclusionQuery() {
    }

    public static void glBeginOcclusionQueryNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glBeginOcclusionQueryNV;
        BufferChecks.checkFunctionAddress(j);
        nglBeginOcclusionQueryNV(i2, j);
    }

    public static void glDeleteOcclusionQueriesNV(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteOcclusionQueriesNV;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteOcclusionQueriesNV(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteOcclusionQueriesNV(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteOcclusionQueriesNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteOcclusionQueriesNV(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glEndOcclusionQueryNV() {
        long j = GLContext.getCapabilities().glEndOcclusionQueryNV;
        BufferChecks.checkFunctionAddress(j);
        nglEndOcclusionQueryNV(j);
    }

    public static int glGenOcclusionQueriesNV() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenOcclusionQueriesNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenOcclusionQueriesNV(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenOcclusionQueriesNV(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenOcclusionQueriesNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenOcclusionQueriesNV(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetOcclusionQueryNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetOcclusionQueryivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetOcclusionQueryivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetOcclusionQueryiNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetOcclusionQueryivNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetOcclusionQueryivNV(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetOcclusionQueryuNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetOcclusionQueryuivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetOcclusionQueryuivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetOcclusionQueryuiNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetOcclusionQueryuivNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetOcclusionQueryuivNV(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static boolean glIsOcclusionQueryNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsOcclusionQueryNV;
        BufferChecks.checkFunctionAddress(j);
        return nglIsOcclusionQueryNV(i2, j);
    }

    static native void nglBeginOcclusionQueryNV(int i, long j);

    static native void nglDeleteOcclusionQueriesNV(int i, long j, long j2);

    static native void nglEndOcclusionQueryNV(long j);

    static native void nglGenOcclusionQueriesNV(int i, long j, long j2);

    static native void nglGetOcclusionQueryivNV(int i, int i2, long j, long j2);

    static native void nglGetOcclusionQueryuivNV(int i, int i2, long j, long j2);

    static native boolean nglIsOcclusionQueryNV(int i, long j);
}
