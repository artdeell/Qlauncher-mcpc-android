package com.google.android.gms.internal;

import com.google.android.gms.internal.zzm.zza;
import com.google.android.gms.internal.zzm.zzb;
import java.io.UnsupportedEncodingException;

public class zzab extends zzk<String> {
    private final zzb<String> zzaG;

    public zzab(int i, String str, zzb<String> zzb, zza zza) {
        zzb<String> zzb2 = zzb;
        super(i, str, zza);
        this.zzaG = zzb2;
    }

    public zzab(String str, zzb<String> zzb, zza zza) {
        this(0, str, zzb, zza);
    }

    /* access modifiers changed from: protected */
    public zzm<String> zza(zzi zzi) {
        String str;
        String str2;
        String str3;
        zzi zzi2 = zzi;
        try {
            String str4 = str3;
            String str5 = new String(zzi2.data, zzx.zza(zzi2.zzA));
            str2 = str4;
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            String str6 = str;
            String str7 = new String(zzi2.data);
            str2 = str6;
        }
        return zzm.zza(str2, zzx.zzb(zzi2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzi */
    public void zza(String str) {
        String str2 = str;
        this.zzaG.zzb(str2);
    }
}
