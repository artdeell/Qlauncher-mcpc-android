package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzj<T extends IInterface> implements com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.internal.zzk.zza {
    public static final String[] zzalJ;
    private final Context mContext;
    final Handler mHandler;
    private final Account zzTI;
    /* access modifiers changed from: private */
    public final Set<Scope> zzXf;
    private final Looper zzagr;
    private final com.google.android.gms.common.zzc zzags;
    private final zzf zzahz;
    /* access modifiers changed from: private */
    public com.google.android.gms.common.api.GoogleApiClient.zza zzalA;
    private T zzalB;
    /* access modifiers changed from: private */
    public final ArrayList<zzc<?>> zzalC;
    private zze zzalD;
    private int zzalE;
    /* access modifiers changed from: private */
    public final ConnectionCallbacks zzalF;
    /* access modifiers changed from: private */
    public final OnConnectionFailedListener zzalG;
    private final int zzalH;
    protected AtomicInteger zzalI;
    private int zzals;
    private long zzalt;
    private long zzalu;
    private int zzalv;
    private long zzalw;
    private final zzl zzalx;
    /* access modifiers changed from: private */
    public final Object zzaly;
    private zzs zzalz;
    private final Object zzpV;

    private abstract class zza extends zzc<Boolean> {
        public final int statusCode;
        public final Bundle zzalK;
        final /* synthetic */ zzj zzalL;

        @BinderThread
        protected zza(zzj zzj, int i, Bundle bundle) {
            zzj zzj2 = zzj;
            int i2 = i;
            Bundle bundle2 = bundle;
            this.zzalL = zzj2;
            super(zzj2, Boolean.valueOf(true));
            this.statusCode = i2;
            this.zzalK = bundle2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzc */
        public void zzw(Boolean bool) {
            IllegalStateException illegalStateException;
            ConnectionResult connectionResult;
            ConnectionResult connectionResult2;
            if (bool == null) {
                this.zzalL.zzb(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!zzqL()) {
                        this.zzalL.zzb(1, null);
                        ConnectionResult connectionResult3 = connectionResult;
                        ConnectionResult connectionResult4 = new ConnectionResult(8, null);
                        zzj(connectionResult3);
                        return;
                    }
                    return;
                case 10:
                    this.zzalL.zzb(1, null);
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                    throw illegalStateException2;
                default:
                    this.zzalL.zzb(1, null);
                    PendingIntent pendingIntent = null;
                    if (this.zzalK != null) {
                        pendingIntent = (PendingIntent) this.zzalK.getParcelable("pendingIntent");
                    }
                    ConnectionResult connectionResult5 = connectionResult2;
                    ConnectionResult connectionResult6 = new ConnectionResult(this.statusCode, pendingIntent);
                    zzj(connectionResult5);
                    return;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzj(ConnectionResult connectionResult);

        /* access modifiers changed from: protected */
        public abstract boolean zzqL();

        /* access modifiers changed from: protected */
        public void zzqM() {
        }
    }

    final class zzb extends Handler {
        final /* synthetic */ zzj zzalL;

        public zzb(zzj zzj, Looper looper) {
            Looper looper2 = looper;
            this.zzalL = zzj;
            super(looper2);
        }

        private void zza(Message message) {
            zzc zzc = (zzc) message.obj;
            zzc.zzqM();
            zzc.unregister();
        }

        private boolean zzb(Message message) {
            Message message2 = message;
            return message2.what == 2 || message2.what == 1 || message2.what == 5;
        }

        public void handleMessage(Message message) {
            StringBuilder sb;
            Exception exc;
            ConnectionResult connectionResult;
            Message message2 = message;
            if (this.zzalL.zzalI.get() != message2.arg1) {
                if (zzb(message2)) {
                    zza(message2);
                }
            } else if ((message2.what == 1 || message2.what == 5) && !this.zzalL.isConnecting()) {
                zza(message2);
            } else if (message2.what == 3) {
                ConnectionResult connectionResult2 = connectionResult;
                ConnectionResult connectionResult3 = new ConnectionResult(message2.arg2, null);
                ConnectionResult connectionResult4 = connectionResult2;
                this.zzalL.zzalA.zza(connectionResult4);
                this.zzalL.onConnectionFailed(connectionResult4);
            } else if (message2.what == 4) {
                this.zzalL.zzb(4, null);
                if (this.zzalL.zzalF != null) {
                    this.zzalL.zzalF.onConnectionSuspended(message2.arg2);
                }
                this.zzalL.onConnectionSuspended(message2.arg2);
                boolean zza = this.zzalL.zza(4, 1, null);
            } else if (message2.what == 2 && !this.zzalL.isConnected()) {
                zza(message2);
            } else if (zzb(message2)) {
                ((zzc) message2.obj).zzqN();
            } else {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                String sb4 = sb2.append("Don't know how to handle message: ").append(message2.what).toString();
                Exception exc2 = exc;
                Exception exc3 = new Exception();
                int wtf = Log.wtf("GmsClient", sb4, exc2);
            }
        }
    }

    protected abstract class zzc<TListener> {
        private TListener mListener;
        final /* synthetic */ zzj zzalL;
        private boolean zzalM = false;

        public zzc(zzj zzj, TListener tlistener) {
            TListener tlistener2 = tlistener;
            this.zzalL = zzj;
            this.mListener = tlistener2;
        }

        public void unregister() {
            zzqO();
            ArrayList zzd = this.zzalL.zzalC;
            synchronized (zzd) {
                try {
                    boolean remove = this.zzalL.zzalC.remove(this);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    ArrayList arrayList = zzd;
                    throw th2;
                }
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzqM();

        public void zzqN() {
            StringBuilder sb;
            synchronized (this) {
                try {
                    th = this.mListener;
                    if (this.zzalM) {
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        int w = Log.w("GmsClient", sb2.append("Callback proxy ").append(this).append(" being reused. This is not safe.").toString());
                    }
                } finally {
                    while (true) {
                        Throwable th = th;
                        Throwable th2 = th;
                    }
                }
            }
            if (th != null) {
                try {
                    zzw(th);
                } catch (RuntimeException e) {
                    RuntimeException runtimeException = e;
                    zzqM();
                    throw runtimeException;
                }
            } else {
                zzqM();
            }
            synchronized (this) {
                try {
                    this.zzalM = true;
                } catch (Throwable th3) {
                    while (true) {
                        Throwable th4 = th3;
                        throw th4;
                    }
                }
            }
            unregister();
        }

        public void zzqO() {
            synchronized (this) {
                try {
                    this.mListener = null;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzw(TListener tlistener);
    }

    public static final class zzd extends com.google.android.gms.common.internal.zzr.zza {
        private zzj zzalN;
        private final int zzalO;

        public zzd(@NonNull zzj zzj, int i) {
            int i2 = i;
            this.zzalN = zzj;
            this.zzalO = i2;
        }

        private void zzqP() {
            this.zzalN = null;
        }

        @BinderThread
        public void zza(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            int i2 = i;
            IBinder iBinder2 = iBinder;
            Bundle bundle2 = bundle;
            Object zzb = zzx.zzb(this.zzalN, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.zzalN.zza(i2, iBinder2, bundle2, this.zzalO);
            zzqP();
        }

        @BinderThread
        public void zzb(int i, @Nullable Bundle bundle) {
            Exception exc;
            int i2 = i;
            Bundle bundle2 = bundle;
            Exception exc2 = exc;
            Exception exc3 = new Exception();
            int wtf = Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", exc2);
        }
    }

    public final class zze implements ServiceConnection {
        final /* synthetic */ zzj zzalL;
        private final int zzalO;

        public zze(zzj zzj, int i) {
            int i2 = i;
            this.zzalL = zzj;
            this.zzalO = i2;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ComponentName componentName2 = componentName;
            IBinder iBinder2 = iBinder;
            Object zzb = zzx.zzb(iBinder2, (Object) "Expecting a valid IBinder");
            Object zza = this.zzalL.zzaly;
            synchronized (zza) {
                try {
                    zzs zza2 = zzj.zza(this.zzalL, com.google.android.gms.common.internal.zzs.zza.zzaS(iBinder2));
                } catch (Throwable th) {
                    while (true) {
                        Throwable th2 = th;
                        Object obj = zza;
                        throw th2;
                    }
                }
            }
            this.zzalL.zzm(0, this.zzalO);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            ComponentName componentName2 = componentName;
            Object zza = this.zzalL.zzaly;
            synchronized (zza) {
                try {
                    zzs zza2 = zzj.zza(this.zzalL, (zzs) null);
                } catch (Throwable th) {
                    while (true) {
                        Throwable th2 = th;
                        Object obj = zza;
                        throw th2;
                    }
                }
            }
            boolean sendMessage = this.zzalL.mHandler.sendMessage(this.zzalL.mHandler.obtainMessage(4, this.zzalO, 1));
        }
    }

    protected class zzf implements com.google.android.gms.common.api.GoogleApiClient.zza {
        final /* synthetic */ zzj zzalL;

        public zzf(zzj zzj) {
            this.zzalL = zzj;
        }

        public void zza(@NonNull ConnectionResult connectionResult) {
            ConnectionResult connectionResult2 = connectionResult;
            if (connectionResult2.isSuccess()) {
                this.zzalL.zza((zzp) null, this.zzalL.zzXf);
            } else if (this.zzalL.zzalG != null) {
                this.zzalL.zzalG.onConnectionFailed(connectionResult2);
            }
        }
    }

    protected final class zzg extends zza {
        final /* synthetic */ zzj zzalL;
        public final IBinder zzalP;

        @BinderThread
        public zzg(zzj zzj, int i, IBinder iBinder, Bundle bundle) {
            zzj zzj2 = zzj;
            int i2 = i;
            IBinder iBinder2 = iBinder;
            Bundle bundle2 = bundle;
            this.zzalL = zzj2;
            super(zzj2, i2, bundle2);
            this.zzalP = iBinder2;
        }

        /* access modifiers changed from: protected */
        public void zzj(ConnectionResult connectionResult) {
            ConnectionResult connectionResult2 = connectionResult;
            if (this.zzalL.zzalG != null) {
                this.zzalL.zzalG.onConnectionFailed(connectionResult2);
            }
            this.zzalL.onConnectionFailed(connectionResult2);
        }

        /* access modifiers changed from: protected */
        public boolean zzqL() {
            StringBuilder sb;
            try {
                String interfaceDescriptor = this.zzalP.getInterfaceDescriptor();
                if (!this.zzalL.zzgv().equals(interfaceDescriptor)) {
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int e = Log.e("GmsClient", sb2.append("service descriptor mismatch: ").append(this.zzalL.zzgv()).append(" vs. ").append(interfaceDescriptor).toString());
                } else {
                    IInterface zzW = this.zzalL.zzW(this.zzalP);
                    if (zzW != null && this.zzalL.zza(2, 3, zzW)) {
                        Bundle zzoi = this.zzalL.zzoi();
                        if (this.zzalL.zzalF != null) {
                            this.zzalL.zzalF.onConnected(zzoi);
                        }
                        return true;
                    }
                }
                return false;
            } catch (RemoteException e2) {
                RemoteException remoteException = e2;
                int w = Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class zzh extends zza {
        final /* synthetic */ zzj zzalL;

        @BinderThread
        public zzh(zzj zzj, int i) {
            zzj zzj2 = zzj;
            int i2 = i;
            this.zzalL = zzj2;
            super(zzj2, i2, null);
        }

        /* access modifiers changed from: protected */
        public void zzj(ConnectionResult connectionResult) {
            ConnectionResult connectionResult2 = connectionResult;
            this.zzalL.zzalA.zza(connectionResult2);
            this.zzalL.onConnectionFailed(connectionResult2);
        }

        /* access modifiers changed from: protected */
        public boolean zzqL() {
            this.zzalL.zzalA.zza(ConnectionResult.zzafB);
            return true;
        }
    }

    static {
        String[] strArr = new String[2];
        String[] strArr2 = strArr;
        strArr[0] = "service_esmobile";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "service_googleme";
        zzalJ = strArr4;
    }

    protected zzj(Context context, Looper looper, int i, zzf zzf2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        Context context2 = context;
        this(context2, looper, zzl.zzau(context2), com.google.android.gms.common.zzc.zzoK(), i, zzf2, (ConnectionCallbacks) zzx.zzz(connectionCallbacks), (OnConnectionFailedListener) zzx.zzz(onConnectionFailedListener));
    }

    protected zzj(Context context, Looper looper, zzl zzl, com.google.android.gms.common.zzc zzc2, int i, zzf zzf2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        Object obj;
        Object obj2;
        zzf zzf3;
        ArrayList<zzc<?>> arrayList;
        AtomicInteger atomicInteger;
        zzb zzb2;
        Context context2 = context;
        Looper looper2 = looper;
        zzl zzl2 = zzl;
        com.google.android.gms.common.zzc zzc3 = zzc2;
        int i2 = i;
        zzf zzf4 = zzf2;
        ConnectionCallbacks connectionCallbacks2 = connectionCallbacks;
        OnConnectionFailedListener onConnectionFailedListener2 = onConnectionFailedListener;
        Object obj3 = obj;
        Object obj4 = new Object();
        this.zzpV = obj3;
        Object obj5 = obj2;
        Object obj6 = new Object();
        this.zzaly = obj5;
        zzf zzf5 = zzf3;
        zzf zzf6 = new zzf(this);
        this.zzalA = zzf5;
        ArrayList<zzc<?>> arrayList2 = arrayList;
        ArrayList<zzc<?>> arrayList3 = new ArrayList<>();
        this.zzalC = arrayList2;
        this.zzalE = 1;
        AtomicInteger atomicInteger2 = atomicInteger;
        AtomicInteger atomicInteger3 = new AtomicInteger(0);
        this.zzalI = atomicInteger2;
        this.mContext = (Context) zzx.zzb(context2, (Object) "Context must not be null");
        this.zzagr = (Looper) zzx.zzb(looper2, (Object) "Looper must not be null");
        this.zzalx = (zzl) zzx.zzb(zzl2, (Object) "Supervisor must not be null");
        this.zzags = (com.google.android.gms.common.zzc) zzx.zzb(zzc3, (Object) "API availability must not be null");
        zzb zzb3 = zzb2;
        zzb zzb4 = new zzb(this, looper2);
        this.mHandler = zzb3;
        this.zzalH = i2;
        this.zzahz = (zzf) zzx.zzz(zzf4);
        this.zzTI = zzf4.getAccount();
        this.zzXf = zza(zzf4.zzqt());
        this.zzalF = connectionCallbacks2;
        this.zzalG = onConnectionFailedListener2;
    }

    static /* synthetic */ zzs zza(zzj zzj, zzs zzs) {
        zzs zzs2 = zzs;
        zzj.zzalz = zzs2;
        return zzs2;
    }

    private Set<Scope> zza(Set<Scope> set) {
        IllegalStateException illegalStateException;
        Set<Scope> set2 = set;
        Set<Scope> zzb2 = zzb(set2);
        if (zzb2 == null) {
            return zzb2;
        }
        for (Scope contains : zzb2) {
            if (!set2.contains(contains)) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
                throw illegalStateException2;
            }
        }
        return zzb2;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public boolean zza(int i, int i2, T t) {
        int i3 = i;
        int i4 = i2;
        T t2 = t;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzalE != i3) {
                    return false;
                }
                zzb(i4, t2);
                return true;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: private */
    public void zzb(int i, T t) {
        int i2 = i;
        T t2 = t;
        boolean z = true;
        if ((i2 == 3) != (t2 != null)) {
            z = false;
        }
        zzx.zzac(z);
        t2 = this.zzpV;
        synchronized (t2) {
            try {
                this.zzalE = i2;
                this.zzalB = t2;
                zzc(i2, t2);
                switch (i2) {
                    case 1:
                        zzqF();
                        break;
                    case 2:
                        zzqE();
                        break;
                    case 3:
                        zza(t2);
                        break;
                }
            } finally {
                Throwable th = th;
                T t3 = t2;
                Throwable th2 = th;
            }
        }
    }

    private void zzqE() {
        zze zze2;
        StringBuilder sb;
        StringBuilder sb2;
        if (this.zzalD != null) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            int e = Log.e("GmsClient", sb3.append("Calling connect() while still connected, missing disconnect() for ").append(zzgu()).toString());
            this.zzalx.zzb(zzgu(), (ServiceConnection) this.zzalD, zzqD());
            int incrementAndGet = this.zzalI.incrementAndGet();
        }
        zze zze3 = zze2;
        zze zze4 = new zze<>(this, this.zzalI.get());
        this.zzalD = zze3;
        if (!this.zzalx.zza(zzgu(), (ServiceConnection) this.zzalD, zzqD())) {
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            int e2 = Log.e("GmsClient", sb5.append("unable to connect to service: ").append(zzgu()).toString());
            zzm(8, this.zzalI.get());
        }
    }

    private void zzqF() {
        if (this.zzalD != null) {
            this.zzalx.zzb(zzgu(), (ServiceConnection) this.zzalD, zzqD());
            this.zzalD = null;
        }
    }

    public void disconnect() {
        int incrementAndGet = this.zzalI.incrementAndGet();
        int i = this.zzalC;
        synchronized (i) {
            try {
                i = this.zzalC.size();
                for (int i2 = 0; th < i; i2 = th + 1) {
                    ((zzc) this.zzalC.get(th)).zzqO();
                }
                this.zzalC.clear();
            } finally {
                while (true) {
                    int i3 = th;
                    int i4 = i;
                    Throwable th = i3;
                }
            }
        }
        Object obj = this.zzaly;
        synchronized (obj) {
            try {
                this.zzalz = null;
            } catch (Throwable th2) {
                while (true) {
                    Throwable th3 = th2;
                    Object obj2 = obj;
                    throw th3;
                }
            }
        }
        zzb(1, null);
    }

    /* JADX INFO: finally extract failed */
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        SimpleDateFormat simpleDateFormat;
        StringBuilder sb;
        Date date;
        StringBuilder sb2;
        Date date2;
        StringBuilder sb3;
        Date date3;
        String str2 = str;
        FileDescriptor fileDescriptor2 = fileDescriptor;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                i = this.zzalE;
                t = this.zzalB;
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
        PrintWriter append = printWriter2.append(str2).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter2.print("DISCONNECTED");
                break;
            case 2:
                printWriter2.print("CONNECTING");
                break;
            case 3:
                printWriter2.print("CONNECTED");
                break;
            case 4:
                printWriter2.print("DISCONNECTING");
                break;
            default:
                printWriter2.print("UNKNOWN");
                break;
        }
        PrintWriter append2 = printWriter2.append(" mService=");
        if (t == null) {
            printWriter2.println("null");
        } else {
            printWriter2.append(zzgv()).append("@").println(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        SimpleDateFormat simpleDateFormat4 = simpleDateFormat2;
        if (this.zzalu > 0) {
            PrintWriter append3 = printWriter2.append(str2).append("lastConnectedTime=");
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            StringBuilder append4 = sb4.append(this.zzalu).append(" ");
            SimpleDateFormat simpleDateFormat5 = simpleDateFormat4;
            Date date4 = date3;
            Date date5 = new Date(this.zzalu);
            append3.println(append4.append(simpleDateFormat5.format(date4)).toString());
        }
        if (this.zzalt > 0) {
            PrintWriter append5 = printWriter2.append(str2).append("lastSuspendedCause=");
            switch (this.zzals) {
                case 1:
                    PrintWriter append6 = printWriter2.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    PrintWriter append7 = printWriter2.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    PrintWriter append8 = printWriter2.append(String.valueOf(this.zzals));
                    break;
            }
            PrintWriter append9 = printWriter2.append(" lastSuspendedTime=");
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            StringBuilder append10 = sb6.append(this.zzalt).append(" ");
            SimpleDateFormat simpleDateFormat6 = simpleDateFormat4;
            Date date6 = date2;
            Date date7 = new Date(this.zzalt);
            append9.println(append10.append(simpleDateFormat6.format(date6)).toString());
        }
        if (this.zzalw > 0) {
            PrintWriter append11 = printWriter2.append(str2).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzalv));
            PrintWriter append12 = printWriter2.append(" lastFailedTime=");
            StringBuilder sb8 = sb;
            StringBuilder sb9 = new StringBuilder();
            StringBuilder append13 = sb8.append(this.zzalw).append(" ");
            SimpleDateFormat simpleDateFormat7 = simpleDateFormat4;
            Date date8 = date;
            Date date9 = new Date(this.zzalw);
            append12.println(append13.append(simpleDateFormat7.format(date8)).toString());
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzagr;
    }

    public boolean isConnected() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzalE == 3;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public boolean isConnecting() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzalE == 2;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzalv = connectionResult.getErrorCode();
        this.zzalw = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionSuspended(int i) {
        this.zzals = i;
        this.zzalt = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract T zzW(IBinder iBinder);

    /* access modifiers changed from: protected */
    @BinderThread
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        zzg zzg2;
        int i3 = i;
        IBinder iBinder2 = iBinder;
        Bundle bundle2 = bundle;
        int i4 = i2;
        Handler handler = this.mHandler;
        Handler handler2 = this.mHandler;
        int i5 = i4;
        zzg zzg3 = zzg2;
        zzg zzg4 = new zzg(this, i3, iBinder2, bundle2);
        boolean sendMessage = handler.sendMessage(handler2.obtainMessage(1, i5, -1, zzg3));
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void zza(@NonNull T t) {
        T t2 = t;
        this.zzalu = System.currentTimeMillis();
    }

    public void zza(@NonNull com.google.android.gms.common.api.GoogleApiClient.zza zza2) {
        this.zzalA = (com.google.android.gms.common.api.GoogleApiClient.zza) zzx.zzb(zza2, (Object) "Connection progress callbacks cannot be null.");
        zzb(2, null);
    }

    @WorkerThread
    public void zza(zzp zzp, Set<Scope> set) {
        GetServiceRequest getServiceRequest;
        Object obj;
        zzd zzd2;
        zzp zzp2 = zzp;
        Set<Scope> set2 = set;
        try {
            Bundle zzml = zzml();
            GetServiceRequest getServiceRequest2 = getServiceRequest;
            GetServiceRequest getServiceRequest3 = new GetServiceRequest(this.zzalH);
            GetServiceRequest zzj = getServiceRequest2.zzcG(this.mContext.getPackageName()).zzj(zzml);
            if (set2 != null) {
                GetServiceRequest zzd3 = zzj.zzd(set2);
            }
            if (zzmE()) {
                GetServiceRequest zzb2 = zzj.zzc(zzqq()).zzb(zzp2);
            } else if (zzqK()) {
                GetServiceRequest zzc2 = zzj.zzc(this.zzTI);
            }
            obj = this.zzaly;
            synchronized (obj) {
                if (this.zzalz != null) {
                    zzs zzs = this.zzalz;
                    zzd zzd4 = zzd2;
                    zzd zzd5 = new zzd(this, this.zzalI.get());
                    zzs.zza((zzr) zzd4, zzj);
                } else {
                    int w = Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            DeadObjectException deadObjectException = e;
            int w2 = Log.w("GmsClient", "service died");
            zzbS(1);
        } catch (RemoteException e2) {
            int w3 = Log.w("GmsClient", "Remote exception occurred", e2);
        } catch (Throwable th) {
            Throwable th2 = th;
            Object obj2 = obj;
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Set<Scope> zzb(@NonNull Set<Scope> set) {
        return set;
    }

    public void zzbS(int i) {
        boolean sendMessage = this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.zzalI.get(), i));
    }

    /* access modifiers changed from: 0000 */
    public void zzc(int i, T t) {
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String zzgu();

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String zzgv();

    /* access modifiers changed from: protected */
    public void zzm(int i, int i2) {
        zzh zzh2;
        int i3 = i;
        int i4 = i2;
        Handler handler = this.mHandler;
        Handler handler2 = this.mHandler;
        int i5 = i4;
        zzh zzh3 = zzh2;
        zzh zzh4 = new zzh(this, i3);
        boolean sendMessage = handler.sendMessage(handler2.obtainMessage(5, i5, -1, zzh3));
    }

    public boolean zzmE() {
        return false;
    }

    /* access modifiers changed from: protected */
    public Bundle zzml() {
        Bundle bundle;
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        return bundle2;
    }

    public boolean zznb() {
        return false;
    }

    public Intent zznc() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Not a sign in API");
        throw unsupportedOperationException2;
    }

    @Nullable
    public IBinder zzoT() {
        IBinder iBinder;
        Object obj = this.zzaly;
        synchronized (obj) {
            try {
                if (this.zzalz == null) {
                    return null;
                }
                th = this.zzalz.asBinder();
                return iBinder;
            } finally {
                iBinder = th;
                Object obj2 = obj;
                Throwable th = iBinder;
            }
        }
    }

    public Bundle zzoi() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzqD() {
        return this.zzahz.zzqw();
    }

    public void zzqG() {
        zzf zzf2;
        zzf zzf3;
        int isGooglePlayServicesAvailable = this.zzags.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zzb(1, null);
            zzf zzf4 = zzf3;
            zzf zzf5 = new zzf(this);
            this.zzalA = zzf4;
            boolean sendMessage = this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzalI.get(), isGooglePlayServicesAvailable));
            return;
        }
        zzf zzf6 = zzf2;
        zzf zzf7 = new zzf(this);
        zza((com.google.android.gms.common.api.GoogleApiClient.zza) zzf6);
    }

    /* access modifiers changed from: protected */
    public final zzf zzqH() {
        return this.zzahz;
    }

    /* access modifiers changed from: protected */
    public final void zzqI() {
        IllegalStateException illegalStateException;
        if (!isConnected()) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            throw illegalStateException2;
        }
    }

    public final T zzqJ() throws DeadObjectException {
        T t;
        DeadObjectException deadObjectException;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzalE == 4) {
                    DeadObjectException deadObjectException2 = deadObjectException;
                    DeadObjectException deadObjectException3 = new DeadObjectException();
                    throw deadObjectException2;
                }
                zzqI();
                zzx.zza(this.zzalB != null, (Object) "Client is connected but service is null");
                th = this.zzalB;
            } finally {
                t = th;
                Object obj2 = obj;
                Throwable th = t;
            }
        }
        return t;
    }

    public boolean zzqK() {
        return false;
    }

    public final Account zzqq() {
        Account account;
        if (this.zzTI != null) {
            return this.zzTI;
        }
        Account account2 = account;
        Account account3 = new Account("<<default account>>", com.google.android.gms.auth.zzd.GOOGLE_ACCOUNT_TYPE);
        return account2;
    }
}
