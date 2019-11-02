package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.playlog.internal.zza.C0925zza;
import com.google.android.gms.playlog.internal.zzb.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzf extends zzj<zza> {
    private final String zzTJ;
    private final zzd zzbdT;
    private final zzb zzbdU;
    private boolean zzbdV = true;
    private final Object zzpV;

    public zzf(Context context, Looper looper, zzd zzd, com.google.android.gms.common.internal.zzf zzf) {
        zzb zzb;
        Object obj;
        Context context2 = context;
        zzd zzd2 = zzd;
        super(context2, looper, 24, zzf, zzd2, zzd2);
        this.zzTJ = context2.getPackageName();
        this.zzbdT = (zzd) zzx.zzz(zzd2);
        this.zzbdT.zza(this);
        zzb zzb2 = zzb;
        zzb zzb3 = new zzb();
        this.zzbdU = zzb2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
    }

    private void zzEW() {
        ArrayList arrayList;
        PlayLoggerContext playLoggerContext;
        zzb.zzab(!this.zzbdV);
        if (!this.zzbdU.isEmpty()) {
            PlayLoggerContext playLoggerContext2 = null;
            try {
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = arrayList2;
                Iterator it = this.zzbdU.zzEU().iterator();
                while (it.hasNext()) {
                    zza zza = (zza) it.next();
                    if (zza.zzbdI != null) {
                        ((zza) zzqJ()).zza(this.zzTJ, zza.zzbdG, zzsu.toByteArray(zza.zzbdI));
                    } else {
                        if (zza.zzbdG.equals(playLoggerContext2)) {
                            boolean add = arrayList4.add(zza.zzbdH);
                            playLoggerContext = playLoggerContext2;
                        } else {
                            if (!arrayList4.isEmpty()) {
                                ((zza) zzqJ()).zza(this.zzTJ, playLoggerContext2, (List<LogEvent>) arrayList4);
                                arrayList4.clear();
                            }
                            PlayLoggerContext playLoggerContext3 = zza.zzbdG;
                            boolean add2 = arrayList4.add(zza.zzbdH);
                            playLoggerContext = playLoggerContext3;
                        }
                        playLoggerContext2 = playLoggerContext;
                    }
                }
                if (!arrayList4.isEmpty()) {
                    ((zza) zzqJ()).zza(this.zzTJ, playLoggerContext2, (List<LogEvent>) arrayList4);
                }
                this.zzbdU.clear();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                int e2 = Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
            }
        }
    }

    private void zzc(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        PlayLoggerContext playLoggerContext2 = playLoggerContext;
        LogEvent logEvent2 = logEvent;
        this.zzbdU.zza(playLoggerContext2, logEvent2);
    }

    private void zzd(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        PlayLoggerContext playLoggerContext2 = playLoggerContext;
        LogEvent logEvent2 = logEvent;
        try {
            zzEW();
            ((zza) zzqJ()).zza(this.zzTJ, playLoggerContext2, logEvent2);
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            int e2 = Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            zzc(playLoggerContext2, logEvent2);
        } catch (IllegalStateException e3) {
            IllegalStateException illegalStateException = e3;
            int e4 = Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            zzc(playLoggerContext2, logEvent2);
        }
    }

    public void start() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!isConnecting() && !isConnected()) {
                    this.zzbdT.zzat(true);
                    zzqG();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void stop() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzbdT.zzat(false);
                disconnect();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzau(boolean z) {
        boolean z2 = z;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                boolean z3 = this.zzbdV;
                this.zzbdV = z2;
                if (z3 && !this.zzbdV) {
                    zzEW();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzb(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        PlayLoggerContext playLoggerContext2 = playLoggerContext;
        LogEvent logEvent2 = logEvent;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzbdV) {
                    zzc(playLoggerContext2, logEvent2);
                } else {
                    zzd(playLoggerContext2, logEvent2);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdO */
    public zza zzW(IBinder iBinder) {
        return C0925zza.zzdN(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.playlog.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }
}
