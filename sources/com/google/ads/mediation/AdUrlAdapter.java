package com.google.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class AdUrlAdapter extends AbstractAdViewAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    public AdUrlAdapter() {
    }

    public String getAdUnitId(Bundle bundle) {
        Bundle bundle2 = bundle;
        return "adurl";
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
        bundle4.putBundle("sdk_less_server_data", bundle5);
        bundle4.putBoolean("_noRefresh", true);
        return bundle4;
    }
}
