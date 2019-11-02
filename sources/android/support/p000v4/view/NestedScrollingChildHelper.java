package android.support.p000v4.view;

import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.NestedScrollingChildHelper */
public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParent;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(View view) {
        this.mView = view;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        float f3 = f;
        float f4 = f2;
        boolean z2 = z;
        if (!isNestedScrollingEnabled() || this.mNestedScrollingParent == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(this.mNestedScrollingParent, this.mView, f3, f4, z2);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        if (!isNestedScrollingEnabled() || this.mNestedScrollingParent == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(this.mNestedScrollingParent, this.mView, f3, f4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0090, code lost:
        if (r3[1] != 0) goto L_0x0092;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchNestedPreScroll(int r17, int r18, int[] r19, int[] r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r11 = r0
            boolean r11 = r11.isNestedScrollingEnabled()
            r5 = r11
            r11 = 0
            r6 = r11
            r11 = r5
            if (r11 == 0) goto L_0x0094
            r11 = r0
            android.view.ViewParent r11 = r11.mNestedScrollingParent
            r7 = r11
            r11 = 0
            r6 = r11
            r11 = r7
            if (r11 == 0) goto L_0x0094
            r11 = r1
            if (r11 != 0) goto L_0x0024
            r11 = r2
            if (r11 == 0) goto L_0x0097
        L_0x0024:
            r11 = 0
            r8 = r11
            r11 = 0
            r9 = r11
            r11 = r4
            if (r11 == 0) goto L_0x003c
            r11 = r0
            android.view.View r11 = r11.mView
            r12 = r4
            r11.getLocationInWindow(r12)
            r11 = r4
            r12 = 0
            r11 = r11[r12]
            r8 = r11
            r11 = r4
            r12 = 1
            r11 = r11[r12]
            r9 = r11
        L_0x003c:
            r11 = r3
            if (r11 != 0) goto L_0x004e
            r11 = r0
            int[] r11 = r11.mTempNestedScrollConsumed
            if (r11 != 0) goto L_0x004a
            r11 = r0
            r12 = 2
            int[] r12 = new int[r12]
            r11.mTempNestedScrollConsumed = r12
        L_0x004a:
            r11 = r0
            int[] r11 = r11.mTempNestedScrollConsumed
            r3 = r11
        L_0x004e:
            r11 = r3
            r12 = 0
            r13 = 0
            r11[r12] = r13
            r11 = r3
            r12 = 1
            r13 = 0
            r11[r12] = r13
            r11 = r0
            android.view.ViewParent r11 = r11.mNestedScrollingParent
            r12 = r0
            android.view.View r12 = r12.mView
            r13 = r1
            r14 = r2
            r15 = r3
            android.support.p000v4.view.ViewParentCompat.onNestedPreScroll(r11, r12, r13, r14, r15)
            r11 = r4
            if (r11 == 0) goto L_0x0082
            r11 = r0
            android.view.View r11 = r11.mView
            r12 = r4
            r11.getLocationInWindow(r12)
            r11 = r4
            r12 = 0
            r13 = r4
            r14 = 0
            r13 = r13[r14]
            r14 = r8
            int r13 = r13 - r14
            r11[r12] = r13
            r11 = r4
            r12 = 1
            r13 = r4
            r14 = 1
            r13 = r13[r14]
            r14 = r9
            int r13 = r13 - r14
            r11[r12] = r13
        L_0x0082:
            r11 = r3
            r12 = 0
            r11 = r11[r12]
            if (r11 != 0) goto L_0x0092
            r11 = r3
            r12 = 1
            r11 = r11[r12]
            r10 = r11
            r11 = 0
            r6 = r11
            r11 = r10
            if (r11 == 0) goto L_0x0094
        L_0x0092:
            r11 = 1
            r6 = r11
        L_0x0094:
            r11 = r6
            r0 = r11
        L_0x0096:
            return r0
        L_0x0097:
            r11 = 0
            r6 = r11
            r11 = r4
            if (r11 == 0) goto L_0x0094
            r11 = r4
            r12 = 0
            r13 = 0
            r11[r12] = r13
            r11 = r4
            r12 = 1
            r13 = 0
            r11[r12] = r13
            r11 = 0
            r0 = r11
            goto L_0x0096
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.NestedScrollingChildHelper.dispatchNestedPreScroll(int, int, int[], int[]):boolean");
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int[] iArr2 = iArr;
        if (isNestedScrollingEnabled() && this.mNestedScrollingParent != null) {
            if (i5 != 0 || i6 != 0 || i7 != 0 || i8 != 0) {
                int i9 = 0;
                int i10 = 0;
                if (iArr2 != null) {
                    this.mView.getLocationInWindow(iArr2);
                    i9 = iArr2[0];
                    i10 = iArr2[1];
                }
                ViewParentCompat.onNestedScroll(this.mNestedScrollingParent, this.mView, i5, i6, i7, i8);
                if (iArr2 != null) {
                    this.mView.getLocationInWindow(iArr2);
                    iArr2[0] = iArr2[0] - i9;
                    iArr2[1] = iArr2[1] - i10;
                }
                return true;
            } else if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
        }
        return false;
    }

    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingParent != null;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(View view) {
        View view2 = view;
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean z) {
        boolean z2 = z;
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = z2;
    }

    public boolean startNestedScroll(int i) {
        int i2 = i;
        if (hasNestedScrollingParent()) {
            return true;
        }
        if (isNestedScrollingEnabled()) {
            View view = this.mView;
            for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
                if (ViewParentCompat.onStartNestedScroll(parent, view, this.mView, i2)) {
                    this.mNestedScrollingParent = parent;
                    ViewParentCompat.onNestedScrollAccepted(parent, view, this.mView, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void stopNestedScroll() {
        if (this.mNestedScrollingParent != null) {
            ViewParentCompat.onStopNestedScroll(this.mNestedScrollingParent, this.mView);
            this.mNestedScrollingParent = null;
        }
    }
}
