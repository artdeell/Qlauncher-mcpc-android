package android.support.p000v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.Rating;
import java.util.Set;

/* renamed from: android.support.v4.media.MediaMetadataCompatApi21 */
class MediaMetadataCompatApi21 {

    /* renamed from: android.support.v4.media.MediaMetadataCompatApi21$Builder */
    public static class Builder {
        public Builder() {
        }

        public static Object build(Object obj) {
            return ((android.media.MediaMetadata.Builder) obj).build();
        }

        public static Object newInstance() {
            android.media.MediaMetadata.Builder builder;
            android.media.MediaMetadata.Builder builder2 = builder;
            android.media.MediaMetadata.Builder builder3 = new android.media.MediaMetadata.Builder();
            return builder2;
        }

        public static void putBitmap(Object obj, String str, Bitmap bitmap) {
            android.media.MediaMetadata.Builder putBitmap = ((android.media.MediaMetadata.Builder) obj).putBitmap(str, bitmap);
        }

        public static void putLong(Object obj, String str, long j) {
            android.media.MediaMetadata.Builder putLong = ((android.media.MediaMetadata.Builder) obj).putLong(str, j);
        }

        public static void putRating(Object obj, String str, Object obj2) {
            android.media.MediaMetadata.Builder putRating = ((android.media.MediaMetadata.Builder) obj).putRating(str, (Rating) obj2);
        }

        public static void putString(Object obj, String str, String str2) {
            android.media.MediaMetadata.Builder putString = ((android.media.MediaMetadata.Builder) obj).putString(str, str2);
        }

        public static void putText(Object obj, String str, CharSequence charSequence) {
            android.media.MediaMetadata.Builder putText = ((android.media.MediaMetadata.Builder) obj).putText(str, charSequence);
        }
    }

    MediaMetadataCompatApi21() {
    }

    public static Bitmap getBitmap(Object obj, String str) {
        return ((MediaMetadata) obj).getBitmap(str);
    }

    public static long getLong(Object obj, String str) {
        return ((MediaMetadata) obj).getLong(str);
    }

    public static Object getRating(Object obj, String str) {
        return ((MediaMetadata) obj).getRating(str);
    }

    public static CharSequence getText(Object obj, String str) {
        return ((MediaMetadata) obj).getText(str);
    }

    public static Set<String> keySet(Object obj) {
        return ((MediaMetadata) obj).keySet();
    }
}
