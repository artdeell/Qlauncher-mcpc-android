package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzif.zza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Future;

@zzhb
public class zzhz extends zzim implements zzhy {
    private final Context mContext;
    private final zza zzGd;
    private final ArrayList<Future> zzKL;
    private final ArrayList<String> zzKM;
    private final HashSet<String> zzKN;
    /* access modifiers changed from: private */
    public final zzht zzKO;
    private final Object zzpV;
    private final String zzrG;

    public zzhz(Context context, String str, zza zza, zzht zzht) {
        ArrayList<Future> arrayList;
        ArrayList<String> arrayList2;
        HashSet<String> hashSet;
        Object obj;
        Context context2 = context;
        String str2 = str;
        zza zza2 = zza;
        zzht zzht2 = zzht;
        ArrayList<Future> arrayList3 = arrayList;
        ArrayList<Future> arrayList4 = new ArrayList<>();
        this.zzKL = arrayList3;
        ArrayList<String> arrayList5 = arrayList2;
        ArrayList<String> arrayList6 = new ArrayList<>();
        this.zzKM = arrayList5;
        HashSet<String> hashSet2 = hashSet;
        HashSet<String> hashSet3 = new HashSet<>();
        this.zzKN = hashSet2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.mContext = context2;
        this.zzrG = str2;
        this.zzGd = zza2;
        this.zzKO = zzht2;
    }

    private zzif zza(int i, @Nullable String str, @Nullable zzen zzen) {
        zzif zzif;
        zzen zzen2 = zzen;
        zzif zzif2 = zzif;
        zzif zzif3 = new zzif(this.zzGd.zzLd.zzHt, null, this.zzGd.zzLe.zzBQ, i, this.zzGd.zzLe.zzBR, this.zzGd.zzLe.zzHV, this.zzGd.zzLe.orientation, this.zzGd.zzLe.zzBU, this.zzGd.zzLd.zzHw, this.zzGd.zzLe.zzHT, zzen2, null, str, this.zzGd.zzKV, null, this.zzGd.zzLe.zzHU, this.zzGd.zzrp, this.zzGd.zzLe.zzHS, this.zzGd.zzKY, this.zzGd.zzLe.zzHX, this.zzGd.zzLe.zzHY, this.zzGd.zzKT, null, this.zzGd.zzLe.zzIj, this.zzGd.zzLe.zzIk, this.zzGd.zzLe.zzIl, this.zzGd.zzLe.zzIm);
        return zzif2;
    }

    private zzif zza(String str, zzen zzen) {
        return zza(-2, str, zzen);
    }

    /* JADX INFO: finally extract failed */
    private void zzd(String str, String str2, String str3) {
        zzhu zzhu;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                zzia zzaw = this.zzKO.zzaw(str4);
                if (zzaw != null && zzaw.zzgQ() != null && zzaw.zzgP() != null) {
                    zzhu zzhu2 = zzhu;
                    zzhu zzhu3 = new zzhu(this.mContext, str4, this.zzrG, str5, str6, this.zzGd, zzaw, this);
                    boolean add = this.zzKL.add(zzhu2.zzgd());
                    boolean add2 = this.zzKM.add(str4);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    private zzif zzgO() {
        return zza(3, null, null);
    }

    public void onStop() {
    }

    public void zza(String str, int i) {
    }

    public void zzax(String str) {
        String str2 = str;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                boolean add = this.zzKN.add(str2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzbr() {
        C04012 r22;
        C04001 r222;
        for (zzen zzen : this.zzGd.zzKV.zzBO) {
            String str = zzen.zzBG;
            for (String zzd : zzen.zzBB) {
                zzd(zzd, str, zzen.zzBz);
            }
        }
        int i = 0;
        while (true) {
            if (i >= this.zzKL.size()) {
                break;
            }
            try {
                Object obj = ((Future) this.zzKL.get(i)).get();
                Object obj2 = this.zzpV;
                synchronized (obj2) {
                    try {
                        if (this.zzKN.contains(this.zzKM.get(i))) {
                            zzif zza = zza((String) this.zzKM.get(i), (zzen) this.zzGd.zzKV.zzBO.get(i));
                            Handler handler = com.google.android.gms.ads.internal.util.client.zza.zzMS;
                            C04001 r18 = r222;
                            final zzif zzif = zza;
                            C04001 r19 = new Runnable(this) {
                                final /* synthetic */ zzhz zzKP;

                                {
                                    zzif zzif = r7;
                                    this.zzKP = r6;
                                }

                                public void run() {
                                    this.zzKP.zzKO.zzb(zzif);
                                }
                            };
                            boolean post = handler.post(r18);
                            return;
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj3 = obj2;
                        throw th2;
                    }
                }
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
            } catch (Exception e2) {
                Exception exc = e2;
            }
            i++;
        }
        zzif zzgO = zzgO();
        Handler handler2 = com.google.android.gms.ads.internal.util.client.zza.zzMS;
        C04012 r182 = r22;
        final zzif zzif2 = zzgO;
        C04012 r192 = new Runnable(this) {
            final /* synthetic */ zzhz zzKP;

            {
                zzif zzif = r7;
                this.zzKP = r6;
            }

            public void run() {
                this.zzKP.zzKO.zzb(zzif2);
            }
        };
        boolean post2 = handler2.post(r182);
    }
}
