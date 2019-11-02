package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.C0879zza;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzlv implements com.google.android.gms.clearcut.zzc {
    private static final Object zzafn;
    /* access modifiers changed from: private */
    public static final zze zzafo;
    private static final long zzafp = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
    /* access modifiers changed from: private */
    public GoogleApiClient zzaaj;
    private final zza zzafq;
    /* access modifiers changed from: private */
    public final Object zzafr;
    /* access modifiers changed from: private */
    public long zzafs;
    private final long zzaft;
    private ScheduledFuture<?> zzafu;
    private final Runnable zzafv;
    /* access modifiers changed from: private */
    public final zzmq zzqW;

    public interface zza {
    }

    public static class zzb implements zza {
        public zzb() {
        }
    }

    static abstract class zzc<R extends Result> extends C0879zza<R, zzlw> {
        public zzc(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.clearcut.zzb.zzUI, googleApiClient);
        }
    }

    final class zzd extends zzc<Status> {
        final /* synthetic */ zzlv zzafw;
        private final LogEventParcelable zzafx;

        zzd(zzlv zzlv, LogEventParcelable logEventParcelable, GoogleApiClient googleApiClient) {
            LogEventParcelable logEventParcelable2 = logEventParcelable;
            GoogleApiClient googleApiClient2 = googleApiClient;
            this.zzafw = zzlv;
            super(googleApiClient2);
            this.zzafx = logEventParcelable2;
        }

        public boolean equals(Object obj) {
            Object obj2 = obj;
            if (!(obj2 instanceof zzd)) {
                return false;
            }
            return this.zzafx.equals(((zzd) obj2).zzafx);
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append("MethodImpl(").append(this.zzafx).append(")").toString();
        }

        /* access modifiers changed from: protected */
        public void zza(zzlw zzlw) throws RemoteException {
            C04411 r7;
            StringBuilder sb;
            zzlw zzlw2 = zzlw;
            C04411 r4 = r7;
            C04411 r5 = new com.google.android.gms.internal.zzlx.zza(this) {
                final /* synthetic */ zzd zzafy;

                {
                    this.zzafy = r5;
                }

                public void zzv(Status status) {
                    Status status2 = status;
                    this.zzafy.zza(status2);
                }
            };
            C04411 r2 = r4;
            try {
                zzlv.zza(this.zzafx);
                zzlw2.zza(r2, this.zzafx);
            } catch (Throwable th) {
                Throwable th2 = th;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e = Log.e("ClearcutLoggerApiImpl", sb2.append("MessageNanoProducer ").append(this.zzafx.zzafl.toString()).append(" threw: ").append(th2.toString()).toString());
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    private static final class zze {
        private int mSize;

        private zze() {
            this.mSize = 0;
        }

        /* synthetic */ zze(C04391 r4) {
            C04391 r1 = r4;
            this();
        }

        public boolean zza(long j, TimeUnit timeUnit) throws InterruptedException {
            long j2 = j;
            TimeUnit timeUnit2 = timeUnit;
            long currentTimeMillis = System.currentTimeMillis();
            long convert = TimeUnit.MILLISECONDS.convert(j2, timeUnit2);
            synchronized (this) {
                while (this.mSize != 0) {
                    try {
                        if (th <= 0) {
                            return false;
                        }
                        wait(th);
                        convert = th - (System.currentTimeMillis() - currentTimeMillis);
                    } finally {
                        Throwable th = th;
                        Throwable th2 = th;
                    }
                }
                return true;
            }
        }

        public void zzoH() {
            synchronized (this) {
                try {
                    this.mSize = 1 + this.mSize;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }

        public void zzoI() {
            RuntimeException runtimeException;
            synchronized (this) {
                try {
                    if (this.mSize == 0) {
                        RuntimeException runtimeException2 = runtimeException;
                        RuntimeException runtimeException3 = new RuntimeException("too many decrements");
                        throw runtimeException2;
                    }
                    this.mSize = -1 + this.mSize;
                    if (this.mSize == 0) {
                        notifyAll();
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }
    }

    static {
        Object obj;
        zze zze2;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzafn = obj2;
        zze zze3 = zze2;
        zze zze4 = new zze(null);
        zzafo = zze3;
    }

    public zzlv() {
        zzmt zzmt;
        zzb zzb2;
        zzmt zzmt2 = zzmt;
        zzmt zzmt3 = new zzmt();
        long j = zzafp;
        zzb zzb3 = zzb2;
        zzb zzb4 = new zzb();
        this(zzmt2, j, zzb3);
    }

    public zzlv(zzmq zzmq, long j, zza zza2) {
        Object obj;
        C04391 r9;
        zzmq zzmq2 = zzmq;
        long j2 = j;
        zza zza3 = zza2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzafr = obj2;
        this.zzafs = 0;
        this.zzafu = null;
        this.zzaaj = null;
        C04391 r6 = r9;
        C04391 r7 = new Runnable(this) {
            final /* synthetic */ zzlv zzafw;

            {
                this.zzafw = r5;
            }

            public void run() {
                Object zza = this.zzafw.zzafr;
                synchronized (zza) {
                    try {
                        if (this.zzafw.zzafs <= this.zzafw.zzqW.elapsedRealtime() && this.zzafw.zzaaj != null) {
                            int i = Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                            this.zzafw.zzaaj.disconnect();
                            GoogleApiClient zza2 = zzlv.zza(this.zzafw, (GoogleApiClient) null);
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj = zza;
                        throw th2;
                    }
                }
            }
        };
        this.zzafv = r6;
        this.zzqW = zzmq2;
        this.zzaft = j2;
        this.zzafq = zza3;
    }

    static /* synthetic */ GoogleApiClient zza(zzlv zzlv, GoogleApiClient googleApiClient) {
        GoogleApiClient googleApiClient2 = googleApiClient;
        zzlv.zzaaj = googleApiClient2;
        return googleApiClient2;
    }

    /* access modifiers changed from: private */
    public static void zza(LogEventParcelable logEventParcelable) {
        LogEventParcelable logEventParcelable2 = logEventParcelable;
        if (logEventParcelable2.zzafl != null && logEventParcelable2.zzafk.zzbuY.length == 0) {
            logEventParcelable2.zzafk.zzbuY = logEventParcelable2.zzafl.zzoF();
        }
        if (logEventParcelable2.zzafm != null && logEventParcelable2.zzafk.zzbvf.length == 0) {
            logEventParcelable2.zzafk.zzbvf = logEventParcelable2.zzafm.zzoF();
        }
        logEventParcelable2.zzafi = zzsu.toByteArray(logEventParcelable2.zzafk);
    }

    private zzd zzb(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        zzd zzd2;
        C04402 r9;
        GoogleApiClient googleApiClient2 = googleApiClient;
        LogEventParcelable logEventParcelable2 = logEventParcelable;
        zzafo.zzoH();
        zzd zzd3 = zzd2;
        zzd zzd4 = new zzd(this, logEventParcelable2, googleApiClient2);
        zzd zzd5 = zzd3;
        zzd zzd6 = zzd5;
        C04402 r5 = r9;
        C04402 r6 = new com.google.android.gms.common.api.PendingResult.zza(this) {
            final /* synthetic */ zzlv zzafw;

            {
                this.zzafw = r5;
            }

            public void zzu(Status status) {
                Status status2 = status;
                zzlv.zzafo.zzoI();
            }
        };
        zzd6.zza((com.google.android.gms.common.api.PendingResult.zza) r5);
        return zzd5;
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, LogEventParcelable logEventParcelable) {
        GoogleApiClient googleApiClient2 = googleApiClient;
        LogEventParcelable logEventParcelable2 = logEventParcelable;
        zza(logEventParcelable2);
        return googleApiClient2.zza(zzb(googleApiClient2, logEventParcelable2));
    }

    public boolean zza(GoogleApiClient googleApiClient, long j, TimeUnit timeUnit) {
        GoogleApiClient googleApiClient2 = googleApiClient;
        try {
            return zzafo.zza(j, timeUnit);
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
            int e2 = Log.e("ClearcutLoggerApiImpl", "flush interrupted");
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
