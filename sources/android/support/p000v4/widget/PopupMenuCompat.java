package android.support.p000v4.widget;

import android.os.Build.VERSION;
import android.view.View.OnTouchListener;

/* renamed from: android.support.v4.widget.PopupMenuCompat */
public class PopupMenuCompat {
    static final PopupMenuImpl IMPL;

    /* renamed from: android.support.v4.widget.PopupMenuCompat$BasePopupMenuImpl */
    static class BasePopupMenuImpl implements PopupMenuImpl {
        BasePopupMenuImpl() {
        }

        public OnTouchListener getDragToOpenListener(Object obj) {
            Object obj2 = obj;
            return null;
        }
    }

    /* renamed from: android.support.v4.widget.PopupMenuCompat$KitKatPopupMenuImpl */
    static class KitKatPopupMenuImpl extends BasePopupMenuImpl {
        KitKatPopupMenuImpl() {
        }

        public OnTouchListener getDragToOpenListener(Object obj) {
            return PopupMenuCompatKitKat.getDragToOpenListener(obj);
        }
    }

    /* renamed from: android.support.v4.widget.PopupMenuCompat$PopupMenuImpl */
    interface PopupMenuImpl {
        OnTouchListener getDragToOpenListener(Object obj);
    }

    static {
        BasePopupMenuImpl basePopupMenuImpl;
        KitKatPopupMenuImpl kitKatPopupMenuImpl;
        if (VERSION.SDK_INT >= 19) {
            KitKatPopupMenuImpl kitKatPopupMenuImpl2 = kitKatPopupMenuImpl;
            KitKatPopupMenuImpl kitKatPopupMenuImpl3 = new KitKatPopupMenuImpl();
            IMPL = kitKatPopupMenuImpl2;
            return;
        }
        BasePopupMenuImpl basePopupMenuImpl2 = basePopupMenuImpl;
        BasePopupMenuImpl basePopupMenuImpl3 = new BasePopupMenuImpl();
        IMPL = basePopupMenuImpl2;
    }

    private PopupMenuCompat() {
    }

    public static OnTouchListener getDragToOpenListener(Object obj) {
        return IMPL.getDragToOpenListener(obj);
    }
}
