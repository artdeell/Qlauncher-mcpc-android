package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class GL21 {
    public static final int GL_COMPRESSED_SLUMINANCE = 35914;
    public static final int GL_COMPRESSED_SLUMINANCE_ALPHA = 35915;
    public static final int GL_COMPRESSED_SRGB = 35912;
    public static final int GL_COMPRESSED_SRGB_ALPHA = 35913;
    public static final int GL_CURRENT_RASTER_SECONDARY_COLOR = 33887;
    public static final int GL_FLOAT_MAT2x3 = 35685;
    public static final int GL_FLOAT_MAT2x4 = 35686;
    public static final int GL_FLOAT_MAT3x2 = 35687;
    public static final int GL_FLOAT_MAT3x4 = 35688;
    public static final int GL_FLOAT_MAT4x2 = 35689;
    public static final int GL_FLOAT_MAT4x3 = 35690;
    public static final int GL_PIXEL_PACK_BUFFER = 35051;
    public static final int GL_PIXEL_PACK_BUFFER_BINDING = 35053;
    public static final int GL_PIXEL_UNPACK_BUFFER = 35052;
    public static final int GL_PIXEL_UNPACK_BUFFER_BINDING = 35055;
    public static final int GL_SLUMINANCE = 35910;
    public static final int GL_SLUMINANCE8 = 35911;
    public static final int GL_SLUMINANCE8_ALPHA8 = 35909;
    public static final int GL_SLUMINANCE_ALPHA = 35908;
    public static final int GL_SRGB = 35904;
    public static final int GL_SRGB8 = 35905;
    public static final int GL_SRGB8_ALPHA8 = 35907;
    public static final int GL_SRGB_ALPHA = 35906;

    private GL21() {
    }

    public static void glUniformMatrix2x3(int i, boolean z, FloatBuffer floatBuffer) {
        int i2 = i;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix2x3fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniformMatrix2x3fv(i2, floatBuffer2.remaining() / 6, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniformMatrix2x4(int i, boolean z, FloatBuffer floatBuffer) {
        int i2 = i;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix2x4fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniformMatrix2x4fv(i2, floatBuffer2.remaining() >> 3, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniformMatrix3x2(int i, boolean z, FloatBuffer floatBuffer) {
        int i2 = i;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix3x2fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniformMatrix3x2fv(i2, floatBuffer2.remaining() / 6, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniformMatrix3x4(int i, boolean z, FloatBuffer floatBuffer) {
        int i2 = i;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix3x4fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniformMatrix3x4fv(i2, floatBuffer2.remaining() / 12, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniformMatrix4x2(int i, boolean z, FloatBuffer floatBuffer) {
        int i2 = i;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix4x2fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniformMatrix4x2fv(i2, floatBuffer2.remaining() >> 3, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniformMatrix4x3(int i, boolean z, FloatBuffer floatBuffer) {
        int i2 = i;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix4x3fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniformMatrix4x3fv(i2, floatBuffer2.remaining() / 12, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    static native void nglUniformMatrix2x3fv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix2x4fv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix3x2fv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix3x4fv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix4x2fv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix4x3fv(int i, int i2, boolean z, long j, long j2);
}
