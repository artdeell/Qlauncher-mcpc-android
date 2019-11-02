package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ATIEnvmapBumpmap {
    public static final int GL_BUMP_ENVMAP_ATI = 34683;
    public static final int GL_BUMP_NUM_TEX_UNITS_ATI = 34679;
    public static final int GL_BUMP_ROT_MATRIX_ATI = 34677;
    public static final int GL_BUMP_ROT_MATRIX_SIZE_ATI = 34678;
    public static final int GL_BUMP_TARGET_ATI = 34684;
    public static final int GL_BUMP_TEX_UNITS_ATI = 34680;
    public static final int GL_DU8DV8_ATI = 34682;
    public static final int GL_DUDV_ATI = 34681;

    private ATIEnvmapBumpmap() {
    }

    public static void glGetTexBumpParameterATI(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetTexBumpParameterfvATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetTexBumpParameterfvATI(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetTexBumpParameterATI(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTexBumpParameterivATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetTexBumpParameterivATI(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexBumpParameterATI(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glTexBumpParameterfvATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglTexBumpParameterfvATI(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glTexBumpParameterATI(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTexBumpParameterivATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglTexBumpParameterivATI(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    static native void nglGetTexBumpParameterfvATI(int i, long j, long j2);

    static native void nglGetTexBumpParameterivATI(int i, long j, long j2);

    static native void nglTexBumpParameterfvATI(int i, long j, long j2);

    static native void nglTexBumpParameterivATI(int i, long j, long j2);
}
