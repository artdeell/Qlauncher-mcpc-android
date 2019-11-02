package android.support.p000v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.widget.PopupWindowCompatGingerbread */
class PopupWindowCompatGingerbread {
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    PopupWindowCompatGingerbread() {
    }

    static int getWindowLayoutType(PopupWindow popupWindow) {
        PopupWindow popupWindow2 = popupWindow;
        if (!sGetWindowLayoutTypeMethodAttempted) {
            try {
                sGetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
                sGetWindowLayoutTypeMethod.setAccessible(true);
            } catch (Exception e) {
                Exception exc = e;
            }
            sGetWindowLayoutTypeMethodAttempted = true;
        }
        if (sGetWindowLayoutTypeMethod != null) {
            try {
                return ((Integer) sGetWindowLayoutTypeMethod.invoke(popupWindow2, new Object[0])).intValue();
            } catch (Exception e2) {
                Exception exc2 = e2;
            }
        }
        return 0;
    }

    static void setWindowLayoutType(PopupWindow popupWindow, int i) {
        PopupWindow popupWindow2 = popupWindow;
        int i2 = i;
        if (!sSetWindowLayoutTypeMethodAttempted) {
            try {
                sSetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                sSetWindowLayoutTypeMethod.setAccessible(true);
            } catch (Exception e) {
                Exception exc = e;
            }
            sSetWindowLayoutTypeMethodAttempted = true;
        }
        if (sSetWindowLayoutTypeMethod != null) {
            try {
                Object invoke = sSetWindowLayoutTypeMethod.invoke(popupWindow2, new Object[]{Integer.valueOf(i2)});
            } catch (Exception e2) {
                Exception exc2 = e2;
            }
        }
    }
}
