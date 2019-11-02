package org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class ARBViewportArray {
    public static final int GL_DEPTH_RANGE = 2928;
    public static final int GL_FIRST_VERTEX_CONVENTION = 36429;
    public static final int GL_LAST_VERTEX_CONVENTION = 36430;
    public static final int GL_LAYER_PROVOKING_VERTEX = 33374;
    public static final int GL_MAX_VIEWPORTS = 33371;
    public static final int GL_PROVOKING_VERTEX = 36431;
    public static final int GL_SCISSOR_BOX = 3088;
    public static final int GL_SCISSOR_TEST = 3089;
    public static final int GL_UNDEFINED_VERTEX = 33376;
    public static final int GL_VIEWPORT = 2978;
    public static final int GL_VIEWPORT_BOUNDS_RANGE = 33373;
    public static final int GL_VIEWPORT_INDEX_PROVOKING_VERTEX = 33375;
    public static final int GL_VIEWPORT_SUBPIXEL_BITS = 33372;

    private ARBViewportArray() {
    }

    public static void glDepthRangeArray(int i, DoubleBuffer doubleBuffer) {
        GL41.glDepthRangeArray(i, doubleBuffer);
    }

    public static void glDepthRangeIndexed(int i, double d, double d2) {
        GL41.glDepthRangeIndexed(i, d, d2);
    }

    public static void glDisableIndexedEXT(int i, int i2) {
        EXTDrawBuffers2.glDisableIndexedEXT(i, i2);
    }

    public static void glEnableIndexedEXT(int i, int i2) {
        EXTDrawBuffers2.glEnableIndexedEXT(i, i2);
    }

    public static double glGetDouble(int i, int i2) {
        return GL41.glGetDouble(i, i2);
    }

    public static void glGetDouble(int i, int i2, DoubleBuffer doubleBuffer) {
        GL41.glGetDouble(i, i2, doubleBuffer);
    }

    public static float glGetFloat(int i, int i2) {
        return GL41.glGetFloat(i, i2);
    }

    public static void glGetFloat(int i, int i2, FloatBuffer floatBuffer) {
        GL41.glGetFloat(i, i2, floatBuffer);
    }

    public static int glGetIntegerIndexedEXT(int i, int i2) {
        return EXTDrawBuffers2.glGetIntegerIndexedEXT(i, i2);
    }

    public static void glGetIntegerIndexedEXT(int i, int i2, IntBuffer intBuffer) {
        EXTDrawBuffers2.glGetIntegerIndexedEXT(i, i2, intBuffer);
    }

    public static boolean glIsEnabledIndexedEXT(int i, int i2) {
        return EXTDrawBuffers2.glIsEnabledIndexedEXT(i, i2);
    }

    public static void glScissorArray(int i, IntBuffer intBuffer) {
        GL41.glScissorArray(i, intBuffer);
    }

    public static void glScissorIndexed(int i, int i2, int i3, int i4, int i5) {
        GL41.glScissorIndexed(i, i2, i3, i4, i5);
    }

    public static void glScissorIndexed(int i, IntBuffer intBuffer) {
        GL41.glScissorIndexed(i, intBuffer);
    }

    public static void glViewportArray(int i, FloatBuffer floatBuffer) {
        GL41.glViewportArray(i, floatBuffer);
    }

    public static void glViewportIndexed(int i, FloatBuffer floatBuffer) {
        GL41.glViewportIndexed(i, floatBuffer);
    }

    public static void glViewportIndexedf(int i, float f, float f2, float f3, float f4) {
        GL41.glViewportIndexedf(i, f, f2, f3, f4);
    }
}
