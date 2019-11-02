package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.PointerBuffer;

public final class ARBMultiBind {
    private ARBMultiBind() {
    }

    public static void glBindBuffersBase(int i, int i2, int i3, IntBuffer intBuffer) {
        GL44.glBindBuffersBase(i, i2, i3, intBuffer);
    }

    public static void glBindBuffersRange(int i, int i2, int i3, IntBuffer intBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        GL44.glBindBuffersRange(i, i2, i3, intBuffer, pointerBuffer, pointerBuffer2);
    }

    public static void glBindImageTextures(int i, int i2, IntBuffer intBuffer) {
        GL44.glBindImageTextures(i, i2, intBuffer);
    }

    public static void glBindSamplers(int i, int i2, IntBuffer intBuffer) {
        GL44.glBindSamplers(i, i2, intBuffer);
    }

    public static void glBindTextures(int i, int i2, IntBuffer intBuffer) {
        GL44.glBindTextures(i, i2, intBuffer);
    }

    public static void glBindVertexBuffers(int i, int i2, IntBuffer intBuffer, PointerBuffer pointerBuffer, IntBuffer intBuffer2) {
        GL44.glBindVertexBuffers(i, i2, intBuffer, pointerBuffer, intBuffer2);
    }
}
