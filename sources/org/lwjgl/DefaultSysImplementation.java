package org.lwjgl;

abstract class DefaultSysImplementation implements SysImplementation {
    DefaultSysImplementation() {
    }

    public abstract void alert(String str, String str2);

    public abstract String getClipboard();

    public native int getJNIVersion();

    public native int getPointerSize();

    public abstract long getTime();

    public long getTimerResolution() {
        return 1000;
    }

    public boolean has64Bit() {
        return false;
    }

    public native void setDebug(boolean z);
}
