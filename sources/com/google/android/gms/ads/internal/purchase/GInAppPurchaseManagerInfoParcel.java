package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class GInAppPurchaseManagerInfoParcel implements SafeParcelable {
    public static final zza CREATOR;
    public final int versionCode;
    public final zzgc zzFw;
    public final Context zzFx;
    public final zzj zzFy;
    public final zzk zzrI;

    static {
        zza zza;
        zza zza2 = zza;
        zza zza3 = new zza();
        CREATOR = zza2;
    }

    GInAppPurchaseManagerInfoParcel(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        IBinder iBinder5 = iBinder;
        IBinder iBinder6 = iBinder2;
        IBinder iBinder7 = iBinder3;
        IBinder iBinder8 = iBinder4;
        this.versionCode = i;
        this.zzrI = (zzk) zze.zzp(zza.zzbs(iBinder5));
        this.zzFw = (zzgc) zze.zzp(zza.zzbs(iBinder6));
        this.zzFx = (Context) zze.zzp(zza.zzbs(iBinder7));
        this.zzFy = (zzj) zze.zzp(zza.zzbs(iBinder8));
    }

    public GInAppPurchaseManagerInfoParcel(Context context, zzk zzk, zzgc zzgc, zzj zzj) {
        Context context2 = context;
        zzk zzk2 = zzk;
        zzgc zzgc2 = zzgc;
        zzj zzj2 = zzj;
        this.versionCode = 2;
        this.zzFx = context2;
        this.zzrI = zzk2;
        this.zzFw = zzgc2;
        this.zzFy = zzj2;
    }

    public static void zza(Intent intent, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Bundle bundle;
        Intent intent2 = intent;
        GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel2 = gInAppPurchaseManagerInfoParcel;
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle(1);
        Bundle bundle4 = bundle2;
        bundle4.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", gInAppPurchaseManagerInfoParcel2);
        Intent putExtra = intent2.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle4);
    }

    public static GInAppPurchaseManagerInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            Exception exc = e;
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzfS() {
        return zze.zzC(this.zzFy).asBinder();
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzfT() {
        return zze.zzC(this.zzrI).asBinder();
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzfU() {
        return zze.zzC(this.zzFw).asBinder();
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzfV() {
        return zze.zzC(this.zzFx).asBinder();
    }
}
