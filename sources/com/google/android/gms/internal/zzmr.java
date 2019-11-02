package com.google.android.gms.internal;

import android.support.p000v4.util.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzmr {
    public static <T> Set<T> zzA(T t) {
        return Collections.singleton(t);
    }

    public static <K, V> Map<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        ArrayMap arrayMap;
        K k7 = k;
        V v7 = v;
        K k8 = k2;
        V v8 = v2;
        K k9 = k3;
        V v9 = v3;
        K k10 = k4;
        V v10 = v4;
        K k11 = k5;
        V v11 = v5;
        K k12 = k6;
        V v12 = v6;
        ArrayMap arrayMap2 = arrayMap;
        ArrayMap arrayMap3 = new ArrayMap(6);
        ArrayMap arrayMap4 = arrayMap2;
        Object put = arrayMap4.put(k7, v7);
        Object put2 = arrayMap4.put(k8, v8);
        Object put3 = arrayMap4.put(k9, v9);
        Object put4 = arrayMap4.put(k10, v10);
        Object put5 = arrayMap4.put(k11, v11);
        Object put6 = arrayMap4.put(k12, v12);
        return Collections.unmodifiableMap(arrayMap4);
    }

    public static <T> Set<T> zza(T t, T t2, T t3) {
        zzmm zzmm;
        T t4 = t;
        T t5 = t2;
        T t6 = t3;
        zzmm zzmm2 = zzmm;
        zzmm zzmm3 = new zzmm(3);
        zzmm zzmm4 = zzmm2;
        boolean add = zzmm4.add(t4);
        boolean add2 = zzmm4.add(t5);
        boolean add3 = zzmm4.add(t6);
        return Collections.unmodifiableSet(zzmm4);
    }

    public static <T> Set<T> zza(T t, T t2, T t3, T t4) {
        zzmm zzmm;
        T t5 = t;
        T t6 = t2;
        T t7 = t3;
        T t8 = t4;
        zzmm zzmm2 = zzmm;
        zzmm zzmm3 = new zzmm(4);
        zzmm zzmm4 = zzmm2;
        boolean add = zzmm4.add(t5);
        boolean add2 = zzmm4.add(t6);
        boolean add3 = zzmm4.add(t7);
        boolean add4 = zzmm4.add(t8);
        return Collections.unmodifiableSet(zzmm4);
    }

    public static <T> List<T> zzc(T t, T t2) {
        ArrayList arrayList;
        T t3 = t;
        T t4 = t2;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(2);
        ArrayList arrayList4 = arrayList2;
        boolean add = arrayList4.add(t3);
        boolean add2 = arrayList4.add(t4);
        return Collections.unmodifiableList(arrayList4);
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r2v19, types: [java.util.Set] */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> java.util.Set<T> zzc(T... r8) {
        /*
            r0 = r8
            r2 = r0
            int r2 = r2.length
            switch(r2) {
                case 0: goto L_0x0021;
                case 1: goto L_0x0027;
                case 2: goto L_0x0031;
                case 3: goto L_0x003f;
                case 4: goto L_0x0051;
                default: goto L_0x0006;
            }
        L_0x0006:
            r2 = r0
            int r2 = r2.length
            r3 = 32
            if (r2 > r3) goto L_0x0067
            com.google.android.gms.internal.zzmm r2 = new com.google.android.gms.internal.zzmm
            r7 = r2
            r2 = r7
            r3 = r7
            r4 = r0
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.<init>(r4)
            r1 = r2
        L_0x001a:
            r2 = r1
            java.util.Set r2 = java.util.Collections.unmodifiableSet(r2)
            r0 = r2
        L_0x0020:
            return r0
        L_0x0021:
            java.util.Set r2 = zzsb()
            r0 = r2
            goto L_0x0020
        L_0x0027:
            r2 = r0
            r3 = 0
            r2 = r2[r3]
            java.util.Set r2 = zzA(r2)
            r0 = r2
            goto L_0x0020
        L_0x0031:
            r2 = r0
            r3 = 0
            r2 = r2[r3]
            r3 = r0
            r4 = 1
            r3 = r3[r4]
            java.util.Set r2 = zzd(r2, r3)
            r0 = r2
            goto L_0x0020
        L_0x003f:
            r2 = r0
            r3 = 0
            r2 = r2[r3]
            r3 = r0
            r4 = 1
            r3 = r3[r4]
            r4 = r0
            r5 = 2
            r4 = r4[r5]
            java.util.Set r2 = zza(r2, r3, r4)
            r0 = r2
            goto L_0x0020
        L_0x0051:
            r2 = r0
            r3 = 0
            r2 = r2[r3]
            r3 = r0
            r4 = 1
            r3 = r3[r4]
            r4 = r0
            r5 = 2
            r4 = r4[r5]
            r5 = r0
            r6 = 3
            r5 = r5[r6]
            java.util.Set r2 = zza(r2, r3, r4, r5)
            r0 = r2
            goto L_0x0020
        L_0x0067:
            java.util.HashSet r2 = new java.util.HashSet
            r7 = r2
            r2 = r7
            r3 = r7
            r4 = r0
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.<init>(r4)
            r1 = r2
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzmr.zzc(java.lang.Object[]):java.util.Set");
    }

    public static <T> Set<T> zzd(T t, T t2) {
        zzmm zzmm;
        T t3 = t;
        T t4 = t2;
        zzmm zzmm2 = zzmm;
        zzmm zzmm3 = new zzmm(2);
        zzmm zzmm4 = zzmm2;
        boolean add = zzmm4.add(t3);
        boolean add2 = zzmm4.add(t4);
        return Collections.unmodifiableSet(zzmm4);
    }

    public static <T> Set<T> zzsb() {
        return Collections.emptySet();
    }
}
