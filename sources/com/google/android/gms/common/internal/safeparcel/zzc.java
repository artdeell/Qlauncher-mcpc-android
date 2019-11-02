package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;

public final class zzc {
    public static <T extends SafeParcelable> T zza(Intent intent, String str, Creator<T> creator) {
        Creator<T> creator2 = creator;
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return zza(byteArrayExtra, creator2);
    }

    public static <T extends SafeParcelable> T zza(byte[] bArr, Creator<T> creator) {
        byte[] bArr2 = bArr;
        Creator<T> creator2 = creator;
        Object zzz = zzx.zzz(creator2);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr2, 0, bArr2.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) creator2.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }

    public static <T extends SafeParcelable> void zza(T t, Intent intent, String str) {
        Intent putExtra = intent.putExtra(str, zza(t));
    }

    public static <T extends SafeParcelable> byte[] zza(T t) {
        T t2 = t;
        Parcel obtain = Parcel.obtain();
        t2.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
