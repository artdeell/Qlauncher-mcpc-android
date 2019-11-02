package android.support.p000v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.graphics.drawable.DrawableCompat */
public class DrawableCompat {
    static final DrawableImpl IMPL;

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$BaseDrawableImpl */
    static class BaseDrawableImpl implements DrawableImpl {
        BaseDrawableImpl() {
        }

        public int getLayoutDirection(Drawable drawable) {
            Drawable drawable2 = drawable;
            return 0;
        }

        public boolean isAutoMirrored(Drawable drawable) {
            Drawable drawable2 = drawable;
            return false;
        }

        public void jumpToCurrentState(Drawable drawable) {
        }

        public void setAutoMirrored(Drawable drawable, boolean z) {
        }

        public void setHotspot(Drawable drawable, float f, float f2) {
        }

        public void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void setLayoutDirection(Drawable drawable, int i) {
        }

        public void setTint(Drawable drawable, int i) {
            DrawableCompatBase.setTint(drawable, i);
        }

        public void setTintList(Drawable drawable, ColorStateList colorStateList) {
            DrawableCompatBase.setTintList(drawable, colorStateList);
        }

        public void setTintMode(Drawable drawable, Mode mode) {
            DrawableCompatBase.setTintMode(drawable, mode);
        }

        public Drawable wrap(Drawable drawable) {
            return DrawableCompatBase.wrapForTinting(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$DrawableImpl */
    interface DrawableImpl {
        int getLayoutDirection(Drawable drawable);

        boolean isAutoMirrored(Drawable drawable);

        void jumpToCurrentState(Drawable drawable);

        void setAutoMirrored(Drawable drawable, boolean z);

        void setHotspot(Drawable drawable, float f, float f2);

        void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4);

        void setLayoutDirection(Drawable drawable, int i);

        void setTint(Drawable drawable, int i);

        void setTintList(Drawable drawable, ColorStateList colorStateList);

        void setTintMode(Drawable drawable, Mode mode);

        Drawable wrap(Drawable drawable);
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$HoneycombDrawableImpl */
    static class HoneycombDrawableImpl extends BaseDrawableImpl {
        HoneycombDrawableImpl() {
        }

        public void jumpToCurrentState(Drawable drawable) {
            DrawableCompatHoneycomb.jumpToCurrentState(drawable);
        }

        public Drawable wrap(Drawable drawable) {
            return DrawableCompatHoneycomb.wrapForTinting(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$JellybeanMr1DrawableImpl */
    static class JellybeanMr1DrawableImpl extends HoneycombDrawableImpl {
        JellybeanMr1DrawableImpl() {
        }

        public int getLayoutDirection(Drawable drawable) {
            int layoutDirection = DrawableCompatJellybeanMr1.getLayoutDirection(drawable);
            if (layoutDirection >= 0) {
                return layoutDirection;
            }
            return 0;
        }

        public void setLayoutDirection(Drawable drawable, int i) {
            DrawableCompatJellybeanMr1.setLayoutDirection(drawable, i);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$KitKatDrawableImpl */
    static class KitKatDrawableImpl extends JellybeanMr1DrawableImpl {
        KitKatDrawableImpl() {
        }

        public boolean isAutoMirrored(Drawable drawable) {
            return DrawableCompatKitKat.isAutoMirrored(drawable);
        }

        public void setAutoMirrored(Drawable drawable, boolean z) {
            DrawableCompatKitKat.setAutoMirrored(drawable, z);
        }

        public Drawable wrap(Drawable drawable) {
            return DrawableCompatKitKat.wrapForTinting(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$LollipopDrawableImpl */
    static class LollipopDrawableImpl extends KitKatDrawableImpl {
        LollipopDrawableImpl() {
        }

        public void setHotspot(Drawable drawable, float f, float f2) {
            DrawableCompatLollipop.setHotspot(drawable, f, f2);
        }

        public void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
            DrawableCompatLollipop.setHotspotBounds(drawable, i, i2, i3, i4);
        }

        public void setTint(Drawable drawable, int i) {
            DrawableCompatLollipop.setTint(drawable, i);
        }

        public void setTintList(Drawable drawable, ColorStateList colorStateList) {
            DrawableCompatLollipop.setTintList(drawable, colorStateList);
        }

        public void setTintMode(Drawable drawable, Mode mode) {
            DrawableCompatLollipop.setTintMode(drawable, mode);
        }

        public Drawable wrap(Drawable drawable) {
            return DrawableCompatLollipop.wrapForTinting(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$LollipopMr1DrawableImpl */
    static class LollipopMr1DrawableImpl extends LollipopDrawableImpl {
        LollipopMr1DrawableImpl() {
        }

        public Drawable wrap(Drawable drawable) {
            return DrawableCompatApi22.wrapForTinting(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$MDrawableImpl */
    static class MDrawableImpl extends LollipopMr1DrawableImpl {
        MDrawableImpl() {
        }

        public int getLayoutDirection(Drawable drawable) {
            return DrawableCompatApi23.getLayoutDirection(drawable);
        }

        public void setLayoutDirection(Drawable drawable, int i) {
            DrawableCompatApi23.setLayoutDirection(drawable, i);
        }
    }

    static {
        BaseDrawableImpl baseDrawableImpl;
        HoneycombDrawableImpl honeycombDrawableImpl;
        JellybeanMr1DrawableImpl jellybeanMr1DrawableImpl;
        KitKatDrawableImpl kitKatDrawableImpl;
        LollipopDrawableImpl lollipopDrawableImpl;
        LollipopMr1DrawableImpl lollipopMr1DrawableImpl;
        MDrawableImpl mDrawableImpl;
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            MDrawableImpl mDrawableImpl2 = mDrawableImpl;
            MDrawableImpl mDrawableImpl3 = new MDrawableImpl();
            IMPL = mDrawableImpl2;
        } else if (i >= 22) {
            LollipopMr1DrawableImpl lollipopMr1DrawableImpl2 = lollipopMr1DrawableImpl;
            LollipopMr1DrawableImpl lollipopMr1DrawableImpl3 = new LollipopMr1DrawableImpl();
            IMPL = lollipopMr1DrawableImpl2;
        } else if (i >= 21) {
            LollipopDrawableImpl lollipopDrawableImpl2 = lollipopDrawableImpl;
            LollipopDrawableImpl lollipopDrawableImpl3 = new LollipopDrawableImpl();
            IMPL = lollipopDrawableImpl2;
        } else if (i >= 19) {
            KitKatDrawableImpl kitKatDrawableImpl2 = kitKatDrawableImpl;
            KitKatDrawableImpl kitKatDrawableImpl3 = new KitKatDrawableImpl();
            IMPL = kitKatDrawableImpl2;
        } else if (i >= 17) {
            JellybeanMr1DrawableImpl jellybeanMr1DrawableImpl2 = jellybeanMr1DrawableImpl;
            JellybeanMr1DrawableImpl jellybeanMr1DrawableImpl3 = new JellybeanMr1DrawableImpl();
            IMPL = jellybeanMr1DrawableImpl2;
        } else if (i >= 11) {
            HoneycombDrawableImpl honeycombDrawableImpl2 = honeycombDrawableImpl;
            HoneycombDrawableImpl honeycombDrawableImpl3 = new HoneycombDrawableImpl();
            IMPL = honeycombDrawableImpl2;
        } else {
            BaseDrawableImpl baseDrawableImpl2 = baseDrawableImpl;
            BaseDrawableImpl baseDrawableImpl3 = new BaseDrawableImpl();
            IMPL = baseDrawableImpl2;
        }
    }

    public DrawableCompat() {
    }

    public static int getLayoutDirection(Drawable drawable) {
        return IMPL.getLayoutDirection(drawable);
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        return IMPL.isAutoMirrored(drawable);
    }

    public static void jumpToCurrentState(Drawable drawable) {
        IMPL.jumpToCurrentState(drawable);
    }

    public static void setAutoMirrored(Drawable drawable, boolean z) {
        IMPL.setAutoMirrored(drawable, z);
    }

    public static void setHotspot(Drawable drawable, float f, float f2) {
        IMPL.setHotspot(drawable, f, f2);
    }

    public static void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
        IMPL.setHotspotBounds(drawable, i, i2, i3, i4);
    }

    public static void setLayoutDirection(Drawable drawable, int i) {
        IMPL.setLayoutDirection(drawable, i);
    }

    public static void setTint(Drawable drawable, int i) {
        IMPL.setTint(drawable, i);
    }

    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        IMPL.setTintList(drawable, colorStateList);
    }

    public static void setTintMode(Drawable drawable, Mode mode) {
        IMPL.setTintMode(drawable, mode);
    }

    public static <T extends Drawable> T unwrap(Drawable drawable) {
        Drawable drawable2 = drawable;
        if (drawable2 instanceof DrawableWrapper) {
            drawable2 = ((DrawableWrapper) drawable2).getWrappedDrawable();
        }
        return drawable2;
    }

    public static Drawable wrap(Drawable drawable) {
        return IMPL.wrap(drawable);
    }
}
