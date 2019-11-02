package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzsn {
    private final ByteBuffer zzbui;

    public static class zza extends IOException {
        zza(int i, int i2) {
            StringBuilder sb;
            int i3 = i;
            int i4 = i2;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            super(sb2.append("CodedOutputStream was writing to a flat byte array and ran out of space (pos ").append(i3).append(" limit ").append(i4).append(").").toString());
        }
    }

    private zzsn(ByteBuffer byteBuffer) {
        this.zzbui = byteBuffer;
        ByteBuffer order = this.zzbui.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzsn(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int zzC(int i, int i2) {
        return zzmA(i) + zzmx(i2);
    }

    public static int zzD(int i, int i2) {
        return zzmA(i) + zzmy(i2);
    }

    public static zzsn zzE(byte[] bArr) {
        byte[] bArr2 = bArr;
        return zzb(bArr2, 0, bArr2.length);
    }

    public static int zzG(byte[] bArr) {
        byte[] bArr2 = bArr;
        return zzmC(bArr2.length) + bArr2.length;
    }

    private static int zza(CharSequence charSequence, int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        CharSequence charSequence2 = charSequence;
        int i2 = i;
        int length = charSequence2.length();
        int i3 = 0;
        int i4 = i2;
        while (i4 < length) {
            int charAt = charSequence2.charAt(i4);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
            } else {
                i3 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence2, i4) < 65536) {
                        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unpaired surrogate at index ").append(i4).toString());
                        throw illegalArgumentException2;
                    }
                    i4++;
                }
            }
            i4++;
        }
        return i3;
    }

    private static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb2;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb3;
        int i3;
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        int length = charSequence2.length();
        int i6 = 0;
        int i7 = i4 + i5;
        while (i6 < length && i6 + i4 < i7) {
            char charAt = charSequence2.charAt(i6);
            if (charAt >= 128) {
                break;
            }
            bArr2[i4 + i6] = (byte) charAt;
            i6++;
        }
        if (i6 == length) {
            return i4 + length;
        }
        int i8 = i4 + i6;
        while (true) {
            int i9 = i8;
            if (i6 >= length) {
                return i9;
            }
            char charAt2 = charSequence2.charAt(i6);
            if (charAt2 < 128 && i9 < i7) {
                i3 = i9 + 1;
                bArr2[i9] = (byte) charAt2;
            } else if (charAt2 < 2048 && i9 <= i7 - 2) {
                int i10 = i9 + 1;
                bArr2[i9] = (byte) (960 | (charAt2 >>> 6));
                i3 = i10 + 1;
                bArr2[i10] = (byte) (128 | (charAt2 & '?'));
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i9 <= i7 - 3) {
                int i11 = i9 + 1;
                bArr2[i9] = (byte) (480 | (charAt2 >>> 12));
                int i12 = i11 + 1;
                bArr2[i11] = (byte) (128 | (63 & (charAt2 >>> 6)));
                i3 = i12 + 1;
                bArr2[i12] = (byte) (128 | (charAt2 & '?'));
            } else if (i9 <= i7 - 4) {
                if (i6 + 1 == charSequence2.length()) {
                    break;
                }
                i6++;
                char charAt3 = charSequence2.charAt(i6);
                if (!Character.isSurrogatePair(charAt2, charAt3)) {
                    break;
                }
                int codePoint = Character.toCodePoint(charAt2, charAt3);
                int i13 = i9 + 1;
                bArr2[i9] = (byte) (240 | (codePoint >>> 18));
                int i14 = i13 + 1;
                bArr2[i13] = (byte) (128 | (63 & (codePoint >>> 12)));
                int i15 = i14 + 1;
                bArr2[i14] = (byte) (128 | (63 & (codePoint >>> 6)));
                i3 = i15 + 1;
                bArr2[i15] = (byte) (128 | (codePoint & 63));
            } else if (55296 > charAt2 || charAt2 > 57343 || (i6 + 1 != charSequence2.length() && Character.isSurrogatePair(charAt2, charSequence2.charAt(i6 + 1)))) {
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = arrayIndexOutOfBoundsException;
                StringBuilder sb4 = sb;
                StringBuilder sb5 = new StringBuilder();
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException3 = new ArrayIndexOutOfBoundsException(sb4.append("Failed writing ").append(charAt2).append(" at index ").append(i9).toString());
                throw arrayIndexOutOfBoundsException2;
            } else {
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException;
                StringBuilder sb6 = sb2;
                StringBuilder sb7 = new StringBuilder();
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(sb6.append("Unpaired surrogate at index ").append(i6).toString());
                throw illegalArgumentException3;
            }
            i6++;
            i8 = i3;
        }
        IllegalArgumentException illegalArgumentException5 = illegalArgumentException2;
        StringBuilder sb8 = sb3;
        StringBuilder sb9 = new StringBuilder();
        IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb8.append("Unpaired surrogate at index ").append(i6 - 1).toString());
        throw illegalArgumentException5;
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        BufferOverflowException bufferOverflowException;
        ReadOnlyBufferException readOnlyBufferException;
        CharSequence charSequence2 = charSequence;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (byteBuffer2.isReadOnly()) {
            ReadOnlyBufferException readOnlyBufferException2 = readOnlyBufferException;
            ReadOnlyBufferException readOnlyBufferException3 = new ReadOnlyBufferException();
            throw readOnlyBufferException2;
        } else if (byteBuffer2.hasArray()) {
            try {
                Buffer position = byteBuffer2.position(zza(charSequence2, byteBuffer2.array(), byteBuffer2.arrayOffset() + byteBuffer2.position(), byteBuffer2.remaining()) - byteBuffer2.arrayOffset());
            } catch (ArrayIndexOutOfBoundsException e) {
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
                BufferOverflowException bufferOverflowException2 = bufferOverflowException;
                BufferOverflowException bufferOverflowException3 = new BufferOverflowException();
                BufferOverflowException bufferOverflowException4 = bufferOverflowException2;
                Throwable initCause = bufferOverflowException4.initCause(arrayIndexOutOfBoundsException);
                throw bufferOverflowException4;
            }
        } else {
            zzb(charSequence2, byteBuffer2);
        }
    }

    public static int zzaA(boolean z) {
        boolean z2 = z;
        return 1;
    }

    public static int zzar(long j) {
        return zzav(j);
    }

    public static int zzas(long j) {
        return zzav(j);
    }

    public static int zzat(long j) {
        return zzav(zzax(j));
    }

    public static int zzav(long j) {
        long j2 = j;
        if ((-128 & j2) == 0) {
            return 1;
        }
        if ((-16384 & j2) == 0) {
            return 2;
        }
        if ((-2097152 & j2) == 0) {
            return 3;
        }
        if ((-268435456 & j2) == 0) {
            return 4;
        }
        if ((-34359738368L & j2) == 0) {
            return 5;
        }
        if ((-4398046511104L & j2) == 0) {
            return 6;
        }
        if ((-562949953421312L & j2) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j2) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j2) == 0 ? 9 : 10;
    }

    public static long zzax(long j) {
        long j2 = j;
        return (j2 << 1) ^ (j2 >> 63);
    }

    public static int zzb(int i, double d) {
        return zzmA(i) + zzl(d);
    }

    public static int zzb(int i, zzsu zzsu) {
        return (2 * zzmA(i)) + zzd(zzsu);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzmA(i) + zzG(bArr);
    }

    public static zzsn zzb(byte[] bArr, int i, int i2) {
        zzsn zzsn;
        zzsn zzsn2 = zzsn;
        zzsn zzsn3 = new zzsn(bArr, i, i2);
        return zzsn2;
    }

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        CharSequence charSequence2 = charSequence;
        ByteBuffer byteBuffer2 = byteBuffer;
        int length = charSequence2.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence2.charAt(i);
            if (charAt < 128) {
                ByteBuffer put = byteBuffer2.put((byte) charAt);
            } else if (charAt < 2048) {
                ByteBuffer put2 = byteBuffer2.put((byte) (960 | (charAt >>> 6)));
                ByteBuffer put3 = byteBuffer2.put((byte) (128 | (charAt & '?')));
            } else if (charAt < 55296 || 57343 < charAt) {
                ByteBuffer put4 = byteBuffer2.put((byte) (480 | (charAt >>> 12)));
                ByteBuffer put5 = byteBuffer2.put((byte) (128 | (63 & (charAt >>> 6))));
                ByteBuffer put6 = byteBuffer2.put((byte) (128 | (charAt & '?')));
            } else {
                if (i + 1 != charSequence2.length()) {
                    i++;
                    char charAt2 = charSequence2.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int codePoint = Character.toCodePoint(charAt, charAt2);
                        ByteBuffer put7 = byteBuffer2.put((byte) (240 | (codePoint >>> 18)));
                        ByteBuffer put8 = byteBuffer2.put((byte) (128 | (63 & (codePoint >>> 12))));
                        ByteBuffer put9 = byteBuffer2.put((byte) (128 | (63 & (codePoint >>> 6))));
                        ByteBuffer put10 = byteBuffer2.put((byte) (128 | (codePoint & 63)));
                    }
                }
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unpaired surrogate at index ").append(i - 1).toString());
                throw illegalArgumentException2;
            }
            i++;
        }
    }

    public static int zzc(int i, float f) {
        return zzmA(i) + zzk(f);
    }

    public static int zzc(int i, zzsu zzsu) {
        return zzmA(i) + zze(zzsu);
    }

    private static int zzc(CharSequence charSequence) {
        int i;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        CharSequence charSequence2 = charSequence;
        int length = charSequence2.length();
        int i2 = 0;
        while (i2 < length && charSequence2.charAt(i2) < 128) {
            i2++;
        }
        int i3 = i2;
        int i4 = length;
        while (true) {
            i = i4;
            if (i3 >= length) {
                break;
            }
            int charAt = charSequence2.charAt(i3);
            if (charAt >= 2048) {
                i += zza(charSequence2, i3);
                break;
            }
            i3++;
            i4 = i + ((127 - charAt) >>> 31);
        }
        if (i >= length) {
            return i;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("UTF-8 length does not fit in int: ").append(4294967296L + ((long) i)).toString());
        throw illegalArgumentException2;
    }

    public static int zzd(int i, long j) {
        return zzmA(i) + zzas(j);
    }

    public static int zzd(zzsu zzsu) {
        return zzsu.getSerializedSize();
    }

    public static int zze(int i, long j) {
        return zzmA(i) + zzat(j);
    }

    public static int zze(zzsu zzsu) {
        int serializedSize = zzsu.getSerializedSize();
        return serializedSize + zzmC(serializedSize);
    }

    public static int zzf(int i, boolean z) {
        return zzmA(i) + zzaA(z);
    }

    public static int zzgO(String str) {
        int zzc = zzc((CharSequence) str);
        return zzc + zzmC(zzc);
    }

    public static int zzk(float f) {
        float f2 = f;
        return 4;
    }

    public static int zzl(double d) {
        double d2 = d;
        return 8;
    }

    public static int zzmA(int i) {
        return zzmC(zzsx.zzF(i, 0));
    }

    public static int zzmC(int i) {
        int i2 = i;
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        return (-268435456 & i2) == 0 ? 4 : 5;
    }

    public static int zzmE(int i) {
        int i2 = i;
        return (i2 << 1) ^ (i2 >> 31);
    }

    public static int zzmx(int i) {
        int i2 = i;
        if (i2 >= 0) {
            return zzmC(i2);
        }
        return 10;
    }

    public static int zzmy(int i) {
        return zzmC(zzmE(i));
    }

    public static int zzo(int i, String str) {
        return zzmA(i) + zzgO(str);
    }

    public void zzA(int i, int i2) throws IOException {
        int i3 = i2;
        zzE(i, 0);
        zzmv(i3);
    }

    public void zzB(int i, int i2) throws IOException {
        int i3 = i2;
        zzE(i, 0);
        zzmw(i3);
    }

    public void zzE(int i, int i2) throws IOException {
        zzmB(zzsx.zzF(i, i2));
    }

    public void zzF(byte[] bArr) throws IOException {
        byte[] bArr2 = bArr;
        zzmB(bArr2.length);
        zzH(bArr2);
    }

    public void zzH(byte[] bArr) throws IOException {
        byte[] bArr2 = bArr;
        zzc(bArr2, 0, bArr2.length);
    }

    public int zzJn() {
        return this.zzbui.remaining();
    }

    public void zzJo() {
        IllegalStateException illegalStateException;
        if (zzJn() != 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Did not write as much data as expected.");
            throw illegalStateException2;
        }
    }

    public void zza(int i, double d) throws IOException {
        double d2 = d;
        zzE(i, 1);
        zzk(d2);
    }

    public void zza(int i, long j) throws IOException {
        long j2 = j;
        zzE(i, 0);
        zzao(j2);
    }

    public void zza(int i, zzsu zzsu) throws IOException {
        zzsu zzsu2 = zzsu;
        zzE(i, 2);
        zzc(zzsu2);
    }

    public void zza(int i, byte[] bArr) throws IOException {
        byte[] bArr2 = bArr;
        zzE(i, 2);
        zzF(bArr2);
    }

    public void zzao(long j) throws IOException {
        zzau(j);
    }

    public void zzap(long j) throws IOException {
        zzau(j);
    }

    public void zzaq(long j) throws IOException {
        zzau(zzax(j));
    }

    public void zzau(long j) throws IOException {
        long j2 = j;
        while ((-128 & j2) != 0) {
            zzmz(128 | (127 & ((int) j2)));
            j2 >>>= 7;
        }
        zzmz((int) j2);
    }

    public void zzaw(long j) throws IOException {
        zza zza2;
        long j2 = j;
        if (this.zzbui.remaining() < 8) {
            zza zza3 = zza2;
            zza zza4 = new zza(this.zzbui.position(), this.zzbui.limit());
            throw zza3;
        }
        ByteBuffer putLong = this.zzbui.putLong(j2);
    }

    public void zzaz(boolean z) throws IOException {
        zzmz(z ? 1 : 0);
    }

    public void zzb(byte b) throws IOException {
        zza zza2;
        byte b2 = b;
        if (!this.zzbui.hasRemaining()) {
            zza zza3 = zza2;
            zza zza4 = new zza(this.zzbui.position(), this.zzbui.limit());
            throw zza3;
        }
        ByteBuffer put = this.zzbui.put(b2);
    }

    public void zzb(int i, float f) throws IOException {
        float f2 = f;
        zzE(i, 5);
        zzj(f2);
    }

    public void zzb(int i, long j) throws IOException {
        long j2 = j;
        zzE(i, 0);
        zzap(j2);
    }

    public void zzb(zzsu zzsu) throws IOException {
        zzsu.writeTo(this);
    }

    public void zzc(int i, long j) throws IOException {
        long j2 = j;
        zzE(i, 0);
        zzaq(j2);
    }

    public void zzc(zzsu zzsu) throws IOException {
        zzsu zzsu2 = zzsu;
        zzmB(zzsu2.getCachedSize());
        zzsu2.writeTo(this);
    }

    public void zzc(byte[] bArr, int i, int i2) throws IOException {
        zza zza2;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        if (this.zzbui.remaining() >= i4) {
            ByteBuffer put = this.zzbui.put(bArr2, i3, i4);
            return;
        }
        zza zza3 = zza2;
        zza zza4 = new zza(this.zzbui.position(), this.zzbui.limit());
        throw zza3;
    }

    public void zze(int i, boolean z) throws IOException {
        boolean z2 = z;
        zzE(i, 0);
        zzaz(z2);
    }

    public void zzgN(String str) throws IOException {
        zza zza2;
        zza zza3;
        String str2 = str;
        try {
            int zzmC = zzmC(str2.length());
            if (zzmC == zzmC(3 * str2.length())) {
                int position = this.zzbui.position();
                if (this.zzbui.remaining() < zzmC) {
                    zza zza4 = zza3;
                    zza zza5 = new zza(zzmC + position, this.zzbui.limit());
                    throw zza4;
                }
                Buffer position2 = this.zzbui.position(position + zzmC);
                zza((CharSequence) str2, this.zzbui);
                int position3 = this.zzbui.position();
                Buffer position4 = this.zzbui.position(position);
                zzmB((position3 - position) - zzmC);
                Buffer position5 = this.zzbui.position(position3);
                return;
            }
            zzmB(zzc((CharSequence) str2));
            zza((CharSequence) str2, this.zzbui);
        } catch (BufferOverflowException e) {
            BufferOverflowException bufferOverflowException = e;
            zza zza6 = zza2;
            zza zza7 = new zza(this.zzbui.position(), this.zzbui.limit());
            zza zza8 = zza6;
            Throwable initCause = zza8.initCause(bufferOverflowException);
            throw zza8;
        }
    }

    public void zzj(float f) throws IOException {
        zzmD(Float.floatToIntBits(f));
    }

    public void zzk(double d) throws IOException {
        zzaw(Double.doubleToLongBits(d));
    }

    public void zzmB(int i) throws IOException {
        int i2 = i;
        while ((i2 & -128) != 0) {
            zzmz(128 | (i2 & 127));
            i2 >>>= 7;
        }
        zzmz(i2);
    }

    public void zzmD(int i) throws IOException {
        zza zza2;
        int i2 = i;
        if (this.zzbui.remaining() < 4) {
            zza zza3 = zza2;
            zza zza4 = new zza(this.zzbui.position(), this.zzbui.limit());
            throw zza3;
        }
        ByteBuffer putInt = this.zzbui.putInt(i2);
    }

    public void zzmv(int i) throws IOException {
        int i2 = i;
        if (i2 >= 0) {
            zzmB(i2);
        } else {
            zzau((long) i2);
        }
    }

    public void zzmw(int i) throws IOException {
        zzmB(zzmE(i));
    }

    public void zzmz(int i) throws IOException {
        zzb((byte) i);
    }

    public void zzn(int i, String str) throws IOException {
        String str2 = str;
        zzE(i, 2);
        zzgN(str2);
    }
}
