package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVParameterBufferObject {
    public static final int GL_FRAGMENT_PROGRAM_PARAMETER_BUFFER_NV = 36260;
    public static final int GL_GEOMETRY_PROGRAM_PARAMETER_BUFFER_NV = 36259;
    public static final int GL_MAX_PROGRAM_PARAMETER_BUFFER_BINDINGS_NV = 36256;
    public static final int GL_MAX_PROGRAM_PARAMETER_BUFFER_SIZE_NV = 36257;
    public static final int GL_VERTEX_PROGRAM_PARAMETER_BUFFER_NV = 36258;

    private NVParameterBufferObject() {
    }

    public static void glProgramBufferParametersINV(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramBufferParametersIivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramBufferParametersIivNV(i4, i5, i6, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramBufferParametersIuNV(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramBufferParametersIuivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramBufferParametersIuivNV(i4, i5, i6, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramBufferParametersNV(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramBufferParametersfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramBufferParametersfvNV(i4, i5, i6, floatBuffer2.remaining() >> 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    static native void nglProgramBufferParametersIivNV(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglProgramBufferParametersIuivNV(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglProgramBufferParametersfvNV(int i, int i2, int i3, int i4, long j, long j2);
}
