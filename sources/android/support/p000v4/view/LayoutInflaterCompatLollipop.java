package android.support.p000v4.view;

import android.view.LayoutInflater;

/* renamed from: android.support.v4.view.LayoutInflaterCompatLollipop */
class LayoutInflaterCompatLollipop {
    LayoutInflaterCompatLollipop() {
    }

    static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        FactoryWrapperHC factoryWrapperHC;
        FactoryWrapperHC factoryWrapperHC2;
        LayoutInflater layoutInflater2 = layoutInflater;
        LayoutInflaterFactory layoutInflaterFactory2 = layoutInflaterFactory;
        if (layoutInflaterFactory2 != null) {
            FactoryWrapperHC factoryWrapperHC3 = factoryWrapperHC2;
            FactoryWrapperHC factoryWrapperHC4 = new FactoryWrapperHC(layoutInflaterFactory2);
            factoryWrapperHC = factoryWrapperHC3;
        } else {
            factoryWrapperHC = null;
        }
        layoutInflater2.setFactory2(factoryWrapperHC);
    }
}
