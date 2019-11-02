package android.support.p000v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* renamed from: android.support.v4.content.res.ResourcesCompat */
public class ResourcesCompat {
    public ResourcesCompat() {
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i, @Nullable Theme theme) throws NotFoundException {
        Resources resources2 = resources;
        int i2 = i;
        return VERSION.SDK_INT >= 21 ? ResourcesCompatApi21.getDrawable(resources2, i2, theme) : resources2.getDrawable(i2);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i, int i2, @Nullable Theme theme) throws NotFoundException {
        Resources resources2 = resources;
        int i3 = i;
        int i4 = i2;
        return VERSION.SDK_INT >= 21 ? ResourcesCompatApi21.getDrawableForDensity(resources2, i3, i4, theme) : VERSION.SDK_INT >= 15 ? ResourcesCompatIcsMr1.getDrawableForDensity(resources2, i3, i4) : resources2.getDrawable(i3);
    }

    @ColorInt
    public int getColor(@NonNull Resources resources, @ColorRes int i, @Nullable Theme theme) throws NotFoundException {
        Resources resources2 = resources;
        int i2 = i;
        return VERSION.SDK_INT >= 23 ? ResourcesCompatApi23.getColor(resources2, i2, theme) : resources2.getColor(i2);
    }

    @Nullable
    public ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i, @Nullable Theme theme) throws NotFoundException {
        Resources resources2 = resources;
        int i2 = i;
        return VERSION.SDK_INT >= 23 ? ResourcesCompatApi23.getColorStateList(resources2, i2, theme) : resources2.getColorStateList(i2);
    }
}
