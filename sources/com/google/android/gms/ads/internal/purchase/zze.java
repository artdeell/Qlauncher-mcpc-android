package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzge.zza;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
public class zze extends zza implements ServiceConnection {
    private final Activity mActivity;
    private zzb zzFC;
    zzh zzFD;
    private zzk zzFF;
    private Context zzFK;
    private zzgc zzFL;
    private zzf zzFM;
    private zzj zzFN;
    private String zzFO = null;

    public zze(Activity activity) {
        Activity activity2 = activity;
        this.mActivity = activity2;
        this.zzFD = zzh.zzy(this.mActivity.getApplicationContext());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        int i3 = i2;
        Intent intent2 = intent;
        if (i == 1001) {
            try {
                int zzd = zzr.zzbM().zzd(intent2);
                if (i3 == -1) {
                    zzi zzbM = zzr.zzbM();
                    if (zzd == 0) {
                        z = false;
                        if (this.zzFF.zza(this.zzFO, i3, intent2)) {
                            z = true;
                        }
                        this.zzFL.recordPlayBillingResolution(zzd);
                        this.mActivity.finish();
                        zza(this.zzFL.getProductId(), z, i3, intent2);
                        this.zzFO = null;
                    }
                }
                this.zzFD.zza(this.zzFM);
                z = false;
                this.zzFL.recordPlayBillingResolution(zzd);
                this.mActivity.finish();
                zza(this.zzFL.getProductId(), z, i3, intent2);
                this.zzFO = null;
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                zzin.zzaK("Fail to process purchase result.");
                this.mActivity.finish();
                this.zzFO = null;
            } catch (Throwable th) {
                Throwable th2 = th;
                this.zzFO = null;
                throw th2;
            }
        }
    }

    public void onCreate() {
        zzb zzb;
        Intent intent;
        GInAppPurchaseManagerInfoParcel zzc = GInAppPurchaseManagerInfoParcel.zzc(this.mActivity.getIntent());
        this.zzFN = zzc.zzFy;
        this.zzFF = zzc.zzrI;
        this.zzFL = zzc.zzFw;
        zzb zzb2 = zzb;
        zzb zzb3 = new zzb(this.mActivity.getApplicationContext());
        this.zzFC = zzb2;
        this.zzFK = zzc.zzFx;
        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
            this.mActivity.setRequestedOrientation(zzr.zzbE().zzhv());
        } else {
            this.mActivity.setRequestedOrientation(zzr.zzbE().zzhw());
        }
        Intent intent2 = intent;
        Intent intent3 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        Intent intent4 = intent2;
        Intent intent5 = intent4.setPackage(com.google.android.gms.common.zze.GOOGLE_PLAY_STORE_PACKAGE);
        boolean bindService = this.mActivity.bindService(intent4, this, 1);
    }

    public void onDestroy() {
        this.mActivity.unbindService(this);
        this.zzFC.destroy();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Throwable th;
        zzf zzf;
        Intent intent;
        ComponentName componentName2 = componentName;
        this.zzFC.zzN(iBinder);
        try {
            this.zzFO = this.zzFF.zzfZ();
            Bundle zzb = this.zzFC.zzb(this.mActivity.getPackageName(), this.zzFL.getProductId(), this.zzFO);
            PendingIntent pendingIntent = (PendingIntent) zzb.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int zzd = zzr.zzbM().zzd(zzb);
                this.zzFL.recordPlayBillingResolution(zzd);
                zza(this.zzFL.getProductId(), false, zzd, null);
                this.mActivity.finish();
                return;
            }
            zzf zzf2 = zzf;
            zzf zzf3 = new zzf(this.zzFL.getProductId(), this.zzFO);
            this.zzFM = zzf2;
            this.zzFD.zzb(this.zzFM);
            Activity activity = this.mActivity;
            IntentSender intentSender = pendingIntent.getIntentSender();
            Intent intent2 = intent;
            Intent intent3 = new Intent();
            activity.startIntentSenderForResult(intentSender, 1001, intent2, Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        } catch (RemoteException e) {
            th = e;
            zzin.zzd("Error when connecting in-app billing service", th);
            this.mActivity.finish();
        } catch (SendIntentException e2) {
            th = e2;
            zzin.zzd("Error when connecting in-app billing service", th);
            this.mActivity.finish();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        ComponentName componentName2 = componentName;
        zzin.zzaJ("In-app billing service disconnected.");
        this.zzFC.destroy();
    }

    /* access modifiers changed from: protected */
    public void zza(String str, boolean z, int i, Intent intent) {
        String str2 = str;
        boolean z2 = z;
        int i2 = i;
        Intent intent2 = intent;
        if (this.zzFN != null) {
            this.zzFN.zza(str2, z2, i2, intent2, this.zzFM);
        }
    }
}
