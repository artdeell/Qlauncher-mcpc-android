package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzip.zzb;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Future;

@zzhb
public class zzih implements zzb {
    private Context mContext;
    private boolean zzJA;
    private boolean zzJz;
    private final LinkedList<Thread> zzLA;
    private Boolean zzLB;
    private boolean zzLC;
    private boolean zzLD;
    private final String zzLq;
    private final zzii zzLr;
    private BigInteger zzLs = BigInteger.ONE;
    private final HashSet<zzig> zzLt;
    private final HashMap<String, zzik> zzLu;
    private boolean zzLv;
    private int zzLw;
    private zzbv zzLx;
    private zzbf zzLy;
    private String zzLz;
    private VersionInfoParcel zzpT;
    private final Object zzpV;
    private zzax zzpl;
    private boolean zzqA;
    private zzbe zzsZ;
    private zzbd zzta;
    private final zzha zztb;
    private String zzzN;

    public zzih(zzir zzir) {
        Object obj;
        HashSet<zzig> hashSet;
        HashMap<String, zzik> hashMap;
        LinkedList<Thread> linkedList;
        zzii zzii;
        zzir zzir2 = zzir;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        HashSet<zzig> hashSet2 = hashSet;
        HashSet<zzig> hashSet3 = new HashSet<>();
        this.zzLt = hashSet2;
        HashMap<String, zzik> hashMap2 = hashMap;
        HashMap<String, zzik> hashMap3 = new HashMap<>();
        this.zzLu = hashMap2;
        this.zzLv = false;
        this.zzJz = true;
        this.zzLw = 0;
        this.zzqA = false;
        this.zzLx = null;
        this.zzJA = true;
        this.zzsZ = null;
        this.zzLy = null;
        this.zzta = null;
        LinkedList<Thread> linkedList2 = linkedList;
        LinkedList<Thread> linkedList3 = new LinkedList<>();
        this.zzLA = linkedList2;
        this.zztb = null;
        this.zzLB = null;
        this.zzLC = false;
        this.zzLD = false;
        this.zzLq = zzir2.zzhs();
        zzii zzii2 = zzii;
        zzii zzii3 = new zzii(this.zzLq);
        this.zzLr = zzii2;
    }

    public String getSessionId() {
        return this.zzLq;
    }

    public void zzB(boolean z) {
        boolean z2 = z;
        zzbf zzbf = this.zzpV;
        synchronized (zzbf) {
            try {
                if (this.zzJA != z2) {
                    Future zzb = zzip.zzb(this.mContext, z2);
                }
                this.zzJA = z2;
                th = zzG(this.mContext);
                if (zzbf != null && !zzbf.isAlive()) {
                    zzin.zzaJ("start fetching content...");
                    zzbf.zzcG();
                }
            } finally {
                Throwable th = th;
                zzbf zzbf2 = zzbf;
                Throwable th2 = th;
            }
        }
    }

    public void zzC(boolean z) {
        boolean z2 = z;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzLC = z2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public zzbf zzG(Context context) {
        zzbf zzbf;
        zzbf zzbf2;
        zzha zzha;
        zzbd zzbd;
        zzbe zzbe;
        Context context2 = context;
        if (!((Boolean) zzbt.zzwj.get()).booleanValue() || !zzne.zzsg() || zzgY()) {
            return null;
        }
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzsZ == null) {
                    if (!(context2 instanceof Activity)) {
                        return null;
                    }
                    zzbe zzbe2 = zzbe;
                    zzbe zzbe3 = new zzbe((Application) context2.getApplicationContext(), (Activity) context2);
                    this.zzsZ = zzbe2;
                }
                if (this.zzta == null) {
                    zzbd zzbd2 = zzbd;
                    zzbd zzbd3 = new zzbd();
                    this.zzta = zzbd2;
                }
                if (this.zzLy == null) {
                    zzbf zzbf3 = zzbf2;
                    zzbe zzbe4 = this.zzsZ;
                    zzbd zzbd4 = this.zzta;
                    zzha zzha2 = zzha;
                    zzha zzha3 = new zzha(this.mContext, this.zzpT, null, null);
                    zzbf zzbf4 = new zzbf(zzbe4, zzbd4, zzha2);
                    this.zzLy = zzbf3;
                }
                this.zzLy.zzcG();
                th = this.zzLy;
                return zzbf;
            } finally {
                zzbf = th;
                Object obj2 = obj;
                Throwable th = zzbf;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public Bundle zza(Context context, zzij zzij, String str) {
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        ArrayList arrayList;
        Context context2 = context;
        zzij zzij2 = zzij;
        String str2 = str;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                Bundle bundle4 = bundle;
                Bundle bundle5 = new Bundle();
                bundle2 = bundle4;
                bundle2.putBundle("app", this.zzLr.zzc(context2, str2));
                Bundle bundle6 = bundle3;
                Bundle bundle7 = new Bundle();
                Bundle bundle8 = bundle6;
                for (String str3 : this.zzLu.keySet()) {
                    bundle8.putBundle(str3, ((zzik) this.zzLu.get(str3)).toBundle());
                }
                bundle2.putBundle("slots", bundle8);
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = arrayList2;
                Iterator it = this.zzLt.iterator();
                while (it.hasNext()) {
                    boolean add = arrayList4.add(((zzig) it.next()).toBundle());
                }
                bundle2.putParcelableArrayList("ads", arrayList4);
                zzij2.zza(this.zzLt);
                this.zzLt.clear();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
        return bundle2;
    }

    public Future zza(Context context, boolean z) {
        Future future;
        Context context2 = context;
        boolean z2 = z;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (z2 == this.zzJz) {
                    return null;
                }
                this.zzJz = z2;
                th = zzip.zza(context2, z2);
                return future;
            } finally {
                future = th;
                Object obj2 = obj;
                Throwable th = future;
            }
        }
    }

    public void zza(zzig zzig) {
        zzig zzig2 = zzig;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                boolean add = this.zzLt.add(zzig2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zza(String str, zzik zzik) {
        String str2 = str;
        zzik zzik2 = zzik;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                Object put = this.zzLu.put(str2, zzik2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zza(Thread thread) {
        zzha zza = zzha.zza(this.mContext, thread, this.zzpT);
    }

    public Future zzaA(String str) {
        Future future;
        String str2 = str;
        Object obj = this.zzpV;
        synchronized (obj) {
            if (str2 != null) {
                try {
                    if (!str2.equals(this.zzLz)) {
                        this.zzLz = str2;
                        th = zzip.zzd(this.mContext, str2);
                        return future;
                    }
                } finally {
                    future = th;
                    Object obj2 = obj;
                    Throwable th = future;
                }
            }
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    @TargetApi(23)
    public void zzb(Context context, VersionInfoParcel versionInfoParcel) {
        zzax zzax;
        zzeg zzeg;
        Context context2 = context;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!this.zzqA) {
                    this.mContext = context2.getApplicationContext();
                    this.zzpT = versionInfoParcel2;
                    Future zza = zzip.zza(context2, (zzb) this);
                    Future zzb = zzip.zzb(context2, (zzb) this);
                    Future zzc = zzip.zzc(context2, this);
                    Future zzd = zzip.zzd(context2, (zzb) this);
                    zza(Thread.currentThread());
                    this.zzzN = zzr.zzbC().zze(context2, versionInfoParcel2.afmaVersion);
                    if (zzne.zzsn() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                        this.zzLD = true;
                    }
                    zzax zzax2 = zzax;
                    Context applicationContext = context2.getApplicationContext();
                    VersionInfoParcel versionInfoParcel3 = this.zzpT;
                    zzeg zzeg2 = zzeg;
                    zzeg zzeg3 = new zzeg(context2.getApplicationContext(), this.zzpT, (String) zzbt.zzvB.get());
                    zzax zzax3 = new zzax(applicationContext, versionInfoParcel3, zzeg2);
                    this.zzpl = zzax2;
                    zzhk();
                    zzr.zzbM().zzz(this.mContext);
                    this.zzqA = true;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzb(Boolean bool) {
        Boolean bool2 = bool;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzLB = bool2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzb(Throwable th, boolean z) {
        zzha zzha;
        Throwable th2 = th;
        boolean z2 = z;
        zzha zzha2 = zzha;
        zzha zzha3 = new zzha(this.mContext, this.zzpT, null, null);
        zzha2.zza(th2, z2);
    }

    public void zzb(HashSet<zzig> hashSet) {
        HashSet<zzig> hashSet2 = hashSet;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                boolean addAll = this.zzLt.addAll(hashSet2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public String zzd(int i, String str) {
        int i2 = i;
        String str2 = str;
        Resources remoteResource = this.zzpT.zzNb ? this.mContext.getResources() : zze.getRemoteResource(this.mContext);
        return remoteResource == null ? str2 : remoteResource.getString(i2);
    }

    /* JADX INFO: finally extract failed */
    public void zze(Bundle bundle) {
        Bundle bundle2 = bundle;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzJz = bundle2.containsKey("use_https") ? bundle2.getBoolean("use_https") : this.zzJz;
                this.zzLw = bundle2.containsKey("webview_cache_version") ? bundle2.getInt("webview_cache_version") : this.zzLw;
                if (bundle2.containsKey("content_url_opted_out")) {
                    zzB(bundle2.getBoolean("content_url_opted_out"));
                }
                if (bundle2.containsKey("content_url_hashes")) {
                    this.zzLz = bundle2.getString("content_url_hashes");
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public boolean zzgY() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzJA;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public String zzgZ() {
        String str = this.zzpV;
        synchronized (str) {
            try {
                th = this.zzLs.toString();
                this.zzLs = this.zzLs.add(BigInteger.ONE);
            } finally {
                Throwable th = th;
                String str2 = str;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public zzii zzha() {
        zzii zzii = this.zzpV;
        synchronized (zzii) {
            try {
                th = this.zzLr;
            } finally {
                Throwable th = th;
                zzii zzii2 = zzii;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public zzbv zzhb() {
        zzbv zzbv = this.zzpV;
        synchronized (zzbv) {
            try {
                th = this.zzLx;
            } finally {
                Throwable th = th;
                zzbv zzbv2 = zzbv;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public boolean zzhc() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzLv;
                this.zzLv = true;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public boolean zzhd() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzJz || this.zzLD;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public String zzhe() {
        String str = this.zzpV;
        synchronized (str) {
            try {
                th = this.zzzN;
            } finally {
                Throwable th = th;
                String str2 = str;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public String zzhf() {
        String str = this.zzpV;
        synchronized (str) {
            try {
                th = this.zzLz;
            } finally {
                Throwable th = th;
                String str2 = str;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public Boolean zzhg() {
        Boolean bool = this.zzpV;
        synchronized (bool) {
            try {
                th = this.zzLB;
            } finally {
                Throwable th = th;
                Boolean bool2 = bool;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public zzax zzhh() {
        return this.zzpl;
    }

    public boolean zzhi() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzLw >= ((Integer) zzbt.zzwA.get()).intValue()) {
                    return false;
                }
                this.zzLw = ((Integer) zzbt.zzwA.get()).intValue();
                Future zza = zzip.zza(this.mContext, this.zzLw);
                return true;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public boolean zzhj() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzLC;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    /* access modifiers changed from: 0000 */
    public void zzhk() {
        zzbu zzbu;
        zzbu zzbu2 = zzbu;
        zzbu zzbu3 = new zzbu(this.mContext, this.zzpT.afmaVersion);
        zzbu zzbu4 = zzbu2;
        try {
            this.zzLx = zzr.zzbH().zza(zzbu4);
        } catch (IllegalArgumentException e) {
            zzin.zzd("Cannot initialize CSI reporter.", e);
        }
    }
}
