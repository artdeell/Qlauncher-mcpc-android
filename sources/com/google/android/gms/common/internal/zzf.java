package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.auth.zzd;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzro;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzf {
    private final Account zzTI;
    private final String zzUW;
    private final Set<Scope> zzagh;
    private final int zzagj;
    private final View zzagk;
    private final String zzagl;
    private final Set<Scope> zzalb;
    private final Map<Api<?>, zza> zzalc;
    private final zzro zzald;
    private Integer zzale;

    public static final class zza {
        public final Set<Scope> zzXf;
        public final boolean zzalf;

        public zza(Set<Scope> set, boolean z) {
            Set<Scope> set2 = set;
            boolean z2 = z;
            Object zzz = zzx.zzz(set2);
            this.zzXf = Collections.unmodifiableSet(set2);
            this.zzalf = z2;
        }
    }

    public zzf(Account account, Set<Scope> set, Map<Api<?>, zza> map, int i, View view, String str, String str2, zzro zzro) {
        HashSet hashSet;
        Set<Scope> set2 = set;
        Map<Api<?>, zza> map2 = map;
        int i2 = i;
        View view2 = view;
        String str3 = str;
        String str4 = str2;
        zzro zzro2 = zzro;
        this.zzTI = account;
        this.zzagh = set2 == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set2);
        if (map2 == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.zzalc = map2;
        this.zzagk = view2;
        this.zzagj = i2;
        this.zzUW = str3;
        this.zzagl = str4;
        this.zzald = zzro2;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet(this.zzagh);
        HashSet hashSet4 = hashSet2;
        for (zza zza2 : this.zzalc.values()) {
            boolean addAll = hashSet4.addAll(zza2.zzXf);
        }
        this.zzalb = Collections.unmodifiableSet(hashSet4);
    }

    public static zzf zzat(Context context) {
        Builder builder;
        Builder builder2 = builder;
        Builder builder3 = new Builder(context);
        return builder2.zzoY();
    }

    public Account getAccount() {
        return this.zzTI;
    }

    @Deprecated
    public String getAccountName() {
        if (this.zzTI != null) {
            return this.zzTI.name;
        }
        return null;
    }

    public void zza(Integer num) {
        Integer num2 = num;
        this.zzale = num2;
    }

    public Set<Scope> zzb(Api<?> api) {
        HashSet hashSet;
        zza zza2 = (zza) this.zzalc.get(api);
        if (zza2 == null || zza2.zzXf.isEmpty()) {
            return this.zzagh;
        }
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet(this.zzagh);
        HashSet hashSet4 = hashSet2;
        boolean addAll = hashSet4.addAll(zza2.zzXf);
        return hashSet4;
    }

    public Account zzqq() {
        Account account;
        if (this.zzTI != null) {
            return this.zzTI;
        }
        Account account2 = account;
        Account account3 = new Account("<<default account>>", zzd.GOOGLE_ACCOUNT_TYPE);
        return account2;
    }

    public int zzqr() {
        return this.zzagj;
    }

    public Set<Scope> zzqs() {
        return this.zzagh;
    }

    public Set<Scope> zzqt() {
        return this.zzalb;
    }

    public Map<Api<?>, zza> zzqu() {
        return this.zzalc;
    }

    public String zzqv() {
        return this.zzUW;
    }

    public String zzqw() {
        return this.zzagl;
    }

    public View zzqx() {
        return this.zzagk;
    }

    public zzro zzqy() {
        return this.zzald;
    }

    public Integer zzqz() {
        return this.zzale;
    }
}
