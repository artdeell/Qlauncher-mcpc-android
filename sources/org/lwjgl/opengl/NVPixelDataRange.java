package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVPixelDataRange {
    public static final int GL_READ_PIXEL_DATA_RANGE_LENGTH_NV = 34939;
    public static final int GL_READ_PIXEL_DATA_RANGE_NV = 34937;
    public static final int GL_READ_PIXEL_DATA_RANGE_POINTER_NV = 34941;
    public static final int GL_WRITE_PIXEL_DATA_RANGE_LENGTH_NV = 34938;
    public static final int GL_WRITE_PIXEL_DATA_RANGE_NV = 34936;
    public static final int GL_WRITE_PIXEL_DATA_RANGE_POINTER_NV = 34940;

    private NVPixelDataRange() {
    }

    public static void glFlushPixelDataRangeNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glFlushPixelDataRangeNV;
        BufferChecks.checkFunctionAddress(j);
        nglFlushPixelDataRangeNV(i2, j);
    }

    public static void glPixelDataRangeNV(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glPixelDataRangeNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglPixelDataRangeNV(i2, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glPixelDataRangeNV(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glPixelDataRangeNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglPixelDataRangeNV(i2, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glPixelDataRangeNV(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glPixelDataRangeNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglPixelDataRangeNV(i2, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glPixelDataRangeNV(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glPixelDataRangeNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglPixelDataRangeNV(i2, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glPixelDataRangeNV(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glPixelDataRangeNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglPixelDataRangeNV(i2, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), j);
    }

    static native void nglFlushPixelDataRangeNV(int i, long j);

    static native void nglPixelDataRangeNV(int i, int i2, long j, long j2);
}
