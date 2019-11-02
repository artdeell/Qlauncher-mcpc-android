package com.google.android.gms.internal;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import java.util.Set;

public final class zznh {
    public static String[] zzb(Scope[] scopeArr) {
        Scope[] scopeArr2 = scopeArr;
        Object zzb = zzx.zzb(scopeArr2, (Object) "scopes can't be null.");
        String[] strArr = new String[scopeArr2.length];
        for (int i = 0; i < scopeArr2.length; i++) {
            strArr[i] = scopeArr2[i].zzpb();
        }
        return strArr;
    }

    public static String[] zzc(Set<Scope> set) {
        Set<Scope> set2 = set;
        Object zzb = zzx.zzb(set2, (Object) "scopes can't be null.");
        return zzb((Scope[]) set2.toArray(new Scope[set2.size()]));
    }
}
