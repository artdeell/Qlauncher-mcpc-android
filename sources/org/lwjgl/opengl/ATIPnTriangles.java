package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ATIPnTriangles {
    public static final int GL_MAX_PN_TRIANGLES_TESSELATION_LEVEL_ATI = 34801;
    public static final int GL_PN_TRIANGLES_ATI = 34800;
    public static final int GL_PN_TRIANGLES_NORMAL_MODE_ATI = 34803;
    public static final int GL_PN_TRIANGLES_NORMAL_MODE_LINEAR_ATI = 34807;
    public static final int GL_PN_TRIANGLES_NORMAL_MODE_QUADRATIC_ATI = 34808;
    public static final int GL_PN_TRIANGLES_POINT_MODE_ATI = 34802;
    public static final int GL_PN_TRIANGLES_POINT_MODE_CUBIC_ATI = 34806;
    public static final int GL_PN_TRIANGLES_POINT_MODE_LINEAR_ATI = 34805;
    public static final int GL_PN_TRIANGLES_TESSELATION_LEVEL_ATI = 34804;

    private ATIPnTriangles() {
    }

    public static void glPNTrianglesfATI(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glPNTrianglesfATI;
        BufferChecks.checkFunctionAddress(j);
        nglPNTrianglesfATI(i2, f2, j);
    }

    public static void glPNTrianglesiATI(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glPNTrianglesiATI;
        BufferChecks.checkFunctionAddress(j);
        nglPNTrianglesiATI(i3, i4, j);
    }

    static native void nglPNTrianglesfATI(int i, float f, long j);

    static native void nglPNTrianglesiATI(int i, int i2, long j);
}
