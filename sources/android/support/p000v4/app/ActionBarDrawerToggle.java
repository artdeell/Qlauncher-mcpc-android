package android.support.p000v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.widget.DrawerLayout;
import android.support.p000v4.widget.DrawerLayout.DrawerListener;
import android.view.MenuItem;
import android.view.View;

@Deprecated
/* renamed from: android.support.v4.app.ActionBarDrawerToggle */
public class ActionBarDrawerToggle implements DrawerListener {
    private static final int ID_HOME = 16908332;
    private static final ActionBarDrawerToggleImpl IMPL;
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    /* access modifiers changed from: private */
    public final Activity mActivity;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private Object mSetIndicatorInfo;
    private SlideDrawable mSlider;

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImpl */
    private interface ActionBarDrawerToggleImpl {
        Drawable getThemeUpIndicator(Activity activity);

        Object setActionBarDescription(Object obj, Activity activity, int i);

        Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i);
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImplBase */
    private static class ActionBarDrawerToggleImplBase implements ActionBarDrawerToggleImpl {
        private ActionBarDrawerToggleImplBase() {
        }

        /* synthetic */ ActionBarDrawerToggleImplBase(C00021 r4) {
            C00021 r1 = r4;
            this();
        }

        public Drawable getThemeUpIndicator(Activity activity) {
            Activity activity2 = activity;
            return null;
        }

        public Object setActionBarDescription(Object obj, Activity activity, int i) {
            Activity activity2 = activity;
            int i2 = i;
            return obj;
        }

        public Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i) {
            Activity activity2 = activity;
            Drawable drawable2 = drawable;
            int i2 = i;
            return obj;
        }
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImplHC */
    private static class ActionBarDrawerToggleImplHC implements ActionBarDrawerToggleImpl {
        private ActionBarDrawerToggleImplHC() {
        }

        /* synthetic */ ActionBarDrawerToggleImplHC(C00021 r4) {
            C00021 r1 = r4;
            this();
        }

        public Drawable getThemeUpIndicator(Activity activity) {
            return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(activity);
        }

        public Object setActionBarDescription(Object obj, Activity activity, int i) {
            return ActionBarDrawerToggleHoneycomb.setActionBarDescription(obj, activity, i);
        }

        public Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i) {
            return ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(obj, activity, drawable, i);
        }
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImplJellybeanMR2 */
    private static class ActionBarDrawerToggleImplJellybeanMR2 implements ActionBarDrawerToggleImpl {
        private ActionBarDrawerToggleImplJellybeanMR2() {
        }

        /* synthetic */ ActionBarDrawerToggleImplJellybeanMR2(C00021 r4) {
            C00021 r1 = r4;
            this();
        }

        public Drawable getThemeUpIndicator(Activity activity) {
            return ActionBarDrawerToggleJellybeanMR2.getThemeUpIndicator(activity);
        }

        public Object setActionBarDescription(Object obj, Activity activity, int i) {
            return ActionBarDrawerToggleJellybeanMR2.setActionBarDescription(obj, activity, i);
        }

        public Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i) {
            return ActionBarDrawerToggleJellybeanMR2.setActionBarUpIndicator(obj, activity, drawable, i);
        }
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$Delegate */
    public interface Delegate {
        @Nullable
        Drawable getThemeUpIndicator();

        void setActionBarDescription(@StringRes int i);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i);
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$DelegateProvider */
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$SlideDrawable */
    private class SlideDrawable extends InsetDrawable implements Callback {
        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect;
        final /* synthetic */ ActionBarDrawerToggle this$0;

        private SlideDrawable(ActionBarDrawerToggle actionBarDrawerToggle, Drawable drawable) {
            Rect rect;
            Drawable drawable2 = drawable;
            this.this$0 = actionBarDrawerToggle;
            super(drawable2, 0);
            boolean z = false;
            if (VERSION.SDK_INT > 18) {
                z = true;
            }
            this.mHasMirroring = z;
            Rect rect2 = rect;
            Rect rect3 = new Rect();
            this.mTmpRect = rect2;
        }

        /* synthetic */ SlideDrawable(ActionBarDrawerToggle actionBarDrawerToggle, Drawable drawable, C00021 r10) {
            C00021 r3 = r10;
            this(actionBarDrawerToggle, drawable);
        }

        public void draw(Canvas canvas) {
            Canvas canvas2 = canvas;
            int i = 1;
            copyBounds(this.mTmpRect);
            int save = canvas2.save();
            boolean z = ViewCompat.getLayoutDirection(this.this$0.mActivity.getWindow().getDecorView()) == 1;
            if (z) {
                i = -1;
            }
            int width = this.mTmpRect.width();
            canvas2.translate((-this.mOffset) * ((float) width) * this.mPosition * ((float) i), 0.0f);
            if (z && !this.mHasMirroring) {
                canvas2.translate((float) width, 0.0f);
                canvas2.scale(-1.0f, 1.0f);
            }
            super.draw(canvas2);
            canvas2.restore();
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void setOffset(float f) {
            this.mOffset = f;
            invalidateSelf();
        }

        public void setPosition(float f) {
            this.mPosition = f;
            invalidateSelf();
        }
    }

    static {
        ActionBarDrawerToggleImplBase actionBarDrawerToggleImplBase;
        ActionBarDrawerToggleImplHC actionBarDrawerToggleImplHC;
        ActionBarDrawerToggleImplJellybeanMR2 actionBarDrawerToggleImplJellybeanMR2;
        int i = VERSION.SDK_INT;
        if (i >= 18) {
            ActionBarDrawerToggleImplJellybeanMR2 actionBarDrawerToggleImplJellybeanMR22 = actionBarDrawerToggleImplJellybeanMR2;
            ActionBarDrawerToggleImplJellybeanMR2 actionBarDrawerToggleImplJellybeanMR23 = new ActionBarDrawerToggleImplJellybeanMR2(null);
            IMPL = actionBarDrawerToggleImplJellybeanMR22;
        } else if (i >= 11) {
            ActionBarDrawerToggleImplHC actionBarDrawerToggleImplHC2 = actionBarDrawerToggleImplHC;
            ActionBarDrawerToggleImplHC actionBarDrawerToggleImplHC3 = new ActionBarDrawerToggleImplHC(null);
            IMPL = actionBarDrawerToggleImplHC2;
        } else {
            ActionBarDrawerToggleImplBase actionBarDrawerToggleImplBase2 = actionBarDrawerToggleImplBase;
            ActionBarDrawerToggleImplBase actionBarDrawerToggleImplBase3 = new ActionBarDrawerToggleImplBase(null);
            IMPL = actionBarDrawerToggleImplBase2;
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @DrawableRes int i, @StringRes int i2, @StringRes int i3) {
        Activity activity2 = activity;
        this(activity2, drawerLayout, !assumeMaterial(activity2), i, i2, i3);
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z, @DrawableRes int i, @StringRes int i2, @StringRes int i3) {
        SlideDrawable slideDrawable;
        Activity activity2 = activity;
        DrawerLayout drawerLayout2 = drawerLayout;
        boolean z2 = z;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = activity2;
        if (activity2 instanceof DelegateProvider) {
            this.mActivityImpl = ((DelegateProvider) activity2).getDrawerToggleDelegate();
        } else {
            this.mActivityImpl = null;
        }
        this.mDrawerLayout = drawerLayout2;
        this.mDrawerImageResource = i4;
        this.mOpenDrawerContentDescRes = i5;
        this.mCloseDrawerContentDescRes = i6;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable(activity2, i4);
        SlideDrawable slideDrawable2 = slideDrawable;
        SlideDrawable slideDrawable3 = new SlideDrawable(this, this.mDrawerImage, null);
        this.mSlider = slideDrawable2;
        this.mSlider.setOffset(z2 ? 0.33333334f : 0.0f);
    }

    private static boolean assumeMaterial(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21 && VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: 0000 */
    public Drawable getThemeUpIndicator() {
        return this.mActivityImpl != null ? this.mActivityImpl.getThemeUpIndicator() : IMPL.getThemeUpIndicator(this.mActivity);
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration configuration) {
        Configuration configuration2 = configuration;
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
        }
        this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
        syncState();
    }

    public void onDrawerClosed(View view) {
        View view2 = view;
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }

    public void onDrawerOpened(View view) {
        View view2 = view;
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }

    public void onDrawerSlide(View view, float f) {
        View view2 = view;
        float f2 = f;
        float position = this.mSlider.getPosition();
        this.mSlider.setPosition(f2 > 0.5f ? Math.max(position, 2.0f * Math.max(0.0f, f2 - 0.5f)) : Math.min(position, f2 * 2.0f));
    }

    public void onDrawerStateChanged(int i) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        MenuItem menuItem2 = menuItem;
        if (menuItem2 == null || menuItem2.getItemId() != ID_HOME || !this.mDrawerIndicatorEnabled) {
            return false;
        }
        if (this.mDrawerLayout.isDrawerVisible(8388611)) {
            this.mDrawerLayout.closeDrawer(8388611);
        } else {
            this.mDrawerLayout.openDrawer(8388611);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void setActionBarDescription(int i) {
        int i2 = i;
        if (this.mActivityImpl != null) {
            this.mActivityImpl.setActionBarDescription(i2);
            return;
        }
        this.mSetIndicatorInfo = IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, i2);
    }

    /* access modifiers changed from: 0000 */
    public void setActionBarUpIndicator(Drawable drawable, int i) {
        Drawable drawable2 = drawable;
        int i2 = i;
        if (this.mActivityImpl != null) {
            this.mActivityImpl.setActionBarUpIndicator(drawable2, i2);
            return;
        }
        this.mSetIndicatorInfo = IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, drawable2, i2);
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        boolean z2 = z;
        if (z2 != this.mDrawerIndicatorEnabled) {
            if (z2) {
                setActionBarUpIndicator(this.mSlider, this.mDrawerLayout.isDrawerOpen(8388611) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
            } else {
                setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = z2;
        }
    }

    public void setHomeAsUpIndicator(int i) {
        int i2 = i;
        Drawable drawable = null;
        if (i2 != 0) {
            drawable = ContextCompat.getDrawable(this.mActivity, i2);
        }
        setHomeAsUpIndicator(drawable);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        Drawable drawable2 = drawable;
        if (drawable2 == null) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        } else {
            this.mHomeAsUpIndicator = drawable2;
            this.mHasCustomUpIndicator = true;
        }
        if (!this.mDrawerIndicatorEnabled) {
            setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        }
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(8388611)) {
            this.mSlider.setPosition(1.0f);
        } else {
            this.mSlider.setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            setActionBarUpIndicator(this.mSlider, this.mDrawerLayout.isDrawerOpen(8388611) ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes);
        }
    }
}
