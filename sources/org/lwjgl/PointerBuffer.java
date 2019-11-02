package org.lwjgl;

import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ReadOnlyBufferException;

public class PointerBuffer implements Comparable {
    private static final boolean is64Bit;
    protected final ByteBuffer pointers;
    protected final Buffer view;
    protected final IntBuffer view32;
    protected final LongBuffer view64;

    private static final class PointerBufferR extends PointerBuffer {
        PointerBufferR(ByteBuffer byteBuffer) {
            super(byteBuffer);
        }

        public PointerBuffer asReadOnlyBuffer() {
            return duplicate();
        }

        public PointerBuffer compact() {
            ReadOnlyBufferException readOnlyBufferException;
            ReadOnlyBufferException readOnlyBufferException2 = readOnlyBufferException;
            ReadOnlyBufferException readOnlyBufferException3 = new ReadOnlyBufferException();
            throw readOnlyBufferException2;
        }

        public boolean isReadOnly() {
            return true;
        }

        /* access modifiers changed from: protected */
        public PointerBuffer newInstance(ByteBuffer byteBuffer) {
            PointerBufferR pointerBufferR;
            PointerBufferR pointerBufferR2 = pointerBufferR;
            PointerBufferR pointerBufferR3 = new PointerBufferR(byteBuffer);
            return pointerBufferR2;
        }

        public PointerBuffer put(int i, long j) {
            ReadOnlyBufferException readOnlyBufferException;
            int i2 = i;
            long j2 = j;
            ReadOnlyBufferException readOnlyBufferException2 = readOnlyBufferException;
            ReadOnlyBufferException readOnlyBufferException3 = new ReadOnlyBufferException();
            throw readOnlyBufferException2;
        }

        public PointerBuffer put(long j) {
            ReadOnlyBufferException readOnlyBufferException;
            long j2 = j;
            ReadOnlyBufferException readOnlyBufferException2 = readOnlyBufferException;
            ReadOnlyBufferException readOnlyBufferException3 = new ReadOnlyBufferException();
            throw readOnlyBufferException2;
        }

        public PointerBuffer put(PointerBuffer pointerBuffer) {
            ReadOnlyBufferException readOnlyBufferException;
            PointerBuffer pointerBuffer2 = pointerBuffer;
            ReadOnlyBufferException readOnlyBufferException2 = readOnlyBufferException;
            ReadOnlyBufferException readOnlyBufferException3 = new ReadOnlyBufferException();
            throw readOnlyBufferException2;
        }

        public PointerBuffer put(long[] jArr, int i, int i2) {
            ReadOnlyBufferException readOnlyBufferException;
            long[] jArr2 = jArr;
            int i3 = i;
            int i4 = i2;
            ReadOnlyBufferException readOnlyBufferException2 = readOnlyBufferException;
            ReadOnlyBufferException readOnlyBufferException3 = new ReadOnlyBufferException();
            throw readOnlyBufferException2;
        }
    }

    static {
        try {
            is64Bit = ((Boolean) Class.forName("org.lwjgl.Sys").getDeclaredMethod("is64Bit", null).invoke(null, null)).booleanValue();
        } catch (Throwable th) {
            Throwable th2 = th;
            is64Bit = false;
            throw th2;
        }
    }

    public PointerBuffer(int i) {
        this(BufferUtils.createByteBuffer(i * getPointerSize()));
    }

    public PointerBuffer(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        if (LWJGLUtil.CHECKS) {
            checkSource(byteBuffer2);
        }
        this.pointers = byteBuffer2.slice().order(byteBuffer2.order());
        if (is64Bit) {
            this.view32 = null;
            LongBuffer asLongBuffer = this.pointers.asLongBuffer();
            this.view64 = asLongBuffer;
            this.view = asLongBuffer;
            return;
        }
        IntBuffer asIntBuffer = this.pointers.asIntBuffer();
        this.view32 = asIntBuffer;
        this.view = asIntBuffer;
        this.view64 = null;
    }

    public static PointerBuffer allocateDirect(int i) {
        PointerBuffer pointerBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        PointerBuffer pointerBuffer3 = new PointerBuffer(i);
        return pointerBuffer2;
    }

    private static void checkBounds(int i, int i2, int i3) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i4 = i;
        int i5 = i2;
        if ((i4 | i5 | (i4 + i5) | (i3 - (i4 + i5))) < 0) {
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException();
            throw indexOutOfBoundsException2;
        }
    }

    private static void checkSource(ByteBuffer byteBuffer) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException2;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (!byteBuffer2.isDirect()) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("The source buffer is not direct.");
            throw illegalArgumentException3;
        }
        int i = is64Bit ? 8 : 4;
        if ((MemoryUtil.getAddress0((Buffer) byteBuffer2) + ((long) byteBuffer2.position())) % ((long) i) != 0 || byteBuffer2.remaining() % i != 0) {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb2.append("The source buffer is not aligned to ").append(i).append(" bytes.").toString());
            throw illegalArgumentException5;
        }
    }

    public static int getPointerSize() {
        return is64Bit ? 8 : 4;
    }

    public static boolean is64Bit() {
        return is64Bit;
    }

    public static void put(ByteBuffer byteBuffer, int i, long j) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int i2 = i;
        long j2 = j;
        if (is64Bit) {
            ByteBuffer putLong = byteBuffer2.putLong(i2, j2);
        } else {
            ByteBuffer putInt = byteBuffer2.putInt(i2, (int) j2);
        }
    }

    public static void put(ByteBuffer byteBuffer, long j) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = j;
        if (is64Bit) {
            ByteBuffer putLong = byteBuffer2.putLong(j2);
        } else {
            ByteBuffer putInt = byteBuffer2.putInt((int) j2);
        }
    }

    public PointerBuffer asReadOnlyBuffer() {
        PointerBufferR pointerBufferR;
        PointerBufferR pointerBufferR2 = pointerBufferR;
        PointerBufferR pointerBufferR3 = new PointerBufferR(this.pointers);
        PointerBufferR pointerBufferR4 = pointerBufferR2;
        PointerBuffer position = pointerBufferR4.position(this.view.position());
        PointerBuffer limit = pointerBufferR4.limit(this.view.limit());
        return pointerBufferR4;
    }

    public final int capacity() {
        return this.view.capacity();
    }

    public final PointerBuffer clear() {
        Buffer clear = this.view.clear();
        return this;
    }

    public PointerBuffer compact() {
        if (is64Bit) {
            LongBuffer compact = this.view64.compact();
            return this;
        }
        IntBuffer compact2 = this.view32.compact();
        return this;
    }

    public int compareTo(Object obj) {
        PointerBuffer pointerBuffer = (PointerBuffer) obj;
        int position = position() + Math.min(remaining(), pointerBuffer.remaining());
        int position2 = position();
        int position3 = pointerBuffer.position();
        while (position2 < position) {
            long j = get(position2);
            long j2 = pointerBuffer.get(position3);
            if (j != j2) {
                return j < j2 ? -1 : 1;
            }
            position2++;
            position3++;
        }
        return remaining() - pointerBuffer.remaining();
    }

    public PointerBuffer duplicate() {
        PointerBuffer newInstance = newInstance(this.pointers);
        PointerBuffer position = newInstance.position(this.view.position());
        PointerBuffer limit = newInstance.limit(this.view.limit());
        return newInstance;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof PointerBuffer) {
            PointerBuffer pointerBuffer = (PointerBuffer) obj2;
            if (remaining() == pointerBuffer.remaining()) {
                int position = position();
                int limit = -1 + limit();
                int limit2 = -1 + pointerBuffer.limit();
                while (limit >= position) {
                    if (get(limit) == pointerBuffer.get(limit2)) {
                        limit--;
                        limit2--;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final PointerBuffer flip() {
        Buffer flip = this.view.flip();
        return this;
    }

    public long get() {
        return is64Bit ? this.view64.get() : 4294967295L & ((long) this.view32.get());
    }

    public long get(int i) {
        int i2 = i;
        return is64Bit ? this.view64.get(i2) : 4294967295L & ((long) this.view32.get(i2));
    }

    public PointerBuffer get(long[] jArr) {
        long[] jArr2 = jArr;
        return get(jArr2, 0, jArr2.length);
    }

    public PointerBuffer get(long[] jArr, int i, int i2) {
        BufferUnderflowException bufferUnderflowException;
        long[] jArr2 = jArr;
        int i3 = i;
        int i4 = i2;
        if (is64Bit) {
            LongBuffer longBuffer = this.view64.get(jArr2, i3, i4);
        } else {
            checkBounds(i3, i4, jArr2.length);
            if (i4 > this.view32.remaining()) {
                BufferUnderflowException bufferUnderflowException2 = bufferUnderflowException;
                BufferUnderflowException bufferUnderflowException3 = new BufferUnderflowException();
                throw bufferUnderflowException2;
            }
            int i5 = i3 + i4;
            for (int i6 = i3; i6 < i5; i6++) {
                jArr2[i6] = 4294967295L & ((long) this.view32.get());
            }
        }
        return this;
    }

    public ByteBuffer getBuffer() {
        return this.pointers;
    }

    public final boolean hasRemaining() {
        return this.view.hasRemaining();
    }

    public int hashCode() {
        int i = 1;
        for (int limit = -1 + limit(); limit >= position(); limit--) {
            i = (i * 31) + ((int) get(limit));
        }
        return i;
    }

    public boolean isReadOnly() {
        return false;
    }

    public final int limit() {
        return this.view.limit();
    }

    public final PointerBuffer limit(int i) {
        Buffer limit = this.view.limit(i);
        return this;
    }

    public final PointerBuffer mark() {
        Buffer mark = this.view.mark();
        return this;
    }

    /* access modifiers changed from: protected */
    public PointerBuffer newInstance(ByteBuffer byteBuffer) {
        PointerBuffer pointerBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        PointerBuffer pointerBuffer3 = new PointerBuffer(byteBuffer);
        return pointerBuffer2;
    }

    public ByteOrder order() {
        return is64Bit ? this.view64.order() : this.view32.order();
    }

    public final int position() {
        return this.view.position();
    }

    public final PointerBuffer position(int i) {
        Buffer position = this.view.position(i);
        return this;
    }

    public final int positionByte() {
        return position() * getPointerSize();
    }

    public PointerBuffer put(int i, long j) {
        int i2 = i;
        long j2 = j;
        if (is64Bit) {
            LongBuffer put = this.view64.put(i2, j2);
            return this;
        }
        IntBuffer put2 = this.view32.put(i2, (int) j2);
        return this;
    }

    public PointerBuffer put(int i, PointerWrapper pointerWrapper) {
        return put(i, pointerWrapper.getPointer());
    }

    public PointerBuffer put(long j) {
        long j2 = j;
        if (is64Bit) {
            LongBuffer put = this.view64.put(j2);
            return this;
        }
        IntBuffer put2 = this.view32.put((int) j2);
        return this;
    }

    public PointerBuffer put(PointerBuffer pointerBuffer) {
        PointerBuffer pointerBuffer2 = pointerBuffer;
        if (is64Bit) {
            LongBuffer put = this.view64.put(pointerBuffer2.view64);
            return this;
        }
        IntBuffer put2 = this.view32.put(pointerBuffer2.view32);
        return this;
    }

    public PointerBuffer put(PointerWrapper pointerWrapper) {
        return put(pointerWrapper.getPointer());
    }

    public final PointerBuffer put(long[] jArr) {
        long[] jArr2 = jArr;
        return put(jArr2, 0, jArr2.length);
    }

    public PointerBuffer put(long[] jArr, int i, int i2) {
        BufferOverflowException bufferOverflowException;
        long[] jArr2 = jArr;
        int i3 = i;
        int i4 = i2;
        if (is64Bit) {
            LongBuffer put = this.view64.put(jArr2, i3, i4);
        } else {
            checkBounds(i3, i4, jArr2.length);
            if (i4 > this.view32.remaining()) {
                BufferOverflowException bufferOverflowException2 = bufferOverflowException;
                BufferOverflowException bufferOverflowException3 = new BufferOverflowException();
                throw bufferOverflowException2;
            }
            int i5 = i3 + i4;
            for (int i6 = i3; i6 < i5; i6++) {
                IntBuffer put2 = this.view32.put((int) jArr2[i6]);
            }
        }
        return this;
    }

    public final int remaining() {
        return this.view.remaining();
    }

    public final int remainingByte() {
        return remaining() * getPointerSize();
    }

    public final PointerBuffer reset() {
        Buffer reset = this.view.reset();
        return this;
    }

    public final PointerBuffer rewind() {
        Buffer rewind = this.view.rewind();
        return this;
    }

    /* JADX INFO: finally extract failed */
    public PointerBuffer slice() {
        int pointerSize = getPointerSize();
        Buffer position = this.pointers.position(pointerSize * this.view.position());
        Buffer limit = this.pointers.limit(pointerSize * this.view.limit());
        try {
            PointerBuffer newInstance = newInstance(this.pointers);
            Buffer clear = this.pointers.clear();
            return newInstance;
        } catch (Throwable th) {
            Throwable th2 = th;
            Buffer clear2 = this.pointers.clear();
            throw th2;
        }
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(48);
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(getClass().getName());
        StringBuilder append2 = sb4.append("[pos=");
        StringBuilder append3 = sb4.append(position());
        StringBuilder append4 = sb4.append(" lim=");
        StringBuilder append5 = sb4.append(limit());
        StringBuilder append6 = sb4.append(" cap=");
        StringBuilder append7 = sb4.append(capacity());
        StringBuilder append8 = sb4.append("]");
        return sb4.toString();
    }
}
