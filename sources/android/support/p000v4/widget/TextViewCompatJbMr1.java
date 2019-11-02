package android.support.p000v4.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

/* renamed from: android.support.v4.widget.TextViewCompatJbMr1 */
class TextViewCompatJbMr1 {
    TextViewCompatJbMr1() {
    }

    public static void setCompoundDrawablesRelative(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        TextView textView2 = textView;
        Drawable drawable5 = drawable;
        Drawable drawable6 = drawable2;
        Drawable drawable7 = drawable3;
        Drawable drawable8 = drawable4;
        boolean z = true;
        if (textView2.getLayoutDirection() != 1) {
            z = false;
        }
        Drawable drawable9 = z ? drawable7 : drawable5;
        if (!z) {
            drawable5 = drawable7;
        }
        textView2.setCompoundDrawables(drawable9, drawable6, drawable5, drawable8);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, int i, int i2, int i3, int i4) {
        TextView textView2 = textView;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        boolean z = true;
        if (textView2.getLayoutDirection() != 1) {
            z = false;
        }
        int i9 = z ? i7 : i5;
        if (!z) {
            i5 = i7;
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(i9, i6, i5, i8);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        TextView textView2 = textView;
        Drawable drawable5 = drawable;
        Drawable drawable6 = drawable2;
        Drawable drawable7 = drawable3;
        Drawable drawable8 = drawable4;
        boolean z = true;
        if (textView2.getLayoutDirection() != 1) {
            z = false;
        }
        Drawable drawable9 = z ? drawable7 : drawable5;
        if (!z) {
            drawable5 = drawable7;
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable9, drawable6, drawable5, drawable8);
    }
}
