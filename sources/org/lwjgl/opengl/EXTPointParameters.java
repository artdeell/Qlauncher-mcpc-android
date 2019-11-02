package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class EXTPointParameters {
    public static final int GL_DISTANCE_ATTENUATION_EXT = 33065;
    public static final int GL_POINT_FADE_THRESHOLD_SIZE_EXT = 33064;
    public static final int GL_POINT_SIZE_MAX_EXT = 33063;
    public static final int GL_POINT_SIZE_MIN_EXT = 33062;

    private EXTPointParameters() {
    }

    public static void glPointParameterEXT(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glPointParameterfvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglPointParameterfvEXT(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glPointParameterfEXT(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glPointParameterfEXT;
        BufferChecks.checkFunctionAddress(j);
        nglPointParameterfEXT(i2, f2, j);
    }

    static native void nglPointParameterfEXT(int i, float f, long j);

    static native void nglPointParameterfvEXT(int i, long j, long j2);
}
