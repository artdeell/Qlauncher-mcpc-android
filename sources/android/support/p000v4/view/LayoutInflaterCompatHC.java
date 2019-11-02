package android.support.p000v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.view.LayoutInflaterCompatHC */
class LayoutInflaterCompatHC {
    private static final String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;

    /* renamed from: android.support.v4.view.LayoutInflaterCompatHC$FactoryWrapperHC */
    static class FactoryWrapperHC extends FactoryWrapper implements Factory2 {
        FactoryWrapperHC(LayoutInflaterFactory layoutInflaterFactory) {
            super(layoutInflaterFactory);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(view, str, context, attributeSet);
        }
    }

    LayoutInflaterCompatHC() {
    }

    static void forceSetFactory2(LayoutInflater layoutInflater, Factory2 factory2) {
        StringBuilder sb;
        StringBuilder sb2;
        LayoutInflater layoutInflater2 = layoutInflater;
        Factory2 factory22 = factory2;
        if (!sCheckedField) {
            try {
                sLayoutInflaterFactory2Field = LayoutInflater.class.getDeclaredField("mFactory2");
                sLayoutInflaterFactory2Field.setAccessible(true);
            } catch (NoSuchFieldException e) {
                NoSuchFieldException noSuchFieldException = e;
                String str = TAG;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                int e2 = Log.e(str, sb3.append("forceSetFactory2 Could not find field 'mFactory2' on class ").append(LayoutInflater.class.getName()).append("; inflation may have unexpected results.").toString(), noSuchFieldException);
            }
            sCheckedField = true;
        }
        if (sLayoutInflaterFactory2Field != null) {
            try {
                sLayoutInflaterFactory2Field.set(layoutInflater2, factory22);
            } catch (IllegalAccessException e3) {
                IllegalAccessException illegalAccessException = e3;
                String str2 = TAG;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                int e4 = Log.e(str2, sb5.append("forceSetFactory2 could not set the Factory2 on LayoutInflater ").append(layoutInflater2).append("; inflation may have unexpected results.").toString(), illegalAccessException);
            }
        }
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
        Factory factory = layoutInflater2.getFactory();
        if (factory instanceof Factory2) {
            forceSetFactory2(layoutInflater2, (Factory2) factory);
        } else {
            forceSetFactory2(layoutInflater2, factoryWrapperHC);
        }
    }
}
