package android.support.p000v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    /* access modifiers changed from: private */
    public static final AccessibilityNodeInfoImpl IMPL;
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private final Object mInfo;

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat */
    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION;
        public static final AccessibilityActionCompat ACTION_CLICK;
        public static final AccessibilityActionCompat ACTION_COLLAPSE;
        public static final AccessibilityActionCompat ACTION_COPY;
        public static final AccessibilityActionCompat ACTION_CUT;
        public static final AccessibilityActionCompat ACTION_DISMISS;
        public static final AccessibilityActionCompat ACTION_EXPAND;
        public static final AccessibilityActionCompat ACTION_FOCUS;
        public static final AccessibilityActionCompat ACTION_LONG_CLICK;
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
        public static final AccessibilityActionCompat ACTION_PASTE;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
        public static final AccessibilityActionCompat ACTION_SELECT;
        public static final AccessibilityActionCompat ACTION_SET_SELECTION;
        public static final AccessibilityActionCompat ACTION_SET_TEXT;
        /* access modifiers changed from: private */
        public final Object mAction;

        static {
            AccessibilityActionCompat accessibilityActionCompat;
            AccessibilityActionCompat accessibilityActionCompat2;
            AccessibilityActionCompat accessibilityActionCompat3;
            AccessibilityActionCompat accessibilityActionCompat4;
            AccessibilityActionCompat accessibilityActionCompat5;
            AccessibilityActionCompat accessibilityActionCompat6;
            AccessibilityActionCompat accessibilityActionCompat7;
            AccessibilityActionCompat accessibilityActionCompat8;
            AccessibilityActionCompat accessibilityActionCompat9;
            AccessibilityActionCompat accessibilityActionCompat10;
            AccessibilityActionCompat accessibilityActionCompat11;
            AccessibilityActionCompat accessibilityActionCompat12;
            AccessibilityActionCompat accessibilityActionCompat13;
            AccessibilityActionCompat accessibilityActionCompat14;
            AccessibilityActionCompat accessibilityActionCompat15;
            AccessibilityActionCompat accessibilityActionCompat16;
            AccessibilityActionCompat accessibilityActionCompat17;
            AccessibilityActionCompat accessibilityActionCompat18;
            AccessibilityActionCompat accessibilityActionCompat19;
            AccessibilityActionCompat accessibilityActionCompat20;
            AccessibilityActionCompat accessibilityActionCompat21;
            AccessibilityActionCompat accessibilityActionCompat22;
            AccessibilityActionCompat accessibilityActionCompat23 = accessibilityActionCompat;
            AccessibilityActionCompat accessibilityActionCompat24 = new AccessibilityActionCompat(1, (CharSequence) null);
            ACTION_FOCUS = accessibilityActionCompat23;
            AccessibilityActionCompat accessibilityActionCompat25 = accessibilityActionCompat2;
            AccessibilityActionCompat accessibilityActionCompat26 = new AccessibilityActionCompat(2, (CharSequence) null);
            ACTION_CLEAR_FOCUS = accessibilityActionCompat25;
            AccessibilityActionCompat accessibilityActionCompat27 = accessibilityActionCompat3;
            AccessibilityActionCompat accessibilityActionCompat28 = new AccessibilityActionCompat(4, (CharSequence) null);
            ACTION_SELECT = accessibilityActionCompat27;
            AccessibilityActionCompat accessibilityActionCompat29 = accessibilityActionCompat4;
            AccessibilityActionCompat accessibilityActionCompat30 = new AccessibilityActionCompat(8, (CharSequence) null);
            ACTION_CLEAR_SELECTION = accessibilityActionCompat29;
            AccessibilityActionCompat accessibilityActionCompat31 = accessibilityActionCompat5;
            AccessibilityActionCompat accessibilityActionCompat32 = new AccessibilityActionCompat(16, (CharSequence) null);
            ACTION_CLICK = accessibilityActionCompat31;
            AccessibilityActionCompat accessibilityActionCompat33 = accessibilityActionCompat6;
            AccessibilityActionCompat accessibilityActionCompat34 = new AccessibilityActionCompat(32, (CharSequence) null);
            ACTION_LONG_CLICK = accessibilityActionCompat33;
            AccessibilityActionCompat accessibilityActionCompat35 = accessibilityActionCompat7;
            AccessibilityActionCompat accessibilityActionCompat36 = new AccessibilityActionCompat(64, (CharSequence) null);
            ACTION_ACCESSIBILITY_FOCUS = accessibilityActionCompat35;
            AccessibilityActionCompat accessibilityActionCompat37 = accessibilityActionCompat8;
            AccessibilityActionCompat accessibilityActionCompat38 = new AccessibilityActionCompat(128, (CharSequence) null);
            ACTION_CLEAR_ACCESSIBILITY_FOCUS = accessibilityActionCompat37;
            AccessibilityActionCompat accessibilityActionCompat39 = accessibilityActionCompat9;
            AccessibilityActionCompat accessibilityActionCompat40 = new AccessibilityActionCompat(256, (CharSequence) null);
            ACTION_NEXT_AT_MOVEMENT_GRANULARITY = accessibilityActionCompat39;
            AccessibilityActionCompat accessibilityActionCompat41 = accessibilityActionCompat10;
            AccessibilityActionCompat accessibilityActionCompat42 = new AccessibilityActionCompat(512, (CharSequence) null);
            ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = accessibilityActionCompat41;
            AccessibilityActionCompat accessibilityActionCompat43 = accessibilityActionCompat11;
            AccessibilityActionCompat accessibilityActionCompat44 = new AccessibilityActionCompat(1024, (CharSequence) null);
            ACTION_NEXT_HTML_ELEMENT = accessibilityActionCompat43;
            AccessibilityActionCompat accessibilityActionCompat45 = accessibilityActionCompat12;
            AccessibilityActionCompat accessibilityActionCompat46 = new AccessibilityActionCompat(2048, (CharSequence) null);
            ACTION_PREVIOUS_HTML_ELEMENT = accessibilityActionCompat45;
            AccessibilityActionCompat accessibilityActionCompat47 = accessibilityActionCompat13;
            AccessibilityActionCompat accessibilityActionCompat48 = new AccessibilityActionCompat(4096, (CharSequence) null);
            ACTION_SCROLL_FORWARD = accessibilityActionCompat47;
            AccessibilityActionCompat accessibilityActionCompat49 = accessibilityActionCompat14;
            AccessibilityActionCompat accessibilityActionCompat50 = new AccessibilityActionCompat(8192, (CharSequence) null);
            ACTION_SCROLL_BACKWARD = accessibilityActionCompat49;
            AccessibilityActionCompat accessibilityActionCompat51 = accessibilityActionCompat15;
            AccessibilityActionCompat accessibilityActionCompat52 = new AccessibilityActionCompat(16384, (CharSequence) null);
            ACTION_COPY = accessibilityActionCompat51;
            AccessibilityActionCompat accessibilityActionCompat53 = accessibilityActionCompat16;
            AccessibilityActionCompat accessibilityActionCompat54 = new AccessibilityActionCompat(32768, (CharSequence) null);
            ACTION_PASTE = accessibilityActionCompat53;
            AccessibilityActionCompat accessibilityActionCompat55 = accessibilityActionCompat17;
            AccessibilityActionCompat accessibilityActionCompat56 = new AccessibilityActionCompat(65536, (CharSequence) null);
            ACTION_CUT = accessibilityActionCompat55;
            AccessibilityActionCompat accessibilityActionCompat57 = accessibilityActionCompat18;
            AccessibilityActionCompat accessibilityActionCompat58 = new AccessibilityActionCompat(131072, (CharSequence) null);
            ACTION_SET_SELECTION = accessibilityActionCompat57;
            AccessibilityActionCompat accessibilityActionCompat59 = accessibilityActionCompat19;
            AccessibilityActionCompat accessibilityActionCompat60 = new AccessibilityActionCompat(262144, (CharSequence) null);
            ACTION_EXPAND = accessibilityActionCompat59;
            AccessibilityActionCompat accessibilityActionCompat61 = accessibilityActionCompat20;
            AccessibilityActionCompat accessibilityActionCompat62 = new AccessibilityActionCompat(524288, (CharSequence) null);
            ACTION_COLLAPSE = accessibilityActionCompat61;
            AccessibilityActionCompat accessibilityActionCompat63 = accessibilityActionCompat21;
            AccessibilityActionCompat accessibilityActionCompat64 = new AccessibilityActionCompat(1048576, (CharSequence) null);
            ACTION_DISMISS = accessibilityActionCompat63;
            AccessibilityActionCompat accessibilityActionCompat65 = accessibilityActionCompat22;
            AccessibilityActionCompat accessibilityActionCompat66 = new AccessibilityActionCompat(2097152, (CharSequence) null);
            ACTION_SET_TEXT = accessibilityActionCompat65;
        }

        public AccessibilityActionCompat(int i, CharSequence charSequence) {
            this(AccessibilityNodeInfoCompat.IMPL.newAccessibilityAction(i, charSequence));
        }

        private AccessibilityActionCompat(Object obj) {
            this.mAction = obj;
        }

        /* synthetic */ AccessibilityActionCompat(Object obj, C01201 r7) {
            C01201 r2 = r7;
            this(obj);
        }

        public int getId() {
            return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionId(this.mAction);
        }

        public CharSequence getLabel() {
            return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionLabel(this.mAction);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi21Impl */
    static class AccessibilityNodeInfoApi21Impl extends AccessibilityNodeInfoKitKatImpl {
        AccessibilityNodeInfoApi21Impl() {
        }

        public void addAction(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatApi21.addAction(obj, obj2);
        }

        public int getAccessibilityActionId(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getAccessibilityActionId(obj);
        }

        public CharSequence getAccessibilityActionLabel(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getAccessibilityActionLabel(obj);
        }

        public List<Object> getActionList(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getActionList(obj);
        }

        public CharSequence getError(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getError(obj);
        }

        public int getMaxTextLength(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getMaxTextLength(obj);
        }

        public Object getWindow(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getWindow(obj);
        }

        public boolean isCollectionItemSelected(Object obj) {
            return CollectionItemInfo.isSelected(obj);
        }

        public Object newAccessibilityAction(int i, CharSequence charSequence) {
            return AccessibilityNodeInfoCompatApi21.newAccessibilityAction(i, charSequence);
        }

        public Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            return AccessibilityNodeInfoCompatApi21.obtainCollectionInfo(i, i2, z, i3);
        }

        public Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return AccessibilityNodeInfoCompatApi21.obtainCollectionItemInfo(i, i2, i3, i4, z, z2);
        }

        public boolean removeAction(Object obj, Object obj2) {
            return AccessibilityNodeInfoCompatApi21.removeAction(obj, obj2);
        }

        public boolean removeChild(Object obj, View view) {
            return AccessibilityNodeInfoCompatApi21.removeChild(obj, view);
        }

        public boolean removeChild(Object obj, View view, int i) {
            return AccessibilityNodeInfoCompatApi21.removeChild(obj, view, i);
        }

        public void setError(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatApi21.setError(obj, charSequence);
        }

        public void setMaxTextLength(Object obj, int i) {
            AccessibilityNodeInfoCompatApi21.setMaxTextLength(obj, i);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi22Impl */
    static class AccessibilityNodeInfoApi22Impl extends AccessibilityNodeInfoApi21Impl {
        AccessibilityNodeInfoApi22Impl() {
        }

        public Object getTraversalAfter(Object obj) {
            return AccessibilityNodeInfoCompatApi22.getTraversalAfter(obj);
        }

        public Object getTraversalBefore(Object obj) {
            return AccessibilityNodeInfoCompatApi22.getTraversalBefore(obj);
        }

        public void setTraversalAfter(Object obj, View view) {
            AccessibilityNodeInfoCompatApi22.setTraversalAfter(obj, view);
        }

        public void setTraversalAfter(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatApi22.setTraversalAfter(obj, view, i);
        }

        public void setTraversalBefore(Object obj, View view) {
            AccessibilityNodeInfoCompatApi22.setTraversalBefore(obj, view);
        }

        public void setTraversalBefore(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatApi22.setTraversalBefore(obj, view, i);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoIcsImpl */
    static class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoStubImpl {
        AccessibilityNodeInfoIcsImpl() {
        }

        public void addAction(Object obj, int i) {
            AccessibilityNodeInfoCompatIcs.addAction(obj, i);
        }

        public void addChild(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.addChild(obj, view);
        }

        public List<Object> findAccessibilityNodeInfosByText(Object obj, String str) {
            return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(obj, str);
        }

        public int getActions(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getActions(obj);
        }

        public void getBoundsInParent(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.getBoundsInParent(obj, rect);
        }

        public void getBoundsInScreen(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.getBoundsInScreen(obj, rect);
        }

        public Object getChild(Object obj, int i) {
            return AccessibilityNodeInfoCompatIcs.getChild(obj, i);
        }

        public int getChildCount(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getChildCount(obj);
        }

        public CharSequence getClassName(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getClassName(obj);
        }

        public CharSequence getContentDescription(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getContentDescription(obj);
        }

        public CharSequence getPackageName(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getPackageName(obj);
        }

        public Object getParent(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getParent(obj);
        }

        public CharSequence getText(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getText(obj);
        }

        public int getWindowId(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getWindowId(obj);
        }

        public boolean isCheckable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isCheckable(obj);
        }

        public boolean isChecked(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isChecked(obj);
        }

        public boolean isClickable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isClickable(obj);
        }

        public boolean isEnabled(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isEnabled(obj);
        }

        public boolean isFocusable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isFocusable(obj);
        }

        public boolean isFocused(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isFocused(obj);
        }

        public boolean isLongClickable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isLongClickable(obj);
        }

        public boolean isPassword(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isPassword(obj);
        }

        public boolean isScrollable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isScrollable(obj);
        }

        public boolean isSelected(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isSelected(obj);
        }

        public Object obtain() {
            return AccessibilityNodeInfoCompatIcs.obtain();
        }

        public Object obtain(View view) {
            return AccessibilityNodeInfoCompatIcs.obtain(view);
        }

        public Object obtain(Object obj) {
            return AccessibilityNodeInfoCompatIcs.obtain(obj);
        }

        public boolean performAction(Object obj, int i) {
            return AccessibilityNodeInfoCompatIcs.performAction(obj, i);
        }

        public void recycle(Object obj) {
            AccessibilityNodeInfoCompatIcs.recycle(obj);
        }

        public void setBoundsInParent(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.setBoundsInParent(obj, rect);
        }

        public void setBoundsInScreen(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.setBoundsInScreen(obj, rect);
        }

        public void setCheckable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setCheckable(obj, z);
        }

        public void setChecked(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setChecked(obj, z);
        }

        public void setClassName(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setClassName(obj, charSequence);
        }

        public void setClickable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setClickable(obj, z);
        }

        public void setContentDescription(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setContentDescription(obj, charSequence);
        }

        public void setEnabled(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setEnabled(obj, z);
        }

        public void setFocusable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setFocusable(obj, z);
        }

        public void setFocused(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setFocused(obj, z);
        }

        public void setLongClickable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setLongClickable(obj, z);
        }

        public void setPackageName(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setPackageName(obj, charSequence);
        }

        public void setParent(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.setParent(obj, view);
        }

        public void setPassword(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setPassword(obj, z);
        }

        public void setScrollable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setScrollable(obj, z);
        }

        public void setSelected(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setSelected(obj, z);
        }

        public void setSource(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.setSource(obj, view);
        }

        public void setText(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setText(obj, charSequence);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoImpl */
    interface AccessibilityNodeInfoImpl {
        void addAction(Object obj, int i);

        void addAction(Object obj, Object obj2);

        void addChild(Object obj, View view);

        void addChild(Object obj, View view, int i);

        boolean canOpenPopup(Object obj);

        List<Object> findAccessibilityNodeInfosByText(Object obj, String str);

        List<Object> findAccessibilityNodeInfosByViewId(Object obj, String str);

        Object findFocus(Object obj, int i);

        Object focusSearch(Object obj, int i);

        int getAccessibilityActionId(Object obj);

        CharSequence getAccessibilityActionLabel(Object obj);

        List<Object> getActionList(Object obj);

        int getActions(Object obj);

        void getBoundsInParent(Object obj, Rect rect);

        void getBoundsInScreen(Object obj, Rect rect);

        Object getChild(Object obj, int i);

        int getChildCount(Object obj);

        CharSequence getClassName(Object obj);

        Object getCollectionInfo(Object obj);

        int getCollectionInfoColumnCount(Object obj);

        int getCollectionInfoRowCount(Object obj);

        int getCollectionItemColumnIndex(Object obj);

        int getCollectionItemColumnSpan(Object obj);

        Object getCollectionItemInfo(Object obj);

        int getCollectionItemRowIndex(Object obj);

        int getCollectionItemRowSpan(Object obj);

        CharSequence getContentDescription(Object obj);

        CharSequence getError(Object obj);

        Bundle getExtras(Object obj);

        int getInputType(Object obj);

        Object getLabelFor(Object obj);

        Object getLabeledBy(Object obj);

        int getLiveRegion(Object obj);

        int getMaxTextLength(Object obj);

        int getMovementGranularities(Object obj);

        CharSequence getPackageName(Object obj);

        Object getParent(Object obj);

        Object getRangeInfo(Object obj);

        CharSequence getText(Object obj);

        int getTextSelectionEnd(Object obj);

        int getTextSelectionStart(Object obj);

        Object getTraversalAfter(Object obj);

        Object getTraversalBefore(Object obj);

        String getViewIdResourceName(Object obj);

        Object getWindow(Object obj);

        int getWindowId(Object obj);

        boolean isAccessibilityFocused(Object obj);

        boolean isCheckable(Object obj);

        boolean isChecked(Object obj);

        boolean isClickable(Object obj);

        boolean isCollectionInfoHierarchical(Object obj);

        boolean isCollectionItemHeading(Object obj);

        boolean isCollectionItemSelected(Object obj);

        boolean isContentInvalid(Object obj);

        boolean isDismissable(Object obj);

        boolean isEditable(Object obj);

        boolean isEnabled(Object obj);

        boolean isFocusable(Object obj);

        boolean isFocused(Object obj);

        boolean isLongClickable(Object obj);

        boolean isMultiLine(Object obj);

        boolean isPassword(Object obj);

        boolean isScrollable(Object obj);

        boolean isSelected(Object obj);

        boolean isVisibleToUser(Object obj);

        Object newAccessibilityAction(int i, CharSequence charSequence);

        Object obtain();

        Object obtain(View view);

        Object obtain(View view, int i);

        Object obtain(Object obj);

        Object obtainCollectionInfo(int i, int i2, boolean z, int i3);

        Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2);

        boolean performAction(Object obj, int i);

        boolean performAction(Object obj, int i, Bundle bundle);

        void recycle(Object obj);

        boolean refresh(Object obj);

        boolean removeAction(Object obj, Object obj2);

        boolean removeChild(Object obj, View view);

        boolean removeChild(Object obj, View view, int i);

        void setAccessibilityFocused(Object obj, boolean z);

        void setBoundsInParent(Object obj, Rect rect);

        void setBoundsInScreen(Object obj, Rect rect);

        void setCanOpenPopup(Object obj, boolean z);

        void setCheckable(Object obj, boolean z);

        void setChecked(Object obj, boolean z);

        void setClassName(Object obj, CharSequence charSequence);

        void setClickable(Object obj, boolean z);

        void setCollectionInfo(Object obj, Object obj2);

        void setCollectionItemInfo(Object obj, Object obj2);

        void setContentDescription(Object obj, CharSequence charSequence);

        void setContentInvalid(Object obj, boolean z);

        void setDismissable(Object obj, boolean z);

        void setEditable(Object obj, boolean z);

        void setEnabled(Object obj, boolean z);

        void setError(Object obj, CharSequence charSequence);

        void setFocusable(Object obj, boolean z);

        void setFocused(Object obj, boolean z);

        void setInputType(Object obj, int i);

        void setLabelFor(Object obj, View view);

        void setLabelFor(Object obj, View view, int i);

        void setLabeledBy(Object obj, View view);

        void setLabeledBy(Object obj, View view, int i);

        void setLiveRegion(Object obj, int i);

        void setLongClickable(Object obj, boolean z);

        void setMaxTextLength(Object obj, int i);

        void setMovementGranularities(Object obj, int i);

        void setMultiLine(Object obj, boolean z);

        void setPackageName(Object obj, CharSequence charSequence);

        void setParent(Object obj, View view);

        void setParent(Object obj, View view, int i);

        void setPassword(Object obj, boolean z);

        void setRangeInfo(Object obj, Object obj2);

        void setScrollable(Object obj, boolean z);

        void setSelected(Object obj, boolean z);

        void setSource(Object obj, View view);

        void setSource(Object obj, View view, int i);

        void setText(Object obj, CharSequence charSequence);

        void setTextSelection(Object obj, int i, int i2);

        void setTraversalAfter(Object obj, View view);

        void setTraversalAfter(Object obj, View view, int i);

        void setTraversalBefore(Object obj, View view);

        void setTraversalBefore(Object obj, View view, int i);

        void setViewIdResourceName(Object obj, String str);

        void setVisibleToUser(Object obj, boolean z);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanImpl */
    static class AccessibilityNodeInfoJellybeanImpl extends AccessibilityNodeInfoIcsImpl {
        AccessibilityNodeInfoJellybeanImpl() {
        }

        public void addChild(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellyBean.addChild(obj, view, i);
        }

        public Object findFocus(Object obj, int i) {
            return AccessibilityNodeInfoCompatJellyBean.findFocus(obj, i);
        }

        public Object focusSearch(Object obj, int i) {
            return AccessibilityNodeInfoCompatJellyBean.focusSearch(obj, i);
        }

        public int getMovementGranularities(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(obj);
        }

        public boolean isAccessibilityFocused(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(obj);
        }

        public boolean isVisibleToUser(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(obj);
        }

        public Object obtain(View view, int i) {
            return AccessibilityNodeInfoCompatJellyBean.obtain(view, i);
        }

        public boolean performAction(Object obj, int i, Bundle bundle) {
            return AccessibilityNodeInfoCompatJellyBean.performAction(obj, i, bundle);
        }

        public void setAccessibilityFocused(Object obj, boolean z) {
            AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(obj, z);
        }

        public void setMovementGranularities(Object obj, int i) {
            AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(obj, i);
        }

        public void setParent(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellyBean.setParent(obj, view, i);
        }

        public void setSource(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellyBean.setSource(obj, view, i);
        }

        public void setVisibleToUser(Object obj, boolean z) {
            AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(obj, z);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr1Impl */
    static class AccessibilityNodeInfoJellybeanMr1Impl extends AccessibilityNodeInfoJellybeanImpl {
        AccessibilityNodeInfoJellybeanMr1Impl() {
        }

        public Object getLabelFor(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr1.getLabelFor(obj);
        }

        public Object getLabeledBy(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr1.getLabeledBy(obj);
        }

        public void setLabelFor(Object obj, View view) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(obj, view);
        }

        public void setLabelFor(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(obj, view, i);
        }

        public void setLabeledBy(Object obj, View view) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(obj, view);
        }

        public void setLabeledBy(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(obj, view, i);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr2Impl */
    static class AccessibilityNodeInfoJellybeanMr2Impl extends AccessibilityNodeInfoJellybeanMr1Impl {
        AccessibilityNodeInfoJellybeanMr2Impl() {
        }

        public List<Object> findAccessibilityNodeInfosByViewId(Object obj, String str) {
            return AccessibilityNodeInfoCompatJellybeanMr2.findAccessibilityNodeInfosByViewId(obj, str);
        }

        public int getTextSelectionEnd(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionEnd(obj);
        }

        public int getTextSelectionStart(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionStart(obj);
        }

        public String getViewIdResourceName(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.getViewIdResourceName(obj);
        }

        public boolean isEditable(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.isEditable(obj);
        }

        public boolean refresh(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.refresh(obj);
        }

        public void setEditable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatJellybeanMr2.setEditable(obj, z);
        }

        public void setTextSelection(Object obj, int i, int i2) {
            AccessibilityNodeInfoCompatJellybeanMr2.setTextSelection(obj, i, i2);
        }

        public void setViewIdResourceName(Object obj, String str) {
            AccessibilityNodeInfoCompatJellybeanMr2.setViewIdResourceName(obj, str);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoKitKatImpl */
    static class AccessibilityNodeInfoKitKatImpl extends AccessibilityNodeInfoJellybeanMr2Impl {
        AccessibilityNodeInfoKitKatImpl() {
        }

        public boolean canOpenPopup(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.canOpenPopup(obj);
        }

        public Object getCollectionInfo(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getCollectionInfo(obj);
        }

        public int getCollectionInfoColumnCount(Object obj) {
            return CollectionInfo.getColumnCount(obj);
        }

        public int getCollectionInfoRowCount(Object obj) {
            return CollectionInfo.getRowCount(obj);
        }

        public int getCollectionItemColumnIndex(Object obj) {
            return CollectionItemInfo.getColumnIndex(obj);
        }

        public int getCollectionItemColumnSpan(Object obj) {
            return CollectionItemInfo.getColumnSpan(obj);
        }

        public Object getCollectionItemInfo(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getCollectionItemInfo(obj);
        }

        public int getCollectionItemRowIndex(Object obj) {
            return CollectionItemInfo.getRowIndex(obj);
        }

        public int getCollectionItemRowSpan(Object obj) {
            return CollectionItemInfo.getRowSpan(obj);
        }

        public Bundle getExtras(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getExtras(obj);
        }

        public int getInputType(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getInputType(obj);
        }

        public int getLiveRegion(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getLiveRegion(obj);
        }

        public Object getRangeInfo(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getRangeInfo(obj);
        }

        public boolean isCollectionInfoHierarchical(Object obj) {
            return CollectionInfo.isHierarchical(obj);
        }

        public boolean isCollectionItemHeading(Object obj) {
            return CollectionItemInfo.isHeading(obj);
        }

        public boolean isContentInvalid(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.isContentInvalid(obj);
        }

        public boolean isDismissable(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.isDismissable(obj);
        }

        public boolean isMultiLine(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.isMultiLine(obj);
        }

        public Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            return AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(i, i2, z, i3);
        }

        public Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            boolean z3 = z2;
            return AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(i, i2, i3, i4, z);
        }

        public void setCanOpenPopup(Object obj, boolean z) {
            AccessibilityNodeInfoCompatKitKat.setCanOpenPopup(obj, z);
        }

        public void setCollectionInfo(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatKitKat.setCollectionInfo(obj, obj2);
        }

        public void setCollectionItemInfo(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatKitKat.setCollectionItemInfo(obj, obj2);
        }

        public void setContentInvalid(Object obj, boolean z) {
            AccessibilityNodeInfoCompatKitKat.setContentInvalid(obj, z);
        }

        public void setDismissable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatKitKat.setDismissable(obj, z);
        }

        public void setInputType(Object obj, int i) {
            AccessibilityNodeInfoCompatKitKat.setInputType(obj, i);
        }

        public void setLiveRegion(Object obj, int i) {
            AccessibilityNodeInfoCompatKitKat.setLiveRegion(obj, i);
        }

        public void setMultiLine(Object obj, boolean z) {
            AccessibilityNodeInfoCompatKitKat.setMultiLine(obj, z);
        }

        public void setRangeInfo(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatKitKat.setRangeInfo(obj, obj2);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoStubImpl */
    static class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoImpl {
        AccessibilityNodeInfoStubImpl() {
        }

        public void addAction(Object obj, int i) {
        }

        public void addAction(Object obj, Object obj2) {
        }

        public void addChild(Object obj, View view) {
        }

        public void addChild(Object obj, View view, int i) {
        }

        public boolean canOpenPopup(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public List<Object> findAccessibilityNodeInfosByText(Object obj, String str) {
            Object obj2 = obj;
            String str2 = str;
            return Collections.emptyList();
        }

        public List<Object> findAccessibilityNodeInfosByViewId(Object obj, String str) {
            Object obj2 = obj;
            String str2 = str;
            return Collections.emptyList();
        }

        public Object findFocus(Object obj, int i) {
            Object obj2 = obj;
            int i2 = i;
            return null;
        }

        public Object focusSearch(Object obj, int i) {
            Object obj2 = obj;
            int i2 = i;
            return null;
        }

        public int getAccessibilityActionId(Object obj) {
            Object obj2 = obj;
            return 0;
        }

        public CharSequence getAccessibilityActionLabel(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public List<Object> getActionList(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public int getActions(Object obj) {
            Object obj2 = obj;
            return 0;
        }

        public void getBoundsInParent(Object obj, Rect rect) {
        }

        public void getBoundsInScreen(Object obj, Rect rect) {
        }

        public Object getChild(Object obj, int i) {
            Object obj2 = obj;
            int i2 = i;
            return null;
        }

        public int getChildCount(Object obj) {
            Object obj2 = obj;
            return 0;
        }

        public CharSequence getClassName(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public Object getCollectionInfo(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public int getCollectionInfoColumnCount(Object obj) {
            Object obj2 = obj;
            return 0;
        }

        public int getCollectionInfoRowCount(Object obj) {
            Object obj2 = obj;
            return 0;
        }

        public int getCollectionItemColumnIndex(Object obj) {
            Object obj2 = obj;
            return 0;
        }

        public int getCollectionItemColumnSpan(Object obj) {
            Object obj2 = obj;
            return 0;
        }

        public Object getCollectionItemInfo(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public int getCollectionItemRowIndex(Object obj) {
            Object obj2 = obj;
            return 0;
        }

        public int getCollectionItemRowSpan(Object obj) {
            Object obj2 = obj;
            return 0;
        }

        public CharSequence getContentDescription(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public CharSequence getError(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public Bundle getExtras(Object obj) {
            Bundle bundle;
            Object obj2 = obj;
            Bundle bundle2 = bundle;
            Bundle bundle3 = new Bundle();
            return bundle2;
        }

        public int getInputType(Object obj) {
            Object obj2 = obj;
            return 0;
        }

        public Object getLabelFor(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public Object getLabeledBy(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public int getLiveRegion(Object obj) {
            Object obj2 = obj;
            return 0;
        }

        public int getMaxTextLength(Object obj) {
            Object obj2 = obj;
            return -1;
        }

        public int getMovementGranularities(Object obj) {
            Object obj2 = obj;
            return 0;
        }

        public CharSequence getPackageName(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public Object getParent(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public Object getRangeInfo(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public CharSequence getText(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public int getTextSelectionEnd(Object obj) {
            Object obj2 = obj;
            return -1;
        }

        public int getTextSelectionStart(Object obj) {
            Object obj2 = obj;
            return -1;
        }

        public Object getTraversalAfter(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public Object getTraversalBefore(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public String getViewIdResourceName(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public Object getWindow(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public int getWindowId(Object obj) {
            Object obj2 = obj;
            return 0;
        }

        public boolean isAccessibilityFocused(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isCheckable(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isChecked(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isClickable(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isCollectionInfoHierarchical(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isCollectionItemHeading(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isCollectionItemSelected(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isContentInvalid(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isDismissable(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isEditable(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isEnabled(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isFocusable(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isFocused(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isLongClickable(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isMultiLine(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isPassword(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isScrollable(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isSelected(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean isVisibleToUser(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public Object newAccessibilityAction(int i, CharSequence charSequence) {
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            return null;
        }

        public Object obtain() {
            return null;
        }

        public Object obtain(View view) {
            View view2 = view;
            return null;
        }

        public Object obtain(View view, int i) {
            View view2 = view;
            int i2 = i;
            return null;
        }

        public Object obtain(Object obj) {
            Object obj2 = obj;
            return null;
        }

        public Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            int i4 = i;
            int i5 = i2;
            boolean z2 = z;
            int i6 = i3;
            return null;
        }

        public Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            int i8 = i4;
            boolean z3 = z;
            boolean z4 = z2;
            return null;
        }

        public boolean performAction(Object obj, int i) {
            Object obj2 = obj;
            int i2 = i;
            return false;
        }

        public boolean performAction(Object obj, int i, Bundle bundle) {
            Object obj2 = obj;
            int i2 = i;
            Bundle bundle2 = bundle;
            return false;
        }

        public void recycle(Object obj) {
        }

        public boolean refresh(Object obj) {
            Object obj2 = obj;
            return false;
        }

        public boolean removeAction(Object obj, Object obj2) {
            Object obj3 = obj;
            Object obj4 = obj2;
            return false;
        }

        public boolean removeChild(Object obj, View view) {
            Object obj2 = obj;
            View view2 = view;
            return false;
        }

        public boolean removeChild(Object obj, View view, int i) {
            Object obj2 = obj;
            View view2 = view;
            int i2 = i;
            return false;
        }

        public void setAccessibilityFocused(Object obj, boolean z) {
        }

        public void setBoundsInParent(Object obj, Rect rect) {
        }

        public void setBoundsInScreen(Object obj, Rect rect) {
        }

        public void setCanOpenPopup(Object obj, boolean z) {
        }

        public void setCheckable(Object obj, boolean z) {
        }

        public void setChecked(Object obj, boolean z) {
        }

        public void setClassName(Object obj, CharSequence charSequence) {
        }

        public void setClickable(Object obj, boolean z) {
        }

        public void setCollectionInfo(Object obj, Object obj2) {
        }

        public void setCollectionItemInfo(Object obj, Object obj2) {
        }

        public void setContentDescription(Object obj, CharSequence charSequence) {
        }

        public void setContentInvalid(Object obj, boolean z) {
        }

        public void setDismissable(Object obj, boolean z) {
        }

        public void setEditable(Object obj, boolean z) {
        }

        public void setEnabled(Object obj, boolean z) {
        }

        public void setError(Object obj, CharSequence charSequence) {
        }

        public void setFocusable(Object obj, boolean z) {
        }

        public void setFocused(Object obj, boolean z) {
        }

        public void setInputType(Object obj, int i) {
        }

        public void setLabelFor(Object obj, View view) {
        }

        public void setLabelFor(Object obj, View view, int i) {
        }

        public void setLabeledBy(Object obj, View view) {
        }

        public void setLabeledBy(Object obj, View view, int i) {
        }

        public void setLiveRegion(Object obj, int i) {
        }

        public void setLongClickable(Object obj, boolean z) {
        }

        public void setMaxTextLength(Object obj, int i) {
        }

        public void setMovementGranularities(Object obj, int i) {
        }

        public void setMultiLine(Object obj, boolean z) {
        }

        public void setPackageName(Object obj, CharSequence charSequence) {
        }

        public void setParent(Object obj, View view) {
        }

        public void setParent(Object obj, View view, int i) {
        }

        public void setPassword(Object obj, boolean z) {
        }

        public void setRangeInfo(Object obj, Object obj2) {
        }

        public void setScrollable(Object obj, boolean z) {
        }

        public void setSelected(Object obj, boolean z) {
        }

        public void setSource(Object obj, View view) {
        }

        public void setSource(Object obj, View view, int i) {
        }

        public void setText(Object obj, CharSequence charSequence) {
        }

        public void setTextSelection(Object obj, int i, int i2) {
        }

        public void setTraversalAfter(Object obj, View view) {
        }

        public void setTraversalAfter(Object obj, View view, int i) {
        }

        public void setTraversalBefore(Object obj, View view) {
        }

        public void setTraversalBefore(Object obj, View view, int i) {
        }

        public void setViewIdResourceName(Object obj, String str) {
        }

        public void setVisibleToUser(Object obj, boolean z) {
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat */
    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final Object mInfo;

        private CollectionInfoCompat(Object obj) {
            this.mInfo = obj;
        }

        /* synthetic */ CollectionInfoCompat(Object obj, C01201 r7) {
            C01201 r2 = r7;
            this(obj);
        }

        public static CollectionInfoCompat obtain(int i, int i2, boolean z, int i3) {
            CollectionInfoCompat collectionInfoCompat;
            CollectionInfoCompat collectionInfoCompat2 = collectionInfoCompat;
            CollectionInfoCompat collectionInfoCompat3 = new CollectionInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(i, i2, z, i3));
            return collectionInfoCompat2;
        }

        public int getColumnCount() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoColumnCount(this.mInfo);
        }

        public int getRowCount() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoRowCount(this.mInfo);
        }

        public boolean isHierarchical() {
            return AccessibilityNodeInfoCompat.IMPL.isCollectionInfoHierarchical(this.mInfo);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat */
    public static class CollectionItemInfoCompat {
        /* access modifiers changed from: private */
        public final Object mInfo;

        private CollectionItemInfoCompat(Object obj) {
            this.mInfo = obj;
        }

        /* synthetic */ CollectionItemInfoCompat(Object obj, C01201 r7) {
            C01201 r2 = r7;
            this(obj);
        }

        public static CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            CollectionItemInfoCompat collectionItemInfoCompat;
            CollectionItemInfoCompat collectionItemInfoCompat2 = collectionItemInfoCompat;
            CollectionItemInfoCompat collectionItemInfoCompat3 = new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(i, i2, i3, i4, z, z2));
            return collectionItemInfoCompat2;
        }

        public int getColumnIndex() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnIndex(this.mInfo);
        }

        public int getColumnSpan() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnSpan(this.mInfo);
        }

        public int getRowIndex() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowIndex(this.mInfo);
        }

        public int getRowSpan() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowSpan(this.mInfo);
        }

        public boolean isHeading() {
            return AccessibilityNodeInfoCompat.IMPL.isCollectionItemHeading(this.mInfo);
        }

        public boolean isSelected() {
            return AccessibilityNodeInfoCompat.IMPL.isCollectionItemSelected(this.mInfo);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$RangeInfoCompat */
    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        /* access modifiers changed from: private */
        public final Object mInfo;

        private RangeInfoCompat(Object obj) {
            this.mInfo = obj;
        }

        /* synthetic */ RangeInfoCompat(Object obj, C01201 r7) {
            C01201 r2 = r7;
            this(obj);
        }

        public float getCurrent() {
            return RangeInfo.getCurrent(this.mInfo);
        }

        public float getMax() {
            return RangeInfo.getMax(this.mInfo);
        }

        public float getMin() {
            return RangeInfo.getMin(this.mInfo);
        }

        public int getType() {
            return RangeInfo.getType(this.mInfo);
        }
    }

    static {
        AccessibilityNodeInfoStubImpl accessibilityNodeInfoStubImpl;
        AccessibilityNodeInfoIcsImpl accessibilityNodeInfoIcsImpl;
        AccessibilityNodeInfoJellybeanImpl accessibilityNodeInfoJellybeanImpl;
        AccessibilityNodeInfoJellybeanMr1Impl accessibilityNodeInfoJellybeanMr1Impl;
        AccessibilityNodeInfoJellybeanMr2Impl accessibilityNodeInfoJellybeanMr2Impl;
        AccessibilityNodeInfoKitKatImpl accessibilityNodeInfoKitKatImpl;
        AccessibilityNodeInfoApi21Impl accessibilityNodeInfoApi21Impl;
        AccessibilityNodeInfoApi22Impl accessibilityNodeInfoApi22Impl;
        if (VERSION.SDK_INT >= 22) {
            AccessibilityNodeInfoApi22Impl accessibilityNodeInfoApi22Impl2 = accessibilityNodeInfoApi22Impl;
            AccessibilityNodeInfoApi22Impl accessibilityNodeInfoApi22Impl3 = new AccessibilityNodeInfoApi22Impl();
            IMPL = accessibilityNodeInfoApi22Impl2;
        } else if (VERSION.SDK_INT >= 21) {
            AccessibilityNodeInfoApi21Impl accessibilityNodeInfoApi21Impl2 = accessibilityNodeInfoApi21Impl;
            AccessibilityNodeInfoApi21Impl accessibilityNodeInfoApi21Impl3 = new AccessibilityNodeInfoApi21Impl();
            IMPL = accessibilityNodeInfoApi21Impl2;
        } else if (VERSION.SDK_INT >= 19) {
            AccessibilityNodeInfoKitKatImpl accessibilityNodeInfoKitKatImpl2 = accessibilityNodeInfoKitKatImpl;
            AccessibilityNodeInfoKitKatImpl accessibilityNodeInfoKitKatImpl3 = new AccessibilityNodeInfoKitKatImpl();
            IMPL = accessibilityNodeInfoKitKatImpl2;
        } else if (VERSION.SDK_INT >= 18) {
            AccessibilityNodeInfoJellybeanMr2Impl accessibilityNodeInfoJellybeanMr2Impl2 = accessibilityNodeInfoJellybeanMr2Impl;
            AccessibilityNodeInfoJellybeanMr2Impl accessibilityNodeInfoJellybeanMr2Impl3 = new AccessibilityNodeInfoJellybeanMr2Impl();
            IMPL = accessibilityNodeInfoJellybeanMr2Impl2;
        } else if (VERSION.SDK_INT >= 17) {
            AccessibilityNodeInfoJellybeanMr1Impl accessibilityNodeInfoJellybeanMr1Impl2 = accessibilityNodeInfoJellybeanMr1Impl;
            AccessibilityNodeInfoJellybeanMr1Impl accessibilityNodeInfoJellybeanMr1Impl3 = new AccessibilityNodeInfoJellybeanMr1Impl();
            IMPL = accessibilityNodeInfoJellybeanMr1Impl2;
        } else if (VERSION.SDK_INT >= 16) {
            AccessibilityNodeInfoJellybeanImpl accessibilityNodeInfoJellybeanImpl2 = accessibilityNodeInfoJellybeanImpl;
            AccessibilityNodeInfoJellybeanImpl accessibilityNodeInfoJellybeanImpl3 = new AccessibilityNodeInfoJellybeanImpl();
            IMPL = accessibilityNodeInfoJellybeanImpl2;
        } else if (VERSION.SDK_INT >= 14) {
            AccessibilityNodeInfoIcsImpl accessibilityNodeInfoIcsImpl2 = accessibilityNodeInfoIcsImpl;
            AccessibilityNodeInfoIcsImpl accessibilityNodeInfoIcsImpl3 = new AccessibilityNodeInfoIcsImpl();
            IMPL = accessibilityNodeInfoIcsImpl2;
        } else {
            AccessibilityNodeInfoStubImpl accessibilityNodeInfoStubImpl2 = accessibilityNodeInfoStubImpl;
            AccessibilityNodeInfoStubImpl accessibilityNodeInfoStubImpl3 = new AccessibilityNodeInfoStubImpl();
            IMPL = accessibilityNodeInfoStubImpl2;
        }
    }

    public AccessibilityNodeInfoCompat(Object obj) {
        this.mInfo = obj;
    }

    private static String getActionSymbolicName(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return wrapNonNullInstance(IMPL.obtain());
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return wrapNonNullInstance(IMPL.obtain(accessibilityNodeInfoCompat.mInfo));
    }

    public static AccessibilityNodeInfoCompat obtain(View view) {
        return wrapNonNullInstance(IMPL.obtain(view));
    }

    public static AccessibilityNodeInfoCompat obtain(View view, int i) {
        return wrapNonNullInstance(IMPL.obtain(view, i));
    }

    static AccessibilityNodeInfoCompat wrapNonNullInstance(Object obj) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        Object obj2 = obj;
        if (obj2 == null) {
            return null;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = new AccessibilityNodeInfoCompat(obj2);
        return accessibilityNodeInfoCompat2;
    }

    public void addAction(int i) {
        int i2 = i;
        IMPL.addAction(this.mInfo, i2);
    }

    public void addAction(AccessibilityActionCompat accessibilityActionCompat) {
        IMPL.addAction(this.mInfo, accessibilityActionCompat.mAction);
    }

    public void addChild(View view) {
        View view2 = view;
        IMPL.addChild(this.mInfo, view2);
    }

    public void addChild(View view, int i) {
        View view2 = view;
        int i2 = i;
        IMPL.addChild(this.mInfo, view2, i2);
    }

    public boolean canOpenPopup() {
        return IMPL.canOpenPopup(this.mInfo);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this != obj2) {
            if (obj2 == null) {
                return false;
            }
            if (getClass() != obj2.getClass()) {
                return false;
            }
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj2;
            if (this.mInfo == null) {
                if (accessibilityNodeInfoCompat.mInfo != null) {
                    return false;
                }
            } else if (!this.mInfo.equals(accessibilityNodeInfoCompat.mInfo)) {
                return false;
            }
        }
        return true;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str) {
        ArrayList arrayList;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        String str2 = str;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        List findAccessibilityNodeInfosByText = IMPL.findAccessibilityNodeInfosByText(this.mInfo, str2);
        int size = findAccessibilityNodeInfosByText.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList5 = arrayList4;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = new AccessibilityNodeInfoCompat(findAccessibilityNodeInfosByText.get(i));
            boolean add = arrayList5.add(accessibilityNodeInfoCompat2);
        }
        return arrayList4;
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.List<android.support.v4.view.accessibility.AccessibilityNodeInfoCompat>] */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r5v11, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(java.lang.String r11) {
        /*
            r10 = this;
            r0 = r10
            r1 = r11
            android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoImpl r5 = IMPL
            r6 = r0
            java.lang.Object r6 = r6.mInfo
            r7 = r1
            java.util.List r5 = r5.findAccessibilityNodeInfosByViewId(r6, r7)
            r2 = r5
            r5 = r2
            if (r5 == 0) goto L_0x0039
            java.util.ArrayList r5 = new java.util.ArrayList
            r9 = r5
            r5 = r9
            r6 = r9
            r6.<init>()
            r3 = r5
            r5 = r2
            java.util.Iterator r5 = r5.iterator()
            r4 = r5
        L_0x001f:
            r5 = r4
            boolean r5 = r5.hasNext()
            if (r5 == 0) goto L_0x003e
            r5 = r3
            android.support.v4.view.accessibility.AccessibilityNodeInfoCompat r6 = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat
            r9 = r6
            r6 = r9
            r7 = r9
            r8 = r4
            java.lang.Object r8 = r8.next()
            r7.<init>(r8)
            boolean r5 = r5.add(r6)
            goto L_0x001f
        L_0x0039:
            java.util.List r5 = java.util.Collections.emptyList()
            r3 = r5
        L_0x003e:
            r5 = r3
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat.findAccessibilityNodeInfosByViewId(java.lang.String):java.util.List");
    }

    public AccessibilityNodeInfoCompat findFocus(int i) {
        return wrapNonNullInstance(IMPL.findFocus(this.mInfo, i));
    }

    public AccessibilityNodeInfoCompat focusSearch(int i) {
        return wrapNonNullInstance(IMPL.focusSearch(this.mInfo, i));
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.List<android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat>] */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r5v11, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList() {
        /*
            r11 = this;
            r0 = r11
            android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoImpl r5 = IMPL
            r6 = r0
            java.lang.Object r6 = r6.mInfo
            java.util.List r5 = r5.getActionList(r6)
            r1 = r5
            r5 = r1
            if (r5 == 0) goto L_0x003a
            java.util.ArrayList r5 = new java.util.ArrayList
            r10 = r5
            r5 = r10
            r6 = r10
            r6.<init>()
            r2 = r5
            r5 = r1
            int r5 = r5.size()
            r3 = r5
            r5 = 0
            r4 = r5
        L_0x001f:
            r5 = r4
            r6 = r3
            if (r5 >= r6) goto L_0x003f
            r5 = r2
            android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat r6 = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat
            r10 = r6
            r6 = r10
            r7 = r10
            r8 = r1
            r9 = r4
            java.lang.Object r8 = r8.get(r9)
            r9 = 0
            r7.<init>(r8, r9)
            boolean r5 = r5.add(r6)
            int r4 = r4 + 1
            goto L_0x001f
        L_0x003a:
            java.util.List r5 = java.util.Collections.emptyList()
            r2 = r5
        L_0x003f:
            r5 = r2
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat.getActionList():java.util.List");
    }

    public int getActions() {
        return IMPL.getActions(this.mInfo);
    }

    public void getBoundsInParent(Rect rect) {
        Rect rect2 = rect;
        IMPL.getBoundsInParent(this.mInfo, rect2);
    }

    public void getBoundsInScreen(Rect rect) {
        Rect rect2 = rect;
        IMPL.getBoundsInScreen(this.mInfo, rect2);
    }

    public AccessibilityNodeInfoCompat getChild(int i) {
        return wrapNonNullInstance(IMPL.getChild(this.mInfo, i));
    }

    public int getChildCount() {
        return IMPL.getChildCount(this.mInfo);
    }

    public CharSequence getClassName() {
        return IMPL.getClassName(this.mInfo);
    }

    public CollectionInfoCompat getCollectionInfo() {
        CollectionInfoCompat collectionInfoCompat;
        Object collectionInfo = IMPL.getCollectionInfo(this.mInfo);
        if (collectionInfo == null) {
            return null;
        }
        CollectionInfoCompat collectionInfoCompat2 = collectionInfoCompat;
        CollectionInfoCompat collectionInfoCompat3 = new CollectionInfoCompat(collectionInfo, null);
        return collectionInfoCompat2;
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        CollectionItemInfoCompat collectionItemInfoCompat;
        Object collectionItemInfo = IMPL.getCollectionItemInfo(this.mInfo);
        if (collectionItemInfo == null) {
            return null;
        }
        CollectionItemInfoCompat collectionItemInfoCompat2 = collectionItemInfoCompat;
        CollectionItemInfoCompat collectionItemInfoCompat3 = new CollectionItemInfoCompat(collectionItemInfo, null);
        return collectionItemInfoCompat2;
    }

    public CharSequence getContentDescription() {
        return IMPL.getContentDescription(this.mInfo);
    }

    public CharSequence getError() {
        return IMPL.getError(this.mInfo);
    }

    public Bundle getExtras() {
        return IMPL.getExtras(this.mInfo);
    }

    public Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        return IMPL.getInputType(this.mInfo);
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        return wrapNonNullInstance(IMPL.getLabelFor(this.mInfo));
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        return wrapNonNullInstance(IMPL.getLabeledBy(this.mInfo));
    }

    public int getLiveRegion() {
        return IMPL.getLiveRegion(this.mInfo);
    }

    public int getMaxTextLength() {
        return IMPL.getMaxTextLength(this.mInfo);
    }

    public int getMovementGranularities() {
        return IMPL.getMovementGranularities(this.mInfo);
    }

    public CharSequence getPackageName() {
        return IMPL.getPackageName(this.mInfo);
    }

    public AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(IMPL.getParent(this.mInfo));
    }

    public RangeInfoCompat getRangeInfo() {
        RangeInfoCompat rangeInfoCompat;
        Object rangeInfo = IMPL.getRangeInfo(this.mInfo);
        if (rangeInfo == null) {
            return null;
        }
        RangeInfoCompat rangeInfoCompat2 = rangeInfoCompat;
        RangeInfoCompat rangeInfoCompat3 = new RangeInfoCompat(rangeInfo, null);
        return rangeInfoCompat2;
    }

    public CharSequence getText() {
        return IMPL.getText(this.mInfo);
    }

    public int getTextSelectionEnd() {
        return IMPL.getTextSelectionEnd(this.mInfo);
    }

    public int getTextSelectionStart() {
        return IMPL.getTextSelectionStart(this.mInfo);
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return wrapNonNullInstance(IMPL.getTraversalAfter(this.mInfo));
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return wrapNonNullInstance(IMPL.getTraversalBefore(this.mInfo));
    }

    public String getViewIdResourceName() {
        return IMPL.getViewIdResourceName(this.mInfo);
    }

    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(IMPL.getWindow(this.mInfo));
    }

    public int getWindowId() {
        return IMPL.getWindowId(this.mInfo);
    }

    public int hashCode() {
        if (this.mInfo == null) {
            return 0;
        }
        return this.mInfo.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return IMPL.isAccessibilityFocused(this.mInfo);
    }

    public boolean isCheckable() {
        return IMPL.isCheckable(this.mInfo);
    }

    public boolean isChecked() {
        return IMPL.isChecked(this.mInfo);
    }

    public boolean isClickable() {
        return IMPL.isClickable(this.mInfo);
    }

    public boolean isContentInvalid() {
        return IMPL.isContentInvalid(this.mInfo);
    }

    public boolean isDismissable() {
        return IMPL.isDismissable(this.mInfo);
    }

    public boolean isEditable() {
        return IMPL.isEditable(this.mInfo);
    }

    public boolean isEnabled() {
        return IMPL.isEnabled(this.mInfo);
    }

    public boolean isFocusable() {
        return IMPL.isFocusable(this.mInfo);
    }

    public boolean isFocused() {
        return IMPL.isFocused(this.mInfo);
    }

    public boolean isLongClickable() {
        return IMPL.isLongClickable(this.mInfo);
    }

    public boolean isMultiLine() {
        return IMPL.isMultiLine(this.mInfo);
    }

    public boolean isPassword() {
        return IMPL.isPassword(this.mInfo);
    }

    public boolean isScrollable() {
        return IMPL.isScrollable(this.mInfo);
    }

    public boolean isSelected() {
        return IMPL.isSelected(this.mInfo);
    }

    public boolean isVisibleToUser() {
        return IMPL.isVisibleToUser(this.mInfo);
    }

    public boolean performAction(int i) {
        return IMPL.performAction(this.mInfo, i);
    }

    public boolean performAction(int i, Bundle bundle) {
        return IMPL.performAction(this.mInfo, i, bundle);
    }

    public void recycle() {
        IMPL.recycle(this.mInfo);
    }

    public boolean refresh() {
        return IMPL.refresh(this.mInfo);
    }

    public boolean removeAction(AccessibilityActionCompat accessibilityActionCompat) {
        return IMPL.removeAction(this.mInfo, accessibilityActionCompat.mAction);
    }

    public boolean removeChild(View view) {
        return IMPL.removeChild(this.mInfo, view);
    }

    public boolean removeChild(View view, int i) {
        return IMPL.removeChild(this.mInfo, view, i);
    }

    public void setAccessibilityFocused(boolean z) {
        boolean z2 = z;
        IMPL.setAccessibilityFocused(this.mInfo, z2);
    }

    public void setBoundsInParent(Rect rect) {
        Rect rect2 = rect;
        IMPL.setBoundsInParent(this.mInfo, rect2);
    }

    public void setBoundsInScreen(Rect rect) {
        Rect rect2 = rect;
        IMPL.setBoundsInScreen(this.mInfo, rect2);
    }

    public void setCanOpenPopup(boolean z) {
        boolean z2 = z;
        IMPL.setCanOpenPopup(this.mInfo, z2);
    }

    public void setCheckable(boolean z) {
        boolean z2 = z;
        IMPL.setCheckable(this.mInfo, z2);
    }

    public void setChecked(boolean z) {
        boolean z2 = z;
        IMPL.setChecked(this.mInfo, z2);
    }

    public void setClassName(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        IMPL.setClassName(this.mInfo, charSequence2);
    }

    public void setClickable(boolean z) {
        boolean z2 = z;
        IMPL.setClickable(this.mInfo, z2);
    }

    public void setCollectionInfo(Object obj) {
        IMPL.setCollectionInfo(this.mInfo, ((CollectionInfoCompat) obj).mInfo);
    }

    public void setCollectionItemInfo(Object obj) {
        IMPL.setCollectionItemInfo(this.mInfo, ((CollectionItemInfoCompat) obj).mInfo);
    }

    public void setContentDescription(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        IMPL.setContentDescription(this.mInfo, charSequence2);
    }

    public void setContentInvalid(boolean z) {
        boolean z2 = z;
        IMPL.setContentInvalid(this.mInfo, z2);
    }

    public void setDismissable(boolean z) {
        boolean z2 = z;
        IMPL.setDismissable(this.mInfo, z2);
    }

    public void setEditable(boolean z) {
        boolean z2 = z;
        IMPL.setEditable(this.mInfo, z2);
    }

    public void setEnabled(boolean z) {
        boolean z2 = z;
        IMPL.setEnabled(this.mInfo, z2);
    }

    public void setError(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        IMPL.setError(this.mInfo, charSequence2);
    }

    public void setFocusable(boolean z) {
        boolean z2 = z;
        IMPL.setFocusable(this.mInfo, z2);
    }

    public void setFocused(boolean z) {
        boolean z2 = z;
        IMPL.setFocused(this.mInfo, z2);
    }

    public void setInputType(int i) {
        int i2 = i;
        IMPL.setInputType(this.mInfo, i2);
    }

    public void setLabelFor(View view) {
        View view2 = view;
        IMPL.setLabelFor(this.mInfo, view2);
    }

    public void setLabelFor(View view, int i) {
        View view2 = view;
        int i2 = i;
        IMPL.setLabelFor(this.mInfo, view2, i2);
    }

    public void setLabeledBy(View view) {
        View view2 = view;
        IMPL.setLabeledBy(this.mInfo, view2);
    }

    public void setLabeledBy(View view, int i) {
        View view2 = view;
        int i2 = i;
        IMPL.setLabeledBy(this.mInfo, view2, i2);
    }

    public void setLiveRegion(int i) {
        int i2 = i;
        IMPL.setLiveRegion(this.mInfo, i2);
    }

    public void setLongClickable(boolean z) {
        boolean z2 = z;
        IMPL.setLongClickable(this.mInfo, z2);
    }

    public void setMaxTextLength(int i) {
        int i2 = i;
        IMPL.setMaxTextLength(this.mInfo, i2);
    }

    public void setMovementGranularities(int i) {
        int i2 = i;
        IMPL.setMovementGranularities(this.mInfo, i2);
    }

    public void setMultiLine(boolean z) {
        boolean z2 = z;
        IMPL.setMultiLine(this.mInfo, z2);
    }

    public void setPackageName(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        IMPL.setPackageName(this.mInfo, charSequence2);
    }

    public void setParent(View view) {
        View view2 = view;
        IMPL.setParent(this.mInfo, view2);
    }

    public void setParent(View view, int i) {
        View view2 = view;
        int i2 = i;
        IMPL.setParent(this.mInfo, view2, i2);
    }

    public void setPassword(boolean z) {
        boolean z2 = z;
        IMPL.setPassword(this.mInfo, z2);
    }

    public void setRangeInfo(RangeInfoCompat rangeInfoCompat) {
        IMPL.setRangeInfo(this.mInfo, rangeInfoCompat.mInfo);
    }

    public void setScrollable(boolean z) {
        boolean z2 = z;
        IMPL.setScrollable(this.mInfo, z2);
    }

    public void setSelected(boolean z) {
        boolean z2 = z;
        IMPL.setSelected(this.mInfo, z2);
    }

    public void setSource(View view) {
        View view2 = view;
        IMPL.setSource(this.mInfo, view2);
    }

    public void setSource(View view, int i) {
        View view2 = view;
        int i2 = i;
        IMPL.setSource(this.mInfo, view2, i2);
    }

    public void setText(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        IMPL.setText(this.mInfo, charSequence2);
    }

    public void setTextSelection(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        IMPL.setTextSelection(this.mInfo, i3, i4);
    }

    public void setTraversalAfter(View view) {
        View view2 = view;
        IMPL.setTraversalAfter(this.mInfo, view2);
    }

    public void setTraversalAfter(View view, int i) {
        View view2 = view;
        int i2 = i;
        IMPL.setTraversalAfter(this.mInfo, view2, i2);
    }

    public void setTraversalBefore(View view) {
        View view2 = view;
        IMPL.setTraversalBefore(this.mInfo, view2);
    }

    public void setTraversalBefore(View view, int i) {
        View view2 = view;
        int i2 = i;
        IMPL.setTraversalBefore(this.mInfo, view2, i2);
    }

    public void setViewIdResourceName(String str) {
        String str2 = str;
        IMPL.setViewIdResourceName(this.mInfo, str2);
    }

    public void setVisibleToUser(boolean z) {
        boolean z2 = z;
        IMPL.setVisibleToUser(this.mInfo, z2);
    }

    public String toString() {
        StringBuilder sb;
        Rect rect;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = sb5;
        StringBuilder append = sb7.append(super.toString());
        Rect rect2 = rect;
        Rect rect3 = new Rect();
        Rect rect4 = rect2;
        getBoundsInParent(rect4);
        StringBuilder sb8 = sb7;
        StringBuilder sb9 = sb2;
        StringBuilder sb10 = new StringBuilder();
        StringBuilder append2 = sb8.append(sb9.append("; boundsInParent: ").append(rect4).toString());
        getBoundsInScreen(rect4);
        StringBuilder sb11 = sb7;
        StringBuilder sb12 = sb3;
        StringBuilder sb13 = new StringBuilder();
        StringBuilder append3 = sb11.append(sb12.append("; boundsInScreen: ").append(rect4).toString());
        StringBuilder append4 = sb7.append("; packageName: ").append(getPackageName());
        StringBuilder append5 = sb7.append("; className: ").append(getClassName());
        StringBuilder append6 = sb7.append("; text: ").append(getText());
        StringBuilder append7 = sb7.append("; contentDescription: ").append(getContentDescription());
        StringBuilder append8 = sb7.append("; viewId: ").append(getViewIdResourceName());
        StringBuilder append9 = sb7.append("; checkable: ").append(isCheckable());
        StringBuilder append10 = sb7.append("; checked: ").append(isChecked());
        StringBuilder append11 = sb7.append("; focusable: ").append(isFocusable());
        StringBuilder append12 = sb7.append("; focused: ").append(isFocused());
        StringBuilder append13 = sb7.append("; selected: ").append(isSelected());
        StringBuilder append14 = sb7.append("; clickable: ").append(isClickable());
        StringBuilder append15 = sb7.append("; longClickable: ").append(isLongClickable());
        StringBuilder append16 = sb7.append("; enabled: ").append(isEnabled());
        StringBuilder append17 = sb7.append("; password: ").append(isPassword());
        StringBuilder sb14 = sb7;
        StringBuilder sb15 = sb4;
        StringBuilder sb16 = new StringBuilder();
        StringBuilder append18 = sb14.append(sb15.append("; scrollable: ").append(isScrollable()).toString());
        StringBuilder append19 = sb7.append("; [");
        int actions = getActions();
        while (actions != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
            actions &= numberOfTrailingZeros ^ -1;
            StringBuilder append20 = sb7.append(getActionSymbolicName(numberOfTrailingZeros));
            if (actions != 0) {
                StringBuilder append21 = sb7.append(", ");
            }
        }
        StringBuilder append22 = sb7.append("]");
        return sb7.toString();
    }
}
