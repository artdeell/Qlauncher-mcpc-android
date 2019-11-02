package android.support.p000v4.view;

import android.graphics.Rect;
import android.view.WindowInsets;

/* renamed from: android.support.v4.view.WindowInsetsCompatApi21 */
class WindowInsetsCompatApi21 extends WindowInsetsCompat {
    private final WindowInsets mSource;

    WindowInsetsCompatApi21(WindowInsets windowInsets) {
        this.mSource = windowInsets;
    }

    public WindowInsetsCompat consumeStableInsets() {
        WindowInsetsCompatApi21 windowInsetsCompatApi21;
        WindowInsetsCompatApi21 windowInsetsCompatApi212 = windowInsetsCompatApi21;
        WindowInsetsCompatApi21 windowInsetsCompatApi213 = new WindowInsetsCompatApi21(this.mSource.consumeStableInsets());
        return windowInsetsCompatApi212;
    }

    public WindowInsetsCompat consumeSystemWindowInsets() {
        WindowInsetsCompatApi21 windowInsetsCompatApi21;
        WindowInsetsCompatApi21 windowInsetsCompatApi212 = windowInsetsCompatApi21;
        WindowInsetsCompatApi21 windowInsetsCompatApi213 = new WindowInsetsCompatApi21(this.mSource.consumeSystemWindowInsets());
        return windowInsetsCompatApi212;
    }

    public int getStableInsetBottom() {
        return this.mSource.getStableInsetBottom();
    }

    public int getStableInsetLeft() {
        return this.mSource.getStableInsetLeft();
    }

    public int getStableInsetRight() {
        return this.mSource.getStableInsetRight();
    }

    public int getStableInsetTop() {
        return this.mSource.getStableInsetTop();
    }

    public int getSystemWindowInsetBottom() {
        return this.mSource.getSystemWindowInsetBottom();
    }

    public int getSystemWindowInsetLeft() {
        return this.mSource.getSystemWindowInsetLeft();
    }

    public int getSystemWindowInsetRight() {
        return this.mSource.getSystemWindowInsetRight();
    }

    public int getSystemWindowInsetTop() {
        return this.mSource.getSystemWindowInsetTop();
    }

    public boolean hasInsets() {
        return this.mSource.hasInsets();
    }

    public boolean hasStableInsets() {
        return this.mSource.hasStableInsets();
    }

    public boolean hasSystemWindowInsets() {
        return this.mSource.hasSystemWindowInsets();
    }

    public boolean isConsumed() {
        return this.mSource.isConsumed();
    }

    public boolean isRound() {
        return this.mSource.isRound();
    }

    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        WindowInsetsCompatApi21 windowInsetsCompatApi21;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        WindowInsetsCompatApi21 windowInsetsCompatApi212 = windowInsetsCompatApi21;
        WindowInsetsCompatApi21 windowInsetsCompatApi213 = new WindowInsetsCompatApi21(this.mSource.replaceSystemWindowInsets(i5, i6, i7, i8));
        return windowInsetsCompatApi212;
    }

    public WindowInsetsCompat replaceSystemWindowInsets(Rect rect) {
        WindowInsetsCompatApi21 windowInsetsCompatApi21;
        Rect rect2 = rect;
        WindowInsetsCompatApi21 windowInsetsCompatApi212 = windowInsetsCompatApi21;
        WindowInsetsCompatApi21 windowInsetsCompatApi213 = new WindowInsetsCompatApi21(this.mSource.replaceSystemWindowInsets(rect2));
        return windowInsetsCompatApi212;
    }

    /* access modifiers changed from: 0000 */
    public WindowInsets unwrap() {
        return this.mSource;
    }
}
