package com.google.android.gms.ads.formats;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcj;

public abstract class NativeAdView extends FrameLayout {
    private final FrameLayout zzoQ;
    private final zzcj zzoR = zzaI();

    public NativeAdView(Context context) {
        Context context2 = context;
        super(context2);
        this.zzoQ = zzn(context2);
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        Context context2 = context;
        super(context2, attributeSet);
        this.zzoQ = zzn(context2);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        Context context2 = context;
        super(context2, attributeSet, i);
        this.zzoQ = zzn(context2);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        Context context2 = context;
        super(context2, attributeSet, i, i2);
        this.zzoQ = zzn(context2);
    }

    private zzcj zzaI() {
        Object zzb = zzx.zzb(this.zzoQ, (Object) "createDelegate must be called after mOverlayFrame has been created");
        return zzn.zzcW().zza(this.zzoQ.getContext(), this, this.zzoQ);
    }

    private FrameLayout zzn(Context context) {
        LayoutParams layoutParams;
        FrameLayout zzo = zzo(context);
        FrameLayout frameLayout = zzo;
        LayoutParams layoutParams2 = layoutParams;
        LayoutParams layoutParams3 = new LayoutParams(-1, -1);
        frameLayout.setLayoutParams(layoutParams2);
        addView(zzo);
        return zzo;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzoQ);
    }

    public void bringChildToFront(View view) {
        View view2 = view;
        super.bringChildToFront(view2);
        if (this.zzoQ != view2) {
            super.bringChildToFront(this.zzoQ);
        }
    }

    public void destroy() {
        try {
            this.zzoR.destroy();
        } catch (RemoteException e) {
            zzb.zzb("Unable to destroy native ad view", e);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzoQ);
    }

    public void removeView(View view) {
        View view2 = view;
        if (this.zzoQ != view2) {
            super.removeView(view2);
        }
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzoR.zza((zzd) nativeAd.zzaH());
        } catch (RemoteException e) {
            zzb.zzb("Unable to call setNativeAd on delegate", e);
        }
    }

    /* access modifiers changed from: protected */
    public void zza(String str, View view) {
        try {
            this.zzoR.zza(str, zze.zzC(view));
        } catch (RemoteException e) {
            zzb.zzb("Unable to call setAssetView on delegate", e);
        }
    }

    /* access modifiers changed from: protected */
    public View zzn(String str) {
        try {
            zzd zzK = this.zzoR.zzK(str);
            if (zzK != null) {
                return (View) zze.zzp(zzK);
            }
        } catch (RemoteException e) {
            zzb.zzb("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public FrameLayout zzo(Context context) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        FrameLayout frameLayout3 = new FrameLayout(context);
        return frameLayout2;
    }
}
