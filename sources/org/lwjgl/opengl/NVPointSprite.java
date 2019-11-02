package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVPointSprite {
    public static final int GL_COORD_REPLACE_NV = 34914;
    public static final int GL_POINT_SPRITE_NV = 34913;
    public static final int GL_POINT_SPRITE_R_MODE_NV = 34915;

    private NVPointSprite() {
    }

    public static void glPointParameterNV(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glPointParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglPointParameterivNV(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glPointParameteriNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glPointParameteriNV;
        BufferChecks.checkFunctionAddress(j);
        nglPointParameteriNV(i3, i4, j);
    }

    static native void nglPointParameteriNV(int i, int i2, long j);

    static native void nglPointParameterivNV(int i, long j, long j2);
}
