package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ARBColorBufferFloat {
    public static final int GLX_RGBA_FLOAT_BIT = 4;
    public static final int GLX_RGBA_FLOAT_TYPE = 8377;
    public static final int GL_CLAMP_FRAGMENT_COLOR_ARB = 35099;
    public static final int GL_CLAMP_READ_COLOR_ARB = 35100;
    public static final int GL_CLAMP_VERTEX_COLOR_ARB = 35098;
    public static final int GL_FIXED_ONLY_ARB = 35101;
    public static final int GL_RGBA_FLOAT_MODE_ARB = 34848;
    public static final int WGL_TYPE_RGBA_FLOAT_ARB = 8608;

    private ARBColorBufferFloat() {
    }

    public static void glClampColorARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glClampColorARB;
        BufferChecks.checkFunctionAddress(j);
        nglClampColorARB(i3, i4, j);
    }

    static native void nglClampColorARB(int i, int i2, long j);
}
