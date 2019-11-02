package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

abstract class zzjn {
    private final WeakReference<View> zzNw;

    public zzjn(View view) {
        WeakReference<View> weakReference;
        WeakReference<View> weakReference2 = weakReference;
        WeakReference<View> weakReference3 = new WeakReference<>(view);
        this.zzNw = weakReference2;
    }

    public final void detach() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            zzb(viewTreeObserver);
        }
    }

    /* access modifiers changed from: protected */
    public ViewTreeObserver getViewTreeObserver() {
        ViewTreeObserver viewTreeObserver;
        View view = (View) this.zzNw.get();
        if (view == null) {
            viewTreeObserver = null;
        } else {
            viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                return null;
            }
        }
        return viewTreeObserver;
    }

    /* access modifiers changed from: protected */
    public abstract void zza(ViewTreeObserver viewTreeObserver);

    /* access modifiers changed from: protected */
    public abstract void zzb(ViewTreeObserver viewTreeObserver);

    public final void zzhL() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            zza(viewTreeObserver);
        }
    }
}
