package android.support.p000v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.support.p000v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;
import java.util.ArrayList;

/* renamed from: android.support.v4.media.TransportMediator */
public class TransportMediator extends TransportController {
    public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64;
    public static final int FLAG_KEY_MEDIA_NEXT = 128;
    public static final int FLAG_KEY_MEDIA_PAUSE = 16;
    public static final int FLAG_KEY_MEDIA_PLAY = 4;
    public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
    public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
    public static final int FLAG_KEY_MEDIA_REWIND = 2;
    public static final int FLAG_KEY_MEDIA_STOP = 32;
    public static final int KEYCODE_MEDIA_PAUSE = 127;
    public static final int KEYCODE_MEDIA_PLAY = 126;
    public static final int KEYCODE_MEDIA_RECORD = 130;
    final AudioManager mAudioManager;
    final TransportPerformer mCallbacks;
    final Context mContext;
    final TransportMediatorJellybeanMR2 mController;
    final Object mDispatcherState;
    final Callback mKeyEventCallback;
    final ArrayList<TransportStateListener> mListeners;
    final TransportMediatorCallback mTransportKeyCallback;
    final View mView;

    public TransportMediator(Activity activity, TransportPerformer transportPerformer) {
        this(activity, null, transportPerformer);
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r5v6, types: [android.content.Context] */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r6v6, types: [android.content.Context] */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: type inference failed for: r5v16, types: [android.app.Activity] */
    /* JADX WARNING: type inference failed for: r5v19 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TransportMediator(android.app.Activity r14, android.view.View r15, android.support.p000v4.media.TransportPerformer r16) {
        /*
            r13 = this;
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r0
            r5.<init>()
            r5 = r0
            java.util.ArrayList r6 = new java.util.ArrayList
            r12 = r6
            r6 = r12
            r7 = r12
            r7.<init>()
            r5.mListeners = r6
            r5 = r0
            android.support.v4.media.TransportMediator$1 r6 = new android.support.v4.media.TransportMediator$1
            r12 = r6
            r6 = r12
            r7 = r12
            r8 = r0
            r7.<init>(r8)
            r5.mTransportKeyCallback = r6
            r5 = r0
            android.support.v4.media.TransportMediator$2 r6 = new android.support.v4.media.TransportMediator$2
            r12 = r6
            r6 = r12
            r7 = r12
            r8 = r0
            r7.<init>(r8)
            r5.mKeyEventCallback = r6
            r5 = r1
            if (r5 == 0) goto L_0x0080
            r5 = r1
            r4 = r5
        L_0x0031:
            r5 = r0
            r6 = r4
            r5.mContext = r6
            r5 = r0
            r6 = r3
            r5.mCallbacks = r6
            r5 = r0
            r6 = r0
            android.content.Context r6 = r6.mContext
            java.lang.String r7 = "audio"
            java.lang.Object r6 = r6.getSystemService(r7)
            android.media.AudioManager r6 = (android.media.AudioManager) r6
            r5.mAudioManager = r6
            r5 = r1
            if (r5 == 0) goto L_0x0054
            r5 = r1
            android.view.Window r5 = r5.getWindow()
            android.view.View r5 = r5.getDecorView()
            r2 = r5
        L_0x0054:
            r5 = r0
            r6 = r2
            r5.mView = r6
            r5 = r0
            r6 = r0
            android.view.View r6 = r6.mView
            java.lang.Object r6 = android.support.p000v4.view.KeyEventCompat.getKeyDispatcherState(r6)
            r5.mDispatcherState = r6
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 18
            if (r5 < r6) goto L_0x0087
            r5 = r0
            android.support.v4.media.TransportMediatorJellybeanMR2 r6 = new android.support.v4.media.TransportMediatorJellybeanMR2
            r12 = r6
            r6 = r12
            r7 = r12
            r8 = r0
            android.content.Context r8 = r8.mContext
            r9 = r0
            android.media.AudioManager r9 = r9.mAudioManager
            r10 = r0
            android.view.View r10 = r10.mView
            r11 = r0
            android.support.v4.media.TransportMediatorCallback r11 = r11.mTransportKeyCallback
            r7.<init>(r8, r9, r10, r11)
            r5.mController = r6
        L_0x007f:
            return
        L_0x0080:
            r5 = r2
            android.content.Context r5 = r5.getContext()
            r4 = r5
            goto L_0x0031
        L_0x0087:
            r5 = r0
            r6 = 0
            r5.mController = r6
            goto L_0x007f
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.media.TransportMediator.<init>(android.app.Activity, android.view.View, android.support.v4.media.TransportPerformer):void");
    }

    public TransportMediator(View view, TransportPerformer transportPerformer) {
        this(null, view, transportPerformer);
    }

    private TransportStateListener[] getListeners() {
        if (this.mListeners.size() <= 0) {
            return null;
        }
        TransportStateListener[] transportStateListenerArr = new TransportStateListener[this.mListeners.size()];
        Object[] array = this.mListeners.toArray(transportStateListenerArr);
        return transportStateListenerArr;
    }

    static boolean isMediaKey(int i) {
        switch (i) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 126:
            case 127:
            case 130:
                return true;
            default:
                return false;
        }
    }

    private void pushControllerState() {
        if (this.mController != null) {
            this.mController.refreshState(this.mCallbacks.onIsPlaying(), this.mCallbacks.onGetCurrentPosition(), this.mCallbacks.onGetTransportControlFlags());
        }
    }

    private void reportPlayingChanged() {
        TransportStateListener[] listeners = getListeners();
        if (listeners != null) {
            int length = listeners.length;
            for (int i = 0; i < length; i++) {
                listeners[i].onPlayingChanged(this);
            }
        }
    }

    private void reportTransportControlsChanged() {
        TransportStateListener[] listeners = getListeners();
        if (listeners != null) {
            int length = listeners.length;
            for (int i = 0; i < length; i++) {
                listeners[i].onTransportControlsChanged(this);
            }
        }
    }

    public void destroy() {
        this.mController.destroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventCompat.dispatch(keyEvent, this.mKeyEventCallback, this.mDispatcherState, this);
    }

    public int getBufferPercentage() {
        return this.mCallbacks.onGetBufferPercentage();
    }

    public long getCurrentPosition() {
        return this.mCallbacks.onGetCurrentPosition();
    }

    public long getDuration() {
        return this.mCallbacks.onGetDuration();
    }

    public Object getRemoteControlClient() {
        if (this.mController != null) {
            return this.mController.getRemoteControlClient();
        }
        return null;
    }

    public int getTransportControlFlags() {
        return this.mCallbacks.onGetTransportControlFlags();
    }

    public boolean isPlaying() {
        return this.mCallbacks.onIsPlaying();
    }

    public void pausePlaying() {
        if (this.mController != null) {
            this.mController.pausePlaying();
        }
        this.mCallbacks.onPause();
        pushControllerState();
        reportPlayingChanged();
    }

    public void refreshState() {
        pushControllerState();
        reportPlayingChanged();
        reportTransportControlsChanged();
    }

    public void registerStateListener(TransportStateListener transportStateListener) {
        TransportStateListener transportStateListener2 = transportStateListener;
        boolean add = this.mListeners.add(transportStateListener2);
    }

    public void seekTo(long j) {
        long j2 = j;
        this.mCallbacks.onSeekTo(j2);
    }

    public void startPlaying() {
        if (this.mController != null) {
            this.mController.startPlaying();
        }
        this.mCallbacks.onStart();
        pushControllerState();
        reportPlayingChanged();
    }

    public void stopPlaying() {
        if (this.mController != null) {
            this.mController.stopPlaying();
        }
        this.mCallbacks.onStop();
        pushControllerState();
        reportPlayingChanged();
    }

    public void unregisterStateListener(TransportStateListener transportStateListener) {
        TransportStateListener transportStateListener2 = transportStateListener;
        boolean remove = this.mListeners.remove(transportStateListener2);
    }
}
