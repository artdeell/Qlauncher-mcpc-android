package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVGpuShader5 {
    public static final int GL_FLOAT16_NV = 36856;
    public static final int GL_FLOAT16_VEC2_NV = 36857;
    public static final int GL_FLOAT16_VEC3_NV = 36858;
    public static final int GL_FLOAT16_VEC4_NV = 36859;
    public static final int GL_INT16_NV = 36836;
    public static final int GL_INT16_VEC2_NV = 36837;
    public static final int GL_INT16_VEC3_NV = 36838;
    public static final int GL_INT16_VEC4_NV = 36839;
    public static final int GL_INT64_NV = 5134;
    public static final int GL_INT64_VEC2_NV = 36841;
    public static final int GL_INT64_VEC3_NV = 36842;
    public static final int GL_INT64_VEC4_NV = 36843;
    public static final int GL_INT8_NV = 36832;
    public static final int GL_INT8_VEC2_NV = 36833;
    public static final int GL_INT8_VEC3_NV = 36834;
    public static final int GL_INT8_VEC4_NV = 36835;
    public static final int GL_PATCHES = 14;
    public static final int GL_UNSIGNED_INT16_NV = 36848;
    public static final int GL_UNSIGNED_INT16_VEC2_NV = 36849;
    public static final int GL_UNSIGNED_INT16_VEC3_NV = 36850;
    public static final int GL_UNSIGNED_INT16_VEC4_NV = 36851;
    public static final int GL_UNSIGNED_INT64_NV = 5135;
    public static final int GL_UNSIGNED_INT64_VEC2_NV = 36853;
    public static final int GL_UNSIGNED_INT64_VEC3_NV = 36854;
    public static final int GL_UNSIGNED_INT64_VEC4_NV = 36855;
    public static final int GL_UNSIGNED_INT8_NV = 36844;
    public static final int GL_UNSIGNED_INT8_VEC2_NV = 36845;
    public static final int GL_UNSIGNED_INT8_VEC3_NV = 36846;
    public static final int GL_UNSIGNED_INT8_VEC4_NV = 36847;

    private NVGpuShader5() {
    }

    public static void glGetUniformNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetUniformi64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglGetUniformi64vNV(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glGetUniformuNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetUniformui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglGetUniformui64vNV(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glProgramUniform1NV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glProgramUniform1i64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglProgramUniform1i64vNV(i3, i4, longBuffer2.remaining(), MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glProgramUniform1i64NV(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glProgramUniform1i64NV;
        BufferChecks.checkFunctionAddress(j3);
        nglProgramUniform1i64NV(i3, i4, j2, j3);
    }

    public static void glProgramUniform1uNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glProgramUniform1ui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglProgramUniform1ui64vNV(i3, i4, longBuffer2.remaining(), MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glProgramUniform1ui64NV(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glProgramUniform1ui64NV;
        BufferChecks.checkFunctionAddress(j3);
        nglProgramUniform1ui64NV(i3, i4, j2, j3);
    }

    public static void glProgramUniform2NV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glProgramUniform2i64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglProgramUniform2i64vNV(i3, i4, longBuffer2.remaining() >> 1, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glProgramUniform2i64NV(int i, int i2, long j, long j2) {
        int i3 = i;
        int i4 = i2;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glProgramUniform2i64NV;
        BufferChecks.checkFunctionAddress(j5);
        nglProgramUniform2i64NV(i3, i4, j3, j4, j5);
    }

    public static void glProgramUniform2uNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glProgramUniform2ui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglProgramUniform2ui64vNV(i3, i4, longBuffer2.remaining() >> 1, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glProgramUniform2ui64NV(int i, int i2, long j, long j2) {
        int i3 = i;
        int i4 = i2;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glProgramUniform2ui64NV;
        BufferChecks.checkFunctionAddress(j5);
        nglProgramUniform2ui64NV(i3, i4, j3, j4, j5);
    }

    public static void glProgramUniform3NV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glProgramUniform3i64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglProgramUniform3i64vNV(i3, i4, longBuffer2.remaining() / 3, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glProgramUniform3i64NV(int i, int i2, long j, long j2, long j3) {
        int i3 = i;
        int i4 = i2;
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        long j7 = GLContext.getCapabilities().glProgramUniform3i64NV;
        BufferChecks.checkFunctionAddress(j7);
        nglProgramUniform3i64NV(i3, i4, j4, j5, j6, j7);
    }

    public static void glProgramUniform3uNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glProgramUniform3ui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglProgramUniform3ui64vNV(i3, i4, longBuffer2.remaining() / 3, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glProgramUniform3ui64NV(int i, int i2, long j, long j2, long j3) {
        int i3 = i;
        int i4 = i2;
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        long j7 = GLContext.getCapabilities().glProgramUniform3ui64NV;
        BufferChecks.checkFunctionAddress(j7);
        nglProgramUniform3ui64NV(i3, i4, j4, j5, j6, j7);
    }

    public static void glProgramUniform4NV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glProgramUniform4i64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglProgramUniform4i64vNV(i3, i4, longBuffer2.remaining() >> 2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glProgramUniform4i64NV(int i, int i2, long j, long j2, long j3, long j4) {
        int i3 = i;
        int i4 = i2;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        long j9 = GLContext.getCapabilities().glProgramUniform4i64NV;
        BufferChecks.checkFunctionAddress(j9);
        nglProgramUniform4i64NV(i3, i4, j5, j6, j7, j8, j9);
    }

    public static void glProgramUniform4uNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glProgramUniform4ui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglProgramUniform4ui64vNV(i3, i4, longBuffer2.remaining() >> 2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glProgramUniform4ui64NV(int i, int i2, long j, long j2, long j3, long j4) {
        int i3 = i;
        int i4 = i2;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        long j9 = GLContext.getCapabilities().glProgramUniform4ui64NV;
        BufferChecks.checkFunctionAddress(j9);
        nglProgramUniform4ui64NV(i3, i4, j5, j6, j7, j8, j9);
    }

    public static void glUniform1NV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glUniform1i64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglUniform1i64vNV(i2, longBuffer2.remaining(), MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glUniform1i64NV(int i, long j) {
        int i2 = i;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glUniform1i64NV;
        BufferChecks.checkFunctionAddress(j3);
        nglUniform1i64NV(i2, j2, j3);
    }

    public static void glUniform1uNV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glUniform1ui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglUniform1ui64vNV(i2, longBuffer2.remaining(), MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glUniform1ui64NV(int i, long j) {
        int i2 = i;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glUniform1ui64NV;
        BufferChecks.checkFunctionAddress(j3);
        nglUniform1ui64NV(i2, j2, j3);
    }

    public static void glUniform2NV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glUniform2i64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglUniform2i64vNV(i2, longBuffer2.remaining() >> 1, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glUniform2i64NV(int i, long j, long j2) {
        int i2 = i;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glUniform2i64NV;
        BufferChecks.checkFunctionAddress(j5);
        nglUniform2i64NV(i2, j3, j4, j5);
    }

    public static void glUniform2uNV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glUniform2ui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglUniform2ui64vNV(i2, longBuffer2.remaining() >> 1, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glUniform2ui64NV(int i, long j, long j2) {
        int i2 = i;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glUniform2ui64NV;
        BufferChecks.checkFunctionAddress(j5);
        nglUniform2ui64NV(i2, j3, j4, j5);
    }

    public static void glUniform3NV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glUniform3i64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglUniform3i64vNV(i2, longBuffer2.remaining() / 3, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glUniform3i64NV(int i, long j, long j2, long j3) {
        int i2 = i;
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        long j7 = GLContext.getCapabilities().glUniform3i64NV;
        BufferChecks.checkFunctionAddress(j7);
        nglUniform3i64NV(i2, j4, j5, j6, j7);
    }

    public static void glUniform3uNV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glUniform3ui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglUniform3ui64vNV(i2, longBuffer2.remaining() / 3, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glUniform3ui64NV(int i, long j, long j2, long j3) {
        int i2 = i;
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        long j7 = GLContext.getCapabilities().glUniform3ui64NV;
        BufferChecks.checkFunctionAddress(j7);
        nglUniform3ui64NV(i2, j4, j5, j6, j7);
    }

    public static void glUniform4NV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glUniform4i64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglUniform4i64vNV(i2, longBuffer2.remaining() >> 2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glUniform4i64NV(int i, long j, long j2, long j3, long j4) {
        int i2 = i;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        long j9 = GLContext.getCapabilities().glUniform4i64NV;
        BufferChecks.checkFunctionAddress(j9);
        nglUniform4i64NV(i2, j5, j6, j7, j8, j9);
    }

    public static void glUniform4uNV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glUniform4ui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglUniform4ui64vNV(i2, longBuffer2.remaining() >> 2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glUniform4ui64NV(int i, long j, long j2, long j3, long j4) {
        int i2 = i;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        long j9 = GLContext.getCapabilities().glUniform4ui64NV;
        BufferChecks.checkFunctionAddress(j9);
        nglUniform4ui64NV(i2, j5, j6, j7, j8, j9);
    }

    static native void nglGetUniformi64vNV(int i, int i2, long j, long j2);

    static native void nglGetUniformui64vNV(int i, int i2, long j, long j2);

    static native void nglProgramUniform1i64NV(int i, int i2, long j, long j2);

    static native void nglProgramUniform1i64vNV(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform1ui64NV(int i, int i2, long j, long j2);

    static native void nglProgramUniform1ui64vNV(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform2i64NV(int i, int i2, long j, long j2, long j3);

    static native void nglProgramUniform2i64vNV(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform2ui64NV(int i, int i2, long j, long j2, long j3);

    static native void nglProgramUniform2ui64vNV(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform3i64NV(int i, int i2, long j, long j2, long j3, long j4);

    static native void nglProgramUniform3i64vNV(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform3ui64NV(int i, int i2, long j, long j2, long j3, long j4);

    static native void nglProgramUniform3ui64vNV(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform4i64NV(int i, int i2, long j, long j2, long j3, long j4, long j5);

    static native void nglProgramUniform4i64vNV(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform4ui64NV(int i, int i2, long j, long j2, long j3, long j4, long j5);

    static native void nglProgramUniform4ui64vNV(int i, int i2, int i3, long j, long j2);

    static native void nglUniform1i64NV(int i, long j, long j2);

    static native void nglUniform1i64vNV(int i, int i2, long j, long j2);

    static native void nglUniform1ui64NV(int i, long j, long j2);

    static native void nglUniform1ui64vNV(int i, int i2, long j, long j2);

    static native void nglUniform2i64NV(int i, long j, long j2, long j3);

    static native void nglUniform2i64vNV(int i, int i2, long j, long j2);

    static native void nglUniform2ui64NV(int i, long j, long j2, long j3);

    static native void nglUniform2ui64vNV(int i, int i2, long j, long j2);

    static native void nglUniform3i64NV(int i, long j, long j2, long j3, long j4);

    static native void nglUniform3i64vNV(int i, int i2, long j, long j2);

    static native void nglUniform3ui64NV(int i, long j, long j2, long j3, long j4);

    static native void nglUniform3ui64vNV(int i, int i2, long j, long j2);

    static native void nglUniform4i64NV(int i, long j, long j2, long j3, long j4, long j5);

    static native void nglUniform4i64vNV(int i, int i2, long j, long j2);

    static native void nglUniform4ui64NV(int i, long j, long j2, long j3, long j4, long j5);

    static native void nglUniform4ui64vNV(int i, int i2, long j, long j2);
}
