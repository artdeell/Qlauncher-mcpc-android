package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzfq.zza;
import java.util.Map;

@zzhb
public class zzfr extends zzfs implements zzdf {
    private final Context mContext;
    DisplayMetrics zzDA;
    private float zzDB;
    int zzDC = -1;
    int zzDD = -1;
    private int zzDE;
    int zzDF = -1;
    int zzDG = -1;
    int zzDH = -1;
    int zzDI = -1;
    private final zzbl zzDz;
    private final zzjp zzpD;
    private final WindowManager zzsb;

    public zzfr(zzjp zzjp, Context context, zzbl zzbl) {
        zzjp zzjp2 = zzjp;
        Context context2 = context;
        zzbl zzbl2 = zzbl;
        super(zzjp2);
        this.zzpD = zzjp2;
        this.mContext = context2;
        this.zzDz = zzbl2;
        this.zzsb = (WindowManager) context2.getSystemService("window");
    }

    private void zzeQ() {
        DisplayMetrics displayMetrics;
        DisplayMetrics displayMetrics2 = displayMetrics;
        DisplayMetrics displayMetrics3 = new DisplayMetrics();
        this.zzDA = displayMetrics2;
        Display defaultDisplay = this.zzsb.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzDA);
        this.zzDB = this.zzDA.density;
        this.zzDE = defaultDisplay.getRotation();
    }

    private void zzeV() {
        int[] iArr = new int[2];
        this.zzpD.getLocationOnScreen(iArr);
        zzf(zzn.zzcS().zzc(this.mContext, iArr[0]), zzn.zzcS().zzc(this.mContext, iArr[1]));
    }

    private zzfq zzeY() {
        zza zza;
        zza zza2 = zza;
        zza zza3 = new zza();
        return zza2.zzr(this.zzDz.zzdj()).zzq(this.zzDz.zzdk()).zzs(this.zzDz.zzdo()).zzt(this.zzDz.zzdl()).zzu(this.zzDz.zzdm()).zzeP();
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        zzeT();
    }

    /* access modifiers changed from: 0000 */
    public void zzeR() {
        this.zzDC = zzn.zzcS().zzb(this.zzDA, this.zzDA.widthPixels);
        this.zzDD = zzn.zzcS().zzb(this.zzDA, this.zzDA.heightPixels);
        Activity zzhP = this.zzpD.zzhP();
        if (zzhP == null || zzhP.getWindow() == null) {
            this.zzDF = this.zzDC;
            this.zzDG = this.zzDD;
            return;
        }
        int[] zze = zzr.zzbC().zze(zzhP);
        this.zzDF = zzn.zzcS().zzb(this.zzDA, zze[0]);
        this.zzDG = zzn.zzcS().zzb(this.zzDA, zze[1]);
    }

    /* access modifiers changed from: 0000 */
    public void zzeS() {
        if (this.zzpD.zzaN().zzui) {
            this.zzDH = this.zzDC;
            this.zzDI = this.zzDD;
            return;
        }
        this.zzpD.measure(0, 0);
        this.zzDH = zzn.zzcS().zzc(this.mContext, this.zzpD.getMeasuredWidth());
        this.zzDI = zzn.zzcS().zzc(this.mContext, this.zzpD.getMeasuredHeight());
    }

    public void zzeT() {
        zzeQ();
        zzeR();
        zzeS();
        zzeW();
        zzeX();
        zzeV();
        zzeU();
    }

    /* access modifiers changed from: 0000 */
    public void zzeU() {
        if (zzin.zzQ(2)) {
            zzin.zzaJ("Dispatching Ready Event.");
        }
        zzan(this.zzpD.zzhX().afmaVersion);
    }

    /* access modifiers changed from: 0000 */
    public void zzeW() {
        zza(this.zzDC, this.zzDD, this.zzDF, this.zzDG, this.zzDB, this.zzDE);
    }

    /* access modifiers changed from: 0000 */
    public void zzeX() {
        this.zzpD.zzb("onDeviceFeaturesReceived", zzeY().toJson());
    }

    public void zzf(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        zzc(i3, i4 - (this.mContext instanceof Activity ? zzr.zzbC().zzh((Activity) this.mContext)[0] : 0), this.zzDH, this.zzDI);
        this.zzpD.zzhU().zze(i3, i4);
    }
}
