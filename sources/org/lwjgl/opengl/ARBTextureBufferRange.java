package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ARBTextureBufferRange {
    public static final int GL_TEXTURE_BUFFER_OFFSET = 37277;
    public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 37279;
    public static final int GL_TEXTURE_BUFFER_SIZE = 37278;

    private ARBTextureBufferRange() {
    }

    public static void glTexBufferRange(int i, int i2, int i3, long j, long j2) {
        GL43.glTexBufferRange(i, i2, i3, j, j2);
    }

    public static void glTextureBufferRangeEXT(int i, int i2, int i3, int i4, long j, long j2) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glTextureBufferRangeEXT;
        BufferChecks.checkFunctionAddress(j5);
        nglTextureBufferRangeEXT(i5, i6, i7, i8, j3, j4, j5);
    }

    static native void nglTextureBufferRangeEXT(int i, int i2, int i3, int i4, long j, long j2, long j3);
}
