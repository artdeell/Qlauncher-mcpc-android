package com.google.android.gms.ads.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;

public abstract class NativeAd {

    public static abstract class Image {
        public Image() {
        }

        public abstract Drawable getDrawable();

        public abstract double getScale();

        public abstract Uri getUri();
    }

    public NativeAd() {
    }

    /* access modifiers changed from: protected */
    public abstract Object zzaH();
}
