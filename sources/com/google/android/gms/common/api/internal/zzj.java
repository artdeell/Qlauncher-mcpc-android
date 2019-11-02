package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.p000v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzq;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.C0879zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmf;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public final class zzj extends GoogleApiClient implements com.google.android.gms.common.api.internal.zzp.zza {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Lock zzXG;
    /* access modifiers changed from: private */
    public final int zzagp;
    private final Looper zzagr;
    private final com.google.android.gms.common.zzc zzags;
    final com.google.android.gms.common.api.Api.zza<? extends zzrn, zzro> zzagt;
    final Map<Api<?>, Integer> zzahA;
    private final zzk zzahL;
    private zzp zzahM = null;
    final Queue<C0879zza<?, ?>> zzahN;
    private volatile boolean zzahO;
    private long zzahP;
    private long zzahQ;
    private final zza zzahR;
    zzc zzahS;
    final Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.Api.zzb> zzahT;
    Set<Scope> zzahU;
    private final Set<zzq<?>> zzahV;
    final Set<zze<?>> zzahW;
    /* access modifiers changed from: private */
    public com.google.android.gms.common.api.zza zzahX;
    private final ArrayList<zzc> zzahY;
    private Integer zzahZ;
    final zzf zzahz;
    Set<zzx> zzaia;
    private final zzd zzaib;
    private final com.google.android.gms.common.internal.zzk.zza zzaic;

    final class zza extends Handler {
        final /* synthetic */ zzj zzaid;

        zza(zzj zzj, Looper looper) {
            Looper looper2 = looper;
            this.zzaid = zzj;
            super(looper2);
        }

        public void handleMessage(Message message) {
            StringBuilder sb;
            Message message2 = message;
            switch (message2.what) {
                case 1:
                    this.zzaid.zzpD();
                    return;
                case 2:
                    this.zzaid.resume();
                    return;
                default:
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int w = Log.w("GoogleApiClientImpl", sb2.append("Unknown message id: ").append(message2.what).toString());
                    return;
            }
        }
    }

    private static class zzb implements DeathRecipient, zzd {
        private final WeakReference<zze<?>> zzaii;
        private final WeakReference<com.google.android.gms.common.api.zza> zzaij;
        private final WeakReference<IBinder> zzaik;

        private zzb(zze zze, com.google.android.gms.common.api.zza zza, IBinder iBinder) {
            WeakReference<com.google.android.gms.common.api.zza> weakReference;
            WeakReference<zze<?>> weakReference2;
            WeakReference<IBinder> weakReference3;
            zze zze2 = zze;
            IBinder iBinder2 = iBinder;
            WeakReference<com.google.android.gms.common.api.zza> weakReference4 = weakReference;
            WeakReference<com.google.android.gms.common.api.zza> weakReference5 = new WeakReference<>(zza);
            this.zzaij = weakReference4;
            WeakReference<zze<?>> weakReference6 = weakReference2;
            WeakReference<zze<?>> weakReference7 = new WeakReference<>(zze2);
            this.zzaii = weakReference6;
            WeakReference<IBinder> weakReference8 = weakReference3;
            WeakReference<IBinder> weakReference9 = new WeakReference<>(iBinder2);
            this.zzaik = weakReference8;
        }

        /* synthetic */ zzb(zze zze, com.google.android.gms.common.api.zza zza, IBinder iBinder, C02311 r13) {
            C02311 r4 = r13;
            this(zze, zza, iBinder);
        }

        private void zzpI() {
            zze zze = (zze) this.zzaii.get();
            com.google.android.gms.common.api.zza zza = (com.google.android.gms.common.api.zza) this.zzaij.get();
            if (!(zza == null || zze == null)) {
                zza.remove(zze.zzpa().intValue());
            }
            IBinder iBinder = (IBinder) this.zzaik.get();
            if (this.zzaik != null) {
                boolean unlinkToDeath = iBinder.unlinkToDeath(this, 0);
            }
        }

        public void binderDied() {
            zzpI();
        }

        public void zzc(zze<?> zze) {
            zze<?> zze2 = zze;
            zzpI();
        }
    }

    static class zzc extends zzn {
        private WeakReference<zzj> zzail;

        zzc(zzj zzj) {
            WeakReference<zzj> weakReference;
            WeakReference<zzj> weakReference2 = weakReference;
            WeakReference<zzj> weakReference3 = new WeakReference<>(zzj);
            this.zzail = weakReference2;
        }

        public void zzpJ() {
            zzj zzj = (zzj) this.zzail.get();
            if (zzj != null) {
                zzj.resume();
            }
        }
    }

    interface zzd {
        void zzc(zze<?> zze);
    }

    interface zze<A extends com.google.android.gms.common.api.Api.zzb> {
        void cancel();

        boolean isReady();

        void zza(zzd zzd);

        void zzb(A a) throws DeadObjectException;

        com.google.android.gms.common.api.Api.zzc<A> zzoR();

        Integer zzpa();

        void zzpe();

        void zzpg();

        void zzw(Status status);

        void zzx(Status status);
    }

    public zzj(Context context, Lock lock, Looper looper, zzf zzf, com.google.android.gms.common.zzc zzc2, com.google.android.gms.common.api.Api.zza<? extends zzrn, zzro> zza2, Map<Api<?>, Integer> map, List<ConnectionCallbacks> list, List<OnConnectionFailedListener> list2, Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.Api.zzb> map2, int i, int i2, ArrayList<zzc> arrayList) {
        LinkedList linkedList;
        HashSet hashSet;
        WeakHashMap weakHashMap;
        ConcurrentHashMap concurrentHashMap;
        C02311 r27;
        C02322 r272;
        zzk zzk;
        zza zza3;
        Context context2 = context;
        Lock lock2 = lock;
        Looper looper2 = looper;
        zzf zzf2 = zzf;
        com.google.android.gms.common.zzc zzc3 = zzc2;
        com.google.android.gms.common.api.Api.zza<? extends zzrn, zzro> zza4 = zza2;
        Map<Api<?>, Integer> map3 = map;
        List<ConnectionCallbacks> list3 = list;
        List<OnConnectionFailedListener> list4 = list2;
        Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.Api.zzb> map4 = map2;
        int i3 = i;
        int i4 = i2;
        ArrayList<zzc> arrayList2 = arrayList;
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList();
        this.zzahN = linkedList2;
        this.zzahP = 120000;
        this.zzahQ = 5000;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        this.zzahU = hashSet2;
        WeakHashMap weakHashMap2 = weakHashMap;
        WeakHashMap weakHashMap3 = new WeakHashMap();
        this.zzahV = Collections.newSetFromMap(weakHashMap2);
        ConcurrentHashMap concurrentHashMap2 = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap(16, 0.75f, 2);
        this.zzahW = Collections.newSetFromMap(concurrentHashMap2);
        this.zzahZ = null;
        this.zzaia = null;
        C02311 r22 = r27;
        C02311 r23 = new zzd(this) {
            final /* synthetic */ zzj zzaid;

            {
                this.zzaid = r5;
            }

            public void zzc(zze<?> zze) {
                zze<?> zze2 = zze;
                boolean remove = this.zzaid.zzahW.remove(zze2);
                if (zze2.zzpa() != null && this.zzaid.zzahX != null) {
                    this.zzaid.zzahX.remove(zze2.zzpa().intValue());
                }
            }
        };
        this.zzaib = r22;
        C02322 r222 = r272;
        C02322 r232 = new com.google.android.gms.common.internal.zzk.zza(this) {
            final /* synthetic */ zzj zzaid;

            {
                this.zzaid = r5;
            }

            public boolean isConnected() {
                return this.zzaid.isConnected();
            }

            public Bundle zzoi() {
                return null;
            }
        };
        this.zzaic = r222;
        this.mContext = context2;
        this.zzXG = lock2;
        zzk zzk2 = zzk;
        zzk zzk3 = new zzk(looper2, this.zzaic);
        this.zzahL = zzk2;
        this.zzagr = looper2;
        zza zza5 = zza3;
        zza zza6 = new zza(this, looper2);
        this.zzahR = zza5;
        this.zzags = zzc3;
        this.zzagp = i3;
        if (this.zzagp >= 0) {
            this.zzahZ = Integer.valueOf(i4);
        }
        this.zzahA = map3;
        this.zzahT = map4;
        this.zzahY = arrayList2;
        for (ConnectionCallbacks registerConnectionCallbacks : list3) {
            this.zzahL.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : list4) {
            this.zzahL.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        this.zzahz = zzf2;
        this.zzagt = zza4;
    }

    /* access modifiers changed from: private */
    public void resume() {
        this.zzXG.lock();
        try {
            if (zzpB()) {
                zzpC();
            }
            this.zzXG.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public static int zza(Iterable<com.google.android.gms.common.api.Api.zzb> iterable, boolean z) {
        boolean z2 = z;
        int i = 1;
        boolean z3 = false;
        boolean z4 = false;
        for (com.google.android.gms.common.api.Api.zzb zzb2 : iterable) {
            if (zzb2.zzmE()) {
                z4 = true;
            }
            z3 = zzb2.zznb() ? true : z3;
        }
        if (!z4) {
            return 3;
        }
        if (z3 && z2) {
            i = 2;
        }
        return i;
    }

    /* access modifiers changed from: private */
    public void zza(GoogleApiClient googleApiClient, zzv zzv, boolean z) {
        C02355 r11;
        GoogleApiClient googleApiClient2 = googleApiClient;
        zzv zzv2 = zzv;
        boolean z2 = z;
        PendingResult zzf = zzmf.zzamA.zzf(googleApiClient2);
        C02355 r5 = r11;
        final zzv zzv3 = zzv2;
        final boolean z3 = z2;
        final GoogleApiClient googleApiClient3 = googleApiClient2;
        C02355 r6 = new ResultCallback<Status>(this) {
            final /* synthetic */ zzj zzaid;

            {
                zzv zzv = r9;
                boolean z = r10;
                GoogleApiClient googleApiClient = r11;
                this.zzaid = r8;
            }

            /* renamed from: zzp */
            public void onResult(@NonNull Status status) {
                Status status2 = status;
                zzq.zzaf(this.zzaid.mContext).zznr();
                if (status2.isSuccess() && this.zzaid.isConnected()) {
                    this.zzaid.reconnect();
                }
                zzv3.zza(status2);
                if (z3) {
                    googleApiClient3.disconnect();
                }
            }
        };
        zzf.setResultCallback(r5);
    }

    private static void zza(zze<?> zze2, com.google.android.gms.common.api.zza zza2, IBinder iBinder) {
        zzb zzb2;
        zzb zzb3;
        zze<?> zze3 = zze2;
        com.google.android.gms.common.api.zza zza3 = zza2;
        IBinder iBinder2 = iBinder;
        if (zze3.isReady()) {
            zze<?> zze4 = zze3;
            zzb zzb4 = zzb3;
            zzb zzb5 = new zzb(zze3, zza3, iBinder2, null);
            zze4.zza(zzb4);
        } else if (iBinder2 == null || !iBinder2.isBinderAlive()) {
            zze3.zza(null);
            zze3.cancel();
            zza3.remove(zze3.zzpa().intValue());
        } else {
            zzb zzb6 = zzb2;
            zzb zzb7 = new zzb(zze3, zza3, iBinder2, null);
            zzb zzb8 = zzb6;
            zze3.zza(zzb8);
            try {
                iBinder2.linkToDeath(zzb8, 0);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                zze3.cancel();
                zza3.remove(zze3.zzpa().intValue());
            }
        }
    }

    private void zzbB(int i) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        zzd zzd2;
        IllegalStateException illegalStateException2;
        IllegalStateException illegalStateException3;
        zzl zzl;
        int i2 = i;
        if (this.zzahZ == null) {
            this.zzahZ = Integer.valueOf(i2);
        } else if (this.zzahZ.intValue() != i2) {
            IllegalStateException illegalStateException4 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException5 = new IllegalStateException(sb2.append("Cannot use sign-in mode: ").append(zzbC(i2)).append(". Mode was already set to ").append(zzbC(this.zzahZ.intValue())).toString());
            throw illegalStateException4;
        }
        if (this.zzahM == null) {
            boolean z = false;
            boolean z2 = false;
            for (com.google.android.gms.common.api.Api.zzb zzb2 : this.zzahT.values()) {
                if (zzb2.zzmE()) {
                    z2 = true;
                }
                z = zzb2.zznb() ? true : z;
            }
            switch (this.zzahZ.intValue()) {
                case 1:
                    if (!z2) {
                        IllegalStateException illegalStateException6 = illegalStateException3;
                        IllegalStateException illegalStateException7 = new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                        throw illegalStateException6;
                    } else if (z) {
                        IllegalStateException illegalStateException8 = illegalStateException2;
                        IllegalStateException illegalStateException9 = new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                        throw illegalStateException8;
                    }
                    break;
                case 2:
                    if (z2) {
                        zzd zzd3 = zzd2;
                        zzd zzd4 = new zzd(this.mContext, this, this.zzXG, this.zzagr, this.zzags, this.zzahT, this.zzahz, this.zzahA, this.zzagt, this.zzahY);
                        this.zzahM = zzd3;
                        return;
                    }
                    break;
            }
            zzl zzl2 = zzl;
            zzl zzl3 = new zzl(this.mContext, this, this.zzXG, this.zzagr, this.zzags, this.zzahT, this.zzahz, this.zzahA, this.zzagt, this.zzahY, this);
            this.zzahM = zzl2;
        }
    }

    static String zzbC(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void zzpC() {
        this.zzahL.zzqR();
        this.zzahM.connect();
    }

    /* access modifiers changed from: private */
    public void zzpD() {
        this.zzXG.lock();
        try {
            if (zzpF()) {
                zzpC();
            }
            this.zzXG.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public ConnectionResult blockingConnect() {
        IllegalStateException illegalStateException;
        boolean z = true;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.zzXG.lock();
        try {
            if (this.zzagp >= 0) {
                if (this.zzahZ == null) {
                    z = false;
                }
                zzx.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzahZ == null) {
                this.zzahZ = Integer.valueOf(zza(this.zzahT.values(), false));
            } else if (this.zzahZ.intValue() == 2) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                throw illegalStateException2;
            }
            zzbB(this.zzahZ.intValue());
            this.zzahL.zzqR();
            ConnectionResult blockingConnect = this.zzahM.blockingConnect();
            this.zzXG.unlock();
            return blockingConnect;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        IllegalStateException illegalStateException;
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        boolean z = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        zzx.zza(z, (Object) "blockingConnect must not be called on the UI thread");
        Object zzb2 = zzx.zzb(timeUnit2, (Object) "TimeUnit must not be null");
        this.zzXG.lock();
        try {
            if (this.zzahZ == null) {
                this.zzahZ = Integer.valueOf(zza(this.zzahT.values(), false));
            } else if (this.zzahZ.intValue() == 2) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                throw illegalStateException2;
            }
            zzbB(this.zzahZ.intValue());
            this.zzahL.zzqR();
            ConnectionResult blockingConnect = this.zzahM.blockingConnect(j2, timeUnit2);
            this.zzXG.unlock();
            return blockingConnect;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzv zzv;
        AtomicReference atomicReference;
        C02333 r12;
        C02344 r122;
        Builder builder;
        zzx.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        zzx.zza(this.zzahZ.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        zzv zzv2 = zzv;
        zzv zzv3 = new zzv((GoogleApiClient) this);
        zzv zzv4 = zzv2;
        if (this.zzahT.containsKey(zzmf.zzUI)) {
            zza((GoogleApiClient) this, zzv4, false);
            return zzv4;
        }
        AtomicReference atomicReference2 = atomicReference;
        AtomicReference atomicReference3 = new AtomicReference();
        AtomicReference atomicReference4 = atomicReference2;
        C02333 r7 = r12;
        final AtomicReference atomicReference5 = atomicReference4;
        final zzv zzv5 = zzv4;
        C02333 r8 = new ConnectionCallbacks(this) {
            final /* synthetic */ zzj zzaid;

            {
                AtomicReference atomicReference = r8;
                zzv zzv = r9;
                this.zzaid = r7;
            }

            public void onConnected(Bundle bundle) {
                Bundle bundle2 = bundle;
                this.zzaid.zza((GoogleApiClient) atomicReference5.get(), zzv5, true);
            }

            public void onConnectionSuspended(int i) {
            }
        };
        C02333 r4 = r7;
        C02344 r72 = r122;
        final zzv zzv6 = zzv4;
        C02344 r82 = new OnConnectionFailedListener(this) {
            final /* synthetic */ zzj zzaid;

            {
                zzv zzv = r7;
                this.zzaid = r6;
            }

            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                Status status;
                ConnectionResult connectionResult2 = connectionResult;
                zzv zzv = zzv6;
                Status status2 = status;
                Status status3 = new Status(8);
                zzv.zza(status2);
            }
        };
        C02344 r5 = r72;
        Builder builder2 = builder;
        Builder builder3 = new Builder(this.mContext);
        GoogleApiClient build = builder2.addApi(zzmf.API).addConnectionCallbacks(r4).addOnConnectionFailedListener(r5).setHandler(this.zzahR).build();
        atomicReference4.set(build);
        build.connect();
        return zzv4;
    }

    public void connect() {
        IllegalStateException illegalStateException;
        this.zzXG.lock();
        try {
            if (this.zzagp >= 0) {
                boolean z = false;
                if (this.zzahZ != null) {
                    z = true;
                }
                zzx.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzahZ == null) {
                this.zzahZ = Integer.valueOf(zza(this.zzahT.values(), false));
            } else if (this.zzahZ.intValue() == 2) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                throw illegalStateException2;
            }
            connect(this.zzahZ.intValue());
            this.zzXG.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public void connect(int i) {
        StringBuilder sb;
        int i2 = i;
        boolean z = true;
        this.zzXG.lock();
        if (!(i2 == 3 || i2 == 1 || i2 == 2)) {
            z = false;
        }
        boolean z2 = z;
        try {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzx.zzb(z2, (Object) sb2.append("Illegal sign-in mode: ").append(i2).toString());
            zzbB(i2);
            zzpC();
            this.zzXG.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public void disconnect() {
        this.zzXG.lock();
        try {
            zzaa(this.zzahM != null && !this.zzahM.disconnect());
            for (zzq clear : this.zzahV) {
                clear.clear();
            }
            this.zzahV.clear();
            for (zze zze2 : this.zzahN) {
                zze2.zza(null);
                zze2.cancel();
            }
            this.zzahN.clear();
            if (this.zzahM == null) {
                this.zzXG.unlock();
                return;
            }
            boolean zzpF = zzpF();
            this.zzahL.zzqQ();
            this.zzXG.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str;
        FileDescriptor fileDescriptor2 = fileDescriptor;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        printWriter2.append(str2).append("mContext=").println(this.mContext);
        printWriter2.append(str2).append("mResuming=").print(this.zzahO);
        printWriter2.append(" mWorkQueue.size()=").print(this.zzahN.size());
        printWriter2.append(" mUnconsumedRunners.size()=").println(this.zzahW.size());
        if (this.zzahM != null) {
            this.zzahM.dump(str2, fileDescriptor2, printWriter2, strArr2);
        }
    }

    /* JADX INFO: finally extract failed */
    @NonNull
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        StringBuilder sb2;
        Exception exc;
        ConnectionResult connectionResult;
        IllegalStateException illegalStateException;
        Api<?> api2 = api;
        this.zzXG.lock();
        try {
            if (!isConnected() && !zzpB()) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
                throw illegalStateException2;
            } else if (this.zzahT.containsKey(api2.zzoR())) {
                ConnectionResult connectionResult2 = this.zzahM.getConnectionResult(api2);
                if (connectionResult2 != null) {
                    this.zzXG.unlock();
                    return connectionResult2;
                } else if (zzpB()) {
                    ConnectionResult connectionResult3 = ConnectionResult.zzafB;
                    this.zzXG.unlock();
                    return connectionResult3;
                } else {
                    int i = Log.i("GoogleApiClientImpl", zzpH());
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    String sb5 = sb3.append(api2.getName()).append(" requested in getConnectionResult").append(" is not connected but is not present in the failed ").append(" connections map").toString();
                    Exception exc2 = exc;
                    Exception exc3 = new Exception();
                    int wtf = Log.wtf("GoogleApiClientImpl", sb5, exc2);
                    ConnectionResult connectionResult4 = connectionResult;
                    ConnectionResult connectionResult5 = new ConnectionResult(8, null);
                    ConnectionResult connectionResult6 = connectionResult4;
                    this.zzXG.unlock();
                    return connectionResult6;
                }
            } else {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb6 = sb;
                StringBuilder sb7 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb6.append(api2.getName()).append(" was never registered with GoogleApiClient").toString());
                throw illegalArgumentException2;
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Looper getLooper() {
        return this.zzagr;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    public boolean hasConnectedApi(@NonNull Api<?> api) {
        com.google.android.gms.common.api.Api.zzb zzb2 = (com.google.android.gms.common.api.Api.zzb) this.zzahT.get(api.zzoR());
        return zzb2 != null && zzb2.isConnected();
    }

    public boolean isConnected() {
        return this.zzahM != null && this.zzahM.isConnected();
    }

    public boolean isConnecting() {
        return this.zzahM != null && this.zzahM.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks) {
        return this.zzahL.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        return this.zzahL.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
        ConnectionCallbacks connectionCallbacks2 = connectionCallbacks;
        this.zzahL.registerConnectionCallbacks(connectionCallbacks2);
    }

    public void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        OnConnectionFailedListener onConnectionFailedListener2 = onConnectionFailedListener;
        this.zzahL.registerConnectionFailedListener(onConnectionFailedListener2);
    }

    public void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {
        IllegalStateException illegalStateException;
        Handler handler;
        C02366 r8;
        FragmentActivity fragmentActivity2 = fragmentActivity;
        if (this.zzagp >= 0) {
            zzw zza2 = zzw.zza(fragmentActivity2);
            if (zza2 == null) {
                Handler handler2 = handler;
                Handler handler3 = new Handler(this.mContext.getMainLooper());
                C02366 r4 = r8;
                final FragmentActivity fragmentActivity3 = fragmentActivity2;
                C02366 r5 = new Runnable(this) {
                    final /* synthetic */ zzj zzaid;

                    {
                        FragmentActivity fragmentActivity = r7;
                        this.zzaid = r6;
                    }

                    public void run() {
                        if (!fragmentActivity3.isFinishing() && !fragmentActivity3.getSupportFragmentManager().isDestroyed()) {
                            zzw.zzb(fragmentActivity3).zzbD(this.zzaid.zzagp);
                        }
                    }
                };
                boolean post = handler2.post(r4);
                return;
            }
            zza2.zzbD(this.zzagp);
            return;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        throw illegalStateException2;
    }

    public void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
        ConnectionCallbacks connectionCallbacks2 = connectionCallbacks;
        this.zzahL.unregisterConnectionCallbacks(connectionCallbacks2);
    }

    public void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        OnConnectionFailedListener onConnectionFailedListener2 = onConnectionFailedListener;
        this.zzahL.unregisterConnectionFailedListener(onConnectionFailedListener2);
    }

    @NonNull
    public <C extends com.google.android.gms.common.api.Api.zzb> C zza(@NonNull com.google.android.gms.common.api.Api.zzc<C> zzc2) {
        com.google.android.gms.common.api.Api.zzc<C> zzc3 = zzc2;
        com.google.android.gms.common.api.Api.zzb zzb2 = (com.google.android.gms.common.api.Api.zzb) this.zzahT.get(zzc3);
        Object zzb3 = zzx.zzb(zzb2, (Object) "Appropriate Api was not requested.");
        return zzb2;
    }

    /* JADX INFO: finally extract failed */
    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends C0879zza<R, A>> T zza(@NonNull T t) {
        T t2 = t;
        zzx.zzb(t2.zzoR() != null, (Object) "This task can not be enqueued (it's probably a Batch or malformed)");
        zzx.zzb(this.zzahT.containsKey(t2.zzoR()), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        this.zzXG.lock();
        try {
            if (this.zzahM == null) {
                boolean add = this.zzahN.add(t2);
                this.zzXG.unlock();
                return t2;
            }
            C0879zza zza2 = this.zzahM.zza(t2);
            this.zzXG.unlock();
            return zza2;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public void zza(zzx zzx) {
        HashSet hashSet;
        zzx zzx2 = zzx;
        this.zzXG.lock();
        try {
            if (this.zzaia == null) {
                HashSet hashSet2 = hashSet;
                HashSet hashSet3 = new HashSet();
                this.zzaia = hashSet2;
            }
            boolean add = this.zzaia.add(zzx2);
            this.zzXG.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public boolean zza(@NonNull Api<?> api) {
        return this.zzahT.containsKey(api.zzoR());
    }

    public boolean zza(zzu zzu) {
        return this.zzahM != null && this.zzahM.zza(zzu);
    }

    /* access modifiers changed from: 0000 */
    public void zzaa(boolean z) {
        boolean z2 = z;
        for (zze zze2 : this.zzahW) {
            if (zze2.zzpa() != null) {
                zze2.zzpe();
                zza(zze2, this.zzahX, zza(zze2.zzoR()).zzoT());
                boolean remove = this.zzahW.remove(zze2);
            } else if (z2) {
                zze2.zzpg();
            } else {
                zze2.cancel();
                boolean remove2 = this.zzahW.remove(zze2);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public <A extends com.google.android.gms.common.api.Api.zzb, T extends C0879zza<? extends Result, A>> T zzb(@NonNull T t) {
        IllegalStateException illegalStateException;
        T t2 = t;
        zzx.zzb(t2.zzoR() != null, (Object) "This task can not be executed (it's probably a Batch or malformed)");
        this.zzXG.lock();
        try {
            if (this.zzahM == null) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("GoogleApiClient is not connected yet.");
                throw illegalStateException2;
            } else if (zzpB()) {
                boolean add = this.zzahN.add(t2);
                while (!this.zzahN.isEmpty()) {
                    zze zze2 = (zze) this.zzahN.remove();
                    zzb(zze2);
                    zze2.zzw(Status.zzagE);
                }
                this.zzXG.unlock();
                return t2;
            } else {
                C0879zza zzb2 = this.zzahM.zzb(t2);
                this.zzXG.unlock();
                return zzb2;
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    /* access modifiers changed from: 0000 */
    public <A extends com.google.android.gms.common.api.Api.zzb> void zzb(zze<A> zze2) {
        zze<A> zze3 = zze2;
        boolean add = this.zzahW.add(zze3);
        zze3.zza(this.zzaib);
    }

    public void zzb(zzx zzx) {
        Exception exc;
        Exception exc2;
        zzx zzx2 = zzx;
        this.zzXG.lock();
        try {
            if (this.zzaia == null) {
                Exception exc3 = exc2;
                Exception exc4 = new Exception();
                int wtf = Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", exc3);
            } else if (!this.zzaia.remove(zzx2)) {
                Exception exc5 = exc;
                Exception exc6 = new Exception();
                int wtf2 = Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", exc5);
            } else if (!zzpG()) {
                this.zzahM.zzpj();
            }
            this.zzXG.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    public void zzc(int i, boolean z) {
        Status status;
        int i2 = i;
        boolean z2 = z;
        if (i2 == 1 && !z2) {
            zzpE();
        }
        for (zze zze2 : this.zzahW) {
            if (z2) {
                zze2.zzpe();
            }
            zze zze3 = zze2;
            Status status2 = status;
            Status status3 = new Status(8, "The connection to Google Play services was lost");
            zze3.zzx(status2);
        }
        this.zzahW.clear();
        this.zzahL.zzbT(i2);
        this.zzahL.zzqQ();
        if (i2 == 2) {
            zzpC();
        }
    }

    public void zzd(ConnectionResult connectionResult) {
        ConnectionResult connectionResult2 = connectionResult;
        if (!this.zzags.zzd(this.mContext, connectionResult2.getErrorCode())) {
            boolean zzpF = zzpF();
        }
        if (!zzpB()) {
            this.zzahL.zzk(connectionResult2);
            this.zzahL.zzqQ();
        }
    }

    public void zzi(Bundle bundle) {
        Bundle bundle2 = bundle;
        while (!this.zzahN.isEmpty()) {
            C0879zza zzb2 = zzb((T) (C0879zza) this.zzahN.remove());
        }
        this.zzahL.zzk(bundle2);
    }

    public void zzoW() {
        if (this.zzahM != null) {
            this.zzahM.zzoW();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zzpB() {
        return this.zzahO;
    }

    /* access modifiers changed from: 0000 */
    public void zzpE() {
        zzc zzc2;
        if (!zzpB()) {
            this.zzahO = true;
            if (this.zzahS == null) {
                Context applicationContext = this.mContext.getApplicationContext();
                zzc zzc3 = zzc2;
                zzc zzc4 = new zzc(this);
                this.zzahS = (zzc) zzn.zza(applicationContext, zzc3, this.zzags);
            }
            boolean sendMessageDelayed = this.zzahR.sendMessageDelayed(this.zzahR.obtainMessage(1), this.zzahP);
            boolean sendMessageDelayed2 = this.zzahR.sendMessageDelayed(this.zzahR.obtainMessage(2), this.zzahQ);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zzpF() {
        if (!zzpB()) {
            return false;
        }
        this.zzahO = false;
        this.zzahR.removeMessages(2);
        this.zzahR.removeMessages(1);
        if (this.zzahS != null) {
            this.zzahS.unregister();
            this.zzahS = null;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean zzpG() {
        this.zzXG.lock();
        try {
            if (this.zzaia == null) {
                this.zzXG.unlock();
                return false;
            }
            boolean z = false;
            if (!this.zzaia.isEmpty()) {
                z = true;
            }
            this.zzXG.unlock();
            return z;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }

    /* access modifiers changed from: 0000 */
    public String zzpH() {
        StringWriter stringWriter;
        PrintWriter printWriter;
        StringWriter stringWriter2 = stringWriter;
        StringWriter stringWriter3 = new StringWriter();
        StringWriter stringWriter4 = stringWriter2;
        String str = LibrariesRepository.MOJANG_MAVEN_REPO;
        PrintWriter printWriter2 = printWriter;
        PrintWriter printWriter3 = new PrintWriter(stringWriter4);
        dump(str, null, printWriter2, null);
        return stringWriter4.toString();
    }

    public <L> zzq<L> zzr(@NonNull L l) {
        zzq zzq;
        L l2 = l;
        Object zzb2 = zzx.zzb(l2, (Object) "Listener must not be null");
        this.zzXG.lock();
        try {
            zzq zzq2 = zzq;
            zzq zzq3 = new zzq(this.zzagr, l2);
            zzq zzq4 = zzq2;
            boolean add = this.zzahV.add(zzq4);
            this.zzXG.unlock();
            return zzq4;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzXG.unlock();
            throw th2;
        }
    }
}
