package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;

public final class zzmn {
    public static <T> int zza(T[] tArr, T t) {
        int i;
        T[] tArr2 = tArr;
        T t2 = t;
        int i2 = 0;
        if (tArr2 != null) {
            i = tArr2.length;
        } else {
            i = 0;
            i2 = 0;
        }
        while (i2 < i) {
            if (zzw.equal(tArr2[i2], t2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static void zza(StringBuilder sb, double[] dArr) {
        StringBuilder sb2 = sb;
        double[] dArr2 = dArr;
        int length = dArr2.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                StringBuilder append = sb2.append(",");
            }
            StringBuilder append2 = sb2.append(Double.toString(dArr2[i]));
        }
    }

    public static void zza(StringBuilder sb, float[] fArr) {
        StringBuilder sb2 = sb;
        float[] fArr2 = fArr;
        int length = fArr2.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                StringBuilder append = sb2.append(",");
            }
            StringBuilder append2 = sb2.append(Float.toString(fArr2[i]));
        }
    }

    public static void zza(StringBuilder sb, int[] iArr) {
        StringBuilder sb2 = sb;
        int[] iArr2 = iArr;
        int length = iArr2.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                StringBuilder append = sb2.append(",");
            }
            StringBuilder append2 = sb2.append(Integer.toString(iArr2[i]));
        }
    }

    public static void zza(StringBuilder sb, long[] jArr) {
        StringBuilder sb2 = sb;
        long[] jArr2 = jArr;
        int length = jArr2.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                StringBuilder append = sb2.append(",");
            }
            StringBuilder append2 = sb2.append(Long.toString(jArr2[i]));
        }
    }

    public static <T> void zza(StringBuilder sb, T[] tArr) {
        StringBuilder sb2 = sb;
        T[] tArr2 = tArr;
        int length = tArr2.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                StringBuilder append = sb2.append(",");
            }
            StringBuilder append2 = sb2.append(tArr2[i].toString());
        }
    }

    public static void zza(StringBuilder sb, String[] strArr) {
        StringBuilder sb2 = sb;
        String[] strArr2 = strArr;
        int length = strArr2.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                StringBuilder append = sb2.append(",");
            }
            StringBuilder append2 = sb2.append("\"").append(strArr2[i]).append("\"");
        }
    }

    public static void zza(StringBuilder sb, boolean[] zArr) {
        StringBuilder sb2 = sb;
        boolean[] zArr2 = zArr;
        int length = zArr2.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                StringBuilder append = sb2.append(",");
            }
            StringBuilder append2 = sb2.append(Boolean.toString(zArr2[i]));
        }
    }

    public static Integer[] zza(int[] iArr) {
        Integer[] numArr;
        int[] iArr2 = iArr;
        if (iArr2 == null) {
            numArr = null;
        } else {
            int length = iArr2.length;
            numArr = new Integer[length];
            for (int i = 0; i < length; i++) {
                numArr[i] = Integer.valueOf(iArr2[i]);
            }
        }
        return numArr;
    }

    public static <T> ArrayList<T> zzb(T[] tArr) {
        ArrayList arrayList;
        T[] tArr2 = tArr;
        int length = tArr2.length;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(length);
        ArrayList arrayList4 = arrayList2;
        for (int i = 0; i < length; i++) {
            boolean add = arrayList4.add(tArr2[i]);
        }
        return arrayList4;
    }

    public static <T> boolean zzb(T[] tArr, T t) {
        return zza(tArr, t) >= 0;
    }

    public static <T> ArrayList<T> zzsa() {
        ArrayList<T> arrayList;
        ArrayList<T> arrayList2 = arrayList;
        ArrayList<T> arrayList3 = new ArrayList<>();
        return arrayList2;
    }
}
