package android.support.p000v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;

/* renamed from: android.support.v4.widget.CompoundButtonCompat */
public final class CompoundButtonCompat {
    private static final CompoundButtonCompatImpl IMPL;

    /* renamed from: android.support.v4.widget.CompoundButtonCompat$Api23CompoundButtonImpl */
    static class Api23CompoundButtonImpl extends LollipopCompoundButtonImpl {
        Api23CompoundButtonImpl() {
        }

        public Drawable getButtonDrawable(CompoundButton compoundButton) {
            return CompoundButtonCompatApi23.getButtonDrawable(compoundButton);
        }
    }

    /* renamed from: android.support.v4.widget.CompoundButtonCompat$BaseCompoundButtonCompat */
    static class BaseCompoundButtonCompat implements CompoundButtonCompatImpl {
        BaseCompoundButtonCompat() {
        }

        public Drawable getButtonDrawable(CompoundButton compoundButton) {
            return CompoundButtonCompatDonut.getButtonDrawable(compoundButton);
        }

        public ColorStateList getButtonTintList(CompoundButton compoundButton) {
            return CompoundButtonCompatDonut.getButtonTintList(compoundButton);
        }

        public Mode getButtonTintMode(CompoundButton compoundButton) {
            return CompoundButtonCompatDonut.getButtonTintMode(compoundButton);
        }

        public void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
            CompoundButtonCompatDonut.setButtonTintList(compoundButton, colorStateList);
        }

        public void setButtonTintMode(CompoundButton compoundButton, Mode mode) {
            CompoundButtonCompatDonut.setButtonTintMode(compoundButton, mode);
        }
    }

    /* renamed from: android.support.v4.widget.CompoundButtonCompat$CompoundButtonCompatImpl */
    interface CompoundButtonCompatImpl {
        Drawable getButtonDrawable(CompoundButton compoundButton);

        ColorStateList getButtonTintList(CompoundButton compoundButton);

        Mode getButtonTintMode(CompoundButton compoundButton);

        void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList);

        void setButtonTintMode(CompoundButton compoundButton, Mode mode);
    }

    /* renamed from: android.support.v4.widget.CompoundButtonCompat$LollipopCompoundButtonImpl */
    static class LollipopCompoundButtonImpl extends BaseCompoundButtonCompat {
        LollipopCompoundButtonImpl() {
        }

        public ColorStateList getButtonTintList(CompoundButton compoundButton) {
            return CompoundButtonCompatLollipop.getButtonTintList(compoundButton);
        }

        public Mode getButtonTintMode(CompoundButton compoundButton) {
            return CompoundButtonCompatLollipop.getButtonTintMode(compoundButton);
        }

        public void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
            CompoundButtonCompatLollipop.setButtonTintList(compoundButton, colorStateList);
        }

        public void setButtonTintMode(CompoundButton compoundButton, Mode mode) {
            CompoundButtonCompatLollipop.setButtonTintMode(compoundButton, mode);
        }
    }

    static {
        BaseCompoundButtonCompat baseCompoundButtonCompat;
        LollipopCompoundButtonImpl lollipopCompoundButtonImpl;
        Api23CompoundButtonImpl api23CompoundButtonImpl;
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            Api23CompoundButtonImpl api23CompoundButtonImpl2 = api23CompoundButtonImpl;
            Api23CompoundButtonImpl api23CompoundButtonImpl3 = new Api23CompoundButtonImpl();
            IMPL = api23CompoundButtonImpl2;
        } else if (i >= 21) {
            LollipopCompoundButtonImpl lollipopCompoundButtonImpl2 = lollipopCompoundButtonImpl;
            LollipopCompoundButtonImpl lollipopCompoundButtonImpl3 = new LollipopCompoundButtonImpl();
            IMPL = lollipopCompoundButtonImpl2;
        } else {
            BaseCompoundButtonCompat baseCompoundButtonCompat2 = baseCompoundButtonCompat;
            BaseCompoundButtonCompat baseCompoundButtonCompat3 = new BaseCompoundButtonCompat();
            IMPL = baseCompoundButtonCompat2;
        }
    }

    private CompoundButtonCompat() {
    }

    @Nullable
    public static Drawable getButtonDrawable(@NonNull CompoundButton compoundButton) {
        return IMPL.getButtonDrawable(compoundButton);
    }

    @Nullable
    public static ColorStateList getButtonTintList(@NonNull CompoundButton compoundButton) {
        return IMPL.getButtonTintList(compoundButton);
    }

    @Nullable
    public static Mode getButtonTintMode(@NonNull CompoundButton compoundButton) {
        return IMPL.getButtonTintMode(compoundButton);
    }

    public static void setButtonTintList(@NonNull CompoundButton compoundButton, @Nullable ColorStateList colorStateList) {
        IMPL.setButtonTintList(compoundButton, colorStateList);
    }

    public static void setButtonTintMode(@NonNull CompoundButton compoundButton, @Nullable Mode mode) {
        IMPL.setButtonTintMode(compoundButton, mode);
    }
}
