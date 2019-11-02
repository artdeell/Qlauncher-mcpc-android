package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.C0879zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class zzd implements zzp {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final Lock zzXG;
    private final zzj zzagW;
    /* access modifiers changed from: private */
    public final zzl zzagX;
    /* access modifiers changed from: private */
    public final zzl zzagY;
    private final Map<zzc<?>, zzl> zzagZ;
    private final Looper zzagr;
    private final Set<zzu> zzaha;
    private final zzb zzahb;
    private Bundle zzahc;
    private ConnectionResult zzahd = null;
    /* access modifiers changed from: private */
    public ConnectionResult zzahe = null;
    /* access modifiers changed from: private */
    public boolean zzahf = false;
    private int zzahg = 0;

    public zzd(Context context, zzj zzj, Lock lock, Looper looper, com.google.android.gms.common.zzc zzc, Map<zzc<?>, zzb> map, zzf zzf, Map<Api<?>, Integer> map2, zza<? extends zzrn, zzro> zza, ArrayList<zzc> arrayList) {
        ArrayMap arrayMap;
        WeakHashMap weakHashMap;
        ArrayMap arrayMap2;
        ArrayMap arrayMap3;
        ArrayMap arrayMap4;
        ArrayMap arrayMap5;
        ArrayList arrayList2;
        ArrayList arrayList3;
        C02231 r54;
        zzl zzl;
        C02242 r542;
        zzl zzl2;
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2;
        IllegalStateException illegalStateException3;
        Context context2 = context;
        zzj zzj2 = zzj;
        Lock lock2 = lock;
        Looper looper2 = looper;
        com.google.android.gms.common.zzc zzc2 = zzc;
        Map<zzc<?>, zzb> map3 = map;
        zzf zzf2 = zzf;
        Map<Api<?>, Integer> map4 = map2;
        zza<? extends zzrn, zzro> zza2 = zza;
        ArrayList<zzc> arrayList4 = arrayList;
        ArrayMap arrayMap6 = arrayMap;
        ArrayMap arrayMap7 = new ArrayMap();
        this.zzagZ = arrayMap6;
        WeakHashMap weakHashMap2 = weakHashMap;
        WeakHashMap weakHashMap3 = new WeakHashMap();
        this.zzaha = Collections.newSetFromMap(weakHashMap2);
        this.mContext = context2;
        this.zzagW = zzj2;
        this.zzXG = lock2;
        this.zzagr = looper2;
        zzb zzb = null;
        ArrayMap arrayMap8 = arrayMap2;
        ArrayMap arrayMap9 = new ArrayMap();
        ArrayMap arrayMap10 = arrayMap8;
        ArrayMap arrayMap11 = arrayMap3;
        ArrayMap arrayMap12 = new ArrayMap();
        ArrayMap arrayMap13 = arrayMap11;
        for (zzc zzc3 : map3.keySet()) {
            zzb zzb2 = (zzb) map3.get(zzc3);
            if (zzb2.zznb()) {
                zzb = zzb2;
            }
            if (zzb2.zzmE()) {
                Object put = arrayMap10.put(zzc3, zzb2);
            } else {
                Object put2 = arrayMap13.put(zzc3, zzb2);
            }
        }
        this.zzahb = zzb;
        if (arrayMap10.isEmpty()) {
            IllegalStateException illegalStateException4 = illegalStateException3;
            IllegalStateException illegalStateException5 = new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
            throw illegalStateException4;
        }
        ArrayMap arrayMap14 = arrayMap4;
        ArrayMap arrayMap15 = new ArrayMap();
        ArrayMap arrayMap16 = arrayMap14;
        ArrayMap arrayMap17 = arrayMap5;
        ArrayMap arrayMap18 = new ArrayMap();
        ArrayMap arrayMap19 = arrayMap17;
        for (Api api : map4.keySet()) {
            zzc zzoR = api.zzoR();
            if (arrayMap10.containsKey(zzoR)) {
                Object put3 = arrayMap16.put(api, map4.get(api));
            } else if (arrayMap13.containsKey(zzoR)) {
                Object put4 = arrayMap19.put(api, map4.get(api));
            } else {
                IllegalStateException illegalStateException6 = illegalStateException2;
                IllegalStateException illegalStateException7 = new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
                throw illegalStateException6;
            }
        }
        ArrayList arrayList5 = arrayList2;
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = arrayList5;
        ArrayList arrayList8 = arrayList3;
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = arrayList8;
        Iterator it = arrayList4.iterator();
        while (it.hasNext()) {
            zzc zzc4 = (zzc) it.next();
            if (arrayMap16.containsKey(zzc4.zzagT)) {
                boolean add = arrayList7.add(zzc4);
            } else if (arrayMap19.containsKey(zzc4.zzagT)) {
                boolean add2 = arrayList10.add(zzc4);
            } else {
                IllegalStateException illegalStateException8 = illegalStateException;
                IllegalStateException illegalStateException9 = new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
                throw illegalStateException8;
            }
        }
        C02231 r40 = r54;
        C02231 r41 = new zzp.zza(this) {
            final /* synthetic */ zzd zzahh;

            {
                this.zzahh = r5;
            }

            public void zzc(int i, boolean z) {
                int i2 = i;
                boolean z2 = z;
                this.zzahh.zzXG.lock();
                try {
                    if (this.zzahh.zzahf || this.zzahh.zzahe == null || !this.zzahh.zzahe.isSuccess()) {
                        boolean zza = zzd.zza(this.zzahh, false);
                        this.zzahh.zzb(i2, z2);
                        this.zzahh.zzXG.unlock();
                        return;
                    }
                    boolean zza2 = zzd.zza(this.zzahh, true);
                    this.zzahh.zzagY.onConnectionSuspended(i2);
                    this.zzahh.zzXG.unlock();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    this.zzahh.zzXG.unlock();
                    throw th2;
                }
            }

            public void zzd(@NonNull ConnectionResult connectionResult) {
                ConnectionResult connectionResult2 = connectionResult;
                this.zzahh.zzXG.lock();
                try {
                    ConnectionResult zza = zzd.zza(this.zzahh, connectionResult2);
                    this.zzahh.zzpm();
                    this.zzahh.zzXG.unlock();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    this.zzahh.zzXG.unlock();
                    throw th2;
                }
            }

            public void zzi(@Nullable Bundle bundle) {
                Bundle bundle2 = bundle;
                this.zzahh.zzXG.lock();
                try {
                    this.zzahh.zzh(bundle2);
                    ConnectionResult zza = zzd.zza(this.zzahh, ConnectionResult.zzafB);
                    this.zzahh.zzpm();
                    this.zzahh.zzXG.unlock();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    this.zzahh.zzXG.unlock();
                    throw th2;
                }
            }
        };
        C02231 r23 = r40;
        zzl zzl3 = zzl;
        zzl zzl4 = new zzl(context2, this.zzagW, lock2, looper2, zzc2, arrayMap13, null, arrayMap19, null, arrayList10, r23);
        this.zzagX = zzl3;
        C02242 r402 = r542;
        C02242 r412 = new zzp.zza(this) {
            final /* synthetic */ zzd zzahh;

            {
                this.zzahh = r5;
            }

            public void zzc(int i, boolean z) {
                int i2 = i;
                boolean z2 = z;
                this.zzahh.zzXG.lock();
                try {
                    if (this.zzahh.zzahf) {
                        boolean zza = zzd.zza(this.zzahh, false);
                        this.zzahh.zzb(i2, z2);
                        this.zzahh.zzXG.unlock();
                        return;
                    }
                    boolean zza2 = zzd.zza(this.zzahh, true);
                    this.zzahh.zzagX.onConnectionSuspended(i2);
                    this.zzahh.zzXG.unlock();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    this.zzahh.zzXG.unlock();
                    throw th2;
                }
            }

            public void zzd(@NonNull ConnectionResult connectionResult) {
                ConnectionResult connectionResult2 = connectionResult;
                this.zzahh.zzXG.lock();
                try {
                    ConnectionResult zzb = zzd.zzb(this.zzahh, connectionResult2);
                    this.zzahh.zzpm();
                    this.zzahh.zzXG.unlock();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    this.zzahh.zzXG.unlock();
                    throw th2;
                }
            }

            public void zzi(@Nullable Bundle bundle) {
                Bundle bundle2 = bundle;
                this.zzahh.zzXG.lock();
                try {
                    ConnectionResult zzb = zzd.zzb(this.zzahh, ConnectionResult.zzafB);
                    this.zzahh.zzpm();
                    this.zzahh.zzXG.unlock();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    this.zzahh.zzXG.unlock();
                    throw th2;
                }
            }
        };
        C02242 r24 = r402;
        zzl zzl5 = zzl2;
        zzl zzl6 = new zzl(context2, this.zzagW, lock2, looper2, zzc2, arrayMap10, zzf2, arrayMap16, zza2, arrayList7, r24);
        this.zzagY = zzl5;
        for (zzc put5 : arrayMap13.keySet()) {
            Object put6 = this.zzagZ.put(put5, this.zzagX);
        }
        for (zzc put7 : arrayMap10.keySet()) {
            Object put8 = this.zzagZ.put(put7, this.zzagY);
        }
    }

    static /* synthetic */ ConnectionResult zza(zzd zzd, ConnectionResult connectionResult) {
        ConnectionResult connectionResult2 = connectionResult;
        zzd.zzahd = connectionResult2;
        return connectionResult2;
    }

    static /* synthetic */ boolean zza(zzd zzd, boolean z) {
        boolean z2 = z;
        zzd.zzahf = z2;
        return z2;
    }

    static /* synthetic */ ConnectionResult zzb(zzd zzd, ConnectionResult connectionResult) {
        ConnectionResult connectionResult2 = connectionResult;
        zzd.zzahe = connectionResult2;
        return connectionResult2;
    }

    /* access modifiers changed from: private */
    public void zzb(int i, boolean z) {
        this.zzagW.zzc(i, z);
        this.zzahe = null;
        this.zzahd = null;
    }

    private void zzb(ConnectionResult connectionResult) {
        Exception exc;
        ConnectionResult connectionResult2 = connectionResult;
        switch (this.zzahg) {
            case 1:
                break;
            case 2:
                this.zzagW.zzd(connectionResult2);
                break;
            default:
                Exception exc2 = exc;
                Exception exc3 = new Exception();
                int wtf = Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", exc2);
                break;
        }
        zzpo();
        this.zzahg = 0;
    }

    private static boolean zzc(ConnectionResult connectionResult) {
        ConnectionResult connectionResult2 = connectionResult;
        return connectionResult2 != null && connectionResult2.isSuccess();
    }

    private boolean zzc(C0879zza<? extends Result, ? extends zzb> zza) {
        zzc zzoR = zza.zzoR();
        zzx.zzb(this.zzagZ.containsKey(zzoR), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        return ((zzl) this.zzagZ.get(zzoR)).equals(this.zzagY);
    }

    /* access modifiers changed from: private */
    public void zzh(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (this.zzahc == null) {
            this.zzahc = bundle2;
        } else if (bundle2 != null) {
            this.zzahc.putAll(bundle2);
        }
    }

    private void zzpl() {
        this.zzahe = null;
        this.zzahd = null;
        this.zzagX.connect();
        this.zzagY.connect();
    }

    /* access modifiers changed from: private */
    public void zzpm() {
        if (zzc(this.zzahd)) {
            if (zzc(this.zzahe) || zzpp()) {
                zzpn();
            } else if (this.zzahe == null) {
            } else {
                if (this.zzahg == 1) {
                    zzpo();
                    return;
                }
                zzb(this.zzahe);
                boolean disconnect = this.zzagX.disconnect();
            }
        } else if (this.zzahd != null && zzc(this.zzahe)) {
            boolean disconnect2 = this.zzagY.disconnect();
            zzb(this.zzahd);
        } else if (this.zzahd != null && this.zzahe != null) {
            ConnectionResult connectionResult = this.zzahd;
            if (this.zzagY.zzair < this.zzagX.zzair) {
                connectionResult = this.zzahe;
            }
            zzb(connectionResult);
        }
    }

    private void zzpn() {
        Exception exc;
        switch (this.zzahg) {
            case 1:
                break;
            case 2:
                this.zzagW.zzi(this.zzahc);
                break;
            default:
                Exception exc2 = exc;
                Exception exc3 = new Exception();
                int wtf = Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", exc2);
                break;
        }
        zzpo();
        this.zzahg = 0;
    }

    private void zzpo() {
        for (zzu zzna : this.zzaha) {
            zzna.zzna();
        }
        this.zzaha.clear();
    }

    private boolean zzpp() {
        return this.zzahe != null && this.zzahe.getErrorCode() == 4;
    }

    @Nullable
    private PendingIntent zzpq() {
        if (this.zzahb == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, this.zzagW.getSessionId(), this.zzahb.zznc(), 134217728);
    }

    public ConnectionResult blockingConnect() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        UnsupportedOperationException unsupportedOperationException;
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public void connect() {
        this.zzahg = 2;
        this.zzahf = false;
        zzpl();
    }

    public boolean disconnect() {
        this.zzahe = null;
        this.zzahd = null;
        this.zzahg = 0;
        boolean disconnect = this.zzagX.disconnect();
        boolean disconnect2 = this.zzagY.disconnect();
        zzpo();
        boolean z = false;
        if (disconnect) {
            z = false;
            if (disconnect2) {
                z = true;
            }
        }
        return z;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        StringBuilder sb;
        StringBuilder sb2;
        String str2 = str;
        FileDescriptor fileDescriptor2 = fileDescriptor;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        printWriter2.append(str2).append("authClient").println(":");
        zzl zzl = this.zzagY;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        zzl.dump(sb3.append(str2).append("  ").toString(), fileDescriptor2, printWriter2, strArr2);
        printWriter2.append(str2).append("anonClient").println(":");
        zzl zzl2 = this.zzagX;
        StringBuilder sb5 = sb2;
        StringBuilder sb6 = new StringBuilder();
        zzl2.dump(sb5.append(str2).append("  ").toString(), fileDescriptor2, printWriter2, strArr2);
    }

    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        ConnectionResult connectionResult;
        Api<?> api2 = api;
        if (!((zzl) this.zzagZ.get(api2.zzoR())).equals(this.zzagY)) {
            return this.zzagX.getConnectionResult(api2);
        }
        if (!zzpp()) {
            return this.zzagY.getConnectionResult(api2);
        }
        ConnectionResult connectionResult2 = connectionResult;
        ConnectionResult connectionResult3 = new ConnectionResult(4, zzpq());
        return connectionResult2;
    }

    public boolean isConnected() {
        boolean z = true;
        this.zzXG.lock();
        try {
            if (!this.zzagX.isConnected() || (!zzpk() && !zzpp() && this.zzahg != 1)) {
                z = false;
            }
            this.zzXG.unlock();
            return z;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public boolean isConnecting() {
        this.zzXG.lock();
        try {
            boolean z = this.zzahg == 2;
            this.zzXG.unlock();
            return z;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public <A extends zzb, R extends Result, T extends C0879zza<R, A>> T zza(@NonNull T t) {
        Status status;
        T t2 = t;
        if (!zzc((C0879zza<? extends Result, ? extends zzb>) t2)) {
            return this.zzagX.zza(t2);
        }
        if (!zzpp()) {
            return this.zzagY.zza(t2);
        }
        T t3 = t2;
        Status status2 = status;
        Status status3 = new Status(4, null, zzpq());
        t3.zzw(status2);
        return t2;
    }

    public boolean zza(zzu zzu) {
        zzu zzu2 = zzu;
        this.zzXG.lock();
        try {
            if ((isConnecting() || isConnected()) && !zzpk()) {
                boolean add = this.zzaha.add(zzu2);
                if (this.zzahg == 0) {
                    this.zzahg = 1;
                }
                this.zzahe = null;
                this.zzagY.connect();
                this.zzXG.unlock();
                return true;
            }
            this.zzXG.unlock();
            return false;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public <A extends zzb, T extends C0879zza<? extends Result, A>> T zzb(@NonNull T t) {
        Status status;
        T t2 = t;
        if (!zzc((C0879zza<? extends Result, ? extends zzb>) t2)) {
            return this.zzagX.zzb(t2);
        }
        if (!zzpp()) {
            return this.zzagY.zzb(t2);
        }
        T t3 = t2;
        Status status2 = status;
        Status status3 = new Status(4, null, zzpq());
        t3.zzw(status2);
        return t2;
    }

    public void zzoW() {
        ConnectionResult connectionResult;
        Handler handler;
        C02253 r7;
        this.zzXG.lock();
        try {
            boolean isConnecting = isConnecting();
            boolean disconnect = this.zzagY.disconnect();
            ConnectionResult connectionResult2 = connectionResult;
            ConnectionResult connectionResult3 = new ConnectionResult(4);
            this.zzahe = connectionResult2;
            if (isConnecting) {
                Handler handler2 = handler;
                Handler handler3 = new Handler(this.zzagr);
                C02253 r4 = r7;
                C02253 r5 = new Runnable(this) {
                    final /* synthetic */ zzd zzahh;

                    {
                        this.zzahh = r5;
                    }

                    public void run() {
                        this.zzahh.zzXG.lock();
                        try {
                            this.zzahh.zzpm();
                            this.zzahh.zzXG.unlock();
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            this.zzahh.zzXG.unlock();
                            throw th2;
                        }
                    }
                };
                boolean post = handler2.post(r4);
            } else {
                zzpo();
            }
            this.zzXG.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public void zzpj() {
        this.zzagX.zzpj();
        this.zzagY.zzpj();
    }

    public boolean zzpk() {
        return this.zzagY.isConnected();
    }
}
