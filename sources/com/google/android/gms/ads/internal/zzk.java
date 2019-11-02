package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.view.Window;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzau;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzdj;
import com.google.android.gms.internal.zzdn;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjp;
import java.util.concurrent.Future;

@zzhb
public class zzk extends zzc implements zzdj, com.google.android.gms.internal.zzdn.zza {
    protected transient boolean zzqc = false;
    /* access modifiers changed from: private */
    public boolean zzqd;
    /* access modifiers changed from: private */
    public float zzqe;
    private String zzqf;

    @zzhb
    private class zza extends zzim {
        private final String zzqg;
        final /* synthetic */ zzk zzqh;

        public zza(zzk zzk, String str) {
            String str2 = str;
            this.zzqh = zzk;
            this.zzqg = str2;
        }

        public void onStop() {
        }

        public void zzbr() {
            zzr.zzbC().zzg(this.zzqh.zzpj.context, this.zzqg);
        }
    }

    @zzhb
    private class zzb extends zzim {
        private final String zzqg;
        final /* synthetic */ zzk zzqh;
        private final Bitmap zzqi;

        public zzb(zzk zzk, Bitmap bitmap, String str) {
            Bitmap bitmap2 = bitmap;
            String str2 = str;
            this.zzqh = zzk;
            this.zzqi = bitmap2;
            this.zzqg = str2;
        }

        public void onStop() {
        }

        public void zzbr() {
            InterstitialAdParameterParcel interstitialAdParameterParcel;
            AdOverlayInfoParcel adOverlayInfoParcel;
            C02031 r19;
            InterstitialAdParameterParcel interstitialAdParameterParcel2 = interstitialAdParameterParcel;
            InterstitialAdParameterParcel interstitialAdParameterParcel3 = new InterstitialAdParameterParcel(this.zzqh.zzpj.zzql, this.zzqh.zzbo(), this.zzqh.zzpj.zzql ? zzr.zzbC().zza(this.zzqh.zzpj.context, this.zzqi, this.zzqg) : false ? this.zzqg : null, this.zzqh.zzqd, this.zzqh.zzqe);
            InterstitialAdParameterParcel interstitialAdParameterParcel4 = interstitialAdParameterParcel2;
            int requestedOrientation = this.zzqh.zzpj.zzrq.zzED.getRequestedOrientation();
            if (requestedOrientation == -1) {
                requestedOrientation = this.zzqh.zzpj.zzrq.orientation;
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = adOverlayInfoParcel;
            AdOverlayInfoParcel adOverlayInfoParcel3 = new AdOverlayInfoParcel(this.zzqh, this.zzqh, this.zzqh, this.zzqh.zzpj.zzrq.zzED, requestedOrientation, this.zzqh.zzpj.zzrl, this.zzqh.zzpj.zzrq.zzHY, interstitialAdParameterParcel4);
            AdOverlayInfoParcel adOverlayInfoParcel4 = adOverlayInfoParcel2;
            Handler handler = zzir.zzMc;
            C02031 r10 = r19;
            final AdOverlayInfoParcel adOverlayInfoParcel5 = adOverlayInfoParcel4;
            C02031 r11 = new Runnable(this) {
                final /* synthetic */ zzb zzqk;

                {
                    AdOverlayInfoParcel adOverlayInfoParcel = r7;
                    this.zzqk = r6;
                }

                public void run() {
                    zzr.zzbA().zza(this.zzqk.zzqh.zzpj.context, adOverlayInfoParcel5);
                }
            };
            boolean post = handler.post(r10);
        }
    }

    public zzk(Context context, AdSizeParcel adSizeParcel, String str, zzex zzex, VersionInfoParcel versionInfoParcel, zzd zzd) {
        StringBuilder sb;
        super(context, adSizeParcel, str, zzex, versionInfoParcel, zzd);
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        this.zzqf = sb2.append("background").append(hashCode()).append(".").append("png").toString();
    }

    private void zzb(Bundle bundle) {
        zzr.zzbC().zzb(this.zzpj.context, this.zzpj.zzrl.afmaVersion, "gmob-apps", bundle, false);
    }

    public void showInterstitial() {
        InterstitialAdParameterParcel interstitialAdParameterParcel;
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzb zzb2;
        Bundle bundle;
        Bundle bundle2;
        zzx.zzcD("showInterstitial must be called on the main UI thread.");
        if (this.zzpj.zzrq == null) {
            zzin.zzaK("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) zzbt.zzwN.get()).booleanValue()) {
            String packageName = this.zzpj.context.getApplicationContext() != null ? this.zzpj.context.getApplicationContext().getPackageName() : this.zzpj.context.getPackageName();
            if (!this.zzqc) {
                zzin.zzaK("It is not recommended to show an interstitial before onAdLoaded completes.");
                Bundle bundle3 = bundle2;
                Bundle bundle4 = new Bundle();
                Bundle bundle5 = bundle3;
                bundle5.putString("appid", packageName);
                bundle5.putString("action", "show_interstitial_before_load_finish");
                zzb(bundle5);
            }
            if (!zzr.zzbC().zzO(this.zzpj.context)) {
                zzin.zzaK("It is not recommended to show an interstitial when app is not in foreground.");
                Bundle bundle6 = bundle;
                Bundle bundle7 = new Bundle();
                Bundle bundle8 = bundle6;
                bundle8.putString("appid", packageName);
                bundle8.putString("action", "show_interstitial_app_not_in_foreground");
                zzb(bundle8);
            }
        }
        if (this.zzpj.zzbX()) {
            return;
        }
        if (this.zzpj.zzrq.zzHT) {
            try {
                this.zzpj.zzrq.zzCq.showInterstitial();
            } catch (RemoteException e) {
                zzin.zzd("Could not show interstitial.", e);
                zzbp();
            }
        } else if (this.zzpj.zzrq.zzED == null) {
            zzin.zzaK("The interstitial failed to load.");
        } else if (this.zzpj.zzrq.zzED.zzhY()) {
            zzin.zzaK("The interstitial is already showing.");
        } else {
            this.zzpj.zzrq.zzED.zzD(true);
            if (this.zzpj.zzrq.zzKT != null) {
                zzau zza2 = this.zzpl.zza(this.zzpj.zzrp, this.zzpj.zzrq);
            }
            Bitmap bitmap = this.zzpj.zzql ? zzr.zzbC().zzP(this.zzpj.context) : null;
            if (!((Boolean) zzbt.zzxe.get()).booleanValue() || bitmap == null) {
                InterstitialAdParameterParcel interstitialAdParameterParcel2 = interstitialAdParameterParcel;
                InterstitialAdParameterParcel interstitialAdParameterParcel3 = new InterstitialAdParameterParcel(this.zzpj.zzql, zzbo(), null, false, 0.0f);
                InterstitialAdParameterParcel interstitialAdParameterParcel4 = interstitialAdParameterParcel2;
                int requestedOrientation = this.zzpj.zzrq.zzED.getRequestedOrientation();
                if (requestedOrientation == -1) {
                    requestedOrientation = this.zzpj.zzrq.orientation;
                }
                AdOverlayInfoParcel adOverlayInfoParcel2 = adOverlayInfoParcel;
                AdOverlayInfoParcel adOverlayInfoParcel3 = new AdOverlayInfoParcel(this, this, this, this.zzpj.zzrq.zzED, requestedOrientation, this.zzpj.zzrl, this.zzpj.zzrq.zzHY, interstitialAdParameterParcel4);
                zzr.zzbA().zza(this.zzpj.context, adOverlayInfoParcel2);
                return;
            }
            zzb zzb3 = zzb2;
            zzb zzb4 = new zzb(this, bitmap, this.zzqf);
            Future zzhn = zzb3.zzgd();
        }
    }

    /* access modifiers changed from: protected */
    public zzjp zza(com.google.android.gms.internal.zzif.zza zza2, zze zze) {
        com.google.android.gms.internal.zzif.zza zza3 = zza2;
        zze zze2 = zze;
        zzjp zza4 = zzr.zzbD().zza(this.zzpj.context, this.zzpj.zzrp, false, false, this.zzpj.zzrk, this.zzpj.zzrl, this.zzpe, this.zzpm);
        zza4.zzhU().zzb(this, null, this, this, ((Boolean) zzbt.zzwv.get()).booleanValue(), this, this, zze2, null);
        zza((zzeh) zza4);
        zza4.zzaM(zza3.zzLd.zzHI);
        zzdn.zza(zza4, (com.google.android.gms.internal.zzdn.zza) this);
        return zza4;
    }

    public void zza(boolean z, float f) {
        float f2 = f;
        this.zzqd = z;
        this.zzqe = f2;
    }

    public boolean zza(AdRequestParcel adRequestParcel, zzcb zzcb) {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        zzcb zzcb2 = zzcb;
        if (this.zzpj.zzrq == null) {
            return super.zza(adRequestParcel2, zzcb2);
        }
        zzin.zzaK("An interstitial is already loading. Aborting.");
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zza(AdRequestParcel adRequestParcel, zzif zzif, boolean z) {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        zzif zzif2 = zzif;
        boolean z2 = z;
        if (this.zzpj.zzbW() && zzif2.zzED != null) {
            boolean zzi = zzr.zzbE().zzi(zzif2.zzED);
        }
        return this.zzpi.zzbw();
    }

    public boolean zza(zzif zzif, zzif zzif2) {
        zzif zzif3 = zzif2;
        if (!super.zza(zzif, zzif3)) {
            return false;
        }
        if (!(this.zzpj.zzbW() || this.zzpj.zzrK == null || zzif3.zzKT == null)) {
            zzau zza2 = this.zzpl.zza(this.zzpj.zzrp, zzif3, this.zzpj.zzrK);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void zzaQ() {
        zzbp();
        super.zzaQ();
    }

    /* access modifiers changed from: protected */
    public void zzaT() {
        super.zzaT();
        this.zzqc = true;
    }

    public void zzaX() {
        recordImpression();
        super.zzaX();
    }

    public void zzb(RewardItemParcel rewardItemParcel) {
        RewardItemParcel rewardItemParcel2 = rewardItemParcel;
        if (this.zzpj.zzrq != null) {
            if (this.zzpj.zzrq.zzIl != null) {
                zzr.zzbC().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq.zzIl);
            }
            if (this.zzpj.zzrq.zzIj != null) {
                rewardItemParcel2 = this.zzpj.zzrq.zzIj;
            }
        }
        zza(rewardItemParcel2);
    }

    /* access modifiers changed from: protected */
    public boolean zzbo() {
        Rect rect;
        Rect rect2;
        if (this.zzpj.context instanceof Activity) {
            Window window = ((Activity) this.zzpj.context).getWindow();
            if (!(window == null || window.getDecorView() == null)) {
                Rect rect3 = rect;
                Rect rect4 = new Rect();
                Rect rect5 = rect3;
                Rect rect6 = rect2;
                Rect rect7 = new Rect();
                Rect rect8 = rect6;
                boolean globalVisibleRect = window.getDecorView().getGlobalVisibleRect(rect5, null);
                window.getDecorView().getWindowVisibleDisplayFrame(rect8);
                return (rect5.bottom == 0 || rect8.bottom == 0 || rect5.top != rect8.top) ? false : true;
            }
        }
        return false;
    }

    public void zzbp() {
        zza zza2;
        zza zza3 = zza2;
        zza zza4 = new zza(this, this.zzqf);
        Future zzhn = zza3.zzgd();
        if (this.zzpj.zzbW()) {
            this.zzpj.zzbT();
            this.zzpj.zzrq = null;
            this.zzpj.zzql = false;
            this.zzqc = false;
        }
    }

    public void zzbq() {
        if (!(this.zzpj.zzrq == null || this.zzpj.zzrq.zzKX == null)) {
            zzr.zzbC().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq.zzKX);
        }
        zzaU();
    }

    public void zzd(boolean z) {
        boolean z2 = z;
        this.zzpj.zzql = z2;
    }
}
