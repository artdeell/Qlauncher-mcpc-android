package android.support.p000v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v4.app.BaseFragmentActivityHoneycomb */
abstract class BaseFragmentActivityHoneycomb extends BaseFragmentActivityDonut {
    BaseFragmentActivityHoneycomb() {
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View view2 = view;
        String str2 = str;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view2, str2, context2, attributeSet2);
        if (dispatchFragmentsOnCreateView == null && VERSION.SDK_INT >= 11) {
            dispatchFragmentsOnCreateView = super.onCreateView(view2, str2, context2, attributeSet2);
        }
        return dispatchFragmentsOnCreateView;
    }
}
