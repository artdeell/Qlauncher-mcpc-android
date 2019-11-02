package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBPointParameters {
    public static final int GL_POINT_DISTANCE_ATTENUATION_ARB = 33065;
    public static final int GL_POINT_FADE_THRESHOLD_SIZE_ARB = 33064;
    public static final int GL_POINT_SIZE_MAX_ARB = 33063;
    public static final int GL_POINT_SIZE_MIN_ARB = 33062;

    private ARBPointParameters() {
    }

    public static void glPointParameterARB(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glPointParameterfvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglPointParameterfvARB(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glPointParameterfARB(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glPointParameterfARB;
        BufferChecks.checkFunctionAddress(j);
        nglPointParameterfARB(i2, f2, j);
    }

    static native void nglPointParameterfARB(int i, float f, long j);

    static native void nglPointParameterfvARB(int i, long j, long j2);
}
