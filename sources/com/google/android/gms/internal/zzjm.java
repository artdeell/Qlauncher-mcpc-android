package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

@zzhb
class zzjm extends zzjn implements OnScrollChangedListener {
    private final WeakReference<OnScrollChangedListener> zzNv;

    public zzjm(View view, OnScrollChangedListener onScrollChangedListener) {
        WeakReference<OnScrollChangedListener> weakReference;
        OnScrollChangedListener onScrollChangedListener2 = onScrollChangedListener;
        super(view);
        WeakReference<OnScrollChangedListener> weakReference2 = weakReference;
        WeakReference<OnScrollChangedListener> weakReference3 = new WeakReference<>(onScrollChangedListener2);
        this.zzNv = weakReference2;
    }

    public void onScrollChanged() {
        OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) this.zzNv.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            detach();
        }
    }

    /* access modifiers changed from: protected */
    public void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    /* access modifiers changed from: protected */
    public void zzb(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }
}
