package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public interface MediationAdapter {

    public static class zza {
        private int zzOn;

        public zza() {
        }

        public zza zzS(int i) {
            this.zzOn = i;
            return this;
        }

        public Bundle zziw() {
            Bundle bundle;
            Bundle bundle2 = bundle;
            Bundle bundle3 = new Bundle();
            Bundle bundle4 = bundle2;
            bundle4.putInt("capabilities", this.zzOn);
            return bundle4;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
