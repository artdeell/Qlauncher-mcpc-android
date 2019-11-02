package android.support.p000v4.content.res;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.AnyRes;
import android.support.annotation.StyleableRes;

/* renamed from: android.support.v4.content.res.TypedArrayUtils */
public class TypedArrayUtils {
    public TypedArrayUtils() {
    }

    public static boolean getBoolean(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2, boolean z) {
        TypedArray typedArray2 = typedArray;
        return typedArray2.getBoolean(i, typedArray2.getBoolean(i2, z));
    }

    public static Drawable getDrawable(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2) {
        TypedArray typedArray2 = typedArray;
        int i3 = i2;
        Drawable drawable = typedArray2.getDrawable(i);
        if (drawable == null) {
            drawable = typedArray2.getDrawable(i3);
        }
        return drawable;
    }

    public static int getInt(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2, int i3) {
        TypedArray typedArray2 = typedArray;
        return typedArray2.getInt(i, typedArray2.getInt(i2, i3));
    }

    @AnyRes
    public static int getResourceId(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2, @AnyRes int i3) {
        TypedArray typedArray2 = typedArray;
        return typedArray2.getResourceId(i, typedArray2.getResourceId(i2, i3));
    }

    public static String getString(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2) {
        TypedArray typedArray2 = typedArray;
        int i3 = i2;
        String string = typedArray2.getString(i);
        if (string == null) {
            string = typedArray2.getString(i3);
        }
        return string;
    }

    public static CharSequence[] getTextArray(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2) {
        TypedArray typedArray2 = typedArray;
        int i3 = i2;
        CharSequence[] textArray = typedArray2.getTextArray(i);
        if (textArray == null) {
            textArray = typedArray2.getTextArray(i3);
        }
        return textArray;
    }
}
