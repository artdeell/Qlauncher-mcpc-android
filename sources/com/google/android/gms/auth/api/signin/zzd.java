package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.util.Log;

public enum zzd {
    ;
    
    private final String zzVY;
    private final String zzXj;
    private final int zzXk;

    private zzd(String str, int i, String str2) {
        int i2 = i;
        String str3 = str2;
        String str4 = r10;
        int i3 = r11;
        this.zzXj = str;
        this.zzXk = i2;
        this.zzVY = str3;
    }

    public static zzd zzbL(String str) {
        StringBuilder sb;
        String str2 = str;
        if (str2 != null) {
            zzd[] values = values();
            int length = values.length;
            for (int i = 0; i < length; i++) {
                zzd zzd = values[i];
                if (zzd.zzmT().equals(str2)) {
                    return zzd;
                }
            }
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int w = Log.w("IdProvider", sb2.append("Unrecognized providerId: ").append(str2).toString());
        }
        return null;
    }

    public String toString() {
        return this.zzXj;
    }

    public CharSequence zzae(Context context) {
        return context.getResources().getString(this.zzXk);
    }

    public String zzmT() {
        return this.zzXj;
    }
}
