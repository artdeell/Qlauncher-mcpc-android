package android.support.p000v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/* renamed from: android.support.v4.media.MediaDescriptionCompat */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR;
    private final CharSequence mDescription;
    private Object mDescriptionObj;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$Builder */
    public static final class Builder {
        private CharSequence mDescription;
        private Bundle mExtras;
        private Bitmap mIcon;
        private Uri mIconUri;
        private String mMediaId;
        private Uri mMediaUri;
        private CharSequence mSubtitle;
        private CharSequence mTitle;

        public Builder() {
        }

        public MediaDescriptionCompat build() {
            MediaDescriptionCompat mediaDescriptionCompat;
            MediaDescriptionCompat mediaDescriptionCompat2 = mediaDescriptionCompat;
            MediaDescriptionCompat mediaDescriptionCompat3 = new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri, null);
            return mediaDescriptionCompat2;
        }

        public Builder setDescription(@Nullable CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public Builder setExtras(@Nullable Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public Builder setIconBitmap(@Nullable Bitmap bitmap) {
            this.mIcon = bitmap;
            return this;
        }

        public Builder setIconUri(@Nullable Uri uri) {
            this.mIconUri = uri;
            return this;
        }

        public Builder setMediaId(@Nullable String str) {
            this.mMediaId = str;
            return this;
        }

        public Builder setMediaUri(@Nullable Uri uri) {
            this.mMediaUri = uri;
            return this;
        }

        public Builder setSubtitle(@Nullable CharSequence charSequence) {
            this.mSubtitle = charSequence;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }
    }

    static {
        C00611 r2;
        C00611 r0 = r2;
        C00611 r1 = new Creator<MediaDescriptionCompat>() {
            public MediaDescriptionCompat createFromParcel(Parcel parcel) {
                MediaDescriptionCompat mediaDescriptionCompat;
                Parcel parcel2 = parcel;
                if (VERSION.SDK_INT >= 21) {
                    return MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(parcel2));
                }
                MediaDescriptionCompat mediaDescriptionCompat2 = mediaDescriptionCompat;
                MediaDescriptionCompat mediaDescriptionCompat3 = new MediaDescriptionCompat(parcel2, null);
                return mediaDescriptionCompat2;
            }

            public MediaDescriptionCompat[] newArray(int i) {
                return new MediaDescriptionCompat[i];
            }
        };
        CREATOR = r0;
    }

    private MediaDescriptionCompat(Parcel parcel) {
        Parcel parcel2 = parcel;
        this.mMediaId = parcel2.readString();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel2);
        this.mSubtitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel2);
        this.mDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel2);
        this.mIcon = (Bitmap) parcel2.readParcelable(null);
        this.mIconUri = (Uri) parcel2.readParcelable(null);
        this.mExtras = parcel2.readBundle();
        this.mMediaUri = (Uri) parcel2.readParcelable(null);
    }

    /* synthetic */ MediaDescriptionCompat(Parcel parcel, C00611 r7) {
        C00611 r2 = r7;
        this(parcel);
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        CharSequence charSequence4 = charSequence;
        CharSequence charSequence5 = charSequence2;
        CharSequence charSequence6 = charSequence3;
        Bitmap bitmap2 = bitmap;
        Uri uri3 = uri;
        Bundle bundle2 = bundle;
        Uri uri4 = uri2;
        this.mMediaId = str;
        this.mTitle = charSequence4;
        this.mSubtitle = charSequence5;
        this.mDescription = charSequence6;
        this.mIcon = bitmap2;
        this.mIconUri = uri3;
        this.mExtras = bundle2;
        this.mMediaUri = uri4;
    }

    /* synthetic */ MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2, C00611 r28) {
        C00611 r9 = r28;
        this(str, charSequence, charSequence2, charSequence3, bitmap, uri, bundle, uri2);
    }

    public static MediaDescriptionCompat fromMediaDescription(Object obj) {
        Builder builder;
        Object obj2 = obj;
        if (obj2 == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Builder builder2 = builder;
        Builder builder3 = new Builder();
        Builder builder4 = builder2;
        Builder mediaId = builder4.setMediaId(MediaDescriptionCompatApi21.getMediaId(obj2));
        Builder title = builder4.setTitle(MediaDescriptionCompatApi21.getTitle(obj2));
        Builder subtitle = builder4.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(obj2));
        Builder description = builder4.setDescription(MediaDescriptionCompatApi21.getDescription(obj2));
        Builder iconBitmap = builder4.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(obj2));
        Builder iconUri = builder4.setIconUri(MediaDescriptionCompatApi21.getIconUri(obj2));
        Builder extras = builder4.setExtras(MediaDescriptionCompatApi21.getExtras(obj2));
        if (VERSION.SDK_INT >= 23) {
            Builder mediaUri = builder4.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(obj2));
        }
        MediaDescriptionCompat build = builder4.build();
        build.mDescriptionObj = obj2;
        return build;
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public CharSequence getDescription() {
        return this.mDescription;
    }

    @Nullable
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Nullable
    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    @Nullable
    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Object getMediaDescription() {
        if (this.mDescriptionObj != null || VERSION.SDK_INT < 21) {
            return this.mDescriptionObj;
        }
        Object newInstance = Builder.newInstance();
        Builder.setMediaId(newInstance, this.mMediaId);
        Builder.setTitle(newInstance, this.mTitle);
        Builder.setSubtitle(newInstance, this.mSubtitle);
        Builder.setDescription(newInstance, this.mDescription);
        Builder.setIconBitmap(newInstance, this.mIcon);
        Builder.setIconUri(newInstance, this.mIconUri);
        Builder.setExtras(newInstance, this.mExtras);
        if (VERSION.SDK_INT >= 23) {
            Builder.setMediaUri(newInstance, this.mMediaUri);
        }
        this.mDescriptionObj = Builder.build(newInstance);
        return this.mDescriptionObj;
    }

    @Nullable
    public String getMediaId() {
        return this.mMediaId;
    }

    @Nullable
    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    @Nullable
    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    @Nullable
    public CharSequence getTitle() {
        return this.mTitle;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(this.mTitle).append(", ").append(this.mSubtitle).append(", ").append(this.mDescription).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        if (VERSION.SDK_INT < 21) {
            parcel2.writeString(this.mMediaId);
            TextUtils.writeToParcel(this.mTitle, parcel2, i2);
            TextUtils.writeToParcel(this.mSubtitle, parcel2, i2);
            TextUtils.writeToParcel(this.mDescription, parcel2, i2);
            parcel2.writeParcelable(this.mIcon, i2);
            parcel2.writeParcelable(this.mIconUri, i2);
            parcel2.writeBundle(this.mExtras);
            return;
        }
        MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), parcel2, i2);
    }
}
