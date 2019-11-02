package android.support.p000v4.p002os;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.os.CancellationSignal */
public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    /* renamed from: android.support.v4.os.CancellationSignal$OnCancelListener */
    public interface OnCancelListener {
        void onCancel();
    }

    public CancellationSignal() {
    }

    private void waitForCancelFinishedLocked() {
        while (this.mCancelInProgress) {
            try {
                wait();
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r2 == null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2.onCancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        if (r3 == null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
        android.support.p000v4.p002os.CancellationSignalCompatJellybean.cancel(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0.mCancelInProgress = false;
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0038, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0039, code lost:
        r6 = r7;
        r7 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003d, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0044, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0045, code lost:
        r4 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0047, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r0.mCancelInProgress = false;
        notifyAll();
        r7 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0053, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0054, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0055, code lost:
        r5 = r7;
        r7 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0059, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r9 = this;
            r0 = r9
            r7 = r0
            monitor-enter(r7)
            r7 = r0
            boolean r7 = r7.mIsCanceled     // Catch:{ all -> 0x003e }
            if (r7 == 0) goto L_0x000b
            r7 = r0
            monitor-exit(r7)     // Catch:{ all -> 0x003e }
        L_0x000a:
            return
        L_0x000b:
            r7 = r0
            r8 = 1
            r7.mIsCanceled = r8     // Catch:{ all -> 0x003e }
            r7 = r0
            r8 = 1
            r7.mCancelInProgress = r8     // Catch:{ all -> 0x003e }
            r7 = r0
            android.support.v4.os.CancellationSignal$OnCancelListener r7 = r7.mOnCancelListener     // Catch:{ all -> 0x003e }
            r2 = r7
            r7 = r0
            java.lang.Object r7 = r7.mCancellationSignalObj     // Catch:{ all -> 0x003e }
            r3 = r7
            r7 = r0
            monitor-exit(r7)     // Catch:{ all -> 0x003e }
            r7 = r2
            if (r7 == 0) goto L_0x0024
            r7 = r2
            r7.onCancel()     // Catch:{ all -> 0x0044 }
        L_0x0024:
            r7 = r3
            if (r7 == 0) goto L_0x002b
            r7 = r3
            android.support.p000v4.p002os.CancellationSignalCompatJellybean.cancel(r7)     // Catch:{ all -> 0x0044 }
        L_0x002b:
            r7 = r0
            monitor-enter(r7)
            r7 = r0
            r8 = 0
            r7.mCancelInProgress = r8     // Catch:{ all -> 0x0038 }
            r7 = r0
            r7.notifyAll()     // Catch:{ all -> 0x0038 }
            r7 = r0
            monitor-exit(r7)     // Catch:{ all -> 0x0038 }
            goto L_0x000a
        L_0x0038:
            r7 = move-exception
            r6 = r7
            r7 = r0
            monitor-exit(r7)     // Catch:{ all -> 0x0038 }
            r7 = r6
            throw r7
        L_0x003e:
            r7 = move-exception
            r1 = r7
            r7 = r0
            monitor-exit(r7)     // Catch:{ all -> 0x003e }
            r7 = r1
            throw r7
        L_0x0044:
            r7 = move-exception
            r4 = r7
            r7 = r0
            monitor-enter(r7)
            r7 = r0
            r8 = 0
            r7.mCancelInProgress = r8     // Catch:{ all -> 0x0054 }
            r7 = r0
            r7.notifyAll()     // Catch:{ all -> 0x0054 }
            r7 = r0
            monitor-exit(r7)     // Catch:{ all -> 0x0054 }
            r7 = r4
            throw r7
        L_0x0054:
            r7 = move-exception
            r5 = r7
            r7 = r0
            monitor-exit(r7)     // Catch:{ all -> 0x0054 }
            r7 = r5
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.p002os.CancellationSignal.cancel():void");
    }

    public Object getCancellationSignalObject() {
        Object obj;
        if (VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            try {
                if (this.mCancellationSignalObj == null) {
                    this.mCancellationSignalObj = CancellationSignalCompatJellybean.create();
                    if (this.mIsCanceled) {
                        CancellationSignalCompatJellybean.cancel(this.mCancellationSignalObj);
                    }
                }
                th = this.mCancellationSignalObj;
            } finally {
                obj = th;
                Throwable th = obj;
            }
        }
        return obj;
    }

    public boolean isCanceled() {
        synchronized (this) {
            try {
                th = this.mIsCanceled;
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return th;
    }

    /* JADX INFO: finally extract failed */
    public void setOnCancelListener(OnCancelListener onCancelListener) {
        OnCancelListener onCancelListener2 = onCancelListener;
        synchronized (this) {
            try {
                waitForCancelFinishedLocked();
                if (this.mOnCancelListener != onCancelListener2) {
                    this.mOnCancelListener = onCancelListener2;
                    if (this.mIsCanceled && onCancelListener2 != null) {
                        onCancelListener2.onCancel();
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void throwIfCanceled() {
        OperationCanceledException operationCanceledException;
        if (isCanceled()) {
            OperationCanceledException operationCanceledException2 = operationCanceledException;
            OperationCanceledException operationCanceledException3 = new OperationCanceledException();
            throw operationCanceledException2;
        }
    }
}
