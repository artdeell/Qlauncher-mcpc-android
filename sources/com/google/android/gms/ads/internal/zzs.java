package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.p000v4.util.SimpleArrayMap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zziu;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzjc;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

@zzhb
public final class zzs implements OnGlobalLayoutListener, OnScrollChangedListener {
    public final Context context;
    boolean zzql;
    zzcs zzrA;
    SimpleArrayMap<String, zzct> zzrB;
    SimpleArrayMap<String, zzcu> zzrC;
    NativeAdOptionsParcel zzrD;
    zzcf zzrE;
    @Nullable
    zzd zzrF;
    @Nullable
    private String zzrG;
    List<String> zzrH;
    zzk zzrI;
    public zzik zzrJ;
    View zzrK;
    public int zzrL;
    boolean zzrM;
    private HashSet<zzig> zzrN;
    private int zzrO;
    private int zzrP;
    private zziz zzrQ;
    private boolean zzrR;
    private boolean zzrS;
    private boolean zzrT;
    final String zzri;
    public String zzrj;
    final zzan zzrk;
    public final VersionInfoParcel zzrl;
    zza zzrm;
    public zzim zzrn;
    public zzit zzro;
    public AdSizeParcel zzrp;
    public zzif zzrq;
    public com.google.android.gms.internal.zzif.zza zzrr;
    public zzig zzrs;
    zzp zzrt;
    zzq zzru;
    zzw zzrv;
    zzx zzrw;
    zzgd zzrx;
    zzgh zzry;
    zzcr zzrz;

    public static class zza extends ViewSwitcher {
        private final zziu zzrU;
        private final zzjc zzrV;

        public zza(Context context, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
            zziu zziu;
            zzjc zzjc;
            Context context2 = context;
            OnGlobalLayoutListener onGlobalLayoutListener2 = onGlobalLayoutListener;
            OnScrollChangedListener onScrollChangedListener2 = onScrollChangedListener;
            super(context2);
            zziu zziu2 = zziu;
            zziu zziu3 = new zziu(context2);
            this.zzrU = zziu2;
            if (context2 instanceof Activity) {
                zzjc zzjc2 = zzjc;
                zzjc zzjc3 = new zzjc((Activity) context2, onGlobalLayoutListener2, onScrollChangedListener2);
                this.zzrV = zzjc2;
                this.zzrV.zzhE();
                return;
            }
            this.zzrV = null;
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.zzrV != null) {
                this.zzrV.onAttachedToWindow();
            }
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.zzrV != null) {
                this.zzrV.onDetachedFromWindow();
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            MotionEvent motionEvent2 = motionEvent;
            this.zzrU.zze(motionEvent2);
            return false;
        }

        public void removeAllViews() {
            ArrayList arrayList;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            ArrayList<zzjp> arrayList4 = arrayList2;
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt != null && (childAt instanceof zzjp)) {
                    boolean add = arrayList4.add((zzjp) childAt);
                }
            }
            super.removeAllViews();
            for (zzjp destroy : arrayList4) {
                destroy.destroy();
            }
        }

        public void zzbY() {
            zzin.m20v("Disable position monitoring on adFrame.");
            if (this.zzrV != null) {
                this.zzrV.zzhF();
            }
        }

        public zziu zzcc() {
            return this.zzrU;
        }
    }

    public zzs(Context context2, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel) {
        this(context2, adSizeParcel, str, versionInfoParcel, null);
    }

    zzs(Context context2, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel, zzan zzan) {
        zzan zzan2;
        zzh zzh;
        zziz zziz;
        SimpleArrayMap<String, zzcu> simpleArrayMap;
        zza zza2;
        Context context3 = context2;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        String str2 = str;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        zzan zzan3 = zzan;
        this.zzrJ = null;
        this.zzrK = null;
        this.zzrL = 0;
        this.zzrM = false;
        this.zzql = false;
        this.zzrN = null;
        this.zzrO = -1;
        this.zzrP = -1;
        this.zzrR = true;
        this.zzrS = true;
        this.zzrT = false;
        zzbt.initialize(context3);
        if (zzr.zzbF().zzhb() != null) {
            List zzds = zzbt.zzds();
            if (versionInfoParcel2.zzMZ != 0) {
                boolean add = zzds.add(Integer.toString(versionInfoParcel2.zzMZ));
            }
            zzr.zzbF().zzhb().zzb(zzds);
        }
        this.zzri = UUID.randomUUID().toString();
        if (adSizeParcel2.zzui || adSizeParcel2.zzuk) {
            this.zzrm = null;
        } else {
            zza zza3 = zza2;
            zza zza4 = new zza(context3, this, this);
            this.zzrm = zza3;
            this.zzrm.setMinimumWidth(adSizeParcel2.widthPixels);
            this.zzrm.setMinimumHeight(adSizeParcel2.heightPixels);
            this.zzrm.setVisibility(4);
        }
        this.zzrp = adSizeParcel2;
        this.zzrj = str2;
        this.context = context3;
        this.zzrl = versionInfoParcel2;
        if (zzan3 == null) {
            zzan zzan4 = zzan2;
            zzh zzh2 = zzh;
            zzh zzh3 = new zzh(this);
            zzan zzan5 = new zzan(zzh2);
            zzan3 = zzan4;
        }
        this.zzrk = zzan3;
        zziz zziz2 = zziz;
        zziz zziz3 = new zziz(200);
        this.zzrQ = zziz2;
        SimpleArrayMap<String, zzcu> simpleArrayMap2 = simpleArrayMap;
        SimpleArrayMap<String, zzcu> simpleArrayMap3 = new SimpleArrayMap<>();
        this.zzrC = simpleArrayMap2;
    }

    private void zzbZ() {
        Rect rect;
        Rect rect2;
        View findViewById = this.zzrm.getRootView().findViewById(16908290);
        if (findViewById != null) {
            Rect rect3 = rect;
            Rect rect4 = new Rect();
            Rect rect5 = rect3;
            Rect rect6 = rect2;
            Rect rect7 = new Rect();
            Rect rect8 = rect6;
            boolean globalVisibleRect = this.zzrm.getGlobalVisibleRect(rect5);
            boolean globalVisibleRect2 = findViewById.getGlobalVisibleRect(rect8);
            if (rect5.top != rect8.top) {
                this.zzrR = false;
            }
            if (rect5.bottom != rect8.bottom) {
                this.zzrS = false;
            }
        }
    }

    private void zze(boolean z) {
        boolean z2 = z;
        boolean z3 = true;
        if (this.zzrm != null && this.zzrq != null && this.zzrq.zzED != null) {
            if (!z2 || this.zzrQ.tryAcquire()) {
                if (this.zzrq.zzED.zzhU().zzcv()) {
                    int[] iArr = new int[2];
                    this.zzrm.getLocationOnScreen(iArr);
                    int zzc = zzn.zzcS().zzc(this.context, iArr[0]);
                    int zzc2 = zzn.zzcS().zzc(this.context, iArr[1]);
                    if (!(zzc == this.zzrO && zzc2 == this.zzrP)) {
                        this.zzrO = zzc;
                        this.zzrP = zzc2;
                        zzjq zzhU = this.zzrq.zzED.zzhU();
                        int i = this.zzrO;
                        int i2 = this.zzrP;
                        if (z2) {
                            z3 = false;
                        }
                        zzhU.zza(i, i2, z3);
                    }
                }
                zzbZ();
            }
        }
    }

    public void destroy() {
        zzbY();
        this.zzru = null;
        this.zzrv = null;
        this.zzry = null;
        this.zzrx = null;
        this.zzrE = null;
        this.zzrw = null;
        zzf(false);
        if (this.zzrm != null) {
            this.zzrm.removeAllViews();
        }
        zzbT();
        zzbV();
        this.zzrq = null;
    }

    public String getUserId() {
        return this.zzrG;
    }

    public void onGlobalLayout() {
        zze(false);
    }

    public void onScrollChanged() {
        zze(true);
        this.zzrT = true;
    }

    /* access modifiers changed from: 0000 */
    public void setUserId(String str) {
        String str2 = str;
        this.zzrG = str2;
    }

    public void zza(HashSet<zzig> hashSet) {
        HashSet<zzig> hashSet2 = hashSet;
        this.zzrN = hashSet2;
    }

    public HashSet<zzig> zzbS() {
        return this.zzrN;
    }

    public void zzbT() {
        if (this.zzrq != null && this.zzrq.zzED != null) {
            this.zzrq.zzED.destroy();
        }
    }

    public void zzbU() {
        if (this.zzrq != null && this.zzrq.zzED != null) {
            this.zzrq.zzED.stopLoading();
        }
    }

    public void zzbV() {
        if (this.zzrq != null && this.zzrq.zzCq != null) {
            try {
                this.zzrq.zzCq.destroy();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                zzin.zzaK("Could not destroy mediation adapter.");
            }
        }
    }

    public boolean zzbW() {
        return this.zzrL == 0;
    }

    public boolean zzbX() {
        return this.zzrL == 1;
    }

    public void zzbY() {
        if (this.zzrm != null) {
            this.zzrm.zzbY();
        }
    }

    public String zzca() {
        return (!this.zzrR || !this.zzrS) ? this.zzrR ? this.zzrT ? "top-scrollable" : "top-locked" : this.zzrS ? this.zzrT ? "bottom-scrollable" : "bottom-locked" : LibrariesRepository.MOJANG_MAVEN_REPO : LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public void zzcb() {
        this.zzrs.zzl(this.zzrq.zzKY);
        this.zzrs.zzm(this.zzrq.zzKZ);
        this.zzrs.zzz(this.zzrp.zzui);
        this.zzrs.zzA(this.zzrq.zzHT);
    }

    public void zzf(boolean z) {
        boolean z2 = z;
        if (this.zzrL == 0) {
            zzbU();
        }
        if (this.zzrn != null) {
            this.zzrn.cancel();
        }
        if (this.zzro != null) {
            this.zzro.cancel();
        }
        if (z2) {
            this.zzrq = null;
        }
    }
}
