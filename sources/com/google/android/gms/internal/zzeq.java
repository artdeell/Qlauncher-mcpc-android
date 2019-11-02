package com.google.android.gms.internal;

import com.google.android.gms.internal.zzez.zza;

@zzhb
public final class zzeq extends zza {
    private zzes.zza zzCb;
    private zzep zzCc;
    private final Object zzpV;

    public zzeq() {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
    }

    public void onAdClicked() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzCc != null) {
                    this.zzCc.zzaY();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void onAdClosed() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzCc != null) {
                    this.zzCc.zzaZ();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        int i2 = i;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzCb != null) {
                    this.zzCb.zzr(i2 == 3 ? 1 : 2);
                    this.zzCb = null;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void onAdLeftApplication() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzCc != null) {
                    this.zzCc.zzba();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void onAdLoaded() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzCb != null) {
                    this.zzCb.zzr(0);
                    this.zzCb = null;
                    return;
                }
                if (this.zzCc != null) {
                    this.zzCc.zzbc();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void onAdOpened() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzCc != null) {
                    this.zzCc.zzbb();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zza(zzep zzep) {
        zzep zzep2 = zzep;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzCc = zzep2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zza(zzes.zza zza) {
        zzes.zza zza2 = zza;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzCb = zza2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zza(zzfa zzfa) {
        zzfa zzfa2 = zzfa;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzCb != null) {
                    this.zzCb.zza(0, zzfa2);
                    this.zzCb = null;
                    return;
                }
                if (this.zzCc != null) {
                    this.zzCc.zzbc();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
