package com.google.android.gms.internal;

import java.security.MessageDigest;

@zzhb
public class zzbj extends zzbg {
    private MessageDigest zztw;

    public zzbj() {
    }

    /* access modifiers changed from: 0000 */
    public byte[] zza(String[] strArr) {
        String[] strArr2 = strArr;
        byte[] bArr = new byte[strArr2.length];
        for (int i = 0; i < strArr2.length; i++) {
            bArr[i] = zzk(zzbi.zzx(strArr2[i]));
        }
        return bArr;
    }

    /* access modifiers changed from: 0000 */
    public byte zzk(int i) {
        int i2 = i;
        return (byte) ((((i2 & 255) ^ ((65280 & i2) >> 8)) ^ ((16711680 & i2) >> 16)) ^ ((-16777216 & i2) >> 24));
    }

    public byte[] zzu(String str) {
        byte[] bArr;
        byte[] zza = zza(str.split(" "));
        this.zztw = zzcL();
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zztw == null) {
                    th = new byte[0];
                    return bArr;
                }
                this.zztw.reset();
                this.zztw.update(zza);
                byte[] digest = this.zztw.digest();
                int i = 4;
                if (digest.length <= 4) {
                    i = digest.length;
                }
                byte[] bArr2 = new byte[i];
                System.arraycopy(digest, 0, bArr2, 0, bArr2.length);
                return bArr2;
            } finally {
                bArr = th;
                Object obj2 = obj;
                Throwable th = bArr;
            }
        }
    }
}
