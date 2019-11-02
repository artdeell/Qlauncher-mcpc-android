package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

@zzhb
public class zziv {
    private final String[] zzMn;
    private final double[] zzMo;
    private final double[] zzMp;
    private final int[] zzMq;
    private int zzMr;

    public static class zza {
        public final int count;
        public final String name;
        public final double zzMs;
        public final double zzMt;
        public final double zzMu;

        public zza(String str, double d, double d2, double d3, int i) {
            double d4 = d;
            double d5 = d2;
            double d6 = d3;
            int i2 = i;
            this.name = str;
            this.zzMt = d4;
            this.zzMs = d5;
            this.zzMu = d6;
            this.count = i2;
        }

        public boolean equals(Object obj) {
            Object obj2 = obj;
            if (obj2 instanceof zza) {
                zza zza = (zza) obj2;
                if (zzw.equal(this.name, zza.name) && this.zzMs == zza.zzMs && this.zzMt == zza.zzMt && this.count == zza.count && Double.compare(this.zzMu, zza.zzMu) == 0) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return zzw.hashCode(this.name, Double.valueOf(this.zzMs), Double.valueOf(this.zzMt), Double.valueOf(this.zzMu), Integer.valueOf(this.count));
        }

        public String toString() {
            return zzw.zzy(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzMt)).zzg("maxBound", Double.valueOf(this.zzMs)).zzg("percent", Double.valueOf(this.zzMu)).zzg("count", Integer.valueOf(this.count)).toString();
        }
    }

    public static class zzb {
        /* access modifiers changed from: private */
        public final List<String> zzMv;
        /* access modifiers changed from: private */
        public final List<Double> zzMw;
        /* access modifiers changed from: private */
        public final List<Double> zzMx;

        public zzb() {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            ArrayList arrayList4 = arrayList;
            ArrayList arrayList5 = new ArrayList();
            this.zzMv = arrayList4;
            ArrayList arrayList6 = arrayList2;
            ArrayList arrayList7 = new ArrayList();
            this.zzMw = arrayList6;
            ArrayList arrayList8 = arrayList3;
            ArrayList arrayList9 = new ArrayList();
            this.zzMx = arrayList8;
        }

        public zzb zza(String str, double d, double d2) {
            String str2 = str;
            double d3 = d;
            double d4 = d2;
            int i = 0;
            while (i < this.zzMv.size()) {
                double doubleValue = ((Double) this.zzMx.get(i)).doubleValue();
                double doubleValue2 = ((Double) this.zzMw.get(i)).doubleValue();
                if (d3 < doubleValue || (doubleValue == d3 && d4 < doubleValue2)) {
                    break;
                }
                i++;
            }
            this.zzMv.add(i, str2);
            this.zzMx.add(i, Double.valueOf(d3));
            this.zzMw.add(i, Double.valueOf(d4));
            return this;
        }

        public zziv zzhA() {
            zziv zziv;
            zziv zziv2 = zziv;
            zziv zziv3 = new zziv(this, null);
            return zziv2;
        }
    }

    private zziv(zzb zzb2) {
        zzb zzb3 = zzb2;
        int size = zzb3.zzMw.size();
        this.zzMn = (String[]) zzb3.zzMv.toArray(new String[size]);
        this.zzMo = zzk(zzb3.zzMw);
        this.zzMp = zzk(zzb3.zzMx);
        this.zzMq = new int[size];
        this.zzMr = 0;
    }

    /* synthetic */ zziv(zzb zzb2, C04211 r7) {
        C04211 r2 = r7;
        this(zzb2);
    }

    private double[] zzk(List<Double> list) {
        List<Double> list2 = list;
        double[] dArr = new double[list2.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list2.get(i)).doubleValue();
        }
        return dArr;
    }

    public List<zza> getBuckets() {
        ArrayList arrayList;
        zza zza2;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(this.zzMn.length);
        ArrayList arrayList4 = arrayList2;
        for (int i = 0; i < this.zzMn.length; i++) {
            ArrayList arrayList5 = arrayList4;
            zza zza3 = zza2;
            zza zza4 = new zza(this.zzMn[i], this.zzMp[i], this.zzMo[i], ((double) this.zzMq[i]) / ((double) this.zzMr), this.zzMq[i]);
            boolean add = arrayList5.add(zza3);
        }
        return arrayList4;
    }

    public void zza(double d) {
        double d2 = d;
        this.zzMr = 1 + this.zzMr;
        int i = 0;
        while (i < this.zzMp.length) {
            if (this.zzMp[i] <= d2 && d2 < this.zzMo[i]) {
                int[] iArr = this.zzMq;
                iArr[i] = 1 + iArr[i];
            }
            if (d2 >= this.zzMp[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
