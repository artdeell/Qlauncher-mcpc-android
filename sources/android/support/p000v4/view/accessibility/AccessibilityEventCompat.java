package android.support.p000v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.accessibility.AccessibilityEventCompat */
public class AccessibilityEventCompat {
    public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
    public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
    public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
    public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
    private static final AccessibilityEventVersionImpl IMPL;
    public static final int TYPES_ALL_MASK = -1;
    public static final int TYPE_ANNOUNCEMENT = 16384;
    public static final int TYPE_GESTURE_DETECTION_END = 524288;
    public static final int TYPE_GESTURE_DETECTION_START = 262144;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
    public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
    public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
    public static final int TYPE_VIEW_HOVER_ENTER = 128;
    public static final int TYPE_VIEW_HOVER_EXIT = 256;
    public static final int TYPE_VIEW_SCROLLED = 4096;
    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
    public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;

    /* renamed from: android.support.v4.view.accessibility.AccessibilityEventCompat$AccessibilityEventIcsImpl */
    static class AccessibilityEventIcsImpl extends AccessibilityEventStubImpl {
        AccessibilityEventIcsImpl() {
        }

        public void appendRecord(AccessibilityEvent accessibilityEvent, Object obj) {
            AccessibilityEventCompatIcs.appendRecord(accessibilityEvent, obj);
        }

        public Object getRecord(AccessibilityEvent accessibilityEvent, int i) {
            return AccessibilityEventCompatIcs.getRecord(accessibilityEvent, i);
        }

        public int getRecordCount(AccessibilityEvent accessibilityEvent) {
            return AccessibilityEventCompatIcs.getRecordCount(accessibilityEvent);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityEventCompat$AccessibilityEventKitKatImpl */
    static class AccessibilityEventKitKatImpl extends AccessibilityEventIcsImpl {
        AccessibilityEventKitKatImpl() {
        }

        public int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
            return AccessibilityEventCompatKitKat.getContentChangeTypes(accessibilityEvent);
        }

        public void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i) {
            AccessibilityEventCompatKitKat.setContentChangeTypes(accessibilityEvent, i);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityEventCompat$AccessibilityEventStubImpl */
    static class AccessibilityEventStubImpl implements AccessibilityEventVersionImpl {
        AccessibilityEventStubImpl() {
        }

        public void appendRecord(AccessibilityEvent accessibilityEvent, Object obj) {
        }

        public int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
            AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
            return 0;
        }

        public Object getRecord(AccessibilityEvent accessibilityEvent, int i) {
            AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
            int i2 = i;
            return null;
        }

        public int getRecordCount(AccessibilityEvent accessibilityEvent) {
            AccessibilityEvent accessibilityEvent2 = accessibilityEvent;
            return 0;
        }

        public void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i) {
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityEventCompat$AccessibilityEventVersionImpl */
    interface AccessibilityEventVersionImpl {
        void appendRecord(AccessibilityEvent accessibilityEvent, Object obj);

        int getContentChangeTypes(AccessibilityEvent accessibilityEvent);

        Object getRecord(AccessibilityEvent accessibilityEvent, int i);

        int getRecordCount(AccessibilityEvent accessibilityEvent);

        void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i);
    }

    static {
        AccessibilityEventStubImpl accessibilityEventStubImpl;
        AccessibilityEventIcsImpl accessibilityEventIcsImpl;
        AccessibilityEventKitKatImpl accessibilityEventKitKatImpl;
        if (VERSION.SDK_INT >= 19) {
            AccessibilityEventKitKatImpl accessibilityEventKitKatImpl2 = accessibilityEventKitKatImpl;
            AccessibilityEventKitKatImpl accessibilityEventKitKatImpl3 = new AccessibilityEventKitKatImpl();
            IMPL = accessibilityEventKitKatImpl2;
        } else if (VERSION.SDK_INT >= 14) {
            AccessibilityEventIcsImpl accessibilityEventIcsImpl2 = accessibilityEventIcsImpl;
            AccessibilityEventIcsImpl accessibilityEventIcsImpl3 = new AccessibilityEventIcsImpl();
            IMPL = accessibilityEventIcsImpl2;
        } else {
            AccessibilityEventStubImpl accessibilityEventStubImpl2 = accessibilityEventStubImpl;
            AccessibilityEventStubImpl accessibilityEventStubImpl3 = new AccessibilityEventStubImpl();
            IMPL = accessibilityEventStubImpl2;
        }
    }

    private AccessibilityEventCompat() {
    }

    public static void appendRecord(AccessibilityEvent accessibilityEvent, AccessibilityRecordCompat accessibilityRecordCompat) {
        IMPL.appendRecord(accessibilityEvent, accessibilityRecordCompat.getImpl());
    }

    public static AccessibilityRecordCompat asRecord(AccessibilityEvent accessibilityEvent) {
        AccessibilityRecordCompat accessibilityRecordCompat;
        AccessibilityRecordCompat accessibilityRecordCompat2 = accessibilityRecordCompat;
        AccessibilityRecordCompat accessibilityRecordCompat3 = new AccessibilityRecordCompat(accessibilityEvent);
        return accessibilityRecordCompat2;
    }

    public static int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
        return IMPL.getContentChangeTypes(accessibilityEvent);
    }

    public static AccessibilityRecordCompat getRecord(AccessibilityEvent accessibilityEvent, int i) {
        AccessibilityRecordCompat accessibilityRecordCompat;
        AccessibilityRecordCompat accessibilityRecordCompat2 = accessibilityRecordCompat;
        AccessibilityRecordCompat accessibilityRecordCompat3 = new AccessibilityRecordCompat(IMPL.getRecord(accessibilityEvent, i));
        return accessibilityRecordCompat2;
    }

    public static int getRecordCount(AccessibilityEvent accessibilityEvent) {
        return IMPL.getRecordCount(accessibilityEvent);
    }

    public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i) {
        IMPL.setContentChangeTypes(accessibilityEvent, i);
    }
}
