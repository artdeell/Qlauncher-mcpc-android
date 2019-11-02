package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.Bits */
public final class Bits {
    private Bits() {
    }

    public static boolean anyInRange(int[] iArr, int i, int i2) {
        int i3 = i2;
        int findFirst = findFirst(iArr, i);
        return findFirst >= 0 && findFirst < i3;
    }

    public static int bitCount(int[] iArr) {
        int[] iArr2 = iArr;
        int i = 0;
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            i += Integer.bitCount(iArr2[i2]);
        }
        return i;
    }

    public static void clear(int[] iArr, int i) {
        int[] iArr2 = iArr;
        int i2 = i;
        int i3 = i2 >> 5;
        iArr2[i3] = iArr2[i3] & ((1 << (i2 & 31)) ^ -1);
    }

    public static int findFirst(int i, int i2) {
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i & (-1 ^ (-1 + (1 << i2))));
        if (numberOfTrailingZeros == 32) {
            numberOfTrailingZeros = -1;
        }
        return numberOfTrailingZeros;
    }

    public static int findFirst(int[] iArr, int i) {
        int[] iArr2 = iArr;
        int i2 = i;
        int length = iArr2.length;
        int i3 = i2 & 31;
        int i4 = i2 >> 5;
        while (i4 < length) {
            int i5 = iArr2[i4];
            if (i5 != 0) {
                int findFirst = findFirst(i5, i3);
                if (findFirst >= 0) {
                    return findFirst + (i4 << 5);
                }
            }
            i4++;
            i3 = 0;
        }
        return -1;
    }

    public static boolean get(int[] iArr, int i) {
        int i2 = i;
        return ((1 << (i2 & 31)) & iArr[i2 >> 5]) != 0;
    }

    public static int getMax(int[] iArr) {
        return 32 * iArr.length;
    }

    public static boolean isEmpty(int[] iArr) {
        int[] iArr2 = iArr;
        int length = iArr2.length;
        for (int i = 0; i < length; i++) {
            if (iArr2[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] makeBitSet(int i) {
        return new int[((i + 31) >> 5)];
    }

    /* renamed from: or */
    public static void m45or(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        for (int i = 0; i < iArr4.length; i++) {
            iArr3[i] = iArr3[i] | iArr4[i];
        }
    }

    public static void set(int[] iArr, int i) {
        int[] iArr2 = iArr;
        int i2 = i;
        int i3 = i2 >> 5;
        iArr2[i3] = (1 << (i2 & 31)) | iArr2[i3];
    }

    public static void set(int[] iArr, int i, boolean z) {
        int[] iArr2 = iArr;
        int i2 = i;
        int i3 = i2 >> 5;
        int i4 = 1 << (i2 & 31);
        if (z) {
            iArr2[i3] = i4 | iArr2[i3];
        } else {
            iArr2[i3] = iArr2[i3] & (i4 ^ -1);
        }
    }

    public static String toHuman(int[] iArr) {
        StringBuilder sb;
        int[] iArr2 = iArr;
        boolean z = false;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append('{');
        int length = 32 * iArr2.length;
        for (int i = 0; i < length; i++) {
            if (get(iArr2, i)) {
                if (z) {
                    StringBuilder append2 = sb4.append(',');
                }
                z = true;
                StringBuilder append3 = sb4.append(i);
            }
        }
        StringBuilder append4 = sb4.append('}');
        return sb4.toString();
    }
}
