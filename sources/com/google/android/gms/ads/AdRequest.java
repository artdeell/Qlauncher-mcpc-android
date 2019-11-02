package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzaa;
import com.google.android.gms.ads.internal.client.zzaa.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzx;
import java.util.Date;
import java.util.Set;

public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = zzaa.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    private final zzaa zzoE;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final zza zzoF;

        public Builder() {
            zza zza;
            zza zza2 = zza;
            zza zza3 = new zza();
            this.zzoF = zza2;
            this.zzoF.zzB(AdRequest.DEVICE_ID_EMULATOR);
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzoF.zzb(cls, bundle);
            return this;
        }

        public Builder addKeyword(String str) {
            this.zzoF.zzA(str);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzoF.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            Class<? extends MediationAdapter> cls2 = cls;
            Bundle bundle2 = bundle;
            this.zzoF.zza(cls2, bundle2);
            if (cls2.equals(AdMobAdapter.class) && bundle2.getBoolean("_emulatorLiveAds")) {
                this.zzoF.zzC(AdRequest.DEVICE_ID_EMULATOR);
            }
            return this;
        }

        public Builder addTestDevice(String str) {
            this.zzoF.zzB(str);
            return this;
        }

        public AdRequest build() {
            AdRequest adRequest;
            AdRequest adRequest2 = adRequest;
            AdRequest adRequest3 = new AdRequest(this, null);
            return adRequest2;
        }

        public Builder setBirthday(Date date) {
            this.zzoF.zza(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            String str2 = str;
            Object zzb = zzx.zzb(str2, (Object) "Content URL must be non-null.");
            String zzh = zzx.zzh(str2, "Content URL must be non-empty.");
            zzx.zzb(str2.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", Integer.valueOf(512), Integer.valueOf(str2.length()));
            this.zzoF.zzD(str2);
            return this;
        }

        public Builder setGender(int i) {
            this.zzoF.zzn(i);
            return this;
        }

        public Builder setIsDesignedForFamilies(boolean z) {
            this.zzoF.zzl(z);
            return this;
        }

        public Builder setLocation(Location location) {
            this.zzoF.zzb(location);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.zzoF.zzF(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.zzoF.zzk(z);
            return this;
        }
    }

    private AdRequest(Builder builder) {
        zzaa zzaa;
        zzaa zzaa2 = zzaa;
        zzaa zzaa3 = new zzaa(builder.zzoF);
        this.zzoE = zzaa2;
    }

    /* synthetic */ AdRequest(Builder builder, C01591 r7) {
        C01591 r2 = r7;
        this(builder);
    }

    public Date getBirthday() {
        return this.zzoE.getBirthday();
    }

    public String getContentUrl() {
        return this.zzoE.getContentUrl();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzoE.getCustomEventExtrasBundle(cls);
    }

    public int getGender() {
        return this.zzoE.getGender();
    }

    public Set<String> getKeywords() {
        return this.zzoE.getKeywords();
    }

    public Location getLocation() {
        return this.zzoE.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.zzoE.getNetworkExtras(cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzoE.getNetworkExtrasBundle(cls);
    }

    public boolean isTestDevice(Context context) {
        return this.zzoE.isTestDevice(context);
    }

    public zzaa zzaE() {
        return this.zzoE;
    }
}
