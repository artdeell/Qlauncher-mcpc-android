package android.support.p000v4.media.session;

import android.net.Uri;
import android.os.Bundle;

/* renamed from: android.support.v4.media.session.MediaSessionCompatApi23 */
class MediaSessionCompatApi23 {

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi23$Callback */
    public interface Callback extends Callback {
        void onPlayFromUri(Uri uri, Bundle bundle);
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi23$CallbackProxy */
    static class CallbackProxy<T extends Callback> extends CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
            Uri uri2 = uri;
            Bundle bundle2 = bundle;
            ((Callback) this.mCallback).onPlayFromUri(uri2, bundle2);
        }
    }

    MediaSessionCompatApi23() {
    }

    public static Object createCallback(Callback callback) {
        CallbackProxy callbackProxy;
        CallbackProxy callbackProxy2 = callbackProxy;
        CallbackProxy callbackProxy3 = new CallbackProxy(callback);
        return callbackProxy2;
    }
}
