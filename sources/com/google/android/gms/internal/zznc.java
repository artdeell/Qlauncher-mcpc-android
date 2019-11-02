package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Iterator;

public class zznc {
    public static void zza(StringBuilder sb, HashMap<String, String> hashMap) {
        boolean z;
        StringBuilder sb2 = sb;
        HashMap<String, String> hashMap2 = hashMap;
        StringBuilder append = sb2.append("{");
        Iterator it = hashMap2.keySet().iterator();
        boolean z2 = true;
        while (true) {
            boolean z3 = z2;
            if (it.hasNext()) {
                String str = (String) it.next();
                if (!z3) {
                    StringBuilder append2 = sb2.append(",");
                    z = z3;
                } else {
                    z = false;
                }
                String str2 = (String) hashMap2.get(str);
                StringBuilder append3 = sb2.append("\"").append(str).append("\":");
                if (str2 == null) {
                    StringBuilder append4 = sb2.append("null");
                } else {
                    StringBuilder append5 = sb2.append("\"").append(str2).append("\"");
                }
                z2 = z;
            } else {
                StringBuilder append6 = sb2.append("}");
                return;
            }
        }
    }
}
