package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.afma.nano.NanoAfmaSignals.AFMASignals;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzam extends zzal {
    /* access modifiers changed from: private */
    public static AdvertisingIdClient zzok = null;
    /* access modifiers changed from: private */
    public static CountDownLatch zzol;
    private boolean zzom;

    class zza {
        private String zzon;
        private boolean zzoo;
        final /* synthetic */ zzam zzop;

        public zza(zzam zzam, String str, boolean z) {
            String str2 = str;
            boolean z2 = z;
            this.zzop = zzam;
            this.zzon = str2;
            this.zzoo = z2;
        }

        public String getId() {
            return this.zzon;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzoo;
        }
    }

    private static final class zzb implements Runnable {
        private Context zzoq;

        public zzb(Context context) {
            Context context2 = context;
            this.zzoq = context2.getApplicationContext();
            if (this.zzoq == null) {
                this.zzoq = context2;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
            r3 = r8;
            r8 = com.google.android.gms.internal.zzam.class;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
            throw r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
            r2 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            com.google.android.gms.internal.zzam.zzaa().countDown();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
            throw r2;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x0023, B:14:0x0031] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r12 = this;
                r0 = r12
                java.lang.Class<com.google.android.gms.internal.zzam> r8 = com.google.android.gms.internal.zzam.class
                monitor-enter(r8)
                com.google.android.gms.ads.identifier.AdvertisingIdClient r8 = com.google.android.gms.internal.zzam.zzok     // Catch:{ GooglePlayServicesNotAvailableException -> 0x004f, IOException -> 0x002e, GooglePlayServicesRepairableException -> 0x0052 }
                if (r8 != 0) goto L_0x0023
                r8 = 1
                com.google.android.gms.ads.identifier.AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(r8)     // Catch:{ GooglePlayServicesNotAvailableException -> 0x004f, IOException -> 0x002e, GooglePlayServicesRepairableException -> 0x0052 }
                com.google.android.gms.ads.identifier.AdvertisingIdClient r8 = new com.google.android.gms.ads.identifier.AdvertisingIdClient     // Catch:{ GooglePlayServicesNotAvailableException -> 0x004f, IOException -> 0x002e, GooglePlayServicesRepairableException -> 0x0052 }
                r11 = r8
                r8 = r11
                r9 = r11
                r10 = r0
                android.content.Context r10 = r10.zzoq     // Catch:{ GooglePlayServicesNotAvailableException -> 0x004f, IOException -> 0x002e, GooglePlayServicesRepairableException -> 0x0052 }
                r9.<init>(r10)     // Catch:{ GooglePlayServicesNotAvailableException -> 0x004f, IOException -> 0x002e, GooglePlayServicesRepairableException -> 0x0052 }
                r7 = r8
                r8 = r7
                r8.start()     // Catch:{ GooglePlayServicesNotAvailableException -> 0x004f, IOException -> 0x002e, GooglePlayServicesRepairableException -> 0x0052 }
                r8 = r7
                com.google.android.gms.ads.identifier.AdvertisingIdClient r8 = com.google.android.gms.internal.zzam.zza(r8)     // Catch:{ GooglePlayServicesNotAvailableException -> 0x004f, IOException -> 0x002e, GooglePlayServicesRepairableException -> 0x0052 }
            L_0x0023:
                java.util.concurrent.CountDownLatch r8 = com.google.android.gms.internal.zzam.zzol     // Catch:{ all -> 0x003d }
                r8.countDown()     // Catch:{ all -> 0x003d }
            L_0x002a:
                java.lang.Class<com.google.android.gms.internal.zzam> r8 = com.google.android.gms.internal.zzam.class
                monitor-exit(r8)     // Catch:{ all -> 0x003d }
                return
            L_0x002e:
                r8 = move-exception
                r6 = r8
            L_0x0030:
                r8 = 0
                com.google.android.gms.ads.identifier.AdvertisingIdClient r8 = com.google.android.gms.internal.zzam.zza(r8)     // Catch:{ all -> 0x0044 }
                java.util.concurrent.CountDownLatch r8 = com.google.android.gms.internal.zzam.zzol     // Catch:{ all -> 0x003d }
                r8.countDown()     // Catch:{ all -> 0x003d }
                goto L_0x002a
            L_0x003d:
                r8 = move-exception
                r3 = r8
                java.lang.Class<com.google.android.gms.internal.zzam> r8 = com.google.android.gms.internal.zzam.class
                monitor-exit(r8)     // Catch:{ all -> 0x003d }
                r8 = r3
                throw r8
            L_0x0044:
                r8 = move-exception
                r2 = r8
                java.util.concurrent.CountDownLatch r8 = com.google.android.gms.internal.zzam.zzol     // Catch:{ all -> 0x003d }
                r8.countDown()     // Catch:{ all -> 0x003d }
                r8 = r2
                throw r8     // Catch:{ all -> 0x003d }
            L_0x004f:
                r8 = move-exception
                r5 = r8
                goto L_0x0030
            L_0x0052:
                r8 = move-exception
                r1 = r8
                goto L_0x0030
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzam.zzb.run():void");
        }
    }

    static {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2 = countDownLatch;
        CountDownLatch countDownLatch3 = new CountDownLatch(1);
        zzol = countDownLatch2;
    }

    protected zzam(Context context, zzap zzap, boolean z) {
        boolean z2 = z;
        super(context, zzap);
        this.zzom = z2;
    }

    static /* synthetic */ AdvertisingIdClient zza(AdvertisingIdClient advertisingIdClient) {
        AdvertisingIdClient advertisingIdClient2 = advertisingIdClient;
        zzok = advertisingIdClient2;
        return advertisingIdClient2;
    }

    public static zzam zza(String str, Context context, boolean z) {
        zzah zzah;
        zzam zzam;
        Thread thread;
        zzb zzb2;
        String str2 = str;
        Context context2 = context;
        boolean z2 = z;
        zzah zzah2 = zzah;
        zzah zzah3 = new zzah();
        zzah zzah4 = zzah2;
        zza(str2, context2, zzah4);
        if (z2) {
            synchronized (zzam.class) {
                try {
                    if (zzok == null) {
                        Thread thread2 = thread;
                        zzb zzb3 = zzb2;
                        zzb zzb4 = new zzb(context2);
                        Thread thread3 = new Thread(zzb3);
                        thread2.start();
                    }
                } catch (Throwable th) {
                    while (true) {
                        Throwable th2 = th;
                        Class<zzam> cls = zzam.class;
                        throw th2;
                    }
                }
            }
        }
        zzam zzam2 = zzam;
        zzam zzam3 = new zzam(context2, zzah4, z2);
        return zzam2;
    }

    private void zza(Context context, AFMASignals aFMASignals) {
        Context context2 = context;
        AFMASignals aFMASignals2 = aFMASignals;
        if (this.zzom) {
            try {
                if (zzS()) {
                    zza zzY = zzY();
                    String id = zzY.getId();
                    if (id != null) {
                        aFMASignals2.didOptOut = Boolean.valueOf(zzY.isLimitAdTrackingEnabled());
                        aFMASignals2.didSignalType = Integer.valueOf(5);
                        aFMASignals2.didSignal = id;
                        zza(28, zzob);
                        return;
                    }
                    return;
                }
                aFMASignals2.didSignal = zzf(context2);
                zza(24, zzob);
            } catch (IOException e) {
                IOException iOException = e;
            } catch (zza e2) {
                zza zza2 = e2;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public zza zzY() throws IOException {
        zza zza2;
        zza zza3;
        zza zza4;
        zza zza5;
        zza zza6;
        try {
            if (!zzol.await(2, TimeUnit.SECONDS)) {
                zza zza7 = zza6;
                zza zza8 = new zza(this, null, false);
                return zza7;
            }
            synchronized (zzam.class) {
                try {
                    if (zzok == null) {
                        th = zza5;
                        zza zza9 = new zza(this, null, false);
                        return zza3;
                    }
                    Info info = zzok.getInfo();
                    zza zza10 = zza4;
                    zza zza11 = new zza(this, zzk(info.getId()), info.isLimitAdTrackingEnabled());
                    return zza10;
                } finally {
                    zza3 = th;
                    Class<zzam> cls = zzam.class;
                    Throwable th = zza3;
                }
            }
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
            zza zza12 = zza2;
            zza zza13 = new zza(this, null, false);
            return zza12;
        }
    }

    /* access modifiers changed from: protected */
    public AFMASignals zzc(Context context) {
        Context context2 = context;
        AFMASignals zzc = super.zzc(context2);
        zza(context2, zzc);
        return zzc;
    }
}
