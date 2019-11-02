package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@zzhb
public class zzbq {
    private final Collection<zzbp> zzvu;
    private final Collection<zzbp<String>> zzvv;
    private final Collection<zzbp<String>> zzvw;

    public zzbq() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = new ArrayList();
        this.zzvu = arrayList4;
        ArrayList arrayList6 = arrayList2;
        ArrayList arrayList7 = new ArrayList();
        this.zzvv = arrayList6;
        ArrayList arrayList8 = arrayList3;
        ArrayList arrayList9 = new ArrayList();
        this.zzvw = arrayList8;
    }

    public void zza(zzbp zzbp) {
        zzbp zzbp2 = zzbp;
        boolean add = this.zzvu.add(zzbp2);
    }

    public void zzb(zzbp<String> zzbp) {
        zzbp<String> zzbp2 = zzbp;
        boolean add = this.zzvv.add(zzbp2);
    }

    public void zzc(zzbp<String> zzbp) {
        zzbp<String> zzbp2 = zzbp;
        boolean add = this.zzvw.add(zzbp2);
    }

    public List<String> zzdr() {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (zzbp zzbp : this.zzvv) {
            String str = (String) zzbp.get();
            if (str != null) {
                boolean add = arrayList4.add(str);
            }
        }
        return arrayList4;
    }

    public List<String> zzds() {
        List zzdr = zzdr();
        for (zzbp zzbp : this.zzvw) {
            String str = (String) zzbp.get();
            if (str != null) {
                boolean add = zzdr.add(str);
            }
        }
        return zzdr;
    }
}
