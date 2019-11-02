package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ARBTextureBufferObject {
    public static final int GL_MAX_TEXTURE_BUFFER_SIZE_ARB = 35883;
    public static final int GL_TEXTURE_BINDING_BUFFER_ARB = 35884;
    public static final int GL_TEXTURE_BUFFER_ARB = 35882;
    public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING_ARB = 35885;
    public static final int GL_TEXTURE_BUFFER_FORMAT_ARB = 35886;

    private ARBTextureBufferObject() {
    }

    public static void glTexBufferARB(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glTexBufferARB;
        BufferChecks.checkFunctionAddress(j);
        nglTexBufferARB(i4, i5, i6, j);
    }

    static native void nglTexBufferARB(int i, int i2, int i3, long j);
}
