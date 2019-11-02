package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVRegisterCombiners2 {
    public static final int GL_PER_STAGE_CONSTANTS_NV = 34101;

    private NVRegisterCombiners2() {
    }

    public static void glCombinerStageParameterNV(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glCombinerStageParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglCombinerStageParameterfvNV(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetCombinerStageParameterNV(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetCombinerStageParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetCombinerStageParameterfvNV(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    static native void nglCombinerStageParameterfvNV(int i, int i2, long j, long j2);

    static native void nglGetCombinerStageParameterfvNV(int i, int i2, long j, long j2);
}
