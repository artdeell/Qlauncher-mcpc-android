package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk implements Callback {
    private final Handler mHandler;
    private final zza zzalQ;
    private final ArrayList<ConnectionCallbacks> zzalR;
    final ArrayList<ConnectionCallbacks> zzalS;
    private final ArrayList<OnConnectionFailedListener> zzalT;
    private volatile boolean zzalU = false;
    private final AtomicInteger zzalV;
    private boolean zzalW;
    private final Object zzpV;

    public interface zza {
        boolean isConnected();

        Bundle zzoi();
    }

    public zzk(Looper looper, zza zza2) {
        ArrayList<ConnectionCallbacks> arrayList;
        ArrayList<ConnectionCallbacks> arrayList2;
        ArrayList<OnConnectionFailedListener> arrayList3;
        AtomicInteger atomicInteger;
        Object obj;
        Handler handler;
        Looper looper2 = looper;
        zza zza3 = zza2;
        ArrayList<ConnectionCallbacks> arrayList4 = arrayList;
        ArrayList<ConnectionCallbacks> arrayList5 = new ArrayList<>();
        this.zzalR = arrayList4;
        ArrayList<ConnectionCallbacks> arrayList6 = arrayList2;
        ArrayList<ConnectionCallbacks> arrayList7 = new ArrayList<>();
        this.zzalS = arrayList6;
        ArrayList<OnConnectionFailedListener> arrayList8 = arrayList3;
        ArrayList<OnConnectionFailedListener> arrayList9 = new ArrayList<>();
        this.zzalT = arrayList8;
        AtomicInteger atomicInteger2 = atomicInteger;
        AtomicInteger atomicInteger3 = new AtomicInteger(0);
        this.zzalV = atomicInteger2;
        this.zzalW = false;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzalQ = zza3;
        Handler handler2 = handler;
        Handler handler3 = new Handler(looper2, this);
        this.mHandler = handler2;
    }

    /* JADX INFO: finally extract failed */
    public boolean handleMessage(Message message) {
        StringBuilder sb;
        Exception exc;
        Message message2 = message;
        if (message2.what == 1) {
            ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) message2.obj;
            Object obj = this.zzpV;
            synchronized (obj) {
                try {
                    if (this.zzalU && this.zzalQ.isConnected() && this.zzalR.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(this.zzalQ.zzoi());
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
            return true;
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        String sb4 = sb2.append("Don't know how to handle message: ").append(message2.what).toString();
        Exception exc2 = exc;
        Exception exc3 = new Exception();
        int wtf = Log.wtf("GmsClientEvents", sb4, exc2);
        return false;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        ConnectionCallbacks connectionCallbacks2 = connectionCallbacks;
        Object zzz = zzx.zzz(connectionCallbacks2);
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzalR.contains(connectionCallbacks2);
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        OnConnectionFailedListener onConnectionFailedListener2 = onConnectionFailedListener;
        Object zzz = zzx.zzz(onConnectionFailedListener2);
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzalT.contains(onConnectionFailedListener2);
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        StringBuilder sb;
        ConnectionCallbacks connectionCallbacks2 = connectionCallbacks;
        Object zzz = zzx.zzz(connectionCallbacks2);
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzalR.contains(connectionCallbacks2)) {
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int w = Log.w("GmsClientEvents", sb2.append("registerConnectionCallbacks(): listener ").append(connectionCallbacks2).append(" is already registered").toString());
                } else {
                    boolean add = this.zzalR.add(connectionCallbacks2);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
        if (this.zzalQ.isConnected()) {
            boolean sendMessage = this.mHandler.sendMessage(this.mHandler.obtainMessage(1, connectionCallbacks2));
        }
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        StringBuilder sb;
        OnConnectionFailedListener onConnectionFailedListener2 = onConnectionFailedListener;
        Object zzz = zzx.zzz(onConnectionFailedListener2);
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzalT.contains(onConnectionFailedListener2)) {
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int w = Log.w("GmsClientEvents", sb2.append("registerConnectionFailedListener(): listener ").append(onConnectionFailedListener2).append(" is already registered").toString());
                } else {
                    boolean add = this.zzalT.add(onConnectionFailedListener2);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        StringBuilder sb;
        ConnectionCallbacks connectionCallbacks2 = connectionCallbacks;
        Object zzz = zzx.zzz(connectionCallbacks2);
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!this.zzalR.remove(connectionCallbacks2)) {
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int w = Log.w("GmsClientEvents", sb2.append("unregisterConnectionCallbacks(): listener ").append(connectionCallbacks2).append(" not found").toString());
                } else if (this.zzalW) {
                    boolean add = this.zzalS.add(connectionCallbacks2);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        StringBuilder sb;
        OnConnectionFailedListener onConnectionFailedListener2 = onConnectionFailedListener;
        Object zzz = zzx.zzz(onConnectionFailedListener2);
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!this.zzalT.remove(onConnectionFailedListener2)) {
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int w = Log.w("GmsClientEvents", sb2.append("unregisterConnectionFailedListener(): listener ").append(onConnectionFailedListener2).append(" not found").toString());
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzbT(int i) {
        ArrayList arrayList;
        int i2 = i;
        boolean z = false;
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            z = true;
        }
        zzx.zza(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzalW = true;
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(this.zzalR);
                ArrayList arrayList4 = arrayList2;
                int i3 = this.zzalV.get();
                Iterator it = arrayList4.iterator();
                while (it.hasNext()) {
                    ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                    if (!this.zzalU || this.zzalV.get() != i3) {
                        break;
                    } else if (this.zzalR.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnectionSuspended(i2);
                    }
                }
                this.zzalS.clear();
                this.zzalW = false;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzk(Bundle bundle) {
        boolean z;
        boolean z2;
        ArrayList arrayList;
        Bundle bundle2 = bundle;
        th = true;
        zzx.zza(Looper.myLooper() == this.mHandler.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzalW) {
                    z = false;
                }
                zzx.zzab(z);
                this.mHandler.removeMessages(1);
                this.zzalW = true;
                if (this.zzalS.size() != 0) {
                    z2 = false;
                }
                zzx.zzab(z2);
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(this.zzalR);
                ArrayList arrayList4 = arrayList2;
                int i = this.zzalV.get();
                Iterator it = arrayList4.iterator();
                while (it.hasNext()) {
                    ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                    if (!this.zzalU || !this.zzalQ.isConnected() || this.zzalV.get() != i) {
                        break;
                    } else if (!this.zzalS.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(bundle2);
                    }
                }
                this.zzalS.clear();
                this.zzalW = false;
            } finally {
                Throwable th = th;
                boolean z3 = obj;
                Throwable th2 = th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzk(ConnectionResult connectionResult) {
        ArrayList arrayList;
        ConnectionResult connectionResult2 = connectionResult;
        zzx.zza(Looper.myLooper() == this.mHandler.getLooper(), (Object) "onConnectionFailure must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(this.zzalT);
                ArrayList arrayList4 = arrayList2;
                int i = this.zzalV.get();
                Iterator it = arrayList4.iterator();
                while (it.hasNext()) {
                    OnConnectionFailedListener onConnectionFailedListener = (OnConnectionFailedListener) it.next();
                    if (this.zzalU && this.zzalV.get() == i) {
                        if (this.zzalT.contains(onConnectionFailedListener)) {
                            onConnectionFailedListener.onConnectionFailed(connectionResult2);
                        }
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzqQ() {
        this.zzalU = false;
        int incrementAndGet = this.zzalV.incrementAndGet();
    }

    public void zzqR() {
        this.zzalU = true;
    }
}
