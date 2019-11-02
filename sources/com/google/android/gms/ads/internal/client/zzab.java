package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgi;
import com.google.android.gms.internal.zzgm;
import com.google.android.gms.internal.zzhb;
import java.util.concurrent.atomic.AtomicBoolean;

@zzhb
public class zzab {
    private final zzh zzoB;
    private boolean zzpE;
    private String zzpS;
    private AdListener zztA;
    private zza zztz;
    private final zzew zzuJ;
    private final AtomicBoolean zzuK;
    private zzu zzuL;
    private String zzuM;
    private ViewGroup zzuN;
    private InAppPurchaseListener zzuO;
    private PlayStorePurchaseListener zzuP;
    private OnCustomRenderedAdLoadedListener zzuQ;
    private Correlator zzuR;
    private boolean zzuS;
    private AppEventListener zzun;
    private AdSize[] zzuo;

    public zzab(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzh.zzcO(), false);
    }

    public zzab(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzh.zzcO(), false);
    }

    zzab(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzh zzh, zzu zzu, boolean z2) {
        zzew zzew;
        AtomicBoolean atomicBoolean;
        AdSizeParcel adSizeParcel;
        zzk zzk;
        ViewGroup viewGroup2 = viewGroup;
        AttributeSet attributeSet2 = attributeSet;
        boolean z3 = z;
        zzh zzh2 = zzh;
        zzu zzu2 = zzu;
        boolean z4 = z2;
        zzew zzew2 = zzew;
        zzew zzew3 = new zzew();
        this.zzuJ = zzew2;
        this.zzuN = viewGroup2;
        this.zzoB = zzh2;
        this.zzuL = zzu2;
        AtomicBoolean atomicBoolean2 = atomicBoolean;
        AtomicBoolean atomicBoolean3 = new AtomicBoolean(false);
        this.zzuK = atomicBoolean2;
        this.zzuS = z4;
        if (attributeSet2 != null) {
            Context context = viewGroup2.getContext();
            try {
                zzk zzk2 = zzk;
                zzk zzk3 = new zzk(context, attributeSet2);
                zzk zzk4 = zzk2;
                this.zzuo = zzk4.zzj(z3);
                this.zzpS = zzk4.getAdUnitId();
                if (viewGroup2.isInEditMode()) {
                    zzn.zzcS().zza(viewGroup2, zza(context, this.zzuo[0], this.zzuS), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                IllegalArgumentException illegalArgumentException = e;
                zza zzcS = zzn.zzcS();
                ViewGroup viewGroup3 = viewGroup2;
                AdSizeParcel adSizeParcel2 = adSizeParcel;
                AdSizeParcel adSizeParcel3 = new AdSizeParcel(context, AdSize.BANNER);
                zzcS.zza(viewGroup3, adSizeParcel2, illegalArgumentException.getMessage(), illegalArgumentException.getMessage());
            }
        }
    }

    zzab(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzh zzh, boolean z2) {
        this(viewGroup, attributeSet, z, zzh, null, z2);
    }

    public zzab(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, boolean z2) {
        this(viewGroup, attributeSet, z, zzh.zzcO(), z2);
    }

    public zzab(ViewGroup viewGroup, boolean z) {
        this(viewGroup, null, false, zzh.zzcO(), z);
    }

    private static AdSizeParcel zza(Context context, AdSize adSize, boolean z) {
        AdSizeParcel adSizeParcel;
        boolean z2 = z;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        AdSizeParcel adSizeParcel3 = new AdSizeParcel(context, adSize);
        AdSizeParcel adSizeParcel4 = adSizeParcel2;
        adSizeParcel4.zzi(z2);
        return adSizeParcel4;
    }

    private static AdSizeParcel zza(Context context, AdSize[] adSizeArr, boolean z) {
        AdSizeParcel adSizeParcel;
        boolean z2 = z;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        AdSizeParcel adSizeParcel3 = new AdSizeParcel(context, adSizeArr);
        AdSizeParcel adSizeParcel4 = adSizeParcel2;
        adSizeParcel4.zzi(z2);
        return adSizeParcel4;
    }

    private void zzdf() {
        try {
            zzd zzaM = this.zzuL.zzaM();
            if (zzaM != null) {
                this.zzuN.addView((View) zze.zzp(zzaM));
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to get an ad frame.", e);
        }
    }

    public void destroy() {
        try {
            if (this.zzuL != null) {
                this.zzuL.destroy();
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.zztA;
    }

    public AdSize getAdSize() {
        try {
            if (this.zzuL != null) {
                AdSizeParcel zzaN = this.zzuL.zzaN();
                if (zzaN != null) {
                    return zzaN.zzcQ();
                }
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to get the current AdSize.", e);
        }
        if (this.zzuo != null) {
            return this.zzuo[0];
        }
        return null;
    }

    public AdSize[] getAdSizes() {
        return this.zzuo;
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

    public boolean isLoading() {
        try {
            if (this.zzuL != null) {
                return this.zzuL.isLoading();
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to check if ad is loading.", e);
        }
        return false;
    }

    public void pause() {
        try {
            if (this.zzuL != null) {
                this.zzuL.pause();
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        if (!this.zzuK.getAndSet(true)) {
            try {
                if (this.zzuL != null) {
                    this.zzuL.zzaP();
                }
            } catch (RemoteException e) {
                zzb.zzd("Failed to record impression.", e);
            }
        }
    }

    public void resume() {
        try {
            if (this.zzuL != null) {
                this.zzuL.resume();
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to call resume.", e);
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

    public void setAdSizes(AdSize... adSizeArr) {
        IllegalStateException illegalStateException;
        AdSize[] adSizeArr2 = adSizeArr;
        if (this.zzuo != null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("The ad size can only be set once on AdView.");
            throw illegalStateException2;
        }
        zza(adSizeArr2);
    }

    public void setAdUnitId(String str) {
        IllegalStateException illegalStateException;
        String str2 = str;
        if (this.zzpS != null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("The ad unit ID can only be set once on AdView.");
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

    public void setManualImpressionsEnabled(boolean z) {
        this.zzpE = z;
        try {
            if (this.zzuL != null) {
                this.zzuL.setManualImpressionsEnabled(this.zzpE);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set manual impressions.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        zzcg zzcg;
        zzcg zzcg2;
        OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener2 = onCustomRenderedAdLoadedListener;
        this.zzuQ = onCustomRenderedAdLoadedListener2;
        try {
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
            zzb.zzd("Failed to set the onCustomRenderedAdLoadedListener.", e);
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
            IllegalStateException illegalStateException3 = new IllegalStateException("InAppPurchaseListener has already been set.");
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
                zzdg();
            }
            if (this.zzuL.zzb(this.zzoB.zza(this.zzuN.getContext(), zzaa2))) {
                this.zzuJ.zzg(zzaa2.zzdb());
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to load ad.", e);
        }
    }

    public void zza(AdSize... adSizeArr) {
        this.zzuo = adSizeArr;
        try {
            if (this.zzuL != null) {
                this.zzuL.zza(zza(this.zzuN.getContext(), this.zzuo, this.zzuS));
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the ad size.", e);
        }
        this.zzuN.requestLayout();
    }

    /* access modifiers changed from: 0000 */
    public void zzdg() throws RemoteException {
        zzcg zzcg;
        zzgm zzgm;
        zzgi zzgi;
        zzj zzj;
        zzb zzb;
        zzc zzc;
        IllegalStateException illegalStateException;
        if ((this.zzuo == null || this.zzpS == null) && this.zzuL == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
            throw illegalStateException2;
        }
        this.zzuL = zzdh();
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
        this.zzuL.setManualImpressionsEnabled(this.zzpE);
        zzdf();
    }

    /* access modifiers changed from: protected */
    public zzu zzdh() throws RemoteException {
        Context context = this.zzuN.getContext();
        return zzn.zzcT().zza(context, zza(context, this.zzuo, this.zzuS), this.zzpS, this.zzuJ);
    }
}
