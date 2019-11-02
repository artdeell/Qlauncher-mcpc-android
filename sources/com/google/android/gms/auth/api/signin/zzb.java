package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import java.util.List;

public class zzb implements Creator<GoogleSignInAccount> {
    public zzb() {
    }

    static void zza(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        GoogleSignInAccount googleSignInAccount2 = googleSignInAccount;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel2);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel2, 1, googleSignInAccount2.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 2, googleSignInAccount2.getId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 3, googleSignInAccount2.getIdToken(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 4, googleSignInAccount2.getEmail(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 5, googleSignInAccount2.getDisplayName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 6, (Parcelable) googleSignInAccount2.getPhotoUrl(), i2, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 7, googleSignInAccount2.getServerAuthCode(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 8, googleSignInAccount2.zzmK());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel2, 9, googleSignInAccount2.zzmL(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel2, 10, googleSignInAccount2.zzVs, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzR */
    public GoogleSignInAccount createFromParcel(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        List list = null;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    str6 = zza.zzp(parcel2, zzat);
                    break;
                case 3:
                    str5 = zza.zzp(parcel2, zzat);
                    break;
                case 4:
                    str4 = zza.zzp(parcel2, zzat);
                    break;
                case 5:
                    str3 = zza.zzp(parcel2, zzat);
                    break;
                case 6:
                    uri = (Uri) zza.zza(parcel2, zzat, Uri.CREATOR);
                    break;
                case 7:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 8:
                    j = zza.zzi(parcel2, zzat);
                    break;
                case 9:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 10:
                    list = zza.zzc(parcel2, zzat, Scope.CREATOR);
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
        GoogleSignInAccount googleSignInAccount2 = googleSignInAccount;
        GoogleSignInAccount googleSignInAccount3 = new GoogleSignInAccount(i, str6, str5, str4, str3, uri, str2, j, str, list);
        return googleSignInAccount2;
    }

    /* renamed from: zzaM */
    public GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
