package org.lwjgl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public final class NondirectBufferWrapper {
    private static final int INITIAL_BUFFER_SIZE = 1;
    private static final ThreadLocal<CachedBuffers> thread_buffer;

    private static final class CachedBuffers {
        /* access modifiers changed from: private */
        public final ByteBuffer byte_buffer;
        /* access modifiers changed from: private */
        public final DoubleBuffer double_buffer_big;
        /* access modifiers changed from: private */
        public final DoubleBuffer double_buffer_little;
        /* access modifiers changed from: private */
        public final FloatBuffer float_buffer_big;
        /* access modifiers changed from: private */
        public final FloatBuffer float_buffer_little;
        /* access modifiers changed from: private */
        public final IntBuffer int_buffer_big;
        /* access modifiers changed from: private */
        public final IntBuffer int_buffer_little;
        /* access modifiers changed from: private */
        public final LongBuffer long_buffer_big;
        /* access modifiers changed from: private */
        public final LongBuffer long_buffer_little;
        /* access modifiers changed from: private */
        public final ShortBuffer short_buffer_big;
        /* access modifiers changed from: private */
        public final ShortBuffer short_buffer_little;

        private CachedBuffers(int i) {
            this.byte_buffer = ByteBuffer.allocateDirect(i);
            this.short_buffer_big = this.byte_buffer.asShortBuffer();
            this.int_buffer_big = this.byte_buffer.asIntBuffer();
            this.float_buffer_big = this.byte_buffer.asFloatBuffer();
            this.long_buffer_big = this.byte_buffer.asLongBuffer();
            this.double_buffer_big = this.byte_buffer.asDoubleBuffer();
            ByteBuffer order = this.byte_buffer.order(ByteOrder.LITTLE_ENDIAN);
            this.short_buffer_little = this.byte_buffer.asShortBuffer();
            this.int_buffer_little = this.byte_buffer.asIntBuffer();
            this.float_buffer_little = this.byte_buffer.asFloatBuffer();
            this.long_buffer_little = this.byte_buffer.asLongBuffer();
            this.double_buffer_little = this.byte_buffer.asDoubleBuffer();
        }

        /* synthetic */ CachedBuffers(int i, C07471 r7) {
            C07471 r2 = r7;
            this(i);
        }
    }

    static {
        C07471 r2;
        C07471 r0 = r2;
        C07471 r1 = new ThreadLocal<CachedBuffers>() {
            /* access modifiers changed from: protected */
            public CachedBuffers initialValue() {
                CachedBuffers cachedBuffers;
                CachedBuffers cachedBuffers2 = cachedBuffers;
                CachedBuffers cachedBuffers3 = new CachedBuffers(1, null);
                return cachedBuffers2;
            }
        };
        thread_buffer = r0;
    }

    public NondirectBufferWrapper() {
    }

    public static void copy(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        if (byteBuffer4 != null && !byteBuffer4.isDirect()) {
            int position = byteBuffer4.position();
            ByteBuffer put = byteBuffer4.put(byteBuffer3);
            Buffer position2 = byteBuffer4.position(position);
        }
    }

    public static void copy(DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2) {
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        if (doubleBuffer4 != null && !doubleBuffer4.isDirect()) {
            int position = doubleBuffer4.position();
            DoubleBuffer put = doubleBuffer4.put(doubleBuffer3);
            Buffer position2 = doubleBuffer4.position(position);
        }
    }

    public static void copy(FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        FloatBuffer floatBuffer3 = floatBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        if (floatBuffer4 != null && !floatBuffer4.isDirect()) {
            int position = floatBuffer4.position();
            FloatBuffer put = floatBuffer4.put(floatBuffer3);
            Buffer position2 = floatBuffer4.position(position);
        }
    }

    public static void copy(IntBuffer intBuffer, IntBuffer intBuffer2) {
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        if (intBuffer4 != null && !intBuffer4.isDirect()) {
            int position = intBuffer4.position();
            IntBuffer put = intBuffer4.put(intBuffer3);
            Buffer position2 = intBuffer4.position(position);
        }
    }

    public static void copy(LongBuffer longBuffer, LongBuffer longBuffer2) {
        LongBuffer longBuffer3 = longBuffer;
        LongBuffer longBuffer4 = longBuffer2;
        if (longBuffer4 != null && !longBuffer4.isDirect()) {
            int position = longBuffer4.position();
            LongBuffer put = longBuffer4.put(longBuffer3);
            Buffer position2 = longBuffer4.position(position);
        }
    }

    public static void copy(ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        if (shortBuffer4 != null && !shortBuffer4.isDirect()) {
            int position = shortBuffer4.position();
            ShortBuffer put = shortBuffer4.put(shortBuffer3);
            Buffer position2 = shortBuffer4.position(position);
        }
    }

    private static ByteBuffer doNoCopyWrap(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        ByteBuffer lookupBuffer = lookupBuffer(byteBuffer2);
        Buffer limit = lookupBuffer.limit(byteBuffer2.limit());
        Buffer position = lookupBuffer.position(byteBuffer2.position());
        return lookupBuffer;
    }

    private static DoubleBuffer doNoCopyWrap(DoubleBuffer doubleBuffer) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        DoubleBuffer lookupBuffer = lookupBuffer(doubleBuffer2);
        Buffer limit = lookupBuffer.limit(doubleBuffer2.limit());
        Buffer position = lookupBuffer.position(doubleBuffer2.position());
        return lookupBuffer;
    }

    private static FloatBuffer doNoCopyWrap(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        FloatBuffer lookupBuffer = lookupBuffer(floatBuffer2);
        Buffer limit = lookupBuffer.limit(floatBuffer2.limit());
        Buffer position = lookupBuffer.position(floatBuffer2.position());
        return lookupBuffer;
    }

    private static IntBuffer doNoCopyWrap(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        IntBuffer lookupBuffer = lookupBuffer(intBuffer2);
        Buffer limit = lookupBuffer.limit(intBuffer2.limit());
        Buffer position = lookupBuffer.position(intBuffer2.position());
        return lookupBuffer;
    }

    private static LongBuffer doNoCopyWrap(LongBuffer longBuffer) {
        LongBuffer longBuffer2 = longBuffer;
        LongBuffer lookupBuffer = lookupBuffer(longBuffer2);
        Buffer limit = lookupBuffer.limit(longBuffer2.limit());
        Buffer position = lookupBuffer.position(longBuffer2.position());
        return lookupBuffer;
    }

    private static ShortBuffer doNoCopyWrap(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        ShortBuffer lookupBuffer = lookupBuffer(shortBuffer2);
        Buffer limit = lookupBuffer.limit(shortBuffer2.limit());
        Buffer position = lookupBuffer.position(shortBuffer2.position());
        return lookupBuffer;
    }

    private static ByteBuffer doWrap(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        ByteBuffer lookupBuffer = lookupBuffer(byteBuffer2);
        Buffer clear = lookupBuffer.clear();
        int position = byteBuffer2.position();
        ByteBuffer put = lookupBuffer.put(byteBuffer2);
        Buffer position2 = byteBuffer2.position(position);
        Buffer flip = lookupBuffer.flip();
        return lookupBuffer;
    }

    private static DoubleBuffer doWrap(DoubleBuffer doubleBuffer) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        DoubleBuffer lookupBuffer = lookupBuffer(doubleBuffer2);
        Buffer clear = lookupBuffer.clear();
        int position = doubleBuffer2.position();
        DoubleBuffer put = lookupBuffer.put(doubleBuffer2);
        Buffer position2 = doubleBuffer2.position(position);
        Buffer flip = lookupBuffer.flip();
        return lookupBuffer;
    }

    private static FloatBuffer doWrap(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        FloatBuffer lookupBuffer = lookupBuffer(floatBuffer2);
        Buffer clear = lookupBuffer.clear();
        int position = floatBuffer2.position();
        FloatBuffer put = lookupBuffer.put(floatBuffer2);
        Buffer position2 = floatBuffer2.position(position);
        Buffer flip = lookupBuffer.flip();
        return lookupBuffer;
    }

    private static IntBuffer doWrap(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        IntBuffer lookupBuffer = lookupBuffer(intBuffer2);
        Buffer clear = lookupBuffer.clear();
        int position = intBuffer2.position();
        IntBuffer put = lookupBuffer.put(intBuffer2);
        Buffer position2 = intBuffer2.position(position);
        Buffer flip = lookupBuffer.flip();
        return lookupBuffer;
    }

    private static LongBuffer doWrap(LongBuffer longBuffer) {
        LongBuffer longBuffer2 = longBuffer;
        LongBuffer lookupBuffer = lookupBuffer(longBuffer2);
        Buffer clear = lookupBuffer.clear();
        int position = longBuffer2.position();
        LongBuffer put = lookupBuffer.put(longBuffer2);
        Buffer position2 = longBuffer2.position(position);
        Buffer flip = lookupBuffer.flip();
        return lookupBuffer;
    }

    private static ShortBuffer doWrap(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        ShortBuffer lookupBuffer = lookupBuffer(shortBuffer2);
        Buffer clear = lookupBuffer.clear();
        int position = shortBuffer2.position();
        ShortBuffer put = lookupBuffer.put(shortBuffer2);
        Buffer position2 = shortBuffer2.position(position);
        Buffer flip = lookupBuffer.flip();
        return lookupBuffer;
    }

    private static CachedBuffers getCachedBuffers(int i) {
        CachedBuffers cachedBuffers;
        int i2 = i;
        CachedBuffers cachedBuffers2 = (CachedBuffers) thread_buffer.get();
        if (i2 > cachedBuffers2.byte_buffer.capacity()) {
            CachedBuffers cachedBuffers3 = cachedBuffers;
            CachedBuffers cachedBuffers4 = new CachedBuffers(i2, null);
            cachedBuffers2 = cachedBuffers3;
            thread_buffer.set(cachedBuffers2);
        }
        return cachedBuffers2;
    }

    private static ByteBuffer lookupBuffer(ByteBuffer byteBuffer) {
        return getCachedBuffers(byteBuffer.remaining()).byte_buffer;
    }

    private static DoubleBuffer lookupBuffer(DoubleBuffer doubleBuffer) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        CachedBuffers cachedBuffers = getCachedBuffers(8 * doubleBuffer2.remaining());
        return doubleBuffer2.order() == ByteOrder.LITTLE_ENDIAN ? cachedBuffers.double_buffer_little : cachedBuffers.double_buffer_big;
    }

    private static FloatBuffer lookupBuffer(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        CachedBuffers cachedBuffers = getCachedBuffers(4 * floatBuffer2.remaining());
        return floatBuffer2.order() == ByteOrder.LITTLE_ENDIAN ? cachedBuffers.float_buffer_little : cachedBuffers.float_buffer_big;
    }

    private static IntBuffer lookupBuffer(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        CachedBuffers cachedBuffers = getCachedBuffers(4 * intBuffer2.remaining());
        return intBuffer2.order() == ByteOrder.LITTLE_ENDIAN ? cachedBuffers.int_buffer_little : cachedBuffers.int_buffer_big;
    }

    private static LongBuffer lookupBuffer(LongBuffer longBuffer) {
        LongBuffer longBuffer2 = longBuffer;
        CachedBuffers cachedBuffers = getCachedBuffers(8 * longBuffer2.remaining());
        return longBuffer2.order() == ByteOrder.LITTLE_ENDIAN ? cachedBuffers.long_buffer_little : cachedBuffers.long_buffer_big;
    }

    private static ShortBuffer lookupBuffer(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        CachedBuffers cachedBuffers = getCachedBuffers(2 * shortBuffer2.remaining());
        return shortBuffer2.order() == ByteOrder.LITTLE_ENDIAN ? cachedBuffers.short_buffer_little : cachedBuffers.short_buffer_big;
    }

    public static ByteBuffer wrapBuffer(ByteBuffer byteBuffer, int i) {
        ByteBuffer byteBuffer2 = byteBuffer;
        BufferChecks.checkBufferSize(byteBuffer2, i);
        return wrapDirect(byteBuffer2);
    }

    public static DoubleBuffer wrapBuffer(DoubleBuffer doubleBuffer, int i) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        BufferChecks.checkBufferSize(doubleBuffer2, i);
        return wrapDirect(doubleBuffer2);
    }

    public static FloatBuffer wrapBuffer(FloatBuffer floatBuffer, int i) {
        FloatBuffer floatBuffer2 = floatBuffer;
        BufferChecks.checkBufferSize(floatBuffer2, i);
        return wrapDirect(floatBuffer2);
    }

    public static IntBuffer wrapBuffer(IntBuffer intBuffer, int i) {
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkBufferSize(intBuffer2, i);
        return wrapDirect(intBuffer2);
    }

    public static LongBuffer wrapBuffer(LongBuffer longBuffer, int i) {
        LongBuffer longBuffer2 = longBuffer;
        BufferChecks.checkBufferSize(longBuffer2, i);
        return wrapDirect(longBuffer2);
    }

    public static ShortBuffer wrapBuffer(ShortBuffer shortBuffer, int i) {
        ShortBuffer shortBuffer2 = shortBuffer;
        BufferChecks.checkBufferSize(shortBuffer2, i);
        return wrapDirect(shortBuffer2);
    }

    public static ByteBuffer wrapDirect(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        if (!byteBuffer2.isDirect()) {
            byteBuffer2 = doWrap(byteBuffer2);
        }
        return byteBuffer2;
    }

    public static DoubleBuffer wrapDirect(DoubleBuffer doubleBuffer) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        if (!doubleBuffer2.isDirect()) {
            doubleBuffer2 = doWrap(doubleBuffer2);
        }
        return doubleBuffer2;
    }

    public static FloatBuffer wrapDirect(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        if (!floatBuffer2.isDirect()) {
            floatBuffer2 = doWrap(floatBuffer2);
        }
        return floatBuffer2;
    }

    public static IntBuffer wrapDirect(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        if (!intBuffer2.isDirect()) {
            intBuffer2 = doWrap(intBuffer2);
        }
        return intBuffer2;
    }

    public static LongBuffer wrapDirect(LongBuffer longBuffer) {
        LongBuffer longBuffer2 = longBuffer;
        if (!longBuffer2.isDirect()) {
            longBuffer2 = doWrap(longBuffer2);
        }
        return longBuffer2;
    }

    public static ShortBuffer wrapDirect(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        if (!shortBuffer2.isDirect()) {
            shortBuffer2 = doWrap(shortBuffer2);
        }
        return shortBuffer2;
    }

    public static ByteBuffer wrapNoCopyBuffer(ByteBuffer byteBuffer, int i) {
        ByteBuffer byteBuffer2 = byteBuffer;
        BufferChecks.checkBufferSize(byteBuffer2, i);
        return wrapNoCopyDirect(byteBuffer2);
    }

    public static DoubleBuffer wrapNoCopyBuffer(DoubleBuffer doubleBuffer, int i) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        BufferChecks.checkBufferSize(doubleBuffer2, i);
        return wrapNoCopyDirect(doubleBuffer2);
    }

    public static FloatBuffer wrapNoCopyBuffer(FloatBuffer floatBuffer, int i) {
        FloatBuffer floatBuffer2 = floatBuffer;
        BufferChecks.checkBufferSize(floatBuffer2, i);
        return wrapNoCopyDirect(floatBuffer2);
    }

    public static IntBuffer wrapNoCopyBuffer(IntBuffer intBuffer, int i) {
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkBufferSize(intBuffer2, i);
        return wrapNoCopyDirect(intBuffer2);
    }

    public static LongBuffer wrapNoCopyBuffer(LongBuffer longBuffer, int i) {
        LongBuffer longBuffer2 = longBuffer;
        BufferChecks.checkBufferSize(longBuffer2, i);
        return wrapNoCopyDirect(longBuffer2);
    }

    public static ShortBuffer wrapNoCopyBuffer(ShortBuffer shortBuffer, int i) {
        ShortBuffer shortBuffer2 = shortBuffer;
        BufferChecks.checkBufferSize(shortBuffer2, i);
        return wrapNoCopyDirect(shortBuffer2);
    }

    public static ByteBuffer wrapNoCopyDirect(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        if (!byteBuffer2.isDirect()) {
            byteBuffer2 = doNoCopyWrap(byteBuffer2);
        }
        return byteBuffer2;
    }

    public static DoubleBuffer wrapNoCopyDirect(DoubleBuffer doubleBuffer) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        if (!doubleBuffer2.isDirect()) {
            doubleBuffer2 = doNoCopyWrap(doubleBuffer2);
        }
        return doubleBuffer2;
    }

    public static FloatBuffer wrapNoCopyDirect(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        if (!floatBuffer2.isDirect()) {
            floatBuffer2 = doNoCopyWrap(floatBuffer2);
        }
        return floatBuffer2;
    }

    public static IntBuffer wrapNoCopyDirect(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        if (!intBuffer2.isDirect()) {
            intBuffer2 = doNoCopyWrap(intBuffer2);
        }
        return intBuffer2;
    }

    public static LongBuffer wrapNoCopyDirect(LongBuffer longBuffer) {
        LongBuffer longBuffer2 = longBuffer;
        if (!longBuffer2.isDirect()) {
            longBuffer2 = doNoCopyWrap(longBuffer2);
        }
        return longBuffer2;
    }

    public static ShortBuffer wrapNoCopyDirect(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        if (!shortBuffer2.isDirect()) {
            shortBuffer2 = doNoCopyWrap(shortBuffer2);
        }
        return shortBuffer2;
    }
}
