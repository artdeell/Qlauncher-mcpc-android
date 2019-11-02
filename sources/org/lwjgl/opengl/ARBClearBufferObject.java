package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBClearBufferObject {
    private ARBClearBufferObject() {
    }

    public static void glClearBufferData(int i, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        GL43.glClearBufferData(i, i2, i3, i4, byteBuffer);
    }

    public static void glClearBufferSubData(int i, int i2, long j, int i3, int i4, ByteBuffer byteBuffer) {
        GL43.glClearBufferSubData(i, i2, j, i3, i4, byteBuffer);
    }

    public static void glClearNamedBufferDataEXT(int i, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glClearNamedBufferDataEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 1);
        nglClearNamedBufferDataEXT(i5, i6, i7, i8, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glClearNamedBufferSubDataEXT(int i, int i2, long j, int i3, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        long j2 = j;
        int i7 = i3;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = GLContext.getCapabilities().glClearNamedBufferSubDataEXT;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(byteBuffer2);
        nglClearNamedBufferSubDataEXT(i5, i6, j2, (long) byteBuffer2.remaining(), i7, i8, MemoryUtil.getAddress(byteBuffer2), j3);
    }

    static native void nglClearNamedBufferDataEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglClearNamedBufferSubDataEXT(int i, int i2, long j, long j2, int i3, int i4, long j3, long j4);
}
