package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class EXTTextureBufferObject {
    public static final int GL_MAX_TEXTURE_BUFFER_SIZE_EXT = 35883;
    public static final int GL_TEXTURE_BINDING_BUFFER_EXT = 35884;
    public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING_EXT = 35885;
    public static final int GL_TEXTURE_BUFFER_EXT = 35882;
    public static final int GL_TEXTURE_BUFFER_FORMAT_EXT = 35886;

    private EXTTextureBufferObject() {
    }

    public static void glTexBufferEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glTexBufferEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTexBufferEXT(i4, i5, i6, j);
    }

    static native void nglTexBufferEXT(int i, int i2, int i3, long j);
}
