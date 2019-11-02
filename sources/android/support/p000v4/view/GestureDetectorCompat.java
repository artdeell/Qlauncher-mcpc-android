package android.support.p000v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.view.GestureDetectorCompat */
public class GestureDetectorCompat {
    private final GestureDetectorCompatImpl mImpl;

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImpl */
    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener);
    }

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase */
    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        private static final int LONG_PRESS = 2;
        private static final int SHOW_PRESS = 1;
        private static final int TAP = 3;
        private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        private boolean mAlwaysInBiggerTapRegion;
        private boolean mAlwaysInTapRegion;
        /* access modifiers changed from: private */
        public MotionEvent mCurrentDownEvent;
        private boolean mDeferConfirmSingleTap;
        /* access modifiers changed from: private */
        public OnDoubleTapListener mDoubleTapListener;
        private int mDoubleTapSlopSquare;
        private float mDownFocusX;
        private float mDownFocusY;
        private final Handler mHandler;
        private boolean mInLongPress;
        private boolean mIsDoubleTapping;
        private boolean mIsLongpressEnabled;
        private float mLastFocusX;
        private float mLastFocusY;
        /* access modifiers changed from: private */
        public final OnGestureListener mListener;
        private int mMaximumFlingVelocity;
        private int mMinimumFlingVelocity;
        private MotionEvent mPreviousUpEvent;
        /* access modifiers changed from: private */
        public boolean mStillDown;
        private int mTouchSlopSquare;
        private VelocityTracker mVelocityTracker;

        /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler */
        private class GestureHandler extends Handler {
            final /* synthetic */ GestureDetectorCompatImplBase this$0;

            GestureHandler(GestureDetectorCompatImplBase gestureDetectorCompatImplBase) {
                this.this$0 = gestureDetectorCompatImplBase;
            }

            GestureHandler(GestureDetectorCompatImplBase gestureDetectorCompatImplBase, Handler handler) {
                Handler handler2 = handler;
                this.this$0 = gestureDetectorCompatImplBase;
                super(handler2.getLooper());
            }

            public void handleMessage(Message message) {
                RuntimeException runtimeException;
                StringBuilder sb;
                Message message2 = message;
                switch (message2.what) {
                    case 1:
                        this.this$0.mListener.onShowPress(this.this$0.mCurrentDownEvent);
                        return;
                    case 2:
                        this.this$0.dispatchLongPress();
                        return;
                    case 3:
                        if (this.this$0.mDoubleTapListener == null) {
                            return;
                        }
                        if (!this.this$0.mStillDown) {
                            boolean onSingleTapConfirmed = this.this$0.mDoubleTapListener.onSingleTapConfirmed(this.this$0.mCurrentDownEvent);
                            return;
                        } else {
                            boolean access$502 = GestureDetectorCompatImplBase.access$502(this.this$0, true);
                            return;
                        }
                    default:
                        RuntimeException runtimeException2 = runtimeException;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        RuntimeException runtimeException3 = new RuntimeException(sb2.append("Unknown message ").append(message2).toString());
                        throw runtimeException2;
                }
            }
        }

        public GestureDetectorCompatImplBase(Context context, OnGestureListener onGestureListener, Handler handler) {
            GestureHandler gestureHandler;
            GestureHandler gestureHandler2;
            Context context2 = context;
            OnGestureListener onGestureListener2 = onGestureListener;
            Handler handler2 = handler;
            if (handler2 != null) {
                GestureHandler gestureHandler3 = gestureHandler2;
                GestureHandler gestureHandler4 = new GestureHandler(this, handler2);
                this.mHandler = gestureHandler3;
            } else {
                GestureHandler gestureHandler5 = gestureHandler;
                GestureHandler gestureHandler6 = new GestureHandler(this);
                this.mHandler = gestureHandler5;
            }
            this.mListener = onGestureListener2;
            if (onGestureListener2 instanceof OnDoubleTapListener) {
                setOnDoubleTapListener((OnDoubleTapListener) onGestureListener2);
            }
            init(context2);
        }

        static /* synthetic */ boolean access$502(GestureDetectorCompatImplBase gestureDetectorCompatImplBase, boolean z) {
            boolean z2 = z;
            gestureDetectorCompatImplBase.mDeferConfirmSingleTap = z2;
            return z2;
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void cancelTaps() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        /* access modifiers changed from: private */
        public void dispatchLongPress() {
            this.mHandler.removeMessages(3);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }

        private void init(Context context) {
            IllegalArgumentException illegalArgumentException;
            IllegalArgumentException illegalArgumentException2;
            Context context2 = context;
            if (context2 == null) {
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Context must not be null");
                throw illegalArgumentException3;
            } else if (this.mListener == null) {
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("OnGestureListener must not be null");
                throw illegalArgumentException5;
            } else {
                this.mIsLongpressEnabled = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
                this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
            }
        }

        private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            MotionEvent motionEvent4 = motionEvent;
            MotionEvent motionEvent5 = motionEvent2;
            MotionEvent motionEvent6 = motionEvent3;
            if (this.mAlwaysInBiggerTapRegion && motionEvent6.getEventTime() - motionEvent5.getEventTime() <= ((long) DOUBLE_TAP_TIMEOUT)) {
                int x = ((int) motionEvent4.getX()) - ((int) motionEvent6.getX());
                int y = ((int) motionEvent4.getY()) - ((int) motionEvent6.getY());
                if ((x * x) + (y * y) < this.mDoubleTapSlopSquare) {
                    return true;
                }
            }
            return false;
        }

        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:73:0x04ea, code lost:
            if (java.lang.Math.abs(r26) >= 1.0f) goto L_0x04ec;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0699, code lost:
            if (java.lang.Math.abs(r20) > ((float) r2.mMinimumFlingVelocity)) goto L_0x069b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r53) {
            /*
                r52 = this;
                r2 = r52
                r3 = r53
                r46 = r3
                int r46 = r46.getAction()
                r4 = r46
                r46 = r2
                r0 = r46
                android.view.VelocityTracker r0 = r0.mVelocityTracker
                r46 = r0
                if (r46 != 0) goto L_0x0022
                r46 = r2
                android.view.VelocityTracker r47 = android.view.VelocityTracker.obtain()
                r0 = r47
                r1 = r46
                r1.mVelocityTracker = r0
            L_0x0022:
                r46 = r2
                r0 = r46
                android.view.VelocityTracker r0 = r0.mVelocityTracker
                r46 = r0
                r47 = r3
                r46.addMovement(r47)
                r46 = r4
                r47 = 255(0xff, float:3.57E-43)
                r0 = r46
                r0 = r0 & 255(0xff, float:3.57E-43)
                r46 = r0
                r47 = 6
                r0 = r46
                r1 = r47
                if (r0 != r1) goto L_0x007c
                r46 = 1
                r5 = r46
            L_0x0045:
                r46 = r5
                if (r46 == 0) goto L_0x0081
                r46 = r3
                int r46 = android.support.p000v4.view.MotionEventCompat.getActionIndex(r46)
                r6 = r46
            L_0x0051:
                r46 = 0
                r7 = r46
                r46 = 0
                r8 = r46
                r46 = r3
                int r46 = android.support.p000v4.view.MotionEventCompat.getPointerCount(r46)
                r9 = r46
                r46 = 0
                r10 = r46
            L_0x0065:
                r46 = r10
                r47 = r9
                r0 = r46
                r1 = r47
                if (r0 >= r1) goto L_0x00a3
                r46 = r6
                r47 = r10
                r0 = r46
                r1 = r47
                if (r0 != r1) goto L_0x0086
            L_0x0079:
                int r10 = r10 + 1
                goto L_0x0065
            L_0x007c:
                r46 = 0
                r5 = r46
                goto L_0x0045
            L_0x0081:
                r46 = -1
                r6 = r46
                goto L_0x0051
            L_0x0086:
                r46 = r7
                r47 = r3
                r48 = r10
                float r47 = android.support.p000v4.view.MotionEventCompat.getX(r47, r48)
                float r46 = r46 + r47
                r7 = r46
                r46 = r8
                r47 = r3
                r48 = r10
                float r47 = android.support.p000v4.view.MotionEventCompat.getY(r47, r48)
                float r46 = r46 + r47
                r8 = r46
                goto L_0x0079
            L_0x00a3:
                r46 = r5
                if (r46 == 0) goto L_0x00e3
                r46 = r9
                r47 = 1
                int r46 = r46 + -1
                r11 = r46
            L_0x00af:
                r46 = r7
                r47 = r11
                r0 = r47
                float r0 = (float) r0
                r47 = r0
                float r46 = r46 / r47
                r12 = r46
                r46 = r8
                r47 = r11
                r0 = r47
                float r0 = (float) r0
                r47 = r0
                float r46 = r46 / r47
                r13 = r46
                r46 = r4
                r47 = 255(0xff, float:3.57E-43)
                r0 = r46
                r0 = r0 & 255(0xff, float:3.57E-43)
                r46 = r0
                r14 = r46
                r46 = 0
                r15 = r46
                r46 = r14
                switch(r46) {
                    case 0: goto L_0x01f8;
                    case 1: goto L_0x0522;
                    case 2: goto L_0x03a5;
                    case 3: goto L_0x06b9;
                    case 4: goto L_0x00de;
                    case 5: goto L_0x00e8;
                    case 6: goto L_0x011a;
                    default: goto L_0x00de;
                }
            L_0x00de:
                r46 = r15
                r2 = r46
            L_0x00e2:
                return r2
            L_0x00e3:
                r46 = r9
                r11 = r46
                goto L_0x00af
            L_0x00e8:
                r46 = r2
                r47 = r12
                r0 = r47
                r1 = r46
                r1.mLastFocusX = r0
                r46 = r2
                r47 = r12
                r0 = r47
                r1 = r46
                r1.mDownFocusX = r0
                r46 = r2
                r47 = r13
                r0 = r47
                r1 = r46
                r1.mLastFocusY = r0
                r46 = r2
                r47 = r13
                r0 = r47
                r1 = r46
                r1.mDownFocusY = r0
                r46 = r2
                r46.cancelTaps()
                r46 = 0
                r2 = r46
                goto L_0x00e2
            L_0x011a:
                r46 = r2
                r47 = r12
                r0 = r47
                r1 = r46
                r1.mLastFocusX = r0
                r46 = r2
                r47 = r12
                r0 = r47
                r1 = r46
                r1.mDownFocusX = r0
                r46 = r2
                r47 = r13
                r0 = r47
                r1 = r46
                r1.mLastFocusY = r0
                r46 = r2
                r47 = r13
                r0 = r47
                r1 = r46
                r1.mDownFocusY = r0
                r46 = r2
                r0 = r46
                android.view.VelocityTracker r0 = r0.mVelocityTracker
                r46 = r0
                r47 = 1000(0x3e8, float:1.401E-42)
                r48 = r2
                r0 = r48
                int r0 = r0.mMaximumFlingVelocity
                r48 = r0
                r0 = r48
                float r0 = (float) r0
                r48 = r0
                r46.computeCurrentVelocity(r47, r48)
                r46 = r3
                int r46 = android.support.p000v4.view.MotionEventCompat.getActionIndex(r46)
                r39 = r46
                r46 = r3
                r47 = r39
                int r46 = android.support.p000v4.view.MotionEventCompat.getPointerId(r46, r47)
                r40 = r46
                r46 = r2
                r0 = r46
                android.view.VelocityTracker r0 = r0.mVelocityTracker
                r46 = r0
                r47 = r40
                float r46 = android.support.p000v4.view.VelocityTrackerCompat.getXVelocity(r46, r47)
                r41 = r46
                r46 = r2
                r0 = r46
                android.view.VelocityTracker r0 = r0.mVelocityTracker
                r46 = r0
                r47 = r40
                float r46 = android.support.p000v4.view.VelocityTrackerCompat.getYVelocity(r46, r47)
                r42 = r46
                r46 = 0
                r43 = r46
            L_0x0192:
                r46 = r43
                r44 = r46
                r46 = 0
                r15 = r46
                r46 = r44
                r47 = r9
                r0 = r46
                r1 = r47
                if (r0 >= r1) goto L_0x00de
                r46 = r43
                r47 = r39
                r0 = r46
                r1 = r47
                if (r0 != r1) goto L_0x01b1
            L_0x01ae:
                int r43 = r43 + 1
                goto L_0x0192
            L_0x01b1:
                r46 = r3
                r47 = r43
                int r46 = android.support.p000v4.view.MotionEventCompat.getPointerId(r46, r47)
                r45 = r46
                r46 = r41
                r47 = r2
                r0 = r47
                android.view.VelocityTracker r0 = r0.mVelocityTracker
                r47 = r0
                r48 = r45
                float r47 = android.support.p000v4.view.VelocityTrackerCompat.getXVelocity(r47, r48)
                float r46 = r46 * r47
                r47 = r42
                r48 = r2
                r0 = r48
                android.view.VelocityTracker r0 = r0.mVelocityTracker
                r48 = r0
                r49 = r45
                float r48 = android.support.p000v4.view.VelocityTrackerCompat.getYVelocity(r48, r49)
                float r47 = r47 * r48
                float r46 = r46 + r47
                r47 = 0
                int r46 = (r46 > r47 ? 1 : (r46 == r47 ? 0 : -1))
                if (r46 >= 0) goto L_0x01ae
                r46 = r2
                r0 = r46
                android.view.VelocityTracker r0 = r0.mVelocityTracker
                r46 = r0
                r46.clear()
                r46 = 0
                r2 = r46
                goto L_0x00e2
            L_0x01f8:
                r46 = r2
                r0 = r46
                android.view.GestureDetector$OnDoubleTapListener r0 = r0.mDoubleTapListener
                r46 = r0
                r33 = r46
                r46 = 0
                r34 = r46
                r46 = r33
                if (r46 == 0) goto L_0x0291
                r46 = r2
                r0 = r46
                android.os.Handler r0 = r0.mHandler
                r46 = r0
                r47 = 3
                boolean r46 = r46.hasMessages(r47)
                r37 = r46
                r46 = r37
                if (r46 == 0) goto L_0x022b
                r46 = r2
                r0 = r46
                android.os.Handler r0 = r0.mHandler
                r46 = r0
                r47 = 3
                r46.removeMessages(r47)
            L_0x022b:
                r46 = r2
                r0 = r46
                android.view.MotionEvent r0 = r0.mCurrentDownEvent
                r46 = r0
                if (r46 == 0) goto L_0x038a
                r46 = r2
                r0 = r46
                android.view.MotionEvent r0 = r0.mPreviousUpEvent
                r46 = r0
                if (r46 == 0) goto L_0x038a
                r46 = r37
                if (r46 == 0) goto L_0x038a
                r46 = r2
                r47 = r2
                r0 = r47
                android.view.MotionEvent r0 = r0.mCurrentDownEvent
                r47 = r0
                r48 = r2
                r0 = r48
                android.view.MotionEvent r0 = r0.mPreviousUpEvent
                r48 = r0
                r49 = r3
                boolean r46 = r46.isConsideredDoubleTap(r47, r48, r49)
                if (r46 == 0) goto L_0x038a
                r46 = r2
                r47 = 1
                r0 = r47
                r1 = r46
                r1.mIsDoubleTapping = r0
                r46 = 0
                r47 = r2
                r0 = r47
                android.view.GestureDetector$OnDoubleTapListener r0 = r0.mDoubleTapListener
                r47 = r0
                r48 = r2
                r0 = r48
                android.view.MotionEvent r0 = r0.mCurrentDownEvent
                r48 = r0
                boolean r47 = r47.onDoubleTap(r48)
                r46 = r46 | r47
                r47 = r2
                r0 = r47
                android.view.GestureDetector$OnDoubleTapListener r0 = r0.mDoubleTapListener
                r47 = r0
                r48 = r3
                boolean r47 = r47.onDoubleTapEvent(r48)
                r46 = r46 | r47
                r34 = r46
            L_0x0291:
                r46 = r2
                r47 = r12
                r0 = r47
                r1 = r46
                r1.mLastFocusX = r0
                r46 = r2
                r47 = r12
                r0 = r47
                r1 = r46
                r1.mDownFocusX = r0
                r46 = r2
                r47 = r13
                r0 = r47
                r1 = r46
                r1.mLastFocusY = r0
                r46 = r2
                r47 = r13
                r0 = r47
                r1 = r46
                r1.mDownFocusY = r0
                r46 = r2
                r0 = r46
                android.view.MotionEvent r0 = r0.mCurrentDownEvent
                r46 = r0
                if (r46 == 0) goto L_0x02ce
                r46 = r2
                r0 = r46
                android.view.MotionEvent r0 = r0.mCurrentDownEvent
                r46 = r0
                r46.recycle()
            L_0x02ce:
                r46 = r2
                r47 = r3
                android.view.MotionEvent r47 = android.view.MotionEvent.obtain(r47)
                r0 = r47
                r1 = r46
                r1.mCurrentDownEvent = r0
                r46 = r2
                r47 = 1
                r0 = r47
                r1 = r46
                r1.mAlwaysInTapRegion = r0
                r46 = r2
                r47 = 1
                r0 = r47
                r1 = r46
                r1.mAlwaysInBiggerTapRegion = r0
                r46 = r2
                r47 = 1
                r0 = r47
                r1 = r46
                r1.mStillDown = r0
                r46 = r2
                r47 = 0
                r0 = r47
                r1 = r46
                r1.mInLongPress = r0
                r46 = r2
                r47 = 0
                r0 = r47
                r1 = r46
                r1.mDeferConfirmSingleTap = r0
                r46 = r2
                r0 = r46
                boolean r0 = r0.mIsLongpressEnabled
                r46 = r0
                if (r46 == 0) goto L_0x0351
                r46 = r2
                r0 = r46
                android.os.Handler r0 = r0.mHandler
                r46 = r0
                r47 = 2
                r46.removeMessages(r47)
                r46 = r2
                r0 = r46
                android.os.Handler r0 = r0.mHandler
                r46 = r0
                r47 = 2
                r48 = r2
                r0 = r48
                android.view.MotionEvent r0 = r0.mCurrentDownEvent
                r48 = r0
                long r48 = r48.getDownTime()
                int r50 = TAP_TIMEOUT
                r0 = r50
                long r0 = (long) r0
                r50 = r0
                long r48 = r48 + r50
                int r50 = LONGPRESS_TIMEOUT
                r0 = r50
                long r0 = (long) r0
                r50 = r0
                long r48 = r48 + r50
                boolean r46 = r46.sendEmptyMessageAtTime(r47, r48)
            L_0x0351:
                r46 = r2
                r0 = r46
                android.os.Handler r0 = r0.mHandler
                r46 = r0
                r47 = 1
                r48 = r2
                r0 = r48
                android.view.MotionEvent r0 = r0.mCurrentDownEvent
                r48 = r0
                long r48 = r48.getDownTime()
                int r50 = TAP_TIMEOUT
                r0 = r50
                long r0 = (long) r0
                r50 = r0
                long r48 = r48 + r50
                boolean r46 = r46.sendEmptyMessageAtTime(r47, r48)
                r46 = r34
                r47 = r2
                r0 = r47
                android.view.GestureDetector$OnGestureListener r0 = r0.mListener
                r47 = r0
                r48 = r3
                boolean r47 = r47.onDown(r48)
                r46 = r46 | r47
                r2 = r46
                goto L_0x00e2
            L_0x038a:
                r46 = r2
                r0 = r46
                android.os.Handler r0 = r0.mHandler
                r46 = r0
                r47 = 3
                int r48 = DOUBLE_TAP_TIMEOUT
                r0 = r48
                long r0 = (long) r0
                r48 = r0
                boolean r46 = r46.sendEmptyMessageDelayed(r47, r48)
                r46 = 0
                r34 = r46
                goto L_0x0291
            L_0x03a5:
                r46 = r2
                r0 = r46
                boolean r0 = r0.mInLongPress
                r46 = r0
                r24 = r46
                r46 = 0
                r15 = r46
                r46 = r24
                if (r46 != 0) goto L_0x00de
                r46 = r2
                r0 = r46
                float r0 = r0.mLastFocusX
                r46 = r0
                r47 = r12
                float r46 = r46 - r47
                r25 = r46
                r46 = r2
                r0 = r46
                float r0 = r0.mLastFocusY
                r46 = r0
                r47 = r13
                float r46 = r46 - r47
                r26 = r46
                r46 = r2
                r0 = r46
                boolean r0 = r0.mIsDoubleTapping
                r46 = r0
                if (r46 == 0) goto L_0x03f3
                r46 = 0
                r47 = r2
                r0 = r47
                android.view.GestureDetector$OnDoubleTapListener r0 = r0.mDoubleTapListener
                r47 = r0
                r48 = r3
                boolean r47 = r47.onDoubleTapEvent(r48)
                r46 = r46 | r47
                r2 = r46
                goto L_0x00e2
            L_0x03f3:
                r46 = r2
                r0 = r46
                boolean r0 = r0.mAlwaysInTapRegion
                r46 = r0
                if (r46 == 0) goto L_0x04cc
                r46 = r12
                r47 = r2
                r0 = r47
                float r0 = r0.mDownFocusX
                r47 = r0
                float r46 = r46 - r47
                r0 = r46
                int r0 = (int) r0
                r46 = r0
                r29 = r46
                r46 = r13
                r47 = r2
                r0 = r47
                float r0 = r0.mDownFocusY
                r47 = r0
                float r46 = r46 - r47
                r0 = r46
                int r0 = (int) r0
                r46 = r0
                r30 = r46
                r46 = r29
                r47 = r29
                int r46 = r46 * r47
                r47 = r30
                r48 = r30
                int r47 = r47 * r48
                int r46 = r46 + r47
                r31 = r46
                r46 = r2
                r0 = r46
                int r0 = r0.mTouchSlopSquare
                r46 = r0
                r32 = r46
                r46 = 0
                r15 = r46
                r46 = r31
                r47 = r32
                r0 = r46
                r1 = r47
                if (r0 <= r1) goto L_0x04ac
                r46 = r2
                r0 = r46
                android.view.GestureDetector$OnGestureListener r0 = r0.mListener
                r46 = r0
                r47 = r2
                r0 = r47
                android.view.MotionEvent r0 = r0.mCurrentDownEvent
                r47 = r0
                r48 = r3
                r49 = r25
                r50 = r26
                boolean r46 = r46.onScroll(r47, r48, r49, r50)
                r15 = r46
                r46 = r2
                r47 = r12
                r0 = r47
                r1 = r46
                r1.mLastFocusX = r0
                r46 = r2
                r47 = r13
                r0 = r47
                r1 = r46
                r1.mLastFocusY = r0
                r46 = r2
                r47 = 0
                r0 = r47
                r1 = r46
                r1.mAlwaysInTapRegion = r0
                r46 = r2
                r0 = r46
                android.os.Handler r0 = r0.mHandler
                r46 = r0
                r47 = 3
                r46.removeMessages(r47)
                r46 = r2
                r0 = r46
                android.os.Handler r0 = r0.mHandler
                r46 = r0
                r47 = 1
                r46.removeMessages(r47)
                r46 = r2
                r0 = r46
                android.os.Handler r0 = r0.mHandler
                r46 = r0
                r47 = 2
                r46.removeMessages(r47)
            L_0x04ac:
                r46 = r31
                r47 = r2
                r0 = r47
                int r0 = r0.mTouchSlopSquare
                r47 = r0
                r0 = r46
                r1 = r47
                if (r0 <= r1) goto L_0x00de
                r46 = r2
                r47 = 0
                r0 = r47
                r1 = r46
                r1.mAlwaysInBiggerTapRegion = r0
                r46 = r15
                r2 = r46
                goto L_0x00e2
            L_0x04cc:
                r46 = r25
                float r46 = java.lang.Math.abs(r46)
                r47 = 1065353216(0x3f800000, float:1.0)
                int r46 = (r46 > r47 ? 1 : (r46 == r47 ? 0 : -1))
                if (r46 >= 0) goto L_0x04ec
                r46 = r26
                float r46 = java.lang.Math.abs(r46)
                r47 = 1065353216(0x3f800000, float:1.0)
                int r46 = (r46 > r47 ? 1 : (r46 == r47 ? 0 : -1))
                r28 = r46
                r46 = 0
                r15 = r46
                r46 = r28
                if (r46 < 0) goto L_0x00de
            L_0x04ec:
                r46 = r2
                r0 = r46
                android.view.GestureDetector$OnGestureListener r0 = r0.mListener
                r46 = r0
                r47 = r2
                r0 = r47
                android.view.MotionEvent r0 = r0.mCurrentDownEvent
                r47 = r0
                r48 = r3
                r49 = r25
                r50 = r26
                boolean r46 = r46.onScroll(r47, r48, r49, r50)
                r27 = r46
                r46 = r2
                r47 = r12
                r0 = r47
                r1 = r46
                r1.mLastFocusX = r0
                r46 = r2
                r47 = r13
                r0 = r47
                r1 = r46
                r1.mLastFocusY = r0
                r46 = r27
                r2 = r46
                goto L_0x00e2
            L_0x0522:
                r46 = r2
                r47 = 0
                r0 = r47
                r1 = r46
                r1.mStillDown = r0
                r46 = r3
                android.view.MotionEvent r46 = android.view.MotionEvent.obtain(r46)
                r16 = r46
                r46 = r2
                r0 = r46
                boolean r0 = r0.mIsDoubleTapping
                r46 = r0
                if (r46 == 0) goto L_0x05c4
                r46 = 0
                r47 = r2
                r0 = r47
                android.view.GestureDetector$OnDoubleTapListener r0 = r0.mDoubleTapListener
                r47 = r0
                r48 = r3
                boolean r47 = r47.onDoubleTapEvent(r48)
                r46 = r46 | r47
                r21 = r46
            L_0x0552:
                r46 = r2
                r0 = r46
                android.view.MotionEvent r0 = r0.mPreviousUpEvent
                r46 = r0
                if (r46 == 0) goto L_0x0567
                r46 = r2
                r0 = r46
                android.view.MotionEvent r0 = r0.mPreviousUpEvent
                r46 = r0
                r46.recycle()
            L_0x0567:
                r46 = r2
                r47 = r16
                r0 = r47
                r1 = r46
                r1.mPreviousUpEvent = r0
                r46 = r2
                r0 = r46
                android.view.VelocityTracker r0 = r0.mVelocityTracker
                r46 = r0
                if (r46 == 0) goto L_0x0590
                r46 = r2
                r0 = r46
                android.view.VelocityTracker r0 = r0.mVelocityTracker
                r46 = r0
                r46.recycle()
                r46 = r2
                r47 = 0
                r0 = r47
                r1 = r46
                r1.mVelocityTracker = r0
            L_0x0590:
                r46 = r2
                r47 = 0
                r0 = r47
                r1 = r46
                r1.mIsDoubleTapping = r0
                r46 = r2
                r47 = 0
                r0 = r47
                r1 = r46
                r1.mDeferConfirmSingleTap = r0
                r46 = r2
                r0 = r46
                android.os.Handler r0 = r0.mHandler
                r46 = r0
                r47 = 1
                r46.removeMessages(r47)
                r46 = r2
                r0 = r46
                android.os.Handler r0 = r0.mHandler
                r46 = r0
                r47 = 2
                r46.removeMessages(r47)
                r46 = r21
                r2 = r46
                goto L_0x00e2
            L_0x05c4:
                r46 = r2
                r0 = r46
                boolean r0 = r0.mInLongPress
                r46 = r0
                if (r46 == 0) goto L_0x05eb
                r46 = r2
                r0 = r46
                android.os.Handler r0 = r0.mHandler
                r46 = r0
                r47 = 3
                r46.removeMessages(r47)
                r46 = r2
                r47 = 0
                r0 = r47
                r1 = r46
                r1.mInLongPress = r0
                r46 = 0
                r21 = r46
                goto L_0x0552
            L_0x05eb:
                r46 = r2
                r0 = r46
                boolean r0 = r0.mAlwaysInTapRegion
                r46 = r0
                if (r46 == 0) goto L_0x0629
                r46 = r2
                r0 = r46
                android.view.GestureDetector$OnGestureListener r0 = r0.mListener
                r46 = r0
                r47 = r3
                boolean r46 = r46.onSingleTapUp(r47)
                r21 = r46
                r46 = r2
                r0 = r46
                boolean r0 = r0.mDeferConfirmSingleTap
                r46 = r0
                if (r46 == 0) goto L_0x0552
                r46 = r2
                r0 = r46
                android.view.GestureDetector$OnDoubleTapListener r0 = r0.mDoubleTapListener
                r46 = r0
                if (r46 == 0) goto L_0x0552
                r46 = r2
                r0 = r46
                android.view.GestureDetector$OnDoubleTapListener r0 = r0.mDoubleTapListener
                r46 = r0
                r47 = r3
                boolean r46 = r46.onSingleTapConfirmed(r47)
                goto L_0x0552
            L_0x0629:
                r46 = r2
                r0 = r46
                android.view.VelocityTracker r0 = r0.mVelocityTracker
                r46 = r0
                r17 = r46
                r46 = r3
                r47 = 0
                int r46 = android.support.p000v4.view.MotionEventCompat.getPointerId(r46, r47)
                r18 = r46
                r46 = r17
                r47 = 1000(0x3e8, float:1.401E-42)
                r48 = r2
                r0 = r48
                int r0 = r0.mMaximumFlingVelocity
                r48 = r0
                r0 = r48
                float r0 = (float) r0
                r48 = r0
                r46.computeCurrentVelocity(r47, r48)
                r46 = r17
                r47 = r18
                float r46 = android.support.p000v4.view.VelocityTrackerCompat.getYVelocity(r46, r47)
                r19 = r46
                r46 = r17
                r47 = r18
                float r46 = android.support.p000v4.view.VelocityTrackerCompat.getXVelocity(r46, r47)
                r20 = r46
                r46 = r19
                float r46 = java.lang.Math.abs(r46)
                r47 = r2
                r0 = r47
                int r0 = r0.mMinimumFlingVelocity
                r47 = r0
                r0 = r47
                float r0 = (float) r0
                r47 = r0
                int r46 = (r46 > r47 ? 1 : (r46 == r47 ? 0 : -1))
                if (r46 > 0) goto L_0x069b
                r46 = r20
                float r46 = java.lang.Math.abs(r46)
                r47 = r2
                r0 = r47
                int r0 = r0.mMinimumFlingVelocity
                r47 = r0
                r0 = r47
                float r0 = (float) r0
                r47 = r0
                int r46 = (r46 > r47 ? 1 : (r46 == r47 ? 0 : -1))
                r22 = r46
                r46 = 0
                r21 = r46
                r46 = r22
                if (r46 <= 0) goto L_0x0552
            L_0x069b:
                r46 = r2
                r0 = r46
                android.view.GestureDetector$OnGestureListener r0 = r0.mListener
                r46 = r0
                r47 = r2
                r0 = r47
                android.view.MotionEvent r0 = r0.mCurrentDownEvent
                r47 = r0
                r48 = r3
                r49 = r20
                r50 = r19
                boolean r46 = r46.onFling(r47, r48, r49, r50)
                r21 = r46
                goto L_0x0552
            L_0x06b9:
                r46 = r2
                r46.cancel()
                r46 = 0
                r2 = r46
                goto L_0x00e2
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.GestureDetectorCompat.GestureDetectorCompatImplBase.onTouchEvent(android.view.MotionEvent):boolean");
        }

        public void setIsLongpressEnabled(boolean z) {
            boolean z2 = z;
            this.mIsLongpressEnabled = z2;
        }

        public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
            OnDoubleTapListener onDoubleTapListener2 = onDoubleTapListener;
            this.mDoubleTapListener = onDoubleTapListener2;
        }
    }

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2 */
    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector mDetector;

        public GestureDetectorCompatImplJellybeanMr2(Context context, OnGestureListener onGestureListener, Handler handler) {
            GestureDetector gestureDetector;
            GestureDetector gestureDetector2 = gestureDetector;
            GestureDetector gestureDetector3 = new GestureDetector(context, onGestureListener, handler);
            this.mDetector = gestureDetector2;
        }

        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.mDetector.onTouchEvent(motionEvent);
        }

        public void setIsLongpressEnabled(boolean z) {
            boolean z2 = z;
            this.mDetector.setIsLongpressEnabled(z2);
        }

        public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
            OnDoubleTapListener onDoubleTapListener2 = onDoubleTapListener;
            this.mDetector.setOnDoubleTapListener(onDoubleTapListener2);
        }
    }

    public GestureDetectorCompat(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public GestureDetectorCompat(Context context, OnGestureListener onGestureListener, Handler handler) {
        GestureDetectorCompatImplBase gestureDetectorCompatImplBase;
        GestureDetectorCompatImplJellybeanMr2 gestureDetectorCompatImplJellybeanMr2;
        Context context2 = context;
        OnGestureListener onGestureListener2 = onGestureListener;
        Handler handler2 = handler;
        if (VERSION.SDK_INT > 17) {
            GestureDetectorCompatImplJellybeanMr2 gestureDetectorCompatImplJellybeanMr22 = gestureDetectorCompatImplJellybeanMr2;
            GestureDetectorCompatImplJellybeanMr2 gestureDetectorCompatImplJellybeanMr23 = new GestureDetectorCompatImplJellybeanMr2(context2, onGestureListener2, handler2);
            this.mImpl = gestureDetectorCompatImplJellybeanMr22;
            return;
        }
        GestureDetectorCompatImplBase gestureDetectorCompatImplBase2 = gestureDetectorCompatImplBase;
        GestureDetectorCompatImplBase gestureDetectorCompatImplBase3 = new GestureDetectorCompatImplBase(context2, onGestureListener2, handler2);
        this.mImpl = gestureDetectorCompatImplBase2;
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mImpl.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        boolean z2 = z;
        this.mImpl.setIsLongpressEnabled(z2);
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        OnDoubleTapListener onDoubleTapListener2 = onDoubleTapListener;
        this.mImpl.setOnDoubleTapListener(onDoubleTapListener2);
    }
}
