package android.support.p000v4.util;

import org.objectweb.asm.signature.SignatureVisitor;

/* renamed from: android.support.v4.util.SparseArrayCompat */
public class SparseArrayCompat<E> implements Cloneable {
    private static final Object DELETED;
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        DELETED = obj2;
    }

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int i) {
        int i2 = i;
        this.mGarbage = false;
        if (i2 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_INTS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i2);
            this.mKeys = new int[idealIntArraySize];
            this.mValues = new Object[idealIntArraySize];
        }
        this.mSize = 0;
    }

    /* renamed from: gc */
    private void m3gc() {
        int i = this.mSize;
        int i2 = 0;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public void append(int i, E e) {
        int i2 = i;
        E e2 = e;
        if (this.mSize == 0 || i2 > this.mKeys[-1 + this.mSize]) {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                m3gc();
            }
            int i3 = this.mSize;
            if (i3 >= this.mKeys.length) {
                int idealIntArraySize = ContainerHelpers.idealIntArraySize(i3 + 1);
                int[] iArr = new int[idealIntArraySize];
                Object[] objArr = new Object[idealIntArraySize];
                System.arraycopy(this.mKeys, 0, iArr, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, objArr, 0, this.mValues.length);
                this.mKeys = iArr;
                this.mValues = objArr;
            }
            this.mKeys[i3] = i2;
            this.mValues[i3] = e2;
            this.mSize = i3 + 1;
            return;
        }
        put(i2, e2);
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

    public SparseArrayCompat<E> clone() {
        SparseArrayCompat<E> sparseArrayCompat = null;
        try {
            sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.mKeys = (int[]) this.mKeys.clone();
            sparseArrayCompat.mValues = (Object[]) this.mValues.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e) {
            CloneNotSupportedException cloneNotSupportedException = e;
            return sparseArrayCompat;
        }
    }

    public void delete(int i) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0 && this.mValues[binarySearch] != DELETED) {
            this.mValues[binarySearch] = DELETED;
            this.mGarbage = true;
        }
    }

    public E get(int i) {
        return get(i, null);
    }

    public E get(int i, E e) {
        E e2 = e;
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        return (binarySearch < 0 || this.mValues[binarySearch] == DELETED) ? e2 : this.mValues[binarySearch];
    }

    public int indexOfKey(int i) {
        int i2 = i;
        if (this.mGarbage) {
            m3gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, i2);
    }

    public int indexOfValue(E e) {
        E e2 = e;
        if (this.mGarbage) {
            m3gc();
        }
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == e2) {
                return i;
            }
        }
        return -1;
    }

    public int keyAt(int i) {
        int i2 = i;
        if (this.mGarbage) {
            m3gc();
        }
        return this.mKeys[i2];
    }

    public void put(int i, E e) {
        int i2 = i;
        E e2 = e;
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i2);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e2;
            return;
        }
        int i3 = binarySearch ^ -1;
        if (i3 >= this.mSize || this.mValues[i3] != DELETED) {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                m3gc();
                i3 = -1 ^ ContainerHelpers.binarySearch(this.mKeys, this.mSize, i2);
            }
            if (this.mSize >= this.mKeys.length) {
                int idealIntArraySize = ContainerHelpers.idealIntArraySize(1 + this.mSize);
                int[] iArr = new int[idealIntArraySize];
                Object[] objArr = new Object[idealIntArraySize];
                System.arraycopy(this.mKeys, 0, iArr, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, objArr, 0, this.mValues.length);
                this.mKeys = iArr;
                this.mValues = objArr;
            }
            if (this.mSize - i3 != 0) {
                System.arraycopy(this.mKeys, i3, this.mKeys, i3 + 1, this.mSize - i3);
                System.arraycopy(this.mValues, i3, this.mValues, i3 + 1, this.mSize - i3);
            }
            this.mKeys[i3] = i2;
            this.mValues[i3] = e2;
            this.mSize = 1 + this.mSize;
            return;
        }
        this.mKeys[i3] = i2;
        this.mValues[i3] = e2;
    }

    public void remove(int i) {
        delete(i);
    }

    public void removeAt(int i) {
        int i2 = i;
        if (this.mValues[i2] != DELETED) {
            this.mValues[i2] = DELETED;
            this.mGarbage = true;
        }
    }

    public void removeAtRange(int i, int i2) {
        int i3 = i;
        int min = Math.min(this.mSize, i3 + i2);
        for (int i4 = i3; i4 < min; i4++) {
            removeAt(i4);
        }
    }

    public void setValueAt(int i, E e) {
        int i2 = i;
        E e2 = e;
        if (this.mGarbage) {
            m3gc();
        }
        this.mValues[i2] = e2;
    }

    public int size() {
        if (this.mGarbage) {
            m3gc();
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
            m3gc();
        }
        return this.mValues[i2];
    }
}
