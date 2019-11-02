package org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVVideoCapture {
    public static final int GL_FAILURE_NV = 36912;
    public static final int GL_FIELD_LOWER_NV = 36899;
    public static final int GL_FIELD_UPPER_NV = 36898;
    public static final int GL_LAST_VIDEO_CAPTURE_STATUS_NV = 36903;
    public static final int GL_NEXT_VIDEO_CAPTURE_BUFFER_STATUS_NV = 36901;
    public static final int GL_NUM_VIDEO_CAPTURE_SLOTS_NV = 8399;
    public static final int GL_NUM_VIDEO_CAPTURE_STREAMS_NV = 36900;
    public static final int GL_PARTIAL_SUCCESS_NV = 36910;
    public static final int GL_SUCCESS_NV = 36911;
    public static final int GL_UNIQUE_ID_NV = 8398;
    public static final int GL_VIDEO_BUFFER_BINDING_NV = 36897;
    public static final int GL_VIDEO_BUFFER_INTERNAL_FORMAT_NV = 36909;
    public static final int GL_VIDEO_BUFFER_NV = 36896;
    public static final int GL_VIDEO_BUFFER_PITCH_NV = 36904;
    public static final int GL_VIDEO_CAPTURE_FIELD_LOWER_HEIGHT_NV = 36923;
    public static final int GL_VIDEO_CAPTURE_FIELD_UPPER_HEIGHT_NV = 36922;
    public static final int GL_VIDEO_CAPTURE_FRAME_HEIGHT_NV = 36921;
    public static final int GL_VIDEO_CAPTURE_FRAME_WIDTH_NV = 36920;
    public static final int GL_VIDEO_CAPTURE_SURFACE_ORIGIN_NV = 36924;
    public static final int GL_VIDEO_CAPTURE_TO_422_SUPPORTED_NV = 36902;
    public static final int GL_VIDEO_COLOR_CONVERSION_MATRIX_NV = 36905;
    public static final int GL_VIDEO_COLOR_CONVERSION_MAX_NV = 36906;
    public static final int GL_VIDEO_COLOR_CONVERSION_MIN_NV = 36907;
    public static final int GL_VIDEO_COLOR_CONVERSION_OFFSET_NV = 36908;
    public static final int GL_YCBAYCR8A_4224_NV = 36914;
    public static final int GL_YCBYCR8_422_NV = 36913;
    public static final int GL_Z4Y12Z4CB12Z4A12Z4Y12Z4CR12Z4A12_4224_NV = 36918;
    public static final int GL_Z4Y12Z4CB12Z4CR12_444_NV = 36919;
    public static final int GL_Z4Y12Z4CB12Z4Y12Z4CR12_422_NV = 36917;
    public static final int GL_Z6Y10Z6CB10Z6A10Z6Y10Z6CR10Z6A10_4224_NV = 36916;
    public static final int GL_Z6Y10Z6CB10Z6Y10Z6CR10_422_NV = 36915;

    private NVVideoCapture() {
    }

    public static void glBeginVideoCaptureNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glBeginVideoCaptureNV;
        BufferChecks.checkFunctionAddress(j);
        nglBeginVideoCaptureNV(i2, j);
    }

    public static void glBindVideoCaptureStreamBufferNV(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glBindVideoCaptureStreamBufferNV;
        BufferChecks.checkFunctionAddress(j3);
        nglBindVideoCaptureStreamBufferNV(i4, i5, i6, j2, j3);
    }

    public static void glBindVideoCaptureStreamTextureNV(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glBindVideoCaptureStreamTextureNV;
        BufferChecks.checkFunctionAddress(j);
        nglBindVideoCaptureStreamTextureNV(i6, i7, i8, i9, i10, j);
    }

    public static void glEndVideoCaptureNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glEndVideoCaptureNV;
        BufferChecks.checkFunctionAddress(j);
        nglEndVideoCaptureNV(i2, j);
    }

    public static void glGetVideoCaptureNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVideoCaptureivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetVideoCaptureivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetVideoCaptureStreamNV(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetVideoCaptureStreamdvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 1);
        nglGetVideoCaptureStreamdvNV(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetVideoCaptureStreamNV(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetVideoCaptureStreamfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 1);
        nglGetVideoCaptureStreamfvNV(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetVideoCaptureStreamNV(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVideoCaptureStreamivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetVideoCaptureStreamivNV(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static double glGetVideoCaptureStreamdNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetVideoCaptureStreamdvNV;
        BufferChecks.checkFunctionAddress(j);
        DoubleBuffer bufferDouble = APIUtil.getBufferDouble(capabilities);
        nglGetVideoCaptureStreamdvNV(i4, i5, i6, MemoryUtil.getAddress(bufferDouble), j);
        return bufferDouble.get(0);
    }

    public static float glGetVideoCaptureStreamfNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetVideoCaptureStreamfvNV;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetVideoCaptureStreamfvNV(i4, i5, i6, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetVideoCaptureStreamiNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetVideoCaptureStreamivNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetVideoCaptureStreamivNV(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static int glGetVideoCaptureiNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetVideoCaptureivNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetVideoCaptureivNV(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static int glVideoCaptureNV(int i, IntBuffer intBuffer, LongBuffer longBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glVideoCaptureNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        BufferChecks.checkBuffer(longBuffer2, 1);
        return nglVideoCaptureNV(i2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glVideoCaptureStreamParameterNV(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVideoCaptureStreamParameterdvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 16);
        nglVideoCaptureStreamParameterdvNV(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVideoCaptureStreamParameterNV(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glVideoCaptureStreamParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglVideoCaptureStreamParameterfvNV(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glVideoCaptureStreamParameterNV(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVideoCaptureStreamParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 16);
        nglVideoCaptureStreamParameterivNV(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    static native void nglBeginVideoCaptureNV(int i, long j);

    static native void nglBindVideoCaptureStreamBufferNV(int i, int i2, int i3, long j, long j2);

    static native void nglBindVideoCaptureStreamTextureNV(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglEndVideoCaptureNV(int i, long j);

    static native void nglGetVideoCaptureStreamdvNV(int i, int i2, int i3, long j, long j2);

    static native void nglGetVideoCaptureStreamfvNV(int i, int i2, int i3, long j, long j2);

    static native void nglGetVideoCaptureStreamivNV(int i, int i2, int i3, long j, long j2);

    static native void nglGetVideoCaptureivNV(int i, int i2, long j, long j2);

    static native int nglVideoCaptureNV(int i, long j, long j2, long j3);

    static native void nglVideoCaptureStreamParameterdvNV(int i, int i2, int i3, long j, long j2);

    static native void nglVideoCaptureStreamParameterfvNV(int i, int i2, int i3, long j, long j2);

    static native void nglVideoCaptureStreamParameterivNV(int i, int i2, int i3, long j, long j2);
}
