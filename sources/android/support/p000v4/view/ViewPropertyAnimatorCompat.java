package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat */
public class ViewPropertyAnimatorCompat {
    static final ViewPropertyAnimatorCompatImpl IMPL;
    static final int LISTENER_TAG_ID = 2113929216;
    private static final String TAG = "ViewAnimatorCompat";
    /* access modifiers changed from: private */
    public Runnable mEndAction = null;
    /* access modifiers changed from: private */
    public int mOldLayerType = -1;
    /* access modifiers changed from: private */
    public Runnable mStartAction = null;
    private WeakReference<View> mView;

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl */
    static class BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompatImpl {
        WeakHashMap<View, Runnable> mStarterMap = null;

        /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl$Starter */
        class Starter implements Runnable {
            WeakReference<View> mViewRef;
            ViewPropertyAnimatorCompat mVpa;
            final /* synthetic */ BaseViewPropertyAnimatorCompatImpl this$0;

            private Starter(BaseViewPropertyAnimatorCompatImpl baseViewPropertyAnimatorCompatImpl, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
                WeakReference<View> weakReference;
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
                View view2 = view;
                this.this$0 = baseViewPropertyAnimatorCompatImpl;
                WeakReference<View> weakReference2 = weakReference;
                WeakReference<View> weakReference3 = new WeakReference<>(view2);
                this.mViewRef = weakReference2;
                this.mVpa = viewPropertyAnimatorCompat2;
            }

            /* synthetic */ Starter(BaseViewPropertyAnimatorCompatImpl baseViewPropertyAnimatorCompatImpl, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, C01141 r13) {
                C01141 r4 = r13;
                this(baseViewPropertyAnimatorCompatImpl, viewPropertyAnimatorCompat, view);
            }

            public void run() {
                View view = (View) this.mViewRef.get();
                if (view != null) {
                    this.this$0.startAnimation(this.mVpa, view);
                }
            }
        }

        BaseViewPropertyAnimatorCompatImpl() {
        }

        /* JADX WARNING: type inference failed for: r4v0 */
        /* JADX WARNING: type inference failed for: r4v1 */
        /* JADX WARNING: type inference failed for: r5v4 */
        /* JADX WARNING: type inference failed for: r4v2 */
        /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Runnable] */
        /* JADX WARNING: type inference failed for: r6v1, types: [java.lang.Runnable] */
        /* JADX WARNING: type inference failed for: r11v0 */
        /* JADX WARNING: type inference failed for: r5v10 */
        /* JADX WARNING: type inference failed for: r4v3 */
        /* JADX WARNING: type inference failed for: r7v1, types: [java.lang.Object] */
        /* JADX WARNING: type inference failed for: r5v20, types: [java.lang.Runnable] */
        /* JADX WARNING: type inference failed for: r4v4 */
        /* JADX WARNING: type inference failed for: r4v5 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 9 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void postStartMessage(android.support.p000v4.view.ViewPropertyAnimatorCompat r13, android.view.View r14) {
            /*
                r12 = this;
                r0 = r12
                r1 = r13
                r2 = r14
                r5 = r0
                java.util.WeakHashMap<android.view.View, java.lang.Runnable> r5 = r5.mStarterMap
                r3 = r5
                r5 = 0
                r4 = r5
                r5 = r3
                if (r5 == 0) goto L_0x0017
                r5 = r0
                java.util.WeakHashMap<android.view.View, java.lang.Runnable> r5 = r5.mStarterMap
                r6 = r2
                java.lang.Object r5 = r5.get(r6)
                java.lang.Runnable r5 = (java.lang.Runnable) r5
                r4 = r5
            L_0x0017:
                r5 = r4
                if (r5 != 0) goto L_0x0040
                android.support.v4.view.ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl$Starter r5 = new android.support.v4.view.ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl$Starter
                r11 = r5
                r5 = r11
                r6 = r11
                r7 = r0
                r8 = r1
                r9 = r2
                r10 = 0
                r6.<init>(r7, r8, r9, r10)
                r4 = r5
                r5 = r0
                java.util.WeakHashMap<android.view.View, java.lang.Runnable> r5 = r5.mStarterMap
                if (r5 != 0) goto L_0x0037
                r5 = r0
                java.util.WeakHashMap r6 = new java.util.WeakHashMap
                r11 = r6
                r6 = r11
                r7 = r11
                r7.<init>()
                r5.mStarterMap = r6
            L_0x0037:
                r5 = r0
                java.util.WeakHashMap<android.view.View, java.lang.Runnable> r5 = r5.mStarterMap
                r6 = r2
                r7 = r4
                java.lang.Object r5 = r5.put(r6, r7)
            L_0x0040:
                r5 = r2
                r6 = r4
                boolean r5 = r5.removeCallbacks(r6)
                r5 = r2
                r6 = r4
                boolean r5 = r5.post(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl.postStartMessage(android.support.v4.view.ViewPropertyAnimatorCompat, android.view.View):void");
        }

        private void removeStartMessage(View view) {
            View view2 = view;
            if (this.mStarterMap != null) {
                Runnable runnable = (Runnable) this.mStarterMap.get(view2);
                if (runnable != null) {
                    boolean removeCallbacks = view2.removeCallbacks(runnable);
                }
            }
        }

        /* access modifiers changed from: private */
        public void startAnimation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            View view2 = view;
            Object tag = view2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
            if (tag instanceof ViewPropertyAnimatorListener) {
                viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
            }
            Runnable access$100 = viewPropertyAnimatorCompat2.mStartAction;
            Runnable access$000 = viewPropertyAnimatorCompat2.mEndAction;
            if (access$100 != null) {
                access$100.run();
            }
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(view2);
                viewPropertyAnimatorListener.onAnimationEnd(view2);
            }
            if (access$000 != null) {
                access$000.run();
            }
            if (this.mStarterMap != null) {
                Object remove = this.mStarterMap.remove(view2);
            }
        }

        public void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            View view2 = view;
            return 0;
        }

        public Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            View view2 = view;
            return null;
        }

        public long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            View view2 = view;
            return 0;
        }

        public void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
        }

        public void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator) {
        }

        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            view.setTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID, viewPropertyAnimatorListener);
        }

        public void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
        }

        public void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        }

        public void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            View view2 = view;
            removeStartMessage(view2);
            startAnimation(viewPropertyAnimatorCompat2, view2);
        }

        public void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void translationZ(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        public void translationZBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            View view2 = view;
            Runnable access$002 = ViewPropertyAnimatorCompat.access$002(viewPropertyAnimatorCompat2, runnable);
            postStartMessage(viewPropertyAnimatorCompat2, view2);
        }

        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
        }

        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            View view2 = view;
            Runnable access$102 = ViewPropertyAnimatorCompat.access$102(viewPropertyAnimatorCompat2, runnable);
            postStartMessage(viewPropertyAnimatorCompat2, view2);
        }

        /* renamed from: x */
        public void mo2389x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: y */
        public void mo2391y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        public void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            float f2 = f;
            postStartMessage(viewPropertyAnimatorCompat, view);
        }

        /* renamed from: z */
        public void mo2393z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }

        public void zBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl */
    static class ICSViewPropertyAnimatorCompatImpl extends BaseViewPropertyAnimatorCompatImpl {
        WeakHashMap<View, Integer> mLayerMap = null;

        /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener */
        static class MyVpaListener implements ViewPropertyAnimatorListener {
            ViewPropertyAnimatorCompat mVpa;

            MyVpaListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
                this.mVpa = viewPropertyAnimatorCompat;
            }

            public void onAnimationCancel(View view) {
                View view2 = view;
                Object tag = view2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationCancel(view2);
                }
            }

            public void onAnimationEnd(View view) {
                View view2 = view;
                if (this.mVpa.mOldLayerType >= 0) {
                    ViewCompat.setLayerType(view2, this.mVpa.mOldLayerType, null);
                    int access$402 = ViewPropertyAnimatorCompat.access$402(this.mVpa, -1);
                }
                if (this.mVpa.mEndAction != null) {
                    this.mVpa.mEndAction.run();
                }
                Object tag = view2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(view2);
                }
            }

            public void onAnimationStart(View view) {
                View view2 = view;
                if (this.mVpa.mOldLayerType >= 0) {
                    ViewCompat.setLayerType(view2, 2, null);
                }
                if (this.mVpa.mStartAction != null) {
                    this.mVpa.mStartAction.run();
                }
                Object tag = view2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
                if (tag instanceof ViewPropertyAnimatorListener) {
                    viewPropertyAnimatorListener = (ViewPropertyAnimatorListener) tag;
                }
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart(view2);
                }
            }
        }

        ICSViewPropertyAnimatorCompatImpl() {
        }

        public void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.alpha(view, f);
        }

        public void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.alphaBy(view, f);
        }

        public void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.cancel(view);
        }

        public long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            return ViewPropertyAnimatorCompatICS.getDuration(view);
        }

        public long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            return ViewPropertyAnimatorCompatICS.getStartDelay(view);
        }

        public void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.rotation(view, f);
        }

        public void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.rotationBy(view, f);
        }

        public void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.rotationX(view, f);
        }

        public void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.rotationXBy(view, f);
        }

        public void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.rotationY(view, f);
        }

        public void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.rotationYBy(view, f);
        }

        public void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.scaleX(view, f);
        }

        public void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.scaleXBy(view, f);
        }

        public void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.scaleY(view, f);
        }

        public void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.scaleYBy(view, f);
        }

        public void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.setDuration(view, j);
        }

        public void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.setInterpolator(view, interpolator);
        }

        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            MyVpaListener myVpaListener;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            View view2 = view;
            view2.setTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID, viewPropertyAnimatorListener);
            View view3 = view2;
            MyVpaListener myVpaListener2 = myVpaListener;
            MyVpaListener myVpaListener3 = new MyVpaListener(viewPropertyAnimatorCompat2);
            ViewPropertyAnimatorCompatICS.setListener(view3, myVpaListener2);
        }

        public void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.setStartDelay(view, j);
        }

        public void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.start(view);
        }

        public void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.translationX(view, f);
        }

        public void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.translationXBy(view, f);
        }

        public void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.translationY(view, f);
        }

        public void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.translationYBy(view, f);
        }

        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            MyVpaListener myVpaListener;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            Runnable runnable2 = runnable;
            View view2 = view;
            MyVpaListener myVpaListener2 = myVpaListener;
            MyVpaListener myVpaListener3 = new MyVpaListener(viewPropertyAnimatorCompat2);
            ViewPropertyAnimatorCompatICS.setListener(view2, myVpaListener2);
            Runnable access$002 = ViewPropertyAnimatorCompat.access$002(viewPropertyAnimatorCompat2, runnable2);
        }

        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            MyVpaListener myVpaListener;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            View view2 = view;
            int access$402 = ViewPropertyAnimatorCompat.access$402(viewPropertyAnimatorCompat2, ViewCompat.getLayerType(view2));
            View view3 = view2;
            MyVpaListener myVpaListener2 = myVpaListener;
            MyVpaListener myVpaListener3 = new MyVpaListener(viewPropertyAnimatorCompat2);
            ViewPropertyAnimatorCompatICS.setListener(view3, myVpaListener2);
        }

        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            MyVpaListener myVpaListener;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            Runnable runnable2 = runnable;
            View view2 = view;
            MyVpaListener myVpaListener2 = myVpaListener;
            MyVpaListener myVpaListener3 = new MyVpaListener(viewPropertyAnimatorCompat2);
            ViewPropertyAnimatorCompatICS.setListener(view2, myVpaListener2);
            Runnable access$102 = ViewPropertyAnimatorCompat.access$102(viewPropertyAnimatorCompat2, runnable2);
        }

        /* renamed from: x */
        public void mo2389x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.m16x(view, f);
        }

        public void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.xBy(view, f);
        }

        /* renamed from: y */
        public void mo2391y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.m17y(view, f);
        }

        public void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatICS.yBy(view, f);
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$JBMr2ViewPropertyAnimatorCompatImpl */
    static class JBMr2ViewPropertyAnimatorCompatImpl extends JBViewPropertyAnimatorCompatImpl {
        JBMr2ViewPropertyAnimatorCompatImpl() {
        }

        public Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            return ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(view);
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$JBViewPropertyAnimatorCompatImpl */
    static class JBViewPropertyAnimatorCompatImpl extends ICSViewPropertyAnimatorCompatImpl {
        JBViewPropertyAnimatorCompatImpl() {
        }

        public void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatJB.setListener(view, viewPropertyAnimatorListener);
        }

        public void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatJB.withEndAction(view, runnable);
        }

        public void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatJB.withLayer(view);
        }

        public void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatJB.withStartAction(view, runnable);
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$KitKatViewPropertyAnimatorCompatImpl */
    static class KitKatViewPropertyAnimatorCompatImpl extends JBMr2ViewPropertyAnimatorCompatImpl {
        KitKatViewPropertyAnimatorCompatImpl() {
        }

        public void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatKK.setUpdateListener(view, viewPropertyAnimatorUpdateListener);
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$LollipopViewPropertyAnimatorCompatImpl */
    static class LollipopViewPropertyAnimatorCompatImpl extends KitKatViewPropertyAnimatorCompatImpl {
        LollipopViewPropertyAnimatorCompatImpl() {
        }

        public void translationZ(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatLollipop.translationZ(view, f);
        }

        public void translationZBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatLollipop.translationZBy(view, f);
        }

        /* renamed from: z */
        public void mo2393z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatLollipop.m18z(view, f);
        }

        public void zBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompatLollipop.zBy(view, f);
        }
    }

    /* renamed from: android.support.v4.view.ViewPropertyAnimatorCompat$ViewPropertyAnimatorCompatImpl */
    interface ViewPropertyAnimatorCompatImpl {
        void alpha(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void alphaBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void cancel(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        long getDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        Interpolator getInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        long getStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        void rotation(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void rotationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void scaleX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void scaleXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void scaleY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void scaleYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void setDuration(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j);

        void setInterpolator(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Interpolator interpolator);

        void setListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener);

        void setStartDelay(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, long j);

        void setUpdateListener(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener);

        void start(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        void translationX(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationXBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationY(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationYBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationZ(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void translationZBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void withEndAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable);

        void withLayer(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view);

        void withStartAction(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, Runnable runnable);

        /* renamed from: x */
        void mo2389x(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void xBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: y */
        void mo2391y(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void yBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        /* renamed from: z */
        void mo2393z(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);

        void zBy(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, View view, float f);
    }

    static {
        BaseViewPropertyAnimatorCompatImpl baseViewPropertyAnimatorCompatImpl;
        ICSViewPropertyAnimatorCompatImpl iCSViewPropertyAnimatorCompatImpl;
        JBViewPropertyAnimatorCompatImpl jBViewPropertyAnimatorCompatImpl;
        JBMr2ViewPropertyAnimatorCompatImpl jBMr2ViewPropertyAnimatorCompatImpl;
        KitKatViewPropertyAnimatorCompatImpl kitKatViewPropertyAnimatorCompatImpl;
        LollipopViewPropertyAnimatorCompatImpl lollipopViewPropertyAnimatorCompatImpl;
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            LollipopViewPropertyAnimatorCompatImpl lollipopViewPropertyAnimatorCompatImpl2 = lollipopViewPropertyAnimatorCompatImpl;
            LollipopViewPropertyAnimatorCompatImpl lollipopViewPropertyAnimatorCompatImpl3 = new LollipopViewPropertyAnimatorCompatImpl();
            IMPL = lollipopViewPropertyAnimatorCompatImpl2;
        } else if (i >= 19) {
            KitKatViewPropertyAnimatorCompatImpl kitKatViewPropertyAnimatorCompatImpl2 = kitKatViewPropertyAnimatorCompatImpl;
            KitKatViewPropertyAnimatorCompatImpl kitKatViewPropertyAnimatorCompatImpl3 = new KitKatViewPropertyAnimatorCompatImpl();
            IMPL = kitKatViewPropertyAnimatorCompatImpl2;
        } else if (i >= 18) {
            JBMr2ViewPropertyAnimatorCompatImpl jBMr2ViewPropertyAnimatorCompatImpl2 = jBMr2ViewPropertyAnimatorCompatImpl;
            JBMr2ViewPropertyAnimatorCompatImpl jBMr2ViewPropertyAnimatorCompatImpl3 = new JBMr2ViewPropertyAnimatorCompatImpl();
            IMPL = jBMr2ViewPropertyAnimatorCompatImpl2;
        } else if (i >= 16) {
            JBViewPropertyAnimatorCompatImpl jBViewPropertyAnimatorCompatImpl2 = jBViewPropertyAnimatorCompatImpl;
            JBViewPropertyAnimatorCompatImpl jBViewPropertyAnimatorCompatImpl3 = new JBViewPropertyAnimatorCompatImpl();
            IMPL = jBViewPropertyAnimatorCompatImpl2;
        } else if (i >= 14) {
            ICSViewPropertyAnimatorCompatImpl iCSViewPropertyAnimatorCompatImpl2 = iCSViewPropertyAnimatorCompatImpl;
            ICSViewPropertyAnimatorCompatImpl iCSViewPropertyAnimatorCompatImpl3 = new ICSViewPropertyAnimatorCompatImpl();
            IMPL = iCSViewPropertyAnimatorCompatImpl2;
        } else {
            BaseViewPropertyAnimatorCompatImpl baseViewPropertyAnimatorCompatImpl2 = baseViewPropertyAnimatorCompatImpl;
            BaseViewPropertyAnimatorCompatImpl baseViewPropertyAnimatorCompatImpl3 = new BaseViewPropertyAnimatorCompatImpl();
            IMPL = baseViewPropertyAnimatorCompatImpl2;
        }
    }

    ViewPropertyAnimatorCompat(View view) {
        WeakReference<View> weakReference;
        View view2 = view;
        WeakReference<View> weakReference2 = weakReference;
        WeakReference<View> weakReference3 = new WeakReference<>(view2);
        this.mView = weakReference2;
    }

    static /* synthetic */ Runnable access$002(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, Runnable runnable) {
        Runnable runnable2 = runnable;
        viewPropertyAnimatorCompat.mEndAction = runnable2;
        return runnable2;
    }

    static /* synthetic */ Runnable access$102(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, Runnable runnable) {
        Runnable runnable2 = runnable;
        viewPropertyAnimatorCompat.mStartAction = runnable2;
        return runnable2;
    }

    static /* synthetic */ int access$402(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
        int i2 = i;
        viewPropertyAnimatorCompat.mOldLayerType = i2;
        return i2;
    }

    public ViewPropertyAnimatorCompat alpha(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.alpha(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.alphaBy(this, view, f2);
        }
        return this;
    }

    public void cancel() {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.cancel(this, view);
        }
    }

    public long getDuration() {
        View view = (View) this.mView.get();
        if (view != null) {
            return IMPL.getDuration(this, view);
        }
        return 0;
    }

    public Interpolator getInterpolator() {
        View view = (View) this.mView.get();
        if (view != null) {
            return IMPL.getInterpolator(this, view);
        }
        return null;
    }

    public long getStartDelay() {
        View view = (View) this.mView.get();
        if (view != null) {
            return IMPL.getStartDelay(this, view);
        }
        return 0;
    }

    public ViewPropertyAnimatorCompat rotation(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotation(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationBy(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationX(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationXBy(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationY(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.rotationYBy(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.scaleX(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.scaleXBy(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.scaleY(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.scaleYBy(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long j) {
        long j2 = j;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.setDuration(this, view, j2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        Interpolator interpolator2 = interpolator;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.setInterpolator(this, view, interpolator2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        ViewPropertyAnimatorListener viewPropertyAnimatorListener2 = viewPropertyAnimatorListener;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.setListener(this, view, viewPropertyAnimatorListener2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long j) {
        long j2 = j;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.setStartDelay(this, view, j2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener2 = viewPropertyAnimatorUpdateListener;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.setUpdateListener(this, view, viewPropertyAnimatorUpdateListener2);
        }
        return this;
    }

    public void start() {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.start(this, view);
        }
    }

    public ViewPropertyAnimatorCompat translationX(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationX(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationXBy(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationY(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationYBy(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationZ(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.translationZBy(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        Runnable runnable2 = runnable;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.withEndAction(this, view, runnable2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withLayer() {
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.withLayer(this, view);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        Runnable runnable2 = runnable;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.withStartAction(this, view, runnable2);
        }
        return this;
    }

    /* renamed from: x */
    public ViewPropertyAnimatorCompat mo2352x(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.mo2389x(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.xBy(this, view, f2);
        }
        return this;
    }

    /* renamed from: y */
    public ViewPropertyAnimatorCompat mo2354y(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.mo2391y(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.yBy(this, view, f2);
        }
        return this;
    }

    /* renamed from: z */
    public ViewPropertyAnimatorCompat mo2356z(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.mo2393z(this, view, f2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f) {
        float f2 = f;
        View view = (View) this.mView.get();
        if (view != null) {
            IMPL.zBy(this, view, f2);
        }
        return this;
    }
}
