package android.support.p000v4.p002os;

import android.os.AsyncTask;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.os.AsyncTaskCompat */
public class AsyncTaskCompat {
    public AsyncTaskCompat() {
    }

    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> executeParallel(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        IllegalArgumentException illegalArgumentException;
        AsyncTask<Params, Progress, Result> asyncTask2 = asyncTask;
        Params[] paramsArr2 = paramsArr;
        if (asyncTask2 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("task can not be null");
            throw illegalArgumentException2;
        } else if (VERSION.SDK_INT >= 11) {
            AsyncTaskCompatHoneycomb.executeParallel(asyncTask2, paramsArr2);
            return asyncTask2;
        } else {
            AsyncTask execute = asyncTask2.execute(paramsArr2);
            return asyncTask2;
        }
    }
}
