package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class NVVertexArrayRange {
    public static final int GL_MAX_VERTEX_ARRAY_RANGE_ELEMENT_NV = 34080;
    public static final int GL_VERTEX_ARRAY_RANGE_LENGTH_NV = 34078;
    public static final int GL_VERTEX_ARRAY_RANGE_NV = 34077;
    public static final int GL_VERTEX_ARRAY_RANGE_POINTER_NV = 34081;
    public static final int GL_VERTEX_ARRAY_RANGE_VALID_NV = 34079;

    private NVVertexArrayRange() {
    }

    public static ByteBuffer glAllocateMemoryNV(int i, float f, float f2, float f3) {
        int i2 = i;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glAllocateMemoryNV;
        BufferChecks.checkFunctionAddress(j);
        ByteBuffer nglAllocateMemoryNV = nglAllocateMemoryNV(i2, f4, f5, f6, (long) i2, j);
        if (!LWJGLUtil.CHECKS || nglAllocateMemoryNV != null) {
            return nglAllocateMemoryNV.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static void glFlushVertexArrayRangeNV() {
        long j = GLContext.getCapabilities().glFlushVertexArrayRangeNV;
        BufferChecks.checkFunctionAddress(j);
        nglFlushVertexArrayRangeNV(j);
    }

    public static void glFreeMemoryNV(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glFreeMemoryNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglFreeMemoryNV(MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexArrayRangeNV(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glVertexArrayRangeNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglVertexArrayRangeNV(byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexArrayRangeNV(DoubleBuffer doubleBuffer) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVertexArrayRangeNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglVertexArrayRangeNV(doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexArrayRangeNV(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glVertexArrayRangeNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglVertexArrayRangeNV(floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glVertexArrayRangeNV(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexArrayRangeNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglVertexArrayRangeNV(intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexArrayRangeNV(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVertexArrayRangeNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglVertexArrayRangeNV(shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), j);
    }

    static native ByteBuffer nglAllocateMemoryNV(int i, float f, float f2, float f3, long j, long j2);

    static native void nglFlushVertexArrayRangeNV(long j);

    static native void nglFreeMemoryNV(long j, long j2);

    static native void nglVertexArrayRangeNV(int i, long j, long j2);
}
