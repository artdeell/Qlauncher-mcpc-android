package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.internal.zzhb;
import java.util.ArrayList;
import java.util.List;

@zzhb
public final class zzf {
    private Bundle mExtras;
    private Location zzbj;
    private boolean zzpE;
    private long zztS;
    private int zztT;
    private List<String> zztU;
    private boolean zztV;
    private int zztW;
    private String zztX;
    private SearchAdRequestParcel zztY;
    private String zztZ;
    private Bundle zzua;
    private Bundle zzub;
    private List<String> zzuc;
    private String zzud;
    private String zzue;
    private boolean zzuf;

    public zzf() {
        Bundle bundle;
        ArrayList arrayList;
        Bundle bundle2;
        Bundle bundle3;
        ArrayList arrayList2;
        this.zztS = -1;
        Bundle bundle4 = bundle;
        Bundle bundle5 = new Bundle();
        this.mExtras = bundle4;
        this.zztT = -1;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = new ArrayList();
        this.zztU = arrayList3;
        this.zztV = false;
        this.zztW = -1;
        this.zzpE = false;
        this.zztX = null;
        this.zztY = null;
        this.zzbj = null;
        this.zztZ = null;
        Bundle bundle6 = bundle2;
        Bundle bundle7 = new Bundle();
        this.zzua = bundle6;
        Bundle bundle8 = bundle3;
        Bundle bundle9 = new Bundle();
        this.zzub = bundle8;
        ArrayList arrayList5 = arrayList2;
        ArrayList arrayList6 = new ArrayList();
        this.zzuc = arrayList5;
        this.zzud = null;
        this.zzue = null;
        this.zzuf = false;
    }

    public zzf(AdRequestParcel adRequestParcel) {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        this.zztS = adRequestParcel2.zztC;
        this.mExtras = adRequestParcel2.extras;
        this.zztT = adRequestParcel2.zztD;
        this.zztU = adRequestParcel2.zztE;
        this.zztV = adRequestParcel2.zztF;
        this.zztW = adRequestParcel2.zztG;
        this.zzpE = adRequestParcel2.zztH;
        this.zztX = adRequestParcel2.zztI;
        this.zztY = adRequestParcel2.zztJ;
        this.zzbj = adRequestParcel2.zztK;
        this.zztZ = adRequestParcel2.zztL;
        this.zzua = adRequestParcel2.zztM;
        this.zzub = adRequestParcel2.zztN;
        this.zzuc = adRequestParcel2.zztO;
        this.zzud = adRequestParcel2.zztP;
        this.zzue = adRequestParcel2.zztQ;
    }

    public zzf zza(Location location) {
        this.zzbj = location;
        return this;
    }

    public AdRequestParcel zzcN() {
        AdRequestParcel adRequestParcel;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        AdRequestParcel adRequestParcel3 = new AdRequestParcel(7, this.zztS, this.mExtras, this.zztT, this.zztU, this.zztV, this.zztW, this.zzpE, this.zztX, this.zztY, this.zzbj, this.zztZ, this.zzua, this.zzub, this.zzuc, this.zzud, this.zzue, this.zzuf);
        return adRequestParcel2;
    }
}
