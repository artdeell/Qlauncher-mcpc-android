package android.support.p000v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.p000v4.app.BackStackRecord.TransitionState;
import android.support.p000v4.app.Fragment.SavedState;
import android.support.p000v4.app.FragmentManager.BackStackEntry;
import android.support.p000v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.p000v4.util.DebugUtils;
import android.support.p000v4.util.LogWriter;
import android.support.p000v4.view.LayoutInflaterFactory;
import android.support.p000v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: android.support.v4.app.FragmentManagerImpl */
final class FragmentManagerImpl extends FragmentManager implements LayoutInflaterFactory {
    static final Interpolator ACCELERATE_CUBIC;
    static final Interpolator ACCELERATE_QUINT;
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = false;
    static final Interpolator DECELERATE_CUBIC;
    static final Interpolator DECELERATE_QUINT;
    static final boolean HONEYCOMB;
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    static Field sAnimationListenerField = null;
    ArrayList<Fragment> mActive;
    ArrayList<Fragment> mAdded;
    ArrayList<Integer> mAvailBackStackIndices;
    ArrayList<Integer> mAvailIndices;
    ArrayList<BackStackRecord> mBackStack;
    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    ArrayList<BackStackRecord> mBackStackIndices;
    FragmentContainer mContainer;
    FragmentController mController;
    ArrayList<Fragment> mCreatedMenus;
    int mCurState = 0;
    boolean mDestroyed;
    Runnable mExecCommit;
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    FragmentHostCallback mHost;
    boolean mNeedMenuInvalidate;
    String mNoTransactionsBecause;
    Fragment mParent;
    ArrayList<Runnable> mPendingActions;
    SparseArray<Parcelable> mStateArray = null;
    Bundle mStateBundle = null;
    boolean mStateSaved;
    Runnable[] mTmpActions;

    /* renamed from: android.support.v4.app.FragmentManagerImpl$AnimateOnHWLayerIfNeededListener */
    static class AnimateOnHWLayerIfNeededListener implements AnimationListener {
        private AnimationListener mOrignalListener = null;
        private boolean mShouldRunOnHWLayer = false;
        /* access modifiers changed from: private */
        public View mView = null;

        public AnimateOnHWLayerIfNeededListener(View view, Animation animation) {
            View view2 = view;
            Animation animation2 = animation;
            if (view2 != null && animation2 != null) {
                this.mView = view2;
            }
        }

        public AnimateOnHWLayerIfNeededListener(View view, Animation animation, AnimationListener animationListener) {
            View view2 = view;
            Animation animation2 = animation;
            AnimationListener animationListener2 = animationListener;
            if (view2 != null && animation2 != null) {
                this.mOrignalListener = animationListener2;
                this.mView = view2;
            }
        }

        @CallSuper
        public void onAnimationEnd(Animation animation) {
            C00192 r6;
            Animation animation2 = animation;
            if (this.mView != null && this.mShouldRunOnHWLayer) {
                View view = this.mView;
                C00192 r3 = r6;
                C00192 r4 = new Runnable(this) {
                    final /* synthetic */ AnimateOnHWLayerIfNeededListener this$0;

                    {
                        this.this$0 = r5;
                    }

                    public void run() {
                        ViewCompat.setLayerType(this.this$0.mView, 0, null);
                    }
                };
                boolean post = view.post(r3);
            }
            if (this.mOrignalListener != null) {
                this.mOrignalListener.onAnimationEnd(animation2);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            Animation animation2 = animation;
            if (this.mOrignalListener != null) {
                this.mOrignalListener.onAnimationRepeat(animation2);
            }
        }

        @CallSuper
        public void onAnimationStart(Animation animation) {
            C00181 r6;
            Animation animation2 = animation;
            if (this.mView != null) {
                this.mShouldRunOnHWLayer = FragmentManagerImpl.shouldRunOnHWLayer(this.mView, animation2);
                if (this.mShouldRunOnHWLayer) {
                    View view = this.mView;
                    C00181 r3 = r6;
                    C00181 r4 = new Runnable(this) {
                        final /* synthetic */ AnimateOnHWLayerIfNeededListener this$0;

                        {
                            this.this$0 = r5;
                        }

                        public void run() {
                            ViewCompat.setLayerType(this.this$0.mView, 2, null);
                        }
                    };
                    boolean post = view.post(r3);
                }
            }
            if (this.mOrignalListener != null) {
                this.mOrignalListener.onAnimationStart(animation2);
            }
        }
    }

    /* renamed from: android.support.v4.app.FragmentManagerImpl$FragmentTag */
    static class FragmentTag {
        public static final int[] Fragment = {16842755, 16842960, 16842961};
        public static final int Fragment_id = 1;
        public static final int Fragment_name = 0;
        public static final int Fragment_tag = 2;

        FragmentTag() {
        }
    }

    static {
        DecelerateInterpolator decelerateInterpolator;
        DecelerateInterpolator decelerateInterpolator2;
        AccelerateInterpolator accelerateInterpolator;
        AccelerateInterpolator accelerateInterpolator2;
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        HONEYCOMB = z;
        DecelerateInterpolator decelerateInterpolator3 = decelerateInterpolator;
        DecelerateInterpolator decelerateInterpolator4 = new DecelerateInterpolator(2.5f);
        DECELERATE_QUINT = decelerateInterpolator3;
        DecelerateInterpolator decelerateInterpolator5 = decelerateInterpolator2;
        DecelerateInterpolator decelerateInterpolator6 = new DecelerateInterpolator(1.5f);
        DECELERATE_CUBIC = decelerateInterpolator5;
        AccelerateInterpolator accelerateInterpolator3 = accelerateInterpolator;
        AccelerateInterpolator accelerateInterpolator4 = new AccelerateInterpolator(2.5f);
        ACCELERATE_QUINT = accelerateInterpolator3;
        AccelerateInterpolator accelerateInterpolator5 = accelerateInterpolator2;
        AccelerateInterpolator accelerateInterpolator6 = new AccelerateInterpolator(1.5f);
        ACCELERATE_CUBIC = accelerateInterpolator5;
    }

    FragmentManagerImpl() {
        C00131 r5;
        C00131 r2 = r5;
        C00131 r3 = new Runnable(this) {
            final /* synthetic */ FragmentManagerImpl this$0;

            {
                this.this$0 = r5;
            }

            public void run() {
                boolean execPendingActions = this.this$0.execPendingActions();
            }
        };
        this.mExecCommit = r2;
    }

    private void checkStateLoss() {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        IllegalStateException illegalStateException2;
        if (this.mStateSaved) {
            IllegalStateException illegalStateException3 = illegalStateException2;
            IllegalStateException illegalStateException4 = new IllegalStateException("Can not perform this action after onSaveInstanceState");
            throw illegalStateException3;
        } else if (this.mNoTransactionsBecause != null) {
            IllegalStateException illegalStateException5 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException6 = new IllegalStateException(sb2.append("Can not perform this action inside of ").append(this.mNoTransactionsBecause).toString());
            throw illegalStateException5;
        }
    }

    static Animation makeFadeAnimation(Context context, float f, float f2) {
        AlphaAnimation alphaAnimation;
        Context context2 = context;
        AlphaAnimation alphaAnimation2 = alphaAnimation;
        AlphaAnimation alphaAnimation3 = new AlphaAnimation(f, f2);
        AlphaAnimation alphaAnimation4 = alphaAnimation2;
        alphaAnimation4.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation4.setDuration(220);
        return alphaAnimation4;
    }

    static Animation makeOpenCloseAnimation(Context context, float f, float f2, float f3, float f4) {
        AnimationSet animationSet;
        ScaleAnimation scaleAnimation;
        AlphaAnimation alphaAnimation;
        Context context2 = context;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        AnimationSet animationSet2 = animationSet;
        AnimationSet animationSet3 = new AnimationSet(false);
        AnimationSet animationSet4 = animationSet2;
        ScaleAnimation scaleAnimation2 = scaleAnimation;
        ScaleAnimation scaleAnimation3 = new ScaleAnimation(f5, f6, f5, f6, 1, 0.5f, 1, 0.5f);
        ScaleAnimation scaleAnimation4 = scaleAnimation2;
        scaleAnimation4.setInterpolator(DECELERATE_QUINT);
        scaleAnimation4.setDuration(220);
        animationSet4.addAnimation(scaleAnimation4);
        AlphaAnimation alphaAnimation2 = alphaAnimation;
        AlphaAnimation alphaAnimation3 = new AlphaAnimation(f7, f8);
        AlphaAnimation alphaAnimation4 = alphaAnimation2;
        alphaAnimation4.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation4.setDuration(220);
        animationSet4.addAnimation(alphaAnimation4);
        return animationSet4;
    }

    static boolean modifiesAlpha(Animation animation) {
        Animation animation2 = animation;
        if (!(animation2 instanceof AlphaAnimation)) {
            if (animation2 instanceof AnimationSet) {
                List animations = ((AnimationSet) animation2).getAnimations();
                int i = 0;
                while (i < animations.size()) {
                    if (!(animations.get(i) instanceof AlphaAnimation)) {
                        i++;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static int reverseTransit(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private void setHWLayerAnimListenerIfAlpha(View view, Animation animation) {
        AnimationListener animationListener;
        AnimateOnHWLayerIfNeededListener animateOnHWLayerIfNeededListener;
        View view2 = view;
        Animation animation2 = animation;
        if (view2 != null && animation2 != null && shouldRunOnHWLayer(view2, animation2)) {
            try {
                if (sAnimationListenerField == null) {
                    sAnimationListenerField = Animation.class.getDeclaredField("mListener");
                    sAnimationListenerField.setAccessible(true);
                }
                animationListener = (AnimationListener) sAnimationListenerField.get(animation2);
            } catch (NoSuchFieldException e) {
                int e2 = Log.e(TAG, "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (IllegalAccessException e3) {
                int e4 = Log.e(TAG, "Cannot access Animation's mListener field", e3);
                animationListener = null;
            }
            Animation animation3 = animation2;
            AnimateOnHWLayerIfNeededListener animateOnHWLayerIfNeededListener2 = animateOnHWLayerIfNeededListener;
            AnimateOnHWLayerIfNeededListener animateOnHWLayerIfNeededListener3 = new AnimateOnHWLayerIfNeededListener(view2, animation2, animationListener);
            animation3.setAnimationListener(animateOnHWLayerIfNeededListener2);
        }
    }

    static boolean shouldRunOnHWLayer(View view, Animation animation) {
        View view2 = view;
        return VERSION.SDK_INT >= 19 && ViewCompat.getLayerType(view2) == 0 && ViewCompat.hasOverlappingRendering(view2) && modifiesAlpha(animation);
    }

    private void throwException(RuntimeException runtimeException) {
        PrintWriter printWriter;
        LogWriter logWriter;
        RuntimeException runtimeException2 = runtimeException;
        int e = Log.e(TAG, runtimeException2.getMessage());
        int e2 = Log.e(TAG, "Activity state:");
        PrintWriter printWriter2 = printWriter;
        LogWriter logWriter2 = logWriter;
        LogWriter logWriter3 = new LogWriter(TAG);
        PrintWriter printWriter3 = new PrintWriter(logWriter2);
        PrintWriter printWriter4 = printWriter2;
        if (this.mHost != null) {
            try {
                this.mHost.onDump("  ", null, printWriter4, new String[0]);
            } catch (Exception e3) {
                int e4 = Log.e(TAG, "Failed dumping state", e3);
            }
        } else {
            try {
                dump("  ", null, printWriter4, new String[0]);
            } catch (Exception e5) {
                int e6 = Log.e(TAG, "Failed dumping state", e5);
            }
        }
        throw runtimeException2;
    }

    public static int transitToStyleIndex(int i, boolean z) {
        boolean z2 = z;
        switch (i) {
            case 4097:
                return z2 ? 1 : 2;
            case 4099:
                return z2 ? 5 : 6;
            case 8194:
                return z2 ? 3 : 4;
            default:
                return -1;
        }
    }

    /* access modifiers changed from: 0000 */
    public void addBackStackState(BackStackRecord backStackRecord) {
        ArrayList<BackStackRecord> arrayList;
        BackStackRecord backStackRecord2 = backStackRecord;
        if (this.mBackStack == null) {
            ArrayList<BackStackRecord> arrayList2 = arrayList;
            ArrayList<BackStackRecord> arrayList3 = new ArrayList<>();
            this.mBackStack = arrayList2;
        }
        boolean add = this.mBackStack.add(backStackRecord2);
        reportBackStackChanged();
    }

    public void addFragment(Fragment fragment, boolean z) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        StringBuilder sb2;
        ArrayList<Fragment> arrayList;
        Fragment fragment2 = fragment;
        boolean z2 = z;
        if (this.mAdded == null) {
            ArrayList<Fragment> arrayList2 = arrayList;
            ArrayList<Fragment> arrayList3 = new ArrayList<>();
            this.mAdded = arrayList2;
        }
        if (DEBUG) {
            String str = TAG;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            int v = Log.v(str, sb3.append("add: ").append(fragment2).toString());
        }
        makeActive(fragment2);
        if (fragment2.mDetached) {
            return;
        }
        if (this.mAdded.contains(fragment2)) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb5.append("Fragment already added: ").append(fragment2).toString());
            throw illegalStateException2;
        }
        boolean add = this.mAdded.add(fragment2);
        fragment2.mAdded = true;
        fragment2.mRemoving = false;
        if (fragment2.mHasMenu && fragment2.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
        }
        if (z2) {
            moveToState(fragment2);
        }
    }

    public void addOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList<OnBackStackChangedListener> arrayList;
        OnBackStackChangedListener onBackStackChangedListener2 = onBackStackChangedListener;
        if (this.mBackStackChangeListeners == null) {
            ArrayList<OnBackStackChangedListener> arrayList2 = arrayList;
            ArrayList<OnBackStackChangedListener> arrayList3 = new ArrayList<>();
            this.mBackStackChangeListeners = arrayList2;
        }
        boolean add = this.mBackStackChangeListeners.add(onBackStackChangedListener2);
    }

    public int allocBackStackIndex(BackStackRecord backStackRecord) {
        StringBuilder sb;
        ArrayList<BackStackRecord> arrayList;
        StringBuilder sb2;
        BackStackRecord backStackRecord2 = backStackRecord;
        synchronized (this) {
            try {
                if (this.mAvailBackStackIndices == null || this.mAvailBackStackIndices.size() <= 0) {
                    if (this.mBackStackIndices == null) {
                        ArrayList<BackStackRecord> arrayList2 = arrayList;
                        ArrayList<BackStackRecord> arrayList3 = new ArrayList<>();
                        this.mBackStackIndices = arrayList2;
                    }
                    th = this.mBackStackIndices.size();
                    if (DEBUG) {
                        String str = TAG;
                        StringBuilder sb3 = sb;
                        StringBuilder sb4 = new StringBuilder();
                        int v = Log.v(str, sb3.append("Setting back stack index ").append(th).append(" to ").append(backStackRecord2).toString());
                    }
                    boolean add = this.mBackStackIndices.add(backStackRecord2);
                    return th;
                }
                int intValue = ((Integer) this.mAvailBackStackIndices.remove(-1 + this.mAvailBackStackIndices.size())).intValue();
                if (DEBUG) {
                    String str2 = TAG;
                    StringBuilder sb5 = sb2;
                    StringBuilder sb6 = new StringBuilder();
                    int v2 = Log.v(str2, sb5.append("Adding back stack index ").append(intValue).append(" with ").append(backStackRecord2).toString());
                }
                Object obj = this.mBackStackIndices.set(intValue, backStackRecord2);
                return intValue;
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
    }

    public void attachController(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        IllegalStateException illegalStateException;
        FragmentHostCallback fragmentHostCallback2 = fragmentHostCallback;
        FragmentContainer fragmentContainer2 = fragmentContainer;
        Fragment fragment2 = fragment;
        if (this.mHost != null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Already attached");
            throw illegalStateException2;
        }
        this.mHost = fragmentHostCallback2;
        this.mContainer = fragmentContainer2;
        this.mParent = fragment2;
    }

    public void attachFragment(Fragment fragment, int i, int i2) {
        StringBuilder sb;
        IllegalStateException illegalStateException;
        StringBuilder sb2;
        ArrayList<Fragment> arrayList;
        StringBuilder sb3;
        Fragment fragment2 = fragment;
        int i3 = i;
        int i4 = i2;
        if (DEBUG) {
            String str = TAG;
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            int v = Log.v(str, sb4.append("attach: ").append(fragment2).toString());
        }
        if (fragment2.mDetached) {
            fragment2.mDetached = false;
            if (!fragment2.mAdded) {
                if (this.mAdded == null) {
                    ArrayList<Fragment> arrayList2 = arrayList;
                    ArrayList<Fragment> arrayList3 = new ArrayList<>();
                    this.mAdded = arrayList2;
                }
                if (this.mAdded.contains(fragment2)) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    StringBuilder sb6 = sb2;
                    StringBuilder sb7 = new StringBuilder();
                    IllegalStateException illegalStateException3 = new IllegalStateException(sb6.append("Fragment already added: ").append(fragment2).toString());
                    throw illegalStateException2;
                }
                if (DEBUG) {
                    String str2 = TAG;
                    StringBuilder sb8 = sb;
                    StringBuilder sb9 = new StringBuilder();
                    int v2 = Log.v(str2, sb8.append("add from attach: ").append(fragment2).toString());
                }
                boolean add = this.mAdded.add(fragment2);
                fragment2.mAdded = true;
                if (fragment2.mHasMenu && fragment2.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
                moveToState(fragment2, this.mCurState, i3, i4, false);
            }
        }
    }

    public FragmentTransaction beginTransaction() {
        BackStackRecord backStackRecord;
        BackStackRecord backStackRecord2 = backStackRecord;
        BackStackRecord backStackRecord3 = new BackStackRecord(this);
        return backStackRecord2;
    }

    public void detachFragment(Fragment fragment, int i, int i2) {
        StringBuilder sb;
        StringBuilder sb2;
        Fragment fragment2 = fragment;
        int i3 = i;
        int i4 = i2;
        if (DEBUG) {
            String str = TAG;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            int v = Log.v(str, sb3.append("detach: ").append(fragment2).toString());
        }
        if (!fragment2.mDetached) {
            fragment2.mDetached = true;
            if (fragment2.mAdded) {
                if (this.mAdded != null) {
                    if (DEBUG) {
                        String str2 = TAG;
                        StringBuilder sb5 = sb;
                        StringBuilder sb6 = new StringBuilder();
                        int v2 = Log.v(str2, sb5.append("remove from detach: ").append(fragment2).toString());
                    }
                    boolean remove = this.mAdded.remove(fragment2);
                }
                if (fragment2.mHasMenu && fragment2.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
                fragment2.mAdded = false;
                moveToState(fragment2, 1, i3, i4, false);
            }
        }
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        moveToState(2, false);
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        Configuration configuration2 = configuration;
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performConfigurationChanged(configuration2);
                }
            }
        }
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null && fragment.performContextItemSelected(menuItem2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        moveToState(1, false);
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        ArrayList<Fragment> arrayList;
        Menu menu2 = menu;
        MenuInflater menuInflater2 = menuInflater;
        ArrayList<Fragment> arrayList2 = null;
        boolean z = false;
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null && fragment.performCreateOptionsMenu(menu2, menuInflater2)) {
                    z = true;
                    if (arrayList2 == null) {
                        ArrayList<Fragment> arrayList3 = arrayList;
                        ArrayList<Fragment> arrayList4 = new ArrayList<>();
                        arrayList2 = arrayList3;
                    }
                    boolean add = arrayList2.add(fragment);
                }
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i2 = 0; i2 < this.mCreatedMenus.size(); i2++) {
                Fragment fragment2 = (Fragment) this.mCreatedMenus.get(i2);
                if (arrayList2 == null || !arrayList2.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList2;
        return z;
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        boolean execPendingActions = execPendingActions();
        moveToState(0, false);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
    }

    public void dispatchDestroyView() {
        moveToState(1, false);
    }

    public void dispatchLowMemory() {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performLowMemory();
                }
            }
        }
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null && fragment.performOptionsItemSelected(menuItem2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        Menu menu2 = menu;
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu2);
                }
            }
        }
    }

    public void dispatchPause() {
        moveToState(4, false);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        Menu menu2 = menu;
        boolean z = false;
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null && fragment.performPrepareOptionsMenu(menu2)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public void dispatchReallyStop() {
        moveToState(2, false);
    }

    public void dispatchResume() {
        this.mStateSaved = false;
        moveToState(5, false);
    }

    public void dispatchStart() {
        this.mStateSaved = false;
        moveToState(4, false);
    }

    public void dispatchStop() {
        this.mStateSaved = true;
        moveToState(3, false);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        StringBuilder sb;
        String str2 = str;
        FileDescriptor fileDescriptor2 = fileDescriptor;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        String sb4 = sb2.append(str2).append("    ").toString();
        if (this.mActive != null) {
            int size = this.mActive.size();
            if (size > 0) {
                printWriter2.print(str2);
                printWriter2.print("Active Fragments in ");
                printWriter2.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter2.println(":");
                for (int i = 0; i < size; i++) {
                    Fragment fragment = (Fragment) this.mActive.get(i);
                    printWriter2.print(str2);
                    printWriter2.print("  #");
                    printWriter2.print(i);
                    printWriter2.print(": ");
                    printWriter2.println(fragment);
                    if (fragment != null) {
                        fragment.dump(sb4, fileDescriptor2, printWriter2, strArr2);
                    }
                }
            }
        }
        if (this.mAdded != null) {
            int size2 = this.mAdded.size();
            if (size2 > 0) {
                printWriter2.print(str2);
                printWriter2.println("Added Fragments:");
                for (int i2 = 0; i2 < size2; i2++) {
                    Fragment fragment2 = (Fragment) this.mAdded.get(i2);
                    printWriter2.print(str2);
                    printWriter2.print("  #");
                    printWriter2.print(i2);
                    printWriter2.print(": ");
                    printWriter2.println(fragment2.toString());
                }
            }
        }
        if (this.mCreatedMenus != null) {
            int size3 = this.mCreatedMenus.size();
            if (size3 > 0) {
                printWriter2.print(str2);
                printWriter2.println("Fragments Created Menus:");
                for (int i3 = 0; i3 < size3; i3++) {
                    Fragment fragment3 = (Fragment) this.mCreatedMenus.get(i3);
                    printWriter2.print(str2);
                    printWriter2.print("  #");
                    printWriter2.print(i3);
                    printWriter2.print(": ");
                    printWriter2.println(fragment3.toString());
                }
            }
        }
        if (this.mBackStack != null) {
            int size4 = this.mBackStack.size();
            if (size4 > 0) {
                printWriter2.print(str2);
                printWriter2.println("Back Stack:");
                for (int i4 = 0; i4 < size4; i4++) {
                    BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(i4);
                    printWriter2.print(str2);
                    printWriter2.print("  #");
                    printWriter2.print(i4);
                    printWriter2.print(": ");
                    printWriter2.println(backStackRecord.toString());
                    backStackRecord.dump(sb4, fileDescriptor2, printWriter2, strArr2);
                }
            }
        }
        synchronized (this) {
            try {
                if (this.mBackStackIndices != null) {
                    th = this.mBackStackIndices.size();
                    if (this > 0) {
                        printWriter2.print(str2);
                        printWriter2.println("Back Stack Indices:");
                        for (int i5 = 0; i5 < this; i5++) {
                            BackStackRecord backStackRecord2 = (BackStackRecord) this.mBackStackIndices.get(i5);
                            printWriter2.print(str2);
                            printWriter2.print("  #");
                            printWriter2.print(i5);
                            printWriter2.print(": ");
                            printWriter2.println(backStackRecord2);
                        }
                    }
                }
                if (this.mAvailBackStackIndices != null) {
                    if (this.mAvailBackStackIndices.size() > 0) {
                        printWriter2.print(str2);
                        printWriter2.print("mAvailBackStackIndices: ");
                        printWriter2.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
                    }
                }
            } finally {
                while (true) {
                    Throwable th = th;
                    Throwable th2 = th;
                }
            }
        }
        if (this.mPendingActions != null) {
            int size5 = this.mPendingActions.size();
            if (size5 > 0) {
                printWriter2.print(str2);
                printWriter2.println("Pending Actions:");
                for (int i6 = 0; i6 < size5; i6++) {
                    Runnable runnable = (Runnable) this.mPendingActions.get(i6);
                    printWriter2.print(str2);
                    printWriter2.print("  #");
                    printWriter2.print(i6);
                    printWriter2.print(": ");
                    printWriter2.println(runnable);
                }
            }
        }
        printWriter2.print(str2);
        printWriter2.println("FragmentManager misc state:");
        printWriter2.print(str2);
        printWriter2.print("  mHost=");
        printWriter2.println(this.mHost);
        printWriter2.print(str2);
        printWriter2.print("  mContainer=");
        printWriter2.println(this.mContainer);
        if (this.mParent != null) {
            printWriter2.print(str2);
            printWriter2.print("  mParent=");
            printWriter2.println(this.mParent);
        }
        printWriter2.print(str2);
        printWriter2.print("  mCurState=");
        printWriter2.print(this.mCurState);
        printWriter2.print(" mStateSaved=");
        printWriter2.print(this.mStateSaved);
        printWriter2.print(" mDestroyed=");
        printWriter2.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter2.print(str2);
            printWriter2.print("  mNeedMenuInvalidate=");
            printWriter2.println(this.mNeedMenuInvalidate);
        }
        if (this.mNoTransactionsBecause != null) {
            printWriter2.print(str2);
            printWriter2.print("  mNoTransactionsBecause=");
            printWriter2.println(this.mNoTransactionsBecause);
        }
        if (this.mAvailIndices != null) {
            if (this.mAvailIndices.size() > 0) {
                printWriter2.print(str2);
                printWriter2.print("  mAvailIndices: ");
                printWriter2.println(Arrays.toString(this.mAvailIndices.toArray()));
            }
        }
    }

    public void enqueueAction(Runnable runnable, boolean z) {
        IllegalStateException illegalStateException;
        ArrayList<Runnable> arrayList;
        Runnable runnable2 = runnable;
        if (!z) {
            checkStateLoss();
        }
        synchronized (this) {
            try {
                if (this.mDestroyed || this.mHost == null) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Activity has been destroyed");
                    throw illegalStateException2;
                }
                if (this.mPendingActions == null) {
                    ArrayList<Runnable> arrayList2 = arrayList;
                    ArrayList<Runnable> arrayList3 = new ArrayList<>();
                    this.mPendingActions = arrayList2;
                }
                boolean add = this.mPendingActions.add(runnable2);
                if (this.mPendingActions.size() == 1) {
                    this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                    boolean post = this.mHost.getHandler().post(this.mExecCommit);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ad, code lost:
        r0.mExecutingActions = true;
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b5, code lost:
        if (r8 >= r6) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b7, code lost:
        r0.mTmpActions[r8].run();
        r0.mTmpActions[r8] = null;
        r8 = r8 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean execPendingActions() {
        /*
            r13 = this;
            r0 = r13
            r9 = r0
            boolean r9 = r9.mExecutingActions
            if (r9 == 0) goto L_0x0011
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r12 = r9
            r9 = r12
            r10 = r12
            java.lang.String r11 = "Recursive entry to executePendingTransactions"
            r10.<init>(r11)
            throw r9
        L_0x0011:
            android.os.Looper r9 = android.os.Looper.myLooper()
            r10 = r0
            android.support.v4.app.FragmentHostCallback r10 = r10.mHost
            android.os.Handler r10 = r10.getHandler()
            android.os.Looper r10 = r10.getLooper()
            if (r9 == r10) goto L_0x002d
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r12 = r9
            r9 = r12
            r10 = r12
            java.lang.String r11 = "Must be called from main thread of process"
            r10.<init>(r11)
            throw r9
        L_0x002d:
            r9 = 0
            r1 = r9
        L_0x002f:
            r9 = r0
            monitor-enter(r9)
            r9 = r0
            java.util.ArrayList<java.lang.Runnable> r9 = r9.mPendingActions     // Catch:{ all -> 0x00ca }
            if (r9 == 0) goto L_0x003f
            r9 = r0
            java.util.ArrayList<java.lang.Runnable> r9 = r9.mPendingActions     // Catch:{ all -> 0x00ca }
            int r9 = r9.size()     // Catch:{ all -> 0x00ca }
            if (r9 != 0) goto L_0x0074
        L_0x003f:
            r9 = r0
            monitor-exit(r9)     // Catch:{ all -> 0x00ca }
            r9 = r0
            boolean r9 = r9.mHavePendingDeferredStart
            if (r9 == 0) goto L_0x00e3
            r9 = 0
            r3 = r9
            r9 = 0
            r4 = r9
        L_0x004a:
            r9 = r4
            r10 = r0
            java.util.ArrayList<android.support.v4.app.Fragment> r10 = r10.mActive
            int r10 = r10.size()
            if (r9 >= r10) goto L_0x00d8
            r9 = r0
            java.util.ArrayList<android.support.v4.app.Fragment> r9 = r9.mActive
            r10 = r4
            java.lang.Object r9 = r9.get(r10)
            android.support.v4.app.Fragment r9 = (android.support.p000v4.app.Fragment) r9
            r5 = r9
            r9 = r5
            if (r9 == 0) goto L_0x0071
            r9 = r5
            android.support.v4.app.LoaderManagerImpl r9 = r9.mLoaderManager
            if (r9 == 0) goto L_0x0071
            r9 = r3
            r10 = r5
            android.support.v4.app.LoaderManagerImpl r10 = r10.mLoaderManager
            boolean r10 = r10.hasRunningLoaders()
            r9 = r9 | r10
            r3 = r9
        L_0x0071:
            int r4 = r4 + 1
            goto L_0x004a
        L_0x0074:
            r9 = r0
            java.util.ArrayList<java.lang.Runnable> r9 = r9.mPendingActions     // Catch:{ all -> 0x00ca }
            int r9 = r9.size()     // Catch:{ all -> 0x00ca }
            r6 = r9
            r9 = r0
            java.lang.Runnable[] r9 = r9.mTmpActions     // Catch:{ all -> 0x00ca }
            if (r9 == 0) goto L_0x0088
            r9 = r0
            java.lang.Runnable[] r9 = r9.mTmpActions     // Catch:{ all -> 0x00ca }
            int r9 = r9.length     // Catch:{ all -> 0x00ca }
            r10 = r6
            if (r9 >= r10) goto L_0x008e
        L_0x0088:
            r9 = r0
            r10 = r6
            java.lang.Runnable[] r10 = new java.lang.Runnable[r10]     // Catch:{ all -> 0x00ca }
            r9.mTmpActions = r10     // Catch:{ all -> 0x00ca }
        L_0x008e:
            r9 = r0
            java.util.ArrayList<java.lang.Runnable> r9 = r9.mPendingActions     // Catch:{ all -> 0x00ca }
            r10 = r0
            java.lang.Runnable[] r10 = r10.mTmpActions     // Catch:{ all -> 0x00ca }
            java.lang.Object[] r9 = r9.toArray(r10)     // Catch:{ all -> 0x00ca }
            r9 = r0
            java.util.ArrayList<java.lang.Runnable> r9 = r9.mPendingActions     // Catch:{ all -> 0x00ca }
            r9.clear()     // Catch:{ all -> 0x00ca }
            r9 = r0
            android.support.v4.app.FragmentHostCallback r9 = r9.mHost     // Catch:{ all -> 0x00ca }
            android.os.Handler r9 = r9.getHandler()     // Catch:{ all -> 0x00ca }
            r10 = r0
            java.lang.Runnable r10 = r10.mExecCommit     // Catch:{ all -> 0x00ca }
            r9.removeCallbacks(r10)     // Catch:{ all -> 0x00ca }
            r9 = r0
            monitor-exit(r9)     // Catch:{ all -> 0x00ca }
            r9 = r0
            r10 = 1
            r9.mExecutingActions = r10
            r9 = 0
            r8 = r9
        L_0x00b3:
            r9 = r8
            r10 = r6
            if (r9 >= r10) goto L_0x00d0
            r9 = r0
            java.lang.Runnable[] r9 = r9.mTmpActions
            r10 = r8
            r9 = r9[r10]
            r9.run()
            r9 = r0
            java.lang.Runnable[] r9 = r9.mTmpActions
            r10 = r8
            r11 = 0
            r9[r10] = r11
            int r8 = r8 + 1
            goto L_0x00b3
        L_0x00ca:
            r9 = move-exception
            r2 = r9
            r9 = r0
            monitor-exit(r9)     // Catch:{ all -> 0x00ca }
            r9 = r2
            throw r9
        L_0x00d0:
            r9 = r0
            r10 = 0
            r9.mExecutingActions = r10
            r9 = 1
            r1 = r9
            goto L_0x002f
        L_0x00d8:
            r9 = r3
            if (r9 != 0) goto L_0x00e3
            r9 = r0
            r10 = 0
            r9.mHavePendingDeferredStart = r10
            r9 = r0
            r9.startPendingDeferredFragments()
        L_0x00e3:
            r9 = r1
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.FragmentManagerImpl.execPendingActions():boolean");
    }

    public boolean executePendingTransactions() {
        return execPendingActions();
    }

    public Fragment findFragmentById(int i) {
        Fragment fragment;
        int i2 = i;
        if (this.mAdded != null) {
            int size = -1 + this.mAdded.size();
            while (true) {
                if (size < 0) {
                    break;
                }
                fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null && fragment.mFragmentId == i2) {
                    break;
                }
                size--;
            }
            return fragment;
        }
        if (this.mActive != null) {
            for (int size2 = -1 + this.mActive.size(); size2 >= 0; size2--) {
                fragment = (Fragment) this.mActive.get(size2);
                if (fragment != null && fragment.mFragmentId == i2) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment findFragmentByTag(String str) {
        Fragment fragment;
        String str2 = str;
        if (this.mAdded != null && str2 != null) {
            int size = -1 + this.mAdded.size();
            while (true) {
                if (size < 0) {
                    break;
                }
                fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null && str2.equals(fragment.mTag)) {
                    break;
                }
                size--;
            }
            return fragment;
        }
        if (!(this.mActive == null || str2 == null)) {
            for (int size2 = -1 + this.mActive.size(); size2 >= 0; size2--) {
                fragment = (Fragment) this.mActive.get(size2);
                if (fragment != null && str2.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment findFragmentByWho(String str) {
        String str2 = str;
        if (!(this.mActive == null || str2 == null)) {
            for (int size = -1 + this.mActive.size(); size >= 0; size--) {
                Fragment fragment = (Fragment) this.mActive.get(size);
                if (fragment != null) {
                    Fragment findFragmentByWho = fragment.findFragmentByWho(str2);
                    if (findFragmentByWho != null) {
                        return findFragmentByWho;
                    }
                }
            }
        }
        return null;
    }

    public void freeBackStackIndex(int i) {
        StringBuilder sb;
        ArrayList<Integer> arrayList;
        int i2 = i;
        synchronized (this) {
            try {
                Object obj = this.mBackStackIndices.set(i2, null);
                if (this.mAvailBackStackIndices == null) {
                    ArrayList<Integer> arrayList2 = arrayList;
                    ArrayList<Integer> arrayList3 = new ArrayList<>();
                    this.mAvailBackStackIndices = arrayList2;
                }
                if (DEBUG) {
                    String str = TAG;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int v = Log.v(str, sb2.append("Freeing back stack index ").append(i2).toString());
                }
                boolean add = this.mAvailBackStackIndices.add(Integer.valueOf(i2));
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public BackStackEntry getBackStackEntryAt(int i) {
        return (BackStackEntry) this.mBackStack.get(i);
    }

    public int getBackStackEntryCount() {
        if (this.mBackStack != null) {
            return this.mBackStack.size();
        }
        return 0;
    }

    public Fragment getFragment(Bundle bundle, String str) {
        Fragment fragment;
        IllegalStateException illegalStateException;
        StringBuilder sb;
        IllegalStateException illegalStateException2;
        StringBuilder sb2;
        String str2 = str;
        int i = bundle.getInt(str2, -1);
        if (i == -1) {
            fragment = null;
        } else {
            if (i >= this.mActive.size()) {
                IllegalStateException illegalStateException3 = illegalStateException2;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                IllegalStateException illegalStateException4 = new IllegalStateException(sb3.append("Fragment no longer exists for key ").append(str2).append(": index ").append(i).toString());
                throwException(illegalStateException3);
            }
            fragment = (Fragment) this.mActive.get(i);
            if (fragment == null) {
                IllegalStateException illegalStateException5 = illegalStateException;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                IllegalStateException illegalStateException6 = new IllegalStateException(sb5.append("Fragment no longer exists for key ").append(str2).append(": index ").append(i).toString());
                throwException(illegalStateException5);
                return fragment;
            }
        }
        return fragment;
    }

    public List<Fragment> getFragments() {
        return this.mActive;
    }

    /* access modifiers changed from: 0000 */
    public LayoutInflaterFactory getLayoutInflaterFactory() {
        return this;
    }

    public void hideFragment(Fragment fragment, int i, int i2) {
        StringBuilder sb;
        Fragment fragment2 = fragment;
        int i3 = i;
        int i4 = i2;
        if (DEBUG) {
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int v = Log.v(str, sb2.append("hide: ").append(fragment2).toString());
        }
        if (!fragment2.mHidden) {
            fragment2.mHidden = true;
            if (fragment2.mView != null) {
                Animation loadAnimation = loadAnimation(fragment2, i3, false, i4);
                if (loadAnimation != null) {
                    setHWLayerAnimListenerIfAlpha(fragment2.mView, loadAnimation);
                    fragment2.mView.startAnimation(loadAnimation);
                }
                fragment2.mView.setVisibility(8);
            }
            if (fragment2.mAdded && fragment2.mHasMenu && fragment2.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment2.onHiddenChanged(true);
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    /* access modifiers changed from: 0000 */
    public Animation loadAnimation(Fragment fragment, int i, boolean z, int i2) {
        Fragment fragment2 = fragment;
        int i3 = i;
        boolean z2 = z;
        int i4 = i2;
        Animation onCreateAnimation = fragment2.onCreateAnimation(i3, z2, fragment2.mNextAnim);
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (fragment2.mNextAnim != 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mHost.getContext(), fragment2.mNextAnim);
            if (loadAnimation != null) {
                return loadAnimation;
            }
        }
        if (i3 == 0) {
            return null;
        }
        int transitToStyleIndex = transitToStyleIndex(i3, z2);
        if (transitToStyleIndex < 0) {
            return null;
        }
        switch (transitToStyleIndex) {
            case 1:
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return makeOpenCloseAnimation(this.mHost.getContext(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return makeFadeAnimation(this.mHost.getContext(), 0.0f, 1.0f);
            case 6:
                return makeFadeAnimation(this.mHost.getContext(), 1.0f, 0.0f);
            default:
                if (i4 == 0 && this.mHost.onHasWindowAnimations()) {
                    i4 = this.mHost.onGetWindowAnimations();
                }
                return i4 == 0 ? null : null;
        }
    }

    /* access modifiers changed from: 0000 */
    public void makeActive(Fragment fragment) {
        StringBuilder sb;
        ArrayList<Fragment> arrayList;
        Fragment fragment2 = fragment;
        if (fragment2.mIndex < 0) {
            if (this.mAvailIndices == null || this.mAvailIndices.size() <= 0) {
                if (this.mActive == null) {
                    ArrayList<Fragment> arrayList2 = arrayList;
                    ArrayList<Fragment> arrayList3 = new ArrayList<>();
                    this.mActive = arrayList2;
                }
                fragment2.setIndex(this.mActive.size(), this.mParent);
                boolean add = this.mActive.add(fragment2);
            } else {
                fragment2.setIndex(((Integer) this.mAvailIndices.remove(-1 + this.mAvailIndices.size())).intValue(), this.mParent);
                Object obj = this.mActive.set(fragment2.mIndex, fragment2);
            }
            if (DEBUG) {
                String str = TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int v = Log.v(str, sb2.append("Allocated fragment index ").append(fragment2).toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void makeInactive(Fragment fragment) {
        ArrayList<Integer> arrayList;
        StringBuilder sb;
        Fragment fragment2 = fragment;
        if (fragment2.mIndex >= 0) {
            if (DEBUG) {
                String str = TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int v = Log.v(str, sb2.append("Freeing fragment index ").append(fragment2).toString());
            }
            Object obj = this.mActive.set(fragment2.mIndex, null);
            if (this.mAvailIndices == null) {
                ArrayList<Integer> arrayList2 = arrayList;
                ArrayList<Integer> arrayList3 = new ArrayList<>();
                this.mAvailIndices = arrayList2;
            }
            boolean add = this.mAvailIndices.add(Integer.valueOf(fragment2.mIndex));
            this.mHost.inactivateFragment(fragment2.mWho);
            fragment2.initState();
        }
    }

    /* access modifiers changed from: 0000 */
    public void moveToState(int i, int i2, int i3, boolean z) {
        IllegalStateException illegalStateException;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        boolean z2 = z;
        if (this.mHost == null && i4 != 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No host");
            throw illegalStateException2;
        } else if (z2 || this.mCurState != i4) {
            this.mCurState = i4;
            if (this.mActive != null) {
                boolean z3 = false;
                for (int i7 = 0; i7 < this.mActive.size(); i7++) {
                    Fragment fragment = (Fragment) this.mActive.get(i7);
                    if (fragment != null) {
                        moveToState(fragment, i4, i5, i6, false);
                        if (fragment.mLoaderManager != null) {
                            z3 |= fragment.mLoaderManager.hasRunningLoaders();
                        }
                    }
                }
                if (!z3) {
                    startPendingDeferredFragments();
                }
                if (this.mNeedMenuInvalidate && this.mHost != null && this.mCurState == 5) {
                    this.mHost.onSupportInvalidateOptionsMenu();
                    this.mNeedMenuInvalidate = false;
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void moveToState(int i, boolean z) {
        moveToState(i, 0, 0, z);
    }

    /* access modifiers changed from: 0000 */
    public void moveToState(Fragment fragment) {
        moveToState(fragment, this.mCurState, 0, 0, false);
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r24v0 */
    /* JADX WARNING: type inference failed for: r0v0, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v2 */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v4 */
    /* JADX WARNING: type inference failed for: r0v4, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v6 */
    /* JADX WARNING: type inference failed for: r0v6, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v8 */
    /* JADX WARNING: type inference failed for: r0v9, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v10 */
    /* JADX WARNING: type inference failed for: r0v12, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v15 */
    /* JADX WARNING: type inference failed for: r0v17, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v18 */
    /* JADX WARNING: type inference failed for: r0v19, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v20 */
    /* JADX WARNING: type inference failed for: r1v3, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v21, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v22 */
    /* JADX WARNING: type inference failed for: r0v22, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v25 */
    /* JADX WARNING: type inference failed for: r0v24, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v27 */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v28 */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v29 */
    /* JADX WARNING: type inference failed for: r1v6, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v30 */
    /* JADX WARNING: type inference failed for: r1v7, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v8, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r27v2, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r24v34, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r26v8, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r24v37 */
    /* JADX WARNING: type inference failed for: r1v8, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v39 */
    /* JADX WARNING: type inference failed for: r0v31, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v41 */
    /* JADX WARNING: type inference failed for: r0v33, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v43 */
    /* JADX WARNING: type inference failed for: r1v9, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v47 */
    /* JADX WARNING: type inference failed for: r0v37, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v49, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v50 */
    /* JADX WARNING: type inference failed for: r0v39, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v52 */
    /* JADX WARNING: type inference failed for: r1v11, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v53 */
    /* JADX WARNING: type inference failed for: r1v12, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v54 */
    /* JADX WARNING: type inference failed for: r1v13, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v55 */
    /* JADX WARNING: type inference failed for: r0v44, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v62 */
    /* JADX WARNING: type inference failed for: r0v48, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v21 */
    /* JADX WARNING: type inference failed for: r0v50, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v64 */
    /* JADX WARNING: type inference failed for: r25v23 */
    /* JADX WARNING: type inference failed for: r0v52, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r1v14, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v65 */
    /* JADX WARNING: type inference failed for: r1v15, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r28v0 */
    /* JADX WARNING: type inference failed for: r0v56, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r30v0, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v67 */
    /* JADX WARNING: type inference failed for: r0v58, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v29, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v30, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v78 */
    /* JADX WARNING: type inference failed for: r0v64, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v31, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r26v13, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r24v85, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r26v16, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r24v90, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r26v19, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r24v95, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v96 */
    /* JADX WARNING: type inference failed for: r1v19, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r26v22, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r24v99 */
    /* JADX WARNING: type inference failed for: r1v20, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v100 */
    /* JADX WARNING: type inference failed for: r0v71, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v102 */
    /* JADX WARNING: type inference failed for: r0v73, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v104 */
    /* JADX WARNING: type inference failed for: r0v75, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v108 */
    /* JADX WARNING: type inference failed for: r1v22, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v109, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v110 */
    /* JADX WARNING: type inference failed for: r1v23, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v111 */
    /* JADX WARNING: type inference failed for: r1v24, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r26v25, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r24v116, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r26v28, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r24v121 */
    /* JADX WARNING: type inference failed for: r0v83, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v123, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v73 */
    /* JADX WARNING: type inference failed for: r0v85, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v124 */
    /* JADX WARNING: type inference failed for: r0v87, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v126 */
    /* JADX WARNING: type inference failed for: r1v27, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v127, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v76 */
    /* JADX WARNING: type inference failed for: r0v90, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v128 */
    /* JADX WARNING: type inference failed for: r0v92, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v132 */
    /* JADX WARNING: type inference failed for: r1v28, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v133 */
    /* JADX WARNING: type inference failed for: r25v79, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r26v29, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r27v6 */
    /* JADX WARNING: type inference failed for: r0v95, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r28v3 */
    /* JADX WARNING: type inference failed for: r0v97, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r1v29, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v134 */
    /* JADX WARNING: type inference failed for: r0v100, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v136 */
    /* JADX WARNING: type inference failed for: r1v30, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v137 */
    /* JADX WARNING: type inference failed for: r25v82 */
    /* JADX WARNING: type inference failed for: r0v103, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r1v31, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v139 */
    /* JADX WARNING: type inference failed for: r25v85 */
    /* JADX WARNING: type inference failed for: r0v107, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r1v33, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v141 */
    /* JADX WARNING: type inference failed for: r0v110, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v143, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v88 */
    /* JADX WARNING: type inference failed for: r0v112, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r26v31 */
    /* JADX WARNING: type inference failed for: r0v114, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v144 */
    /* JADX WARNING: type inference failed for: r0v116, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v91, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v92 */
    /* JADX WARNING: type inference failed for: r0v118, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v94 */
    /* JADX WARNING: type inference failed for: r0v120, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v151 */
    /* JADX WARNING: type inference failed for: r0v122, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v153 */
    /* JADX WARNING: type inference failed for: r0v124, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v98 */
    /* JADX WARNING: type inference failed for: r0v128, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v160 */
    /* JADX WARNING: type inference failed for: r0v130, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r28v8 */
    /* JADX WARNING: type inference failed for: r0v132, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r28v12, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r29v1 */
    /* JADX WARNING: type inference failed for: r0v134, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r28v16, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r26v38, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r24v166 */
    /* JADX WARNING: type inference failed for: r0v136, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v168 */
    /* JADX WARNING: type inference failed for: r1v34, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v169 */
    /* JADX WARNING: type inference failed for: r1v35, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v175 */
    /* JADX WARNING: type inference failed for: r1v36, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v176 */
    /* JADX WARNING: type inference failed for: r1v37, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v177, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v178 */
    /* JADX WARNING: type inference failed for: r0v152, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v180 */
    /* JADX WARNING: type inference failed for: r0v154, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v182 */
    /* JADX WARNING: type inference failed for: r0v156, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v184 */
    /* JADX WARNING: type inference failed for: r1v38, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v185 */
    /* JADX WARNING: type inference failed for: r0v159, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v187 */
    /* JADX WARNING: type inference failed for: r25v117, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r26v39, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r27v19 */
    /* JADX WARNING: type inference failed for: r0v161, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r28v17 */
    /* JADX WARNING: type inference failed for: r0v163, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r1v39, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v188 */
    /* JADX WARNING: type inference failed for: r0v166, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v190 */
    /* JADX WARNING: type inference failed for: r1v40, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v191 */
    /* JADX WARNING: type inference failed for: r25v120 */
    /* JADX WARNING: type inference failed for: r0v169, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r1v41, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v193 */
    /* JADX WARNING: type inference failed for: r25v123 */
    /* JADX WARNING: type inference failed for: r0v173, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r1v43, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v194 */
    /* JADX WARNING: type inference failed for: r0v176, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v196, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v126 */
    /* JADX WARNING: type inference failed for: r0v178, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r26v41 */
    /* JADX WARNING: type inference failed for: r0v180, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v197 */
    /* JADX WARNING: type inference failed for: r0v182, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v199 */
    /* JADX WARNING: type inference failed for: r0v184, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v201, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v130 */
    /* JADX WARNING: type inference failed for: r0v186, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v132, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r27v24, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r24v209 */
    /* JADX WARNING: type inference failed for: r0v194, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v211 */
    /* JADX WARNING: type inference failed for: r25v138 */
    /* JADX WARNING: type inference failed for: r0v198, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r1v44, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v212 */
    /* JADX WARNING: type inference failed for: r26v50 */
    /* JADX WARNING: type inference failed for: r0v201, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r1v45, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v213 */
    /* JADX WARNING: type inference failed for: r0v204, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v215 */
    /* JADX WARNING: type inference failed for: r25v143 */
    /* JADX WARNING: type inference failed for: r0v206, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r1v46, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v216 */
    /* JADX WARNING: type inference failed for: r0v209, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v218 */
    /* JADX WARNING: type inference failed for: r1v47, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v221 */
    /* JADX WARNING: type inference failed for: r25v148 */
    /* JADX WARNING: type inference failed for: r0v213, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r1v49, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r26v56, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r24v224 */
    /* JADX WARNING: type inference failed for: r1v50, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v157, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r26v57 */
    /* JADX WARNING: type inference failed for: r0v217, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v226 */
    /* JADX WARNING: type inference failed for: r0v219, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v228 */
    /* JADX WARNING: type inference failed for: r0v221, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r25v160 */
    /* JADX WARNING: type inference failed for: r0v225, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v233 */
    /* JADX WARNING: type inference failed for: r0v228, types: [android.support.v4.app.Fragment] */
    /* JADX WARNING: type inference failed for: r24v237 */
    /* JADX WARNING: type inference failed for: r0v231, types: [android.support.v4.app.Fragment] */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x04cf, code lost:
        r3.restoreViewState(r3.mSavedFragmentState);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x04dc, code lost:
        r3.mSavedFragmentState = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x04ee, code lost:
        if (r4 <= 3) goto L_0x051a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x04f2, code lost:
        if (DEBUG == false) goto L_0x0515;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x04f4, code lost:
        r24 = TAG;
        r25 = r31;
        r26 = new java.lang.StringBuilder();
        r24 = android.util.Log.v(r24, r25.append("moveto STARTED: ").append(r3).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0515, code lost:
        r3.performStart();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0522, code lost:
        if (r4 <= 4) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0526, code lost:
        if (DEBUG == false) goto L_0x0549;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0528, code lost:
        r24 = TAG;
        r25 = r31;
        r26 = new java.lang.StringBuilder();
        r24 = android.util.Log.v(r24, r25.append("moveto RESUMED: ").append(r3).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0549, code lost:
        r3.mResumed = true;
        r3.performResume();
        r3.mSavedFragmentState = null;
        r3.mSavedViewState = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0590, code lost:
        r3.mView = android.support.p000v4.app.NoSaveStateFrameLayout.wrap(r3.mView);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x05a6, code lost:
        r3.mInnerView = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0615, code lost:
        if (r4 >= 4) goto L_0x0641;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0619, code lost:
        if (DEBUG == false) goto L_0x063c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x061b, code lost:
        r24 = TAG;
        r25 = r31;
        r26 = new java.lang.StringBuilder();
        r24 = android.util.Log.v(r24, r25.append("movefrom STARTED: ").append(r3).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x063c, code lost:
        r3.performStop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0649, code lost:
        if (r4 >= 3) goto L_0x0675;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x064d, code lost:
        if (DEBUG == false) goto L_0x0670;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x064f, code lost:
        r24 = TAG;
        r25 = r31;
        r26 = new java.lang.StringBuilder();
        r24 = android.util.Log.v(r24, r25.append("movefrom STOPPED: ").append(r3).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0670, code lost:
        r3.performReallyStop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x067d, code lost:
        if (r4 >= 2) goto L_0x0796;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0681, code lost:
        if (DEBUG == false) goto L_0x06a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0683, code lost:
        r24 = TAG;
        r25 = r31;
        r26 = new java.lang.StringBuilder();
        r24 = android.util.Log.v(r24, r25.append("movefrom ACTIVITY_CREATED: ").append(r3).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x06ac, code lost:
        if (r3.mView == null) goto L_0x06cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x06bc, code lost:
        if (r2.mHost.onShouldSaveFragmentState(r3) == false) goto L_0x06cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x06c6, code lost:
        if (r3.mSavedViewState != null) goto L_0x06cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x06c8, code lost:
        saveFragmentViewState(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x06cf, code lost:
        r3.performDestroyView();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x06dc, code lost:
        if (r3.mView == null) goto L_0x0778;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x06e6, code lost:
        if (r3.mContainer == null) goto L_0x0778;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x06e8, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x06f8, code lost:
        if (r2.mCurState <= 0) goto L_0x071c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x06fa, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x070a, code lost:
        if (r2.mDestroyed != false) goto L_0x071c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x070c, code lost:
        r11 = loadAnimation(r3, r5, false, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x071e, code lost:
        if (r11 == null) goto L_0x0765;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0720, code lost:
        r3.mAnimatingAway = r3.mView;
        r3.mStateAfterAnimating = r4;
        r24 = r11;
        r25 = r31;
        r30 = r3;
        r26 = new android.support.p000v4.app.FragmentManagerImpl.C00175(r2, r3.mView, r11);
        r24.setAnimationListener(r25);
        r3.mView.startAnimation(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0765, code lost:
        r3.mContainer.removeView(r3.mView);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0778, code lost:
        r3.mContainer = null;
        r3.mView = null;
        r3.mInnerView = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x079e, code lost:
        if (r4 >= 1) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x07a8, code lost:
        if (r2.mDestroyed == false) goto L_0x07cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x07b2, code lost:
        if (r3.mAnimatingAway == null) goto L_0x07cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x07b4, code lost:
        r9 = r3.mAnimatingAway;
        r3.mAnimatingAway = null;
        r9.clearAnimation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x07d5, code lost:
        if (r3.mAnimatingAway == null) goto L_0x07e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x07d7, code lost:
        r3.mStateAfterAnimating = r4;
        r4 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x07e9, code lost:
        if (DEBUG == false) goto L_0x080c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x07eb, code lost:
        r24 = TAG;
        r25 = r31;
        r26 = new java.lang.StringBuilder();
        r24 = android.util.Log.v(r24, r25.append("movefrom CREATED: ").append(r3).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0814, code lost:
        if (r3.mRetaining != false) goto L_0x081b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0816, code lost:
        r3.performDestroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x081b, code lost:
        r3.mCalled = false;
        r3.onDetach();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0832, code lost:
        if (r3.mCalled != false) goto L_0x0861;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0834, code lost:
        r24 = r31;
        r26 = r31;
        r27 = new java.lang.StringBuilder();
        r25 = new android.support.p000v4.app.SuperNotCalledException(r26.append("Fragment ").append(r3).append(" did not call through to super.onDetach()").toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0860, code lost:
        throw r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0863, code lost:
        if (r7 != false) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x086d, code lost:
        if (r3.mRetaining != false) goto L_0x0878;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x086f, code lost:
        makeInactive(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0878, code lost:
        r3.mHost = null;
        r3.mParentFragment = null;
        r3.mFragmentManager = null;
        r3.mChildFragmentManager = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0324, code lost:
        if (r4 <= 1) goto L_0x04e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0328, code lost:
        if (DEBUG == false) goto L_0x034b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x032a, code lost:
        r24 = TAG;
        r25 = r31;
        r26 = new java.lang.StringBuilder();
        r24 = android.util.Log.v(r24, r25.append("moveto ACTIVITY_CREATED: ").append(r3).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0353, code lost:
        if (r3.mFromLayout != false) goto L_0x04b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0355, code lost:
        r20 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0365, code lost:
        if (r3.mContainerId == 0) goto L_0x03ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0367, code lost:
        r20 = (android.view.ViewGroup) r2.mContainer.onFindViewById(r3.mContainerId);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0381, code lost:
        if (r20 != null) goto L_0x03ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x038b, code lost:
        if (r3.mRestored != false) goto L_0x03ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x038d, code lost:
        r24 = r2;
        r25 = r31;
        r27 = r31;
        r28 = new java.lang.StringBuilder();
        r26 = new java.lang.IllegalArgumentException(r27.append("No view found for id 0x").append(java.lang.Integer.toHexString(r3.mContainerId)).append(" (").append(r3.getResources().getResourceName(r3.mContainerId)).append(") for fragment ").append(r3).toString());
        throwException(r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x03ea, code lost:
        r3.mContainer = r20;
        r3.mView = r3.performCreateView(r3.getLayoutInflater(r3.mSavedFragmentState), r20, r3.mSavedFragmentState);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0422, code lost:
        if (r3.mView == null) goto L_0x05a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0424, code lost:
        r3.mInnerView = r3.mView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x043c, code lost:
        if (android.os.Build.VERSION.SDK_INT < 11) goto L_0x0590;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x043e, code lost:
        android.support.p000v4.view.ViewCompat.setSaveFromParentEnabled(r3.mView, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x044d, code lost:
        if (r20 == null) goto L_0x048c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x044f, code lost:
        r21 = loadAnimation(r3, r5, true, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0461, code lost:
        if (r21 == null) goto L_0x047f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0463, code lost:
        setHWLayerAnimListenerIfAlpha(r3.mView, r21);
        r3.mView.startAnimation(r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x047f, code lost:
        r20.addView(r3.mView);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0494, code lost:
        if (r3.mHidden == false) goto L_0x04a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0496, code lost:
        r3.mView.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x04a3, code lost:
        r3.onViewCreated(r3.mView, r3.mSavedFragmentState);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x04b8, code lost:
        r3.performActivityCreated(r3.mSavedFragmentState);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x04cd, code lost:
        if (r3.mView == null) goto L_0x04dc;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 266 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void moveToState(android.support.p000v4.app.Fragment r33, int r34, int r35, int r36, boolean r37) {
        /*
            r32 = this;
            r2 = r32
            r3 = r33
            r4 = r34
            r5 = r35
            r6 = r36
            r7 = r37
            r24 = r3
            r0 = r24
            boolean r0 = r0.mAdded
            r24 = r0
            if (r24 == 0) goto L_0x0020
            r24 = r3
            r0 = r24
            boolean r0 = r0.mDetached
            r24 = r0
            if (r24 == 0) goto L_0x002e
        L_0x0020:
            r24 = r4
            r25 = 1
            r0 = r24
            r1 = r25
            if (r0 <= r1) goto L_0x002e
            r24 = 1
            r4 = r24
        L_0x002e:
            r24 = r3
            r0 = r24
            boolean r0 = r0.mRemoving
            r24 = r0
            if (r24 == 0) goto L_0x0052
            r24 = r4
            r25 = r3
            r0 = r25
            int r0 = r0.mState
            r25 = r0
            r0 = r24
            r1 = r25
            if (r0 <= r1) goto L_0x0052
            r24 = r3
            r0 = r24
            int r0 = r0.mState
            r24 = r0
            r4 = r24
        L_0x0052:
            r24 = r3
            r0 = r24
            boolean r0 = r0.mDeferStart
            r24 = r0
            if (r24 == 0) goto L_0x007a
            r24 = r3
            r0 = r24
            int r0 = r0.mState
            r24 = r0
            r25 = 4
            r0 = r24
            r1 = r25
            if (r0 >= r1) goto L_0x007a
            r24 = r4
            r25 = 3
            r0 = r24
            r1 = r25
            if (r0 <= r1) goto L_0x007a
            r24 = 3
            r4 = r24
        L_0x007a:
            r24 = r3
            r0 = r24
            int r0 = r0.mState
            r24 = r0
            r25 = r4
            r0 = r24
            r1 = r25
            if (r0 >= r1) goto L_0x05b2
            r24 = r3
            r0 = r24
            boolean r0 = r0.mFromLayout
            r24 = r0
            if (r24 == 0) goto L_0x009f
            r24 = r3
            r0 = r24
            boolean r0 = r0.mInLayout
            r24 = r0
            if (r24 != 0) goto L_0x009f
        L_0x009e:
            return
        L_0x009f:
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mAnimatingAway
            r24 = r0
            if (r24 == 0) goto L_0x00c8
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mAnimatingAway = r0
            r24 = r2
            r25 = r3
            r26 = r3
            r0 = r26
            int r0 = r0.mStateAfterAnimating
            r26 = r0
            r27 = 0
            r28 = 0
            r29 = 1
            r24.moveToState(r25, r26, r27, r28, r29)
        L_0x00c8:
            r24 = r3
            r0 = r24
            int r0 = r0.mState
            r24 = r0
            switch(r24) {
                case 0: goto L_0x00de;
                case 1: goto L_0x031c;
                case 2: goto L_0x04e6;
                case 3: goto L_0x04e6;
                case 4: goto L_0x051a;
                default: goto L_0x00d3;
            }
        L_0x00d3:
            r24 = r3
            r25 = r4
            r0 = r25
            r1 = r24
            r1.mState = r0
            goto L_0x009e
        L_0x00de:
            boolean r24 = DEBUG
            if (r24 == 0) goto L_0x0103
            java.lang.String r24 = "FragmentManager"
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r31 = r25
            r25 = r31
            r26 = r31
            r26.<init>()
            java.lang.String r26 = "moveto CREATED: "
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r3
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            int r24 = android.util.Log.v(r24, r25)
        L_0x0103:
            r24 = r3
            r0 = r24
            android.os.Bundle r0 = r0.mSavedFragmentState
            r24 = r0
            if (r24 == 0) goto L_0x01b2
            r24 = r3
            r0 = r24
            android.os.Bundle r0 = r0.mSavedFragmentState
            r24 = r0
            r25 = r2
            r0 = r25
            android.support.v4.app.FragmentHostCallback r0 = r0.mHost
            r25 = r0
            android.content.Context r25 = r25.getContext()
            java.lang.ClassLoader r25 = r25.getClassLoader()
            r24.setClassLoader(r25)
            r24 = r3
            r25 = r3
            r0 = r25
            android.os.Bundle r0 = r0.mSavedFragmentState
            r25 = r0
            java.lang.String r26 = "android:view_state"
            android.util.SparseArray r25 = r25.getSparseParcelableArray(r26)
            r0 = r25
            r1 = r24
            r1.mSavedViewState = r0
            r24 = r3
            r25 = r2
            r26 = r3
            r0 = r26
            android.os.Bundle r0 = r0.mSavedFragmentState
            r26 = r0
            java.lang.String r27 = "android:target_state"
            android.support.v4.app.Fragment r25 = r25.getFragment(r26, r27)
            r0 = r25
            r1 = r24
            r1.mTarget = r0
            r24 = r3
            r0 = r24
            android.support.v4.app.Fragment r0 = r0.mTarget
            r24 = r0
            if (r24 == 0) goto L_0x0178
            r24 = r3
            r25 = r3
            r0 = r25
            android.os.Bundle r0 = r0.mSavedFragmentState
            r25 = r0
            java.lang.String r26 = "android:target_req_state"
            r27 = 0
            int r25 = r25.getInt(r26, r27)
            r0 = r25
            r1 = r24
            r1.mTargetRequestCode = r0
        L_0x0178:
            r24 = r3
            r25 = r3
            r0 = r25
            android.os.Bundle r0 = r0.mSavedFragmentState
            r25 = r0
            java.lang.String r26 = "android:user_visible_hint"
            r27 = 1
            boolean r25 = r25.getBoolean(r26, r27)
            r0 = r25
            r1 = r24
            r1.mUserVisibleHint = r0
            r24 = r3
            r0 = r24
            boolean r0 = r0.mUserVisibleHint
            r24 = r0
            if (r24 != 0) goto L_0x01b2
            r24 = r3
            r25 = 1
            r0 = r25
            r1 = r24
            r1.mDeferStart = r0
            r24 = r4
            r25 = 3
            r0 = r24
            r1 = r25
            if (r0 <= r1) goto L_0x01b2
            r24 = 3
            r4 = r24
        L_0x01b2:
            r24 = r3
            r25 = r2
            r0 = r25
            android.support.v4.app.FragmentHostCallback r0 = r0.mHost
            r25 = r0
            r0 = r25
            r1 = r24
            r1.mHost = r0
            r24 = r3
            r25 = r2
            r0 = r25
            android.support.v4.app.Fragment r0 = r0.mParent
            r25 = r0
            r0 = r25
            r1 = r24
            r1.mParentFragment = r0
            r24 = r2
            r0 = r24
            android.support.v4.app.Fragment r0 = r0.mParent
            r24 = r0
            if (r24 == 0) goto L_0x0248
            r24 = r2
            r0 = r24
            android.support.v4.app.Fragment r0 = r0.mParent
            r24 = r0
            r0 = r24
            android.support.v4.app.FragmentManagerImpl r0 = r0.mChildFragmentManager
            r24 = r0
            r23 = r24
        L_0x01ec:
            r24 = r3
            r25 = r23
            r0 = r25
            r1 = r24
            r1.mFragmentManager = r0
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mCalled = r0
            r24 = r3
            r25 = r2
            r0 = r25
            android.support.v4.app.FragmentHostCallback r0 = r0.mHost
            r25 = r0
            android.content.Context r25 = r25.getContext()
            r24.onAttach(r25)
            r24 = r3
            r0 = r24
            boolean r0 = r0.mCalled
            r24 = r0
            if (r24 != 0) goto L_0x0257
            android.support.v4.app.SuperNotCalledException r24 = new android.support.v4.app.SuperNotCalledException
            r31 = r24
            r24 = r31
            r25 = r31
            java.lang.StringBuilder r26 = new java.lang.StringBuilder
            r31 = r26
            r26 = r31
            r27 = r31
            r27.<init>()
            java.lang.String r27 = "Fragment "
            java.lang.StringBuilder r26 = r26.append(r27)
            r27 = r3
            java.lang.StringBuilder r26 = r26.append(r27)
            java.lang.String r27 = " did not call through to super.onAttach()"
            java.lang.StringBuilder r26 = r26.append(r27)
            java.lang.String r26 = r26.toString()
            r25.<init>(r26)
            throw r24
        L_0x0248:
            r24 = r2
            r0 = r24
            android.support.v4.app.FragmentHostCallback r0 = r0.mHost
            r24 = r0
            android.support.v4.app.FragmentManagerImpl r24 = r24.getFragmentManagerImpl()
            r23 = r24
            goto L_0x01ec
        L_0x0257:
            r24 = r3
            r0 = r24
            android.support.v4.app.Fragment r0 = r0.mParentFragment
            r24 = r0
            if (r24 != 0) goto L_0x026e
            r24 = r2
            r0 = r24
            android.support.v4.app.FragmentHostCallback r0 = r0.mHost
            r24 = r0
            r25 = r3
            r24.onAttachFragment(r25)
        L_0x026e:
            r24 = r3
            r0 = r24
            boolean r0 = r0.mRetaining
            r24 = r0
            if (r24 != 0) goto L_0x0285
            r24 = r3
            r25 = r3
            r0 = r25
            android.os.Bundle r0 = r0.mSavedFragmentState
            r25 = r0
            r24.performCreate(r25)
        L_0x0285:
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mRetaining = r0
            r24 = r3
            r0 = r24
            boolean r0 = r0.mFromLayout
            r24 = r0
            if (r24 == 0) goto L_0x031c
            r24 = r3
            r25 = r3
            r26 = r3
            r27 = r3
            r0 = r27
            android.os.Bundle r0 = r0.mSavedFragmentState
            r27 = r0
            android.view.LayoutInflater r26 = r26.getLayoutInflater(r27)
            r27 = 0
            r28 = r3
            r0 = r28
            android.os.Bundle r0 = r0.mSavedFragmentState
            r28 = r0
            android.view.View r25 = r25.performCreateView(r26, r27, r28)
            r0 = r25
            r1 = r24
            r1.mView = r0
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mView
            r24 = r0
            if (r24 == 0) goto L_0x0584
            r24 = r3
            r25 = r3
            r0 = r25
            android.view.View r0 = r0.mView
            r25 = r0
            r0 = r25
            r1 = r24
            r1.mInnerView = r0
            int r24 = android.os.Build.VERSION.SDK_INT
            r25 = 11
            r0 = r24
            r1 = r25
            if (r0 < r1) goto L_0x056e
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mView
            r24 = r0
            r25 = 0
            android.support.p000v4.view.ViewCompat.setSaveFromParentEnabled(r24, r25)
        L_0x02f0:
            r24 = r3
            r0 = r24
            boolean r0 = r0.mHidden
            r24 = r0
            if (r24 == 0) goto L_0x0307
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mView
            r24 = r0
            r25 = 8
            r24.setVisibility(r25)
        L_0x0307:
            r24 = r3
            r25 = r3
            r0 = r25
            android.view.View r0 = r0.mView
            r25 = r0
            r26 = r3
            r0 = r26
            android.os.Bundle r0 = r0.mSavedFragmentState
            r26 = r0
            r24.onViewCreated(r25, r26)
        L_0x031c:
            r24 = r4
            r25 = 1
            r0 = r24
            r1 = r25
            if (r0 <= r1) goto L_0x04e6
            boolean r24 = DEBUG
            if (r24 == 0) goto L_0x034b
            java.lang.String r24 = "FragmentManager"
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r31 = r25
            r25 = r31
            r26 = r31
            r26.<init>()
            java.lang.String r26 = "moveto ACTIVITY_CREATED: "
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r3
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            int r24 = android.util.Log.v(r24, r25)
        L_0x034b:
            r24 = r3
            r0 = r24
            boolean r0 = r0.mFromLayout
            r24 = r0
            if (r24 != 0) goto L_0x04b8
            r24 = r3
            r0 = r24
            int r0 = r0.mContainerId
            r24 = r0
            r19 = r24
            r24 = 0
            r20 = r24
            r24 = r19
            if (r24 == 0) goto L_0x03ea
            r24 = r2
            r0 = r24
            android.support.v4.app.FragmentContainer r0 = r0.mContainer
            r24 = r0
            r25 = r3
            r0 = r25
            int r0 = r0.mContainerId
            r25 = r0
            android.view.View r24 = r24.onFindViewById(r25)
            android.view.ViewGroup r24 = (android.view.ViewGroup) r24
            r20 = r24
            r24 = r20
            if (r24 != 0) goto L_0x03ea
            r24 = r3
            r0 = r24
            boolean r0 = r0.mRestored
            r24 = r0
            if (r24 != 0) goto L_0x03ea
            r24 = r2
            java.lang.IllegalArgumentException r25 = new java.lang.IllegalArgumentException
            r31 = r25
            r25 = r31
            r26 = r31
            java.lang.StringBuilder r27 = new java.lang.StringBuilder
            r31 = r27
            r27 = r31
            r28 = r31
            r28.<init>()
            java.lang.String r28 = "No view found for id 0x"
            java.lang.StringBuilder r27 = r27.append(r28)
            r28 = r3
            r0 = r28
            int r0 = r0.mContainerId
            r28 = r0
            java.lang.String r28 = java.lang.Integer.toHexString(r28)
            java.lang.StringBuilder r27 = r27.append(r28)
            java.lang.String r28 = " ("
            java.lang.StringBuilder r27 = r27.append(r28)
            r28 = r3
            android.content.res.Resources r28 = r28.getResources()
            r29 = r3
            r0 = r29
            int r0 = r0.mContainerId
            r29 = r0
            java.lang.String r28 = r28.getResourceName(r29)
            java.lang.StringBuilder r27 = r27.append(r28)
            java.lang.String r28 = ") for fragment "
            java.lang.StringBuilder r27 = r27.append(r28)
            r28 = r3
            java.lang.StringBuilder r27 = r27.append(r28)
            java.lang.String r27 = r27.toString()
            r26.<init>(r27)
            r24.throwException(r25)
        L_0x03ea:
            r24 = r3
            r25 = r20
            r0 = r25
            r1 = r24
            r1.mContainer = r0
            r24 = r3
            r25 = r3
            r26 = r3
            r27 = r3
            r0 = r27
            android.os.Bundle r0 = r0.mSavedFragmentState
            r27 = r0
            android.view.LayoutInflater r26 = r26.getLayoutInflater(r27)
            r27 = r20
            r28 = r3
            r0 = r28
            android.os.Bundle r0 = r0.mSavedFragmentState
            r28 = r0
            android.view.View r25 = r25.performCreateView(r26, r27, r28)
            r0 = r25
            r1 = r24
            r1.mView = r0
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mView
            r24 = r0
            if (r24 == 0) goto L_0x05a6
            r24 = r3
            r25 = r3
            r0 = r25
            android.view.View r0 = r0.mView
            r25 = r0
            r0 = r25
            r1 = r24
            r1.mInnerView = r0
            int r24 = android.os.Build.VERSION.SDK_INT
            r25 = 11
            r0 = r24
            r1 = r25
            if (r0 < r1) goto L_0x0590
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mView
            r24 = r0
            r25 = 0
            android.support.p000v4.view.ViewCompat.setSaveFromParentEnabled(r24, r25)
        L_0x044b:
            r24 = r20
            if (r24 == 0) goto L_0x048c
            r24 = r2
            r25 = r3
            r26 = r5
            r27 = 1
            r28 = r6
            android.view.animation.Animation r24 = r24.loadAnimation(r25, r26, r27, r28)
            r21 = r24
            r24 = r21
            if (r24 == 0) goto L_0x047f
            r24 = r2
            r25 = r3
            r0 = r25
            android.view.View r0 = r0.mView
            r25 = r0
            r26 = r21
            r24.setHWLayerAnimListenerIfAlpha(r25, r26)
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mView
            r24 = r0
            r25 = r21
            r24.startAnimation(r25)
        L_0x047f:
            r24 = r20
            r25 = r3
            r0 = r25
            android.view.View r0 = r0.mView
            r25 = r0
            r24.addView(r25)
        L_0x048c:
            r24 = r3
            r0 = r24
            boolean r0 = r0.mHidden
            r24 = r0
            if (r24 == 0) goto L_0x04a3
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mView
            r24 = r0
            r25 = 8
            r24.setVisibility(r25)
        L_0x04a3:
            r24 = r3
            r25 = r3
            r0 = r25
            android.view.View r0 = r0.mView
            r25 = r0
            r26 = r3
            r0 = r26
            android.os.Bundle r0 = r0.mSavedFragmentState
            r26 = r0
            r24.onViewCreated(r25, r26)
        L_0x04b8:
            r24 = r3
            r25 = r3
            r0 = r25
            android.os.Bundle r0 = r0.mSavedFragmentState
            r25 = r0
            r24.performActivityCreated(r25)
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mView
            r24 = r0
            if (r24 == 0) goto L_0x04dc
            r24 = r3
            r25 = r3
            r0 = r25
            android.os.Bundle r0 = r0.mSavedFragmentState
            r25 = r0
            r24.restoreViewState(r25)
        L_0x04dc:
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mSavedFragmentState = r0
        L_0x04e6:
            r24 = r4
            r25 = 3
            r0 = r24
            r1 = r25
            if (r0 <= r1) goto L_0x051a
            boolean r24 = DEBUG
            if (r24 == 0) goto L_0x0515
            java.lang.String r24 = "FragmentManager"
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r31 = r25
            r25 = r31
            r26 = r31
            r26.<init>()
            java.lang.String r26 = "moveto STARTED: "
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r3
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            int r24 = android.util.Log.v(r24, r25)
        L_0x0515:
            r24 = r3
            r24.performStart()
        L_0x051a:
            r24 = r4
            r25 = 4
            r0 = r24
            r1 = r25
            if (r0 <= r1) goto L_0x00d3
            boolean r24 = DEBUG
            if (r24 == 0) goto L_0x0549
            java.lang.String r24 = "FragmentManager"
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r31 = r25
            r25 = r31
            r26 = r31
            r26.<init>()
            java.lang.String r26 = "moveto RESUMED: "
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r3
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            int r24 = android.util.Log.v(r24, r25)
        L_0x0549:
            r24 = r3
            r25 = 1
            r0 = r25
            r1 = r24
            r1.mResumed = r0
            r24 = r3
            r24.performResume()
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mSavedFragmentState = r0
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mSavedViewState = r0
            goto L_0x00d3
        L_0x056e:
            r24 = r3
            r25 = r3
            r0 = r25
            android.view.View r0 = r0.mView
            r25 = r0
            android.view.ViewGroup r25 = android.support.p000v4.app.NoSaveStateFrameLayout.wrap(r25)
            r0 = r25
            r1 = r24
            r1.mView = r0
            goto L_0x02f0
        L_0x0584:
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mInnerView = r0
            goto L_0x031c
        L_0x0590:
            r24 = r3
            r25 = r3
            r0 = r25
            android.view.View r0 = r0.mView
            r25 = r0
            android.view.ViewGroup r25 = android.support.p000v4.app.NoSaveStateFrameLayout.wrap(r25)
            r0 = r25
            r1 = r24
            r1.mView = r0
            goto L_0x044b
        L_0x05a6:
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mInnerView = r0
            goto L_0x04b8
        L_0x05b2:
            r24 = r3
            r0 = r24
            int r0 = r0.mState
            r24 = r0
            r25 = r4
            r0 = r24
            r1 = r25
            if (r0 <= r1) goto L_0x00d3
            r24 = r3
            r0 = r24
            int r0 = r0.mState
            r24 = r0
            switch(r24) {
                case 1: goto L_0x0796;
                case 2: goto L_0x0675;
                case 3: goto L_0x0641;
                case 4: goto L_0x060d;
                case 5: goto L_0x05cf;
                default: goto L_0x05cd;
            }
        L_0x05cd:
            goto L_0x00d3
        L_0x05cf:
            r24 = r4
            r25 = 5
            r0 = r24
            r1 = r25
            if (r0 >= r1) goto L_0x060d
            boolean r24 = DEBUG
            if (r24 == 0) goto L_0x05fe
            java.lang.String r24 = "FragmentManager"
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r31 = r25
            r25 = r31
            r26 = r31
            r26.<init>()
            java.lang.String r26 = "movefrom RESUMED: "
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r3
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            int r24 = android.util.Log.v(r24, r25)
        L_0x05fe:
            r24 = r3
            r24.performPause()
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mResumed = r0
        L_0x060d:
            r24 = r4
            r25 = 4
            r0 = r24
            r1 = r25
            if (r0 >= r1) goto L_0x0641
            boolean r24 = DEBUG
            if (r24 == 0) goto L_0x063c
            java.lang.String r24 = "FragmentManager"
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r31 = r25
            r25 = r31
            r26 = r31
            r26.<init>()
            java.lang.String r26 = "movefrom STARTED: "
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r3
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            int r24 = android.util.Log.v(r24, r25)
        L_0x063c:
            r24 = r3
            r24.performStop()
        L_0x0641:
            r24 = r4
            r25 = 3
            r0 = r24
            r1 = r25
            if (r0 >= r1) goto L_0x0675
            boolean r24 = DEBUG
            if (r24 == 0) goto L_0x0670
            java.lang.String r24 = "FragmentManager"
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r31 = r25
            r25 = r31
            r26 = r31
            r26.<init>()
            java.lang.String r26 = "movefrom STOPPED: "
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r3
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            int r24 = android.util.Log.v(r24, r25)
        L_0x0670:
            r24 = r3
            r24.performReallyStop()
        L_0x0675:
            r24 = r4
            r25 = 2
            r0 = r24
            r1 = r25
            if (r0 >= r1) goto L_0x0796
            boolean r24 = DEBUG
            if (r24 == 0) goto L_0x06a4
            java.lang.String r24 = "FragmentManager"
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r31 = r25
            r25 = r31
            r26 = r31
            r26.<init>()
            java.lang.String r26 = "movefrom ACTIVITY_CREATED: "
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r3
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            int r24 = android.util.Log.v(r24, r25)
        L_0x06a4:
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mView
            r24 = r0
            if (r24 == 0) goto L_0x06cf
            r24 = r2
            r0 = r24
            android.support.v4.app.FragmentHostCallback r0 = r0.mHost
            r24 = r0
            r25 = r3
            boolean r24 = r24.onShouldSaveFragmentState(r25)
            if (r24 == 0) goto L_0x06cf
            r24 = r3
            r0 = r24
            android.util.SparseArray<android.os.Parcelable> r0 = r0.mSavedViewState
            r24 = r0
            if (r24 != 0) goto L_0x06cf
            r24 = r2
            r25 = r3
            r24.saveFragmentViewState(r25)
        L_0x06cf:
            r24 = r3
            r24.performDestroyView()
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mView
            r24 = r0
            if (r24 == 0) goto L_0x0778
            r24 = r3
            r0 = r24
            android.view.ViewGroup r0 = r0.mContainer
            r24 = r0
            if (r24 == 0) goto L_0x0778
            r24 = r2
            r0 = r24
            int r0 = r0.mCurState
            r24 = r0
            r10 = r24
            r24 = 0
            r11 = r24
            r24 = r10
            if (r24 <= 0) goto L_0x071c
            r24 = r2
            r0 = r24
            boolean r0 = r0.mDestroyed
            r24 = r0
            r12 = r24
            r24 = 0
            r11 = r24
            r24 = r12
            if (r24 != 0) goto L_0x071c
            r24 = r2
            r25 = r3
            r26 = r5
            r27 = 0
            r28 = r6
            android.view.animation.Animation r24 = r24.loadAnimation(r25, r26, r27, r28)
            r11 = r24
        L_0x071c:
            r24 = r11
            if (r24 == 0) goto L_0x0765
            r24 = r3
            r25 = r3
            r0 = r25
            android.view.View r0 = r0.mView
            r25 = r0
            r0 = r25
            r1 = r24
            r1.mAnimatingAway = r0
            r24 = r3
            r25 = r4
            r0 = r25
            r1 = r24
            r1.mStateAfterAnimating = r0
            r24 = r11
            android.support.v4.app.FragmentManagerImpl$5 r25 = new android.support.v4.app.FragmentManagerImpl$5
            r31 = r25
            r25 = r31
            r26 = r31
            r27 = r2
            r28 = r3
            r0 = r28
            android.view.View r0 = r0.mView
            r28 = r0
            r29 = r11
            r30 = r3
            r26.<init>(r27, r28, r29, r30)
            r24.setAnimationListener(r25)
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mView
            r24 = r0
            r25 = r11
            r24.startAnimation(r25)
        L_0x0765:
            r24 = r3
            r0 = r24
            android.view.ViewGroup r0 = r0.mContainer
            r24 = r0
            r25 = r3
            r0 = r25
            android.view.View r0 = r0.mView
            r25 = r0
            r24.removeView(r25)
        L_0x0778:
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mContainer = r0
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mView = r0
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mInnerView = r0
        L_0x0796:
            r24 = r4
            r25 = 1
            r0 = r24
            r1 = r25
            if (r0 >= r1) goto L_0x00d3
            r24 = r2
            r0 = r24
            boolean r0 = r0.mDestroyed
            r24 = r0
            if (r24 == 0) goto L_0x07cd
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mAnimatingAway
            r24 = r0
            if (r24 == 0) goto L_0x07cd
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mAnimatingAway
            r24 = r0
            r9 = r24
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mAnimatingAway = r0
            r24 = r9
            r24.clearAnimation()
        L_0x07cd:
            r24 = r3
            r0 = r24
            android.view.View r0 = r0.mAnimatingAway
            r24 = r0
            if (r24 == 0) goto L_0x07e7
            r24 = r3
            r25 = r4
            r0 = r25
            r1 = r24
            r1.mStateAfterAnimating = r0
            r24 = 1
            r4 = r24
            goto L_0x00d3
        L_0x07e7:
            boolean r24 = DEBUG
            if (r24 == 0) goto L_0x080c
            java.lang.String r24 = "FragmentManager"
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r31 = r25
            r25 = r31
            r26 = r31
            r26.<init>()
            java.lang.String r26 = "movefrom CREATED: "
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r3
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            int r24 = android.util.Log.v(r24, r25)
        L_0x080c:
            r24 = r3
            r0 = r24
            boolean r0 = r0.mRetaining
            r24 = r0
            if (r24 != 0) goto L_0x081b
            r24 = r3
            r24.performDestroy()
        L_0x081b:
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mCalled = r0
            r24 = r3
            r24.onDetach()
            r24 = r3
            r0 = r24
            boolean r0 = r0.mCalled
            r24 = r0
            if (r24 != 0) goto L_0x0861
            android.support.v4.app.SuperNotCalledException r24 = new android.support.v4.app.SuperNotCalledException
            r31 = r24
            r24 = r31
            r25 = r31
            java.lang.StringBuilder r26 = new java.lang.StringBuilder
            r31 = r26
            r26 = r31
            r27 = r31
            r27.<init>()
            java.lang.String r27 = "Fragment "
            java.lang.StringBuilder r26 = r26.append(r27)
            r27 = r3
            java.lang.StringBuilder r26 = r26.append(r27)
            java.lang.String r27 = " did not call through to super.onDetach()"
            java.lang.StringBuilder r26 = r26.append(r27)
            java.lang.String r26 = r26.toString()
            r25.<init>(r26)
            throw r24
        L_0x0861:
            r24 = r7
            if (r24 != 0) goto L_0x00d3
            r24 = r3
            r0 = r24
            boolean r0 = r0.mRetaining
            r24 = r0
            if (r24 != 0) goto L_0x0878
            r24 = r2
            r25 = r3
            r24.makeInactive(r25)
            goto L_0x00d3
        L_0x0878:
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mHost = r0
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mParentFragment = r0
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mFragmentManager = r0
            r24 = r3
            r25 = 0
            r0 = r25
            r1 = r24
            r1.mChildFragmentManager = r0
            goto L_0x00d3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.FragmentManagerImpl.moveToState(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    public void noteStateNotSaved() {
        this.mStateSaved = false;
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        IllegalStateException illegalStateException;
        StringBuilder sb2;
        StringBuilder sb3;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb4;
        View view2 = view;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet2.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, FragmentTag.Fragment);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (Fragment.isSupportFragmentClass(this.mHost.getContext(), attributeValue)) {
                int i = view2 != null ? view2.getId() : 0;
                if (i == -1 && resourceId == -1 && string == null) {
                    IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
                    StringBuilder sb5 = sb4;
                    StringBuilder sb6 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(sb5.append(attributeSet2.getPositionDescription()).append(": Must specify unique android:id, android:tag, or have a parent with an id for ").append(attributeValue).toString());
                    throw illegalArgumentException3;
                }
                Fragment fragment = resourceId != -1 ? findFragmentById(resourceId) : null;
                if (fragment == null && string != null) {
                    fragment = findFragmentByTag(string);
                }
                if (fragment == null && i != -1) {
                    fragment = findFragmentById(i);
                }
                if (DEBUG) {
                    String str2 = TAG;
                    StringBuilder sb7 = sb3;
                    StringBuilder sb8 = new StringBuilder();
                    int v = Log.v(str2, sb7.append("onCreateView: id=0x").append(Integer.toHexString(resourceId)).append(" fname=").append(attributeValue).append(" existing=").append(fragment).toString());
                }
                if (fragment == null) {
                    fragment = Fragment.instantiate(context2, attributeValue);
                    fragment.mFromLayout = true;
                    fragment.mFragmentId = resourceId != 0 ? resourceId : i;
                    fragment.mContainerId = i;
                    fragment.mTag = string;
                    fragment.mInLayout = true;
                    fragment.mFragmentManager = this;
                    fragment.mHost = this.mHost;
                    fragment.onInflate(this.mHost.getContext(), attributeSet2, fragment.mSavedFragmentState);
                    addFragment(fragment, true);
                } else if (fragment.mInLayout) {
                    IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                    StringBuilder sb9 = sb;
                    StringBuilder sb10 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb9.append(attributeSet2.getPositionDescription()).append(": Duplicate id 0x").append(Integer.toHexString(resourceId)).append(", tag ").append(string).append(", or parent id 0x").append(Integer.toHexString(i)).append(" with another fragment for ").append(attributeValue).toString());
                    throw illegalArgumentException5;
                } else {
                    fragment.mInLayout = true;
                    if (!fragment.mRetaining) {
                        fragment.onInflate(this.mHost.getContext(), attributeSet2, fragment.mSavedFragmentState);
                    }
                }
                if (this.mCurState >= 1 || !fragment.mFromLayout) {
                    moveToState(fragment);
                } else {
                    moveToState(fragment, 1, 0, 0, false);
                }
                if (fragment.mView == null) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    StringBuilder sb11 = sb2;
                    StringBuilder sb12 = new StringBuilder();
                    IllegalStateException illegalStateException3 = new IllegalStateException(sb11.append("Fragment ").append(attributeValue).append(" did not create a view.").toString());
                    throw illegalStateException2;
                }
                if (resourceId != 0) {
                    fragment.mView.setId(resourceId);
                }
                if (fragment.mView.getTag() == null) {
                    fragment.mView.setTag(string);
                }
                return fragment.mView;
            }
        }
        return null;
    }

    public void performPendingDeferredStart(Fragment fragment) {
        Fragment fragment2 = fragment;
        if (!fragment2.mDeferStart) {
            return;
        }
        if (this.mExecutingActions) {
            this.mHavePendingDeferredStart = true;
            return;
        }
        fragment2.mDeferStart = false;
        moveToState(fragment2, this.mCurState, 0, 0, false);
    }

    public void popBackStack() {
        C00142 r5;
        C00142 r2 = r5;
        C00142 r3 = new Runnable(this) {
            final /* synthetic */ FragmentManagerImpl this$0;

            {
                this.this$0 = r5;
            }

            public void run() {
                boolean popBackStackState = this.this$0.popBackStackState(this.this$0.mHost.getHandler(), null, -1, 0);
            }
        };
        enqueueAction(r2, false);
    }

    public void popBackStack(int i, int i2) {
        C00164 r9;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i3 = i;
        int i4 = i2;
        if (i3 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Bad id: ").append(i3).toString());
            throw illegalArgumentException2;
        }
        C00164 r4 = r9;
        final int i5 = i3;
        final int i6 = i4;
        C00164 r5 = new Runnable(this) {
            final /* synthetic */ FragmentManagerImpl this$0;

            {
                int i = r8;
                int i2 = r9;
                this.this$0 = r7;
            }

            public void run() {
                boolean popBackStackState = this.this$0.popBackStackState(this.this$0.mHost.getHandler(), null, i5, i6);
            }
        };
        enqueueAction(r4, false);
    }

    public void popBackStack(String str, int i) {
        C00153 r9;
        C00153 r4 = r9;
        final String str2 = str;
        final int i2 = i;
        C00153 r5 = new Runnable(this) {
            final /* synthetic */ FragmentManagerImpl this$0;

            {
                String str = r8;
                int i = r9;
                this.this$0 = r7;
            }

            public void run() {
                boolean popBackStackState = this.this$0.popBackStackState(this.this$0.mHost.getHandler(), str2, -1, i2);
            }
        };
        enqueueAction(r4, false);
    }

    public boolean popBackStackImmediate() {
        checkStateLoss();
        boolean executePendingTransactions = executePendingTransactions();
        return popBackStackState(this.mHost.getHandler(), null, -1, 0);
    }

    public boolean popBackStackImmediate(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i3 = i;
        int i4 = i2;
        checkStateLoss();
        boolean executePendingTransactions = executePendingTransactions();
        if (i3 >= 0) {
            return popBackStackState(this.mHost.getHandler(), null, i3, i4);
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Bad id: ").append(i3).toString());
        throw illegalArgumentException2;
    }

    public boolean popBackStackImmediate(String str, int i) {
        String str2 = str;
        int i2 = i;
        checkStateLoss();
        boolean executePendingTransactions = executePendingTransactions();
        return popBackStackState(this.mHost.getHandler(), str2, -1, i2);
    }

    /* access modifiers changed from: 0000 */
    public boolean popBackStackState(Handler handler, String str, int i, int i2) {
        ArrayList arrayList;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        StringBuilder sb;
        SparseArray sparseArray3;
        SparseArray sparseArray4;
        Handler handler2 = handler;
        String str2 = str;
        int i3 = i;
        int i4 = i2;
        if (this.mBackStack == null) {
            return false;
        }
        if (str2 == null && i3 < 0 && (i4 & 1) == 0) {
            int size = -1 + this.mBackStack.size();
            if (size < 0) {
                return false;
            }
            BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.remove(size);
            SparseArray sparseArray5 = sparseArray3;
            SparseArray sparseArray6 = new SparseArray();
            SparseArray sparseArray7 = sparseArray5;
            SparseArray sparseArray8 = sparseArray4;
            SparseArray sparseArray9 = new SparseArray();
            SparseArray sparseArray10 = sparseArray8;
            backStackRecord.calculateBackFragments(sparseArray7, sparseArray10);
            TransitionState popFromBackStack = backStackRecord.popFromBackStack(true, null, sparseArray7, sparseArray10);
            reportBackStackChanged();
        } else {
            int i5 = -1;
            if (str2 != null || i3 >= 0) {
                i5 = -1 + this.mBackStack.size();
                while (i5 >= 0) {
                    BackStackRecord backStackRecord2 = (BackStackRecord) this.mBackStack.get(i5);
                    if ((str2 != null && str2.equals(backStackRecord2.getName())) || (i3 >= 0 && i3 == backStackRecord2.mIndex)) {
                        break;
                    }
                    i5--;
                }
                if (i5 < 0) {
                    return false;
                }
                if ((i4 & 1) != 0) {
                    while (true) {
                        i5--;
                        if (i5 < 0) {
                            break;
                        }
                        BackStackRecord backStackRecord3 = (BackStackRecord) this.mBackStack.get(i5);
                        if ((str2 == null || !str2.equals(backStackRecord3.getName())) && (i3 < 0 || i3 != backStackRecord3.mIndex)) {
                            break;
                        }
                    }
                }
            }
            if (i5 == -1 + this.mBackStack.size()) {
                return false;
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList2;
            for (int size2 = -1 + this.mBackStack.size(); size2 > i5; size2--) {
                boolean add = arrayList4.add(this.mBackStack.remove(size2));
            }
            int size3 = -1 + arrayList4.size();
            SparseArray sparseArray11 = sparseArray;
            SparseArray sparseArray12 = new SparseArray();
            SparseArray sparseArray13 = sparseArray11;
            SparseArray sparseArray14 = sparseArray2;
            SparseArray sparseArray15 = new SparseArray();
            SparseArray sparseArray16 = sparseArray14;
            for (int i6 = 0; i6 <= size3; i6++) {
                ((BackStackRecord) arrayList4.get(i6)).calculateBackFragments(sparseArray13, sparseArray16);
            }
            TransitionState transitionState = null;
            int i7 = 0;
            while (i7 <= size3) {
                if (DEBUG) {
                    String str3 = TAG;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int v = Log.v(str3, sb2.append("Popping back stack state: ").append(arrayList4.get(i7)).toString());
                }
                transitionState = ((BackStackRecord) arrayList4.get(i7)).popFromBackStack(i7 == size3, transitionState, sparseArray13, sparseArray16);
                i7++;
            }
            reportBackStackChanged();
        }
        return true;
    }

    public void putFragment(Bundle bundle, String str, Fragment fragment) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        Bundle bundle2 = bundle;
        String str2 = str;
        Fragment fragment2 = fragment;
        if (fragment2.mIndex < 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Fragment ").append(fragment2).append(" is not currently in the FragmentManager").toString());
            throwException(illegalStateException2);
        }
        bundle2.putInt(str2, fragment2.mIndex);
    }

    public void removeFragment(Fragment fragment, int i, int i2) {
        StringBuilder sb;
        Fragment fragment2 = fragment;
        int i3 = i;
        int i4 = i2;
        if (DEBUG) {
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int v = Log.v(str, sb2.append("remove: ").append(fragment2).append(" nesting=").append(fragment2.mBackStackNesting).toString());
        }
        boolean z = !fragment2.isInBackStack();
        if (!fragment2.mDetached || z) {
            if (this.mAdded != null) {
                boolean remove = this.mAdded.remove(fragment2);
            }
            if (fragment2.mHasMenu && fragment2.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment2.mAdded = false;
            fragment2.mRemoving = true;
            moveToState(fragment2, z ? 0 : 1, i3, i4, false);
        }
    }

    public void removeOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        OnBackStackChangedListener onBackStackChangedListener2 = onBackStackChangedListener;
        if (this.mBackStackChangeListeners != null) {
            boolean remove = this.mBackStackChangeListeners.remove(onBackStackChangedListener2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i = 0; i < this.mBackStackChangeListeners.size(); i++) {
                ((OnBackStackChangedListener) this.mBackStackChangeListeners.get(i)).onBackStackChanged();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        ArrayList arrayList;
        ArrayList arrayList2;
        StringBuilder sb;
        PrintWriter printWriter;
        LogWriter logWriter;
        ArrayList arrayList3;
        IllegalStateException illegalStateException;
        StringBuilder sb2;
        IllegalStateException illegalStateException2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        ArrayList arrayList4;
        StringBuilder sb6;
        StringBuilder sb7;
        Parcelable parcelable2 = parcelable;
        List<Fragment> list2 = list;
        if (parcelable2 != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable2;
            if (fragmentManagerState.mActive != null) {
                if (list2 != null) {
                    for (int i = 0; i < list2.size(); i++) {
                        Fragment fragment = (Fragment) list2.get(i);
                        if (DEBUG) {
                            String str = TAG;
                            StringBuilder sb8 = sb7;
                            StringBuilder sb9 = new StringBuilder();
                            int v = Log.v(str, sb8.append("restoreAllState: re-attaching retained ").append(fragment).toString());
                        }
                        FragmentState fragmentState = fragmentManagerState.mActive[fragment.mIndex];
                        fragmentState.mInstance = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.mSavedFragmentState != null) {
                            fragmentState.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
                            fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
                            fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
                        }
                    }
                }
                ArrayList arrayList5 = arrayList;
                ArrayList arrayList6 = new ArrayList(fragmentManagerState.mActive.length);
                this.mActive = arrayList5;
                if (this.mAvailIndices != null) {
                    this.mAvailIndices.clear();
                }
                for (int i2 = 0; i2 < fragmentManagerState.mActive.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.mActive[i2];
                    if (fragmentState2 != null) {
                        Fragment instantiate = fragmentState2.instantiate(this.mHost, this.mParent);
                        if (DEBUG) {
                            String str2 = TAG;
                            StringBuilder sb10 = sb6;
                            StringBuilder sb11 = new StringBuilder();
                            int v2 = Log.v(str2, sb10.append("restoreAllState: active #").append(i2).append(": ").append(instantiate).toString());
                        }
                        boolean add = this.mActive.add(instantiate);
                        fragmentState2.mInstance = null;
                    } else {
                        boolean add2 = this.mActive.add(null);
                        if (this.mAvailIndices == null) {
                            ArrayList arrayList7 = arrayList4;
                            ArrayList arrayList8 = new ArrayList();
                            this.mAvailIndices = arrayList7;
                        }
                        if (DEBUG) {
                            String str3 = TAG;
                            StringBuilder sb12 = sb5;
                            StringBuilder sb13 = new StringBuilder();
                            int v3 = Log.v(str3, sb12.append("restoreAllState: avail #").append(i2).toString());
                        }
                        boolean add3 = this.mAvailIndices.add(Integer.valueOf(i2));
                    }
                }
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        Fragment fragment2 = (Fragment) list2.get(i3);
                        if (fragment2.mTargetIndex >= 0) {
                            if (fragment2.mTargetIndex < this.mActive.size()) {
                                fragment2.mTarget = (Fragment) this.mActive.get(fragment2.mTargetIndex);
                            } else {
                                String str4 = TAG;
                                StringBuilder sb14 = sb4;
                                StringBuilder sb15 = new StringBuilder();
                                int w = Log.w(str4, sb14.append("Re-attaching retained fragment ").append(fragment2).append(" target no longer exists: ").append(fragment2.mTargetIndex).toString());
                                fragment2.mTarget = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.mAdded != null) {
                    ArrayList arrayList9 = arrayList3;
                    ArrayList arrayList10 = new ArrayList(fragmentManagerState.mAdded.length);
                    this.mAdded = arrayList9;
                    for (int i4 = 0; i4 < fragmentManagerState.mAdded.length; i4++) {
                        Fragment fragment3 = (Fragment) this.mActive.get(fragmentManagerState.mAdded[i4]);
                        if (fragment3 == null) {
                            IllegalStateException illegalStateException3 = illegalStateException2;
                            StringBuilder sb16 = sb3;
                            StringBuilder sb17 = new StringBuilder();
                            IllegalStateException illegalStateException4 = new IllegalStateException(sb16.append("No instantiated fragment for index #").append(fragmentManagerState.mAdded[i4]).toString());
                            throwException(illegalStateException3);
                        }
                        fragment3.mAdded = true;
                        if (DEBUG) {
                            String str5 = TAG;
                            StringBuilder sb18 = sb2;
                            StringBuilder sb19 = new StringBuilder();
                            int v4 = Log.v(str5, sb18.append("restoreAllState: added #").append(i4).append(": ").append(fragment3).toString());
                        }
                        if (this.mAdded.contains(fragment3)) {
                            IllegalStateException illegalStateException5 = illegalStateException;
                            IllegalStateException illegalStateException6 = new IllegalStateException("Already added!");
                            throw illegalStateException5;
                        }
                        boolean add4 = this.mAdded.add(fragment3);
                    }
                } else {
                    this.mAdded = null;
                }
                if (fragmentManagerState.mBackStack != null) {
                    ArrayList arrayList11 = arrayList2;
                    ArrayList arrayList12 = new ArrayList(fragmentManagerState.mBackStack.length);
                    this.mBackStack = arrayList11;
                    for (int i5 = 0; i5 < fragmentManagerState.mBackStack.length; i5++) {
                        BackStackRecord instantiate2 = fragmentManagerState.mBackStack[i5].instantiate(this);
                        if (DEBUG) {
                            String str6 = TAG;
                            StringBuilder sb20 = sb;
                            StringBuilder sb21 = new StringBuilder();
                            int v5 = Log.v(str6, sb20.append("restoreAllState: back stack #").append(i5).append(" (index ").append(instantiate2.mIndex).append("): ").append(instantiate2).toString());
                            PrintWriter printWriter2 = printWriter;
                            LogWriter logWriter2 = logWriter;
                            LogWriter logWriter3 = new LogWriter(TAG);
                            PrintWriter printWriter3 = new PrintWriter(logWriter2);
                            instantiate2.dump("  ", printWriter2, false);
                        }
                        boolean add5 = this.mBackStack.add(instantiate2);
                        if (instantiate2.mIndex >= 0) {
                            setBackStackIndex(instantiate2.mIndex, instantiate2);
                        }
                    }
                    return;
                }
                this.mBackStack = null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public ArrayList<Fragment> retainNonConfig() {
        StringBuilder sb;
        ArrayList<Fragment> arrayList;
        ArrayList<Fragment> arrayList2 = null;
        if (this.mActive != null) {
            for (int i = 0; i < this.mActive.size(); i++) {
                Fragment fragment = (Fragment) this.mActive.get(i);
                if (fragment != null && fragment.mRetainInstance) {
                    if (arrayList2 == null) {
                        ArrayList<Fragment> arrayList3 = arrayList;
                        ArrayList<Fragment> arrayList4 = new ArrayList<>();
                        arrayList2 = arrayList3;
                    }
                    boolean add = arrayList2.add(fragment);
                    fragment.mRetaining = true;
                    fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                    if (DEBUG) {
                        String str = TAG;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        int v = Log.v(str, sb2.append("retainNonConfig: keeping retained ").append(fragment).toString());
                    }
                }
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: 0000 */
    public Parcelable saveAllState() {
        FragmentManagerState fragmentManagerState;
        BackStackState backStackState;
        StringBuilder sb;
        StringBuilder sb2;
        IllegalStateException illegalStateException;
        StringBuilder sb3;
        FragmentState fragmentState;
        StringBuilder sb4;
        Bundle bundle;
        IllegalStateException illegalStateException2;
        StringBuilder sb5;
        IllegalStateException illegalStateException3;
        StringBuilder sb6;
        boolean execPendingActions = execPendingActions();
        if (HONEYCOMB) {
            this.mStateSaved = true;
        }
        if (this.mActive != null) {
            if (this.mActive.size() > 0) {
                int size = this.mActive.size();
                FragmentState[] fragmentStateArr = new FragmentState[size];
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    Fragment fragment = (Fragment) this.mActive.get(i);
                    if (fragment != null) {
                        if (fragment.mIndex < 0) {
                            IllegalStateException illegalStateException4 = illegalStateException3;
                            StringBuilder sb7 = sb6;
                            StringBuilder sb8 = new StringBuilder();
                            IllegalStateException illegalStateException5 = new IllegalStateException(sb7.append("Failure saving state: active ").append(fragment).append(" has cleared index: ").append(fragment.mIndex).toString());
                            throwException(illegalStateException4);
                        }
                        z = true;
                        FragmentState fragmentState2 = fragmentState;
                        FragmentState fragmentState3 = new FragmentState(fragment);
                        FragmentState fragmentState4 = fragmentState2;
                        fragmentStateArr[i] = fragmentState4;
                        if (fragment.mState <= 0 || fragmentState4.mSavedFragmentState != null) {
                            fragmentState4.mSavedFragmentState = fragment.mSavedFragmentState;
                        } else {
                            fragmentState4.mSavedFragmentState = saveFragmentBasicState(fragment);
                            if (fragment.mTarget != null) {
                                if (fragment.mTarget.mIndex < 0) {
                                    IllegalStateException illegalStateException6 = illegalStateException2;
                                    StringBuilder sb9 = sb5;
                                    StringBuilder sb10 = new StringBuilder();
                                    IllegalStateException illegalStateException7 = new IllegalStateException(sb9.append("Failure saving state: ").append(fragment).append(" has target not in fragment manager: ").append(fragment.mTarget).toString());
                                    throwException(illegalStateException6);
                                }
                                if (fragmentState4.mSavedFragmentState == null) {
                                    FragmentState fragmentState5 = fragmentState4;
                                    Bundle bundle2 = bundle;
                                    Bundle bundle3 = new Bundle();
                                    fragmentState5.mSavedFragmentState = bundle2;
                                }
                                putFragment(fragmentState4.mSavedFragmentState, TARGET_STATE_TAG, fragment.mTarget);
                                if (fragment.mTargetRequestCode != 0) {
                                    fragmentState4.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, fragment.mTargetRequestCode);
                                }
                            }
                        }
                        if (DEBUG) {
                            String str = TAG;
                            StringBuilder sb11 = sb4;
                            StringBuilder sb12 = new StringBuilder();
                            int v = Log.v(str, sb11.append("Saved state of ").append(fragment).append(": ").append(fragmentState4.mSavedFragmentState).toString());
                        }
                    }
                }
                if (z) {
                    int[] iArr = null;
                    if (this.mAdded != null) {
                        int size2 = this.mAdded.size();
                        iArr = null;
                        if (size2 > 0) {
                            iArr = new int[size2];
                            for (int i2 = 0; i2 < size2; i2++) {
                                iArr[i2] = ((Fragment) this.mAdded.get(i2)).mIndex;
                                if (iArr[i2] < 0) {
                                    IllegalStateException illegalStateException8 = illegalStateException;
                                    StringBuilder sb13 = sb3;
                                    StringBuilder sb14 = new StringBuilder();
                                    IllegalStateException illegalStateException9 = new IllegalStateException(sb13.append("Failure saving state: active ").append(this.mAdded.get(i2)).append(" has cleared index: ").append(iArr[i2]).toString());
                                    throwException(illegalStateException8);
                                }
                                if (DEBUG) {
                                    String str2 = TAG;
                                    StringBuilder sb15 = sb2;
                                    StringBuilder sb16 = new StringBuilder();
                                    int v2 = Log.v(str2, sb15.append("saveAllState: adding fragment #").append(i2).append(": ").append(this.mAdded.get(i2)).toString());
                                }
                            }
                        }
                    }
                    BackStackState[] backStackStateArr = null;
                    if (this.mBackStack != null) {
                        int size3 = this.mBackStack.size();
                        backStackStateArr = null;
                        if (size3 > 0) {
                            backStackStateArr = new BackStackState[size3];
                            for (int i3 = 0; i3 < size3; i3++) {
                                BackStackState[] backStackStateArr2 = backStackStateArr;
                                int i4 = i3;
                                BackStackState backStackState2 = backStackState;
                                BackStackState backStackState3 = new BackStackState((BackStackRecord) this.mBackStack.get(i3));
                                backStackStateArr2[i4] = backStackState2;
                                if (DEBUG) {
                                    String str3 = TAG;
                                    StringBuilder sb17 = sb;
                                    StringBuilder sb18 = new StringBuilder();
                                    int v3 = Log.v(str3, sb17.append("saveAllState: adding back stack #").append(i3).append(": ").append(this.mBackStack.get(i3)).toString());
                                }
                            }
                        }
                    }
                    FragmentManagerState fragmentManagerState2 = fragmentManagerState;
                    FragmentManagerState fragmentManagerState3 = new FragmentManagerState();
                    FragmentManagerState fragmentManagerState4 = fragmentManagerState2;
                    fragmentManagerState4.mActive = fragmentStateArr;
                    fragmentManagerState4.mAdded = iArr;
                    fragmentManagerState4.mBackStack = backStackStateArr;
                    return fragmentManagerState4;
                } else if (DEBUG) {
                    int v4 = Log.v(TAG, "saveAllState: no fragments!");
                    return null;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public Bundle saveFragmentBasicState(Fragment fragment) {
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        Fragment fragment2 = fragment;
        if (this.mStateBundle == null) {
            Bundle bundle4 = bundle3;
            Bundle bundle5 = new Bundle();
            this.mStateBundle = bundle4;
        }
        fragment2.performSaveInstanceState(this.mStateBundle);
        Bundle bundle6 = null;
        if (!this.mStateBundle.isEmpty()) {
            bundle6 = this.mStateBundle;
            this.mStateBundle = null;
        }
        if (fragment2.mView != null) {
            saveFragmentViewState(fragment2);
        }
        if (fragment2.mSavedViewState != null) {
            if (bundle6 == null) {
                Bundle bundle7 = bundle2;
                Bundle bundle8 = new Bundle();
                bundle6 = bundle7;
            }
            bundle6.putSparseParcelableArray(VIEW_STATE_TAG, fragment2.mSavedViewState);
        }
        if (!fragment2.mUserVisibleHint) {
            if (bundle6 == null) {
                Bundle bundle9 = bundle;
                Bundle bundle10 = new Bundle();
                bundle6 = bundle9;
            }
            bundle6.putBoolean(USER_VISIBLE_HINT_TAG, fragment2.mUserVisibleHint);
        }
        return bundle6;
    }

    public SavedState saveFragmentInstanceState(Fragment fragment) {
        SavedState savedState;
        IllegalStateException illegalStateException;
        StringBuilder sb;
        Fragment fragment2 = fragment;
        if (fragment2.mIndex < 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Fragment ").append(fragment2).append(" is not currently in the FragmentManager").toString());
            throwException(illegalStateException2);
        }
        SavedState savedState2 = null;
        if (fragment2.mState > 0) {
            Bundle saveFragmentBasicState = saveFragmentBasicState(fragment2);
            savedState2 = null;
            if (saveFragmentBasicState != null) {
                SavedState savedState3 = savedState;
                SavedState savedState4 = new SavedState(saveFragmentBasicState);
                savedState2 = savedState3;
            }
        }
        return savedState2;
    }

    /* access modifiers changed from: 0000 */
    public void saveFragmentViewState(Fragment fragment) {
        SparseArray<Parcelable> sparseArray;
        Fragment fragment2 = fragment;
        if (fragment2.mInnerView != null) {
            if (this.mStateArray == null) {
                SparseArray<Parcelable> sparseArray2 = sparseArray;
                SparseArray<Parcelable> sparseArray3 = new SparseArray<>();
                this.mStateArray = sparseArray2;
            } else {
                this.mStateArray.clear();
            }
            fragment2.mInnerView.saveHierarchyState(this.mStateArray);
            if (this.mStateArray.size() > 0) {
                fragment2.mSavedViewState = this.mStateArray;
                this.mStateArray = null;
            }
        }
    }

    public void setBackStackIndex(int i, BackStackRecord backStackRecord) {
        int i2;
        StringBuilder sb;
        StringBuilder sb2;
        ArrayList<Integer> arrayList;
        StringBuilder sb3;
        ArrayList<BackStackRecord> arrayList2;
        th = i;
        BackStackRecord backStackRecord2 = backStackRecord;
        synchronized (this) {
            try {
                if (this.mBackStackIndices == null) {
                    ArrayList<BackStackRecord> arrayList3 = arrayList2;
                    ArrayList<BackStackRecord> arrayList4 = new ArrayList<>();
                    this.mBackStackIndices = arrayList3;
                }
                this = this.mBackStackIndices.size();
                if (th < this) {
                    if (DEBUG) {
                        String str = TAG;
                        StringBuilder sb4 = sb3;
                        StringBuilder sb5 = new StringBuilder();
                        int v = Log.v(str, sb4.append("Setting back stack index ").append(th).append(" to ").append(backStackRecord2).toString());
                    }
                    Object obj = this.mBackStackIndices.set(th, backStackRecord2);
                } else {
                    while (i2 < th) {
                        boolean add = this.mBackStackIndices.add(null);
                        if (this.mAvailBackStackIndices == null) {
                            ArrayList<Integer> arrayList5 = arrayList;
                            ArrayList<Integer> arrayList6 = new ArrayList<>();
                            this.mAvailBackStackIndices = arrayList5;
                        }
                        if (DEBUG) {
                            String str2 = TAG;
                            StringBuilder sb6 = sb2;
                            StringBuilder sb7 = new StringBuilder();
                            int v2 = Log.v(str2, sb6.append("Adding available back stack index ").append(i2).toString());
                        }
                        boolean add2 = this.mAvailBackStackIndices.add(Integer.valueOf(i2));
                        i2++;
                    }
                    if (DEBUG) {
                        String str3 = TAG;
                        StringBuilder sb8 = sb;
                        StringBuilder sb9 = new StringBuilder();
                        int v3 = Log.v(str3, sb8.append("Adding back stack index ").append(th).append(" with ").append(backStackRecord2).toString());
                    }
                    boolean add3 = this.mBackStackIndices.add(backStackRecord2);
                }
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
    }

    public void showFragment(Fragment fragment, int i, int i2) {
        StringBuilder sb;
        Fragment fragment2 = fragment;
        int i3 = i;
        int i4 = i2;
        if (DEBUG) {
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int v = Log.v(str, sb2.append("show: ").append(fragment2).toString());
        }
        if (fragment2.mHidden) {
            fragment2.mHidden = false;
            if (fragment2.mView != null) {
                Animation loadAnimation = loadAnimation(fragment2, i3, true, i4);
                if (loadAnimation != null) {
                    setHWLayerAnimListenerIfAlpha(fragment2.mView, loadAnimation);
                    fragment2.mView.startAnimation(loadAnimation);
                }
                fragment2.mView.setVisibility(0);
            }
            if (fragment2.mAdded && fragment2.mHasMenu && fragment2.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment2.onHiddenChanged(false);
        }
    }

    /* access modifiers changed from: 0000 */
    public void startPendingDeferredFragments() {
        if (this.mActive != null) {
            for (int i = 0; i < this.mActive.size(); i++) {
                Fragment fragment = (Fragment) this.mActive.get(i);
                if (fragment != null) {
                    performPendingDeferredStart(fragment);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(128);
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("FragmentManager{");
        StringBuilder append2 = sb4.append(Integer.toHexString(System.identityHashCode(this)));
        StringBuilder append3 = sb4.append(" in ");
        if (this.mParent != null) {
            DebugUtils.buildShortClassTag(this.mParent, sb4);
        } else {
            DebugUtils.buildShortClassTag(this.mHost, sb4);
        }
        StringBuilder append4 = sb4.append("}}");
        return sb4.toString();
    }
}
