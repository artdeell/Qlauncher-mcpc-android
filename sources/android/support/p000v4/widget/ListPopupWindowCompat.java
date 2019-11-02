package android.support.p000v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: android.support.v4.widget.ListPopupWindowCompat */
public class ListPopupWindowCompat {
    static final ListPopupWindowImpl IMPL;

    /* renamed from: android.support.v4.widget.ListPopupWindowCompat$BaseListPopupWindowImpl */
    static class BaseListPopupWindowImpl implements ListPopupWindowImpl {
        BaseListPopupWindowImpl() {
        }

        public OnTouchListener createDragToOpenListener(Object obj, View view) {
            Object obj2 = obj;
            View view2 = view;
            return null;
        }
    }

    /* renamed from: android.support.v4.widget.ListPopupWindowCompat$KitKatListPopupWindowImpl */
    static class KitKatListPopupWindowImpl extends BaseListPopupWindowImpl {
        KitKatListPopupWindowImpl() {
        }

        public OnTouchListener createDragToOpenListener(Object obj, View view) {
            return ListPopupWindowCompatKitKat.createDragToOpenListener(obj, view);
        }
    }

    /* renamed from: android.support.v4.widget.ListPopupWindowCompat$ListPopupWindowImpl */
    interface ListPopupWindowImpl {
        OnTouchListener createDragToOpenListener(Object obj, View view);
    }

    static {
        BaseListPopupWindowImpl baseListPopupWindowImpl;
        KitKatListPopupWindowImpl kitKatListPopupWindowImpl;
        if (VERSION.SDK_INT >= 19) {
            KitKatListPopupWindowImpl kitKatListPopupWindowImpl2 = kitKatListPopupWindowImpl;
            KitKatListPopupWindowImpl kitKatListPopupWindowImpl3 = new KitKatListPopupWindowImpl();
            IMPL = kitKatListPopupWindowImpl2;
            return;
        }
        BaseListPopupWindowImpl baseListPopupWindowImpl2 = baseListPopupWindowImpl;
        BaseListPopupWindowImpl baseListPopupWindowImpl3 = new BaseListPopupWindowImpl();
        IMPL = baseListPopupWindowImpl2;
    }

    private ListPopupWindowCompat() {
    }

    public static OnTouchListener createDragToOpenListener(Object obj, View view) {
        return IMPL.createDragToOpenListener(obj, view);
    }
}
