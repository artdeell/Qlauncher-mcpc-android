package android.support.p000v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.CompoundButtonCompatDonut */
class CompoundButtonCompatDonut {
    private static final String TAG = "CompoundButtonCompatDonut";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    CompoundButtonCompatDonut() {
    }

    static Drawable getButtonDrawable(CompoundButton compoundButton) {
        CompoundButton compoundButton2 = compoundButton;
        if (!sButtonDrawableFieldFetched) {
            try {
                sButtonDrawableField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                sButtonDrawableField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                int i = Log.i(TAG, "Failed to retrieve mButtonDrawable field", e);
            }
            sButtonDrawableFieldFetched = true;
        }
        if (sButtonDrawableField != null) {
            try {
                return (Drawable) sButtonDrawableField.get(compoundButton2);
            } catch (IllegalAccessException e2) {
                int i2 = Log.i(TAG, "Failed to get button drawable via reflection", e2);
                sButtonDrawableField = null;
            }
        }
        return null;
    }

    static ColorStateList getButtonTintList(CompoundButton compoundButton) {
        CompoundButton compoundButton2 = compoundButton;
        if (compoundButton2 instanceof TintableCompoundButton) {
            return ((TintableCompoundButton) compoundButton2).getSupportButtonTintList();
        }
        return null;
    }

    static Mode getButtonTintMode(CompoundButton compoundButton) {
        CompoundButton compoundButton2 = compoundButton;
        if (compoundButton2 instanceof TintableCompoundButton) {
            return ((TintableCompoundButton) compoundButton2).getSupportButtonTintMode();
        }
        return null;
    }

    static void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
        CompoundButton compoundButton2 = compoundButton;
        ColorStateList colorStateList2 = colorStateList;
        if (compoundButton2 instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton2).setSupportButtonTintList(colorStateList2);
        }
    }

    static void setButtonTintMode(CompoundButton compoundButton, Mode mode) {
        CompoundButton compoundButton2 = compoundButton;
        Mode mode2 = mode;
        if (compoundButton2 instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton2).setSupportButtonTintMode(mode2);
        }
    }
}
