package com.google.android.gms.internal;

import android.content.MutableContextWrapper;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.LinkedList;

@zzhb
class zzea {
    /* access modifiers changed from: private */
    public final LinkedList<zza> zzAB;
    private final int zzAC;
    /* access modifiers changed from: private */
    public final String zzpS;
    /* access modifiers changed from: private */
    public AdRequestParcel zzqH;

    class zza {
        zzk zzAD;
        zzdw zzAE;
        long zzAF;
        boolean zzAG;
        boolean zzAH;
        final /* synthetic */ zzea zzAI;
        MutableContextWrapper zzAb;

        zza(zzea zzea, zzdv zzdv) {
            zzdw zzdw;
            zzea zzea2 = zzea;
            zzdv zzdv2 = zzdv;
            this.zzAI = zzea2;
            zzdv zzec = zzdv2.zzec();
            this.zzAb = zzdv2.zzed();
            this.zzAD = zzec.zzX(zzea2.zzpS);
            zzdw zzdw2 = zzdw;
            zzdw zzdw3 = new zzdw();
            this.zzAE = zzdw2;
            this.zzAE.zzc(this.zzAD);
        }

        private void zzek() {
            if (!this.zzAG && this.zzAI.zzqH != null) {
                this.zzAH = this.zzAD.zzb(this.zzAI.zzqH);
                this.zzAG = true;
                this.zzAF = zzr.zzbG().currentTimeMillis();
            }
        }

        /* access modifiers changed from: 0000 */
        public void zzc(zzdv zzdv) {
            this.zzAb.setBaseContext(zzdv.zzed().getBaseContext());
        }

        /* access modifiers changed from: 0000 */
        public void zzh(AdRequestParcel adRequestParcel) {
            AdRequestParcel adRequestParcel2 = adRequestParcel;
            if (adRequestParcel2 != null) {
                AdRequestParcel zza = zzea.zza(this.zzAI, adRequestParcel2);
            }
            zzek();
            Iterator it = this.zzAI.zzAB.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzek();
            }
        }
    }

    zzea(AdRequestParcel adRequestParcel, String str, int i) {
        LinkedList<zza> linkedList;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        String str2 = str;
        int i2 = i;
        Object zzz = zzx.zzz(adRequestParcel2);
        Object zzz2 = zzx.zzz(str2);
        LinkedList<zza> linkedList2 = linkedList;
        LinkedList<zza> linkedList3 = new LinkedList<>();
        this.zzAB = linkedList2;
        this.zzqH = adRequestParcel2;
        this.zzpS = str2;
        this.zzAC = i2;
    }

    static /* synthetic */ AdRequestParcel zza(zzea zzea, AdRequestParcel adRequestParcel) {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        zzea.zzqH = adRequestParcel2;
        return adRequestParcel2;
    }

    /* access modifiers changed from: 0000 */
    public String getAdUnitId() {
        return this.zzpS;
    }

    /* access modifiers changed from: 0000 */
    public int getNetworkType() {
        return this.zzAC;
    }

    /* access modifiers changed from: 0000 */
    public int size() {
        return this.zzAB.size();
    }

    /* access modifiers changed from: 0000 */
    public void zzb(zzdv zzdv) {
        zza zza2;
        zza zza3 = zza2;
        zza zza4 = new zza(this, zzdv);
        zza zza5 = zza3;
        boolean add = this.zzAB.add(zza5);
        zza5.zzh(this.zzqH);
    }

    /* access modifiers changed from: 0000 */
    public AdRequestParcel zzei() {
        return this.zzqH;
    }

    /* access modifiers changed from: 0000 */
    public zza zzej() {
        return (zza) this.zzAB.remove();
    }
}
