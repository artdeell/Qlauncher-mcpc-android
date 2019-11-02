package android.support.p000v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.app.ActionBarDrawerToggleJellybeanMR2 */
class ActionBarDrawerToggleJellybeanMR2 {
    private static final String TAG = "ActionBarDrawerToggleImplJellybeanMR2";
    private static final int[] THEME_ATTRS;

    static {
        int[] iArr = new int[1];
        int[] iArr2 = iArr;
        iArr[0] = 16843531;
        THEME_ATTRS = iArr2;
    }

    ActionBarDrawerToggleJellybeanMR2() {
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r5v0, types: [android.app.Activity] */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r5v4, types: [android.content.Context] */
    /* JADX WARNING: type inference failed for: r5v11, types: [android.content.Context] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Drawable getThemeUpIndicator(android.app.Activity r10) {
        /*
            r0 = r10
            r5 = r0
            android.app.ActionBar r5 = r5.getActionBar()
            r1 = r5
            r5 = r1
            if (r5 == 0) goto L_0x002b
            r5 = r1
            android.content.Context r5 = r5.getThemedContext()
            r2 = r5
        L_0x0010:
            r5 = r2
            r6 = 0
            int[] r7 = THEME_ATTRS
            r8 = 16843470(0x10102ce, float:2.369557E-38)
            r9 = 0
            android.content.res.TypedArray r5 = r5.obtainStyledAttributes(r6, r7, r8, r9)
            r3 = r5
            r5 = r3
            r6 = 0
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)
            r4 = r5
            r5 = r3
            r5.recycle()
            r5 = r4
            r0 = r5
            return r0
        L_0x002b:
            r5 = r0
            r2 = r5
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.ActionBarDrawerToggleJellybeanMR2.getThemeUpIndicator(android.app.Activity):android.graphics.drawable.Drawable");
    }

    public static Object setActionBarDescription(Object obj, Activity activity, int i) {
        Object obj2 = obj;
        int i2 = i;
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i2);
        }
        return obj2;
    }

    public static Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i) {
        Object obj2 = obj;
        Drawable drawable2 = drawable;
        int i2 = i;
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable2);
            actionBar.setHomeActionContentDescription(i2);
        }
        return obj2;
    }
}
