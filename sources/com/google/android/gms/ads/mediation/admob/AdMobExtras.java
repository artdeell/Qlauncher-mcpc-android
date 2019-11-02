package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
public final class AdMobExtras implements NetworkExtras {
    private final Bundle mExtras;

    public AdMobExtras(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        Bundle bundle4 = bundle;
        if (bundle4 != null) {
            Bundle bundle5 = bundle3;
            Bundle bundle6 = new Bundle(bundle4);
            bundle2 = bundle5;
        } else {
            bundle2 = null;
        }
        this.mExtras = bundle2;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }
}
