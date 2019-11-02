package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVVertexAttribInteger64bit {
    public static final int GL_INT64_NV = 5134;
    public static final int GL_UNSIGNED_INT64_NV = 5135;

    private NVVertexAttribInteger64bit() {
    }

    public static void glGetVertexAttribLNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribLi64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 4);
        nglGetVertexAttribLi64vNV(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glGetVertexAttribLuNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribLui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 4);
        nglGetVertexAttribLui64vNV(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glVertexAttribL1NV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL1i64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglVertexAttribL1i64vNV(i2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glVertexAttribL1i64NV(int i, long j) {
        int i2 = i;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexAttribL1i64NV;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexAttribL1i64NV(i2, j2, j3);
    }

    public static void glVertexAttribL1uNV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL1ui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglVertexAttribL1ui64vNV(i2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glVertexAttribL1ui64NV(int i, long j) {
        int i2 = i;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexAttribL1ui64NV;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexAttribL1ui64NV(i2, j2, j3);
    }

    public static void glVertexAttribL2NV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL2i64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 2);
        nglVertexAttribL2i64vNV(i2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glVertexAttribL2i64NV(int i, long j, long j2) {
        int i2 = i;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glVertexAttribL2i64NV;
        BufferChecks.checkFunctionAddress(j5);
        nglVertexAttribL2i64NV(i2, j3, j4, j5);
    }

    public static void glVertexAttribL2uNV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL2ui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 2);
        nglVertexAttribL2ui64vNV(i2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glVertexAttribL2ui64NV(int i, long j, long j2) {
        int i2 = i;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glVertexAttribL2ui64NV;
        BufferChecks.checkFunctionAddress(j5);
        nglVertexAttribL2ui64NV(i2, j3, j4, j5);
    }

    public static void glVertexAttribL3NV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL3i64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 3);
        nglVertexAttribL3i64vNV(i2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glVertexAttribL3i64NV(int i, long j, long j2, long j3) {
        int i2 = i;
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        long j7 = GLContext.getCapabilities().glVertexAttribL3i64NV;
        BufferChecks.checkFunctionAddress(j7);
        nglVertexAttribL3i64NV(i2, j4, j5, j6, j7);
    }

    public static void glVertexAttribL3uNV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL3ui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 3);
        nglVertexAttribL3ui64vNV(i2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glVertexAttribL3ui64NV(int i, long j, long j2, long j3) {
        int i2 = i;
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        long j7 = GLContext.getCapabilities().glVertexAttribL3ui64NV;
        BufferChecks.checkFunctionAddress(j7);
        nglVertexAttribL3ui64NV(i2, j4, j5, j6, j7);
    }

    public static void glVertexAttribL4NV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL4i64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 4);
        nglVertexAttribL4i64vNV(i2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glVertexAttribL4i64NV(int i, long j, long j2, long j3, long j4) {
        int i2 = i;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        long j9 = GLContext.getCapabilities().glVertexAttribL4i64NV;
        BufferChecks.checkFunctionAddress(j9);
        nglVertexAttribL4i64NV(i2, j5, j6, j7, j8, j9);
    }

    public static void glVertexAttribL4uNV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL4ui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 4);
        nglVertexAttribL4ui64vNV(i2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glVertexAttribL4ui64NV(int i, long j, long j2, long j3, long j4) {
        int i2 = i;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        long j9 = GLContext.getCapabilities().glVertexAttribL4ui64NV;
        BufferChecks.checkFunctionAddress(j9);
        nglVertexAttribL4ui64NV(i2, j5, j6, j7, j8, j9);
    }

    public static void glVertexAttribLFormatNV(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glVertexAttribLFormatNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribLFormatNV(i5, i6, i7, i8, j);
    }

    static native void nglGetVertexAttribLi64vNV(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribLui64vNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribL1i64NV(int i, long j, long j2);

    static native void nglVertexAttribL1i64vNV(int i, long j, long j2);

    static native void nglVertexAttribL1ui64NV(int i, long j, long j2);

    static native void nglVertexAttribL1ui64vNV(int i, long j, long j2);

    static native void nglVertexAttribL2i64NV(int i, long j, long j2, long j3);

    static native void nglVertexAttribL2i64vNV(int i, long j, long j2);

    static native void nglVertexAttribL2ui64NV(int i, long j, long j2, long j3);

    static native void nglVertexAttribL2ui64vNV(int i, long j, long j2);

    static native void nglVertexAttribL3i64NV(int i, long j, long j2, long j3, long j4);

    static native void nglVertexAttribL3i64vNV(int i, long j, long j2);

    static native void nglVertexAttribL3ui64NV(int i, long j, long j2, long j3, long j4);

    static native void nglVertexAttribL3ui64vNV(int i, long j, long j2);

    static native void nglVertexAttribL4i64NV(int i, long j, long j2, long j3, long j4, long j5);

    static native void nglVertexAttribL4i64vNV(int i, long j, long j2);

    static native void nglVertexAttribL4ui64NV(int i, long j, long j2, long j3, long j4, long j5);

    static native void nglVertexAttribL4ui64vNV(int i, long j, long j2);

    static native void nglVertexAttribLFormatNV(int i, int i2, int i3, int i4, long j);
}
