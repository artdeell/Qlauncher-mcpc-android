package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzr;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzhb
public class zzdq implements Iterable<zzdp> {
    private final List<zzdp> zzzM;

    public zzdq() {
        LinkedList linkedList;
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList();
        this.zzzM = linkedList2;
    }

    private zzdp zzf(zzjp zzjp) {
        zzjp zzjp2 = zzjp;
        Iterator it = zzr.zzbR().iterator();
        while (it.hasNext()) {
            zzdp zzdp = (zzdp) it.next();
            if (zzdp.zzpD == zzjp2) {
                return zzdp;
            }
        }
        return null;
    }

    public Iterator<zzdp> iterator() {
        return this.zzzM.iterator();
    }

    public void zza(zzdp zzdp) {
        zzdp zzdp2 = zzdp;
        boolean add = this.zzzM.add(zzdp2);
    }

    public void zzb(zzdp zzdp) {
        zzdp zzdp2 = zzdp;
        boolean remove = this.zzzM.remove(zzdp2);
    }

    public boolean zzd(zzjp zzjp) {
        zzdp zzf = zzf(zzjp);
        if (zzf == null) {
            return false;
        }
        zzf.zzzJ.abort();
        return true;
    }

    public boolean zze(zzjp zzjp) {
        return zzf(zzjp) != null;
    }
}
