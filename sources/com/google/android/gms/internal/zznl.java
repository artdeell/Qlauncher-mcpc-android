package com.google.android.gms.internal;

import android.os.Process;

class zznl implements Runnable {
    private final int mPriority;
    private final Runnable zzx;

    public zznl(Runnable runnable, int i) {
        int i2 = i;
        this.zzx = runnable;
        this.mPriority = i2;
    }

    public void run() {
        Process.setThreadPriority(this.mPriority);
        this.zzx.run();
    }
}
