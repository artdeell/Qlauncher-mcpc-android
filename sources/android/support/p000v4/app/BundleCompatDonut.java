package android.support.p000v4.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.app.BundleCompatDonut */
class BundleCompatDonut {
    private static final String TAG = "BundleCompatDonut";
    private static Method sGetIBinderMethod;
    private static boolean sGetIBinderMethodFetched;
    private static Method sPutIBinderMethod;
    private static boolean sPutIBinderMethodFetched;

    BundleCompatDonut() {
    }

    public static IBinder getBinder(Bundle bundle, String str) {
        Throwable th;
        Bundle bundle2 = bundle;
        String str2 = str;
        if (!sGetIBinderMethodFetched) {
            Class<Bundle> cls = Bundle.class;
            String str3 = "getIBinder";
            try {
                Class[] clsArr = new Class[1];
                Class[] clsArr2 = clsArr;
                clsArr[0] = String.class;
                sGetIBinderMethod = cls.getMethod(str3, clsArr2);
                sGetIBinderMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                int i = Log.i(TAG, "Failed to retrieve getIBinder method", e);
            }
            sGetIBinderMethodFetched = true;
        }
        if (sGetIBinderMethod != null) {
            try {
                Method method = sGetIBinderMethod;
                Bundle bundle3 = bundle2;
                Object[] objArr = new Object[1];
                Object[] objArr2 = objArr;
                objArr[0] = str2;
                return (IBinder) method.invoke(bundle3, objArr2);
            } catch (InvocationTargetException e2) {
                th = e2;
                int i2 = Log.i(TAG, "Failed to invoke getIBinder via reflection", th);
                sGetIBinderMethod = null;
                return null;
            } catch (IllegalAccessException e3) {
                th = e3;
                int i22 = Log.i(TAG, "Failed to invoke getIBinder via reflection", th);
                sGetIBinderMethod = null;
                return null;
            } catch (IllegalArgumentException e4) {
                th = e4;
                int i222 = Log.i(TAG, "Failed to invoke getIBinder via reflection", th);
                sGetIBinderMethod = null;
                return null;
            }
        }
        return null;
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        Throwable th;
        Bundle bundle2 = bundle;
        String str2 = str;
        IBinder iBinder2 = iBinder;
        if (!sPutIBinderMethodFetched) {
            Class<Bundle> cls = Bundle.class;
            String str3 = "putIBinder";
            try {
                Class[] clsArr = new Class[2];
                Class[] clsArr2 = clsArr;
                clsArr[0] = String.class;
                Class[] clsArr3 = clsArr2;
                Class[] clsArr4 = clsArr3;
                clsArr3[1] = IBinder.class;
                sPutIBinderMethod = cls.getMethod(str3, clsArr4);
                sPutIBinderMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                int i = Log.i(TAG, "Failed to retrieve putIBinder method", e);
            }
            sPutIBinderMethodFetched = true;
        }
        if (sPutIBinderMethod != null) {
            try {
                Method method = sPutIBinderMethod;
                Bundle bundle3 = bundle2;
                Object[] objArr = new Object[2];
                Object[] objArr2 = objArr;
                objArr[0] = str2;
                Object[] objArr3 = objArr2;
                Object[] objArr4 = objArr3;
                objArr3[1] = iBinder2;
                Object invoke = method.invoke(bundle3, objArr4);
                return;
            } catch (InvocationTargetException e2) {
                th = e2;
            } catch (IllegalAccessException e3) {
                th = e3;
            } catch (IllegalArgumentException e4) {
                th = e4;
            }
        } else {
            return;
        }
        int i2 = Log.i(TAG, "Failed to invoke putIBinder via reflection", th);
        sPutIBinderMethod = null;
    }
}
