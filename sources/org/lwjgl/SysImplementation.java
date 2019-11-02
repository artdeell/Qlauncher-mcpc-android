package org.lwjgl;

interface SysImplementation {
    void alert(String str, String str2);

    String getClipboard();

    int getJNIVersion();

    int getPointerSize();

    int getRequiredJNIVersion();

    long getTime();

    long getTimerResolution();

    boolean has64Bit();

    boolean openURL(String str);

    void setDebug(boolean z);
}
