package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class EXTGpuProgramParameters {
    private EXTGpuProgramParameters() {
    }

    public static void glProgramEnvParameters4EXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramEnvParameters4fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, i6 << 2);
        nglProgramEnvParameters4fvEXT(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramLocalParameters4EXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramLocalParameters4fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, i6 << 2);
        nglProgramLocalParameters4fvEXT(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    static native void nglProgramEnvParameters4fvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramLocalParameters4fvEXT(int i, int i2, int i3, long j, long j2);
}
