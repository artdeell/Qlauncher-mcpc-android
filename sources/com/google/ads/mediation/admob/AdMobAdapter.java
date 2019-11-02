package com.google.ads.mediation.admob;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class AdMobAdapter extends AbstractAdViewAdapter {
    public AdMobAdapter() {
    }

    /* access modifiers changed from: protected */
    public Bundle zza(Bundle bundle, Bundle bundle2) {
        Bundle bundle3;
        Bundle bundle4 = bundle;
        Bundle bundle5 = bundle2;
        if (bundle4 == null) {
            Bundle bundle6 = bundle3;
            Bundle bundle7 = new Bundle();
            bundle4 = bundle6;
        }
        bundle4.putInt("gw", 1);
        bundle4.putString("mad_hac", bundle5.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle5.getString("adJson"))) {
            bundle4.putString("_ad", bundle5.getString("adJson"));
        }
        bundle4.putBoolean("_noRefresh", true);
        return bundle4;
    }
}
