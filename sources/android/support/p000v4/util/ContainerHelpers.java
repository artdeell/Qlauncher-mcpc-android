package android.support.p000v4.util;

/* renamed from: android.support.v4.util.ContainerHelpers */
class ContainerHelpers {
    static final int[] EMPTY_INTS = new int[0];
    static final long[] EMPTY_LONGS = new long[0];
    static final Object[] EMPTY_OBJECTS = new Object[0];

    ContainerHelpers() {
    }

    static int binarySearch(int[] iArr, int i, int i2) {
        int i3;
        int[] iArr2 = iArr;
        int i4 = i2;
        int i5 = 0;
        int i6 = i - 1;
        while (true) {
            if (i5 > i6) {
                i3 = i5 ^ -1;
                break;
            }
            i3 = (i5 + i6) >>> 1;
            int i7 = iArr2[i3];
            if (i7 >= i4) {
                if (i7 <= i4) {
                    break;
                }
                i6 = i3 - 1;
            } else {
                i5 = i3 + 1;
            }
        }
        return i3;
    }

    static int binarySearch(long[] jArr, int i, long j) {
        int i2;
        long[] jArr2 = jArr;
        long j2 = j;
        int i3 = 0;
        int i4 = i - 1;
        while (true) {
            if (i3 > i4) {
                i2 = i3 ^ -1;
                break;
            }
            i2 = (i3 + i4) >>> 1;
            long j3 = jArr2[i2];
            if (j3 >= j2) {
                if (j3 <= j2) {
                    break;
                }
                i4 = i2 - 1;
            } else {
                i3 = i2 + 1;
            }
        }
        return i2;
    }

    public static boolean equal(Object obj, Object obj2) {
        Object obj3 = obj;
        Object obj4 = obj2;
        return obj3 == obj4 || (obj3 != null && obj3.equals(obj4));
    }

    public static int idealByteArraySize(int i) {
        int i2 = i;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            } else if (i2 <= -12 + (1 << i3)) {
                i2 = -12 + (1 << i3);
                break;
            } else {
                i3++;
            }
        }
        return i2;
    }

    public static int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    public static int idealLongArraySize(int i) {
        return idealByteArraySize(i * 8) / 8;
    }
}
