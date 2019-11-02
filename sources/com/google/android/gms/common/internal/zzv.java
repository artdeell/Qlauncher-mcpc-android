package com.google.android.gms.common.internal;

import java.util.Iterator;

public class zzv {
    private final String separator;

    private zzv(String str) {
        this.separator = str;
    }

    public static zzv zzcL(String str) {
        zzv zzv;
        zzv zzv2 = zzv;
        zzv zzv3 = new zzv(str);
        return zzv2;
    }

    public final String zza(Iterable<?> iterable) {
        StringBuilder sb;
        Iterable<?> iterable2 = iterable;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return zza(sb2, iterable2).toString();
    }

    public final StringBuilder zza(StringBuilder sb, Iterable<?> iterable) {
        StringBuilder sb2 = sb;
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            StringBuilder append = sb2.append(zzx(it.next()));
            while (it.hasNext()) {
                StringBuilder append2 = sb2.append(this.separator);
                StringBuilder append3 = sb2.append(zzx(it.next()));
            }
        }
        return sb2;
    }

    /* access modifiers changed from: 0000 */
    public CharSequence zzx(Object obj) {
        Object obj2 = obj;
        return obj2 instanceof CharSequence ? (CharSequence) obj2 : obj2.toString();
    }
}
