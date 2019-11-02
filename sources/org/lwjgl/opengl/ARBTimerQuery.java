package org.lwjgl.opengl;

import java.nio.LongBuffer;

public final class ARBTimerQuery {
    public static final int GL_TIMESTAMP = 36392;
    public static final int GL_TIME_ELAPSED = 35007;

    private ARBTimerQuery() {
    }

    public static void glGetQueryObject(int i, int i2, LongBuffer longBuffer) {
        GL33.glGetQueryObject(i, i2, longBuffer);
    }

    public static long glGetQueryObjecti64(int i, int i2) {
        return GL33.glGetQueryObjecti64(i, i2);
    }

    public static void glGetQueryObjectu(int i, int i2, LongBuffer longBuffer) {
        GL33.glGetQueryObjectu(i, i2, longBuffer);
    }

    public static long glGetQueryObjectui64(int i, int i2) {
        return GL33.glGetQueryObjectui64(i, i2);
    }

    public static void glQueryCounter(int i, int i2) {
        GL33.glQueryCounter(i, i2);
    }
}
