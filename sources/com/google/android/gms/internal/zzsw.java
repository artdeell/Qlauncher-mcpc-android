package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzsw {
    final int tag;
    final byte[] zzbuv;

    zzsw(int i, byte[] bArr) {
        byte[] bArr2 = bArr;
        this.tag = i;
        this.zzbuv = bArr2;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 != this) {
            if (!(obj2 instanceof zzsw)) {
                return false;
            }
            zzsw zzsw = (zzsw) obj2;
            if (this.tag != zzsw.tag || !Arrays.equals(this.zzbuv, zzsw.zzbuv)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return (31 * (527 + this.tag)) + Arrays.hashCode(this.zzbuv);
    }

    /* access modifiers changed from: 0000 */
    public void writeTo(zzsn zzsn) throws IOException {
        zzsn zzsn2 = zzsn;
        zzsn2.zzmB(this.tag);
        zzsn2.zzH(this.zzbuv);
    }

    /* access modifiers changed from: 0000 */
    public int zzz() {
        return 0 + zzsn.zzmC(this.tag) + this.zzbuv.length;
    }
}
