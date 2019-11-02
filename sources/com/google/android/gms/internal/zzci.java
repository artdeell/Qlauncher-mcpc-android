package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzhb
public class zzci extends Image {
    private final Drawable mDrawable;
    private final Uri mUri;
    private final double zzxV;
    private final zzch zzyL;

    public zzci(zzch zzch) {
        Drawable drawable;
        Uri uri;
        this.zzyL = zzch;
        try {
            zzd zzdJ = this.zzyL.zzdJ();
            if (zzdJ != null) {
                drawable = (Drawable) zze.zzp(zzdJ);
                this.mDrawable = drawable;
                uri = this.zzyL.getUri();
                this.mUri = uri;
                double d = 1.0d;
                d = this.zzyL.getScale();
                this.zzxV = d;
            }
        } catch (RemoteException e) {
            zzb.zzb("Failed to get drawable.", e);
        }
        drawable = null;
        this.mDrawable = drawable;
        try {
            uri = this.zzyL.getUri();
        } catch (RemoteException e2) {
            zzb.zzb("Failed to get uri.", e2);
            uri = null;
        }
        this.mUri = uri;
        double d2 = 1.0d;
        try {
            d2 = this.zzyL.getScale();
        } catch (RemoteException e3) {
            zzb.zzb("Failed to get scale.", e3);
        }
        this.zzxV = d2;
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public double getScale() {
        return this.zzxV;
    }

    public Uri getUri() {
        return this.mUri;
    }
}
