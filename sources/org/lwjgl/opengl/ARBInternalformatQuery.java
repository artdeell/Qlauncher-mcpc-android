package org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBInternalformatQuery {
    public static final int GL_NUM_SAMPLE_COUNTS = 37760;

    private ARBInternalformatQuery() {
    }

    public static int glGetInternalformat(int i, int i2, int i3) {
        return GL42.glGetInternalformat(i, i2, i3);
    }

    public static void glGetInternalformat(int i, int i2, int i3, IntBuffer intBuffer) {
        GL42.glGetInternalformat(i, i2, i3, intBuffer);
    }
}
