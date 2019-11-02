package android.support.p000v4.graphics.drawable;

import android.content.res.Resources.Theme;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.graphics.drawable.DrawableWrapperLollipop */
class DrawableWrapperLollipop extends DrawableWrapperKitKat {
    DrawableWrapperLollipop(Drawable drawable) {
        super(drawable);
    }

    public void applyTheme(Theme theme) {
        Theme theme2 = theme;
        this.mDrawable.applyTheme(theme2);
    }

    public boolean canApplyTheme() {
        return this.mDrawable.canApplyTheme();
    }

    public Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        Outline outline2 = outline;
        this.mDrawable.getOutline(outline2);
    }

    public void setHotspot(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        this.mDrawable.setHotspot(f3, f4);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        this.mDrawable.setHotspotBounds(i5, i6, i7, i8);
    }
}
