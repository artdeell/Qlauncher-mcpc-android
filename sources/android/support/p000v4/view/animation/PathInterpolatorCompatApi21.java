package android.support.p000v4.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* renamed from: android.support.v4.view.animation.PathInterpolatorCompatApi21 */
class PathInterpolatorCompatApi21 {
    private PathInterpolatorCompatApi21() {
    }

    public static Interpolator create(float f, float f2) {
        PathInterpolator pathInterpolator;
        PathInterpolator pathInterpolator2 = pathInterpolator;
        PathInterpolator pathInterpolator3 = new PathInterpolator(f, f2);
        return pathInterpolator2;
    }

    public static Interpolator create(float f, float f2, float f3, float f4) {
        PathInterpolator pathInterpolator;
        PathInterpolator pathInterpolator2 = pathInterpolator;
        PathInterpolator pathInterpolator3 = new PathInterpolator(f, f2, f3, f4);
        return pathInterpolator2;
    }

    public static Interpolator create(Path path) {
        PathInterpolator pathInterpolator;
        PathInterpolator pathInterpolator2 = pathInterpolator;
        PathInterpolator pathInterpolator3 = new PathInterpolator(path);
        return pathInterpolator2;
    }
}
