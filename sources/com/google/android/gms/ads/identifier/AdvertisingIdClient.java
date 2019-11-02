package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private final Context mContext;
    com.google.android.gms.common.zza zzoS;
    zzat zzoT;
    boolean zzoU;
    Object zzoV;
    zza zzoW;
    final long zzoX;

    public static final class Info {
        private final String zzpc;
        private final boolean zzpd;

        public Info(String str, boolean z) {
            boolean z2 = z;
            this.zzpc = str;
            this.zzpd = z2;
        }

        public String getId() {
            return this.zzpc;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzpd;
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append("{").append(this.zzpc).append("}").append(this.zzpd).toString();
        }
    }

    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzoY;
        private long zzoZ;
        CountDownLatch zzpa;
        boolean zzpb = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            WeakReference<AdvertisingIdClient> weakReference;
            CountDownLatch countDownLatch;
            long j2 = j;
            WeakReference<AdvertisingIdClient> weakReference2 = weakReference;
            WeakReference<AdvertisingIdClient> weakReference3 = new WeakReference<>(advertisingIdClient);
            this.zzoY = weakReference2;
            this.zzoZ = j2;
            CountDownLatch countDownLatch2 = countDownLatch;
            CountDownLatch countDownLatch3 = new CountDownLatch(1);
            this.zzpa = countDownLatch2;
            start();
        }

        private void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzoY.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzpb = true;
            }
        }

        public void cancel() {
            this.zzpa.countDown();
        }

        public void run() {
            try {
                if (!this.zzpa.await(this.zzoZ, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
                disconnect();
            }
        }

        public boolean zzaK() {
            return this.zzpb;
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long j) {
        Object obj;
        Context context2 = context;
        long j2 = j;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzoV = obj2;
        Object zzz = zzx.zzz(context2);
        this.mContext = context2;
        this.zzoU = false;
        this.zzoX = j2;
    }

    /* JADX INFO: finally extract failed */
    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient;
        AdvertisingIdClient advertisingIdClient2 = advertisingIdClient;
        AdvertisingIdClient advertisingIdClient3 = new AdvertisingIdClient(context, -1);
        AdvertisingIdClient advertisingIdClient4 = advertisingIdClient2;
        try {
            advertisingIdClient4.zzb(false);
            Info info = advertisingIdClient4.getInfo();
            advertisingIdClient4.finish();
            return info;
        } catch (Throwable th) {
            Throwable th2 = th;
            advertisingIdClient4.finish();
            throw th2;
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    static zzat zza(Context context, com.google.android.gms.common.zza zza2) throws IOException {
        IOException iOException;
        IOException iOException2;
        Context context2 = context;
        try {
            return com.google.android.gms.internal.zzat.zza.zzb(zza2.zzoJ());
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
            IOException iOException3 = iOException2;
            IOException iOException4 = new IOException("Interrupted exception");
            throw iOException3;
        } catch (Throwable th) {
            Throwable th2 = th;
            IOException iOException5 = iOException;
            IOException iOException6 = new IOException(th2);
            throw iOException5;
        }
    }

    /* JADX INFO: finally extract failed */
    private void zzaJ() {
        zza zza2;
        Object obj = this.zzoV;
        synchronized (obj) {
            try {
                if (this.zzoW != null) {
                    this.zzoW.cancel();
                    try {
                        this.zzoW.join();
                    } catch (InterruptedException e) {
                        InterruptedException interruptedException = e;
                    }
                }
                if (this.zzoX > 0) {
                    zza zza3 = zza2;
                    zza zza4 = new zza(this, this.zzoX);
                    this.zzoW = zza3;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    static com.google.android.gms.common.zza zzp(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException;
        com.google.android.gms.common.zza zza2;
        Intent intent;
        IOException iOException;
        IOException iOException2;
        IOException iOException3;
        Context context2 = context;
        try {
            PackageInfo packageInfo = context2.getPackageManager().getPackageInfo(zze.GOOGLE_PLAY_STORE_PACKAGE, 0);
            switch (zzc.zzoK().isGooglePlayServicesAvailable(context2)) {
                case 0:
                case 2:
                    com.google.android.gms.common.zza zza3 = zza2;
                    com.google.android.gms.common.zza zza4 = new com.google.android.gms.common.zza();
                    com.google.android.gms.common.zza zza5 = zza3;
                    Intent intent2 = intent;
                    Intent intent3 = new Intent("com.google.android.gms.ads.identifier.service.START");
                    Intent intent4 = intent2;
                    Intent intent5 = intent4.setPackage("com.google.android.gms");
                    try {
                        if (zzb.zzrP().zza(context2, intent4, (ServiceConnection) zza5, 1)) {
                            return zza5;
                        }
                        IOException iOException4 = iOException2;
                        IOException iOException5 = new IOException("Connection failure");
                        throw iOException4;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        IOException iOException6 = iOException;
                        IOException iOException7 = new IOException(th2);
                        throw iOException6;
                    }
                default:
                    IOException iOException8 = iOException3;
                    IOException iOException9 = new IOException("Google Play services not available");
                    throw iOException8;
            }
        } catch (NameNotFoundException e) {
            NameNotFoundException nameNotFoundException = e;
            GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException2 = googlePlayServicesNotAvailableException;
            GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException3 = new GooglePlayServicesNotAvailableException(9);
            throw googlePlayServicesNotAvailableException2;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    public void finish() {
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.mContext != null && this.zzoS != null) {
                    if (this.zzoU) {
                        zzb.zzrP().zza(this.mContext, this.zzoS);
                    }
                    this.zzoU = false;
                    this.zzoT = null;
                    this.zzoS = null;
                }
            } catch (IllegalArgumentException e) {
                int i = Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", e);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public Info getInfo() throws IOException {
        IOException iOException;
        Info info;
        Info info2;
        Object obj;
        IOException iOException2;
        IOException iOException3;
        IOException iOException4;
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.zzoU) {
                    obj = this.zzoV;
                    synchronized (obj) {
                        if (this.zzoW == null || !this.zzoW.zzaK()) {
                            IOException iOException5 = iOException2;
                            IOException iOException6 = new IOException("AdvertisingIdClient is not connected.");
                            throw iOException5;
                        }
                    }
                    zzb(false);
                    if (!this.zzoU) {
                        IOException iOException7 = iOException4;
                        IOException iOException8 = new IOException("AdvertisingIdClient cannot reconnect.");
                        throw iOException7;
                    }
                }
                Object zzz = zzx.zzz(this.zzoS);
                Object zzz2 = zzx.zzz(this.zzoT);
                Info info3 = info;
                Info info4 = new Info(this.zzoT.getId(), this.zzoT.zzc(true));
                info2 = info3;
            } catch (RemoteException e) {
                int i = Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                IOException iOException9 = iOException;
                IOException iOException10 = new IOException("Remote exception");
                throw iOException9;
            } catch (Exception e2) {
                Exception exc = e2;
                IOException iOException11 = iOException3;
                IOException iOException12 = new IOException("AdvertisingIdClient cannot reconnect.", exc);
                throw iOException11;
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
        zzaJ();
        return info2;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb(true);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void zzb(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        boolean z2 = z;
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.zzoU) {
                    finish();
                }
                this.zzoS = zzp(this.mContext);
                this.zzoT = zza(this.mContext, this.zzoS);
                this.zzoU = true;
                if (z2) {
                    zzaJ();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}
