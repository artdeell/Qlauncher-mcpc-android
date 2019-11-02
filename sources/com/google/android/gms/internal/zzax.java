package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzau.zza;
import com.google.android.gms.internal.zzau.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@zzhb
public class zzax implements zzay {
    private final VersionInfoParcel zzpT;
    private final Object zzpV;
    private final WeakHashMap<zzif, zzau> zzsB;
    private final ArrayList<zzau> zzsC;
    private final zzeg zzsD;
    private final Context zzsa;

    public zzax(Context context, VersionInfoParcel versionInfoParcel, zzeg zzeg) {
        Object obj;
        WeakHashMap<zzif, zzau> weakHashMap;
        ArrayList<zzau> arrayList;
        Context context2 = context;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzeg zzeg2 = zzeg;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        WeakHashMap<zzif, zzau> weakHashMap2 = weakHashMap;
        WeakHashMap<zzif, zzau> weakHashMap3 = new WeakHashMap<>();
        this.zzsB = weakHashMap2;
        ArrayList<zzau> arrayList2 = arrayList;
        ArrayList<zzau> arrayList3 = new ArrayList<>();
        this.zzsC = arrayList2;
        this.zzsa = context2.getApplicationContext();
        this.zzpT = versionInfoParcel2;
        this.zzsD = zzeg2;
    }

    public zzau zza(AdSizeParcel adSizeParcel, zzif zzif) {
        zzif zzif2 = zzif;
        return zza(adSizeParcel, zzif2, zzif2.zzED.getView());
    }

    public zzau zza(AdSizeParcel adSizeParcel, zzif zzif, View view) {
        zzd zzd;
        zzif zzif2 = zzif;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        zzif zzif3 = zzif2;
        zzd zzd2 = zzd;
        zzd zzd3 = new zzd(view, zzif2);
        return zza(adSizeParcel2, zzif3, (zzbb) zzd2, (zzeh) null);
    }

    public zzau zza(AdSizeParcel adSizeParcel, zzif zzif, View view, zzeh zzeh) {
        zzd zzd;
        zzif zzif2 = zzif;
        zzeh zzeh2 = zzeh;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        zzif zzif3 = zzif2;
        zzd zzd2 = zzd;
        zzd zzd3 = new zzd(view, zzif2);
        return zza(adSizeParcel2, zzif3, (zzbb) zzd2, zzeh2);
    }

    public zzau zza(AdSizeParcel adSizeParcel, zzif zzif, zzh zzh) {
        zza zza;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        zzif zzif2 = zzif;
        zza zza2 = zza;
        zza zza3 = new zza(zzh);
        return zza(adSizeParcel2, zzif2, (zzbb) zza2, (zzeh) null);
    }

    /* JADX WARNING: type inference failed for: r20v0 */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r12v11, types: [com.google.android.gms.internal.zzau] */
    /* JADX WARNING: type inference failed for: r14v2, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r13v4, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r12v19 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.zzau] */
    /* JADX WARNING: type inference failed for: r20v1 */
    /* JADX WARNING: type inference failed for: r12v21 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 10 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzau zza(com.google.android.gms.ads.internal.client.AdSizeParcel r22, com.google.android.gms.internal.zzif r23, com.google.android.gms.internal.zzbb r24, com.google.android.gms.internal.zzeh r25) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r12 = r1
            java.lang.Object r12 = r12.zzpV
            r6 = r12
            r12 = r6
            monitor-enter(r12)
            r12 = r1
            r13 = r3
            boolean r12 = r12.zzh(r13)     // Catch:{ all -> 0x0064 }
            if (r12 == 0) goto L_0x0028
            r12 = r1
            java.util.WeakHashMap<com.google.android.gms.internal.zzif, com.google.android.gms.internal.zzau> r12 = r12.zzsB     // Catch:{ all -> 0x0064 }
            r13 = r3
            java.lang.Object r12 = r12.get(r13)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.zzau r12 = (com.google.android.gms.internal.zzau) r12     // Catch:{ all -> 0x0064 }
            r11 = r12
            r12 = r6
            monitor-exit(r12)     // Catch:{ all -> 0x0064 }
            r12 = r11
            r1 = r12
        L_0x0027:
            return r1
        L_0x0028:
            r12 = r5
            if (r12 == 0) goto L_0x006a
            com.google.android.gms.internal.zzaz r12 = new com.google.android.gms.internal.zzaz     // Catch:{ all -> 0x0064 }
            r20 = r12
            r12 = r20
            r13 = r20
            r14 = r1
            android.content.Context r14 = r14.zzsa     // Catch:{ all -> 0x0064 }
            r15 = r2
            r16 = r3
            r17 = r1
            r0 = r17
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r0.zzpT     // Catch:{ all -> 0x0064 }
            r17 = r0
            r18 = r4
            r19 = r5
            r13.<init>(r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0064 }
            r8 = r12
        L_0x0049:
            r12 = r8
            r13 = r1
            r12.zza(r13)     // Catch:{ all -> 0x0064 }
            r12 = r1
            java.util.WeakHashMap<com.google.android.gms.internal.zzif, com.google.android.gms.internal.zzau> r12 = r12.zzsB     // Catch:{ all -> 0x0064 }
            r13 = r3
            r14 = r8
            java.lang.Object r12 = r12.put(r13, r14)     // Catch:{ all -> 0x0064 }
            r12 = r1
            java.util.ArrayList<com.google.android.gms.internal.zzau> r12 = r12.zzsC     // Catch:{ all -> 0x0064 }
            r13 = r8
            boolean r12 = r12.add(r13)     // Catch:{ all -> 0x0064 }
            r12 = r6
            monitor-exit(r12)     // Catch:{ all -> 0x0064 }
            r12 = r8
            r1 = r12
            goto L_0x0027
        L_0x0064:
            r12 = move-exception
            r7 = r12
            r12 = r6
            monitor-exit(r12)     // Catch:{ all -> 0x0064 }
            r12 = r7
            throw r12
        L_0x006a:
            com.google.android.gms.internal.zzba r12 = new com.google.android.gms.internal.zzba     // Catch:{ all -> 0x0064 }
            r20 = r12
            r12 = r20
            r13 = r20
            r14 = r1
            android.content.Context r14 = r14.zzsa     // Catch:{ all -> 0x0064 }
            r15 = r2
            r16 = r3
            r17 = r1
            r0 = r17
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r0.zzpT     // Catch:{ all -> 0x0064 }
            r17 = r0
            r18 = r4
            r19 = r1
            r0 = r19
            com.google.android.gms.internal.zzeg r0 = r0.zzsD     // Catch:{ all -> 0x0064 }
            r19 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0064 }
            r8 = r12
            goto L_0x0049
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzax.zza(com.google.android.gms.ads.internal.client.AdSizeParcel, com.google.android.gms.internal.zzif, com.google.android.gms.internal.zzbb, com.google.android.gms.internal.zzeh):com.google.android.gms.internal.zzau");
    }

    public void zza(zzau zzau) {
        zzau zzau2 = zzau;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!zzau2.zzch()) {
                    boolean remove = this.zzsC.remove(zzau2);
                    Iterator it = this.zzsB.entrySet().iterator();
                    while (it.hasNext()) {
                        if (((Entry) it.next()).getValue() == zzau2) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public boolean zzh(zzif zzif) {
        zzif zzif2 = zzif;
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                zzau zzau = (zzau) this.zzsB.get(zzif2);
                th = zzau != null && zzau.zzch();
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void zzi(zzif zzif) {
        zzif zzif2 = zzif;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                zzau zzau = (zzau) this.zzsB.get(zzif2);
                if (zzau != null) {
                    zzau.zzcf();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzj(zzif zzif) {
        zzif zzif2 = zzif;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                zzau zzau = (zzau) this.zzsB.get(zzif2);
                if (zzau != null) {
                    zzau.stop();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzk(zzif zzif) {
        zzif zzif2 = zzif;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                zzau zzau = (zzau) this.zzsB.get(zzif2);
                if (zzau != null) {
                    zzau.pause();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzl(zzif zzif) {
        zzif zzif2 = zzif;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                zzau zzau = (zzau) this.zzsB.get(zzif2);
                if (zzau != null) {
                    zzau.resume();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
