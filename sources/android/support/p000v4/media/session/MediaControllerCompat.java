package android.support.p000v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.p000v4.media.MediaMetadataCompat;
import android.support.p000v4.media.RatingCompat;
import android.support.p000v4.media.session.IMediaControllerCallback.Stub;
import android.support.p000v4.media.session.MediaSessionCompat.QueueItem;
import android.support.p000v4.media.session.MediaSessionCompat.Token;
import android.support.p000v4.media.session.PlaybackStateCompat.CustomAction;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaControllerCompat */
public final class MediaControllerCompat {
    private static final String TAG = "MediaControllerCompat";
    private final MediaControllerImpl mImpl;
    private final Token mToken;

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback */
    public static abstract class Callback implements DeathRecipient {
        /* access modifiers changed from: private */
        public final Object mCallbackObj;
        /* access modifiers changed from: private */
        public MessageHandler mHandler;
        /* access modifiers changed from: private */
        public boolean mRegistered = false;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$MessageHandler */
        private class MessageHandler extends Handler {
            private static final int MSG_DESTROYED = 8;
            private static final int MSG_EVENT = 1;
            private static final int MSG_UPDATE_EXTRAS = 7;
            private static final int MSG_UPDATE_METADATA = 3;
            private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
            private static final int MSG_UPDATE_QUEUE = 5;
            private static final int MSG_UPDATE_QUEUE_TITLE = 6;
            private static final int MSG_UPDATE_VOLUME = 4;
            final /* synthetic */ Callback this$0;

            public MessageHandler(Callback callback, Looper looper) {
                Looper looper2 = looper;
                this.this$0 = callback;
                super(looper2);
            }

            public void handleMessage(Message message) {
                Message message2 = message;
                if (this.this$0.mRegistered) {
                    switch (message2.what) {
                        case 1:
                            this.this$0.onSessionEvent((String) message2.obj, message2.getData());
                            return;
                        case 2:
                            this.this$0.onPlaybackStateChanged((PlaybackStateCompat) message2.obj);
                            return;
                        case 3:
                            this.this$0.onMetadataChanged((MediaMetadataCompat) message2.obj);
                            return;
                        case 4:
                            this.this$0.onAudioInfoChanged((PlaybackInfo) message2.obj);
                            return;
                        case 5:
                            this.this$0.onQueueChanged((List) message2.obj);
                            return;
                        case 6:
                            this.this$0.onQueueTitleChanged((CharSequence) message2.obj);
                            return;
                        case 7:
                            this.this$0.onExtrasChanged((Bundle) message2.obj);
                            return;
                        case 8:
                            this.this$0.onSessionDestroyed();
                            return;
                        default:
                            return;
                    }
                }
            }

            public void post(int i, Object obj, Bundle bundle) {
                Bundle bundle2 = bundle;
                obtainMessage(i, obj).sendToTarget();
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$StubApi21 */
        private class StubApi21 implements android.support.p000v4.media.session.MediaControllerCompatApi21.Callback {
            final /* synthetic */ Callback this$0;

            private StubApi21(Callback callback) {
                this.this$0 = callback;
            }

            /* synthetic */ StubApi21(Callback callback, C00741 r7) {
                C00741 r2 = r7;
                this(callback);
            }

            public void onMetadataChanged(Object obj) {
                this.this$0.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(obj));
            }

            public void onPlaybackStateChanged(Object obj) {
                this.this$0.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(obj));
            }

            public void onSessionDestroyed() {
                this.this$0.onSessionDestroyed();
            }

            public void onSessionEvent(String str, Bundle bundle) {
                String str2 = str;
                Bundle bundle2 = bundle;
                this.this$0.onSessionEvent(str2, bundle2);
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat */
        private class StubCompat extends Stub {
            final /* synthetic */ Callback this$0;

            private StubCompat(Callback callback) {
                this.this$0 = callback;
            }

            /* synthetic */ StubCompat(Callback callback, C00741 r7) {
                C00741 r2 = r7;
                this(callback);
            }

            public void onEvent(String str, Bundle bundle) throws RemoteException {
                String str2 = str;
                Bundle bundle2 = bundle;
                this.this$0.mHandler.post(1, str2, bundle2);
            }

            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                Bundle bundle2 = bundle;
                this.this$0.mHandler.post(7, bundle2, null);
            }

            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                MediaMetadataCompat mediaMetadataCompat2 = mediaMetadataCompat;
                this.this$0.mHandler.post(3, mediaMetadataCompat2, null);
            }

            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
                this.this$0.mHandler.post(2, playbackStateCompat2, null);
            }

            public void onQueueChanged(List<QueueItem> list) throws RemoteException {
                List<QueueItem> list2 = list;
                this.this$0.mHandler.post(5, list2, null);
            }

            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                CharSequence charSequence2 = charSequence;
                this.this$0.mHandler.post(6, charSequence2, null);
            }

            public void onSessionDestroyed() throws RemoteException {
                this.this$0.mHandler.post(8, null, null);
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                PlaybackInfo playbackInfo;
                ParcelableVolumeInfo parcelableVolumeInfo2 = parcelableVolumeInfo;
                PlaybackInfo playbackInfo2 = null;
                if (parcelableVolumeInfo2 != null) {
                    PlaybackInfo playbackInfo3 = playbackInfo;
                    PlaybackInfo playbackInfo4 = new PlaybackInfo(parcelableVolumeInfo2.volumeType, parcelableVolumeInfo2.audioStream, parcelableVolumeInfo2.controlType, parcelableVolumeInfo2.maxVolume, parcelableVolumeInfo2.currentVolume);
                    playbackInfo2 = playbackInfo3;
                }
                this.this$0.mHandler.post(4, playbackInfo2, null);
            }
        }

        public Callback() {
            StubCompat stubCompat;
            StubApi21 stubApi21;
            if (VERSION.SDK_INT >= 21) {
                StubApi21 stubApi212 = stubApi21;
                StubApi21 stubApi213 = new StubApi21(this, null);
                this.mCallbackObj = MediaControllerCompatApi21.createCallback(stubApi212);
                return;
            }
            StubCompat stubCompat2 = stubCompat;
            StubCompat stubCompat3 = new StubCompat(this, null);
            this.mCallbackObj = stubCompat2;
        }

        static /* synthetic */ boolean access$302(Callback callback, boolean z) {
            boolean z2 = z;
            callback.mRegistered = z2;
            return z2;
        }

        /* access modifiers changed from: private */
        public void setHandler(Handler handler) {
            MessageHandler messageHandler;
            MessageHandler messageHandler2 = messageHandler;
            MessageHandler messageHandler3 = new MessageHandler(this, handler.getLooper());
            this.mHandler = messageHandler2;
        }

        public void binderDied() {
            onSessionDestroyed();
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        }

        public void onQueueChanged(List<QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl */
    interface MediaControllerImpl {
        void adjustVolume(int i, int i2);

        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List<QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        PendingIntent getSessionActivity();

        TransportControls getTransportControls();

        void registerCallback(Callback callback, Handler handler);

        void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void setVolumeTo(int i, int i2);

        void unregisterCallback(Callback callback);
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21 */
    static class MediaControllerImplApi21 implements MediaControllerImpl {
        protected final Object mControllerObj;

        public MediaControllerImplApi21(Context context, Token token) throws RemoteException {
            RemoteException remoteException;
            this.mControllerObj = MediaControllerCompatApi21.fromToken(context, token.getToken());
            if (this.mControllerObj == null) {
                RemoteException remoteException2 = remoteException;
                RemoteException remoteException3 = new RemoteException();
                throw remoteException2;
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat mediaSessionCompat) {
            this.mControllerObj = MediaControllerCompatApi21.fromToken(context, mediaSessionCompat.getSessionToken().getToken());
        }

        public void adjustVolume(int i, int i2) {
            int i3 = i;
            int i4 = i2;
            MediaControllerCompatApi21.adjustVolume(this.mControllerObj, i3, i4);
        }

        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, keyEvent);
        }

        public Bundle getExtras() {
            return MediaControllerCompatApi21.getExtras(this.mControllerObj);
        }

        public long getFlags() {
            return MediaControllerCompatApi21.getFlags(this.mControllerObj);
        }

        public Object getMediaController() {
            return this.mControllerObj;
        }

        public MediaMetadataCompat getMetadata() {
            Object metadata = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
            if (metadata != null) {
                return MediaMetadataCompat.fromMediaMetadata(metadata);
            }
            return null;
        }

        public String getPackageName() {
            return MediaControllerCompatApi21.getPackageName(this.mControllerObj);
        }

        public PlaybackInfo getPlaybackInfo() {
            PlaybackInfo playbackInfo;
            Object playbackInfo2 = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
            if (playbackInfo2 == null) {
                return null;
            }
            PlaybackInfo playbackInfo3 = playbackInfo;
            PlaybackInfo playbackInfo4 = new PlaybackInfo(android.support.p000v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(playbackInfo2), android.support.p000v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(playbackInfo2), android.support.p000v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(playbackInfo2), android.support.p000v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(playbackInfo2), android.support.p000v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(playbackInfo2));
            return playbackInfo3;
        }

        public PlaybackStateCompat getPlaybackState() {
            Object playbackState = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
            if (playbackState != null) {
                return PlaybackStateCompat.fromPlaybackState(playbackState);
            }
            return null;
        }

        public List<QueueItem> getQueue() {
            ArrayList arrayList;
            ArrayList arrayList2;
            List<Object> queue = MediaControllerCompatApi21.getQueue(this.mControllerObj);
            if (queue == null) {
                arrayList2 = null;
            } else {
                ArrayList arrayList3 = arrayList;
                ArrayList arrayList4 = new ArrayList();
                arrayList2 = arrayList3;
                for (Object obtain : queue) {
                    boolean add = arrayList2.add(QueueItem.obtain(obtain));
                }
            }
            return arrayList2;
        }

        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.getQueueTitle(this.mControllerObj);
        }

        public int getRatingType() {
            return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
        }

        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.getSessionActivity(this.mControllerObj);
        }

        public TransportControls getTransportControls() {
            TransportControlsApi21 transportControlsApi21;
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (transportControls == null) {
                return null;
            }
            TransportControlsApi21 transportControlsApi212 = transportControlsApi21;
            TransportControlsApi21 transportControlsApi213 = new TransportControlsApi21(transportControls);
            return transportControlsApi212;
        }

        public void registerCallback(Callback callback, Handler handler) {
            Handler handler2 = handler;
            MediaControllerCompatApi21.registerCallback(this.mControllerObj, callback.mCallbackObj, handler2);
        }

        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            String str2 = str;
            Bundle bundle2 = bundle;
            ResultReceiver resultReceiver2 = resultReceiver;
            MediaControllerCompatApi21.sendCommand(this.mControllerObj, str2, bundle2, resultReceiver2);
        }

        public void setVolumeTo(int i, int i2) {
            int i3 = i;
            int i4 = i2;
            MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, i3, i4);
        }

        public void unregisterCallback(Callback callback) {
            MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, callback.mCallbackObj);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi23 */
    static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context context, Token token) throws RemoteException {
            super(context, token);
        }

        public MediaControllerImplApi23(Context context, MediaSessionCompat mediaSessionCompat) {
            super(context, mediaSessionCompat);
        }

        public TransportControls getTransportControls() {
            TransportControlsApi23 transportControlsApi23;
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (transportControls == null) {
                return null;
            }
            TransportControlsApi23 transportControlsApi232 = transportControlsApi23;
            TransportControlsApi23 transportControlsApi233 = new TransportControlsApi23(transportControls);
            return transportControlsApi232;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplBase */
    static class MediaControllerImplBase implements MediaControllerImpl {
        private IMediaSession mBinder;
        private Token mToken;
        private TransportControls mTransportControls;

        public MediaControllerImplBase(Token token) {
            Token token2 = token;
            this.mToken = token2;
            this.mBinder = IMediaSession.Stub.asInterface((IBinder) token2.getToken());
        }

        public void adjustVolume(int i, int i2) {
            StringBuilder sb;
            try {
                this.mBinder.adjustVolume(i, i2, null);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in adjustVolume. ").append(remoteException).toString());
            }
        }

        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            StringBuilder sb;
            IllegalArgumentException illegalArgumentException;
            KeyEvent keyEvent2 = keyEvent;
            if (keyEvent2 == null) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("event may not be null.");
                throw illegalArgumentException2;
            }
            try {
                boolean sendMediaButton = this.mBinder.sendMediaButton(keyEvent2);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in dispatchMediaButtonEvent. ").append(remoteException).toString());
            }
            return false;
        }

        public Bundle getExtras() {
            StringBuilder sb;
            try {
                return this.mBinder.getExtras();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in getExtras. ").append(remoteException).toString());
                return null;
            }
        }

        public long getFlags() {
            StringBuilder sb;
            try {
                return this.mBinder.getFlags();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in getFlags. ").append(remoteException).toString());
                return 0;
            }
        }

        public Object getMediaController() {
            return null;
        }

        public MediaMetadataCompat getMetadata() {
            StringBuilder sb;
            try {
                return this.mBinder.getMetadata();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in getMetadata. ").append(remoteException).toString());
                return null;
            }
        }

        public String getPackageName() {
            StringBuilder sb;
            try {
                return this.mBinder.getPackageName();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in getPackageName. ").append(remoteException).toString());
                return null;
            }
        }

        public PlaybackInfo getPlaybackInfo() {
            StringBuilder sb;
            PlaybackInfo playbackInfo;
            try {
                ParcelableVolumeInfo volumeAttributes = this.mBinder.getVolumeAttributes();
                PlaybackInfo playbackInfo2 = playbackInfo;
                PlaybackInfo playbackInfo3 = new PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioStream, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
                return playbackInfo2;
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in getPlaybackInfo. ").append(remoteException).toString());
                return null;
            }
        }

        public PlaybackStateCompat getPlaybackState() {
            StringBuilder sb;
            try {
                return this.mBinder.getPlaybackState();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in getPlaybackState. ").append(remoteException).toString());
                return null;
            }
        }

        public List<QueueItem> getQueue() {
            StringBuilder sb;
            try {
                return this.mBinder.getQueue();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in getQueue. ").append(remoteException).toString());
                return null;
            }
        }

        public CharSequence getQueueTitle() {
            StringBuilder sb;
            try {
                return this.mBinder.getQueueTitle();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in getQueueTitle. ").append(remoteException).toString());
                return null;
            }
        }

        public int getRatingType() {
            StringBuilder sb;
            try {
                return this.mBinder.getRatingType();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in getRatingType. ").append(remoteException).toString());
                return 0;
            }
        }

        public PendingIntent getSessionActivity() {
            StringBuilder sb;
            try {
                return this.mBinder.getLaunchPendingIntent();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in getSessionActivity. ").append(remoteException).toString());
                return null;
            }
        }

        public TransportControls getTransportControls() {
            TransportControlsBase transportControlsBase;
            if (this.mTransportControls == null) {
                TransportControlsBase transportControlsBase2 = transportControlsBase;
                TransportControlsBase transportControlsBase3 = new TransportControlsBase(this.mBinder);
                this.mTransportControls = transportControlsBase2;
            }
            return this.mTransportControls;
        }

        public void registerCallback(Callback callback, Handler handler) {
            StringBuilder sb;
            IllegalArgumentException illegalArgumentException;
            Callback callback2 = callback;
            Handler handler2 = handler;
            if (callback2 == null) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("callback may not be null.");
                throw illegalArgumentException2;
            }
            try {
                this.mBinder.asBinder().linkToDeath(callback2, 0);
                this.mBinder.registerCallbackListener((IMediaControllerCallback) callback2.mCallbackObj);
                callback2.setHandler(handler2);
                boolean access$302 = Callback.access$302(callback2, true);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in registerCallback. ").append(remoteException).toString());
                callback2.onSessionDestroyed();
            }
        }

        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            StringBuilder sb;
            ResultReceiverWrapper resultReceiverWrapper;
            String str2 = str;
            Bundle bundle2 = bundle;
            ResultReceiver resultReceiver2 = resultReceiver;
            try {
                IMediaSession iMediaSession = this.mBinder;
                String str3 = str2;
                Bundle bundle3 = bundle2;
                ResultReceiverWrapper resultReceiverWrapper2 = resultReceiverWrapper;
                ResultReceiverWrapper resultReceiverWrapper3 = new ResultReceiverWrapper(resultReceiver2);
                iMediaSession.sendCommand(str3, bundle3, resultReceiverWrapper2);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str4 = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str4, sb2.append("Dead object in sendCommand. ").append(remoteException).toString());
            }
        }

        public void setVolumeTo(int i, int i2) {
            StringBuilder sb;
            try {
                this.mBinder.setVolumeTo(i, i2, null);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in setVolumeTo. ").append(remoteException).toString());
            }
        }

        public void unregisterCallback(Callback callback) {
            StringBuilder sb;
            IllegalArgumentException illegalArgumentException;
            Callback callback2 = callback;
            if (callback2 == null) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("callback may not be null.");
                throw illegalArgumentException2;
            }
            try {
                this.mBinder.unregisterCallbackListener((IMediaControllerCallback) callback2.mCallbackObj);
                boolean unlinkToDeath = this.mBinder.asBinder().unlinkToDeath(callback2, 0);
                boolean access$302 = Callback.access$302(callback2, false);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in unregisterCallback. ").append(remoteException).toString());
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$PlaybackInfo */
    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        private final int mAudioStream;
        private final int mCurrentVolume;
        private final int mMaxVolume;
        private final int mPlaybackType;
        private final int mVolumeControl;

        PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
            int i6 = i2;
            int i7 = i3;
            int i8 = i4;
            int i9 = i5;
            this.mPlaybackType = i;
            this.mAudioStream = i6;
            this.mVolumeControl = i7;
            this.mMaxVolume = i8;
            this.mCurrentVolume = i9;
        }

        public int getAudioStream() {
            return this.mAudioStream;
        }

        public int getCurrentVolume() {
            return this.mCurrentVolume;
        }

        public int getMaxVolume() {
            return this.mMaxVolume;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public int getVolumeControl() {
            return this.mVolumeControl;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$TransportControls */
    public static abstract class TransportControls {
        TransportControls() {
        }

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String str, Bundle bundle);

        public abstract void playFromSearch(String str, Bundle bundle);

        public abstract void playFromUri(Uri uri, Bundle bundle);

        public abstract void rewind();

        public abstract void seekTo(long j);

        public abstract void sendCustomAction(CustomAction customAction, Bundle bundle);

        public abstract void sendCustomAction(String str, Bundle bundle);

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j);

        public abstract void stop();
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$TransportControlsApi21 */
    static class TransportControlsApi21 extends TransportControls {
        protected final Object mControlsObj;

        public TransportControlsApi21(Object obj) {
            this.mControlsObj = obj;
        }

        public void fastForward() {
            android.support.p000v4.media.session.MediaControllerCompatApi21.TransportControls.fastForward(this.mControlsObj);
        }

        public void pause() {
            android.support.p000v4.media.session.MediaControllerCompatApi21.TransportControls.pause(this.mControlsObj);
        }

        public void play() {
            android.support.p000v4.media.session.MediaControllerCompatApi21.TransportControls.play(this.mControlsObj);
        }

        public void playFromMediaId(String str, Bundle bundle) {
            String str2 = str;
            Bundle bundle2 = bundle;
            android.support.p000v4.media.session.MediaControllerCompatApi21.TransportControls.playFromMediaId(this.mControlsObj, str2, bundle2);
        }

        public void playFromSearch(String str, Bundle bundle) {
            String str2 = str;
            Bundle bundle2 = bundle;
            android.support.p000v4.media.session.MediaControllerCompatApi21.TransportControls.playFromSearch(this.mControlsObj, str2, bundle2);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
        }

        public void rewind() {
            android.support.p000v4.media.session.MediaControllerCompatApi21.TransportControls.rewind(this.mControlsObj);
        }

        public void seekTo(long j) {
            long j2 = j;
            android.support.p000v4.media.session.MediaControllerCompatApi21.TransportControls.seekTo(this.mControlsObj, j2);
        }

        public void sendCustomAction(CustomAction customAction, Bundle bundle) {
            Bundle bundle2 = bundle;
            android.support.p000v4.media.session.MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, customAction.getAction(), bundle2);
        }

        public void sendCustomAction(String str, Bundle bundle) {
            String str2 = str;
            Bundle bundle2 = bundle;
            android.support.p000v4.media.session.MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, str2, bundle2);
        }

        public void setRating(RatingCompat ratingCompat) {
            RatingCompat ratingCompat2 = ratingCompat;
            android.support.p000v4.media.session.MediaControllerCompatApi21.TransportControls.setRating(this.mControlsObj, ratingCompat2 != null ? ratingCompat2.getRating() : null);
        }

        public void skipToNext() {
            android.support.p000v4.media.session.MediaControllerCompatApi21.TransportControls.skipToNext(this.mControlsObj);
        }

        public void skipToPrevious() {
            android.support.p000v4.media.session.MediaControllerCompatApi21.TransportControls.skipToPrevious(this.mControlsObj);
        }

        public void skipToQueueItem(long j) {
            long j2 = j;
            android.support.p000v4.media.session.MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.mControlsObj, j2);
        }

        public void stop() {
            android.support.p000v4.media.session.MediaControllerCompatApi21.TransportControls.stop(this.mControlsObj);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$TransportControlsApi23 */
    static class TransportControlsApi23 extends TransportControlsApi21 {
        public TransportControlsApi23(Object obj) {
            super(obj);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            Uri uri2 = uri;
            Bundle bundle2 = bundle;
            android.support.p000v4.media.session.MediaControllerCompatApi23.TransportControls.playFromUri(this.mControlsObj, uri2, bundle2);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$TransportControlsBase */
    static class TransportControlsBase extends TransportControls {
        private IMediaSession mBinder;

        public TransportControlsBase(IMediaSession iMediaSession) {
            this.mBinder = iMediaSession;
        }

        public void fastForward() {
            StringBuilder sb;
            try {
                this.mBinder.fastForward();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in fastForward. ").append(remoteException).toString());
            }
        }

        public void pause() {
            StringBuilder sb;
            try {
                this.mBinder.pause();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in pause. ").append(remoteException).toString());
            }
        }

        public void play() {
            StringBuilder sb;
            try {
                this.mBinder.play();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in play. ").append(remoteException).toString());
            }
        }

        public void playFromMediaId(String str, Bundle bundle) {
            StringBuilder sb;
            try {
                this.mBinder.playFromMediaId(str, bundle);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str2 = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str2, sb2.append("Dead object in playFromMediaId. ").append(remoteException).toString());
            }
        }

        public void playFromSearch(String str, Bundle bundle) {
            StringBuilder sb;
            try {
                this.mBinder.playFromSearch(str, bundle);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str2 = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str2, sb2.append("Dead object in playFromSearch. ").append(remoteException).toString());
            }
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            StringBuilder sb;
            try {
                this.mBinder.playFromUri(uri, bundle);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in playFromUri. ").append(remoteException).toString());
            }
        }

        public void rewind() {
            StringBuilder sb;
            try {
                this.mBinder.rewind();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in rewind. ").append(remoteException).toString());
            }
        }

        public void seekTo(long j) {
            StringBuilder sb;
            try {
                this.mBinder.seekTo(j);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in seekTo. ").append(remoteException).toString());
            }
        }

        public void sendCustomAction(CustomAction customAction, Bundle bundle) {
            sendCustomAction(customAction.getAction(), bundle);
        }

        public void sendCustomAction(String str, Bundle bundle) {
            StringBuilder sb;
            try {
                this.mBinder.sendCustomAction(str, bundle);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str2 = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str2, sb2.append("Dead object in sendCustomAction. ").append(remoteException).toString());
            }
        }

        public void setRating(RatingCompat ratingCompat) {
            StringBuilder sb;
            try {
                this.mBinder.rate(ratingCompat);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in setRating. ").append(remoteException).toString());
            }
        }

        public void skipToNext() {
            StringBuilder sb;
            try {
                this.mBinder.next();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in skipToNext. ").append(remoteException).toString());
            }
        }

        public void skipToPrevious() {
            StringBuilder sb;
            try {
                this.mBinder.previous();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in skipToPrevious. ").append(remoteException).toString());
            }
        }

        public void skipToQueueItem(long j) {
            StringBuilder sb;
            try {
                this.mBinder.skipToQueueItem(j);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in skipToQueueItem. ").append(remoteException).toString());
            }
        }

        public void stop() {
            StringBuilder sb;
            try {
                this.mBinder.stop();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                String str = MediaControllerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e2 = Log.e(str, sb2.append("Dead object in stop. ").append(remoteException).toString());
            }
        }
    }

    public MediaControllerCompat(Context context, Token token) throws RemoteException {
        MediaControllerImplBase mediaControllerImplBase;
        MediaControllerImplApi21 mediaControllerImplApi21;
        IllegalArgumentException illegalArgumentException;
        Context context2 = context;
        Token token2 = token;
        if (token2 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("sessionToken must not be null");
            throw illegalArgumentException2;
        }
        this.mToken = token2;
        if (VERSION.SDK_INT >= 21) {
            MediaControllerImplApi21 mediaControllerImplApi212 = mediaControllerImplApi21;
            MediaControllerImplApi21 mediaControllerImplApi213 = new MediaControllerImplApi21(context2, token2);
            this.mImpl = mediaControllerImplApi212;
            return;
        }
        MediaControllerImplBase mediaControllerImplBase2 = mediaControllerImplBase;
        MediaControllerImplBase mediaControllerImplBase3 = new MediaControllerImplBase(this.mToken);
        this.mImpl = mediaControllerImplBase2;
    }

    public MediaControllerCompat(Context context, MediaSessionCompat mediaSessionCompat) {
        MediaControllerImplBase mediaControllerImplBase;
        MediaControllerImplApi21 mediaControllerImplApi21;
        MediaControllerImplApi23 mediaControllerImplApi23;
        IllegalArgumentException illegalArgumentException;
        Context context2 = context;
        MediaSessionCompat mediaSessionCompat2 = mediaSessionCompat;
        if (mediaSessionCompat2 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("session must not be null");
            throw illegalArgumentException2;
        }
        this.mToken = mediaSessionCompat2.getSessionToken();
        if (VERSION.SDK_INT >= 23) {
            MediaControllerImplApi23 mediaControllerImplApi232 = mediaControllerImplApi23;
            MediaControllerImplApi23 mediaControllerImplApi233 = new MediaControllerImplApi23(context2, mediaSessionCompat2);
            this.mImpl = mediaControllerImplApi232;
        } else if (VERSION.SDK_INT >= 21) {
            MediaControllerImplApi21 mediaControllerImplApi212 = mediaControllerImplApi21;
            MediaControllerImplApi21 mediaControllerImplApi213 = new MediaControllerImplApi21(context2, mediaSessionCompat2);
            this.mImpl = mediaControllerImplApi212;
        } else {
            MediaControllerImplBase mediaControllerImplBase2 = mediaControllerImplBase;
            MediaControllerImplBase mediaControllerImplBase3 = new MediaControllerImplBase(this.mToken);
            this.mImpl = mediaControllerImplBase2;
        }
    }

    public void adjustVolume(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        this.mImpl.adjustVolume(i3, i4);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        IllegalArgumentException illegalArgumentException;
        KeyEvent keyEvent2 = keyEvent;
        if (keyEvent2 != null) {
            return this.mImpl.dispatchMediaButtonEvent(keyEvent2);
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("KeyEvent may not be null");
        throw illegalArgumentException2;
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public long getFlags() {
        return this.mImpl.getFlags();
    }

    public Object getMediaController() {
        return this.mImpl.getMediaController();
    }

    public MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public List<QueueItem> getQueue() {
        return this.mImpl.getQueue();
    }

    public CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }

    public int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }

    public Token getSessionToken() {
        return this.mToken;
    }

    public TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    public void registerCallback(Callback callback) {
        registerCallback(callback, null);
    }

    public void registerCallback(Callback callback, Handler handler) {
        Handler handler2;
        IllegalArgumentException illegalArgumentException;
        Callback callback2 = callback;
        Handler handler3 = handler;
        if (callback2 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("callback cannot be null");
            throw illegalArgumentException2;
        }
        if (handler3 == null) {
            Handler handler4 = handler2;
            Handler handler5 = new Handler();
            handler3 = handler4;
        }
        this.mImpl.registerCallback(callback2, handler3);
    }

    public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        IllegalArgumentException illegalArgumentException;
        String str2 = str;
        Bundle bundle2 = bundle;
        ResultReceiver resultReceiver2 = resultReceiver;
        if (TextUtils.isEmpty(str2)) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("command cannot be null or empty");
            throw illegalArgumentException2;
        }
        this.mImpl.sendCommand(str2, bundle2, resultReceiver2);
    }

    public void setVolumeTo(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        this.mImpl.setVolumeTo(i3, i4);
    }

    public void unregisterCallback(Callback callback) {
        IllegalArgumentException illegalArgumentException;
        Callback callback2 = callback;
        if (callback2 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("callback cannot be null");
            throw illegalArgumentException2;
        }
        this.mImpl.unregisterCallback(callback2);
    }
}
