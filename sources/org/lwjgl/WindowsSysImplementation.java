package org.lwjgl;

import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import org.lwjgl.opengl.Display;

final class WindowsSysImplementation extends DefaultSysImplementation {
    private static final int JNI_VERSION = 24;

    static {
        Sys.initialize();
    }

    WindowsSysImplementation() {
    }

    private static long getHwnd() {
        Error error;
        C07511 r6;
        if (!Display.isCreated()) {
            return 0;
        }
        try {
            C07511 r3 = r6;
            C07511 r4 = new PrivilegedExceptionAction<Long>() {
                public Long run() throws Exception {
                    Method declaredMethod = Display.class.getDeclaredMethod("getImplementation", new Class[0]);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(null, new Object[0]);
                    Method declaredMethod2 = Class.forName("org.lwjgl.opengl.WindowsDisplay").getDeclaredMethod("getHwnd", new Class[0]);
                    declaredMethod2.setAccessible(true);
                    return (Long) declaredMethod2.invoke(invoke, new Object[0]);
                }
            };
            return ((Long) AccessController.doPrivileged(r3)).longValue();
        } catch (PrivilegedActionException e) {
            PrivilegedActionException privilegedActionException = e;
            Error error2 = error;
            Error error3 = new Error(privilegedActionException);
            throw error2;
        }
    }

    private static native void initCommonControls();

    private static native void nAlert(long j, long j2, long j3);

    private static native String nGetClipboard();

    private static native long nGetTime();

    public void alert(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (!Display.isCreated()) {
            initCommonControls();
        }
        Object[] objArr = new Object[2];
        Object[] objArr2 = objArr;
        objArr[0] = str3;
        Object[] objArr3 = objArr2;
        Object[] objArr4 = objArr3;
        objArr3[1] = str4;
        LWJGLUtil.log(String.format("*** Alert *** %s\n%s\n", objArr4));
        nAlert(getHwnd(), MemoryUtil.getAddress(MemoryUtil.encodeUTF16(str3)), MemoryUtil.getAddress(MemoryUtil.encodeUTF16(str4)));
    }

    public String getClipboard() {
        return nGetClipboard();
    }

    public int getRequiredJNIVersion() {
        return 24;
    }

    public long getTime() {
        return nGetTime();
    }

    public long getTimerResolution() {
        return 1000;
    }

    public boolean has64Bit() {
        return true;
    }

    public boolean openURL(String str) {
        StringBuilder sb;
        String str2 = str;
        try {
            String[] strArr = new String[3];
            String[] strArr2 = strArr;
            strArr[0] = "rundll32";
            String[] strArr3 = strArr2;
            String[] strArr4 = strArr3;
            strArr3[1] = "url.dll,FileProtocolHandler";
            String[] strArr5 = strArr4;
            String[] strArr6 = strArr5;
            strArr5[2] = str2;
            LWJGLUtil.execPrivileged(strArr6);
            return true;
        } catch (Exception e) {
            Exception exc = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Failed to open url (").append(str2).append("): ").append(exc.getMessage()).toString());
            return false;
        }
    }
}
