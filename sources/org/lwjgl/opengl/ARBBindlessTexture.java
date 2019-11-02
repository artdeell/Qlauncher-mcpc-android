package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBBindlessTexture {
    public static final int GL_UNSIGNED_INT64_ARB = 5135;

    private ARBBindlessTexture() {
    }

    public static long glGetImageHandleARB(int i, int i2, boolean z, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        boolean z2 = z;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glGetImageHandleARB;
        BufferChecks.checkFunctionAddress(j);
        return nglGetImageHandleARB(i5, i6, z2, i7, i8, j);
    }

    public static long glGetTextureHandleARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glGetTextureHandleARB;
        BufferChecks.checkFunctionAddress(j);
        return nglGetTextureHandleARB(i2, j);
    }

    public static long glGetTextureSamplerHandleARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glGetTextureSamplerHandleARB;
        BufferChecks.checkFunctionAddress(j);
        return nglGetTextureSamplerHandleARB(i3, i4, j);
    }

    public static void glGetVertexAttribLuARB(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribLui64vARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 4);
        nglGetVertexAttribLui64vARB(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static boolean glIsImageHandleResidentARB(long j) {
        long j2 = j;
        long j3 = GLContext.getCapabilities().glIsImageHandleResidentARB;
        BufferChecks.checkFunctionAddress(j3);
        return nglIsImageHandleResidentARB(j2, j3);
    }

    public static boolean glIsTextureHandleResidentARB(long j) {
        long j2 = j;
        long j3 = GLContext.getCapabilities().glIsTextureHandleResidentARB;
        BufferChecks.checkFunctionAddress(j3);
        return nglIsTextureHandleResidentARB(j2, j3);
    }

    public static void glMakeImageHandleNonResidentARB(long j) {
        long j2 = j;
        long j3 = GLContext.getCapabilities().glMakeImageHandleNonResidentARB;
        BufferChecks.checkFunctionAddress(j3);
        nglMakeImageHandleNonResidentARB(j2, j3);
    }

    public static void glMakeImageHandleResidentARB(long j, int i) {
        long j2 = j;
        int i2 = i;
        long j3 = GLContext.getCapabilities().glMakeImageHandleResidentARB;
        BufferChecks.checkFunctionAddress(j3);
        nglMakeImageHandleResidentARB(j2, i2, j3);
    }

    public static void glMakeTextureHandleNonResidentARB(long j) {
        long j2 = j;
        long j3 = GLContext.getCapabilities().glMakeTextureHandleNonResidentARB;
        BufferChecks.checkFunctionAddress(j3);
        nglMakeTextureHandleNonResidentARB(j2, j3);
    }

    public static void glMakeTextureHandleResidentARB(long j) {
        long j2 = j;
        long j3 = GLContext.getCapabilities().glMakeTextureHandleResidentARB;
        BufferChecks.checkFunctionAddress(j3);
        nglMakeTextureHandleResidentARB(j2, j3);
    }

    public static void glProgramUniformHandleuARB(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glProgramUniformHandleui64vARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglProgramUniformHandleui64vARB(i3, i4, longBuffer2.remaining(), MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glProgramUniformHandleui64ARB(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glProgramUniformHandleui64ARB;
        BufferChecks.checkFunctionAddress(j3);
        nglProgramUniformHandleui64ARB(i3, i4, j2, j3);
    }

    public static void glUniformHandleuARB(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glUniformHandleui64vARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglUniformHandleui64vARB(i2, longBuffer2.remaining(), MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glUniformHandleui64ARB(int i, long j) {
        int i2 = i;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glUniformHandleui64ARB;
        BufferChecks.checkFunctionAddress(j3);
        nglUniformHandleui64ARB(i2, j2, j3);
    }

    public static void glVertexAttribL1uARB(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL1ui64vARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglVertexAttribL1ui64vARB(i2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glVertexAttribL1ui64ARB(int i, long j) {
        int i2 = i;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexAttribL1ui64ARB;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexAttribL1ui64ARB(i2, j2, j3);
    }

    static native long nglGetImageHandleARB(int i, int i2, boolean z, int i3, int i4, long j);

    static native long nglGetTextureHandleARB(int i, long j);

    static native long nglGetTextureSamplerHandleARB(int i, int i2, long j);

    static native void nglGetVertexAttribLui64vARB(int i, int i2, long j, long j2);

    static native boolean nglIsImageHandleResidentARB(long j, long j2);

    static native boolean nglIsTextureHandleResidentARB(long j, long j2);

    static native void nglMakeImageHandleNonResidentARB(long j, long j2);

    static native void nglMakeImageHandleResidentARB(long j, int i, long j2);

    static native void nglMakeTextureHandleNonResidentARB(long j, long j2);

    static native void nglMakeTextureHandleResidentARB(long j, long j2);

    static native void nglProgramUniformHandleui64ARB(int i, int i2, long j, long j2);

    static native void nglProgramUniformHandleui64vARB(int i, int i2, int i3, long j, long j2);

    static native void nglUniformHandleui64ARB(int i, long j, long j2);

    static native void nglUniformHandleui64vARB(int i, int i2, long j, long j2);

    static native void nglVertexAttribL1ui64ARB(int i, long j, long j2);

    static native void nglVertexAttribL1ui64vARB(int i, long j, long j2);
}
