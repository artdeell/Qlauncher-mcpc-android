package android.support.p000v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.p000v4.media.MediaDescriptionCompat;
import android.support.p000v4.media.MediaMetadataCompat;
import android.support.p000v4.media.RatingCompat;
import android.support.p000v4.media.VolumeProviderCompat;
import android.support.p000v4.media.session.IMediaSession.Stub;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaSessionCompat */
public class MediaSessionCompat {
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    private static final String TAG = "MediaSessionCompat";
    private final ArrayList<OnActiveChangeListener> mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback */
    public static abstract class Callback {
        final Object mCallbackObj;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback$StubApi21 */
        private class StubApi21 implements Callback {
            final /* synthetic */ Callback this$0;

            private StubApi21(Callback callback) {
                this.this$0 = callback;
            }

            /* synthetic */ StubApi21(Callback callback, C00751 r7) {
                C00751 r2 = r7;
                this(callback);
            }

            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                String str2 = str;
                Bundle bundle2 = bundle;
                ResultReceiver resultReceiver2 = resultReceiver;
                this.this$0.onCommand(str2, bundle2, resultReceiver2);
            }

            public void onCustomAction(String str, Bundle bundle) {
                String str2 = str;
                Bundle bundle2 = bundle;
                this.this$0.onCustomAction(str2, bundle2);
            }

            public void onFastForward() {
                this.this$0.onFastForward();
            }

            public boolean onMediaButtonEvent(Intent intent) {
                return this.this$0.onMediaButtonEvent(intent);
            }

            public void onPause() {
                this.this$0.onPause();
            }

            public void onPlay() {
                this.this$0.onPlay();
            }

            public void onPlayFromMediaId(String str, Bundle bundle) {
                String str2 = str;
                Bundle bundle2 = bundle;
                this.this$0.onPlayFromMediaId(str2, bundle2);
            }

            public void onPlayFromSearch(String str, Bundle bundle) {
                String str2 = str;
                Bundle bundle2 = bundle;
                this.this$0.onPlayFromSearch(str2, bundle2);
            }

            public void onRewind() {
                this.this$0.onRewind();
            }

            public void onSeekTo(long j) {
                long j2 = j;
                this.this$0.onSeekTo(j2);
            }

            public void onSetRating(Object obj) {
                this.this$0.onSetRating(RatingCompat.fromRating(obj));
            }

            public void onSkipToNext() {
                this.this$0.onSkipToNext();
            }

            public void onSkipToPrevious() {
                this.this$0.onSkipToPrevious();
            }

            public void onSkipToQueueItem(long j) {
                long j2 = j;
                this.this$0.onSkipToQueueItem(j2);
            }

            public void onStop() {
                this.this$0.onStop();
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback$StubApi23 */
        private class StubApi23 extends StubApi21 implements android.support.p000v4.media.session.MediaSessionCompatApi23.Callback {
            final /* synthetic */ Callback this$0;

            private StubApi23(Callback callback) {
                Callback callback2 = callback;
                this.this$0 = callback2;
                super(callback2, null);
            }

            /* synthetic */ StubApi23(Callback callback, C00751 r7) {
                C00751 r2 = r7;
                this(callback);
            }

            public void onPlayFromUri(Uri uri, Bundle bundle) {
                Uri uri2 = uri;
                Bundle bundle2 = bundle;
                this.this$0.onPlayFromUri(uri2, bundle2);
            }
        }

        public Callback() {
            StubApi21 stubApi21;
            StubApi23 stubApi23;
            if (VERSION.SDK_INT >= 23) {
                StubApi23 stubApi232 = stubApi23;
                StubApi23 stubApi233 = new StubApi23(this, null);
                this.mCallbackObj = MediaSessionCompatApi23.createCallback(stubApi232);
            } else if (VERSION.SDK_INT >= 21) {
                StubApi21 stubApi212 = stubApi21;
                StubApi21 stubApi213 = new StubApi21(this, null);
                this.mCallbackObj = MediaSessionCompatApi21.createCallback(stubApi212);
            } else {
                this.mCallbackObj = null;
            }
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            Intent intent2 = intent;
            return false;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j) {
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j) {
        }

        public void onStop() {
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl */
    interface MediaSessionImpl {
        Object getMediaSession();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String str, Bundle bundle);

        void setActive(boolean z);

        void setCallback(Callback callback, Handler handler);

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setMediaButtonReceiver(PendingIntent pendingIntent);

        void setMetadata(MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i);

        void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat);

        void setQueue(List<QueueItem> list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i);

        void setSessionActivity(PendingIntent pendingIntent);
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21 */
    static class MediaSessionImplApi21 implements MediaSessionImpl {
        private PendingIntent mMediaButtonIntent;
        private final Object mSessionObj;
        private final Token mToken;

        public MediaSessionImplApi21(Context context, String str) {
            Token token;
            this.mSessionObj = MediaSessionCompatApi21.createSession(context, str);
            Token token2 = token;
            Token token3 = new Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj));
            this.mToken = token2;
        }

        public MediaSessionImplApi21(Object obj) {
            Token token;
            this.mSessionObj = MediaSessionCompatApi21.verifySession(obj);
            Token token2 = token;
            Token token3 = new Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj));
            this.mToken = token2;
        }

        public Object getMediaSession() {
            return this.mSessionObj;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return MediaSessionCompatApi21.isActive(this.mSessionObj);
        }

        public void release() {
            MediaSessionCompatApi21.release(this.mSessionObj);
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            String str2 = str;
            Bundle bundle2 = bundle;
            MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, str2, bundle2);
        }

        public void setActive(boolean z) {
            boolean z2 = z;
            MediaSessionCompatApi21.setActive(this.mSessionObj, z2);
        }

        public void setCallback(Callback callback, Handler handler) {
            Callback callback2 = callback;
            MediaSessionCompatApi21.setCallback(this.mSessionObj, callback2 == null ? null : callback2.mCallbackObj, handler);
        }

        public void setExtras(Bundle bundle) {
            Bundle bundle2 = bundle;
            MediaSessionCompatApi21.setExtras(this.mSessionObj, bundle2);
        }

        public void setFlags(int i) {
            int i2 = i;
            MediaSessionCompatApi21.setFlags(this.mSessionObj, i2);
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
            PendingIntent pendingIntent2 = pendingIntent;
            this.mMediaButtonIntent = pendingIntent2;
            MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, pendingIntent2);
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            MediaMetadataCompat mediaMetadataCompat2 = mediaMetadataCompat;
            MediaSessionCompatApi21.setMetadata(this.mSessionObj, mediaMetadataCompat2 == null ? null : mediaMetadataCompat2.getMediaMetadata());
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
            MediaSessionCompatApi21.setPlaybackState(this.mSessionObj, playbackStateCompat2 == null ? null : playbackStateCompat2.getPlaybackState());
        }

        public void setPlaybackToLocal(int i) {
            int i2 = i;
            MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, i2);
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, volumeProviderCompat.getVolumeProvider());
        }

        public void setQueue(List<QueueItem> list) {
            ArrayList arrayList;
            List<QueueItem> list2 = list;
            ArrayList arrayList2 = null;
            if (list2 != null) {
                ArrayList arrayList3 = arrayList;
                ArrayList arrayList4 = new ArrayList();
                arrayList2 = arrayList3;
                for (QueueItem queueItem : list2) {
                    boolean add = arrayList2.add(queueItem.getQueueItem());
                }
            }
            MediaSessionCompatApi21.setQueue(this.mSessionObj, arrayList2);
        }

        public void setQueueTitle(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, charSequence2);
        }

        public void setRatingType(int i) {
            int i2 = i;
            if (VERSION.SDK_INT >= 22) {
                MediaSessionCompatApi22.setRatingType(this.mSessionObj, i2);
            }
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            PendingIntent pendingIntent2 = pendingIntent;
            MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, pendingIntent2);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase */
    static class MediaSessionImplBase implements MediaSessionImpl {
        /* access modifiers changed from: private */
        public final AudioManager mAudioManager;
        /* access modifiers changed from: private */
        public Callback mCallback;
        private final ComponentName mComponentName;
        private final Context mContext;
        /* access modifiers changed from: private */
        public final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks;
        /* access modifiers changed from: private */
        public boolean mDestroyed = false;
        /* access modifiers changed from: private */
        public Bundle mExtras;
        /* access modifiers changed from: private */
        public int mFlags;
        /* access modifiers changed from: private */
        public final MessageHandler mHandler;
        private boolean mIsActive = false;
        private boolean mIsMbrRegistered = false;
        private boolean mIsRccRegistered = false;
        /* access modifiers changed from: private */
        public int mLocalStream;
        /* access modifiers changed from: private */
        public final Object mLock;
        private final PendingIntent mMediaButtonEventReceiver;
        /* access modifiers changed from: private */
        public MediaMetadataCompat mMetadata;
        /* access modifiers changed from: private */
        public final String mPackageName;
        /* access modifiers changed from: private */
        public List<QueueItem> mQueue;
        /* access modifiers changed from: private */
        public CharSequence mQueueTitle;
        /* access modifiers changed from: private */
        public int mRatingType;
        private final Object mRccObj;
        /* access modifiers changed from: private */
        public PendingIntent mSessionActivity;
        /* access modifiers changed from: private */
        public PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        /* access modifiers changed from: private */
        public final String mTag;
        private final Token mToken;
        private android.support.p000v4.media.VolumeProviderCompat.Callback mVolumeCallback;
        /* access modifiers changed from: private */
        public VolumeProviderCompat mVolumeProvider;
        /* access modifiers changed from: private */
        public int mVolumeType;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$Command */
        private static final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
                Bundle bundle2 = bundle;
                ResultReceiver resultReceiver2 = resultReceiver;
                this.command = str;
                this.extras = bundle2;
                this.stub = resultReceiver2;
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MediaSessionStub */
        class MediaSessionStub extends Stub {
            final /* synthetic */ MediaSessionImplBase this$0;

            MediaSessionStub(MediaSessionImplBase mediaSessionImplBase) {
                this.this$0 = mediaSessionImplBase;
            }

            public void adjustVolume(int i, int i2, String str) {
                int i3 = i;
                int i4 = i2;
                String str2 = str;
                this.this$0.adjustVolume(i3, i4);
            }

            public void fastForward() throws RemoteException {
                this.this$0.mHandler.post(9);
            }

            public Bundle getExtras() {
                Bundle access$1400 = this.this$0.mLock;
                synchronized (access$1400) {
                    try {
                        th = this.this$0.mExtras;
                    } finally {
                        Throwable th = th;
                        Bundle bundle = access$1400;
                        Throwable th2 = th;
                    }
                }
                return th;
            }

            public long getFlags() {
                long access$1400 = this.this$0.mLock;
                synchronized (access$1400) {
                    try {
                        th = (long) this.this$0.mFlags;
                    } finally {
                        Throwable th = th;
                        long j = access$1400;
                        Throwable th2 = th;
                    }
                }
                return th;
            }

            public PendingIntent getLaunchPendingIntent() {
                PendingIntent access$1400 = this.this$0.mLock;
                synchronized (access$1400) {
                    try {
                        th = this.this$0.mSessionActivity;
                    } finally {
                        Throwable th = th;
                        PendingIntent pendingIntent = access$1400;
                        Throwable th2 = th;
                    }
                }
                return th;
            }

            public MediaMetadataCompat getMetadata() {
                return this.this$0.mMetadata;
            }

            public String getPackageName() {
                return this.this$0.mPackageName;
            }

            public PlaybackStateCompat getPlaybackState() {
                return this.this$0.getStateWithUpdatedPosition();
            }

            public List<QueueItem> getQueue() {
                List access$1400 = this.this$0.mLock;
                synchronized (access$1400) {
                    try {
                        th = this.this$0.mQueue;
                    } finally {
                        Throwable th = th;
                        List list = access$1400;
                        Throwable th2 = th;
                    }
                }
                return th;
            }

            public CharSequence getQueueTitle() {
                return this.this$0.mQueueTitle;
            }

            public int getRatingType() {
                return this.this$0.mRatingType;
            }

            public String getTag() {
                return this.this$0.mTag;
            }

            /* JADX INFO: finally extract failed */
            public ParcelableVolumeInfo getVolumeAttributes() {
                int access$400;
                int access$500;
                int i;
                int streamMaxVolume;
                int streamVolume;
                ParcelableVolumeInfo parcelableVolumeInfo;
                Object access$1400 = this.this$0.mLock;
                synchronized (access$1400) {
                    try {
                        access$400 = this.this$0.mVolumeType;
                        access$500 = this.this$0.mLocalStream;
                        VolumeProviderCompat access$300 = this.this$0.mVolumeProvider;
                        if (access$400 == 2) {
                            i = access$300.getVolumeControl();
                            streamMaxVolume = access$300.getMaxVolume();
                            streamVolume = access$300.getCurrentVolume();
                        } else {
                            i = 2;
                            streamMaxVolume = this.this$0.mAudioManager.getStreamMaxVolume(access$500);
                            streamVolume = this.this$0.mAudioManager.getStreamVolume(access$500);
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj = access$1400;
                        throw th2;
                    }
                }
                ParcelableVolumeInfo parcelableVolumeInfo2 = parcelableVolumeInfo;
                ParcelableVolumeInfo parcelableVolumeInfo3 = new ParcelableVolumeInfo(access$400, access$500, i, streamMaxVolume, streamVolume);
                return parcelableVolumeInfo2;
            }

            public boolean isTransportControlEnabled() {
                return (2 & this.this$0.mFlags) != 0;
            }

            public void next() throws RemoteException {
                this.this$0.mHandler.post(7);
            }

            public void pause() throws RemoteException {
                this.this$0.mHandler.post(5);
            }

            public void play() throws RemoteException {
                this.this$0.mHandler.post(1);
            }

            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                String str2 = str;
                Bundle bundle2 = bundle;
                this.this$0.mHandler.post(2, (Object) str2, bundle2);
            }

            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                String str2 = str;
                Bundle bundle2 = bundle;
                this.this$0.mHandler.post(3, (Object) str2, bundle2);
            }

            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                Uri uri2 = uri;
                Bundle bundle2 = bundle;
                this.this$0.mHandler.post(18, (Object) uri2, bundle2);
            }

            public void previous() throws RemoteException {
                this.this$0.mHandler.post(8);
            }

            public void rate(RatingCompat ratingCompat) throws RemoteException {
                RatingCompat ratingCompat2 = ratingCompat;
                this.this$0.mHandler.post(12, ratingCompat2);
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                IMediaControllerCallback iMediaControllerCallback2 = iMediaControllerCallback;
                if (this.this$0.mDestroyed) {
                    try {
                        iMediaControllerCallback2.onSessionDestroyed();
                    } catch (Exception e) {
                        Exception exc = e;
                    }
                } else {
                    boolean register = this.this$0.mControllerCallbacks.register(iMediaControllerCallback2);
                }
            }

            public void rewind() throws RemoteException {
                this.this$0.mHandler.post(10);
            }

            public void seekTo(long j) throws RemoteException {
                this.this$0.mHandler.post(11, Long.valueOf(j));
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                Command command;
                String str2 = str;
                Bundle bundle2 = bundle;
                ResultReceiverWrapper resultReceiverWrapper2 = resultReceiverWrapper;
                MessageHandler access$800 = this.this$0.mHandler;
                Command command2 = command;
                Command command3 = new Command(str2, bundle2, resultReceiverWrapper2.mResultReceiver);
                access$800.post(15, command2);
            }

            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                String str2 = str;
                Bundle bundle2 = bundle;
                this.this$0.mHandler.post(13, (Object) str2, bundle2);
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                KeyEvent keyEvent2 = keyEvent;
                boolean z = (1 & this.this$0.mFlags) != 0;
                if (z) {
                    this.this$0.mHandler.post(14, keyEvent2);
                }
                return z;
            }

            public void setVolumeTo(int i, int i2, String str) {
                int i3 = i;
                int i4 = i2;
                String str2 = str;
                this.this$0.setVolumeTo(i3, i4);
            }

            public void skipToQueueItem(long j) {
                this.this$0.mHandler.post(4, Long.valueOf(j));
            }

            public void stop() throws RemoteException {
                this.this$0.mHandler.post(6);
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                IMediaControllerCallback iMediaControllerCallback2 = iMediaControllerCallback;
                boolean unregister = this.this$0.mControllerCallbacks.unregister(iMediaControllerCallback2);
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler */
        private class MessageHandler extends Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 127;
            private static final int KEYCODE_MEDIA_PLAY = 126;
            private static final int MSG_ADJUST_VOLUME = 16;
            private static final int MSG_COMMAND = 15;
            private static final int MSG_CUSTOM_ACTION = 13;
            private static final int MSG_FAST_FORWARD = 9;
            private static final int MSG_MEDIA_BUTTON = 14;
            private static final int MSG_NEXT = 7;
            private static final int MSG_PAUSE = 5;
            private static final int MSG_PLAY = 1;
            private static final int MSG_PLAY_MEDIA_ID = 2;
            private static final int MSG_PLAY_SEARCH = 3;
            private static final int MSG_PLAY_URI = 18;
            private static final int MSG_PREVIOUS = 8;
            private static final int MSG_RATE = 12;
            private static final int MSG_REWIND = 10;
            private static final int MSG_SEEK_TO = 11;
            private static final int MSG_SET_VOLUME = 17;
            private static final int MSG_SKIP_TO_ITEM = 4;
            private static final int MSG_STOP = 6;
            final /* synthetic */ MediaSessionImplBase this$0;

            public MessageHandler(MediaSessionImplBase mediaSessionImplBase, Looper looper) {
                Looper looper2 = looper;
                this.this$0 = mediaSessionImplBase;
                super(looper2);
            }

            private void onMediaButtonEvent(KeyEvent keyEvent) {
                KeyEvent keyEvent2 = keyEvent;
                boolean z = true;
                if (keyEvent2 != null && keyEvent2.getAction() == 0) {
                    long actions = this.this$0.mState == null ? 0 : this.this$0.mState.getActions();
                    switch (keyEvent2.getKeyCode()) {
                        case 79:
                        case 85:
                            boolean z2 = this.this$0.mState != null && this.this$0.mState.getState() == 3;
                            boolean z3 = (516 & actions) != 0;
                            if ((514 & actions) == 0) {
                                z = false;
                            }
                            if (z2 && z) {
                                this.this$0.mCallback.onPause();
                                return;
                            } else if (!z2 && z3) {
                                this.this$0.mCallback.onPlay();
                                return;
                            } else {
                                return;
                            }
                        case 86:
                            if ((1 & actions) != 0) {
                                this.this$0.mCallback.onStop();
                                return;
                            }
                            return;
                        case 87:
                            if ((32 & actions) != 0) {
                                this.this$0.mCallback.onSkipToNext();
                                return;
                            }
                            return;
                        case 88:
                            if ((16 & actions) != 0) {
                                this.this$0.mCallback.onSkipToPrevious();
                                return;
                            }
                            return;
                        case 89:
                            if ((8 & actions) != 0) {
                                this.this$0.mCallback.onRewind();
                                return;
                            }
                            return;
                        case 90:
                            if ((64 & actions) != 0) {
                                this.this$0.mCallback.onFastForward();
                                return;
                            }
                            return;
                        case 126:
                            if ((4 & actions) != 0) {
                                this.this$0.mCallback.onPlay();
                                return;
                            }
                            return;
                        case 127:
                            if ((2 & actions) != 0) {
                                this.this$0.mCallback.onPause();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }

            public void handleMessage(Message message) {
                Intent intent;
                Message message2 = message;
                if (this.this$0.mCallback != null) {
                    switch (message2.what) {
                        case 1:
                            this.this$0.mCallback.onPlay();
                            return;
                        case 2:
                            this.this$0.mCallback.onPlayFromMediaId((String) message2.obj, message2.getData());
                            return;
                        case 3:
                            this.this$0.mCallback.onPlayFromSearch((String) message2.obj, message2.getData());
                            return;
                        case 4:
                            this.this$0.mCallback.onSkipToQueueItem(((Long) message2.obj).longValue());
                            return;
                        case 5:
                            this.this$0.mCallback.onPause();
                            return;
                        case 6:
                            this.this$0.mCallback.onStop();
                            return;
                        case 7:
                            this.this$0.mCallback.onSkipToNext();
                            return;
                        case 8:
                            this.this$0.mCallback.onSkipToPrevious();
                            return;
                        case 9:
                            this.this$0.mCallback.onFastForward();
                            return;
                        case 10:
                            this.this$0.mCallback.onRewind();
                            return;
                        case 11:
                            this.this$0.mCallback.onSeekTo(((Long) message2.obj).longValue());
                            return;
                        case 12:
                            this.this$0.mCallback.onSetRating((RatingCompat) message2.obj);
                            return;
                        case 13:
                            this.this$0.mCallback.onCustomAction((String) message2.obj, message2.getData());
                            return;
                        case 14:
                            KeyEvent keyEvent = (KeyEvent) message2.obj;
                            Intent intent2 = intent;
                            Intent intent3 = new Intent("android.intent.action.MEDIA_BUTTON");
                            Intent intent4 = intent2;
                            Intent putExtra = intent4.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!this.this$0.mCallback.onMediaButtonEvent(intent4)) {
                                onMediaButtonEvent(keyEvent);
                                return;
                            }
                            return;
                        case 15:
                            Command command = (Command) message2.obj;
                            this.this$0.mCallback.onCommand(command.command, command.extras, command.stub);
                            return;
                        case 16:
                            this.this$0.adjustVolume(((Integer) message2.obj).intValue(), 0);
                            return;
                        case 17:
                            this.this$0.setVolumeTo(((Integer) message2.obj).intValue(), 0);
                            return;
                        case 18:
                            this.this$0.mCallback.onPlayFromUri((Uri) message2.obj, message2.getData());
                            return;
                        default:
                            return;
                    }
                }
            }

            public void post(int i) {
                post(i, null);
            }

            public void post(int i, Object obj) {
                obtainMessage(i, obj).sendToTarget();
            }

            public void post(int i, Object obj, int i2) {
                obtainMessage(i, i2, 0, obj).sendToTarget();
            }

            public void post(int i, Object obj, Bundle bundle) {
                Bundle bundle2 = bundle;
                Message obtainMessage = obtainMessage(i, obj);
                obtainMessage.setData(bundle2);
                obtainMessage.sendToTarget();
            }
        }

        public MediaSessionImplBase(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            Object obj;
            RemoteCallbackList<IMediaControllerCallback> remoteCallbackList;
            C00761 r10;
            MediaSessionStub mediaSessionStub;
            Token token;
            MessageHandler messageHandler;
            IllegalArgumentException illegalArgumentException;
            Context context2 = context;
            String str2 = str;
            ComponentName componentName2 = componentName;
            PendingIntent pendingIntent2 = pendingIntent;
            Object obj2 = obj;
            Object obj3 = new Object();
            this.mLock = obj2;
            RemoteCallbackList<IMediaControllerCallback> remoteCallbackList2 = remoteCallbackList;
            RemoteCallbackList<IMediaControllerCallback> remoteCallbackList3 = new RemoteCallbackList<>();
            this.mControllerCallbacks = remoteCallbackList2;
            C00761 r6 = r10;
            C00761 r7 = new android.support.p000v4.media.VolumeProviderCompat.Callback(this) {
                final /* synthetic */ MediaSessionImplBase this$0;

                {
                    this.this$0 = r5;
                }

                public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat) {
                    ParcelableVolumeInfo parcelableVolumeInfo;
                    VolumeProviderCompat volumeProviderCompat2 = volumeProviderCompat;
                    if (this.this$0.mVolumeProvider == volumeProviderCompat2) {
                        ParcelableVolumeInfo parcelableVolumeInfo2 = parcelableVolumeInfo;
                        ParcelableVolumeInfo parcelableVolumeInfo3 = new ParcelableVolumeInfo(this.this$0.mVolumeType, this.this$0.mLocalStream, volumeProviderCompat2.getVolumeControl(), volumeProviderCompat2.getMaxVolume(), volumeProviderCompat2.getCurrentVolume());
                        this.this$0.sendVolumeInfoChanged(parcelableVolumeInfo2);
                    }
                }
            };
            this.mVolumeCallback = r6;
            if (componentName2 == null) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("MediaButtonReceiver component may not be null.");
                throw illegalArgumentException2;
            }
            this.mContext = context2;
            this.mPackageName = context2.getPackageName();
            this.mAudioManager = (AudioManager) context2.getSystemService("audio");
            this.mTag = str2;
            this.mComponentName = componentName2;
            this.mMediaButtonEventReceiver = pendingIntent2;
            MediaSessionStub mediaSessionStub2 = mediaSessionStub;
            MediaSessionStub mediaSessionStub3 = new MediaSessionStub(this);
            this.mStub = mediaSessionStub2;
            Token token2 = token;
            Token token3 = new Token(this.mStub);
            this.mToken = token2;
            MessageHandler messageHandler2 = messageHandler;
            MessageHandler messageHandler3 = new MessageHandler(this, Looper.myLooper());
            this.mHandler = messageHandler2;
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            if (VERSION.SDK_INT >= 14) {
                this.mRccObj = MediaSessionCompatApi14.createRemoteControlClient(pendingIntent2);
                return;
            }
            this.mRccObj = null;
        }

        /* access modifiers changed from: private */
        public void adjustVolume(int i, int i2) {
            int i3 = i;
            int i4 = i2;
            if (this.mVolumeType != 2) {
                this.mAudioManager.adjustStreamVolume(this.mLocalStream, i3, i4);
            } else if (this.mVolumeProvider != null) {
                this.mVolumeProvider.onAdjustVolume(i3);
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0082, code lost:
            if (r7.getState() == 5) goto L_0x0084;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.support.p000v4.media.session.PlaybackStateCompat getStateWithUpdatedPosition() {
            /*
                r27 = this;
                r2 = r27
                r19 = -1
                r3 = r19
                r19 = r2
                r0 = r19
                java.lang.Object r0 = r0.mLock
                r19 = r0
                r5 = r19
                r19 = r5
                monitor-enter(r19)
                r19 = r2
                r0 = r19
                android.support.v4.media.session.PlaybackStateCompat r0 = r0.mState     // Catch:{ all -> 0x010e }
                r19 = r0
                r7 = r19
                r19 = r2
                r0 = r19
                android.support.v4.media.MediaMetadataCompat r0 = r0.mMetadata     // Catch:{ all -> 0x010e }
                r19 = r0
                if (r19 == 0) goto L_0x0047
                r19 = r2
                r0 = r19
                android.support.v4.media.MediaMetadataCompat r0 = r0.mMetadata     // Catch:{ all -> 0x010e }
                r19 = r0
                java.lang.String r20 = "android.media.metadata.DURATION"
                boolean r19 = r19.containsKey(r20)     // Catch:{ all -> 0x010e }
                if (r19 == 0) goto L_0x0047
                r19 = r2
                r0 = r19
                android.support.v4.media.MediaMetadataCompat r0 = r0.mMetadata     // Catch:{ all -> 0x010e }
                r19 = r0
                java.lang.String r20 = "android.media.metadata.DURATION"
                long r19 = r19.getLong(r20)     // Catch:{ all -> 0x010e }
                r3 = r19
            L_0x0047:
                r19 = r5
                monitor-exit(r19)     // Catch:{ all -> 0x010e }
                r19 = 0
                r8 = r19
                r19 = r7
                if (r19 == 0) goto L_0x0105
                r19 = r7
                int r19 = r19.getState()
                r20 = 3
                r0 = r19
                r1 = r20
                if (r0 == r1) goto L_0x0084
                r19 = r7
                int r19 = r19.getState()
                r20 = 4
                r0 = r19
                r1 = r20
                if (r0 == r1) goto L_0x0084
                r19 = r7
                int r19 = r19.getState()
                r18 = r19
                r19 = 0
                r8 = r19
                r19 = r18
                r20 = 5
                r0 = r19
                r1 = r20
                if (r0 != r1) goto L_0x0105
            L_0x0084:
                r19 = r7
                long r19 = r19.getLastPositionUpdateTime()
                r9 = r19
                long r19 = android.os.SystemClock.elapsedRealtime()
                r11 = r19
                r19 = r9
                r21 = 0
                int r19 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
                r13 = r19
                r19 = 0
                r8 = r19
                r19 = r13
                if (r19 <= 0) goto L_0x0105
                r19 = r7
                float r19 = r19.getPlaybackSpeed()
                r20 = r11
                r22 = r9
                long r20 = r20 - r22
                r0 = r20
                float r0 = (float) r0
                r20 = r0
                float r19 = r19 * r20
                r0 = r19
                long r0 = (long) r0
                r19 = r0
                r21 = r7
                long r21 = r21.getPosition()
                long r19 = r19 + r21
                r14 = r19
                r19 = r3
                r21 = 0
                int r19 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
                if (r19 < 0) goto L_0x0117
                r19 = r14
                r21 = r3
                int r19 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
                if (r19 <= 0) goto L_0x0117
                r19 = r3
                r14 = r19
            L_0x00d8:
                android.support.v4.media.session.PlaybackStateCompat$Builder r19 = new android.support.v4.media.session.PlaybackStateCompat$Builder
                r26 = r19
                r19 = r26
                r20 = r26
                r21 = r7
                r20.<init>(r21)
                r16 = r19
                r19 = r16
                r20 = r7
                int r20 = r20.getState()
                r21 = r14
                r23 = r7
                float r23 = r23.getPlaybackSpeed()
                r24 = r11
                android.support.v4.media.session.PlaybackStateCompat$Builder r19 = r19.setState(r20, r21, r23, r24)
                r19 = r16
                android.support.v4.media.session.PlaybackStateCompat r19 = r19.build()
                r8 = r19
            L_0x0105:
                r19 = r8
                if (r19 != 0) goto L_0x0124
                r19 = r7
                r2 = r19
            L_0x010d:
                return r2
            L_0x010e:
                r19 = move-exception
                r6 = r19
                r19 = r5
                monitor-exit(r19)     // Catch:{ all -> 0x010e }
                r19 = r6
                throw r19
            L_0x0117:
                r19 = r14
                r21 = 0
                int r19 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
                if (r19 >= 0) goto L_0x00d8
                r19 = 0
                r14 = r19
                goto L_0x00d8
            L_0x0124:
                r19 = r8
                r2 = r19
                goto L_0x010d
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.media.session.MediaSessionCompat.MediaSessionImplBase.getStateWithUpdatedPosition():android.support.v4.media.session.PlaybackStateCompat");
        }

        private void sendEvent(String str, Bundle bundle) {
            String str2 = str;
            Bundle bundle2 = bundle;
            for (int beginBroadcast = -1 + this.mControllerCallbacks.beginBroadcast(); beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onEvent(str2, bundle2);
                } catch (RemoteException e) {
                    RemoteException remoteException = e;
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(MediaMetadataCompat mediaMetadataCompat) {
            MediaMetadataCompat mediaMetadataCompat2 = mediaMetadataCompat;
            for (int beginBroadcast = -1 + this.mControllerCallbacks.beginBroadcast(); beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onMetadataChanged(mediaMetadataCompat2);
                } catch (RemoteException e) {
                    RemoteException remoteException = e;
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(List<QueueItem> list) {
            List<QueueItem> list2 = list;
            for (int beginBroadcast = -1 + this.mControllerCallbacks.beginBroadcast(); beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onQueueChanged(list2);
                } catch (RemoteException e) {
                    RemoteException remoteException = e;
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            for (int beginBroadcast = -1 + this.mControllerCallbacks.beginBroadcast(); beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onQueueTitleChanged(charSequence2);
                } catch (RemoteException e) {
                    RemoteException remoteException = e;
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendSessionDestroyed() {
            for (int beginBroadcast = -1 + this.mControllerCallbacks.beginBroadcast(); beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onSessionDestroyed();
                } catch (RemoteException e) {
                    RemoteException remoteException = e;
                }
            }
            this.mControllerCallbacks.finishBroadcast();
            this.mControllerCallbacks.kill();
        }

        private void sendState(PlaybackStateCompat playbackStateCompat) {
            PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
            for (int beginBroadcast = -1 + this.mControllerCallbacks.beginBroadcast(); beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onPlaybackStateChanged(playbackStateCompat2);
                } catch (RemoteException e) {
                    RemoteException remoteException = e;
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        /* access modifiers changed from: private */
        public void sendVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
            ParcelableVolumeInfo parcelableVolumeInfo2 = parcelableVolumeInfo;
            for (int beginBroadcast = -1 + this.mControllerCallbacks.beginBroadcast(); beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onVolumeInfoChanged(parcelableVolumeInfo2);
                } catch (RemoteException e) {
                    RemoteException remoteException = e;
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        /* access modifiers changed from: private */
        public void setVolumeTo(int i, int i2) {
            int i3 = i;
            int i4 = i2;
            if (this.mVolumeType != 2) {
                this.mAudioManager.setStreamVolume(this.mLocalStream, i3, i4);
            } else if (this.mVolumeProvider != null) {
                this.mVolumeProvider.onSetVolumeTo(i3);
            }
        }

        private boolean update() {
            boolean z;
            if (this.mIsActive) {
                if (VERSION.SDK_INT >= 8) {
                    if (!this.mIsMbrRegistered && (1 & this.mFlags) != 0) {
                        if (VERSION.SDK_INT >= 18) {
                            MediaSessionCompatApi18.registerMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver, this.mComponentName);
                        } else {
                            MediaSessionCompatApi8.registerMediaButtonEventReceiver(this.mContext, this.mComponentName);
                        }
                        this.mIsMbrRegistered = true;
                    } else if (this.mIsMbrRegistered && (1 & this.mFlags) == 0) {
                        if (VERSION.SDK_INT >= 18) {
                            MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver, this.mComponentName);
                        } else {
                            MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(this.mContext, this.mComponentName);
                        }
                        this.mIsMbrRegistered = false;
                    }
                }
                z = false;
                if (VERSION.SDK_INT >= 14) {
                    if (this.mIsRccRegistered || (2 & this.mFlags) == 0) {
                        z = false;
                        if (this.mIsRccRegistered) {
                            z = false;
                            if ((2 & this.mFlags) == 0) {
                                MediaSessionCompatApi14.setState(this.mRccObj, 0);
                                MediaSessionCompatApi14.unregisterRemoteControlClient(this.mContext, this.mRccObj);
                                this.mIsRccRegistered = false;
                                return false;
                            }
                        }
                    } else {
                        MediaSessionCompatApi14.registerRemoteControlClient(this.mContext, this.mRccObj);
                        this.mIsRccRegistered = true;
                        z = true;
                    }
                }
            } else {
                if (this.mIsMbrRegistered) {
                    if (VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver, this.mComponentName);
                    } else {
                        MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(this.mContext, this.mComponentName);
                    }
                    this.mIsMbrRegistered = false;
                }
                z = false;
                if (this.mIsRccRegistered) {
                    MediaSessionCompatApi14.setState(this.mRccObj, 0);
                    MediaSessionCompatApi14.unregisterRemoteControlClient(this.mContext, this.mRccObj);
                    this.mIsRccRegistered = false;
                    return false;
                }
            }
            return z;
        }

        public Object getMediaSession() {
            return null;
        }

        public Object getRemoteControlClient() {
            return this.mRccObj;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return this.mIsActive;
        }

        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            boolean update = update();
            sendSessionDestroyed();
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            sendEvent(str, bundle);
        }

        public void setActive(boolean z) {
            boolean z2 = z;
            if (z2 != this.mIsActive) {
                this.mIsActive = z2;
                if (update()) {
                    setMetadata(this.mMetadata);
                    setPlaybackState(this.mState);
                }
            }
        }

        public void setCallback(Callback callback, Handler handler) {
            C00772 r11;
            Handler handler2;
            Callback callback2 = callback;
            Handler handler3 = handler;
            if (callback2 != this.mCallback) {
                if (callback2 == null || VERSION.SDK_INT < 18) {
                    if (VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.mRccObj, null);
                    }
                    if (VERSION.SDK_INT >= 19) {
                        MediaSessionCompatApi19.setOnMetadataUpdateListener(this.mRccObj, null);
                    }
                } else {
                    if (handler3 == null) {
                        Handler handler4 = handler2;
                        Handler handler5 = new Handler();
                    }
                    C00772 r7 = r11;
                    final Callback callback3 = callback2;
                    C00772 r8 = new Callback(this) {
                        final /* synthetic */ MediaSessionImplBase this$0;

                        {
                            Callback callback = r7;
                            this.this$0 = r6;
                        }

                        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                            String str2 = str;
                            Bundle bundle2 = bundle;
                            ResultReceiver resultReceiver2 = resultReceiver;
                            callback3.onCommand(str2, bundle2, resultReceiver2);
                        }

                        public void onFastForward() {
                            callback3.onFastForward();
                        }

                        public boolean onMediaButtonEvent(Intent intent) {
                            return callback3.onMediaButtonEvent(intent);
                        }

                        public void onPause() {
                            callback3.onPause();
                        }

                        public void onPlay() {
                            callback3.onPlay();
                        }

                        public void onRewind() {
                            callback3.onRewind();
                        }

                        public void onSeekTo(long j) {
                            long j2 = j;
                            callback3.onSeekTo(j2);
                        }

                        public void onSetRating(Object obj) {
                            callback3.onSetRating(RatingCompat.fromRating(obj));
                        }

                        public void onSkipToNext() {
                            callback3.onSkipToNext();
                        }

                        public void onSkipToPrevious() {
                            callback3.onSkipToPrevious();
                        }

                        public void onStop() {
                            callback3.onStop();
                        }
                    };
                    C00772 r4 = r7;
                    if (VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.mRccObj, MediaSessionCompatApi18.createPlaybackPositionUpdateListener(r4));
                    }
                    if (VERSION.SDK_INT >= 19) {
                        MediaSessionCompatApi19.setOnMetadataUpdateListener(this.mRccObj, MediaSessionCompatApi19.createMetadataUpdateListener(r4));
                    }
                }
                this.mCallback = callback2;
            }
        }

        public void setExtras(Bundle bundle) {
            Bundle bundle2 = bundle;
            this.mExtras = bundle2;
        }

        public void setFlags(int i) {
            int i2 = i;
            Object obj = this.mLock;
            synchronized (obj) {
                try {
                    this.mFlags = i2;
                } catch (Throwable th) {
                    while (true) {
                        Throwable th2 = th;
                        Object obj2 = obj;
                        throw th2;
                    }
                }
            }
            boolean update = update();
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        }

        /* JADX INFO: finally extract failed */
        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            MediaMetadataCompat mediaMetadataCompat2 = mediaMetadataCompat;
            Object obj = this.mLock;
            synchronized (obj) {
                try {
                    this.mMetadata = mediaMetadataCompat2;
                } catch (Throwable th) {
                    while (true) {
                        Throwable th2 = th;
                        Object obj2 = obj;
                        throw th2;
                    }
                }
            }
            sendMetadata(mediaMetadataCompat2);
            if (this.mIsActive) {
                if (VERSION.SDK_INT >= 19) {
                    Object obj3 = this.mRccObj;
                    Bundle bundle = null;
                    if (mediaMetadataCompat2 != null) {
                        bundle = mediaMetadataCompat2.getBundle();
                    }
                    MediaSessionCompatApi19.setMetadata(obj3, bundle, this.mState == null ? 0 : this.mState.getActions());
                } else if (VERSION.SDK_INT >= 14) {
                    Object obj4 = this.mRccObj;
                    Bundle bundle2 = null;
                    if (mediaMetadataCompat2 != null) {
                        bundle2 = mediaMetadataCompat2.getBundle();
                    }
                    MediaSessionCompatApi14.setMetadata(obj4, bundle2);
                }
            }
        }

        /* JADX INFO: finally extract failed */
        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
            Object obj = this.mLock;
            synchronized (obj) {
                try {
                    this.mState = playbackStateCompat2;
                } catch (Throwable th) {
                    while (true) {
                        Throwable th2 = th;
                        Object obj2 = obj;
                        throw th2;
                    }
                }
            }
            sendState(playbackStateCompat2);
            if (this.mIsActive) {
                if (playbackStateCompat2 != null) {
                    if (VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setState(this.mRccObj, playbackStateCompat2.getState(), playbackStateCompat2.getPosition(), playbackStateCompat2.getPlaybackSpeed(), playbackStateCompat2.getLastPositionUpdateTime());
                    } else if (VERSION.SDK_INT >= 14) {
                        MediaSessionCompatApi14.setState(this.mRccObj, playbackStateCompat2.getState());
                    }
                    if (VERSION.SDK_INT >= 19) {
                        MediaSessionCompatApi19.setTransportControlFlags(this.mRccObj, playbackStateCompat2.getActions());
                    } else if (VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setTransportControlFlags(this.mRccObj, playbackStateCompat2.getActions());
                    } else if (VERSION.SDK_INT >= 14) {
                        MediaSessionCompatApi14.setTransportControlFlags(this.mRccObj, playbackStateCompat2.getActions());
                    }
                } else if (VERSION.SDK_INT >= 14) {
                    MediaSessionCompatApi14.setState(this.mRccObj, 0);
                    MediaSessionCompatApi14.setTransportControlFlags(this.mRccObj, 0);
                }
            }
        }

        public void setPlaybackToLocal(int i) {
            ParcelableVolumeInfo parcelableVolumeInfo;
            int i2 = i;
            if (this.mVolumeProvider != null) {
                this.mVolumeProvider.setCallback(null);
            }
            this.mVolumeType = 1;
            ParcelableVolumeInfo parcelableVolumeInfo2 = parcelableVolumeInfo;
            ParcelableVolumeInfo parcelableVolumeInfo3 = new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, 2, this.mAudioManager.getStreamMaxVolume(this.mLocalStream), this.mAudioManager.getStreamVolume(this.mLocalStream));
            sendVolumeInfoChanged(parcelableVolumeInfo2);
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            ParcelableVolumeInfo parcelableVolumeInfo;
            IllegalArgumentException illegalArgumentException;
            VolumeProviderCompat volumeProviderCompat2 = volumeProviderCompat;
            if (volumeProviderCompat2 == null) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("volumeProvider may not be null");
                throw illegalArgumentException2;
            }
            if (this.mVolumeProvider != null) {
                this.mVolumeProvider.setCallback(null);
            }
            this.mVolumeType = 2;
            this.mVolumeProvider = volumeProviderCompat2;
            ParcelableVolumeInfo parcelableVolumeInfo2 = parcelableVolumeInfo;
            ParcelableVolumeInfo parcelableVolumeInfo3 = new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume());
            sendVolumeInfoChanged(parcelableVolumeInfo2);
            volumeProviderCompat2.setCallback(this.mVolumeCallback);
        }

        public void setQueue(List<QueueItem> list) {
            List<QueueItem> list2 = list;
            this.mQueue = list2;
            sendQueue(list2);
        }

        public void setQueueTitle(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            this.mQueueTitle = charSequence2;
            sendQueueTitle(charSequence2);
        }

        public void setRatingType(int i) {
            int i2 = i;
            this.mRatingType = i2;
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            PendingIntent pendingIntent2 = pendingIntent;
            Object obj = this.mLock;
            synchronized (obj) {
                try {
                    this.mSessionActivity = pendingIntent2;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$OnActiveChangeListener */
    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem */
    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR;
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private Object mItem;

        static {
            C00781 r2;
            C00781 r0 = r2;
            C00781 r1 = new Creator<QueueItem>() {
                public QueueItem createFromParcel(Parcel parcel) {
                    QueueItem queueItem;
                    QueueItem queueItem2 = queueItem;
                    QueueItem queueItem3 = new QueueItem(parcel, (C00751) null);
                    return queueItem2;
                }

                public QueueItem[] newArray(int i) {
                    return new QueueItem[i];
                }
            };
            CREATOR = r0;
        }

        private QueueItem(Parcel parcel) {
            Parcel parcel2 = parcel;
            this.mDescription = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel2);
            this.mId = parcel2.readLong();
        }

        /* synthetic */ QueueItem(Parcel parcel, C00751 r7) {
            C00751 r2 = r7;
            this(parcel);
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j) {
            this(null, mediaDescriptionCompat, j);
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            IllegalArgumentException illegalArgumentException;
            IllegalArgumentException illegalArgumentException2;
            Object obj2 = obj;
            MediaDescriptionCompat mediaDescriptionCompat2 = mediaDescriptionCompat;
            long j2 = j;
            if (mediaDescriptionCompat2 == null) {
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Description cannot be null.");
                throw illegalArgumentException3;
            } else if (j2 == -1) {
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
                throw illegalArgumentException5;
            } else {
                this.mDescription = mediaDescriptionCompat2;
                this.mId = j2;
                this.mItem = obj2;
            }
        }

        public static QueueItem obtain(Object obj) {
            QueueItem queueItem;
            Object obj2 = obj;
            QueueItem queueItem2 = queueItem;
            QueueItem queueItem3 = new QueueItem(obj2, MediaDescriptionCompat.fromMediaDescription(QueueItem.getDescription(obj2)), QueueItem.getQueueId(obj2));
            return queueItem2;
        }

        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public Object getQueueItem() {
            if (this.mItem != null || VERSION.SDK_INT < 21) {
                return this.mItem;
            }
            this.mItem = QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
            return this.mItem;
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append("MediaSession.QueueItem {Description=").append(this.mDescription).append(", Id=").append(this.mId).append(" }").toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            Parcel parcel2 = parcel;
            this.mDescription.writeToParcel(parcel2, i);
            parcel2.writeLong(this.mId);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper */
    static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR;
        /* access modifiers changed from: private */
        public ResultReceiver mResultReceiver;

        static {
            C00791 r2;
            C00791 r0 = r2;
            C00791 r1 = new Creator<ResultReceiverWrapper>() {
                public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                    ResultReceiverWrapper resultReceiverWrapper;
                    ResultReceiverWrapper resultReceiverWrapper2 = resultReceiverWrapper;
                    ResultReceiverWrapper resultReceiverWrapper3 = new ResultReceiverWrapper(parcel);
                    return resultReceiverWrapper2;
                }

                public ResultReceiverWrapper[] newArray(int i) {
                    return new ResultReceiverWrapper[i];
                }
            };
            CREATOR = r0;
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.mResultReceiver = resultReceiver;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Parcel parcel2 = parcel;
            int i2 = i;
            this.mResultReceiver.writeToParcel(parcel2, i2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.MediaSessionCompat$SessionFlags */
    public @interface SessionFlags {
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token */
    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR;
        private final Object mInner;

        static {
            C00801 r2;
            C00801 r0 = r2;
            C00801 r1 = new Creator<Token>() {
                public Token createFromParcel(Parcel parcel) {
                    Token token;
                    Parcel parcel2 = parcel;
                    Token token2 = token;
                    Token token3 = new Token(VERSION.SDK_INT >= 21 ? parcel2.readParcelable(null) : parcel2.readStrongBinder());
                    return token2;
                }

                public Token[] newArray(int i) {
                    return new Token[i];
                }
            };
            CREATOR = r0;
        }

        Token(Object obj) {
            this.mInner = obj;
        }

        public static Token fromToken(Object obj) {
            Token token;
            Object obj2 = obj;
            if (obj2 == null || VERSION.SDK_INT < 21) {
                return null;
            }
            Token token2 = token;
            Token token3 = new Token(MediaSessionCompatApi21.verifyToken(obj2));
            return token2;
        }

        public int describeContents() {
            return 0;
        }

        public Object getToken() {
            return this.mInner;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Parcel parcel2 = parcel;
            int i2 = i;
            if (VERSION.SDK_INT >= 21) {
                parcel2.writeParcelable((Parcelable) this.mInner, i2);
            } else {
                parcel2.writeStrongBinder((IBinder) this.mInner);
            }
        }
    }

    private MediaSessionCompat(Context context, MediaSessionImpl mediaSessionImpl) {
        ArrayList<OnActiveChangeListener> arrayList;
        MediaControllerCompat mediaControllerCompat;
        Context context2 = context;
        MediaSessionImpl mediaSessionImpl2 = mediaSessionImpl;
        ArrayList<OnActiveChangeListener> arrayList2 = arrayList;
        ArrayList<OnActiveChangeListener> arrayList3 = new ArrayList<>();
        this.mActiveListeners = arrayList2;
        this.mImpl = mediaSessionImpl2;
        MediaControllerCompat mediaControllerCompat2 = mediaControllerCompat;
        MediaControllerCompat mediaControllerCompat3 = new MediaControllerCompat(context2, this);
        this.mController = mediaControllerCompat2;
    }

    public MediaSessionCompat(Context context, String str) {
        this(context, str, null, null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        ArrayList<OnActiveChangeListener> arrayList;
        MediaSessionImplBase mediaSessionImplBase;
        MediaControllerCompat mediaControllerCompat;
        MediaSessionImplApi21 mediaSessionImplApi21;
        Intent intent;
        Intent intent2;
        ComponentName componentName2;
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        Context context2 = context;
        String str2 = str;
        ComponentName componentName3 = componentName;
        PendingIntent pendingIntent2 = pendingIntent;
        ArrayList<OnActiveChangeListener> arrayList2 = arrayList;
        ArrayList<OnActiveChangeListener> arrayList3 = new ArrayList<>();
        this.mActiveListeners = arrayList2;
        if (context2 == null) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("context must not be null");
            throw illegalArgumentException3;
        } else if (TextUtils.isEmpty(str2)) {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("tag must not be null or empty");
            throw illegalArgumentException5;
        } else {
            if (componentName3 == null) {
                Intent intent3 = intent2;
                Intent intent4 = new Intent("android.intent.action.MEDIA_BUTTON");
                Intent intent5 = intent3;
                Intent intent6 = intent5.setPackage(context2.getPackageName());
                List queryBroadcastReceivers = context2.getPackageManager().queryBroadcastReceivers(intent5, 0);
                if (queryBroadcastReceivers.size() == 1) {
                    ResolveInfo resolveInfo = (ResolveInfo) queryBroadcastReceivers.get(0);
                    ComponentName componentName4 = componentName2;
                    ComponentName componentName5 = new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                    componentName3 = componentName4;
                } else if (queryBroadcastReceivers.size() > 1) {
                    int w = Log.w(TAG, "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, using null. Provide a specific ComponentName to use as this session's media button receiver");
                }
            }
            if (componentName3 != null && pendingIntent2 == null) {
                Intent intent7 = intent;
                Intent intent8 = new Intent("android.intent.action.MEDIA_BUTTON");
                Intent intent9 = intent7;
                Intent component = intent9.setComponent(componentName3);
                pendingIntent2 = PendingIntent.getBroadcast(context2, 0, intent9, 0);
            }
            if (VERSION.SDK_INT >= 21) {
                MediaSessionImplApi21 mediaSessionImplApi212 = mediaSessionImplApi21;
                MediaSessionImplApi21 mediaSessionImplApi213 = new MediaSessionImplApi21(context2, str2);
                this.mImpl = mediaSessionImplApi212;
                this.mImpl.setMediaButtonReceiver(pendingIntent2);
            } else {
                MediaSessionImplBase mediaSessionImplBase2 = mediaSessionImplBase;
                MediaSessionImplBase mediaSessionImplBase3 = new MediaSessionImplBase(context2, str2, componentName3, pendingIntent2);
                this.mImpl = mediaSessionImplBase2;
            }
            MediaControllerCompat mediaControllerCompat2 = mediaControllerCompat;
            MediaControllerCompat mediaControllerCompat3 = new MediaControllerCompat(context2, this);
            this.mController = mediaControllerCompat2;
        }
    }

    public static MediaSessionCompat obtain(Context context, Object obj) {
        MediaSessionCompat mediaSessionCompat;
        MediaSessionImplApi21 mediaSessionImplApi21;
        MediaSessionCompat mediaSessionCompat2 = mediaSessionCompat;
        Context context2 = context;
        MediaSessionImplApi21 mediaSessionImplApi212 = mediaSessionImplApi21;
        MediaSessionImplApi21 mediaSessionImplApi213 = new MediaSessionImplApi21(obj);
        MediaSessionCompat mediaSessionCompat3 = new MediaSessionCompat(context2, (MediaSessionImpl) mediaSessionImplApi212);
        return mediaSessionCompat2;
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        IllegalArgumentException illegalArgumentException;
        OnActiveChangeListener onActiveChangeListener2 = onActiveChangeListener;
        if (onActiveChangeListener2 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Listener may not be null");
            throw illegalArgumentException2;
        }
        boolean add = this.mActiveListeners.add(onActiveChangeListener2);
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void release() {
        this.mImpl.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        IllegalArgumentException illegalArgumentException;
        OnActiveChangeListener onActiveChangeListener2 = onActiveChangeListener;
        if (onActiveChangeListener2 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Listener may not be null");
            throw illegalArgumentException2;
        }
        boolean remove = this.mActiveListeners.remove(onActiveChangeListener2);
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        IllegalArgumentException illegalArgumentException;
        String str2 = str;
        Bundle bundle2 = bundle;
        if (TextUtils.isEmpty(str2)) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("event cannot be null or empty");
            throw illegalArgumentException2;
        }
        this.mImpl.sendSessionEvent(str2, bundle2);
    }

    public void setActive(boolean z) {
        this.mImpl.setActive(z);
        Iterator it = this.mActiveListeners.iterator();
        while (it.hasNext()) {
            ((OnActiveChangeListener) it.next()).onActiveChanged();
        }
    }

    public void setCallback(Callback callback) {
        setCallback(callback, null);
    }

    public void setCallback(Callback callback, Handler handler) {
        Handler handler2;
        Callback callback2 = callback;
        Handler handler3 = handler;
        MediaSessionImpl mediaSessionImpl = this.mImpl;
        if (handler3 == null) {
            Handler handler4 = handler2;
            Handler handler5 = new Handler();
            handler3 = handler4;
        }
        mediaSessionImpl.setCallback(callback2, handler3);
    }

    public void setExtras(Bundle bundle) {
        Bundle bundle2 = bundle;
        this.mImpl.setExtras(bundle2);
    }

    public void setFlags(int i) {
        int i2 = i;
        this.mImpl.setFlags(i2);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        PendingIntent pendingIntent2 = pendingIntent;
        this.mImpl.setMediaButtonReceiver(pendingIntent2);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        MediaMetadataCompat mediaMetadataCompat2 = mediaMetadataCompat;
        this.mImpl.setMetadata(mediaMetadataCompat2);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
        this.mImpl.setPlaybackState(playbackStateCompat2);
    }

    public void setPlaybackToLocal(int i) {
        int i2 = i;
        this.mImpl.setPlaybackToLocal(i2);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        IllegalArgumentException illegalArgumentException;
        VolumeProviderCompat volumeProviderCompat2 = volumeProviderCompat;
        if (volumeProviderCompat2 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("volumeProvider may not be null!");
            throw illegalArgumentException2;
        }
        this.mImpl.setPlaybackToRemote(volumeProviderCompat2);
    }

    public void setQueue(List<QueueItem> list) {
        List<QueueItem> list2 = list;
        this.mImpl.setQueue(list2);
    }

    public void setQueueTitle(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        this.mImpl.setQueueTitle(charSequence2);
    }

    public void setRatingType(int i) {
        int i2 = i;
        this.mImpl.setRatingType(i2);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        PendingIntent pendingIntent2 = pendingIntent;
        this.mImpl.setSessionActivity(pendingIntent2);
    }
}
