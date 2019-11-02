package com.google.android.gms.ads.internal.purchase;

import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

@zzhb
public class zzl {
    public static boolean zza(PublicKey publicKey, String str, String str2) {
        PublicKey publicKey2 = publicKey;
        String str3 = str;
        String str4 = str2;
        try {
            Signature instance = Signature.getInstance("SHA1withRSA");
            instance.initVerify(publicKey2);
            instance.update(str3.getBytes());
            if (instance.verify(Base64.decode(str4, 0))) {
                return true;
            }
            zzin.m19e("Signature verification failed.");
            return false;
        } catch (NoSuchAlgorithmException e) {
            NoSuchAlgorithmException noSuchAlgorithmException = e;
            zzin.m19e("NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException e2) {
            InvalidKeyException invalidKeyException = e2;
            zzin.m19e("Invalid key specification.");
            return false;
        } catch (SignatureException e3) {
            SignatureException signatureException = e3;
            zzin.m19e("Signature exception.");
            return false;
        }
    }

    public static PublicKey zzas(String str) {
        IllegalArgumentException illegalArgumentException;
        RuntimeException runtimeException;
        X509EncodedKeySpec x509EncodedKeySpec;
        try {
            byte[] decode = Base64.decode(str, 0);
            KeyFactory instance = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec x509EncodedKeySpec2 = x509EncodedKeySpec;
            X509EncodedKeySpec x509EncodedKeySpec3 = new X509EncodedKeySpec(decode);
            return instance.generatePublic(x509EncodedKeySpec2);
        } catch (NoSuchAlgorithmException e) {
            NoSuchAlgorithmException noSuchAlgorithmException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(noSuchAlgorithmException);
            throw runtimeException2;
        } catch (InvalidKeySpecException e2) {
            InvalidKeySpecException invalidKeySpecException = e2;
            zzin.m19e("Invalid key specification.");
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(invalidKeySpecException);
            throw illegalArgumentException2;
        }
    }

    public static boolean zzc(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str6)) {
            return zza(zzas(str4), str5, str6);
        }
        zzin.m19e("Purchase verification failed: missing data.");
        return false;
    }
}
