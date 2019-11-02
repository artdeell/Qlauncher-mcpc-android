package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;

@zzhb
public class zzjk {
    public static void zza(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        zzjl zzjl;
        zzjl zzjl2 = zzjl;
        zzjl zzjl3 = new zzjl(view, onGlobalLayoutListener);
        zzjl2.zzhL();
    }

    public static void zza(View view, OnScrollChangedListener onScrollChangedListener) {
        zzjm zzjm;
        zzjm zzjm2 = zzjm;
        zzjm zzjm3 = new zzjm(view, onScrollChangedListener);
        zzjm2.zzhL();
    }
}
