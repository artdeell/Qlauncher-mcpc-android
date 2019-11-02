package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary implements SafeParcelable {
    public static final zzc CREATOR;
    private final int mVersionCode;
    private final HashMap<String, Map<String, Field<?, ?>>> zzamV;
    private final ArrayList<Entry> zzamW;
    private final String zzamX;

    public static class Entry implements SafeParcelable {
        public static final zzd CREATOR;
        final String className;
        final int versionCode;
        final ArrayList<FieldMapPair> zzamY;

        static {
            zzd zzd;
            zzd zzd2 = zzd;
            zzd zzd3 = new zzd();
            CREATOR = zzd2;
        }

        Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
            String str2 = str;
            ArrayList<FieldMapPair> arrayList2 = arrayList;
            this.versionCode = i;
            this.className = str2;
            this.zzamY = arrayList2;
        }

        Entry(String str, Map<String, Field<?, ?>> map) {
            String str2 = str;
            Map<String, Field<?, ?>> map2 = map;
            this.versionCode = 1;
            this.className = str2;
            this.zzamY = zzM(map2);
        }

        private static ArrayList<FieldMapPair> zzM(Map<String, Field<?, ?>> map) {
            ArrayList arrayList;
            FieldMapPair fieldMapPair;
            Map<String, Field<?, ?>> map2 = map;
            if (map2 == null) {
                return null;
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList2;
            for (String str : map2.keySet()) {
                ArrayList arrayList5 = arrayList4;
                FieldMapPair fieldMapPair2 = fieldMapPair;
                FieldMapPair fieldMapPair3 = new FieldMapPair(str, (Field) map2.get(str));
                boolean add = arrayList5.add(fieldMapPair2);
            }
            return arrayList4;
        }

        public int describeContents() {
            zzd zzd = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Parcel parcel2 = parcel;
            int i2 = i;
            zzd zzd = CREATOR;
            zzd.zza(this, parcel2, i2);
        }

        /* access modifiers changed from: 0000 */
        public HashMap<String, Field<?, ?>> zzrC() {
            HashMap hashMap;
            HashMap hashMap2 = hashMap;
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = hashMap2;
            int size = this.zzamY.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = (FieldMapPair) this.zzamY.get(i);
                Object put = hashMap4.put(fieldMapPair.key, fieldMapPair.zzamZ);
            }
            return hashMap4;
        }
    }

    public static class FieldMapPair implements SafeParcelable {
        public static final zzb CREATOR;
        final String key;
        final int versionCode;
        final Field<?, ?> zzamZ;

        static {
            zzb zzb;
            zzb zzb2 = zzb;
            zzb zzb3 = new zzb();
            CREATOR = zzb2;
        }

        FieldMapPair(int i, String str, Field<?, ?> field) {
            String str2 = str;
            Field<?, ?> field2 = field;
            this.versionCode = i;
            this.key = str2;
            this.zzamZ = field2;
        }

        FieldMapPair(String str, Field<?, ?> field) {
            String str2 = str;
            Field<?, ?> field2 = field;
            this.versionCode = 1;
            this.key = str2;
            this.zzamZ = field2;
        }

        public int describeContents() {
            zzb zzb = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Parcel parcel2 = parcel;
            int i2 = i;
            zzb zzb = CREATOR;
            zzb.zza(this, parcel2, i2);
        }
    }

    static {
        zzc zzc;
        zzc zzc2 = zzc;
        zzc zzc3 = new zzc();
        CREATOR = zzc2;
    }

    FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        ArrayList<Entry> arrayList2 = arrayList;
        String str2 = str;
        this.mVersionCode = i;
        this.zzamW = null;
        this.zzamV = zze(arrayList2);
        this.zzamX = (String) zzx.zzz(str2);
        zzry();
    }

    public FieldMappingDictionary(Class<? extends FastJsonResponse> cls) {
        HashMap<String, Map<String, Field<?, ?>>> hashMap;
        Class<? extends FastJsonResponse> cls2 = cls;
        this.mVersionCode = 1;
        this.zzamW = null;
        HashMap<String, Map<String, Field<?, ?>>> hashMap2 = hashMap;
        HashMap<String, Map<String, Field<?, ?>>> hashMap3 = new HashMap<>();
        this.zzamV = hashMap2;
        this.zzamX = cls2.getCanonicalName();
    }

    private static HashMap<String, Map<String, Field<?, ?>>> zze(ArrayList<Entry> arrayList) {
        HashMap hashMap;
        ArrayList<Entry> arrayList2 = arrayList;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = hashMap2;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList2.get(i);
            Object put = hashMap4.put(entry.className, entry.zzrC());
        }
        return hashMap4;
    }

    public int describeContents() {
        zzc zzc = CREATOR;
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        for (String str : this.zzamV.keySet()) {
            StringBuilder append = sb4.append(str).append(":\n");
            Map map = (Map) this.zzamV.get(str);
            for (String str2 : map.keySet()) {
                StringBuilder append2 = sb4.append("  ").append(str2).append(": ");
                StringBuilder append3 = sb4.append(map.get(str2));
            }
        }
        return sb4.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        zzc zzc = CREATOR;
        zzc.zza(this, parcel2, i2);
    }

    public void zza(Class<? extends FastJsonResponse> cls, Map<String, Field<?, ?>> map) {
        Map<String, Field<?, ?>> map2 = map;
        Object put = this.zzamV.put(cls.getCanonicalName(), map2);
    }

    public boolean zzb(Class<? extends FastJsonResponse> cls) {
        return this.zzamV.containsKey(cls.getCanonicalName());
    }

    public Map<String, Field<?, ?>> zzcR(String str) {
        return (Map) this.zzamV.get(str);
    }

    /* access modifiers changed from: 0000 */
    public ArrayList<Entry> zzrA() {
        ArrayList arrayList;
        Entry entry;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (String str : this.zzamV.keySet()) {
            ArrayList arrayList5 = arrayList4;
            Entry entry2 = entry;
            Entry entry3 = new Entry(str, (Map) this.zzamV.get(str));
            boolean add = arrayList5.add(entry2);
        }
        return arrayList4;
    }

    public String zzrB() {
        return this.zzamX;
    }

    public void zzry() {
        for (String str : this.zzamV.keySet()) {
            Map map = (Map) this.zzamV.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).zza(this);
            }
        }
    }

    public void zzrz() {
        HashMap hashMap;
        for (String str : this.zzamV.keySet()) {
            Map map = (Map) this.zzamV.get(str);
            HashMap hashMap2 = hashMap;
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = hashMap2;
            for (String str2 : map.keySet()) {
                Object put = hashMap4.put(str2, ((Field) map.get(str2)).zzro());
            }
            Object put2 = this.zzamV.put(str, hashMap4);
        }
    }
}
