package android.support.p000v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.os.SystemClock;
import android.util.Log;

/* renamed from: android.support.v4.media.session.MediaSessionCompatApi18 */
class MediaSessionCompatApi18 {
    private static final long ACTION_SEEK_TO = 256;
    private static final String TAG = "MediaSessionCompatApi18";
    private static boolean sIsMbrPendingIntentSupported = true;

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi18$OnPlaybackPositionUpdateListener */
    static class OnPlaybackPositionUpdateListener<T extends Callback> implements android.media.RemoteControlClient.OnPlaybackPositionUpdateListener {
        protected final T mCallback;

        public OnPlaybackPositionUpdateListener(T t) {
            this.mCallback = t;
        }

        public void onPlaybackPositionUpdate(long j) {
            long j2 = j;
            this.mCallback.onSeekTo(j2);
        }
    }

    MediaSessionCompatApi18() {
    }

    public static Object createPlaybackPositionUpdateListener(Callback callback) {
        OnPlaybackPositionUpdateListener onPlaybackPositionUpdateListener;
        OnPlaybackPositionUpdateListener onPlaybackPositionUpdateListener2 = onPlaybackPositionUpdateListener;
        OnPlaybackPositionUpdateListener onPlaybackPositionUpdateListener3 = new OnPlaybackPositionUpdateListener(callback);
        return onPlaybackPositionUpdateListener2;
    }

    static int getRccTransportControlFlagsFromActions(long j) {
        long j2 = j;
        int rccTransportControlFlagsFromActions = MediaSessionCompatApi14.getRccTransportControlFlagsFromActions(j2);
        if ((256 & j2) != 0) {
            rccTransportControlFlagsFromActions |= 256;
        }
        return rccTransportControlFlagsFromActions;
    }

    public static void registerMediaButtonEventReceiver(Context context, PendingIntent pendingIntent, ComponentName componentName) {
        PendingIntent pendingIntent2 = pendingIntent;
        ComponentName componentName2 = componentName;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (sIsMbrPendingIntentSupported) {
            try {
                audioManager.registerMediaButtonEventReceiver(pendingIntent2);
            } catch (NullPointerException e) {
                NullPointerException nullPointerException = e;
                int w = Log.w(TAG, "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                sIsMbrPendingIntentSupported = false;
            }
        }
        if (!sIsMbrPendingIntentSupported) {
            audioManager.registerMediaButtonEventReceiver(componentName2);
        }
    }

    public static void setOnPlaybackPositionUpdateListener(Object obj, Object obj2) {
        ((RemoteControlClient) obj).setPlaybackPositionUpdateListener((android.media.RemoteControlClient.OnPlaybackPositionUpdateListener) obj2);
    }

    public static void setState(Object obj, int i, long j, float f, long j2) {
        Object obj2 = obj;
        int i2 = i;
        long j3 = j;
        float f2 = f;
        long j4 = j2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (i2 == 3 && j3 > 0) {
            long j5 = 0;
            if (j4 > 0) {
                j5 = elapsedRealtime - j4;
                if (f2 > 0.0f && f2 != 1.0f) {
                    j5 = (long) (f2 * ((float) j5));
                }
            }
            j3 += j5;
        }
        ((RemoteControlClient) obj2).setPlaybackState(MediaSessionCompatApi14.getRccStateFromState(i2), j3, f2);
    }

    public static void setTransportControlFlags(Object obj, long j) {
        ((RemoteControlClient) obj).setTransportControlFlags(getRccTransportControlFlagsFromActions(j));
    }

    public static void unregisterMediaButtonEventReceiver(Context context, PendingIntent pendingIntent, ComponentName componentName) {
        PendingIntent pendingIntent2 = pendingIntent;
        ComponentName componentName2 = componentName;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (sIsMbrPendingIntentSupported) {
            audioManager.unregisterMediaButtonEventReceiver(pendingIntent2);
        } else {
            audioManager.unregisterMediaButtonEventReceiver(componentName2);
        }
    }
}
