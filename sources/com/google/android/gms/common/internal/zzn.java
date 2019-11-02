package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.zze;

public class zzn {
    private static final Uri zzamj = Uri.parse("http://plus.google.com/");
    private static final Uri zzamk = zzamj.buildUpon().appendPath("circles").appendPath("find").build();

    public static Intent zzcJ(String str) {
        Intent intent;
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent2 = intent;
        Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        Intent intent4 = intent2;
        Intent data = intent4.setData(fromParts);
        return intent4;
    }

    public static Intent zzqU() {
        Intent intent;
        Intent intent2 = intent;
        Intent intent3 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        Intent intent4 = intent2;
        Intent intent5 = intent4.setPackage("com.google.android.wearable.app");
        return intent4;
    }

    private static Uri zzw(String str, @Nullable String str2) {
        String str3 = str2;
        Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(str3)) {
            Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("pcampaignid", str3);
        }
        return appendQueryParameter.build();
    }

    public static Intent zzx(String str, @Nullable String str2) {
        Intent intent;
        String str3 = str;
        String str4 = str2;
        Intent intent2 = intent;
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Intent intent4 = intent2;
        Intent data = intent4.setData(zzw(str3, str4));
        Intent intent5 = intent4.setPackage(zze.GOOGLE_PLAY_STORE_PACKAGE);
        Intent addFlags = intent4.addFlags(524288);
        return intent4;
    }
}
