package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class EXTFramebufferMultisample {
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE_EXT = 36182;
    public static final int GL_MAX_SAMPLES_EXT = 36183;
    public static final int GL_RENDERBUFFER_SAMPLES_EXT = 36011;

    private EXTFramebufferMultisample() {
    }

    public static void glRenderbufferStorageMultisampleEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glRenderbufferStorageMultisampleEXT;
        BufferChecks.checkFunctionAddress(j);
        nglRenderbufferStorageMultisampleEXT(i6, i7, i8, i9, i10, j);
    }

    static native void nglRenderbufferStorageMultisampleEXT(int i, int i2, int i3, int i4, int i5, long j);
}
