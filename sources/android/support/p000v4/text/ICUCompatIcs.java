package android.support.p000v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: android.support.v4.text.ICUCompatIcs */
class ICUCompatIcs {
    private static final String TAG = "ICUCompatIcs";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                Class[] clsArr = new Class[1];
                Class[] clsArr2 = clsArr;
                clsArr[0] = String.class;
                sGetScriptMethod = cls.getMethod("getScript", clsArr2);
                Class[] clsArr3 = new Class[1];
                Class[] clsArr4 = clsArr3;
                clsArr3[0] = String.class;
                sAddLikelySubtagsMethod = cls.getMethod("addLikelySubtags", clsArr4);
            }
        } catch (Exception e) {
            Exception exc = e;
            sGetScriptMethod = null;
            sAddLikelySubtagsMethod = null;
            int w = Log.w(TAG, exc);
        }
    }

    ICUCompatIcs() {
    }

    private static String addLikelySubtags(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (sAddLikelySubtagsMethod != null) {
                Object[] objArr = new Object[1];
                Object[] objArr2 = objArr;
                objArr[0] = locale2;
                return (String) sAddLikelySubtagsMethod.invoke(null, objArr2);
            }
        } catch (IllegalAccessException e) {
            int w = Log.w(TAG, e);
        } catch (InvocationTargetException e2) {
            int w2 = Log.w(TAG, e2);
        }
        return locale2;
    }

    private static String getScript(String str) {
        String str2 = str;
        try {
            if (sGetScriptMethod != null) {
                Object[] objArr = new Object[1];
                Object[] objArr2 = objArr;
                objArr[0] = str2;
                return (String) sGetScriptMethod.invoke(null, objArr2);
            }
        } catch (IllegalAccessException e) {
            int w = Log.w(TAG, e);
        } catch (InvocationTargetException e2) {
            int w2 = Log.w(TAG, e2);
        }
        return null;
    }

    public static String maximizeAndGetScript(Locale locale) {
        String addLikelySubtags = addLikelySubtags(locale);
        if (addLikelySubtags != null) {
            return getScript(addLikelySubtags);
        }
        return null;
    }
}
