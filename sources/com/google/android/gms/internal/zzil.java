package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import java.math.BigInteger;
import java.util.Locale;

@zzhb
public final class zzil {
    private static String zzLL;
    private static final Object zzqy;

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzqy = obj2;
    }

    /* JADX INFO: finally extract failed */
    public static String zza(Context context, String str, String str2) {
        String str3;
        Context context2 = context;
        String str4 = str;
        String str5 = str2;
        Object obj = zzqy;
        synchronized (obj) {
            try {
                if (zzLL == null && !TextUtils.isEmpty(str4)) {
                    zzb(context2, str4, str5);
                }
                str3 = zzLL;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
        return str3;
    }

    private static void zzb(Context context, String str, String str2) {
        BigInteger bigInteger;
        String str3 = str;
        try {
            ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
            Class cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            BigInteger bigInteger2 = bigInteger;
            BigInteger bigInteger3 = new BigInteger(new byte[1]);
            BigInteger bigInteger4 = bigInteger2;
            String[] split = str3.split(",");
            BigInteger bigInteger5 = bigInteger4;
            for (int i = 0; i < split.length; i++) {
                if (zzr.zzbC().zza(classLoader, cls, split[i])) {
                    bigInteger5 = bigInteger5.setBit(i);
                }
            }
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = bigInteger5;
            zzLL = String.format(Locale.US, "%X", objArr2);
        } catch (Throwable th) {
            Throwable th2 = th;
            zzLL = "err";
        }
    }

    public static String zzhm() {
        String str = zzqy;
        synchronized (str) {
            try {
                th = zzLL;
            } finally {
                Throwable th = th;
                String str2 = str;
                Throwable th2 = th;
            }
        }
        return th;
    }
}
