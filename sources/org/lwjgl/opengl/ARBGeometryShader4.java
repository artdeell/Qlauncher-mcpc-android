package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ARBGeometryShader4 {
    public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED_ARB = 36263;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER_ARB = 36052;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_COUNT_ARB = 36265;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS_ARB = 36264;
    public static final int GL_GEOMETRY_INPUT_TYPE_ARB = 36315;
    public static final int GL_GEOMETRY_OUTPUT_TYPE_ARB = 36316;
    public static final int GL_GEOMETRY_SHADER_ARB = 36313;
    public static final int GL_GEOMETRY_VERTICES_OUT_ARB = 36314;
    public static final int GL_LINES_ADJACENCY_ARB = 10;
    public static final int GL_LINE_STRIP_ADJACENCY_ARB = 11;
    public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES_ARB = 36320;
    public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS_ARB = 35881;
    public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS_ARB = 36321;
    public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS_ARB = 36319;
    public static final int GL_MAX_GEOMETRY_VARYING_COMPONENTS_ARB = 36317;
    public static final int GL_MAX_VARYING_COMPONENTS_ARB = 35659;
    public static final int GL_MAX_VERTEX_VARYING_COMPONENTS_ARB = 36318;
    public static final int GL_PROGRAM_POINT_SIZE_ARB = 34370;
    public static final int GL_TRIANGLES_ADJACENCY_ARB = 12;
    public static final int GL_TRIANGLE_STRIP_ADJACENCY_ARB = 13;

    private ARBGeometryShader4() {
    }

    public static void glFramebufferTextureARB(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glFramebufferTextureARB;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferTextureARB(i5, i6, i7, i8, j);
    }

    public static void glFramebufferTextureFaceARB(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glFramebufferTextureFaceARB;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferTextureFaceARB(i6, i7, i8, i9, i10, j);
    }

    public static void glFramebufferTextureLayerARB(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glFramebufferTextureLayerARB;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferTextureLayerARB(i6, i7, i8, i9, i10, j);
    }

    public static void glProgramParameteriARB(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glProgramParameteriARB;
        BufferChecks.checkFunctionAddress(j);
        nglProgramParameteriARB(i4, i5, i6, j);
    }

    static native void nglFramebufferTextureARB(int i, int i2, int i3, int i4, long j);

    static native void nglFramebufferTextureFaceARB(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglFramebufferTextureLayerARB(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglProgramParameteriARB(int i, int i2, int i3, long j);
}
