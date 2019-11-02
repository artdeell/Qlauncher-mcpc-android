package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public class AdSizeParcel implements SafeParcelable {
    public static final zzi CREATOR;
    public final int height;
    public final int heightPixels;
    public final int versionCode;
    public final int width;
    public final int widthPixels;
    public final String zzuh;
    public final boolean zzui;
    public final AdSizeParcel[] zzuj;
    public final boolean zzuk;
    public final boolean zzul;
    public boolean zzum;

    static {
        zzi zzi;
        zzi zzi2 = zzi;
        zzi zzi3 = new zzi();
        CREATOR = zzi2;
    }

    public AdSizeParcel() {
        this(5, "interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    AdSizeParcel(int i, String str, int i2, int i3, boolean z, int i4, int i5, AdSizeParcel[] adSizeParcelArr, boolean z2, boolean z3, boolean z4) {
        String str2 = str;
        int i6 = i2;
        int i7 = i3;
        boolean z5 = z;
        int i8 = i4;
        int i9 = i5;
        AdSizeParcel[] adSizeParcelArr2 = adSizeParcelArr;
        boolean z6 = z2;
        boolean z7 = z3;
        boolean z8 = z4;
        this.versionCode = i;
        this.zzuh = str2;
        this.height = i6;
        this.heightPixels = i7;
        this.zzui = z5;
        this.width = i8;
        this.widthPixels = i9;
        this.zzuj = adSizeParcelArr2;
        this.zzuk = z6;
        this.zzul = z7;
        this.zzum = z8;
    }

    public AdSizeParcel(Context context, AdSize adSize) {
        Context context2 = context;
        AdSize[] adSizeArr = new AdSize[1];
        AdSize[] adSizeArr2 = adSizeArr;
        adSizeArr[0] = adSize;
        this(context2, adSizeArr2);
    }

    public AdSizeParcel(Context context, AdSize[] adSizeArr) {
        int i;
        AdSizeParcel adSizeParcel;
        StringBuilder sb;
        Context context2 = context;
        AdSize[] adSizeArr2 = adSizeArr;
        AdSize adSize = adSizeArr2[0];
        this.versionCode = 5;
        this.zzui = false;
        this.zzul = adSize.isFluid();
        if (this.zzul) {
            this.width = AdSize.BANNER.getWidth();
            this.height = AdSize.BANNER.getHeight();
        } else {
            this.width = adSize.getWidth();
            this.height = adSize.getHeight();
        }
        boolean z = this.width == -1;
        boolean z2 = this.height == -2;
        DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
        if (z) {
            if (!zzn.zzcS().zzV(context2) || !zzn.zzcS().zzW(context2)) {
                this.widthPixels = zza(displayMetrics);
            } else {
                this.widthPixels = zza(displayMetrics) - zzn.zzcS().zzX(context2);
            }
            double d = (double) (((float) this.widthPixels) / displayMetrics.density);
            int i2 = (int) d;
            if (d - ((double) ((int) d)) >= 0.01d) {
                i2++;
            }
            i = i2;
        } else {
            int i3 = this.width;
            this.widthPixels = zzn.zzcS().zza(displayMetrics, this.width);
            i = i3;
        }
        int i4 = z2 ? zzc(displayMetrics) : this.height;
        this.heightPixels = zzn.zzcS().zza(displayMetrics, i4);
        if (z || z2) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            this.zzuh = sb2.append(i).append("x").append(i4).append("_as").toString();
        } else {
            if (this.zzul) {
                this.zzuh = "320x50_mb";
            } else {
                this.zzuh = adSize.toString();
            }
        }
        if (adSizeArr2.length > 1) {
            this.zzuj = new AdSizeParcel[adSizeArr2.length];
            for (int i5 = 0; i5 < adSizeArr2.length; i5++) {
                AdSizeParcel[] adSizeParcelArr = this.zzuj;
                int i6 = i5;
                AdSizeParcel adSizeParcel2 = adSizeParcel;
                AdSizeParcel adSizeParcel3 = new AdSizeParcel(context2, adSizeArr2[i5]);
                adSizeParcelArr[i6] = adSizeParcel2;
            }
        } else {
            this.zzuj = null;
        }
        this.zzuk = false;
        this.zzum = false;
    }

    public AdSizeParcel(AdSizeParcel adSizeParcel, AdSizeParcel[] adSizeParcelArr) {
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        this(5, adSizeParcel2.zzuh, adSizeParcel2.height, adSizeParcel2.heightPixels, adSizeParcel2.zzui, adSizeParcel2.width, adSizeParcel2.widthPixels, adSizeParcelArr, adSizeParcel2.zzuk, adSizeParcel2.zzul, adSizeParcel2.zzum);
    }

    public static int zza(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        DisplayMetrics displayMetrics2 = displayMetrics;
        return (int) (((float) zzc(displayMetrics2)) * displayMetrics2.density);
    }

    private static int zzc(DisplayMetrics displayMetrics) {
        DisplayMetrics displayMetrics2 = displayMetrics;
        int i = (int) (((float) displayMetrics2.heightPixels) / displayMetrics2.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static AdSizeParcel zzcP() {
        AdSizeParcel adSizeParcel;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        AdSizeParcel adSizeParcel3 = new AdSizeParcel(5, "reward_mb", 0, 0, true, 0, 0, null, false, false, false);
        return adSizeParcel2;
    }

    public static AdSizeParcel zzt(Context context) {
        AdSizeParcel adSizeParcel;
        Context context2 = context;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        AdSizeParcel adSizeParcel3 = new AdSizeParcel(5, "320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
        return adSizeParcel2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public AdSize zzcQ() {
        return zza.zza(this.width, this.height, this.zzuh);
    }

    public void zzi(boolean z) {
        boolean z2 = z;
        this.zzum = z2;
    }
}
