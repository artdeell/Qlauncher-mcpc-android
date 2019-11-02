package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public abstract class zzsu {
    protected volatile int zzbuu = -1;

    public zzsu() {
    }

    public static final <T extends zzsu> T mergeFrom(T t, byte[] bArr) throws zzst {
        byte[] bArr2 = bArr;
        return mergeFrom(t, bArr2, 0, bArr2.length);
    }

    public static final <T extends zzsu> T mergeFrom(T t, byte[] bArr, int i, int i2) throws zzst {
        RuntimeException runtimeException;
        T t2 = t;
        try {
            zzsm zza = zzsm.zza(bArr, i, i2);
            zzsu mergeFrom = t2.mergeFrom(zza);
            zza.zzmn(0);
            return t2;
        } catch (zzst e) {
            throw e;
        } catch (IOException e2) {
            IOException iOException = e2;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
            throw runtimeException2;
        }
    }

    public static final boolean messageNanoEquals(zzsu zzsu, zzsu zzsu2) {
        boolean z;
        zzsu zzsu3 = zzsu;
        zzsu zzsu4 = zzsu2;
        if (zzsu3 == zzsu4) {
            z = true;
        } else {
            z = false;
            if (zzsu3 != null) {
                z = false;
                if (zzsu4 != null) {
                    z = false;
                    if (zzsu3.getClass() == zzsu4.getClass()) {
                        int serializedSize = zzsu3.getSerializedSize();
                        z = false;
                        if (zzsu4.getSerializedSize() == serializedSize) {
                            byte[] bArr = new byte[serializedSize];
                            byte[] bArr2 = new byte[serializedSize];
                            toByteArray(zzsu3, bArr, 0, serializedSize);
                            toByteArray(zzsu4, bArr2, 0, serializedSize);
                            return Arrays.equals(bArr, bArr2);
                        }
                    }
                }
            }
        }
        return z;
    }

    public static final void toByteArray(zzsu zzsu, byte[] bArr, int i, int i2) {
        RuntimeException runtimeException;
        zzsu zzsu2 = zzsu;
        try {
            zzsn zzb = zzsn.zzb(bArr, i, i2);
            zzsu2.writeTo(zzb);
            zzb.zzJo();
        } catch (IOException e) {
            IOException iOException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", iOException);
            throw runtimeException2;
        }
    }

    public static final byte[] toByteArray(zzsu zzsu) {
        zzsu zzsu2 = zzsu;
        byte[] bArr = new byte[zzsu2.getSerializedSize()];
        toByteArray(zzsu2, bArr, 0, bArr.length);
        return bArr;
    }

    public zzsu clone() throws CloneNotSupportedException {
        return (zzsu) super.clone();
    }

    public int getCachedSize() {
        if (this.zzbuu < 0) {
            int serializedSize = getSerializedSize();
        }
        return this.zzbuu;
    }

    public int getSerializedSize() {
        int zzz = zzz();
        this.zzbuu = zzz;
        return zzz;
    }

    public abstract zzsu mergeFrom(zzsm zzsm) throws IOException;

    public String toString() {
        return zzsv.zzf(this);
    }

    public void writeTo(zzsn zzsn) throws IOException {
    }

    /* access modifiers changed from: protected */
    public int zzz() {
        return 0;
    }
}
