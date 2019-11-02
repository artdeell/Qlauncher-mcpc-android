package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<RecordConsentRequest> {
    public zzf() {
    }

    static void zza(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        RecordConsentRequest recordConsentRequest2 = recordConsentRequest;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, recordConsentRequest2.mVersionCode);
        zzb.zza(parcel2, 2, (Parcelable) recordConsentRequest2.getAccount(), i2, false);
        zzb.zza(parcel2, 3, (T[]) recordConsentRequest2.zzFM(), i2, false);
        zzb.zza(parcel2, 4, recordConsentRequest2.zzmR(), false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzgT */
    public RecordConsentRequest createFromParcel(Parcel parcel) {
        RecordConsentRequest recordConsentRequest;
        C0881zza zza;
        StringBuilder sb;
        String zzp;
        Scope[] scopeArr;
        Account account;
        int i;
        Parcel parcel2 = parcel;
        String str = null;
        int zzau = zza.zzau(parcel2);
        int i2 = 0;
        Scope[] scopeArr2 = null;
        Account account2 = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    scopeArr = scopeArr2;
                    account = account2;
                    i = zza.zzg(parcel2, zzat);
                    zzp = str;
                    break;
                case 2:
                    i = i2;
                    account = (Account) zza.zza(parcel2, zzat, Account.CREATOR);
                    zzp = str;
                    scopeArr = scopeArr2;
                    break;
                case 3:
                    account = account2;
                    i = i2;
                    scopeArr = (Scope[]) zza.zzb(parcel2, zzat, Scope.CREATOR);
                    zzp = str;
                    break;
                case 4:
                    zzp = zza.zzp(parcel2, zzat);
                    scopeArr = scopeArr2;
                    account = account2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel2, zzat);
                    zzp = str;
                    scopeArr = scopeArr2;
                    account = account2;
                    i = i2;
                    break;
            }
            i2 = i;
            account2 = account;
            scopeArr2 = scopeArr;
            str = zzp;
        }
        if (parcel2.dataPosition() != zzau) {
            C0881zza zza2 = zza;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            C0881zza zza3 = new C0881zza(sb2.append("Overread allowed size end=").append(zzau).toString(), parcel2);
            throw zza2;
        }
        RecordConsentRequest recordConsentRequest2 = recordConsentRequest;
        RecordConsentRequest recordConsentRequest3 = new RecordConsentRequest(i2, account2, scopeArr2, str);
        return recordConsentRequest2;
    }

    /* renamed from: zzkb */
    public RecordConsentRequest[] newArray(int i) {
        return new RecordConsentRequest[i];
    }
}
