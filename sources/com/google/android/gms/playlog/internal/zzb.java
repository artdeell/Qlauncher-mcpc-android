package com.google.android.gms.playlog.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzsz.zzd;
import java.util.ArrayList;

public class zzb {
    private final ArrayList<zza> zzbdE;
    private int zzbdF;

    public static class zza {
        public final PlayLoggerContext zzbdG;
        public final LogEvent zzbdH;
        public final zzd zzbdI;

        private zza(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
            LogEvent logEvent2 = logEvent;
            this.zzbdG = (PlayLoggerContext) zzx.zzz(playLoggerContext);
            this.zzbdH = (LogEvent) zzx.zzz(logEvent2);
            this.zzbdI = null;
        }

        /* synthetic */ zza(PlayLoggerContext playLoggerContext, LogEvent logEvent, C04541 r10) {
            C04541 r3 = r10;
            this(playLoggerContext, logEvent);
        }
    }

    public zzb() {
        this(100);
    }

    public zzb(int i) {
        ArrayList<zza> arrayList;
        int i2 = i;
        ArrayList<zza> arrayList2 = arrayList;
        ArrayList<zza> arrayList3 = new ArrayList<>();
        this.zzbdE = arrayList2;
        this.zzbdF = i2;
    }

    private void zzEV() {
        while (getSize() > getCapacity()) {
            Object remove = this.zzbdE.remove(0);
        }
    }

    public void clear() {
        this.zzbdE.clear();
    }

    public int getCapacity() {
        return this.zzbdF;
    }

    public int getSize() {
        return this.zzbdE.size();
    }

    public boolean isEmpty() {
        return this.zzbdE.isEmpty();
    }

    public ArrayList<zza> zzEU() {
        return this.zzbdE;
    }

    public void zza(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        zza zza2;
        PlayLoggerContext playLoggerContext2 = playLoggerContext;
        LogEvent logEvent2 = logEvent;
        ArrayList<zza> arrayList = this.zzbdE;
        zza zza3 = zza2;
        zza zza4 = new zza(playLoggerContext2, logEvent2, null);
        boolean add = arrayList.add(zza3);
        zzEV();
    }
}
