package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import com.google.android.gms.common.internal.zzx;

@zzhb
public class zzbl {
    private final Context mContext;

    public zzbl(Context context) {
        Context context2 = context;
        Object zzb = zzx.zzb(context2, (Object) "Context can not be null");
        this.mContext = context2;
    }

    public static boolean zzdn() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public boolean zza(Intent intent) {
        Intent intent2 = intent;
        Object zzb = zzx.zzb(intent2, (Object) "Intent can not be null");
        boolean z = false;
        if (!this.mContext.getPackageManager().queryIntentActivities(intent2, 0).isEmpty()) {
            z = true;
        }
        return z;
    }

    public boolean zzdj() {
        Intent intent;
        Intent intent2 = intent;
        Intent intent3 = new Intent("android.intent.action.DIAL");
        Intent intent4 = intent2;
        Intent data = intent4.setData(Uri.parse("tel:"));
        return zza(intent4);
    }

    public boolean zzdk() {
        Intent intent;
        Intent intent2 = intent;
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Intent intent4 = intent2;
        Intent data = intent4.setData(Uri.parse("sms:"));
        return zza(intent4);
    }

    public boolean zzdl() {
        return zzdn() && this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public boolean zzdm() {
        return true;
    }

    @TargetApi(14)
    public boolean zzdo() {
        Intent intent;
        Intent intent2 = intent;
        Intent intent3 = new Intent("android.intent.action.INSERT");
        return VERSION.SDK_INT >= 14 && zza(intent2.setType("vnd.android.cursor.dir/event"));
    }
}
