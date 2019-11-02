package org.lwjgl.opengl;

public final class ARBTextureView {
    public static final int GL_TEXTURE_IMMUTABLE_LEVELS = 33503;
    public static final int GL_TEXTURE_VIEW_MIN_LAYER = 33501;
    public static final int GL_TEXTURE_VIEW_MIN_LEVEL = 33499;
    public static final int GL_TEXTURE_VIEW_NUM_LAYERS = 33502;
    public static final int GL_TEXTURE_VIEW_NUM_LEVELS = 33500;

    private ARBTextureView() {
    }

    public static void glTextureView(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GL43.glTextureView(i, i2, i3, i4, i5, i6, i7, i8);
    }
}
