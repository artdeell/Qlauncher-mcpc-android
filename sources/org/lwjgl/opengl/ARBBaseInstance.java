package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ARBBaseInstance {
    private ARBBaseInstance() {
    }

    public static void glDrawArraysInstancedBaseInstance(int i, int i2, int i3, int i4, int i5) {
        GL42.glDrawArraysInstancedBaseInstance(i, i2, i3, i4, i5);
    }

    public static void glDrawElementsInstancedBaseInstance(int i, int i2, int i3, long j, int i4, int i5) {
        GL42.glDrawElementsInstancedBaseInstance(i, i2, i3, j, i4, i5);
    }

    public static void glDrawElementsInstancedBaseInstance(int i, ByteBuffer byteBuffer, int i2, int i3) {
        GL42.glDrawElementsInstancedBaseInstance(i, byteBuffer, i2, i3);
    }

    public static void glDrawElementsInstancedBaseInstance(int i, IntBuffer intBuffer, int i2, int i3) {
        GL42.glDrawElementsInstancedBaseInstance(i, intBuffer, i2, i3);
    }

    public static void glDrawElementsInstancedBaseInstance(int i, ShortBuffer shortBuffer, int i2, int i3) {
        GL42.glDrawElementsInstancedBaseInstance(i, shortBuffer, i2, i3);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(int i, int i2, int i3, long j, int i4, int i5, int i6) {
        GL42.glDrawElementsInstancedBaseVertexBaseInstance(i, i2, i3, j, i4, i5, i6);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(int i, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        GL42.glDrawElementsInstancedBaseVertexBaseInstance(i, byteBuffer, i2, i3, i4);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(int i, IntBuffer intBuffer, int i2, int i3, int i4) {
        GL42.glDrawElementsInstancedBaseVertexBaseInstance(i, intBuffer, i2, i3, i4);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(int i, ShortBuffer shortBuffer, int i2, int i3, int i4) {
        GL42.glDrawElementsInstancedBaseVertexBaseInstance(i, shortBuffer, i2, i3, i4);
    }
}
