package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.view.InputDeviceCompat;
import android.support.p000v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;
import java.util.HashMap;
import java.util.Map;

@zzhb
public class zzk extends FrameLayout implements zzh {
    private final FrameLayout zzEN;
    private final zzu zzEO;
    @Nullable
    private zzi zzEP;
    private boolean zzEQ;
    private boolean zzER;
    private TextView zzES;
    private long zzET;
    private long zzEU;
    private String zzEV;
    private final zzjp zzpD;
    private String zzzK;

    public zzk(Context context, zzjp zzjp, int i, zzcb zzcb, zzbz zzbz) {
        FrameLayout frameLayout;
        LayoutParams layoutParams;
        TextView textView;
        zzu zzu;
        LayoutParams layoutParams2;
        Context context2 = context;
        zzjp zzjp2 = zzjp;
        int i2 = i;
        zzcb zzcb2 = zzcb;
        zzbz zzbz2 = zzbz;
        super(context2);
        this.zzpD = zzjp2;
        FrameLayout frameLayout2 = frameLayout;
        FrameLayout frameLayout3 = new FrameLayout(context2);
        this.zzEN = frameLayout2;
        FrameLayout frameLayout4 = this.zzEN;
        LayoutParams layoutParams3 = layoutParams;
        LayoutParams layoutParams4 = new LayoutParams(-1, -1);
        addView(frameLayout4, layoutParams3);
        zzb.zzv(zzjp2.zzhR());
        this.zzEP = zzjp2.zzhR().zzpx.zza(context2, zzjp2, i2, zzcb2, zzbz2);
        if (this.zzEP != null) {
            FrameLayout frameLayout5 = this.zzEN;
            zzi zzi = this.zzEP;
            LayoutParams layoutParams5 = layoutParams2;
            LayoutParams layoutParams6 = new LayoutParams(-1, -1, 17);
            frameLayout5.addView(zzi, layoutParams5);
        }
        TextView textView2 = textView;
        TextView textView3 = new TextView(context2);
        this.zzES = textView2;
        this.zzES.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        zzfG();
        zzu zzu2 = zzu;
        zzu zzu3 = new zzu(this);
        this.zzEO = zzu2;
        this.zzEO.zzfQ();
        if (this.zzEP != null) {
            this.zzEP.zza((zzh) this);
        }
        if (this.zzEP == null) {
            zzg("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    private void zza(String str, String... strArr) {
        HashMap hashMap;
        String str2 = str;
        String[] strArr2 = strArr;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = hashMap2;
        Object put = hashMap4.put("event", str2);
        int length = strArr2.length;
        int i = 0;
        String str3 = null;
        while (true) {
            String str4 = str3;
            if (i < length) {
                String str5 = strArr2[i];
                if (str4 != null) {
                    Object put2 = hashMap4.put(str4, str5);
                    str5 = null;
                }
                i++;
                str3 = str5;
            } else {
                this.zzpD.zza("onVideoEvent", (Map<String, ?>) hashMap4);
                return;
            }
        }
    }

    private void zzfG() {
        LayoutParams layoutParams;
        if (!zzfI()) {
            FrameLayout frameLayout = this.zzEN;
            TextView textView = this.zzES;
            LayoutParams layoutParams2 = layoutParams;
            LayoutParams layoutParams3 = new LayoutParams(-1, -1);
            frameLayout.addView(textView, layoutParams2);
            this.zzEN.bringChildToFront(this.zzES);
        }
    }

    private void zzfH() {
        if (zzfI()) {
            this.zzEN.removeView(this.zzES);
        }
    }

    private boolean zzfI() {
        return this.zzES.getParent() != null;
    }

    private void zzfJ() {
        if (this.zzpD.zzhP() != null && !this.zzEQ) {
            this.zzER = (128 & this.zzpD.zzhP().getWindow().getAttributes().flags) != 0;
            if (!this.zzER) {
                this.zzpD.zzhP().getWindow().addFlags(128);
                this.zzEQ = true;
            }
        }
    }

    private void zzfK() {
        if (this.zzpD.zzhP() != null && this.zzEQ && !this.zzER) {
            this.zzpD.zzhP().getWindow().clearFlags(128);
            this.zzEQ = false;
        }
    }

    public static void zzg(zzjp zzjp) {
        HashMap hashMap;
        zzjp zzjp2 = zzjp;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = hashMap2;
        Object put = hashMap4.put("event", "no_video_view");
        zzjp2.zza("onVideoEvent", (Map<String, ?>) hashMap4);
    }

    public void destroy() {
        this.zzEO.cancel();
        if (this.zzEP != null) {
            this.zzEP.stop();
        }
        zzfK();
    }

    public void onPaused() {
        zza("pause", new String[0]);
        zzfK();
    }

    public void pause() {
        if (this.zzEP != null) {
            this.zzEP.pause();
        }
    }

    public void play() {
        if (this.zzEP != null) {
            this.zzEP.play();
        }
    }

    public void seekTo(int i) {
        int i2 = i;
        if (this.zzEP != null) {
            this.zzEP.seekTo(i2);
        }
    }

    public void setMimeType(String str) {
        String str2 = str;
        this.zzEV = str2;
    }

    public void zza(float f) {
        float f2 = f;
        if (this.zzEP != null) {
            this.zzEP.zza(f2);
        }
    }

    public void zzap(String str) {
        String str2 = str;
        this.zzzK = str2;
    }

    public void zzd(int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (i7 != 0 && i8 != 0) {
            LayoutParams layoutParams2 = layoutParams;
            LayoutParams layoutParams3 = new LayoutParams(i7 + 2, i8 + 2);
            LayoutParams layoutParams4 = layoutParams2;
            layoutParams4.setMargins(i5 - 1, i6 - 1, 0, 0);
            this.zzEN.setLayoutParams(layoutParams4);
            requestLayout();
        }
    }

    public void zzd(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        if (this.zzEP != null) {
            boolean dispatchTouchEvent = this.zzEP.dispatchTouchEvent(motionEvent2);
        }
    }

    public void zzfA() {
        zzfJ();
    }

    public void zzfB() {
        zza("ended", new String[0]);
        zzfK();
    }

    public void zzfC() {
        zzfG();
        this.zzEU = this.zzET;
    }

    public void zzfD() {
        if (this.zzEP != null) {
            if (!TextUtils.isEmpty(this.zzzK)) {
                this.zzEP.setMimeType(this.zzEV);
                this.zzEP.setVideoPath(this.zzzK);
                return;
            }
            zza("no_src", new String[0]);
        }
    }

    public void zzfE() {
        TextView textView;
        StringBuilder sb;
        LayoutParams layoutParams;
        if (this.zzEP != null) {
            TextView textView2 = textView;
            TextView textView3 = new TextView(this.zzEP.getContext());
            TextView textView4 = textView2;
            TextView textView5 = textView4;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            textView5.setText(sb2.append("AdMob - ").append(this.zzEP.zzeZ()).toString());
            textView4.setTextColor(SupportMenu.CATEGORY_MASK);
            textView4.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            FrameLayout frameLayout = this.zzEN;
            TextView textView6 = textView4;
            LayoutParams layoutParams2 = layoutParams;
            LayoutParams layoutParams3 = new LayoutParams(-2, -2, 17);
            frameLayout.addView(textView6, layoutParams2);
            this.zzEN.bringChildToFront(textView4);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzfF() {
        if (this.zzEP != null) {
            long currentPosition = (long) this.zzEP.getCurrentPosition();
            if (this.zzET != currentPosition && currentPosition > 0) {
                zzfH();
                zza("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
                this.zzET = currentPosition;
            }
        }
    }

    public void zzff() {
        if (this.zzEP != null) {
            this.zzEP.zzff();
        }
    }

    public void zzfg() {
        if (this.zzEP != null) {
            this.zzEP.zzfg();
        }
    }

    public void zzfy() {
    }

    public void zzfz() {
        if (this.zzEP != null && this.zzEU == 0) {
            zza("canplaythrough", "duration", String.valueOf(((float) this.zzEP.getDuration()) / 1000.0f), "videoWidth", String.valueOf(this.zzEP.getVideoWidth()), "videoHeight", String.valueOf(this.zzEP.getVideoHeight()));
        }
    }

    public void zzg(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        String[] strArr = new String[4];
        String[] strArr2 = strArr;
        strArr[0] = "what";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = str3;
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = "extra";
        String[] strArr7 = strArr6;
        String[] strArr8 = strArr7;
        strArr7[3] = str4;
        zza("error", strArr8);
    }
}
