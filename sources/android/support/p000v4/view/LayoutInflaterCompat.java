package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

/* renamed from: android.support.v4.view.LayoutInflaterCompat */
public class LayoutInflaterCompat {
    static final LayoutInflaterCompatImpl IMPL;

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImpl */
    interface LayoutInflaterCompatImpl {
        void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory);
    }

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImplBase */
    static class LayoutInflaterCompatImplBase implements LayoutInflaterCompatImpl {
        LayoutInflaterCompatImplBase() {
        }

        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            LayoutInflaterCompatBase.setFactory(layoutInflater, layoutInflaterFactory);
        }
    }

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImplV11 */
    static class LayoutInflaterCompatImplV11 extends LayoutInflaterCompatImplBase {
        LayoutInflaterCompatImplV11() {
        }

        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            LayoutInflaterCompatHC.setFactory(layoutInflater, layoutInflaterFactory);
        }
    }

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImplV21 */
    static class LayoutInflaterCompatImplV21 extends LayoutInflaterCompatImplV11 {
        LayoutInflaterCompatImplV21() {
        }

        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
            LayoutInflaterCompatLollipop.setFactory(layoutInflater, layoutInflaterFactory);
        }
    }

    static {
        LayoutInflaterCompatImplBase layoutInflaterCompatImplBase;
        LayoutInflaterCompatImplV11 layoutInflaterCompatImplV11;
        LayoutInflaterCompatImplV21 layoutInflaterCompatImplV21;
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            LayoutInflaterCompatImplV21 layoutInflaterCompatImplV212 = layoutInflaterCompatImplV21;
            LayoutInflaterCompatImplV21 layoutInflaterCompatImplV213 = new LayoutInflaterCompatImplV21();
            IMPL = layoutInflaterCompatImplV212;
        } else if (i >= 11) {
            LayoutInflaterCompatImplV11 layoutInflaterCompatImplV112 = layoutInflaterCompatImplV11;
            LayoutInflaterCompatImplV11 layoutInflaterCompatImplV113 = new LayoutInflaterCompatImplV11();
            IMPL = layoutInflaterCompatImplV112;
        } else {
            LayoutInflaterCompatImplBase layoutInflaterCompatImplBase2 = layoutInflaterCompatImplBase;
            LayoutInflaterCompatImplBase layoutInflaterCompatImplBase3 = new LayoutInflaterCompatImplBase();
            IMPL = layoutInflaterCompatImplBase2;
        }
    }

    private LayoutInflaterCompat() {
    }

    public static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        IMPL.setFactory(layoutInflater, layoutInflaterFactory);
    }
}
