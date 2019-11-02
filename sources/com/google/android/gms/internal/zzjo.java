package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.common.internal.zzx;

@zzhb
public class zzjo {
    private final Context mContext;
    private zzk zzFo;
    private final ViewGroup zzNx;
    private final zzjp zzpD;

    public zzjo(Context context, ViewGroup viewGroup, zzjp zzjp) {
        this(context, viewGroup, zzjp, null);
    }

    zzjo(Context context, ViewGroup viewGroup, zzjp zzjp, zzk zzk) {
        ViewGroup viewGroup2 = viewGroup;
        zzjp zzjp2 = zzjp;
        zzk zzk2 = zzk;
        this.mContext = context;
        this.zzNx = viewGroup2;
        this.zzpD = zzjp2;
        this.zzFo = zzk2;
    }

    public void onDestroy() {
        zzx.zzcD("onDestroy must be called from the UI thread.");
        if (this.zzFo != null) {
            this.zzFo.destroy();
        }
    }

    public void onPause() {
        zzx.zzcD("onPause must be called from the UI thread.");
        if (this.zzFo != null) {
            this.zzFo.pause();
        }
    }

    public void zza(int i, int i2, int i3, int i4, int i5) {
        zzk zzk;
        LayoutParams layoutParams;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        if (this.zzFo == null) {
            zzcb zzdA = this.zzpD.zzic().zzdA();
            zzbz zzib = this.zzpD.zzib();
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = "vpr";
            boolean zza = zzbx.zza(zzdA, zzib, strArr2);
            zzk zzk2 = zzk;
            zzk zzk3 = new zzk(this.mContext, this.zzpD, i10, this.zzpD.zzic().zzdA(), zzbx.zzb(this.zzpD.zzic().zzdA()));
            this.zzFo = zzk2;
            ViewGroup viewGroup = this.zzNx;
            zzk zzk4 = this.zzFo;
            LayoutParams layoutParams2 = layoutParams;
            LayoutParams layoutParams3 = new LayoutParams(-1, -1);
            viewGroup.addView(zzk4, 0, layoutParams2);
            this.zzFo.zzd(i6, i7, i8, i9);
            this.zzpD.zzhU().zzG(false);
        }
    }

    public void zze(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        zzx.zzcD("The underlay may only be modified from the UI thread.");
        if (this.zzFo != null) {
            this.zzFo.zzd(i5, i6, i7, i8);
        }
    }

    public zzk zzhM() {
        zzx.zzcD("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzFo;
    }
}
