package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, zza<String, Integer> {
    public static final zzb CREATOR;
    private final int mVersionCode;
    private final HashMap<String, Integer> zzamG;
    private final HashMap<Integer, String> zzamH;
    private final ArrayList<Entry> zzamI;

    public static final class Entry implements SafeParcelable {
        public static final zzc CREATOR;
        final int versionCode;
        final String zzamJ;
        final int zzamK;

        static {
            zzc zzc;
            zzc zzc2 = zzc;
            zzc zzc3 = new zzc();
            CREATOR = zzc2;
        }

        Entry(int i, String str, int i2) {
            String str2 = str;
            int i3 = i2;
            this.versionCode = i;
            this.zzamJ = str2;
            this.zzamK = i3;
        }

        Entry(String str, int i) {
            String str2 = str;
            int i2 = i;
            this.versionCode = 1;
            this.zzamJ = str2;
            this.zzamK = i2;
        }

        public int describeContents() {
            zzc zzc = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Parcel parcel2 = parcel;
            int i2 = i;
            zzc zzc = CREATOR;
            zzc.zza(this, parcel2, i2);
        }
    }

    static {
        zzb zzb;
        zzb zzb2 = zzb;
        zzb zzb3 = new zzb();
        CREATOR = zzb2;
    }

    public StringToIntConverter() {
        HashMap<String, Integer> hashMap;
        HashMap<Integer, String> hashMap2;
        this.mVersionCode = 1;
        HashMap<String, Integer> hashMap3 = hashMap;
        HashMap<String, Integer> hashMap4 = new HashMap<>();
        this.zzamG = hashMap3;
        HashMap<Integer, String> hashMap5 = hashMap2;
        HashMap<Integer, String> hashMap6 = new HashMap<>();
        this.zzamH = hashMap5;
        this.zzamI = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        HashMap<String, Integer> hashMap;
        HashMap<Integer, String> hashMap2;
        ArrayList<Entry> arrayList2 = arrayList;
        this.mVersionCode = i;
        HashMap<String, Integer> hashMap3 = hashMap;
        HashMap<String, Integer> hashMap4 = new HashMap<>();
        this.zzamG = hashMap3;
        HashMap<Integer, String> hashMap5 = hashMap2;
        HashMap<Integer, String> hashMap6 = new HashMap<>();
        this.zzamH = hashMap5;
        this.zzamI = null;
        zzd(arrayList2);
    }

    private void zzd(ArrayList<Entry> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            StringToIntConverter zzh = zzh(entry.zzamJ, entry.zzamK);
        }
    }

    public int describeContents() {
        zzb zzb = CREATOR;
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        zzb zzb = CREATOR;
        zzb.zza(this, parcel2, i2);
    }

    /* renamed from: zzb */
    public String convertBack(Integer num) {
        String str = (String) this.zzamH.get(num);
        if (str == null && this.zzamG.containsKey("gms_unknown")) {
            str = "gms_unknown";
        }
        return str;
    }

    public StringToIntConverter zzh(String str, int i) {
        String str2 = str;
        int i2 = i;
        Object put = this.zzamG.put(str2, Integer.valueOf(i2));
        Object put2 = this.zzamH.put(Integer.valueOf(i2), str2);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public ArrayList<Entry> zzri() {
        ArrayList arrayList;
        Entry entry;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (String str : this.zzamG.keySet()) {
            ArrayList arrayList5 = arrayList4;
            Entry entry2 = entry;
            Entry entry3 = new Entry(str, ((Integer) this.zzamG.get(str)).intValue());
            boolean add = arrayList5.add(entry2);
        }
        return arrayList4;
    }

    public int zzrj() {
        return 7;
    }

    public int zzrk() {
        return 0;
    }
}
