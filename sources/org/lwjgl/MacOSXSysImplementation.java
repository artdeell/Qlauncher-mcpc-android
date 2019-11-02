package org.lwjgl;

import com.apple.eio.FileManager;
import java.awt.Toolkit;

final class MacOSXSysImplementation extends J2SESysImplementation {
    private static final int JNI_VERSION = 25;

    static {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
    }

    MacOSXSysImplementation() {
    }

    public int getRequiredJNIVersion() {
        return 25;
    }

    public boolean openURL(String str) {
        StringBuilder sb;
        try {
            FileManager.openURL(str);
            return true;
        } catch (Exception e) {
            Exception exc = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Exception occurred while trying to invoke browser: ").append(exc).toString());
            return false;
        }
    }
}
