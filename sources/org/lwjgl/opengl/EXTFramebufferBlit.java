package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class EXTFramebufferBlit {
    public static final int GL_DRAW_FRAMEBUFFER_BINDING_EXT = 36006;
    public static final int GL_DRAW_FRAMEBUFFER_EXT = 36009;
    public static final int GL_READ_FRAMEBUFFER_BINDING_EXT = 36010;
    public static final int GL_READ_FRAMEBUFFER_EXT = 36008;

    private EXTFramebufferBlit() {
    }

    public static void glBlitFramebufferEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = i;
        int i12 = i2;
        int i13 = i3;
        int i14 = i4;
        int i15 = i5;
        int i16 = i6;
        int i17 = i7;
        int i18 = i8;
        int i19 = i9;
        int i20 = i10;
        long j = GLContext.getCapabilities().glBlitFramebufferEXT;
        BufferChecks.checkFunctionAddress(j);
        nglBlitFramebufferEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, j);
    }

    static native void nglBlitFramebufferEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j);
}
