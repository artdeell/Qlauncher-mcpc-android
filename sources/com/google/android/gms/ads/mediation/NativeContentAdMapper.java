package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeContentAdMapper extends NativeAdMapper {
    private Image zzOp;
    private String zzxW;
    private List<Image> zzxX;
    private String zzxY;
    private String zzya;
    private String zzyh;

    public NativeContentAdMapper() {
    }

    public final String getAdvertiser() {
        return this.zzyh;
    }

    public final String getBody() {
        return this.zzxY;
    }

    public final String getCallToAction() {
        return this.zzya;
    }

    public final String getHeadline() {
        return this.zzxW;
    }

    public final List<Image> getImages() {
        return this.zzxX;
    }

    public final Image getLogo() {
        return this.zzOp;
    }

    public final void setAdvertiser(String str) {
        String str2 = str;
        this.zzyh = str2;
    }

    public final void setBody(String str) {
        String str2 = str;
        this.zzxY = str2;
    }

    public final void setCallToAction(String str) {
        String str2 = str;
        this.zzya = str2;
    }

    public final void setHeadline(String str) {
        String str2 = str;
        this.zzxW = str2;
    }

    public final void setImages(List<Image> list) {
        List<Image> list2 = list;
        this.zzxX = list2;
    }

    public final void setLogo(Image image) {
        Image image2 = image;
        this.zzOp = image2;
    }
}
