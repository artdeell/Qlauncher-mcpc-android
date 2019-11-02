package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzhb
public class zzc extends zzim implements ServiceConnection {
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public zzgh zzAK;
    private boolean zzFB;
    private zzb zzFC;
    private zzh zzFD;
    private List<zzf> zzFE;
    /* access modifiers changed from: private */
    public zzk zzFF;
    private final Object zzpV;

    public zzc(Context context, zzgh zzgh, zzk zzk) {
        zzb zzb;
        Context context2 = context;
        Context context3 = context2;
        zzgh zzgh2 = zzgh;
        zzk zzk2 = zzk;
        zzb zzb2 = zzb;
        zzb zzb3 = new zzb(context2);
        this(context3, zzgh2, zzk2, zzb2, zzh.zzy(context2.getApplicationContext()));
    }

    zzc(Context context, zzgh zzgh, zzk zzk, zzb zzb, zzh zzh) {
        Object obj;
        Context context2 = context;
        zzgh zzgh2 = zzgh;
        zzk zzk2 = zzk;
        zzb zzb2 = zzb;
        zzh zzh2 = zzh;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzFB = false;
        this.zzFE = null;
        this.mContext = context2;
        this.zzAK = zzgh2;
        this.zzFF = zzk2;
        this.zzFC = zzb2;
        this.zzFD = zzh2;
        this.zzFE = this.zzFD.zzg(10);
    }

    private void zze(long j) {
        long j2 = j;
        do {
            if (!zzf(j2)) {
                zzin.m20v("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.zzFB);
    }

    private boolean zzf(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzpV.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
            zzin.zzaK("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ComponentName componentName2 = componentName;
        IBinder iBinder2 = iBinder;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzFC.zzN(iBinder2);
                zzfW();
                this.zzFB = true;
                this.zzpV.notify();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        ComponentName componentName2 = componentName;
        zzin.zzaJ("In-app billing service disconnected.");
        this.zzFC.destroy();
    }

    public void onStop() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                zzb.zzrP().zza(this.mContext, this);
                this.zzFC.destroy();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zza(zzf zzf, String str, String str2) {
        Intent intent;
        C01821 r11;
        zzf zzf2 = zzf;
        String str3 = str;
        String str4 = str2;
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        Intent intent4 = intent2;
        zzi zzbM = zzr.zzbM();
        Intent putExtra = intent4.putExtra("RESPONSE_CODE", 0);
        zzi zzbM2 = zzr.zzbM();
        Intent putExtra2 = intent4.putExtra("INAPP_PURCHASE_DATA", str3);
        zzi zzbM3 = zzr.zzbM();
        Intent putExtra3 = intent4.putExtra("INAPP_DATA_SIGNATURE", str4);
        Handler handler = zzir.zzMc;
        C01821 r6 = r11;
        final zzf zzf3 = zzf2;
        final Intent intent5 = intent4;
        C01821 r7 = new Runnable(this) {
            final /* synthetic */ zzc zzFH;

            {
                zzf zzf = r8;
                Intent intent = r9;
                this.zzFH = r7;
            }

            public void run() {
                zzg zzg;
                zzg zzg2;
                try {
                    if (this.zzFH.zzFF.zza(zzf3.zzFQ, -1, intent5)) {
                        zzgh zzc = this.zzFH.zzAK;
                        zzg zzg3 = zzg2;
                        zzg zzg4 = new zzg(this.zzFH.mContext, zzf3.zzFR, true, -1, intent5, zzf3);
                        zzc.zza(zzg3);
                        return;
                    }
                    zzgh zzc2 = this.zzFH.zzAK;
                    zzg zzg5 = zzg;
                    zzg zzg6 = new zzg(this.zzFH.mContext, zzf3.zzFR, false, -1, intent5, zzf3);
                    zzc2.zza(zzg5);
                } catch (RemoteException e) {
                    RemoteException remoteException = e;
                    zzin.zzaK("Fail to verify and dispatch pending transaction");
                }
            }
        };
        boolean post = handler.post(r6);
    }

    public void zzbr() {
        Intent intent;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                Intent intent2 = intent;
                Intent intent3 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                Intent intent4 = intent2;
                Intent intent5 = intent4.setPackage(zze.GOOGLE_PLAY_STORE_PACKAGE);
                boolean zza = zzb.zzrP().zza(this.mContext, intent4, (ServiceConnection) this, 1);
                zze(SystemClock.elapsedRealtime());
                zzb.zzrP().zza(this.mContext, this);
                this.zzFC.destroy();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzfW() {
        HashMap hashMap;
        if (!this.zzFE.isEmpty()) {
            HashMap hashMap2 = hashMap;
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = hashMap2;
            for (zzf zzf : this.zzFE) {
                Object put = hashMap4.put(zzf.zzFR, zzf);
            }
            String str = null;
            while (true) {
                Bundle zzi = this.zzFC.zzi(this.mContext.getPackageName(), str);
                if (zzi == null || zzr.zzbM().zzd(zzi) != 0) {
                    break;
                }
                ArrayList stringArrayList = zzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList stringArrayList2 = zzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList stringArrayList3 = zzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String string = zzi.getString("INAPP_CONTINUATION_TOKEN");
                for (int i = 0; i < stringArrayList.size(); i++) {
                    if (hashMap4.containsKey(stringArrayList.get(i))) {
                        String str2 = (String) stringArrayList.get(i);
                        String str3 = (String) stringArrayList2.get(i);
                        String str4 = (String) stringArrayList3.get(i);
                        zzf zzf2 = (zzf) hashMap4.get(str2);
                        if (zzf2.zzFQ.equals(zzr.zzbM().zzaq(str3))) {
                            zza(zzf2, str3, str4);
                            Object remove = hashMap4.remove(str2);
                        }
                    }
                }
                if (string == null || hashMap4.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str5 : hashMap4.keySet()) {
                this.zzFD.zza((zzf) hashMap4.get(str5));
            }
        }
    }
}
