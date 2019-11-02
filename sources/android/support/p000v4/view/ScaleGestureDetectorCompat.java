package android.support.p000v4.view;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.view.ScaleGestureDetectorCompat */
public class ScaleGestureDetectorCompat {
    static final ScaleGestureDetectorImpl IMPL;

    /* renamed from: android.support.v4.view.ScaleGestureDetectorCompat$BaseScaleGestureDetectorImpl */
    private static class BaseScaleGestureDetectorImpl implements ScaleGestureDetectorImpl {
        private BaseScaleGestureDetectorImpl() {
        }

        /* synthetic */ BaseScaleGestureDetectorImpl(C01081 r4) {
            C01081 r1 = r4;
            this();
        }

        public boolean isQuickScaleEnabled(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public void setQuickScaleEnabled(Object obj, boolean z) {
        }
    }

    /* renamed from: android.support.v4.view.ScaleGestureDetectorCompat$ScaleGestureDetectorCompatKitKatImpl */
    private static class ScaleGestureDetectorCompatKitKatImpl implements ScaleGestureDetectorImpl {
        private ScaleGestureDetectorCompatKitKatImpl() {
        }

        /* synthetic */ ScaleGestureDetectorCompatKitKatImpl(C01081 r4) {
            C01081 r1 = r4;
            this();
        }

        public boolean isQuickScaleEnabled(Object obj) {
            return ScaleGestureDetectorCompatKitKat.isQuickScaleEnabled(obj);
        }

        public void setQuickScaleEnabled(Object obj, boolean z) {
            ScaleGestureDetectorCompatKitKat.setQuickScaleEnabled(obj, z);
        }
    }

    /* renamed from: android.support.v4.view.ScaleGestureDetectorCompat$ScaleGestureDetectorImpl */
    interface ScaleGestureDetectorImpl {
        boolean isQuickScaleEnabled(Object obj);

        void setQuickScaleEnabled(Object obj, boolean z);
    }

    static {
        BaseScaleGestureDetectorImpl baseScaleGestureDetectorImpl;
        ScaleGestureDetectorCompatKitKatImpl scaleGestureDetectorCompatKitKatImpl;
        if (VERSION.SDK_INT >= 19) {
            ScaleGestureDetectorCompatKitKatImpl scaleGestureDetectorCompatKitKatImpl2 = scaleGestureDetectorCompatKitKatImpl;
            ScaleGestureDetectorCompatKitKatImpl scaleGestureDetectorCompatKitKatImpl3 = new ScaleGestureDetectorCompatKitKatImpl(null);
            IMPL = scaleGestureDetectorCompatKitKatImpl2;
            return;
        }
        BaseScaleGestureDetectorImpl baseScaleGestureDetectorImpl2 = baseScaleGestureDetectorImpl;
        BaseScaleGestureDetectorImpl baseScaleGestureDetectorImpl3 = new BaseScaleGestureDetectorImpl(null);
        IMPL = baseScaleGestureDetectorImpl2;
    }

    private ScaleGestureDetectorCompat() {
    }

    public static boolean isQuickScaleEnabled(Object obj) {
        return IMPL.isQuickScaleEnabled(obj);
    }

    public static void setQuickScaleEnabled(Object obj, boolean z) {
        IMPL.setQuickScaleEnabled(obj, z);
    }
}
