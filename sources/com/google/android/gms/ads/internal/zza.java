package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.zzf;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.request.zza.C0868zza;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzax;
import com.google.android.gms.internal.zzbc;
import com.google.android.gms.internal.zzbf;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhr;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzij;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zzin;
import java.util.HashSet;
import java.util.concurrent.Future;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

@zzhb
public abstract class zza extends com.google.android.gms.ads.internal.client.zzu.zza implements com.google.android.gms.ads.internal.client.zza, zzp, C0868zza, zzdb, com.google.android.gms.internal.zzgr.zza, zzij {
    protected zzcb zzpe;
    protected zzbz zzpf;
    protected zzbz zzpg;
    protected boolean zzph = false;
    protected final zzq zzpi;
    protected final zzs zzpj;
    protected transient AdRequestParcel zzpk;
    protected final zzax zzpl;
    protected final zzd zzpm;

    zza(zzs zzs, zzq zzq, zzd zzd) {
        zzq zzq2;
        zzs zzs2 = zzs;
        zzq zzq3 = zzq;
        zzd zzd2 = zzd;
        this.zzpj = zzs2;
        if (zzq3 == null) {
            zzq zzq4 = zzq2;
            zzq zzq5 = new zzq(this);
            zzq3 = zzq4;
        }
        this.zzpi = zzq3;
        this.zzpm = zzd2;
        boolean zzJ = zzr.zzbC().zzJ(this.zzpj.context);
        zzr.zzbF().zzb(this.zzpj.context, this.zzpj.zzrl);
        this.zzpl = zzr.zzbF().zzhh();
    }

    private AdRequestParcel zza(AdRequestParcel adRequestParcel) {
        zzf zzf;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        if (zze.zzap(this.zzpj.context) && adRequestParcel2.zztK != null) {
            zzf zzf2 = zzf;
            zzf zzf3 = new zzf(adRequestParcel2);
            adRequestParcel2 = zzf2.zza(null).zzcN();
        }
        return adRequestParcel2;
    }

    public void destroy() {
        zzx.zzcD("destroy must be called on the main UI thread.");
        this.zzpi.cancel();
        this.zzpl.zzj(this.zzpj.zzrq);
        this.zzpj.destroy();
    }

    public boolean isLoading() {
        return this.zzph;
    }

    public boolean isReady() {
        zzx.zzcD("isLoaded must be called on the main UI thread.");
        return this.zzpj.zzrn == null && this.zzpj.zzro == null && this.zzpj.zzrq != null;
    }

    public void onAdClicked() {
        if (this.zzpj.zzrq == null) {
            zzin.zzaK("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzin.zzaI("Pinging click URLs.");
        this.zzpj.zzrs.zzgT();
        if (this.zzpj.zzrq.zzBQ != null) {
            zzr.zzbC().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq.zzBQ);
        }
        if (this.zzpj.zzrt != null) {
            try {
                this.zzpj.zzrt.onAdClicked();
            } catch (RemoteException e) {
                zzin.zzd("Could not notify onAdClicked event.", e);
            }
        }
    }

    public void onAppEvent(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (this.zzpj.zzrv != null) {
            try {
                this.zzpj.zzrv.onAppEvent(str3, str4);
            } catch (RemoteException e) {
                zzin.zzd("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        zzx.zzcD("pause must be called on the main UI thread.");
    }

    public void resume() {
        zzx.zzcD("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean z) {
        UnsupportedOperationException unsupportedOperationException;
        boolean z2 = z;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
        throw unsupportedOperationException2;
    }

    public void setUserId(String str) {
        String str2 = str;
        zzx.zzcD("setUserId must be called on the main UI thread.");
        this.zzpj.setUserId(str2);
    }

    public void stopLoading() {
        zzx.zzcD("stopLoading must be called on the main UI thread.");
        this.zzph = false;
        this.zzpj.zzf(true);
    }

    /* access modifiers changed from: 0000 */
    public Bundle zza(zzbf zzbf) {
        String zzhf;
        String str;
        Bundle bundle;
        StringBuilder sb;
        zzbf zzbf2 = zzbf;
        Bundle bundle2 = null;
        if (zzbf2 != null) {
            if (zzbf2.zzcK()) {
                zzbf2.wakeup();
            }
            zzbc zzcI = zzbf2.zzcI();
            if (zzcI != null) {
                zzhf = zzcI.zzcy();
                str = zzcI.zzcz();
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                zzin.zzaI(sb2.append("In AdManager: loadAd, ").append(zzcI.toString()).toString());
                if (zzhf != null) {
                    Future zzaA = zzr.zzbF().zzaA(zzhf);
                }
            } else {
                zzhf = zzr.zzbF().zzhf();
                str = null;
            }
            bundle2 = null;
            if (zzhf != null) {
                Bundle bundle3 = bundle;
                Bundle bundle4 = new Bundle(1);
                bundle2 = bundle3;
                bundle2.putString("fingerprint", zzhf);
                if (!zzhf.equals(str)) {
                    bundle2.putString("v_fp", str);
                    return bundle2;
                }
            }
        }
        return bundle2;
    }

    public void zza(AdSizeParcel adSizeParcel) {
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        zzx.zzcD("setAdSize must be called on the main UI thread.");
        this.zzpj.zzrp = adSizeParcel2;
        if (!(this.zzpj.zzrq == null || this.zzpj.zzrq.zzED == null || this.zzpj.zzrL != 0)) {
            this.zzpj.zzrq.zzED.zza(adSizeParcel2);
        }
        if (this.zzpj.zzrm != null) {
            if (this.zzpj.zzrm.getChildCount() > 1) {
                this.zzpj.zzrm.removeView(this.zzpj.zzrm.getNextView());
            }
            this.zzpj.zzrm.setMinimumWidth(adSizeParcel2.widthPixels);
            this.zzpj.zzrm.setMinimumHeight(adSizeParcel2.heightPixels);
            this.zzpj.zzrm.requestLayout();
        }
    }

    public void zza(com.google.android.gms.ads.internal.client.zzp zzp) {
        com.google.android.gms.ads.internal.client.zzp zzp2 = zzp;
        zzx.zzcD("setAdListener must be called on the main UI thread.");
        this.zzpj.zzrt = zzp2;
    }

    public void zza(zzq zzq) {
        zzq zzq2 = zzq;
        zzx.zzcD("setAdListener must be called on the main UI thread.");
        this.zzpj.zzru = zzq2;
    }

    public void zza(zzw zzw) {
        zzw zzw2 = zzw;
        zzx.zzcD("setAppEventListener must be called on the main UI thread.");
        this.zzpj.zzrv = zzw2;
    }

    public void zza(com.google.android.gms.ads.internal.client.zzx zzx) {
        com.google.android.gms.ads.internal.client.zzx zzx2 = zzx;
        zzx.zzcD("setCorrelationIdProvider must be called on the main UI thread");
        this.zzpj.zzrw = zzx2;
    }

    public void zza(zzd zzd) {
        zzd zzd2 = zzd;
        zzx.zzcD("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzpj.zzrF = zzd2;
    }

    /* access modifiers changed from: protected */
    public void zza(RewardItemParcel rewardItemParcel) {
        zzhr zzhr;
        RewardItemParcel rewardItemParcel2 = rewardItemParcel;
        if (this.zzpj.zzrF != null) {
            String str = LibrariesRepository.MOJANG_MAVEN_REPO;
            int i = 0;
            if (rewardItemParcel2 != null) {
                try {
                    str = rewardItemParcel2.type;
                    i = rewardItemParcel2.zzKS;
                } catch (RemoteException e) {
                    zzin.zzd("Could not call RewardedVideoAdListener.onRewarded().", e);
                    return;
                }
            }
            zzd zzd = this.zzpj.zzrF;
            zzhr zzhr2 = zzhr;
            zzhr zzhr3 = new zzhr(str, i);
            zzd.zza(zzhr2);
        }
    }

    public void zza(zzcf zzcf) {
        IllegalStateException illegalStateException;
        zzcf zzcf2 = zzcf;
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
        throw illegalStateException2;
    }

    public void zza(zzgd zzgd) {
        IllegalStateException illegalStateException;
        zzgd zzgd2 = zzgd;
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
        throw illegalStateException2;
    }

    public void zza(zzgh zzgh, String str) {
        IllegalStateException illegalStateException;
        zzgh zzgh2 = zzgh;
        String str2 = str;
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
        throw illegalStateException2;
    }

    public void zza(com.google.android.gms.internal.zzif.zza zza) {
        com.google.android.gms.internal.zzif.zza zza2 = zza;
        if (zza2.zzLe.zzHX != -1 && !TextUtils.isEmpty(zza2.zzLe.zzIh)) {
            long zzp = zzp(zza2.zzLe.zzIh);
            if (zzp != -1) {
                zzbz zzb = this.zzpe.zzb(zzp + zza2.zzLe.zzHX);
                zzcb zzcb = this.zzpe;
                zzbz zzbz = zzb;
                String[] strArr = new String[1];
                String[] strArr2 = strArr;
                strArr[0] = "stc";
                boolean zza3 = zzcb.zza(zzbz, strArr2);
            }
        }
        this.zzpe.zzN(zza2.zzLe.zzIh);
        zzcb zzcb2 = this.zzpe;
        zzbz zzbz2 = this.zzpf;
        String[] strArr3 = new String[1];
        String[] strArr4 = strArr3;
        strArr3[0] = "arf";
        boolean zza4 = zzcb2.zza(zzbz2, strArr4);
        this.zzpg = this.zzpe.zzdB();
        this.zzpe.zzc("gqi", zza2.zzLe.zzIi);
        this.zzpj.zzrn = null;
        this.zzpj.zzrr = zza2;
        zza(zza2, this.zzpe);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(com.google.android.gms.internal.zzif.zza zza, zzcb zzcb);

    public void zza(HashSet<zzig> hashSet) {
        HashSet<zzig> hashSet2 = hashSet;
        this.zzpj.zza(hashSet2);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(AdRequestParcel adRequestParcel, zzcb zzcb);

    /* access modifiers changed from: 0000 */
    public boolean zza(zzif zzif) {
        zzif zzif2 = zzif;
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zzif zzif, zzif zzif2);

    /* access modifiers changed from: 0000 */
    public void zzaL() {
        zzcb zzcb;
        zzbz zzbz;
        zzbz zzbz2;
        zzcb zzcb2 = zzcb;
        zzcb zzcb3 = new zzcb(((Boolean) zzbt.zzwg.get()).booleanValue(), "load_ad", this.zzpj.zzrp.zzuh);
        this.zzpe = zzcb2;
        zzbz zzbz3 = zzbz;
        zzbz zzbz4 = new zzbz(-1, null, null);
        this.zzpf = zzbz3;
        zzbz zzbz5 = zzbz2;
        zzbz zzbz6 = new zzbz(-1, null, null);
        this.zzpg = zzbz5;
    }

    public com.google.android.gms.dynamic.zzd zzaM() {
        zzx.zzcD("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.dynamic.zze.zzC(this.zzpj.zzrm);
    }

    public AdSizeParcel zzaN() {
        ThinAdSizeParcel thinAdSizeParcel;
        zzx.zzcD("getAdSize must be called on the main UI thread.");
        if (this.zzpj.zzrp == null) {
            return null;
        }
        ThinAdSizeParcel thinAdSizeParcel2 = thinAdSizeParcel;
        ThinAdSizeParcel thinAdSizeParcel3 = new ThinAdSizeParcel(this.zzpj.zzrp);
        return thinAdSizeParcel2;
    }

    public void zzaO() {
        zzaR();
    }

    public void zzaP() {
        zzx.zzcD("recordManualImpression must be called on the main UI thread.");
        if (this.zzpj.zzrq == null) {
            zzin.zzaK("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzin.zzaI("Pinging manual tracking URLs.");
        if (this.zzpj.zzrq.zzHV != null && !this.zzpj.zzrq.zzLc) {
            zzr.zzbC().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq.zzHV);
            this.zzpj.zzrq.zzLc = true;
        }
    }

    /* access modifiers changed from: protected */
    public void zzaQ() {
        zzin.zzaJ("Ad closing.");
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdClosed();
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdClosed();
            } catch (RemoteException e2) {
                zzin.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzaR() {
        zzin.zzaJ("Ad leaving application.");
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdLeftApplication();
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdLeftApplication();
            } catch (RemoteException e2) {
                zzin.zzd("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzaS() {
        zzin.zzaJ("Ad opening.");
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdOpened();
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdOpened();
            } catch (RemoteException e2) {
                zzin.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzaT() {
        zzin.zzaJ("Ad finished loading.");
        this.zzph = false;
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdLoaded();
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdLoaded();
            } catch (RemoteException e2) {
                zzin.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzaU() {
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoStarted();
            } catch (RemoteException e) {
                zzin.zzd("Could not call RewardedVideoAdListener.onVideoStarted().", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(View view) {
        View view2 = view;
        this.zzpj.zzrm.addView(view2, zzr.zzbE().zzhy());
    }

    public void zzb(zzif zzif) {
        zzik zzik;
        zzif zzif2 = zzif;
        zzcb zzcb = this.zzpe;
        zzbz zzbz = this.zzpg;
        String[] strArr = new String[1];
        String[] strArr2 = strArr;
        strArr[0] = "awr";
        boolean zza = zzcb.zza(zzbz, strArr2);
        this.zzpj.zzro = null;
        if (!(zzif2.errorCode == -2 || zzif2.errorCode == 3)) {
            zzr.zzbF().zzb(this.zzpj.zzbS());
        }
        if (zzif2.errorCode == -1) {
            this.zzph = false;
            return;
        }
        if (zza(zzif2)) {
            zzin.zzaI("Ad refresh scheduled.");
        }
        if (zzif2.errorCode != -2) {
            zzf(zzif2.errorCode);
            return;
        }
        if (this.zzpj.zzrJ == null) {
            zzs zzs = this.zzpj;
            zzik zzik2 = zzik;
            zzik zzik3 = new zzik(this.zzpj.zzrj);
            zzs.zzrJ = zzik2;
        }
        this.zzpl.zzi(this.zzpj.zzrq);
        if (zza(this.zzpj.zzrq, zzif2)) {
            this.zzpj.zzrq = zzif2;
            this.zzpj.zzcb();
            this.zzpe.zzc("is_mraid", this.zzpj.zzrq.zzcv() ? "1" : "0");
            this.zzpe.zzc("is_mediation", this.zzpj.zzrq.zzHT ? "1" : "0");
            if (!(this.zzpj.zzrq.zzED == null || this.zzpj.zzrq.zzED.zzhU() == null)) {
                this.zzpe.zzc("is_video", this.zzpj.zzrq.zzED.zzhU().zzih() ? "1" : "0");
            }
            zzcb zzcb2 = this.zzpe;
            zzbz zzbz2 = this.zzpf;
            String[] strArr3 = new String[1];
            String[] strArr4 = strArr3;
            strArr3[0] = "ttc";
            boolean zza2 = zzcb2.zza(zzbz2, strArr4);
            if (zzr.zzbF().zzhb() != null) {
                boolean zza3 = zzr.zzbF().zzhb().zza(this.zzpe);
            }
            if (this.zzpj.zzbW()) {
                zzaT();
            }
        }
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        StringBuilder sb;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        zzx.zzcD("loadAd must be called on the main UI thread.");
        AdRequestParcel zza = zza(adRequestParcel2);
        if (this.zzpj.zzrn == null && this.zzpj.zzro == null) {
            zzin.zzaJ("Starting ad request.");
            zzaL();
            this.zzpf = this.zzpe.zzdB();
            if (!zza.zztF) {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                zzin.zzaJ(sb2.append("Use AdRequest.Builder.addTestDevice(\"").append(zzn.zzcS().zzT(this.zzpj.context)).append("\") to get test ads on this device.").toString());
            }
            this.zzph = zza(zza, this.zzpe);
            return this.zzph;
        }
        if (this.zzpk != null) {
            zzin.zzaK("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        } else {
            zzin.zzaK("Loading already in progress, saving this object for future refreshes.");
        }
        this.zzpk = zza;
        return false;
    }

    /* access modifiers changed from: protected */
    public void zzc(zzif zzif) {
        zzif zzif2 = zzif;
        if (zzif2 == null) {
            zzin.zzaK("Ad state was null when trying to ping impression URLs.");
            return;
        }
        zzin.zzaI("Pinging Impression URLs.");
        this.zzpj.zzrs.zzgS();
        if (zzif2.zzBR != null && !zzif2.zzLb) {
            zzr.zzbC().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, zzif2.zzBR);
            zzif2.zzLb = true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzc(AdRequestParcel adRequestParcel) {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        ViewParent parent = this.zzpj.zzrm.getParent();
        return (parent instanceof View) && ((View) parent).isShown() && zzr.zzbC().zzhq();
    }

    public void zzd(AdRequestParcel adRequestParcel) {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        if (zzc(adRequestParcel2)) {
            boolean zzb = zzb(adRequestParcel2);
            return;
        }
        zzin.zzaJ("Ad is not visible. Not refreshing ad.");
        this.zzpi.zzg(adRequestParcel2);
    }

    /* access modifiers changed from: protected */
    public void zzf(int i) {
        StringBuilder sb;
        int i2 = i;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.zzaK(sb2.append("Failed to load ad: ").append(i2).toString());
        this.zzph = false;
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdFailedToLoad(i2);
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdFailedToLoad(i2);
            } catch (RemoteException e2) {
                zzin.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public long zzp(@NonNull String str) {
        String str2 = str;
        int indexOf = str2.indexOf("ufe");
        int indexOf2 = str2.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str2.length();
        }
        try {
            return Long.parseLong(str2.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException indexOutOfBoundsException = e;
            zzin.zzaK("Invalid index for Url fetch time in CSI latency info.");
            return -1;
        } catch (NumberFormatException e2) {
            NumberFormatException numberFormatException = e2;
            zzin.zzaK("Cannot find valid format of Url fetch time in CSI latency info.");
            return -1;
        }
    }
}
