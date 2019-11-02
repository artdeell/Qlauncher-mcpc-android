package android.support.p000v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.graphics.drawable.DrawableCompatBase */
class DrawableCompatBase {
    DrawableCompatBase() {
    }

    public static void setTint(Drawable drawable, int i) {
        Drawable drawable2 = drawable;
        int i2 = i;
        if (drawable2 instanceof DrawableWrapper) {
            ((DrawableWrapper) drawable2).setTint(i2);
        }
    }

    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        Drawable drawable2 = drawable;
        ColorStateList colorStateList2 = colorStateList;
        if (drawable2 instanceof DrawableWrapper) {
            ((DrawableWrapper) drawable2).setTintList(colorStateList2);
        }
    }

    public static void setTintMode(Drawable drawable, Mode mode) {
        Drawable drawable2 = drawable;
        Mode mode2 = mode;
        if (drawable2 instanceof DrawableWrapper) {
            ((DrawableWrapper) drawable2).setTintMode(mode2);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r3v0, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Drawable wrapForTinting(android.graphics.drawable.Drawable r5) {
        /*
            r0 = r5
            r1 = r0
            boolean r1 = r1 instanceof android.support.p000v4.graphics.drawable.DrawableWrapperDonut
            if (r1 != 0) goto L_0x0010
            android.support.v4.graphics.drawable.DrawableWrapperDonut r1 = new android.support.v4.graphics.drawable.DrawableWrapperDonut
            r4 = r1
            r1 = r4
            r2 = r4
            r3 = r0
            r2.<init>(r3)
            r0 = r1
        L_0x0010:
            r1 = r0
            r0 = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.graphics.drawable.DrawableCompatBase.wrapForTinting(android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
