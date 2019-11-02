package android.support.p000v4.media;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: android.support.v4.media.RatingCompat */
public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR;
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.RatingCompat$StarStyle */
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.RatingCompat$Style */
    public @interface Style {
    }

    static {
        C00631 r2;
        C00631 r0 = r2;
        C00631 r1 = new Creator<RatingCompat>() {
            public RatingCompat createFromParcel(Parcel parcel) {
                RatingCompat ratingCompat;
                Parcel parcel2 = parcel;
                RatingCompat ratingCompat2 = ratingCompat;
                RatingCompat ratingCompat3 = new RatingCompat(parcel2.readInt(), parcel2.readFloat(), null);
                return ratingCompat2;
            }

            public RatingCompat[] newArray(int i) {
                return new RatingCompat[i];
            }
        };
        CREATOR = r0;
    }

    private RatingCompat(int i, float f) {
        float f2 = f;
        this.mRatingStyle = i;
        this.mRatingValue = f2;
    }

    /* synthetic */ RatingCompat(int i, float f, C00631 r10) {
        C00631 r3 = r10;
        this(i, f);
    }

    public static RatingCompat fromRating(Object obj) {
        RatingCompat newUnratedRating;
        Object obj2 = obj;
        if (obj2 == null || VERSION.SDK_INT < 21) {
            return null;
        }
        int ratingStyle = RatingCompatApi21.getRatingStyle(obj2);
        if (RatingCompatApi21.isRated(obj2)) {
            switch (ratingStyle) {
                case 1:
                    newUnratedRating = newHeartRating(RatingCompatApi21.hasHeart(obj2));
                    break;
                case 2:
                    newUnratedRating = newThumbRating(RatingCompatApi21.isThumbUp(obj2));
                    break;
                case 3:
                case 4:
                case 5:
                    newUnratedRating = newStarRating(ratingStyle, RatingCompatApi21.getStarRating(obj2));
                    break;
                case 6:
                    newUnratedRating = newPercentageRating(RatingCompatApi21.getPercentRating(obj2));
                    break;
                default:
                    return null;
            }
        } else {
            newUnratedRating = newUnratedRating(ratingStyle);
        }
        newUnratedRating.mRatingObj = obj2;
        return newUnratedRating;
    }

    public static RatingCompat newHeartRating(boolean z) {
        RatingCompat ratingCompat;
        RatingCompat ratingCompat2 = ratingCompat;
        RatingCompat ratingCompat3 = new RatingCompat(1, z ? 1.0f : 0.0f);
        return ratingCompat2;
    }

    public static RatingCompat newPercentageRating(float f) {
        RatingCompat ratingCompat;
        float f2 = f;
        if (f2 < 0.0f || f2 > 100.0f) {
            int e = Log.e(TAG, "Invalid percentage-based rating value");
            return null;
        }
        RatingCompat ratingCompat2 = ratingCompat;
        RatingCompat ratingCompat3 = new RatingCompat(6, f2);
        return ratingCompat2;
    }

    public static RatingCompat newStarRating(int i, float f) {
        float f2;
        RatingCompat ratingCompat;
        StringBuilder sb;
        int i2 = i;
        float f3 = f;
        switch (i2) {
            case 3:
                f2 = 3.0f;
                break;
            case 4:
                f2 = 4.0f;
                break;
            case 5:
                f2 = 5.0f;
                break;
            default:
                String str = TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e = Log.e(str, sb2.append("Invalid rating style (").append(i2).append(") for a star rating").toString());
                return null;
        }
        if (f3 < 0.0f || f3 > f2) {
            int e2 = Log.e(TAG, "Trying to set out of range star-based rating");
            return null;
        }
        RatingCompat ratingCompat2 = ratingCompat;
        RatingCompat ratingCompat3 = new RatingCompat(i2, f3);
        return ratingCompat2;
    }

    public static RatingCompat newThumbRating(boolean z) {
        RatingCompat ratingCompat;
        RatingCompat ratingCompat2 = ratingCompat;
        RatingCompat ratingCompat3 = new RatingCompat(2, z ? 1.0f : 0.0f);
        return ratingCompat2;
    }

    public static RatingCompat newUnratedRating(int i) {
        RatingCompat ratingCompat;
        int i2 = i;
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                RatingCompat ratingCompat2 = ratingCompat;
                RatingCompat ratingCompat3 = new RatingCompat(i2, -1.0f);
                return ratingCompat2;
            default:
                return null;
        }
    }

    public int describeContents() {
        return this.mRatingStyle;
    }

    public float getPercentRating() {
        if (this.mRatingStyle != 6 || !isRated()) {
            return -1.0f;
        }
        return this.mRatingValue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getRating() {
        /*
            r4 = this;
            r0 = r4
            r1 = r0
            java.lang.Object r1 = r1.mRatingObj
            if (r1 != 0) goto L_0x000c
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 >= r2) goto L_0x0011
        L_0x000c:
            r1 = r0
            java.lang.Object r1 = r1.mRatingObj
            r0 = r1
        L_0x0010:
            return r0
        L_0x0011:
            r1 = r0
            boolean r1 = r1.isRated()
            if (r1 == 0) goto L_0x005c
            r1 = r0
            int r1 = r1.mRatingStyle
            switch(r1) {
                case 1: goto L_0x0021;
                case 2: goto L_0x0032;
                case 3: goto L_0x003f;
                case 4: goto L_0x003f;
                case 5: goto L_0x003f;
                case 6: goto L_0x004f;
                default: goto L_0x001e;
            }
        L_0x001e:
            r1 = 0
            r0 = r1
            goto L_0x0010
        L_0x0021:
            r1 = r0
            r2 = r0
            boolean r2 = r2.hasHeart()
            java.lang.Object r2 = android.support.p000v4.media.RatingCompatApi21.newHeartRating(r2)
            r1.mRatingObj = r2
        L_0x002d:
            r1 = r0
            java.lang.Object r1 = r1.mRatingObj
            r0 = r1
            goto L_0x0010
        L_0x0032:
            r1 = r0
            r2 = r0
            boolean r2 = r2.isThumbUp()
            java.lang.Object r2 = android.support.p000v4.media.RatingCompatApi21.newThumbRating(r2)
            r1.mRatingObj = r2
            goto L_0x002d
        L_0x003f:
            r1 = r0
            r2 = r0
            int r2 = r2.mRatingStyle
            r3 = r0
            float r3 = r3.getStarRating()
            java.lang.Object r2 = android.support.p000v4.media.RatingCompatApi21.newStarRating(r2, r3)
            r1.mRatingObj = r2
            goto L_0x002d
        L_0x004f:
            r1 = r0
            r2 = r0
            float r2 = r2.getPercentRating()
            java.lang.Object r2 = android.support.p000v4.media.RatingCompatApi21.newPercentageRating(r2)
            r1.mRatingObj = r2
            goto L_0x001e
        L_0x005c:
            r1 = r0
            r2 = r0
            int r2 = r2.mRatingStyle
            java.lang.Object r2 = android.support.p000v4.media.RatingCompatApi21.newUnratedRating(r2)
            r1.mRatingObj = r2
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.media.RatingCompat.getRating():java.lang.Object");
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public float getStarRating() {
        switch (this.mRatingStyle) {
            case 3:
            case 4:
            case 5:
                if (isRated()) {
                    return this.mRatingValue;
                }
                break;
        }
        return -1.0f;
    }

    public boolean hasHeart() {
        boolean z = true;
        if (this.mRatingStyle != 1) {
            return false;
        }
        if (this.mRatingValue != 1.0f) {
            z = false;
        }
        return z;
    }

    public boolean isRated() {
        return this.mRatingValue >= 0.0f;
    }

    public boolean isThumbUp() {
        return this.mRatingStyle == 2 && this.mRatingValue == 1.0f;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("Rating:style=").append(this.mRatingStyle).append(" rating=").append(this.mRatingValue < 0.0f ? "unrated" : String.valueOf(this.mRatingValue)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        parcel2.writeInt(this.mRatingStyle);
        parcel2.writeFloat(this.mRatingValue);
    }
}
