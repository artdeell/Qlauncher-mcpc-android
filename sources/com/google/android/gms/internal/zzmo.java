package com.google.android.gms.internal;

import android.util.Base64;

public final class zzmo {
    public static String zzj(byte[] bArr) {
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return null;
        }
        return Base64.encodeToString(bArr2, 0);
    }

    public static String zzk(byte[] bArr) {
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return null;
        }
        return Base64.encodeToString(bArr2, 10);
    }
}
