package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzgg.zza;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
public final class zzg extends zza implements ServiceConnection {
    private Context mContext;
    zzb zzFC;
    private String zzFI;
    private zzf zzFM;
    private boolean zzFS = false;
    private int zzFT;
    private Intent zzFU;

    public zzg(Context context, String str, boolean z, int i, Intent intent, zzf zzf) {
        Context context2 = context;
        String str2 = str;
        boolean z2 = z;
        int i2 = i;
        Intent intent2 = intent;
        zzf zzf2 = zzf;
        this.zzFI = str2;
        this.zzFT = i2;
        this.zzFU = intent2;
        this.zzFS = z2;
        this.mContext = context2;
        this.zzFM = zzf2;
    }

    public void finishPurchase() {
        zzb zzb;
        Intent intent;
        int zzd = zzr.zzbM().zzd(this.zzFU);
        if (this.zzFT == -1 && zzd == 0) {
            zzb zzb2 = zzb;
            zzb zzb3 = new zzb(this.mContext);
            this.zzFC = zzb2;
            Intent intent2 = intent;
            Intent intent3 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            Intent intent4 = intent2;
            Intent intent5 = intent4.setPackage(zze.GOOGLE_PLAY_STORE_PACKAGE);
            boolean zza = zzb.zzrP().zza(this.mContext, intent4, (ServiceConnection) this, 1);
        }
    }

    public String getProductId() {
        return this.zzFI;
    }

    public Intent getPurchaseData() {
        return this.zzFU;
    }

    public int getResultCode() {
        return this.zzFT;
    }

    public boolean isVerified() {
        return this.zzFS;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ComponentName componentName2 = componentName;
        IBinder iBinder2 = iBinder;
        zzin.zzaJ("In-app billing service connected.");
        this.zzFC.zzN(iBinder2);
        String zzar = zzr.zzbM().zzar(zzr.zzbM().zze(this.zzFU));
        if (zzar != null) {
            if (this.zzFC.zzh(this.mContext.getPackageName(), zzar) == 0) {
                zzh.zzy(this.mContext).zza(this.zzFM);
            }
            zzb.zzrP().zza(this.mContext, this);
            this.zzFC.destroy();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        ComponentName componentName2 = componentName;
        zzin.zzaJ("In-app billing service disconnected.");
        this.zzFC.destroy();
    }
}
