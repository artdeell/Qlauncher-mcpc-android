package android.support.p000v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.MetadataEditor;
import android.os.Bundle;
import android.os.ResultReceiver;

/* renamed from: android.support.v4.media.session.MediaSessionCompatApi14 */
class MediaSessionCompatApi14 {
    private static final long ACTION_FAST_FORWARD = 64;
    private static final long ACTION_PAUSE = 2;
    private static final long ACTION_PLAY = 4;
    private static final long ACTION_PLAY_PAUSE = 512;
    private static final long ACTION_REWIND = 8;
    private static final long ACTION_SKIP_TO_NEXT = 32;
    private static final long ACTION_SKIP_TO_PREVIOUS = 16;
    private static final long ACTION_STOP = 1;
    private static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    private static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    private static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    private static final String METADATA_KEY_ART = "android.media.metadata.ART";
    private static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    private static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    private static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    private static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    private static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    private static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    private static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    private static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    private static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    private static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    private static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    static final int RCC_PLAYSTATE_NONE = 0;
    static final int STATE_BUFFERING = 6;
    static final int STATE_CONNECTING = 8;
    static final int STATE_ERROR = 7;
    static final int STATE_FAST_FORWARDING = 4;
    static final int STATE_NONE = 0;
    static final int STATE_PAUSED = 2;
    static final int STATE_PLAYING = 3;
    static final int STATE_REWINDING = 5;
    static final int STATE_SKIPPING_TO_NEXT = 10;
    static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    static final int STATE_STOPPED = 1;

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi14$Callback */
    interface Callback {
        void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void onFastForward();

        boolean onMediaButtonEvent(Intent intent);

        void onPause();

        void onPlay();

        void onRewind();

        void onSeekTo(long j);

        void onSetRating(Object obj);

        void onSkipToNext();

        void onSkipToPrevious();

        void onStop();
    }

    MediaSessionCompatApi14() {
    }

    static void buildOldMetadata(Bundle bundle, MetadataEditor metadataEditor) {
        Bundle bundle2 = bundle;
        MetadataEditor metadataEditor2 = metadataEditor;
        if (bundle2 != null) {
            if (bundle2.containsKey("android.media.metadata.ART")) {
                MetadataEditor putBitmap = metadataEditor2.putBitmap(100, (Bitmap) bundle2.getParcelable("android.media.metadata.ART"));
            } else if (bundle2.containsKey("android.media.metadata.ALBUM_ART")) {
                MetadataEditor putBitmap2 = metadataEditor2.putBitmap(100, (Bitmap) bundle2.getParcelable("android.media.metadata.ALBUM_ART"));
            }
            if (bundle2.containsKey("android.media.metadata.ALBUM")) {
                MetadataEditor putString = metadataEditor2.putString(1, bundle2.getString("android.media.metadata.ALBUM"));
            }
            if (bundle2.containsKey("android.media.metadata.ALBUM_ARTIST")) {
                MetadataEditor putString2 = metadataEditor2.putString(13, bundle2.getString("android.media.metadata.ALBUM_ARTIST"));
            }
            if (bundle2.containsKey("android.media.metadata.ARTIST")) {
                MetadataEditor putString3 = metadataEditor2.putString(2, bundle2.getString("android.media.metadata.ARTIST"));
            }
            if (bundle2.containsKey("android.media.metadata.AUTHOR")) {
                MetadataEditor putString4 = metadataEditor2.putString(3, bundle2.getString("android.media.metadata.AUTHOR"));
            }
            if (bundle2.containsKey("android.media.metadata.COMPILATION")) {
                MetadataEditor putString5 = metadataEditor2.putString(15, bundle2.getString("android.media.metadata.COMPILATION"));
            }
            if (bundle2.containsKey("android.media.metadata.COMPOSER")) {
                MetadataEditor putString6 = metadataEditor2.putString(4, bundle2.getString("android.media.metadata.COMPOSER"));
            }
            if (bundle2.containsKey("android.media.metadata.DATE")) {
                MetadataEditor putString7 = metadataEditor2.putString(5, bundle2.getString("android.media.metadata.DATE"));
            }
            if (bundle2.containsKey("android.media.metadata.DISC_NUMBER")) {
                MetadataEditor putLong = metadataEditor2.putLong(14, bundle2.getLong("android.media.metadata.DISC_NUMBER"));
            }
            if (bundle2.containsKey("android.media.metadata.DURATION")) {
                MetadataEditor putLong2 = metadataEditor2.putLong(9, bundle2.getLong("android.media.metadata.DURATION"));
            }
            if (bundle2.containsKey("android.media.metadata.GENRE")) {
                MetadataEditor putString8 = metadataEditor2.putString(6, bundle2.getString("android.media.metadata.GENRE"));
            }
            if (bundle2.containsKey("android.media.metadata.TITLE")) {
                MetadataEditor putString9 = metadataEditor2.putString(7, bundle2.getString("android.media.metadata.TITLE"));
            }
            if (bundle2.containsKey("android.media.metadata.TRACK_NUMBER")) {
                MetadataEditor putLong3 = metadataEditor2.putLong(0, bundle2.getLong("android.media.metadata.TRACK_NUMBER"));
            }
            if (bundle2.containsKey("android.media.metadata.WRITER")) {
                MetadataEditor putString10 = metadataEditor2.putString(11, bundle2.getString("android.media.metadata.WRITER"));
            }
        }
    }

    public static Object createRemoteControlClient(PendingIntent pendingIntent) {
        RemoteControlClient remoteControlClient;
        RemoteControlClient remoteControlClient2 = remoteControlClient;
        RemoteControlClient remoteControlClient3 = new RemoteControlClient(pendingIntent);
        return remoteControlClient2;
    }

    static int getRccStateFromState(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
            case 8:
                return 8;
            case 7:
                return 9;
            case 9:
                return 7;
            case 10:
            case 11:
                return 6;
            default:
                return -1;
        }
    }

    static int getRccTransportControlFlagsFromActions(long j) {
        long j2 = j;
        int i = 0;
        if ((1 & j2) != 0) {
            i = 0 | 32;
        }
        if ((2 & j2) != 0) {
            i |= 16;
        }
        if ((4 & j2) != 0) {
            i |= 4;
        }
        if ((8 & j2) != 0) {
            i |= 2;
        }
        if ((16 & j2) != 0) {
            i |= 1;
        }
        if ((32 & j2) != 0) {
            i |= 128;
        }
        if ((64 & j2) != 0) {
            i |= 64;
        }
        if ((512 & j2) != 0) {
            i |= 8;
        }
        return i;
    }

    public static void registerRemoteControlClient(Context context, Object obj) {
        ((AudioManager) context.getSystemService("audio")).registerRemoteControlClient((RemoteControlClient) obj);
    }

    public static void setMetadata(Object obj, Bundle bundle) {
        Bundle bundle2 = bundle;
        MetadataEditor editMetadata = ((RemoteControlClient) obj).editMetadata(true);
        buildOldMetadata(bundle2, editMetadata);
        editMetadata.apply();
    }

    public static void setState(Object obj, int i) {
        ((RemoteControlClient) obj).setPlaybackState(getRccStateFromState(i));
    }

    public static void setTransportControlFlags(Object obj, long j) {
        ((RemoteControlClient) obj).setTransportControlFlags(getRccTransportControlFlagsFromActions(j));
    }

    public static void unregisterRemoteControlClient(Context context, Object obj) {
        ((AudioManager) context.getSystemService("audio")).unregisterRemoteControlClient((RemoteControlClient) obj);
    }
}
