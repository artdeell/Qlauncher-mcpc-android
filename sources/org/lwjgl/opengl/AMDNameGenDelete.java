package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class AMDNameGenDelete {
    public static final int GL_DATA_BUFFER_AMD = 37201;
    public static final int GL_PERFORMANCE_MONITOR_AMD = 37202;
    public static final int GL_QUERY_OBJECT_AMD = 37203;
    public static final int GL_SAMPLER_OBJECT_AMD = 37205;
    public static final int GL_VERTEX_ARRAY_OBJECT_AMD = 37204;

    private AMDNameGenDelete() {
    }

    public static void glDeleteNamesAMD(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteNamesAMD;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteNamesAMD(i3, 1, APIUtil.getInt(capabilities, i4), j);
    }

    public static void glDeleteNamesAMD(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteNamesAMD;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteNamesAMD(i2, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGenNamesAMD(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenNamesAMD;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenNamesAMD(i2, 1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenNamesAMD(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenNamesAMD;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenNamesAMD(i2, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static boolean glIsNameAMD(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glIsNameAMD;
        BufferChecks.checkFunctionAddress(j);
        return nglIsNameAMD(i3, i4, j);
    }

    static native void nglDeleteNamesAMD(int i, int i2, long j, long j2);

    static native void nglGenNamesAMD(int i, int i2, long j, long j2);

    static native boolean nglIsNameAMD(int i, int i2, long j);
}
