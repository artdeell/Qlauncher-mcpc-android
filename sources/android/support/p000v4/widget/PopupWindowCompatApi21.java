package android.support.p000v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.PopupWindowCompatApi21 */
class PopupWindowCompatApi21 {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Field sOverlapAnchorField;

    static {
        try {
            sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            sOverlapAnchorField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            int i = Log.i(TAG, "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    PopupWindowCompatApi21() {
    }

    static boolean getOverlapAnchor(PopupWindow popupWindow) {
        PopupWindow popupWindow2 = popupWindow;
        if (sOverlapAnchorField != null) {
            try {
                return ((Boolean) sOverlapAnchorField.get(popupWindow2)).booleanValue();
            } catch (IllegalAccessException e) {
                int i = Log.i(TAG, "Could not get overlap anchor field in PopupWindow", e);
            }
        }
        return false;
    }

    static void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        PopupWindow popupWindow2 = popupWindow;
        boolean z2 = z;
        if (sOverlapAnchorField != null) {
            try {
                sOverlapAnchorField.set(popupWindow2, Boolean.valueOf(z2));
            } catch (IllegalAccessException e) {
                int i = Log.i(TAG, "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }
}
