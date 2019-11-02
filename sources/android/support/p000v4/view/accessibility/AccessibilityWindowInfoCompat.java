package android.support.p000v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat */
public class AccessibilityWindowInfoCompat {
    private static final AccessibilityWindowInfoImpl IMPL;
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private Object mInfo;

    /* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$AccessibilityWindowInfoApi21Impl */
    private static class AccessibilityWindowInfoApi21Impl extends AccessibilityWindowInfoStubImpl {
        private AccessibilityWindowInfoApi21Impl() {
            super(null);
        }

        /* synthetic */ AccessibilityWindowInfoApi21Impl(C01251 r4) {
            C01251 r1 = r4;
            this();
        }

        public void getBoundsInScreen(Object obj, Rect rect) {
            AccessibilityWindowInfoCompatApi21.getBoundsInScreen(obj, rect);
        }

        public Object getChild(Object obj, int i) {
            return AccessibilityWindowInfoCompatApi21.getChild(obj, i);
        }

        public int getChildCount(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getChildCount(obj);
        }

        public int getId(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getId(obj);
        }

        public int getLayer(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getLayer(obj);
        }

        public Object getParent(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getParent(obj);
        }

        public Object getRoot(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getRoot(obj);
        }

        public int getType(Object obj) {
            return AccessibilityWindowInfoCompatApi21.getType(obj);
        }

        public boolean isAccessibilityFocused(Object obj) {
            return AccessibilityWindowInfoCompatApi21.isAccessibilityFocused(obj);
        }

        public boolean isActive(Object obj) {
            return AccessibilityWindowInfoCompatApi21.isActive(obj);
        }

        public boolean isFocused(Object obj) {
            return AccessibilityWindowInfoCompatApi21.isFocused(obj);
        }

        public Object obtain() {
            return AccessibilityWindowInfoCompatApi21.obtain();
        }

        public Object obtain(Object obj) {
            return AccessibilityWindowInfoCompatApi21.obtain(obj);
        }

        public void recycle(Object obj) {
            AccessibilityWindowInfoCompatApi21.recycle(obj);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$AccessibilityWindowInfoImpl */
    private interface AccessibilityWindowInfoImpl {
        void getBoundsInScreen(Object obj, Rect rect);

        Object getChild(Object obj, int i);

        int getChildCount(Object obj);

        int getId(Object obj);

        int getLayer(Object obj);

        Object getParent(Object obj);

        Object getRoot(Object obj);

        int getType(Object obj);

        boolean isAccessibilityFocused(Object obj);

        boolean isActive(Object obj);

        boolean isFocused(Object obj);

        Object obtain();

        Object obtain(Object obj);

        void recycle(Object obj);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$AccessibilityWindowInfoStubImpl */
    private static class AccessibilityWindowInfoStubImpl implements AccessibilityWindowInfoImpl {
        private AccessibilityWindowInfoStubImpl() {
        }

        /* synthetic */ AccessibilityWindowInfoStubImpl(C01251 r4) {
            C01251 r1 = r4;
            this();
        }

        public void getBoundsInScreen(Object obj, Rect rect) {
        }

        public Object getChild(Object obj, int i) {
            Object obj2 = obj;
            int i2 = i;
            return null;
        }

        public int getChildCount(Object obj) {
            Object obj2 = obj;
            return 0;
        }

        public int getId(Object obj) {
            Object obj2 = obj;
            return -1;
        }

        public int getLayer(Object obj) {
            Object obj2 = obj;
            return -1;
        }

        public Object getParent(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public Object getRoot(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public int getType(Object obj) {
            Object obj2 = obj;
            return -1;
        }

        public boolean isAccessibilityFocused(Object obj) {
            Object obj2 = obj;
            return true;
        }

        public boolean isActive(Object obj) {
            Object obj2 = obj;
            return true;
        }

        public boolean isFocused(Object obj) {
            Object obj2 = obj;
            return true;
        }

        public Object obtain() {
            return null;
        }

        public Object obtain(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public void recycle(Object obj) {
        }
    }

    static {
        AccessibilityWindowInfoStubImpl accessibilityWindowInfoStubImpl;
        AccessibilityWindowInfoApi21Impl accessibilityWindowInfoApi21Impl;
        if (VERSION.SDK_INT >= 21) {
            AccessibilityWindowInfoApi21Impl accessibilityWindowInfoApi21Impl2 = accessibilityWindowInfoApi21Impl;
            AccessibilityWindowInfoApi21Impl accessibilityWindowInfoApi21Impl3 = new AccessibilityWindowInfoApi21Impl(null);
            IMPL = accessibilityWindowInfoApi21Impl2;
            return;
        }
        AccessibilityWindowInfoStubImpl accessibilityWindowInfoStubImpl2 = accessibilityWindowInfoStubImpl;
        AccessibilityWindowInfoStubImpl accessibilityWindowInfoStubImpl3 = new AccessibilityWindowInfoStubImpl(null);
        IMPL = accessibilityWindowInfoStubImpl2;
    }

    private AccessibilityWindowInfoCompat(Object obj) {
        this.mInfo = obj;
    }

    public static AccessibilityWindowInfoCompat obtain() {
        return wrapNonNullInstance(IMPL.obtain());
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        return wrapNonNullInstance(IMPL.obtain(accessibilityWindowInfoCompat.mInfo));
    }

    private static String typeToString(int i) {
        switch (i) {
            case 1:
                return "TYPE_APPLICATION";
            case 2:
                return "TYPE_INPUT_METHOD";
            case 3:
                return "TYPE_SYSTEM";
            case 4:
                return "TYPE_ACCESSIBILITY_OVERLAY";
            default:
                return "<UNKNOWN>";
        }
    }

    static AccessibilityWindowInfoCompat wrapNonNullInstance(Object obj) {
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat;
        Object obj2 = obj;
        if (obj2 == null) {
            return null;
        }
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat2 = accessibilityWindowInfoCompat;
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat3 = new AccessibilityWindowInfoCompat(obj2);
        return accessibilityWindowInfoCompat2;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this != obj2) {
            if (obj2 == null) {
                return false;
            }
            if (getClass() != obj2.getClass()) {
                return false;
            }
            AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj2;
            if (this.mInfo == null) {
                if (accessibilityWindowInfoCompat.mInfo != null) {
                    return false;
                }
            } else if (!this.mInfo.equals(accessibilityWindowInfoCompat.mInfo)) {
                return false;
            }
        }
        return true;
    }

    public void getBoundsInScreen(Rect rect) {
        Rect rect2 = rect;
        IMPL.getBoundsInScreen(this.mInfo, rect2);
    }

    public AccessibilityWindowInfoCompat getChild(int i) {
        return wrapNonNullInstance(IMPL.getChild(this.mInfo, i));
    }

    public int getChildCount() {
        return IMPL.getChildCount(this.mInfo);
    }

    public int getId() {
        return IMPL.getId(this.mInfo);
    }

    public int getLayer() {
        return IMPL.getLayer(this.mInfo);
    }

    public AccessibilityWindowInfoCompat getParent() {
        return wrapNonNullInstance(IMPL.getParent(this.mInfo));
    }

    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(IMPL.getRoot(this.mInfo));
    }

    public int getType() {
        return IMPL.getType(this.mInfo);
    }

    public int hashCode() {
        if (this.mInfo == null) {
            return 0;
        }
        return this.mInfo.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return IMPL.isAccessibilityFocused(this.mInfo);
    }

    public boolean isActive() {
        return IMPL.isActive(this.mInfo);
    }

    public boolean isFocused() {
        return IMPL.isFocused(this.mInfo);
    }

    public void recycle() {
        IMPL.recycle(this.mInfo);
    }

    public String toString() {
        StringBuilder sb;
        Rect rect;
        boolean z = true;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        Rect rect2 = rect;
        Rect rect3 = new Rect();
        Rect rect4 = rect2;
        getBoundsInScreen(rect4);
        StringBuilder append = sb4.append("AccessibilityWindowInfo[");
        StringBuilder append2 = sb4.append("id=").append(getId());
        StringBuilder append3 = sb4.append(", type=").append(typeToString(getType()));
        StringBuilder append4 = sb4.append(", layer=").append(getLayer());
        StringBuilder append5 = sb4.append(", bounds=").append(rect4);
        StringBuilder append6 = sb4.append(", focused=").append(isFocused());
        StringBuilder append7 = sb4.append(", active=").append(isActive());
        StringBuilder append8 = sb4.append(", hasParent=").append(getParent() != null);
        StringBuilder append9 = sb4.append(", hasChildren=");
        if (getChildCount() <= 0) {
            z = false;
        }
        StringBuilder append10 = append9.append(z);
        StringBuilder append11 = sb4.append(']');
        return sb4.toString();
    }
}
