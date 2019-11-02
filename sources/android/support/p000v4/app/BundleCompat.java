package android.support.p000v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;

/* renamed from: android.support.v4.app.BundleCompat */
public class BundleCompat {
    public BundleCompat() {
    }

    public static IBinder getBinder(Bundle bundle, String str) {
        Bundle bundle2 = bundle;
        String str2 = str;
        return VERSION.SDK_INT >= 18 ? BundleCompatJellybeanMR2.getBinder(bundle2, str2) : BundleCompatDonut.getBinder(bundle2, str2);
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        Bundle bundle2 = bundle;
        String str2 = str;
        IBinder iBinder2 = iBinder;
        if (VERSION.SDK_INT >= 18) {
            BundleCompatJellybeanMR2.putBinder(bundle2, str2, iBinder2);
        } else {
            BundleCompatDonut.putBinder(bundle2, str2, iBinder2);
        }
    }
}
