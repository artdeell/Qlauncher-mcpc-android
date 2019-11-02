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

public class ARBBufferObject {
    public static final int GL_BUFFER_ACCESS_ARB = 35003;
    public static final int GL_BUFFER_MAPPED_ARB = 35004;
    public static final int GL_BUFFER_MAP_POINTER_ARB = 35005;
    public static final int GL_BUFFER_SIZE_ARB = 34660;
    public static final int GL_BUFFER_USAGE_ARB = 34661;
    public static final int GL_DYNAMIC_COPY_ARB = 35050;
    public static final int GL_DYNAMIC_DRAW_ARB = 35048;
    public static final int GL_DYNAMIC_READ_ARB = 35049;
    public static final int GL_READ_ONLY_ARB = 35000;
    public static final int GL_READ_WRITE_ARB = 35002;
    public static final int GL_STATIC_COPY_ARB = 35046;
    public static final int GL_STATIC_DRAW_ARB = 35044;
    public static final int GL_STATIC_READ_ARB = 35045;
    public static final int GL_STREAM_COPY_ARB = 35042;
    public static final int GL_STREAM_DRAW_ARB = 35040;
    public static final int GL_STREAM_READ_ARB = 35041;
    public static final int GL_WRITE_ONLY_ARB = 35001;

    public ARBBufferObject() {
    }

    public static void glBindBufferARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glBindBufferARB;
        BufferChecks.checkFunctionAddress(j);
        StateTracker.bindBuffer(capabilities, i3, i4);
        nglBindBufferARB(i3, i4, j);
    }

    public static void glBufferDataARB(int i, long j, int i2) {
        int i3 = i;
        long j2 = j;
        int i4 = i2;
        long j3 = GLContext.getCapabilities().glBufferDataARB;
        BufferChecks.checkFunctionAddress(j3);
        nglBufferDataARB(i3, j2, 0, i4, j3);
    }

    public static void glBufferDataARB(int i, ByteBuffer byteBuffer, int i2) {
        int i3 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferDataARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglBufferDataARB(i3, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), i4, j);
    }

    public static void glBufferDataARB(int i, DoubleBuffer doubleBuffer, int i2) {
        int i3 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferDataARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglBufferDataARB(i3, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), i4, j);
    }

    public static void glBufferDataARB(int i, FloatBuffer floatBuffer, int i2) {
        int i3 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferDataARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglBufferDataARB(i3, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), i4, j);
    }

    public static void glBufferDataARB(int i, IntBuffer intBuffer, int i2) {
        int i3 = i;
        IntBuffer intBuffer2 = intBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferDataARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglBufferDataARB(i3, (long) (intBuffer2.remaining() << 2), MemoryUtil.getAddress(intBuffer2), i4, j);
    }

    public static void glBufferDataARB(int i, ShortBuffer shortBuffer, int i2) {
        int i3 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferDataARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglBufferDataARB(i3, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), i4, j);
    }

    public static void glBufferSubDataARB(int i, long j, ByteBuffer byteBuffer) {
        int i2 = i;
        long j2 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = GLContext.getCapabilities().glBufferSubDataARB;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(byteBuffer2);
        nglBufferSubDataARB(i2, j2, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j3);
    }

    public static void glBufferSubDataARB(int i, long j, DoubleBuffer doubleBuffer) {
        int i2 = i;
        long j2 = j;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j3 = GLContext.getCapabilities().glBufferSubDataARB;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(doubleBuffer2);
        nglBufferSubDataARB(i2, j2, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), j3);
    }

    public static void glBufferSubDataARB(int i, long j, FloatBuffer floatBuffer) {
        int i2 = i;
        long j2 = j;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j3 = GLContext.getCapabilities().glBufferSubDataARB;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(floatBuffer2);
        nglBufferSubDataARB(i2, j2, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), j3);
    }

    public static void glBufferSubDataARB(int i, long j, IntBuffer intBuffer) {
        int i2 = i;
        long j2 = j;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = GLContext.getCapabilities().glBufferSubDataARB;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(intBuffer2);
        nglBufferSubDataARB(i2, j2, (long) (intBuffer2.remaining() << 2), MemoryUtil.getAddress(intBuffer2), j3);
    }

    public static void glBufferSubDataARB(int i, long j, ShortBuffer shortBuffer) {
        int i2 = i;
        long j2 = j;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j3 = GLContext.getCapabilities().glBufferSubDataARB;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(shortBuffer2);
        nglBufferSubDataARB(i2, j2, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), j3);
    }

    public static void glDeleteBuffersARB(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteBuffersARB;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteBuffersARB(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteBuffersARB(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteBuffersARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteBuffersARB(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGenBuffersARB() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenBuffersARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenBuffersARB(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenBuffersARB(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenBuffersARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenBuffersARB(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    @Deprecated
    public static int glGetBufferParameterARB(int i, int i2) {
        return glGetBufferParameteriARB(i, i2);
    }

    public static void glGetBufferParameterARB(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetBufferParameterivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetBufferParameterivARB(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetBufferParameteriARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetBufferParameterivARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetBufferParameterivARB(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static ByteBuffer glGetBufferPointerARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetBufferPointervARB;
        BufferChecks.checkFunctionAddress(j);
        ByteBuffer nglGetBufferPointervARB = nglGetBufferPointervARB(i3, i4, (long) GLChecks.getBufferObjectSizeARB(capabilities, i3), j);
        if (!LWJGLUtil.CHECKS || nglGetBufferPointervARB != null) {
            return nglGetBufferPointervARB.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static void glGetBufferSubDataARB(int i, long j, ByteBuffer byteBuffer) {
        int i2 = i;
        long j2 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = GLContext.getCapabilities().glGetBufferSubDataARB;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetBufferSubDataARB(i2, j2, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j3);
    }

    public static void glGetBufferSubDataARB(int i, long j, DoubleBuffer doubleBuffer) {
        int i2 = i;
        long j2 = j;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j3 = GLContext.getCapabilities().glGetBufferSubDataARB;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetBufferSubDataARB(i2, j2, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), j3);
    }

    public static void glGetBufferSubDataARB(int i, long j, FloatBuffer floatBuffer) {
        int i2 = i;
        long j2 = j;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j3 = GLContext.getCapabilities().glGetBufferSubDataARB;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetBufferSubDataARB(i2, j2, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), j3);
    }

    public static void glGetBufferSubDataARB(int i, long j, IntBuffer intBuffer) {
        int i2 = i;
        long j2 = j;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = GLContext.getCapabilities().glGetBufferSubDataARB;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(intBuffer2);
        nglGetBufferSubDataARB(i2, j2, (long) (intBuffer2.remaining() << 2), MemoryUtil.getAddress(intBuffer2), j3);
    }

    public static void glGetBufferSubDataARB(int i, long j, ShortBuffer shortBuffer) {
        int i2 = i;
        long j2 = j;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j3 = GLContext.getCapabilities().glGetBufferSubDataARB;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetBufferSubDataARB(i2, j2, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), j3);
    }

    public static boolean glIsBufferARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsBufferARB;
        BufferChecks.checkFunctionAddress(j);
        return nglIsBufferARB(i2, j);
    }

    public static ByteBuffer glMapBufferARB(int i, int i2, long j, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = GLContext.getCapabilities().glMapBufferARB;
        BufferChecks.checkFunctionAddress(j3);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        ByteBuffer nglMapBufferARB = nglMapBufferARB(i3, i4, j2, byteBuffer2, j3);
        if (!LWJGLUtil.CHECKS || nglMapBufferARB != null) {
            return nglMapBufferARB.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static ByteBuffer glMapBufferARB(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMapBufferARB;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        ByteBuffer nglMapBufferARB = nglMapBufferARB(i3, i4, (long) GLChecks.getBufferObjectSizeARB(capabilities, i3), byteBuffer2, j);
        if (!LWJGLUtil.CHECKS || nglMapBufferARB != null) {
            return nglMapBufferARB.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static boolean glUnmapBufferARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glUnmapBufferARB;
        BufferChecks.checkFunctionAddress(j);
        return nglUnmapBufferARB(i2, j);
    }

    static native void nglBindBufferARB(int i, int i2, long j);

    static native void nglBufferDataARB(int i, long j, long j2, int i2, long j3);

    static native void nglBufferSubDataARB(int i, long j, long j2, long j3, long j4);

    static native void nglDeleteBuffersARB(int i, long j, long j2);

    static native void nglGenBuffersARB(int i, long j, long j2);

    static native void nglGetBufferParameterivARB(int i, int i2, long j, long j2);

    static native ByteBuffer nglGetBufferPointervARB(int i, int i2, long j, long j2);

    static native void nglGetBufferSubDataARB(int i, long j, long j2, long j3, long j4);

    static native boolean nglIsBufferARB(int i, long j);

    static native ByteBuffer nglMapBufferARB(int i, int i2, long j, ByteBuffer byteBuffer, long j2);

    static native boolean nglUnmapBufferARB(int i, long j);
}
