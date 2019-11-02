package android.support.p000v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: android.support.v4.widget.PopupWindowCompat */
public class PopupWindowCompat {
    static final PopupWindowImpl IMPL;

    /* renamed from: android.support.v4.widget.PopupWindowCompat$Api21PopupWindowImpl */
    static class Api21PopupWindowImpl extends KitKatPopupWindowImpl {
        Api21PopupWindowImpl() {
        }

        public boolean getOverlapAnchor(PopupWindow popupWindow) {
            return PopupWindowCompatApi21.getOverlapAnchor(popupWindow);
        }

        public void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
            PopupWindowCompatApi21.setOverlapAnchor(popupWindow, z);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$Api23PopupWindowImpl */
    static class Api23PopupWindowImpl extends Api21PopupWindowImpl {
        Api23PopupWindowImpl() {
        }

        public boolean getOverlapAnchor(PopupWindow popupWindow) {
            return PopupWindowCompatApi23.getOverlapAnchor(popupWindow);
        }

        public int getWindowLayoutType(PopupWindow popupWindow) {
            return PopupWindowCompatApi23.getWindowLayoutType(popupWindow);
        }

        public void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
            PopupWindowCompatApi23.setOverlapAnchor(popupWindow, z);
        }

        public void setWindowLayoutType(PopupWindow popupWindow, int i) {
            PopupWindowCompatApi23.setWindowLayoutType(popupWindow, i);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$BasePopupWindowImpl */
    static class BasePopupWindowImpl implements PopupWindowImpl {
        BasePopupWindowImpl() {
        }

        public boolean getOverlapAnchor(PopupWindow popupWindow) {
            PopupWindow popupWindow2 = popupWindow;
            return false;
        }

        public int getWindowLayoutType(PopupWindow popupWindow) {
            PopupWindow popupWindow2 = popupWindow;
            return 0;
        }

        public void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        }

        public void setWindowLayoutType(PopupWindow popupWindow, int i) {
        }

        public void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            int i4 = i3;
            popupWindow.showAsDropDown(view, i, i2);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$GingerbreadPopupWindowImpl */
    static class GingerbreadPopupWindowImpl extends BasePopupWindowImpl {
        GingerbreadPopupWindowImpl() {
        }

        public int getWindowLayoutType(PopupWindow popupWindow) {
            return PopupWindowCompatGingerbread.getWindowLayoutType(popupWindow);
        }

        public void setWindowLayoutType(PopupWindow popupWindow, int i) {
            PopupWindowCompatGingerbread.setWindowLayoutType(popupWindow, i);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$KitKatPopupWindowImpl */
    static class KitKatPopupWindowImpl extends GingerbreadPopupWindowImpl {
        KitKatPopupWindowImpl() {
        }

        public void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            PopupWindowCompatKitKat.showAsDropDown(popupWindow, view, i, i2, i3);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$PopupWindowImpl */
    interface PopupWindowImpl {
        boolean getOverlapAnchor(PopupWindow popupWindow);

        int getWindowLayoutType(PopupWindow popupWindow);

        void setOverlapAnchor(PopupWindow popupWindow, boolean z);

        void setWindowLayoutType(PopupWindow popupWindow, int i);

        void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3);
    }

    static {
        BasePopupWindowImpl basePopupWindowImpl;
        GingerbreadPopupWindowImpl gingerbreadPopupWindowImpl;
        KitKatPopupWindowImpl kitKatPopupWindowImpl;
        Api21PopupWindowImpl api21PopupWindowImpl;
        Api23PopupWindowImpl api23PopupWindowImpl;
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            Api23PopupWindowImpl api23PopupWindowImpl2 = api23PopupWindowImpl;
            Api23PopupWindowImpl api23PopupWindowImpl3 = new Api23PopupWindowImpl();
            IMPL = api23PopupWindowImpl2;
        } else if (i >= 21) {
            Api21PopupWindowImpl api21PopupWindowImpl2 = api21PopupWindowImpl;
            Api21PopupWindowImpl api21PopupWindowImpl3 = new Api21PopupWindowImpl();
            IMPL = api21PopupWindowImpl2;
        } else if (i >= 19) {
            KitKatPopupWindowImpl kitKatPopupWindowImpl2 = kitKatPopupWindowImpl;
            KitKatPopupWindowImpl kitKatPopupWindowImpl3 = new KitKatPopupWindowImpl();
            IMPL = kitKatPopupWindowImpl2;
        } else if (i >= 9) {
            GingerbreadPopupWindowImpl gingerbreadPopupWindowImpl2 = gingerbreadPopupWindowImpl;
            GingerbreadPopupWindowImpl gingerbreadPopupWindowImpl3 = new GingerbreadPopupWindowImpl();
            IMPL = gingerbreadPopupWindowImpl2;
        } else {
            BasePopupWindowImpl basePopupWindowImpl2 = basePopupWindowImpl;
            BasePopupWindowImpl basePopupWindowImpl3 = new BasePopupWindowImpl();
            IMPL = basePopupWindowImpl2;
        }
    }

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(PopupWindow popupWindow) {
        return IMPL.getOverlapAnchor(popupWindow);
    }

    public static int getWindowLayoutType(PopupWindow popupWindow) {
        return IMPL.getWindowLayoutType(popupWindow);
    }

    public static void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        IMPL.setOverlapAnchor(popupWindow, z);
    }

    public static void setWindowLayoutType(PopupWindow popupWindow, int i) {
        IMPL.setWindowLayoutType(popupWindow, i);
    }

    public static void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        IMPL.showAsDropDown(popupWindow, view, i, i2, i3);
    }
}
