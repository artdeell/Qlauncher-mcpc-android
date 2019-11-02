package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class zza implements ServiceConnection {
    private final BlockingQueue<IBinder> zzafA;
    boolean zzafz = false;

    public zza() {
        LinkedBlockingQueue linkedBlockingQueue;
        LinkedBlockingQueue linkedBlockingQueue2 = linkedBlockingQueue;
        LinkedBlockingQueue linkedBlockingQueue3 = new LinkedBlockingQueue();
        this.zzafA = linkedBlockingQueue2;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ComponentName componentName2 = componentName;
        IBinder iBinder2 = iBinder;
        boolean add = this.zzafA.add(iBinder2);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    public IBinder zzoJ() throws InterruptedException {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            IllegalStateException illegalStateException3 = illegalStateException2;
            IllegalStateException illegalStateException4 = new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
            throw illegalStateException3;
        } else if (this.zzafz) {
            IllegalStateException illegalStateException5 = illegalStateException;
            IllegalStateException illegalStateException6 = new IllegalStateException();
            throw illegalStateException5;
        } else {
            this.zzafz = true;
            return (IBinder) this.zzafA.take();
        }
    }
}
