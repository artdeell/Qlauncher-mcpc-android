package android.support.p000v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompat */
public class AccessibilityManagerCompat {
    /* access modifiers changed from: private */
    public static final AccessibilityManagerVersionImpl IMPL;

    /* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerIcsImpl */
    static class AccessibilityManagerIcsImpl extends AccessibilityManagerStubImpl {
        AccessibilityManagerIcsImpl() {
        }

        public boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat.mListener);
        }

        public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
            return AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(accessibilityManager, i);
        }

        public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
            return AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(accessibilityManager);
        }

        public boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
            return AccessibilityManagerCompatIcs.isTouchExplorationEnabled(accessibilityManager);
        }

        public Object newAccessiblityStateChangeListener(AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            C01181 r6;
            C01181 r2 = r6;
            final AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat2 = accessibilityStateChangeListenerCompat;
            C01181 r3 = new AccessibilityStateChangeListenerBridge(this) {
                final /* synthetic */ AccessibilityManagerIcsImpl this$0;

                {
                    AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat = r7;
                    this.this$0 = r6;
                }

                public void onAccessibilityStateChanged(boolean z) {
                    boolean z2 = z;
                    accessibilityStateChangeListenerCompat2.onAccessibilityStateChanged(z2);
                }
            };
            return AccessibilityManagerCompatIcs.newAccessibilityStateChangeListener(r2);
        }

        public boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            return AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat.mListener);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerStubImpl */
    static class AccessibilityManagerStubImpl implements AccessibilityManagerVersionImpl {
        AccessibilityManagerStubImpl() {
        }

        public boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            AccessibilityManager accessibilityManager2 = accessibilityManager;
            AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat2 = accessibilityStateChangeListenerCompat;
            return false;
        }

        public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
            AccessibilityManager accessibilityManager2 = accessibilityManager;
            int i2 = i;
            return Collections.emptyList();
        }

        public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
            AccessibilityManager accessibilityManager2 = accessibilityManager;
            return Collections.emptyList();
        }

        public boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
            AccessibilityManager accessibilityManager2 = accessibilityManager;
            return false;
        }

        public Object newAccessiblityStateChangeListener(AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat2 = accessibilityStateChangeListenerCompat;
            return null;
        }

        public boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
            AccessibilityManager accessibilityManager2 = accessibilityManager;
            AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat2 = accessibilityStateChangeListenerCompat;
            return false;
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerVersionImpl */
    interface AccessibilityManagerVersionImpl {
        boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat);

        List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i);

        List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager);

        boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager);

        Object newAccessiblityStateChangeListener(AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat);

        boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat */
    public static abstract class AccessibilityStateChangeListenerCompat {
        final Object mListener = AccessibilityManagerCompat.IMPL.newAccessiblityStateChangeListener(this);

        public AccessibilityStateChangeListenerCompat() {
        }

        public abstract void onAccessibilityStateChanged(boolean z);
    }

    static {
        AccessibilityManagerStubImpl accessibilityManagerStubImpl;
        AccessibilityManagerIcsImpl accessibilityManagerIcsImpl;
        if (VERSION.SDK_INT >= 14) {
            AccessibilityManagerIcsImpl accessibilityManagerIcsImpl2 = accessibilityManagerIcsImpl;
            AccessibilityManagerIcsImpl accessibilityManagerIcsImpl3 = new AccessibilityManagerIcsImpl();
            IMPL = accessibilityManagerIcsImpl2;
            return;
        }
        AccessibilityManagerStubImpl accessibilityManagerStubImpl2 = accessibilityManagerStubImpl;
        AccessibilityManagerStubImpl accessibilityManagerStubImpl3 = new AccessibilityManagerStubImpl();
        IMPL = accessibilityManagerStubImpl2;
    }

    public AccessibilityManagerCompat() {
    }

    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return IMPL.addAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat);
    }

    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
        return IMPL.getEnabledAccessibilityServiceList(accessibilityManager, i);
    }

    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
        return IMPL.getInstalledAccessibilityServiceList(accessibilityManager);
    }

    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
        return IMPL.isTouchExplorationEnabled(accessibilityManager);
    }

    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return IMPL.removeAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat);
    }
}
