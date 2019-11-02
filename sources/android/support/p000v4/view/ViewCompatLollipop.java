package android.support.p000v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* renamed from: android.support.v4.view.ViewCompatLollipop */
class ViewCompatLollipop {
    ViewCompatLollipop() {
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.support.v4.view.WindowInsetsCompat] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p000v4.view.WindowInsetsCompat dispatchApplyWindowInsets(android.view.View r8, android.support.p000v4.view.WindowInsetsCompat r9) {
        /*
            r0 = r8
            r1 = r9
            r4 = r1
            boolean r4 = r4 instanceof android.support.p000v4.view.WindowInsetsCompatApi21
            if (r4 == 0) goto L_0x0024
            r4 = r1
            android.support.v4.view.WindowInsetsCompatApi21 r4 = (android.support.p000v4.view.WindowInsetsCompatApi21) r4
            android.view.WindowInsets r4 = r4.unwrap()
            r2 = r4
            r4 = r0
            r5 = r2
            android.view.WindowInsets r4 = r4.dispatchApplyWindowInsets(r5)
            r3 = r4
            r4 = r3
            r5 = r2
            if (r4 == r5) goto L_0x0024
            android.support.v4.view.WindowInsetsCompatApi21 r4 = new android.support.v4.view.WindowInsetsCompatApi21
            r7 = r4
            r4 = r7
            r5 = r7
            r6 = r3
            r5.<init>(r6)
            r1 = r4
        L_0x0024:
            r4 = r1
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.ViewCompatLollipop.dispatchApplyWindowInsets(android.view.View, android.support.v4.view.WindowInsetsCompat):android.support.v4.view.WindowInsetsCompat");
    }

    public static boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
        return view.dispatchNestedFling(f, f2, z);
    }

    public static boolean dispatchNestedPreFling(View view, float f, float f2) {
        return view.dispatchNestedPreFling(f, f2);
    }

    public static boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public static boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
        return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    static ColorStateList getBackgroundTintList(View view) {
        return view.getBackgroundTintList();
    }

    static Mode getBackgroundTintMode(View view) {
        return view.getBackgroundTintMode();
    }

    public static float getElevation(View view) {
        return view.getElevation();
    }

    public static String getTransitionName(View view) {
        return view.getTransitionName();
    }

    public static float getTranslationZ(View view) {
        return view.getTranslationZ();
    }

    public static float getZ(View view) {
        return view.getZ();
    }

    public static boolean hasNestedScrollingParent(View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean isImportantForAccessibility(View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return view.isNestedScrollingEnabled();
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.support.v4.view.WindowInsetsCompat] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p000v4.view.WindowInsetsCompat onApplyWindowInsets(android.view.View r8, android.support.p000v4.view.WindowInsetsCompat r9) {
        /*
            r0 = r8
            r1 = r9
            r4 = r1
            boolean r4 = r4 instanceof android.support.p000v4.view.WindowInsetsCompatApi21
            if (r4 == 0) goto L_0x0024
            r4 = r1
            android.support.v4.view.WindowInsetsCompatApi21 r4 = (android.support.p000v4.view.WindowInsetsCompatApi21) r4
            android.view.WindowInsets r4 = r4.unwrap()
            r2 = r4
            r4 = r0
            r5 = r2
            android.view.WindowInsets r4 = r4.onApplyWindowInsets(r5)
            r3 = r4
            r4 = r3
            r5 = r2
            if (r4 == r5) goto L_0x0024
            android.support.v4.view.WindowInsetsCompatApi21 r4 = new android.support.v4.view.WindowInsetsCompatApi21
            r7 = r4
            r4 = r7
            r5 = r7
            r6 = r3
            r5.<init>(r6)
            r1 = r4
        L_0x0024:
            r4 = r1
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.ViewCompatLollipop.onApplyWindowInsets(android.view.View, android.support.v4.view.WindowInsetsCompat):android.support.v4.view.WindowInsetsCompat");
    }

    public static void requestApplyInsets(View view) {
        view.requestApplyInsets();
    }

    static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    static void setBackgroundTintMode(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void setElevation(View view, float f) {
        view.setElevation(f);
    }

    public static void setNestedScrollingEnabled(View view, boolean z) {
        view.setNestedScrollingEnabled(z);
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        C01091 r6;
        View view2 = view;
        C01091 r3 = r6;
        final OnApplyWindowInsetsListener onApplyWindowInsetsListener2 = onApplyWindowInsetsListener;
        C01091 r4 = new OnApplyWindowInsetsListener() {
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsetsCompatApi21 windowInsetsCompatApi21;
                View view2 = view;
                WindowInsetsCompatApi21 windowInsetsCompatApi212 = windowInsetsCompatApi21;
                WindowInsetsCompatApi21 windowInsetsCompatApi213 = new WindowInsetsCompatApi21(windowInsets);
                return ((WindowInsetsCompatApi21) onApplyWindowInsetsListener2.onApplyWindowInsets(view2, windowInsetsCompatApi212)).unwrap();
            }
        };
        view2.setOnApplyWindowInsetsListener(r3);
    }

    public static void setTransitionName(View view, String str) {
        view.setTransitionName(str);
    }

    public static void setTranslationZ(View view, float f) {
        view.setTranslationZ(f);
    }

    public static boolean startNestedScroll(View view, int i) {
        return view.startNestedScroll(i);
    }

    public static void stopNestedScroll(View view) {
        view.stopNestedScroll();
    }
}
