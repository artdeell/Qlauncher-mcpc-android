package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp implements Creator<SignInConfiguration> {
    public zzp() {
    }

    static void zza(SignInConfiguration signInConfiguration, Parcel parcel, int i) {
        SignInConfiguration signInConfiguration2 = signInConfiguration;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, signInConfiguration2.versionCode);
        zzb.zza(parcel2, 2, signInConfiguration2.zznk(), false);
        zzb.zza(parcel2, 3, signInConfiguration2.zzmR(), false);
        zzb.zza(parcel2, 4, (Parcelable) signInConfiguration2.zznl(), i2, false);
        zzb.zza(parcel2, 5, (Parcelable) signInConfiguration2.zznm(), i2, false);
        zzb.zza(parcel2, 7, signInConfiguration2.zznn(), false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzV */
    public SignInConfiguration createFromParcel(Parcel parcel) {
        SignInConfiguration signInConfiguration;
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        String str = null;
        int zzau = zza.zzau(parcel2);
        int i = 0;
        GoogleSignInOptions googleSignInOptions = null;
        EmailSignInOptions emailSignInOptions = null;
        String str2 = null;
        String str3 = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel2);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    str3 = zza.zzp(parcel2, zzat);
                    break;
                case 3:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 4:
                    emailSignInOptions = (EmailSignInOptions) zza.zza(parcel2, zzat, EmailSignInOptions.CREATOR);
                    break;
                case 5:
                    googleSignInOptions = (GoogleSignInOptions) zza.zza(parcel2, zzat, GoogleSignInOptions.CREATOR);
                    break;
                case 7:
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
        SignInConfiguration signInConfiguration2 = signInConfiguration;
        SignInConfiguration signInConfiguration3 = new SignInConfiguration(i, str3, str2, emailSignInOptions, googleSignInOptions, str);
        return signInConfiguration2;
    }

    /* renamed from: zzaQ */
    public SignInConfiguration[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
