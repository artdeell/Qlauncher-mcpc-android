package org.lwjgl.opengl;

public final class DisplayMode {
    private final int bpp;
    private final int freq;
    private final boolean fullscreen;
    private final int height;
    private final int width;

    public DisplayMode(int i, int i2) {
        this(i, i2, 0, 0, false);
    }

    DisplayMode(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, true);
    }

    public DisplayMode(int i, int i2, int i3, int i4, boolean z) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        boolean z2 = z;
        this.width = i;
        this.height = i5;
        this.bpp = i6;
        this.freq = i7;
        this.fullscreen = z2;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 != null && (obj2 instanceof DisplayMode)) {
            DisplayMode displayMode = (DisplayMode) obj2;
            if (displayMode.width == this.width && displayMode.height == this.height && displayMode.bpp == this.bpp && displayMode.freq == this.freq) {
                return true;
            }
        }
        return false;
    }

    public int getBitsPerPixel() {
        return this.bpp;
    }

    public int getFrequency() {
        return this.freq;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return ((this.width ^ this.height) ^ this.freq) ^ this.bpp;
    }

    public boolean isFullscreenCapable() {
        return this.fullscreen;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(32);
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(this.width);
        StringBuilder append2 = sb4.append(" x ");
        StringBuilder append3 = sb4.append(this.height);
        StringBuilder append4 = sb4.append(" x ");
        StringBuilder append5 = sb4.append(this.bpp);
        StringBuilder append6 = sb4.append(" @");
        StringBuilder append7 = sb4.append(this.freq);
        StringBuilder append8 = sb4.append("Hz");
        return sb4.toString();
    }
}
