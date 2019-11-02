package android.support.p000v4.p002os;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.os.TraceCompat */
public class TraceCompat {
    public TraceCompat() {
    }

    public static void beginSection(String str) {
        String str2 = str;
        if (VERSION.SDK_INT >= 18) {
            TraceJellybeanMR2.beginSection(str2);
        }
    }

    public static void endSection() {
        if (VERSION.SDK_INT >= 18) {
            TraceJellybeanMR2.endSection();
        }
    }
}
