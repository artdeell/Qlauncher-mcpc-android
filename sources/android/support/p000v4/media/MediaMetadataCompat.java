package android.support.p000v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

/* renamed from: android.support.v4.media.MediaMetadataCompat */
public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR;
    /* access modifiers changed from: private */
    public static final ArrayMap<String, Integer> METADATA_KEYS_TYPE;
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    private static final int METADATA_TYPE_BITMAP = 2;
    private static final int METADATA_TYPE_LONG = 0;
    private static final int METADATA_TYPE_RATING = 3;
    private static final int METADATA_TYPE_TEXT = 1;
    private static final String[] PREFERRED_BITMAP_ORDER;
    private static final String[] PREFERRED_DESCRIPTION_ORDER;
    private static final String[] PREFERRED_URI_ORDER;
    private static final String TAG = "MediaMetadata";
    /* access modifiers changed from: private */
    public final Bundle mBundle;
    private MediaDescriptionCompat mDescription;
    private Object mMetadataObj;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.MediaMetadataCompat$BitmapKey */
    public @interface BitmapKey {
    }

    /* renamed from: android.support.v4.media.MediaMetadataCompat$Builder */
    public static final class Builder {
        private final Bundle mBundle;

        public Builder() {
            Bundle bundle;
            Bundle bundle2 = bundle;
            Bundle bundle3 = new Bundle();
            this.mBundle = bundle2;
        }

        public Builder(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle;
            Bundle bundle2 = bundle;
            Bundle bundle3 = new Bundle(mediaMetadataCompat.mBundle);
            this.mBundle = bundle2;
        }

        public MediaMetadataCompat build() {
            MediaMetadataCompat mediaMetadataCompat;
            MediaMetadataCompat mediaMetadataCompat2 = mediaMetadataCompat;
            MediaMetadataCompat mediaMetadataCompat3 = new MediaMetadataCompat(this.mBundle, (C00621) null);
            return mediaMetadataCompat2;
        }

        public Builder putBitmap(String str, Bitmap bitmap) {
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            String str2 = str;
            Bitmap bitmap2 = bitmap;
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str2) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str2)).intValue() == 2) {
                this.mBundle.putParcelable(str2, bitmap2);
                return this;
            }
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("The ").append(str2).append(" key cannot be used to put a Bitmap").toString());
            throw illegalArgumentException2;
        }

        public Builder putLong(String str, long j) {
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            String str2 = str;
            long j2 = j;
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str2) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str2)).intValue() == 0) {
                this.mBundle.putLong(str2, j2);
                return this;
            }
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("The ").append(str2).append(" key cannot be used to put a long").toString());
            throw illegalArgumentException2;
        }

        public Builder putRating(String str, RatingCompat ratingCompat) {
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            String str2 = str;
            RatingCompat ratingCompat2 = ratingCompat;
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str2) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str2)).intValue() == 3) {
                this.mBundle.putParcelable(str2, ratingCompat2);
                return this;
            }
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("The ").append(str2).append(" key cannot be used to put a Rating").toString());
            throw illegalArgumentException2;
        }

        public Builder putString(String str, String str2) {
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            String str3 = str;
            String str4 = str2;
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str3) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str3)).intValue() == 1) {
                this.mBundle.putCharSequence(str3, str4);
                return this;
            }
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("The ").append(str3).append(" key cannot be used to put a String").toString());
            throw illegalArgumentException2;
        }

        public Builder putText(String str, CharSequence charSequence) {
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            String str2 = str;
            CharSequence charSequence2 = charSequence;
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str2) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str2)).intValue() == 1) {
                this.mBundle.putCharSequence(str2, charSequence2);
                return this;
            }
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("The ").append(str2).append(" key cannot be used to put a CharSequence").toString());
            throw illegalArgumentException2;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.MediaMetadataCompat$LongKey */
    public @interface LongKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.MediaMetadataCompat$RatingKey */
    public @interface RatingKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.MediaMetadataCompat$TextKey */
    public @interface TextKey {
    }

    static {
        ArrayMap<String, Integer> arrayMap;
        C00621 r4;
        ArrayMap<String, Integer> arrayMap2 = arrayMap;
        ArrayMap<String, Integer> arrayMap3 = new ArrayMap<>();
        METADATA_KEYS_TYPE = arrayMap2;
        Object put = METADATA_KEYS_TYPE.put(METADATA_KEY_TITLE, Integer.valueOf(1));
        Object put2 = METADATA_KEYS_TYPE.put(METADATA_KEY_ARTIST, Integer.valueOf(1));
        Object put3 = METADATA_KEYS_TYPE.put(METADATA_KEY_DURATION, Integer.valueOf(0));
        Object put4 = METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM, Integer.valueOf(1));
        Object put5 = METADATA_KEYS_TYPE.put(METADATA_KEY_AUTHOR, Integer.valueOf(1));
        Object put6 = METADATA_KEYS_TYPE.put(METADATA_KEY_WRITER, Integer.valueOf(1));
        Object put7 = METADATA_KEYS_TYPE.put(METADATA_KEY_COMPOSER, Integer.valueOf(1));
        Object put8 = METADATA_KEYS_TYPE.put(METADATA_KEY_COMPILATION, Integer.valueOf(1));
        Object put9 = METADATA_KEYS_TYPE.put(METADATA_KEY_DATE, Integer.valueOf(1));
        Object put10 = METADATA_KEYS_TYPE.put(METADATA_KEY_YEAR, Integer.valueOf(0));
        Object put11 = METADATA_KEYS_TYPE.put(METADATA_KEY_GENRE, Integer.valueOf(1));
        Object put12 = METADATA_KEYS_TYPE.put(METADATA_KEY_TRACK_NUMBER, Integer.valueOf(0));
        Object put13 = METADATA_KEYS_TYPE.put(METADATA_KEY_NUM_TRACKS, Integer.valueOf(0));
        Object put14 = METADATA_KEYS_TYPE.put(METADATA_KEY_DISC_NUMBER, Integer.valueOf(0));
        Object put15 = METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ARTIST, Integer.valueOf(1));
        Object put16 = METADATA_KEYS_TYPE.put(METADATA_KEY_ART, Integer.valueOf(2));
        Object put17 = METADATA_KEYS_TYPE.put(METADATA_KEY_ART_URI, Integer.valueOf(1));
        Object put18 = METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ART, Integer.valueOf(2));
        Object put19 = METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ART_URI, Integer.valueOf(1));
        Object put20 = METADATA_KEYS_TYPE.put(METADATA_KEY_USER_RATING, Integer.valueOf(3));
        Object put21 = METADATA_KEYS_TYPE.put(METADATA_KEY_RATING, Integer.valueOf(3));
        Object put22 = METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_TITLE, Integer.valueOf(1));
        Object put23 = METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_SUBTITLE, Integer.valueOf(1));
        Object put24 = METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_DESCRIPTION, Integer.valueOf(1));
        Object put25 = METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_ICON, Integer.valueOf(2));
        Object put26 = METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_ICON_URI, Integer.valueOf(1));
        Object put27 = METADATA_KEYS_TYPE.put(METADATA_KEY_MEDIA_ID, Integer.valueOf(1));
        String[] strArr = new String[7];
        String[] strArr2 = strArr;
        strArr[0] = METADATA_KEY_TITLE;
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = METADATA_KEY_ARTIST;
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = METADATA_KEY_ALBUM;
        String[] strArr7 = strArr6;
        String[] strArr8 = strArr7;
        strArr7[3] = METADATA_KEY_ALBUM_ARTIST;
        String[] strArr9 = strArr8;
        String[] strArr10 = strArr9;
        strArr9[4] = METADATA_KEY_WRITER;
        String[] strArr11 = strArr10;
        String[] strArr12 = strArr11;
        strArr11[5] = METADATA_KEY_AUTHOR;
        String[] strArr13 = strArr12;
        String[] strArr14 = strArr13;
        strArr13[6] = METADATA_KEY_COMPOSER;
        PREFERRED_DESCRIPTION_ORDER = strArr14;
        String[] strArr15 = new String[3];
        String[] strArr16 = strArr15;
        strArr15[0] = METADATA_KEY_DISPLAY_ICON;
        String[] strArr17 = strArr16;
        String[] strArr18 = strArr17;
        strArr17[1] = METADATA_KEY_ART;
        String[] strArr19 = strArr18;
        String[] strArr20 = strArr19;
        strArr19[2] = METADATA_KEY_ALBUM_ART;
        PREFERRED_BITMAP_ORDER = strArr20;
        String[] strArr21 = new String[3];
        String[] strArr22 = strArr21;
        strArr21[0] = METADATA_KEY_DISPLAY_ICON_URI;
        String[] strArr23 = strArr22;
        String[] strArr24 = strArr23;
        strArr23[1] = METADATA_KEY_ART_URI;
        String[] strArr25 = strArr24;
        String[] strArr26 = strArr25;
        strArr25[2] = METADATA_KEY_ALBUM_ART_URI;
        PREFERRED_URI_ORDER = strArr26;
        C00621 r0 = r4;
        C00621 r1 = new Creator<MediaMetadataCompat>() {
            public MediaMetadataCompat createFromParcel(Parcel parcel) {
                MediaMetadataCompat mediaMetadataCompat;
                MediaMetadataCompat mediaMetadataCompat2 = mediaMetadataCompat;
                MediaMetadataCompat mediaMetadataCompat3 = new MediaMetadataCompat(parcel, (C00621) null);
                return mediaMetadataCompat2;
            }

            public MediaMetadataCompat[] newArray(int i) {
                return new MediaMetadataCompat[i];
            }
        };
        CREATOR = r0;
    }

    private MediaMetadataCompat(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3 = bundle2;
        Bundle bundle4 = new Bundle(bundle);
        this.mBundle = bundle3;
    }

    /* synthetic */ MediaMetadataCompat(Bundle bundle, C00621 r7) {
        C00621 r2 = r7;
        this(bundle);
    }

    private MediaMetadataCompat(Parcel parcel) {
        this.mBundle = parcel.readBundle();
    }

    /* synthetic */ MediaMetadataCompat(Parcel parcel, C00621 r7) {
        C00621 r2 = r7;
        this(parcel);
    }

    public static MediaMetadataCompat fromMediaMetadata(Object obj) {
        Builder builder;
        Object obj2 = obj;
        if (obj2 == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Builder builder2 = builder;
        Builder builder3 = new Builder();
        Builder builder4 = builder2;
        for (String str : MediaMetadataCompatApi21.keySet(obj2)) {
            Integer num = (Integer) METADATA_KEYS_TYPE.get(str);
            if (num != null) {
                switch (num.intValue()) {
                    case 0:
                        Builder putLong = builder4.putLong(str, MediaMetadataCompatApi21.getLong(obj2, str));
                        break;
                    case 1:
                        Builder putText = builder4.putText(str, MediaMetadataCompatApi21.getText(obj2, str));
                        break;
                    case 2:
                        Builder putBitmap = builder4.putBitmap(str, MediaMetadataCompatApi21.getBitmap(obj2, str));
                        break;
                    case 3:
                        Builder putRating = builder4.putRating(str, RatingCompat.fromRating(MediaMetadataCompatApi21.getRating(obj2, str)));
                        break;
                }
            }
        }
        MediaMetadataCompat build = builder4.build();
        build.mMetadataObj = obj2;
        return build;
    }

    public boolean containsKey(String str) {
        return this.mBundle.containsKey(str);
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap(String str) {
        try {
            return (Bitmap) this.mBundle.getParcelable(str);
        } catch (Exception e) {
            int w = Log.w(TAG, "Failed to retrieve a key as Bitmap.", e);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public MediaDescriptionCompat getDescription() {
        Bitmap bitmap;
        Uri uri;
        android.support.p000v4.media.MediaDescriptionCompat.Builder builder;
        if (this.mDescription != null) {
            return this.mDescription;
        }
        String string = getString(METADATA_KEY_MEDIA_ID);
        CharSequence[] charSequenceArr = new CharSequence[3];
        CharSequence text = getText(METADATA_KEY_DISPLAY_TITLE);
        if (TextUtils.isEmpty(text)) {
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i >= charSequenceArr.length || i3 >= PREFERRED_DESCRIPTION_ORDER.length) {
                    break;
                }
                int i4 = i3 + 1;
                CharSequence text2 = getText(PREFERRED_DESCRIPTION_ORDER[i3]);
                if (!TextUtils.isEmpty(text2)) {
                    int i5 = i + 1;
                    charSequenceArr[i] = text2;
                    i = i5;
                }
                i2 = i4;
            }
        } else {
            charSequenceArr[0] = text;
            charSequenceArr[1] = getText(METADATA_KEY_DISPLAY_SUBTITLE);
            charSequenceArr[2] = getText(METADATA_KEY_DISPLAY_DESCRIPTION);
        }
        int i6 = 0;
        while (true) {
            bitmap = null;
            if (i6 >= PREFERRED_BITMAP_ORDER.length) {
                break;
            }
            Bitmap bitmap2 = getBitmap(PREFERRED_BITMAP_ORDER[i6]);
            if (bitmap2 != null) {
                bitmap = bitmap2;
                break;
            }
            i6++;
        }
        int i7 = 0;
        while (true) {
            uri = null;
            if (i7 >= PREFERRED_URI_ORDER.length) {
                break;
            }
            String string2 = getString(PREFERRED_URI_ORDER[i7]);
            if (!TextUtils.isEmpty(string2)) {
                uri = Uri.parse(string2);
                break;
            }
            i7++;
        }
        android.support.p000v4.media.MediaDescriptionCompat.Builder builder2 = builder;
        android.support.p000v4.media.MediaDescriptionCompat.Builder builder3 = new android.support.p000v4.media.MediaDescriptionCompat.Builder();
        android.support.p000v4.media.MediaDescriptionCompat.Builder builder4 = builder2;
        android.support.p000v4.media.MediaDescriptionCompat.Builder mediaId = builder4.setMediaId(string);
        android.support.p000v4.media.MediaDescriptionCompat.Builder title = builder4.setTitle(charSequenceArr[0]);
        android.support.p000v4.media.MediaDescriptionCompat.Builder subtitle = builder4.setSubtitle(charSequenceArr[1]);
        android.support.p000v4.media.MediaDescriptionCompat.Builder description = builder4.setDescription(charSequenceArr[2]);
        android.support.p000v4.media.MediaDescriptionCompat.Builder iconBitmap = builder4.setIconBitmap(bitmap);
        android.support.p000v4.media.MediaDescriptionCompat.Builder iconUri = builder4.setIconUri(uri);
        this.mDescription = builder4.build();
        return this.mDescription;
    }

    public long getLong(String str) {
        return this.mBundle.getLong(str, 0);
    }

    public Object getMediaMetadata() {
        if (this.mMetadataObj != null || VERSION.SDK_INT < 21) {
            return this.mMetadataObj;
        }
        Object newInstance = android.support.p000v4.media.MediaMetadataCompatApi21.Builder.newInstance();
        for (String str : keySet()) {
            Integer num = (Integer) METADATA_KEYS_TYPE.get(str);
            if (num != null) {
                switch (num.intValue()) {
                    case 0:
                        android.support.p000v4.media.MediaMetadataCompatApi21.Builder.putLong(newInstance, str, getLong(str));
                        break;
                    case 1:
                        android.support.p000v4.media.MediaMetadataCompatApi21.Builder.putText(newInstance, str, getText(str));
                        break;
                    case 2:
                        android.support.p000v4.media.MediaMetadataCompatApi21.Builder.putBitmap(newInstance, str, getBitmap(str));
                        break;
                    case 3:
                        android.support.p000v4.media.MediaMetadataCompatApi21.Builder.putRating(newInstance, str, getRating(str).getRating());
                        break;
                }
            }
        }
        this.mMetadataObj = android.support.p000v4.media.MediaMetadataCompatApi21.Builder.build(newInstance);
        return this.mMetadataObj;
    }

    public RatingCompat getRating(String str) {
        try {
            return (RatingCompat) this.mBundle.getParcelable(str);
        } catch (Exception e) {
            int w = Log.w(TAG, "Failed to retrieve a key as Rating.", e);
            return null;
        }
    }

    public String getString(String str) {
        String str2 = str;
        CharSequence charSequence = this.mBundle.getCharSequence(str2);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public CharSequence getText(String str) {
        return this.mBundle.getCharSequence(str);
    }

    public Set<String> keySet() {
        return this.mBundle.keySet();
    }

    public int size() {
        return this.mBundle.size();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = i;
        parcel.writeBundle(this.mBundle);
    }
}
