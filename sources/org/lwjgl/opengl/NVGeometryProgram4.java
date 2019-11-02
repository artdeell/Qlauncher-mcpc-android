package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class NVGeometryProgram4 {
    public static final int GL_GEOMETRY_PROGRAM_NV = 35878;
    public static final int GL_MAX_PROGRAM_OUTPUT_VERTICES_NV = 35879;
    public static final int GL_MAX_PROGRAM_TOTAL_OUTPUT_COMPONENTS_NV = 35880;

    private NVGeometryProgram4() {
    }

    public static void glFramebufferTextureEXT(int i, int i2, int i3, int i4) {
        EXTGeometryShader4.glFramebufferTextureEXT(i, i2, i3, i4);
    }

    public static void glFramebufferTextureFaceEXT(int i, int i2, int i3, int i4, int i5) {
        EXTGeometryShader4.glFramebufferTextureFaceEXT(i, i2, i3, i4, i5);
    }

    public static void glFramebufferTextureLayerEXT(int i, int i2, int i3, int i4, int i5) {
        EXTGeometryShader4.glFramebufferTextureLayerEXT(i, i2, i3, i4, i5);
    }

    public static void glProgramVertexLimitNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glProgramVertexLimitNV;
        BufferChecks.checkFunctionAddress(j);
        nglProgramVertexLimitNV(i3, i4, j);
    }

    static native void nglProgramVertexLimitNV(int i, int i2, long j);
}
