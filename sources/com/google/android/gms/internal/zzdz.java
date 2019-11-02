package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@zzhb
class zzdz {
    private final Object[] mParams;
    private boolean zzAA;

    zzdz(AdRequestParcel adRequestParcel, String str, int i) {
        this.mParams = zza(adRequestParcel, str, i);
    }

    private static Object[] zza(AdRequestParcel adRequestParcel, String str, int i) {
        HashSet hashSet;
        ArrayList arrayList;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        String str2 = str;
        int i2 = i;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet(Arrays.asList(((String) zzbt.zzwF.get()).split(",")));
        HashSet hashSet4 = hashSet2;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        boolean add = arrayList4.add(str2);
        if (hashSet4.contains("networkType")) {
            boolean add2 = arrayList4.add(Integer.valueOf(i2));
        }
        if (hashSet4.contains("birthday")) {
            boolean add3 = arrayList4.add(Long.valueOf(adRequestParcel2.zztC));
        }
        if (hashSet4.contains("extras")) {
            boolean add4 = arrayList4.add(zzc(adRequestParcel2.extras));
        }
        if (hashSet4.contains("gender")) {
            boolean add5 = arrayList4.add(Integer.valueOf(adRequestParcel2.zztD));
        }
        if (hashSet4.contains("keywords")) {
            if (adRequestParcel2.zztE != null) {
                boolean add6 = arrayList4.add(adRequestParcel2.zztE.toString());
            } else {
                boolean add7 = arrayList4.add(null);
            }
        }
        if (hashSet4.contains("isTestDevice")) {
            boolean add8 = arrayList4.add(Boolean.valueOf(adRequestParcel2.zztF));
        }
        if (hashSet4.contains("tagForChildDirectedTreatment")) {
            boolean add9 = arrayList4.add(Integer.valueOf(adRequestParcel2.zztG));
        }
        if (hashSet4.contains("manualImpressionsEnabled")) {
            boolean add10 = arrayList4.add(Boolean.valueOf(adRequestParcel2.zztH));
        }
        if (hashSet4.contains("publisherProvidedId")) {
            boolean add11 = arrayList4.add(adRequestParcel2.zztI);
        }
        if (hashSet4.contains("location")) {
            if (adRequestParcel2.zztK != null) {
                boolean add12 = arrayList4.add(adRequestParcel2.zztK.toString());
            } else {
                boolean add13 = arrayList4.add(null);
            }
        }
        if (hashSet4.contains("contentUrl")) {
            boolean add14 = arrayList4.add(adRequestParcel2.zztL);
        }
        if (hashSet4.contains("networkExtras")) {
            boolean add15 = arrayList4.add(zzc(adRequestParcel2.zztM));
        }
        if (hashSet4.contains("customTargeting")) {
            boolean add16 = arrayList4.add(zzc(adRequestParcel2.zztN));
        }
        if (hashSet4.contains("categoryExclusions")) {
            if (adRequestParcel2.zztO != null) {
                boolean add17 = arrayList4.add(adRequestParcel2.zztO.toString());
            } else {
                boolean add18 = arrayList4.add(null);
            }
        }
        if (hashSet4.contains("requestAgent")) {
            boolean add19 = arrayList4.add(adRequestParcel2.zztP);
        }
        if (hashSet4.contains("requestPackage")) {
            boolean add20 = arrayList4.add(adRequestParcel2.zztQ);
        }
        return arrayList4.toArray();
    }

    private static String zzc(Bundle bundle) {
        StringBuilder sb;
        ArrayList arrayList;
        Bundle bundle2 = bundle;
        if (bundle2 == null) {
            return null;
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(bundle2.keySet());
        Collections.sort(arrayList2);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            String obj2 = obj == null ? "null" : obj instanceof Bundle ? zzc((Bundle) obj) : obj.toString();
            StringBuilder append = sb4.append(obj2);
        }
        return sb4.toString();
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof zzdz)) {
            return false;
        }
        return Arrays.equals(this.mParams, ((zzdz) obj2).mParams);
    }

    public int hashCode() {
        return Arrays.hashCode(this.mParams);
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("[InterstitialAdPoolKey ").append(Arrays.toString(this.mParams)).append("]").toString();
    }

    /* access modifiers changed from: 0000 */
    public void zzeg() {
        this.zzAA = true;
    }

    /* access modifiers changed from: 0000 */
    public boolean zzeh() {
        return this.zzAA;
    }
}
