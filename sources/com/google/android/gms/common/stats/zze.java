package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.p000v4.util.SimpleArrayMap;
import android.util.Log;

public class zze {
    private final long zzanN;
    private final int zzanO;
    private final SimpleArrayMap<String, Long> zzanP;

    public zze() {
        SimpleArrayMap<String, Long> simpleArrayMap;
        this.zzanN = 60000;
        this.zzanO = 10;
        SimpleArrayMap<String, Long> simpleArrayMap2 = simpleArrayMap;
        SimpleArrayMap<String, Long> simpleArrayMap3 = new SimpleArrayMap<>(10);
        this.zzanP = simpleArrayMap2;
    }

    public zze(int i, long j) {
        SimpleArrayMap<String, Long> simpleArrayMap;
        int i2 = i;
        this.zzanN = j;
        this.zzanO = i2;
        SimpleArrayMap<String, Long> simpleArrayMap2 = simpleArrayMap;
        SimpleArrayMap<String, Long> simpleArrayMap3 = new SimpleArrayMap<>();
        this.zzanP = simpleArrayMap2;
    }

    private void zzb(long j, long j2) {
        long j3 = j;
        long j4 = j2;
        for (int size = -1 + this.zzanP.size(); size >= 0; size--) {
            if (j4 - ((Long) this.zzanP.valueAt(size)).longValue() > j3) {
                Object removeAt = this.zzanP.removeAt(size);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public Long zzcS(String str) {
        Long l;
        StringBuilder sb;
        String str2 = str;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.zzanN;
        synchronized (this) {
            while (this.zzanP.size() >= this.zzanO) {
                try {
                    zzb(j, elapsedRealtime);
                    j /= 2;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int w = Log.w("ConnectionTracker", sb2.append("The max capacity ").append(this.zzanO).append(" is not enough. Current durationThreshold is: ").append(j).toString());
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
            l = (Long) this.zzanP.put(str2, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public boolean zzcT(String str) {
        String str2 = str;
        synchronized (this) {
            try {
                th = this.zzanP.remove(str2) != null;
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return th;
    }
}
