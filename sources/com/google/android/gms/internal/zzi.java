package com.google.android.gms.internal;

import java.util.Map;

public class zzi {
    public final byte[] data;
    public final int statusCode;
    public final Map<String, String> zzA;
    public final boolean zzB;
    public final long zzC;

    public zzi(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        byte[] bArr2 = bArr;
        Map<String, String> map2 = map;
        boolean z2 = z;
        long j2 = j;
        this.statusCode = i;
        this.data = bArr2;
        this.zzA = map2;
        this.zzB = z2;
        this.zzC = j2;
    }

    public zzi(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0);
    }
}
