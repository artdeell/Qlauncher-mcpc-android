package android.support.p000v4.widget;

import android.view.View;
import android.widget.ListView;

/* renamed from: android.support.v4.widget.ListViewAutoScrollHelper */
public class ListViewAutoScrollHelper extends AutoScrollHelper {
    private final ListView mTarget;

    public ListViewAutoScrollHelper(ListView listView) {
        ListView listView2 = listView;
        super(listView2);
        this.mTarget = listView2;
    }

    public boolean canTargetScrollHorizontally(int i) {
        int i2 = i;
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003b, code lost:
        if (r2.getChildAt(r4 - 1).getBottom() <= r2.getHeight()) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canTargetScrollVertically(int r11) {
        /*
            r10 = this;
            r0 = r10
            r1 = r11
            r7 = r0
            android.widget.ListView r7 = r7.mTarget
            r2 = r7
            r7 = r2
            int r7 = r7.getCount()
            r3 = r7
            r7 = r3
            if (r7 != 0) goto L_0x0012
        L_0x000f:
            r7 = 0
            r0 = r7
        L_0x0011:
            return r0
        L_0x0012:
            r7 = r2
            int r7 = r7.getChildCount()
            r4 = r7
            r7 = r2
            int r7 = r7.getFirstVisiblePosition()
            r5 = r7
            r7 = r5
            r8 = r4
            int r7 = r7 + r8
            r6 = r7
            r7 = r1
            if (r7 <= 0) goto L_0x0040
            r7 = r6
            r8 = r3
            if (r7 < r8) goto L_0x003d
            r7 = r2
            r8 = r4
            r9 = 1
            int r8 = r8 + -1
            android.view.View r7 = r7.getChildAt(r8)
            int r7 = r7.getBottom()
            r8 = r2
            int r8 = r8.getHeight()
            if (r7 <= r8) goto L_0x000f
        L_0x003d:
            r7 = 1
            r0 = r7
            goto L_0x0011
        L_0x0040:
            r7 = r1
            if (r7 >= 0) goto L_0x000f
            r7 = r5
            if (r7 > 0) goto L_0x003d
            r7 = r2
            r8 = 0
            android.view.View r7 = r7.getChildAt(r8)
            int r7 = r7.getTop()
            if (r7 < 0) goto L_0x003d
            r7 = 0
            r0 = r7
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.ListViewAutoScrollHelper.canTargetScrollVertically(int):boolean");
    }

    public void scrollTargetBy(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ListView listView = this.mTarget;
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1) {
            View childAt = listView.getChildAt(0);
            if (childAt != null) {
                listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i4);
            }
        }
    }
}
