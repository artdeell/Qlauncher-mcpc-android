package android.support.p000v4.util;

import java.util.Map;
import org.objectweb.asm.signature.SignatureVisitor;

/* renamed from: android.support.v4.util.SimpleArrayMap */
public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    public SimpleArrayMap(int i) {
        int i2 = i;
        if (i2 == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(i2);
        }
        this.mSize = 0;
    }

    public SimpleArrayMap(SimpleArrayMap simpleArrayMap) {
        SimpleArrayMap simpleArrayMap2 = simpleArrayMap;
        this();
        if (simpleArrayMap2 != null) {
            putAll(simpleArrayMap2);
        }
    }

    private void allocArrays(int i) {
        int i2 = i;
        if (i2 == 8) {
            synchronized (ArrayMap.class) {
                try {
                    if (mTwiceBaseCache != null) {
                        Object[] objArr = mTwiceBaseCache;
                        this.mArray = objArr;
                        mTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        mTwiceBaseCacheSize = -1 + mTwiceBaseCacheSize;
                        return;
                    }
                } catch (Throwable th) {
                    while (true) {
                        Throwable th2 = th;
                        Class<ArrayMap> cls = ArrayMap.class;
                        throw th2;
                    }
                }
            }
        } else if (i2 == 4) {
            synchronized (ArrayMap.class) {
                try {
                    if (mBaseCache != null) {
                        Object[] objArr2 = mBaseCache;
                        this.mArray = objArr2;
                        mBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        mBaseCacheSize = -1 + mBaseCacheSize;
                        return;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    Class<ArrayMap> cls2 = ArrayMap.class;
                    throw th4;
                }
            }
        }
        this.mHashes = new int[i2];
        this.mArray = new Object[(i2 << 1)];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i) {
        int[] iArr2 = iArr;
        Object[] objArr2 = objArr;
        int i2 = i;
        if (iArr2.length == 8) {
            synchronized (ArrayMap.class) {
                try {
                    if (mTwiceBaseCacheSize < 10) {
                        objArr2[0] = mTwiceBaseCache;
                        objArr2[1] = iArr2;
                        for (int i3 = -1 + (i2 << 1); i3 >= 2; i3--) {
                            objArr2[i3] = 0;
                        }
                        mTwiceBaseCache = objArr2;
                        mTwiceBaseCacheSize = 1 + mTwiceBaseCacheSize;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Class<ArrayMap> cls = ArrayMap.class;
                    throw th2;
                }
            }
        } else if (iArr2.length == 4) {
            synchronized (ArrayMap.class) {
                try {
                    if (mBaseCacheSize < 10) {
                        objArr2[0] = mBaseCache;
                        objArr2[1] = iArr2;
                        for (int i4 = -1 + (i2 << 1); i4 >= 2; i4--) {
                            objArr2[i4] = 0;
                        }
                        mBaseCache = objArr2;
                        mBaseCacheSize = 1 + mBaseCacheSize;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    Class<ArrayMap> cls2 = ArrayMap.class;
                    throw th4;
                }
            }
        }
    }

    public void clear() {
        if (this.mSize != 0) {
            freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public void ensureCapacity(int i) {
        int i2 = i;
        if (this.mHashes.length < i2) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i2);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, this.mSize);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize << 1);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this != obj2) {
            if (!(obj2 instanceof Map)) {
                return false;
            }
            Map map = (Map) obj2;
            if (size() != map.size()) {
                return false;
            }
            int i = 0;
            while (i < this.mSize) {
                try {
                    Object keyAt = keyAt(i);
                    Object valueAt = valueAt(i);
                    Object obj3 = map.get(keyAt);
                    if (valueAt == null) {
                        if (obj3 != null || !map.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj3)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e) {
                    NullPointerException nullPointerException = e;
                    return false;
                } catch (ClassCastException e2) {
                    ClassCastException classCastException = e2;
                    return false;
                }
            }
        }
        return true;
    }

    public V get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return this.mArray[1 + (indexOfKey << 1)];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        int i4 = this.mSize;
        while (i2 < i4) {
            Object obj = objArr[i3];
            i += (obj == null ? 0 : obj.hashCode()) ^ iArr[i2];
            i2++;
            i3 += 2;
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    public int indexOf(Object obj, int i) {
        int binarySearch;
        Object obj2 = obj;
        int i2 = i;
        int i3 = this.mSize;
        if (i3 == 0) {
            binarySearch = -1;
        } else {
            binarySearch = ContainerHelpers.binarySearch(this.mHashes, i3, i2);
            if (binarySearch >= 0 && !obj2.equals(this.mArray[binarySearch << 1])) {
                int i4 = binarySearch + 1;
                while (i4 < i3 && this.mHashes[i4] == i2) {
                    if (obj2.equals(this.mArray[i4 << 1])) {
                        return i4;
                    }
                    i4++;
                }
                int i5 = binarySearch - 1;
                while (i5 >= 0 && this.mHashes[i5] == i2) {
                    if (obj2.equals(this.mArray[i5 << 1])) {
                        return i5;
                    }
                    i5--;
                }
                return i4 ^ -1;
            }
        }
        return binarySearch;
    }

    public int indexOfKey(Object obj) {
        Object obj2 = obj;
        return obj2 == null ? indexOfNull() : indexOf(obj2, obj2.hashCode());
    }

    /* access modifiers changed from: 0000 */
    public int indexOfNull() {
        int binarySearch;
        int i = this.mSize;
        if (i == 0) {
            binarySearch = -1;
        } else {
            binarySearch = ContainerHelpers.binarySearch(this.mHashes, i, 0);
            if (binarySearch >= 0 && this.mArray[binarySearch << 1] != null) {
                int i2 = binarySearch + 1;
                while (i2 < i && this.mHashes[i2] == 0) {
                    if (this.mArray[i2 << 1] == null) {
                        return i2;
                    }
                    i2++;
                }
                int i3 = binarySearch - 1;
                while (i3 >= 0 && this.mHashes[i3] == 0) {
                    if (this.mArray[i3 << 1] == null) {
                        return i3;
                    }
                    i3--;
                }
                return i2 ^ -1;
            }
        }
        return binarySearch;
    }

    /* access modifiers changed from: 0000 */
    public int indexOfValue(Object obj) {
        Object obj2 = obj;
        int i = 2 * this.mSize;
        Object[] objArr = this.mArray;
        if (obj2 == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
        } else {
            for (int i3 = 1; i3 < i; i3 += 2) {
                if (obj2.equals(objArr[i3])) {
                    return i3 >> 1;
                }
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public K keyAt(int i) {
        return this.mArray[i << 1];
    }

    public V put(K k, V v) {
        int hashCode;
        int indexOf;
        K k2 = k;
        V v2 = v;
        int i = 8;
        if (k2 == null) {
            hashCode = 0;
            indexOf = indexOfNull();
        } else {
            hashCode = k2.hashCode();
            indexOf = indexOf(k2, hashCode);
        }
        if (indexOf >= 0) {
            int i2 = 1 + (indexOf << 1);
            Object obj = this.mArray[i2];
            this.mArray[i2] = v2;
            return obj;
        }
        int i3 = indexOf ^ -1;
        if (this.mSize >= this.mHashes.length) {
            if (this.mSize >= 8) {
                i = this.mSize + (this.mSize >> 1);
            } else if (this.mSize < 4) {
                i = 4;
            }
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i);
            if (this.mHashes.length > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        if (i3 < this.mSize) {
            System.arraycopy(this.mHashes, i3, this.mHashes, i3 + 1, this.mSize - i3);
            System.arraycopy(this.mArray, i3 << 1, this.mArray, (i3 + 1) << 1, (this.mSize - i3) << 1);
        }
        this.mHashes[i3] = hashCode;
        this.mArray[i3 << 1] = k2;
        this.mArray[1 + (i3 << 1)] = v2;
        this.mSize = 1 + this.mSize;
        return null;
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        SimpleArrayMap<? extends K, ? extends V> simpleArrayMap2 = simpleArrayMap;
        int i = simpleArrayMap2.mSize;
        ensureCapacity(i + this.mSize);
        if (this.mSize != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                Object put = put(simpleArrayMap2.keyAt(i2), simpleArrayMap2.valueAt(i2));
            }
        } else if (i > 0) {
            System.arraycopy(simpleArrayMap2.mHashes, 0, this.mHashes, 0, i);
            System.arraycopy(simpleArrayMap2.mArray, 0, this.mArray, 0, i << 1);
            this.mSize = i;
        }
    }

    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i) {
        int i2 = i;
        int i3 = 8;
        Object obj = this.mArray[1 + (i2 << 1)];
        if (this.mSize <= 1) {
            freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
        } else if (this.mHashes.length <= 8 || this.mSize >= this.mHashes.length / 3) {
            this.mSize = -1 + this.mSize;
            if (i2 < this.mSize) {
                System.arraycopy(this.mHashes, i2 + 1, this.mHashes, i2, this.mSize - i2);
                System.arraycopy(this.mArray, (i2 + 1) << 1, this.mArray, i2 << 1, (this.mSize - i2) << 1);
            }
            this.mArray[this.mSize << 1] = null;
            this.mArray[1 + (this.mSize << 1)] = null;
            return obj;
        } else {
            if (this.mSize > 8) {
                i3 = this.mSize + (this.mSize >> 1);
            }
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i3);
            this.mSize = -1 + this.mSize;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i2);
                System.arraycopy(objArr, 0, this.mArray, 0, i2 << 1);
            }
            if (i2 < this.mSize) {
                System.arraycopy(iArr, i2 + 1, this.mHashes, i2, this.mSize - i2);
                System.arraycopy(objArr, (i2 + 1) << 1, this.mArray, i2 << 1, (this.mSize - i2) << 1);
                return obj;
            }
        }
        return obj;
    }

    public V setValueAt(int i, V v) {
        V v2 = v;
        int i2 = 1 + (i << 1);
        Object obj = this.mArray[i2];
        this.mArray[i2] = v2;
        return obj;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        StringBuilder sb;
        if (isEmpty()) {
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
            Object keyAt = keyAt(i);
            if (keyAt != this) {
                StringBuilder append3 = sb4.append(keyAt);
            } else {
                StringBuilder append4 = sb4.append("(this Map)");
            }
            StringBuilder append5 = sb4.append(SignatureVisitor.INSTANCEOF);
            Object valueAt = valueAt(i);
            if (valueAt != this) {
                StringBuilder append6 = sb4.append(valueAt);
            } else {
                StringBuilder append7 = sb4.append("(this Map)");
            }
        }
        StringBuilder append8 = sb4.append('}');
        return sb4.toString();
    }

    public V valueAt(int i) {
        return this.mArray[1 + (i << 1)];
    }
}
