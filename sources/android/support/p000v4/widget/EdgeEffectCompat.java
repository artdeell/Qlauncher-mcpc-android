package android.support.p000v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.widget.EdgeEffectCompat */
public class EdgeEffectCompat {
    private static final EdgeEffectImpl IMPL;
    private Object mEdgeEffect;

    /* renamed from: android.support.v4.widget.EdgeEffectCompat$BaseEdgeEffectImpl */
    static class BaseEdgeEffectImpl implements EdgeEffectImpl {
        BaseEdgeEffectImpl() {
        }

        public boolean draw(Object obj, Canvas canvas) {
            Object obj2 = obj;
            Canvas canvas2 = canvas;
            return false;
        }

        public void finish(Object obj) {
        }

        public boolean isFinished(Object obj) {
            Object obj2 = obj;
            return true;
        }

        public Object newEdgeEffect(Context context) {
            Context context2 = context;
            return null;
        }

        public boolean onAbsorb(Object obj, int i) {
            Object obj2 = obj;
            int i2 = i;
            return false;
        }

        public boolean onPull(Object obj, float f) {
            Object obj2 = obj;
            float f2 = f;
            return false;
        }

        public boolean onPull(Object obj, float f, float f2) {
            Object obj2 = obj;
            float f3 = f;
            float f4 = f2;
            return false;
        }

        public boolean onRelease(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public void setSize(Object obj, int i, int i2) {
        }
    }

    /* renamed from: android.support.v4.widget.EdgeEffectCompat$EdgeEffectIcsImpl */
    static class EdgeEffectIcsImpl implements EdgeEffectImpl {
        EdgeEffectIcsImpl() {
        }

        public boolean draw(Object obj, Canvas canvas) {
            return EdgeEffectCompatIcs.draw(obj, canvas);
        }

        public void finish(Object obj) {
            EdgeEffectCompatIcs.finish(obj);
        }

        public boolean isFinished(Object obj) {
            return EdgeEffectCompatIcs.isFinished(obj);
        }

        public Object newEdgeEffect(Context context) {
            return EdgeEffectCompatIcs.newEdgeEffect(context);
        }

        public boolean onAbsorb(Object obj, int i) {
            return EdgeEffectCompatIcs.onAbsorb(obj, i);
        }

        public boolean onPull(Object obj, float f) {
            return EdgeEffectCompatIcs.onPull(obj, f);
        }

        public boolean onPull(Object obj, float f, float f2) {
            float f3 = f2;
            return EdgeEffectCompatIcs.onPull(obj, f);
        }

        public boolean onRelease(Object obj) {
            return EdgeEffectCompatIcs.onRelease(obj);
        }

        public void setSize(Object obj, int i, int i2) {
            EdgeEffectCompatIcs.setSize(obj, i, i2);
        }
    }

    /* renamed from: android.support.v4.widget.EdgeEffectCompat$EdgeEffectImpl */
    interface EdgeEffectImpl {
        boolean draw(Object obj, Canvas canvas);

        void finish(Object obj);

        boolean isFinished(Object obj);

        Object newEdgeEffect(Context context);

        boolean onAbsorb(Object obj, int i);

        boolean onPull(Object obj, float f);

        boolean onPull(Object obj, float f, float f2);

        boolean onRelease(Object obj);

        void setSize(Object obj, int i, int i2);
    }

    /* renamed from: android.support.v4.widget.EdgeEffectCompat$EdgeEffectLollipopImpl */
    static class EdgeEffectLollipopImpl extends EdgeEffectIcsImpl {
        EdgeEffectLollipopImpl() {
        }

        public boolean onPull(Object obj, float f, float f2) {
            return EdgeEffectCompatLollipop.onPull(obj, f, f2);
        }
    }

    static {
        BaseEdgeEffectImpl baseEdgeEffectImpl;
        EdgeEffectIcsImpl edgeEffectIcsImpl;
        EdgeEffectLollipopImpl edgeEffectLollipopImpl;
        if (VERSION.SDK_INT >= 21) {
            EdgeEffectLollipopImpl edgeEffectLollipopImpl2 = edgeEffectLollipopImpl;
            EdgeEffectLollipopImpl edgeEffectLollipopImpl3 = new EdgeEffectLollipopImpl();
            IMPL = edgeEffectLollipopImpl2;
        } else if (VERSION.SDK_INT >= 14) {
            EdgeEffectIcsImpl edgeEffectIcsImpl2 = edgeEffectIcsImpl;
            EdgeEffectIcsImpl edgeEffectIcsImpl3 = new EdgeEffectIcsImpl();
            IMPL = edgeEffectIcsImpl2;
        } else {
            BaseEdgeEffectImpl baseEdgeEffectImpl2 = baseEdgeEffectImpl;
            BaseEdgeEffectImpl baseEdgeEffectImpl3 = new BaseEdgeEffectImpl();
            IMPL = baseEdgeEffectImpl2;
        }
    }

    public EdgeEffectCompat(Context context) {
        this.mEdgeEffect = IMPL.newEdgeEffect(context);
    }

    public boolean draw(Canvas canvas) {
        return IMPL.draw(this.mEdgeEffect, canvas);
    }

    public void finish() {
        IMPL.finish(this.mEdgeEffect);
    }

    public boolean isFinished() {
        return IMPL.isFinished(this.mEdgeEffect);
    }

    public boolean onAbsorb(int i) {
        return IMPL.onAbsorb(this.mEdgeEffect, i);
    }

    public boolean onPull(float f) {
        return IMPL.onPull(this.mEdgeEffect, f);
    }

    public boolean onPull(float f, float f2) {
        return IMPL.onPull(this.mEdgeEffect, f, f2);
    }

    public boolean onRelease() {
        return IMPL.onRelease(this.mEdgeEffect);
    }

    public void setSize(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        IMPL.setSize(this.mEdgeEffect, i3, i4);
    }
}
