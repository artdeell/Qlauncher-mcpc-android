package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVBindlessMultiDrawIndirect {
    private NVBindlessMultiDrawIndirect() {
    }

    public static void glMultiDrawArraysIndirectBindlessNV(int i, long j, int i2, int i3, int i4) {
        int i5 = i;
        long j2 = j;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiDrawArraysIndirectBindlessNV;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureIndirectBOenabled(capabilities);
        nglMultiDrawArraysIndirectBindlessNVBO(i5, j2, i6, i7, i8, j3);
    }

    public static void glMultiDrawArraysIndirectBindlessNV(int i, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        int i5 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiDrawArraysIndirectBindlessNV;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, (i7 == 0 ? 20 + (i8 * 24) : i7) * i6);
        nglMultiDrawArraysIndirectBindlessNV(i5, MemoryUtil.getAddress(byteBuffer2), i6, i7, i8, j);
    }

    public static void glMultiDrawElementsIndirectBindlessNV(int i, int i2, long j, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        long j2 = j;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiDrawElementsIndirectBindlessNV;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureIndirectBOenabled(capabilities);
        nglMultiDrawElementsIndirectBindlessNVBO(i6, i7, j2, i8, i9, i10, j3);
    }

    public static void glMultiDrawElementsIndirectBindlessNV(int i, int i2, ByteBuffer byteBuffer, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiDrawElementsIndirectBindlessNV;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, (i9 == 0 ? 48 + (i10 * 24) : i9) * i8);
        nglMultiDrawElementsIndirectBindlessNV(i6, i7, MemoryUtil.getAddress(byteBuffer2), i8, i9, i10, j);
    }

    static native void nglMultiDrawArraysIndirectBindlessNV(int i, long j, int i2, int i3, int i4, long j2);

    static native void nglMultiDrawArraysIndirectBindlessNVBO(int i, long j, int i2, int i3, int i4, long j2);

    static native void nglMultiDrawElementsIndirectBindlessNV(int i, int i2, long j, int i3, int i4, int i5, long j2);

    static native void nglMultiDrawElementsIndirectBindlessNVBO(int i, int i2, long j, int i3, int i4, int i5, long j2);
}
