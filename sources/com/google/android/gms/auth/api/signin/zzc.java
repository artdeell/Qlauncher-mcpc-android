package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Creator<GoogleSignInOptions> {
    public zzc() {
    }

    static void zza(GoogleSignInOptions googleSignInOptions, Parcel parcel, int i) {
        GoogleSignInOptions googleSignInOptions2 = googleSignInOptions;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, googleSignInOptions2.versionCode);
        zzb.zzc(parcel2, 2, googleSignInOptions2.zzmN(), false);
        zzb.zza(parcel2, 3, (Parcelable) googleSignInOptions2.getAccount(), i2, false);
        zzb.zza(parcel2, 4, googleSignInOptions2.zzmO());
        zzb.zza(parcel2, 5, googleSignInOptions2.zzmP());
        zzb.zza(parcel2, 6, googleSignInOptions2.zzmQ());
        zzb.zza(parcel2, 7, googleSignInOptions2.zzmR(), false);
        zzb.zza(parcel2, 8, googleSignInOptions2.zzmS(), false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzS */
    public GoogleSignInOptions createFromParcel(Parcel parcel) {
        GoogleSignInOptions googleSignInOptions;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        String str = null;
        boolean z = false;
        int zzau = zza.zzau(parcel2);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList = null;
        int i = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel2, zzat, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) zza.zza(parcel2, zzat, Account.CREATOR);
                    break;
                case 4:
                    z3 = zza.zzc(parcel2, zzat);
                    break;
                case 5:
                    z2 = zza.zzc(parcel2, zzat);
                    break;
                case 6:
                    z = zza.zzc(parcel2, zzat);
                    break;
                case 7:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 8:
                    str = zza.zzp(parcel2, zzat);
                    break;
                default:
                    zza.zzb(parcel2, zzat);
                    break;
            }
        }
        if (parcel2.dataPosition() != zzau) {
            C0881zza zza2 = zza;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            C0881zza zza3 = new C0881zza(sb2.append("Overread allowed size end=").append(zzau).toString(), parcel2);
            throw zza2;
        }
        GoogleSignInOptions googleSignInOptions2 = googleSignInOptions;
        GoogleSignInOptions googleSignInOptions3 = new GoogleSignInOptions(i, arrayList, account, z3, z2, z, str2, str);
        return googleSignInOptions2;
    }

    /* renamed from: zzaN */
    public GoogleSignInOptions[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
