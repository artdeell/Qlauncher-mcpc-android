package android.support.p000v4.graphics;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

/* renamed from: android.support.v4.graphics.ColorUtils */
public class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;

    private ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(@NonNull float[] fArr) {
        float[] fArr2 = fArr;
        float f = fArr2[0];
        float f2 = fArr2[1];
        float f3 = fArr2[2];
        float abs = f2 * (1.0f - Math.abs((2.0f * f3) - 1.0f));
        float f4 = f3 - (0.5f * abs);
        float abs2 = abs * (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f));
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        switch (((int) f) / 60) {
            case 0:
                i3 = Math.round(255.0f * (abs + f4));
                i2 = Math.round(255.0f * (abs2 + f4));
                i = Math.round(255.0f * f4);
                break;
            case 1:
                i3 = Math.round(255.0f * (abs2 + f4));
                i2 = Math.round(255.0f * (abs + f4));
                i = Math.round(255.0f * f4);
                break;
            case 2:
                i3 = Math.round(255.0f * f4);
                i2 = Math.round(255.0f * (abs + f4));
                i = Math.round(255.0f * (abs2 + f4));
                break;
            case 3:
                i3 = Math.round(255.0f * f4);
                i2 = Math.round(255.0f * (abs2 + f4));
                i = Math.round(255.0f * (abs + f4));
                break;
            case 4:
                i3 = Math.round(255.0f * (abs2 + f4));
                i2 = Math.round(255.0f * f4);
                i = Math.round(255.0f * (abs + f4));
                break;
            case 5:
            case 6:
                i3 = Math.round(255.0f * (abs + f4));
                i2 = Math.round(255.0f * f4);
                i = Math.round(255.0f * (abs2 + f4));
                break;
        }
        return Color.rgb(constrain(i3, 0, 255), constrain(i2, 0, 255), constrain(i, 0, 255));
    }

    public static void RGBToHSL(@IntRange(from = 0, mo20to = 255) int i, @IntRange(from = 0, mo20to = 255) int i2, @IntRange(from = 0, mo20to = 255) int i3, @NonNull float[] fArr) {
        float f;
        float abs;
        float[] fArr2 = fArr;
        float f2 = ((float) i) / 255.0f;
        float f3 = ((float) i2) / 255.0f;
        float f4 = ((float) i3) / 255.0f;
        float max = Math.max(f2, Math.max(f3, f4));
        float min = Math.min(f2, Math.min(f3, f4));
        float f5 = max - min;
        float f6 = (max + min) / 2.0f;
        if (max == min) {
            abs = 0.0f;
            f = 0.0f;
        } else {
            f = max == f2 ? ((f3 - f4) / f5) % 6.0f : max == f3 ? 2.0f + ((f4 - f2) / f5) : 4.0f + ((f2 - f3) / f5);
            abs = f5 / (1.0f - Math.abs((2.0f * f6) - 1.0f));
        }
        float f7 = (60.0f * f) % 360.0f;
        if (f7 < 0.0f) {
            f7 += 360.0f;
        }
        fArr2[0] = constrain(f7, 0.0f, 360.0f);
        fArr2[1] = constrain(abs, 0.0f, 1.0f);
        fArr2[2] = constrain(f6, 0.0f, 1.0f);
    }

    public static double calculateContrast(@ColorInt int i, @ColorInt int i2) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i3 = i;
        int i4 = i2;
        if (Color.alpha(i4) != 255) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("background can not be translucent: #").append(Integer.toHexString(i4)).toString());
            throw illegalArgumentException2;
        }
        if (Color.alpha(i3) < 255) {
            i3 = compositeColors(i3, i4);
        }
        double calculateLuminance = 0.05d + calculateLuminance(i3);
        double calculateLuminance2 = 0.05d + calculateLuminance(i4);
        return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
    }

    @FloatRange(from = 0.0d, mo15to = 1.0d)
    public static double calculateLuminance(@ColorInt int i) {
        int i2 = i;
        double red = ((double) Color.red(i2)) / 255.0d;
        double green = ((double) Color.green(i2)) / 255.0d;
        double blue = ((double) Color.blue(i2)) / 255.0d;
        return (0.2126d * (red < 0.03928d ? red / 12.92d : Math.pow((0.055d + red) / 1.055d, 2.4d))) + (0.7152d * (green < 0.03928d ? green / 12.92d : Math.pow((0.055d + green) / 1.055d, 2.4d))) + (0.0722d * (blue < 0.03928d ? blue / 12.92d : Math.pow((0.055d + blue) / 1.055d, 2.4d)));
    }

    public static int calculateMinimumAlpha(@ColorInt int i, @ColorInt int i2, float f) {
        int i3;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i4 = i;
        int i5 = i2;
        float f2 = f;
        if (Color.alpha(i5) != 255) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("background can not be translucent: #").append(Integer.toHexString(i5)).toString());
            throw illegalArgumentException2;
        }
        if (calculateContrast(setAlphaComponent(i4, 255), i5) < ((double) f2)) {
            i3 = -1;
        } else {
            int i6 = 0;
            i3 = 255;
            for (int i7 = 0; i7 <= 10 && i3 - i6 > 1; i7++) {
                int i8 = (i6 + i3) / 2;
                if (calculateContrast(setAlphaComponent(i4, i8), i5) < ((double) f2)) {
                    i6 = i8;
                } else {
                    i3 = i8;
                }
            }
        }
        return i3;
    }

    public static void colorToHSL(@ColorInt int i, @NonNull float[] fArr) {
        int i2 = i;
        RGBToHSL(Color.red(i2), Color.green(i2), Color.blue(i2), fArr);
    }

    private static int compositeAlpha(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    public static int compositeColors(@ColorInt int i, @ColorInt int i2) {
        int i3 = i;
        int i4 = i2;
        int alpha = Color.alpha(i4);
        int alpha2 = Color.alpha(i3);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i3), alpha2, Color.red(i4), alpha, compositeAlpha), compositeComponent(Color.green(i3), alpha2, Color.green(i4), alpha, compositeAlpha), compositeComponent(Color.blue(i3), alpha2, Color.blue(i4), alpha, compositeAlpha));
    }

    private static int compositeComponent(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        if (i10 == 0) {
            return 0;
        }
        return ((i7 * (i6 * 255)) + ((i8 * i9) * (255 - i7))) / (i10 * 255);
    }

    private static float constrain(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        return f4 < f5 ? f5 : f4 > f6 ? f6 : f4;
    }

    private static int constrain(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        return i4 < i5 ? i5 : i4 > i6 ? i6 : i4;
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int i, @IntRange(from = 0, mo20to = 255) int i2) {
        IllegalArgumentException illegalArgumentException;
        int i3 = i;
        int i4 = i2;
        if (i4 >= 0 && i4 <= 255) {
            return (16777215 & i3) | (i4 << 24);
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("alpha must be between 0 and 255.");
        throw illegalArgumentException2;
    }
}
