package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

import java.util.Arrays;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.IntList */
public final class IntList extends MutabilityControl {
    public static final IntList EMPTY;
    private int size;
    private boolean sorted;
    private int[] values;

    static {
        IntList intList;
        IntList intList2 = intList;
        IntList intList3 = new IntList(0);
        EMPTY = intList2;
        EMPTY.setImmutable();
    }

    public IntList() {
        this(4);
    }

    public IntList(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        super(true);
        try {
            this.values = new int[i2];
            this.size = 0;
            this.sorted = true;
        } catch (NegativeArraySizeException e) {
            NegativeArraySizeException negativeArraySizeException = e;
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("size < 0");
            throw illegalArgumentException2;
        }
    }

    private void growIfNeeded() {
        if (this.size == this.values.length) {
            int[] iArr = new int[(10 + ((3 * this.size) / 2))];
            System.arraycopy(this.values, 0, iArr, 0, this.size);
            this.values = iArr;
        }
    }

    public static IntList makeImmutable(int i) {
        IntList intList;
        int i2 = i;
        IntList intList2 = intList;
        IntList intList3 = new IntList(1);
        IntList intList4 = intList2;
        intList4.add(i2);
        intList4.setImmutable();
        return intList4;
    }

    public static IntList makeImmutable(int i, int i2) {
        IntList intList;
        int i3 = i;
        int i4 = i2;
        IntList intList2 = intList;
        IntList intList3 = new IntList(2);
        IntList intList4 = intList2;
        intList4.add(i3);
        intList4.add(i4);
        intList4.setImmutable();
        return intList4;
    }

    public void add(int i) {
        int i2 = i;
        boolean z = true;
        throwIfImmutable();
        growIfNeeded();
        int[] iArr = this.values;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr[i3] = i2;
        if (this.sorted && this.size > 1) {
            if (i2 < this.values[-2 + this.size]) {
                z = false;
            }
            this.sorted = z;
        }
    }

    public int binarysearch(int i) {
        int i2;
        int i3;
        int i4 = i;
        int i5 = this.size;
        if (!this.sorted) {
            i2 = 0;
            while (i2 < i5) {
                if (this.values[i2] != i4) {
                    i2++;
                }
            }
            return -i5;
        }
        int i6 = -1;
        int i7 = i5;
        while (true) {
            i2 = i7;
            if (i2 <= i6 + 1) {
                break;
            }
            int i8 = i6 + ((i2 - i6) >> 1);
            if (i4 <= this.values[i8]) {
                i3 = i6;
            } else {
                i3 = i8;
                i8 = i2;
            }
            i6 = i3;
            i7 = i8;
        }
        if (i2 == i5) {
            return -1 + (-i5);
        }
        if (i4 != this.values[i2]) {
            return -1 + (-i2);
        }
        return i2;
    }

    public boolean contains(int i) {
        return indexOf(i) >= 0;
    }

    public boolean equals(Object obj) {
        boolean z;
        Object obj2 = obj;
        if (obj2 == this) {
            z = true;
        } else {
            z = false;
            if (obj2 instanceof IntList) {
                IntList intList = (IntList) obj2;
                z = false;
                if (this.sorted == intList.sorted) {
                    z = false;
                    if (this.size == intList.size) {
                        int i = 0;
                        while (i < this.size) {
                            z = false;
                            if (this.values[i] == intList.values[i]) {
                                i++;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return z;
    }

    public int get(int i) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        IndexOutOfBoundsException indexOutOfBoundsException2;
        int i2 = i;
        if (i2 >= this.size) {
            IndexOutOfBoundsException indexOutOfBoundsException3 = indexOutOfBoundsException2;
            IndexOutOfBoundsException indexOutOfBoundsException4 = new IndexOutOfBoundsException("n >= size()");
            throw indexOutOfBoundsException3;
        }
        try {
            return this.values[i2];
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            IndexOutOfBoundsException indexOutOfBoundsException5 = indexOutOfBoundsException;
            IndexOutOfBoundsException indexOutOfBoundsException6 = new IndexOutOfBoundsException("n < 0");
            throw indexOutOfBoundsException5;
        }
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.values[i2];
        }
        return i;
    }

    public int indexOf(int i) {
        int binarysearch = binarysearch(i);
        if (binarysearch >= 0) {
            return binarysearch;
        }
        return -1;
    }

    public void insert(int i, int i2) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i3 = i;
        int i4 = i2;
        if (i3 > this.size) {
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException("n > size()");
            throw indexOutOfBoundsException2;
        }
        growIfNeeded();
        System.arraycopy(this.values, i3, this.values, i3 + 1, this.size - i3);
        this.values[i3] = i4;
        this.size = 1 + this.size;
        this.sorted = this.sorted && (i3 == 0 || i4 > this.values[i3 + -1]) && (i3 == -1 + this.size || i4 < this.values[i3 + 1]);
    }

    public IntList mutableCopy() {
        IntList intList;
        int i = this.size;
        IntList intList2 = intList;
        IntList intList3 = new IntList(i);
        IntList intList4 = intList2;
        for (int i2 = 0; i2 < i; i2++) {
            intList4.add(this.values[i2]);
        }
        return intList4;
    }

    public int pop() {
        throwIfImmutable();
        int i = get(-1 + this.size);
        this.size = -1 + this.size;
        return i;
    }

    public void pop(int i) {
        int i2 = i;
        throwIfImmutable();
        this.size -= i2;
    }

    public void removeIndex(int i) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i2 = i;
        if (i2 >= this.size) {
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException("n >= size()");
            throw indexOutOfBoundsException2;
        }
        System.arraycopy(this.values, i2 + 1, this.values, i2, -1 + (this.size - i2));
        this.size = -1 + this.size;
    }

    public void set(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i3 = i;
        int i4 = i2;
        throwIfImmutable();
        if (i3 >= this.size) {
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException("n >= size()");
            throw indexOutOfBoundsException2;
        }
        try {
            this.values[i3] = i4;
            this.sorted = false;
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            if (i3 < 0) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("n < 0");
                throw illegalArgumentException2;
            }
        }
    }

    public void shrink(int i) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("newSize < 0");
            throw illegalArgumentException3;
        } else if (i2 > this.size) {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("newSize > size");
            throw illegalArgumentException5;
        } else {
            throwIfImmutable();
            this.size = i2;
        }
    }

    public int size() {
        return this.size;
    }

    public void sort() {
        throwIfImmutable();
        if (!this.sorted) {
            Arrays.sort(this.values, 0, this.size);
            this.sorted = true;
        }
    }

    public String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(10 + (5 * this.size));
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append('{');
        for (int i = 0; i < this.size; i++) {
            if (i != 0) {
                StringBuffer append2 = stringBuffer4.append(", ");
            }
            StringBuffer append3 = stringBuffer4.append(this.values[i]);
        }
        StringBuffer append4 = stringBuffer4.append('}');
        return stringBuffer4.toString();
    }

    public int top() {
        return get(-1 + this.size);
    }
}
