package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzb<R extends Result> extends PendingResult<R> {
    private boolean zzL;
    private final Object zzagI;
    protected final zza<R> zzagJ;
    private final WeakReference<GoogleApiClient> zzagK;
    private final ArrayList<com.google.android.gms.common.api.PendingResult.zza> zzagL;
    private ResultCallback<? super R> zzagM;
    private volatile boolean zzagN;
    private boolean zzagO;
    private boolean zzagP;
    private zzq zzagQ;
    private Integer zzagR;
    private volatile zzx<R> zzagS;
    private volatile R zzagy;
    private final CountDownLatch zzpJ;

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            StringBuilder sb;
            Exception exc;
            Message message2 = message;
            switch (message2.what) {
                case 1:
                    Pair pair = (Pair) message2.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((zzb) message2.obj).zzx(Status.zzagF);
                    return;
                default:
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    String sb4 = sb2.append("Don't know how to handle message: ").append(message2.what).toString();
                    Exception exc2 = exc;
                    Exception exc3 = new Exception();
                    int wtf = Log.wtf("BasePendingResult", sb4, exc2);
                    return;
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            Pair pair;
            Pair pair2 = pair;
            Pair pair3 = new Pair(resultCallback, r);
            boolean sendMessage = sendMessage(obtainMessage(1, pair2));
        }

        public void zza(zzb<R> zzb, long j) {
            boolean sendMessageDelayed = sendMessageDelayed(obtainMessage(2, zzb), j);
        }

        /* access modifiers changed from: protected */
        public void zzb(ResultCallback<? super R> resultCallback, R r) {
            R r2 = r;
            try {
                resultCallback.onResult(r2);
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                zzb.zzc((Result) r2);
                throw runtimeException;
            }
        }

        public void zzph() {
            removeMessages(2);
        }
    }

    @Deprecated
    protected zzb(Looper looper) {
        Object obj;
        CountDownLatch countDownLatch;
        ArrayList<com.google.android.gms.common.api.PendingResult.zza> arrayList;
        zza<R> zza2;
        WeakReference<GoogleApiClient> weakReference;
        Looper looper2 = looper;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzagI = obj2;
        CountDownLatch countDownLatch2 = countDownLatch;
        CountDownLatch countDownLatch3 = new CountDownLatch(1);
        this.zzpJ = countDownLatch2;
        ArrayList<com.google.android.gms.common.api.PendingResult.zza> arrayList2 = arrayList;
        ArrayList<com.google.android.gms.common.api.PendingResult.zza> arrayList3 = new ArrayList<>();
        this.zzagL = arrayList2;
        zza<R> zza3 = zza2;
        zza<R> zza4 = new zza<>(looper2);
        this.zzagJ = zza3;
        WeakReference<GoogleApiClient> weakReference2 = weakReference;
        WeakReference<GoogleApiClient> weakReference3 = new WeakReference<>(null);
        this.zzagK = weakReference2;
    }

    protected zzb(GoogleApiClient googleApiClient) {
        Object obj;
        CountDownLatch countDownLatch;
        ArrayList<com.google.android.gms.common.api.PendingResult.zza> arrayList;
        zza<R> zza2;
        WeakReference<GoogleApiClient> weakReference;
        GoogleApiClient googleApiClient2 = googleApiClient;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzagI = obj2;
        CountDownLatch countDownLatch2 = countDownLatch;
        CountDownLatch countDownLatch3 = new CountDownLatch(1);
        this.zzpJ = countDownLatch2;
        ArrayList<com.google.android.gms.common.api.PendingResult.zza> arrayList2 = arrayList;
        ArrayList<com.google.android.gms.common.api.PendingResult.zza> arrayList3 = new ArrayList<>();
        this.zzagL = arrayList2;
        zza<R> zza3 = zza2;
        zza<R> zza4 = new zza<>(googleApiClient2 != null ? googleApiClient2.getLooper() : Looper.getMainLooper());
        this.zzagJ = zza3;
        WeakReference<GoogleApiClient> weakReference2 = weakReference;
        WeakReference<GoogleApiClient> weakReference3 = new WeakReference<>(googleApiClient2);
        this.zzagK = weakReference2;
    }

    /* JADX INFO: finally extract failed */
    private R get() {
        R r;
        boolean z = true;
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                if (this.zzagN) {
                    z = false;
                }
                zzx.zza(z, (Object) "Result has already been consumed.");
                zzx.zza(isReady(), (Object) "Result is not ready.");
                r = this.zzagy;
                this.zzagy = null;
                this.zzagM = null;
                this.zzagN = true;
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
        zzpf();
        return r;
    }

    private void zzb(R r) {
        this.zzagy = r;
        this.zzagQ = null;
        this.zzpJ.countDown();
        Status status = this.zzagy.getStatus();
        if (this.zzagM != null) {
            this.zzagJ.zzph();
            if (!this.zzL) {
                this.zzagJ.zza(this.zzagM, get());
            }
        }
        Iterator it = this.zzagL.iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.PendingResult.zza) it.next()).zzu(status);
        }
        this.zzagL.clear();
    }

    public static void zzc(Result result) {
        StringBuilder sb;
        Result result2 = result;
        if (result2 instanceof Releasable) {
            try {
                ((Releasable) result2).release();
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int w = Log.w("BasePendingResult", sb2.append("Unable to release ").append(result2).toString(), runtimeException);
            }
        }
    }

    public final R await() {
        boolean z = true;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread");
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed");
        if (this.zzagS != null) {
            z = false;
        }
        zzx.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            this.zzpJ.await();
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
            zzx(Status.zzagD);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public final R await(long j, TimeUnit timeUnit) {
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        boolean z = true;
        zzx.zza(j2 <= 0 || Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread when time is greater than zero.");
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed.");
        if (this.zzagS != null) {
            z = false;
        }
        zzx.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.zzpJ.await(j2, timeUnit2)) {
                zzx(Status.zzagF);
            }
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
            zzx(Status.zzagD);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public void cancel() {
        zzq zzq = this.zzagI;
        synchronized (zzq) {
            try {
                if (!this.zzL && !this.zzagN) {
                    th = this.zzagQ;
                    if (th != null) {
                        try {
                            this.zzagQ.cancel();
                        } catch (RemoteException e) {
                            RemoteException remoteException = e;
                        }
                    }
                    zzc((Result) this.zzagy);
                    this.zzagM = null;
                    this.zzL = true;
                    zzb(zzc(Status.zzagG));
                }
            } finally {
                Throwable th = th;
                zzq zzq2 = zzq;
                Throwable th2 = th;
            }
        }
    }

    public boolean isCanceled() {
        boolean z = this.zzagI;
        synchronized (z) {
            try {
                th = this.zzL;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public final boolean isReady() {
        return this.zzpJ.getCount() == 0;
    }

    /* JADX INFO: finally extract failed */
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        ResultCallback<? super R> resultCallback2 = resultCallback;
        boolean z = true;
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed.");
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                if (this.zzagS != null) {
                    z = false;
                }
                zzx.zza(z, (Object) "Cannot set callbacks if then() has been called.");
                if (!isCanceled()) {
                    if (!this.zzagP || (((GoogleApiClient) this.zzagK.get()) != null && (resultCallback2 instanceof zzx))) {
                        if (isReady()) {
                            this.zzagJ.zza(resultCallback2, get());
                        } else {
                            this.zzagM = resultCallback2;
                        }
                        return;
                    }
                    cancel();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        ResultCallback<? super R> resultCallback2 = resultCallback;
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        boolean z = true;
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed.");
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                if (this.zzagS != null) {
                    z = false;
                }
                zzx.zza(z, (Object) "Cannot set callbacks if then() has been called.");
                if (!isCanceled()) {
                    if (!this.zzagP || (((GoogleApiClient) this.zzagK.get()) != null && (resultCallback2 instanceof zzx))) {
                        if (isReady()) {
                            this.zzagJ.zza(resultCallback2, get());
                        } else {
                            this.zzagM = resultCallback2;
                            this.zzagJ.zza(this, timeUnit2.toMillis(j2));
                        }
                        return;
                    }
                    cancel();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        boolean z;
        boolean z2;
        zzx<R> zzx;
        TransformedResult then;
        ResultTransform<? super R, ? extends S> resultTransform2 = resultTransform;
        th = true;
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed.");
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                if (this.zzagS != null) {
                    z = false;
                }
                zzx.zza(z, (Object) "Cannot call then() twice.");
                if (this.zzagM != null) {
                    z2 = false;
                }
                zzx.zza(z2, (Object) "Cannot call then() if callbacks are set.");
                zzx<R> zzx2 = zzx;
                zzx<R> zzx3 = new zzx<>(this.zzagK);
                this.zzagS = zzx2;
                then = this.zzagS.then(resultTransform2);
                if (isReady()) {
                    this.zzagJ.zza((ResultCallback<? super R>) this.zzagS, get());
                } else {
                    this.zzagM = this.zzagS;
                }
            } finally {
                Throwable th = th;
                boolean z3 = obj;
                Throwable th2 = th;
            }
        }
        return then;
    }

    /* JADX INFO: finally extract failed */
    public final void zza(com.google.android.gms.common.api.PendingResult.zza zza2) {
        com.google.android.gms.common.api.PendingResult.zza zza3 = zza2;
        boolean z = true;
        zzx.zza(!this.zzagN, (Object) "Result has already been consumed.");
        if (zza3 == null) {
            z = false;
        }
        zzx.zzb(z, (Object) "Callback cannot be null.");
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                if (isReady()) {
                    zza3.zzu(this.zzagy.getStatus());
                } else {
                    boolean add = this.zzagL.add(zza3);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public final void zza(R r) {
        boolean z;
        boolean z2;
        R r2 = r;
        th = true;
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                if (this.zzagO || this.zzL) {
                    zzc((Result) r2);
                    return;
                }
                if (isReady()) {
                    z = false;
                }
                zzx.zza(z, (Object) "Results have already been set");
                if (this.zzagN) {
                    z2 = false;
                }
                zzx.zza(z2, (Object) "Result has already been consumed");
                zzb(r2);
            } finally {
                Throwable th = th;
                boolean z3 = obj;
                Throwable th2 = th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzq zzq) {
        zzq zzq2 = zzq;
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                this.zzagQ = zzq2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract R zzc(Status status);

    public Integer zzpa() {
        return this.zzagR;
    }

    /* access modifiers changed from: protected */
    public void zzpf() {
    }

    public void zzpg() {
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                if (((GoogleApiClient) this.zzagK.get()) == null) {
                    cancel();
                    return;
                }
                if (this.zzagM == null || (this.zzagM instanceof zzx)) {
                    this.zzagP = true;
                } else {
                    cancel();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final void zzx(Status status) {
        Status status2 = status;
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                if (!isReady()) {
                    zza((R) zzc(status2));
                    this.zzagO = true;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
