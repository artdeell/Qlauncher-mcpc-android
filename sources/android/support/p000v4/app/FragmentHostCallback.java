package android.support.p000v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.util.SimpleArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.FragmentHostCallback */
public abstract class FragmentHostCallback<E> extends FragmentContainer {
    private final Activity mActivity;
    private SimpleArrayMap<String, LoaderManager> mAllLoaderManagers;
    private boolean mCheckedForLoaderManager;
    final Context mContext;
    final FragmentManagerImpl mFragmentManager;
    private final Handler mHandler;
    private LoaderManagerImpl mLoaderManager;
    private boolean mLoadersStarted;
    private boolean mRetainLoaders;
    final int mWindowAnimations;

    FragmentHostCallback(Activity activity, Context context, Handler handler, int i) {
        FragmentManagerImpl fragmentManagerImpl;
        Activity activity2 = activity;
        Context context2 = context;
        Handler handler2 = handler;
        int i2 = i;
        FragmentManagerImpl fragmentManagerImpl2 = fragmentManagerImpl;
        FragmentManagerImpl fragmentManagerImpl3 = new FragmentManagerImpl();
        this.mFragmentManager = fragmentManagerImpl2;
        this.mActivity = activity2;
        this.mContext = context2;
        this.mHandler = handler2;
        this.mWindowAnimations = i2;
    }

    public FragmentHostCallback(Context context, Handler handler, int i) {
        this(null, context, handler, i);
    }

    FragmentHostCallback(FragmentActivity fragmentActivity) {
        FragmentActivity fragmentActivity2 = fragmentActivity;
        this(fragmentActivity2, fragmentActivity2, fragmentActivity2.mHandler, 0);
    }

    /* access modifiers changed from: 0000 */
    public void doLoaderDestroy() {
        if (this.mLoaderManager != null) {
            this.mLoaderManager.doDestroy();
        }
    }

    /* access modifiers changed from: 0000 */
    public void doLoaderRetain() {
        if (this.mLoaderManager != null) {
            this.mLoaderManager.doRetain();
        }
    }

    /* access modifiers changed from: 0000 */
    public void doLoaderStart() {
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if (this.mLoaderManager != null) {
                this.mLoaderManager.doStart();
            } else if (!this.mCheckedForLoaderManager) {
                this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, false);
                if (this.mLoaderManager != null && !this.mLoaderManager.mStarted) {
                    this.mLoaderManager.doStart();
                }
            }
            this.mCheckedForLoaderManager = true;
        }
    }

    /* access modifiers changed from: 0000 */
    public void doLoaderStop(boolean z) {
        boolean z2 = z;
        this.mRetainLoaders = z2;
        if (this.mLoaderManager != null && this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (z2) {
                this.mLoaderManager.doRetain();
            } else {
                this.mLoaderManager.doStop();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        StringBuilder sb;
        String str2 = str;
        FileDescriptor fileDescriptor2 = fileDescriptor;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        printWriter2.print(str2);
        printWriter2.print("mLoadersStarted=");
        printWriter2.println(this.mLoadersStarted);
        if (this.mLoaderManager != null) {
            printWriter2.print(str2);
            printWriter2.print("Loader Manager ");
            printWriter2.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
            printWriter2.println(":");
            LoaderManagerImpl loaderManagerImpl = this.mLoaderManager;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            loaderManagerImpl.dump(sb2.append(str2).append("  ").toString(), fileDescriptor2, printWriter2, strArr2);
        }
    }

    /* access modifiers changed from: 0000 */
    public Activity getActivity() {
        return this.mActivity;
    }

    /* access modifiers changed from: 0000 */
    public Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: 0000 */
    public FragmentManagerImpl getFragmentManagerImpl() {
        return this.mFragmentManager;
    }

    /* access modifiers changed from: 0000 */
    public Handler getHandler() {
        return this.mHandler;
    }

    /* access modifiers changed from: 0000 */
    public LoaderManagerImpl getLoaderManager(String str, boolean z, boolean z2) {
        LoaderManagerImpl loaderManagerImpl;
        SimpleArrayMap<String, LoaderManager> simpleArrayMap;
        String str2 = str;
        boolean z3 = z;
        boolean z4 = z2;
        if (this.mAllLoaderManagers == null) {
            SimpleArrayMap<String, LoaderManager> simpleArrayMap2 = simpleArrayMap;
            SimpleArrayMap<String, LoaderManager> simpleArrayMap3 = new SimpleArrayMap<>();
            this.mAllLoaderManagers = simpleArrayMap2;
        }
        LoaderManagerImpl loaderManagerImpl2 = (LoaderManagerImpl) this.mAllLoaderManagers.get(str2);
        if (loaderManagerImpl2 == null) {
            if (z4) {
                LoaderManagerImpl loaderManagerImpl3 = loaderManagerImpl;
                LoaderManagerImpl loaderManagerImpl4 = new LoaderManagerImpl(str2, this, z3);
                loaderManagerImpl2 = loaderManagerImpl3;
                Object put = this.mAllLoaderManagers.put(str2, loaderManagerImpl2);
            }
            return loaderManagerImpl2;
        }
        loaderManagerImpl2.updateHostController(this);
        return loaderManagerImpl2;
    }

    /* access modifiers changed from: 0000 */
    public LoaderManagerImpl getLoaderManagerImpl() {
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, true);
        return this.mLoaderManager;
    }

    /* access modifiers changed from: 0000 */
    public boolean getRetainLoaders() {
        return this.mRetainLoaders;
    }

    /* access modifiers changed from: 0000 */
    public void inactivateFragment(String str) {
        String str2 = str;
        if (this.mAllLoaderManagers != null) {
            LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl) this.mAllLoaderManagers.get(str2);
            if (loaderManagerImpl != null && !loaderManagerImpl.mRetaining) {
                loaderManagerImpl.doDestroy();
                Object remove = this.mAllLoaderManagers.remove(str2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void onAttachFragment(Fragment fragment) {
    }

    public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Nullable
    public View onFindViewById(int i) {
        int i2 = i;
        return null;
    }

    @Nullable
    public abstract E onGetHost();

    public LayoutInflater onGetLayoutInflater() {
        return (LayoutInflater) this.mContext.getSystemService("layout_inflater");
    }

    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }

    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public void onRequestPermissionsFromFragment(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
    }

    public boolean onShouldSaveFragmentState(Fragment fragment) {
        Fragment fragment2 = fragment;
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(@NonNull String str) {
        String str2 = str;
        return false;
    }

    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i) {
        IllegalStateException illegalStateException;
        Fragment fragment2 = fragment;
        Intent intent2 = intent;
        if (i != -1) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
            throw illegalStateException2;
        }
        this.mContext.startActivity(intent2);
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    /* access modifiers changed from: 0000 */
    public void reportLoaderStart() {
        if (this.mAllLoaderManagers != null) {
            int size = this.mAllLoaderManagers.size();
            LoaderManagerImpl[] loaderManagerImplArr = new LoaderManagerImpl[size];
            for (int i = size - 1; i >= 0; i--) {
                loaderManagerImplArr[i] = (LoaderManagerImpl) this.mAllLoaderManagers.valueAt(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                LoaderManagerImpl loaderManagerImpl = loaderManagerImplArr[i2];
                loaderManagerImpl.finishRetain();
                loaderManagerImpl.doReportStart();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
        SimpleArrayMap<String, LoaderManager> simpleArrayMap2 = simpleArrayMap;
        this.mAllLoaderManagers = simpleArrayMap2;
    }

    /* access modifiers changed from: 0000 */
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        boolean z = false;
        if (this.mAllLoaderManagers != null) {
            int size = this.mAllLoaderManagers.size();
            LoaderManagerImpl[] loaderManagerImplArr = new LoaderManagerImpl[size];
            for (int i = size - 1; i >= 0; i--) {
                loaderManagerImplArr[i] = (LoaderManagerImpl) this.mAllLoaderManagers.valueAt(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                LoaderManagerImpl loaderManagerImpl = loaderManagerImplArr[i2];
                if (loaderManagerImpl.mRetaining) {
                    z = true;
                } else {
                    loaderManagerImpl.doDestroy();
                    Object remove = this.mAllLoaderManagers.remove(loaderManagerImpl.mWho);
                }
            }
        }
        if (z) {
            return this.mAllLoaderManagers;
        }
        return null;
    }
}
