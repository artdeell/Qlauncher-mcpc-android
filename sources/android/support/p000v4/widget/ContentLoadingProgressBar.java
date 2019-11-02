package android.support.p000v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* renamed from: android.support.v4.widget.ContentLoadingProgressBar */
public class ContentLoadingProgressBar extends ProgressBar {
    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    /* access modifiers changed from: private */
    public boolean mDismissed;
    private boolean mPostedHide;
    private boolean mPostedShow;
    private long mStartTime;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        C01271 r7;
        C01282 r72;
        super(context, attributeSet, 0);
        this.mStartTime = -1;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        C01271 r4 = r7;
        C01271 r5 = new Runnable(this) {
            final /* synthetic */ ContentLoadingProgressBar this$0;

            {
                this.this$0 = r5;
            }

            public void run() {
                boolean access$002 = ContentLoadingProgressBar.access$002(this.this$0, false);
                long access$102 = ContentLoadingProgressBar.access$102(this.this$0, -1);
                this.this$0.setVisibility(8);
            }
        };
        this.mDelayedHide = r4;
        C01282 r42 = r72;
        C01282 r52 = new Runnable(this) {
            final /* synthetic */ ContentLoadingProgressBar this$0;

            {
                this.this$0 = r5;
            }

            public void run() {
                boolean access$202 = ContentLoadingProgressBar.access$202(this.this$0, false);
                if (!this.this$0.mDismissed) {
                    long access$102 = ContentLoadingProgressBar.access$102(this.this$0, System.currentTimeMillis());
                    this.this$0.setVisibility(0);
                }
            }
        };
        this.mDelayedShow = r42;
    }

    static /* synthetic */ boolean access$002(ContentLoadingProgressBar contentLoadingProgressBar, boolean z) {
        boolean z2 = z;
        contentLoadingProgressBar.mPostedHide = z2;
        return z2;
    }

    static /* synthetic */ long access$102(ContentLoadingProgressBar contentLoadingProgressBar, long j) {
        long j2 = j;
        contentLoadingProgressBar.mStartTime = j2;
        return j2;
    }

    static /* synthetic */ boolean access$202(ContentLoadingProgressBar contentLoadingProgressBar, boolean z) {
        boolean z2 = z;
        contentLoadingProgressBar.mPostedShow = z2;
        return z2;
    }

    private void removeCallbacks() {
        boolean removeCallbacks = removeCallbacks(this.mDelayedHide);
        boolean removeCallbacks2 = removeCallbacks(this.mDelayedShow);
    }

    public void hide() {
        this.mDismissed = true;
        boolean removeCallbacks = removeCallbacks(this.mDelayedShow);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (currentTimeMillis >= 500 || this.mStartTime == -1) {
            setVisibility(8);
        } else if (!this.mPostedHide) {
            boolean postDelayed = postDelayed(this.mDelayedHide, 500 - currentTimeMillis);
            this.mPostedHide = true;
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    public void show() {
        this.mStartTime = -1;
        this.mDismissed = false;
        boolean removeCallbacks = removeCallbacks(this.mDelayedHide);
        if (!this.mPostedShow) {
            boolean postDelayed = postDelayed(this.mDelayedShow, 500);
            this.mPostedShow = true;
        }
    }
}
