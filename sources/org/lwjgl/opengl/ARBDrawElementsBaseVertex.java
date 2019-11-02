package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ARBDrawElementsBaseVertex {
    private ARBDrawElementsBaseVertex() {
    }

    public static void glDrawElementsBaseVertex(int i, int i2, int i3, long j, int i4) {
        GL32.glDrawElementsBaseVertex(i, i2, i3, j, i4);
    }

    public static void glDrawElementsBaseVertex(int i, ByteBuffer byteBuffer, int i2) {
        GL32.glDrawElementsBaseVertex(i, byteBuffer, i2);
    }

    public static void glDrawElementsBaseVertex(int i, IntBuffer intBuffer, int i2) {
        GL32.glDrawElementsBaseVertex(i, intBuffer, i2);
    }

    public static void glDrawElementsBaseVertex(int i, ShortBuffer shortBuffer, int i2) {
        GL32.glDrawElementsBaseVertex(i, shortBuffer, i2);
    }

    public static void glDrawElementsInstancedBaseVertex(int i, int i2, int i3, long j, int i4, int i5) {
        GL32.glDrawElementsInstancedBaseVertex(i, i2, i3, j, i4, i5);
    }

    public static void glDrawElementsInstancedBaseVertex(int i, ByteBuffer byteBuffer, int i2, int i3) {
        GL32.glDrawElementsInstancedBaseVertex(i, byteBuffer, i2, i3);
    }

    public static void glDrawElementsInstancedBaseVertex(int i, IntBuffer intBuffer, int i2, int i3) {
        GL32.glDrawElementsInstancedBaseVertex(i, intBuffer, i2, i3);
    }

    public static void glDrawElementsInstancedBaseVertex(int i, ShortBuffer shortBuffer, int i2, int i3) {
        GL32.glDrawElementsInstancedBaseVertex(i, shortBuffer, i2, i3);
    }

    public static void glDrawRangeElementsBaseVertex(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        GL32.glDrawRangeElementsBaseVertex(i, i2, i3, i4, i5, j, i6);
    }

    public static void glDrawRangeElementsBaseVertex(int i, int i2, int i3, ByteBuffer byteBuffer, int i4) {
        GL32.glDrawRangeElementsBaseVertex(i, i2, i3, byteBuffer, i4);
    }

    public static void glDrawRangeElementsBaseVertex(int i, int i2, int i3, IntBuffer intBuffer, int i4) {
        GL32.glDrawRangeElementsBaseVertex(i, i2, i3, intBuffer, i4);
    }

    public static void glDrawRangeElementsBaseVertex(int i, int i2, int i3, ShortBuffer shortBuffer, int i4) {
        GL32.glDrawRangeElementsBaseVertex(i, i2, i3, shortBuffer, i4);
    }
}
