package com.google.android.gms.internal;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@zzhb
public class zzej implements zzei {
    private final zzeh zzBx;
    private final HashSet<SimpleEntry<String, zzdf>> zzBy;

    public zzej(zzeh zzeh) {
        HashSet<SimpleEntry<String, zzdf>> hashSet;
        this.zzBx = zzeh;
        HashSet<SimpleEntry<String, zzdf>> hashSet2 = hashSet;
        HashSet<SimpleEntry<String, zzdf>> hashSet3 = new HashSet<>();
        this.zzBy = hashSet2;
    }

    public void zza(String str, zzdf zzdf) {
        SimpleEntry simpleEntry;
        String str2 = str;
        zzdf zzdf2 = zzdf;
        this.zzBx.zza(str2, zzdf2);
        HashSet<SimpleEntry<String, zzdf>> hashSet = this.zzBy;
        SimpleEntry simpleEntry2 = simpleEntry;
        SimpleEntry simpleEntry3 = new SimpleEntry(str2, zzdf2);
        boolean add = hashSet.add(simpleEntry2);
    }

    public void zza(String str, JSONObject jSONObject) {
        String str2 = str;
        JSONObject jSONObject2 = jSONObject;
        this.zzBx.zza(str2, jSONObject2);
    }

    public void zzb(String str, zzdf zzdf) {
        SimpleEntry simpleEntry;
        String str2 = str;
        zzdf zzdf2 = zzdf;
        this.zzBx.zzb(str2, zzdf2);
        HashSet<SimpleEntry<String, zzdf>> hashSet = this.zzBy;
        SimpleEntry simpleEntry2 = simpleEntry;
        SimpleEntry simpleEntry3 = new SimpleEntry(str2, zzdf2);
        boolean remove = hashSet.remove(simpleEntry2);
    }

    public void zzb(String str, JSONObject jSONObject) {
        String str2 = str;
        JSONObject jSONObject2 = jSONObject;
        this.zzBx.zzb(str2, jSONObject2);
    }

    public void zze(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        this.zzBx.zze(str3, str4);
    }

    public void zzew() {
        StringBuilder sb;
        Iterator it = this.zzBy.iterator();
        while (it.hasNext()) {
            SimpleEntry simpleEntry = (SimpleEntry) it.next();
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.m20v(sb2.append("Unregistering eventhandler: ").append(((zzdf) simpleEntry.getValue()).toString()).toString());
            this.zzBx.zzb((String) simpleEntry.getKey(), (zzdf) simpleEntry.getValue());
        }
        this.zzBy.clear();
    }
}
