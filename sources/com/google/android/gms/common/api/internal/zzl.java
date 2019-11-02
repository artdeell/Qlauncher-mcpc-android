package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza.C0879zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzl implements zzp {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final Lock zzXG;
    final zzj zzagW;
    private final zzc zzags;
    final com.google.android.gms.common.api.Api.zza<? extends zzrn, zzro> zzagt;
    final Map<Api<?>, Integer> zzahA;
    final Map<Api.zzc<?>, com.google.android.gms.common.api.Api.zzb> zzahT;
    final zzf zzahz;
    private final Condition zzaim;
    private final zzb zzain;
    final Map<Api.zzc<?>, ConnectionResult> zzaio;
    /* access modifiers changed from: private */
    public volatile zzk zzaip;
    private ConnectionResult zzaiq = null;
    int zzair;
    final com.google.android.gms.common.api.internal.zzp.zza zzais;

    static abstract class zza {
        private final zzk zzait;

        protected zza(zzk zzk) {
            this.zzait = zzk;
        }

        public final void zzd(zzl zzl) {
            zzl zzl2 = zzl;
            zzl2.zzXG.lock();
            try {
                if (zzl2.zzaip != this.zzait) {
                    zzl2.zzXG.unlock();
                    return;
                }
                zzpt();
                zzl2.zzXG.unlock();
            } catch (Throwable th) {
                Throwable th2 = th;
                zzl2.zzXG.unlock();
                throw th2;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzpt();
    }

    final class zzb extends Handler {
        final /* synthetic */ zzl zzaiu;

        zzb(zzl zzl, Looper looper) {
            Looper looper2 = looper;
            this.zzaiu = zzl;
            super(looper2);
        }

        public void handleMessage(Message message) {
            StringBuilder sb;
            Message message2 = message;
            switch (message2.what) {
                case 1:
                    ((zza) message2.obj).zzd(this.zzaiu);
                    return;
                case 2:
                    throw ((RuntimeException) message2.obj);
                default:
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int w = Log.w("GACStateManager", sb2.append("Unknown message id: ").append(message2.what).toString());
                    return;
            }
        }
    }

    public zzl(Context context, zzj zzj, Lock lock, Looper looper, zzc zzc, Map<Api.zzc<?>, com.google.android.gms.common.api.Api.zzb> map, zzf zzf, Map<Api<?>, Integer> map2, com.google.android.gms.common.api.Api.zza<? extends zzrn, zzro> zza2, ArrayList<zzc> arrayList, com.google.android.gms.common.api.internal.zzp.zza zza3) {
        HashMap hashMap;
        zzb zzb2;
        zzi zzi;
        Context context2 = context;
        zzj zzj2 = zzj;
        Lock lock2 = lock;
        Looper looper2 = looper;
        zzc zzc2 = zzc;
        Map<Api.zzc<?>, com.google.android.gms.common.api.Api.zzb> map3 = map;
        zzf zzf2 = zzf;
        Map<Api<?>, Integer> map4 = map2;
        com.google.android.gms.common.api.Api.zza<? extends zzrn, zzro> zza4 = zza2;
        ArrayList<zzc> arrayList2 = arrayList;
        com.google.android.gms.common.api.internal.zzp.zza zza5 = zza3;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.zzaio = hashMap2;
        this.mContext = context2;
        this.zzXG = lock2;
        this.zzags = zzc2;
        this.zzahT = map3;
        this.zzahz = zzf2;
        this.zzahA = map4;
        this.zzagt = zza4;
        this.zzagW = zzj2;
        this.zzais = zza5;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((zzc) it.next()).zza(this);
        }
        zzb zzb3 = zzb2;
        zzb zzb4 = new zzb(this, looper2);
        this.zzain = zzb3;
        this.zzaim = lock2.newCondition();
        zzi zzi2 = zzi;
        zzi zzi3 = new zzi(this);
        this.zzaip = zzi2;
    }

    public ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        connect();
        while (isConnecting()) {
            try {
                this.zzaim.await();
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
                Thread.currentThread().interrupt();
                ConnectionResult connectionResult3 = connectionResult2;
                ConnectionResult connectionResult4 = new ConnectionResult(15, null);
                return connectionResult3;
            }
        }
        if (isConnected()) {
            return ConnectionResult.zzafB;
        }
        if (this.zzaiq != null) {
            return this.zzaiq;
        }
        ConnectionResult connectionResult5 = connectionResult;
        ConnectionResult connectionResult6 = new ConnectionResult(13, null);
        return connectionResult5;
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        ConnectionResult connectionResult3;
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        connect();
        long nanos = timeUnit2.toNanos(j2);
        while (true) {
            long j3 = nanos;
            if (isConnecting()) {
                if (j3 <= 0) {
                    try {
                        boolean disconnect = disconnect();
                        ConnectionResult connectionResult4 = connectionResult3;
                        ConnectionResult connectionResult5 = new ConnectionResult(14, null);
                        return connectionResult4;
                    } catch (InterruptedException e) {
                        InterruptedException interruptedException = e;
                        Thread.currentThread().interrupt();
                        ConnectionResult connectionResult6 = connectionResult2;
                        ConnectionResult connectionResult7 = new ConnectionResult(15, null);
                        return connectionResult6;
                    }
                } else {
                    nanos = this.zzaim.awaitNanos(j3);
                }
            } else if (isConnected()) {
                return ConnectionResult.zzafB;
            } else {
                if (this.zzaiq != null) {
                    return this.zzaiq;
                }
                ConnectionResult connectionResult8 = connectionResult;
                ConnectionResult connectionResult9 = new ConnectionResult(13, null);
                return connectionResult8;
            }
        }
    }

    public void connect() {
        this.zzaip.connect();
    }

    public boolean disconnect() {
        boolean disconnect = this.zzaip.disconnect();
        if (disconnect) {
            this.zzaio.clear();
        }
        return disconnect;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        StringBuilder sb;
        String str2 = str;
        FileDescriptor fileDescriptor2 = fileDescriptor;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        String sb4 = sb2.append(str2).append("  ").toString();
        for (Api api : this.zzahA.keySet()) {
            printWriter2.append(str2).append(api.getName()).println(":");
            ((com.google.android.gms.common.api.Api.zzb) this.zzahT.get(api.zzoR())).dump(sb4, fileDescriptor2, printWriter2, strArr2);
        }
    }

    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        Api.zzc zzoR = api.zzoR();
        if (this.zzahT.containsKey(zzoR)) {
            if (((com.google.android.gms.common.api.Api.zzb) this.zzahT.get(zzoR)).isConnected()) {
                return ConnectionResult.zzafB;
            }
            if (this.zzaio.containsKey(zzoR)) {
                return (ConnectionResult) this.zzaio.get(zzoR);
            }
        }
        return null;
    }

    public boolean isConnected() {
        return this.zzaip instanceof zzg;
    }

    public boolean isConnecting() {
        return this.zzaip instanceof zzh;
    }

    public void onConnected(@Nullable Bundle bundle) {
        Bundle bundle2 = bundle;
        this.zzXG.lock();
        try {
            this.zzaip.onConnected(bundle2);
            this.zzXG.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public void onConnectionSuspended(int i) {
        int i2 = i;
        this.zzXG.lock();
        try {
            this.zzaip.onConnectionSuspended(i2);
            this.zzXG.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends C0879zza<R, A>> T zza(@NonNull T t) {
        return this.zzaip.zza(t);
    }

    public void zza(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, int i) {
        ConnectionResult connectionResult2 = connectionResult;
        Api<?> api2 = api;
        int i2 = i;
        this.zzXG.lock();
        try {
            this.zzaip.zza(connectionResult2, api2, i2);
            this.zzXG.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(zza zza2) {
        boolean sendMessage = this.zzain.sendMessage(this.zzain.obtainMessage(1, zza2));
    }

    /* access modifiers changed from: 0000 */
    public void zza(RuntimeException runtimeException) {
        boolean sendMessage = this.zzain.sendMessage(this.zzain.obtainMessage(2, runtimeException));
    }

    public boolean zza(zzu zzu) {
        zzu zzu2 = zzu;
        return false;
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends C0879zza<? extends Result, A>> T zzb(@NonNull T t) {
        return this.zzaip.zzb(t);
    }

    /* access modifiers changed from: 0000 */
    public void zzh(ConnectionResult connectionResult) {
        zzi zzi;
        ConnectionResult connectionResult2 = connectionResult;
        this.zzXG.lock();
        try {
            this.zzaiq = connectionResult2;
            zzi zzi2 = zzi;
            zzi zzi3 = new zzi(this);
            this.zzaip = zzi2;
            this.zzaip.begin();
            this.zzaim.signalAll();
            this.zzXG.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public void zzoW() {
    }

    /* access modifiers changed from: 0000 */
    public void zzpK() {
        zzh zzh;
        this.zzXG.lock();
        try {
            zzh zzh2 = zzh;
            zzh zzh3 = new zzh(this, this.zzahz, this.zzahA, this.zzags, this.zzagt, this.zzXG, this.mContext);
            this.zzaip = zzh2;
            this.zzaip.begin();
            this.zzaim.signalAll();
            this.zzXG.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzpL() {
        zzg zzg;
        this.zzXG.lock();
        try {
            boolean zzpF = this.zzagW.zzpF();
            zzg zzg2 = zzg;
            zzg zzg3 = new zzg(this);
            this.zzaip = zzg2;
            this.zzaip.begin();
            this.zzaim.signalAll();
            this.zzXG.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzpM() {
        for (com.google.android.gms.common.api.Api.zzb disconnect : this.zzahT.values()) {
            disconnect.disconnect();
        }
    }

    public void zzpj() {
        if (isConnected()) {
            ((zzg) this.zzaip).zzps();
        }
    }
}
