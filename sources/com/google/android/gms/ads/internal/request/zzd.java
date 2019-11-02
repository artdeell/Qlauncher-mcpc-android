package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzbm;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhc;
import com.google.android.gms.internal.zzhd;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzji.zzc;

@zzhb
public abstract class zzd implements com.google.android.gms.ads.internal.request.zzc.zza, zzit<Void> {
    private final zzji<AdRequestInfoParcel> zzHl;
    private final com.google.android.gms.ads.internal.request.zzc.zza zzHm;
    private final Object zzpV;

    @zzhb
    public static final class zza extends zzd {
        private final Context mContext;

        public zza(Context context, zzji<AdRequestInfoParcel> zzji, com.google.android.gms.ads.internal.request.zzc.zza zza) {
            Context context2 = context;
            super(zzji, zza);
            this.mContext = context2;
        }

        public /* synthetic */ Object zzgd() {
            return zzd.super.zzgd();
        }

        public void zzgr() {
        }

        public zzj zzgs() {
            zzbm zzbm;
            zzbm zzbm2 = zzbm;
            zzbm zzbm3 = new zzbm((String) zzbt.zzvB.get());
            return zzhd.zza(this.mContext, zzbm2, zzhc.zzgA());
        }
    }

    @zzhb
    public static class zzb extends zzd implements ConnectionCallbacks, OnConnectionFailedListener {
        private Context mContext;
        private zzji<AdRequestInfoParcel> zzHl;
        private final com.google.android.gms.ads.internal.request.zzc.zza zzHm;
        protected zze zzHp;
        private boolean zzHq;
        private VersionInfoParcel zzpT;
        private final Object zzpV;

        public zzb(Context context, VersionInfoParcel versionInfoParcel, zzji<AdRequestInfoParcel> zzji, com.google.android.gms.ads.internal.request.zzc.zza zza) {
            Object obj;
            Looper mainLooper;
            zze zze;
            Context context2 = context;
            VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
            zzji<AdRequestInfoParcel> zzji2 = zzji;
            com.google.android.gms.ads.internal.request.zzc.zza zza2 = zza;
            super(zzji2, zza2);
            Object obj2 = obj;
            Object obj3 = new Object();
            this.zzpV = obj2;
            this.mContext = context2;
            this.zzpT = versionInfoParcel2;
            this.zzHl = zzji2;
            this.zzHm = zza2;
            if (((Boolean) zzbt.zzwa.get()).booleanValue()) {
                this.zzHq = true;
                mainLooper = zzr.zzbO().zzhC();
            } else {
                mainLooper = context2.getMainLooper();
            }
            zze zze2 = zze;
            zze zze3 = new zze(context2, mainLooper, this, this, this.zzpT.zzNa);
            this.zzHp = zze2;
            connect();
        }

        /* access modifiers changed from: protected */
        public void connect() {
            this.zzHp.zzqG();
        }

        public void onConnected(Bundle bundle) {
            Bundle bundle2 = bundle;
            Void zzga = zzgd();
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            Bundle bundle;
            ConnectionResult connectionResult2 = connectionResult;
            zzin.zzaI("Cannot connect to remote service, fallback to local instance.");
            Object zzgd = zzgt().zzgd();
            Bundle bundle2 = bundle;
            Bundle bundle3 = new Bundle();
            Bundle bundle4 = bundle2;
            bundle4.putString("action", "gms_connection_failed_fallback_to_local");
            zzr.zzbC().zzb(this.mContext, this.zzpT.afmaVersion, "gmob-apps", bundle4, true);
        }

        public void onConnectionSuspended(int i) {
            int i2 = i;
            zzin.zzaI("Disconnected from remote ad request service.");
        }

        public /* synthetic */ Object zzgd() {
            return zzd.super.zzgd();
        }

        public void zzgr() {
            Object obj = this.zzpV;
            synchronized (obj) {
                try {
                    if (this.zzHp.isConnected() || this.zzHp.isConnecting()) {
                        this.zzHp.disconnect();
                    }
                    Binder.flushPendingCommands();
                    if (this.zzHq) {
                        zzr.zzbO().zzhD();
                        this.zzHq = false;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.gms.ads.internal.request.zzj zzgs() {
            /*
                r7 = this;
                r0 = r7
                r6 = r0
                java.lang.Object r6 = r6.zzpV
                r1 = r6
                r6 = r1
                monitor-enter(r6)
                r6 = r0
                com.google.android.gms.ads.internal.request.zze r6 = r6.zzHp     // Catch:{ IllegalStateException -> 0x0021, DeadObjectException -> 0x0014 }
                com.google.android.gms.ads.internal.request.zzj r6 = r6.zzgw()     // Catch:{ IllegalStateException -> 0x0021, DeadObjectException -> 0x0014 }
                r5 = r6
                r6 = r1
                monitor-exit(r6)     // Catch:{ all -> 0x001b }
                r6 = r5
                r0 = r6
            L_0x0013:
                return r0
            L_0x0014:
                r6 = move-exception
                r2 = r6
            L_0x0016:
                r6 = r1
                monitor-exit(r6)     // Catch:{ all -> 0x001b }
                r6 = 0
                r0 = r6
                goto L_0x0013
            L_0x001b:
                r6 = move-exception
                r3 = r6
                r6 = r1
                monitor-exit(r6)     // Catch:{ all -> 0x001b }
                r6 = r3
                throw r6
            L_0x0021:
                r6 = move-exception
                r4 = r6
                goto L_0x0016
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.request.zzd.zzb.zzgs():com.google.android.gms.ads.internal.request.zzj");
        }

        /* access modifiers changed from: 0000 */
        public zzit zzgt() {
            zza zza;
            zza zza2 = zza;
            zza zza3 = new zza(this.mContext, this.zzHl, this.zzHm);
            return zza2;
        }
    }

    public zzd(zzji<AdRequestInfoParcel> zzji, com.google.android.gms.ads.internal.request.zzc.zza zza2) {
        Object obj;
        zzji<AdRequestInfoParcel> zzji2 = zzji;
        com.google.android.gms.ads.internal.request.zzc.zza zza3 = zza2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzHl = zzji2;
        this.zzHm = zza3;
    }

    public void cancel() {
        zzgr();
    }

    /* access modifiers changed from: 0000 */
    public boolean zza(zzj zzj, AdRequestInfoParcel adRequestInfoParcel) {
        AdResponseParcel adResponseParcel;
        zzg zzg;
        zzj zzj2 = zzj;
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        try {
            zzg zzg2 = zzg;
            zzg zzg3 = new zzg(this);
            zzj2.zza(adRequestInfoParcel2, zzg2);
            return true;
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            zzin.zzd("Could not fetch ad response from ad request service.", remoteException);
            zzr.zzbF().zzb((Throwable) remoteException, true);
            com.google.android.gms.ads.internal.request.zzc.zza zza2 = this.zzHm;
            AdResponseParcel adResponseParcel2 = adResponseParcel;
            AdResponseParcel adResponseParcel3 = new AdResponseParcel(0);
            zza2.zzb(adResponseParcel2);
            return false;
        } catch (NullPointerException e2) {
            NullPointerException nullPointerException = e2;
            zzin.zzd("Could not fetch ad response from ad request service due to an Exception.", nullPointerException);
            zzr.zzbF().zzb((Throwable) nullPointerException, true);
            com.google.android.gms.ads.internal.request.zzc.zza zza22 = this.zzHm;
            AdResponseParcel adResponseParcel22 = adResponseParcel;
            AdResponseParcel adResponseParcel32 = new AdResponseParcel(0);
            zza22.zzb(adResponseParcel22);
            return false;
        } catch (SecurityException e3) {
            SecurityException securityException = e3;
            zzin.zzd("Could not fetch ad response from ad request service due to an Exception.", securityException);
            zzr.zzbF().zzb((Throwable) securityException, true);
            com.google.android.gms.ads.internal.request.zzc.zza zza222 = this.zzHm;
            AdResponseParcel adResponseParcel222 = adResponseParcel;
            AdResponseParcel adResponseParcel322 = new AdResponseParcel(0);
            zza222.zzb(adResponseParcel222);
            return false;
        } catch (Throwable th) {
            Throwable th2 = th;
            zzin.zzd("Could not fetch ad response from ad request service due to an Exception.", th2);
            zzr.zzbF().zzb(th2, true);
            com.google.android.gms.ads.internal.request.zzc.zza zza2222 = this.zzHm;
            AdResponseParcel adResponseParcel2222 = adResponseParcel;
            AdResponseParcel adResponseParcel3222 = new AdResponseParcel(0);
            zza2222.zzb(adResponseParcel2222);
            return false;
        }
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        AdResponseParcel adResponseParcel2 = adResponseParcel;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzHm.zzb(adResponseParcel2);
                zzgr();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* renamed from: zzga */
    public Void zzgd() {
        C01881 r7;
        C01892 r72;
        AdResponseParcel adResponseParcel;
        zzj zzgs = zzgs();
        if (zzgs == null) {
            com.google.android.gms.ads.internal.request.zzc.zza zza2 = this.zzHm;
            AdResponseParcel adResponseParcel2 = adResponseParcel;
            AdResponseParcel adResponseParcel3 = new AdResponseParcel(0);
            zza2.zzb(adResponseParcel2);
            zzgr();
            return null;
        }
        zzji<AdRequestInfoParcel> zzji = this.zzHl;
        C01881 r3 = r7;
        final zzj zzj = zzgs;
        C01881 r4 = new zzc<AdRequestInfoParcel>(this) {
            final /* synthetic */ zzd zzHo;

            {
                zzj zzj = r7;
                this.zzHo = r6;
            }

            /* renamed from: zzc */
            public void zze(AdRequestInfoParcel adRequestInfoParcel) {
                if (!this.zzHo.zza(zzj, adRequestInfoParcel)) {
                    this.zzHo.zzgr();
                }
            }
        };
        C01892 r42 = r72;
        C01892 r5 = new com.google.android.gms.internal.zzji.zza(this) {
            final /* synthetic */ zzd zzHo;

            {
                this.zzHo = r5;
            }

            public void run() {
                this.zzHo.zzgr();
            }
        };
        zzji.zza(r3, r42);
        return null;
    }

    public abstract void zzgr();

    public abstract zzj zzgs();
}
