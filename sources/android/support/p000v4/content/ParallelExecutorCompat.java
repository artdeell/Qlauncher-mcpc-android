package android.support.p000v4.content;

import android.os.Build.VERSION;
import java.util.concurrent.Executor;

/* renamed from: android.support.v4.content.ParallelExecutorCompat */
public class ParallelExecutorCompat {
    public ParallelExecutorCompat() {
    }

    public static Executor getParallelExecutor() {
        return VERSION.SDK_INT >= 11 ? ExecutorCompatHoneycomb.getParallelExecutor() : ModernAsyncTask.THREAD_POOL_EXECUTOR;
    }
}
