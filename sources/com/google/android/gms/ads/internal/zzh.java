package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.internal.zzaj;
import com.google.android.gms.internal.zzam;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zziq;
import com.google.android.gms.internal.zzjg;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

@zzhb
class zzh implements zzaj, Runnable {
    private final List<Object[]> zzpH;
    private final AtomicReference<zzaj> zzpI;
    CountDownLatch zzpJ;
    private zzs zzpj;

    public zzh(zzs zzs) {
        Vector vector;
        AtomicReference<zzaj> atomicReference;
        CountDownLatch countDownLatch;
        zzs zzs2 = zzs;
        Vector vector2 = vector;
        Vector vector3 = new Vector();
        this.zzpH = vector2;
        AtomicReference<zzaj> atomicReference2 = atomicReference;
        AtomicReference<zzaj> atomicReference3 = new AtomicReference<>();
        this.zzpI = atomicReference2;
        CountDownLatch countDownLatch2 = countDownLatch;
        CountDownLatch countDownLatch3 = new CountDownLatch(1);
        this.zzpJ = countDownLatch2;
        this.zzpj = zzs2;
        if (zzn.zzcS().zzhJ()) {
            zzjg zza = zziq.zza((Runnable) this);
        } else {
            run();
        }
    }

    private void zzbk() {
        if (!this.zzpH.isEmpty()) {
            for (Object[] objArr : this.zzpH) {
                if (objArr.length == 1) {
                    ((zzaj) this.zzpI.get()).zza((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((zzaj) this.zzpI.get()).zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.zzpH.clear();
        }
    }

    private Context zzq(Context context) {
        Context context2 = context;
        if (((Boolean) zzbt.zzvM.get()).booleanValue()) {
            Context applicationContext = context2.getApplicationContext();
            if (applicationContext != null) {
                return applicationContext;
            }
        }
        return context2;
    }

    public void run() {
        try {
            zza(zzb(this.zzpj.zzrl.afmaVersion, zzq(this.zzpj.context), !((Boolean) zzbt.zzvY.get()).booleanValue() || this.zzpj.zzrl.zzNb));
            this.zzpJ.countDown();
            this.zzpj = null;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.zzpJ.countDown();
            this.zzpj = null;
            throw th2;
        }
    }

    public void zza(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        zzaj zzaj = (zzaj) this.zzpI.get();
        if (zzaj != null) {
            zzbk();
            zzaj.zza(i4, i5, i6);
            return;
        }
        boolean add = this.zzpH.add(new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
    }

    public void zza(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        zzaj zzaj = (zzaj) this.zzpI.get();
        if (zzaj != null) {
            zzbk();
            zzaj.zza(motionEvent2);
            return;
        }
        List<Object[]> list = this.zzpH;
        Object[] objArr = new Object[1];
        Object[] objArr2 = objArr;
        objArr[0] = motionEvent2;
        boolean add = list.add(objArr2);
    }

    /* access modifiers changed from: protected */
    public void zza(zzaj zzaj) {
        zzaj zzaj2 = zzaj;
        this.zzpI.set(zzaj2);
    }

    /* access modifiers changed from: protected */
    public zzaj zzb(String str, Context context, boolean z) {
        return zzam.zza(str, context, z);
    }

    public String zzb(Context context) {
        Context context2 = context;
        if (zzbj()) {
            zzaj zzaj = (zzaj) this.zzpI.get();
            if (zzaj != null) {
                zzbk();
                return zzaj.zzb(zzq(context2));
            }
        }
        return LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public String zzb(Context context, String str) {
        Context context2 = context;
        String str2 = str;
        if (zzbj()) {
            zzaj zzaj = (zzaj) this.zzpI.get();
            if (zzaj != null) {
                zzbk();
                return zzaj.zzb(zzq(context2), str2);
            }
        }
        return LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    /* access modifiers changed from: protected */
    public boolean zzbj() {
        try {
            this.zzpJ.await();
            return true;
        } catch (InterruptedException e) {
            zzin.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }
}
