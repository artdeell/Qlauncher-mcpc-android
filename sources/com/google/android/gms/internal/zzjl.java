package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.zzr;
import java.lang.ref.WeakReference;

@zzhb
class zzjl extends zzjn implements OnGlobalLayoutListener {
    private final WeakReference<OnGlobalLayoutListener> zzNv;

    public zzjl(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        WeakReference<OnGlobalLayoutListener> weakReference;
        OnGlobalLayoutListener onGlobalLayoutListener2 = onGlobalLayoutListener;
        super(view);
        WeakReference<OnGlobalLayoutListener> weakReference2 = weakReference;
        WeakReference<OnGlobalLayoutListener> weakReference3 = new WeakReference<>(onGlobalLayoutListener2);
        this.zzNv = weakReference2;
    }

    public void onGlobalLayout() {
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.zzNv.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            detach();
        }
    }

    /* access modifiers changed from: protected */
    public void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    /* access modifiers changed from: protected */
    public void zzb(ViewTreeObserver viewTreeObserver) {
        ViewTreeObserver viewTreeObserver2 = viewTreeObserver;
        zzr.zzbE().zza(viewTreeObserver2, (OnGlobalLayoutListener) this);
    }
}
