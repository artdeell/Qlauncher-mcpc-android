package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzpl;
import java.util.concurrent.Callable;

public class zzb {
    private static SharedPreferences zzaBZ = null;

    public static SharedPreferences zzw(Context context) {
        SharedPreferences sharedPreferences;
        C02571 r6;
        Context context2 = context;
        synchronized (SharedPreferences.class) {
            try {
                if (zzaBZ == null) {
                    C02571 r3 = r6;
                    final Context context3 = context2;
                    C02571 r4 = new Callable<SharedPreferences>() {
                        /* renamed from: zzvw */
                        public SharedPreferences call() {
                            return context3.getSharedPreferences("google_sdk_flags", 1);
                        }
                    };
                    zzaBZ = (SharedPreferences) zzpl.zzb(r3);
                }
                th = zzaBZ;
            } finally {
                sharedPreferences = th;
                Class<SharedPreferences> cls = SharedPreferences.class;
                Throwable th = sharedPreferences;
            }
        }
        return sharedPreferences;
    }
}
