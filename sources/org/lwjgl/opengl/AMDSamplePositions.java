package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class AMDSamplePositions {
    public static final int GL_SUBSAMPLE_DISTANCE_AMD = 34879;

    private AMDSamplePositions() {
    }

    public static void glSetMultisampleAMD(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glSetMultisamplefvAMD;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 2);
        nglSetMultisamplefvAMD(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    static native void nglSetMultisamplefvAMD(int i, int i2, long j, long j2);
}
