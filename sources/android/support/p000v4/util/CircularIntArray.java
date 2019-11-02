package android.support.p000v4.util;

/* renamed from: android.support.v4.util.CircularIntArray */
public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    public CircularIntArray() {
        this(8);
    }

    public CircularIntArray(int i) {
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
        this.mElements = new int[i3];
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
        int[] iArr = new int[i2];
        System.arraycopy(this.mElements, this.mHead, iArr, 0, i);
        System.arraycopy(this.mElements, 0, iArr, i, this.mHead);
        this.mElements = iArr;
        this.mHead = 0;
        this.mTail = length;
        this.mCapacityBitmask = i2 - 1;
    }

    public void addFirst(int i) {
        int i2 = i;
        this.mHead = (-1 + this.mHead) & this.mCapacityBitmask;
        this.mElements[this.mHead] = i2;
        if (this.mHead == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(int i) {
        this.mElements[this.mTail] = i;
        this.mTail = (1 + this.mTail) & this.mCapacityBitmask;
        if (this.mTail == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        this.mTail = this.mHead;
    }

    public int get(int i) {
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        int i2 = i;
        if (i2 >= 0 && i2 < size()) {
            return this.mElements[(i2 + this.mHead) & this.mCapacityBitmask];
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = arrayIndexOutOfBoundsException;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException3 = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException2;
    }

    public int getFirst() {
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        if (this.mHead != this.mTail) {
            return this.mElements[this.mHead];
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = arrayIndexOutOfBoundsException;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException3 = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException2;
    }

    public int getLast() {
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

    public int popFirst() {
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        if (this.mHead == this.mTail) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = arrayIndexOutOfBoundsException;
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException3 = new ArrayIndexOutOfBoundsException();
            throw arrayIndexOutOfBoundsException2;
        }
        int i = this.mElements[this.mHead];
        this.mHead = (1 + this.mHead) & this.mCapacityBitmask;
        return i;
    }

    public int popLast() {
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        if (this.mHead == this.mTail) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = arrayIndexOutOfBoundsException;
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException3 = new ArrayIndexOutOfBoundsException();
            throw arrayIndexOutOfBoundsException2;
        }
        int i = (-1 + this.mTail) & this.mCapacityBitmask;
        int i2 = this.mElements[i];
        this.mTail = i;
        return i2;
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
            this.mTail = (this.mTail - i2) & this.mCapacityBitmask;
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
            this.mHead = (i2 + this.mHead) & this.mCapacityBitmask;
        }
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }
}
