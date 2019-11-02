package com.google.android.gms.internal;

public class zzsl {
    private final byte[] zzbtW = new byte[256];
    private int zzbtX;
    private int zzbtY;

    public zzsl(byte[] bArr) {
        byte[] bArr2 = bArr;
        for (int i = 0; i < 256; i++) {
            this.zzbtW[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            b = 255 & (b + this.zzbtW[i2] + bArr2[i2 % bArr2.length]);
            byte b2 = this.zzbtW[i2];
            this.zzbtW[i2] = this.zzbtW[b];
            this.zzbtW[b] = b2;
        }
        this.zzbtX = 0;
        this.zzbtY = 0;
    }

    public void zzC(byte[] bArr) {
        byte[] bArr2 = bArr;
        int i = this.zzbtX;
        int i2 = this.zzbtY;
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            i = 255 & (i + 1);
            i2 = 255 & (i2 + this.zzbtW[i]);
            byte b = this.zzbtW[i];
            this.zzbtW[i] = this.zzbtW[i2];
            this.zzbtW[i2] = b;
            bArr2[i3] = (byte) (bArr2[i3] ^ this.zzbtW[255 & (this.zzbtW[i] + this.zzbtW[i2])]);
        }
        this.zzbtX = i;
        this.zzbtY = i2;
    }
}
