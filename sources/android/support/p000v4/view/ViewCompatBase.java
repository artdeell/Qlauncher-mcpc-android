package android.support.p000v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.view.ViewCompatBase */
class ViewCompatBase {
    private static final String TAG = "ViewCompatBase";
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;

    ViewCompatBase() {
    }

    static ColorStateList getBackgroundTintList(View view) {
        View view2 = view;
        if (view2 instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view2).getSupportBackgroundTintList();
        }
        return null;
    }

    static Mode getBackgroundTintMode(View view) {
        View view2 = view;
        if (view2 instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view2).getSupportBackgroundTintMode();
        }
        return null;
    }

    static int getMinimumHeight(View view) {
        View view2 = view;
        if (!sMinHeightFieldFetched) {
            try {
                sMinHeightField = View.class.getDeclaredField("mMinHeight");
                sMinHeightField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                NoSuchFieldException noSuchFieldException = e;
            }
            sMinHeightFieldFetched = true;
        }
        if (sMinHeightField != null) {
            try {
                return ((Integer) sMinHeightField.get(view2)).intValue();
            } catch (Exception e2) {
                Exception exc = e2;
            }
        }
        return 0;
    }

    static int getMinimumWidth(View view) {
        View view2 = view;
        if (!sMinWidthFieldFetched) {
            try {
                sMinWidthField = View.class.getDeclaredField("mMinWidth");
                sMinWidthField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                NoSuchFieldException noSuchFieldException = e;
            }
            sMinWidthFieldFetched = true;
        }
        if (sMinWidthField != null) {
            try {
                return ((Integer) sMinWidthField.get(view2)).intValue();
            } catch (Exception e2) {
                Exception exc = e2;
            }
        }
        return 0;
    }

    static boolean isAttachedToWindow(View view) {
        return view.getWindowToken() != null;
    }

    static boolean isLaidOut(View view) {
        View view2 = view;
        return view2.getWidth() > 0 && view2.getHeight() > 0;
    }

    static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        View view2 = view;
        ColorStateList colorStateList2 = colorStateList;
        if (view2 instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view2).setSupportBackgroundTintList(colorStateList2);
        }
    }

    static void setBackgroundTintMode(View view, Mode mode) {
        View view2 = view;
        Mode mode2 = mode;
        if (view2 instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view2).setSupportBackgroundTintMode(mode2);
        }
    }
}
