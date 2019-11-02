package android.support.p000v4.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23 */
public final class FingerprintManagerCompatApi23 {

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationCallback */
    public static abstract class AuthenticationCallback {
        public AuthenticationCallback() {
        }

        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResultInternal authenticationResultInternal) {
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationResultInternal */
    public static final class AuthenticationResultInternal {
        private CryptoObject mCryptoObject;

        public AuthenticationResultInternal(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$CryptoObject */
    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }

        public Signature getSignature() {
            return this.mSignature;
        }
    }

    public FingerprintManagerCompatApi23() {
    }

    public static void authenticate(Context context, CryptoObject cryptoObject, int i, Object obj, AuthenticationCallback authenticationCallback, Handler handler) {
        int i2 = i;
        Handler handler2 = handler;
        getFingerprintManager(context).authenticate(wrapCryptoObject(cryptoObject), (CancellationSignal) obj, i2, wrapCallback(authenticationCallback), handler2);
    }

    private static FingerprintManager getFingerprintManager(Context context) {
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    public static boolean hasEnrolledFingerprints(Context context) {
        return getFingerprintManager(context).hasEnrolledFingerprints();
    }

    public static boolean isHardwareDetected(Context context) {
        return getFingerprintManager(context).isHardwareDetected();
    }

    /* access modifiers changed from: private */
    public static CryptoObject unwrapCryptoObject(android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject) {
        CryptoObject cryptoObject2;
        CryptoObject cryptoObject3;
        CryptoObject cryptoObject4;
        android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject5 = cryptoObject;
        if (cryptoObject5 != null) {
            if (cryptoObject5.getCipher() != null) {
                CryptoObject cryptoObject6 = cryptoObject4;
                CryptoObject cryptoObject7 = new CryptoObject(cryptoObject5.getCipher());
                return cryptoObject6;
            } else if (cryptoObject5.getSignature() != null) {
                CryptoObject cryptoObject8 = cryptoObject3;
                CryptoObject cryptoObject9 = new CryptoObject(cryptoObject5.getSignature());
                return cryptoObject8;
            } else if (cryptoObject5.getMac() != null) {
                CryptoObject cryptoObject10 = cryptoObject2;
                CryptoObject cryptoObject11 = new CryptoObject(cryptoObject5.getMac());
                return cryptoObject10;
            }
        }
        return null;
    }

    private static android.hardware.fingerprint.FingerprintManager.AuthenticationCallback wrapCallback(AuthenticationCallback authenticationCallback) {
        C00421 r4;
        C00421 r1 = r4;
        final AuthenticationCallback authenticationCallback2 = authenticationCallback;
        C00421 r2 = new android.hardware.fingerprint.FingerprintManager.AuthenticationCallback() {
            public void onAuthenticationError(int i, CharSequence charSequence) {
                int i2 = i;
                CharSequence charSequence2 = charSequence;
                authenticationCallback2.onAuthenticationError(i2, charSequence2);
            }

            public void onAuthenticationFailed() {
                authenticationCallback2.onAuthenticationFailed();
            }

            public void onAuthenticationHelp(int i, CharSequence charSequence) {
                int i2 = i;
                CharSequence charSequence2 = charSequence;
                authenticationCallback2.onAuthenticationHelp(i2, charSequence2);
            }

            public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
                AuthenticationResultInternal authenticationResultInternal;
                AuthenticationResult authenticationResult2 = authenticationResult;
                AuthenticationCallback authenticationCallback = authenticationCallback2;
                AuthenticationResultInternal authenticationResultInternal2 = authenticationResultInternal;
                AuthenticationResultInternal authenticationResultInternal3 = new AuthenticationResultInternal(FingerprintManagerCompatApi23.unwrapCryptoObject(authenticationResult2.getCryptoObject()));
                authenticationCallback.onAuthenticationSucceeded(authenticationResultInternal2);
            }
        };
        return r1;
    }

    private static android.hardware.fingerprint.FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject2;
        android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject3;
        android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject4;
        CryptoObject cryptoObject5 = cryptoObject;
        if (cryptoObject5 != null) {
            if (cryptoObject5.getCipher() != null) {
                android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject6 = cryptoObject4;
                android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject7 = new android.hardware.fingerprint.FingerprintManager.CryptoObject(cryptoObject5.getCipher());
                return cryptoObject6;
            } else if (cryptoObject5.getSignature() != null) {
                android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject8 = cryptoObject3;
                android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject9 = new android.hardware.fingerprint.FingerprintManager.CryptoObject(cryptoObject5.getSignature());
                return cryptoObject8;
            } else if (cryptoObject5.getMac() != null) {
                android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject10 = cryptoObject2;
                android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject11 = new android.hardware.fingerprint.FingerprintManager.CryptoObject(cryptoObject5.getMac());
                return cryptoObject10;
            }
        }
        return null;
    }
}
