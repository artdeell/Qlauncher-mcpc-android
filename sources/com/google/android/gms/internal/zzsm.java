package com.google.android.gms.internal;

import java.io.IOException;

public final class zzsm {
    private final byte[] buffer;
    private int zzbtZ;
    private int zzbua;
    private int zzbub;
    private int zzbuc;
    private int zzbud;
    private int zzbue = IDirectInputDevice.DIPROPRANGE_NOMAX;
    private int zzbuf;
    private int zzbug = 64;
    private int zzbuh = 67108864;

    private zzsm(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        this.buffer = bArr2;
        this.zzbtZ = i3;
        this.zzbua = i3 + i4;
        this.zzbuc = i3;
    }

    public static zzsm zzD(byte[] bArr) {
        byte[] bArr2 = bArr;
        return zza(bArr2, 0, bArr2.length);
    }

    private void zzJj() {
        this.zzbua += this.zzbub;
        int i = this.zzbua;
        if (i > this.zzbue) {
            this.zzbub = i - this.zzbue;
            this.zzbua -= this.zzbub;
            return;
        }
        this.zzbub = 0;
    }

    public static zzsm zza(byte[] bArr, int i, int i2) {
        zzsm zzsm;
        zzsm zzsm2 = zzsm;
        zzsm zzsm3 = new zzsm(bArr, i, i2);
        return zzsm2;
    }

    public static long zzan(long j) {
        long j2 = j;
        return (j2 >>> 1) ^ (-(1 & j2));
    }

    public static int zzmp(int i) {
        int i2 = i;
        return (i2 >>> 1) ^ (-(i2 & 1));
    }

    public int getPosition() {
        return this.zzbuc - this.zzbtZ;
    }

    public byte[] readBytes() throws IOException {
        int zzJf = zzJf();
        if (zzJf > this.zzbua - this.zzbuc || zzJf <= 0) {
            return zzJf == 0 ? zzsx.zzbuD : zzmt(zzJf);
        }
        byte[] bArr = new byte[zzJf];
        System.arraycopy(this.buffer, this.zzbuc, bArr, 0, zzJf);
        this.zzbuc = zzJf + this.zzbuc;
        return bArr;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(zzJi());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(zzJh());
    }

    public String readString() throws IOException {
        String str;
        String str2;
        int zzJf = zzJf();
        if (zzJf > this.zzbua - this.zzbuc || zzJf <= 0) {
            String str3 = str;
            String str4 = new String(zzmt(zzJf), "UTF-8");
            return str3;
        }
        String str5 = str2;
        String str6 = new String(this.buffer, this.zzbuc, zzJf, "UTF-8");
        String str7 = str5;
        this.zzbuc = zzJf + this.zzbuc;
        return str7;
    }

    public int zzIX() throws IOException {
        if (zzJl()) {
            this.zzbud = 0;
            return 0;
        }
        this.zzbud = zzJf();
        if (this.zzbud != 0) {
            return this.zzbud;
        }
        throw zzst.zzJv();
    }

    public void zzIY() throws IOException {
        int zzIX;
        do {
            zzIX = zzIX();
            if (zzIX == 0) {
                return;
            }
        } while (zzmo(zzIX));
    }

    public long zzIZ() throws IOException {
        return zzJg();
    }

    public long zzJa() throws IOException {
        return zzJg();
    }

    public int zzJb() throws IOException {
        return zzJf();
    }

    public boolean zzJc() throws IOException {
        return zzJf() != 0;
    }

    public int zzJd() throws IOException {
        return zzmp(zzJf());
    }

    public long zzJe() throws IOException {
        return zzan(zzJg());
    }

    public int zzJf() throws IOException {
        byte zzJm = zzJm();
        if (zzJm < 0) {
            byte b = zzJm & Byte.MAX_VALUE;
            byte zzJm2 = zzJm();
            if (zzJm2 >= 0) {
                return b | (zzJm2 << 7);
            }
            byte b2 = b | ((zzJm2 & Byte.MAX_VALUE) << 7);
            byte zzJm3 = zzJm();
            if (zzJm3 >= 0) {
                return b2 | (zzJm3 << 14);
            }
            byte b3 = b2 | ((zzJm3 & Byte.MAX_VALUE) << 14);
            byte zzJm4 = zzJm();
            if (zzJm4 >= 0) {
                return b3 | (zzJm4 << 21);
            }
            byte b4 = b3 | ((zzJm4 & Byte.MAX_VALUE) << 21);
            byte zzJm5 = zzJm();
            zzJm = b4 | (zzJm5 << 28);
            if (zzJm5 < 0) {
                int i = 0;
                while (i < 5) {
                    if (zzJm() < 0) {
                        i++;
                    }
                }
                throw zzst.zzJu();
            }
        }
        return zzJm;
    }

    public long zzJg() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzJm = zzJm();
            j |= ((long) (zzJm & Byte.MAX_VALUE)) << i;
            if ((zzJm & 128) == 0) {
                return j;
            }
        }
        throw zzst.zzJu();
    }

    public int zzJh() throws IOException {
        return (zzJm() & 255) | ((zzJm() & 255) << 8) | ((zzJm() & 255) << 16) | ((zzJm() & 255) << 24);
    }

    public long zzJi() throws IOException {
        return (255 & ((long) zzJm())) | ((255 & ((long) zzJm())) << 8) | ((255 & ((long) zzJm())) << 16) | ((255 & ((long) zzJm())) << 24) | ((255 & ((long) zzJm())) << 32) | ((255 & ((long) zzJm())) << 40) | ((255 & ((long) zzJm())) << 48) | ((255 & ((long) zzJm())) << 56);
    }

    public int zzJk() {
        if (this.zzbue == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzbue - this.zzbuc;
    }

    public boolean zzJl() {
        return this.zzbuc == this.zzbua;
    }

    public byte zzJm() throws IOException {
        if (this.zzbuc == this.zzbua) {
            throw zzst.zzJs();
        }
        byte[] bArr = this.buffer;
        int i = this.zzbuc;
        this.zzbuc = i + 1;
        return bArr[i];
    }

    public void zza(zzsu zzsu) throws IOException {
        zzsu zzsu2 = zzsu;
        int zzJf = zzJf();
        if (this.zzbuf >= this.zzbug) {
            throw zzst.zzJy();
        }
        int zzmq = zzmq(zzJf);
        this.zzbuf = 1 + this.zzbuf;
        zzsu mergeFrom = zzsu2.mergeFrom(this);
        zzmn(0);
        this.zzbuf = -1 + this.zzbuf;
        zzmr(zzmq);
    }

    public void zza(zzsu zzsu, int i) throws IOException {
        zzsu zzsu2 = zzsu;
        int i2 = i;
        if (this.zzbuf >= this.zzbug) {
            throw zzst.zzJy();
        }
        this.zzbuf = 1 + this.zzbuf;
        zzsu mergeFrom = zzsu2.mergeFrom(this);
        zzmn(zzsx.zzF(i2, 4));
        this.zzbuf = -1 + this.zzbuf;
    }

    public void zzmn(int i) throws zzst {
        if (this.zzbud != i) {
            throw zzst.zzJw();
        }
    }

    public boolean zzmo(int i) throws IOException {
        int i2 = i;
        switch (zzsx.zzmI(i2)) {
            case 0:
                int zzJb = zzJb();
                return true;
            case 1:
                long zzJi = zzJi();
                return true;
            case 2:
                zzmu(zzJf());
                return true;
            case 3:
                zzIY();
                zzmn(zzsx.zzF(zzsx.zzmJ(i2), 4));
                return true;
            case 4:
                return false;
            case 5:
                int zzJh = zzJh();
                return true;
            default:
                throw zzst.zzJx();
        }
    }

    public int zzmq(int i) throws zzst {
        int i2 = i;
        if (i2 < 0) {
            throw zzst.zzJt();
        }
        int i3 = i2 + this.zzbuc;
        int i4 = this.zzbue;
        if (i3 > i4) {
            throw zzst.zzJs();
        }
        this.zzbue = i3;
        zzJj();
        return i4;
    }

    public void zzmr(int i) {
        this.zzbue = i;
        zzJj();
    }

    public void zzms(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb2;
        int i2 = i;
        if (i2 > this.zzbuc - this.zzbtZ) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(sb3.append("Position ").append(i2).append(" is beyond current ").append(this.zzbuc - this.zzbtZ).toString());
            throw illegalArgumentException3;
        } else if (i2 < 0) {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb5.append("Bad position ").append(i2).toString());
            throw illegalArgumentException5;
        } else {
            this.zzbuc = i2 + this.zzbtZ;
        }
    }

    public byte[] zzmt(int i) throws IOException {
        int i2 = i;
        if (i2 < 0) {
            throw zzst.zzJt();
        } else if (i2 + this.zzbuc > this.zzbue) {
            zzmu(this.zzbue - this.zzbuc);
            throw zzst.zzJs();
        } else if (i2 <= this.zzbua - this.zzbuc) {
            byte[] bArr = new byte[i2];
            System.arraycopy(this.buffer, this.zzbuc, bArr, 0, i2);
            this.zzbuc = i2 + this.zzbuc;
            return bArr;
        } else {
            throw zzst.zzJs();
        }
    }

    public void zzmu(int i) throws IOException {
        int i2 = i;
        if (i2 < 0) {
            throw zzst.zzJt();
        } else if (i2 + this.zzbuc > this.zzbue) {
            zzmu(this.zzbue - this.zzbuc);
            throw zzst.zzJs();
        } else if (i2 <= this.zzbua - this.zzbuc) {
            this.zzbuc = i2 + this.zzbuc;
        } else {
            throw zzst.zzJs();
        }
    }

    public byte[] zzz(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (i4 == 0) {
            return zzsx.zzbuD;
        }
        byte[] bArr = new byte[i4];
        System.arraycopy(this.buffer, i3 + this.zzbtZ, bArr, 0, i4);
        return bArr;
    }
}
