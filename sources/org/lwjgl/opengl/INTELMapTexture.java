package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class INTELMapTexture {
    public static final int GL_LAYOUT_DEFAULT_INTEL = 0;
    public static final int GL_LAYOUT_LINEAR_CPU_CACHED_INTEL = 2;
    public static final int GL_LAYOUT_LINEAR_INTEL = 1;
    public static final int GL_TEXTURE_MEMORY_LAYOUT_INTEL = 33791;

    private INTELMapTexture() {
    }

    public static ByteBuffer glMapTexture2DINTEL(int i, int i2, long j, int i3, IntBuffer intBuffer, IntBuffer intBuffer2, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        long j2 = j;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = GLContext.getCapabilities().glMapTexture2DINTEL;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkBuffer(intBuffer3, 1);
        BufferChecks.checkBuffer(intBuffer4, 1);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        ByteBuffer nglMapTexture2DINTEL = nglMapTexture2DINTEL(i4, i5, j2, i6, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), byteBuffer2, j3);
        if (!LWJGLUtil.CHECKS || nglMapTexture2DINTEL != null) {
            return nglMapTexture2DINTEL.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static void glSyncTextureINTEL(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glSyncTextureINTEL;
        BufferChecks.checkFunctionAddress(j);
        nglSyncTextureINTEL(i2, j);
    }

    public static void glUnmapTexture2DINTEL(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glUnmapTexture2DINTEL;
        BufferChecks.checkFunctionAddress(j);
        nglUnmapTexture2DINTEL(i3, i4, j);
    }

    static native ByteBuffer nglMapTexture2DINTEL(int i, int i2, long j, int i3, long j2, long j3, ByteBuffer byteBuffer, long j4);

    static native void nglSyncTextureINTEL(int i, long j);

    static native void nglUnmapTexture2DINTEL(int i, int i2, long j);
}
