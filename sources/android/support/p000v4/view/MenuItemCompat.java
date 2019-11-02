package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.support.p000v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.view.MenuItemCompat */
public class MenuItemCompat {
    static final MenuVersionImpl IMPL;
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    /* renamed from: android.support.v4.view.MenuItemCompat$BaseMenuVersionImpl */
    static class BaseMenuVersionImpl implements MenuVersionImpl {
        BaseMenuVersionImpl() {
        }

        public boolean collapseActionView(MenuItem menuItem) {
            MenuItem menuItem2 = menuItem;
            return false;
        }

        public boolean expandActionView(MenuItem menuItem) {
            MenuItem menuItem2 = menuItem;
            return false;
        }

        public View getActionView(MenuItem menuItem) {
            MenuItem menuItem2 = menuItem;
            return null;
        }

        public boolean isActionViewExpanded(MenuItem menuItem) {
            MenuItem menuItem2 = menuItem;
            return false;
        }

        public MenuItem setActionView(MenuItem menuItem, int i) {
            int i2 = i;
            return menuItem;
        }

        public MenuItem setActionView(MenuItem menuItem, View view) {
            View view2 = view;
            return menuItem;
        }

        public MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
            OnActionExpandListener onActionExpandListener2 = onActionExpandListener;
            return menuItem;
        }

        public void setShowAsAction(MenuItem menuItem, int i) {
        }
    }

    /* renamed from: android.support.v4.view.MenuItemCompat$HoneycombMenuVersionImpl */
    static class HoneycombMenuVersionImpl implements MenuVersionImpl {
        HoneycombMenuVersionImpl() {
        }

        public boolean collapseActionView(MenuItem menuItem) {
            MenuItem menuItem2 = menuItem;
            return false;
        }

        public boolean expandActionView(MenuItem menuItem) {
            MenuItem menuItem2 = menuItem;
            return false;
        }

        public View getActionView(MenuItem menuItem) {
            return MenuItemCompatHoneycomb.getActionView(menuItem);
        }

        public boolean isActionViewExpanded(MenuItem menuItem) {
            MenuItem menuItem2 = menuItem;
            return false;
        }

        public MenuItem setActionView(MenuItem menuItem, int i) {
            return MenuItemCompatHoneycomb.setActionView(menuItem, i);
        }

        public MenuItem setActionView(MenuItem menuItem, View view) {
            return MenuItemCompatHoneycomb.setActionView(menuItem, view);
        }

        public MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
            OnActionExpandListener onActionExpandListener2 = onActionExpandListener;
            return menuItem;
        }

        public void setShowAsAction(MenuItem menuItem, int i) {
            MenuItemCompatHoneycomb.setShowAsAction(menuItem, i);
        }
    }

    /* renamed from: android.support.v4.view.MenuItemCompat$IcsMenuVersionImpl */
    static class IcsMenuVersionImpl extends HoneycombMenuVersionImpl {
        IcsMenuVersionImpl() {
        }

        public boolean collapseActionView(MenuItem menuItem) {
            return MenuItemCompatIcs.collapseActionView(menuItem);
        }

        public boolean expandActionView(MenuItem menuItem) {
            return MenuItemCompatIcs.expandActionView(menuItem);
        }

        public boolean isActionViewExpanded(MenuItem menuItem) {
            return MenuItemCompatIcs.isActionViewExpanded(menuItem);
        }

        public MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
            C01041 r8;
            MenuItem menuItem2 = menuItem;
            OnActionExpandListener onActionExpandListener2 = onActionExpandListener;
            if (onActionExpandListener2 == null) {
                return MenuItemCompatIcs.setOnActionExpandListener(menuItem2, null);
            }
            MenuItem menuItem3 = menuItem2;
            C01041 r4 = r8;
            final OnActionExpandListener onActionExpandListener3 = onActionExpandListener2;
            C01041 r5 = new SupportActionExpandProxy(this) {
                final /* synthetic */ IcsMenuVersionImpl this$0;

                {
                    OnActionExpandListener onActionExpandListener = r7;
                    this.this$0 = r6;
                }

                public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                    return onActionExpandListener3.onMenuItemActionCollapse(menuItem);
                }

                public boolean onMenuItemActionExpand(MenuItem menuItem) {
                    return onActionExpandListener3.onMenuItemActionExpand(menuItem);
                }
            };
            return MenuItemCompatIcs.setOnActionExpandListener(menuItem3, r4);
        }
    }

    /* renamed from: android.support.v4.view.MenuItemCompat$MenuVersionImpl */
    interface MenuVersionImpl {
        boolean collapseActionView(MenuItem menuItem);

        boolean expandActionView(MenuItem menuItem);

        View getActionView(MenuItem menuItem);

        boolean isActionViewExpanded(MenuItem menuItem);

        MenuItem setActionView(MenuItem menuItem, int i);

        MenuItem setActionView(MenuItem menuItem, View view);

        MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener);

        void setShowAsAction(MenuItem menuItem, int i);
    }

    /* renamed from: android.support.v4.view.MenuItemCompat$OnActionExpandListener */
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    static {
        BaseMenuVersionImpl baseMenuVersionImpl;
        HoneycombMenuVersionImpl honeycombMenuVersionImpl;
        IcsMenuVersionImpl icsMenuVersionImpl;
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            IcsMenuVersionImpl icsMenuVersionImpl2 = icsMenuVersionImpl;
            IcsMenuVersionImpl icsMenuVersionImpl3 = new IcsMenuVersionImpl();
            IMPL = icsMenuVersionImpl2;
        } else if (i >= 11) {
            HoneycombMenuVersionImpl honeycombMenuVersionImpl2 = honeycombMenuVersionImpl;
            HoneycombMenuVersionImpl honeycombMenuVersionImpl3 = new HoneycombMenuVersionImpl();
            IMPL = honeycombMenuVersionImpl2;
        } else {
            BaseMenuVersionImpl baseMenuVersionImpl2 = baseMenuVersionImpl;
            BaseMenuVersionImpl baseMenuVersionImpl3 = new BaseMenuVersionImpl();
            IMPL = baseMenuVersionImpl2;
        }
    }

    public MenuItemCompat() {
    }

    public static boolean collapseActionView(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        return menuItem2 instanceof SupportMenuItem ? ((SupportMenuItem) menuItem2).collapseActionView() : IMPL.collapseActionView(menuItem2);
    }

    public static boolean expandActionView(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        return menuItem2 instanceof SupportMenuItem ? ((SupportMenuItem) menuItem2).expandActionView() : IMPL.expandActionView(menuItem2);
    }

    public static ActionProvider getActionProvider(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        if (menuItem2 instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem2).getSupportActionProvider();
        }
        int w = Log.w(TAG, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    public static View getActionView(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        return menuItem2 instanceof SupportMenuItem ? ((SupportMenuItem) menuItem2).getActionView() : IMPL.getActionView(menuItem2);
    }

    public static boolean isActionViewExpanded(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        return menuItem2 instanceof SupportMenuItem ? ((SupportMenuItem) menuItem2).isActionViewExpanded() : IMPL.isActionViewExpanded(menuItem2);
    }

    public static MenuItem setActionProvider(MenuItem menuItem, ActionProvider actionProvider) {
        MenuItem menuItem2 = menuItem;
        ActionProvider actionProvider2 = actionProvider;
        if (menuItem2 instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem2).setSupportActionProvider(actionProvider2);
        }
        int w = Log.w(TAG, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem2;
    }

    public static MenuItem setActionView(MenuItem menuItem, int i) {
        MenuItem menuItem2 = menuItem;
        int i2 = i;
        return menuItem2 instanceof SupportMenuItem ? ((SupportMenuItem) menuItem2).setActionView(i2) : IMPL.setActionView(menuItem2, i2);
    }

    public static MenuItem setActionView(MenuItem menuItem, View view) {
        MenuItem menuItem2 = menuItem;
        View view2 = view;
        return menuItem2 instanceof SupportMenuItem ? ((SupportMenuItem) menuItem2).setActionView(view2) : IMPL.setActionView(menuItem2, view2);
    }

    public static MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
        MenuItem menuItem2 = menuItem;
        OnActionExpandListener onActionExpandListener2 = onActionExpandListener;
        return menuItem2 instanceof SupportMenuItem ? ((SupportMenuItem) menuItem2).setSupportOnActionExpandListener(onActionExpandListener2) : IMPL.setOnActionExpandListener(menuItem2, onActionExpandListener2);
    }

    public static void setShowAsAction(MenuItem menuItem, int i) {
        MenuItem menuItem2 = menuItem;
        int i2 = i;
        if (menuItem2 instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem2).setShowAsAction(i2);
        } else {
            IMPL.setShowAsAction(menuItem2, i2);
        }
    }
}
