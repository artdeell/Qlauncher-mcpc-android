package android.support.p000v4.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.animation.PathInterpolatorCompatBase */
class PathInterpolatorCompatBase {
    private PathInterpolatorCompatBase() {
    }

    public static Interpolator create(float f, float f2) {
        PathInterpolatorDonut pathInterpolatorDonut;
        PathInterpolatorDonut pathInterpolatorDonut2 = pathInterpolatorDonut;
        PathInterpolatorDonut pathInterpolatorDonut3 = new PathInterpolatorDonut(f, f2);
        return pathInterpolatorDonut2;
    }

    public static Interpolator create(float f, float f2, float f3, float f4) {
        PathInterpolatorDonut pathInterpolatorDonut;
        PathInterpolatorDonut pathInterpolatorDonut2 = pathInterpolatorDonut;
        PathInterpolatorDonut pathInterpolatorDonut3 = new PathInterpolatorDonut(f, f2, f3, f4);
        return pathInterpolatorDonut2;
    }

    public static Interpolator create(Path path) {
        PathInterpolatorDonut pathInterpolatorDonut;
        PathInterpolatorDonut pathInterpolatorDonut2 = pathInterpolatorDonut;
        PathInterpolatorDonut pathInterpolatorDonut3 = new PathInterpolatorDonut(path);
        return pathInterpolatorDonut2;
    }
}
