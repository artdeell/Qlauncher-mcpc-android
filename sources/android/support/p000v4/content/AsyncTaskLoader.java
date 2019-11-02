package android.support.p000v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.p000v4.p002os.OperationCanceledException;
import android.support.p000v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* renamed from: android.support.v4.content.AsyncTaskLoader */
public abstract class AsyncTaskLoader<D> extends Loader<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile LoadTask mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile LoadTask mTask;
    long mUpdateThrottle;

    /* renamed from: android.support.v4.content.AsyncTaskLoader$LoadTask */
    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        private final CountDownLatch mDone;
        final /* synthetic */ AsyncTaskLoader this$0;
        boolean waiting;

        LoadTask(AsyncTaskLoader asyncTaskLoader) {
            CountDownLatch countDownLatch;
            this.this$0 = asyncTaskLoader;
            CountDownLatch countDownLatch2 = countDownLatch;
            CountDownLatch countDownLatch3 = new CountDownLatch(1);
            this.mDone = countDownLatch2;
        }

        /* access modifiers changed from: protected */
        public D doInBackground(Void... voidArr) {
            Void[] voidArr2 = voidArr;
            try {
                return this.this$0.onLoadInBackground();
            } catch (OperationCanceledException e) {
                OperationCanceledException operationCanceledException = e;
                if (isCancelled()) {
                    return null;
                }
                throw operationCanceledException;
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled(D d) {
            try {
                this.this$0.dispatchOnCancelled(this, d);
                this.mDone.countDown();
            } catch (Throwable th) {
                Throwable th2 = th;
                this.mDone.countDown();
                throw th2;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(D d) {
            try {
                this.this$0.dispatchOnLoadComplete(this, d);
                this.mDone.countDown();
            } catch (Throwable th) {
                Throwable th2 = th;
                this.mDone.countDown();
                throw th2;
            }
        }

        public void run() {
            this.waiting = false;
            this.this$0.executePendingTask();
        }

        public void waitForLoader() {
            try {
                this.mDone.await();
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
            }
        }
    }

    public AsyncTaskLoader(Context context) {
        this(context, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    private AsyncTaskLoader(Context context, Executor executor) {
        Executor executor2 = executor;
        super(context);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = executor2;
    }

    public void cancelLoadInBackground() {
    }

    /* access modifiers changed from: 0000 */
    public void dispatchOnCancelled(LoadTask loadTask, D d) {
        LoadTask loadTask2 = loadTask;
        onCanceled(d);
        if (this.mCancellingTask == loadTask2) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    /* access modifiers changed from: 0000 */
    public void dispatchOnLoadComplete(LoadTask loadTask, D d) {
        LoadTask loadTask2 = loadTask;
        D d2 = d;
        if (this.mTask != loadTask2) {
            dispatchOnCancelled(loadTask2, d2);
        } else if (isAbandoned()) {
            onCanceled(d2);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(d2);
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str;
        PrintWriter printWriter2 = printWriter;
        super.dump(str2, fileDescriptor, printWriter2, strArr);
        if (this.mTask != null) {
            printWriter2.print(str2);
            printWriter2.print("mTask=");
            printWriter2.print(this.mTask);
            printWriter2.print(" waiting=");
            printWriter2.println(this.mTask.waiting);
        }
        if (this.mCancellingTask != null) {
            printWriter2.print(str2);
            printWriter2.print("mCancellingTask=");
            printWriter2.print(this.mCancellingTask);
            printWriter2.print(" waiting=");
            printWriter2.println(this.mCancellingTask.waiting);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter2.print(str2);
            printWriter2.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.mUpdateThrottle, printWriter2);
            printWriter2.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter2);
            printWriter2.println();
        }
    }

    /* access modifiers changed from: 0000 */
    public void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.waiting) {
                this.mTask.waiting = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                ModernAsyncTask executeOnExecutor = this.mTask.executeOnExecutor(this.mExecutor, null);
                return;
            }
            this.mTask.waiting = true;
            boolean postAtTime = this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public abstract D loadInBackground();

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        if (this.mTask != null) {
            if (this.mCancellingTask != null) {
                if (this.mTask.waiting) {
                    this.mTask.waiting = false;
                    this.mHandler.removeCallbacks(this.mTask);
                }
                this.mTask = null;
            } else if (this.mTask.waiting) {
                this.mTask.waiting = false;
                this.mHandler.removeCallbacks(this.mTask);
                this.mTask = null;
                return false;
            } else {
                boolean cancel = this.mTask.cancel(false);
                if (cancel) {
                    this.mCancellingTask = this.mTask;
                    cancelLoadInBackground();
                }
                this.mTask = null;
                return cancel;
            }
        }
        return false;
    }

    public void onCanceled(D d) {
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
        LoadTask loadTask;
        super.onForceLoad();
        boolean cancelLoad = cancelLoad();
        LoadTask loadTask2 = loadTask;
        LoadTask loadTask3 = new LoadTask<>(this);
        this.mTask = loadTask2;
        executePendingTask();
    }

    /* access modifiers changed from: protected */
    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j) {
        Handler handler;
        long j2 = j;
        this.mUpdateThrottle = j2;
        if (j2 != 0) {
            Handler handler2 = handler;
            Handler handler3 = new Handler();
            this.mHandler = handler2;
        }
    }

    public void waitForLoader() {
        LoadTask loadTask = this.mTask;
        if (loadTask != null) {
            loadTask.waitForLoader();
        }
    }
}
