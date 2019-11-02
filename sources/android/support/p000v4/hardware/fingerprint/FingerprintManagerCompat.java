package android.support.p000v4.hardware.fingerprint;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationResultInternal;
import android.support.p000v4.p002os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat */
public class FingerprintManagerCompat {
    static final FingerprintManagerCompatImpl IMPL;
    private Context mContext;

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$Api23FingerprintManagerCompatImpl */
    private static class Api23FingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
        public Api23FingerprintManagerCompatImpl() {
        }

        /* access modifiers changed from: private */
        public static CryptoObject unwrapCryptoObject(android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject cryptoObject) {
            CryptoObject cryptoObject2;
            CryptoObject cryptoObject3;
            CryptoObject cryptoObject4;
            android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject cryptoObject5 = cryptoObject;
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

        private static android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback wrapCallback(AuthenticationCallback authenticationCallback) {
            C00411 r4;
            C00411 r1 = r4;
            final AuthenticationCallback authenticationCallback2 = authenticationCallback;
            C00411 r2 = new android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.AuthenticationCallback() {
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

                public void onAuthenticationSucceeded(AuthenticationResultInternal authenticationResultInternal) {
                    AuthenticationResult authenticationResult;
                    AuthenticationResultInternal authenticationResultInternal2 = authenticationResultInternal;
                    AuthenticationCallback authenticationCallback = authenticationCallback2;
                    AuthenticationResult authenticationResult2 = authenticationResult;
                    AuthenticationResult authenticationResult3 = new AuthenticationResult(Api23FingerprintManagerCompatImpl.unwrapCryptoObject(authenticationResultInternal2.getCryptoObject()));
                    authenticationCallback.onAuthenticationSucceeded(authenticationResult2);
                }
            };
            return r1;
        }

        private static android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
            android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject cryptoObject2;
            android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject cryptoObject3;
            android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject cryptoObject4;
            CryptoObject cryptoObject5 = cryptoObject;
            if (cryptoObject5 != null) {
                if (cryptoObject5.getCipher() != null) {
                    android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject cryptoObject6 = cryptoObject4;
                    android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject cryptoObject7 = new android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject(cryptoObject5.getCipher());
                    return cryptoObject6;
                } else if (cryptoObject5.getSignature() != null) {
                    android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject cryptoObject8 = cryptoObject3;
                    android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject cryptoObject9 = new android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject(cryptoObject5.getSignature());
                    return cryptoObject8;
                } else if (cryptoObject5.getMac() != null) {
                    android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject cryptoObject10 = cryptoObject2;
                    android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject cryptoObject11 = new android.support.p000v4.hardware.fingerprint.FingerprintManagerCompatApi23.CryptoObject(cryptoObject5.getMac());
                    return cryptoObject10;
                }
            }
            return null;
        }

        public void authenticate(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
            CancellationSignal cancellationSignal2 = cancellationSignal;
            FingerprintManagerCompatApi23.authenticate(context, wrapCryptoObject(cryptoObject), i, cancellationSignal2 != null ? cancellationSignal2.getCancellationSignalObject() : null, wrapCallback(authenticationCallback), handler);
        }

        public boolean hasEnrolledFingerprints(Context context) {
            return FingerprintManagerCompatApi23.hasEnrolledFingerprints(context);
        }

        public boolean isHardwareDetected(Context context) {
            return FingerprintManagerCompatApi23.isHardwareDetected(context);
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$AuthenticationCallback */
    public static abstract class AuthenticationCallback {
        public AuthenticationCallback() {
        }

        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$AuthenticationResult */
    public static final class AuthenticationResult {
        private CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$CryptoObject */
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

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$FingerprintManagerCompatImpl */
    private interface FingerprintManagerCompatImpl {
        void authenticate(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler);

        boolean hasEnrolledFingerprints(Context context);

        boolean isHardwareDetected(Context context);
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompat$LegacyFingerprintManagerCompatImpl */
    private static class LegacyFingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
        public LegacyFingerprintManagerCompatImpl() {
        }

        public void authenticate(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        }

        public boolean hasEnrolledFingerprints(Context context) {
            Context context2 = context;
            return false;
        }

        public boolean isHardwareDetected(Context context) {
            Context context2 = context;
            return false;
        }
    }

    static {
        LegacyFingerprintManagerCompatImpl legacyFingerprintManagerCompatImpl;
        Api23FingerprintManagerCompatImpl api23FingerprintManagerCompatImpl;
        if (VERSION.SDK_INT >= 23) {
            Api23FingerprintManagerCompatImpl api23FingerprintManagerCompatImpl2 = api23FingerprintManagerCompatImpl;
            Api23FingerprintManagerCompatImpl api23FingerprintManagerCompatImpl3 = new Api23FingerprintManagerCompatImpl();
            IMPL = api23FingerprintManagerCompatImpl2;
            return;
        }
        LegacyFingerprintManagerCompatImpl legacyFingerprintManagerCompatImpl2 = legacyFingerprintManagerCompatImpl;
        LegacyFingerprintManagerCompatImpl legacyFingerprintManagerCompatImpl3 = new LegacyFingerprintManagerCompatImpl();
        IMPL = legacyFingerprintManagerCompatImpl2;
    }

    private FingerprintManagerCompat(Context context) {
        this.mContext = context;
    }

    public static FingerprintManagerCompat from(Context context) {
        FingerprintManagerCompat fingerprintManagerCompat;
        FingerprintManagerCompat fingerprintManagerCompat2 = fingerprintManagerCompat;
        FingerprintManagerCompat fingerprintManagerCompat3 = new FingerprintManagerCompat(context);
        return fingerprintManagerCompat2;
    }

    public void authenticate(@Nullable CryptoObject cryptoObject, int i, @Nullable CancellationSignal cancellationSignal, @NonNull AuthenticationCallback authenticationCallback, @Nullable Handler handler) {
        CryptoObject cryptoObject2 = cryptoObject;
        int i2 = i;
        CancellationSignal cancellationSignal2 = cancellationSignal;
        AuthenticationCallback authenticationCallback2 = authenticationCallback;
        Handler handler2 = handler;
        IMPL.authenticate(this.mContext, cryptoObject2, i2, cancellationSignal2, authenticationCallback2, handler2);
    }

    public boolean hasEnrolledFingerprints() {
        return IMPL.hasEnrolledFingerprints(this.mContext);
    }

    public boolean isHardwareDetected() {
        return IMPL.isHardwareDetected(this.mContext);
    }
}
