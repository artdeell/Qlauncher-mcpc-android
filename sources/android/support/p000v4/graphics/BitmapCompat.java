package android.support.p000v4.graphics;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.graphics.BitmapCompat */
public class BitmapCompat {
    static final BitmapImpl IMPL;

    /* renamed from: android.support.v4.graphics.BitmapCompat$BaseBitmapImpl */
    static class BaseBitmapImpl implements BitmapImpl {
        BaseBitmapImpl() {
        }

        public int getAllocationByteCount(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            return bitmap2.getRowBytes() * bitmap2.getHeight();
        }

        public boolean hasMipMap(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            return false;
        }

        public void setHasMipMap(Bitmap bitmap, boolean z) {
        }
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$BitmapImpl */
    interface BitmapImpl {
        int getAllocationByteCount(Bitmap bitmap);

        boolean hasMipMap(Bitmap bitmap);

        void setHasMipMap(Bitmap bitmap, boolean z);
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$HcMr1BitmapCompatImpl */
    static class HcMr1BitmapCompatImpl extends BaseBitmapImpl {
        HcMr1BitmapCompatImpl() {
        }

        public int getAllocationByteCount(Bitmap bitmap) {
            return BitmapCompatHoneycombMr1.getAllocationByteCount(bitmap);
        }
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$JbMr2BitmapCompatImpl */
    static class JbMr2BitmapCompatImpl extends HcMr1BitmapCompatImpl {
        JbMr2BitmapCompatImpl() {
        }

        public boolean hasMipMap(Bitmap bitmap) {
            return BitmapCompatJellybeanMR2.hasMipMap(bitmap);
        }

        public void setHasMipMap(Bitmap bitmap, boolean z) {
            BitmapCompatJellybeanMR2.setHasMipMap(bitmap, z);
        }
    }

    /* renamed from: android.support.v4.graphics.BitmapCompat$KitKatBitmapCompatImpl */
    static class KitKatBitmapCompatImpl extends JbMr2BitmapCompatImpl {
        KitKatBitmapCompatImpl() {
        }

        public int getAllocationByteCount(Bitmap bitmap) {
            return BitmapCompatKitKat.getAllocationByteCount(bitmap);
        }
    }

    static {
        BaseBitmapImpl baseBitmapImpl;
        HcMr1BitmapCompatImpl hcMr1BitmapCompatImpl;
        JbMr2BitmapCompatImpl jbMr2BitmapCompatImpl;
        KitKatBitmapCompatImpl kitKatBitmapCompatImpl;
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            KitKatBitmapCompatImpl kitKatBitmapCompatImpl2 = kitKatBitmapCompatImpl;
            KitKatBitmapCompatImpl kitKatBitmapCompatImpl3 = new KitKatBitmapCompatImpl();
            IMPL = kitKatBitmapCompatImpl2;
        } else if (i >= 18) {
            JbMr2BitmapCompatImpl jbMr2BitmapCompatImpl2 = jbMr2BitmapCompatImpl;
            JbMr2BitmapCompatImpl jbMr2BitmapCompatImpl3 = new JbMr2BitmapCompatImpl();
            IMPL = jbMr2BitmapCompatImpl2;
        } else if (i >= 12) {
            HcMr1BitmapCompatImpl hcMr1BitmapCompatImpl2 = hcMr1BitmapCompatImpl;
            HcMr1BitmapCompatImpl hcMr1BitmapCompatImpl3 = new HcMr1BitmapCompatImpl();
            IMPL = hcMr1BitmapCompatImpl2;
        } else {
            BaseBitmapImpl baseBitmapImpl2 = baseBitmapImpl;
            BaseBitmapImpl baseBitmapImpl3 = new BaseBitmapImpl();
            IMPL = baseBitmapImpl2;
        }
    }

    public BitmapCompat() {
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        return IMPL.getAllocationByteCount(bitmap);
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        return IMPL.hasMipMap(bitmap);
    }

    public static void setHasMipMap(Bitmap bitmap, boolean z) {
        IMPL.setHasMipMap(bitmap, z);
    }
}
