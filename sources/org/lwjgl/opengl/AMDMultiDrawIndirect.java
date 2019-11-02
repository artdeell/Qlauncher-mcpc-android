package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class AMDMultiDrawIndirect {
    private AMDMultiDrawIndirect() {
    }

    public static void glMultiDrawArraysIndirectAMD(int i, long j, int i2, int i3) {
        int i4 = i;
        long j2 = j;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiDrawArraysIndirectAMD;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureIndirectBOenabled(capabilities);
        nglMultiDrawArraysIndirectAMDBO(i4, j2, i5, i6, j3);
    }

    public static void glMultiDrawArraysIndirectAMD(int i, ByteBuffer byteBuffer, int i2, int i3) {
        int i4 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiDrawArraysIndirectAMD;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, (i6 == 0 ? 16 : i6) * i5);
        nglMultiDrawArraysIndirectAMD(i4, MemoryUtil.getAddress(byteBuffer2), i5, i6, j);
    }

    public static void glMultiDrawArraysIndirectAMD(int i, IntBuffer intBuffer, int i2, int i3) {
        int i4 = i;
        IntBuffer intBuffer2 = intBuffer;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiDrawArraysIndirectAMD;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, (i6 == 0 ? 4 : i6 >> 2) * i5);
        nglMultiDrawArraysIndirectAMD(i4, MemoryUtil.getAddress(intBuffer2), i5, i6, j);
    }

    public static void glMultiDrawElementsIndirectAMD(int i, int i2, long j, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        long j2 = j;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiDrawElementsIndirectAMD;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureIndirectBOenabled(capabilities);
        nglMultiDrawElementsIndirectAMDBO(i5, i6, j2, i7, i8, j3);
    }

    public static void glMultiDrawElementsIndirectAMD(int i, int i2, ByteBuffer byteBuffer, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiDrawElementsIndirectAMD;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, (i8 == 0 ? 20 : i8) * i7);
        nglMultiDrawElementsIndirectAMD(i5, i6, MemoryUtil.getAddress(byteBuffer2), i7, i8, j);
    }

    public static void glMultiDrawElementsIndirectAMD(int i, int i2, IntBuffer intBuffer, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        IntBuffer intBuffer2 = intBuffer;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiDrawElementsIndirectAMD;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, (i8 == 0 ? 5 : i8 >> 2) * i7);
        nglMultiDrawElementsIndirectAMD(i5, i6, MemoryUtil.getAddress(intBuffer2), i7, i8, j);
    }

    static native void nglMultiDrawArraysIndirectAMD(int i, long j, int i2, int i3, long j2);

    static native void nglMultiDrawArraysIndirectAMDBO(int i, long j, int i2, int i3, long j2);

    static native void nglMultiDrawElementsIndirectAMD(int i, int i2, long j, int i3, int i4, long j2);

    static native void nglMultiDrawElementsIndirectAMDBO(int i, int i2, long j, int i3, int i4, long j2);
}
