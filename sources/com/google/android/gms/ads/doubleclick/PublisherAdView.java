package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.internal.client.zzab;

public final class PublisherAdView extends ViewGroup {
    private final zzab zzoJ;

    public PublisherAdView(Context context) {
        zzab zzab;
        super(context);
        zzab zzab2 = zzab;
        zzab zzab3 = new zzab(this);
        this.zzoJ = zzab2;
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        zzab zzab;
        AttributeSet attributeSet2 = attributeSet;
        super(context, attributeSet2);
        zzab zzab2 = zzab;
        zzab zzab3 = new zzab(this, attributeSet2, true);
        this.zzoJ = zzab2;
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        zzab zzab;
        AttributeSet attributeSet2 = attributeSet;
        super(context, attributeSet2, i);
        zzab zzab2 = zzab;
        zzab zzab3 = new zzab(this, attributeSet2, true);
        this.zzoJ = zzab2;
    }

    public void destroy() {
        this.zzoJ.destroy();
    }

    public AdListener getAdListener() {
        return this.zzoJ.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zzoJ.getAdSize();
    }

    public AdSize[] getAdSizes() {
        return this.zzoJ.getAdSizes();
    }

    public String getAdUnitId() {
        return this.zzoJ.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.zzoJ.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzoJ.getMediationAdapterClassName();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzoJ.getOnCustomRenderedAdLoadedListener();
    }

    public boolean isLoading() {
        return this.zzoJ.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzoJ.zza(publisherAdRequest.zzaE());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = z;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i9 = ((i7 - i5) - measuredWidth) / 2;
            int i10 = ((i8 - i6) - measuredHeight) / 2;
            childAt.layout(i9, i10, measuredWidth + i9, measuredHeight + i10);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = i;
        int i6 = i2;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = getAdSize();
            if (adSize != null) {
                Context context = getContext();
                i4 = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
            } else {
                i3 = 0;
                i4 = 0;
            }
        } else {
            measureChild(childAt, i5, i6);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i5), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i6));
    }

    public void pause() {
        this.zzoJ.pause();
    }

    public void recordManualImpression() {
        this.zzoJ.recordManualImpression();
    }

    public void resume() {
        this.zzoJ.resume();
    }

    public void setAdListener(AdListener adListener) {
        AdListener adListener2 = adListener;
        this.zzoJ.setAdListener(adListener2);
    }

    public void setAdSizes(AdSize... adSizeArr) {
        IllegalArgumentException illegalArgumentException;
        AdSize[] adSizeArr2 = adSizeArr;
        if (adSizeArr2 == null || adSizeArr2.length < 1) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            throw illegalArgumentException2;
        }
        this.zzoJ.zza(adSizeArr2);
    }

    public void setAdUnitId(String str) {
        String str2 = str;
        this.zzoJ.setAdUnitId(str2);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        AppEventListener appEventListener2 = appEventListener;
        this.zzoJ.setAppEventListener(appEventListener2);
    }

    public void setCorrelator(Correlator correlator) {
        Correlator correlator2 = correlator;
        this.zzoJ.setCorrelator(correlator2);
    }

    public void setManualImpressionsEnabled(boolean z) {
        boolean z2 = z;
        this.zzoJ.setManualImpressionsEnabled(z2);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener2 = onCustomRenderedAdLoadedListener;
        this.zzoJ.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener2);
    }
}
