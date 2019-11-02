package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.view.ViewConfigurationCompat */
public class ViewConfigurationCompat {
    static final ViewConfigurationVersionImpl IMPL;

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$BaseViewConfigurationVersionImpl */
    static class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        BaseViewConfigurationVersionImpl() {
        }

        public int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }

        public boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
            ViewConfiguration viewConfiguration2 = viewConfiguration;
            return true;
        }
    }

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$FroyoViewConfigurationVersionImpl */
    static class FroyoViewConfigurationVersionImpl extends BaseViewConfigurationVersionImpl {
        FroyoViewConfigurationVersionImpl() {
        }

        public int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
            return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(viewConfiguration);
        }
    }

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$HoneycombViewConfigurationVersionImpl */
    static class HoneycombViewConfigurationVersionImpl extends FroyoViewConfigurationVersionImpl {
        HoneycombViewConfigurationVersionImpl() {
        }

        public boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
            ViewConfiguration viewConfiguration2 = viewConfiguration;
            return false;
        }
    }

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$IcsViewConfigurationVersionImpl */
    static class IcsViewConfigurationVersionImpl extends HoneycombViewConfigurationVersionImpl {
        IcsViewConfigurationVersionImpl() {
        }

        public boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
            return ViewConfigurationCompatICS.hasPermanentMenuKey(viewConfiguration);
        }
    }

    /* renamed from: android.support.v4.view.ViewConfigurationCompat$ViewConfigurationVersionImpl */
    interface ViewConfigurationVersionImpl {
        int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration);

        boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration);
    }

    static {
        BaseViewConfigurationVersionImpl baseViewConfigurationVersionImpl;
        FroyoViewConfigurationVersionImpl froyoViewConfigurationVersionImpl;
        HoneycombViewConfigurationVersionImpl honeycombViewConfigurationVersionImpl;
        IcsViewConfigurationVersionImpl icsViewConfigurationVersionImpl;
        if (VERSION.SDK_INT >= 14) {
            IcsViewConfigurationVersionImpl icsViewConfigurationVersionImpl2 = icsViewConfigurationVersionImpl;
            IcsViewConfigurationVersionImpl icsViewConfigurationVersionImpl3 = new IcsViewConfigurationVersionImpl();
            IMPL = icsViewConfigurationVersionImpl2;
        } else if (VERSION.SDK_INT >= 11) {
            HoneycombViewConfigurationVersionImpl honeycombViewConfigurationVersionImpl2 = honeycombViewConfigurationVersionImpl;
            HoneycombViewConfigurationVersionImpl honeycombViewConfigurationVersionImpl3 = new HoneycombViewConfigurationVersionImpl();
            IMPL = honeycombViewConfigurationVersionImpl2;
        } else if (VERSION.SDK_INT >= 8) {
            FroyoViewConfigurationVersionImpl froyoViewConfigurationVersionImpl2 = froyoViewConfigurationVersionImpl;
            FroyoViewConfigurationVersionImpl froyoViewConfigurationVersionImpl3 = new FroyoViewConfigurationVersionImpl();
            IMPL = froyoViewConfigurationVersionImpl2;
        } else {
            BaseViewConfigurationVersionImpl baseViewConfigurationVersionImpl2 = baseViewConfigurationVersionImpl;
            BaseViewConfigurationVersionImpl baseViewConfigurationVersionImpl3 = new BaseViewConfigurationVersionImpl();
            IMPL = baseViewConfigurationVersionImpl2;
        }
    }

    public ViewConfigurationCompat() {
    }

    public static int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
        return IMPL.getScaledPagingTouchSlop(viewConfiguration);
    }

    public static boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
        return IMPL.hasPermanentMenuKey(viewConfiguration);
    }
}
