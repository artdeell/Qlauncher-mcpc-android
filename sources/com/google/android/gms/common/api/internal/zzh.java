package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.zza.C0879zza;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzh implements zzk {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Lock zzXG;
    /* access modifiers changed from: private */
    public final com.google.android.gms.common.zzc zzags;
    private final com.google.android.gms.common.api.Api.zza<? extends zzrn, zzro> zzagt;
    private final Map<Api<?>, Integer> zzahA;
    private ArrayList<Future<?>> zzahB;
    /* access modifiers changed from: private */
    public final zzl zzahj;
    private ConnectionResult zzahm;
    private int zzahn;
    private int zzaho = 0;
    private int zzahp;
    private final Bundle zzahq;
    private final Set<com.google.android.gms.common.api.Api.zzc> zzahr;
    /* access modifiers changed from: private */
    public zzrn zzahs;
    private int zzaht;
    /* access modifiers changed from: private */
    public boolean zzahu;
    private boolean zzahv;
    /* access modifiers changed from: private */
    public zzp zzahw;
    private boolean zzahx;
    private boolean zzahy;
    private final com.google.android.gms.common.internal.zzf zzahz;

    private static class zza implements com.google.android.gms.common.api.GoogleApiClient.zza {
        private final Api<?> zzagT;
        private final int zzagU;
        private final WeakReference<zzh> zzahD;

        public zza(zzh zzh, Api<?> api, int i) {
            WeakReference<zzh> weakReference;
            Api<?> api2 = api;
            int i2 = i;
            WeakReference<zzh> weakReference2 = weakReference;
            WeakReference<zzh> weakReference3 = new WeakReference<>(zzh);
            this.zzahD = weakReference2;
            this.zzagT = api2;
            this.zzagU = i2;
        }

        public void zza(@NonNull ConnectionResult connectionResult) {
            ConnectionResult connectionResult2 = connectionResult;
            zzh zzh = (zzh) this.zzahD.get();
            if (zzh != null) {
                boolean z = false;
                if (Looper.myLooper() == zzh.zzahj.zzagW.getLooper()) {
                    z = true;
                }
                zzx.zza(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                zzh.zzXG.lock();
                try {
                    if (!zzh.zzbz(0)) {
                        zzh.zzXG.unlock();
                        return;
                    }
                    if (!connectionResult2.isSuccess()) {
                        zzh.zzb(connectionResult2, this.zzagT, this.zzagU);
                    }
                    if (zzh.zzpu()) {
                        zzh.zzpv();
                    }
                    zzh.zzXG.unlock();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    zzh.zzXG.unlock();
                    throw th2;
                }
            }
        }
    }

    private class zzb extends zzf {
        final /* synthetic */ zzh zzahC;
        private final Map<com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.api.GoogleApiClient.zza> zzahE;

        public zzb(zzh zzh, Map<com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.api.GoogleApiClient.zza> map) {
            zzh zzh2 = zzh;
            Map<com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.api.GoogleApiClient.zza> map2 = map;
            this.zzahC = zzh2;
            super(zzh2, null);
            this.zzahE = map2;
        }

        @WorkerThread
        public void zzpt() {
            ConnectionResult connectionResult;
            C02291 r11;
            int isGooglePlayServicesAvailable = this.zzahC.zzags.isGooglePlayServicesAvailable(this.zzahC.mContext);
            if (isGooglePlayServicesAvailable != 0) {
                ConnectionResult connectionResult2 = connectionResult;
                ConnectionResult connectionResult3 = new ConnectionResult(isGooglePlayServicesAvailable, null);
                ConnectionResult connectionResult4 = connectionResult2;
                zzl zzd = this.zzahC.zzahj;
                C02291 r6 = r11;
                final ConnectionResult connectionResult5 = connectionResult4;
                C02291 r7 = new zza(this, this.zzahC) {
                    final /* synthetic */ zzb zzahG;

                    {
                        zzk zzk = r8;
                        ConnectionResult connectionResult = r9;
                        this.zzahG = r7;
                    }

                    public void zzpt() {
                        this.zzahG.zzahC.zzg(connectionResult5);
                    }
                };
                zzd.zza((zza) r6);
                return;
            }
            if (this.zzahC.zzahu) {
                this.zzahC.zzahs.connect();
            }
            for (com.google.android.gms.common.api.Api.zzb zzb : this.zzahE.keySet()) {
                zzb.zza((com.google.android.gms.common.api.GoogleApiClient.zza) this.zzahE.get(zzb));
            }
        }
    }

    private class zzc extends zzf {
        final /* synthetic */ zzh zzahC;
        private final ArrayList<com.google.android.gms.common.api.Api.zzb> zzahH;

        public zzc(zzh zzh, ArrayList<com.google.android.gms.common.api.Api.zzb> arrayList) {
            zzh zzh2 = zzh;
            ArrayList<com.google.android.gms.common.api.Api.zzb> arrayList2 = arrayList;
            this.zzahC = zzh2;
            super(zzh2, null);
            this.zzahH = arrayList2;
        }

        @WorkerThread
        public void zzpt() {
            this.zzahC.zzahj.zzagW.zzahU = this.zzahC.zzpA();
            Iterator it = this.zzahH.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.Api.zzb) it.next()).zza(this.zzahC.zzahw, this.zzahC.zzahj.zzagW.zzahU);
            }
        }
    }

    private static class zzd extends com.google.android.gms.signin.internal.zzb {
        private final WeakReference<zzh> zzahD;

        zzd(zzh zzh) {
            WeakReference<zzh> weakReference;
            WeakReference<zzh> weakReference2 = weakReference;
            WeakReference<zzh> weakReference3 = new WeakReference<>(zzh);
            this.zzahD = weakReference2;
        }

        @BinderThread
        public void zzb(SignInResponse signInResponse) {
            C02301 r10;
            SignInResponse signInResponse2 = signInResponse;
            zzh zzh = (zzh) this.zzahD.get();
            if (zzh != null) {
                zzl zzd = zzh.zzahj;
                C02301 r4 = r10;
                final zzh zzh2 = zzh;
                final SignInResponse signInResponse3 = signInResponse2;
                C02301 r5 = new zza(this, zzh) {
                    final /* synthetic */ zzd zzahK;

                    {
                        zzk zzk = r9;
                        zzh zzh = r10;
                        SignInResponse signInResponse = r11;
                        this.zzahK = r8;
                    }

                    public void zzpt() {
                        zzh2.zza(signInResponse3);
                    }
                };
                zzd.zza((zza) r4);
            }
        }
    }

    private class zze implements ConnectionCallbacks, OnConnectionFailedListener {
        final /* synthetic */ zzh zzahC;

        private zze(zzh zzh) {
            this.zzahC = zzh;
        }

        /* synthetic */ zze(zzh zzh, C02281 r7) {
            C02281 r2 = r7;
            this(zzh);
        }

        public void onConnected(Bundle bundle) {
            zzd zzd;
            Bundle bundle2 = bundle;
            zzrn zzf = this.zzahC.zzahs;
            zzd zzd2 = zzd;
            zzd zzd3 = new zzd(this.zzahC);
            zzf.zza(zzd2);
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            ConnectionResult connectionResult2 = connectionResult;
            this.zzahC.zzXG.lock();
            try {
                if (this.zzahC.zzf(connectionResult2)) {
                    this.zzahC.zzpy();
                    this.zzahC.zzpv();
                } else {
                    this.zzahC.zzg(connectionResult2);
                }
                this.zzahC.zzXG.unlock();
            } catch (Throwable th) {
                Throwable th2 = th;
                this.zzahC.zzXG.unlock();
                throw th2;
            }
        }

        public void onConnectionSuspended(int i) {
        }
    }

    private abstract class zzf implements Runnable {
        final /* synthetic */ zzh zzahC;

        private zzf(zzh zzh) {
            this.zzahC = zzh;
        }

        /* synthetic */ zzf(zzh zzh, C02281 r7) {
            C02281 r2 = r7;
            this(zzh);
        }

        @WorkerThread
        public void run() {
            this.zzahC.zzXG.lock();
            try {
                if (Thread.interrupted()) {
                    this.zzahC.zzXG.unlock();
                    return;
                }
                zzpt();
                this.zzahC.zzXG.unlock();
            } catch (RuntimeException e) {
                this.zzahC.zzahj.zza(e);
                this.zzahC.zzXG.unlock();
            } catch (Throwable th) {
                Throwable th2 = th;
                this.zzahC.zzXG.unlock();
                throw th2;
            }
        }

        /* access modifiers changed from: protected */
        @WorkerThread
        public abstract void zzpt();
    }

    public zzh(zzl zzl, com.google.android.gms.common.internal.zzf zzf2, Map<Api<?>, Integer> map, com.google.android.gms.common.zzc zzc2, com.google.android.gms.common.api.Api.zza<? extends zzrn, zzro> zza2, Lock lock, Context context) {
        Bundle bundle;
        HashSet hashSet;
        ArrayList<Future<?>> arrayList;
        zzl zzl2 = zzl;
        com.google.android.gms.common.internal.zzf zzf3 = zzf2;
        Map<Api<?>, Integer> map2 = map;
        com.google.android.gms.common.zzc zzc3 = zzc2;
        com.google.android.gms.common.api.Api.zza<? extends zzrn, zzro> zza3 = zza2;
        Lock lock2 = lock;
        Context context2 = context;
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        this.zzahq = bundle2;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        this.zzahr = hashSet2;
        ArrayList<Future<?>> arrayList2 = arrayList;
        ArrayList<Future<?>> arrayList3 = new ArrayList<>();
        this.zzahB = arrayList2;
        this.zzahj = zzl2;
        this.zzahz = zzf3;
        this.zzahA = map2;
        this.zzags = zzc3;
        this.zzagt = zza3;
        this.zzXG = lock2;
        this.mContext = context2;
    }

    private void zzZ(boolean z) {
        boolean z2 = z;
        if (this.zzahs != null) {
            if (this.zzahs.isConnected() && z2) {
                this.zzahs.zzFG();
            }
            this.zzahs.disconnect();
            this.zzahw = null;
        }
    }

    /* access modifiers changed from: private */
    public void zza(SignInResponse signInResponse) {
        StringBuilder sb;
        Exception exc;
        SignInResponse signInResponse2 = signInResponse;
        if (zzbz(0)) {
            ConnectionResult zzqY = signInResponse2.zzqY();
            if (zzqY.isSuccess()) {
                ResolveAccountResponse zzFP = signInResponse2.zzFP();
                ConnectionResult zzqY2 = zzFP.zzqY();
                if (!zzqY2.isSuccess()) {
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    String sb4 = sb2.append("Sign-in succeeded with resolve account failure: ").append(zzqY2).toString();
                    Exception exc2 = exc;
                    Exception exc3 = new Exception();
                    int wtf = Log.wtf("GoogleApiClientConnecting", sb4, exc2);
                    zzg(zzqY2);
                    return;
                }
                this.zzahv = true;
                this.zzahw = zzFP.zzqX();
                this.zzahx = zzFP.zzqZ();
                this.zzahy = zzFP.zzra();
                zzpv();
            } else if (zzf(zzqY)) {
                zzpy();
                zzpv();
            } else {
                zzg(zzqY);
            }
        }
    }

    private boolean zza(int i, int i2, ConnectionResult connectionResult) {
        return (i2 != 1 || zze(connectionResult)) && (this.zzahm == null || i < this.zzahn);
    }

    /* access modifiers changed from: private */
    public void zzb(ConnectionResult connectionResult, Api<?> api, int i) {
        ConnectionResult connectionResult2 = connectionResult;
        Api<?> api2 = api;
        int i2 = i;
        if (i2 != 2) {
            int priority = api2.zzoP().getPriority();
            if (zza(priority, i2, connectionResult2)) {
                this.zzahm = connectionResult2;
                this.zzahn = priority;
            }
        }
        Object put = this.zzahj.zzaio.put(api2.zzoR(), connectionResult2);
    }

    private String zzbA(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    /* access modifiers changed from: private */
    public boolean zzbz(int i) {
        StringBuilder sb;
        Exception exc;
        ConnectionResult connectionResult;
        int i2 = i;
        if (this.zzaho == i2) {
            return true;
        }
        int i3 = Log.i("GoogleApiClientConnecting", this.zzahj.zzagW.zzpH());
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        String sb4 = sb2.append("GoogleApiClient connecting is in step ").append(zzbA(this.zzaho)).append(" but received callback for step ").append(zzbA(i2)).toString();
        Exception exc2 = exc;
        Exception exc3 = new Exception();
        int wtf = Log.wtf("GoogleApiClientConnecting", sb4, exc2);
        ConnectionResult connectionResult2 = connectionResult;
        ConnectionResult connectionResult3 = new ConnectionResult(8, null);
        zzg(connectionResult2);
        return false;
    }

    private boolean zze(ConnectionResult connectionResult) {
        ConnectionResult connectionResult2 = connectionResult;
        return connectionResult2.hasResolution() || this.zzags.zzbu(connectionResult2.getErrorCode()) != null;
    }

    /* access modifiers changed from: private */
    public boolean zzf(ConnectionResult connectionResult) {
        return this.zzaht == 2 || (this.zzaht == 1 && !connectionResult.hasResolution());
    }

    /* access modifiers changed from: private */
    public void zzg(ConnectionResult connectionResult) {
        ConnectionResult connectionResult2 = connectionResult;
        zzpz();
        zzZ(!connectionResult2.hasResolution());
        this.zzahj.zzh(connectionResult2);
        this.zzahj.zzais.zzd(connectionResult2);
    }

    /* access modifiers changed from: private */
    public Set<Scope> zzpA() {
        HashSet hashSet;
        if (this.zzahz == null) {
            return Collections.emptySet();
        }
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet(this.zzahz.zzqs());
        HashSet hashSet4 = hashSet2;
        Map zzqu = this.zzahz.zzqu();
        for (Api api : zzqu.keySet()) {
            if (!this.zzahj.zzaio.containsKey(api.zzoR())) {
                boolean addAll = hashSet4.addAll(((com.google.android.gms.common.internal.zzf.zza) zzqu.get(api)).zzXf);
            }
        }
        return hashSet4;
    }

    /* access modifiers changed from: private */
    public boolean zzpu() {
        Exception exc;
        ConnectionResult connectionResult;
        this.zzahp = -1 + this.zzahp;
        if (this.zzahp > 0) {
            return false;
        }
        if (this.zzahp < 0) {
            int i = Log.i("GoogleApiClientConnecting", this.zzahj.zzagW.zzpH());
            Exception exc2 = exc;
            Exception exc3 = new Exception();
            int wtf = Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", exc2);
            ConnectionResult connectionResult2 = connectionResult;
            ConnectionResult connectionResult3 = new ConnectionResult(8, null);
            zzg(connectionResult2);
            return false;
        } else if (this.zzahm == null) {
            return true;
        } else {
            this.zzahj.zzair = this.zzahn;
            zzg(this.zzahm);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void zzpv() {
        if (this.zzahp == 0) {
            if (!this.zzahu || this.zzahv) {
                zzpw();
            }
        }
    }

    private void zzpw() {
        ArrayList arrayList;
        zzc zzc2;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        this.zzaho = 1;
        this.zzahp = this.zzahj.zzahT.size();
        for (com.google.android.gms.common.api.Api.zzc zzc3 : this.zzahj.zzahT.keySet()) {
            if (!this.zzahj.zzaio.containsKey(zzc3)) {
                boolean add = arrayList4.add(this.zzahj.zzahT.get(zzc3));
            } else if (zzpu()) {
                zzpx();
            }
        }
        if (!arrayList4.isEmpty()) {
            ArrayList<Future<?>> arrayList5 = this.zzahB;
            ExecutorService zzpN = zzm.zzpN();
            zzc zzc4 = zzc2;
            zzc zzc5 = new zzc(this, arrayList4);
            boolean add2 = arrayList5.add(zzpN.submit(zzc4));
        }
    }

    private void zzpx() {
        C02281 r8;
        this.zzahj.zzpL();
        ExecutorService zzpN = zzm.zzpN();
        C02281 r5 = r8;
        C02281 r6 = new Runnable(this) {
            final /* synthetic */ zzh zzahC;

            {
                this.zzahC = r5;
            }

            public void run() {
                this.zzahC.zzags.zzal(this.zzahC.mContext);
            }
        };
        zzpN.execute(r5);
        if (this.zzahs != null) {
            if (this.zzahx) {
                this.zzahs.zza(this.zzahw, this.zzahy);
            }
            zzZ(false);
        }
        for (com.google.android.gms.common.api.Api.zzc zzc2 : this.zzahj.zzaio.keySet()) {
            ((com.google.android.gms.common.api.Api.zzb) this.zzahj.zzahT.get(zzc2)).disconnect();
        }
        this.zzahj.zzais.zzi(this.zzahq.isEmpty() ? null : this.zzahq);
    }

    /* access modifiers changed from: private */
    public void zzpy() {
        ConnectionResult connectionResult;
        this.zzahu = false;
        this.zzahj.zzagW.zzahU = Collections.emptySet();
        for (com.google.android.gms.common.api.Api.zzc zzc2 : this.zzahr) {
            if (!this.zzahj.zzaio.containsKey(zzc2)) {
                Map<com.google.android.gms.common.api.Api.zzc<?>, ConnectionResult> map = this.zzahj.zzaio;
                com.google.android.gms.common.api.Api.zzc zzc3 = zzc2;
                ConnectionResult connectionResult2 = connectionResult;
                ConnectionResult connectionResult3 = new ConnectionResult(17, null);
                Object put = map.put(zzc3, connectionResult2);
            }
        }
    }

    private void zzpz() {
        Iterator it = this.zzahB.iterator();
        while (it.hasNext()) {
            boolean cancel = ((Future) it.next()).cancel(true);
        }
        this.zzahB.clear();
    }

    public void begin() {
        HashMap hashMap;
        boolean z;
        zzb zzb2;
        zze zze2;
        zza zza2;
        this.zzahj.zzaio.clear();
        this.zzahu = false;
        this.zzahm = null;
        this.zzaho = 0;
        this.zzaht = 2;
        this.zzahv = false;
        this.zzahx = false;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = hashMap2;
        Iterator it = this.zzahA.keySet().iterator();
        boolean z2 = false;
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            Api api = (Api) it.next();
            com.google.android.gms.common.api.Api.zzb zzb3 = (com.google.android.gms.common.api.Api.zzb) this.zzahj.zzahT.get(api.zzoR());
            int intValue = ((Integer) this.zzahA.get(api)).intValue();
            boolean z3 = (api.zzoP().getPriority() == 1) | z;
            if (zzb3.zzmE()) {
                this.zzahu = true;
                if (intValue < this.zzaht) {
                    this.zzaht = intValue;
                }
                if (intValue != 0) {
                    boolean add = this.zzahr.add(api.zzoR());
                }
            }
            HashMap hashMap5 = hashMap4;
            com.google.android.gms.common.api.Api.zzb zzb4 = zzb3;
            zza zza3 = zza2;
            zza zza4 = new zza(this, api, intValue);
            Object put = hashMap5.put(zzb4, zza3);
            z2 = z3;
        }
        if (z) {
            this.zzahu = false;
        }
        if (this.zzahu) {
            this.zzahz.zza(Integer.valueOf(this.zzahj.zzagW.getSessionId()));
            zze zze3 = zze2;
            zze zze4 = new zze(this, null);
            zze zze5 = zze3;
            this.zzahs = (zzrn) this.zzagt.zza(this.mContext, this.zzahj.zzagW.getLooper(), this.zzahz, this.zzahz.zzqy(), zze5, zze5);
        }
        this.zzahp = this.zzahj.zzahT.size();
        ArrayList<Future<?>> arrayList = this.zzahB;
        ExecutorService zzpN = zzm.zzpN();
        zzb zzb5 = zzb2;
        zzb zzb6 = new zzb(this, hashMap4);
        boolean add2 = arrayList.add(zzpN.submit(zzb5));
    }

    public void connect() {
    }

    public boolean disconnect() {
        zzpz();
        zzZ(true);
        this.zzahj.zzh(null);
        return true;
    }

    public void onConnected(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (zzbz(1)) {
            if (bundle2 != null) {
                this.zzahq.putAll(bundle2);
            }
            if (zzpu()) {
                zzpx();
            }
        }
    }

    public void onConnectionSuspended(int i) {
        ConnectionResult connectionResult;
        int i2 = i;
        ConnectionResult connectionResult2 = connectionResult;
        ConnectionResult connectionResult3 = new ConnectionResult(8, null);
        zzg(connectionResult2);
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends C0879zza<R, A>> T zza(T t) {
        T t2 = t;
        boolean add = this.zzahj.zzagW.zzahN.add(t2);
        return t2;
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        ConnectionResult connectionResult2 = connectionResult;
        Api<?> api2 = api;
        int i2 = i;
        if (zzbz(1)) {
            zzb(connectionResult2, api2, i2);
            if (zzpu()) {
                zzpx();
            }
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends C0879zza<? extends Result, A>> T zzb(T t) {
        IllegalStateException illegalStateException;
        T t2 = t;
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("GoogleApiClient is not connected yet.");
        throw illegalStateException2;
    }
}
