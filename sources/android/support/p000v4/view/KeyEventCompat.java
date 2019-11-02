package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;

/* renamed from: android.support.v4.view.KeyEventCompat */
public class KeyEventCompat {
    static final KeyEventVersionImpl IMPL;

    /* renamed from: android.support.v4.view.KeyEventCompat$BaseKeyEventVersionImpl */
    static class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
        private static final int META_ALL_MASK = 247;
        private static final int META_MODIFIER_MASK = 247;

        BaseKeyEventVersionImpl() {
        }

        private static int metaStateFilterDirectionalModifiers(int i, int i2, int i3, int i4, int i5) {
            IllegalArgumentException illegalArgumentException;
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            int i10 = i5;
            boolean z = true;
            boolean z2 = (i7 & i8) != 0;
            int i11 = i9 | i10;
            if ((i7 & i11) == 0) {
                z = false;
            }
            if (z2) {
                if (z) {
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bad arguments");
                    throw illegalArgumentException2;
                }
                i6 &= i11 ^ -1;
            } else if (z) {
                return i6 & (i8 ^ -1);
            }
            return i6;
        }

        public boolean dispatch(KeyEvent keyEvent, Callback callback, Object obj, Object obj2) {
            Object obj3 = obj;
            Object obj4 = obj2;
            return keyEvent.dispatch(callback);
        }

        public Object getKeyDispatcherState(View view) {
            View view2 = view;
            return null;
        }

        public boolean isTracking(KeyEvent keyEvent) {
            KeyEvent keyEvent2 = keyEvent;
            return false;
        }

        public boolean metaStateHasModifiers(int i, int i2) {
            int i3 = i2;
            return metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(247 & normalizeMetaState(i), i3, 1, 64, 128), i3, 2, 16, 32) == i3;
        }

        public boolean metaStateHasNoModifiers(int i) {
            return (247 & normalizeMetaState(i)) == 0;
        }

        public int normalizeMetaState(int i) {
            int i2 = i;
            if ((i2 & 192) != 0) {
                i2 |= 1;
            }
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        public void startTracking(KeyEvent keyEvent) {
        }
    }

    /* renamed from: android.support.v4.view.KeyEventCompat$EclairKeyEventVersionImpl */
    static class EclairKeyEventVersionImpl extends BaseKeyEventVersionImpl {
        EclairKeyEventVersionImpl() {
        }

        public boolean dispatch(KeyEvent keyEvent, Callback callback, Object obj, Object obj2) {
            return KeyEventCompatEclair.dispatch(keyEvent, callback, obj, obj2);
        }

        public Object getKeyDispatcherState(View view) {
            return KeyEventCompatEclair.getKeyDispatcherState(view);
        }

        public boolean isTracking(KeyEvent keyEvent) {
            return KeyEventCompatEclair.isTracking(keyEvent);
        }

        public void startTracking(KeyEvent keyEvent) {
            KeyEventCompatEclair.startTracking(keyEvent);
        }
    }

    /* renamed from: android.support.v4.view.KeyEventCompat$HoneycombKeyEventVersionImpl */
    static class HoneycombKeyEventVersionImpl extends EclairKeyEventVersionImpl {
        HoneycombKeyEventVersionImpl() {
        }

        public boolean metaStateHasModifiers(int i, int i2) {
            return KeyEventCompatHoneycomb.metaStateHasModifiers(i, i2);
        }

        public boolean metaStateHasNoModifiers(int i) {
            return KeyEventCompatHoneycomb.metaStateHasNoModifiers(i);
        }

        public int normalizeMetaState(int i) {
            return KeyEventCompatHoneycomb.normalizeMetaState(i);
        }
    }

    /* renamed from: android.support.v4.view.KeyEventCompat$KeyEventVersionImpl */
    interface KeyEventVersionImpl {
        boolean dispatch(KeyEvent keyEvent, Callback callback, Object obj, Object obj2);

        Object getKeyDispatcherState(View view);

        boolean isTracking(KeyEvent keyEvent);

        boolean metaStateHasModifiers(int i, int i2);

        boolean metaStateHasNoModifiers(int i);

        int normalizeMetaState(int i);

        void startTracking(KeyEvent keyEvent);
    }

    static {
        BaseKeyEventVersionImpl baseKeyEventVersionImpl;
        HoneycombKeyEventVersionImpl honeycombKeyEventVersionImpl;
        if (VERSION.SDK_INT >= 11) {
            HoneycombKeyEventVersionImpl honeycombKeyEventVersionImpl2 = honeycombKeyEventVersionImpl;
            HoneycombKeyEventVersionImpl honeycombKeyEventVersionImpl3 = new HoneycombKeyEventVersionImpl();
            IMPL = honeycombKeyEventVersionImpl2;
            return;
        }
        BaseKeyEventVersionImpl baseKeyEventVersionImpl2 = baseKeyEventVersionImpl;
        BaseKeyEventVersionImpl baseKeyEventVersionImpl3 = new BaseKeyEventVersionImpl();
        IMPL = baseKeyEventVersionImpl2;
    }

    public KeyEventCompat() {
    }

    public static boolean dispatch(KeyEvent keyEvent, Callback callback, Object obj, Object obj2) {
        return IMPL.dispatch(keyEvent, callback, obj, obj2);
    }

    public static Object getKeyDispatcherState(View view) {
        return IMPL.getKeyDispatcherState(view);
    }

    public static boolean hasModifiers(KeyEvent keyEvent, int i) {
        return IMPL.metaStateHasModifiers(keyEvent.getMetaState(), i);
    }

    public static boolean hasNoModifiers(KeyEvent keyEvent) {
        return IMPL.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public static boolean isTracking(KeyEvent keyEvent) {
        return IMPL.isTracking(keyEvent);
    }

    public static boolean metaStateHasModifiers(int i, int i2) {
        return IMPL.metaStateHasModifiers(i, i2);
    }

    public static boolean metaStateHasNoModifiers(int i) {
        return IMPL.metaStateHasNoModifiers(i);
    }

    public static int normalizeMetaState(int i) {
        return IMPL.normalizeMetaState(i);
    }

    public static void startTracking(KeyEvent keyEvent) {
        IMPL.startTracking(keyEvent);
    }
}
