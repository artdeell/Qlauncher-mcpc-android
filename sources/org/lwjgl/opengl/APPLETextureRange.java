package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class APPLETextureRange {
    public static final int GL_STORAGE_CACHED_APPLE = 34238;
    public static final int GL_STORAGE_PRIVATE_APPLE = 34237;
    public static final int GL_STORAGE_SHARED_APPLE = 34239;
    public static final int GL_TEXTURE_RANGE_LENGTH_APPLE = 34231;
    public static final int GL_TEXTURE_RANGE_POINTER_APPLE = 34232;
    public static final int GL_TEXTURE_STORAGE_HINT_APPLE = 34236;

    private APPLETextureRange() {
    }

    public static Buffer glGetTexParameterPointervAPPLE(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glGetTexParameterPointervAPPLE;
        BufferChecks.checkFunctionAddress(j3);
        return nglGetTexParameterPointervAPPLE(i3, i4, j2, j3);
    }

    public static void glTextureRangeAPPLE(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glTextureRangeAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglTextureRangeAPPLE(i2, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    static native Buffer nglGetTexParameterPointervAPPLE(int i, int i2, long j, long j2);

    static native void nglTextureRangeAPPLE(int i, int i2, long j, long j2);
}
