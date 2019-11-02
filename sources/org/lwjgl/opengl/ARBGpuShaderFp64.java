package org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBGpuShaderFp64 {
    public static final int GL_DOUBLE = 5130;
    public static final int GL_DOUBLE_MAT2 = 36678;
    public static final int GL_DOUBLE_MAT2x3 = 36681;
    public static final int GL_DOUBLE_MAT2x4 = 36682;
    public static final int GL_DOUBLE_MAT3 = 36679;
    public static final int GL_DOUBLE_MAT3x2 = 36683;
    public static final int GL_DOUBLE_MAT3x4 = 36684;
    public static final int GL_DOUBLE_MAT4 = 36680;
    public static final int GL_DOUBLE_MAT4x2 = 36685;
    public static final int GL_DOUBLE_MAT4x3 = 36686;
    public static final int GL_DOUBLE_VEC2 = 36860;
    public static final int GL_DOUBLE_VEC3 = 36861;
    public static final int GL_DOUBLE_VEC4 = 36862;

    private ARBGpuShaderFp64() {
    }

    public static void glGetUniform(int i, int i2, DoubleBuffer doubleBuffer) {
        GL40.glGetUniform(i, i2, doubleBuffer);
    }

    public static void glProgramUniform1EXT(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniform1dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniform1dvEXT(i3, i4, doubleBuffer2.remaining(), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniform1dEXT(int i, int i2, double d) {
        int i3 = i;
        int i4 = i2;
        double d2 = d;
        long j = GLContext.getCapabilities().glProgramUniform1dEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform1dEXT(i3, i4, d2, j);
    }

    public static void glProgramUniform2EXT(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniform2dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniform2dvEXT(i3, i4, doubleBuffer2.remaining() >> 1, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniform2dEXT(int i, int i2, double d, double d2) {
        int i3 = i;
        int i4 = i2;
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glProgramUniform2dEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform2dEXT(i3, i4, d3, d4, j);
    }

    public static void glProgramUniform3EXT(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniform3dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniform3dvEXT(i3, i4, doubleBuffer2.remaining() / 3, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniform3dEXT(int i, int i2, double d, double d2, double d3) {
        int i3 = i;
        int i4 = i2;
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glProgramUniform3dEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform3dEXT(i3, i4, d4, d5, d6, j);
    }

    public static void glProgramUniform4EXT(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniform4dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniform4dvEXT(i3, i4, doubleBuffer2.remaining() >> 2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniform4dEXT(int i, int i2, double d, double d2, double d3, double d4) {
        int i3 = i;
        int i4 = i2;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glProgramUniform4dEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform4dEXT(i3, i4, d5, d6, d7, d8, j);
    }

    public static void glProgramUniformMatrix2EXT(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix2dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix2dvEXT(i3, i4, doubleBuffer2.remaining() >> 2, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix2x3EXT(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix2x3dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix2x3dvEXT(i3, i4, doubleBuffer2.remaining() / 6, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix2x4EXT(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix2x4dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix2x4dvEXT(i3, i4, doubleBuffer2.remaining() >> 3, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix3EXT(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix3dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix3dvEXT(i3, i4, doubleBuffer2.remaining() / 9, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix3x2EXT(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix3x2dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix3x2dvEXT(i3, i4, doubleBuffer2.remaining() / 6, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix3x4EXT(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix3x4dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix3x4dvEXT(i3, i4, doubleBuffer2.remaining() / 12, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix4EXT(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix4dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix4dvEXT(i3, i4, doubleBuffer2.remaining() >> 4, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix4x2EXT(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix4x2dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix4x2dvEXT(i3, i4, doubleBuffer2.remaining() >> 3, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix4x3EXT(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix4x3dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix4x3dvEXT(i3, i4, doubleBuffer2.remaining() / 12, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glUniform1(int i, DoubleBuffer doubleBuffer) {
        GL40.glUniform1(i, doubleBuffer);
    }

    public static void glUniform1d(int i, double d) {
        GL40.glUniform1d(i, d);
    }

    public static void glUniform2(int i, DoubleBuffer doubleBuffer) {
        GL40.glUniform2(i, doubleBuffer);
    }

    public static void glUniform2d(int i, double d, double d2) {
        GL40.glUniform2d(i, d, d2);
    }

    public static void glUniform3(int i, DoubleBuffer doubleBuffer) {
        GL40.glUniform3(i, doubleBuffer);
    }

    public static void glUniform3d(int i, double d, double d2, double d3) {
        GL40.glUniform3d(i, d, d2, d3);
    }

    public static void glUniform4(int i, DoubleBuffer doubleBuffer) {
        GL40.glUniform4(i, doubleBuffer);
    }

    public static void glUniform4d(int i, double d, double d2, double d3, double d4) {
        GL40.glUniform4d(i, d, d2, d3, d4);
    }

    public static void glUniformMatrix2(int i, boolean z, DoubleBuffer doubleBuffer) {
        GL40.glUniformMatrix2(i, z, doubleBuffer);
    }

    public static void glUniformMatrix2x3(int i, boolean z, DoubleBuffer doubleBuffer) {
        GL40.glUniformMatrix2x3(i, z, doubleBuffer);
    }

    public static void glUniformMatrix2x4(int i, boolean z, DoubleBuffer doubleBuffer) {
        GL40.glUniformMatrix2x4(i, z, doubleBuffer);
    }

    public static void glUniformMatrix3(int i, boolean z, DoubleBuffer doubleBuffer) {
        GL40.glUniformMatrix3(i, z, doubleBuffer);
    }

    public static void glUniformMatrix3x2(int i, boolean z, DoubleBuffer doubleBuffer) {
        GL40.glUniformMatrix3x2(i, z, doubleBuffer);
    }

    public static void glUniformMatrix3x4(int i, boolean z, DoubleBuffer doubleBuffer) {
        GL40.glUniformMatrix3x4(i, z, doubleBuffer);
    }

    public static void glUniformMatrix4(int i, boolean z, DoubleBuffer doubleBuffer) {
        GL40.glUniformMatrix4(i, z, doubleBuffer);
    }

    public static void glUniformMatrix4x2(int i, boolean z, DoubleBuffer doubleBuffer) {
        GL40.glUniformMatrix4x2(i, z, doubleBuffer);
    }

    public static void glUniformMatrix4x3(int i, boolean z, DoubleBuffer doubleBuffer) {
        GL40.glUniformMatrix4x3(i, z, doubleBuffer);
    }

    static native void nglProgramUniform1dEXT(int i, int i2, double d, long j);

    static native void nglProgramUniform1dvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform2dEXT(int i, int i2, double d, double d2, long j);

    static native void nglProgramUniform2dvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform3dEXT(int i, int i2, double d, double d2, double d3, long j);

    static native void nglProgramUniform3dvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform4dEXT(int i, int i2, double d, double d2, double d3, double d4, long j);

    static native void nglProgramUniform4dvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniformMatrix2dvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix2x3dvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix2x4dvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix3dvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix3x2dvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix3x4dvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix4dvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix4x2dvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix4x3dvEXT(int i, int i2, int i3, boolean z, long j, long j2);
}
