package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
public class zza {
    public zza() {
    }

    public boolean zza(Context context, Intent intent, zzp zzp) {
        StringBuilder sb;
        Context context2 = context;
        Intent intent2 = intent;
        zzp zzp2 = zzp;
        try {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.m20v(sb2.append("Launching an intent: ").append(intent2.toURI()).toString());
            zzr.zzbC().zzb(context2, intent2);
            if (zzp2 != null) {
                zzp2.zzaO();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzin.zzaK(e.getMessage());
            return false;
        }
    }

    public boolean zza(Context context, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, zzp zzp) {
        Intent intent;
        int i;
        StringBuilder sb;
        Context context2 = context;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel2 = adLauncherIntentInfoParcel;
        zzp zzp2 = zzp;
        if (adLauncherIntentInfoParcel2 == null) {
            zzin.zzaK("No intent data for launcher overlay.");
            return false;
        } else if (adLauncherIntentInfoParcel2.intent != null) {
            return zza(context2, adLauncherIntentInfoParcel2.intent, zzp2);
        } else {
            Intent intent2 = intent;
            Intent intent3 = new Intent();
            Intent intent4 = intent2;
            if (TextUtils.isEmpty(adLauncherIntentInfoParcel2.url)) {
                zzin.zzaK("Open GMSG did not contain a URL.");
                return false;
            }
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel2.mimeType)) {
                Intent dataAndType = intent4.setDataAndType(Uri.parse(adLauncherIntentInfoParcel2.url), adLauncherIntentInfoParcel2.mimeType);
            } else {
                Intent data = intent4.setData(Uri.parse(adLauncherIntentInfoParcel2.url));
            }
            Intent action = intent4.setAction("android.intent.action.VIEW");
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel2.packageName)) {
                Intent intent5 = intent4.setPackage(adLauncherIntentInfoParcel2.packageName);
            }
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel2.zzDK)) {
                String[] split = adLauncherIntentInfoParcel2.zzDK.split("/", 2);
                if (split.length < 2) {
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    zzin.zzaK(sb2.append("Could not parse component name from open GMSG: ").append(adLauncherIntentInfoParcel2.zzDK).toString());
                    return false;
                }
                Intent className = intent4.setClassName(split[0], split[1]);
            }
            String str = adLauncherIntentInfoParcel2.zzDL;
            if (!TextUtils.isEmpty(str)) {
                try {
                    i = Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    NumberFormatException numberFormatException = e;
                    zzin.zzaK("Could not parse intent flags.");
                    i = 0;
                }
                Intent addFlags = intent4.addFlags(i);
            }
            return zza(context2, intent4, zzp2);
        }
    }
}
