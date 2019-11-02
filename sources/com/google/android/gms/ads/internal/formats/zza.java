package com.google.android.gms.ads.internal.formats;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.zzhb;
import java.util.List;

@zzhb
public class zza {
    private static final int zzxI = Color.rgb(12, 174, 206);
    private static final int zzxJ = Color.rgb(204, 204, 204);
    static final int zzxK = zzxJ;
    static final int zzxL = zzxI;
    private final int mTextColor;
    private final String zzxM;
    private final List<Drawable> zzxN;
    private final int zzxO;
    private final int zzxP;
    private final int zzxQ;

    public zza(String str, List<Drawable> list, Integer num, Integer num2, Integer num3, int i) {
        List<Drawable> list2 = list;
        Integer num4 = num;
        Integer num5 = num2;
        Integer num6 = num3;
        int i2 = i;
        this.zzxM = str;
        this.zzxN = list2;
        this.zzxO = num4 != null ? num4.intValue() : zzxK;
        this.mTextColor = num5 != null ? num5.intValue() : zzxL;
        this.zzxP = num6 != null ? num6.intValue() : 12;
        this.zzxQ = i2;
    }

    public int getBackgroundColor() {
        return this.zzxO;
    }

    public String getText() {
        return this.zzxM;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public int getTextSize() {
        return this.zzxP;
    }

    public List<Drawable> zzdG() {
        return this.zzxN;
    }

    public int zzdH() {
        return this.zzxQ;
    }
}
