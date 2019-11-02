package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVShaderBufferLoad {
    public static final int GL_BUFFER_GPU_ADDRESS_NV = 36637;
    public static final int GL_GPU_ADDRESS_NV = 36660;
    public static final int GL_MAX_SHADER_BUFFER_ADDRESS_NV = 36661;

    private NVShaderBufferLoad() {
    }

    public static void glGetBufferParameteruNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetBufferParameterui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglGetBufferParameterui64vNV(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static long glGetBufferParameterui64NV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetBufferParameterui64vNV;
        BufferChecks.checkFunctionAddress(j);
        LongBuffer bufferLong = APIUtil.getBufferLong(capabilities);
        nglGetBufferParameterui64vNV(i3, i4, MemoryUtil.getAddress(bufferLong), j);
        return bufferLong.get(0);
    }

    public static void glGetIntegeruNV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetIntegerui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglGetIntegerui64vNV(i2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static long glGetIntegerui64NV(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetIntegerui64vNV;
        BufferChecks.checkFunctionAddress(j);
        LongBuffer bufferLong = APIUtil.getBufferLong(capabilities);
        nglGetIntegerui64vNV(i2, MemoryUtil.getAddress(bufferLong), j);
        return bufferLong.get(0);
    }

    public static void glGetNamedBufferParameteruNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetNamedBufferParameterui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglGetNamedBufferParameterui64vNV(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static long glGetNamedBufferParameterui64NV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetNamedBufferParameterui64vNV;
        BufferChecks.checkFunctionAddress(j);
        LongBuffer bufferLong = APIUtil.getBufferLong(capabilities);
        nglGetNamedBufferParameterui64vNV(i3, i4, MemoryUtil.getAddress(bufferLong), j);
        return bufferLong.get(0);
    }

    public static void glGetUniformuNV(int i, int i2, LongBuffer longBuffer) {
        NVGpuShader5.glGetUniformuNV(i, i2, longBuffer);
    }

    public static boolean glIsBufferResidentNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsBufferResidentNV;
        BufferChecks.checkFunctionAddress(j);
        return nglIsBufferResidentNV(i2, j);
    }

    public static boolean glIsNamedBufferResidentNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsNamedBufferResidentNV;
        BufferChecks.checkFunctionAddress(j);
        return nglIsNamedBufferResidentNV(i2, j);
    }

    public static void glMakeBufferNonResidentNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glMakeBufferNonResidentNV;
        BufferChecks.checkFunctionAddress(j);
        nglMakeBufferNonResidentNV(i2, j);
    }

    public static void glMakeBufferResidentNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glMakeBufferResidentNV;
        BufferChecks.checkFunctionAddress(j);
        nglMakeBufferResidentNV(i3, i4, j);
    }

    public static void glMakeNamedBufferNonResidentNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glMakeNamedBufferNonResidentNV;
        BufferChecks.checkFunctionAddress(j);
        nglMakeNamedBufferNonResidentNV(i2, j);
    }

    public static void glMakeNamedBufferResidentNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glMakeNamedBufferResidentNV;
        BufferChecks.checkFunctionAddress(j);
        nglMakeNamedBufferResidentNV(i3, i4, j);
    }

    public static void glProgramUniformuNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glProgramUniformui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglProgramUniformui64vNV(i3, i4, longBuffer2.remaining(), MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glProgramUniformui64NV(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glProgramUniformui64NV;
        BufferChecks.checkFunctionAddress(j3);
        nglProgramUniformui64NV(i3, i4, j2, j3);
    }

    public static void glUniformuNV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glUniformui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglUniformui64vNV(i2, longBuffer2.remaining(), MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glUniformui64NV(int i, long j) {
        int i2 = i;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glUniformui64NV;
        BufferChecks.checkFunctionAddress(j3);
        nglUniformui64NV(i2, j2, j3);
    }

    static native void nglGetBufferParameterui64vNV(int i, int i2, long j, long j2);

    static native void nglGetIntegerui64vNV(int i, long j, long j2);

    static native void nglGetNamedBufferParameterui64vNV(int i, int i2, long j, long j2);

    static native boolean nglIsBufferResidentNV(int i, long j);

    static native boolean nglIsNamedBufferResidentNV(int i, long j);

    static native void nglMakeBufferNonResidentNV(int i, long j);

    static native void nglMakeBufferResidentNV(int i, int i2, long j);

    static native void nglMakeNamedBufferNonResidentNV(int i, long j);

    static native void nglMakeNamedBufferResidentNV(int i, int i2, long j);

    static native void nglProgramUniformui64NV(int i, int i2, long j, long j2);

    static native void nglProgramUniformui64vNV(int i, int i2, int i3, long j, long j2);

    static native void nglUniformui64NV(int i, long j, long j2);

    static native void nglUniformui64vNV(int i, int i2, long j, long j2);
}
