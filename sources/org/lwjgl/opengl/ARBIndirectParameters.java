package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBIndirectParameters {
    public static final int GL_PARAMETER_BUFFER_ARB = 33006;
    public static final int GL_PARAMETER_BUFFER_BINDING_ARB = 33007;

    private ARBIndirectParameters() {
    }

    public static void glMultiDrawArraysIndirectCountARB(int i, long j, long j2, int i2, int i3) {
        int i4 = i;
        long j3 = j;
        long j4 = j2;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j5 = capabilities.glMultiDrawArraysIndirectCountARB;
        BufferChecks.checkFunctionAddress(j5);
        GLChecks.ensureIndirectBOenabled(capabilities);
        nglMultiDrawArraysIndirectCountARBBO(i4, j3, j4, i5, i6, j5);
    }

    public static void glMultiDrawArraysIndirectCountARB(int i, ByteBuffer byteBuffer, long j, int i2, int i3) {
        int i4 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = j;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiDrawArraysIndirectCountARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, (i6 == 0 ? 16 : i6) * i5);
        nglMultiDrawArraysIndirectCountARB(i4, MemoryUtil.getAddress(byteBuffer2), j2, i5, i6, j3);
    }

    public static void glMultiDrawArraysIndirectCountARB(int i, IntBuffer intBuffer, long j, int i2, int i3) {
        int i4 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j2 = j;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiDrawArraysIndirectCountARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, (i6 == 0 ? 4 : i6 >> 2) * i5);
        nglMultiDrawArraysIndirectCountARB(i4, MemoryUtil.getAddress(intBuffer2), j2, i5, i6, j3);
    }

    public static void glMultiDrawElementsIndirectCountARB(int i, int i2, long j, long j2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        long j3 = j;
        long j4 = j2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j5 = capabilities.glMultiDrawElementsIndirectCountARB;
        BufferChecks.checkFunctionAddress(j5);
        GLChecks.ensureIndirectBOenabled(capabilities);
        nglMultiDrawElementsIndirectCountARBBO(i5, i6, j3, j4, i7, i8, j5);
    }

    public static void glMultiDrawElementsIndirectCountARB(int i, int i2, ByteBuffer byteBuffer, long j, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = j;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiDrawElementsIndirectCountARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, (i8 == 0 ? 20 : i8) * i7);
        nglMultiDrawElementsIndirectCountARB(i5, i6, MemoryUtil.getAddress(byteBuffer2), j2, i7, i8, j3);
    }

    public static void glMultiDrawElementsIndirectCountARB(int i, int i2, IntBuffer intBuffer, long j, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j2 = j;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiDrawElementsIndirectCountARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, (i8 == 0 ? 5 : i8 >> 2) * i7);
        nglMultiDrawElementsIndirectCountARB(i5, i6, MemoryUtil.getAddress(intBuffer2), j2, i7, i8, j3);
    }

    static native void nglMultiDrawArraysIndirectCountARB(int i, long j, long j2, int i2, int i3, long j3);

    static native void nglMultiDrawArraysIndirectCountARBBO(int i, long j, long j2, int i2, int i3, long j3);

    static native void nglMultiDrawElementsIndirectCountARB(int i, int i2, long j, long j2, int i3, int i4, long j3);

    static native void nglMultiDrawElementsIndirectCountARBBO(int i, int i2, long j, long j2, int i3, int i4, long j3);
}
