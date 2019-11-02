package android.support.p000v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: android.support.v4.view.ViewPropertyAnimatorCompatLollipop */
class ViewPropertyAnimatorCompatLollipop {
    ViewPropertyAnimatorCompatLollipop() {
    }

    public static void translationZ(View view, float f) {
        ViewPropertyAnimator translationZ = view.animate().translationZ(f);
    }

    public static void translationZBy(View view, float f) {
        ViewPropertyAnimator translationZBy = view.animate().translationZBy(f);
    }

    /* renamed from: z */
    public static void m18z(View view, float f) {
        ViewPropertyAnimator z = view.animate().z(f);
    }

    public static void zBy(View view, float f) {
        ViewPropertyAnimator zBy = view.animate().zBy(f);
    }
}
