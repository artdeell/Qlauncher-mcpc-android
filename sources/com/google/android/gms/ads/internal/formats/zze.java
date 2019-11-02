package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzcn.zza;
import com.google.android.gms.internal.zzhb;
import java.util.List;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

@zzhb
public class zze extends zza implements zzh.zza {
    private Bundle mExtras;
    private Object zzpV;
    private String zzxW;
    private List<zzc> zzxX;
    private String zzxY;
    private String zzya;
    private zza zzye;
    private zzh zzyf;
    private zzch zzyg;
    private String zzyh;

    public zze(String str, List list, String str2, zzch zzch, String str3, String str4, zza zza, Bundle bundle) {
        Object obj;
        String str5 = str;
        List list2 = list;
        String str6 = str2;
        zzch zzch2 = zzch;
        String str7 = str3;
        String str8 = str4;
        zza zza2 = zza;
        Bundle bundle2 = bundle;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzxW = str5;
        this.zzxX = list2;
        this.zzxY = str6;
        this.zzyg = zzch2;
        this.zzya = str7;
        this.zzyh = str8;
        this.zzye = zza2;
        this.mExtras = bundle2;
    }

    public void destroy() {
        this.zzxW = null;
        this.zzxX = null;
        this.zzxY = null;
        this.zzyg = null;
        this.zzya = null;
        this.zzyh = null;
        this.zzye = null;
        this.mExtras = null;
        this.zzpV = null;
        this.zzyf = null;
    }

    public String getAdvertiser() {
        return this.zzyh;
    }

    public String getBody() {
        return this.zzxY;
    }

    public String getCallToAction() {
        return this.zzya;
    }

    public String getCustomTemplateId() {
        return LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getHeadline() {
        return this.zzxW;
    }

    public List getImages() {
        return this.zzxX;
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

    public zzd zzdL() {
        return com.google.android.gms.dynamic.zze.zzC(this.zzyf);
    }

    public String zzdM() {
        return "1";
    }

    public zza zzdN() {
        return this.zzye;
    }

    public zzch zzdO() {
        return this.zzyg;
    }
}
