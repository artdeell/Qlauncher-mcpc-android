package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.p000v4.app.Fragment;
import android.util.Log;

public class zzh implements OnClickListener {
    private final Activity mActivity;
    private final Intent mIntent;
    private final int zzagz;
    private final Fragment zzalg;

    public zzh(Activity activity, Intent intent, int i) {
        Intent intent2 = intent;
        int i2 = i;
        this.mActivity = activity;
        this.zzalg = null;
        this.mIntent = intent2;
        this.zzagz = i2;
    }

    public zzh(Fragment fragment, Intent intent, int i) {
        Fragment fragment2 = fragment;
        Intent intent2 = intent;
        int i2 = i;
        this.mActivity = null;
        this.zzalg = fragment2;
        this.mIntent = intent2;
        this.zzagz = i2;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface dialogInterface2 = dialogInterface;
        int i2 = i;
        try {
            if (this.mIntent != null && this.zzalg != null) {
                this.zzalg.startActivityForResult(this.mIntent, this.zzagz);
            } else if (this.mIntent != null) {
                this.mActivity.startActivityForResult(this.mIntent, this.zzagz);
            }
            dialogInterface2.dismiss();
        } catch (ActivityNotFoundException e) {
            ActivityNotFoundException activityNotFoundException = e;
            int e2 = Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
