package android.support.p000v4.media;

import android.os.SystemClock;
import android.view.KeyEvent;

/* renamed from: android.support.v4.media.TransportPerformer */
public abstract class TransportPerformer {
    static final int AUDIOFOCUS_GAIN = 1;
    static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    static final int AUDIOFOCUS_LOSS = -1;
    static final int AUDIOFOCUS_LOSS_TRANSIENT = -2;
    static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;

    public TransportPerformer() {
    }

    public void onAudioFocusChange(int i) {
        KeyEvent keyEvent;
        KeyEvent keyEvent2;
        int i2 = 0;
        switch (i) {
            case -1:
                i2 = 127;
                break;
        }
        if (i2 != 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i3 = i2;
            KeyEvent keyEvent3 = keyEvent;
            KeyEvent keyEvent4 = new KeyEvent(uptimeMillis, uptimeMillis, 0, i2, 0);
            boolean onMediaButtonDown = onMediaButtonDown(i3, keyEvent3);
            int i4 = i2;
            KeyEvent keyEvent5 = keyEvent2;
            KeyEvent keyEvent6 = new KeyEvent(uptimeMillis, uptimeMillis, 1, i2, 0);
            boolean onMediaButtonUp = onMediaButtonUp(i4, keyEvent5);
        }
    }

    public int onGetBufferPercentage() {
        return 100;
    }

    public abstract long onGetCurrentPosition();

    public abstract long onGetDuration();

    public int onGetTransportControlFlags() {
        return 60;
    }

    public abstract boolean onIsPlaying();

    public boolean onMediaButtonDown(int i, KeyEvent keyEvent) {
        KeyEvent keyEvent2 = keyEvent;
        switch (i) {
            case 79:
            case 85:
                if (onIsPlaying()) {
                    onPause();
                    return true;
                }
                onStart();
                return true;
            case 86:
                onStop();
                return true;
            case 126:
                onStart();
                return true;
            case 127:
                onPause();
                return true;
            default:
                return true;
        }
    }

    public boolean onMediaButtonUp(int i, KeyEvent keyEvent) {
        int i2 = i;
        KeyEvent keyEvent2 = keyEvent;
        return true;
    }

    public abstract void onPause();

    public abstract void onSeekTo(long j);

    public abstract void onStart();

    public abstract void onStop();
}
