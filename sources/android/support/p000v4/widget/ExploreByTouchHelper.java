package android.support.p000v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.p000v4.view.AccessibilityDelegateCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewParentCompat;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.support.p000v4.view.accessibility.AccessibilityManagerCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: android.support.v4.widget.ExploreByTouchHelper */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = View.class.getName();
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private int mFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;
    private final AccessibilityManager mManager;
    private ExploreByTouchNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect = new int[2];
    private final Rect mTempParentRect;
    private final Rect mTempScreenRect;
    private final Rect mTempVisibleRect;
    private final View mView;

    /* renamed from: android.support.v4.widget.ExploreByTouchHelper$ExploreByTouchNodeProvider */
    private class ExploreByTouchNodeProvider extends AccessibilityNodeProviderCompat {
        final /* synthetic */ ExploreByTouchHelper this$0;

        private ExploreByTouchNodeProvider(ExploreByTouchHelper exploreByTouchHelper) {
            this.this$0 = exploreByTouchHelper;
        }

        /* synthetic */ ExploreByTouchNodeProvider(ExploreByTouchHelper exploreByTouchHelper, C01321 r7) {
            C01321 r2 = r7;
            this(exploreByTouchHelper);
        }

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            return this.this$0.createNode(i);
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.this$0.performAction(i, i2, bundle);
        }
    }

    public ExploreByTouchHelper(View view) {
        Rect rect;
        Rect rect2;
        Rect rect3;
        IllegalArgumentException illegalArgumentException;
        View view2 = view;
        Rect rect4 = rect;
        Rect rect5 = new Rect();
        this.mTempScreenRect = rect4;
        Rect rect6 = rect2;
        Rect rect7 = new Rect();
        this.mTempParentRect = rect6;
        Rect rect8 = rect3;
        Rect rect9 = new Rect();
        this.mTempVisibleRect = rect8;
        if (view2 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("View may not be null");
            throw illegalArgumentException2;
        }
        this.mView = view2;
        this.mManager = (AccessibilityManager) view2.getContext().getSystemService("accessibility");
    }

    private boolean clearAccessibilityFocus(int i) {
        int i2 = i;
        if (!isAccessibilityFocused(i2)) {
            return false;
        }
        this.mFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mView.invalidate();
        boolean sendEventForVirtualView = sendEventForVirtualView(i2, 65536);
        return true;
    }

    private AccessibilityEvent createEvent(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        switch (i3) {
            case -1:
                return createEventForHost(i4);
            default:
                return createEventForChild(i3, i4);
        }
    }

    private AccessibilityEvent createEventForChild(int i, int i2) {
        RuntimeException runtimeException;
        int i3 = i;
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        obtain.setEnabled(true);
        obtain.setClassName(DEFAULT_CLASS_NAME);
        onPopulateEventForVirtualView(i3, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setPackageName(this.mView.getContext().getPackageName());
            AccessibilityEventCompat.asRecord(obtain).setSource(this.mView, i3);
            return obtain;
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        throw runtimeException2;
    }

    private AccessibilityEvent createEventForHost(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        ViewCompat.onInitializeAccessibilityEvent(this.mView, obtain);
        return obtain;
    }

    /* access modifiers changed from: private */
    public AccessibilityNodeInfoCompat createNode(int i) {
        int i2 = i;
        switch (i2) {
            case -1:
                return createNodeForHost();
            default:
                return createNodeForChild(i2);
        }
    }

    private AccessibilityNodeInfoCompat createNodeForChild(int i) {
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        RuntimeException runtimeException3;
        RuntimeException runtimeException4;
        int i2 = i;
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setClassName(DEFAULT_CLASS_NAME);
        onPopulateNodeForVirtualView(i2, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            RuntimeException runtimeException5 = runtimeException4;
            RuntimeException runtimeException6 = new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
            throw runtimeException5;
        }
        obtain.getBoundsInParent(this.mTempParentRect);
        if (this.mTempParentRect.isEmpty()) {
            RuntimeException runtimeException7 = runtimeException3;
            RuntimeException runtimeException8 = new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
            throw runtimeException7;
        }
        int actions = obtain.getActions();
        if ((actions & 64) != 0) {
            RuntimeException runtimeException9 = runtimeException2;
            RuntimeException runtimeException10 = new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            throw runtimeException9;
        } else if ((actions & 128) != 0) {
            RuntimeException runtimeException11 = runtimeException;
            RuntimeException runtimeException12 = new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            throw runtimeException11;
        } else {
            obtain.setPackageName(this.mView.getContext().getPackageName());
            obtain.setSource(this.mView, i2);
            obtain.setParent(this.mView);
            if (this.mFocusedVirtualViewId == i2) {
                obtain.setAccessibilityFocused(true);
                obtain.addAction(128);
            } else {
                obtain.setAccessibilityFocused(false);
                obtain.addAction(64);
            }
            if (intersectVisibleToUser(this.mTempParentRect)) {
                obtain.setVisibleToUser(true);
                obtain.setBoundsInParent(this.mTempParentRect);
            }
            this.mView.getLocationOnScreen(this.mTempGlobalRect);
            int i3 = this.mTempGlobalRect[0];
            int i4 = this.mTempGlobalRect[1];
            this.mTempScreenRect.set(this.mTempParentRect);
            this.mTempScreenRect.offset(i3, i4);
            obtain.setBoundsInScreen(this.mTempScreenRect);
            return obtain;
        }
    }

    private AccessibilityNodeInfoCompat createNodeForHost() {
        LinkedList linkedList;
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.mView);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mView, obtain);
        onPopulateNodeForHost(obtain);
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = linkedList2;
        getVisibleVirtualViews(linkedList4);
        Iterator it = linkedList4.iterator();
        while (it.hasNext()) {
            obtain.addChild(this.mView, ((Integer) it.next()).intValue());
        }
        return obtain;
    }

    private boolean intersectVisibleToUser(Rect rect) {
        Rect rect2 = rect;
        if (rect2 != null && !rect2.isEmpty() && this.mView.getWindowVisibility() == 0) {
            ViewParent parent = this.mView.getParent();
            while (true) {
                ViewParent viewParent = parent;
                if (viewParent instanceof View) {
                    View view = (View) viewParent;
                    if (ViewCompat.getAlpha(view) <= 0.0f || view.getVisibility() != 0) {
                        break;
                    }
                    parent = view.getParent();
                } else if (viewParent != null && this.mView.getLocalVisibleRect(this.mTempVisibleRect)) {
                    return rect2.intersect(this.mTempVisibleRect);
                }
            }
        }
        return false;
    }

    private boolean isAccessibilityFocused(int i) {
        return this.mFocusedVirtualViewId == i;
    }

    private boolean manageFocusForChild(int i, int i2, Bundle bundle) {
        int i3 = i;
        Bundle bundle2 = bundle;
        switch (i2) {
            case 64:
                return requestAccessibilityFocus(i3);
            case 128:
                return clearAccessibilityFocus(i3);
            default:
                return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean performAction(int i, int i2, Bundle bundle) {
        int i3 = i;
        int i4 = i2;
        Bundle bundle2 = bundle;
        switch (i3) {
            case -1:
                return performActionForHost(i4, bundle2);
            default:
                return performActionForChild(i3, i4, bundle2);
        }
    }

    private boolean performActionForChild(int i, int i2, Bundle bundle) {
        int i3 = i;
        int i4 = i2;
        Bundle bundle2 = bundle;
        switch (i4) {
            case 64:
            case 128:
                return manageFocusForChild(i3, i4, bundle2);
            default:
                return onPerformActionForVirtualView(i3, i4, bundle2);
        }
    }

    private boolean performActionForHost(int i, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.mView, i, bundle);
    }

    private boolean requestAccessibilityFocus(int i) {
        int i2 = i;
        if (!this.mManager.isEnabled() || !AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager) || isAccessibilityFocused(i2)) {
            return false;
        }
        if (this.mFocusedVirtualViewId != Integer.MIN_VALUE) {
            boolean sendEventForVirtualView = sendEventForVirtualView(this.mFocusedVirtualViewId, 65536);
        }
        this.mFocusedVirtualViewId = i2;
        this.mView.invalidate();
        boolean sendEventForVirtualView2 = sendEventForVirtualView(i2, 32768);
        return true;
    }

    private void updateHoveredVirtualView(int i) {
        int i2 = i;
        if (this.mHoveredVirtualViewId != i2) {
            int i3 = this.mHoveredVirtualViewId;
            this.mHoveredVirtualViewId = i2;
            boolean sendEventForVirtualView = sendEventForVirtualView(i2, 128);
            boolean sendEventForVirtualView2 = sendEventForVirtualView(i3, 256);
        }
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        boolean z = true;
        if (this.mManager.isEnabled() && AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager)) {
            switch (motionEvent2.getAction()) {
                case 7:
                case 9:
                    int virtualViewAt = getVirtualViewAt(motionEvent2.getX(), motionEvent2.getY());
                    updateHoveredVirtualView(virtualViewAt);
                    if (virtualViewAt == Integer.MIN_VALUE) {
                        z = false;
                    }
                    return z;
                case 10:
                    if (this.mFocusedVirtualViewId != Integer.MIN_VALUE) {
                        updateHoveredVirtualView(Integer.MIN_VALUE);
                        return true;
                    }
                    break;
                default:
                    return false;
            }
        }
        return false;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        ExploreByTouchNodeProvider exploreByTouchNodeProvider;
        View view2 = view;
        if (this.mNodeProvider == null) {
            ExploreByTouchNodeProvider exploreByTouchNodeProvider2 = exploreByTouchNodeProvider;
            ExploreByTouchNodeProvider exploreByTouchNodeProvider3 = new ExploreByTouchNodeProvider(this, null);
            this.mNodeProvider = exploreByTouchNodeProvider2;
        }
        return this.mNodeProvider;
    }

    public int getFocusedVirtualView() {
        return this.mFocusedVirtualViewId;
    }

    /* access modifiers changed from: protected */
    public abstract int getVirtualViewAt(float f, float f2);

    /* access modifiers changed from: protected */
    public abstract void getVisibleVirtualViews(List<Integer> list);

    public void invalidateRoot() {
        invalidateVirtualView(-1);
    }

    public void invalidateVirtualView(int i) {
        boolean sendEventForVirtualView = sendEventForVirtualView(i, 2048);
    }

    /* access modifiers changed from: protected */
    public abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent);

    public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    /* access modifiers changed from: protected */
    public abstract void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public boolean sendEventForVirtualView(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (i3 != Integer.MIN_VALUE && this.mManager.isEnabled()) {
            ViewParent parent = this.mView.getParent();
            if (parent != null) {
                return ViewParentCompat.requestSendAccessibilityEvent(parent, this.mView, createEvent(i3, i4));
            }
        }
        return false;
    }
}
