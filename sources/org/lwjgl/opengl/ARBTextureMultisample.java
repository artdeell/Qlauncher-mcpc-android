package org.lwjgl.opengl;

import java.nio.FloatBuffer;

public final class ARBTextureMultisample {
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE = 37129;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37132;
    public static final int GL_MAX_COLOR_TEXTURE_SAMPLES = 37134;
    public static final int GL_MAX_DEPTH_TEXTURE_SAMPLES = 37135;
    public static final int GL_MAX_INTEGER_SAMPLES = 37136;
    public static final int GL_MAX_SAMPLE_MASK_WORDS = 36441;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE = 37121;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY = 37123;
    public static final int GL_SAMPLER_2D_MULTISAMPLE = 37128;
    public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 37131;
    public static final int GL_SAMPLE_MASK = 36433;
    public static final int GL_SAMPLE_MASK_VALUE = 36434;
    public static final int GL_SAMPLE_POSITION = 36432;
    public static final int GL_TEXTURE_2D_MULTISAMPLE = 37120;
    public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 37122;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 37124;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 37125;
    public static final int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS = 37127;
    public static final int GL_TEXTURE_SAMPLES = 37126;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = 37130;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37133;

    private ARBTextureMultisample() {
    }

    public static void glGetMultisample(int i, int i2, FloatBuffer floatBuffer) {
        GL32.glGetMultisample(i, i2, floatBuffer);
    }

    public static void glSampleMaski(int i, int i2) {
        GL32.glSampleMaski(i, i2);
    }

    public static void glTexImage2DMultisample(int i, int i2, int i3, int i4, int i5, boolean z) {
        GL32.glTexImage2DMultisample(i, i2, i3, i4, i5, z);
    }

    public static void glTexImage3DMultisample(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        GL32.glTexImage3DMultisample(i, i2, i3, i4, i5, i6, z);
    }
}
