package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.client.zzg;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgi;
import com.google.android.gms.internal.zzgm;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzac {
    private final Context mContext;
    private String zzaW;
    private RewardedVideoAdListener zzaX;
    private final zzh zzoB;
    private String zzpS;
    private AdListener zztA;
    private zza zztz;
    private final zzew zzuJ;
    private zzu zzuL;
    private String zzuM;
    private InAppPurchaseListener zzuO;
    private PlayStorePurchaseListener zzuP;
    private OnCustomRenderedAdLoadedListener zzuQ;
    private Correlator zzuR;
    private PublisherInterstitialAd zzuT;
    private boolean zzuU;
    private AppEventListener zzun;

    public zzac(Context context) {
        this(context, zzh.zzcO(), null);
    }

    public zzac(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzh.zzcO(), publisherInterstitialAd);
    }

    public zzac(Context context, zzh zzh, PublisherInterstitialAd publisherInterstitialAd) {
        zzew zzew;
        Context context2 = context;
        zzh zzh2 = zzh;
        PublisherInterstitialAd publisherInterstitialAd2 = publisherInterstitialAd;
        zzew zzew2 = zzew;
        zzew zzew3 = new zzew();
        this.zzuJ = zzew2;
        this.mContext = context2;
        this.zzoB = zzh2;
        this.zzuT = publisherInterstitialAd2;
    }

    private void zzH(String str) throws RemoteException {
        AdSizeParcel adSizeParcel;
        AdSizeParcel adSizeParcel2;
        zzg zzg;
        zzcg zzcg;
        zzgm zzgm;
        zzgi zzgi;
        zzj zzj;
        zzb zzb;
        zzc zzc;
        String str2 = str;
        if (this.zzpS == null) {
            zzI(str2);
        }
        if (this.zzuU) {
            adSizeParcel2 = AdSizeParcel.zzcP();
        } else {
            AdSizeParcel adSizeParcel3 = adSizeParcel;
            AdSizeParcel adSizeParcel4 = new AdSizeParcel();
            adSizeParcel2 = adSizeParcel3;
        }
        this.zzuL = zzn.zzcT().zzb(this.mContext, adSizeParcel2, this.zzpS, this.zzuJ);
        if (this.zztA != null) {
            zzu zzu = this.zzuL;
            zzc zzc2 = zzc;
            zzc zzc3 = new zzc(this.zztA);
            zzu.zza((zzq) zzc2);
        }
        if (this.zztz != null) {
            zzu zzu2 = this.zzuL;
            zzb zzb2 = zzb;
            zzb zzb3 = new zzb(this.zztz);
            zzu2.zza((zzp) zzb2);
        }
        if (this.zzun != null) {
            zzu zzu3 = this.zzuL;
            zzj zzj2 = zzj;
            zzj zzj3 = new zzj(this.zzun);
            zzu3.zza((zzw) zzj2);
        }
        if (this.zzuO != null) {
            zzu zzu4 = this.zzuL;
            zzgi zzgi2 = zzgi;
            zzgi zzgi3 = new zzgi(this.zzuO);
            zzu4.zza((zzgd) zzgi2);
        }
        if (this.zzuP != null) {
            zzu zzu5 = this.zzuL;
            zzgm zzgm2 = zzgm;
            zzgm zzgm3 = new zzgm(this.zzuP);
            zzu5.zza(zzgm2, this.zzuM);
        }
        if (this.zzuQ != null) {
            zzu zzu6 = this.zzuL;
            zzcg zzcg2 = zzcg;
            zzcg zzcg3 = new zzcg(this.zzuQ);
            zzu6.zza((zzcf) zzcg2);
        }
        if (this.zzuR != null) {
            this.zzuL.zza((zzx) this.zzuR.zzaF());
        }
        if (this.zzaX != null) {
            zzu zzu7 = this.zzuL;
            zzg zzg2 = zzg;
            zzg zzg3 = new zzg(this.zzaX);
            zzu7.zza((zzd) zzg2);
        }
        if (this.zzaW != null) {
            this.zzuL.setUserId(this.zzaW);
        }
    }

    private void zzI(String str) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        String str2 = str;
        if (this.zzuL == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("The ad unit ID must be set on InterstitialAd before ").append(str2).append(" is called.").toString());
            throw illegalStateException2;
        }
    }

    public AdListener getAdListener() {
        return this.zztA;
    }

    public String getAdUnitId() {
        return this.zzpS;
    }

    public AppEventListener getAppEventListener() {
        return this.zzun;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzuO;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.zzuL != null) {
                return this.zzuL.getMediationAdapterClassName();
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzuQ;
    }

    public boolean isLoaded() {
        try {
            if (this.zzuL == null) {
                return false;
            }
            return this.zzuL.isReady();
        } catch (RemoteException e) {
            zzb.zzd("Failed to check if ad is ready.", e);
            return false;
        }
    }

    public boolean isLoading() {
        try {
            if (this.zzuL == null) {
                return false;
            }
            return this.zzuL.isLoading();
        } catch (RemoteException e) {
            zzb.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public void setAdListener(AdListener adListener) {
        zzc zzc;
        zzc zzc2;
        AdListener adListener2 = adListener;
        try {
            this.zztA = adListener2;
            if (this.zzuL != null) {
                zzu zzu = this.zzuL;
                if (adListener2 != null) {
                    zzc zzc3 = zzc2;
                    zzc zzc4 = new zzc(adListener2);
                    zzc = zzc3;
                } else {
                    zzc = null;
                }
                zzu.zza((zzq) zzc);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String str) {
        IllegalStateException illegalStateException;
        String str2 = str;
        if (this.zzpS != null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
            throw illegalStateException2;
        }
        this.zzpS = str2;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        zzj zzj;
        zzj zzj2;
        AppEventListener appEventListener2 = appEventListener;
        try {
            this.zzun = appEventListener2;
            if (this.zzuL != null) {
                zzu zzu = this.zzuL;
                if (appEventListener2 != null) {
                    zzj zzj3 = zzj2;
                    zzj zzj4 = new zzj(appEventListener2);
                    zzj = zzj3;
                } else {
                    zzj = null;
                }
                zzu.zza((zzw) zzj);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the AppEventListener.", e);
        }
    }

    public void setCorrelator(Correlator correlator) {
        this.zzuR = correlator;
        try {
            if (this.zzuL != null) {
                this.zzuL.zza((zzx) this.zzuR == null ? null : this.zzuR.zzaF());
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set correlator.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        zzgi zzgi;
        zzgi zzgi2;
        IllegalStateException illegalStateException;
        InAppPurchaseListener inAppPurchaseListener2 = inAppPurchaseListener;
        if (this.zzuP != null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Play store purchase parameter has already been set.");
            throw illegalStateException2;
        }
        try {
            this.zzuO = inAppPurchaseListener2;
            if (this.zzuL != null) {
                zzu zzu = this.zzuL;
                if (inAppPurchaseListener2 != null) {
                    zzgi zzgi3 = zzgi2;
                    zzgi zzgi4 = new zzgi(inAppPurchaseListener2);
                    zzgi = zzgi3;
                } else {
                    zzgi = null;
                }
                zzu.zza((zzgd) zzgi);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        zzcg zzcg;
        zzcg zzcg2;
        OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener2 = onCustomRenderedAdLoadedListener;
        try {
            this.zzuQ = onCustomRenderedAdLoadedListener2;
            if (this.zzuL != null) {
                zzu zzu = this.zzuL;
                if (onCustomRenderedAdLoadedListener2 != null) {
                    zzcg zzcg3 = zzcg2;
                    zzcg zzcg4 = new zzcg(onCustomRenderedAdLoadedListener2);
                    zzcg = zzcg3;
                } else {
                    zzcg = null;
                }
                zzu.zza((zzcf) zzcg);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        zzgm zzgm;
        zzgm zzgm2;
        IllegalStateException illegalStateException;
        PlayStorePurchaseListener playStorePurchaseListener2 = playStorePurchaseListener;
        String str2 = str;
        if (this.zzuO != null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("In app purchase parameter has already been set.");
            throw illegalStateException2;
        }
        try {
            this.zzuP = playStorePurchaseListener2;
            this.zzuM = str2;
            if (this.zzuL != null) {
                zzu zzu = this.zzuL;
                if (playStorePurchaseListener2 != null) {
                    zzgm zzgm3 = zzgm2;
                    zzgm zzgm4 = new zzgm(playStorePurchaseListener2);
                    zzgm = zzgm3;
                } else {
                    zzgm = null;
                }
                zzu.zza(zzgm, str2);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the play store purchase parameter.", e);
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        zzg zzg;
        zzg zzg2;
        RewardedVideoAdListener rewardedVideoAdListener2 = rewardedVideoAdListener;
        try {
            this.zzaX = rewardedVideoAdListener2;
            if (this.zzuL != null) {
                zzu zzu = this.zzuL;
                if (rewardedVideoAdListener2 != null) {
                    zzg zzg3 = zzg2;
                    zzg zzg4 = new zzg(rewardedVideoAdListener2);
                    zzg = zzg3;
                } else {
                    zzg = null;
                }
                zzu.zza((zzd) zzg);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the AdListener.", e);
        }
    }

    public void setUserId(String str) {
        String str2 = str;
        try {
            this.zzaW = str2;
            if (this.zzuL != null) {
                this.zzuL.setUserId(str2);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the AdListener.", e);
        }
    }

    public void show() {
        try {
            zzI("show");
            this.zzuL.showInterstitial();
        } catch (RemoteException e) {
            zzb.zzd("Failed to show interstitial.", e);
        }
    }

    public void zza(zza zza) {
        zzb zzb;
        zzb zzb2;
        zza zza2 = zza;
        try {
            this.zztz = zza2;
            if (this.zzuL != null) {
                zzu zzu = this.zzuL;
                if (zza2 != null) {
                    zzb zzb3 = zzb2;
                    zzb zzb4 = new zzb(zza2);
                    zzb = zzb3;
                } else {
                    zzb = null;
                }
                zzu.zza((zzp) zzb);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the AdClickListener.", e);
        }
    }

    public void zza(zzaa zzaa) {
        zzaa zzaa2 = zzaa;
        try {
            if (this.zzuL == null) {
                zzH("loadAd");
            }
            if (this.zzuL.zzb(this.zzoB.zza(this.mContext, zzaa2))) {
                this.zzuJ.zzg(zzaa2.zzdb());
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to load ad.", e);
        }
    }

    public void zza(boolean z) {
        boolean z2 = z;
        this.zzuU = z2;
    }
}
