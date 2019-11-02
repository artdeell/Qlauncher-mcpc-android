package org.lwjgl.opengl;

import java.nio.ByteBuffer;

public final class ARBBlendFuncExtended {
    public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068;
    public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067;
    public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
    public static final int GL_SRC1_ALPHA = 34185;
    public static final int GL_SRC1_COLOR = 35065;

    private ARBBlendFuncExtended() {
    }

    public static void glBindFragDataLocationIndexed(int i, int i2, int i3, CharSequence charSequence) {
        GL33.glBindFragDataLocationIndexed(i, i2, i3, charSequence);
    }

    public static void glBindFragDataLocationIndexed(int i, int i2, int i3, ByteBuffer byteBuffer) {
        GL33.glBindFragDataLocationIndexed(i, i2, i3, byteBuffer);
    }

    public static int glGetFragDataIndex(int i, CharSequence charSequence) {
        return GL33.glGetFragDataIndex(i, charSequence);
    }

    public static int glGetFragDataIndex(int i, ByteBuffer byteBuffer) {
        return GL33.glGetFragDataIndex(i, byteBuffer);
    }
}
