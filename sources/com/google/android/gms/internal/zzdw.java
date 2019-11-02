package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzr;
import java.util.LinkedList;
import java.util.List;

@zzhb
class zzdw {
    /* access modifiers changed from: private */
    public final List<zza> zzpH;

    interface zza {
        void zzb(zzdx zzdx) throws RemoteException;
    }

    zzdw() {
        LinkedList linkedList;
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList();
        this.zzpH = linkedList2;
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzdx zzdx) {
        C03247 r10;
        zzdx zzdx2 = zzdx;
        Handler handler = zzir.zzMc;
        for (final zza zza2 : this.zzpH) {
            Handler handler2 = handler;
            C03247 r5 = r10;
            final zzdx zzdx3 = zzdx2;
            C03247 r6 = new Runnable(this) {
                final /* synthetic */ zzdw zzAc;

                {
                    zza zza = r8;
                    zzdx zzdx = r9;
                    this.zzAc = r7;
                }

                public void run() {
                    try {
                        zza2.zzb(zzdx3);
                    } catch (RemoteException e) {
                        zzin.zzd("Could not propagate interstitial ad event.", e);
                    }
                }
            };
            boolean post = handler2.post(r5);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzc(zzk zzk) {
        C03021 r6;
        C03082 r62;
        C03103 r63;
        C03124 r64;
        C03145 r65;
        C03166 r66;
        zzk zzk2 = zzk;
        zzk zzk3 = zzk2;
        C03021 r3 = r6;
        C03021 r4 = new com.google.android.gms.ads.internal.client.zzq.zza(this) {
            final /* synthetic */ zzdw zzAc;

            {
                this.zzAc = r5;
            }

            public void onAdClosed() throws RemoteException {
                C03031 r5;
                List zza = this.zzAc.zzpH;
                C03031 r2 = r5;
                C03031 r3 = new zza(this) {
                    final /* synthetic */ C03021 zzAd;

                    {
                        this.zzAd = r5;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzpK != null) {
                            zzdx2.zzpK.onAdClosed();
                        }
                        zzr.zzbN().zzee();
                    }
                };
                boolean add = zza.add(r2);
            }

            public void onAdFailedToLoad(int i) throws RemoteException {
                C03042 r7;
                int i2 = i;
                List zza = this.zzAc.zzpH;
                C03042 r3 = r7;
                final int i3 = i2;
                C03042 r4 = new zza(this) {
                    final /* synthetic */ C03021 zzAd;

                    {
                        int i = r7;
                        this.zzAd = r6;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzpK != null) {
                            zzdx2.zzpK.onAdFailedToLoad(i3);
                        }
                    }
                };
                boolean add = zza.add(r3);
                zzin.m20v("Pooled interstitial failed to load.");
            }

            public void onAdLeftApplication() throws RemoteException {
                C03053 r5;
                List zza = this.zzAc.zzpH;
                C03053 r2 = r5;
                C03053 r3 = new zza(this) {
                    final /* synthetic */ C03021 zzAd;

                    {
                        this.zzAd = r5;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzpK != null) {
                            zzdx2.zzpK.onAdLeftApplication();
                        }
                    }
                };
                boolean add = zza.add(r2);
            }

            public void onAdLoaded() throws RemoteException {
                C03064 r5;
                List zza = this.zzAc.zzpH;
                C03064 r2 = r5;
                C03064 r3 = new zza(this) {
                    final /* synthetic */ C03021 zzAd;

                    {
                        this.zzAd = r5;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzpK != null) {
                            zzdx2.zzpK.onAdLoaded();
                        }
                    }
                };
                boolean add = zza.add(r2);
                zzin.m20v("Pooled interstitial loaded.");
            }

            public void onAdOpened() throws RemoteException {
                C03075 r5;
                List zza = this.zzAc.zzpH;
                C03075 r2 = r5;
                C03075 r3 = new zza(this) {
                    final /* synthetic */ C03021 zzAd;

                    {
                        this.zzAd = r5;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzpK != null) {
                            zzdx2.zzpK.onAdOpened();
                        }
                    }
                };
                boolean add = zza.add(r2);
            }
        };
        zzk3.zza((zzq) r3);
        zzk zzk4 = zzk2;
        C03082 r32 = r62;
        C03082 r42 = new com.google.android.gms.ads.internal.client.zzw.zza(this) {
            final /* synthetic */ zzdw zzAc;

            {
                this.zzAc = r5;
            }

            public void onAppEvent(String str, String str2) throws RemoteException {
                C03091 r9;
                String str3 = str;
                String str4 = str2;
                List zza = this.zzAc.zzpH;
                C03091 r4 = r9;
                final String str5 = str3;
                final String str6 = str4;
                C03091 r5 = new zza(this) {
                    final /* synthetic */ C03082 zzAg;

                    {
                        String str = r8;
                        String str2 = r9;
                        this.zzAg = r7;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzAq != null) {
                            zzdx2.zzAq.onAppEvent(str5, str6);
                        }
                    }
                };
                boolean add = zza.add(r4);
            }
        };
        zzk4.zza((zzw) r32);
        zzk zzk5 = zzk2;
        C03103 r33 = r63;
        C03103 r43 = new com.google.android.gms.internal.zzgd.zza(this) {
            final /* synthetic */ zzdw zzAc;

            {
                this.zzAc = r5;
            }

            public void zza(zzgc zzgc) throws RemoteException {
                C03111 r7;
                zzgc zzgc2 = zzgc;
                List zza = this.zzAc.zzpH;
                C03111 r3 = r7;
                final zzgc zzgc3 = zzgc2;
                C03111 r4 = new zza(this) {
                    final /* synthetic */ C03103 zzAi;

                    {
                        zzgc zzgc = r7;
                        this.zzAi = r6;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzAr != null) {
                            zzdx2.zzAr.zza(zzgc3);
                        }
                    }
                };
                boolean add = zza.add(r3);
            }
        };
        zzk5.zza((zzgd) r33);
        zzk zzk6 = zzk2;
        C03124 r34 = r64;
        C03124 r44 = new com.google.android.gms.internal.zzcf.zza(this) {
            final /* synthetic */ zzdw zzAc;

            {
                this.zzAc = r5;
            }

            public void zza(zzce zzce) throws RemoteException {
                C03131 r7;
                zzce zzce2 = zzce;
                List zza = this.zzAc.zzpH;
                C03131 r3 = r7;
                final zzce zzce3 = zzce2;
                C03131 r4 = new zza(this) {
                    final /* synthetic */ C03124 zzAk;

                    {
                        zzce zzce = r7;
                        this.zzAk = r6;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzAs != null) {
                            zzdx2.zzAs.zza(zzce3);
                        }
                    }
                };
                boolean add = zza.add(r3);
            }
        };
        zzk6.zza((zzcf) r34);
        zzk zzk7 = zzk2;
        C03145 r35 = r65;
        C03145 r45 = new com.google.android.gms.ads.internal.client.zzp.zza(this) {
            final /* synthetic */ zzdw zzAc;

            {
                this.zzAc = r5;
            }

            public void onAdClicked() throws RemoteException {
                C03151 r5;
                List zza = this.zzAc.zzpH;
                C03151 r2 = r5;
                C03151 r3 = new zza(this) {
                    final /* synthetic */ C03145 zzAl;

                    {
                        this.zzAl = r5;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzAt != null) {
                            zzdx2.zzAt.onAdClicked();
                        }
                    }
                };
                boolean add = zza.add(r2);
            }
        };
        zzk7.zza((zzp) r35);
        zzk zzk8 = zzk2;
        C03166 r36 = r66;
        C03166 r46 = new com.google.android.gms.ads.internal.reward.client.zzd.zza(this) {
            final /* synthetic */ zzdw zzAc;

            {
                this.zzAc = r5;
            }

            public void onRewardedVideoAdClosed() throws RemoteException {
                C03204 r5;
                List zza = this.zzAc.zzpH;
                C03204 r2 = r5;
                C03204 r3 = new zza(this) {
                    final /* synthetic */ C03166 zzAm;

                    {
                        this.zzAm = r5;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzAu != null) {
                            zzdx2.zzAu.onRewardedVideoAdClosed();
                        }
                    }
                };
                boolean add = zza.add(r2);
            }

            public void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
                C03237 r7;
                int i2 = i;
                List zza = this.zzAc.zzpH;
                C03237 r3 = r7;
                final int i3 = i2;
                C03237 r4 = new zza(this) {
                    final /* synthetic */ C03166 zzAm;

                    {
                        int i = r7;
                        this.zzAm = r6;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzAu != null) {
                            zzdx2.zzAu.onRewardedVideoAdFailedToLoad(i3);
                        }
                    }
                };
                boolean add = zza.add(r3);
            }

            public void onRewardedVideoAdLeftApplication() throws RemoteException {
                C03226 r5;
                List zza = this.zzAc.zzpH;
                C03226 r2 = r5;
                C03226 r3 = new zza(this) {
                    final /* synthetic */ C03166 zzAm;

                    {
                        this.zzAm = r5;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzAu != null) {
                            zzdx2.zzAu.onRewardedVideoAdLeftApplication();
                        }
                    }
                };
                boolean add = zza.add(r2);
            }

            public void onRewardedVideoAdLoaded() throws RemoteException {
                C03171 r5;
                List zza = this.zzAc.zzpH;
                C03171 r2 = r5;
                C03171 r3 = new zza(this) {
                    final /* synthetic */ C03166 zzAm;

                    {
                        this.zzAm = r5;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzAu != null) {
                            zzdx2.zzAu.onRewardedVideoAdLoaded();
                        }
                    }
                };
                boolean add = zza.add(r2);
            }

            public void onRewardedVideoAdOpened() throws RemoteException {
                C03182 r5;
                List zza = this.zzAc.zzpH;
                C03182 r2 = r5;
                C03182 r3 = new zza(this) {
                    final /* synthetic */ C03166 zzAm;

                    {
                        this.zzAm = r5;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzAu != null) {
                            zzdx2.zzAu.onRewardedVideoAdOpened();
                        }
                    }
                };
                boolean add = zza.add(r2);
            }

            public void onRewardedVideoStarted() throws RemoteException {
                C03193 r5;
                List zza = this.zzAc.zzpH;
                C03193 r2 = r5;
                C03193 r3 = new zza(this) {
                    final /* synthetic */ C03166 zzAm;

                    {
                        this.zzAm = r5;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzAu != null) {
                            zzdx2.zzAu.onRewardedVideoStarted();
                        }
                    }
                };
                boolean add = zza.add(r2);
            }

            public void zza(com.google.android.gms.ads.internal.reward.client.zza zza) throws RemoteException {
                C03215 r7;
                com.google.android.gms.ads.internal.reward.client.zza zza2 = zza;
                List zza3 = this.zzAc.zzpH;
                C03215 r3 = r7;
                final com.google.android.gms.ads.internal.reward.client.zza zza4 = zza2;
                C03215 r4 = new zza(this) {
                    final /* synthetic */ C03166 zzAm;

                    {
                        com.google.android.gms.ads.internal.reward.client.zza zza = r7;
                        this.zzAm = r6;
                    }

                    public void zzb(zzdx zzdx) throws RemoteException {
                        zzdx zzdx2 = zzdx;
                        if (zzdx2.zzAu != null) {
                            zzdx2.zzAu.zza(zza4);
                        }
                    }
                };
                boolean add = zza3.add(r3);
            }
        };
        zzk8.zza((zzd) r36);
    }
}
