package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class EXTDepthBoundsTest {
    public static final int GL_DEPTH_BOUNDS_EXT = 34961;
    public static final int GL_DEPTH_BOUNDS_TEST_EXT = 34960;

    private EXTDepthBoundsTest() {
    }

    public static void glDepthBoundsEXT(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glDepthBoundsEXT;
        BufferChecks.checkFunctionAddress(j);
        nglDepthBoundsEXT(d3, d4, j);
    }

    static native void nglDepthBoundsEXT(double d, double d2, long j);
}
