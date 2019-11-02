package android.support.p000v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.app.ActionBarDrawerToggleHoneycomb */
class ActionBarDrawerToggleHoneycomb {
    private static final String TAG = "ActionBarDrawerToggleHoneycomb";
    private static final int[] THEME_ATTRS;

    /* renamed from: android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo */
    private static class SetIndicatorInfo {
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        SetIndicatorInfo(Activity activity) {
            Activity activity2 = activity;
            Class<ActionBar> cls = ActionBar.class;
            String str = "setHomeAsUpIndicator";
            try {
                Class[] clsArr = new Class[1];
                Class[] clsArr2 = clsArr;
                clsArr[0] = Drawable.class;
                this.setHomeAsUpIndicator = cls.getDeclaredMethod(str, clsArr2);
                this.setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
            } catch (NoSuchMethodException e) {
                NoSuchMethodException noSuchMethodException = e;
                View findViewById = activity2.findViewById(16908332);
                if (findViewById != null) {
                    ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                    if (viewGroup.getChildCount() == 2) {
                        View childAt = viewGroup.getChildAt(0);
                        View view = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                        if (view instanceof ImageView) {
                            this.upIndicatorView = (ImageView) view;
                        }
                    }
                }
            }
        }
    }

    static {
        int[] iArr = new int[1];
        int[] iArr2 = iArr;
        iArr[0] = 16843531;
        THEME_ATTRS = iArr2;
    }

    ActionBarDrawerToggleHoneycomb() {
    }

    public static Drawable getThemeUpIndicator(Activity activity) {
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(THEME_ATTRS);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r9v22 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object setActionBarDescription(java.lang.Object r13, android.app.Activity r14, int r15) {
        /*
            r0 = r13
            r1 = r14
            r2 = r15
            r9 = r0
            if (r9 != 0) goto L_0x0010
            android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo r9 = new android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo
            r12 = r9
            r9 = r12
            r10 = r12
            r11 = r1
            r10.<init>(r11)
            r0 = r9
        L_0x0010:
            r9 = r0
            android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo r9 = (android.support.p000v4.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo) r9
            r3 = r9
            r9 = r3
            java.lang.reflect.Method r9 = r9.setHomeAsUpIndicator
            if (r9 == 0) goto L_0x0046
            r9 = r1
            android.app.ActionBar r9 = r9.getActionBar()     // Catch:{ Exception -> 0x0049 }
            r6 = r9
            r9 = r3
            java.lang.reflect.Method r9 = r9.setHomeActionContentDescription     // Catch:{ Exception -> 0x0049 }
            r7 = r9
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0049 }
            r8 = r9
            r9 = r8
            r10 = 0
            r11 = r2
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0049 }
            r9[r10] = r11     // Catch:{ Exception -> 0x0049 }
            r9 = r7
            r10 = r6
            r11 = r8
            java.lang.Object r9 = r9.invoke(r10, r11)     // Catch:{ Exception -> 0x0049 }
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0049 }
            r10 = 19
            if (r9 > r10) goto L_0x0046
            r9 = r6
            r10 = r6
            java.lang.CharSequence r10 = r10.getSubtitle()     // Catch:{ Exception -> 0x0049 }
            r9.setSubtitle(r10)     // Catch:{ Exception -> 0x0049 }
        L_0x0046:
            r9 = r0
            r0 = r9
        L_0x0048:
            return r0
        L_0x0049:
            r9 = move-exception
            r4 = r9
            java.lang.String r9 = "ActionBarDrawerToggleHoneycomb"
            java.lang.String r10 = "Couldn't set content description via JB-MR2 API"
            r11 = r4
            int r9 = android.util.Log.w(r9, r10, r11)
            r9 = r0
            r0 = r9
            goto L_0x0048
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.ActionBarDrawerToggleHoneycomb.setActionBarDescription(java.lang.Object, android.app.Activity, int):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r12v1 */
    /* JADX WARNING: type inference failed for: r12v9 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r12v12 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r12v17 */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r12v29 */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r18v1 */
    /* JADX WARNING: type inference failed for: r12v31 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 13 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object setActionBarUpIndicator(java.lang.Object r19, android.app.Activity r20, android.graphics.drawable.Drawable r21, int r22) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r12 = r0
            if (r12 != 0) goto L_0x0018
            android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo r12 = new android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo
            r18 = r12
            r12 = r18
            r13 = r18
            r14 = r1
            r13.<init>(r14)
            r0 = r12
        L_0x0018:
            r12 = r0
            android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo r12 = (android.support.p000v4.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo) r12
            r4 = r12
            r12 = r4
            java.lang.reflect.Method r12 = r12.setHomeAsUpIndicator
            if (r12 == 0) goto L_0x0067
            r12 = r1
            android.app.ActionBar r12 = r12.getActionBar()     // Catch:{ Exception -> 0x0059 }
            r8 = r12
            r12 = r4
            java.lang.reflect.Method r12 = r12.setHomeAsUpIndicator     // Catch:{ Exception -> 0x0059 }
            r13 = r8
            r14 = 1
            java.lang.Object[] r14 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x0059 }
            r18 = r14
            r14 = r18
            r15 = r18
            r16 = 0
            r17 = r2
            r15[r16] = r17     // Catch:{ Exception -> 0x0059 }
            java.lang.Object r12 = r12.invoke(r13, r14)     // Catch:{ Exception -> 0x0059 }
            r12 = r4
            java.lang.reflect.Method r12 = r12.setHomeActionContentDescription     // Catch:{ Exception -> 0x0059 }
            r10 = r12
            r12 = 1
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x0059 }
            r11 = r12
            r12 = r11
            r13 = 0
            r14 = r3
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x0059 }
            r12[r13] = r14     // Catch:{ Exception -> 0x0059 }
            r12 = r10
            r13 = r8
            r14 = r11
            java.lang.Object r12 = r12.invoke(r13, r14)     // Catch:{ Exception -> 0x0059 }
            r12 = r0
            r0 = r12
        L_0x0058:
            return r0
        L_0x0059:
            r12 = move-exception
            r6 = r12
            java.lang.String r12 = "ActionBarDrawerToggleHoneycomb"
            java.lang.String r13 = "Couldn't set home-as-up indicator via JB-MR2 API"
            r14 = r6
            int r12 = android.util.Log.w(r12, r13, r14)
            r12 = r0
            r0 = r12
            goto L_0x0058
        L_0x0067:
            r12 = r4
            android.widget.ImageView r12 = r12.upIndicatorView
            if (r12 == 0) goto L_0x0076
            r12 = r4
            android.widget.ImageView r12 = r12.upIndicatorView
            r13 = r2
            r12.setImageDrawable(r13)
            r12 = r0
            r0 = r12
            goto L_0x0058
        L_0x0076:
            java.lang.String r12 = "ActionBarDrawerToggleHoneycomb"
            java.lang.String r13 = "Couldn't set home-as-up indicator"
            int r12 = android.util.Log.w(r12, r13)
            r12 = r0
            r0 = r12
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(java.lang.Object, android.app.Activity, android.graphics.drawable.Drawable, int):java.lang.Object");
    }
}
