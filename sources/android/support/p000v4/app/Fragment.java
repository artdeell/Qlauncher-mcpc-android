package android.support.p000v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.p000v4.util.DebugUtils;
import android.support.p000v4.util.SimpleArrayMap;
import android.support.p000v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.Fragment */
public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 5;
    static final int STARTED = 4;
    static final int STOPPED = 3;
    static final Object USE_DEFAULT_TRANSITION;
    private static final SimpleArrayMap<String, Class<?>> sClassMap;
    boolean mAdded;
    Boolean mAllowEnterTransitionOverlap;
    Boolean mAllowReturnTransitionOverlap;
    View mAnimatingAway;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    boolean mCheckedForLoaderManager;
    FragmentManagerImpl mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    Object mEnterTransition = null;
    SharedElementCallback mEnterTransitionCallback = null;
    Object mExitTransition = null;
    SharedElementCallback mExitTransitionCallback = null;
    int mFragmentId;
    FragmentManagerImpl mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    FragmentHostCallback mHost;
    boolean mInLayout;
    int mIndex = -1;
    View mInnerView;
    LoaderManagerImpl mLoaderManager;
    boolean mLoadersStarted;
    boolean mMenuVisible = true;
    int mNextAnim;
    Fragment mParentFragment;
    Object mReenterTransition = USE_DEFAULT_TRANSITION;
    boolean mRemoving;
    boolean mRestored;
    boolean mResumed;
    boolean mRetainInstance;
    boolean mRetaining;
    Object mReturnTransition = USE_DEFAULT_TRANSITION;
    Bundle mSavedFragmentState;
    SparseArray<Parcelable> mSavedViewState;
    Object mSharedElementEnterTransition = null;
    Object mSharedElementReturnTransition = USE_DEFAULT_TRANSITION;
    int mState = 0;
    int mStateAfterAnimating;
    String mTag;
    Fragment mTarget;
    int mTargetIndex = -1;
    int mTargetRequestCode;
    boolean mUserVisibleHint = true;
    View mView;
    String mWho;

    /* renamed from: android.support.v4.app.Fragment$InstantiationException */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* renamed from: android.support.v4.app.Fragment$SavedState */
    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR;
        final Bundle mState;

        static {
            C00111 r2;
            C00111 r0 = r2;
            C00111 r1 = new Creator<SavedState>() {
                public SavedState createFromParcel(Parcel parcel) {
                    SavedState savedState;
                    SavedState savedState2 = savedState;
                    SavedState savedState3 = new SavedState(parcel, null);
                    return savedState2;
                }

                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            CREATOR = r0;
        }

        SavedState(Bundle bundle) {
            this.mState = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            ClassLoader classLoader2 = classLoader;
            this.mState = parcel.readBundle();
            if (classLoader2 != null && this.mState != null) {
                this.mState.setClassLoader(classLoader2);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = i;
            parcel.writeBundle(this.mState);
        }
    }

    static {
        SimpleArrayMap<String, Class<?>> simpleArrayMap;
        Object obj;
        SimpleArrayMap<String, Class<?>> simpleArrayMap2 = simpleArrayMap;
        SimpleArrayMap<String, Class<?>> simpleArrayMap3 = new SimpleArrayMap<>();
        sClassMap = simpleArrayMap2;
        Object obj2 = obj;
        Object obj3 = new Object();
        USE_DEFAULT_TRANSITION = obj2;
    }

    public Fragment() {
    }

    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public static Fragment instantiate(Context context, String str, @Nullable Bundle bundle) {
        InstantiationException instantiationException;
        StringBuilder sb;
        InstantiationException instantiationException2;
        StringBuilder sb2;
        InstantiationException instantiationException3;
        StringBuilder sb3;
        Context context2 = context;
        String str2 = str;
        Bundle bundle2 = bundle;
        try {
            Class cls = (Class) sClassMap.get(str2);
            if (cls == null) {
                cls = context2.getClassLoader().loadClass(str2);
                Object put = sClassMap.put(str2, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle2 != null) {
                bundle2.setClassLoader(fragment.getClass().getClassLoader());
                fragment.mArguments = bundle2;
            }
            return fragment;
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            InstantiationException instantiationException4 = instantiationException3;
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            InstantiationException instantiationException5 = new InstantiationException(sb4.append("Unable to instantiate fragment ").append(str2).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), classNotFoundException);
            throw instantiationException4;
        } catch (InstantiationException e2) {
            InstantiationException instantiationException6 = e2;
            InstantiationException instantiationException7 = instantiationException2;
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            InstantiationException instantiationException8 = new InstantiationException(sb6.append("Unable to instantiate fragment ").append(str2).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), instantiationException6);
            throw instantiationException7;
        } catch (IllegalAccessException e3) {
            IllegalAccessException illegalAccessException = e3;
            InstantiationException instantiationException9 = instantiationException;
            StringBuilder sb8 = sb;
            StringBuilder sb9 = new StringBuilder();
            InstantiationException instantiationException10 = new InstantiationException(sb8.append("Unable to instantiate fragment ").append(str2).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), illegalAccessException);
            throw instantiationException9;
        }
    }

    static boolean isSupportFragmentClass(Context context, String str) {
        Context context2 = context;
        String str2 = str;
        try {
            Class cls = (Class) sClassMap.get(str2);
            if (cls == null) {
                cls = context2.getClassLoader().loadClass(str2);
                Object put = sClassMap.put(str2, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            return false;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        String str2 = str;
        FileDescriptor fileDescriptor2 = fileDescriptor;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        printWriter2.print(str2);
        printWriter2.print("mFragmentId=#");
        printWriter2.print(Integer.toHexString(this.mFragmentId));
        printWriter2.print(" mContainerId=#");
        printWriter2.print(Integer.toHexString(this.mContainerId));
        printWriter2.print(" mTag=");
        printWriter2.println(this.mTag);
        printWriter2.print(str2);
        printWriter2.print("mState=");
        printWriter2.print(this.mState);
        printWriter2.print(" mIndex=");
        printWriter2.print(this.mIndex);
        printWriter2.print(" mWho=");
        printWriter2.print(this.mWho);
        printWriter2.print(" mBackStackNesting=");
        printWriter2.println(this.mBackStackNesting);
        printWriter2.print(str2);
        printWriter2.print("mAdded=");
        printWriter2.print(this.mAdded);
        printWriter2.print(" mRemoving=");
        printWriter2.print(this.mRemoving);
        printWriter2.print(" mResumed=");
        printWriter2.print(this.mResumed);
        printWriter2.print(" mFromLayout=");
        printWriter2.print(this.mFromLayout);
        printWriter2.print(" mInLayout=");
        printWriter2.println(this.mInLayout);
        printWriter2.print(str2);
        printWriter2.print("mHidden=");
        printWriter2.print(this.mHidden);
        printWriter2.print(" mDetached=");
        printWriter2.print(this.mDetached);
        printWriter2.print(" mMenuVisible=");
        printWriter2.print(this.mMenuVisible);
        printWriter2.print(" mHasMenu=");
        printWriter2.println(this.mHasMenu);
        printWriter2.print(str2);
        printWriter2.print("mRetainInstance=");
        printWriter2.print(this.mRetainInstance);
        printWriter2.print(" mRetaining=");
        printWriter2.print(this.mRetaining);
        printWriter2.print(" mUserVisibleHint=");
        printWriter2.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter2.print(str2);
            printWriter2.print("mFragmentManager=");
            printWriter2.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter2.print(str2);
            printWriter2.print("mHost=");
            printWriter2.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter2.print(str2);
            printWriter2.print("mParentFragment=");
            printWriter2.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter2.print(str2);
            printWriter2.print("mArguments=");
            printWriter2.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter2.print(str2);
            printWriter2.print("mSavedFragmentState=");
            printWriter2.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter2.print(str2);
            printWriter2.print("mSavedViewState=");
            printWriter2.println(this.mSavedViewState);
        }
        if (this.mTarget != null) {
            printWriter2.print(str2);
            printWriter2.print("mTarget=");
            printWriter2.print(this.mTarget);
            printWriter2.print(" mTargetRequestCode=");
            printWriter2.println(this.mTargetRequestCode);
        }
        if (this.mNextAnim != 0) {
            printWriter2.print(str2);
            printWriter2.print("mNextAnim=");
            printWriter2.println(this.mNextAnim);
        }
        if (this.mContainer != null) {
            printWriter2.print(str2);
            printWriter2.print("mContainer=");
            printWriter2.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter2.print(str2);
            printWriter2.print("mView=");
            printWriter2.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter2.print(str2);
            printWriter2.print("mInnerView=");
            printWriter2.println(this.mView);
        }
        if (this.mAnimatingAway != null) {
            printWriter2.print(str2);
            printWriter2.print("mAnimatingAway=");
            printWriter2.println(this.mAnimatingAway);
            printWriter2.print(str2);
            printWriter2.print("mStateAfterAnimating=");
            printWriter2.println(this.mStateAfterAnimating);
        }
        if (this.mLoaderManager != null) {
            printWriter2.print(str2);
            printWriter2.println("Loader Manager:");
            LoaderManagerImpl loaderManagerImpl = this.mLoaderManager;
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            loaderManagerImpl.dump(sb4.append(str2).append("  ").toString(), fileDescriptor2, printWriter2, strArr2);
        }
        if (this.mChildFragmentManager != null) {
            printWriter2.print(str2);
            PrintWriter printWriter3 = printWriter2;
            StringBuilder sb6 = sb;
            StringBuilder sb7 = new StringBuilder();
            printWriter3.println(sb6.append("Child ").append(this.mChildFragmentManager).append(":").toString());
            FragmentManagerImpl fragmentManagerImpl = this.mChildFragmentManager;
            StringBuilder sb8 = sb2;
            StringBuilder sb9 = new StringBuilder();
            fragmentManagerImpl.dump(sb8.append(str2).append("  ").toString(), fileDescriptor2, printWriter2, strArr2);
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: 0000 */
    public Fragment findFragmentByWho(String str) {
        String str2 = str;
        if (str2.equals(this.mWho)) {
            return this;
        } else if (this.mChildFragmentManager != null) {
            return this.mChildFragmentManager.findFragmentByWho(str2);
        } else {
            return null;
        }
    }

    public final FragmentActivity getActivity() {
        if (this.mHost == null) {
            return null;
        }
        return (FragmentActivity) this.mHost.getActivity();
    }

    public boolean getAllowEnterTransitionOverlap() {
        if (this.mAllowEnterTransitionOverlap == null) {
            return true;
        }
        return this.mAllowEnterTransitionOverlap.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        if (this.mAllowReturnTransitionOverlap == null) {
            return true;
        }
        return this.mAllowReturnTransitionOverlap.booleanValue();
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mChildFragmentManager == null) {
            instantiateChildFragmentManager();
            if (this.mState >= 5) {
                this.mChildFragmentManager.dispatchResume();
            } else if (this.mState >= 4) {
                this.mChildFragmentManager.dispatchStart();
            } else if (this.mState >= 2) {
                this.mChildFragmentManager.dispatchActivityCreated();
            } else if (this.mState >= 1) {
                this.mChildFragmentManager.dispatchCreate();
            }
        }
        return this.mChildFragmentManager;
    }

    public Context getContext() {
        if (this.mHost == null) {
            return null;
        }
        return this.mHost.getContext();
    }

    public Object getEnterTransition() {
        return this.mEnterTransition;
    }

    public Object getExitTransition() {
        return this.mExitTransition;
    }

    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        if (this.mHost == null) {
            return null;
        }
        return this.mHost.onGetHost();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public LayoutInflater getLayoutInflater(Bundle bundle) {
        Bundle bundle2 = bundle;
        LayoutInflater onGetLayoutInflater = this.mHost.onGetLayoutInflater();
        FragmentManager childFragmentManager = getChildFragmentManager();
        LayoutInflaterCompat.setFactory(onGetLayoutInflater, this.mChildFragmentManager.getLayoutInflaterFactory());
        return onGetLayoutInflater;
    }

    public LoaderManager getLoaderManager() {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        if (this.mHost == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Fragment ").append(this).append(" not attached to Activity").toString());
            throw illegalStateException2;
        }
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, true);
        return this.mLoaderManager;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public Object getReenterTransition() {
        return this.mReenterTransition == USE_DEFAULT_TRANSITION ? getExitTransition() : this.mReenterTransition;
    }

    public final Resources getResources() {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        if (this.mHost != null) {
            return this.mHost.getContext().getResources();
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Fragment ").append(this).append(" not attached to Activity").toString());
        throw illegalStateException2;
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        return this.mReturnTransition == USE_DEFAULT_TRANSITION ? getEnterTransition() : this.mReturnTransition;
    }

    public Object getSharedElementEnterTransition() {
        return this.mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition() {
        return this.mSharedElementReturnTransition == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : this.mSharedElementReturnTransition;
    }

    public final String getString(@StringRes int i) {
        return getResources().getString(i);
    }

    public final String getString(@StringRes int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final String getTag() {
        return this.mTag;
    }

    public final Fragment getTargetFragment() {
        return this.mTarget;
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(@StringRes int i) {
        return getResources().getText(i);
    }

    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @Nullable
    public View getView() {
        return this.mView;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: 0000 */
    public void initState() {
        this.mIndex = -1;
        this.mWho = null;
        this.mAdded = false;
        this.mRemoving = false;
        this.mResumed = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = null;
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
        this.mRetaining = false;
        this.mLoaderManager = null;
        this.mLoadersStarted = false;
        this.mCheckedForLoaderManager = false;
    }

    /* access modifiers changed from: 0000 */
    public void instantiateChildFragmentManager() {
        FragmentManagerImpl fragmentManagerImpl;
        C00101 r6;
        FragmentManagerImpl fragmentManagerImpl2 = fragmentManagerImpl;
        FragmentManagerImpl fragmentManagerImpl3 = new FragmentManagerImpl();
        this.mChildFragmentManager = fragmentManagerImpl2;
        FragmentManagerImpl fragmentManagerImpl4 = this.mChildFragmentManager;
        FragmentHostCallback fragmentHostCallback = this.mHost;
        C00101 r3 = r6;
        C00101 r4 = new FragmentContainer(this) {
            final /* synthetic */ Fragment this$0;

            {
                this.this$0 = r5;
            }

            @Nullable
            public View onFindViewById(int i) {
                IllegalStateException illegalStateException;
                int i2 = i;
                if (this.this$0.mView != null) {
                    return this.this$0.mView.findViewById(i2);
                }
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Fragment does not have a view");
                throw illegalStateException2;
            }

            public boolean onHasView() {
                return this.this$0.mView != null;
            }
        };
        fragmentManagerImpl4.attachController(fragmentHostCallback, r3, this);
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    /* access modifiers changed from: 0000 */
    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mResumed;
    }

    public final boolean isVisible() {
        return isAdded() && !isHidden() && this.mView != null && this.mView.getWindowToken() != null && this.mView.getVisibility() == 0;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        Bundle bundle2 = bundle;
        this.mCalled = true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Deprecated
    public void onAttach(Activity activity) {
        Activity activity2 = activity;
        this.mCalled = true;
    }

    public void onAttach(Context context) {
        Context context2 = context;
        this.mCalled = true;
        Activity activity = this.mHost == null ? null : this.mHost.getActivity();
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        Configuration configuration2 = configuration;
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        return false;
    }

    public void onCreate(@Nullable Bundle bundle) {
        Bundle bundle2 = bundle;
        this.mCalled = true;
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        int i3 = i;
        boolean z2 = z;
        int i4 = i2;
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        ContextMenu contextMenu2 = contextMenu;
        View view2 = view;
        ContextMenuInfo contextMenuInfo2 = contextMenuInfo;
        getActivity().onCreateContextMenu(contextMenu2, view2, contextMenuInfo2);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        Bundle bundle2 = bundle;
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
        if (!this.mCheckedForLoaderManager) {
            this.mCheckedForLoaderManager = true;
            this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
        }
        if (this.mLoaderManager != null) {
            this.mLoaderManager.doDestroy();
        }
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public void onHiddenChanged(boolean z) {
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        Activity activity2 = activity;
        AttributeSet attributeSet2 = attributeSet;
        Bundle bundle2 = bundle;
        this.mCalled = true;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        Bundle bundle2 = bundle;
        this.mCalled = true;
        Activity activity = this.mHost == null ? null : this.mHost.getActivity();
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet2, bundle2);
        }
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if (!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = true;
                this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
            }
            if (this.mLoaderManager != null) {
                this.mLoaderManager.doStart();
            }
        }
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
    }

    public void onViewStateRestored(@Nullable Bundle bundle) {
        Bundle bundle2 = bundle;
        this.mCalled = true;
    }

    /* access modifiers changed from: 0000 */
    public void performActivityCreated(Bundle bundle) {
        SuperNotCalledException superNotCalledException;
        StringBuilder sb;
        Bundle bundle2 = bundle;
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }
        this.mCalled = false;
        onActivityCreated(bundle2);
        if (!this.mCalled) {
            SuperNotCalledException superNotCalledException2 = superNotCalledException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            SuperNotCalledException superNotCalledException3 = new SuperNotCalledException(sb2.append("Fragment ").append(this).append(" did not call through to super.onActivityCreated()").toString());
            throw superNotCalledException2;
        } else if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchActivityCreated();
        }
    }

    /* access modifiers changed from: 0000 */
    public void performConfigurationChanged(Configuration configuration) {
        Configuration configuration2 = configuration;
        onConfigurationChanged(configuration2);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchConfigurationChanged(configuration2);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean performContextItemSelected(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        return !this.mHidden && (onContextItemSelected(menuItem2) || (this.mChildFragmentManager != null && this.mChildFragmentManager.dispatchContextItemSelected(menuItem2)));
    }

    /* access modifiers changed from: 0000 */
    public void performCreate(Bundle bundle) {
        SuperNotCalledException superNotCalledException;
        StringBuilder sb;
        Bundle bundle2 = bundle;
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }
        this.mCalled = false;
        onCreate(bundle2);
        if (!this.mCalled) {
            SuperNotCalledException superNotCalledException2 = superNotCalledException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            SuperNotCalledException superNotCalledException3 = new SuperNotCalledException(sb2.append("Fragment ").append(this).append(" did not call through to super.onCreate()").toString());
            throw superNotCalledException2;
        } else if (bundle2 != null) {
            Parcelable parcelable = bundle2.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.mChildFragmentManager == null) {
                    instantiateChildFragmentManager();
                }
                this.mChildFragmentManager.restoreAllState(parcelable, null);
                this.mChildFragmentManager.dispatchCreate();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Menu menu2 = menu;
        MenuInflater menuInflater2 = menuInflater;
        boolean z = false;
        if (!this.mHidden) {
            z = false;
            if (this.mHasMenu) {
                z = false;
                if (this.mMenuVisible) {
                    z = true;
                    onCreateOptionsMenu(menu2, menuInflater2);
                }
            }
            if (this.mChildFragmentManager != null) {
                z |= this.mChildFragmentManager.dispatchCreateOptionsMenu(menu2, menuInflater2);
            }
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public View performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        Bundle bundle2 = bundle;
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }
        return onCreateView(layoutInflater2, viewGroup2, bundle2);
    }

    /* access modifiers changed from: 0000 */
    public void performDestroy() {
        SuperNotCalledException superNotCalledException;
        StringBuilder sb;
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchDestroy();
        }
        this.mCalled = false;
        onDestroy();
        if (!this.mCalled) {
            SuperNotCalledException superNotCalledException2 = superNotCalledException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            SuperNotCalledException superNotCalledException3 = new SuperNotCalledException(sb2.append("Fragment ").append(this).append(" did not call through to super.onDestroy()").toString());
            throw superNotCalledException2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void performDestroyView() {
        SuperNotCalledException superNotCalledException;
        StringBuilder sb;
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchDestroyView();
        }
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            SuperNotCalledException superNotCalledException2 = superNotCalledException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            SuperNotCalledException superNotCalledException3 = new SuperNotCalledException(sb2.append("Fragment ").append(this).append(" did not call through to super.onDestroyView()").toString());
            throw superNotCalledException2;
        } else if (this.mLoaderManager != null) {
            this.mLoaderManager.doReportNextStart();
        }
    }

    /* access modifiers changed from: 0000 */
    public void performLowMemory() {
        onLowMemory();
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchLowMemory();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean performOptionsItemSelected(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        return !this.mHidden && ((this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem2)) || (this.mChildFragmentManager != null && this.mChildFragmentManager.dispatchOptionsItemSelected(menuItem2)));
    }

    /* access modifiers changed from: 0000 */
    public void performOptionsMenuClosed(Menu menu) {
        Menu menu2 = menu;
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu2);
            }
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.dispatchOptionsMenuClosed(menu2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void performPause() {
        SuperNotCalledException superNotCalledException;
        StringBuilder sb;
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchPause();
        }
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            SuperNotCalledException superNotCalledException2 = superNotCalledException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            SuperNotCalledException superNotCalledException3 = new SuperNotCalledException(sb2.append("Fragment ").append(this).append(" did not call through to super.onPause()").toString());
            throw superNotCalledException2;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean performPrepareOptionsMenu(Menu menu) {
        Menu menu2 = menu;
        boolean z = false;
        if (!this.mHidden) {
            z = false;
            if (this.mHasMenu) {
                z = false;
                if (this.mMenuVisible) {
                    z = true;
                    onPrepareOptionsMenu(menu2);
                }
            }
            if (this.mChildFragmentManager != null) {
                z |= this.mChildFragmentManager.dispatchPrepareOptionsMenu(menu2);
            }
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public void performReallyStop() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchReallyStop();
        }
        if (this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = true;
                this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
            }
            if (this.mLoaderManager == null) {
                return;
            }
            if (this.mHost.getRetainLoaders()) {
                this.mLoaderManager.doRetain();
            } else {
                this.mLoaderManager.doStop();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void performResume() {
        SuperNotCalledException superNotCalledException;
        StringBuilder sb;
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
            boolean execPendingActions = this.mChildFragmentManager.execPendingActions();
        }
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            SuperNotCalledException superNotCalledException2 = superNotCalledException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            SuperNotCalledException superNotCalledException3 = new SuperNotCalledException(sb2.append("Fragment ").append(this).append(" did not call through to super.onResume()").toString());
            throw superNotCalledException2;
        } else if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchResume();
            boolean execPendingActions2 = this.mChildFragmentManager.execPendingActions();
        }
    }

    /* access modifiers changed from: 0000 */
    public void performSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = bundle;
        onSaveInstanceState(bundle2);
        if (this.mChildFragmentManager != null) {
            Parcelable saveAllState = this.mChildFragmentManager.saveAllState();
            if (saveAllState != null) {
                bundle2.putParcelable("android:support:fragments", saveAllState);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void performStart() {
        SuperNotCalledException superNotCalledException;
        StringBuilder sb;
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
            boolean execPendingActions = this.mChildFragmentManager.execPendingActions();
        }
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            SuperNotCalledException superNotCalledException2 = superNotCalledException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            SuperNotCalledException superNotCalledException3 = new SuperNotCalledException(sb2.append("Fragment ").append(this).append(" did not call through to super.onStart()").toString());
            throw superNotCalledException2;
        }
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchStart();
        }
        if (this.mLoaderManager != null) {
            this.mLoaderManager.doReportStart();
        }
    }

    /* access modifiers changed from: 0000 */
    public void performStop() {
        SuperNotCalledException superNotCalledException;
        StringBuilder sb;
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchStop();
        }
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            SuperNotCalledException superNotCalledException2 = superNotCalledException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            SuperNotCalledException superNotCalledException3 = new SuperNotCalledException(sb2.append("Fragment ").append(this).append(" did not call through to super.onStop()").toString());
            throw superNotCalledException2;
        }
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public final void requestPermissions(@NonNull String[] strArr, int i) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        String[] strArr2 = strArr;
        int i2 = i;
        if (this.mHost == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Fragment ").append(this).append(" not attached to Activity").toString());
            throw illegalStateException2;
        }
        this.mHost.onRequestPermissionsFromFragment(this, strArr2, i2);
    }

    /* access modifiers changed from: 0000 */
    public final void restoreViewState(Bundle bundle) {
        SuperNotCalledException superNotCalledException;
        StringBuilder sb;
        Bundle bundle2 = bundle;
        if (this.mSavedViewState != null) {
            this.mInnerView.restoreHierarchyState(this.mSavedViewState);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle2);
        if (!this.mCalled) {
            SuperNotCalledException superNotCalledException2 = superNotCalledException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            SuperNotCalledException superNotCalledException3 = new SuperNotCalledException(sb2.append("Fragment ").append(this).append(" did not call through to super.onViewStateRestored()").toString());
            throw superNotCalledException2;
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        this.mAllowEnterTransitionOverlap = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        this.mAllowReturnTransitionOverlap = Boolean.valueOf(z);
    }

    public void setArguments(Bundle bundle) {
        IllegalStateException illegalStateException;
        Bundle bundle2 = bundle;
        if (this.mIndex >= 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Fragment already active");
            throw illegalStateException2;
        }
        this.mArguments = bundle2;
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        SharedElementCallback sharedElementCallback2 = sharedElementCallback;
        this.mEnterTransitionCallback = sharedElementCallback2;
    }

    public void setEnterTransition(Object obj) {
        Object obj2 = obj;
        this.mEnterTransition = obj2;
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        SharedElementCallback sharedElementCallback2 = sharedElementCallback;
        this.mExitTransitionCallback = sharedElementCallback2;
    }

    public void setExitTransition(Object obj) {
        Object obj2 = obj;
        this.mExitTransition = obj2;
    }

    public void setHasOptionsMenu(boolean z) {
        boolean z2 = z;
        if (this.mHasMenu != z2) {
            this.mHasMenu = z2;
            if (isAdded() && !isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void setIndex(int i, Fragment fragment) {
        StringBuilder sb;
        StringBuilder sb2;
        Fragment fragment2 = fragment;
        this.mIndex = i;
        if (fragment2 != null) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            this.mWho = sb3.append(fragment2.mWho).append(":").append(this.mIndex).toString();
            return;
        }
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        this.mWho = sb5.append("android:fragment:").append(this.mIndex).toString();
    }

    public void setInitialSavedState(SavedState savedState) {
        IllegalStateException illegalStateException;
        SavedState savedState2 = savedState;
        if (this.mIndex >= 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Fragment already active");
            throw illegalStateException2;
        }
        this.mSavedFragmentState = (savedState2 == null || savedState2.mState == null) ? null : savedState2.mState;
    }

    public void setMenuVisibility(boolean z) {
        boolean z2 = z;
        if (this.mMenuVisible != z2) {
            this.mMenuVisible = z2;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setReenterTransition(Object obj) {
        Object obj2 = obj;
        this.mReenterTransition = obj2;
    }

    public void setRetainInstance(boolean z) {
        IllegalStateException illegalStateException;
        boolean z2 = z;
        if (!z2 || this.mParentFragment == null) {
            this.mRetainInstance = z2;
            return;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("Can't retain fragements that are nested in other fragments");
        throw illegalStateException2;
    }

    public void setReturnTransition(Object obj) {
        Object obj2 = obj;
        this.mReturnTransition = obj2;
    }

    public void setSharedElementEnterTransition(Object obj) {
        Object obj2 = obj;
        this.mSharedElementEnterTransition = obj2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        Object obj2 = obj;
        this.mSharedElementReturnTransition = obj2;
    }

    public void setTargetFragment(Fragment fragment, int i) {
        int i2 = i;
        this.mTarget = fragment;
        this.mTargetRequestCode = i2;
    }

    public void setUserVisibleHint(boolean z) {
        boolean z2 = z;
        if (!this.mUserVisibleHint && z2 && this.mState < 4) {
            this.mFragmentManager.performPendingDeferredStart(this);
        }
        this.mUserVisibleHint = z2;
        this.mDeferStart = !z2;
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        String str2 = str;
        if (this.mHost != null) {
            return this.mHost.onShouldShowRequestPermissionRationale(str2);
        }
        return false;
    }

    public void startActivity(Intent intent) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        Intent intent2 = intent;
        if (this.mHost == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Fragment ").append(this).append(" not attached to Activity").toString());
            throw illegalStateException2;
        }
        this.mHost.onStartActivityFromFragment(this, intent2, -1);
    }

    public void startActivityForResult(Intent intent, int i) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        Intent intent2 = intent;
        int i2 = i;
        if (this.mHost == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Fragment ").append(this).append(" not attached to Activity").toString());
            throw illegalStateException2;
        }
        this.mHost.onStartActivityFromFragment(this, intent2, i2);
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(128);
        StringBuilder sb4 = sb2;
        DebugUtils.buildShortClassTag(this, sb4);
        if (this.mIndex >= 0) {
            StringBuilder append = sb4.append(" #");
            StringBuilder append2 = sb4.append(this.mIndex);
        }
        if (this.mFragmentId != 0) {
            StringBuilder append3 = sb4.append(" id=0x");
            StringBuilder append4 = sb4.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            StringBuilder append5 = sb4.append(" ");
            StringBuilder append6 = sb4.append(this.mTag);
        }
        StringBuilder append7 = sb4.append('}');
        return sb4.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }
}
