package org.lwjgl;

final class AndroidSysImplementation implements SysImplementation {
    private static final int JNI_VERSION = 19;

    AndroidSysImplementation() {
    }

    public void alert(String str, String str2) {
    }

    public String getClipboard() {
        return null;
    }

    public int getJNIVersion() {
        return 19;
    }

    public int getPointerSize() {
        return 4;
    }

    public int getRequiredJNIVersion() {
        return 19;
    }

    public long getTime() {
        return System.currentTimeMillis();
    }

    public long getTimerResolution() {
        return 1000;
    }

    public boolean has64Bit() {
        return false;
    }

    public boolean openURL(String str) {
        String str2 = str;
        return false;
    }

    public void setDebug(boolean z) {
    }
}
