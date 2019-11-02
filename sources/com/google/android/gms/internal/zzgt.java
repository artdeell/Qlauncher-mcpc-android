package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.internal.zzif.zza;

@TargetApi(19)
@zzhb
public class zzgt extends zzgs {
    private Object zzGv;
    private PopupWindow zzGw;
    private boolean zzGx = false;

    zzgt(Context context, zza zza, zzjp zzjp, zzgr.zza zza2) {
        Object obj;
        super(context, zza, zzjp, zza2);
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzGv = obj2;
    }

    private void zzgj() {
        Object obj = this.zzGv;
        synchronized (obj) {
            try {
                this.zzGx = true;
                if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                    this.zzGw = null;
                }
                if (this.zzGw != null) {
                    if (this.zzGw.isShowing()) {
                        this.zzGw.dismiss();
                    }
                    this.zzGw = null;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void cancel() {
        zzgj();
        super.cancel();
    }

    /* access modifiers changed from: protected */
    public void zzC(int i) {
        int i2 = i;
        zzgj();
        super.zzC(i2);
    }

    /* access modifiers changed from: protected */
    public void zzgi() {
        FrameLayout frameLayout;
        LayoutParams layoutParams;
        PopupWindow popupWindow;
        Window window = this.mContext instanceof Activity ? ((Activity) this.mContext).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.mContext).isDestroyed()) {
            FrameLayout frameLayout2 = frameLayout;
            FrameLayout frameLayout3 = new FrameLayout(this.mContext);
            FrameLayout frameLayout4 = frameLayout2;
            FrameLayout frameLayout5 = frameLayout4;
            LayoutParams layoutParams2 = layoutParams;
            LayoutParams layoutParams3 = new LayoutParams(-1, -1);
            frameLayout5.setLayoutParams(layoutParams2);
            frameLayout4.addView(this.zzpD.getView(), -1, -1);
            Object obj = this.zzGv;
            synchronized (obj) {
                try {
                    if (!this.zzGx) {
                        PopupWindow popupWindow2 = popupWindow;
                        PopupWindow popupWindow3 = new PopupWindow(frameLayout4, 1, 1, false);
                        this.zzGw = popupWindow2;
                        this.zzGw.setOutsideTouchable(true);
                        this.zzGw.setClippingEnabled(false);
                        zzin.zzaI("Displaying the 1x1 popup off the screen.");
                        this.zzGw.showAtLocation(window.getDecorView(), 0, -1, -1);
                    }
                } catch (Exception e) {
                    Exception exc = e;
                    this.zzGw = null;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
    }
}
