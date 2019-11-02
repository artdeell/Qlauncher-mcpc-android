package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzx;

public final class zzq<L> {
    private volatile L mListener;
    private final zza zzaiw;

    private final class zza extends Handler {
        final /* synthetic */ zzq zzaix;

        public zza(zzq zzq, Looper looper) {
            Looper looper2 = looper;
            this.zzaix = zzq;
            super(looper2);
        }

        public void handleMessage(Message message) {
            Message message2 = message;
            boolean z = true;
            if (message2.what != 1) {
                z = false;
            }
            zzx.zzac(z);
            this.zzaix.zzb((zzb) message2.obj);
        }
    }

    public interface zzb<L> {
        void zzpr();

        void zzt(L l);
    }

    zzq(Looper looper, L l) {
        zza zza2;
        L l2 = l;
        zza zza3 = zza2;
        zza zza4 = new zza<>(this, looper);
        this.zzaiw = zza3;
        this.mListener = zzx.zzb(l2, (Object) "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> zzb2) {
        zzb<? super L> zzb3 = zzb2;
        Object zzb4 = zzx.zzb(zzb3, (Object) "Notifier must not be null");
        boolean sendMessage = this.zzaiw.sendMessage(this.zzaiw.obtainMessage(1, zzb3));
    }

    /* access modifiers changed from: 0000 */
    public void zzb(zzb<? super L> zzb2) {
        zzb<? super L> zzb3 = zzb2;
        L l = this.mListener;
        if (l == null) {
            zzb3.zzpr();
            return;
        }
        try {
            zzb3.zzt(l);
        } catch (RuntimeException e) {
            RuntimeException runtimeException = e;
            zzb3.zzpr();
            throw runtimeException;
        }
    }
}
