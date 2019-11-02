package android.support.p000v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes.Builder;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.MediaSession.Token;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaSessionCompatApi21 */
class MediaSessionCompatApi21 {

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi21$Callback */
    interface Callback {
        void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void onCustomAction(String str, Bundle bundle);

        void onFastForward();

        boolean onMediaButtonEvent(Intent intent);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(String str, Bundle bundle);

        void onPlayFromSearch(String str, Bundle bundle);

        void onRewind();

        void onSeekTo(long j);

        void onSetRating(Object obj);

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long j);

        void onStop();
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi21$CallbackProxy */
    static class CallbackProxy<T extends Callback> extends android.media.session.MediaSession.Callback {
        protected final T mCallback;

        public CallbackProxy(T t) {
            this.mCallback = t;
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            String str2 = str;
            Bundle bundle2 = bundle;
            ResultReceiver resultReceiver2 = resultReceiver;
            this.mCallback.onCommand(str2, bundle2, resultReceiver2);
        }

        public void onCustomAction(String str, Bundle bundle) {
            String str2 = str;
            Bundle bundle2 = bundle;
            this.mCallback.onCustomAction(str2, bundle2);
        }

        public void onFastForward() {
            this.mCallback.onFastForward();
        }

        public boolean onMediaButtonEvent(Intent intent) {
            Intent intent2 = intent;
            return this.mCallback.onMediaButtonEvent(intent2) || super.onMediaButtonEvent(intent2);
        }

        public void onPause() {
            this.mCallback.onPause();
        }

        public void onPlay() {
            this.mCallback.onPlay();
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
            String str2 = str;
            Bundle bundle2 = bundle;
            this.mCallback.onPlayFromMediaId(str2, bundle2);
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
            String str2 = str;
            Bundle bundle2 = bundle;
            this.mCallback.onPlayFromSearch(str2, bundle2);
        }

        public void onRewind() {
            this.mCallback.onRewind();
        }

        public void onSeekTo(long j) {
            long j2 = j;
            this.mCallback.onSeekTo(j2);
        }

        public void onSetRating(Rating rating) {
            Rating rating2 = rating;
            this.mCallback.onSetRating(rating2);
        }

        public void onSkipToNext() {
            this.mCallback.onSkipToNext();
        }

        public void onSkipToPrevious() {
            this.mCallback.onSkipToPrevious();
        }

        public void onSkipToQueueItem(long j) {
            long j2 = j;
            this.mCallback.onSkipToQueueItem(j2);
        }

        public void onStop() {
            this.mCallback.onStop();
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi21$QueueItem */
    static class QueueItem {
        QueueItem() {
        }

        public static Object createItem(Object obj, long j) {
            android.media.session.MediaSession.QueueItem queueItem;
            android.media.session.MediaSession.QueueItem queueItem2 = queueItem;
            android.media.session.MediaSession.QueueItem queueItem3 = new android.media.session.MediaSession.QueueItem((MediaDescription) obj, j);
            return queueItem2;
        }

        public static Object getDescription(Object obj) {
            return ((android.media.session.MediaSession.QueueItem) obj).getDescription();
        }

        public static long getQueueId(Object obj) {
            return ((android.media.session.MediaSession.QueueItem) obj).getQueueId();
        }
    }

    MediaSessionCompatApi21() {
    }

    public static Object createCallback(Callback callback) {
        CallbackProxy callbackProxy;
        CallbackProxy callbackProxy2 = callbackProxy;
        CallbackProxy callbackProxy3 = new CallbackProxy(callback);
        return callbackProxy2;
    }

    public static Object createSession(Context context, String str) {
        MediaSession mediaSession;
        MediaSession mediaSession2 = mediaSession;
        MediaSession mediaSession3 = new MediaSession(context, str);
        return mediaSession2;
    }

    public static Parcelable getSessionToken(Object obj) {
        return ((MediaSession) obj).getSessionToken();
    }

    public static boolean isActive(Object obj) {
        return ((MediaSession) obj).isActive();
    }

    public static void release(Object obj) {
        ((MediaSession) obj).release();
    }

    public static void sendSessionEvent(Object obj, String str, Bundle bundle) {
        ((MediaSession) obj).sendSessionEvent(str, bundle);
    }

    public static void setActive(Object obj, boolean z) {
        ((MediaSession) obj).setActive(z);
    }

    public static void setCallback(Object obj, Object obj2, Handler handler) {
        ((MediaSession) obj).setCallback((android.media.session.MediaSession.Callback) obj2, handler);
    }

    public static void setExtras(Object obj, Bundle bundle) {
        ((MediaSession) obj).setExtras(bundle);
    }

    public static void setFlags(Object obj, int i) {
        ((MediaSession) obj).setFlags(i);
    }

    public static void setMediaButtonReceiver(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setMediaButtonReceiver(pendingIntent);
    }

    public static void setMetadata(Object obj, Object obj2) {
        ((MediaSession) obj).setMetadata((MediaMetadata) obj2);
    }

    public static void setPlaybackState(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackState((PlaybackState) obj2);
    }

    public static void setPlaybackToLocal(Object obj, int i) {
        Builder builder;
        Object obj2 = obj;
        int i2 = i;
        Builder builder2 = builder;
        Builder builder3 = new Builder();
        Builder builder4 = builder2;
        Builder legacyStreamType = builder4.setLegacyStreamType(i2);
        ((MediaSession) obj2).setPlaybackToLocal(builder4.build());
    }

    public static void setPlaybackToRemote(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackToRemote((VolumeProvider) obj2);
    }

    public static void setQueue(Object obj, List<Object> list) {
        ArrayList arrayList;
        Object obj2 = obj;
        List<Object> list2 = list;
        if (list2 == null) {
            ((MediaSession) obj2).setQueue(null);
            return;
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            boolean add = arrayList4.add((android.media.session.MediaSession.QueueItem) it.next());
        }
        ((MediaSession) obj2).setQueue(arrayList4);
    }

    public static void setQueueTitle(Object obj, CharSequence charSequence) {
        ((MediaSession) obj).setQueueTitle(charSequence);
    }

    public static void setSessionActivity(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setSessionActivity(pendingIntent);
    }

    public static Object verifySession(Object obj) {
        IllegalArgumentException illegalArgumentException;
        Object obj2 = obj;
        if (obj2 instanceof MediaSession) {
            return obj2;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("mediaSession is not a valid MediaSession object");
        throw illegalArgumentException2;
    }

    public static Object verifyToken(Object obj) {
        IllegalArgumentException illegalArgumentException;
        Object obj2 = obj;
        if (obj2 instanceof Token) {
            return obj2;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("token is not a valid MediaSession.Token object");
        throw illegalArgumentException2;
    }
}
