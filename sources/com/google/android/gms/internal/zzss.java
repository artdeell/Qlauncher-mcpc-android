package com.google.android.gms.internal;

import java.util.Arrays;

public final class zzss {
    public static final Object zzbut;

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzbut = obj2;
    }

    public static boolean equals(float[] fArr, float[] fArr2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        return (fArr3 == null || fArr3.length == 0) ? fArr4 == null || fArr4.length == 0 : Arrays.equals(fArr3, fArr4);
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        return (iArr3 == null || iArr3.length == 0) ? iArr4 == null || iArr4.length == 0 : Arrays.equals(iArr3, iArr4);
    }

    public static boolean equals(long[] jArr, long[] jArr2) {
        long[] jArr3 = jArr;
        long[] jArr4 = jArr2;
        return (jArr3 == null || jArr3.length == 0) ? jArr4 == null || jArr4.length == 0 : Arrays.equals(jArr3, jArr4);
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        boolean z;
        Object[] objArr3 = objArr;
        Object[] objArr4 = objArr2;
        int length = objArr3 == null ? 0 : objArr3.length;
        int length2 = objArr4 == null ? 0 : objArr4.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length || objArr3[i2] != null) {
                int i3 = i;
                while (i3 < length2 && objArr4[i3] == null) {
                    i3++;
                }
                boolean z2 = i2 >= length;
                boolean z3 = i3 >= length2;
                if (z2 && z3) {
                    z = true;
                    break;
                }
                z = false;
                if (z2 != z3) {
                    break;
                }
                z = false;
                if (!objArr3[i2].equals(objArr4[i3])) {
                    break;
                }
                i = i3 + 1;
                i2++;
            } else {
                i2++;
            }
        }
        return z;
    }

    public static int hashCode(float[] fArr) {
        float[] fArr2 = fArr;
        if (fArr2 == null || fArr2.length == 0) {
            return 0;
        }
        return Arrays.hashCode(fArr2);
    }

    public static int hashCode(int[] iArr) {
        int[] iArr2 = iArr;
        if (iArr2 == null || iArr2.length == 0) {
            return 0;
        }
        return Arrays.hashCode(iArr2);
    }

    public static int hashCode(long[] jArr) {
        long[] jArr2 = jArr;
        if (jArr2 == null || jArr2.length == 0) {
            return 0;
        }
        return Arrays.hashCode(jArr2);
    }

    public static int hashCode(Object[] objArr) {
        Object[] objArr2 = objArr;
        int i = 0;
        int length = objArr2 == null ? 0 : objArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = objArr2[i2];
            if (obj != null) {
                i = (i * 31) + obj.hashCode();
            }
        }
        return i;
    }

    public static int zza(byte[][] bArr) {
        byte[][] bArr2 = bArr;
        int i = 0;
        int length = bArr2 == null ? 0 : bArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            byte[] bArr3 = bArr2[i2];
            if (bArr3 != null) {
                i = (i * 31) + Arrays.hashCode(bArr3);
            }
        }
        return i;
    }

    public static void zza(zzso zzso, zzso zzso2) {
        zzso zzso3 = zzso;
        zzso zzso4 = zzso2;
        if (zzso3.zzbuj != null) {
            zzso4.zzbuj = zzso3.zzbuj.clone();
        }
    }

    public static boolean zza(byte[][] bArr, byte[][] bArr2) {
        boolean z;
        byte[][] bArr3 = bArr;
        byte[][] bArr4 = bArr2;
        int length = bArr3 == null ? 0 : bArr3.length;
        int length2 = bArr4 == null ? 0 : bArr4.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length || bArr3[i2] != null) {
                int i3 = i;
                while (i3 < length2 && bArr4[i3] == null) {
                    i3++;
                }
                boolean z2 = i2 >= length;
                boolean z3 = i3 >= length2;
                if (z2 && z3) {
                    z = true;
                    break;
                }
                z = false;
                if (z2 != z3) {
                    break;
                }
                z = false;
                if (!Arrays.equals(bArr3[i2], bArr4[i3])) {
                    break;
                }
                i = i3 + 1;
                i2++;
            } else {
                i2++;
            }
        }
        return z;
    }
}
