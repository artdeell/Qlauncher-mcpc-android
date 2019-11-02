package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class EXTGeometryShader4 {
    public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED_EXT = 36263;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER_EXT = 36052;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_COUNT_EXT = 36265;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS_EXT = 36264;
    public static final int GL_GEOMETRY_INPUT_TYPE_EXT = 36315;
    public static final int GL_GEOMETRY_OUTPUT_TYPE_EXT = 36316;
    public static final int GL_GEOMETRY_SHADER_EXT = 36313;
    public static final int GL_GEOMETRY_VERTICES_OUT_EXT = 36314;
    public static final int GL_LINES_ADJACENCY_EXT = 10;
    public static final int GL_LINE_STRIP_ADJACENCY_EXT = 11;
    public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES_EXT = 36320;
    public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS_EXT = 35881;
    public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS_EXT = 36321;
    public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS_EXT = 36319;
    public static final int GL_MAX_GEOMETRY_VARYING_COMPONENTS_EXT = 36317;
    public static final int GL_MAX_VARYING_COMPONENTS_EXT = 35659;
    public static final int GL_MAX_VERTEX_VARYING_COMPONENTS_EXT = 36318;
    public static final int GL_PROGRAM_POINT_SIZE_EXT = 34370;
    public static final int GL_TRIANGLES_ADJACENCY_EXT = 12;
    public static final int GL_TRIANGLE_STRIP_ADJACENCY_EXT = 13;

    private EXTGeometryShader4() {
    }

    public static void glFramebufferTextureEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glFramebufferTextureEXT;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferTextureEXT(i5, i6, i7, i8, j);
    }

    public static void glFramebufferTextureFaceEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glFramebufferTextureFaceEXT;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferTextureFaceEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glFramebufferTextureLayerEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glFramebufferTextureLayerEXT;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferTextureLayerEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glProgramParameteriEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glProgramParameteriEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramParameteriEXT(i4, i5, i6, j);
    }

    static native void nglFramebufferTextureEXT(int i, int i2, int i3, int i4, long j);

    static native void nglFramebufferTextureFaceEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglFramebufferTextureLayerEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglProgramParameteriEXT(int i, int i2, int i3, long j);
}
