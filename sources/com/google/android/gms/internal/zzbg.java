package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class zzbg {
    private static MessageDigest zzto = null;
    protected Object zzpV;

    public zzbg() {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
    }

    /* access modifiers changed from: protected */
    public MessageDigest zzcL() {
        MessageDigest messageDigest;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (zzto != null) {
                    th = zzto;
                    return messageDigest;
                }
                for (int i = 0; i < 2; i++) {
                    try {
                        zzto = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                        NoSuchAlgorithmException noSuchAlgorithmException = e;
                    }
                }
                MessageDigest messageDigest2 = zzto;
                return messageDigest2;
            } finally {
                messageDigest = th;
                Object obj2 = obj;
                Throwable th = messageDigest;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract byte[] zzu(String str);
}
