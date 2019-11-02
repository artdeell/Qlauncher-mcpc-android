package org.lwjgl;

import java.awt.Toolkit;
import java.security.AccessController;
import java.security.PrivilegedAction;

final class LinuxSysImplementation extends J2SESysImplementation {
    private static final int JNI_VERSION = 19;

    static {
        C07451 r2;
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        C07451 r0 = r2;
        C07451 r1 = new PrivilegedAction<Object>() {
            public Object run() {
                try {
                    System.loadLibrary("jawt");
                } catch (UnsatisfiedLinkError e) {
                    UnsatisfiedLinkError unsatisfiedLinkError = e;
                }
                return null;
            }
        };
        Object doPrivileged = AccessController.doPrivileged(r0);
    }

    LinuxSysImplementation() {
    }

    public int getRequiredJNIVersion() {
        return 19;
    }

    public boolean has64Bit() {
        return true;
    }

    public boolean openURL(String str) {
        String str2 = str;
        String[] strArr = new String[12];
        String[] strArr2 = strArr;
        strArr[0] = "sensible-browser";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "xdg-open";
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = "google-chrome";
        String[] strArr7 = strArr6;
        String[] strArr8 = strArr7;
        strArr7[3] = "chromium";
        String[] strArr9 = strArr8;
        String[] strArr10 = strArr9;
        strArr9[4] = "firefox";
        String[] strArr11 = strArr10;
        String[] strArr12 = strArr11;
        strArr11[5] = "iceweasel";
        String[] strArr13 = strArr12;
        String[] strArr14 = strArr13;
        strArr13[6] = "mozilla";
        String[] strArr15 = strArr14;
        String[] strArr16 = strArr15;
        strArr15[7] = "opera";
        String[] strArr17 = strArr16;
        String[] strArr18 = strArr17;
        strArr17[8] = "konqueror";
        String[] strArr19 = strArr18;
        String[] strArr20 = strArr19;
        strArr19[9] = "nautilus";
        String[] strArr21 = strArr20;
        String[] strArr22 = strArr21;
        strArr21[10] = "galeon";
        String[] strArr23 = strArr22;
        String[] strArr24 = strArr23;
        strArr23[11] = "netscape";
        String[] strArr25 = strArr24;
        int length = strArr25.length;
        int i = 0;
        while (i < length) {
            try {
                String[] strArr26 = new String[2];
                String[] strArr27 = strArr26;
                strArr26[0] = strArr25[i];
                String[] strArr28 = strArr27;
                String[] strArr29 = strArr28;
                strArr28[1] = str2;
                LWJGLUtil.execPrivileged(strArr29);
                return true;
            } catch (Exception e) {
                e.printStackTrace(System.err);
                i++;
            }
        }
        return false;
    }
}
