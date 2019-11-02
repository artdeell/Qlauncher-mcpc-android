package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public final class ARBClearTexture {
    public static final int GL_CLEAR_TEXTURE = 37733;

    private ARBClearTexture() {
    }

    public static void glClearTexImage(int i, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        GL44.glClearTexImage(i, i2, i3, i4, byteBuffer);
    }

    public static void glClearTexImage(int i, int i2, int i3, int i4, DoubleBuffer doubleBuffer) {
        GL44.glClearTexImage(i, i2, i3, i4, doubleBuffer);
    }

    public static void glClearTexImage(int i, int i2, int i3, int i4, FloatBuffer floatBuffer) {
        GL44.glClearTexImage(i, i2, i3, i4, floatBuffer);
    }

    public static void glClearTexImage(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        GL44.glClearTexImage(i, i2, i3, i4, intBuffer);
    }

    public static void glClearTexImage(int i, int i2, int i3, int i4, LongBuffer longBuffer) {
        GL44.glClearTexImage(i, i2, i3, i4, longBuffer);
    }

    public static void glClearTexImage(int i, int i2, int i3, int i4, ShortBuffer shortBuffer) {
        GL44.glClearTexImage(i, i2, i3, i4, shortBuffer);
    }

    public static void glClearTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, ByteBuffer byteBuffer) {
        GL44.glClearTexSubImage(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, byteBuffer);
    }

    public static void glClearTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, DoubleBuffer doubleBuffer) {
        GL44.glClearTexSubImage(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, doubleBuffer);
    }

    public static void glClearTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, FloatBuffer floatBuffer) {
        GL44.glClearTexSubImage(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, floatBuffer);
    }

    public static void glClearTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, IntBuffer intBuffer) {
        GL44.glClearTexSubImage(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, intBuffer);
    }

    public static void glClearTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, LongBuffer longBuffer) {
        GL44.glClearTexSubImage(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, longBuffer);
    }

    public static void glClearTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, ShortBuffer shortBuffer) {
        GL44.glClearTexSubImage(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, shortBuffer);
    }
}
