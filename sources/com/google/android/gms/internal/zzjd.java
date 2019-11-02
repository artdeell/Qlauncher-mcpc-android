package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzhb
public class zzjd<T> implements zzjg<T> {
    private boolean zzCy = false;
    private T zzNc = null;
    private boolean zzNd = false;
    private final zzjh zzNe;
    private final Object zzpV;

    public zzjd() {
        Object obj;
        zzjh zzjh;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        zzjh zzjh2 = zzjh;
        zzjh zzjh3 = new zzjh();
        this.zzNe = zzjh2;
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzNd) {
                    return false;
                }
                this.zzCy = true;
                this.zzNd = true;
                this.zzpV.notifyAll();
                this.zzNe.zzhK();
                return true;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public T get() {
        T t;
        CancellationException cancellationException;
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzNd;
                if (!th) {
                    try {
                        this.zzpV.wait();
                    } catch (InterruptedException e) {
                        InterruptedException interruptedException = e;
                    }
                }
                if (this.zzCy) {
                    CancellationException cancellationException2 = cancellationException;
                    CancellationException cancellationException3 = new CancellationException("CallbackFuture was cancelled.");
                    throw cancellationException2;
                }
                t = this.zzNc;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) throws TimeoutException {
        T t;
        CancellationException cancellationException;
        TimeoutException timeoutException;
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzNd;
                if (!th) {
                    try {
                        long millis = timeUnit2.toMillis(j2);
                        if (millis != 0) {
                            this.zzpV.wait(millis);
                        }
                    } catch (InterruptedException e) {
                        InterruptedException interruptedException = e;
                    }
                }
                if (!this.zzNd) {
                    TimeoutException timeoutException2 = timeoutException;
                    TimeoutException timeoutException3 = new TimeoutException("CallbackFuture timed out.");
                    throw timeoutException2;
                } else if (this.zzCy) {
                    CancellationException cancellationException2 = cancellationException;
                    CancellationException cancellationException3 = new CancellationException("CallbackFuture was cancelled.");
                    throw cancellationException2;
                } else {
                    t = this.zzNc;
                }
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzCy;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public boolean isDone() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzNd;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void zzb(Runnable runnable) {
        Runnable runnable2 = runnable;
        this.zzNe.zzb(runnable2);
    }

    public void zzc(Runnable runnable) {
        Runnable runnable2 = runnable;
        this.zzNe.zzc(runnable2);
    }

    /* JADX INFO: finally extract failed */
    public void zzg(T t) {
        IllegalStateException illegalStateException;
        T t2 = t;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!this.zzCy) {
                    if (this.zzNd) {
                        IllegalStateException illegalStateException2 = illegalStateException;
                        IllegalStateException illegalStateException3 = new IllegalStateException("Provided CallbackFuture with multiple values.");
                        throw illegalStateException2;
                    }
                    this.zzNd = true;
                    this.zzNc = t2;
                    this.zzpV.notifyAll();
                    this.zzNe.zzhK();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
