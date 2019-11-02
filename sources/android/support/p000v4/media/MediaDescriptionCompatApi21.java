package android.support.p000v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* renamed from: android.support.v4.media.MediaDescriptionCompatApi21 */
class MediaDescriptionCompatApi21 {

    /* renamed from: android.support.v4.media.MediaDescriptionCompatApi21$Builder */
    static class Builder {
        Builder() {
        }

        public static Object build(Object obj) {
            return ((android.media.MediaDescription.Builder) obj).build();
        }

        public static Object newInstance() {
            android.media.MediaDescription.Builder builder;
            android.media.MediaDescription.Builder builder2 = builder;
            android.media.MediaDescription.Builder builder3 = new android.media.MediaDescription.Builder();
            return builder2;
        }

        public static void setDescription(Object obj, CharSequence charSequence) {
            android.media.MediaDescription.Builder description = ((android.media.MediaDescription.Builder) obj).setDescription(charSequence);
        }

        public static void setExtras(Object obj, Bundle bundle) {
            android.media.MediaDescription.Builder extras = ((android.media.MediaDescription.Builder) obj).setExtras(bundle);
        }

        public static void setIconBitmap(Object obj, Bitmap bitmap) {
            android.media.MediaDescription.Builder iconBitmap = ((android.media.MediaDescription.Builder) obj).setIconBitmap(bitmap);
        }

        public static void setIconUri(Object obj, Uri uri) {
            android.media.MediaDescription.Builder iconUri = ((android.media.MediaDescription.Builder) obj).setIconUri(uri);
        }

        public static void setMediaId(Object obj, String str) {
            android.media.MediaDescription.Builder mediaId = ((android.media.MediaDescription.Builder) obj).setMediaId(str);
        }

        public static void setSubtitle(Object obj, CharSequence charSequence) {
            android.media.MediaDescription.Builder subtitle = ((android.media.MediaDescription.Builder) obj).setSubtitle(charSequence);
        }

        public static void setTitle(Object obj, CharSequence charSequence) {
            android.media.MediaDescription.Builder title = ((android.media.MediaDescription.Builder) obj).setTitle(charSequence);
        }
    }

    MediaDescriptionCompatApi21() {
    }

    public static Object fromParcel(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }

    public static CharSequence getDescription(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    public static Bundle getExtras(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    public static Bitmap getIconBitmap(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri getIconUri(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static String getMediaId(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static CharSequence getSubtitle(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static CharSequence getTitle(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static void writeToParcel(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }
}
