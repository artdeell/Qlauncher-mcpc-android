package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzaa;
import com.google.android.gms.ads.internal.client.zzaa.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = zzaa.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final int zzOA;
    private final int zzOB;
    private final int zzOC;
    private final int zzOD;
    private final String zzOE;
    private final int zzOF;
    private final String zzOG;
    private final int zzOH;
    private final int zzOI;
    private final String zzOJ;
    private final int zzOx;
    private final int zzOy;
    private final int zzOz;
    private final zzaa zzoE;
    private final int zzxO;

    public static final class Builder {
        /* access modifiers changed from: private */
        public int zzOA;
        /* access modifiers changed from: private */
        public int zzOB;
        /* access modifiers changed from: private */
        public int zzOC = 0;
        /* access modifiers changed from: private */
        public int zzOD;
        /* access modifiers changed from: private */
        public String zzOE;
        /* access modifiers changed from: private */
        public int zzOF;
        /* access modifiers changed from: private */
        public String zzOG;
        /* access modifiers changed from: private */
        public int zzOH;
        /* access modifiers changed from: private */
        public int zzOI;
        /* access modifiers changed from: private */
        public String zzOJ;
        /* access modifiers changed from: private */
        public int zzOx;
        /* access modifiers changed from: private */
        public int zzOy;
        /* access modifiers changed from: private */
        public int zzOz;
        /* access modifiers changed from: private */
        public final zza zzoF;
        /* access modifiers changed from: private */
        public int zzxO;

        public Builder() {
            zza zza;
            zza zza2 = zza;
            zza zza3 = new zza();
            this.zzoF = zza2;
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzoF.zzb(cls, bundle);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzoF.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zzoF.zza(cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.zzoF.zzB(str);
            return this;
        }

        public SearchAdRequest build() {
            SearchAdRequest searchAdRequest;
            SearchAdRequest searchAdRequest2 = searchAdRequest;
            SearchAdRequest searchAdRequest3 = new SearchAdRequest(this, null);
            return searchAdRequest2;
        }

        public Builder setAnchorTextColor(int i) {
            this.zzOx = i;
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.zzxO = i;
            this.zzOy = Color.argb(0, 0, 0, 0);
            this.zzOz = Color.argb(0, 0, 0, 0);
            return this;
        }

        public Builder setBackgroundGradient(int i, int i2) {
            int i3 = i;
            int i4 = i2;
            this.zzxO = Color.argb(0, 0, 0, 0);
            this.zzOy = i4;
            this.zzOz = i3;
            return this;
        }

        public Builder setBorderColor(int i) {
            this.zzOA = i;
            return this;
        }

        public Builder setBorderThickness(int i) {
            this.zzOB = i;
            return this;
        }

        public Builder setBorderType(int i) {
            this.zzOC = i;
            return this;
        }

        public Builder setCallButtonColor(int i) {
            this.zzOD = i;
            return this;
        }

        public Builder setCustomChannels(String str) {
            this.zzOE = str;
            return this;
        }

        public Builder setDescriptionTextColor(int i) {
            this.zzOF = i;
            return this;
        }

        public Builder setFontFace(String str) {
            this.zzOG = str;
            return this;
        }

        public Builder setHeaderTextColor(int i) {
            this.zzOH = i;
            return this;
        }

        public Builder setHeaderTextSize(int i) {
            this.zzOI = i;
            return this;
        }

        public Builder setLocation(Location location) {
            this.zzoF.zzb(location);
            return this;
        }

        public Builder setQuery(String str) {
            this.zzOJ = str;
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

    private SearchAdRequest(Builder builder) {
        zzaa zzaa;
        Builder builder2 = builder;
        this.zzOx = builder2.zzOx;
        this.zzxO = builder2.zzxO;
        this.zzOy = builder2.zzOy;
        this.zzOz = builder2.zzOz;
        this.zzOA = builder2.zzOA;
        this.zzOB = builder2.zzOB;
        this.zzOC = builder2.zzOC;
        this.zzOD = builder2.zzOD;
        this.zzOE = builder2.zzOE;
        this.zzOF = builder2.zzOF;
        this.zzOG = builder2.zzOG;
        this.zzOH = builder2.zzOH;
        this.zzOI = builder2.zzOI;
        this.zzOJ = builder2.zzOJ;
        zzaa zzaa2 = zzaa;
        zzaa zzaa3 = new zzaa(builder2.zzoF, this);
        this.zzoE = zzaa2;
    }

    /* synthetic */ SearchAdRequest(Builder builder, C02141 r7) {
        C02141 r2 = r7;
        this(builder);
    }

    public int getAnchorTextColor() {
        return this.zzOx;
    }

    public int getBackgroundColor() {
        return this.zzxO;
    }

    public int getBackgroundGradientBottom() {
        return this.zzOy;
    }

    public int getBackgroundGradientTop() {
        return this.zzOz;
    }

    public int getBorderColor() {
        return this.zzOA;
    }

    public int getBorderThickness() {
        return this.zzOB;
    }

    public int getBorderType() {
        return this.zzOC;
    }

    public int getCallButtonColor() {
        return this.zzOD;
    }

    public String getCustomChannels() {
        return this.zzOE;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzoE.getCustomEventExtrasBundle(cls);
    }

    public int getDescriptionTextColor() {
        return this.zzOF;
    }

    public String getFontFace() {
        return this.zzOG;
    }

    public int getHeaderTextColor() {
        return this.zzOH;
    }

    public int getHeaderTextSize() {
        return this.zzOI;
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

    public String getQuery() {
        return this.zzOJ;
    }

    public boolean isTestDevice(Context context) {
        return this.zzoE.isTestDevice(context);
    }

    /* access modifiers changed from: 0000 */
    public zzaa zzaE() {
        return this.zzoE;
    }
}
