package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

/* renamed from: android.support.v4.view.ViewParentCompat */
public class ViewParentCompat {
    static final ViewParentCompatImpl IMPL;

    /* renamed from: android.support.v4.view.ViewParentCompat$ViewParentCompatICSImpl */
    static class ViewParentCompatICSImpl extends ViewParentCompatStubImpl {
        ViewParentCompatICSImpl() {
        }

        public boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
            return ViewParentCompatICS.requestSendAccessibilityEvent(viewParent, view, accessibilityEvent);
        }
    }

    /* renamed from: android.support.v4.view.ViewParentCompat$ViewParentCompatImpl */
    interface ViewParentCompatImpl {
        void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i);

        boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2);

        void onNestedPreScroll(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        void onNestedScroll(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i);

        boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i);

        void onStopNestedScroll(ViewParent viewParent, View view);

        boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: android.support.v4.view.ViewParentCompat$ViewParentCompatKitKatImpl */
    static class ViewParentCompatKitKatImpl extends ViewParentCompatICSImpl {
        ViewParentCompatKitKatImpl() {
        }

        public void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i) {
            ViewParentCompatKitKat.notifySubtreeAccessibilityStateChanged(viewParent, view, view2, i);
        }
    }

    /* renamed from: android.support.v4.view.ViewParentCompat$ViewParentCompatLollipopImpl */
    static class ViewParentCompatLollipopImpl extends ViewParentCompatKitKatImpl {
        ViewParentCompatLollipopImpl() {
        }

        public boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return ViewParentCompatLollipop.onNestedFling(viewParent, view, f, f2, z);
        }

        public boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2) {
            return ViewParentCompatLollipop.onNestedPreFling(viewParent, view, f, f2);
        }

        public void onNestedPreScroll(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            ViewParentCompatLollipop.onNestedPreScroll(viewParent, view, i, i2, iArr);
        }

        public void onNestedScroll(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            ViewParentCompatLollipop.onNestedScroll(viewParent, view, i, i2, i3, i4);
        }

        public void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i) {
            ViewParentCompatLollipop.onNestedScrollAccepted(viewParent, view, view2, i);
        }

        public boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i) {
            return ViewParentCompatLollipop.onStartNestedScroll(viewParent, view, view2, i);
        }

        public void onStopNestedScroll(ViewParent viewParent, View view) {
            ViewParentCompatLollipop.onStopNestedScroll(viewParent, view);
        }
    }

    /* renamed from: android.support.v4.view.ViewParentCompat$ViewParentCompatStubImpl */
    static class ViewParentCompatStubImpl implements ViewParentCompatImpl {
        ViewParentCompatStubImpl() {
        }

        public void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i) {
        }

        public boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean z) {
            ViewParent viewParent2 = viewParent;
            View view2 = view;
            float f3 = f;
            float f4 = f2;
            boolean z2 = z;
            if (viewParent2 instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent2).onNestedFling(view2, f3, f4, z2);
            }
            return false;
        }

        public boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2) {
            ViewParent viewParent2 = viewParent;
            View view2 = view;
            float f3 = f;
            float f4 = f2;
            if (viewParent2 instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent2).onNestedPreFling(view2, f3, f4);
            }
            return false;
        }

        public void onNestedPreScroll(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            ViewParent viewParent2 = viewParent;
            View view2 = view;
            int i3 = i;
            int i4 = i2;
            int[] iArr2 = iArr;
            if (viewParent2 instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent2).onNestedPreScroll(view2, i3, i4, iArr2);
            }
        }

        public void onNestedScroll(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            ViewParent viewParent2 = viewParent;
            View view2 = view;
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            int i8 = i4;
            if (viewParent2 instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent2).onNestedScroll(view2, i5, i6, i7, i8);
            }
        }

        public void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i) {
            ViewParent viewParent2 = viewParent;
            View view3 = view;
            View view4 = view2;
            int i2 = i;
            if (viewParent2 instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent2).onNestedScrollAccepted(view3, view4, i2);
            }
        }

        public boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i) {
            ViewParent viewParent2 = viewParent;
            View view3 = view;
            View view4 = view2;
            int i2 = i;
            if (viewParent2 instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent2).onStartNestedScroll(view3, view4, i2);
            }
            return false;
        }

        public void onStopNestedScroll(ViewParent viewParent, View view) {
            ViewParent viewParent2 = viewParent;
            View view2 = view;
            if (viewParent2 instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent2).onStopNestedScroll(view2);
            }
        }

        public boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
            ViewParent viewParent2 = viewParent;
            View view2 = view;
            AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
            if (view2 == null) {
                return false;
            }
            ((AccessibilityManager) view2.getContext().getSystemService("accessibility")).sendAccessibilityEvent(accessibilityEvent2);
            return true;
        }
    }

    static {
        ViewParentCompatStubImpl viewParentCompatStubImpl;
        ViewParentCompatICSImpl viewParentCompatICSImpl;
        ViewParentCompatKitKatImpl viewParentCompatKitKatImpl;
        ViewParentCompatLollipopImpl viewParentCompatLollipopImpl;
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            ViewParentCompatLollipopImpl viewParentCompatLollipopImpl2 = viewParentCompatLollipopImpl;
            ViewParentCompatLollipopImpl viewParentCompatLollipopImpl3 = new ViewParentCompatLollipopImpl();
            IMPL = viewParentCompatLollipopImpl2;
        } else if (i >= 19) {
            ViewParentCompatKitKatImpl viewParentCompatKitKatImpl2 = viewParentCompatKitKatImpl;
            ViewParentCompatKitKatImpl viewParentCompatKitKatImpl3 = new ViewParentCompatKitKatImpl();
            IMPL = viewParentCompatKitKatImpl2;
        } else if (i >= 14) {
            ViewParentCompatICSImpl viewParentCompatICSImpl2 = viewParentCompatICSImpl;
            ViewParentCompatICSImpl viewParentCompatICSImpl3 = new ViewParentCompatICSImpl();
            IMPL = viewParentCompatICSImpl2;
        } else {
            ViewParentCompatStubImpl viewParentCompatStubImpl2 = viewParentCompatStubImpl;
            ViewParentCompatStubImpl viewParentCompatStubImpl3 = new ViewParentCompatStubImpl();
            IMPL = viewParentCompatStubImpl2;
        }
    }

    private ViewParentCompat() {
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i) {
        IMPL.notifySubtreeAccessibilityStateChanged(viewParent, view, view2, i);
    }

    public static boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return IMPL.onNestedFling(viewParent, view, f, f2, z);
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2) {
        return IMPL.onNestedPreFling(viewParent, view, f, f2);
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        IMPL.onNestedPreScroll(viewParent, view, i, i2, iArr);
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        IMPL.onNestedScroll(viewParent, view, i, i2, i3, i4);
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i) {
        IMPL.onNestedScrollAccepted(viewParent, view, view2, i);
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i) {
        return IMPL.onStartNestedScroll(viewParent, view, view2, i);
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        IMPL.onStopNestedScroll(viewParent, view);
    }

    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return IMPL.requestSendAccessibilityEvent(viewParent, view, accessibilityEvent);
    }
}
