package android.support.p000v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v4.view.ActionProvider */
public abstract class ActionProvider {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private SubUiVisibilityListener mSubUiVisibilityListener;
    private VisibilityListener mVisibilityListener;

    /* renamed from: android.support.v4.view.ActionProvider$SubUiVisibilityListener */
    public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean z);
    }

    /* renamed from: android.support.v4.view.ActionProvider$VisibilityListener */
    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public ActionProvider(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener != null && overridesItemVisibility()) {
            this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
        }
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    public void setSubUiVisibilityListener(SubUiVisibilityListener subUiVisibilityListener) {
        SubUiVisibilityListener subUiVisibilityListener2 = subUiVisibilityListener;
        this.mSubUiVisibilityListener = subUiVisibilityListener2;
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        StringBuilder sb;
        VisibilityListener visibilityListener2 = visibilityListener;
        if (!(this.mVisibilityListener == null || visibilityListener2 == null)) {
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int w = Log.w(str, sb2.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ").append(getClass().getSimpleName()).append(" instance while it is still in use somewhere else?").toString());
        }
        this.mVisibilityListener = visibilityListener2;
    }

    public void subUiVisibilityChanged(boolean z) {
        boolean z2 = z;
        if (this.mSubUiVisibilityListener != null) {
            this.mSubUiVisibilityListener.onSubUiVisibilityChanged(z2);
        }
    }
}
