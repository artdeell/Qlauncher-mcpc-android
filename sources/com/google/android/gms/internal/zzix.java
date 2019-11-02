package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.zzx;

@zzhb
public class zzix {
    private Handler mHandler = null;
    private HandlerThread zzMG = null;
    /* access modifiers changed from: private */
    public int zzMH = 0;
    /* access modifiers changed from: private */
    public final Object zzpV;

    public zzix() {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
    }

    public Looper zzhC() {
        Looper looper;
        HandlerThread handlerThread;
        Handler handler;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzMH != 0) {
                    Object zzb = zzx.zzb(this.zzMG, (Object) "Invalid state: mHandlerThread should already been initialized.");
                } else if (this.zzMG == null) {
                    zzin.m20v("Starting the looper thread.");
                    HandlerThread handlerThread2 = handlerThread;
                    HandlerThread handlerThread3 = new HandlerThread("LooperProvider");
                    this.zzMG = handlerThread2;
                    this.zzMG.start();
                    Handler handler2 = handler;
                    Handler handler3 = new Handler(this.zzMG.getLooper());
                    this.mHandler = handler2;
                    zzin.m20v("Looper thread started.");
                } else {
                    zzin.m20v("Resuming the looper thread");
                    this.zzpV.notifyAll();
                }
                this.zzMH = 1 + this.zzMH;
                th = this.zzMG.getLooper();
            } finally {
                looper = th;
                Object obj2 = obj;
                Throwable th = looper;
            }
        }
        return looper;
    }

    /* JADX INFO: finally extract failed */
    public void zzhD() {
        C04261 r9;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                zzx.zzb(this.zzMH > 0, (Object) "Invalid state: release() called more times than expected.");
                int i = -1 + this.zzMH;
                this.zzMH = i;
                if (i == 0) {
                    Handler handler = this.mHandler;
                    C04261 r6 = r9;
                    C04261 r7 = new Runnable(this) {
                        final /* synthetic */ zzix zzMI;

                        {
                            this.zzMI = r5;
                        }

                        public void run() {
                            Object zza = this.zzMI.zzpV;
                            synchronized (zza) {
                                try {
                                    zzin.m20v("Suspending the looper thread");
                                    while (this.zzMI.zzMH == 0) {
                                        this.zzMI.zzpV.wait();
                                        zzin.m20v("Looper thread resumed");
                                    }
                                } catch (InterruptedException e) {
                                    InterruptedException interruptedException = e;
                                    zzin.m20v("Looper thread interrupted.");
                                } catch (Throwable th) {
                                    Throwable th2 = th;
                                    Object obj = zza;
                                    throw th2;
                                }
                            }
                        }
                    };
                    boolean post = handler.post(r6);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
