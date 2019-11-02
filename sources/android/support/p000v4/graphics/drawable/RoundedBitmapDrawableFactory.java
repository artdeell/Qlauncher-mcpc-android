package android.support.p000v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.p000v4.graphics.BitmapCompat;
import android.support.p000v4.view.GravityCompat;
import android.util.Log;
import java.io.InputStream;

/* renamed from: android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory */
public class RoundedBitmapDrawableFactory {
    private static final String TAG = "RoundedBitmapDrawableFactory";

    /* renamed from: android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable */
    private static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        DefaultRoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        /* access modifiers changed from: 0000 */
        public void gravityCompatApply(int i, int i2, int i3, Rect rect, Rect rect2) {
            GravityCompat.apply(i, i2, i3, rect, rect2, 0);
        }

        public boolean hasMipMap() {
            return this.mBitmap != null && BitmapCompat.hasMipMap(this.mBitmap);
        }

        public void setMipMap(boolean z) {
            boolean z2 = z;
            if (this.mBitmap != null) {
                BitmapCompat.setHasMipMap(this.mBitmap, z2);
                invalidateSelf();
            }
        }
    }

    public RoundedBitmapDrawableFactory() {
    }

    public static RoundedBitmapDrawable create(Resources resources, Bitmap bitmap) {
        DefaultRoundedBitmapDrawable defaultRoundedBitmapDrawable;
        RoundedBitmapDrawable21 roundedBitmapDrawable21;
        Resources resources2 = resources;
        Bitmap bitmap2 = bitmap;
        if (VERSION.SDK_INT >= 21) {
            RoundedBitmapDrawable21 roundedBitmapDrawable212 = roundedBitmapDrawable21;
            RoundedBitmapDrawable21 roundedBitmapDrawable213 = new RoundedBitmapDrawable21(resources2, bitmap2);
            return roundedBitmapDrawable212;
        }
        DefaultRoundedBitmapDrawable defaultRoundedBitmapDrawable2 = defaultRoundedBitmapDrawable;
        DefaultRoundedBitmapDrawable defaultRoundedBitmapDrawable3 = new DefaultRoundedBitmapDrawable(resources2, bitmap2);
        return defaultRoundedBitmapDrawable2;
    }

    public static RoundedBitmapDrawable create(Resources resources, InputStream inputStream) {
        StringBuilder sb;
        InputStream inputStream2 = inputStream;
        RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeStream(inputStream2));
        if (create.getBitmap() == null) {
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int w = Log.w(str, sb2.append("RoundedBitmapDrawable cannot decode ").append(inputStream2).toString());
        }
        return create;
    }

    public static RoundedBitmapDrawable create(Resources resources, String str) {
        StringBuilder sb;
        String str2 = str;
        RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeFile(str2));
        if (create.getBitmap() == null) {
            String str3 = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int w = Log.w(str3, sb2.append("RoundedBitmapDrawable cannot decode ").append(str2).toString());
        }
        return create;
    }
}
