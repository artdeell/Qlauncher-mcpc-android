package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzcl.zza;
import com.google.android.gms.internal.zzhb;
import java.util.List;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

@zzhb
public class zzd extends zza implements zzh.zza {
    private Bundle mExtras;
    private Object zzpV;
    private String zzxW;
    private List<zzc> zzxX;
    private String zzxY;
    private zzch zzxZ;
    private String zzya;
    private double zzyb;
    private String zzyc;
    private String zzyd;
    private zza zzye;
    private zzh zzyf;

    public zzd(String str, List list, String str2, zzch zzch, String str3, double d, String str4, String str5, zza zza, Bundle bundle) {
        Object obj;
        String str6 = str;
        List list2 = list;
        String str7 = str2;
        zzch zzch2 = zzch;
        String str8 = str3;
        double d2 = d;
        String str9 = str4;
        String str10 = str5;
        zza zza2 = zza;
        Bundle bundle2 = bundle;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzxW = str6;
        this.zzxX = list2;
        this.zzxY = str7;
        this.zzxZ = zzch2;
        this.zzya = str8;
        this.zzyb = d2;
        this.zzyc = str9;
        this.zzyd = str10;
        this.zzye = zza2;
        this.mExtras = bundle2;
    }

    public void destroy() {
        this.zzxW = null;
        this.zzxX = null;
        this.zzxY = null;
        this.zzxZ = null;
        this.zzya = null;
        this.zzyb = 0.0d;
        this.zzyc = null;
        this.zzyd = null;
        this.zzye = null;
        this.mExtras = null;
        this.zzpV = null;
        this.zzyf = null;
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

    public String getPrice() {
        return this.zzyd;
    }

    public double getStarRating() {
        return this.zzyb;
    }

    public String getStore() {
        return this.zzyc;
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

    public zzch zzdK() {
        return this.zzxZ;
    }

    public com.google.android.gms.dynamic.zzd zzdL() {
        return zze.zzC(this.zzyf);
    }

    public String zzdM() {
        return "2";
    }

    public zza zzdN() {
        return this.zzye;
    }
}
