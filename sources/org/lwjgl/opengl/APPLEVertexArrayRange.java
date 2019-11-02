package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class APPLEVertexArrayRange {
    public static final int GL_DRAW_PIXELS_APPLE = 35338;
    public static final int GL_FENCE_APPLE = 35339;
    public static final int GL_MAX_VERTEX_ARRAY_RANGE_ELEMENT_APPLE = 34080;
    public static final int GL_STORAGE_CACHED_APPLE = 34238;
    public static final int GL_STORAGE_SHARED_APPLE = 34239;
    public static final int GL_VERTEX_ARRAY_RANGE_APPLE = 34077;
    public static final int GL_VERTEX_ARRAY_RANGE_LENGTH_APPLE = 34078;
    public static final int GL_VERTEX_ARRAY_RANGE_POINTER_APPLE = 34081;
    public static final int GL_VERTEX_ARRAY_STORAGE_HINT_APPLE = 34079;

    private APPLEVertexArrayRange() {
    }

    public static void glFlushVertexArrayRangeAPPLE(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glFlushVertexArrayRangeAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglFlushVertexArrayRangeAPPLE(byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexArrayParameteriAPPLE(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glVertexArrayParameteriAPPLE;
        BufferChecks.checkFunctionAddress(j);
        nglVertexArrayParameteriAPPLE(i3, i4, j);
    }

    public static void glVertexArrayRangeAPPLE(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glVertexArrayRangeAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglVertexArrayRangeAPPLE(byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    static native void nglFlushVertexArrayRangeAPPLE(int i, long j, long j2);

    static native void nglVertexArrayParameteriAPPLE(int i, int i2, long j);

    static native void nglVertexArrayRangeAPPLE(int i, long j, long j2);
}
