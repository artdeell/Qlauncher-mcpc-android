package org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBInvalidateSubdata {
    private ARBInvalidateSubdata() {
    }

    public static void glInvalidateBufferData(int i) {
        GL43.glInvalidateBufferData(i);
    }

    public static void glInvalidateBufferSubData(int i, long j, long j2) {
        GL43.glInvalidateBufferSubData(i, j, j2);
    }

    public static void glInvalidateFramebuffer(int i, IntBuffer intBuffer) {
        GL43.glInvalidateFramebuffer(i, intBuffer);
    }

    public static void glInvalidateSubFramebuffer(int i, IntBuffer intBuffer, int i2, int i3, int i4, int i5) {
        GL43.glInvalidateSubFramebuffer(i, intBuffer, i2, i3, i4, i5);
    }

    public static void glInvalidateTexImage(int i, int i2) {
        GL43.glInvalidateTexImage(i, i2);
    }

    public static void glInvalidateTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GL43.glInvalidateTexSubImage(i, i2, i3, i4, i5, i6, i7, i8);
    }
}
