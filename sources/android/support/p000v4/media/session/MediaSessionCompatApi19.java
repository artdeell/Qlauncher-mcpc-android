package android.support.p000v4.media.session;

import android.media.MediaMetadataEditor;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.MetadataEditor;
import android.os.Bundle;

/* renamed from: android.support.v4.media.session.MediaSessionCompatApi19 */
class MediaSessionCompatApi19 {
    private static final long ACTION_SET_RATING = 128;
    private static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    private static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    private static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi19$OnMetadataUpdateListener */
    static class OnMetadataUpdateListener<T extends Callback> implements android.media.RemoteControlClient.OnMetadataUpdateListener {
        protected final T mCallback;

        public OnMetadataUpdateListener(T t) {
            this.mCallback = t;
        }

        public void onMetadataUpdate(int i, Object obj) {
            Object obj2 = obj;
            if (i == 268435457 && (obj2 instanceof Rating)) {
                this.mCallback.onSetRating(obj2);
            }
        }
    }

    MediaSessionCompatApi19() {
    }

    static void addNewMetadata(Bundle bundle, MetadataEditor metadataEditor) {
        Bundle bundle2 = bundle;
        MetadataEditor metadataEditor2 = metadataEditor;
        if (bundle2 != null) {
            if (bundle2.containsKey("android.media.metadata.YEAR")) {
                MetadataEditor putLong = metadataEditor2.putLong(8, bundle2.getLong("android.media.metadata.YEAR"));
            }
            if (bundle2.containsKey("android.media.metadata.RATING")) {
                MediaMetadataEditor putObject = metadataEditor2.putObject(101, bundle2.getParcelable("android.media.metadata.RATING"));
            }
            if (bundle2.containsKey("android.media.metadata.USER_RATING")) {
                MediaMetadataEditor putObject2 = metadataEditor2.putObject(268435457, bundle2.getParcelable("android.media.metadata.USER_RATING"));
            }
        }
    }

    public static Object createMetadataUpdateListener(Callback callback) {
        OnMetadataUpdateListener onMetadataUpdateListener;
        OnMetadataUpdateListener onMetadataUpdateListener2 = onMetadataUpdateListener;
        OnMetadataUpdateListener onMetadataUpdateListener3 = new OnMetadataUpdateListener(callback);
        return onMetadataUpdateListener2;
    }

    static int getRccTransportControlFlagsFromActions(long j) {
        long j2 = j;
        int rccTransportControlFlagsFromActions = MediaSessionCompatApi18.getRccTransportControlFlagsFromActions(j2);
        if ((128 & j2) != 0) {
            rccTransportControlFlagsFromActions |= 512;
        }
        return rccTransportControlFlagsFromActions;
    }

    public static void setMetadata(Object obj, Bundle bundle, long j) {
        Bundle bundle2 = bundle;
        long j2 = j;
        MetadataEditor editMetadata = ((RemoteControlClient) obj).editMetadata(true);
        MediaSessionCompatApi14.buildOldMetadata(bundle2, editMetadata);
        addNewMetadata(bundle2, editMetadata);
        if ((128 & j2) != 0) {
            editMetadata.addEditableKey(268435457);
        }
        editMetadata.apply();
    }

    public static void setOnMetadataUpdateListener(Object obj, Object obj2) {
        ((RemoteControlClient) obj).setMetadataUpdateListener((android.media.RemoteControlClient.OnMetadataUpdateListener) obj2);
    }

    public static void setTransportControlFlags(Object obj, long j) {
        ((RemoteControlClient) obj).setTransportControlFlags(getRccTransportControlFlagsFromActions(j));
    }
}
