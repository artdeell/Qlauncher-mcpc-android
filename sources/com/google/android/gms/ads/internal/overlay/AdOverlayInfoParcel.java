package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;

@zzhb
public final class AdOverlayInfoParcel implements SafeParcelable {
    public static final zzf CREATOR;
    public final int orientation;
    public final String url;
    public final int versionCode;
    public final AdLauncherIntentInfoParcel zzEA;
    public final zza zzEB;
    public final zzg zzEC;
    public final zzjp zzED;
    public final zzdb zzEE;
    public final String zzEF;
    public final boolean zzEG;
    public final String zzEH;
    public final zzp zzEI;
    public final int zzEJ;
    public final zzdh zzEK;
    public final String zzEL;
    public final InterstitialAdParameterParcel zzEM;
    public final VersionInfoParcel zzrl;

    static {
        zzf zzf;
        zzf zzf2 = zzf;
        zzf zzf3 = new zzf();
        CREATOR = zzf2;
    }

    AdOverlayInfoParcel(int i, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, VersionInfoParcel versionInfoParcel, IBinder iBinder6, String str4, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel2 = adLauncherIntentInfoParcel;
        IBinder iBinder7 = iBinder;
        IBinder iBinder8 = iBinder2;
        IBinder iBinder9 = iBinder3;
        IBinder iBinder10 = iBinder4;
        String str5 = str;
        boolean z2 = z;
        String str6 = str2;
        IBinder iBinder11 = iBinder5;
        int i4 = i2;
        int i5 = i3;
        String str7 = str3;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        IBinder iBinder12 = iBinder6;
        String str8 = str4;
        InterstitialAdParameterParcel interstitialAdParameterParcel2 = interstitialAdParameterParcel;
        this.versionCode = i;
        this.zzEA = adLauncherIntentInfoParcel2;
        this.zzEB = (zza) zze.zzp(zzd.zza.zzbs(iBinder7));
        this.zzEC = (zzg) zze.zzp(zzd.zza.zzbs(iBinder8));
        this.zzED = (zzjp) zze.zzp(zzd.zza.zzbs(iBinder9));
        this.zzEE = (zzdb) zze.zzp(zzd.zza.zzbs(iBinder10));
        this.zzEF = str5;
        this.zzEG = z2;
        this.zzEH = str6;
        this.zzEI = (zzp) zze.zzp(zzd.zza.zzbs(iBinder11));
        this.orientation = i4;
        this.zzEJ = i5;
        this.url = str7;
        this.zzrl = versionInfoParcel2;
        this.zzEK = (zzdh) zze.zzp(zzd.zza.zzbs(iBinder12));
        this.zzEL = str8;
        this.zzEM = interstitialAdParameterParcel2;
    }

    public AdOverlayInfoParcel(zza zza, zzg zzg, zzp zzp, zzjp zzjp, int i, VersionInfoParcel versionInfoParcel, String str, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        zza zza2 = zza;
        zzg zzg2 = zzg;
        zzp zzp2 = zzp;
        zzjp zzjp2 = zzjp;
        int i2 = i;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        String str2 = str;
        InterstitialAdParameterParcel interstitialAdParameterParcel2 = interstitialAdParameterParcel;
        this.versionCode = 4;
        this.zzEA = null;
        this.zzEB = zza2;
        this.zzEC = zzg2;
        this.zzED = zzjp2;
        this.zzEE = null;
        this.zzEF = null;
        this.zzEG = false;
        this.zzEH = null;
        this.zzEI = zzp2;
        this.orientation = i2;
        this.zzEJ = 1;
        this.url = null;
        this.zzrl = versionInfoParcel2;
        this.zzEK = null;
        this.zzEL = str2;
        this.zzEM = interstitialAdParameterParcel2;
    }

    public AdOverlayInfoParcel(zza zza, zzg zzg, zzp zzp, zzjp zzjp, boolean z, int i, VersionInfoParcel versionInfoParcel) {
        zza zza2 = zza;
        zzg zzg2 = zzg;
        zzp zzp2 = zzp;
        zzjp zzjp2 = zzjp;
        boolean z2 = z;
        int i2 = i;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        this.versionCode = 4;
        this.zzEA = null;
        this.zzEB = zza2;
        this.zzEC = zzg2;
        this.zzED = zzjp2;
        this.zzEE = null;
        this.zzEF = null;
        this.zzEG = z2;
        this.zzEH = null;
        this.zzEI = zzp2;
        this.orientation = i2;
        this.zzEJ = 2;
        this.url = null;
        this.zzrl = versionInfoParcel2;
        this.zzEK = null;
        this.zzEL = null;
        this.zzEM = null;
    }

    public AdOverlayInfoParcel(zza zza, zzg zzg, zzdb zzdb, zzp zzp, zzjp zzjp, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, zzdh zzdh) {
        zza zza2 = zza;
        zzg zzg2 = zzg;
        zzdb zzdb2 = zzdb;
        zzp zzp2 = zzp;
        zzjp zzjp2 = zzjp;
        boolean z2 = z;
        int i2 = i;
        String str2 = str;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzdh zzdh2 = zzdh;
        this.versionCode = 4;
        this.zzEA = null;
        this.zzEB = zza2;
        this.zzEC = zzg2;
        this.zzED = zzjp2;
        this.zzEE = zzdb2;
        this.zzEF = null;
        this.zzEG = z2;
        this.zzEH = null;
        this.zzEI = zzp2;
        this.orientation = i2;
        this.zzEJ = 3;
        this.url = str2;
        this.zzrl = versionInfoParcel2;
        this.zzEK = zzdh2;
        this.zzEL = null;
        this.zzEM = null;
    }

    public AdOverlayInfoParcel(zza zza, zzg zzg, zzdb zzdb, zzp zzp, zzjp zzjp, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, zzdh zzdh) {
        zza zza2 = zza;
        zzg zzg2 = zzg;
        zzdb zzdb2 = zzdb;
        zzp zzp2 = zzp;
        zzjp zzjp2 = zzjp;
        boolean z2 = z;
        int i2 = i;
        String str3 = str;
        String str4 = str2;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzdh zzdh2 = zzdh;
        this.versionCode = 4;
        this.zzEA = null;
        this.zzEB = zza2;
        this.zzEC = zzg2;
        this.zzED = zzjp2;
        this.zzEE = zzdb2;
        this.zzEF = str4;
        this.zzEG = z2;
        this.zzEH = str3;
        this.zzEI = zzp2;
        this.orientation = i2;
        this.zzEJ = 3;
        this.url = null;
        this.zzrl = versionInfoParcel2;
        this.zzEK = zzdh2;
        this.zzEL = null;
        this.zzEM = null;
    }

    public AdOverlayInfoParcel(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, zza zza, zzg zzg, zzp zzp, VersionInfoParcel versionInfoParcel) {
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel2 = adLauncherIntentInfoParcel;
        zza zza2 = zza;
        zzg zzg2 = zzg;
        zzp zzp2 = zzp;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        this.versionCode = 4;
        this.zzEA = adLauncherIntentInfoParcel2;
        this.zzEB = zza2;
        this.zzEC = zzg2;
        this.zzED = null;
        this.zzEE = null;
        this.zzEF = null;
        this.zzEG = false;
        this.zzEH = null;
        this.zzEI = zzp2;
        this.orientation = -1;
        this.zzEJ = 4;
        this.url = null;
        this.zzrl = versionInfoParcel2;
        this.zzEK = null;
        this.zzEL = null;
        this.zzEM = null;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle;
        Intent intent2 = intent;
        AdOverlayInfoParcel adOverlayInfoParcel2 = adOverlayInfoParcel;
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle(1);
        Bundle bundle4 = bundle2;
        bundle4.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel2);
        Intent putExtra = intent2.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle4);
    }

    public static AdOverlayInfoParcel zzb(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            Exception exc = e;
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzfs() {
        return zze.zzC(this.zzEB).asBinder();
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzft() {
        return zze.zzC(this.zzEC).asBinder();
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzfu() {
        return zze.zzC(this.zzED).asBinder();
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzfv() {
        return zze.zzC(this.zzEE).asBinder();
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzfw() {
        return zze.zzC(this.zzEK).asBinder();
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzfx() {
        return zze.zzC(this.zzEI).asBinder();
    }
}
