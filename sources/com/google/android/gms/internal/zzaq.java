package com.google.android.gms.internal;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class zzaq {
    private final zzap zznF;
    private final SecureRandom zzox;

    public class zza extends Exception {
        final /* synthetic */ zzaq zzoy;

        public zza(zzaq zzaq) {
            this.zzoy = zzaq;
        }

        public zza(zzaq zzaq, Throwable th) {
            Throwable th2 = th;
            this.zzoy = zzaq;
            super(th2);
        }
    }

    public zzaq(zzap zzap, SecureRandom secureRandom) {
        SecureRandom secureRandom2 = secureRandom;
        this.zznF = zzap;
        this.zzox = secureRandom2;
    }

    static void zze(byte[] bArr) {
        byte[] bArr2 = bArr;
        for (int i = 0; i < bArr2.length; i++) {
            bArr2[i] = (byte) (68 ^ bArr2[i]);
        }
    }

    public byte[] zzc(byte[] bArr, String str) throws zza {
        zza zza2;
        zza zza3;
        zza zza4;
        zza zza5;
        zza zza6;
        zza zza7;
        zza zza8;
        SecretKeySpec secretKeySpec;
        IvParameterSpec ivParameterSpec;
        zza zza9;
        zza zza10;
        byte[] bArr2 = bArr;
        String str2 = str;
        if (bArr2.length != 16) {
            zza zza11 = zza10;
            zza zza12 = new zza(this);
            throw zza11;
        }
        try {
            byte[] zza13 = this.zznF.zza(str2, false);
            if (zza13.length <= 16) {
                zza zza14 = zza9;
                zza zza15 = new zza(this);
                throw zza14;
            }
            ByteBuffer allocate = ByteBuffer.allocate(zza13.length);
            ByteBuffer put = allocate.put(zza13);
            Buffer flip = allocate.flip();
            byte[] bArr3 = new byte[16];
            byte[] bArr4 = new byte[(-16 + zza13.length)];
            ByteBuffer byteBuffer = allocate.get(bArr3);
            ByteBuffer byteBuffer2 = allocate.get(bArr4);
            SecretKeySpec secretKeySpec2 = secretKeySpec;
            SecretKeySpec secretKeySpec3 = new SecretKeySpec(bArr2, "AES");
            SecretKeySpec secretKeySpec4 = secretKeySpec2;
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            Cipher cipher = instance;
            SecretKeySpec secretKeySpec5 = secretKeySpec4;
            IvParameterSpec ivParameterSpec2 = ivParameterSpec;
            IvParameterSpec ivParameterSpec3 = new IvParameterSpec(bArr3);
            cipher.init(2, secretKeySpec5, ivParameterSpec2);
            return instance.doFinal(bArr4);
        } catch (NoSuchAlgorithmException e) {
            NoSuchAlgorithmException noSuchAlgorithmException = e;
            zza zza16 = zza8;
            zza zza17 = new zza(this, noSuchAlgorithmException);
            throw zza16;
        } catch (InvalidKeyException e2) {
            InvalidKeyException invalidKeyException = e2;
            zza zza18 = zza7;
            zza zza19 = new zza(this, invalidKeyException);
            throw zza18;
        } catch (IllegalBlockSizeException e3) {
            IllegalBlockSizeException illegalBlockSizeException = e3;
            zza zza20 = zza6;
            zza zza21 = new zza(this, illegalBlockSizeException);
            throw zza20;
        } catch (NoSuchPaddingException e4) {
            NoSuchPaddingException noSuchPaddingException = e4;
            zza zza22 = zza5;
            zza zza23 = new zza(this, noSuchPaddingException);
            throw zza22;
        } catch (BadPaddingException e5) {
            BadPaddingException badPaddingException = e5;
            zza zza24 = zza4;
            zza zza25 = new zza(this, badPaddingException);
            throw zza24;
        } catch (InvalidAlgorithmParameterException e6) {
            InvalidAlgorithmParameterException invalidAlgorithmParameterException = e6;
            zza zza26 = zza3;
            zza zza27 = new zza(this, invalidAlgorithmParameterException);
            throw zza26;
        } catch (IllegalArgumentException e7) {
            IllegalArgumentException illegalArgumentException = e7;
            zza zza28 = zza2;
            zza zza29 = new zza(this, illegalArgumentException);
            throw zza28;
        }
    }

    public byte[] zzl(String str) throws zza {
        zza zza2;
        zza zza3;
        try {
            byte[] zza4 = this.zznF.zza(str, false);
            if (zza4.length != 32) {
                zza zza5 = zza3;
                zza zza6 = new zza(this);
                throw zza5;
            }
            byte[] bArr = new byte[16];
            ByteBuffer byteBuffer = ByteBuffer.wrap(zza4, 4, 16).get(bArr);
            zze(bArr);
            return bArr;
        } catch (IllegalArgumentException e) {
            IllegalArgumentException illegalArgumentException = e;
            zza zza7 = zza2;
            zza zza8 = new zza(this, illegalArgumentException);
            throw zza7;
        }
    }
}
