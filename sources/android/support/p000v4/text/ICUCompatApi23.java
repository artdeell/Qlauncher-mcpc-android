package android.support.p000v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: android.support.v4.text.ICUCompatApi23 */
public class ICUCompatApi23 {
    private static final String TAG = "ICUCompatIcs";
    private static Method sAddLikelySubtagsMethod;

    static {
        IllegalStateException illegalStateException;
        try {
            Class[] clsArr = new Class[1];
            Class[] clsArr2 = clsArr;
            clsArr[0] = Locale.class;
            sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", clsArr2);
        } catch (Exception e) {
            Exception exc = e;
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException(exc);
            throw illegalStateException2;
        }
    }

    public ICUCompatApi23() {
    }

    public static String maximizeAndGetScript(Locale locale) {
        Locale locale2 = locale;
        try {
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = locale2;
            return ((Locale) sAddLikelySubtagsMethod.invoke(null, objArr2)).getScript();
        } catch (InvocationTargetException e) {
            int w = Log.w(TAG, e);
            return locale2.getScript();
        } catch (IllegalAccessException e2) {
            int w2 = Log.w(TAG, e2);
            return locale2.getScript();
        }
    }
}
