package android.support.p000v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.ViewParentCompatLollipop */
class ViewParentCompatLollipop {
    private static final String TAG = "ViewParentCompat";

    ViewParentCompatLollipop() {
    }

    public static boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean z) {
        StringBuilder sb;
        ViewParent viewParent2 = viewParent;
        try {
            return viewParent2.onNestedFling(view, f, f2, z);
        } catch (AbstractMethodError e) {
            AbstractMethodError abstractMethodError = e;
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int e2 = Log.e(str, sb2.append("ViewParent ").append(viewParent2).append(" does not implement interface ").append("method onNestedFling").toString(), abstractMethodError);
            return false;
        }
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2) {
        StringBuilder sb;
        ViewParent viewParent2 = viewParent;
        try {
            return viewParent2.onNestedPreFling(view, f, f2);
        } catch (AbstractMethodError e) {
            AbstractMethodError abstractMethodError = e;
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int e2 = Log.e(str, sb2.append("ViewParent ").append(viewParent2).append(" does not implement interface ").append("method onNestedPreFling").toString(), abstractMethodError);
            return false;
        }
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        StringBuilder sb;
        ViewParent viewParent2 = viewParent;
        try {
            viewParent2.onNestedPreScroll(view, i, i2, iArr);
        } catch (AbstractMethodError e) {
            AbstractMethodError abstractMethodError = e;
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int e2 = Log.e(str, sb2.append("ViewParent ").append(viewParent2).append(" does not implement interface ").append("method onNestedPreScroll").toString(), abstractMethodError);
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        StringBuilder sb;
        ViewParent viewParent2 = viewParent;
        try {
            viewParent2.onNestedScroll(view, i, i2, i3, i4);
        } catch (AbstractMethodError e) {
            AbstractMethodError abstractMethodError = e;
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int e2 = Log.e(str, sb2.append("ViewParent ").append(viewParent2).append(" does not implement interface ").append("method onNestedScroll").toString(), abstractMethodError);
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i) {
        StringBuilder sb;
        ViewParent viewParent2 = viewParent;
        try {
            viewParent2.onNestedScrollAccepted(view, view2, i);
        } catch (AbstractMethodError e) {
            AbstractMethodError abstractMethodError = e;
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int e2 = Log.e(str, sb2.append("ViewParent ").append(viewParent2).append(" does not implement interface ").append("method onNestedScrollAccepted").toString(), abstractMethodError);
        }
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i) {
        StringBuilder sb;
        ViewParent viewParent2 = viewParent;
        try {
            return viewParent2.onStartNestedScroll(view, view2, i);
        } catch (AbstractMethodError e) {
            AbstractMethodError abstractMethodError = e;
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int e2 = Log.e(str, sb2.append("ViewParent ").append(viewParent2).append(" does not implement interface ").append("method onStartNestedScroll").toString(), abstractMethodError);
            return false;
        }
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        StringBuilder sb;
        ViewParent viewParent2 = viewParent;
        try {
            viewParent2.onStopNestedScroll(view);
        } catch (AbstractMethodError e) {
            AbstractMethodError abstractMethodError = e;
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int e2 = Log.e(str, sb2.append("ViewParent ").append(viewParent2).append(" does not implement interface ").append("method onStopNestedScroll").toString(), abstractMethodError);
        }
    }
}
