package android.support.p000v4.app;

import android.os.Build.VERSION;
import android.support.p000v4.app.FragmentManager.BackStackEntry;
import android.support.p000v4.app.FragmentTransitionCompat21.EpicenterView;
import android.support.p000v4.app.FragmentTransitionCompat21.ViewRetriever;
import android.support.p000v4.util.ArrayMap;
import android.support.p000v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.BackStackRecord */
final class BackStackRecord extends FragmentTransaction implements BackStackEntry, Runnable {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SHOW = 5;
    static final boolean SUPPORTS_TRANSITIONS = (VERSION.SDK_INT >= 21);
    static final String TAG = "FragmentManager";
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack = true;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    boolean mCommitted;
    int mEnterAnim;
    int mExitAnim;
    C0008Op mHead;
    int mIndex = -1;
    final FragmentManagerImpl mManager;
    String mName;
    int mNumOp;
    int mPopEnterAnim;
    int mPopExitAnim;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    C0008Op mTail;
    int mTransition;
    int mTransitionStyle;

    /* renamed from: android.support.v4.app.BackStackRecord$Op */
    static final class C0008Op {
        int cmd;
        int enterAnim;
        int exitAnim;
        Fragment fragment;
        C0008Op next;
        int popEnterAnim;
        int popExitAnim;
        C0008Op prev;
        ArrayList<Fragment> removed;

        C0008Op() {
        }
    }

    /* renamed from: android.support.v4.app.BackStackRecord$TransitionState */
    public class TransitionState {
        public EpicenterView enteringEpicenterView;
        public ArrayList<View> hiddenFragmentViews;
        public ArrayMap<String, String> nameOverrides;
        public View nonExistentView;
        final /* synthetic */ BackStackRecord this$0;

        public TransitionState(BackStackRecord backStackRecord) {
            ArrayMap<String, String> arrayMap;
            ArrayList<View> arrayList;
            EpicenterView epicenterView;
            this.this$0 = backStackRecord;
            ArrayMap<String, String> arrayMap2 = arrayMap;
            ArrayMap<String, String> arrayMap3 = new ArrayMap<>();
            this.nameOverrides = arrayMap2;
            ArrayList<View> arrayList2 = arrayList;
            ArrayList<View> arrayList3 = new ArrayList<>();
            this.hiddenFragmentViews = arrayList2;
            EpicenterView epicenterView2 = epicenterView;
            EpicenterView epicenterView3 = new EpicenterView();
            this.enteringEpicenterView = epicenterView2;
        }
    }

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        FragmentManagerImpl fragmentManagerImpl2 = fragmentManagerImpl;
        this.mManager = fragmentManagerImpl2;
    }

    private TransitionState beginTransition(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        TransitionState transitionState;
        View view;
        SparseArray<Fragment> sparseArray3 = sparseArray;
        SparseArray<Fragment> sparseArray4 = sparseArray2;
        boolean z2 = z;
        TransitionState transitionState2 = transitionState;
        TransitionState transitionState3 = new TransitionState(this);
        TransitionState transitionState4 = transitionState2;
        TransitionState transitionState5 = transitionState4;
        View view2 = view;
        View view3 = new View(this.mManager.mHost.getContext());
        transitionState5.nonExistentView = view2;
        boolean z3 = false;
        for (int i = 0; i < sparseArray3.size(); i++) {
            if (configureTransitions(sparseArray3.keyAt(i), transitionState4, z2, sparseArray3, sparseArray4)) {
                z3 = true;
            }
        }
        for (int i2 = 0; i2 < sparseArray4.size(); i2++) {
            int keyAt = sparseArray4.keyAt(i2);
            if (sparseArray3.get(keyAt) == null && configureTransitions(keyAt, transitionState4, z2, sparseArray3, sparseArray4)) {
                z3 = true;
            }
        }
        if (!z3) {
            transitionState4 = null;
        }
        return transitionState4;
    }

    private void calculateFragments(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        SparseArray<Fragment> sparseArray3 = sparseArray;
        SparseArray<Fragment> sparseArray4 = sparseArray2;
        if (this.mManager.mContainer.onHasView()) {
            C0008Op op = this.mHead;
            while (true) {
                C0008Op op2 = op;
                if (op2 != null) {
                    switch (op2.cmd) {
                        case 1:
                            setLastIn(sparseArray4, op2.fragment);
                            break;
                        case 2:
                            Fragment fragment = op2.fragment;
                            if (this.mManager.mAdded != null) {
                                for (int i = 0; i < this.mManager.mAdded.size(); i++) {
                                    Fragment fragment2 = (Fragment) this.mManager.mAdded.get(i);
                                    if (fragment == null || fragment2.mContainerId == fragment.mContainerId) {
                                        if (fragment2 == fragment) {
                                            fragment = null;
                                        } else {
                                            setFirstOut(sparseArray3, fragment2);
                                        }
                                    }
                                }
                            }
                            setLastIn(sparseArray4, fragment);
                            break;
                        case 3:
                            setFirstOut(sparseArray3, op2.fragment);
                            break;
                        case 4:
                            setFirstOut(sparseArray3, op2.fragment);
                            break;
                        case 5:
                            setLastIn(sparseArray4, op2.fragment);
                            break;
                        case 6:
                            setFirstOut(sparseArray3, op2.fragment);
                            break;
                        case 7:
                            setLastIn(sparseArray4, op2.fragment);
                            break;
                    }
                    op = op2.next;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void callSharedElementEnd(TransitionState transitionState, Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap) {
        ArrayList arrayList;
        ArrayList arrayList2;
        TransitionState transitionState2 = transitionState;
        ArrayMap<String, View> arrayMap2 = arrayMap;
        SharedElementCallback sharedElementCallback = z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
        if (sharedElementCallback != null) {
            SharedElementCallback sharedElementCallback2 = sharedElementCallback;
            ArrayList arrayList3 = arrayList;
            ArrayList arrayList4 = new ArrayList(arrayMap2.keySet());
            ArrayList arrayList5 = arrayList2;
            ArrayList arrayList6 = new ArrayList(arrayMap2.values());
            sharedElementCallback2.onSharedElementEnd(arrayList3, arrayList5, null);
        }
    }

    private static Object captureExitingViews(Object obj, Fragment fragment, ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, View view) {
        Object obj2 = obj;
        Fragment fragment2 = fragment;
        ArrayList<View> arrayList2 = arrayList;
        ArrayMap<String, View> arrayMap2 = arrayMap;
        View view2 = view;
        if (obj2 != null) {
            obj2 = FragmentTransitionCompat21.captureExitingViews(obj2, fragment2.getView(), arrayList2, arrayMap2, view2);
        }
        return obj2;
    }

    private boolean configureTransitions(int i, TransitionState transitionState, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        C00051 r44;
        ArrayList arrayList3;
        ArrayMap arrayMap;
        ArrayList arrayList4;
        ArrayList arrayList5;
        int i2 = i;
        TransitionState transitionState2 = transitionState;
        boolean z2 = z;
        SparseArray<Fragment> sparseArray3 = sparseArray;
        SparseArray<Fragment> sparseArray4 = sparseArray2;
        ViewGroup viewGroup = (ViewGroup) this.mManager.mContainer.onFindViewById(i2);
        if (viewGroup == null) {
            return false;
        }
        Fragment fragment = (Fragment) sparseArray4.get(i2);
        Fragment fragment2 = (Fragment) sparseArray3.get(i2);
        Object enterTransition = getEnterTransition(fragment, z2);
        Object sharedElementTransition = getSharedElementTransition(fragment, fragment2, z2);
        Object exitTransition = getExitTransition(fragment2, z2);
        ArrayList arrayList6 = arrayList;
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = arrayList6;
        ArrayMap arrayMap2 = null;
        if (sharedElementTransition != null) {
            arrayMap2 = remapSharedElements(transitionState2, fragment2, z2);
            if (arrayMap2.isEmpty()) {
                sharedElementTransition = null;
                arrayMap2 = null;
            } else {
                SharedElementCallback sharedElementCallback = z2 ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
                if (sharedElementCallback != null) {
                    ArrayList arrayList9 = arrayList4;
                    ArrayList arrayList10 = new ArrayList(arrayMap2.keySet());
                    ArrayList arrayList11 = arrayList9;
                    ArrayList arrayList12 = arrayList5;
                    ArrayList arrayList13 = new ArrayList(arrayMap2.values());
                    sharedElementCallback.onSharedElementStart(arrayList11, arrayList12, null);
                }
                prepareSharedElementTransition(transitionState2, viewGroup, sharedElementTransition, fragment, fragment2, z2, arrayList8);
            }
        }
        if (enterTransition == null && sharedElementTransition == null && exitTransition == null) {
            return false;
        }
        ArrayList arrayList14 = arrayList2;
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = arrayList14;
        Object captureExitingViews = captureExitingViews(exitTransition, fragment2, arrayList16, arrayMap2, transitionState2.nonExistentView);
        if (!(this.mSharedElementTargetNames == null || arrayMap2 == null)) {
            View view = (View) arrayMap2.get(this.mSharedElementTargetNames.get(0));
            if (view != null) {
                if (captureExitingViews != null) {
                    FragmentTransitionCompat21.setEpicenter(captureExitingViews, view);
                }
                if (sharedElementTransition != null) {
                    FragmentTransitionCompat21.setEpicenter(sharedElementTransition, view);
                }
            }
        }
        C00051 r33 = r44;
        final Fragment fragment3 = fragment;
        C00051 r34 = new ViewRetriever(this) {
            final /* synthetic */ BackStackRecord this$0;

            {
                Fragment fragment = r7;
                this.this$0 = r6;
            }

            public View getView() {
                return fragment3.getView();
            }
        };
        C00051 r18 = r33;
        ArrayList arrayList17 = arrayList3;
        ArrayList arrayList18 = new ArrayList();
        ArrayList arrayList19 = arrayList17;
        ArrayMap arrayMap3 = arrayMap;
        ArrayMap arrayMap4 = new ArrayMap();
        ArrayMap arrayMap5 = arrayMap3;
        boolean z3 = true;
        if (fragment != null) {
            z3 = z2 ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        Object mergeTransitions = FragmentTransitionCompat21.mergeTransitions(enterTransition, captureExitingViews, sharedElementTransition, z3);
        if (mergeTransitions != null) {
            FragmentTransitionCompat21.addTransitionTargets(enterTransition, sharedElementTransition, viewGroup, r18, transitionState2.nonExistentView, transitionState2.enteringEpicenterView, transitionState2.nameOverrides, arrayList19, arrayMap2, arrayMap5, arrayList8);
            excludeHiddenFragmentsAfterEnter(viewGroup, transitionState2, i2, mergeTransitions);
            FragmentTransitionCompat21.excludeTarget(mergeTransitions, transitionState2.nonExistentView, true);
            excludeHiddenFragments(transitionState2, i2, mergeTransitions);
            FragmentTransitionCompat21.beginDelayedTransition(viewGroup, mergeTransitions);
            FragmentTransitionCompat21.cleanupTransitions(viewGroup, transitionState2.nonExistentView, enterTransition, arrayList19, captureExitingViews, arrayList16, sharedElementTransition, arrayList8, mergeTransitions, transitionState2.hiddenFragmentViews, arrayMap5);
        }
        return mergeTransitions != null;
    }

    private void doAddOp(int i, Fragment fragment, String str, int i2) {
        C0008Op op;
        IllegalStateException illegalStateException;
        StringBuilder sb;
        IllegalStateException illegalStateException2;
        StringBuilder sb2;
        int i3 = i;
        Fragment fragment2 = fragment;
        String str2 = str;
        int i4 = i2;
        fragment2.mFragmentManager = this.mManager;
        if (str2 != null) {
            if (fragment2.mTag == null || str2.equals(fragment2.mTag)) {
                fragment2.mTag = str2;
            } else {
                IllegalStateException illegalStateException3 = illegalStateException2;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                IllegalStateException illegalStateException4 = new IllegalStateException(sb3.append("Can't change tag of fragment ").append(fragment2).append(": was ").append(fragment2.mTag).append(" now ").append(str2).toString());
                throw illegalStateException3;
            }
        }
        if (i3 != 0) {
            if (fragment2.mFragmentId == 0 || fragment2.mFragmentId == i3) {
                fragment2.mFragmentId = i3;
                fragment2.mContainerId = i3;
            } else {
                IllegalStateException illegalStateException5 = illegalStateException;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                IllegalStateException illegalStateException6 = new IllegalStateException(sb5.append("Can't change container ID of fragment ").append(fragment2).append(": was ").append(fragment2.mFragmentId).append(" now ").append(i3).toString());
                throw illegalStateException5;
            }
        }
        C0008Op op2 = op;
        C0008Op op3 = new C0008Op();
        C0008Op op4 = op2;
        op4.cmd = i4;
        op4.fragment = fragment2;
        addOp(op4);
    }

    /* access modifiers changed from: private */
    public void excludeHiddenFragments(TransitionState transitionState, int i, Object obj) {
        TransitionState transitionState2 = transitionState;
        int i2 = i;
        Object obj2 = obj;
        if (this.mManager.mAdded != null) {
            for (int i3 = 0; i3 < this.mManager.mAdded.size(); i3++) {
                Fragment fragment = (Fragment) this.mManager.mAdded.get(i3);
                if (!(fragment.mView == null || fragment.mContainer == null || fragment.mContainerId != i2)) {
                    if (!fragment.mHidden) {
                        FragmentTransitionCompat21.excludeTarget(obj2, fragment.mView, false);
                        boolean remove = transitionState2.hiddenFragmentViews.remove(fragment.mView);
                    } else if (!transitionState2.hiddenFragmentViews.contains(fragment.mView)) {
                        FragmentTransitionCompat21.excludeTarget(obj2, fragment.mView, true);
                        boolean add = transitionState2.hiddenFragmentViews.add(fragment.mView);
                    }
                }
            }
        }
    }

    private void excludeHiddenFragmentsAfterEnter(View view, TransitionState transitionState, int i, Object obj) {
        C00073 r13;
        View view2 = view;
        TransitionState transitionState2 = transitionState;
        int i2 = i;
        Object obj2 = obj;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        C00073 r6 = r13;
        final View view3 = view2;
        final TransitionState transitionState3 = transitionState2;
        final int i3 = i2;
        final Object obj3 = obj2;
        C00073 r7 = new OnPreDrawListener(this) {
            final /* synthetic */ BackStackRecord this$0;

            {
                View view = r10;
                TransitionState transitionState = r11;
                int i = r12;
                Object obj = r13;
                this.this$0 = r9;
            }

            public boolean onPreDraw() {
                view3.getViewTreeObserver().removeOnPreDrawListener(this);
                this.this$0.excludeHiddenFragments(transitionState3, i3, obj3);
                return true;
            }
        };
        viewTreeObserver.addOnPreDrawListener(r6);
    }

    private static Object getEnterTransition(Fragment fragment, boolean z) {
        Fragment fragment2 = fragment;
        boolean z2 = z;
        if (fragment2 == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(z2 ? fragment2.getReenterTransition() : fragment2.getEnterTransition());
    }

    private static Object getExitTransition(Fragment fragment, boolean z) {
        Fragment fragment2 = fragment;
        boolean z2 = z;
        if (fragment2 == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(z2 ? fragment2.getReturnTransition() : fragment2.getExitTransition());
    }

    private static Object getSharedElementTransition(Fragment fragment, Fragment fragment2, boolean z) {
        Fragment fragment3 = fragment;
        Fragment fragment4 = fragment2;
        boolean z2 = z;
        if (fragment3 == null || fragment4 == null) {
            return null;
        }
        return FragmentTransitionCompat21.wrapSharedElementTransition(z2 ? fragment4.getSharedElementReturnTransition() : fragment3.getSharedElementEnterTransition());
    }

    private ArrayMap<String, View> mapEnteringSharedElements(TransitionState transitionState, Fragment fragment, boolean z) {
        ArrayMap arrayMap;
        TransitionState transitionState2 = transitionState;
        Fragment fragment2 = fragment;
        boolean z2 = z;
        ArrayMap arrayMap2 = arrayMap;
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = arrayMap2;
        View view = fragment2.getView();
        if (!(view == null || this.mSharedElementSourceNames == null)) {
            FragmentTransitionCompat21.findNamedViews(arrayMap4, view);
            if (z2) {
                arrayMap4 = remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, arrayMap4);
            } else {
                boolean retainAll = arrayMap4.retainAll(this.mSharedElementTargetNames);
                return arrayMap4;
            }
        }
        return arrayMap4;
    }

    /* access modifiers changed from: private */
    public ArrayMap<String, View> mapSharedElementsIn(TransitionState transitionState, boolean z, Fragment fragment) {
        TransitionState transitionState2 = transitionState;
        boolean z2 = z;
        Fragment fragment2 = fragment;
        ArrayMap mapEnteringSharedElements = mapEnteringSharedElements(transitionState2, fragment2, z2);
        if (z2) {
            if (fragment2.mExitTransitionCallback != null) {
                fragment2.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, mapEnteringSharedElements);
            }
            setBackNameOverrides(transitionState2, mapEnteringSharedElements, true);
            return mapEnteringSharedElements;
        }
        if (fragment2.mEnterTransitionCallback != null) {
            fragment2.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, mapEnteringSharedElements);
        }
        setNameOverrides(transitionState2, mapEnteringSharedElements, true);
        return mapEnteringSharedElements;
    }

    private void prepareSharedElementTransition(TransitionState transitionState, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        C00062 r19;
        TransitionState transitionState2 = transitionState;
        View view2 = view;
        Object obj2 = obj;
        Fragment fragment3 = fragment;
        Fragment fragment4 = fragment2;
        boolean z2 = z;
        ArrayList<View> arrayList2 = arrayList;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        C00062 r9 = r19;
        final View view3 = view2;
        final Object obj3 = obj2;
        final ArrayList<View> arrayList3 = arrayList2;
        final TransitionState transitionState3 = transitionState2;
        final boolean z3 = z2;
        final Fragment fragment5 = fragment3;
        final Fragment fragment6 = fragment4;
        C00062 r10 = new OnPreDrawListener(this) {
            final /* synthetic */ BackStackRecord this$0;

            {
                View view = r13;
                Object obj = r14;
                ArrayList arrayList = r15;
                TransitionState transitionState = r16;
                boolean z = r17;
                Fragment fragment = r18;
                Fragment fragment2 = r19;
                this.this$0 = r12;
            }

            public boolean onPreDraw() {
                view3.getViewTreeObserver().removeOnPreDrawListener(this);
                if (obj3 != null) {
                    FragmentTransitionCompat21.removeTargets(obj3, arrayList3);
                    arrayList3.clear();
                    ArrayMap access$000 = this.this$0.mapSharedElementsIn(transitionState3, z3, fragment5);
                    FragmentTransitionCompat21.setSharedElementTargets(obj3, transitionState3.nonExistentView, access$000, arrayList3);
                    this.this$0.setEpicenterIn(access$000, transitionState3);
                    this.this$0.callSharedElementEnd(transitionState3, fragment5, fragment6, z3, access$000);
                }
                return true;
            }
        };
        viewTreeObserver.addOnPreDrawListener(r9);
    }

    private static ArrayMap<String, View> remapNames(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayMap<String, View> arrayMap) {
        ArrayMap arrayMap2;
        ArrayList<String> arrayList3 = arrayList;
        ArrayList<String> arrayList4 = arrayList2;
        ArrayMap<String, View> arrayMap3 = arrayMap;
        if (arrayMap3.isEmpty()) {
            return arrayMap3;
        }
        ArrayMap arrayMap4 = arrayMap2;
        ArrayMap arrayMap5 = new ArrayMap();
        ArrayMap arrayMap6 = arrayMap4;
        int size = arrayList3.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayMap3.get(arrayList3.get(i));
            if (view != null) {
                Object put = arrayMap6.put(arrayList4.get(i), view);
            }
        }
        return arrayMap6;
    }

    private ArrayMap<String, View> remapSharedElements(TransitionState transitionState, Fragment fragment, boolean z) {
        ArrayMap arrayMap;
        TransitionState transitionState2 = transitionState;
        Fragment fragment2 = fragment;
        boolean z2 = z;
        ArrayMap arrayMap2 = arrayMap;
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = arrayMap2;
        if (this.mSharedElementSourceNames != null) {
            FragmentTransitionCompat21.findNamedViews(arrayMap4, fragment2.getView());
            if (z2) {
                boolean retainAll = arrayMap4.retainAll(this.mSharedElementTargetNames);
            } else {
                arrayMap4 = remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, arrayMap4);
            }
        }
        if (z2) {
            if (fragment2.mEnterTransitionCallback != null) {
                fragment2.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, arrayMap4);
            }
            setBackNameOverrides(transitionState2, arrayMap4, false);
            return arrayMap4;
        }
        if (fragment2.mExitTransitionCallback != null) {
            fragment2.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, arrayMap4);
        }
        setNameOverrides(transitionState2, arrayMap4, false);
        return arrayMap4;
    }

    private void setBackNameOverrides(TransitionState transitionState, ArrayMap<String, View> arrayMap, boolean z) {
        TransitionState transitionState2 = transitionState;
        ArrayMap<String, View> arrayMap2 = arrayMap;
        boolean z2 = z;
        int size = this.mSharedElementTargetNames == null ? 0 : this.mSharedElementTargetNames.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.mSharedElementSourceNames.get(i);
            View view = (View) arrayMap2.get((String) this.mSharedElementTargetNames.get(i));
            if (view != null) {
                String transitionName = FragmentTransitionCompat21.getTransitionName(view);
                if (z2) {
                    setNameOverride(transitionState2.nameOverrides, str, transitionName);
                } else {
                    setNameOverride(transitionState2.nameOverrides, transitionName, str);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void setEpicenterIn(ArrayMap<String, View> arrayMap, TransitionState transitionState) {
        ArrayMap<String, View> arrayMap2 = arrayMap;
        TransitionState transitionState2 = transitionState;
        if (this.mSharedElementTargetNames != null && !arrayMap2.isEmpty()) {
            View view = (View) arrayMap2.get(this.mSharedElementTargetNames.get(0));
            if (view != null) {
                transitionState2.enteringEpicenterView.epicenter = view;
            }
        }
    }

    private static void setFirstOut(SparseArray<Fragment> sparseArray, Fragment fragment) {
        SparseArray<Fragment> sparseArray2 = sparseArray;
        Fragment fragment2 = fragment;
        if (fragment2 != null) {
            int i = fragment2.mContainerId;
            if (i != 0 && !fragment2.isHidden() && fragment2.isAdded() && fragment2.getView() != null && sparseArray2.get(i) == null) {
                sparseArray2.put(i, fragment2);
            }
        }
    }

    private void setLastIn(SparseArray<Fragment> sparseArray, Fragment fragment) {
        SparseArray<Fragment> sparseArray2 = sparseArray;
        Fragment fragment2 = fragment;
        if (fragment2 != null) {
            int i = fragment2.mContainerId;
            if (i != 0) {
                sparseArray2.put(i, fragment2);
            }
        }
    }

    private static void setNameOverride(ArrayMap<String, String> arrayMap, String str, String str2) {
        ArrayMap<String, String> arrayMap2 = arrayMap;
        String str3 = str;
        String str4 = str2;
        if (str3 != null && str4 != null) {
            for (int i = 0; i < arrayMap2.size(); i++) {
                if (str3.equals(arrayMap2.valueAt(i))) {
                    Object valueAt = arrayMap2.setValueAt(i, str4);
                    return;
                }
            }
            Object put = arrayMap2.put(str3, str4);
        }
    }

    private void setNameOverrides(TransitionState transitionState, ArrayMap<String, View> arrayMap, boolean z) {
        TransitionState transitionState2 = transitionState;
        ArrayMap<String, View> arrayMap2 = arrayMap;
        boolean z2 = z;
        int size = arrayMap2.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayMap2.keyAt(i);
            String transitionName = FragmentTransitionCompat21.getTransitionName((View) arrayMap2.valueAt(i));
            if (z2) {
                setNameOverride(transitionState2.nameOverrides, str, transitionName);
            } else {
                setNameOverride(transitionState2.nameOverrides, transitionName, str);
            }
        }
    }

    private static void setNameOverrides(TransitionState transitionState, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        TransitionState transitionState2 = transitionState;
        ArrayList<String> arrayList3 = arrayList;
        ArrayList<String> arrayList4 = arrayList2;
        if (arrayList3 != null) {
            for (int i = 0; i < arrayList3.size(); i++) {
                setNameOverride(transitionState2.nameOverrides, (String) arrayList3.get(i), (String) arrayList4.get(i));
            }
        }
    }

    public FragmentTransaction add(int i, Fragment fragment) {
        doAddOp(i, fragment, null, 1);
        return this;
    }

    public FragmentTransaction add(int i, Fragment fragment, String str) {
        doAddOp(i, fragment, str, 1);
        return this;
    }

    public FragmentTransaction add(Fragment fragment, String str) {
        doAddOp(0, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public void addOp(C0008Op op) {
        C0008Op op2 = op;
        if (this.mHead == null) {
            this.mTail = op2;
            this.mHead = op2;
        } else {
            op2.prev = this.mTail;
            this.mTail.next = op2;
            this.mTail = op2;
        }
        op2.enterAnim = this.mEnterAnim;
        op2.exitAnim = this.mExitAnim;
        op2.popEnterAnim = this.mPopEnterAnim;
        op2.popExitAnim = this.mPopExitAnim;
        this.mNumOp = 1 + this.mNumOp;
    }

    public FragmentTransaction addSharedElement(View view, String str) {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        IllegalArgumentException illegalArgumentException;
        View view2 = view;
        String str2 = str;
        if (SUPPORTS_TRANSITIONS) {
            String transitionName = FragmentTransitionCompat21.getTransitionName(view2);
            if (transitionName == null) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
                throw illegalArgumentException2;
            }
            if (this.mSharedElementSourceNames == null) {
                ArrayList<String> arrayList3 = arrayList;
                ArrayList<String> arrayList4 = new ArrayList<>();
                this.mSharedElementSourceNames = arrayList3;
                ArrayList<String> arrayList5 = arrayList2;
                ArrayList<String> arrayList6 = new ArrayList<>();
                this.mSharedElementTargetNames = arrayList5;
            }
            boolean add = this.mSharedElementSourceNames.add(transitionName);
            boolean add2 = this.mSharedElementTargetNames.add(str2);
        }
        return this;
    }

    public FragmentTransaction addToBackStack(String str) {
        IllegalStateException illegalStateException;
        String str2 = str;
        if (!this.mAllowAddToBackStack) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
            throw illegalStateException2;
        }
        this.mAddToBackStack = true;
        this.mName = str2;
        return this;
    }

    public FragmentTransaction attach(Fragment fragment) {
        C0008Op op;
        Fragment fragment2 = fragment;
        C0008Op op2 = op;
        C0008Op op3 = new C0008Op();
        C0008Op op4 = op2;
        op4.cmd = 7;
        op4.fragment = fragment2;
        addOp(op4);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public void bumpBackStackNesting(int i) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        int i2 = i;
        if (this.mAddToBackStack) {
            if (FragmentManagerImpl.DEBUG) {
                String str = TAG;
                StringBuilder sb4 = sb3;
                StringBuilder sb5 = new StringBuilder();
                int v = Log.v(str, sb4.append("Bump nesting in ").append(this).append(" by ").append(i2).toString());
            }
            C0008Op op = this.mHead;
            while (true) {
                C0008Op op2 = op;
                if (op2 != null) {
                    if (op2.fragment != null) {
                        Fragment fragment = op2.fragment;
                        fragment.mBackStackNesting = i2 + fragment.mBackStackNesting;
                        if (FragmentManagerImpl.DEBUG) {
                            String str2 = TAG;
                            StringBuilder sb6 = sb2;
                            StringBuilder sb7 = new StringBuilder();
                            int v2 = Log.v(str2, sb6.append("Bump nesting of ").append(op2.fragment).append(" to ").append(op2.fragment.mBackStackNesting).toString());
                        }
                    }
                    if (op2.removed != null) {
                        for (int size = -1 + op2.removed.size(); size >= 0; size--) {
                            Fragment fragment2 = (Fragment) op2.removed.get(size);
                            fragment2.mBackStackNesting = i2 + fragment2.mBackStackNesting;
                            if (FragmentManagerImpl.DEBUG) {
                                String str3 = TAG;
                                StringBuilder sb8 = sb;
                                StringBuilder sb9 = new StringBuilder();
                                int v3 = Log.v(str3, sb8.append("Bump nesting of ").append(fragment2).append(" to ").append(fragment2.mBackStackNesting).toString());
                            }
                        }
                    }
                    op = op2.next;
                } else {
                    return;
                }
            }
        }
    }

    public void calculateBackFragments(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        SparseArray<Fragment> sparseArray3 = sparseArray;
        SparseArray<Fragment> sparseArray4 = sparseArray2;
        if (this.mManager.mContainer.onHasView()) {
            C0008Op op = this.mHead;
            while (true) {
                C0008Op op2 = op;
                if (op2 != null) {
                    switch (op2.cmd) {
                        case 1:
                            setFirstOut(sparseArray3, op2.fragment);
                            break;
                        case 2:
                            if (op2.removed != null) {
                                for (int size = -1 + op2.removed.size(); size >= 0; size--) {
                                    setLastIn(sparseArray4, (Fragment) op2.removed.get(size));
                                }
                            }
                            setFirstOut(sparseArray3, op2.fragment);
                            break;
                        case 3:
                            setLastIn(sparseArray4, op2.fragment);
                            break;
                        case 4:
                            setLastIn(sparseArray4, op2.fragment);
                            break;
                        case 5:
                            setFirstOut(sparseArray3, op2.fragment);
                            break;
                        case 6:
                            setLastIn(sparseArray4, op2.fragment);
                            break;
                        case 7:
                            setFirstOut(sparseArray3, op2.fragment);
                            break;
                    }
                    op = op2.next;
                } else {
                    return;
                }
            }
        }
    }

    public int commit() {
        return commitInternal(false);
    }

    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    /* access modifiers changed from: 0000 */
    public int commitInternal(boolean z) {
        StringBuilder sb;
        PrintWriter printWriter;
        LogWriter logWriter;
        IllegalStateException illegalStateException;
        boolean z2 = z;
        if (this.mCommitted) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("commit already called");
            throw illegalStateException2;
        }
        if (FragmentManagerImpl.DEBUG) {
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int v = Log.v(str, sb2.append("Commit: ").append(this).toString());
            PrintWriter printWriter2 = printWriter;
            LogWriter logWriter2 = logWriter;
            LogWriter logWriter3 = new LogWriter(TAG);
            PrintWriter printWriter3 = new PrintWriter(logWriter2);
            dump("  ", null, printWriter2, null);
        }
        this.mCommitted = true;
        if (this.mAddToBackStack) {
            this.mIndex = this.mManager.allocBackStackIndex(this);
        } else {
            this.mIndex = -1;
        }
        this.mManager.enqueueAction(this, z2);
        return this.mIndex;
    }

    public FragmentTransaction detach(Fragment fragment) {
        C0008Op op;
        Fragment fragment2 = fragment;
        C0008Op op2 = op;
        C0008Op op3 = new C0008Op();
        C0008Op op4 = op2;
        op4.cmd = 6;
        op4.fragment = fragment2;
        addOp(op4);
        return this;
    }

    public FragmentTransaction disallowAddToBackStack() {
        IllegalStateException illegalStateException;
        if (this.mAddToBackStack) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("This transaction is already being added to the back stack");
            throw illegalStateException2;
        }
        this.mAllowAddToBackStack = false;
        return this;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        FileDescriptor fileDescriptor2 = fileDescriptor;
        String[] strArr2 = strArr;
        dump(str, printWriter, true);
    }

    public void dump(String str, PrintWriter printWriter, boolean z) {
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        String str3 = str;
        PrintWriter printWriter2 = printWriter;
        boolean z2 = z;
        if (z2) {
            printWriter2.print(str3);
            printWriter2.print("mName=");
            printWriter2.print(this.mName);
            printWriter2.print(" mIndex=");
            printWriter2.print(this.mIndex);
            printWriter2.print(" mCommitted=");
            printWriter2.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter2.print(str3);
                printWriter2.print("mTransition=#");
                printWriter2.print(Integer.toHexString(this.mTransition));
                printWriter2.print(" mTransitionStyle=#");
                printWriter2.println(Integer.toHexString(this.mTransitionStyle));
            }
            if (!(this.mEnterAnim == 0 && this.mExitAnim == 0)) {
                printWriter2.print(str3);
                printWriter2.print("mEnterAnim=#");
                printWriter2.print(Integer.toHexString(this.mEnterAnim));
                printWriter2.print(" mExitAnim=#");
                printWriter2.println(Integer.toHexString(this.mExitAnim));
            }
            if (!(this.mPopEnterAnim == 0 && this.mPopExitAnim == 0)) {
                printWriter2.print(str3);
                printWriter2.print("mPopEnterAnim=#");
                printWriter2.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter2.print(" mPopExitAnim=#");
                printWriter2.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (!(this.mBreadCrumbTitleRes == 0 && this.mBreadCrumbTitleText == null)) {
                printWriter2.print(str3);
                printWriter2.print("mBreadCrumbTitleRes=#");
                printWriter2.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter2.print(" mBreadCrumbTitleText=");
                printWriter2.println(this.mBreadCrumbTitleText);
            }
            if (!(this.mBreadCrumbShortTitleRes == 0 && this.mBreadCrumbShortTitleText == null)) {
                printWriter2.print(str3);
                printWriter2.print("mBreadCrumbShortTitleRes=#");
                printWriter2.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter2.print(" mBreadCrumbShortTitleText=");
                printWriter2.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (this.mHead != null) {
            printWriter2.print(str3);
            printWriter2.println("Operations:");
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            String sb5 = sb3.append(str3).append("    ").toString();
            C0008Op op = this.mHead;
            int i = 0;
            while (op != null) {
                switch (op.cmd) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    default:
                        StringBuilder sb6 = sb2;
                        StringBuilder sb7 = new StringBuilder();
                        str2 = sb6.append("cmd=").append(op.cmd).toString();
                        break;
                }
                printWriter2.print(str3);
                printWriter2.print("  Op #");
                printWriter2.print(i);
                printWriter2.print(": ");
                printWriter2.print(str2);
                printWriter2.print(" ");
                printWriter2.println(op.fragment);
                if (z2) {
                    if (!(op.enterAnim == 0 && op.exitAnim == 0)) {
                        printWriter2.print(str3);
                        printWriter2.print("enterAnim=#");
                        printWriter2.print(Integer.toHexString(op.enterAnim));
                        printWriter2.print(" exitAnim=#");
                        printWriter2.println(Integer.toHexString(op.exitAnim));
                    }
                    if (!(op.popEnterAnim == 0 && op.popExitAnim == 0)) {
                        printWriter2.print(str3);
                        printWriter2.print("popEnterAnim=#");
                        printWriter2.print(Integer.toHexString(op.popEnterAnim));
                        printWriter2.print(" popExitAnim=#");
                        printWriter2.println(Integer.toHexString(op.popExitAnim));
                    }
                }
                if (op.removed != null && op.removed.size() > 0) {
                    for (int i2 = 0; i2 < op.removed.size(); i2++) {
                        printWriter2.print(sb5);
                        if (op.removed.size() == 1) {
                            printWriter2.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter2.println("Removed:");
                            }
                            printWriter2.print(sb5);
                            printWriter2.print("  #");
                            printWriter2.print(i2);
                            printWriter2.print(": ");
                        }
                        printWriter2.println(op.removed.get(i2));
                    }
                }
                op = op.next;
                i++;
            }
        }
    }

    public CharSequence getBreadCrumbShortTitle() {
        return this.mBreadCrumbShortTitleRes != 0 ? this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes) : this.mBreadCrumbShortTitleText;
    }

    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    public CharSequence getBreadCrumbTitle() {
        return this.mBreadCrumbTitleRes != 0 ? this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes) : this.mBreadCrumbTitleText;
    }

    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    public int getId() {
        return this.mIndex;
    }

    public String getName() {
        return this.mName;
    }

    public int getTransition() {
        return this.mTransition;
    }

    public int getTransitionStyle() {
        return this.mTransitionStyle;
    }

    public FragmentTransaction hide(Fragment fragment) {
        C0008Op op;
        Fragment fragment2 = fragment;
        C0008Op op2 = op;
        C0008Op op3 = new C0008Op();
        C0008Op op4 = op2;
        op4.cmd = 4;
        op4.fragment = fragment2;
        addOp(op4);
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        return this.mNumOp == 0;
    }

    public TransitionState popFromBackStack(boolean z, TransitionState transitionState, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        StringBuilder sb2;
        PrintWriter printWriter;
        LogWriter logWriter;
        boolean z2 = z;
        TransitionState transitionState2 = transitionState;
        SparseArray<Fragment> sparseArray3 = sparseArray;
        SparseArray<Fragment> sparseArray4 = sparseArray2;
        if (FragmentManagerImpl.DEBUG) {
            String str = TAG;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            int v = Log.v(str, sb3.append("popFromBackStack: ").append(this).toString());
            PrintWriter printWriter2 = printWriter;
            LogWriter logWriter2 = logWriter;
            LogWriter logWriter3 = new LogWriter(TAG);
            PrintWriter printWriter3 = new PrintWriter(logWriter2);
            dump("  ", null, printWriter2, null);
        }
        if (SUPPORTS_TRANSITIONS) {
            if (transitionState2 == null) {
                if (!(sparseArray3.size() == 0 && sparseArray4.size() == 0)) {
                    transitionState2 = beginTransition(sparseArray3, sparseArray4, true);
                }
            } else if (!z2) {
                setNameOverrides(transitionState2, this.mSharedElementTargetNames, this.mSharedElementSourceNames);
            }
        }
        bumpBackStackNesting(-1);
        int i = transitionState2 != null ? 0 : this.mTransitionStyle;
        int i2 = transitionState2 != null ? 0 : this.mTransition;
        C0008Op op = this.mTail;
        while (true) {
            C0008Op op2 = op;
            if (op2 != null) {
                int i3 = transitionState2 != null ? 0 : op2.popEnterAnim;
                int i4 = transitionState2 != null ? 0 : op2.popExitAnim;
                switch (op2.cmd) {
                    case 1:
                        Fragment fragment = op2.fragment;
                        fragment.mNextAnim = i4;
                        this.mManager.removeFragment(fragment, FragmentManagerImpl.reverseTransit(i2), i);
                        break;
                    case 2:
                        Fragment fragment2 = op2.fragment;
                        if (fragment2 != null) {
                            fragment2.mNextAnim = i4;
                            this.mManager.removeFragment(fragment2, FragmentManagerImpl.reverseTransit(i2), i);
                        }
                        if (op2.removed == null) {
                            break;
                        } else {
                            for (int i5 = 0; i5 < op2.removed.size(); i5++) {
                                Fragment fragment3 = (Fragment) op2.removed.get(i5);
                                fragment3.mNextAnim = i3;
                                this.mManager.addFragment(fragment3, false);
                            }
                            break;
                        }
                    case 3:
                        Fragment fragment4 = op2.fragment;
                        fragment4.mNextAnim = i3;
                        this.mManager.addFragment(fragment4, false);
                        break;
                    case 4:
                        Fragment fragment5 = op2.fragment;
                        fragment5.mNextAnim = i3;
                        this.mManager.showFragment(fragment5, FragmentManagerImpl.reverseTransit(i2), i);
                        break;
                    case 5:
                        Fragment fragment6 = op2.fragment;
                        fragment6.mNextAnim = i4;
                        this.mManager.hideFragment(fragment6, FragmentManagerImpl.reverseTransit(i2), i);
                        break;
                    case 6:
                        Fragment fragment7 = op2.fragment;
                        fragment7.mNextAnim = i3;
                        this.mManager.attachFragment(fragment7, FragmentManagerImpl.reverseTransit(i2), i);
                        break;
                    case 7:
                        Fragment fragment8 = op2.fragment;
                        fragment8.mNextAnim = i3;
                        this.mManager.detachFragment(fragment8, FragmentManagerImpl.reverseTransit(i2), i);
                        break;
                    default:
                        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                        StringBuilder sb5 = sb;
                        StringBuilder sb6 = new StringBuilder();
                        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb5.append("Unknown cmd: ").append(op2.cmd).toString());
                        throw illegalArgumentException2;
                }
                op = op2.prev;
            } else {
                if (z2) {
                    this.mManager.moveToState(this.mManager.mCurState, FragmentManagerImpl.reverseTransit(i2), i, true);
                    transitionState2 = null;
                }
                if (this.mIndex >= 0) {
                    this.mManager.freeBackStackIndex(this.mIndex);
                    this.mIndex = -1;
                }
                return transitionState2;
            }
        }
    }

    public FragmentTransaction remove(Fragment fragment) {
        C0008Op op;
        Fragment fragment2 = fragment;
        C0008Op op2 = op;
        C0008Op op3 = new C0008Op();
        C0008Op op4 = op2;
        op4.cmd = 3;
        op4.fragment = fragment2;
        addOp(op4);
        return this;
    }

    public FragmentTransaction replace(int i, Fragment fragment) {
        return replace(i, fragment, null);
    }

    public FragmentTransaction replace(int i, Fragment fragment, String str) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        Fragment fragment2 = fragment;
        String str2 = str;
        if (i2 == 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Must use non-zero containerViewId");
            throw illegalArgumentException2;
        }
        doAddOp(i2, fragment2, str2, 2);
        return this;
    }

    public void run() {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        StringBuilder sb2;
        ArrayList arrayList;
        StringBuilder sb3;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        IllegalStateException illegalStateException;
        StringBuilder sb4;
        if (FragmentManagerImpl.DEBUG) {
            String str = TAG;
            StringBuilder sb5 = sb4;
            StringBuilder sb6 = new StringBuilder();
            int v = Log.v(str, sb5.append("Run: ").append(this).toString());
        }
        if (this.mAddToBackStack) {
            if (this.mIndex < 0) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("addToBackStack() called after commit()");
                throw illegalStateException2;
            }
        }
        bumpBackStackNesting(1);
        TransitionState transitionState = null;
        if (SUPPORTS_TRANSITIONS) {
            SparseArray sparseArray3 = sparseArray;
            SparseArray sparseArray4 = new SparseArray();
            SparseArray sparseArray5 = sparseArray3;
            SparseArray sparseArray6 = sparseArray2;
            SparseArray sparseArray7 = new SparseArray();
            SparseArray sparseArray8 = sparseArray6;
            calculateFragments(sparseArray5, sparseArray8);
            transitionState = beginTransition(sparseArray5, sparseArray8, false);
        }
        int i = transitionState != null ? 0 : this.mTransitionStyle;
        int i2 = transitionState != null ? 0 : this.mTransition;
        C0008Op op = this.mHead;
        while (true) {
            C0008Op op2 = op;
            if (op2 != null) {
                int i3 = transitionState != null ? 0 : op2.enterAnim;
                int i4 = transitionState != null ? 0 : op2.exitAnim;
                switch (op2.cmd) {
                    case 1:
                        Fragment fragment = op2.fragment;
                        fragment.mNextAnim = i3;
                        this.mManager.addFragment(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = op2.fragment;
                        int i5 = fragment2.mContainerId;
                        if (this.mManager.mAdded != null) {
                            int i6 = 0;
                            while (true) {
                                if (i6 < this.mManager.mAdded.size()) {
                                    Fragment fragment3 = (Fragment) this.mManager.mAdded.get(i6);
                                    if (FragmentManagerImpl.DEBUG) {
                                        String str2 = TAG;
                                        StringBuilder sb7 = sb3;
                                        StringBuilder sb8 = new StringBuilder();
                                        int v2 = Log.v(str2, sb7.append("OP_REPLACE: adding=").append(fragment2).append(" old=").append(fragment3).toString());
                                    }
                                    if (fragment3.mContainerId == i5) {
                                        if (fragment3 == fragment2) {
                                            fragment2 = null;
                                            op2.fragment = null;
                                        } else {
                                            if (op2.removed == null) {
                                                C0008Op op3 = op2;
                                                ArrayList arrayList2 = arrayList;
                                                ArrayList arrayList3 = new ArrayList();
                                                op3.removed = arrayList2;
                                            }
                                            boolean add = op2.removed.add(fragment3);
                                            fragment3.mNextAnim = i4;
                                            if (this.mAddToBackStack) {
                                                fragment3.mBackStackNesting = 1 + fragment3.mBackStackNesting;
                                                if (FragmentManagerImpl.DEBUG) {
                                                    String str3 = TAG;
                                                    StringBuilder sb9 = sb2;
                                                    StringBuilder sb10 = new StringBuilder();
                                                    int v3 = Log.v(str3, sb9.append("Bump nesting of ").append(fragment3).append(" to ").append(fragment3.mBackStackNesting).toString());
                                                }
                                            }
                                            this.mManager.removeFragment(fragment3, i2, i);
                                        }
                                    }
                                    i6++;
                                }
                            }
                        }
                        if (fragment2 == null) {
                            break;
                        } else {
                            fragment2.mNextAnim = i3;
                            this.mManager.addFragment(fragment2, false);
                            break;
                        }
                    case 3:
                        Fragment fragment4 = op2.fragment;
                        fragment4.mNextAnim = i4;
                        this.mManager.removeFragment(fragment4, i2, i);
                        break;
                    case 4:
                        Fragment fragment5 = op2.fragment;
                        fragment5.mNextAnim = i4;
                        this.mManager.hideFragment(fragment5, i2, i);
                        break;
                    case 5:
                        Fragment fragment6 = op2.fragment;
                        fragment6.mNextAnim = i3;
                        this.mManager.showFragment(fragment6, i2, i);
                        break;
                    case 6:
                        Fragment fragment7 = op2.fragment;
                        fragment7.mNextAnim = i4;
                        this.mManager.detachFragment(fragment7, i2, i);
                        break;
                    case 7:
                        Fragment fragment8 = op2.fragment;
                        fragment8.mNextAnim = i3;
                        this.mManager.attachFragment(fragment8, i2, i);
                        break;
                    default:
                        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                        StringBuilder sb11 = sb;
                        StringBuilder sb12 = new StringBuilder();
                        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb11.append("Unknown cmd: ").append(op2.cmd).toString());
                        throw illegalArgumentException2;
                }
                op = op2.next;
            } else {
                this.mManager.moveToState(this.mManager.mCurState, i2, i, true);
                if (this.mAddToBackStack) {
                    this.mManager.addBackStackState(this);
                    return;
                }
                return;
            }
        }
    }

    public FragmentTransaction setBreadCrumbShortTitle(int i) {
        this.mBreadCrumbShortTitleRes = i;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = charSequence2;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(int i) {
        this.mBreadCrumbTitleRes = i;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = charSequence2;
        return this;
    }

    public FragmentTransaction setCustomAnimations(int i, int i2) {
        return setCustomAnimations(i, i2, 0, 0);
    }

    public FragmentTransaction setCustomAnimations(int i, int i2, int i3, int i4) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        this.mEnterAnim = i;
        this.mExitAnim = i5;
        this.mPopEnterAnim = i6;
        this.mPopExitAnim = i7;
        return this;
    }

    public FragmentTransaction setTransition(int i) {
        this.mTransition = i;
        return this;
    }

    public FragmentTransaction setTransitionStyle(int i) {
        this.mTransitionStyle = i;
        return this;
    }

    public FragmentTransaction show(Fragment fragment) {
        C0008Op op;
        Fragment fragment2 = fragment;
        C0008Op op2 = op;
        C0008Op op3 = new C0008Op();
        C0008Op op4 = op2;
        op4.cmd = 5;
        op4.fragment = fragment2;
        addOp(op4);
        return this;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(128);
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("BackStackEntry{");
        StringBuilder append2 = sb4.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            StringBuilder append3 = sb4.append(" #");
            StringBuilder append4 = sb4.append(this.mIndex);
        }
        if (this.mName != null) {
            StringBuilder append5 = sb4.append(" ");
            StringBuilder append6 = sb4.append(this.mName);
        }
        StringBuilder append7 = sb4.append("}");
        return sb4.toString();
    }
}
