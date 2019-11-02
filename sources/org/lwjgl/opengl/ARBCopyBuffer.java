package org.lwjgl.opengl;

public final class ARBCopyBuffer {
    public static final int GL_COPY_READ_BUFFER = 36662;
    public static final int GL_COPY_WRITE_BUFFER = 36663;

    private ARBCopyBuffer() {
    }

    public static void glCopyBufferSubData(int i, int i2, long j, long j2, long j3) {
        GL31.glCopyBufferSubData(i, i2, j, j2, j3);
    }
}
