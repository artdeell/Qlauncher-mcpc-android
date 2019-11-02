package android.support.p000v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* renamed from: android.support.v4.graphics.drawable.DrawableWrapperDonut */
class DrawableWrapperDonut extends Drawable implements Callback, DrawableWrapper {
    static final Mode DEFAULT_MODE = Mode.SRC_IN;
    private boolean mColorFilterSet;
    private int mCurrentColor;
    private Mode mCurrentMode;
    Drawable mDrawable;
    private ColorStateList mTintList;
    private Mode mTintMode = DEFAULT_MODE;

    DrawableWrapperDonut(Drawable drawable) {
        Drawable drawable2 = drawable;
        setWrappedDrawable(drawable2);
    }

    private boolean updateTint(int[] iArr) {
        int[] iArr2 = iArr;
        if (this.mTintList == null || this.mTintMode == null) {
            this.mColorFilterSet = false;
            clearColorFilter();
        } else {
            int colorForState = this.mTintList.getColorForState(iArr2, this.mTintList.getDefaultColor());
            Mode mode = this.mTintMode;
            if (!(this.mColorFilterSet && colorForState == this.mCurrentColor && mode == this.mCurrentMode)) {
                setColorFilter(colorForState, mode);
                this.mCurrentColor = colorForState;
                this.mCurrentMode = mode;
                this.mColorFilterSet = true;
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        this.mDrawable.draw(canvas2);
    }

    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = drawable;
        invalidateSelf();
    }

    public boolean isStateful() {
        return (this.mTintList != null && this.mTintList.isStateful()) || this.mDrawable.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.mDrawable;
        Drawable mutate = drawable.mutate();
        if (mutate != drawable) {
            setWrappedDrawable(mutate);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Rect rect2 = rect;
        this.mDrawable.setBounds(rect2);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.mDrawable.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable drawable2 = drawable;
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        int i2 = i;
        this.mDrawable.setAlpha(i2);
    }

    public void setChangingConfigurations(int i) {
        int i2 = i;
        this.mDrawable.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        ColorFilter colorFilter2 = colorFilter;
        this.mDrawable.setColorFilter(colorFilter2);
    }

    public void setDither(boolean z) {
        boolean z2 = z;
        this.mDrawable.setDither(z2);
    }

    public void setFilterBitmap(boolean z) {
        boolean z2 = z;
        this.mDrawable.setFilterBitmap(z2);
    }

    public boolean setState(int[] iArr) {
        int[] iArr2 = iArr;
        return updateTint(iArr2) || this.mDrawable.setState(iArr2);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.mTintList = colorStateList;
        boolean updateTint = updateTint(getState());
    }

    public void setTintMode(Mode mode) {
        this.mTintMode = mode;
        boolean updateTint = updateTint(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean z3 = z;
        boolean z4 = z2;
        return super.setVisible(z3, z4) || this.mDrawable.setVisible(z3, z4);
    }

    public void setWrappedDrawable(Drawable drawable) {
        Drawable drawable2 = drawable;
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
        }
        this.mDrawable = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable drawable2 = drawable;
        unscheduleSelf(runnable);
    }
}
