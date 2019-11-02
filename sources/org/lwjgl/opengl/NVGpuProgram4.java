package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVGpuProgram4 {
    public static final int GL_MAX_PROGRAM_ATTRIB_COMPONENTS_NV = 35080;
    public static final int GL_MAX_PROGRAM_GENERIC_ATTRIBS_NV = 36261;
    public static final int GL_MAX_PROGRAM_GENERIC_RESULTS_NV = 36262;
    public static final int GL_MAX_PROGRAM_RESULT_COMPONENTS_NV = 35081;
    public static final int GL_PROGRAM_ATTRIB_COMPONENTS_NV = 35078;
    public static final int GL_PROGRAM_RESULT_COMPONENTS_NV = 35079;

    private NVGpuProgram4() {
    }

    public static void glGetProgramEnvParameterINV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetProgramEnvParameterIivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetProgramEnvParameterIivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetProgramEnvParameterIuNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetProgramEnvParameterIuivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetProgramEnvParameterIuivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetProgramLocalParameterINV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetProgramLocalParameterIivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetProgramLocalParameterIivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetProgramLocalParameterIuNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetProgramLocalParameterIuivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetProgramLocalParameterIuivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramEnvParameterI4NV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramEnvParameterI4ivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglProgramEnvParameterI4ivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramEnvParameterI4iNV(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glProgramEnvParameterI4iNV;
        BufferChecks.checkFunctionAddress(j);
        nglProgramEnvParameterI4iNV(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glProgramEnvParameterI4uNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramEnvParameterI4uivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglProgramEnvParameterI4uivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramEnvParameterI4uiNV(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glProgramEnvParameterI4uiNV;
        BufferChecks.checkFunctionAddress(j);
        nglProgramEnvParameterI4uiNV(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glProgramEnvParametersI4NV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramEnvParametersI4ivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramEnvParametersI4ivNV(i3, i4, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramEnvParametersI4uNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramEnvParametersI4uivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramEnvParametersI4uivNV(i3, i4, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramLocalParameterI4NV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramLocalParameterI4ivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglProgramLocalParameterI4ivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramLocalParameterI4iNV(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glProgramLocalParameterI4iNV;
        BufferChecks.checkFunctionAddress(j);
        nglProgramLocalParameterI4iNV(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glProgramLocalParameterI4uNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramLocalParameterI4uivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglProgramLocalParameterI4uivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramLocalParameterI4uiNV(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glProgramLocalParameterI4uiNV;
        BufferChecks.checkFunctionAddress(j);
        nglProgramLocalParameterI4uiNV(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glProgramLocalParametersI4NV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramLocalParametersI4ivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramLocalParametersI4ivNV(i3, i4, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramLocalParametersI4uNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramLocalParametersI4uivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramLocalParametersI4uivNV(i3, i4, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    static native void nglGetProgramEnvParameterIivNV(int i, int i2, long j, long j2);

    static native void nglGetProgramEnvParameterIuivNV(int i, int i2, long j, long j2);

    static native void nglGetProgramLocalParameterIivNV(int i, int i2, long j, long j2);

    static native void nglGetProgramLocalParameterIuivNV(int i, int i2, long j, long j2);

    static native void nglProgramEnvParameterI4iNV(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglProgramEnvParameterI4ivNV(int i, int i2, long j, long j2);

    static native void nglProgramEnvParameterI4uiNV(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglProgramEnvParameterI4uivNV(int i, int i2, long j, long j2);

    static native void nglProgramEnvParametersI4ivNV(int i, int i2, int i3, long j, long j2);

    static native void nglProgramEnvParametersI4uivNV(int i, int i2, int i3, long j, long j2);

    static native void nglProgramLocalParameterI4iNV(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglProgramLocalParameterI4ivNV(int i, int i2, long j, long j2);

    static native void nglProgramLocalParameterI4uiNV(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglProgramLocalParameterI4uivNV(int i, int i2, long j, long j2);

    static native void nglProgramLocalParametersI4ivNV(int i, int i2, int i3, long j, long j2);

    static native void nglProgramLocalParametersI4uivNV(int i, int i2, int i3, long j, long j2);
}
