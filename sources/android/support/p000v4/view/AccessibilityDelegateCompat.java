package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge;
import android.support.p000v4.view.AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.AccessibilityDelegateCompat */
public class AccessibilityDelegateCompat {
    private static final Object DEFAULT_DELEGATE = IMPL.newAccessiblityDelegateDefaultImpl();
    private static final AccessibilityDelegateImpl IMPL;
    final Object mBridge = IMPL.newAccessiblityDelegateBridge(this);

    /* renamed from: android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl */
    static class AccessibilityDelegateIcsImpl extends AccessibilityDelegateStubImpl {
        AccessibilityDelegateIcsImpl() {
        }

        public boolean dispatchPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(obj, view, accessibilityEvent);
        }

        public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            C01001 r6;
            C01001 r2 = r6;
            final AccessibilityDelegateCompat accessibilityDelegateCompat2 = accessibilityDelegateCompat;
            C01001 r3 = new AccessibilityDelegateBridge(this) {
                final /* synthetic */ AccessibilityDelegateIcsImpl this$0;

                {
                    AccessibilityDelegateCompat accessibilityDelegateCompat = r7;
                    this.this$0 = r6;
                }

                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat2.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    View view2 = view;
                    AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
                    accessibilityDelegateCompat2.onInitializeAccessibilityEvent(view2, accessibilityEvent2);
                }

                public void onInitializeAccessibilityNodeInfo(View view, Object obj) {
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
                    View view2 = view;
                    Object obj2 = obj;
                    AccessibilityDelegateCompat accessibilityDelegateCompat = accessibilityDelegateCompat2;
                    View view3 = view2;
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = new AccessibilityNodeInfoCompat(obj2);
                    accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(view3, accessibilityNodeInfoCompat2);
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    View view2 = view;
                    AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
                    accessibilityDelegateCompat2.onPopulateAccessibilityEvent(view2, accessibilityEvent2);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat2.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    View view2 = view;
                    int i2 = i;
                    accessibilityDelegateCompat2.sendAccessibilityEvent(view2, i2);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    View view2 = view;
                    AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
                    accessibilityDelegateCompat2.sendAccessibilityEventUnchecked(view2, accessibilityEvent2);
                }
            };
            return AccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(r2);
        }

        public Object newAccessiblityDelegateDefaultImpl() {
            return AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
        }

        public void onInitializeAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(obj, view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(Object obj, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(obj, view, accessibilityNodeInfoCompat.getInfo());
        }

        public void onPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(obj, view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(obj, viewGroup, view, accessibilityEvent);
        }

        public void sendAccessibilityEvent(Object obj, View view, int i) {
            AccessibilityDelegateCompatIcs.sendAccessibilityEvent(obj, view, i);
        }

        public void sendAccessibilityEventUnchecked(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(obj, view, accessibilityEvent);
        }
    }

    /* renamed from: android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateImpl */
    interface AccessibilityDelegateImpl {
        boolean dispatchPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent);

        AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object obj, View view);

        Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat accessibilityDelegateCompat);

        Object newAccessiblityDelegateDefaultImpl();

        void onInitializeAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(Object obj, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

        void onPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean onRequestSendAccessibilityEvent(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        boolean performAccessibilityAction(Object obj, View view, int i, Bundle bundle);

        void sendAccessibilityEvent(Object obj, View view, int i);

        void sendAccessibilityEventUnchecked(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl */
    static class AccessibilityDelegateJellyBeanImpl extends AccessibilityDelegateIcsImpl {
        AccessibilityDelegateJellyBeanImpl() {
        }

        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object obj, View view) {
            AccessibilityNodeProviderCompat accessibilityNodeProviderCompat;
            Object accessibilityNodeProvider = AccessibilityDelegateCompatJellyBean.getAccessibilityNodeProvider(obj, view);
            if (accessibilityNodeProvider == null) {
                return null;
            }
            AccessibilityNodeProviderCompat accessibilityNodeProviderCompat2 = accessibilityNodeProviderCompat;
            AccessibilityNodeProviderCompat accessibilityNodeProviderCompat3 = new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
            return accessibilityNodeProviderCompat2;
        }

        public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            C01011 r6;
            C01011 r2 = r6;
            final AccessibilityDelegateCompat accessibilityDelegateCompat2 = accessibilityDelegateCompat;
            C01011 r3 = new AccessibilityDelegateBridgeJellyBean(this) {
                final /* synthetic */ AccessibilityDelegateJellyBeanImpl this$0;

                {
                    AccessibilityDelegateCompat accessibilityDelegateCompat = r7;
                    this.this$0 = r6;
                }

                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat2.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                public Object getAccessibilityNodeProvider(View view) {
                    View view2 = view;
                    AccessibilityNodeProviderCompat accessibilityNodeProvider = accessibilityDelegateCompat2.getAccessibilityNodeProvider(view2);
                    if (accessibilityNodeProvider != null) {
                        return accessibilityNodeProvider.getProvider();
                    }
                    return null;
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    View view2 = view;
                    AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
                    accessibilityDelegateCompat2.onInitializeAccessibilityEvent(view2, accessibilityEvent2);
                }

                public void onInitializeAccessibilityNodeInfo(View view, Object obj) {
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
                    View view2 = view;
                    Object obj2 = obj;
                    AccessibilityDelegateCompat accessibilityDelegateCompat = accessibilityDelegateCompat2;
                    View view3 = view2;
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = new AccessibilityNodeInfoCompat(obj2);
                    accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(view3, accessibilityNodeInfoCompat2);
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    View view2 = view;
                    AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
                    accessibilityDelegateCompat2.onPopulateAccessibilityEvent(view2, accessibilityEvent2);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat2.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return accessibilityDelegateCompat2.performAccessibilityAction(view, i, bundle);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    View view2 = view;
                    int i2 = i;
                    accessibilityDelegateCompat2.sendAccessibilityEvent(view2, i2);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    View view2 = view;
                    AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
                    accessibilityDelegateCompat2.sendAccessibilityEventUnchecked(view2, accessibilityEvent2);
                }
            };
            return AccessibilityDelegateCompatJellyBean.newAccessibilityDelegateBridge(r2);
        }

        public boolean performAccessibilityAction(Object obj, View view, int i, Bundle bundle) {
            return AccessibilityDelegateCompatJellyBean.performAccessibilityAction(obj, view, i, bundle);
        }
    }

    /* renamed from: android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateStubImpl */
    static class AccessibilityDelegateStubImpl implements AccessibilityDelegateImpl {
        AccessibilityDelegateStubImpl() {
        }

        public boolean dispatchPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            Object obj2 = obj;
            View view2 = view;
            AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
            return false;
        }

        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object obj, View view) {
            Object obj2 = obj;
            View view2 = view;
            return null;
        }

        public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            AccessibilityDelegateCompat accessibilityDelegateCompat2 = accessibilityDelegateCompat;
            return null;
        }

        public Object newAccessiblityDelegateDefaultImpl() {
            return null;
        }

        public void onInitializeAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void onInitializeAccessibilityNodeInfo(Object obj, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public void onPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public boolean onRequestSendAccessibilityEvent(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            Object obj2 = obj;
            ViewGroup viewGroup2 = viewGroup;
            View view2 = view;
            AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
            return true;
        }

        public boolean performAccessibilityAction(Object obj, View view, int i, Bundle bundle) {
            Object obj2 = obj;
            View view2 = view;
            int i2 = i;
            Bundle bundle2 = bundle;
            return false;
        }

        public void sendAccessibilityEvent(Object obj, View view, int i) {
        }

        public void sendAccessibilityEventUnchecked(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }
    }

    static {
        AccessibilityDelegateStubImpl accessibilityDelegateStubImpl;
        AccessibilityDelegateIcsImpl accessibilityDelegateIcsImpl;
        AccessibilityDelegateJellyBeanImpl accessibilityDelegateJellyBeanImpl;
        if (VERSION.SDK_INT >= 16) {
            AccessibilityDelegateJellyBeanImpl accessibilityDelegateJellyBeanImpl2 = accessibilityDelegateJellyBeanImpl;
            AccessibilityDelegateJellyBeanImpl accessibilityDelegateJellyBeanImpl3 = new AccessibilityDelegateJellyBeanImpl();
            IMPL = accessibilityDelegateJellyBeanImpl2;
        } else if (VERSION.SDK_INT >= 14) {
            AccessibilityDelegateIcsImpl accessibilityDelegateIcsImpl2 = accessibilityDelegateIcsImpl;
            AccessibilityDelegateIcsImpl accessibilityDelegateIcsImpl3 = new AccessibilityDelegateIcsImpl();
            IMPL = accessibilityDelegateIcsImpl2;
        } else {
            AccessibilityDelegateStubImpl accessibilityDelegateStubImpl2 = accessibilityDelegateStubImpl;
            AccessibilityDelegateStubImpl accessibilityDelegateStubImpl3 = new AccessibilityDelegateStubImpl();
            IMPL = accessibilityDelegateStubImpl2;
        }
    }

    public AccessibilityDelegateCompat() {
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return IMPL.dispatchPopulateAccessibilityEvent(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        return IMPL.getAccessibilityNodeProvider(DEFAULT_DELEGATE, view);
    }

    /* access modifiers changed from: 0000 */
    public Object getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.onInitializeAccessibilityEvent(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        IMPL.onInitializeAccessibilityNodeInfo(DEFAULT_DELEGATE, view, accessibilityNodeInfoCompat);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.onPopulateAccessibilityEvent(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return IMPL.onRequestSendAccessibilityEvent(DEFAULT_DELEGATE, viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return IMPL.performAccessibilityAction(DEFAULT_DELEGATE, view, i, bundle);
    }

    public void sendAccessibilityEvent(View view, int i) {
        IMPL.sendAccessibilityEvent(DEFAULT_DELEGATE, view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.sendAccessibilityEventUnchecked(DEFAULT_DELEGATE, view, accessibilityEvent);
    }
}
