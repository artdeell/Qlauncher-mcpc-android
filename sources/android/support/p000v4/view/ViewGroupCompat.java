package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.ViewGroupCompat */
public class ViewGroupCompat {
    static final ViewGroupCompatImpl IMPL;
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    /* renamed from: android.support.v4.view.ViewGroupCompat$ViewGroupCompatHCImpl */
    static class ViewGroupCompatHCImpl extends ViewGroupCompatStubImpl {
        ViewGroupCompatHCImpl() {
        }

        public void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z) {
            ViewGroupCompatHC.setMotionEventSplittingEnabled(viewGroup, z);
        }
    }

    /* renamed from: android.support.v4.view.ViewGroupCompat$ViewGroupCompatIcsImpl */
    static class ViewGroupCompatIcsImpl extends ViewGroupCompatHCImpl {
        ViewGroupCompatIcsImpl() {
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return ViewGroupCompatIcs.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
    }

    /* renamed from: android.support.v4.view.ViewGroupCompat$ViewGroupCompatImpl */
    interface ViewGroupCompatImpl {
        int getLayoutMode(ViewGroup viewGroup);

        int getNestedScrollAxes(ViewGroup viewGroup);

        boolean isTransitionGroup(ViewGroup viewGroup);

        boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void setLayoutMode(ViewGroup viewGroup, int i);

        void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z);

        void setTransitionGroup(ViewGroup viewGroup, boolean z);
    }

    /* renamed from: android.support.v4.view.ViewGroupCompat$ViewGroupCompatJellybeanMR2Impl */
    static class ViewGroupCompatJellybeanMR2Impl extends ViewGroupCompatIcsImpl {
        ViewGroupCompatJellybeanMR2Impl() {
        }

        public int getLayoutMode(ViewGroup viewGroup) {
            return ViewGroupCompatJellybeanMR2.getLayoutMode(viewGroup);
        }

        public void setLayoutMode(ViewGroup viewGroup, int i) {
            ViewGroupCompatJellybeanMR2.setLayoutMode(viewGroup, i);
        }
    }

    /* renamed from: android.support.v4.view.ViewGroupCompat$ViewGroupCompatLollipopImpl */
    static class ViewGroupCompatLollipopImpl extends ViewGroupCompatJellybeanMR2Impl {
        ViewGroupCompatLollipopImpl() {
        }

        public int getNestedScrollAxes(ViewGroup viewGroup) {
            return ViewGroupCompatLollipop.getNestedScrollAxes(viewGroup);
        }

        public boolean isTransitionGroup(ViewGroup viewGroup) {
            return ViewGroupCompatLollipop.isTransitionGroup(viewGroup);
        }

        public void setTransitionGroup(ViewGroup viewGroup, boolean z) {
            ViewGroupCompatLollipop.setTransitionGroup(viewGroup, z);
        }
    }

    /* renamed from: android.support.v4.view.ViewGroupCompat$ViewGroupCompatStubImpl */
    static class ViewGroupCompatStubImpl implements ViewGroupCompatImpl {
        ViewGroupCompatStubImpl() {
        }

        public int getLayoutMode(ViewGroup viewGroup) {
            ViewGroup viewGroup2 = viewGroup;
            return 0;
        }

        public int getNestedScrollAxes(ViewGroup viewGroup) {
            ViewGroup viewGroup2 = viewGroup;
            if (viewGroup2 instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewGroup2).getNestedScrollAxes();
            }
            return 0;
        }

        public boolean isTransitionGroup(ViewGroup viewGroup) {
            ViewGroup viewGroup2 = viewGroup;
            return false;
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            ViewGroup viewGroup2 = viewGroup;
            View view2 = view;
            AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
            return true;
        }

        public void setLayoutMode(ViewGroup viewGroup, int i) {
        }

        public void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z) {
        }

        public void setTransitionGroup(ViewGroup viewGroup, boolean z) {
        }
    }

    static {
        ViewGroupCompatStubImpl viewGroupCompatStubImpl;
        ViewGroupCompatHCImpl viewGroupCompatHCImpl;
        ViewGroupCompatIcsImpl viewGroupCompatIcsImpl;
        ViewGroupCompatJellybeanMR2Impl viewGroupCompatJellybeanMR2Impl;
        ViewGroupCompatLollipopImpl viewGroupCompatLollipopImpl;
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            ViewGroupCompatLollipopImpl viewGroupCompatLollipopImpl2 = viewGroupCompatLollipopImpl;
            ViewGroupCompatLollipopImpl viewGroupCompatLollipopImpl3 = new ViewGroupCompatLollipopImpl();
            IMPL = viewGroupCompatLollipopImpl2;
        } else if (i >= 18) {
            ViewGroupCompatJellybeanMR2Impl viewGroupCompatJellybeanMR2Impl2 = viewGroupCompatJellybeanMR2Impl;
            ViewGroupCompatJellybeanMR2Impl viewGroupCompatJellybeanMR2Impl3 = new ViewGroupCompatJellybeanMR2Impl();
            IMPL = viewGroupCompatJellybeanMR2Impl2;
        } else if (i >= 14) {
            ViewGroupCompatIcsImpl viewGroupCompatIcsImpl2 = viewGroupCompatIcsImpl;
            ViewGroupCompatIcsImpl viewGroupCompatIcsImpl3 = new ViewGroupCompatIcsImpl();
            IMPL = viewGroupCompatIcsImpl2;
        } else if (i >= 11) {
            ViewGroupCompatHCImpl viewGroupCompatHCImpl2 = viewGroupCompatHCImpl;
            ViewGroupCompatHCImpl viewGroupCompatHCImpl3 = new ViewGroupCompatHCImpl();
            IMPL = viewGroupCompatHCImpl2;
        } else {
            ViewGroupCompatStubImpl viewGroupCompatStubImpl2 = viewGroupCompatStubImpl;
            ViewGroupCompatStubImpl viewGroupCompatStubImpl3 = new ViewGroupCompatStubImpl();
            IMPL = viewGroupCompatStubImpl2;
        }
    }

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(ViewGroup viewGroup) {
        return IMPL.getLayoutMode(viewGroup);
    }

    public static int getNestedScrollAxes(ViewGroup viewGroup) {
        return IMPL.getNestedScrollAxes(viewGroup);
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        return IMPL.isTransitionGroup(viewGroup);
    }

    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return IMPL.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public static void setLayoutMode(ViewGroup viewGroup, int i) {
        IMPL.setLayoutMode(viewGroup, i);
    }

    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z) {
        IMPL.setMotionEventSplittingEnabled(viewGroup, z);
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean z) {
        IMPL.setTransitionGroup(viewGroup, z);
    }
}
