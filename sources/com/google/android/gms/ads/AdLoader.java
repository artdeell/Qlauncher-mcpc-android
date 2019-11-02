package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.ads.internal.client.zzaa;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzd;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzew;

public class AdLoader {
    private final Context mContext;
    private final zzh zzoB;
    private final zzr zzoC;

    public static class Builder {
        private final Context mContext;
        private final zzs zzoD;

        Builder(Context context, zzs zzs) {
            zzs zzs2 = zzs;
            this.mContext = context;
            this.zzoD = zzs2;
        }

        public Builder(Context context, String str) {
            zzew zzew;
            Context context2 = context;
            Context context3 = (Context) zzx.zzb(context2, (Object) "context cannot be null");
            Context context4 = context2;
            String str2 = str;
            zzew zzew2 = zzew;
            zzew zzew3 = new zzew();
            this(context3, zzd.zza(context4, str2, zzew2));
        }

        public AdLoader build() {
            AdLoader adLoader;
            try {
                AdLoader adLoader2 = adLoader;
                AdLoader adLoader3 = new AdLoader(this.mContext, this.zzoD.zzbn());
                return adLoader2;
            } catch (RemoteException e) {
                zzb.zzb("Failed to build AdLoader.", e);
                return null;
            }
        }

        public Builder forAppInstallAd(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            zzcw zzcw;
            OnAppInstallAdLoadedListener onAppInstallAdLoadedListener2 = onAppInstallAdLoadedListener;
            try {
                zzs zzs = this.zzoD;
                zzcw zzcw2 = zzcw;
                zzcw zzcw3 = new zzcw(onAppInstallAdLoadedListener2);
                zzs.zza((zzcr) zzcw2);
                return this;
            } catch (RemoteException e) {
                zzb.zzd("Failed to add app install ad listener", e);
                return this;
            }
        }

        public Builder forContentAd(OnContentAdLoadedListener onContentAdLoadedListener) {
            zzcx zzcx;
            OnContentAdLoadedListener onContentAdLoadedListener2 = onContentAdLoadedListener;
            try {
                zzs zzs = this.zzoD;
                zzcx zzcx2 = zzcx;
                zzcx zzcx3 = new zzcx(onContentAdLoadedListener2);
                zzs.zza((zzcs) zzcx2);
                return this;
            } catch (RemoteException e) {
                zzb.zzd("Failed to add content ad listener", e);
                return this;
            }
        }

        public Builder forCustomTemplateAd(String str, OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, OnCustomClickListener onCustomClickListener) {
            zzcz zzcz;
            zzcy zzcy;
            zzcy zzcy2;
            String str2 = str;
            OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener2 = onCustomTemplateAdLoadedListener;
            OnCustomClickListener onCustomClickListener2 = onCustomClickListener;
            try {
                zzs zzs = this.zzoD;
                zzcz zzcz2 = zzcz;
                zzcz zzcz3 = new zzcz(onCustomTemplateAdLoadedListener2);
                zzcz zzcz4 = zzcz2;
                if (onCustomClickListener2 == null) {
                    zzcy2 = null;
                } else {
                    zzcy zzcy3 = zzcy;
                    zzcy zzcy4 = new zzcy(onCustomClickListener2);
                    zzcy2 = zzcy3;
                }
                zzs.zza(str2, zzcz4, zzcy2);
                return this;
            } catch (RemoteException e) {
                zzb.zzd("Failed to add custom template ad listener", e);
                return this;
            }
        }

        public Builder withAdListener(AdListener adListener) {
            zzc zzc;
            AdListener adListener2 = adListener;
            try {
                zzs zzs = this.zzoD;
                zzc zzc2 = zzc;
                zzc zzc3 = new zzc(adListener2);
                zzs.zzb((zzq) zzc2);
                return this;
            } catch (RemoteException e) {
                zzb.zzd("Failed to set AdListener.", e);
                return this;
            }
        }

        public Builder withCorrelator(@NonNull Correlator correlator) {
            Correlator correlator2 = correlator;
            Object zzz = zzx.zzz(correlator2);
            try {
                this.zzoD.zzb((com.google.android.gms.ads.internal.client.zzx) correlator2.zzaF());
                return this;
            } catch (RemoteException e) {
                zzb.zzd("Failed to set correlator.", e);
                return this;
            }
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            NativeAdOptionsParcel nativeAdOptionsParcel;
            NativeAdOptions nativeAdOptions2 = nativeAdOptions;
            try {
                zzs zzs = this.zzoD;
                NativeAdOptionsParcel nativeAdOptionsParcel2 = nativeAdOptionsParcel;
                NativeAdOptionsParcel nativeAdOptionsParcel3 = new NativeAdOptionsParcel(nativeAdOptions2);
                zzs.zza(nativeAdOptionsParcel2);
                return this;
            } catch (RemoteException e) {
                zzb.zzd("Failed to specify native ad options", e);
                return this;
            }
        }
    }

    AdLoader(Context context, zzr zzr) {
        this(context, zzr, zzh.zzcO());
    }

    AdLoader(Context context, zzr zzr, zzh zzh) {
        zzr zzr2 = zzr;
        zzh zzh2 = zzh;
        this.mContext = context;
        this.zzoC = zzr2;
        this.zzoB = zzh2;
    }

    private void zza(zzaa zzaa) {
        try {
            this.zzoC.zzf(this.zzoB.zza(this.mContext, zzaa));
        } catch (RemoteException e) {
            zzb.zzb("Failed to load ad.", e);
        }
    }

    public String getMediationAdapterClassName() {
        try {
            return this.zzoC.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzb.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzoC.isLoading();
        } catch (RemoteException e) {
            zzb.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzaE());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzaE());
    }
}
