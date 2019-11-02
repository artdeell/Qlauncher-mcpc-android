package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zzhb
public class zzig {
    private boolean zzJu;
    private final LinkedList<zza> zzLf;
    private final String zzLg;
    private final String zzLh;
    private long zzLi;
    private long zzLj;
    private long zzLk;
    private long zzLl;
    private long zzLm;
    private long zzLn;
    private final Object zzpV;
    private final zzih zzqV;

    @zzhb
    private static final class zza {
        private long zzLo = -1;
        private long zzLp = -1;

        public zza() {
        }

        public Bundle toBundle() {
            Bundle bundle;
            Bundle bundle2 = bundle;
            Bundle bundle3 = new Bundle();
            Bundle bundle4 = bundle2;
            bundle4.putLong("topen", this.zzLo);
            bundle4.putLong("tclose", this.zzLp);
            return bundle4;
        }

        public long zzgV() {
            return this.zzLp;
        }

        public void zzgW() {
            this.zzLp = SystemClock.elapsedRealtime();
        }

        public void zzgX() {
            this.zzLo = SystemClock.elapsedRealtime();
        }
    }

    public zzig(zzih zzih, String str, String str2) {
        Object obj;
        LinkedList<zza> linkedList;
        zzih zzih2 = zzih;
        String str3 = str;
        String str4 = str2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzLi = -1;
        this.zzLj = -1;
        this.zzJu = false;
        this.zzLk = -1;
        this.zzLl = 0;
        this.zzLm = -1;
        this.zzLn = -1;
        this.zzqV = zzih2;
        this.zzLg = str3;
        this.zzLh = str4;
        LinkedList<zza> linkedList2 = linkedList;
        LinkedList<zza> linkedList3 = new LinkedList<>();
        this.zzLf = linkedList2;
    }

    public zzig(String str, String str2) {
        this(zzr.zzbF(), str, str2);
    }

    /* JADX INFO: finally extract failed */
    public Bundle toBundle() {
        Bundle bundle;
        Bundle bundle2;
        ArrayList arrayList;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                Bundle bundle3 = bundle;
                Bundle bundle4 = new Bundle();
                bundle2 = bundle3;
                bundle2.putString("seq_num", this.zzLg);
                bundle2.putString("slotid", this.zzLh);
                bundle2.putBoolean("ismediation", this.zzJu);
                bundle2.putLong("treq", this.zzLm);
                bundle2.putLong("tresponse", this.zzLn);
                bundle2.putLong("timp", this.zzLj);
                bundle2.putLong("tload", this.zzLk);
                bundle2.putLong("pcc", this.zzLl);
                bundle2.putLong("tfetch", this.zzLi);
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = arrayList2;
                Iterator it = this.zzLf.iterator();
                while (it.hasNext()) {
                    boolean add = arrayList4.add(((zza) it.next()).toBundle());
                }
                bundle2.putParcelableArrayList("tclick", arrayList4);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
        return bundle2;
    }

    /* JADX INFO: finally extract failed */
    public void zzA(boolean z) {
        boolean z2 = z;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzLn != -1) {
                    this.zzJu = z2;
                    this.zzqV.zza(this);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzgS() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzLn != -1 && this.zzLj == -1) {
                    this.zzLj = SystemClock.elapsedRealtime();
                    this.zzqV.zza(this);
                }
                this.zzqV.zzha().zzgS();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzgT() {
        zza zza2;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzLn != -1) {
                    zza zza3 = zza2;
                    zza zza4 = new zza();
                    zza zza5 = zza3;
                    zza5.zzgX();
                    boolean add = this.zzLf.add(zza5);
                    this.zzLl = 1 + this.zzLl;
                    this.zzqV.zzha().zzgT();
                    this.zzqV.zza(this);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzgU() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzLn != -1 && !this.zzLf.isEmpty()) {
                    zza zza2 = (zza) this.zzLf.getLast();
                    if (zza2.zzgV() == -1) {
                        zza2.zzgW();
                        this.zzqV.zza(this);
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzk(AdRequestParcel adRequestParcel) {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzLm = SystemClock.elapsedRealtime();
                this.zzqV.zzha().zzb(adRequestParcel2, this.zzLm);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzl(long j) {
        long j2 = j;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzLn = j2;
                if (this.zzLn != -1) {
                    this.zzqV.zza(this);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzm(long j) {
        long j2 = j;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzLn != -1) {
                    this.zzLi = j2;
                    this.zzqV.zza(this);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzz(boolean z) {
        boolean z2 = z;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzLn != -1) {
                    this.zzLk = SystemClock.elapsedRealtime();
                    if (!z2) {
                        this.zzLj = this.zzLk;
                        this.zzqV.zza(this);
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
