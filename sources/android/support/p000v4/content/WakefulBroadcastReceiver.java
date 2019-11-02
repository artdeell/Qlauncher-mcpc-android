package android.support.p000v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

/* renamed from: android.support.v4.content.WakefulBroadcastReceiver */
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final String EXTRA_WAKE_LOCK_ID = "android.support.content.wakelockid";
    private static final SparseArray<WakeLock> mActiveWakeLocks;
    private static int mNextId = 1;

    static {
        SparseArray<WakeLock> sparseArray;
        SparseArray<WakeLock> sparseArray2 = sparseArray;
        SparseArray<WakeLock> sparseArray3 = new SparseArray<>();
        mActiveWakeLocks = sparseArray2;
    }

    public WakefulBroadcastReceiver() {
    }

    public static boolean completeWakefulIntent(Intent intent) {
        StringBuilder sb;
        int intExtra = intent.getIntExtra(EXTRA_WAKE_LOCK_ID, 0);
        if (intExtra == 0) {
            return false;
        }
        SparseArray<WakeLock> sparseArray = mActiveWakeLocks;
        synchronized (sparseArray) {
            try {
                WakeLock wakeLock = (WakeLock) mActiveWakeLocks.get(intExtra);
                if (wakeLock != null) {
                    wakeLock.release();
                    mActiveWakeLocks.remove(intExtra);
                    return true;
                }
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int w = Log.w("WakefulBroadcastReceiver", sb2.append("No active wake lock id #").append(intExtra).toString());
                return true;
            } catch (Throwable th) {
                Throwable th2 = th;
                SparseArray<WakeLock> sparseArray2 = sparseArray;
                throw th2;
            }
        }
    }

    public static ComponentName startWakefulService(Context context, Intent intent) {
        StringBuilder sb;
        Context context2 = context;
        Intent intent2 = intent;
        ComponentName componentName = mActiveWakeLocks;
        synchronized (componentName) {
            try {
                int i = mNextId;
                mNextId = 1 + mNextId;
                if (mNextId <= 0) {
                    mNextId = 1;
                }
                Intent putExtra = intent2.putExtra(EXTRA_WAKE_LOCK_ID, i);
                th = context2.startService(intent2);
                if (componentName == null) {
                    return null;
                }
                PowerManager powerManager = (PowerManager) context2.getSystemService("power");
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                WakeLock newWakeLock = powerManager.newWakeLock(1, sb2.append("wake:").append(componentName.flattenToShortString()).toString());
                newWakeLock.setReferenceCounted(false);
                newWakeLock.acquire(60000);
                mActiveWakeLocks.put(i, newWakeLock);
                return componentName;
            } finally {
                Throwable th = th;
                ComponentName componentName2 = componentName;
                Throwable th2 = th;
            }
        }
    }
}
