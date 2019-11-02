package android.support.p000v4.view.animation;

import android.graphics.Path;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.animation.PathInterpolatorCompat */
public class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static Interpolator create(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        return VERSION.SDK_INT >= 21 ? PathInterpolatorCompatApi21.create(f3, f4) : PathInterpolatorCompatBase.create(f3, f4);
    }

    public static Interpolator create(float f, float f2, float f3, float f4) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        return VERSION.SDK_INT >= 21 ? PathInterpolatorCompatApi21.create(f5, f6, f7, f8) : PathInterpolatorCompatBase.create(f5, f6, f7, f8);
    }

    public static Interpolator create(Path path) {
        Path path2 = path;
        return VERSION.SDK_INT >= 21 ? PathInterpolatorCompatApi21.create(path2) : PathInterpolatorCompatBase.create(path2);
    }
}
