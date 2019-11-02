package android.support.p000v4.util;

import org.objectweb.asm.signature.SignatureVisitor;

/* renamed from: android.support.v4.util.LongSparseArray */
public class LongSparseArray<E> implements Cloneable {
    private static final Object DELETED;
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        DELETED = obj2;
    }

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int i) {
        int i2 = i;
        this.mGarbage = false;
        if (i2 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_LONGS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i2);
            this.mKeys = new long[idealLongArraySize];
            this.mValues = new Object[idealLongArraySize];
        }
        this.mSize = 0;
    }

    /* renamed from: gc */
    private void m2gc() {
        int i = this.mSize;
        int i2 = 0;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public void append(long j, E e) {
        long j2 = j;
        E e2 = e;
        if (this.mSize == 0 || j2 > this.mKeys[-1 + this.mSize]) {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                m2gc();
            }
            int i = this.mSize;
            if (i >= this.mKeys.length) {
                int idealLongArraySize = ContainerHelpers.idealLongArraySize(i + 1);
                long[] jArr = new long[idealLongArraySize];
                Object[] objArr = new Object[idealLongArraySize];
                System.arraycopy(this.mKeys, 0, jArr, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, objArr, 0, this.mValues.length);
                this.mKeys = jArr;
                this.mValues = objArr;
            }
            this.mKeys[i] = j2;
            this.mValues[i] = e2;
            this.mSize = i + 1;
            return;
        }
        put(j2, e2);
    }

    public void clear() {
        int i = this.mSize;
        Object[] objArr = this.mValues;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public LongSparseArray<E> clone() {
        LongSparseArray<E> longSparseArray = null;
        try {
            longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.mKeys = (long[]) this.mKeys.clone();
            longSparseArray.mValues = (Object[]) this.mValues.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e) {
            CloneNotSupportedException cloneNotSupportedException = e;
            return longSparseArray;
        }
    }

    public void delete(long j) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        if (binarySearch >= 0 && this.mValues[binarySearch] != DELETED) {
            this.mValues[binarySearch] = DELETED;
            this.mGarbage = true;
        }
    }

    public E get(long j) {
        return get(j, null);
    }

    public E get(long j, E e) {
        E e2 = e;
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        return (binarySearch < 0 || this.mValues[binarySearch] == DELETED) ? e2 : this.mValues[binarySearch];
    }

    public int indexOfKey(long j) {
        long j2 = j;
        if (this.mGarbage) {
            m2gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
    }

    public int indexOfValue(E e) {
        E e2 = e;
        if (this.mGarbage) {
            m2gc();
        }
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == e2) {
                return i;
            }
        }
        return -1;
    }

    public long keyAt(int i) {
        int i2 = i;
        if (this.mGarbage) {
            m2gc();
        }
        return this.mKeys[i2];
    }

    public void put(long j, E e) {
        long j2 = j;
        E e2 = e;
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e2;
            return;
        }
        int i = binarySearch ^ -1;
        if (i >= this.mSize || this.mValues[i] != DELETED) {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                m2gc();
                i = -1 ^ ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
            }
            if (this.mSize >= this.mKeys.length) {
                int idealLongArraySize = ContainerHelpers.idealLongArraySize(1 + this.mSize);
                long[] jArr = new long[idealLongArraySize];
                Object[] objArr = new Object[idealLongArraySize];
                System.arraycopy(this.mKeys, 0, jArr, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, objArr, 0, this.mValues.length);
                this.mKeys = jArr;
                this.mValues = objArr;
            }
            if (this.mSize - i != 0) {
                System.arraycopy(this.mKeys, i, this.mKeys, i + 1, this.mSize - i);
                System.arraycopy(this.mValues, i, this.mValues, i + 1, this.mSize - i);
            }
            this.mKeys[i] = j2;
            this.mValues[i] = e2;
            this.mSize = 1 + this.mSize;
            return;
        }
        this.mKeys[i] = j2;
        this.mValues[i] = e2;
    }

    public void remove(long j) {
        delete(j);
    }

    public void removeAt(int i) {
        int i2 = i;
        if (this.mValues[i2] != DELETED) {
            this.mValues[i2] = DELETED;
            this.mGarbage = true;
        }
    }

    public void setValueAt(int i, E e) {
        int i2 = i;
        E e2 = e;
        if (this.mGarbage) {
            m2gc();
        }
        this.mValues[i2] = e2;
    }

    public int size() {
        if (this.mGarbage) {
            m2gc();
        }
        return this.mSize;
    }

    public String toString() {
        StringBuilder sb;
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(28 * this.mSize);
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                StringBuilder append2 = sb4.append(", ");
            }
            StringBuilder append3 = sb4.append(keyAt(i));
            StringBuilder append4 = sb4.append(SignatureVisitor.INSTANCEOF);
            Object valueAt = valueAt(i);
            if (valueAt != this) {
                StringBuilder append5 = sb4.append(valueAt);
            } else {
                StringBuilder append6 = sb4.append("(this Map)");
            }
        }
        StringBuilder append7 = sb4.append('}');
        return sb4.toString();
    }

    public E valueAt(int i) {
        int i2 = i;
        if (this.mGarbage) {
            m2gc();
        }
        return this.mValues[i2];
    }
}
