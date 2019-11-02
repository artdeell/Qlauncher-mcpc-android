package android.support.p000v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

/* renamed from: android.support.v4.view.LayoutInflaterCompatBase */
class LayoutInflaterCompatBase {

    /* renamed from: android.support.v4.view.LayoutInflaterCompatBase$FactoryWrapper */
    static class FactoryWrapper implements Factory {
        final LayoutInflaterFactory mDelegateFactory;

        FactoryWrapper(LayoutInflaterFactory layoutInflaterFactory) {
            this.mDelegateFactory = layoutInflaterFactory;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(null, str, context, attributeSet);
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append(getClass().getName()).append("{").append(this.mDelegateFactory).append("}").toString();
        }
    }

    LayoutInflaterCompatBase() {
    }

    static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        FactoryWrapper factoryWrapper;
        FactoryWrapper factoryWrapper2;
        LayoutInflater layoutInflater2 = layoutInflater;
        LayoutInflaterFactory layoutInflaterFactory2 = layoutInflaterFactory;
        if (layoutInflaterFactory2 != null) {
            FactoryWrapper factoryWrapper3 = factoryWrapper2;
            FactoryWrapper factoryWrapper4 = new FactoryWrapper(layoutInflaterFactory2);
            factoryWrapper = factoryWrapper3;
        } else {
            factoryWrapper = null;
        }
        layoutInflater2.setFactory(factoryWrapper);
    }
}
