package org.lwjgl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public final class BufferUtils {
    public BufferUtils() {
    }

    public static ByteBuffer createByteBuffer(int i) {
        return ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
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
        return PointerBuffer.allocateDirect(i);
    }

    public static ShortBuffer createShortBuffer(int i) {
        return createByteBuffer(i << 1).asShortBuffer();
    }

    static native long getBufferAddress(Buffer buffer);

    public static int getElementSizeExponent(Buffer buffer) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        Buffer buffer2 = buffer;
        if (buffer2 instanceof ByteBuffer) {
            return 0;
        }
        if ((buffer2 instanceof ShortBuffer) || (buffer2 instanceof CharBuffer)) {
            return 1;
        }
        if ((buffer2 instanceof FloatBuffer) || (buffer2 instanceof IntBuffer)) {
            return 2;
        }
        if ((buffer2 instanceof LongBuffer) || (buffer2 instanceof DoubleBuffer)) {
            return 3;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Unsupported buffer type: ").append(buffer2).toString());
        throw illegalStateException2;
    }

    public static int getOffset(Buffer buffer) {
        Buffer buffer2 = buffer;
        return buffer2.position() << getElementSizeExponent(buffer2);
    }

    public static void zeroBuffer(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        zeroBuffer0(byteBuffer2, (long) byteBuffer2.position(), (long) byteBuffer2.remaining());
    }

    public static void zeroBuffer(CharBuffer charBuffer) {
        CharBuffer charBuffer2 = charBuffer;
        zeroBuffer0(charBuffer2, 2 * ((long) charBuffer2.position()), 2 * ((long) charBuffer2.remaining()));
    }

    public static void zeroBuffer(DoubleBuffer doubleBuffer) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        zeroBuffer0(doubleBuffer2, 8 * ((long) doubleBuffer2.position()), 8 * ((long) doubleBuffer2.remaining()));
    }

    public static void zeroBuffer(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        zeroBuffer0(floatBuffer2, 4 * ((long) floatBuffer2.position()), 4 * ((long) floatBuffer2.remaining()));
    }

    public static void zeroBuffer(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        zeroBuffer0(intBuffer2, 4 * ((long) intBuffer2.position()), 4 * ((long) intBuffer2.remaining()));
    }

    public static void zeroBuffer(LongBuffer longBuffer) {
        LongBuffer longBuffer2 = longBuffer;
        zeroBuffer0(longBuffer2, 8 * ((long) longBuffer2.position()), 8 * ((long) longBuffer2.remaining()));
    }

    public static void zeroBuffer(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        zeroBuffer0(shortBuffer2, 2 * ((long) shortBuffer2.position()), 2 * ((long) shortBuffer2.remaining()));
    }

    private static native void zeroBuffer0(Buffer buffer, long j, long j2);
}
