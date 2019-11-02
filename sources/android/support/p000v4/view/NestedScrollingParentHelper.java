package android.support.p000v4.view;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.view.NestedScrollingParentHelper */
public class NestedScrollingParentHelper {
    private int mNestedScrollAxes;
    private final ViewGroup mViewGroup;

    public NestedScrollingParentHelper(ViewGroup viewGroup) {
        this.mViewGroup = viewGroup;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollAxes;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        View view3 = view;
        View view4 = view2;
        int i2 = i;
        this.mNestedScrollAxes = i2;
    }

    public void onStopNestedScroll(View view) {
        View view2 = view;
        this.mNestedScrollAxes = 0;
    }
}
