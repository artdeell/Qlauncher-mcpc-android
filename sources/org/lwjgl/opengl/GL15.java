package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class GL15 {
    public static final int GL_ARRAY_BUFFER = 34962;
    public static final int GL_ARRAY_BUFFER_BINDING = 34964;
    public static final int GL_BUFFER_ACCESS = 35003;
    public static final int GL_BUFFER_MAPPED = 35004;
    public static final int GL_BUFFER_MAP_POINTER = 35005;
    public static final int GL_BUFFER_SIZE = 34660;
    public static final int GL_BUFFER_USAGE = 34661;
    public static final int GL_COLOR_ARRAY_BUFFER_BINDING = 34968;
    public static final int GL_CURRENT_FOG_COORD = 33875;
    public static final int GL_CURRENT_QUERY = 34917;
    public static final int GL_DYNAMIC_COPY = 35050;
    public static final int GL_DYNAMIC_DRAW = 35048;
    public static final int GL_DYNAMIC_READ = 35049;
    public static final int GL_EDGE_FLAG_ARRAY_BUFFER_BINDING = 34971;
    public static final int GL_ELEMENT_ARRAY_BUFFER = 34963;
    public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 34965;
    public static final int GL_FOG_COORD = 33873;
    public static final int GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING = 34973;
    public static final int GL_FOG_COORD_ARRAY = 33879;
    public static final int GL_FOG_COORD_ARRAY_BUFFER_BINDING = 34973;
    public static final int GL_FOG_COORD_ARRAY_POINTER = 33878;
    public static final int GL_FOG_COORD_ARRAY_STRIDE = 33877;
    public static final int GL_FOG_COORD_ARRAY_TYPE = 33876;
    public static final int GL_FOG_COORD_SRC = 33872;
    public static final int GL_INDEX_ARRAY_BUFFER_BINDING = 34969;
    public static final int GL_NORMAL_ARRAY_BUFFER_BINDING = 34967;
    public static final int GL_QUERY_COUNTER_BITS = 34916;
    public static final int GL_QUERY_RESULT = 34918;
    public static final int GL_QUERY_RESULT_AVAILABLE = 34919;
    public static final int GL_READ_ONLY = 35000;
    public static final int GL_READ_WRITE = 35002;
    public static final int GL_SAMPLES_PASSED = 35092;
    public static final int GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING = 34972;
    public static final int GL_SRC0_ALPHA = 34184;
    public static final int GL_SRC0_RGB = 34176;
    public static final int GL_SRC1_ALPHA = 34185;
    public static final int GL_SRC1_RGB = 34177;
    public static final int GL_SRC2_ALPHA = 34186;
    public static final int GL_SRC2_RGB = 34178;
    public static final int GL_STATIC_COPY = 35046;
    public static final int GL_STATIC_DRAW = 35044;
    public static final int GL_STATIC_READ = 35045;
    public static final int GL_STREAM_COPY = 35042;
    public static final int GL_STREAM_DRAW = 35040;
    public static final int GL_STREAM_READ = 35041;
    public static final int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING = 34970;
    public static final int GL_VERTEX_ARRAY_BUFFER_BINDING = 34966;
    public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 34975;
    public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING = 34974;
    public static final int GL_WRITE_ONLY = 35001;

    private GL15() {
    }

    public static void glBeginQuery(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBeginQuery;
        BufferChecks.checkFunctionAddress(j);
        nglBeginQuery(i3, i4, j);
    }

    public static void glBindBuffer(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glBindBuffer;
        BufferChecks.checkFunctionAddress(j);
        StateTracker.bindBuffer(capabilities, i3, i4);
        nglBindBuffer(i3, i4, j);
    }

    public static void glBufferData(int i, long j, int i2) {
        int i3 = i;
        long j2 = j;
        int i4 = i2;
        long j3 = GLContext.getCapabilities().glBufferData;
        BufferChecks.checkFunctionAddress(j3);
        nglBufferData(i3, j2, 0, i4, j3);
    }

    public static void glBufferData(int i, ByteBuffer byteBuffer, int i2) {
        int i3 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferData;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglBufferData(i3, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), i4, j);
    }

    public static void glBufferData(int i, DoubleBuffer doubleBuffer, int i2) {
        int i3 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferData;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglBufferData(i3, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), i4, j);
    }

    public static void glBufferData(int i, FloatBuffer floatBuffer, int i2) {
        int i3 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferData;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglBufferData(i3, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), i4, j);
    }

    public static void glBufferData(int i, IntBuffer intBuffer, int i2) {
        int i3 = i;
        IntBuffer intBuffer2 = intBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferData;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglBufferData(i3, (long) (intBuffer2.remaining() << 2), MemoryUtil.getAddress(intBuffer2), i4, j);
    }

    public static void glBufferData(int i, ShortBuffer shortBuffer, int i2) {
        int i3 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferData;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglBufferData(i3, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), i4, j);
    }

    public static void glBufferSubData(int i, long j, ByteBuffer byteBuffer) {
        int i2 = i;
        long j2 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = GLContext.getCapabilities().glBufferSubData;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(byteBuffer2);
        nglBufferSubData(i2, j2, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j3);
    }

    public static void glBufferSubData(int i, long j, DoubleBuffer doubleBuffer) {
        int i2 = i;
        long j2 = j;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j3 = GLContext.getCapabilities().glBufferSubData;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(doubleBuffer2);
        nglBufferSubData(i2, j2, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), j3);
    }

    public static void glBufferSubData(int i, long j, FloatBuffer floatBuffer) {
        int i2 = i;
        long j2 = j;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j3 = GLContext.getCapabilities().glBufferSubData;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(floatBuffer2);
        nglBufferSubData(i2, j2, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), j3);
    }

    public static void glBufferSubData(int i, long j, IntBuffer intBuffer) {
        int i2 = i;
        long j2 = j;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = GLContext.getCapabilities().glBufferSubData;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(intBuffer2);
        nglBufferSubData(i2, j2, (long) (intBuffer2.remaining() << 2), MemoryUtil.getAddress(intBuffer2), j3);
    }

    public static void glBufferSubData(int i, long j, ShortBuffer shortBuffer) {
        int i2 = i;
        long j2 = j;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j3 = GLContext.getCapabilities().glBufferSubData;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(shortBuffer2);
        nglBufferSubData(i2, j2, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), j3);
    }

    public static void glDeleteBuffers(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteBuffers;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteBuffers(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteBuffers(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteBuffers;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteBuffers(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDeleteQueries(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteQueries;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteQueries(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteQueries(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteQueries;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteQueries(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glEndQuery(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glEndQuery;
        BufferChecks.checkFunctionAddress(j);
        nglEndQuery(i2, j);
    }

    public static int glGenBuffers() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenBuffers;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenBuffers(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenBuffers(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenBuffers;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenBuffers(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGenQueries() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenQueries;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenQueries(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenQueries(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenQueries;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenQueries(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    @Deprecated
    public static int glGetBufferParameter(int i, int i2) {
        return glGetBufferParameteri(i, i2);
    }

    public static void glGetBufferParameter(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetBufferParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetBufferParameteriv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetBufferParameteri(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetBufferParameteriv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetBufferParameteriv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static ByteBuffer glGetBufferPointer(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetBufferPointerv;
        BufferChecks.checkFunctionAddress(j);
        ByteBuffer nglGetBufferPointerv = nglGetBufferPointerv(i3, i4, (long) GLChecks.getBufferObjectSize(capabilities, i3), j);
        if (!LWJGLUtil.CHECKS || nglGetBufferPointerv != null) {
            return nglGetBufferPointerv.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static void glGetBufferSubData(int i, long j, ByteBuffer byteBuffer) {
        int i2 = i;
        long j2 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = GLContext.getCapabilities().glGetBufferSubData;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetBufferSubData(i2, j2, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j3);
    }

    public static void glGetBufferSubData(int i, long j, DoubleBuffer doubleBuffer) {
        int i2 = i;
        long j2 = j;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j3 = GLContext.getCapabilities().glGetBufferSubData;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetBufferSubData(i2, j2, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), j3);
    }

    public static void glGetBufferSubData(int i, long j, FloatBuffer floatBuffer) {
        int i2 = i;
        long j2 = j;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j3 = GLContext.getCapabilities().glGetBufferSubData;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetBufferSubData(i2, j2, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), j3);
    }

    public static void glGetBufferSubData(int i, long j, IntBuffer intBuffer) {
        int i2 = i;
        long j2 = j;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = GLContext.getCapabilities().glGetBufferSubData;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(intBuffer2);
        nglGetBufferSubData(i2, j2, (long) (intBuffer2.remaining() << 2), MemoryUtil.getAddress(intBuffer2), j3);
    }

    public static void glGetBufferSubData(int i, long j, ShortBuffer shortBuffer) {
        int i2 = i;
        long j2 = j;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j3 = GLContext.getCapabilities().glGetBufferSubData;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetBufferSubData(i2, j2, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), j3);
    }

    @Deprecated
    public static int glGetQuery(int i, int i2) {
        return glGetQueryi(i, i2);
    }

    public static void glGetQuery(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetQueryiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetQueryiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetQueryObject(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetQueryObjectiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetQueryObjectiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetQueryObjecti(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetQueryObjectiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetQueryObjectiv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetQueryObjectu(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetQueryObjectuiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetQueryObjectuiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetQueryObjectui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetQueryObjectuiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetQueryObjectuiv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static int glGetQueryi(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetQueryiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetQueryiv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static boolean glIsBuffer(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsBuffer;
        BufferChecks.checkFunctionAddress(j);
        return nglIsBuffer(i2, j);
    }

    public static boolean glIsQuery(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsQuery;
        BufferChecks.checkFunctionAddress(j);
        return nglIsQuery(i2, j);
    }

    public static ByteBuffer glMapBuffer(int i, int i2, long j, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = GLContext.getCapabilities().glMapBuffer;
        BufferChecks.checkFunctionAddress(j3);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        ByteBuffer nglMapBuffer = nglMapBuffer(i3, i4, j2, byteBuffer2, j3);
        if (!LWJGLUtil.CHECKS || nglMapBuffer != null) {
            return nglMapBuffer.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static ByteBuffer glMapBuffer(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMapBuffer;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        ByteBuffer nglMapBuffer = nglMapBuffer(i3, i4, (long) GLChecks.getBufferObjectSize(capabilities, i3), byteBuffer2, j);
        if (!LWJGLUtil.CHECKS || nglMapBuffer != null) {
            return nglMapBuffer.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static boolean glUnmapBuffer(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glUnmapBuffer;
        BufferChecks.checkFunctionAddress(j);
        return nglUnmapBuffer(i2, j);
    }

    static native void nglBeginQuery(int i, int i2, long j);

    static native void nglBindBuffer(int i, int i2, long j);

    static native void nglBufferData(int i, long j, long j2, int i2, long j3);

    static native void nglBufferSubData(int i, long j, long j2, long j3, long j4);

    static native void nglDeleteBuffers(int i, long j, long j2);

    static native void nglDeleteQueries(int i, long j, long j2);

    static native void nglEndQuery(int i, long j);

    static native void nglGenBuffers(int i, long j, long j2);

    static native void nglGenQueries(int i, long j, long j2);

    static native void nglGetBufferParameteriv(int i, int i2, long j, long j2);

    static native ByteBuffer nglGetBufferPointerv(int i, int i2, long j, long j2);

    static native void nglGetBufferSubData(int i, long j, long j2, long j3, long j4);

    static native void nglGetQueryObjectiv(int i, int i2, long j, long j2);

    static native void nglGetQueryObjectuiv(int i, int i2, long j, long j2);

    static native void nglGetQueryiv(int i, int i2, long j, long j2);

    static native boolean nglIsBuffer(int i, long j);

    static native boolean nglIsQuery(int i, long j);

    static native ByteBuffer nglMapBuffer(int i, int i2, long j, ByteBuffer byteBuffer, long j2);

    static native boolean nglUnmapBuffer(int i, long j);
}
