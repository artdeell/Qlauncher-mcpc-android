package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzne;

@zzhb
public class zze {
    public zze() {
    }

    public void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel) {
        zza(context, adOverlayInfoParcel, true);
    }

    public void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        Intent intent;
        Context context2 = context;
        AdOverlayInfoParcel adOverlayInfoParcel2 = adOverlayInfoParcel;
        boolean z2 = z;
        if (adOverlayInfoParcel2.zzEJ == 4 && adOverlayInfoParcel2.zzEC == null) {
            if (adOverlayInfoParcel2.zzEB != null) {
                adOverlayInfoParcel2.zzEB.onAdClicked();
            }
            boolean zza = zzr.zzbz().zza(context2, adOverlayInfoParcel2.zzEA, adOverlayInfoParcel2.zzEI);
            return;
        }
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        Intent intent4 = intent2;
        Intent className = intent4.setClassName(context2, AdActivity.CLASS_NAME);
        Intent putExtra = intent4.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel2.zzrl.zzNb);
        Intent putExtra2 = intent4.putExtra("shouldCallOnOverlayOpened", z2);
        AdOverlayInfoParcel.zza(intent4, adOverlayInfoParcel2);
        if (!zzne.isAtLeastL()) {
            Intent addFlags = intent4.addFlags(524288);
        }
        if (!(context2 instanceof Activity)) {
            Intent addFlags2 = intent4.addFlags(268435456);
        }
        zzr.zzbC().zzb(context2, intent4);
    }
}
