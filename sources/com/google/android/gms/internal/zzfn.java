package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;
import java.util.Set;

@zzhb
public class zzfn extends zzfs {
    static final Set<String> zzDa;
    private AdSizeParcel zzCh;
    private String zzDb = "top-right";
    private boolean zzDc = true;
    private int zzDd = 0;
    private int zzDe = 0;
    private int zzDf = 0;
    private int zzDg = 0;
    private final Activity zzDh;
    private ImageView zzDi;
    private LinearLayout zzDj;
    private zzft zzDk;
    private PopupWindow zzDl;
    private RelativeLayout zzDm;
    private ViewGroup zzDn;
    private int zzoG = -1;
    private int zzoH = -1;
    private final zzjp zzpD;
    private final Object zzpV;

    static {
        String[] strArr = new String[7];
        String[] strArr2 = strArr;
        strArr[0] = "top-left";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "top-right";
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = "top-center";
        String[] strArr7 = strArr6;
        String[] strArr8 = strArr7;
        strArr7[3] = "center";
        String[] strArr9 = strArr8;
        String[] strArr10 = strArr9;
        strArr9[4] = "bottom-left";
        String[] strArr11 = strArr10;
        String[] strArr12 = strArr11;
        strArr11[5] = "bottom-right";
        String[] strArr13 = strArr12;
        String[] strArr14 = strArr13;
        strArr13[6] = "bottom-center";
        zzDa = zzmr.zzc(strArr14);
    }

    public zzfn(zzjp zzjp, zzft zzft) {
        Object obj;
        zzjp zzjp2 = zzjp;
        zzft zzft2 = zzft;
        super(zzjp2, "resize");
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        this.zzpD = zzjp2;
        this.zzDh = zzjp2.zzhP();
        this.zzDk = zzft2;
    }

    private int[] zzeM() {
        if (!zzeO()) {
            return null;
        }
        if (this.zzDc) {
            return new int[]{this.zzDd + this.zzDf, this.zzDe + this.zzDg};
        }
        int[] zzf = zzr.zzbC().zzf(this.zzDh);
        int[] zzh = zzr.zzbC().zzh(this.zzDh);
        int i = zzf[0];
        int i2 = this.zzDd + this.zzDf;
        int i3 = this.zzDe + this.zzDg;
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 + this.zzoG > i) {
            i2 = i - this.zzoG;
        }
        if (i3 < zzh[0]) {
            i3 = zzh[0];
        } else if (i3 + this.zzoH > zzh[1]) {
            i3 = zzh[1] - this.zzoH;
        }
        int[] iArr = new int[2];
        int[] iArr2 = iArr;
        iArr[0] = i2;
        int[] iArr3 = iArr2;
        int[] iArr4 = iArr3;
        iArr3[1] = i3;
        return iArr4;
    }

    private void zzh(Map<String, String> map) {
        Map<String, String> map2 = map;
        if (!TextUtils.isEmpty((CharSequence) map2.get("width"))) {
            this.zzoG = zzr.zzbC().zzaD((String) map2.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence) map2.get("height"))) {
            this.zzoH = zzr.zzbC().zzaD((String) map2.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence) map2.get("offsetX"))) {
            this.zzDf = zzr.zzbC().zzaD((String) map2.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) map2.get("offsetY"))) {
            this.zzDg = zzr.zzbC().zzaD((String) map2.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) map2.get("allowOffscreen"))) {
            this.zzDc = Boolean.parseBoolean((String) map2.get("allowOffscreen"));
        }
        String str = (String) map2.get("customClosePosition");
        if (!TextUtils.isEmpty(str)) {
            this.zzDb = str;
        }
    }

    public void zza(int i, int i2, boolean z) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        int[] iArr = this.zzpV;
        synchronized (iArr) {
            try {
                this.zzDd = i3;
                this.zzDe = i4;
                if (this.zzDl != null && z2) {
                    th = zzeM();
                    if (iArr != null) {
                        this.zzDl.update(zzn.zzcS().zzb((Context) this.zzDh, iArr[0]), zzn.zzcS().zzb((Context) this.zzDh, iArr[1]), this.zzDl.getWidth(), this.zzDl.getHeight());
                        zzd(iArr[0], iArr[1]);
                    } else {
                        zzp(true);
                    }
                }
            } finally {
                Throwable th = th;
                int[] iArr2 = iArr;
                Throwable th2 = th;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzc(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.zzDk != null) {
            this.zzDk.zza(i3, i4, this.zzoG, this.zzoH);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzd(int i, int i2) {
        zzb(i, i2 - zzr.zzbC().zzh(this.zzDh)[0], this.zzoG, this.zzoH);
    }

    public void zze(int i, int i2) {
        int i3 = i2;
        this.zzDd = i;
        this.zzDe = i3;
    }

    /* access modifiers changed from: 0000 */
    public boolean zzeL() {
        return this.zzoG > -1 && this.zzoH > -1;
    }

    public boolean zzeN() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzDl != null;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00aa, code lost:
        if ((r8 + 50) <= r2[1]) goto L_0x00ac;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zzeO() {
        /*
            r13 = this;
            r0 = r13
            com.google.android.gms.internal.zzir r9 = com.google.android.gms.ads.internal.zzr.zzbC()
            r10 = r0
            android.app.Activity r10 = r10.zzDh
            int[] r9 = r9.zzf(r10)
            r1 = r9
            com.google.android.gms.internal.zzir r9 = com.google.android.gms.ads.internal.zzr.zzbC()
            r10 = r0
            android.app.Activity r10 = r10.zzDh
            int[] r9 = r9.zzh(r10)
            r2 = r9
            r9 = r1
            r10 = 0
            r9 = r9[r10]
            r3 = r9
            r9 = r1
            r10 = 1
            r9 = r9[r10]
            r4 = r9
            r9 = r0
            int r9 = r9.zzoG
            r10 = 50
            if (r9 < r10) goto L_0x0030
            r9 = r0
            int r9 = r9.zzoG
            r10 = r3
            if (r9 <= r10) goto L_0x0038
        L_0x0030:
            java.lang.String r9 = "Width is too small or too large."
            com.google.android.gms.internal.zzin.zzaK(r9)
        L_0x0035:
            r9 = 0
            r0 = r9
        L_0x0037:
            return r0
        L_0x0038:
            r9 = r0
            int r9 = r9.zzoH
            r10 = 50
            if (r9 < r10) goto L_0x0045
            r9 = r0
            int r9 = r9.zzoH
            r10 = r4
            if (r9 <= r10) goto L_0x004d
        L_0x0045:
            java.lang.String r9 = "Height is too small or too large."
            com.google.android.gms.internal.zzin.zzaK(r9)
            r9 = 0
            r0 = r9
            goto L_0x0037
        L_0x004d:
            r9 = r0
            int r9 = r9.zzoH
            r10 = r4
            if (r9 != r10) goto L_0x0061
            r9 = r0
            int r9 = r9.zzoG
            r10 = r3
            if (r9 != r10) goto L_0x0061
            java.lang.String r9 = "Cannot resize to a full-screen ad."
            com.google.android.gms.internal.zzin.zzaK(r9)
            r9 = 0
            r0 = r9
            goto L_0x0037
        L_0x0061:
            r9 = r0
            boolean r9 = r9.zzDc
            if (r9 == 0) goto L_0x00ac
            r9 = r0
            java.lang.String r9 = r9.zzDb
            r5 = r9
            r9 = -1
            r6 = r9
            r9 = r5
            int r9 = r9.hashCode()
            switch(r9) {
                case -1364013995: goto L_0x00c7;
                case -1012429441: goto L_0x00af;
                case -655373719: goto L_0x00d3;
                case 1163912186: goto L_0x00eb;
                case 1288627767: goto L_0x00df;
                case 1755462605: goto L_0x00bb;
                default: goto L_0x0074;
            }
        L_0x0074:
            r9 = r6
            switch(r9) {
                case 0: goto L_0x00f8;
                case 1: goto L_0x0109;
                case 2: goto L_0x0125;
                case 3: goto L_0x014b;
                case 4: goto L_0x0164;
                case 5: goto L_0x0187;
                default: goto L_0x0078;
            }
        L_0x0078:
            r9 = -50
            r10 = r0
            int r10 = r10.zzDd
            r11 = r0
            int r11 = r11.zzDf
            int r10 = r10 + r11
            r11 = r0
            int r11 = r11.zzoG
            int r10 = r10 + r11
            int r9 = r9 + r10
            r7 = r9
            r9 = r0
            int r9 = r9.zzDe
            r10 = r0
            int r10 = r10.zzDg
            int r9 = r9 + r10
            r8 = r9
        L_0x008f:
            r9 = r7
            if (r9 < 0) goto L_0x0035
            r9 = r7
            r10 = 50
            int r9 = r9 + 50
            r10 = r3
            if (r9 > r10) goto L_0x0035
            r9 = r8
            r10 = r2
            r11 = 0
            r10 = r10[r11]
            if (r9 < r10) goto L_0x0035
            r9 = r8
            r10 = 50
            int r9 = r9 + 50
            r10 = r2
            r11 = 1
            r10 = r10[r11]
            if (r9 > r10) goto L_0x0035
        L_0x00ac:
            r9 = 1
            r0 = r9
            goto L_0x0037
        L_0x00af:
            r9 = r5
            java.lang.String r10 = "top-left"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0074
            r9 = 0
            r6 = r9
            goto L_0x0074
        L_0x00bb:
            r9 = r5
            java.lang.String r10 = "top-center"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0074
            r9 = 1
            r6 = r9
            goto L_0x0074
        L_0x00c7:
            r9 = r5
            java.lang.String r10 = "center"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0074
            r9 = 2
            r6 = r9
            goto L_0x0074
        L_0x00d3:
            r9 = r5
            java.lang.String r10 = "bottom-left"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0074
            r9 = 3
            r6 = r9
            goto L_0x0074
        L_0x00df:
            r9 = r5
            java.lang.String r10 = "bottom-center"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0074
            r9 = 4
            r6 = r9
            goto L_0x0074
        L_0x00eb:
            r9 = r5
            java.lang.String r10 = "bottom-right"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0074
            r9 = 5
            r6 = r9
            goto L_0x0074
        L_0x00f8:
            r9 = r0
            int r9 = r9.zzDd
            r10 = r0
            int r10 = r10.zzDf
            int r9 = r9 + r10
            r7 = r9
            r9 = r0
            int r9 = r9.zzDe
            r10 = r0
            int r10 = r10.zzDg
            int r9 = r9 + r10
            r8 = r9
            goto L_0x008f
        L_0x0109:
            r9 = -25
            r10 = r0
            int r10 = r10.zzDd
            r11 = r0
            int r11 = r11.zzDf
            int r10 = r10 + r11
            r11 = r0
            int r11 = r11.zzoG
            r12 = 2
            int r11 = r11 / 2
            int r10 = r10 + r11
            int r9 = r9 + r10
            r7 = r9
            r9 = r0
            int r9 = r9.zzDe
            r10 = r0
            int r10 = r10.zzDg
            int r9 = r9 + r10
            r8 = r9
            goto L_0x008f
        L_0x0125:
            r9 = -25
            r10 = r0
            int r10 = r10.zzDd
            r11 = r0
            int r11 = r11.zzDf
            int r10 = r10 + r11
            r11 = r0
            int r11 = r11.zzoG
            r12 = 2
            int r11 = r11 / 2
            int r10 = r10 + r11
            int r9 = r9 + r10
            r7 = r9
            r9 = -25
            r10 = r0
            int r10 = r10.zzDe
            r11 = r0
            int r11 = r11.zzDg
            int r10 = r10 + r11
            r11 = r0
            int r11 = r11.zzoH
            r12 = 2
            int r11 = r11 / 2
            int r10 = r10 + r11
            int r9 = r9 + r10
            r8 = r9
            goto L_0x008f
        L_0x014b:
            r9 = r0
            int r9 = r9.zzDd
            r10 = r0
            int r10 = r10.zzDf
            int r9 = r9 + r10
            r7 = r9
            r9 = -50
            r10 = r0
            int r10 = r10.zzDe
            r11 = r0
            int r11 = r11.zzDg
            int r10 = r10 + r11
            r11 = r0
            int r11 = r11.zzoH
            int r10 = r10 + r11
            int r9 = r9 + r10
            r8 = r9
            goto L_0x008f
        L_0x0164:
            r9 = -25
            r10 = r0
            int r10 = r10.zzDd
            r11 = r0
            int r11 = r11.zzDf
            int r10 = r10 + r11
            r11 = r0
            int r11 = r11.zzoG
            r12 = 2
            int r11 = r11 / 2
            int r10 = r10 + r11
            int r9 = r9 + r10
            r7 = r9
            r9 = -50
            r10 = r0
            int r10 = r10.zzDe
            r11 = r0
            int r11 = r11.zzDg
            int r10 = r10 + r11
            r11 = r0
            int r11 = r11.zzoH
            int r10 = r10 + r11
            int r9 = r9 + r10
            r8 = r9
            goto L_0x008f
        L_0x0187:
            r9 = -50
            r10 = r0
            int r10 = r10.zzDd
            r11 = r0
            int r11 = r11.zzDf
            int r10 = r10 + r11
            r11 = r0
            int r11 = r11.zzoG
            int r10 = r10 + r11
            int r9 = r9 + r10
            r7 = r9
            r9 = -50
            r10 = r0
            int r10 = r10.zzDe
            r11 = r0
            int r11 = r11.zzDg
            int r10 = r10 + r11
            r11 = r0
            int r11 = r11.zzoH
            int r10 = r10 + r11
            int r9 = r9 + r10
            r8 = r9
            goto L_0x008f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfn.zzeO():boolean");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzi(java.util.Map<java.lang.String, java.lang.String> r28) {
        /*
            r27 = this;
            r2 = r27
            r3 = r28
            r18 = r2
            r0 = r18
            java.lang.Object r0 = r0.zzpV
            r18 = r0
            r4 = r18
            r18 = r4
            monitor-enter(r18)
            r18 = r2
            r0 = r18
            android.app.Activity r0 = r0.zzDh     // Catch:{ all -> 0x003f }
            r18 = r0
            if (r18 != 0) goto L_0x0026
            r18 = r2
            java.lang.String r19 = "Not an activity context. Cannot resize."
            r18.zzam(r19)     // Catch:{ all -> 0x003f }
            r18 = r4
            monitor-exit(r18)     // Catch:{ all -> 0x003f }
        L_0x0025:
            return
        L_0x0026:
            r18 = r2
            r0 = r18
            com.google.android.gms.internal.zzjp r0 = r0.zzpD     // Catch:{ all -> 0x003f }
            r18 = r0
            com.google.android.gms.ads.internal.client.AdSizeParcel r18 = r18.zzaN()     // Catch:{ all -> 0x003f }
            if (r18 != 0) goto L_0x0048
            r18 = r2
            java.lang.String r19 = "Webview is not yet available, size is not set."
            r18.zzam(r19)     // Catch:{ all -> 0x003f }
            r18 = r4
            monitor-exit(r18)     // Catch:{ all -> 0x003f }
            goto L_0x0025
        L_0x003f:
            r18 = move-exception
            r5 = r18
            r18 = r4
            monitor-exit(r18)     // Catch:{ all -> 0x003f }
            r18 = r5
            throw r18
        L_0x0048:
            r18 = r2
            r0 = r18
            com.google.android.gms.internal.zzjp r0 = r0.zzpD     // Catch:{ all -> 0x003f }
            r18 = r0
            com.google.android.gms.ads.internal.client.AdSizeParcel r18 = r18.zzaN()     // Catch:{ all -> 0x003f }
            r0 = r18
            boolean r0 = r0.zzui     // Catch:{ all -> 0x003f }
            r18 = r0
            if (r18 == 0) goto L_0x0067
            r18 = r2
            java.lang.String r19 = "Is interstitial. Cannot resize an interstitial."
            r18.zzam(r19)     // Catch:{ all -> 0x003f }
            r18 = r4
            monitor-exit(r18)     // Catch:{ all -> 0x003f }
            goto L_0x0025
        L_0x0067:
            r18 = r2
            r0 = r18
            com.google.android.gms.internal.zzjp r0 = r0.zzpD     // Catch:{ all -> 0x003f }
            r18 = r0
            boolean r18 = r18.zzhY()     // Catch:{ all -> 0x003f }
            if (r18 == 0) goto L_0x0080
            r18 = r2
            java.lang.String r19 = "Cannot resize an expanded banner."
            r18.zzam(r19)     // Catch:{ all -> 0x003f }
            r18 = r4
            monitor-exit(r18)     // Catch:{ all -> 0x003f }
            goto L_0x0025
        L_0x0080:
            r18 = r2
            r19 = r3
            r18.zzh(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            boolean r18 = r18.zzeL()     // Catch:{ all -> 0x003f }
            if (r18 != 0) goto L_0x009a
            r18 = r2
            java.lang.String r19 = "Invalid width and height options. Cannot resize."
            r18.zzam(r19)     // Catch:{ all -> 0x003f }
            r18 = r4
            monitor-exit(r18)     // Catch:{ all -> 0x003f }
            goto L_0x0025
        L_0x009a:
            r18 = r2
            r0 = r18
            android.app.Activity r0 = r0.zzDh     // Catch:{ all -> 0x003f }
            r18 = r0
            android.view.Window r18 = r18.getWindow()     // Catch:{ all -> 0x003f }
            r6 = r18
            r18 = r6
            if (r18 == 0) goto L_0x00b4
            r18 = r6
            android.view.View r18 = r18.getDecorView()     // Catch:{ all -> 0x003f }
            if (r18 != 0) goto L_0x00c0
        L_0x00b4:
            r18 = r2
            java.lang.String r19 = "Activity context is not ready, cannot get window or decor view."
            r18.zzam(r19)     // Catch:{ all -> 0x003f }
            r18 = r4
            monitor-exit(r18)     // Catch:{ all -> 0x003f }
            goto L_0x0025
        L_0x00c0:
            r18 = r2
            int[] r18 = r18.zzeM()     // Catch:{ all -> 0x003f }
            r7 = r18
            r18 = r7
            if (r18 != 0) goto L_0x00d8
            r18 = r2
            java.lang.String r19 = "Resize location out of screen or close button is not visible."
            r18.zzam(r19)     // Catch:{ all -> 0x003f }
            r18 = r4
            monitor-exit(r18)     // Catch:{ all -> 0x003f }
            goto L_0x0025
        L_0x00d8:
            com.google.android.gms.ads.internal.util.client.zza r18 = com.google.android.gms.ads.internal.client.zzn.zzcS()     // Catch:{ all -> 0x003f }
            r19 = r2
            r0 = r19
            android.app.Activity r0 = r0.zzDh     // Catch:{ all -> 0x003f }
            r19 = r0
            r20 = r2
            r0 = r20
            int r0 = r0.zzoG     // Catch:{ all -> 0x003f }
            r20 = r0
            int r18 = r18.zzb(r19, r20)     // Catch:{ all -> 0x003f }
            r8 = r18
            com.google.android.gms.ads.internal.util.client.zza r18 = com.google.android.gms.ads.internal.client.zzn.zzcS()     // Catch:{ all -> 0x003f }
            r19 = r2
            r0 = r19
            android.app.Activity r0 = r0.zzDh     // Catch:{ all -> 0x003f }
            r19 = r0
            r20 = r2
            r0 = r20
            int r0 = r0.zzoH     // Catch:{ all -> 0x003f }
            r20 = r0
            int r18 = r18.zzb(r19, r20)     // Catch:{ all -> 0x003f }
            r9 = r18
            r18 = r2
            r0 = r18
            com.google.android.gms.internal.zzjp r0 = r0.zzpD     // Catch:{ all -> 0x003f }
            r18 = r0
            android.view.View r18 = r18.getView()     // Catch:{ all -> 0x003f }
            android.view.ViewParent r18 = r18.getParent()     // Catch:{ all -> 0x003f }
            r10 = r18
            r18 = r10
            if (r18 == 0) goto L_0x03d1
            r18 = r10
            r0 = r18
            boolean r0 = r0 instanceof android.view.ViewGroup     // Catch:{ all -> 0x003f }
            r18 = r0
            if (r18 == 0) goto L_0x03d1
            r18 = r10
            android.view.ViewGroup r18 = (android.view.ViewGroup) r18     // Catch:{ all -> 0x003f }
            r19 = r2
            r0 = r19
            com.google.android.gms.internal.zzjp r0 = r0.zzpD     // Catch:{ all -> 0x003f }
            r19 = r0
            android.view.View r19 = r19.getView()     // Catch:{ all -> 0x003f }
            r18.removeView(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.widget.PopupWindow r0 = r0.zzDl     // Catch:{ all -> 0x003f }
            r18 = r0
            if (r18 != 0) goto L_0x03c4
            r18 = r2
            r19 = r10
            android.view.ViewGroup r19 = (android.view.ViewGroup) r19     // Catch:{ all -> 0x003f }
            r0 = r19
            r1 = r18
            r1.zzDn = r0     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.zzir r18 = com.google.android.gms.ads.internal.zzr.zzbC()     // Catch:{ all -> 0x003f }
            r19 = r2
            r0 = r19
            com.google.android.gms.internal.zzjp r0 = r0.zzpD     // Catch:{ all -> 0x003f }
            r19 = r0
            android.view.View r19 = r19.getView()     // Catch:{ all -> 0x003f }
            android.graphics.Bitmap r18 = r18.zzk(r19)     // Catch:{ all -> 0x003f }
            r17 = r18
            r18 = r2
            android.widget.ImageView r19 = new android.widget.ImageView     // Catch:{ all -> 0x003f }
            r26 = r19
            r19 = r26
            r20 = r26
            r21 = r2
            r0 = r21
            android.app.Activity r0 = r0.zzDh     // Catch:{ all -> 0x003f }
            r21 = r0
            r20.<init>(r21)     // Catch:{ all -> 0x003f }
            r0 = r19
            r1 = r18
            r1.zzDi = r0     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.widget.ImageView r0 = r0.zzDi     // Catch:{ all -> 0x003f }
            r18 = r0
            r19 = r17
            r18.setImageBitmap(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            r19 = r2
            r0 = r19
            com.google.android.gms.internal.zzjp r0 = r0.zzpD     // Catch:{ all -> 0x003f }
            r19 = r0
            com.google.android.gms.ads.internal.client.AdSizeParcel r19 = r19.zzaN()     // Catch:{ all -> 0x003f }
            r0 = r19
            r1 = r18
            r1.zzCh = r0     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.view.ViewGroup r0 = r0.zzDn     // Catch:{ all -> 0x003f }
            r18 = r0
            r19 = r2
            r0 = r19
            android.widget.ImageView r0 = r0.zzDi     // Catch:{ all -> 0x003f }
            r19 = r0
            r18.addView(r19)     // Catch:{ all -> 0x003f }
        L_0x01ba:
            r18 = r2
            android.widget.RelativeLayout r19 = new android.widget.RelativeLayout     // Catch:{ all -> 0x003f }
            r26 = r19
            r19 = r26
            r20 = r26
            r21 = r2
            r0 = r21
            android.app.Activity r0 = r0.zzDh     // Catch:{ all -> 0x003f }
            r21 = r0
            r20.<init>(r21)     // Catch:{ all -> 0x003f }
            r0 = r19
            r1 = r18
            r1.zzDm = r0     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.widget.RelativeLayout r0 = r0.zzDm     // Catch:{ all -> 0x003f }
            r18 = r0
            r19 = 0
            r18.setBackgroundColor(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.widget.RelativeLayout r0 = r0.zzDm     // Catch:{ all -> 0x003f }
            r18 = r0
            android.view.ViewGroup$LayoutParams r19 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x003f }
            r26 = r19
            r19 = r26
            r20 = r26
            r21 = r8
            r22 = r9
            r20.<init>(r21, r22)     // Catch:{ all -> 0x003f }
            r18.setLayoutParams(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            com.google.android.gms.internal.zzir r19 = com.google.android.gms.ads.internal.zzr.zzbC()     // Catch:{ all -> 0x003f }
            r20 = r2
            r0 = r20
            android.widget.RelativeLayout r0 = r0.zzDm     // Catch:{ all -> 0x003f }
            r20 = r0
            r21 = r8
            r22 = r9
            r23 = 0
            android.widget.PopupWindow r19 = r19.zza(r20, r21, r22, r23)     // Catch:{ all -> 0x003f }
            r0 = r19
            r1 = r18
            r1.zzDl = r0     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.widget.PopupWindow r0 = r0.zzDl     // Catch:{ all -> 0x003f }
            r18 = r0
            r19 = 1
            r18.setOutsideTouchable(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.widget.PopupWindow r0 = r0.zzDl     // Catch:{ all -> 0x003f }
            r18 = r0
            r19 = 1
            r18.setTouchable(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.widget.PopupWindow r0 = r0.zzDl     // Catch:{ all -> 0x003f }
            r18 = r0
            r11 = r18
            r18 = r2
            r0 = r18
            boolean r0 = r0.zzDc     // Catch:{ all -> 0x003f }
            r18 = r0
            if (r18 != 0) goto L_0x0520
            r18 = 1
            r12 = r18
        L_0x024c:
            r18 = r11
            r19 = r12
            r18.setClippingEnabled(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.widget.RelativeLayout r0 = r0.zzDm     // Catch:{ all -> 0x003f }
            r18 = r0
            r19 = r2
            r0 = r19
            com.google.android.gms.internal.zzjp r0 = r0.zzpD     // Catch:{ all -> 0x003f }
            r19 = r0
            android.view.View r19 = r19.getView()     // Catch:{ all -> 0x003f }
            r20 = -1
            r21 = -1
            r18.addView(r19, r20, r21)     // Catch:{ all -> 0x003f }
            r18 = r2
            android.widget.LinearLayout r19 = new android.widget.LinearLayout     // Catch:{ all -> 0x003f }
            r26 = r19
            r19 = r26
            r20 = r26
            r21 = r2
            r0 = r21
            android.app.Activity r0 = r0.zzDh     // Catch:{ all -> 0x003f }
            r21 = r0
            r20.<init>(r21)     // Catch:{ all -> 0x003f }
            r0 = r19
            r1 = r18
            r1.zzDj = r0     // Catch:{ all -> 0x003f }
            android.widget.RelativeLayout$LayoutParams r18 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x003f }
            r26 = r18
            r18 = r26
            r19 = r26
            com.google.android.gms.ads.internal.util.client.zza r20 = com.google.android.gms.ads.internal.client.zzn.zzcS()     // Catch:{ all -> 0x003f }
            r21 = r2
            r0 = r21
            android.app.Activity r0 = r0.zzDh     // Catch:{ all -> 0x003f }
            r21 = r0
            r22 = 50
            int r20 = r20.zzb(r21, r22)     // Catch:{ all -> 0x003f }
            com.google.android.gms.ads.internal.util.client.zza r21 = com.google.android.gms.ads.internal.client.zzn.zzcS()     // Catch:{ all -> 0x003f }
            r22 = r2
            r0 = r22
            android.app.Activity r0 = r0.zzDh     // Catch:{ all -> 0x003f }
            r22 = r0
            r23 = 50
            int r21 = r21.zzb(r22, r23)     // Catch:{ all -> 0x003f }
            r19.<init>(r20, r21)     // Catch:{ all -> 0x003f }
            r13 = r18
            r18 = r2
            r0 = r18
            java.lang.String r0 = r0.zzDb     // Catch:{ all -> 0x003f }
            r18 = r0
            r14 = r18
            r18 = r14
            int r18 = r18.hashCode()     // Catch:{ all -> 0x003f }
            switch(r18) {
                case -1364013995: goto L_0x03fd;
                case -1012429441: goto L_0x03dd;
                case -655373719: goto L_0x040d;
                case 1163912186: goto L_0x042d;
                case 1288627767: goto L_0x041d;
                case 1755462605: goto L_0x03ed;
                default: goto L_0x02cd;
            }     // Catch:{ all -> 0x003f }
        L_0x02cd:
            r18 = -1
            r15 = r18
        L_0x02d1:
            r18 = r15
            switch(r18) {
                case 0: goto L_0x043d;
                case 1: goto L_0x044d;
                case 2: goto L_0x045d;
                case 3: goto L_0x0466;
                case 4: goto L_0x0476;
                case 5: goto L_0x0486;
                default: goto L_0x02d6;
            }     // Catch:{ all -> 0x003f }
        L_0x02d6:
            r18 = r13
            r19 = 10
            r18.addRule(r19)     // Catch:{ all -> 0x003f }
            r18 = r13
            r19 = 11
            r18.addRule(r19)     // Catch:{ all -> 0x003f }
        L_0x02e4:
            r18 = r2
            r0 = r18
            android.widget.LinearLayout r0 = r0.zzDj     // Catch:{ all -> 0x003f }
            r18 = r0
            com.google.android.gms.internal.zzfn$1 r19 = new com.google.android.gms.internal.zzfn$1     // Catch:{ all -> 0x003f }
            r26 = r19
            r19 = r26
            r20 = r26
            r21 = r2
            r20.<init>(r21)     // Catch:{ all -> 0x003f }
            r18.setOnClickListener(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.widget.LinearLayout r0 = r0.zzDj     // Catch:{ all -> 0x003f }
            r18 = r0
            java.lang.String r19 = "Close button"
            r18.setContentDescription(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.widget.RelativeLayout r0 = r0.zzDm     // Catch:{ all -> 0x003f }
            r18 = r0
            r19 = r2
            r0 = r19
            android.widget.LinearLayout r0 = r0.zzDj     // Catch:{ all -> 0x003f }
            r19 = r0
            r20 = r13
            r18.addView(r19, r20)     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.widget.PopupWindow r0 = r0.zzDl     // Catch:{ RuntimeException -> 0x0496 }
            r18 = r0
            r19 = r6
            android.view.View r19 = r19.getDecorView()     // Catch:{ RuntimeException -> 0x0496 }
            r20 = 0
            com.google.android.gms.ads.internal.util.client.zza r21 = com.google.android.gms.ads.internal.client.zzn.zzcS()     // Catch:{ RuntimeException -> 0x0496 }
            r22 = r2
            r0 = r22
            android.app.Activity r0 = r0.zzDh     // Catch:{ RuntimeException -> 0x0496 }
            r22 = r0
            r23 = r7
            r24 = 0
            r23 = r23[r24]     // Catch:{ RuntimeException -> 0x0496 }
            int r21 = r21.zzb(r22, r23)     // Catch:{ RuntimeException -> 0x0496 }
            com.google.android.gms.ads.internal.util.client.zza r22 = com.google.android.gms.ads.internal.client.zzn.zzcS()     // Catch:{ RuntimeException -> 0x0496 }
            r23 = r2
            r0 = r23
            android.app.Activity r0 = r0.zzDh     // Catch:{ RuntimeException -> 0x0496 }
            r23 = r0
            r24 = r7
            r25 = 1
            r24 = r24[r25]     // Catch:{ RuntimeException -> 0x0496 }
            int r22 = r22.zzb(r23, r24)     // Catch:{ RuntimeException -> 0x0496 }
            r18.showAtLocation(r19, r20, r21, r22)     // Catch:{ RuntimeException -> 0x0496 }
            r18 = r2
            r19 = r7
            r20 = 0
            r19 = r19[r20]     // Catch:{ all -> 0x003f }
            r20 = r7
            r21 = 1
            r20 = r20[r21]     // Catch:{ all -> 0x003f }
            r18.zzc(r19, r20)     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            com.google.android.gms.internal.zzjp r0 = r0.zzpD     // Catch:{ all -> 0x003f }
            r18 = r0
            com.google.android.gms.ads.internal.client.AdSizeParcel r19 = new com.google.android.gms.ads.internal.client.AdSizeParcel     // Catch:{ all -> 0x003f }
            r26 = r19
            r19 = r26
            r20 = r26
            r21 = r2
            r0 = r21
            android.app.Activity r0 = r0.zzDh     // Catch:{ all -> 0x003f }
            r21 = r0
            com.google.android.gms.ads.AdSize r22 = new com.google.android.gms.ads.AdSize     // Catch:{ all -> 0x003f }
            r26 = r22
            r22 = r26
            r23 = r26
            r24 = r2
            r0 = r24
            int r0 = r0.zzoG     // Catch:{ all -> 0x003f }
            r24 = r0
            r25 = r2
            r0 = r25
            int r0 = r0.zzoH     // Catch:{ all -> 0x003f }
            r25 = r0
            r23.<init>(r24, r25)     // Catch:{ all -> 0x003f }
            r20.<init>(r21, r22)     // Catch:{ all -> 0x003f }
            r18.zza(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            r19 = r7
            r20 = 0
            r19 = r19[r20]     // Catch:{ all -> 0x003f }
            r20 = r7
            r21 = 1
            r20 = r20[r21]     // Catch:{ all -> 0x003f }
            r18.zzd(r19, r20)     // Catch:{ all -> 0x003f }
            r18 = r2
            java.lang.String r19 = "resized"
            r18.zzao(r19)     // Catch:{ all -> 0x003f }
            r18 = r4
            monitor-exit(r18)     // Catch:{ all -> 0x003f }
            goto L_0x0025
        L_0x03c4:
            r18 = r2
            r0 = r18
            android.widget.PopupWindow r0 = r0.zzDl     // Catch:{ all -> 0x003f }
            r18 = r0
            r18.dismiss()     // Catch:{ all -> 0x003f }
            goto L_0x01ba
        L_0x03d1:
            r18 = r2
            java.lang.String r19 = "Webview is detached, probably in the middle of a resize or expand."
            r18.zzam(r19)     // Catch:{ all -> 0x003f }
            r18 = r4
            monitor-exit(r18)     // Catch:{ all -> 0x003f }
            goto L_0x0025
        L_0x03dd:
            r18 = r14
            java.lang.String r19 = "top-left"
            boolean r18 = r18.equals(r19)     // Catch:{ all -> 0x003f }
            if (r18 == 0) goto L_0x02cd
            r18 = 0
            r15 = r18
            goto L_0x02d1
        L_0x03ed:
            r18 = r14
            java.lang.String r19 = "top-center"
            boolean r18 = r18.equals(r19)     // Catch:{ all -> 0x003f }
            if (r18 == 0) goto L_0x02cd
            r18 = 1
            r15 = r18
            goto L_0x02d1
        L_0x03fd:
            r18 = r14
            java.lang.String r19 = "center"
            boolean r18 = r18.equals(r19)     // Catch:{ all -> 0x003f }
            if (r18 == 0) goto L_0x02cd
            r18 = 2
            r15 = r18
            goto L_0x02d1
        L_0x040d:
            r18 = r14
            java.lang.String r19 = "bottom-left"
            boolean r18 = r18.equals(r19)     // Catch:{ all -> 0x003f }
            if (r18 == 0) goto L_0x02cd
            r18 = 3
            r15 = r18
            goto L_0x02d1
        L_0x041d:
            r18 = r14
            java.lang.String r19 = "bottom-center"
            boolean r18 = r18.equals(r19)     // Catch:{ all -> 0x003f }
            if (r18 == 0) goto L_0x02cd
            r18 = 4
            r15 = r18
            goto L_0x02d1
        L_0x042d:
            r18 = r14
            java.lang.String r19 = "bottom-right"
            boolean r18 = r18.equals(r19)     // Catch:{ all -> 0x003f }
            if (r18 == 0) goto L_0x02cd
            r18 = 5
            r15 = r18
            goto L_0x02d1
        L_0x043d:
            r18 = r13
            r19 = 10
            r18.addRule(r19)     // Catch:{ all -> 0x003f }
            r18 = r13
            r19 = 9
            r18.addRule(r19)     // Catch:{ all -> 0x003f }
            goto L_0x02e4
        L_0x044d:
            r18 = r13
            r19 = 10
            r18.addRule(r19)     // Catch:{ all -> 0x003f }
            r18 = r13
            r19 = 14
            r18.addRule(r19)     // Catch:{ all -> 0x003f }
            goto L_0x02e4
        L_0x045d:
            r18 = r13
            r19 = 13
            r18.addRule(r19)     // Catch:{ all -> 0x003f }
            goto L_0x02e4
        L_0x0466:
            r18 = r13
            r19 = 12
            r18.addRule(r19)     // Catch:{ all -> 0x003f }
            r18 = r13
            r19 = 9
            r18.addRule(r19)     // Catch:{ all -> 0x003f }
            goto L_0x02e4
        L_0x0476:
            r18 = r13
            r19 = 12
            r18.addRule(r19)     // Catch:{ all -> 0x003f }
            r18 = r13
            r19 = 14
            r18.addRule(r19)     // Catch:{ all -> 0x003f }
            goto L_0x02e4
        L_0x0486:
            r18 = r13
            r19 = 12
            r18.addRule(r19)     // Catch:{ all -> 0x003f }
            r18 = r13
            r19 = 11
            r18.addRule(r19)     // Catch:{ all -> 0x003f }
            goto L_0x02e4
        L_0x0496:
            r18 = move-exception
            r16 = r18
            r18 = r2
            java.lang.StringBuilder r19 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
            r26 = r19
            r19 = r26
            r20 = r26
            r20.<init>()     // Catch:{ all -> 0x003f }
            java.lang.String r20 = "Cannot show popup window: "
            java.lang.StringBuilder r19 = r19.append(r20)     // Catch:{ all -> 0x003f }
            r20 = r16
            java.lang.String r20 = r20.getMessage()     // Catch:{ all -> 0x003f }
            java.lang.StringBuilder r19 = r19.append(r20)     // Catch:{ all -> 0x003f }
            java.lang.String r19 = r19.toString()     // Catch:{ all -> 0x003f }
            r18.zzam(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.widget.RelativeLayout r0 = r0.zzDm     // Catch:{ all -> 0x003f }
            r18 = r0
            r19 = r2
            r0 = r19
            com.google.android.gms.internal.zzjp r0 = r0.zzpD     // Catch:{ all -> 0x003f }
            r19 = r0
            android.view.View r19 = r19.getView()     // Catch:{ all -> 0x003f }
            r18.removeView(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.view.ViewGroup r0 = r0.zzDn     // Catch:{ all -> 0x003f }
            r18 = r0
            if (r18 == 0) goto L_0x051b
            r18 = r2
            r0 = r18
            android.view.ViewGroup r0 = r0.zzDn     // Catch:{ all -> 0x003f }
            r18 = r0
            r19 = r2
            r0 = r19
            android.widget.ImageView r0 = r0.zzDi     // Catch:{ all -> 0x003f }
            r19 = r0
            r18.removeView(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            android.view.ViewGroup r0 = r0.zzDn     // Catch:{ all -> 0x003f }
            r18 = r0
            r19 = r2
            r0 = r19
            com.google.android.gms.internal.zzjp r0 = r0.zzpD     // Catch:{ all -> 0x003f }
            r19 = r0
            android.view.View r19 = r19.getView()     // Catch:{ all -> 0x003f }
            r18.addView(r19)     // Catch:{ all -> 0x003f }
            r18 = r2
            r0 = r18
            com.google.android.gms.internal.zzjp r0 = r0.zzpD     // Catch:{ all -> 0x003f }
            r18 = r0
            r19 = r2
            r0 = r19
            com.google.android.gms.ads.internal.client.AdSizeParcel r0 = r0.zzCh     // Catch:{ all -> 0x003f }
            r19 = r0
            r18.zza(r19)     // Catch:{ all -> 0x003f }
        L_0x051b:
            r18 = r4
            monitor-exit(r18)     // Catch:{ all -> 0x003f }
            goto L_0x0025
        L_0x0520:
            r18 = 0
            r12 = r18
            goto L_0x024c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfn.zzi(java.util.Map):void");
    }

    public void zzp(boolean z) {
        boolean z2 = z;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzDl != null) {
                    this.zzDl.dismiss();
                    this.zzDm.removeView(this.zzpD.getView());
                    if (this.zzDn != null) {
                        this.zzDn.removeView(this.zzDi);
                        this.zzDn.addView(this.zzpD.getView());
                        this.zzpD.zza(this.zzCh);
                    }
                    if (z2) {
                        zzao("default");
                        if (this.zzDk != null) {
                            this.zzDk.zzbf();
                        }
                    }
                    this.zzDl = null;
                    this.zzDm = null;
                    this.zzDn = null;
                    this.zzDj = null;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
