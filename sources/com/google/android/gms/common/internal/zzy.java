package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy implements Creator<ResolveAccountRequest> {
    public zzy() {
    }

    static void zza(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        ResolveAccountRequest resolveAccountRequest2 = resolveAccountRequest;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, resolveAccountRequest2.mVersionCode);
        zzb.zza(parcel2, 2, (Parcelable) resolveAccountRequest2.getAccount(), i2, false);
        zzb.zzc(parcel2, 3, resolveAccountRequest2.getSessionId());
        zzb.zza(parcel2, 4, (Parcelable) resolveAccountRequest2.zzqW(), i2, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzap */
    public ResolveAccountRequest createFromParcel(Parcel parcel) {
        ResolveAccountRequest resolveAccountRequest;
        C0881zza zza;
        StringBuilder sb;
        GoogleSignInAccount googleSignInAccount;
        int i;
        Account account;
        int i2;
        Parcel parcel2 = parcel;
        GoogleSignInAccount googleSignInAccount2 = null;
        int i3 = 0;
        int zzau = zza.zzau(parcel2);
        Account account2 = null;
        int i4 = 0;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = i3;
                    account = account2;
                    i2 = zza.zzg(parcel2, zzat);
                    googleSignInAccount = googleSignInAccount2;
                    break;
                case 2:
                    i2 = i4;
                    account = (Account) zza.zza(parcel2, zzat, Account.CREATOR);
                    googleSignInAccount = googleSignInAccount2;
                    i = i3;
                    break;
                case 3:
                    account = account2;
                    i2 = i4;
                    i = zza.zzg(parcel2, zzat);
                    googleSignInAccount = googleSignInAccount2;
                    break;
                case 4:
                    googleSignInAccount = (GoogleSignInAccount) zza.zza(parcel2, zzat, GoogleSignInAccount.CREATOR);
                    i = i3;
                    account = account2;
                    i2 = i4;
                    break;
                default:
                    zza.zzb(parcel2, zzat);
                    googleSignInAccount = googleSignInAccount2;
                    i = i3;
                    account = account2;
                    i2 = i4;
                    break;
            }
            i4 = i2;
            account2 = account;
            i3 = i;
            googleSignInAccount2 = googleSignInAccount;
        }
        if (parcel2.dataPosition() != zzau) {
            C0881zza zza2 = zza;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            C0881zza zza3 = new C0881zza(sb2.append("Overread allowed size end=").append(zzau).toString(), parcel2);
            throw zza2;
        }
        ResolveAccountRequest resolveAccountRequest2 = resolveAccountRequest;
        ResolveAccountRequest resolveAccountRequest3 = new ResolveAccountRequest(i4, account2, i3, googleSignInAccount2);
        return resolveAccountRequest2;
    }

    /* renamed from: zzbW */
    public ResolveAccountRequest[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
