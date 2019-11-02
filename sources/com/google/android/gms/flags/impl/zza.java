package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzpl;
import java.util.concurrent.Callable;

public abstract class zza<T> {

    /* renamed from: com.google.android.gms.flags.impl.zza$zza reason: collision with other inner class name */
    public static class C0890zza extends zza<Boolean> {
        public static Boolean zza(SharedPreferences sharedPreferences, String str, Boolean bool) {
            C02531 r8;
            C02531 r3 = r8;
            final SharedPreferences sharedPreferences2 = sharedPreferences;
            final String str2 = str;
            final Boolean bool2 = bool;
            C02531 r4 = new Callable<Boolean>() {
                {
                    String str = r8;
                    Boolean bool = r9;
                }

                /* renamed from: zzvt */
                public Boolean call() {
                    return Boolean.valueOf(sharedPreferences2.getBoolean(str2, bool2.booleanValue()));
                }
            };
            return (Boolean) zzpl.zzb(r3);
        }
    }

    public static class zzb extends zza<Integer> {
        public static Integer zza(SharedPreferences sharedPreferences, String str, Integer num) {
            C02541 r8;
            C02541 r3 = r8;
            final SharedPreferences sharedPreferences2 = sharedPreferences;
            final String str2 = str;
            final Integer num2 = num;
            C02541 r4 = new Callable<Integer>() {
                {
                    String str = r8;
                    Integer num = r9;
                }

                /* renamed from: zzvu */
                public Integer call() {
                    return Integer.valueOf(sharedPreferences2.getInt(str2, num2.intValue()));
                }
            };
            return (Integer) zzpl.zzb(r3);
        }
    }

    public static class zzc extends zza<Long> {
        public static Long zza(SharedPreferences sharedPreferences, String str, Long l) {
            C02551 r8;
            C02551 r3 = r8;
            final SharedPreferences sharedPreferences2 = sharedPreferences;
            final String str2 = str;
            final Long l2 = l;
            C02551 r4 = new Callable<Long>() {
                {
                    String str = r8;
                    Long l = r9;
                }

                /* renamed from: zzvv */
                public Long call() {
                    return Long.valueOf(sharedPreferences2.getLong(str2, l2.longValue()));
                }
            };
            return (Long) zzpl.zzb(r3);
        }
    }

    public static class zzd extends zza<String> {
        public static String zza(SharedPreferences sharedPreferences, String str, String str2) {
            C02561 r8;
            C02561 r3 = r8;
            final SharedPreferences sharedPreferences2 = sharedPreferences;
            final String str3 = str;
            final String str4 = str2;
            C02561 r4 = new Callable<String>() {
                {
                    String str = r8;
                    String str2 = r9;
                }

                /* renamed from: zzkp */
                public String call() {
                    return sharedPreferences2.getString(str3, str4);
                }
            };
            return (String) zzpl.zzb(r3);
        }
    }
}
