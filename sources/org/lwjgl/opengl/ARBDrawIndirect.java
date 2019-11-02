package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class ARBDrawIndirect {
    public static final int GL_DRAW_INDIRECT_BUFFER = 36671;
    public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675;

    private ARBDrawIndirect() {
    }

    public static void glDrawArraysIndirect(int i, long j) {
        GL40.glDrawArraysIndirect(i, j);
    }

    public static void glDrawArraysIndirect(int i, ByteBuffer byteBuffer) {
        GL40.glDrawArraysIndirect(i, byteBuffer);
    }

    public static void glDrawArraysIndirect(int i, IntBuffer intBuffer) {
        GL40.glDrawArraysIndirect(i, intBuffer);
    }

    public static void glDrawElementsIndirect(int i, int i2, long j) {
        GL40.glDrawElementsIndirect(i, i2, j);
    }

    public static void glDrawElementsIndirect(int i, int i2, ByteBuffer byteBuffer) {
        GL40.glDrawElementsIndirect(i, i2, byteBuffer);
    }

    public static void glDrawElementsIndirect(int i, int i2, IntBuffer intBuffer) {
        GL40.glDrawElementsIndirect(i, i2, intBuffer);
    }
}
