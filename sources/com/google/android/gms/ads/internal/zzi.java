package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.p000v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzr.zza;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzir;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@zzhb
public class zzi extends zza {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final zzq zzpK;
    /* access modifiers changed from: private */
    public final zzcr zzpL;
    /* access modifiers changed from: private */
    public final zzcs zzpM;
    /* access modifiers changed from: private */
    public final SimpleArrayMap<String, zzcu> zzpN;
    /* access modifiers changed from: private */
    public final SimpleArrayMap<String, zzct> zzpO;
    /* access modifiers changed from: private */
    public final NativeAdOptionsParcel zzpP;
    private final List<String> zzpQ = zzbl();
    /* access modifiers changed from: private */
    public final zzx zzpR;
    private final String zzpS;
    private final VersionInfoParcel zzpT;
    private WeakReference<zzp> zzpU;
    /* access modifiers changed from: private */
    public final Object zzpV;
    private final zzd zzpm;
    private final zzex zzpn;

    zzi(Context context, String str, zzex zzex, VersionInfoParcel versionInfoParcel, zzq zzq, zzcr zzcr, zzcs zzcs, SimpleArrayMap<String, zzcu> simpleArrayMap, SimpleArrayMap<String, zzct> simpleArrayMap2, NativeAdOptionsParcel nativeAdOptionsParcel, zzx zzx, zzd zzd) {
        Object obj;
        Context context2 = context;
        String str2 = str;
        zzex zzex2 = zzex;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzq zzq2 = zzq;
        zzcr zzcr2 = zzcr;
        zzcs zzcs2 = zzcs;
        SimpleArrayMap<String, zzcu> simpleArrayMap3 = simpleArrayMap;
        SimpleArrayMap<String, zzct> simpleArrayMap4 = simpleArrayMap2;
        NativeAdOptionsParcel nativeAdOptionsParcel2 = nativeAdOptionsParcel;
        zzx zzx2 = zzx;
        zzd zzd2 = zzd;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.mContext = context2;
        this.zzpS = str2;
        this.zzpn = zzex2;
        this.zzpT = versionInfoParcel2;
        this.zzpK = zzq2;
        this.zzpM = zzcs2;
        this.zzpL = zzcr2;
        this.zzpN = simpleArrayMap3;
        this.zzpO = simpleArrayMap4;
        this.zzpP = nativeAdOptionsParcel2;
        this.zzpR = zzx2;
        this.zzpm = zzd2;
    }

    static /* synthetic */ WeakReference zza(zzi zzi, WeakReference weakReference) {
        WeakReference weakReference2 = weakReference;
        zzi.zzpU = weakReference2;
        return weakReference2;
    }

    /* access modifiers changed from: private */
    public List<String> zzbl() {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        if (this.zzpM != null) {
            boolean add = arrayList4.add("1");
        }
        if (this.zzpL != null) {
            boolean add2 = arrayList4.add("2");
        }
        if (this.zzpN.size() > 0) {
            boolean add3 = arrayList4.add("3");
        }
        return arrayList4;
    }

    public String getMediationAdapterClassName() {
        zzp zzp = this.zzpV;
        synchronized (zzp) {
            try {
                if (this.zzpU == null) {
                    return null;
                }
                th = (zzp) this.zzpU.get();
                String str = zzp != null ? zzp.getMediationAdapterClassName() : null;
                return str;
            } finally {
                Throwable th = th;
                zzp zzp2 = zzp;
                Throwable th2 = th;
            }
        }
    }

    public boolean isLoading() {
        zzp zzp = this.zzpV;
        synchronized (zzp) {
            try {
                if (this.zzpU == null) {
                    return false;
                }
                th = (zzp) this.zzpU.get();
                boolean z = zzp != null ? zzp.isLoading() : false;
                return z;
            } finally {
                Throwable th = th;
                zzp zzp2 = zzp;
                Throwable th2 = th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void runOnUiThread(Runnable runnable) {
        boolean post = zzir.zzMc.post(runnable);
    }

    /* access modifiers changed from: protected */
    public zzp zzbm() {
        zzp zzp;
        zzp zzp2 = zzp;
        zzp zzp3 = new zzp(this.mContext, this.zzpm, AdSizeParcel.zzt(this.mContext), this.zzpS, this.zzpn, this.zzpT);
        return zzp2;
    }

    public void zzf(AdRequestParcel adRequestParcel) {
        C02021 r7;
        C02021 r3 = r7;
        final AdRequestParcel adRequestParcel2 = adRequestParcel;
        C02021 r4 = new Runnable(this) {
            final /* synthetic */ zzi zzpX;

            {
                AdRequestParcel adRequestParcel = r7;
                this.zzpX = r6;
            }

            public void run() {
                WeakReference weakReference;
                Object zza = this.zzpX.zzpV;
                synchronized (zza) {
                    try {
                        zzp zzbm = this.zzpX.zzbm();
                        zzi zzi = this.zzpX;
                        WeakReference weakReference2 = weakReference;
                        WeakReference weakReference3 = new WeakReference(zzbm);
                        WeakReference zza2 = zzi.zza(zzi, weakReference2);
                        zzbm.zzb(this.zzpX.zzpL);
                        zzbm.zzb(this.zzpX.zzpM);
                        zzbm.zza(this.zzpX.zzpN);
                        zzbm.zza(this.zzpX.zzpK);
                        zzbm.zzb(this.zzpX.zzpO);
                        zzbm.zza(this.zzpX.zzbl());
                        zzbm.zzb(this.zzpX.zzpP);
                        zzbm.zza(this.zzpX.zzpR);
                        boolean zzb = zzbm.zzb(adRequestParcel2);
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj = zza;
                        throw th2;
                    }
                }
            }
        };
        runOnUiThread(r3);
    }
}
