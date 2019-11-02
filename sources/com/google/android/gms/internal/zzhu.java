package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzif.zza;

@zzhb
public class zzhu extends zzim implements zzhv, zzhy {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final String zzCd;
    private final zza zzGd;
    private int zzGu = 3;
    private final zzia zzKB;
    private final zzhy zzKC;
    /* access modifiers changed from: private */
    public final String zzKD;
    private final String zzKE;
    private int zzKF = 0;
    private final Object zzpV;
    /* access modifiers changed from: private */
    public final String zzrG;

    public zzhu(Context context, String str, String str2, String str3, String str4, zza zza, zzia zzia, zzhy zzhy) {
        Object obj;
        Context context2 = context;
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        zza zza2 = zza;
        zzia zzia2 = zzia;
        zzhy zzhy2 = zzhy;
        this.mContext = context2;
        this.zzCd = str5;
        this.zzrG = str6;
        this.zzKD = str7;
        this.zzKE = str8;
        this.zzGd = zza2;
        this.zzKB = zzia2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzKC = zzhy2;
    }

    /* access modifiers changed from: private */
    public void zza(AdRequestParcel adRequestParcel, zzey zzey) {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        zzey zzey2 = zzey;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzCd)) {
                zzey2.zza(adRequestParcel2, this.zzKD, this.zzKE);
            } else {
                zzey2.zzb(adRequestParcel2, this.zzKD);
            }
        } catch (RemoteException e) {
            zzin.zzd("Fail to load ad from adapter.", e);
            zza(this.zzCd, 0);
        }
    }

    /* JADX INFO: finally extract failed */
    private void zzk(long j) {
        long j2 = j;
        while (true) {
            Object obj = this.zzpV;
            synchronized (obj) {
                try {
                    if (this.zzKF == 0) {
                        if (!zzf(j2)) {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
    }

    public void onStop() {
    }

    public void zzN(int i) {
        int i2 = i;
        zza(this.zzCd, 0);
    }

    public void zza(String str, int i) {
        String str2 = str;
        int i2 = i;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzKF = 2;
                this.zzGu = i2;
                this.zzpV.notify();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzax(String str) {
        String str2 = str;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzKF = 1;
                this.zzpV.notify();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzbr() {
        C03992 r12;
        C03981 r122;
        if (this.zzKB != null && this.zzKB.zzgQ() != null && this.zzKB.zzgP() != null) {
            zzhx zzgQ = this.zzKB.zzgQ();
            zzgQ.zza((zzhy) this);
            zzgQ.zza((zzhv) this);
            AdRequestParcel adRequestParcel = this.zzGd.zzLd.zzHt;
            zzey zzgP = this.zzKB.zzgP();
            try {
                if (zzgP.isInitialized()) {
                    Handler handler = com.google.android.gms.ads.internal.util.client.zza.zzMS;
                    C03981 r6 = r122;
                    final AdRequestParcel adRequestParcel2 = adRequestParcel;
                    final zzey zzey = zzgP;
                    C03981 r7 = new Runnable(this) {
                        final /* synthetic */ zzhu zzKH;

                        {
                            AdRequestParcel adRequestParcel = r8;
                            zzey zzey = r9;
                            this.zzKH = r7;
                        }

                        public void run() {
                            this.zzKH.zza(adRequestParcel2, zzey);
                        }
                    };
                    boolean post = handler.post(r6);
                } else {
                    Handler handler2 = com.google.android.gms.ads.internal.util.client.zza.zzMS;
                    C03992 r62 = r12;
                    final zzey zzey2 = zzgP;
                    final AdRequestParcel adRequestParcel3 = adRequestParcel;
                    final zzhx zzhx = zzgQ;
                    C03992 r72 = new Runnable(this) {
                        final /* synthetic */ zzhu zzKH;

                        {
                            zzey zzey = r9;
                            AdRequestParcel adRequestParcel = r10;
                            zzhx zzhx = r11;
                            this.zzKH = r8;
                        }

                        public void run() {
                            StringBuilder sb;
                            try {
                                zzey2.zza(zze.zzC(this.zzKH.mContext), adRequestParcel3, this.zzKH.zzrG, (com.google.android.gms.ads.internal.reward.mediation.client.zza) zzhx, this.zzKH.zzKD);
                            } catch (RemoteException e) {
                                RemoteException remoteException = e;
                                StringBuilder sb2 = sb;
                                StringBuilder sb3 = new StringBuilder();
                                zzin.zzd(sb2.append("Fail to initialize adapter ").append(this.zzKH.zzCd).toString(), remoteException);
                                this.zzKH.zza(this.zzKH.zzCd, 0);
                            }
                        }
                    };
                    boolean post2 = handler2.post(r62);
                }
            } catch (RemoteException e) {
                zzin.zzd("Fail to check if adapter is initialized.", e);
                zza(this.zzCd, 0);
            }
            zzk(zzr.zzbG().elapsedRealtime());
            zzgQ.zza((zzhy) null);
            zzgQ.zza((zzhv) null);
            if (this.zzKF == 1) {
                this.zzKC.zzax(this.zzCd);
            } else {
                this.zzKC.zza(this.zzCd, this.zzGu);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzf(long j) {
        long elapsedRealtime = 20000 - (zzr.zzbG().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzpV.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
            return false;
        }
    }

    public void zzgN() {
        zza(this.zzGd.zzLd.zzHt, this.zzKB.zzgP());
    }
}
