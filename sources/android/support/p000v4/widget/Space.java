package android.support.p000v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

/* renamed from: android.support.v4.widget.Space */
public class Space extends View {
    public Space(Context context) {
        this(context, null);
    }

    public Space(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Space(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    private static int getDefaultSize2(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int mode = MeasureSpec.getMode(i4);
        int size = MeasureSpec.getSize(i4);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i3, size);
            case 0:
                return i3;
            case IDirectInputDevice.DIEP_NORESTART /*1073741824*/:
                return size;
            default:
                return i3;
        }
    }

    public void draw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), i), getDefaultSize2(getSuggestedMinimumHeight(), i2));
    }
}
