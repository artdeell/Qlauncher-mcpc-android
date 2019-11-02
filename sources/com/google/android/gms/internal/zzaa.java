package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class zzaa extends ByteArrayOutputStream {
    private final zzu zzar;

    public zzaa(zzu zzu, int i) {
        int i2 = i;
        this.zzar = zzu;
        this.buf = this.zzar.zzb(Math.max(i2, 256));
    }

    private void zzd(int i) {
        int i2 = i;
        if (i2 + this.count > this.buf.length) {
            byte[] zzb = this.zzar.zzb(2 * (i2 + this.count));
            System.arraycopy(this.buf, 0, zzb, 0, this.count);
            this.zzar.zza(this.buf);
            this.buf = zzb;
        }
    }

    public void close() throws IOException {
        this.zzar.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.zzar.zza(this.buf);
    }

    public void write(int i) {
        int i2 = i;
        synchronized (this) {
            try {
                zzd(1);
                super.write(i2);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        synchronized (this) {
            try {
                zzd(i4);
                super.write(bArr2, i3, i4);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}
