package org.lwjgl.opengl;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVPresentVideo {
    public static final int FIELDS_NV = 36391;
    public static final int GL_CURRENT_TIME_NV = 36392;
    public static final int GL_FRAME_NV = 36390;
    public static final int GL_NUM_FILL_STREAMS_NV = 36393;
    public static final int GL_NUM_VIDEO_SLOTS_NV = 8432;
    public static final int GL_PRESENT_DURATION_NV = 36395;
    public static final int GL_PRESENT_TIME_NV = 36394;

    private NVPresentVideo() {
    }

    public static void glGetVideoNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVideoivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetVideoivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetVideoNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetVideoi64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglGetVideoi64vNV(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static long glGetVideoi64NV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetVideoi64vNV;
        BufferChecks.checkFunctionAddress(j);
        LongBuffer bufferLong = APIUtil.getBufferLong(capabilities);
        nglGetVideoi64vNV(i3, i4, MemoryUtil.getAddress(bufferLong), j);
        return bufferLong.get(0);
    }

    public static int glGetVideoiNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetVideoivNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetVideoivNV(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetVideouNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVideouivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetVideouivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetVideouNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetVideoui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglGetVideoui64vNV(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static long glGetVideoui64NV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetVideoui64vNV;
        BufferChecks.checkFunctionAddress(j);
        LongBuffer bufferLong = APIUtil.getBufferLong(capabilities);
        nglGetVideoui64vNV(i3, i4, MemoryUtil.getAddress(bufferLong), j);
        return bufferLong.get(0);
    }

    public static int glGetVideouiNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetVideouivNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetVideouivNV(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glPresentFrameDualFillNV(int i, long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int i13 = i;
        long j2 = j;
        int i14 = i2;
        int i15 = i3;
        int i16 = i4;
        int i17 = i5;
        int i18 = i6;
        int i19 = i7;
        int i20 = i8;
        int i21 = i9;
        int i22 = i10;
        int i23 = i11;
        int i24 = i12;
        long j3 = GLContext.getCapabilities().glPresentFrameDualFillNV;
        BufferChecks.checkFunctionAddress(j3);
        nglPresentFrameDualFillNV(i13, j2, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, j3);
    }

    public static void glPresentFrameKeyedNV(int i, long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = i;
        long j2 = j;
        int i12 = i2;
        int i13 = i3;
        int i14 = i4;
        int i15 = i5;
        int i16 = i6;
        int i17 = i7;
        int i18 = i8;
        int i19 = i9;
        int i20 = i10;
        long j3 = GLContext.getCapabilities().glPresentFrameKeyedNV;
        BufferChecks.checkFunctionAddress(j3);
        nglPresentFrameKeyedNV(i11, j2, i12, i13, i14, i15, i16, i17, i18, i19, i20, j3);
    }

    static native void nglGetVideoi64vNV(int i, int i2, long j, long j2);

    static native void nglGetVideoivNV(int i, int i2, long j, long j2);

    static native void nglGetVideoui64vNV(int i, int i2, long j, long j2);

    static native void nglGetVideouivNV(int i, int i2, long j, long j2);

    static native void nglPresentFrameDualFillNV(int i, long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, long j2);

    static native void nglPresentFrameKeyedNV(int i, long j, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j2);
}
