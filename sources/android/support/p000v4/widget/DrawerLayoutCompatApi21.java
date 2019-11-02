package android.support.p000v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import org.lwjgl.opengl.GL11;

/* renamed from: android.support.v4.widget.DrawerLayoutCompatApi21 */
class DrawerLayoutCompatApi21 {
    private static final int[] THEME_ATTRS;

    /* renamed from: android.support.v4.widget.DrawerLayoutCompatApi21$InsetsListener */
    static class InsetsListener implements OnApplyWindowInsetsListener {
        InsetsListener() {
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            WindowInsets windowInsets2 = windowInsets;
            ((DrawerLayoutImpl) view).setChildInsets(windowInsets2, windowInsets2.getSystemWindowInsetTop() > 0);
            return windowInsets2.consumeSystemWindowInsets();
        }
    }

    static {
        int[] iArr = new int[1];
        int[] iArr2 = iArr;
        iArr[0] = 16843828;
        THEME_ATTRS = iArr2;
    }

    DrawerLayoutCompatApi21() {
    }

    public static void applyMarginInsets(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
        int i2 = i;
        WindowInsets windowInsets = (WindowInsets) obj;
        if (i2 == 3) {
            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
        } else if (i2 == 5) {
            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        marginLayoutParams2.leftMargin = windowInsets.getSystemWindowInsetLeft();
        marginLayoutParams2.topMargin = windowInsets.getSystemWindowInsetTop();
        marginLayoutParams2.rightMargin = windowInsets.getSystemWindowInsetRight();
        marginLayoutParams2.bottomMargin = windowInsets.getSystemWindowInsetBottom();
    }

    public static void configureApplyInsets(View view) {
        InsetsListener insetsListener;
        View view2 = view;
        if (view2 instanceof DrawerLayoutImpl) {
            View view3 = view2;
            InsetsListener insetsListener2 = insetsListener;
            InsetsListener insetsListener3 = new InsetsListener();
            view3.setOnApplyWindowInsetsListener(insetsListener2);
            view2.setSystemUiVisibility(GL11.GL_INVALID_ENUM);
        }
    }

    public static void dispatchChildInsets(View view, Object obj, int i) {
        View view2 = view;
        int i2 = i;
        WindowInsets windowInsets = (WindowInsets) obj;
        if (i2 == 3) {
            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
        } else if (i2 == 5) {
            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        WindowInsets dispatchApplyWindowInsets = view2.dispatchApplyWindowInsets(windowInsets);
    }

    /* JADX INFO: finally extract failed */
    public static Drawable getDefaultStatusBarBackground(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(THEME_ATTRS);
        try {
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        } catch (Throwable th) {
            Throwable th2 = th;
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public static int getTopInset(Object obj) {
        Object obj2 = obj;
        if (obj2 != null) {
            return ((WindowInsets) obj2).getSystemWindowInsetTop();
        }
        return 0;
    }
}
