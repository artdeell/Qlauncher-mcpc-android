package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVBindlessTexture {
    private NVBindlessTexture() {
    }

    public static long glGetImageHandleNV(int i, int i2, boolean z, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        boolean z2 = z;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glGetImageHandleNV;
        BufferChecks.checkFunctionAddress(j);
        return nglGetImageHandleNV(i5, i6, z2, i7, i8, j);
    }

    public static long glGetTextureHandleNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glGetTextureHandleNV;
        BufferChecks.checkFunctionAddress(j);
        return nglGetTextureHandleNV(i2, j);
    }

    public static long glGetTextureSamplerHandleNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glGetTextureSamplerHandleNV;
        BufferChecks.checkFunctionAddress(j);
        return nglGetTextureSamplerHandleNV(i3, i4, j);
    }

    public static boolean glIsImageHandleResidentNV(long j) {
        long j2 = j;
        long j3 = GLContext.getCapabilities().glIsImageHandleResidentNV;
        BufferChecks.checkFunctionAddress(j3);
        return nglIsImageHandleResidentNV(j2, j3);
    }

    public static boolean glIsTextureHandleResidentNV(long j) {
        long j2 = j;
        long j3 = GLContext.getCapabilities().glIsTextureHandleResidentNV;
        BufferChecks.checkFunctionAddress(j3);
        return nglIsTextureHandleResidentNV(j2, j3);
    }

    public static void glMakeImageHandleNonResidentNV(long j) {
        long j2 = j;
        long j3 = GLContext.getCapabilities().glMakeImageHandleNonResidentNV;
        BufferChecks.checkFunctionAddress(j3);
        nglMakeImageHandleNonResidentNV(j2, j3);
    }

    public static void glMakeImageHandleResidentNV(long j, int i) {
        long j2 = j;
        int i2 = i;
        long j3 = GLContext.getCapabilities().glMakeImageHandleResidentNV;
        BufferChecks.checkFunctionAddress(j3);
        nglMakeImageHandleResidentNV(j2, i2, j3);
    }

    public static void glMakeTextureHandleNonResidentNV(long j) {
        long j2 = j;
        long j3 = GLContext.getCapabilities().glMakeTextureHandleNonResidentNV;
        BufferChecks.checkFunctionAddress(j3);
        nglMakeTextureHandleNonResidentNV(j2, j3);
    }

    public static void glMakeTextureHandleResidentNV(long j) {
        long j2 = j;
        long j3 = GLContext.getCapabilities().glMakeTextureHandleResidentNV;
        BufferChecks.checkFunctionAddress(j3);
        nglMakeTextureHandleResidentNV(j2, j3);
    }

    public static void glProgramUniformHandleuNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glProgramUniformHandleui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglProgramUniformHandleui64vNV(i3, i4, longBuffer2.remaining(), MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glProgramUniformHandleui64NV(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glProgramUniformHandleui64NV;
        BufferChecks.checkFunctionAddress(j3);
        nglProgramUniformHandleui64NV(i3, i4, j2, j3);
    }

    public static void glUniformHandleuNV(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glUniformHandleui64vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglUniformHandleui64vNV(i2, longBuffer2.remaining(), MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glUniformHandleui64NV(int i, long j) {
        int i2 = i;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glUniformHandleui64NV;
        BufferChecks.checkFunctionAddress(j3);
        nglUniformHandleui64NV(i2, j2, j3);
    }

    static native long nglGetImageHandleNV(int i, int i2, boolean z, int i3, int i4, long j);

    static native long nglGetTextureHandleNV(int i, long j);

    static native long nglGetTextureSamplerHandleNV(int i, int i2, long j);

    static native boolean nglIsImageHandleResidentNV(long j, long j2);

    static native boolean nglIsTextureHandleResidentNV(long j, long j2);

    static native void nglMakeImageHandleNonResidentNV(long j, long j2);

    static native void nglMakeImageHandleResidentNV(long j, int i, long j2);

    static native void nglMakeTextureHandleNonResidentNV(long j, long j2);

    static native void nglMakeTextureHandleResidentNV(long j, long j2);

    static native void nglProgramUniformHandleui64NV(int i, int i2, long j, long j2);

    static native void nglProgramUniformHandleui64vNV(int i, int i2, int i3, long j, long j2);

    static native void nglUniformHandleui64NV(int i, long j, long j2);

    static native void nglUniformHandleui64vNV(int i, int i2, long j, long j2);
}
