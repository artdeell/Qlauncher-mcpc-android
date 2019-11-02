package org.lwjgl.opengl;

public final class ARBTransformFeedbackInstanced {
    private ARBTransformFeedbackInstanced() {
    }

    public static void glDrawTransformFeedbackInstanced(int i, int i2, int i3) {
        GL42.glDrawTransformFeedbackInstanced(i, i2, i3);
    }

    public static void glDrawTransformFeedbackStreamInstanced(int i, int i2, int i3, int i4) {
        GL42.glDrawTransformFeedbackStreamInstanced(i, i2, i3, i4);
    }
}
