package android.support.p000v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.p000v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.content.Loader */
public class Loader<D> {
    boolean mAbandoned = false;
    boolean mContentChanged = false;
    Context mContext;
    int mId;
    OnLoadCompleteListener<D> mListener;
    OnLoadCanceledListener<D> mOnLoadCanceledListener;
    boolean mProcessingChange = false;
    boolean mReset = true;
    boolean mStarted = false;

    /* renamed from: android.support.v4.content.Loader$ForceLoadContentObserver */
    public final class ForceLoadContentObserver extends ContentObserver {
        final /* synthetic */ Loader this$0;

        public ForceLoadContentObserver(Loader loader) {
            Handler handler;
            this.this$0 = loader;
            Handler handler2 = handler;
            Handler handler3 = new Handler();
            super(handler2);
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            boolean z2 = z;
            this.this$0.onContentChanged();
        }
    }

    /* renamed from: android.support.v4.content.Loader$OnLoadCanceledListener */
    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(Loader<D> loader);
    }

    /* renamed from: android.support.v4.content.Loader$OnLoadCompleteListener */
    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(Loader<D> loader, D d);
    }

    public Loader(Context context) {
        Context context2 = context;
        this.mContext = context2.getApplicationContext();
    }

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public String dataToString(D d) {
        StringBuilder sb;
        D d2 = d;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(64);
        StringBuilder sb4 = sb2;
        DebugUtils.buildShortClassTag(d2, sb4);
        StringBuilder append = sb4.append("}");
        return sb4.toString();
    }

    public void deliverCancellation() {
        if (this.mOnLoadCanceledListener != null) {
            this.mOnLoadCanceledListener.onLoadCanceled(this);
        }
    }

    public void deliverResult(D d) {
        D d2 = d;
        if (this.mListener != null) {
            this.mListener.onLoadComplete(this, d2);
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str;
        FileDescriptor fileDescriptor2 = fileDescriptor;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        printWriter2.print(str2);
        printWriter2.print("mId=");
        printWriter2.print(this.mId);
        printWriter2.print(" mListener=");
        printWriter2.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter2.print(str2);
            printWriter2.print("mStarted=");
            printWriter2.print(this.mStarted);
            printWriter2.print(" mContentChanged=");
            printWriter2.print(this.mContentChanged);
            printWriter2.print(" mProcessingChange=");
            printWriter2.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter2.print(str2);
            printWriter2.print("mAbandoned=");
            printWriter2.print(this.mAbandoned);
            printWriter2.print(" mReset=");
            printWriter2.println(this.mReset);
        }
    }

    public void forceLoad() {
        onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    /* access modifiers changed from: protected */
    public void onAbandon() {
    }

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        return false;
    }

    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
    }

    /* access modifiers changed from: protected */
    public void onReset() {
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
    }

    /* access modifiers changed from: protected */
    public void onStopLoading() {
    }

    public void registerListener(int i, OnLoadCompleteListener<D> onLoadCompleteListener) {
        IllegalStateException illegalStateException;
        int i2 = i;
        OnLoadCompleteListener<D> onLoadCompleteListener2 = onLoadCompleteListener;
        if (this.mListener != null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("There is already a listener registered");
            throw illegalStateException2;
        }
        this.mListener = onLoadCompleteListener2;
        this.mId = i2;
    }

    public void registerOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        IllegalStateException illegalStateException;
        OnLoadCanceledListener<D> onLoadCanceledListener2 = onLoadCanceledListener;
        if (this.mOnLoadCanceledListener != null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("There is already a listener registered");
            throw illegalStateException2;
        }
        this.mOnLoadCanceledListener = onLoadCanceledListener2;
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            this.mContentChanged = true;
        }
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange = z | this.mProcessingChange;
        return z;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(64);
        StringBuilder sb4 = sb2;
        DebugUtils.buildShortClassTag(this, sb4);
        StringBuilder append = sb4.append(" id=");
        StringBuilder append2 = sb4.append(this.mId);
        StringBuilder append3 = sb4.append("}");
        return sb4.toString();
    }

    public void unregisterListener(OnLoadCompleteListener<D> onLoadCompleteListener) {
        IllegalArgumentException illegalArgumentException;
        IllegalStateException illegalStateException;
        OnLoadCompleteListener<D> onLoadCompleteListener2 = onLoadCompleteListener;
        if (this.mListener == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No listener register");
            throw illegalStateException2;
        } else if (this.mListener != onLoadCompleteListener2) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Attempting to unregister the wrong listener");
            throw illegalArgumentException2;
        } else {
            this.mListener = null;
        }
    }

    public void unregisterOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        IllegalArgumentException illegalArgumentException;
        IllegalStateException illegalStateException;
        OnLoadCanceledListener<D> onLoadCanceledListener2 = onLoadCanceledListener;
        if (this.mOnLoadCanceledListener == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No listener register");
            throw illegalStateException2;
        } else if (this.mOnLoadCanceledListener != onLoadCanceledListener2) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Attempting to unregister the wrong listener");
            throw illegalArgumentException2;
        } else {
            this.mOnLoadCanceledListener = null;
        }
    }
}
