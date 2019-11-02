package org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBTransformFeedback2 {
    public static final int GL_TRANSFORM_FEEDBACK = 36386;
    public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 36387;

    private ARBTransformFeedback2() {
    }

    public static void glBindTransformFeedback(int i, int i2) {
        GL40.glBindTransformFeedback(i, i2);
    }

    public static void glDeleteTransformFeedbacks(int i) {
        GL40.glDeleteTransformFeedbacks(i);
    }

    public static void glDeleteTransformFeedbacks(IntBuffer intBuffer) {
        GL40.glDeleteTransformFeedbacks(intBuffer);
    }

    public static void glDrawTransformFeedback(int i, int i2) {
        GL40.glDrawTransformFeedback(i, i2);
    }

    public static int glGenTransformFeedbacks() {
        return GL40.glGenTransformFeedbacks();
    }

    public static void glGenTransformFeedbacks(IntBuffer intBuffer) {
        GL40.glGenTransformFeedbacks(intBuffer);
    }

    public static boolean glIsTransformFeedback(int i) {
        return GL40.glIsTransformFeedback(i);
    }

    public static void glPauseTransformFeedback() {
        GL40.glPauseTransformFeedback();
    }

    public static void glResumeTransformFeedback() {
        GL40.glResumeTransformFeedback();
    }
}
