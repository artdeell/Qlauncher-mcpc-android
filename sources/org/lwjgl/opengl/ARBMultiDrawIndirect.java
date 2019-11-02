package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class ARBMultiDrawIndirect {
    private ARBMultiDrawIndirect() {
    }

    public static void glMultiDrawArraysIndirect(int i, long j, int i2, int i3) {
        GL43.glMultiDrawArraysIndirect(i, j, i2, i3);
    }

    public static void glMultiDrawArraysIndirect(int i, ByteBuffer byteBuffer, int i2, int i3) {
        GL43.glMultiDrawArraysIndirect(i, byteBuffer, i2, i3);
    }

    public static void glMultiDrawArraysIndirect(int i, IntBuffer intBuffer, int i2, int i3) {
        GL43.glMultiDrawArraysIndirect(i, intBuffer, i2, i3);
    }

    public static void glMultiDrawElementsIndirect(int i, int i2, long j, int i3, int i4) {
        GL43.glMultiDrawElementsIndirect(i, i2, j, i3, i4);
    }

    public static void glMultiDrawElementsIndirect(int i, int i2, ByteBuffer byteBuffer, int i3, int i4) {
        GL43.glMultiDrawElementsIndirect(i, i2, byteBuffer, i3, i4);
    }

    public static void glMultiDrawElementsIndirect(int i, int i2, IntBuffer intBuffer, int i3, int i4) {
        GL43.glMultiDrawElementsIndirect(i, i2, intBuffer, i3, i4);
    }
}
