package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public class zze implements Creator<SignInAccount> {
    public zze() {
    }

    static void zza(SignInAccount signInAccount, Parcel parcel, int i) {
        SignInAccount signInAccount2 = signInAccount;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, signInAccount2.versionCode);
        zzb.zza(parcel2, 2, signInAccount2.zzmT(), false);
        zzb.zza(parcel2, 3, signInAccount2.getIdToken(), false);
        zzb.zza(parcel2, 4, signInAccount2.getEmail(), false);
        zzb.zza(parcel2, 5, signInAccount2.getDisplayName(), false);
        zzb.zza(parcel2, 6, (Parcelable) signInAccount2.getPhotoUrl(), i2, false);
        zzb.zza(parcel2, 7, (Parcelable) signInAccount2.zzmV(), i2, false);
        zzb.zza(parcel2, 8, signInAccount2.getUserId(), false);
        zzb.zza(parcel2, 9, signInAccount2.zzmW(), false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzT */
    public SignInAccount createFromParcel(Parcel parcel) {
        SignInAccount signInAccount;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        String str = null;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        String str2 = LibrariesRepository.MOJANG_MAVEN_REPO;
        GoogleSignInAccount googleSignInAccount = null;
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
                    googleSignInAccount = (GoogleSignInAccount) zza.zza(parcel2, zzat, GoogleSignInAccount.CREATOR);
                    break;
                case 8:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 9:
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
        SignInAccount signInAccount2 = signInAccount;
        SignInAccount signInAccount3 = new SignInAccount(i, str6, str5, str4, str3, uri, googleSignInAccount, str2, str);
        return signInAccount2;
    }

    /* renamed from: zzaO */
    public SignInAccount[] newArray(int i) {
        return new SignInAccount[i];
    }
}
