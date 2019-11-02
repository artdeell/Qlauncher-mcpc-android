package android.support.p000v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* renamed from: android.support.v4.widget.ScrollerCompat */
public class ScrollerCompat {
    static final int CHASE_FRAME_TIME = 16;
    private static final String TAG = "ScrollerCompat";
    ScrollerCompatImpl mImpl;
    Object mScroller;

    /* renamed from: android.support.v4.widget.ScrollerCompat$ScrollerCompatImpl */
    interface ScrollerCompatImpl {
        void abortAnimation(Object obj);

        boolean computeScrollOffset(Object obj);

        Object createScroller(Context context, Interpolator interpolator);

        void fling(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        void fling(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        float getCurrVelocity(Object obj);

        int getCurrX(Object obj);

        int getCurrY(Object obj);

        int getFinalX(Object obj);

        int getFinalY(Object obj);

        boolean isFinished(Object obj);

        boolean isOverScrolled(Object obj);

        void notifyHorizontalEdgeReached(Object obj, int i, int i2, int i3);

        void notifyVerticalEdgeReached(Object obj, int i, int i2, int i3);

        boolean springBack(Object obj, int i, int i2, int i3, int i4, int i5, int i6);

        void startScroll(Object obj, int i, int i2, int i3, int i4);

        void startScroll(Object obj, int i, int i2, int i3, int i4, int i5);
    }

    /* renamed from: android.support.v4.widget.ScrollerCompat$ScrollerCompatImplBase */
    static class ScrollerCompatImplBase implements ScrollerCompatImpl {
        ScrollerCompatImplBase() {
        }

        public void abortAnimation(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        public boolean computeScrollOffset(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        public Object createScroller(Context context, Interpolator interpolator) {
            Scroller scroller;
            Scroller scroller2;
            Context context2 = context;
            Interpolator interpolator2 = interpolator;
            if (interpolator2 != null) {
                Scroller scroller3 = scroller2;
                Scroller scroller4 = new Scroller(context2, interpolator2);
                return scroller3;
            }
            Scroller scroller5 = scroller;
            Scroller scroller6 = new Scroller(context2);
            return scroller5;
        }

        public void fling(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void fling(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            int i11 = i9;
            int i12 = i10;
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public float getCurrVelocity(Object obj) {
            Object obj2 = obj;
            return 0.0f;
        }

        public int getCurrX(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        public int getCurrY(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        public int getFinalX(Object obj) {
            return ((Scroller) obj).getFinalX();
        }

        public int getFinalY(Object obj) {
            return ((Scroller) obj).getFinalY();
        }

        public boolean isFinished(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        public boolean isOverScrolled(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public void notifyHorizontalEdgeReached(Object obj, int i, int i2, int i3) {
        }

        public void notifyVerticalEdgeReached(Object obj, int i, int i2, int i3) {
        }

        public boolean springBack(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            Object obj2 = obj;
            int i7 = i;
            int i8 = i2;
            int i9 = i3;
            int i10 = i4;
            int i11 = i5;
            int i12 = i6;
            return false;
        }

        public void startScroll(Object obj, int i, int i2, int i3, int i4) {
            ((Scroller) obj).startScroll(i, i2, i3, i4);
        }

        public void startScroll(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
        }
    }

    /* renamed from: android.support.v4.widget.ScrollerCompat$ScrollerCompatImplGingerbread */
    static class ScrollerCompatImplGingerbread implements ScrollerCompatImpl {
        ScrollerCompatImplGingerbread() {
        }

        public void abortAnimation(Object obj) {
            ScrollerCompatGingerbread.abortAnimation(obj);
        }

        public boolean computeScrollOffset(Object obj) {
            return ScrollerCompatGingerbread.computeScrollOffset(obj);
        }

        public Object createScroller(Context context, Interpolator interpolator) {
            return ScrollerCompatGingerbread.createScroller(context, interpolator);
        }

        public void fling(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ScrollerCompatGingerbread.fling(obj, i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void fling(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ScrollerCompatGingerbread.fling(obj, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }

        public float getCurrVelocity(Object obj) {
            Object obj2 = obj;
            return 0.0f;
        }

        public int getCurrX(Object obj) {
            return ScrollerCompatGingerbread.getCurrX(obj);
        }

        public int getCurrY(Object obj) {
            return ScrollerCompatGingerbread.getCurrY(obj);
        }

        public int getFinalX(Object obj) {
            return ScrollerCompatGingerbread.getFinalX(obj);
        }

        public int getFinalY(Object obj) {
            return ScrollerCompatGingerbread.getFinalY(obj);
        }

        public boolean isFinished(Object obj) {
            return ScrollerCompatGingerbread.isFinished(obj);
        }

        public boolean isOverScrolled(Object obj) {
            return ScrollerCompatGingerbread.isOverScrolled(obj);
        }

        public void notifyHorizontalEdgeReached(Object obj, int i, int i2, int i3) {
            ScrollerCompatGingerbread.notifyHorizontalEdgeReached(obj, i, i2, i3);
        }

        public void notifyVerticalEdgeReached(Object obj, int i, int i2, int i3) {
            ScrollerCompatGingerbread.notifyVerticalEdgeReached(obj, i, i2, i3);
        }

        public boolean springBack(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
            return ScrollerCompatGingerbread.springBack(obj, i, i2, i3, i4, i5, i6);
        }

        public void startScroll(Object obj, int i, int i2, int i3, int i4) {
            ScrollerCompatGingerbread.startScroll(obj, i, i2, i3, i4);
        }

        public void startScroll(Object obj, int i, int i2, int i3, int i4, int i5) {
            ScrollerCompatGingerbread.startScroll(obj, i, i2, i3, i4, i5);
        }
    }

    /* renamed from: android.support.v4.widget.ScrollerCompat$ScrollerCompatImplIcs */
    static class ScrollerCompatImplIcs extends ScrollerCompatImplGingerbread {
        ScrollerCompatImplIcs() {
        }

        public float getCurrVelocity(Object obj) {
            return ScrollerCompatIcs.getCurrVelocity(obj);
        }
    }

    private ScrollerCompat(int i, Context context, Interpolator interpolator) {
        ScrollerCompatImplBase scrollerCompatImplBase;
        ScrollerCompatImplGingerbread scrollerCompatImplGingerbread;
        ScrollerCompatImplIcs scrollerCompatImplIcs;
        int i2 = i;
        Context context2 = context;
        Interpolator interpolator2 = interpolator;
        if (i2 >= 14) {
            ScrollerCompatImplIcs scrollerCompatImplIcs2 = scrollerCompatImplIcs;
            ScrollerCompatImplIcs scrollerCompatImplIcs3 = new ScrollerCompatImplIcs();
            this.mImpl = scrollerCompatImplIcs2;
        } else if (i2 >= 9) {
            ScrollerCompatImplGingerbread scrollerCompatImplGingerbread2 = scrollerCompatImplGingerbread;
            ScrollerCompatImplGingerbread scrollerCompatImplGingerbread3 = new ScrollerCompatImplGingerbread();
            this.mImpl = scrollerCompatImplGingerbread2;
        } else {
            ScrollerCompatImplBase scrollerCompatImplBase2 = scrollerCompatImplBase;
            ScrollerCompatImplBase scrollerCompatImplBase3 = new ScrollerCompatImplBase();
            this.mImpl = scrollerCompatImplBase2;
        }
        this.mScroller = this.mImpl.createScroller(context2, interpolator2);
    }

    ScrollerCompat(Context context, Interpolator interpolator) {
        this(VERSION.SDK_INT, context, interpolator);
    }

    public static ScrollerCompat create(Context context) {
        return create(context, null);
    }

    public static ScrollerCompat create(Context context, Interpolator interpolator) {
        ScrollerCompat scrollerCompat;
        ScrollerCompat scrollerCompat2 = scrollerCompat;
        ScrollerCompat scrollerCompat3 = new ScrollerCompat(context, interpolator);
        return scrollerCompat2;
    }

    public void abortAnimation() {
        this.mImpl.abortAnimation(this.mScroller);
    }

    public boolean computeScrollOffset() {
        return this.mImpl.computeScrollOffset(this.mScroller);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.mImpl.fling(this.mScroller, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.mImpl.fling(this.mScroller, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public float getCurrVelocity() {
        return this.mImpl.getCurrVelocity(this.mScroller);
    }

    public int getCurrX() {
        return this.mImpl.getCurrX(this.mScroller);
    }

    public int getCurrY() {
        return this.mImpl.getCurrY(this.mScroller);
    }

    public int getFinalX() {
        return this.mImpl.getFinalX(this.mScroller);
    }

    public int getFinalY() {
        return this.mImpl.getFinalY(this.mScroller);
    }

    public boolean isFinished() {
        return this.mImpl.isFinished(this.mScroller);
    }

    public boolean isOverScrolled() {
        return this.mImpl.isOverScrolled(this.mScroller);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.mImpl.notifyHorizontalEdgeReached(this.mScroller, i, i2, i3);
    }

    public void notifyVerticalEdgeReached(int i, int i2, int i3) {
        this.mImpl.notifyVerticalEdgeReached(this.mScroller, i, i2, i3);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.mImpl.springBack(this.mScroller, i, i2, i3, i4, i5, i6);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        this.mImpl.startScroll(this.mScroller, i, i2, i3, i4);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mImpl.startScroll(this.mScroller, i, i2, i3, i4, i5);
    }
}
