package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzi implements RewardedVideoAd {
    private final Context mContext;
    private final zzb zzKA;
    private RewardedVideoAdListener zzaX;
    private final Object zzpV;
    private String zzrG;

    public zzi(Context context, zzb zzb) {
        Object obj;
        Context context2 = context;
        zzb zzb2 = zzb;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzKA = zzb2;
        this.mContext = context2;
    }

    public void destroy() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzKA != null) {
                    this.zzKA.destroy();
                }
            } catch (RemoteException e) {
                zzb.zzd("Could not forward destroy to RewardedVideoAd", e);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzpV;
        synchronized (rewardedVideoAdListener) {
            try {
                th = this.zzaX;
            } finally {
                Throwable th = th;
                RewardedVideoAdListener rewardedVideoAdListener2 = rewardedVideoAdListener;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public String getUserId() {
        String str = this.zzpV;
        synchronized (str) {
            try {
                th = this.zzrG;
            } finally {
                Throwable th = th;
                String str2 = str;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public boolean isLoaded() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzKA == null) {
                    return false;
                }
                boolean isLoaded = this.zzKA.isLoaded();
                return isLoaded;
            } catch (RemoteException e) {
                zzb.zzd("Could not forward isLoaded to RewardedVideoAd", e);
                Object obj2 = obj;
                return false;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj3 = obj;
                throw th2;
            }
        }
    }

    public void loadAd(String str, AdRequest adRequest) {
        String str2 = str;
        AdRequest adRequest2 = adRequest;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzKA != null) {
                    this.zzKA.zza(zzh.zzcO().zza(this.mContext, adRequest2.zzaE(), str2));
                }
            } catch (RemoteException e) {
                zzb.zzd("Could not forward loadAd to RewardedVideoAd", e);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void pause() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzKA != null) {
                    this.zzKA.pause();
                }
            } catch (RemoteException e) {
                zzb.zzd("Could not forward pause to RewardedVideoAd", e);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void resume() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzKA != null) {
                    this.zzKA.resume();
                }
            } catch (RemoteException e) {
                zzb.zzd("Could not forward resume to RewardedVideoAd", e);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        zzg zzg;
        RewardedVideoAdListener rewardedVideoAdListener2 = rewardedVideoAdListener;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzaX = rewardedVideoAdListener2;
                if (this.zzKA != null) {
                    zzb zzb = this.zzKA;
                    zzg zzg2 = zzg;
                    zzg zzg3 = new zzg(rewardedVideoAdListener2);
                    zzb.zza((zzd) zzg2);
                }
            } catch (RemoteException e) {
                zzb.zzd("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setUserId(java.lang.String r9) {
        /*
            r8 = this;
            r0 = r8
            r1 = r9
            r6 = r0
            java.lang.Object r6 = r6.zzpV
            r2 = r6
            r6 = r2
            monitor-enter(r6)
            r6 = r0
            java.lang.String r6 = r6.zzrG     // Catch:{ all -> 0x002e }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x002e }
            if (r6 != 0) goto L_0x0019
            java.lang.String r6 = "A user id has already been set, ignoring."
            com.google.android.gms.ads.internal.util.client.zzb.zzaK(r6)     // Catch:{ all -> 0x002e }
            r6 = r2
            monitor-exit(r6)     // Catch:{ all -> 0x002e }
        L_0x0018:
            return
        L_0x0019:
            r6 = r0
            r7 = r1
            r6.zzrG = r7     // Catch:{ all -> 0x002e }
            r6 = r0
            com.google.android.gms.ads.internal.reward.client.zzb r6 = r6.zzKA     // Catch:{ all -> 0x002e }
            r4 = r6
            r6 = r4
            if (r6 == 0) goto L_0x002b
            r6 = r0
            com.google.android.gms.ads.internal.reward.client.zzb r6 = r6.zzKA     // Catch:{ RemoteException -> 0x0034 }
            r7 = r1
            r6.setUserId(r7)     // Catch:{ RemoteException -> 0x0034 }
        L_0x002b:
            r6 = r2
            monitor-exit(r6)     // Catch:{ all -> 0x002e }
            goto L_0x0018
        L_0x002e:
            r6 = move-exception
            r3 = r6
            r6 = r2
            monitor-exit(r6)     // Catch:{ all -> 0x002e }
            r6 = r3
            throw r6
        L_0x0034:
            r6 = move-exception
            r5 = r6
            java.lang.String r6 = "Could not forward setUserId to RewardedVideoAd"
            r7 = r5
            com.google.android.gms.ads.internal.util.client.zzb.zzd(r6, r7)     // Catch:{ all -> 0x002e }
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.reward.client.zzi.setUserId(java.lang.String):void");
    }

    public void show() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzKA != null) {
                    this.zzKA.show();
                }
            } catch (RemoteException e) {
                zzb.zzd("Could not forward show to RewardedVideoAd", e);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
