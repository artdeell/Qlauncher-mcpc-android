package org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBTransformFeedback3 {
    public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 36464;
    public static final int GL_MAX_VERTEX_STREAMS = 36465;

    private ARBTransformFeedback3() {
    }

    public static void glBeginQueryIndexed(int i, int i2, int i3) {
        GL40.glBeginQueryIndexed(i, i2, i3);
    }

    public static void glDrawTransformFeedbackStream(int i, int i2, int i3) {
        GL40.glDrawTransformFeedbackStream(i, i2, i3);
    }

    public static void glEndQueryIndexed(int i, int i2) {
        GL40.glEndQueryIndexed(i, i2);
    }

    public static void glGetQueryIndexed(int i, int i2, int i3, IntBuffer intBuffer) {
        GL40.glGetQueryIndexed(i, i2, i3, intBuffer);
    }

    public static int glGetQueryIndexedi(int i, int i2, int i3) {
        return GL40.glGetQueryIndexedi(i, i2, i3);
    }
}
