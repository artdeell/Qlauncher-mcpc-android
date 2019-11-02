package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzfc.zza;
import java.util.ArrayList;
import java.util.List;

@zzhb
public class zzfh extends zza {
    private final NativeContentAdMapper zzCN;

    public zzfh(NativeContentAdMapper nativeContentAdMapper) {
        this.zzCN = nativeContentAdMapper;
    }

    public String getAdvertiser() {
        return this.zzCN.getAdvertiser();
    }

    public String getBody() {
        return this.zzCN.getBody();
    }

    public String getCallToAction() {
        return this.zzCN.getCallToAction();
    }

    public Bundle getExtras() {
        return this.zzCN.getExtras();
    }

    public String getHeadline() {
        return this.zzCN.getHeadline();
    }

    public List getImages() {
        ArrayList arrayList;
        zzc zzc;
        List<Image> images = this.zzCN.getImages();
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
        return this.zzCN.getOverrideClickHandling();
    }

    public boolean getOverrideImpressionRecording() {
        return this.zzCN.getOverrideImpressionRecording();
    }

    public void recordImpression() {
        this.zzCN.recordImpression();
    }

    public void zzc(zzd zzd) {
        this.zzCN.handleClick((View) zze.zzp(zzd));
    }

    public void zzd(zzd zzd) {
        this.zzCN.trackView((View) zze.zzp(zzd));
    }

    public zzch zzdO() {
        zzc zzc;
        Image logo = this.zzCN.getLogo();
        if (logo == null) {
            return null;
        }
        zzc zzc2 = zzc;
        zzc zzc3 = new zzc(logo.getDrawable(), logo.getUri(), logo.getScale());
        return zzc2;
    }
}
