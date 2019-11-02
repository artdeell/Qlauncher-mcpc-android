package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.internal.zza.C0879zza;
import com.google.android.gms.common.api.internal.zzj;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.api.internal.zzu;
import com.google.android.gms.common.api.internal.zzw;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient {
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    /* access modifiers changed from: private */
    public static final Set<GoogleApiClient> zzagg;

    public static final class Builder {
        private final Context mContext;
        private Account zzTI;
        private String zzUW;
        private final Set<Scope> zzagh;
        private final Set<Scope> zzagi;
        private int zzagj;
        private View zzagk;
        private String zzagl;
        private final Map<Api<?>, com.google.android.gms.common.internal.zzf.zza> zzagm;
        private final Map<Api<?>, ApiOptions> zzagn;
        /* access modifiers changed from: private */
        public FragmentActivity zzago;
        private int zzagp;
        private OnConnectionFailedListener zzagq;
        private Looper zzagr;
        private zzc zzags;
        private com.google.android.gms.common.api.Api.zza<? extends zzrn, zzro> zzagt;
        private final ArrayList<ConnectionCallbacks> zzagu;
        private final ArrayList<OnConnectionFailedListener> zzagv;

        public Builder(@NonNull Context context) {
            HashSet hashSet;
            HashSet hashSet2;
            ArrayMap arrayMap;
            ArrayMap arrayMap2;
            ArrayList<ConnectionCallbacks> arrayList;
            ArrayList<OnConnectionFailedListener> arrayList2;
            Context context2 = context;
            HashSet hashSet3 = hashSet;
            HashSet hashSet4 = new HashSet();
            this.zzagh = hashSet3;
            HashSet hashSet5 = hashSet2;
            HashSet hashSet6 = new HashSet();
            this.zzagi = hashSet5;
            ArrayMap arrayMap3 = arrayMap;
            ArrayMap arrayMap4 = new ArrayMap();
            this.zzagm = arrayMap3;
            ArrayMap arrayMap5 = arrayMap2;
            ArrayMap arrayMap6 = new ArrayMap();
            this.zzagn = arrayMap5;
            this.zzagp = -1;
            this.zzags = zzc.zzoK();
            this.zzagt = zzrl.zzUJ;
            ArrayList<ConnectionCallbacks> arrayList3 = arrayList;
            ArrayList<ConnectionCallbacks> arrayList4 = new ArrayList<>();
            this.zzagu = arrayList3;
            ArrayList<OnConnectionFailedListener> arrayList5 = arrayList2;
            ArrayList<OnConnectionFailedListener> arrayList6 = new ArrayList<>();
            this.zzagv = arrayList5;
            this.mContext = context2;
            this.zzagr = context2.getMainLooper();
            this.zzUW = context2.getPackageName();
            this.zzagl = context2.getClass().getName();
        }

        public Builder(@NonNull Context context, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
            ConnectionCallbacks connectionCallbacks2 = connectionCallbacks;
            OnConnectionFailedListener onConnectionFailedListener2 = onConnectionFailedListener;
            this(context);
            Object zzb = zzx.zzb(connectionCallbacks2, (Object) "Must provide a connected listener");
            boolean add = this.zzagu.add(connectionCallbacks2);
            Object zzb2 = zzx.zzb(onConnectionFailedListener2, (Object) "Must provide a connection failed listener");
            boolean add2 = this.zzagv.add(onConnectionFailedListener2);
        }

        private static <C extends zzb, O> C zza(com.google.android.gms.common.api.Api.zza<C, O> zza, Object obj, Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zza.zza(context, looper, zzf, obj, connectionCallbacks, onConnectionFailedListener);
        }

        private static <C extends zzd, O> zzad zza(zze<C, O> zze, Object obj, Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzad zzad;
            zze<C, O> zze2 = zze;
            zzf zzf2 = zzf;
            ConnectionCallbacks connectionCallbacks2 = connectionCallbacks;
            OnConnectionFailedListener onConnectionFailedListener2 = onConnectionFailedListener;
            zzad zzad2 = zzad;
            zzad zzad3 = new zzad(context, looper, zze2.zzoU(), connectionCallbacks2, onConnectionFailedListener2, zzf2, zze2.zzq(obj));
            return zzad2;
        }

        private <O extends ApiOptions> void zza(Api<O> api, O o, int i, Scope... scopeArr) {
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            HashSet hashSet;
            com.google.android.gms.common.internal.zzf.zza zza;
            Api<O> api2 = api;
            O o2 = o;
            int i2 = i;
            Scope[] scopeArr2 = scopeArr;
            boolean z = true;
            if (i2 != 1) {
                if (i2 == 2) {
                    z = false;
                } else {
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid resolution mode: '").append(i2).append("', use a constant from GoogleApiClient.ResolutionMode").toString());
                    throw illegalArgumentException2;
                }
            }
            HashSet hashSet2 = hashSet;
            HashSet hashSet3 = new HashSet(api2.zzoP().zzo(o2));
            HashSet hashSet4 = hashSet2;
            int length = scopeArr2.length;
            for (int i3 = 0; i3 < length; i3++) {
                boolean add = hashSet4.add(scopeArr2[i3]);
            }
            Map<Api<?>, com.google.android.gms.common.internal.zzf.zza> map = this.zzagm;
            Api<O> api3 = api2;
            com.google.android.gms.common.internal.zzf.zza zza2 = zza;
            com.google.android.gms.common.internal.zzf.zza zza3 = new com.google.android.gms.common.internal.zzf.zza(hashSet4, z);
            Object put = map.put(api3, zza2);
        }

        /* access modifiers changed from: private */
        public void zza(zzw zzw, GoogleApiClient googleApiClient) {
            zzw.zza(this.zzagp, googleApiClient, this.zzagq);
        }

        private void zze(GoogleApiClient googleApiClient) {
            Handler handler;
            C02221 r8;
            GoogleApiClient googleApiClient2 = googleApiClient;
            zzw zza = zzw.zza(this.zzago);
            if (zza == null) {
                Handler handler2 = handler;
                Handler handler3 = new Handler(this.mContext.getMainLooper());
                C02221 r4 = r8;
                final GoogleApiClient googleApiClient3 = googleApiClient2;
                C02221 r5 = new Runnable(this) {
                    final /* synthetic */ Builder zzagw;

                    {
                        GoogleApiClient googleApiClient = r7;
                        this.zzagw = r6;
                    }

                    public void run() {
                        if (!this.zzagw.zzago.isFinishing() && !this.zzagw.zzago.getSupportFragmentManager().isDestroyed()) {
                            this.zzagw.zza(zzw.zzb(this.zzagw.zzago), googleApiClient3);
                        }
                    }
                };
                boolean post = handler2.post(r4);
                return;
            }
            zza(zza, googleApiClient2);
        }

        private GoogleApiClient zzoZ() {
            ArrayMap arrayMap;
            ArrayMap arrayMap2;
            ArrayList arrayList;
            zzj zzj;
            ReentrantLock reentrantLock;
            IllegalStateException illegalStateException;
            StringBuilder sb;
            com.google.android.gms.common.api.internal.zzc zzc;
            zzb zza;
            Api api;
            IllegalStateException illegalStateException2;
            StringBuilder sb2;
            zzf zzoY = zzoY();
            Api api2 = null;
            Map zzqu = zzoY.zzqu();
            ArrayMap arrayMap3 = arrayMap;
            ArrayMap arrayMap4 = new ArrayMap();
            ArrayMap arrayMap5 = arrayMap3;
            ArrayMap arrayMap6 = arrayMap2;
            ArrayMap arrayMap7 = new ArrayMap();
            ArrayMap arrayMap8 = arrayMap6;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList2;
            Api api3 = null;
            for (Api api4 : this.zzagn.keySet()) {
                Object obj = this.zzagn.get(api4);
                int i = 0;
                if (zzqu.get(api4) != null) {
                    i = ((com.google.android.gms.common.internal.zzf.zza) zzqu.get(api4)).zzalf ? 1 : 2;
                }
                Object put = arrayMap5.put(api4, Integer.valueOf(i));
                com.google.android.gms.common.api.internal.zzc zzc2 = zzc;
                com.google.android.gms.common.api.internal.zzc zzc3 = new com.google.android.gms.common.api.internal.zzc(api4, i);
                com.google.android.gms.common.api.internal.zzc zzc4 = zzc2;
                boolean add = arrayList4.add(zzc4);
                if (api4.zzoS()) {
                    zze zzoQ = api4.zzoQ();
                    Api api5 = zzoQ.getPriority() == 1 ? api4 : api3;
                    zza = zza(zzoQ, obj, this.mContext, this.zzagr, zzoY, (ConnectionCallbacks) zzc4, (OnConnectionFailedListener) zzc4);
                    api = api5;
                } else {
                    com.google.android.gms.common.api.Api.zza zzoP = api4.zzoP();
                    Api api6 = zzoP.getPriority() == 1 ? api4 : api3;
                    zza = zza(zzoP, obj, this.mContext, this.zzagr, zzoY, (ConnectionCallbacks) zzc4, (OnConnectionFailedListener) zzc4);
                    api = api6;
                }
                Object put2 = arrayMap8.put(api4.zzoR(), zza);
                if (!zza.zznb()) {
                    api4 = api2;
                } else if (api2 != null) {
                    IllegalStateException illegalStateException3 = illegalStateException2;
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    IllegalStateException illegalStateException4 = new IllegalStateException(sb3.append(api4.getName()).append(" cannot be used with ").append(api2.getName()).toString());
                    throw illegalStateException3;
                }
                api3 = api;
                api2 = api4;
            }
            if (api2 != null) {
                if (api3 != null) {
                    IllegalStateException illegalStateException5 = illegalStateException;
                    StringBuilder sb5 = sb;
                    StringBuilder sb6 = new StringBuilder();
                    IllegalStateException illegalStateException6 = new IllegalStateException(sb5.append(api2.getName()).append(" cannot be used with ").append(api3.getName()).toString());
                    throw illegalStateException5;
                }
                zzx.zza(this.zzTI == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api2.getName());
                zzx.zza(this.zzagh.equals(this.zzagi), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api2.getName());
            }
            int zza2 = zzj.zza(arrayMap8.values(), true);
            zzj zzj2 = zzj;
            Context context = this.mContext;
            ReentrantLock reentrantLock2 = reentrantLock;
            ReentrantLock reentrantLock3 = new ReentrantLock();
            zzj zzj3 = new zzj(context, reentrantLock2, this.zzagr, zzoY, this.zzags, this.zzagt, arrayMap5, this.zzagu, this.zzagv, arrayMap8, this.zzagp, zza2, arrayList4);
            return zzj2;
        }

        public Builder addApi(@NonNull Api<? extends NotRequiredOptions> api) {
            Api<? extends NotRequiredOptions> api2 = api;
            Object zzb = zzx.zzb(api2, (Object) "Api must not be null");
            Object put = this.zzagn.put(api2, null);
            List zzo = api2.zzoP().zzo(null);
            boolean addAll = this.zzagi.addAll(zzo);
            boolean addAll2 = this.zzagh.addAll(zzo);
            return this;
        }

        public <O extends HasOptions> Builder addApi(@NonNull Api<O> api, @NonNull O o) {
            Api<O> api2 = api;
            O o2 = o;
            Object zzb = zzx.zzb(api2, (Object) "Api must not be null");
            Object zzb2 = zzx.zzb(o2, (Object) "Null options are not permitted for this Api");
            Object put = this.zzagn.put(api2, o2);
            List zzo = api2.zzoP().zzo(o2);
            boolean addAll = this.zzagi.addAll(zzo);
            boolean addAll2 = this.zzagh.addAll(zzo);
            return this;
        }

        public <O extends HasOptions> Builder addApiIfAvailable(@NonNull Api<O> api, @NonNull O o, Scope... scopeArr) {
            Api<O> api2 = api;
            O o2 = o;
            Scope[] scopeArr2 = scopeArr;
            Object zzb = zzx.zzb(api2, (Object) "Api must not be null");
            Object zzb2 = zzx.zzb(o2, (Object) "Null options are not permitted for this Api");
            Object put = this.zzagn.put(api2, o2);
            zza(api2, o2, 1, scopeArr2);
            return this;
        }

        public Builder addApiIfAvailable(@NonNull Api<? extends NotRequiredOptions> api, Scope... scopeArr) {
            Api<? extends NotRequiredOptions> api2 = api;
            Scope[] scopeArr2 = scopeArr;
            Object zzb = zzx.zzb(api2, (Object) "Api must not be null");
            Object put = this.zzagn.put(api2, null);
            zza(api2, null, 1, scopeArr2);
            return this;
        }

        public Builder addConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
            ConnectionCallbacks connectionCallbacks2 = connectionCallbacks;
            Object zzb = zzx.zzb(connectionCallbacks2, (Object) "Listener must not be null");
            boolean add = this.zzagu.add(connectionCallbacks2);
            return this;
        }

        public Builder addOnConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
            OnConnectionFailedListener onConnectionFailedListener2 = onConnectionFailedListener;
            Object zzb = zzx.zzb(onConnectionFailedListener2, (Object) "Listener must not be null");
            boolean add = this.zzagv.add(onConnectionFailedListener2);
            return this;
        }

        public Builder addScope(@NonNull Scope scope) {
            Scope scope2 = scope;
            Object zzb = zzx.zzb(scope2, (Object) "Scope must not be null");
            boolean add = this.zzagh.add(scope2);
            return this;
        }

        /* JADX INFO: finally extract failed */
        public GoogleApiClient build() {
            zzx.zzb(!this.zzagn.isEmpty(), (Object) "must call addApi() to add at least one API");
            GoogleApiClient zzoZ = zzoZ();
            Set zzoX = GoogleApiClient.zzagg;
            synchronized (zzoX) {
                try {
                    boolean add = GoogleApiClient.zzagg.add(zzoZ);
                } catch (Throwable th) {
                    while (true) {
                        Throwable th2 = th;
                        Set set = zzoX;
                        throw th2;
                    }
                }
            }
            if (this.zzagp >= 0) {
                zze(zzoZ);
            }
            return zzoZ;
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, int i, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            FragmentActivity fragmentActivity2 = fragmentActivity;
            int i2 = i;
            OnConnectionFailedListener onConnectionFailedListener2 = onConnectionFailedListener;
            zzx.zzb(i2 >= 0, (Object) "clientId must be non-negative");
            this.zzagp = i2;
            this.zzago = (FragmentActivity) zzx.zzb(fragmentActivity2, (Object) "Null activity is not permitted.");
            this.zzagq = onConnectionFailedListener2;
            return this;
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
        }

        public Builder setAccountName(String str) {
            Account account;
            Account account2;
            String str2 = str;
            if (str2 == null) {
                account2 = null;
            } else {
                Account account3 = account;
                Account account4 = new Account(str2, com.google.android.gms.auth.zzd.GOOGLE_ACCOUNT_TYPE);
                account2 = account3;
            }
            this.zzTI = account2;
            return this;
        }

        public Builder setGravityForPopups(int i) {
            this.zzagj = i;
            return this;
        }

        public Builder setHandler(@NonNull Handler handler) {
            Handler handler2 = handler;
            Object zzb = zzx.zzb(handler2, (Object) "Handler must not be null");
            this.zzagr = handler2.getLooper();
            return this;
        }

        public Builder setViewForPopups(@NonNull View view) {
            View view2 = view;
            Object zzb = zzx.zzb(view2, (Object) "View must not be null");
            this.zzagk = view2;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzf zzoY() {
            zzf zzf;
            zzro zzro = zzro.zzbgV;
            if (this.zzagn.containsKey(zzrl.API)) {
                zzro = (zzro) this.zzagn.get(zzrl.API);
            }
            zzf zzf2 = zzf;
            zzf zzf3 = new zzf(this.zzTI, this.zzagh, this.zzagm, this.zzagj, this.zzagk, this.zzUW, this.zzagl, zzro);
            return zzf2;
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    public interface zza {
        void zza(@NonNull ConnectionResult connectionResult);
    }

    static {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2 = weakHashMap;
        WeakHashMap weakHashMap3 = new WeakHashMap();
        zzagg = Collections.newSetFromMap(weakHashMap2);
    }

    public GoogleApiClient() {
    }

    /* JADX INFO: finally extract failed */
    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        StringBuilder sb;
        String str2 = str;
        FileDescriptor fileDescriptor2 = fileDescriptor;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        Set<GoogleApiClient> set = zzagg;
        synchronized (set) {
            try {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                String sb4 = sb2.append(str2).append("  ").toString();
                int i = 0;
                for (GoogleApiClient googleApiClient : zzagg) {
                    int i2 = i + 1;
                    printWriter2.append(str2).append("GoogleApiClient#").println(i);
                    googleApiClient.dump(sb4, fileDescriptor2, printWriter2, strArr2);
                    i = i2;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Set<GoogleApiClient> set2 = set;
                throw th2;
            }
        }
    }

    public static Set<GoogleApiClient> zzoV() {
        return zzagg;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        UnsupportedOperationException unsupportedOperationException;
        int i2 = i;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @NonNull
    public abstract ConnectionResult getConnectionResult(@NonNull Api<?> api);

    public Context getContext() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public Looper getLooper() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public abstract boolean hasConnectedApi(@NonNull Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(@NonNull FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @NonNull
    public <C extends zzb> C zza(@NonNull Api.zzc<C> zzc) {
        UnsupportedOperationException unsupportedOperationException;
        Api.zzc<C> zzc2 = zzc;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public <A extends zzb, R extends Result, T extends C0879zza<R, A>> T zza(@NonNull T t) {
        UnsupportedOperationException unsupportedOperationException;
        T t2 = t;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public void zza(com.google.android.gms.common.api.internal.zzx zzx) {
        UnsupportedOperationException unsupportedOperationException;
        com.google.android.gms.common.api.internal.zzx zzx2 = zzx;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public boolean zza(@NonNull Api<?> api) {
        UnsupportedOperationException unsupportedOperationException;
        Api<?> api2 = api;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public boolean zza(zzu zzu) {
        UnsupportedOperationException unsupportedOperationException;
        zzu zzu2 = zzu;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public <A extends zzb, T extends C0879zza<? extends Result, A>> T zzb(@NonNull T t) {
        UnsupportedOperationException unsupportedOperationException;
        T t2 = t;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public void zzb(com.google.android.gms.common.api.internal.zzx zzx) {
        UnsupportedOperationException unsupportedOperationException;
        com.google.android.gms.common.api.internal.zzx zzx2 = zzx;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public void zzoW() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public <L> zzq<L> zzr(@NonNull L l) {
        UnsupportedOperationException unsupportedOperationException;
        L l2 = l;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }
}
