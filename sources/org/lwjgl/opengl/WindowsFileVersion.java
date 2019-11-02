package org.lwjgl.opengl;

final class WindowsFileVersion {
    private final int product_version_ls;
    private final int product_version_ms;

    WindowsFileVersion(int i, int i2) {
        int i3 = i2;
        this.product_version_ms = i;
        this.product_version_ls = i3;
    }

    public String toString() {
        StringBuilder sb;
        int i = 65535 & (this.product_version_ms >> 16);
        int i2 = 65535 & this.product_version_ms;
        int i3 = 65535 & (this.product_version_ls >> 16);
        int i4 = 65535 & this.product_version_ls;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(i).append(".").append(i2).append(".").append(i3).append(".").append(i4).toString();
    }
}
