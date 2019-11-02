package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzhb
public final class zzfk<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */
    public final zzez zzCK;

    public zzfk(zzez zzez) {
        this.zzCK = zzez;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C03561 r7;
        MediationBannerAdapter<?, ?> mediationBannerAdapter2 = mediationBannerAdapter;
        zzb.zzaI("Adapter called onClick.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onClick must be called on the main UI thread.");
            Handler handler = zza.zzMS;
            C03561 r4 = r7;
            C03561 r5 = new Runnable(this) {
                final /* synthetic */ zzfk zzCQ;

                {
                    this.zzCQ = r5;
                }

                public void run() {
                    try {
                        this.zzCQ.zzCK.onAdClicked();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdClicked.", e);
                    }
                }
            };
            boolean post = handler.post(r4);
            return;
        }
        try {
            this.zzCK.onAdClicked();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C03614 r7;
        MediationBannerAdapter<?, ?> mediationBannerAdapter2 = mediationBannerAdapter;
        zzb.zzaI("Adapter called onDismissScreen.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onDismissScreen must be called on the main UI thread.");
            Handler handler = zza.zzMS;
            C03614 r4 = r7;
            C03614 r5 = new Runnable(this) {
                final /* synthetic */ zzfk zzCQ;

                {
                    this.zzCQ = r5;
                }

                public void run() {
                    try {
                        this.zzCQ.zzCK.onAdClosed();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdClosed.", e);
                    }
                }
            };
            boolean post = handler.post(r4);
            return;
        }
        try {
            this.zzCK.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C03669 r7;
        MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter2 = mediationInterstitialAdapter;
        zzb.zzaI("Adapter called onDismissScreen.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onDismissScreen must be called on the main UI thread.");
            Handler handler = zza.zzMS;
            C03669 r4 = r7;
            C03669 r5 = new Runnable(this) {
                final /* synthetic */ zzfk zzCQ;

                {
                    this.zzCQ = r5;
                }

                public void run() {
                    try {
                        this.zzCQ.zzCK.onAdClosed();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdClosed.", e);
                    }
                }
            };
            boolean post = handler.post(r4);
            return;
        }
        try {
            this.zzCK.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, ErrorCode errorCode) {
        StringBuilder sb;
        C03625 r9;
        MediationBannerAdapter<?, ?> mediationBannerAdapter2 = mediationBannerAdapter;
        ErrorCode errorCode2 = errorCode;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzb.zzaI(sb2.append("Adapter called onFailedToReceiveAd with error. ").append(errorCode2).toString());
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onFailedToReceiveAd must be called on the main UI thread.");
            Handler handler = zza.zzMS;
            C03625 r5 = r9;
            final ErrorCode errorCode3 = errorCode2;
            C03625 r6 = new Runnable(this) {
                final /* synthetic */ zzfk zzCQ;

                {
                    ErrorCode errorCode = r7;
                    this.zzCQ = r6;
                }

                public void run() {
                    try {
                        this.zzCQ.zzCK.onAdFailedToLoad(zzfl.zza(errorCode3));
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdFailedToLoad.", e);
                    }
                }
            };
            boolean post = handler.post(r5);
            return;
        }
        try {
            this.zzCK.onAdFailedToLoad(zzfl.zza(errorCode2));
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode) {
        StringBuilder sb;
        C035710 r9;
        MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter2 = mediationInterstitialAdapter;
        ErrorCode errorCode2 = errorCode;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzb.zzaI(sb2.append("Adapter called onFailedToReceiveAd with error ").append(errorCode2).append(".").toString());
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onFailedToReceiveAd must be called on the main UI thread.");
            Handler handler = zza.zzMS;
            C035710 r5 = r9;
            final ErrorCode errorCode3 = errorCode2;
            C035710 r6 = new Runnable(this) {
                final /* synthetic */ zzfk zzCQ;

                {
                    ErrorCode errorCode = r7;
                    this.zzCQ = r6;
                }

                public void run() {
                    try {
                        this.zzCQ.zzCK.onAdFailedToLoad(zzfl.zza(errorCode3));
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdFailedToLoad.", e);
                    }
                }
            };
            boolean post = handler.post(r5);
            return;
        }
        try {
            this.zzCK.onAdFailedToLoad(zzfl.zza(errorCode2));
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C03636 r7;
        MediationBannerAdapter<?, ?> mediationBannerAdapter2 = mediationBannerAdapter;
        zzb.zzaI("Adapter called onLeaveApplication.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onLeaveApplication must be called on the main UI thread.");
            Handler handler = zza.zzMS;
            C03636 r4 = r7;
            C03636 r5 = new Runnable(this) {
                final /* synthetic */ zzfk zzCQ;

                {
                    this.zzCQ = r5;
                }

                public void run() {
                    try {
                        this.zzCQ.zzCK.onAdLeftApplication();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLeftApplication.", e);
                    }
                }
            };
            boolean post = handler.post(r4);
            return;
        }
        try {
            this.zzCK.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C035811 r7;
        MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter2 = mediationInterstitialAdapter;
        zzb.zzaI("Adapter called onLeaveApplication.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onLeaveApplication must be called on the main UI thread.");
            Handler handler = zza.zzMS;
            C035811 r4 = r7;
            C035811 r5 = new Runnable(this) {
                final /* synthetic */ zzfk zzCQ;

                {
                    this.zzCQ = r5;
                }

                public void run() {
                    try {
                        this.zzCQ.zzCK.onAdLeftApplication();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLeftApplication.", e);
                    }
                }
            };
            boolean post = handler.post(r4);
            return;
        }
        try {
            this.zzCK.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C03647 r7;
        MediationBannerAdapter<?, ?> mediationBannerAdapter2 = mediationBannerAdapter;
        zzb.zzaI("Adapter called onPresentScreen.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onPresentScreen must be called on the main UI thread.");
            Handler handler = zza.zzMS;
            C03647 r4 = r7;
            C03647 r5 = new Runnable(this) {
                final /* synthetic */ zzfk zzCQ;

                {
                    this.zzCQ = r5;
                }

                public void run() {
                    try {
                        this.zzCQ.zzCK.onAdOpened();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdOpened.", e);
                    }
                }
            };
            boolean post = handler.post(r4);
            return;
        }
        try {
            this.zzCK.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C03592 r7;
        MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter2 = mediationInterstitialAdapter;
        zzb.zzaI("Adapter called onPresentScreen.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onPresentScreen must be called on the main UI thread.");
            Handler handler = zza.zzMS;
            C03592 r4 = r7;
            C03592 r5 = new Runnable(this) {
                final /* synthetic */ zzfk zzCQ;

                {
                    this.zzCQ = r5;
                }

                public void run() {
                    try {
                        this.zzCQ.zzCK.onAdOpened();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdOpened.", e);
                    }
                }
            };
            boolean post = handler.post(r4);
            return;
        }
        try {
            this.zzCK.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C03658 r7;
        MediationBannerAdapter<?, ?> mediationBannerAdapter2 = mediationBannerAdapter;
        zzb.zzaI("Adapter called onReceivedAd.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onReceivedAd must be called on the main UI thread.");
            Handler handler = zza.zzMS;
            C03658 r4 = r7;
            C03658 r5 = new Runnable(this) {
                final /* synthetic */ zzfk zzCQ;

                {
                    this.zzCQ = r5;
                }

                public void run() {
                    try {
                        this.zzCQ.zzCK.onAdLoaded();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLoaded.", e);
                    }
                }
            };
            boolean post = handler.post(r4);
            return;
        }
        try {
            this.zzCK.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C03603 r7;
        MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter2 = mediationInterstitialAdapter;
        zzb.zzaI("Adapter called onReceivedAd.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onReceivedAd must be called on the main UI thread.");
            Handler handler = zza.zzMS;
            C03603 r4 = r7;
            C03603 r5 = new Runnable(this) {
                final /* synthetic */ zzfk zzCQ;

                {
                    this.zzCQ = r5;
                }

                public void run() {
                    try {
                        this.zzCQ.zzCK.onAdLoaded();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLoaded.", e);
                    }
                }
            };
            boolean post = handler.post(r4);
            return;
        }
        try {
            this.zzCK.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }
}
