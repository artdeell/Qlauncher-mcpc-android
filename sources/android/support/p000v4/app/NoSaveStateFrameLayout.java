package android.support.p000v4.app;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

/* renamed from: android.support.v4.app.NoSaveStateFrameLayout */
class NoSaveStateFrameLayout extends FrameLayout {
    public NoSaveStateFrameLayout(Context context) {
        super(context);
    }

    static ViewGroup wrap(View view) {
        NoSaveStateFrameLayout noSaveStateFrameLayout;
        LayoutParams layoutParams;
        View view2 = view;
        NoSaveStateFrameLayout noSaveStateFrameLayout2 = noSaveStateFrameLayout;
        NoSaveStateFrameLayout noSaveStateFrameLayout3 = new NoSaveStateFrameLayout(view2.getContext());
        NoSaveStateFrameLayout noSaveStateFrameLayout4 = noSaveStateFrameLayout2;
        ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
        if (layoutParams2 != null) {
            noSaveStateFrameLayout4.setLayoutParams(layoutParams2);
        }
        View view3 = view2;
        LayoutParams layoutParams3 = layoutParams;
        LayoutParams layoutParams4 = new LayoutParams(-1, -1);
        view3.setLayoutParams(layoutParams3);
        noSaveStateFrameLayout4.addView(view2);
        return noSaveStateFrameLayout4;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }
}
