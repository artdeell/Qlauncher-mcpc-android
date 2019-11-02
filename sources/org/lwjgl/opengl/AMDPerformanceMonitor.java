package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class AMDPerformanceMonitor {
    public static final int GL_COUNTER_RANGE_AMD = 35777;
    public static final int GL_COUNTER_TYPE_AMD = 35776;
    public static final int GL_PERCENTAGE_AMD = 35779;
    public static final int GL_PERFMON_RESULT_AMD = 35782;
    public static final int GL_PERFMON_RESULT_AVAILABLE_AMD = 35780;
    public static final int GL_PERFMON_RESULT_SIZE_AMD = 35781;
    public static final int GL_UNSIGNED_INT64_AMD = 35778;

    private AMDPerformanceMonitor() {
    }

    public static void glBeginPerfMonitorAMD(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glBeginPerfMonitorAMD;
        BufferChecks.checkFunctionAddress(j);
        nglBeginPerfMonitorAMD(i2, j);
    }

    public static void glDeletePerfMonitorsAMD(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeletePerfMonitorsAMD;
        BufferChecks.checkFunctionAddress(j);
        nglDeletePerfMonitorsAMD(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeletePerfMonitorsAMD(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeletePerfMonitorsAMD;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeletePerfMonitorsAMD(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glEndPerfMonitorAMD(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glEndPerfMonitorAMD;
        BufferChecks.checkFunctionAddress(j);
        nglEndPerfMonitorAMD(i2, j);
    }

    public static int glGenPerfMonitorsAMD() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenPerfMonitorsAMD;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenPerfMonitorsAMD(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenPerfMonitorsAMD(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenPerfMonitorsAMD;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenPerfMonitorsAMD(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetPerfMonitorCounterDataAMD(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetPerfMonitorCounterDataAMD;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetPerfMonitorCounterDataAMD(i3, i4, 4, MemoryUtil.getAddress(bufferInt), 0, j);
        return bufferInt.get(0);
    }

    public static void glGetPerfMonitorCounterDataAMD(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = GLContext.getCapabilities().glGetPerfMonitorCounterDataAMD;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer3);
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        nglGetPerfMonitorCounterDataAMD(i3, i4, intBuffer3.remaining(), MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddressSafe(intBuffer4), j);
    }

    public static void glGetPerfMonitorCounterInfoAMD(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetPerfMonitorCounterInfoAMD;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 16);
        nglGetPerfMonitorCounterInfoAMD(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static String glGetPerfMonitorCounterStringAMD(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetPerfMonitorCounterStringAMD;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetPerfMonitorCounterStringAMD(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetPerfMonitorCounterStringAMD(int i, int i2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetPerfMonitorCounterStringAMD;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        nglGetPerfMonitorCounterStringAMD(i3, i4, byteBuffer2 == null ? 0 : byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glGetPerfMonitorCountersAMD(int i, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3) {
        int i2 = i;
        IntBuffer intBuffer4 = intBuffer;
        IntBuffer intBuffer5 = intBuffer2;
        IntBuffer intBuffer6 = intBuffer3;
        long j = GLContext.getCapabilities().glGetPerfMonitorCountersAMD;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer4, 1);
        BufferChecks.checkBuffer(intBuffer5, 1);
        if (intBuffer6 != null) {
            BufferChecks.checkDirect(intBuffer6);
        }
        nglGetPerfMonitorCountersAMD(i2, MemoryUtil.getAddress(intBuffer4), MemoryUtil.getAddress(intBuffer5), intBuffer6 == null ? 0 : intBuffer6.remaining(), MemoryUtil.getAddressSafe(intBuffer6), j);
    }

    public static String glGetPerfMonitorGroupStringAMD(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetPerfMonitorGroupStringAMD;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i4);
        nglGetPerfMonitorGroupStringAMD(i3, i4, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetPerfMonitorGroupStringAMD(int i, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetPerfMonitorGroupStringAMD;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        nglGetPerfMonitorGroupStringAMD(i2, byteBuffer2 == null ? 0 : byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glGetPerfMonitorGroupsAMD(IntBuffer intBuffer, IntBuffer intBuffer2) {
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = GLContext.getCapabilities().glGetPerfMonitorGroupsAMD;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer3 != null) {
            BufferChecks.checkBuffer(intBuffer3, 1);
        }
        BufferChecks.checkDirect(intBuffer4);
        nglGetPerfMonitorGroupsAMD(MemoryUtil.getAddressSafe(intBuffer3), intBuffer4.remaining(), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glSelectPerfMonitorCountersAMD(int i, boolean z, int i2, int i3) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSelectPerfMonitorCountersAMD;
        BufferChecks.checkFunctionAddress(j);
        nglSelectPerfMonitorCountersAMD(i4, z2, i5, 1, APIUtil.getInt(capabilities, i6), j);
    }

    public static void glSelectPerfMonitorCountersAMD(int i, boolean z, int i2, IntBuffer intBuffer) {
        int i3 = i;
        boolean z2 = z;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glSelectPerfMonitorCountersAMD;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglSelectPerfMonitorCountersAMD(i3, z2, i4, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    static native void nglBeginPerfMonitorAMD(int i, long j);

    static native void nglDeletePerfMonitorsAMD(int i, long j, long j2);

    static native void nglEndPerfMonitorAMD(int i, long j);

    static native void nglGenPerfMonitorsAMD(int i, long j, long j2);

    static native void nglGetPerfMonitorCounterDataAMD(int i, int i2, int i3, long j, long j2, long j3);

    static native void nglGetPerfMonitorCounterInfoAMD(int i, int i2, int i3, long j, long j2);

    static native void nglGetPerfMonitorCounterStringAMD(int i, int i2, int i3, long j, long j2, long j3);

    static native void nglGetPerfMonitorCountersAMD(int i, long j, long j2, int i2, long j3, long j4);

    static native void nglGetPerfMonitorGroupStringAMD(int i, int i2, long j, long j2, long j3);

    static native void nglGetPerfMonitorGroupsAMD(long j, int i, long j2, long j3);

    static native void nglSelectPerfMonitorCountersAMD(int i, boolean z, int i2, int i3, long j, long j2);
}
