package org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class EXTFogCoord {
    public static final int GL_CURRENT_FOG_COORDINATE_EXT = 33875;
    public static final int GL_FOG_COORDINATE_ARRAY_EXT = 33879;
    public static final int GL_FOG_COORDINATE_ARRAY_POINTER_EXT = 33878;
    public static final int GL_FOG_COORDINATE_ARRAY_STRIDE_EXT = 33877;
    public static final int GL_FOG_COORDINATE_ARRAY_TYPE_EXT = 33876;
    public static final int GL_FOG_COORDINATE_EXT = 33873;
    public static final int GL_FOG_COORDINATE_SOURCE_EXT = 33872;
    public static final int GL_FRAGMENT_DEPTH_EXT = 33874;

    private EXTFogCoord() {
    }

    public static void glFogCoordPointerEXT(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glFogCoordPointerEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglFogCoordPointerEXTBO(i3, i4, j2, j3);
    }

    public static void glFogCoordPointerEXT(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glFogCoordPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).EXT_fog_coord_glFogCoordPointerEXT_data = doubleBuffer2;
        }
        nglFogCoordPointerEXT(5130, i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glFogCoordPointerEXT(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glFogCoordPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).EXT_fog_coord_glFogCoordPointerEXT_data = floatBuffer2;
        }
        nglFogCoordPointerEXT(GL11.GL_FLOAT, i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glFogCoorddEXT(double d) {
        double d2 = d;
        long j = GLContext.getCapabilities().glFogCoorddEXT;
        BufferChecks.checkFunctionAddress(j);
        nglFogCoorddEXT(d2, j);
    }

    public static void glFogCoordfEXT(float f) {
        float f2 = f;
        long j = GLContext.getCapabilities().glFogCoordfEXT;
        BufferChecks.checkFunctionAddress(j);
        nglFogCoordfEXT(f2, j);
    }

    static native void nglFogCoordPointerEXT(int i, int i2, long j, long j2);

    static native void nglFogCoordPointerEXTBO(int i, int i2, long j, long j2);

    static native void nglFogCoorddEXT(double d, long j);

    static native void nglFogCoordfEXT(float f, long j);
}
