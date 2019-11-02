package android.support.p000v4.app;

import android.os.Bundle;
import android.support.p000v4.app.LoaderManager.LoaderCallbacks;
import android.support.p000v4.content.Loader;
import android.support.p000v4.content.Loader.OnLoadCanceledListener;
import android.support.p000v4.content.Loader.OnLoadCompleteListener;
import android.support.p000v4.util.DebugUtils;
import android.support.p000v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* renamed from: android.support.v4.app.LoaderManagerImpl */
class LoaderManagerImpl extends LoaderManager {
    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    boolean mCreatingLoader;
    /* access modifiers changed from: private */
    public FragmentHostCallback mHost;
    final SparseArrayCompat<LoaderInfo> mInactiveLoaders;
    final SparseArrayCompat<LoaderInfo> mLoaders;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final String mWho;

    /* renamed from: android.support.v4.app.LoaderManagerImpl$LoaderInfo */
    final class LoaderInfo implements OnLoadCompleteListener<Object>, OnLoadCanceledListener<Object> {
        final Bundle mArgs;
        LoaderCallbacks<Object> mCallbacks;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        boolean mHaveData;
        final int mId;
        boolean mListenerRegistered;
        Loader<Object> mLoader;
        LoaderInfo mPendingLoader;
        boolean mReportNextStart;
        boolean mRetaining;
        boolean mRetainingStarted;
        boolean mStarted;
        final /* synthetic */ LoaderManagerImpl this$0;

        public LoaderInfo(LoaderManagerImpl loaderManagerImpl, int i, Bundle bundle, LoaderCallbacks<Object> loaderCallbacks) {
            int i2 = i;
            Bundle bundle2 = bundle;
            LoaderCallbacks<Object> loaderCallbacks2 = loaderCallbacks;
            this.this$0 = loaderManagerImpl;
            this.mId = i2;
            this.mArgs = bundle2;
            this.mCallbacks = loaderCallbacks2;
        }

        /* access modifiers changed from: 0000 */
        public void callOnLoadFinished(Loader<Object> loader, Object obj) {
            StringBuilder sb;
            Loader<Object> loader2 = loader;
            Object obj2 = obj;
            if (this.mCallbacks != null) {
                String str = null;
                if (this.this$0.mHost != null) {
                    str = this.this$0.mHost.mFragmentManager.mNoTransactionsBecause;
                    this.this$0.mHost.mFragmentManager.mNoTransactionsBecause = "onLoadFinished";
                }
                try {
                    if (LoaderManagerImpl.DEBUG) {
                        String str2 = LoaderManagerImpl.TAG;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        int v = Log.v(str2, sb2.append("  onLoadFinished in ").append(loader2).append(": ").append(loader2.dataToString(obj2)).toString());
                    }
                    this.mCallbacks.onLoadFinished(loader2, obj2);
                    if (this.this$0.mHost != null) {
                        this.this$0.mHost.mFragmentManager.mNoTransactionsBecause = str;
                    }
                    this.mDeliveredData = true;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (this.this$0.mHost != null) {
                        this.this$0.mHost.mFragmentManager.mNoTransactionsBecause = str;
                    }
                    throw th2;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void cancel() {
            StringBuilder sb;
            if (LoaderManagerImpl.DEBUG) {
                String str = LoaderManagerImpl.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int v = Log.v(str, sb2.append("  Canceling: ").append(this).toString());
            }
            if (this.mStarted && this.mLoader != null && this.mListenerRegistered && !this.mLoader.cancelLoad()) {
                onLoadCanceled(this.mLoader);
            }
        }

        /* access modifiers changed from: 0000 */
        public void destroy() {
            StringBuilder sb;
            StringBuilder sb2;
            if (LoaderManagerImpl.DEBUG) {
                String str = LoaderManagerImpl.TAG;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                int v = Log.v(str, sb3.append("  Destroying: ").append(this).toString());
            }
            this.mDestroyed = true;
            boolean z = this.mDeliveredData;
            this.mDeliveredData = false;
            if (this.mCallbacks != null && this.mLoader != null && this.mHaveData && z) {
                if (LoaderManagerImpl.DEBUG) {
                    String str2 = LoaderManagerImpl.TAG;
                    StringBuilder sb5 = sb;
                    StringBuilder sb6 = new StringBuilder();
                    int v2 = Log.v(str2, sb5.append("  Reseting: ").append(this).toString());
                }
                String str3 = null;
                if (this.this$0.mHost != null) {
                    str3 = this.this$0.mHost.mFragmentManager.mNoTransactionsBecause;
                    this.this$0.mHost.mFragmentManager.mNoTransactionsBecause = "onLoaderReset";
                }
                try {
                    this.mCallbacks.onLoaderReset(this.mLoader);
                    if (this.this$0.mHost != null) {
                        this.this$0.mHost.mFragmentManager.mNoTransactionsBecause = str3;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (this.this$0.mHost != null) {
                        this.this$0.mHost.mFragmentManager.mNoTransactionsBecause = str3;
                    }
                    throw th2;
                }
            }
            this.mCallbacks = null;
            this.mData = null;
            this.mHaveData = false;
            if (this.mLoader != null) {
                if (this.mListenerRegistered) {
                    this.mListenerRegistered = false;
                    this.mLoader.unregisterListener(this);
                    this.mLoader.unregisterOnLoadCanceledListener(this);
                }
                this.mLoader.reset();
            }
            if (this.mPendingLoader != null) {
                this.mPendingLoader.destroy();
            }
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            StringBuilder sb;
            StringBuilder sb2;
            String str2 = str;
            FileDescriptor fileDescriptor2 = fileDescriptor;
            PrintWriter printWriter2 = printWriter;
            String[] strArr2 = strArr;
            printWriter2.print(str2);
            printWriter2.print("mId=");
            printWriter2.print(this.mId);
            printWriter2.print(" mArgs=");
            printWriter2.println(this.mArgs);
            printWriter2.print(str2);
            printWriter2.print("mCallbacks=");
            printWriter2.println(this.mCallbacks);
            printWriter2.print(str2);
            printWriter2.print("mLoader=");
            printWriter2.println(this.mLoader);
            if (this.mLoader != null) {
                Loader<Object> loader = this.mLoader;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                loader.dump(sb3.append(str2).append("  ").toString(), fileDescriptor2, printWriter2, strArr2);
            }
            if (this.mHaveData || this.mDeliveredData) {
                printWriter2.print(str2);
                printWriter2.print("mHaveData=");
                printWriter2.print(this.mHaveData);
                printWriter2.print("  mDeliveredData=");
                printWriter2.println(this.mDeliveredData);
                printWriter2.print(str2);
                printWriter2.print("mData=");
                printWriter2.println(this.mData);
            }
            printWriter2.print(str2);
            printWriter2.print("mStarted=");
            printWriter2.print(this.mStarted);
            printWriter2.print(" mReportNextStart=");
            printWriter2.print(this.mReportNextStart);
            printWriter2.print(" mDestroyed=");
            printWriter2.println(this.mDestroyed);
            printWriter2.print(str2);
            printWriter2.print("mRetaining=");
            printWriter2.print(this.mRetaining);
            printWriter2.print(" mRetainingStarted=");
            printWriter2.print(this.mRetainingStarted);
            printWriter2.print(" mListenerRegistered=");
            printWriter2.println(this.mListenerRegistered);
            if (this.mPendingLoader != null) {
                printWriter2.print(str2);
                printWriter2.println("Pending Loader ");
                printWriter2.print(this.mPendingLoader);
                printWriter2.println(":");
                LoaderInfo loaderInfo = this.mPendingLoader;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                loaderInfo.dump(sb5.append(str2).append("  ").toString(), fileDescriptor2, printWriter2, strArr2);
            }
        }

        /* access modifiers changed from: 0000 */
        public void finishRetain() {
            StringBuilder sb;
            if (this.mRetaining) {
                if (LoaderManagerImpl.DEBUG) {
                    String str = LoaderManagerImpl.TAG;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int v = Log.v(str, sb2.append("  Finished Retaining: ").append(this).toString());
                }
                this.mRetaining = false;
                if (this.mStarted != this.mRetainingStarted && !this.mStarted) {
                    stop();
                }
            }
            if (this.mStarted && this.mHaveData && !this.mReportNextStart) {
                callOnLoadFinished(this.mLoader, this.mData);
            }
        }

        public void onLoadCanceled(Loader<Object> loader) {
            StringBuilder sb;
            StringBuilder sb2;
            Loader<Object> loader2 = loader;
            if (LoaderManagerImpl.DEBUG) {
                String str = LoaderManagerImpl.TAG;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                int v = Log.v(str, sb3.append("onLoadCanceled: ").append(this).toString());
            }
            if (this.mDestroyed) {
                if (LoaderManagerImpl.DEBUG) {
                    int v2 = Log.v(LoaderManagerImpl.TAG, "  Ignoring load canceled -- destroyed");
                }
            } else if (this.this$0.mLoaders.get(this.mId) == this) {
                LoaderInfo loaderInfo = this.mPendingLoader;
                if (loaderInfo != null) {
                    if (LoaderManagerImpl.DEBUG) {
                        String str2 = LoaderManagerImpl.TAG;
                        StringBuilder sb5 = sb;
                        StringBuilder sb6 = new StringBuilder();
                        int v3 = Log.v(str2, sb5.append("  Switching to pending loader: ").append(loaderInfo).toString());
                    }
                    this.mPendingLoader = null;
                    this.this$0.mLoaders.put(this.mId, null);
                    destroy();
                    this.this$0.installLoader(loaderInfo);
                }
            } else if (LoaderManagerImpl.DEBUG) {
                int v4 = Log.v(LoaderManagerImpl.TAG, "  Ignoring load canceled -- not active");
            }
        }

        public void onLoadComplete(Loader<Object> loader, Object obj) {
            StringBuilder sb;
            StringBuilder sb2;
            Loader<Object> loader2 = loader;
            Object obj2 = obj;
            if (LoaderManagerImpl.DEBUG) {
                String str = LoaderManagerImpl.TAG;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                int v = Log.v(str, sb3.append("onLoadComplete: ").append(this).toString());
            }
            if (this.mDestroyed) {
                if (LoaderManagerImpl.DEBUG) {
                    int v2 = Log.v(LoaderManagerImpl.TAG, "  Ignoring load complete -- destroyed");
                }
            } else if (this.this$0.mLoaders.get(this.mId) == this) {
                LoaderInfo loaderInfo = this.mPendingLoader;
                if (loaderInfo != null) {
                    if (LoaderManagerImpl.DEBUG) {
                        String str2 = LoaderManagerImpl.TAG;
                        StringBuilder sb5 = sb;
                        StringBuilder sb6 = new StringBuilder();
                        int v3 = Log.v(str2, sb5.append("  Switching to pending loader: ").append(loaderInfo).toString());
                    }
                    this.mPendingLoader = null;
                    this.this$0.mLoaders.put(this.mId, null);
                    destroy();
                    this.this$0.installLoader(loaderInfo);
                    return;
                }
                if (this.mData != obj2 || !this.mHaveData) {
                    this.mData = obj2;
                    this.mHaveData = true;
                    if (this.mStarted) {
                        callOnLoadFinished(loader2, obj2);
                    }
                }
                LoaderInfo loaderInfo2 = (LoaderInfo) this.this$0.mInactiveLoaders.get(this.mId);
                if (!(loaderInfo2 == null || loaderInfo2 == this)) {
                    loaderInfo2.mDeliveredData = false;
                    loaderInfo2.destroy();
                    this.this$0.mInactiveLoaders.remove(this.mId);
                }
                if (this.this$0.mHost != null && !this.this$0.hasRunningLoaders()) {
                    this.this$0.mHost.mFragmentManager.startPendingDeferredFragments();
                }
            } else if (LoaderManagerImpl.DEBUG) {
                int v4 = Log.v(LoaderManagerImpl.TAG, "  Ignoring load complete -- not active");
            }
        }

        /* access modifiers changed from: 0000 */
        public void reportStart() {
            if (this.mStarted && this.mReportNextStart) {
                this.mReportNextStart = false;
                if (this.mHaveData) {
                    callOnLoadFinished(this.mLoader, this.mData);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void retain() {
            StringBuilder sb;
            if (LoaderManagerImpl.DEBUG) {
                String str = LoaderManagerImpl.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int v = Log.v(str, sb2.append("  Retaining: ").append(this).toString());
            }
            this.mRetaining = true;
            this.mRetainingStarted = this.mStarted;
            this.mStarted = false;
            this.mCallbacks = null;
        }

        /* access modifiers changed from: 0000 */
        public void start() {
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            StringBuilder sb2;
            if (this.mRetaining && this.mRetainingStarted) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (LoaderManagerImpl.DEBUG) {
                    String str = LoaderManagerImpl.TAG;
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    int v = Log.v(str, sb3.append("  Starting: ").append(this).toString());
                }
                if (this.mLoader == null && this.mCallbacks != null) {
                    this.mLoader = this.mCallbacks.onCreateLoader(this.mId, this.mArgs);
                }
                if (this.mLoader == null) {
                    return;
                }
                if (!this.mLoader.getClass().isMemberClass() || Modifier.isStatic(this.mLoader.getClass().getModifiers())) {
                    if (!this.mListenerRegistered) {
                        this.mLoader.registerListener(this.mId, this);
                        this.mLoader.registerOnLoadCanceledListener(this);
                        this.mListenerRegistered = true;
                    }
                    this.mLoader.startLoading();
                    return;
                }
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb5.append("Object returned from onCreateLoader must not be a non-static inner member class: ").append(this.mLoader).toString());
                throw illegalArgumentException2;
            }
        }

        /* access modifiers changed from: 0000 */
        public void stop() {
            StringBuilder sb;
            if (LoaderManagerImpl.DEBUG) {
                String str = LoaderManagerImpl.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int v = Log.v(str, sb2.append("  Stopping: ").append(this).toString());
            }
            this.mStarted = false;
            if (!this.mRetaining && this.mLoader != null && this.mListenerRegistered) {
                this.mListenerRegistered = false;
                this.mLoader.unregisterListener(this);
                this.mLoader.unregisterOnLoadCanceledListener(this);
                this.mLoader.stopLoading();
            }
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder(64);
            StringBuilder sb4 = sb2;
            StringBuilder append = sb4.append("LoaderInfo{");
            StringBuilder append2 = sb4.append(Integer.toHexString(System.identityHashCode(this)));
            StringBuilder append3 = sb4.append(" #");
            StringBuilder append4 = sb4.append(this.mId);
            StringBuilder append5 = sb4.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, sb4);
            StringBuilder append6 = sb4.append("}}");
            return sb4.toString();
        }
    }

    LoaderManagerImpl(String str, FragmentHostCallback fragmentHostCallback, boolean z) {
        SparseArrayCompat<LoaderInfo> sparseArrayCompat;
        SparseArrayCompat<LoaderInfo> sparseArrayCompat2;
        String str2 = str;
        FragmentHostCallback fragmentHostCallback2 = fragmentHostCallback;
        boolean z2 = z;
        SparseArrayCompat<LoaderInfo> sparseArrayCompat3 = sparseArrayCompat;
        SparseArrayCompat<LoaderInfo> sparseArrayCompat4 = new SparseArrayCompat<>();
        this.mLoaders = sparseArrayCompat3;
        SparseArrayCompat<LoaderInfo> sparseArrayCompat5 = sparseArrayCompat2;
        SparseArrayCompat<LoaderInfo> sparseArrayCompat6 = new SparseArrayCompat<>();
        this.mInactiveLoaders = sparseArrayCompat5;
        this.mWho = str2;
        this.mHost = fragmentHostCallback2;
        this.mStarted = z2;
    }

    private LoaderInfo createAndInstallLoader(int i, Bundle bundle, LoaderCallbacks<Object> loaderCallbacks) {
        int i2 = i;
        Bundle bundle2 = bundle;
        LoaderCallbacks<Object> loaderCallbacks2 = loaderCallbacks;
        try {
            this.mCreatingLoader = true;
            LoaderInfo createLoader = createLoader(i2, bundle2, loaderCallbacks2);
            installLoader(createLoader);
            this.mCreatingLoader = false;
            return createLoader;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.mCreatingLoader = false;
            throw th2;
        }
    }

    private LoaderInfo createLoader(int i, Bundle bundle, LoaderCallbacks<Object> loaderCallbacks) {
        LoaderInfo loaderInfo;
        int i2 = i;
        Bundle bundle2 = bundle;
        LoaderCallbacks<Object> loaderCallbacks2 = loaderCallbacks;
        LoaderInfo loaderInfo2 = loaderInfo;
        LoaderInfo loaderInfo3 = new LoaderInfo(this, i2, bundle2, loaderCallbacks2);
        LoaderInfo loaderInfo4 = loaderInfo2;
        loaderInfo4.mLoader = loaderCallbacks2.onCreateLoader(i2, bundle2);
        return loaderInfo4;
    }

    public void destroyLoader(int i) {
        StringBuilder sb;
        IllegalStateException illegalStateException;
        int i2 = i;
        if (this.mCreatingLoader) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Called while creating a loader");
            throw illegalStateException2;
        }
        if (DEBUG) {
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int v = Log.v(str, sb2.append("destroyLoader in ").append(this).append(" of ").append(i2).toString());
        }
        int indexOfKey = this.mLoaders.indexOfKey(i2);
        if (indexOfKey >= 0) {
            LoaderInfo loaderInfo = (LoaderInfo) this.mLoaders.valueAt(indexOfKey);
            this.mLoaders.removeAt(indexOfKey);
            loaderInfo.destroy();
        }
        int indexOfKey2 = this.mInactiveLoaders.indexOfKey(i2);
        if (indexOfKey2 >= 0) {
            LoaderInfo loaderInfo2 = (LoaderInfo) this.mInactiveLoaders.valueAt(indexOfKey2);
            this.mInactiveLoaders.removeAt(indexOfKey2);
            loaderInfo2.destroy();
        }
        if (this.mHost != null && !hasRunningLoaders()) {
            this.mHost.mFragmentManager.startPendingDeferredFragments();
        }
    }

    /* access modifiers changed from: 0000 */
    public void doDestroy() {
        StringBuilder sb;
        StringBuilder sb2;
        if (!this.mRetaining) {
            if (DEBUG) {
                String str = TAG;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                int v = Log.v(str, sb3.append("Destroying Active in ").append(this).toString());
            }
            for (int size = -1 + this.mLoaders.size(); size >= 0; size--) {
                ((LoaderInfo) this.mLoaders.valueAt(size)).destroy();
            }
            this.mLoaders.clear();
        }
        if (DEBUG) {
            String str2 = TAG;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            int v2 = Log.v(str2, sb5.append("Destroying Inactive in ").append(this).toString());
        }
        for (int size2 = -1 + this.mInactiveLoaders.size(); size2 >= 0; size2--) {
            ((LoaderInfo) this.mInactiveLoaders.valueAt(size2)).destroy();
        }
        this.mInactiveLoaders.clear();
    }

    /* access modifiers changed from: 0000 */
    public void doReportNextStart() {
        for (int size = -1 + this.mLoaders.size(); size >= 0; size--) {
            ((LoaderInfo) this.mLoaders.valueAt(size)).mReportNextStart = true;
        }
    }

    /* access modifiers changed from: 0000 */
    public void doReportStart() {
        for (int size = -1 + this.mLoaders.size(); size >= 0; size--) {
            ((LoaderInfo) this.mLoaders.valueAt(size)).reportStart();
        }
    }

    /* access modifiers changed from: 0000 */
    public void doRetain() {
        RuntimeException runtimeException;
        StringBuilder sb;
        StringBuilder sb2;
        if (DEBUG) {
            String str = TAG;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            int v = Log.v(str, sb3.append("Retaining in ").append(this).toString());
        }
        if (!this.mStarted) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("here");
            RuntimeException runtimeException4 = runtimeException2;
            Throwable fillInStackTrace = runtimeException4.fillInStackTrace();
            String str2 = TAG;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            int w = Log.w(str2, sb5.append("Called doRetain when not started: ").append(this).toString(), runtimeException4);
            return;
        }
        this.mRetaining = true;
        this.mStarted = false;
        for (int size = -1 + this.mLoaders.size(); size >= 0; size--) {
            ((LoaderInfo) this.mLoaders.valueAt(size)).retain();
        }
    }

    /* access modifiers changed from: 0000 */
    public void doStart() {
        RuntimeException runtimeException;
        StringBuilder sb;
        StringBuilder sb2;
        if (DEBUG) {
            String str = TAG;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            int v = Log.v(str, sb3.append("Starting in ").append(this).toString());
        }
        if (this.mStarted) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("here");
            RuntimeException runtimeException4 = runtimeException2;
            Throwable fillInStackTrace = runtimeException4.fillInStackTrace();
            String str2 = TAG;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            int w = Log.w(str2, sb5.append("Called doStart when already started: ").append(this).toString(), runtimeException4);
            return;
        }
        this.mStarted = true;
        for (int size = -1 + this.mLoaders.size(); size >= 0; size--) {
            ((LoaderInfo) this.mLoaders.valueAt(size)).start();
        }
    }

    /* access modifiers changed from: 0000 */
    public void doStop() {
        RuntimeException runtimeException;
        StringBuilder sb;
        StringBuilder sb2;
        if (DEBUG) {
            String str = TAG;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            int v = Log.v(str, sb3.append("Stopping in ").append(this).toString());
        }
        if (!this.mStarted) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("here");
            RuntimeException runtimeException4 = runtimeException2;
            Throwable fillInStackTrace = runtimeException4.fillInStackTrace();
            String str2 = TAG;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            int w = Log.w(str2, sb5.append("Called doStop when not started: ").append(this).toString(), runtimeException4);
            return;
        }
        for (int size = -1 + this.mLoaders.size(); size >= 0; size--) {
            ((LoaderInfo) this.mLoaders.valueAt(size)).stop();
        }
        this.mStarted = false;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        StringBuilder sb;
        StringBuilder sb2;
        String str2 = str;
        FileDescriptor fileDescriptor2 = fileDescriptor;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        if (this.mLoaders.size() > 0) {
            printWriter2.print(str2);
            printWriter2.println("Active Loaders:");
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            String sb5 = sb3.append(str2).append("    ").toString();
            for (int i = 0; i < this.mLoaders.size(); i++) {
                LoaderInfo loaderInfo = (LoaderInfo) this.mLoaders.valueAt(i);
                printWriter2.print(str2);
                printWriter2.print("  #");
                printWriter2.print(this.mLoaders.keyAt(i));
                printWriter2.print(": ");
                printWriter2.println(loaderInfo.toString());
                loaderInfo.dump(sb5, fileDescriptor2, printWriter2, strArr2);
            }
        }
        if (this.mInactiveLoaders.size() > 0) {
            printWriter2.print(str2);
            printWriter2.println("Inactive Loaders:");
            StringBuilder sb6 = sb;
            StringBuilder sb7 = new StringBuilder();
            String sb8 = sb6.append(str2).append("    ").toString();
            for (int i2 = 0; i2 < this.mInactiveLoaders.size(); i2++) {
                LoaderInfo loaderInfo2 = (LoaderInfo) this.mInactiveLoaders.valueAt(i2);
                printWriter2.print(str2);
                printWriter2.print("  #");
                printWriter2.print(this.mInactiveLoaders.keyAt(i2));
                printWriter2.print(": ");
                printWriter2.println(loaderInfo2.toString());
                loaderInfo2.dump(sb8, fileDescriptor2, printWriter2, strArr2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void finishRetain() {
        StringBuilder sb;
        if (this.mRetaining) {
            if (DEBUG) {
                String str = TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int v = Log.v(str, sb2.append("Finished Retaining in ").append(this).toString());
            }
            this.mRetaining = false;
            for (int size = -1 + this.mLoaders.size(); size >= 0; size--) {
                ((LoaderInfo) this.mLoaders.valueAt(size)).finishRetain();
            }
        }
    }

    public <D> Loader<D> getLoader(int i) {
        IllegalStateException illegalStateException;
        int i2 = i;
        if (this.mCreatingLoader) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Called while creating a loader");
            throw illegalStateException2;
        }
        LoaderInfo loaderInfo = (LoaderInfo) this.mLoaders.get(i2);
        if (loaderInfo != null) {
            return loaderInfo.mPendingLoader != null ? loaderInfo.mPendingLoader.mLoader : loaderInfo.mLoader;
        }
        return null;
    }

    public boolean hasRunningLoaders() {
        boolean z = false;
        for (int i = 0; i < this.mLoaders.size(); i++) {
            LoaderInfo loaderInfo = (LoaderInfo) this.mLoaders.valueAt(i);
            z |= loaderInfo.mStarted && !loaderInfo.mDeliveredData;
        }
        return z;
    }

    public <D> Loader<D> initLoader(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        IllegalStateException illegalStateException;
        int i2 = i;
        Bundle bundle2 = bundle;
        LoaderCallbacks<D> loaderCallbacks2 = loaderCallbacks;
        if (this.mCreatingLoader) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Called while creating a loader");
            throw illegalStateException2;
        }
        LoaderInfo loaderInfo = (LoaderInfo) this.mLoaders.get(i2);
        if (DEBUG) {
            String str = TAG;
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            int v = Log.v(str, sb4.append("initLoader in ").append(this).append(": args=").append(bundle2).toString());
        }
        if (loaderInfo == null) {
            loaderInfo = createAndInstallLoader(i2, bundle2, loaderCallbacks2);
            if (DEBUG) {
                String str2 = TAG;
                StringBuilder sb6 = sb2;
                StringBuilder sb7 = new StringBuilder();
                int v2 = Log.v(str2, sb6.append("  Created new loader ").append(loaderInfo).toString());
            }
        } else {
            if (DEBUG) {
                String str3 = TAG;
                StringBuilder sb8 = sb;
                StringBuilder sb9 = new StringBuilder();
                int v3 = Log.v(str3, sb8.append("  Re-using existing loader ").append(loaderInfo).toString());
            }
            loaderInfo.mCallbacks = loaderCallbacks2;
        }
        if (loaderInfo.mHaveData && this.mStarted) {
            loaderInfo.callOnLoadFinished(loaderInfo.mLoader, loaderInfo.mData);
        }
        return loaderInfo.mLoader;
    }

    /* access modifiers changed from: 0000 */
    public void installLoader(LoaderInfo loaderInfo) {
        LoaderInfo loaderInfo2 = loaderInfo;
        this.mLoaders.put(loaderInfo2.mId, loaderInfo2);
        if (this.mStarted) {
            loaderInfo2.start();
        }
    }

    public <D> Loader<D> restartLoader(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        IllegalStateException illegalStateException;
        int i2 = i;
        Bundle bundle2 = bundle;
        LoaderCallbacks<D> loaderCallbacks2 = loaderCallbacks;
        if (this.mCreatingLoader) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Called while creating a loader");
            throw illegalStateException2;
        }
        LoaderInfo loaderInfo = (LoaderInfo) this.mLoaders.get(i2);
        if (DEBUG) {
            String str = TAG;
            StringBuilder sb5 = sb4;
            StringBuilder sb6 = new StringBuilder();
            int v = Log.v(str, sb5.append("restartLoader in ").append(this).append(": args=").append(bundle2).toString());
        }
        if (loaderInfo != null) {
            LoaderInfo loaderInfo2 = (LoaderInfo) this.mInactiveLoaders.get(i2);
            if (loaderInfo2 == null) {
                if (DEBUG) {
                    String str2 = TAG;
                    StringBuilder sb7 = sb;
                    StringBuilder sb8 = new StringBuilder();
                    int v2 = Log.v(str2, sb7.append("  Making last loader inactive: ").append(loaderInfo).toString());
                }
                loaderInfo.mLoader.abandon();
                this.mInactiveLoaders.put(i2, loaderInfo);
            } else if (loaderInfo.mHaveData) {
                if (DEBUG) {
                    String str3 = TAG;
                    StringBuilder sb9 = sb3;
                    StringBuilder sb10 = new StringBuilder();
                    int v3 = Log.v(str3, sb9.append("  Removing last inactive loader: ").append(loaderInfo).toString());
                }
                loaderInfo2.mDeliveredData = false;
                loaderInfo2.destroy();
                loaderInfo.mLoader.abandon();
                this.mInactiveLoaders.put(i2, loaderInfo);
            } else if (!loaderInfo.mStarted) {
                if (DEBUG) {
                    int v4 = Log.v(TAG, "  Current loader is stopped; replacing");
                }
                this.mLoaders.put(i2, null);
                loaderInfo.destroy();
            } else {
                if (DEBUG) {
                    int v5 = Log.v(TAG, "  Current loader is running; attempting to cancel");
                }
                loaderInfo.cancel();
                if (loaderInfo.mPendingLoader != null) {
                    if (DEBUG) {
                        String str4 = TAG;
                        StringBuilder sb11 = sb2;
                        StringBuilder sb12 = new StringBuilder();
                        int v6 = Log.v(str4, sb11.append("  Removing pending loader: ").append(loaderInfo.mPendingLoader).toString());
                    }
                    loaderInfo.mPendingLoader.destroy();
                    loaderInfo.mPendingLoader = null;
                }
                if (DEBUG) {
                    int v7 = Log.v(TAG, "  Enqueuing as new pending loader");
                }
                loaderInfo.mPendingLoader = createLoader(i2, bundle2, loaderCallbacks2);
                return loaderInfo.mPendingLoader.mLoader;
            }
        }
        return createAndInstallLoader(i2, bundle2, loaderCallbacks2).mLoader;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(128);
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("LoaderManager{");
        StringBuilder append2 = sb4.append(Integer.toHexString(System.identityHashCode(this)));
        StringBuilder append3 = sb4.append(" in ");
        DebugUtils.buildShortClassTag(this.mHost, sb4);
        StringBuilder append4 = sb4.append("}}");
        return sb4.toString();
    }

    /* access modifiers changed from: 0000 */
    public void updateHostController(FragmentHostCallback fragmentHostCallback) {
        FragmentHostCallback fragmentHostCallback2 = fragmentHostCallback;
        this.mHost = fragmentHostCallback2;
    }
}
