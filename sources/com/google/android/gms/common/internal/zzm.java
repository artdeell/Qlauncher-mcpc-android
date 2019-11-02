package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class zzm extends zzl implements Callback {
    private final Handler mHandler;
    /* access modifiers changed from: private */
    public final HashMap<zza, zzb> zzalZ;
    /* access modifiers changed from: private */
    public final com.google.android.gms.common.stats.zzb zzama = com.google.android.gms.common.stats.zzb.zzrP();
    private final long zzamb = 5000;
    /* access modifiers changed from: private */
    public final Context zzsa;

    private static final class zza {
        private final String zzSU;
        private final ComponentName zzamc;

        public zza(ComponentName componentName) {
            ComponentName componentName2 = componentName;
            this.zzSU = null;
            this.zzamc = (ComponentName) zzx.zzz(componentName2);
        }

        public zza(String str) {
            this.zzSU = zzx.zzcM(str);
            this.zzamc = null;
        }

        public boolean equals(Object obj) {
            Object obj2 = obj;
            if (this != obj2) {
                if (!(obj2 instanceof zza)) {
                    return false;
                }
                zza zza = (zza) obj2;
                if (!zzw.equal(this.zzSU, zza.zzSU) || !zzw.equal(this.zzamc, zza.zzamc)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return zzw.hashCode(this.zzSU, this.zzamc);
        }

        public String toString() {
            return this.zzSU == null ? this.zzamc.flattenToString() : this.zzSU;
        }

        public Intent zzqS() {
            Intent intent;
            Intent intent2;
            if (this.zzSU != null) {
                Intent intent3 = intent2;
                Intent intent4 = new Intent(this.zzSU);
                return intent3.setPackage("com.google.android.gms");
            }
            Intent intent5 = intent;
            Intent intent6 = new Intent();
            return intent5.setComponent(this.zzamc);
        }
    }

    private final class zzb {
        private int mState = 2;
        private IBinder zzakD;
        private ComponentName zzamc;
        private final zza zzamd;
        /* access modifiers changed from: private */
        public final Set<ServiceConnection> zzame;
        private boolean zzamf;
        /* access modifiers changed from: private */
        public final zza zzamg;
        final /* synthetic */ zzm zzamh;

        public class zza implements ServiceConnection {
            final /* synthetic */ zzb zzami;

            public zza(zzb zzb) {
                this.zzami = zzb;
            }

            /* JADX INFO: finally extract failed */
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                ComponentName componentName2 = componentName;
                IBinder iBinder2 = iBinder;
                HashMap zza = this.zzami.zzamh.zzalZ;
                synchronized (zza) {
                    try {
                        IBinder zza2 = zzb.zza(this.zzami, iBinder2);
                        ComponentName zza3 = zzb.zza(this.zzami, componentName2);
                        for (ServiceConnection onServiceConnected : this.zzami.zzame) {
                            onServiceConnected.onServiceConnected(componentName2, iBinder2);
                        }
                        int zza4 = zzb.zza(this.zzami, 1);
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        HashMap hashMap = zza;
                        throw th2;
                    }
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                ComponentName componentName2 = componentName;
                HashMap zza = this.zzami.zzamh.zzalZ;
                synchronized (zza) {
                    try {
                        IBinder zza2 = zzb.zza(this.zzami, (IBinder) null);
                        ComponentName zza3 = zzb.zza(this.zzami, componentName2);
                        for (ServiceConnection onServiceDisconnected : this.zzami.zzame) {
                            onServiceDisconnected.onServiceDisconnected(componentName2);
                        }
                        int zza4 = zzb.zza(this.zzami, 2);
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        HashMap hashMap = zza;
                        throw th2;
                    }
                }
            }
        }

        public zzb(zzm zzm, zza zza2) {
            zza zza3;
            HashSet hashSet;
            zza zza4 = zza2;
            this.zzamh = zzm;
            this.zzamg = zza4;
            zza zza5 = zza3;
            zza zza6 = new zza(this);
            this.zzamd = zza5;
            HashSet hashSet2 = hashSet;
            HashSet hashSet3 = new HashSet();
            this.zzame = hashSet2;
        }

        static /* synthetic */ int zza(zzb zzb, int i) {
            int i2 = i;
            zzb.mState = i2;
            return i2;
        }

        static /* synthetic */ ComponentName zza(zzb zzb, ComponentName componentName) {
            ComponentName componentName2 = componentName;
            zzb.zzamc = componentName2;
            return componentName2;
        }

        static /* synthetic */ IBinder zza(zzb zzb, IBinder iBinder) {
            IBinder iBinder2 = iBinder;
            zzb.zzakD = iBinder2;
            return iBinder2;
        }

        public IBinder getBinder() {
            return this.zzakD;
        }

        public ComponentName getComponentName() {
            return this.zzamc;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.zzamf;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            ServiceConnection serviceConnection2 = serviceConnection;
            this.zzamh.zzama.zza(this.zzamh.zzsa, serviceConnection2, str, this.zzamg.zzqS());
            boolean add = this.zzame.add(serviceConnection2);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.zzame.contains(serviceConnection);
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            ServiceConnection serviceConnection2 = serviceConnection;
            String str2 = str;
            this.zzamh.zzama.zzb(this.zzamh.zzsa, serviceConnection2);
            boolean remove = this.zzame.remove(serviceConnection2);
        }

        @TargetApi(14)
        public void zzcH(String str) {
            String str2 = str;
            this.mState = 3;
            this.zzamf = this.zzamh.zzama.zza(this.zzamh.zzsa, str2, this.zzamg.zzqS(), (ServiceConnection) this.zzamd, 129);
            if (!this.zzamf) {
                this.mState = 2;
                try {
                    this.zzamh.zzama.zza(this.zzamh.zzsa, this.zzamd);
                } catch (IllegalArgumentException e) {
                    IllegalArgumentException illegalArgumentException = e;
                }
            }
        }

        public void zzcI(String str) {
            String str2 = str;
            this.zzamh.zzama.zza(this.zzamh.zzsa, this.zzamd);
            this.zzamf = false;
            this.mState = 2;
        }

        public boolean zzqT() {
            return this.zzame.isEmpty();
        }
    }

    zzm(Context context) {
        HashMap<zza, zzb> hashMap;
        Handler handler;
        Context context2 = context;
        HashMap<zza, zzb> hashMap2 = hashMap;
        HashMap<zza, zzb> hashMap3 = new HashMap<>();
        this.zzalZ = hashMap2;
        this.zzsa = context2.getApplicationContext();
        Handler handler2 = handler;
        Handler handler3 = new Handler(context2.getMainLooper(), this);
        this.mHandler = handler2;
    }

    /* JADX INFO: finally extract failed */
    private boolean zza(zza zza2, ServiceConnection serviceConnection, String str) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        boolean isBound;
        zzb zzb2;
        zza zza3 = zza2;
        ServiceConnection serviceConnection2 = serviceConnection;
        String str2 = str;
        Object zzb3 = zzx.zzb(serviceConnection2, (Object) "ServiceConnection must not be null");
        HashMap<zza, zzb> hashMap = this.zzalZ;
        synchronized (hashMap) {
            try {
                zzb zzb4 = (zzb) this.zzalZ.get(zza3);
                if (zzb4 != null) {
                    this.mHandler.removeMessages(0, zzb4);
                    if (!zzb4.zza(serviceConnection2)) {
                        zzb4.zza(serviceConnection2, str2);
                        switch (zzb4.getState()) {
                            case 1:
                                serviceConnection2.onServiceConnected(zzb4.getComponentName(), zzb4.getBinder());
                                break;
                            case 2:
                                zzb4.zzcH(str2);
                                break;
                        }
                    } else {
                        IllegalStateException illegalStateException2 = illegalStateException;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(zza3).toString());
                        throw illegalStateException2;
                    }
                } else {
                    zzb zzb5 = zzb2;
                    zzb zzb6 = new zzb(this, zza3);
                    zzb4 = zzb5;
                    zzb4.zza(serviceConnection2, str2);
                    zzb4.zzcH(str2);
                    Object put = this.zzalZ.put(zza3, zzb4);
                }
                isBound = zzb4.isBound();
            } catch (Throwable th) {
                Throwable th2 = th;
                HashMap<zza, zzb> hashMap2 = hashMap;
                throw th2;
            }
        }
        return isBound;
    }

    private void zzb(zza zza2, ServiceConnection serviceConnection, String str) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        IllegalStateException illegalStateException2;
        StringBuilder sb2;
        zza zza3 = zza2;
        HashMap<zza, zzb> hashMap = serviceConnection;
        String str2 = str;
        Object zzb2 = zzx.zzb(hashMap, (Object) "ServiceConnection must not be null");
        hashMap = this.zzalZ;
        synchronized (hashMap) {
            try {
                th = (zzb) this.zzalZ.get(zza3);
                if (th == null) {
                    IllegalStateException illegalStateException3 = illegalStateException2;
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    IllegalStateException illegalStateException4 = new IllegalStateException(sb3.append("Nonexistent connection status for service config: ").append(zza3).toString());
                    throw illegalStateException3;
                } else if (!th.zza(hashMap)) {
                    IllegalStateException illegalStateException5 = illegalStateException;
                    StringBuilder sb5 = sb;
                    StringBuilder sb6 = new StringBuilder();
                    IllegalStateException illegalStateException6 = new IllegalStateException(sb5.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(zza3).toString());
                    throw illegalStateException5;
                } else {
                    th.zzb(hashMap, str2);
                    if (th.zzqT()) {
                        boolean sendMessageDelayed = this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, th), this.zzamb);
                    }
                }
            } finally {
                zzb zzb3 = th;
                HashMap<zza, zzb> hashMap2 = hashMap;
                Throwable th = zzb3;
            }
        }
    }

    public boolean handleMessage(Message message) {
        Message message2 = message;
        switch (message2.what) {
            case 0:
                zzb zzb2 = (zzb) message2.obj;
                HashMap<zza, zzb> hashMap = this.zzalZ;
                synchronized (hashMap) {
                    try {
                        if (zzb2.zzqT()) {
                            if (zzb2.isBound()) {
                                zzb2.zzcI("GmsClientSupervisor");
                            }
                            Object remove = this.zzalZ.remove(zzb2.zzamg);
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        HashMap<zza, zzb> hashMap2 = hashMap;
                        throw th2;
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zza zza2;
        ServiceConnection serviceConnection2 = serviceConnection;
        String str2 = str;
        zza zza3 = zza2;
        zza zza4 = new zza(componentName);
        return zza(zza3, serviceConnection2, str2);
    }

    public boolean zza(String str, ServiceConnection serviceConnection, String str2) {
        zza zza2;
        ServiceConnection serviceConnection2 = serviceConnection;
        String str3 = str2;
        zza zza3 = zza2;
        zza zza4 = new zza(str);
        return zza(zza3, serviceConnection2, str3);
    }

    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zza zza2;
        ServiceConnection serviceConnection2 = serviceConnection;
        String str2 = str;
        zza zza3 = zza2;
        zza zza4 = new zza(componentName);
        zzb(zza3, serviceConnection2, str2);
    }

    public void zzb(String str, ServiceConnection serviceConnection, String str2) {
        zza zza2;
        ServiceConnection serviceConnection2 = serviceConnection;
        String str3 = str2;
        zza zza3 = zza2;
        zza zza4 = new zza(str);
        zzb(zza3, serviceConnection2, str3);
    }
}
