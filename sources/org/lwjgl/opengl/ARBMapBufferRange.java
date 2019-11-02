package org.lwjgl.opengl;

import java.nio.ByteBuffer;

public final class ARBMapBufferRange {
    public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 16;
    public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 8;
    public static final int GL_MAP_INVALIDATE_RANGE_BIT = 4;
    public static final int GL_MAP_READ_BIT = 1;
    public static final int GL_MAP_UNSYNCHRONIZED_BIT = 32;
    public static final int GL_MAP_WRITE_BIT = 2;

    private ARBMapBufferRange() {
    }

    public static void glFlushMappedBufferRange(int i, long j, long j2) {
        GL30.glFlushMappedBufferRange(i, j, j2);
    }

    public static ByteBuffer glMapBufferRange(int i, long j, long j2, int i2, ByteBuffer byteBuffer) {
        return GL30.glMapBufferRange(i, j, j2, i2, byteBuffer);
    }
}
