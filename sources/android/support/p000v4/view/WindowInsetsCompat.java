package android.support.p000v4.view;

import android.graphics.Rect;

/* renamed from: android.support.v4.view.WindowInsetsCompat */
public class WindowInsetsCompat {
    WindowInsetsCompat() {
    }

    public WindowInsetsCompat consumeStableInsets() {
        return this;
    }

    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this;
    }

    public int getStableInsetBottom() {
        return 0;
    }

    public int getStableInsetLeft() {
        return 0;
    }

    public int getStableInsetRight() {
        return 0;
    }

    public int getStableInsetTop() {
        return 0;
    }

    public int getSystemWindowInsetBottom() {
        return 0;
    }

    public int getSystemWindowInsetLeft() {
        return 0;
    }

    public int getSystemWindowInsetRight() {
        return 0;
    }

    public int getSystemWindowInsetTop() {
        return 0;
    }

    public boolean hasInsets() {
        return false;
    }

    public boolean hasStableInsets() {
        return false;
    }

    public boolean hasSystemWindowInsets() {
        return false;
    }

    public boolean isConsumed() {
        return false;
    }

    public boolean isRound() {
        return false;
    }

    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        return this;
    }

    public WindowInsetsCompat replaceSystemWindowInsets(Rect rect) {
        Rect rect2 = rect;
        return this;
    }
}
