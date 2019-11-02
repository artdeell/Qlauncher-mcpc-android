package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzfb.zza;
import java.util.ArrayList;
import java.util.List;

@zzhb
public class zzfg extends zza {
    private final NativeAppInstallAdMapper zzCM;

    public zzfg(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzCM = nativeAppInstallAdMapper;
    }

    public String getBody() {
        return this.zzCM.getBody();
    }

    public String getCallToAction() {
        return this.zzCM.getCallToAction();
    }

    public Bundle getExtras() {
        return this.zzCM.getExtras();
    }

    public String getHeadline() {
        return this.zzCM.getHeadline();
    }

    public List getImages() {
        ArrayList arrayList;
        zzc zzc;
        List<Image> images = this.zzCM.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (Image image : images) {
            ArrayList arrayList5 = arrayList4;
            zzc zzc2 = zzc;
            zzc zzc3 = new zzc(image.getDrawable(), image.getUri(), image.getScale());
            boolean add = arrayList5.add(zzc2);
        }
        return arrayList4;
    }

    public boolean getOverrideClickHandling() {
        return this.zzCM.getOverrideClickHandling();
    }

    public boolean getOverrideImpressionRecording() {
        return this.zzCM.getOverrideImpressionRecording();
    }

    public String getPrice() {
        return this.zzCM.getPrice();
    }

    public double getStarRating() {
        return this.zzCM.getStarRating();
    }

    public String getStore() {
        return this.zzCM.getStore();
    }

    public void recordImpression() {
        this.zzCM.recordImpression();
    }

    public void zzc(zzd zzd) {
        this.zzCM.handleClick((View) zze.zzp(zzd));
    }

    public void zzd(zzd zzd) {
        this.zzCM.trackView((View) zze.zzp(zzd));
    }

    public zzch zzdK() {
        zzc zzc;
        Image icon = this.zzCM.getIcon();
        if (icon == null) {
            return null;
        }
        zzc zzc2 = zzc;
        zzc zzc3 = new zzc(icon.getDrawable(), icon.getUri(), icon.getScale());
        return zzc2;
    }
}
