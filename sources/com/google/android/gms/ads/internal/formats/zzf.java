package com.google.android.gms.ads.internal.formats;

import android.support.p000v4.util.SimpleArrayMap;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzcp.zza;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.util.Arrays;
import java.util.List;

@zzhb
public class zzf extends zza implements zzh.zza {
    private final Object zzpV;
    private final zza zzye;
    private zzh zzyf;
    private final String zzyi;
    private final SimpleArrayMap<String, zzc> zzyj;
    private final SimpleArrayMap<String, String> zzyk;

    public zzf(String str, SimpleArrayMap<String, zzc> simpleArrayMap, SimpleArrayMap<String, String> simpleArrayMap2, zza zza) {
        Object obj;
        String str2 = str;
        SimpleArrayMap<String, zzc> simpleArrayMap3 = simpleArrayMap;
        SimpleArrayMap<String, String> simpleArrayMap4 = simpleArrayMap2;
        zza zza2 = zza;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzyi = str2;
        this.zzyj = simpleArrayMap3;
        this.zzyk = simpleArrayMap4;
        this.zzye = zza2;
    }

    public List<String> getAvailableAssetNames() {
        int i;
        String[] strArr = new String[(this.zzyj.size() + this.zzyk.size())];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = 0;
            if (i2 >= this.zzyj.size()) {
                break;
            }
            strArr[i3] = (String) this.zzyj.keyAt(i2);
            i3++;
            i2++;
        }
        while (i < this.zzyk.size()) {
            strArr[i3] = (String) this.zzyk.keyAt(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    public String getCustomTemplateId() {
        return this.zzyi;
    }

    public void performClick(String str) {
        String str2 = str;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzyf == null) {
                    zzin.m19e("Attempt to call performClick before ad initialized.");
                } else {
                    this.zzyf.zza(str2, null, null, null);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void recordImpression() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzyf == null) {
                    zzin.m19e("Attempt to perform recordImpression before ad initialized.");
                } else {
                    this.zzyf.recordImpression();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public String zzO(String str) {
        return (String) this.zzyk.get(str);
    }

    public zzch zzP(String str) {
        return (zzch) this.zzyj.get(str);
    }

    public void zzb(zzh zzh) {
        zzh zzh2 = zzh;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzyf = zzh2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public String zzdM() {
        return "3";
    }

    public zza zzdN() {
        return this.zzye;
    }
}
