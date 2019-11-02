package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzr;
import org.json.JSONObject;

@zzhb
public class zzef implements zzed {
    /* access modifiers changed from: private */
    public final zzjp zzpD;

    public zzef(Context context, VersionInfoParcel versionInfoParcel, zzan zzan) {
        AdSizeParcel adSizeParcel;
        Context context2 = context;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzan zzan2 = zzan;
        zzjr zzbD = zzr.zzbD();
        Context context3 = context2;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        AdSizeParcel adSizeParcel3 = new AdSizeParcel();
        this.zzpD = zzbD.zza(context3, adSizeParcel2, false, false, zzan2, versionInfoParcel2);
        this.zzpD.getWebView().setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable) {
        Runnable runnable2 = runnable;
        if (zzn.zzcS().zzhJ()) {
            runnable2.run();
        } else {
            boolean post = zzir.zzMc.post(runnable2);
        }
    }

    public void destroy() {
        this.zzpD.destroy();
    }

    public void zzZ(String str) {
        C03303 r11;
        C03303 r3 = r11;
        Object[] objArr = new Object[1];
        Object[] objArr2 = objArr;
        objArr[0] = str;
        final String format = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", objArr2);
        C03303 r4 = new Runnable(this) {
            final /* synthetic */ zzef zzAU;

            {
                String str = r7;
                this.zzAU = r6;
            }

            public void run() {
                this.zzAU.zzpD.loadData(format, "text/html", "UTF-8");
            }
        };
        runOnUiThread(r3);
    }

    public void zza(zza zza, zzg zzg, zzdb zzdb, zzp zzp, boolean z, zzdh zzdh, zzdj zzdj, zze zze, zzft zzft) {
        zze zze2;
        zza zza2 = zza;
        zzg zzg2 = zzg;
        zzdb zzdb2 = zzdb;
        zzp zzp2 = zzp;
        boolean z2 = z;
        zzdh zzdh2 = zzdh;
        zzdj zzdj2 = zzdj;
        zze zze3 = zze;
        zzft zzft2 = zzft;
        zzjq zzhU = this.zzpD.zzhU();
        zza zza3 = zza2;
        zzg zzg3 = zzg2;
        zzdb zzdb3 = zzdb2;
        zzp zzp3 = zzp2;
        boolean z3 = z2;
        zzdh zzdh3 = zzdh2;
        zzdj zzdj3 = zzdj2;
        zze zze4 = zze2;
        zze zze5 = new zze(false);
        zzhU.zzb(zza3, zzg3, zzdb3, zzp3, z3, zzdh3, zzdj3, zze4, zzft2);
    }

    public void zza(zzed.zza zza) {
        C03336 r7;
        zzed.zza zza2 = zza;
        zzjq zzhU = this.zzpD.zzhU();
        C03336 r3 = r7;
        final zzed.zza zza3 = zza2;
        C03336 r4 = new zzjq.zza(this) {
            final /* synthetic */ zzef zzAU;

            {
                zzed.zza zza = r7;
                this.zzAU = r6;
            }

            public void zza(zzjp zzjp, boolean z) {
                zzjp zzjp2 = zzjp;
                boolean z2 = z;
                zza3.zzeo();
            }
        };
        zzhU.zza((zzjq.zza) r3);
    }

    public void zza(String str, zzdf zzdf) {
        String str2 = str;
        zzdf zzdf2 = zzdf;
        this.zzpD.zzhU().zza(str2, zzdf2);
    }

    public void zza(String str, JSONObject jSONObject) {
        C03281 r9;
        C03281 r4 = r9;
        final String str2 = str;
        final JSONObject jSONObject2 = jSONObject;
        C03281 r5 = new Runnable(this) {
            final /* synthetic */ zzef zzAU;

            {
                String str = r8;
                JSONObject jSONObject = r9;
                this.zzAU = r7;
            }

            public void run() {
                this.zzAU.zzpD.zza(str2, jSONObject2);
            }
        };
        runOnUiThread(r4);
    }

    public void zzaa(String str) {
        C03325 r7;
        C03325 r3 = r7;
        final String str2 = str;
        C03325 r4 = new Runnable(this) {
            final /* synthetic */ zzef zzAU;

            {
                String str = r7;
                this.zzAU = r6;
            }

            public void run() {
                this.zzAU.zzpD.loadUrl(str2);
            }
        };
        runOnUiThread(r3);
    }

    public void zzab(String str) {
        C03314 r7;
        C03314 r3 = r7;
        final String str2 = str;
        C03314 r4 = new Runnable(this) {
            final /* synthetic */ zzef zzAU;

            {
                String str = r7;
                this.zzAU = r6;
            }

            public void run() {
                this.zzAU.zzpD.loadData(str2, "text/html", "UTF-8");
            }
        };
        runOnUiThread(r3);
    }

    public void zzb(String str, zzdf zzdf) {
        String str2 = str;
        zzdf zzdf2 = zzdf;
        this.zzpD.zzhU().zzb(str2, zzdf2);
    }

    public void zzb(String str, JSONObject jSONObject) {
        String str2 = str;
        JSONObject jSONObject2 = jSONObject;
        this.zzpD.zzb(str2, jSONObject2);
    }

    public void zze(String str, String str2) {
        C03292 r9;
        C03292 r4 = r9;
        final String str3 = str;
        final String str4 = str2;
        C03292 r5 = new Runnable(this) {
            final /* synthetic */ zzef zzAU;

            {
                String str = r8;
                String str2 = r9;
                this.zzAU = r7;
            }

            public void run() {
                this.zzAU.zzpD.zze(str3, str4);
            }
        };
        runOnUiThread(r4);
    }

    public zzei zzen() {
        zzej zzej;
        zzej zzej2 = zzej;
        zzej zzej3 = new zzej(this);
        return zzej2;
    }
}
