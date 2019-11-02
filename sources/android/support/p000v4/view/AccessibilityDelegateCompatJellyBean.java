package android.support.p000v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* renamed from: android.support.v4.view.AccessibilityDelegateCompatJellyBean */
class AccessibilityDelegateCompatJellyBean {

    /* renamed from: android.support.v4.view.AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean */
    public interface AccessibilityDelegateBridgeJellyBean {
        boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        Object getAccessibilityNodeProvider(View view);

        void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(View view, Object obj);

        void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        boolean performAccessibilityAction(View view, int i, Bundle bundle);

        void sendAccessibilityEvent(View view, int i);

        void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent);
    }

    AccessibilityDelegateCompatJellyBean() {
    }

    public static Object getAccessibilityNodeProvider(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static Object newAccessibilityDelegateBridge(AccessibilityDelegateBridgeJellyBean accessibilityDelegateBridgeJellyBean) {
        C01031 r4;
        C01031 r1 = r4;
        final AccessibilityDelegateBridgeJellyBean accessibilityDelegateBridgeJellyBean2 = accessibilityDelegateBridgeJellyBean;
        C01031 r2 = new AccessibilityDelegate() {
            public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return accessibilityDelegateBridgeJellyBean2.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }

            public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                return (AccessibilityNodeProvider) accessibilityDelegateBridgeJellyBean2.getAccessibilityNodeProvider(view);
            }

            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                View view2 = view;
                AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
                accessibilityDelegateBridgeJellyBean2.onInitializeAccessibilityEvent(view2, accessibilityEvent2);
            }

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                View view2 = view;
                AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfo;
                accessibilityDelegateBridgeJellyBean2.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo2);
            }

            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                View view2 = view;
                AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
                accessibilityDelegateBridgeJellyBean2.onPopulateAccessibilityEvent(view2, accessibilityEvent2);
            }

            public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return accessibilityDelegateBridgeJellyBean2.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }

            public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                return accessibilityDelegateBridgeJellyBean2.performAccessibilityAction(view, i, bundle);
            }

            public void sendAccessibilityEvent(View view, int i) {
                View view2 = view;
                int i2 = i;
                accessibilityDelegateBridgeJellyBean2.sendAccessibilityEvent(view2, i2);
            }

            public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                View view2 = view;
                AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
                accessibilityDelegateBridgeJellyBean2.sendAccessibilityEventUnchecked(view2, accessibilityEvent2);
            }
        };
        return r1;
    }

    public static boolean performAccessibilityAction(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
