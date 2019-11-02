package org.lwjgl.util.mapped;

import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public abstract class MappedObject {
    static final boolean CHECKS = LWJGLUtil.getPrivilegedBoolean("org.lwjgl.util.mapped.Checks");
    public static int SIZEOF = -1;
    public long baseAddress;
    ByteBuffer preventGC;
    public int view;
    public long viewAddress;

    protected MappedObject() {
    }

    public static <T extends MappedObject> Iterable<T> foreach(T t) {
        T t2 = t;
        return foreach(t2, t2.capacity());
    }

    public static <T extends MappedObject> Iterable<T> foreach(T t, int i) {
        MappedForeach mappedForeach;
        MappedForeach mappedForeach2 = mappedForeach;
        MappedForeach mappedForeach3 = new MappedForeach(t, i);
        return mappedForeach2;
    }

    public static <T extends MappedObject> T malloc(int i) {
        InternalError internalError;
        int i2 = i;
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError("type not registered");
        throw internalError2;
    }

    public static <T extends MappedObject> T map(long j, int i) {
        InternalError internalError;
        long j2 = j;
        int i2 = i;
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError("type not registered");
        throw internalError2;
    }

    public static <T extends MappedObject> T map(ByteBuffer byteBuffer) {
        InternalError internalError;
        ByteBuffer byteBuffer2 = byteBuffer;
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError("type not registered");
        throw internalError2;
    }

    public final <T extends MappedObject> T[] asArray() {
        InternalError internalError;
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError("type not registered");
        throw internalError2;
    }

    public final ByteBuffer backingByteBuffer() {
        return this.preventGC;
    }

    public final int capacity() {
        InternalError internalError;
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError("type not registered");
        throw internalError2;
    }

    /* access modifiers changed from: 0000 */
    public final void checkAddress(long j) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        long j2 = j;
        long address0 = MemoryUtil.getAddress0((Buffer) this.preventGC);
        int i = (int) (j2 - address0);
        if (j2 < address0 || this.preventGC.capacity() < i + getSizeof()) {
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException(Integer.toString(i / getSizeof()));
            throw indexOutOfBoundsException2;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void checkRange(int i) {
        BufferOverflowException bufferOverflowException;
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
            throw illegalArgumentException2;
        } else if (((long) this.preventGC.capacity()) < (this.viewAddress - MemoryUtil.getAddress0((Buffer) this.preventGC)) + ((long) i2)) {
            BufferOverflowException bufferOverflowException2 = bufferOverflowException;
            BufferOverflowException bufferOverflowException3 = new BufferOverflowException();
            throw bufferOverflowException2;
        }
    }

    public final <T extends MappedObject> void copyRange(T t, int i) {
        InternalError internalError;
        T t2 = t;
        int i2 = i;
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError("type not registered");
        throw internalError2;
    }

    public final <T extends MappedObject> void copyTo(T t) {
        InternalError internalError;
        T t2 = t;
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError("type not registered");
        throw internalError2;
    }

    public final <T extends MappedObject> T dup() {
        InternalError internalError;
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError("type not registered");
        throw internalError2;
    }

    public final int getAlign() {
        InternalError internalError;
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError("type not registered");
        throw internalError2;
    }

    public final int getSizeof() {
        InternalError internalError;
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError("type not registered");
        throw internalError2;
    }

    /* access modifiers changed from: protected */
    public final long getViewAddress(int i) {
        InternalError internalError;
        int i2 = i;
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError("type not registered");
        throw internalError2;
    }

    public final void next() {
        InternalError internalError;
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError("type not registered");
        throw internalError2;
    }

    public final void runViewConstructor() {
        InternalError internalError;
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError("type not registered");
        throw internalError2;
    }

    public final void setViewAddress(long j) {
        long j2 = j;
        if (CHECKS) {
            checkAddress(j2);
        }
        this.viewAddress = j2;
    }

    public final <T extends MappedObject> T slice() {
        InternalError internalError;
        InternalError internalError2 = internalError;
        InternalError internalError3 = new InternalError("type not registered");
        throw internalError2;
    }
}
