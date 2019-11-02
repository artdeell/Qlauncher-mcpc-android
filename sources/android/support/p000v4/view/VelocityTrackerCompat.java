package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

/* renamed from: android.support.v4.view.VelocityTrackerCompat */
public class VelocityTrackerCompat {
    static final VelocityTrackerVersionImpl IMPL;

    /* renamed from: android.support.v4.view.VelocityTrackerCompat$BaseVelocityTrackerVersionImpl */
    static class BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        BaseVelocityTrackerVersionImpl() {
        }

        public float getXVelocity(VelocityTracker velocityTracker, int i) {
            int i2 = i;
            return velocityTracker.getXVelocity();
        }

        public float getYVelocity(VelocityTracker velocityTracker, int i) {
            int i2 = i;
            return velocityTracker.getYVelocity();
        }
    }

    /* renamed from: android.support.v4.view.VelocityTrackerCompat$HoneycombVelocityTrackerVersionImpl */
    static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        HoneycombVelocityTrackerVersionImpl() {
        }

        public float getXVelocity(VelocityTracker velocityTracker, int i) {
            return VelocityTrackerCompatHoneycomb.getXVelocity(velocityTracker, i);
        }

        public float getYVelocity(VelocityTracker velocityTracker, int i) {
            return VelocityTrackerCompatHoneycomb.getYVelocity(velocityTracker, i);
        }
    }

    /* renamed from: android.support.v4.view.VelocityTrackerCompat$VelocityTrackerVersionImpl */
    interface VelocityTrackerVersionImpl {
        float getXVelocity(VelocityTracker velocityTracker, int i);

        float getYVelocity(VelocityTracker velocityTracker, int i);
    }

    static {
        BaseVelocityTrackerVersionImpl baseVelocityTrackerVersionImpl;
        HoneycombVelocityTrackerVersionImpl honeycombVelocityTrackerVersionImpl;
        if (VERSION.SDK_INT >= 11) {
            HoneycombVelocityTrackerVersionImpl honeycombVelocityTrackerVersionImpl2 = honeycombVelocityTrackerVersionImpl;
            HoneycombVelocityTrackerVersionImpl honeycombVelocityTrackerVersionImpl3 = new HoneycombVelocityTrackerVersionImpl();
            IMPL = honeycombVelocityTrackerVersionImpl2;
            return;
        }
        BaseVelocityTrackerVersionImpl baseVelocityTrackerVersionImpl2 = baseVelocityTrackerVersionImpl;
        BaseVelocityTrackerVersionImpl baseVelocityTrackerVersionImpl3 = new BaseVelocityTrackerVersionImpl();
        IMPL = baseVelocityTrackerVersionImpl2;
    }

    public VelocityTrackerCompat() {
    }

    public static float getXVelocity(VelocityTracker velocityTracker, int i) {
        return IMPL.getXVelocity(velocityTracker, i);
    }

    public static float getYVelocity(VelocityTracker velocityTracker, int i) {
        return IMPL.getYVelocity(velocityTracker, i);
    }
}
