package android.support.p000v4.util;

/* renamed from: android.support.v4.util.CircularArray */
public final class CircularArray<E> {
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    public CircularArray(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 <= 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("capacity must be positive");
            throw illegalArgumentException2;
        }
        int i3 = i2;
        if (Integer.bitCount(i2) != 1) {
            i3 = 1 << (1 + Integer.highestOneBit(i2));
        }
        this.mCapacityBitmask = i3 - 1;
        this.mElements = (Object[]) new Object[i3];
    }

    private void doubleCapacity() {
        RuntimeException runtimeException;
        int length = this.mElements.length;
        int i = length - this.mHead;
        int i2 = length << 1;
        if (i2 < 0) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("Max array capacity exceeded");
            throw runtimeException2;
        }
        Object[] objArr = new Object[i2];
        System.arraycopy(this.mElements, this.mHead, objArr, 0, i);
        System.arraycopy(this.mElements, 0, objArr, i, this.mHead);
        this.mElements = objArr;
        this.mHead = 0;
        this.mTail = length;
        this.mCapacityBitmask = i2 - 1;
    }

    public void addFirst(E e) {
        E e2 = e;
        this.mHead = (-1 + this.mHead) & this.mCapacityBitmask;
        this.mElements[this.mHead] = e2;
        if (this.mHead == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(E e) {
        this.mElements[this.mTail] = e;
        this.mTail = (1 + this.mTail) & this.mCapacityBitmask;
        if (this.mTail == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int i) {
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        int i2 = i;
        if (i2 >= 0 && i2 < size()) {
            return this.mElements[(i2 + this.mHead) & this.mCapacityBitmask];
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = arrayIndexOutOfBoundsException;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException3 = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException2;
    }

    public E getFirst() {
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        if (this.mHead != this.mTail) {
            return this.mElements[this.mHead];
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = arrayIndexOutOfBoundsException;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException3 = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException2;
    }

    public E getLast() {
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        if (this.mHead != this.mTail) {
            return this.mElements[(-1 + this.mTail) & this.mCapacityBitmask];
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = arrayIndexOutOfBoundsException;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException3 = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException2;
    }

    public boolean isEmpty() {
        return this.mHead == this.mTail;
    }

    public E popFirst() {
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        if (this.mHead == this.mTail) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = arrayIndexOutOfBoundsException;
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException3 = new ArrayIndexOutOfBoundsException();
            throw arrayIndexOutOfBoundsException2;
        }
        E e = this.mElements[this.mHead];
        this.mElements[this.mHead] = null;
        this.mHead = (1 + this.mHead) & this.mCapacityBitmask;
        return e;
    }

    public E popLast() {
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        if (this.mHead == this.mTail) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = arrayIndexOutOfBoundsException;
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException3 = new ArrayIndexOutOfBoundsException();
            throw arrayIndexOutOfBoundsException2;
        }
        int i = (-1 + this.mTail) & this.mCapacityBitmask;
        E e = this.mElements[i];
        this.mElements[i] = null;
        this.mTail = i;
        return e;
    }

    public void removeFromEnd(int i) {
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        int i2 = i;
        if (i2 > 0) {
            if (i2 > size()) {
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = arrayIndexOutOfBoundsException;
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException3 = new ArrayIndexOutOfBoundsException();
                throw arrayIndexOutOfBoundsException2;
            }
            int i3 = 0;
            if (i2 < this.mTail) {
                i3 = this.mTail - i2;
            }
            for (int i4 = i3; i4 < this.mTail; i4++) {
                this.mElements[i4] = null;
            }
            int i5 = this.mTail - i3;
            int i6 = i2 - i5;
            this.mTail -= i5;
            if (i6 > 0) {
                this.mTail = this.mElements.length;
                int i7 = this.mTail - i6;
                for (int i8 = i7; i8 < this.mTail; i8++) {
                    this.mElements[i8] = null;
                }
                this.mTail = i7;
            }
        }
    }

    public void removeFromStart(int i) {
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        int i2 = i;
        if (i2 > 0) {
            if (i2 > size()) {
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = arrayIndexOutOfBoundsException;
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException3 = new ArrayIndexOutOfBoundsException();
                throw arrayIndexOutOfBoundsException2;
            }
            int length = this.mElements.length;
            if (i2 < length - this.mHead) {
                length = i2 + this.mHead;
            }
            for (int i3 = this.mHead; i3 < length; i3++) {
                this.mElements[i3] = null;
            }
            int i4 = length - this.mHead;
            int i5 = i2 - i4;
            this.mHead = (i4 + this.mHead) & this.mCapacityBitmask;
            if (i5 > 0) {
                for (int i6 = 0; i6 < i5; i6++) {
                    this.mElements[i6] = null;
                }
                this.mHead = i5;
            }
        }
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }
}
