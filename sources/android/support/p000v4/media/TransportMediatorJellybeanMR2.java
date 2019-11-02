package android.support.p000v4.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.OnGetPlaybackPositionListener;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnWindowAttachListener;
import android.view.ViewTreeObserver.OnWindowFocusChangeListener;

/* renamed from: android.support.v4.media.TransportMediatorJellybeanMR2 */
class TransportMediatorJellybeanMR2 {
    OnAudioFocusChangeListener mAudioFocusChangeListener;
    boolean mAudioFocused;
    final AudioManager mAudioManager;
    final Context mContext;
    boolean mFocused;
    final OnGetPlaybackPositionListener mGetPlaybackPositionListener;
    final Intent mIntent;
    final BroadcastReceiver mMediaButtonReceiver;
    PendingIntent mPendingIntent;
    int mPlayState = 0;
    final OnPlaybackPositionUpdateListener mPlaybackPositionUpdateListener;
    final String mReceiverAction;
    final IntentFilter mReceiverFilter;
    RemoteControlClient mRemoteControl;
    final View mTargetView;
    final TransportMediatorCallback mTransportCallback;
    final OnWindowAttachListener mWindowAttachListener;
    final OnWindowFocusChangeListener mWindowFocusListener;

    public TransportMediatorJellybeanMR2(Context context, AudioManager audioManager, View view, TransportMediatorCallback transportMediatorCallback) {
        C00661 r9;
        C00672 r92;
        C00683 r93;
        C00694 r94;
        C00705 r95;
        C00716 r96;
        StringBuilder sb;
        Intent intent;
        IntentFilter intentFilter;
        Context context2 = context;
        AudioManager audioManager2 = audioManager;
        View view2 = view;
        TransportMediatorCallback transportMediatorCallback2 = transportMediatorCallback;
        C00661 r6 = r9;
        C00661 r7 = new OnWindowAttachListener(this) {
            final /* synthetic */ TransportMediatorJellybeanMR2 this$0;

            {
                this.this$0 = r5;
            }

            public void onWindowAttached() {
                this.this$0.windowAttached();
            }

            public void onWindowDetached() {
                this.this$0.windowDetached();
            }
        };
        this.mWindowAttachListener = r6;
        C00672 r62 = r92;
        C00672 r72 = new OnWindowFocusChangeListener(this) {
            final /* synthetic */ TransportMediatorJellybeanMR2 this$0;

            {
                this.this$0 = r5;
            }

            public void onWindowFocusChanged(boolean z) {
                if (z) {
                    this.this$0.gainFocus();
                } else {
                    this.this$0.loseFocus();
                }
            }
        };
        this.mWindowFocusListener = r62;
        C00683 r63 = r93;
        C00683 r73 = new BroadcastReceiver(this) {
            final /* synthetic */ TransportMediatorJellybeanMR2 this$0;

            {
                this.this$0 = r5;
            }

            public void onReceive(Context context, Intent intent) {
                Context context2 = context;
                try {
                    this.this$0.mTransportCallback.handleKey((KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
                } catch (ClassCastException e) {
                    int w = Log.w("TransportController", e);
                }
            }
        };
        this.mMediaButtonReceiver = r63;
        C00694 r64 = r94;
        C00694 r74 = new OnAudioFocusChangeListener(this) {
            final /* synthetic */ TransportMediatorJellybeanMR2 this$0;

            {
                this.this$0 = r5;
            }

            public void onAudioFocusChange(int i) {
                int i2 = i;
                this.this$0.mTransportCallback.handleAudioFocusChange(i2);
            }
        };
        this.mAudioFocusChangeListener = r64;
        C00705 r65 = r95;
        C00705 r75 = new OnGetPlaybackPositionListener(this) {
            final /* synthetic */ TransportMediatorJellybeanMR2 this$0;

            {
                this.this$0 = r5;
            }

            public long onGetPlaybackPosition() {
                return this.this$0.mTransportCallback.getPlaybackPosition();
            }
        };
        this.mGetPlaybackPositionListener = r65;
        C00716 r66 = r96;
        C00716 r76 = new OnPlaybackPositionUpdateListener(this) {
            final /* synthetic */ TransportMediatorJellybeanMR2 this$0;

            {
                this.this$0 = r5;
            }

            public void onPlaybackPositionUpdate(long j) {
                long j2 = j;
                this.this$0.mTransportCallback.playbackPositionUpdate(j2);
            }
        };
        this.mPlaybackPositionUpdateListener = r66;
        this.mContext = context2;
        this.mAudioManager = audioManager2;
        this.mTargetView = view2;
        this.mTransportCallback = transportMediatorCallback2;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        this.mReceiverAction = sb2.append(context2.getPackageName()).append(":transport:").append(System.identityHashCode(this)).toString();
        Intent intent2 = intent;
        Intent intent3 = new Intent(this.mReceiverAction);
        this.mIntent = intent2;
        Intent intent4 = this.mIntent.setPackage(context2.getPackageName());
        IntentFilter intentFilter2 = intentFilter;
        IntentFilter intentFilter3 = new IntentFilter();
        this.mReceiverFilter = intentFilter2;
        this.mReceiverFilter.addAction(this.mReceiverAction);
        this.mTargetView.getViewTreeObserver().addOnWindowAttachListener(this.mWindowAttachListener);
        this.mTargetView.getViewTreeObserver().addOnWindowFocusChangeListener(this.mWindowFocusListener);
    }

    public void destroy() {
        windowDetached();
        this.mTargetView.getViewTreeObserver().removeOnWindowAttachListener(this.mWindowAttachListener);
        this.mTargetView.getViewTreeObserver().removeOnWindowFocusChangeListener(this.mWindowFocusListener);
    }

    /* access modifiers changed from: 0000 */
    public void dropAudioFocus() {
        if (this.mAudioFocused) {
            this.mAudioFocused = false;
            int abandonAudioFocus = this.mAudioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
        }
    }

    /* access modifiers changed from: 0000 */
    public void gainFocus() {
        if (!this.mFocused) {
            this.mFocused = true;
            this.mAudioManager.registerMediaButtonEventReceiver(this.mPendingIntent);
            this.mAudioManager.registerRemoteControlClient(this.mRemoteControl);
            if (this.mPlayState == 3) {
                takeAudioFocus();
            }
        }
    }

    public Object getRemoteControlClient() {
        return this.mRemoteControl;
    }

    /* access modifiers changed from: 0000 */
    public void loseFocus() {
        dropAudioFocus();
        if (this.mFocused) {
            this.mFocused = false;
            this.mAudioManager.unregisterRemoteControlClient(this.mRemoteControl);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.mPendingIntent);
        }
    }

    public void pausePlaying() {
        if (this.mPlayState == 3) {
            this.mPlayState = 2;
            this.mRemoteControl.setPlaybackState(2);
        }
        dropAudioFocus();
    }

    public void refreshState(boolean z, long j, int i) {
        boolean z2 = z;
        long j2 = j;
        int i2 = i;
        if (this.mRemoteControl != null) {
            this.mRemoteControl.setPlaybackState(z2 ? 3 : 1, j2, z2 ? 1.0f : 0.0f);
            this.mRemoteControl.setTransportControlFlags(i2);
        }
    }

    public void startPlaying() {
        if (this.mPlayState != 3) {
            this.mPlayState = 3;
            this.mRemoteControl.setPlaybackState(3);
        }
        if (this.mFocused) {
            takeAudioFocus();
        }
    }

    public void stopPlaying() {
        if (this.mPlayState != 1) {
            this.mPlayState = 1;
            this.mRemoteControl.setPlaybackState(1);
        }
        dropAudioFocus();
    }

    /* access modifiers changed from: 0000 */
    public void takeAudioFocus() {
        if (!this.mAudioFocused) {
            this.mAudioFocused = true;
            int requestAudioFocus = this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1);
        }
    }

    /* access modifiers changed from: 0000 */
    public void windowAttached() {
        RemoteControlClient remoteControlClient;
        Intent registerReceiver = this.mContext.registerReceiver(this.mMediaButtonReceiver, this.mReceiverFilter);
        this.mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, this.mIntent, 268435456);
        RemoteControlClient remoteControlClient2 = remoteControlClient;
        RemoteControlClient remoteControlClient3 = new RemoteControlClient(this.mPendingIntent);
        this.mRemoteControl = remoteControlClient2;
        this.mRemoteControl.setOnGetPlaybackPositionListener(this.mGetPlaybackPositionListener);
        this.mRemoteControl.setPlaybackPositionUpdateListener(this.mPlaybackPositionUpdateListener);
    }

    /* access modifiers changed from: 0000 */
    public void windowDetached() {
        loseFocus();
        if (this.mPendingIntent != null) {
            this.mContext.unregisterReceiver(this.mMediaButtonReceiver);
            this.mPendingIntent.cancel();
            this.mPendingIntent = null;
            this.mRemoteControl = null;
        }
    }
}
