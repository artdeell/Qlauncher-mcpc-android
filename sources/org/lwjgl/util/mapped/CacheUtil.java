package org.lwjgl.util.mapped;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;

public final class CacheUtil {
    private static final int CACHE_LINE_SIZE;

    static {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        Integer privilegedInteger = LWJGLUtil.getPrivilegedInteger("org.lwjgl.util.mapped.CacheLineSize");
        if (privilegedInteger != null) {
            if (privilegedInteger.intValue() < 1) {
                IllegalStateException illegalStateException2 = illegalStateException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Invalid CacheLineSize specified: ").append(privilegedInteger).toString());
                throw illegalStateException2;
            }
            CACHE_LINE_SIZE = privilegedInteger.intValue();
        } else if (Runtime.getRuntime().availableProcessors() == 1) {
            if (LWJGLUtil.DEBUG) {
                LWJGLUtil.log("Cannot detect cache line size on single-core CPUs, assuming 64 bytes.");
            }
            CACHE_LINE_SIZE = 64;
        } else {
            CACHE_LINE_SIZE = CacheLineSize.getCacheLineSize();
        }
    }

    private CacheUtil() {
    }

    public static ByteBuffer createByteBuffer(int i) {
        int i2 = i;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2 + CACHE_LINE_SIZE);
        if (MemoryUtil.getAddress(allocateDirect) % ((long) CACHE_LINE_SIZE) != 0) {
            Buffer position = allocateDirect.position(CACHE_LINE_SIZE - ((int) (MemoryUtil.getAddress(allocateDirect) & ((long) (-1 + CACHE_LINE_SIZE)))));
        }
        Buffer limit = allocateDirect.limit(i2 + allocateDirect.position());
        return allocateDirect.slice().order(ByteOrder.nativeOrder());
    }

    public static CharBuffer createCharBuffer(int i) {
        return createByteBuffer(i << 1).asCharBuffer();
    }

    public static DoubleBuffer createDoubleBuffer(int i) {
        return createByteBuffer(i << 3).asDoubleBuffer();
    }

    public static FloatBuffer createFloatBuffer(int i) {
        return createByteBuffer(i << 2).asFloatBuffer();
    }

    public static IntBuffer createIntBuffer(int i) {
        return createByteBuffer(i << 2).asIntBuffer();
    }

    public static LongBuffer createLongBuffer(int i) {
        return createByteBuffer(i << 3).asLongBuffer();
    }

    public static PointerBuffer createPointerBuffer(int i) {
        PointerBuffer pointerBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        PointerBuffer pointerBuffer3 = new PointerBuffer(createByteBuffer(i * PointerBuffer.getPointerSize()));
        return pointerBuffer2;
    }

    public static ShortBuffer createShortBuffer(int i) {
        return createByteBuffer(i << 1).asShortBuffer();
    }

    public static int getCacheLineSize() {
        return CACHE_LINE_SIZE;
    }
}
