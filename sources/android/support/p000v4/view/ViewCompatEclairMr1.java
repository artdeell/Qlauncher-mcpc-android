package android.support.p000v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.view.ViewCompatEclairMr1 */
class ViewCompatEclairMr1 {
    public static final String TAG = "ViewCompat";
    private static Method sChildrenDrawingOrderMethod;

    ViewCompatEclairMr1() {
    }

    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        ViewGroup viewGroup2 = viewGroup;
        boolean z2 = z;
        if (sChildrenDrawingOrderMethod == null) {
            try {
                sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException e) {
                int e2 = Log.e(TAG, "Unable to find childrenDrawingOrderEnabled", e);
            }
            sChildrenDrawingOrderMethod.setAccessible(true);
        }
        try {
            Object invoke = sChildrenDrawingOrderMethod.invoke(viewGroup2, new Object[]{Boolean.valueOf(z2)});
        } catch (IllegalAccessException e3) {
            int e4 = Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e3);
        } catch (IllegalArgumentException e5) {
            int e6 = Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e5);
        } catch (InvocationTargetException e7) {
            int e8 = Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e7);
        }
    }
}
