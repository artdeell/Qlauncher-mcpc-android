package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0881zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<EmailSignInOptions> {
    public zza() {
    }

    static void zza(EmailSignInOptions emailSignInOptions, Parcel parcel, int i) {
        EmailSignInOptions emailSignInOptions2 = emailSignInOptions;
        Parcel parcel2 = parcel;
        int i2 = i;
        int zzav = zzb.zzav(parcel2);
        zzb.zzc(parcel2, 1, emailSignInOptions2.versionCode);
        zzb.zza(parcel2, 2, (Parcelable) emailSignInOptions2.zzmF(), i2, false);
        zzb.zza(parcel2, 3, emailSignInOptions2.zzmH(), false);
        zzb.zza(parcel2, 4, (Parcelable) emailSignInOptions2.zzmG(), i2, false);
        zzb.zzI(parcel2, zzav);
    }

    /* renamed from: zzQ */
    public EmailSignInOptions createFromParcel(Parcel parcel) {
        EmailSignInOptions emailSignInOptions;
        C0881zza zza;
        StringBuilder sb;
        Uri uri;
        String str;
        Uri uri2;
        int i;
        Parcel parcel2 = parcel;
        Uri uri3 = null;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel2);
        int i2 = 0;
        String str2 = null;
        Uri uri4 = null;
        while (parcel2.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel2);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    str = str2;
                    uri2 = uri4;
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    uri = uri3;
                    break;
                case 2:
                    i = i2;
                    uri2 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel2, zzat, Uri.CREATOR);
                    uri = uri3;
                    str = str2;
                    break;
                case 3:
                    uri2 = uri4;
                    i = i2;
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    uri = uri3;
                    break;
                case 4:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel2, zzat, Uri.CREATOR);
                    str = str2;
                    uri2 = uri4;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel2, zzat);
                    uri = uri3;
                    str = str2;
                    uri2 = uri4;
                    i = i2;
                    break;
            }
            i2 = i;
            uri4 = uri2;
            str2 = str;
            uri3 = uri;
        }
        if (parcel2.dataPosition() != zzau) {
            C0881zza zza2 = zza;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            C0881zza zza3 = new C0881zza(sb2.append("Overread allowed size end=").append(zzau).toString(), parcel2);
            throw zza2;
        }
        EmailSignInOptions emailSignInOptions2 = emailSignInOptions;
        EmailSignInOptions emailSignInOptions3 = new EmailSignInOptions(i2, uri4, str2, uri3);
        return emailSignInOptions2;
    }

    /* renamed from: zzaL */
    public EmailSignInOptions[] newArray(int i) {
        return new EmailSignInOptions[i];
    }
}
