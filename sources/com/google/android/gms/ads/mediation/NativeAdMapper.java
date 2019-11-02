package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;

public abstract class NativeAdMapper {
    protected Bundle mExtras;
    protected boolean mOverrideClickHandling;
    protected boolean mOverrideImpressionRecording;

    public NativeAdMapper() {
        Bundle bundle;
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        this.mExtras = bundle2;
    }

    public final Bundle getExtras() {
        return this.mExtras;
    }

    public final boolean getOverrideClickHandling() {
        return this.mOverrideClickHandling;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.mOverrideImpressionRecording;
    }

    public void handleClick(View view) {
    }

    public void recordImpression() {
    }

    public final void setExtras(Bundle bundle) {
        Bundle bundle2 = bundle;
        this.mExtras = bundle2;
    }

    public final void setOverrideClickHandling(boolean z) {
        boolean z2 = z;
        this.mOverrideClickHandling = z2;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        boolean z2 = z;
        this.mOverrideImpressionRecording = z2;
    }

    public void trackView(View view) {
    }
}
