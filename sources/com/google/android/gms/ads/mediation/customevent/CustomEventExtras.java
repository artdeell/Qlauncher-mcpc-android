package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements NetworkExtras {
    private final HashMap<String, Object> zzOv;

    public CustomEventExtras() {
        HashMap<String, Object> hashMap;
        HashMap<String, Object> hashMap2 = hashMap;
        HashMap<String, Object> hashMap3 = new HashMap<>();
        this.zzOv = hashMap2;
    }

    public Object getExtra(String str) {
        return this.zzOv.get(str);
    }

    public void setExtra(String str, Object obj) {
        String str2 = str;
        Object obj2 = obj;
        Object put = this.zzOv.put(str2, obj2);
    }
}
