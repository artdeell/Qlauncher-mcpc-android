package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public final class zzro implements Optional {
    public static final zzro zzbgV;
    private final boolean zzXa;
    private final boolean zzXc;
    private final String zzXd;
    private final String zzXe;
    private final boolean zzbgW;
    private final boolean zzbgX;

    public static final class zza {
        private String zzbdY;
        private boolean zzbgY;
        private boolean zzbgZ;
        private boolean zzbha;
        private String zzbhb;
        private boolean zzbhc;

        public zza() {
        }

        public zzro zzFJ() {
            zzro zzro;
            zzro zzro2 = zzro;
            zzro zzro3 = new zzro(this.zzbgY, this.zzbgZ, this.zzbdY, this.zzbha, this.zzbhb, this.zzbhc, null);
            return zzro2;
        }
    }

    static {
        zza zza2;
        zza zza3 = zza2;
        zza zza4 = new zza();
        zzbgV = zza3.zzFJ();
    }

    private zzro(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4) {
        boolean z5 = z2;
        String str3 = str;
        boolean z6 = z3;
        String str4 = str2;
        boolean z7 = z4;
        this.zzbgW = z;
        this.zzXa = z5;
        this.zzXd = str3;
        this.zzXc = z6;
        this.zzbgX = z7;
        this.zzXe = str4;
    }

    /* synthetic */ zzro(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4, C04511 r22) {
        C04511 r7 = r22;
        this(z, z2, str, z3, str2, z4);
    }

    public boolean zzFH() {
        return this.zzbgW;
    }

    public boolean zzFI() {
        return this.zzbgX;
    }

    public boolean zzmO() {
        return this.zzXa;
    }

    public boolean zzmQ() {
        return this.zzXc;
    }

    public String zzmR() {
        return this.zzXd;
    }

    @Nullable
    public String zzmS() {
        return this.zzXe;
    }
}
