package org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBVertexArrayObject {
    public static final int GL_VERTEX_ARRAY_BINDING = 34229;

    private ARBVertexArrayObject() {
    }

    public static void glBindVertexArray(int i) {
        GL30.glBindVertexArray(i);
    }

    public static void glDeleteVertexArrays(int i) {
        GL30.glDeleteVertexArrays(i);
    }

    public static void glDeleteVertexArrays(IntBuffer intBuffer) {
        GL30.glDeleteVertexArrays(intBuffer);
    }

    public static int glGenVertexArrays() {
        return GL30.glGenVertexArrays();
    }

    public static void glGenVertexArrays(IntBuffer intBuffer) {
        GL30.glGenVertexArrays(intBuffer);
    }

    public static boolean glIsVertexArray(int i) {
        return GL30.glIsVertexArray(i);
    }
}
