package android.support.p000v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v4.app.BaseFragmentActivityDonut */
abstract class BaseFragmentActivityDonut extends Activity {
    BaseFragmentActivityDonut() {
    }

    /* access modifiers changed from: 0000 */
    public abstract View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (VERSION.SDK_INT < 11 && getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle2);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        String str2 = str;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str2, context2, attributeSet2);
        if (dispatchFragmentsOnCreateView == null) {
            dispatchFragmentsOnCreateView = super.onCreateView(str2, context2, attributeSet2);
        }
        return dispatchFragmentsOnCreateView;
    }
}
