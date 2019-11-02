package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzhb;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzhb
public final class zzaa {
    public static final String DEVICE_ID_EMULATOR = zzn.zzcS().zzaH("emulator");
    private final Date zzbf;
    private final Set<String> zzbh;
    private final Location zzbj;
    private final boolean zzpE;
    private final int zztT;
    private final int zztW;
    private final String zztX;
    private final String zztZ;
    private final Bundle zzuA;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzuB;
    private final SearchAdRequest zzuC;
    private final Set<String> zzuD;
    private final Set<String> zzuE;
    private final Bundle zzub;
    private final String zzud;
    private final boolean zzuf;

    public static final class zza {
        /* access modifiers changed from: private */
        public Date zzbf;
        /* access modifiers changed from: private */
        public Location zzbj;
        /* access modifiers changed from: private */
        public boolean zzpE = false;
        /* access modifiers changed from: private */
        public int zztT = -1;
        /* access modifiers changed from: private */
        public int zztW = -1;
        /* access modifiers changed from: private */
        public String zztX;
        /* access modifiers changed from: private */
        public String zztZ;
        /* access modifiers changed from: private */
        public final Bundle zzuA;
        /* access modifiers changed from: private */
        public final HashSet<String> zzuF;
        /* access modifiers changed from: private */
        public final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzuG;
        /* access modifiers changed from: private */
        public final HashSet<String> zzuH;
        /* access modifiers changed from: private */
        public final HashSet<String> zzuI;
        /* access modifiers changed from: private */
        public final Bundle zzub;
        /* access modifiers changed from: private */
        public String zzud;
        /* access modifiers changed from: private */
        public boolean zzuf;

        public zza() {
            HashSet<String> hashSet;
            Bundle bundle;
            HashMap<Class<? extends NetworkExtras>, NetworkExtras> hashMap;
            HashSet<String> hashSet2;
            Bundle bundle2;
            HashSet<String> hashSet3;
            HashSet<String> hashSet4 = hashSet;
            HashSet<String> hashSet5 = new HashSet<>();
            this.zzuF = hashSet4;
            Bundle bundle3 = bundle;
            Bundle bundle4 = new Bundle();
            this.zzuA = bundle3;
            HashMap<Class<? extends NetworkExtras>, NetworkExtras> hashMap2 = hashMap;
            HashMap<Class<? extends NetworkExtras>, NetworkExtras> hashMap3 = new HashMap<>();
            this.zzuG = hashMap2;
            HashSet<String> hashSet6 = hashSet2;
            HashSet<String> hashSet7 = new HashSet<>();
            this.zzuH = hashSet6;
            Bundle bundle5 = bundle2;
            Bundle bundle6 = new Bundle();
            this.zzub = bundle5;
            HashSet<String> hashSet8 = hashSet3;
            HashSet<String> hashSet9 = new HashSet<>();
            this.zzuI = hashSet8;
        }

        public void setManualImpressionsEnabled(boolean z) {
            boolean z2 = z;
            this.zzpE = z2;
        }

        public void zzA(String str) {
            String str2 = str;
            boolean add = this.zzuF.add(str2);
        }

        public void zzB(String str) {
            String str2 = str;
            boolean add = this.zzuH.add(str2);
        }

        public void zzC(String str) {
            String str2 = str;
            boolean remove = this.zzuH.remove(str2);
        }

        public void zzD(String str) {
            String str2 = str;
            this.zztZ = str2;
        }

        public void zzE(String str) {
            String str2 = str;
            this.zztX = str2;
        }

        public void zzF(String str) {
            String str2 = str;
            this.zzud = str2;
        }

        public void zzG(String str) {
            String str2 = str;
            boolean add = this.zzuI.add(str2);
        }

        @Deprecated
        public void zza(NetworkExtras networkExtras) {
            NetworkExtras networkExtras2 = networkExtras;
            if (networkExtras2 instanceof AdMobExtras) {
                zza(AdMobAdapter.class, ((AdMobExtras) networkExtras2).getExtras());
            } else {
                Object put = this.zzuG.put(networkExtras2.getClass(), networkExtras2);
            }
        }

        public void zza(Class<? extends MediationAdapter> cls, Bundle bundle) {
            Bundle bundle2 = bundle;
            this.zzuA.putBundle(cls.getName(), bundle2);
        }

        public void zza(String str, String str2) {
            String str3 = str;
            String str4 = str2;
            this.zzub.putString(str3, str4);
        }

        public void zza(Date date) {
            Date date2 = date;
            this.zzbf = date2;
        }

        public void zzb(Location location) {
            Location location2 = location;
            this.zzbj = location2;
        }

        public void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
            Bundle bundle2;
            Class<? extends CustomEvent> cls2 = cls;
            Bundle bundle3 = bundle;
            if (this.zzuA.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                Bundle bundle4 = bundle2;
                Bundle bundle5 = new Bundle();
                this.zzuA.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", bundle4);
            }
            this.zzuA.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls2.getName(), bundle3);
        }

        public void zzk(boolean z) {
            this.zztW = z ? 1 : 0;
        }

        public void zzl(boolean z) {
            boolean z2 = z;
            this.zzuf = z2;
        }

        public void zzn(int i) {
            int i2 = i;
            this.zztT = i2;
        }
    }

    public zzaa(zza zza2) {
        this(zza2, null);
    }

    public zzaa(zza zza2, SearchAdRequest searchAdRequest) {
        zza zza3 = zza2;
        SearchAdRequest searchAdRequest2 = searchAdRequest;
        this.zzbf = zza3.zzbf;
        this.zztZ = zza3.zztZ;
        this.zztT = zza3.zztT;
        this.zzbh = Collections.unmodifiableSet(zza3.zzuF);
        this.zzbj = zza3.zzbj;
        this.zzpE = zza3.zzpE;
        this.zzuA = zza3.zzuA;
        this.zzuB = Collections.unmodifiableMap(zza3.zzuG);
        this.zztX = zza3.zztX;
        this.zzud = zza3.zzud;
        this.zzuC = searchAdRequest2;
        this.zztW = zza3.zztW;
        this.zzuD = Collections.unmodifiableSet(zza3.zzuH);
        this.zzub = zza3.zzub;
        this.zzuE = Collections.unmodifiableSet(zza3.zzuI);
        this.zzuf = zza3.zzuf;
    }

    public Date getBirthday() {
        return this.zzbf;
    }

    public String getContentUrl() {
        return this.zztZ;
    }

    public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Class<? extends CustomEvent> cls2 = cls;
        Bundle bundle = this.zzuA.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls2.getClass().getName());
        }
        return null;
    }

    public Bundle getCustomTargeting() {
        return this.zzub;
    }

    public int getGender() {
        return this.zztT;
    }

    public Set<String> getKeywords() {
        return this.zzbh;
    }

    public Location getLocation() {
        return this.zzbj;
    }

    public boolean getManualImpressionsEnabled() {
        return this.zzpE;
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (NetworkExtras) this.zzuB.get(cls);
    }

    public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> cls) {
        return this.zzuA.getBundle(cls.getName());
    }

    public String getPublisherProvidedId() {
        return this.zztX;
    }

    public boolean isDesignedForFamilies() {
        return this.zzuf;
    }

    public boolean isTestDevice(Context context) {
        return this.zzuD.contains(zzn.zzcS().zzT(context));
    }

    public String zzcZ() {
        return this.zzud;
    }

    public SearchAdRequest zzda() {
        return this.zzuC;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> zzdb() {
        return this.zzuB;
    }

    public Bundle zzdc() {
        return this.zzuA;
    }

    public int zzdd() {
        return this.zztW;
    }

    public Set<String> zzde() {
        return this.zzuE;
    }
}
