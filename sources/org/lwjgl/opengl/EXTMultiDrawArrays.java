package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class EXTMultiDrawArrays {
    private EXTMultiDrawArrays() {
    }

    public static void glMultiDrawArraysEXT(int i, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i2 = i;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = GLContext.getCapabilities().glMultiDrawArraysEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkBuffer(intBuffer4, intBuffer3.remaining());
        nglMultiDrawArraysEXT(i2, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), intBuffer3.remaining(), j);
    }

    static native void nglMultiDrawArraysEXT(int i, long j, long j2, int i2, long j3);
}
