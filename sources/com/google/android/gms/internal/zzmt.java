package com.google.android.gms.internal;

import android.os.SystemClock;

public final class zzmt implements zzmq {
    private static zzmt zzaoa;

    public zzmt() {
    }

    public static zzmq zzsc() {
        zzmt zzmt;
        zzmt zzmt2;
        synchronized (zzmt.class) {
            try {
                if (zzaoa == null) {
                    zzmt zzmt3 = zzmt2;
                    zzmt zzmt4 = new zzmt();
                    zzaoa = zzmt3;
                }
                th = zzaoa;
            } finally {
                zzmt = th;
                Class<zzmt> cls = zzmt.class;
                Throwable th = zzmt;
            }
        }
        return zzmt;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}
