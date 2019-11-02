package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;

final class WindowsRegistry {
    static final int HKEY_CLASSES_ROOT = 1;
    static final int HKEY_CURRENT_USER = 2;
    static final int HKEY_LOCAL_MACHINE = 3;
    static final int HKEY_USERS = 4;

    static {
        Sys.initialize();
    }

    WindowsRegistry() {
    }

    private static native String nQueryRegistrationKey(int i, String str, String str2) throws LWJGLException;

    static String queryRegistrationKey(int i, String str, String str2) throws LWJGLException {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        String str3 = str;
        String str4 = str2;
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
                return nQueryRegistrationKey(i2, str3, str4);
            default:
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid enum: ").append(i2).toString());
                throw illegalArgumentException2;
        }
    }
}
