package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeAppInstallAdMapper extends NativeAdMapper {
    private Image zzOo;
    private String zzxW;
    private List<Image> zzxX;
    private String zzxY;
    private String zzya;
    private double zzyb;
    private String zzyc;
    private String zzyd;

    public NativeAppInstallAdMapper() {
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

    public final Image getIcon() {
        return this.zzOo;
    }

    public final List<Image> getImages() {
        return this.zzxX;
    }

    public final String getPrice() {
        return this.zzyd;
    }

    public final double getStarRating() {
        return this.zzyb;
    }

    public final String getStore() {
        return this.zzyc;
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

    public final void setIcon(Image image) {
        Image image2 = image;
        this.zzOo = image2;
    }

    public final void setImages(List<Image> list) {
        List<Image> list2 = list;
        this.zzxX = list2;
    }

    public final void setPrice(String str) {
        String str2 = str;
        this.zzyd = str2;
    }

    public final void setStarRating(double d) {
        double d2 = d;
        this.zzyb = d2;
    }

    public final void setStore(String str) {
        String str2 = str;
        this.zzyc = str2;
    }
}
