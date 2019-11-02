package android.support.p000v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: android.support.v4.content.ModernAsyncTask */
abstract class ModernAsyncTask<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor sDefaultExecutor = THREAD_POOL_EXECUTOR;
    private static InternalHandler sHandler;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    private final FutureTask<Result> mFuture;
    private volatile Status mStatus = Status.PENDING;
    /* access modifiers changed from: private */
    public final AtomicBoolean mTaskInvoked;
    private final WorkerRunnable<Params, Result> mWorker;

    /* renamed from: android.support.v4.content.ModernAsyncTask$AsyncTaskResult */
    private static class AsyncTaskResult<Data> {
        final Data[] mData;
        final ModernAsyncTask mTask;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            Data[] dataArr2 = dataArr;
            this.mTask = modernAsyncTask;
            this.mData = dataArr2;
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask$InternalHandler */
    private static class InternalHandler extends Handler {
        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            Message message2 = message;
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message2.obj;
            switch (message2.what) {
                case 1:
                    asyncTaskResult.mTask.finish(asyncTaskResult.mData[0]);
                    return;
                case 2:
                    asyncTaskResult.mTask.onProgressUpdate(asyncTaskResult.mData);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask$Status */
    public enum Status {
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask$WorkerRunnable */
    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        private WorkerRunnable() {
        }

        /* synthetic */ WorkerRunnable(C00361 r4) {
            C00361 r1 = r4;
            this();
        }
    }

    static {
        C00361 r9;
        LinkedBlockingQueue linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor;
        C00361 r0 = r9;
        C00361 r1 = new ThreadFactory() {
            private final AtomicInteger mCount;

            {
                AtomicInteger atomicInteger;
                AtomicInteger atomicInteger2 = atomicInteger;
                AtomicInteger atomicInteger3 = new AtomicInteger(1);
                this.mCount = atomicInteger2;
            }

            public Thread newThread(Runnable runnable) {
                Thread thread;
                StringBuilder sb;
                Thread thread2 = thread;
                Runnable runnable2 = runnable;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                Thread thread3 = new Thread(runnable2, sb2.append("ModernAsyncTask #").append(this.mCount.getAndIncrement()).toString());
                return thread2;
            }
        };
        sThreadFactory = r0;
        LinkedBlockingQueue linkedBlockingQueue2 = linkedBlockingQueue;
        LinkedBlockingQueue linkedBlockingQueue3 = new LinkedBlockingQueue(10);
        sPoolWorkQueue = linkedBlockingQueue2;
        ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        THREAD_POOL_EXECUTOR = threadPoolExecutor2;
    }

    public ModernAsyncTask() {
        AtomicBoolean atomicBoolean;
        C00372 r6;
        C00383 r62;
        AtomicBoolean atomicBoolean2 = atomicBoolean;
        AtomicBoolean atomicBoolean3 = new AtomicBoolean();
        this.mTaskInvoked = atomicBoolean2;
        C00372 r2 = r6;
        C00372 r3 = new WorkerRunnable<Params, Result>(this) {
            final /* synthetic */ ModernAsyncTask this$0;

            {
                this.this$0 = r5;
            }

            public Result call() throws Exception {
                this.this$0.mTaskInvoked.set(true);
                Process.setThreadPriority(10);
                return this.this$0.postResult(this.this$0.doInBackground(this.mParams));
            }
        };
        this.mWorker = r2;
        C00383 r22 = r62;
        C00383 r32 = new FutureTask<Result>(this, this.mWorker) {
            final /* synthetic */ ModernAsyncTask this$0;

            {
                Callable callable = r7;
                this.this$0 = r6;
            }

            /* access modifiers changed from: protected */
            public void done() {
                RuntimeException runtimeException;
                RuntimeException runtimeException2;
                try {
                    this.this$0.postResultIfNotInvoked(get());
                } catch (InterruptedException e) {
                    int w = Log.w(ModernAsyncTask.LOG_TAG, e);
                } catch (ExecutionException e2) {
                    ExecutionException executionException = e2;
                    RuntimeException runtimeException3 = runtimeException2;
                    RuntimeException runtimeException4 = new RuntimeException("An error occurred while executing doInBackground()", executionException.getCause());
                    throw runtimeException3;
                } catch (CancellationException e3) {
                    CancellationException cancellationException = e3;
                    this.this$0.postResultIfNotInvoked(null);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    RuntimeException runtimeException5 = runtimeException;
                    RuntimeException runtimeException6 = new RuntimeException("An error occurred while executing doInBackground()", th2);
                    throw runtimeException5;
                }
            }
        };
        this.mFuture = r22;
    }

    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    /* access modifiers changed from: private */
    public void finish(Result result) {
        Result result2 = result;
        if (isCancelled()) {
            onCancelled(result2);
        } else {
            onPostExecute(result2);
        }
        this.mStatus = Status.FINISHED;
    }

    private static Handler getHandler() {
        InternalHandler internalHandler;
        InternalHandler internalHandler2;
        synchronized (ModernAsyncTask.class) {
            try {
                if (sHandler == null) {
                    InternalHandler internalHandler3 = internalHandler2;
                    InternalHandler internalHandler4 = new InternalHandler();
                    sHandler = internalHandler3;
                }
                th = sHandler;
            } finally {
                internalHandler = th;
                Class<ModernAsyncTask> cls = ModernAsyncTask.class;
                Throwable th = internalHandler;
            }
        }
        return internalHandler;
    }

    /* access modifiers changed from: private */
    public Result postResult(Result result) {
        AsyncTaskResult asyncTaskResult;
        Result result2 = result;
        Handler handler = getHandler();
        AsyncTaskResult asyncTaskResult2 = asyncTaskResult;
        Object[] objArr = new Object[1];
        Object[] objArr2 = objArr;
        objArr[0] = result2;
        AsyncTaskResult asyncTaskResult3 = new AsyncTaskResult(this, objArr2);
        handler.obtainMessage(1, asyncTaskResult2).sendToTarget();
        return result2;
    }

    /* access modifiers changed from: private */
    public void postResultIfNotInvoked(Result result) {
        Result result2 = result;
        if (!this.mTaskInvoked.get()) {
            Object postResult = postResult(result2);
        }
    }

    public static void setDefaultExecutor(Executor executor) {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean z) {
        return this.mFuture.cancel(z);
    }

    /* access modifiers changed from: protected */
    public abstract Result doInBackground(Params... paramsArr);

    public final ModernAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2;
        Executor executor2 = executor;
        Params[] paramsArr2 = paramsArr;
        if (this.mStatus != Status.PENDING) {
            switch (this.mStatus) {
                case RUNNING:
                    IllegalStateException illegalStateException3 = illegalStateException2;
                    IllegalStateException illegalStateException4 = new IllegalStateException("Cannot execute task: the task is already running.");
                    throw illegalStateException3;
                case FINISHED:
                    IllegalStateException illegalStateException5 = illegalStateException;
                    IllegalStateException illegalStateException6 = new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                    throw illegalStateException5;
            }
        }
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = paramsArr2;
        executor2.execute(this.mFuture);
        return this;
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Result get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(j, timeUnit);
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mFuture.isCancelled();
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
    }

    /* access modifiers changed from: protected */
    public void onCancelled(Result result) {
        Result result2 = result;
        onCancelled();
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Progress... progressArr) {
    }

    /* access modifiers changed from: protected */
    public final void publishProgress(Progress... progressArr) {
        AsyncTaskResult asyncTaskResult;
        Progress[] progressArr2 = progressArr;
        if (!isCancelled()) {
            Handler handler = getHandler();
            AsyncTaskResult asyncTaskResult2 = asyncTaskResult;
            AsyncTaskResult asyncTaskResult3 = new AsyncTaskResult(this, progressArr2);
            handler.obtainMessage(2, asyncTaskResult2).sendToTarget();
        }
    }
}
