package android.support.p000v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat */
public class AccessibilityNodeProviderCompat {
    private static final AccessibilityNodeProviderImpl IMPL;
    private final Object mProvider;

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderImpl */
    interface AccessibilityNodeProviderImpl {
        Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderJellyBeanImpl */
    static class AccessibilityNodeProviderJellyBeanImpl extends AccessibilityNodeProviderStubImpl {
        AccessibilityNodeProviderJellyBeanImpl() {
        }

        public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            C01211 r6;
            C01211 r2 = r6;
            final AccessibilityNodeProviderCompat accessibilityNodeProviderCompat2 = accessibilityNodeProviderCompat;
            C01211 r3 = new AccessibilityNodeInfoBridge(this) {
                final /* synthetic */ AccessibilityNodeProviderJellyBeanImpl this$0;

                {
                    AccessibilityNodeProviderCompat accessibilityNodeProviderCompat = r7;
                    this.this$0 = r6;
                }

                public Object createAccessibilityNodeInfo(int i) {
                    int i2 = i;
                    AccessibilityNodeInfoCompat createAccessibilityNodeInfo = accessibilityNodeProviderCompat2.createAccessibilityNodeInfo(i2);
                    if (createAccessibilityNodeInfo == null) {
                        return null;
                    }
                    return createAccessibilityNodeInfo.getInfo();
                }

                public List<Object> findAccessibilityNodeInfosByText(String str, int i) {
                    ArrayList arrayList;
                    String str2 = str;
                    int i2 = i;
                    List findAccessibilityNodeInfosByText = accessibilityNodeProviderCompat2.findAccessibilityNodeInfosByText(str2, i2);
                    ArrayList arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = arrayList2;
                    int size = findAccessibilityNodeInfosByText.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        boolean add = arrayList4.add(((AccessibilityNodeInfoCompat) findAccessibilityNodeInfosByText.get(i3)).getInfo());
                    }
                    return arrayList4;
                }

                public boolean performAction(int i, int i2, Bundle bundle) {
                    return accessibilityNodeProviderCompat2.performAction(i, i2, bundle);
                }
            };
            return AccessibilityNodeProviderCompatJellyBean.newAccessibilityNodeProviderBridge(r2);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl */
    static class AccessibilityNodeProviderKitKatImpl extends AccessibilityNodeProviderStubImpl {
        AccessibilityNodeProviderKitKatImpl() {
        }

        public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            C01221 r6;
            C01221 r2 = r6;
            final AccessibilityNodeProviderCompat accessibilityNodeProviderCompat2 = accessibilityNodeProviderCompat;
            C01221 r3 = new AccessibilityNodeInfoBridge(this) {
                final /* synthetic */ AccessibilityNodeProviderKitKatImpl this$0;

                {
                    AccessibilityNodeProviderCompat accessibilityNodeProviderCompat = r7;
                    this.this$0 = r6;
                }

                public Object createAccessibilityNodeInfo(int i) {
                    int i2 = i;
                    AccessibilityNodeInfoCompat createAccessibilityNodeInfo = accessibilityNodeProviderCompat2.createAccessibilityNodeInfo(i2);
                    if (createAccessibilityNodeInfo == null) {
                        return null;
                    }
                    return createAccessibilityNodeInfo.getInfo();
                }

                public List<Object> findAccessibilityNodeInfosByText(String str, int i) {
                    ArrayList arrayList;
                    String str2 = str;
                    int i2 = i;
                    List findAccessibilityNodeInfosByText = accessibilityNodeProviderCompat2.findAccessibilityNodeInfosByText(str2, i2);
                    ArrayList arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = arrayList2;
                    int size = findAccessibilityNodeInfosByText.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        boolean add = arrayList4.add(((AccessibilityNodeInfoCompat) findAccessibilityNodeInfosByText.get(i3)).getInfo());
                    }
                    return arrayList4;
                }

                public Object findFocus(int i) {
                    int i2 = i;
                    AccessibilityNodeInfoCompat findFocus = accessibilityNodeProviderCompat2.findFocus(i2);
                    if (findFocus == null) {
                        return null;
                    }
                    return findFocus.getInfo();
                }

                public boolean performAction(int i, int i2, Bundle bundle) {
                    return accessibilityNodeProviderCompat2.performAction(i, i2, bundle);
                }
            };
            return AccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge(r2);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderStubImpl */
    static class AccessibilityNodeProviderStubImpl implements AccessibilityNodeProviderImpl {
        AccessibilityNodeProviderStubImpl() {
        }

        public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            AccessibilityNodeProviderCompat accessibilityNodeProviderCompat2 = accessibilityNodeProviderCompat;
            return null;
        }
    }

    static {
        AccessibilityNodeProviderStubImpl accessibilityNodeProviderStubImpl;
        AccessibilityNodeProviderJellyBeanImpl accessibilityNodeProviderJellyBeanImpl;
        AccessibilityNodeProviderKitKatImpl accessibilityNodeProviderKitKatImpl;
        if (VERSION.SDK_INT >= 19) {
            AccessibilityNodeProviderKitKatImpl accessibilityNodeProviderKitKatImpl2 = accessibilityNodeProviderKitKatImpl;
            AccessibilityNodeProviderKitKatImpl accessibilityNodeProviderKitKatImpl3 = new AccessibilityNodeProviderKitKatImpl();
            IMPL = accessibilityNodeProviderKitKatImpl2;
        } else if (VERSION.SDK_INT >= 16) {
            AccessibilityNodeProviderJellyBeanImpl accessibilityNodeProviderJellyBeanImpl2 = accessibilityNodeProviderJellyBeanImpl;
            AccessibilityNodeProviderJellyBeanImpl accessibilityNodeProviderJellyBeanImpl3 = new AccessibilityNodeProviderJellyBeanImpl();
            IMPL = accessibilityNodeProviderJellyBeanImpl2;
        } else {
            AccessibilityNodeProviderStubImpl accessibilityNodeProviderStubImpl2 = accessibilityNodeProviderStubImpl;
            AccessibilityNodeProviderStubImpl accessibilityNodeProviderStubImpl3 = new AccessibilityNodeProviderStubImpl();
            IMPL = accessibilityNodeProviderStubImpl2;
        }
    }

    public AccessibilityNodeProviderCompat() {
        this.mProvider = IMPL.newAccessibilityNodeProviderBridge(this);
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.mProvider = obj;
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
        int i2 = i;
        return null;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str, int i) {
        String str2 = str;
        int i2 = i;
        return null;
    }

    public AccessibilityNodeInfoCompat findFocus(int i) {
        int i2 = i;
        return null;
    }

    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        int i3 = i;
        int i4 = i2;
        Bundle bundle2 = bundle;
        return false;
    }
}
