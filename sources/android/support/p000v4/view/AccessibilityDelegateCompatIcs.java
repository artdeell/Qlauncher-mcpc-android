package android.support.p000v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v4.view.AccessibilityDelegateCompatIcs */
class AccessibilityDelegateCompatIcs {

    /* renamed from: android.support.v4.view.AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge */
    public interface AccessibilityDelegateBridge {
        boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(View view, Object obj);

        void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void sendAccessibilityEvent(View view, int i);

        void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent);
    }

    AccessibilityDelegateCompatIcs() {
    }

    public static boolean dispatchPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        return ((AccessibilityDelegate) obj).dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static Object newAccessibilityDelegateBridge(AccessibilityDelegateBridge accessibilityDelegateBridge) {
        C01021 r4;
        C01021 r1 = r4;
        final AccessibilityDelegateBridge accessibilityDelegateBridge2 = accessibilityDelegateBridge;
        C01021 r2 = new AccessibilityDelegate() {
            public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return accessibilityDelegateBridge2.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }

            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                View view2 = view;
                AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
                accessibilityDelegateBridge2.onInitializeAccessibilityEvent(view2, accessibilityEvent2);
            }

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                View view2 = view;
                AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo;
                accessibilityDelegateBridge2.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo2);
            }

            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                View view2 = view;
                AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
                accessibilityDelegateBridge2.onPopulateAccessibilityEvent(view2, accessibilityEvent2);
            }

            public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return accessibilityDelegateBridge2.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }

            public void sendAccessibilityEvent(View view, int i) {
                View view2 = view;
                int i2 = i;
                accessibilityDelegateBridge2.sendAccessibilityEvent(view2, i2);
            }

            public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                View view2 = view;
                AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
                accessibilityDelegateBridge2.sendAccessibilityEventUnchecked(view2, accessibilityEvent2);
            }
        };
        return r1;
    }

    public static Object newAccessibilityDelegateDefaultImpl() {
        AccessibilityDelegate accessibilityDelegate;
        AccessibilityDelegate accessibilityDelegate2 = accessibilityDelegate;
        AccessibilityDelegate accessibilityDelegate3 = new AccessibilityDelegate();
        return accessibilityDelegate2;
    }

    public static void onInitializeAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(Object obj, View view, Object obj2) {
        ((AccessibilityDelegate) obj).onInitializeAccessibilityNodeInfo(view, (AccessibilityNodeInfo) obj2);
    }

    public static void onPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean onRequestSendAccessibilityEvent(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return ((AccessibilityDelegate) obj).onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public static void sendAccessibilityEvent(Object obj, View view, int i) {
        ((AccessibilityDelegate) obj).sendAccessibilityEvent(view, i);
    }

    public static void sendAccessibilityEventUnchecked(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
