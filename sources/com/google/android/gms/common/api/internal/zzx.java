package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class zzx<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    /* access modifiers changed from: private */
    public final Object zzagI;
    /* access modifiers changed from: private */
    public final WeakReference<GoogleApiClient> zzagK;
    /* access modifiers changed from: private */
    public ResultTransform<? super R, ? extends Result> zzaiN = null;
    /* access modifiers changed from: private */
    public zzx<? extends Result> zzaiO = null;
    private ResultCallbacks<? super R> zzaiP = null;
    private PendingResult<R> zzaiQ = null;
    private Status zzaiR;
    /* access modifiers changed from: private */
    public final zza zzaiS;

    private final class zza extends Handler {
        final /* synthetic */ zzx zzaiU;

        public zza(zzx zzx, Looper looper) {
            Looper looper2 = looper;
            this.zzaiU = zzx;
            super(looper2);
        }

        public void handleMessage(Message message) {
            StringBuilder sb;
            Status status;
            StringBuilder sb2;
            Message message2 = message;
            switch (message2.what) {
                case 0:
                    PendingResult pendingResult = (PendingResult) message2.obj;
                    Object zzf = this.zzaiU.zzagI;
                    synchronized (zzf) {
                        if (pendingResult == null) {
                            try {
                                zzx zzg = this.zzaiU.zzaiO;
                                Status status2 = status;
                                Status status3 = new Status(13, "Transform returned null");
                                zzg.zzy(status2);
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                Object obj = zzf;
                                throw th2;
                            }
                        } else if (pendingResult instanceof zzt) {
                            this.zzaiU.zzaiO.zzy(((zzt) pendingResult).getStatus());
                        } else {
                            this.zzaiU.zzaiO.zza(pendingResult);
                        }
                    }
                    return;
                case 1:
                    RuntimeException runtimeException = (RuntimeException) message2.obj;
                    StringBuilder sb3 = sb;
                    StringBuilder sb4 = new StringBuilder();
                    int e = Log.e("TransformedResultImpl", sb3.append("Runtime exception on the transformation worker thread: ").append(runtimeException.getMessage()).toString());
                    throw runtimeException;
                default:
                    StringBuilder sb5 = sb2;
                    StringBuilder sb6 = new StringBuilder();
                    int e2 = Log.e("TransformedResultImpl", sb5.append("TransformationResultHandler received unknown message type: ").append(message2.what).toString());
                    return;
            }
        }
    }

    public zzx(WeakReference<GoogleApiClient> weakReference) {
        Object obj;
        zza zza2;
        WeakReference<GoogleApiClient> weakReference2 = weakReference;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzagI = obj2;
        this.zzaiR = null;
        Object zzb = com.google.android.gms.common.internal.zzx.zzb(weakReference2, (Object) "GoogleApiClient reference must not be null");
        this.zzagK = weakReference2;
        GoogleApiClient googleApiClient = (GoogleApiClient) this.zzagK.get();
        zza zza3 = zza2;
        zza zza4 = new zza<>(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zzaiS = zza3;
    }

    /* access modifiers changed from: private */
    public void zzc(Result result) {
        StringBuilder sb;
        Result result2 = result;
        if (result2 instanceof Releasable) {
            try {
                ((Releasable) result2).release();
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int w = Log.w("TransformedResultImpl", sb2.append("Unable to release ").append(result2).toString(), runtimeException);
            }
        }
    }

    private void zzpT() {
        if (this.zzaiN != null || this.zzaiP != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zzagK.get();
            if (!(this.zzaiN == null || googleApiClient == null)) {
                googleApiClient.zza(this);
            }
            if (this.zzaiR != null) {
                zzz(this.zzaiR);
            } else if (this.zzaiQ != null) {
                this.zzaiQ.setResultCallback(this);
            }
        }
    }

    private boolean zzpV() {
        return (this.zzaiP == null || ((GoogleApiClient) this.zzagK.get()) == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public void zzy(Status status) {
        Status status2 = status;
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                this.zzaiR = status2;
                zzz(this.zzaiR);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private void zzz(Status status) {
        Status status2 = status;
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                if (this.zzaiN != null) {
                    Status onFailure = this.zzaiN.onFailure(status2);
                    Object zzb = com.google.android.gms.common.internal.zzx.zzb(onFailure, (Object) "onFailure must not return null");
                    this.zzaiO.zzy(onFailure);
                } else if (zzpV()) {
                    this.zzaiP.onFailure(status2);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        boolean z;
        boolean z2;
        ResultCallbacks<? super R> resultCallbacks2 = resultCallbacks;
        th = true;
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                if (this.zzaiP != null) {
                    z = false;
                }
                com.google.android.gms.common.internal.zzx.zza(z, (Object) "Cannot call andFinally() twice.");
                if (this.zzaiN != null) {
                    z2 = false;
                }
                com.google.android.gms.common.internal.zzx.zza(z2, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
                this.zzaiP = resultCallbacks2;
                zzpT();
            } finally {
                Throwable th = th;
                boolean z3 = obj;
                Throwable th2 = th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void onResult(R r) {
        C02371 r9;
        R r2 = r;
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                if (!r2.getStatus().isSuccess()) {
                    zzy(r2.getStatus());
                    zzc((Result) r2);
                } else if (this.zzaiN != null) {
                    ExecutorService zzpN = zzs.zzpN();
                    C02371 r5 = r9;
                    final R r3 = r2;
                    C02371 r6 = new Runnable(this) {
                        final /* synthetic */ zzx zzaiU;

                        {
                            Result result = r7;
                            this.zzaiU = r6;
                        }

                        @WorkerThread
                        public void run() {
                            try {
                                boolean sendMessage = this.zzaiU.zzaiS.sendMessage(this.zzaiU.zzaiS.obtainMessage(0, this.zzaiU.zzaiN.onSuccess(r3)));
                                this.zzaiU.zzc(r3);
                                GoogleApiClient googleApiClient = (GoogleApiClient) this.zzaiU.zzagK.get();
                                if (googleApiClient != null) {
                                    googleApiClient.zzb(this.zzaiU);
                                }
                            } catch (RuntimeException e) {
                                boolean sendMessage2 = this.zzaiU.zzaiS.sendMessage(this.zzaiU.zzaiS.obtainMessage(1, e));
                                this.zzaiU.zzc(r3);
                                GoogleApiClient googleApiClient2 = (GoogleApiClient) this.zzaiU.zzagK.get();
                                if (googleApiClient2 != null) {
                                    googleApiClient2.zzb(this.zzaiU);
                                }
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                this.zzaiU.zzc(r3);
                                GoogleApiClient googleApiClient3 = (GoogleApiClient) this.zzaiU.zzagK.get();
                                if (googleApiClient3 != null) {
                                    googleApiClient3.zzb(this.zzaiU);
                                }
                                throw th2;
                            }
                        }
                    };
                    Future submit = zzpN.submit(r5);
                } else if (zzpV()) {
                    this.zzaiP.onSuccess(r2);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        boolean z;
        boolean z2;
        zzx zzx;
        zzx zzx2;
        ResultTransform<? super R, ? extends S> resultTransform2 = resultTransform;
        th = true;
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                if (this.zzaiN != null) {
                    z = false;
                }
                com.google.android.gms.common.internal.zzx.zza(z, (Object) "Cannot call then() twice.");
                if (this.zzaiP != null) {
                    z2 = false;
                }
                com.google.android.gms.common.internal.zzx.zza(z2, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
                this.zzaiN = resultTransform2;
                zzx zzx3 = zzx;
                zzx zzx4 = new zzx(this.zzagK);
                zzx2 = zzx3;
                this.zzaiO = zzx2;
                zzpT();
            } finally {
                Throwable th = th;
                boolean z3 = obj;
                Throwable th2 = th;
            }
        }
        return zzx2;
    }

    public void zza(PendingResult<?> pendingResult) {
        PendingResult<?> pendingResult2 = pendingResult;
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                this.zzaiQ = pendingResult2;
                zzpT();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzpU() {
        Object obj = this.zzagI;
        synchronized (obj) {
            try {
                this.zzaiP = null;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
