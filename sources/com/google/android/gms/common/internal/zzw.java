package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzw {

    public static final class zza {
        private final Object zzML;
        private final List<String> zzamp;

        private zza(Object obj) {
            ArrayList arrayList;
            this.zzML = zzx.zzz(obj);
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            this.zzamp = arrayList2;
        }

        /* synthetic */ zza(Object obj, C02501 r7) {
            C02501 r2 = r7;
            this(obj);
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder(100);
            StringBuilder append = sb2.append(this.zzML.getClass().getSimpleName()).append('{');
            int size = this.zzamp.size();
            for (int i = 0; i < size; i++) {
                StringBuilder append2 = append.append((String) this.zzamp.get(i));
                if (i < size - 1) {
                    StringBuilder append3 = append.append(", ");
                }
            }
            return append.append('}').toString();
        }

        public zza zzg(String str, Object obj) {
            StringBuilder sb;
            String str2 = str;
            Object obj2 = obj;
            List<String> list = this.zzamp;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            boolean add = list.add(sb2.append((String) zzx.zzz(str2)).append("=").append(String.valueOf(obj2)).toString());
            return this;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        Object obj3 = obj;
        Object obj4 = obj2;
        return obj3 == obj4 || (obj3 != null && obj3.equals(obj4));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static zza zzy(Object obj) {
        zza zza2;
        zza zza3 = zza2;
        zza zza4 = new zza(obj, null);
        return zza3;
    }
}
