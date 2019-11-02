package android.support.p000v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

/* renamed from: android.support.v4.widget.SimpleCursorAdapter */
public class SimpleCursorAdapter extends ResourceCursorAdapter {
    private CursorToStringConverter mCursorToStringConverter;
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn = -1;
    protected int[] mTo;
    private ViewBinder mViewBinder;

    /* renamed from: android.support.v4.widget.SimpleCursorAdapter$CursorToStringConverter */
    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor cursor);
    }

    /* renamed from: android.support.v4.widget.SimpleCursorAdapter$ViewBinder */
    public interface ViewBinder {
        boolean setViewValue(View view, Cursor cursor, int i);
    }

    @Deprecated
    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr) {
        String[] strArr2 = strArr;
        int[] iArr2 = iArr;
        super(context, i, cursor);
        this.mTo = iArr2;
        this.mOriginalFrom = strArr2;
        findColumns(strArr2);
    }

    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr, int i2) {
        String[] strArr2 = strArr;
        int[] iArr2 = iArr;
        super(context, i, cursor, i2);
        this.mTo = iArr2;
        this.mOriginalFrom = strArr2;
        findColumns(strArr2);
    }

    private void findColumns(String[] strArr) {
        String[] strArr2 = strArr;
        if (this.mCursor != null) {
            int length = strArr2.length;
            if (this.mFrom == null || this.mFrom.length != length) {
                this.mFrom = new int[length];
            }
            for (int i = 0; i < length; i++) {
                this.mFrom[i] = this.mCursor.getColumnIndexOrThrow(strArr2[i]);
            }
            return;
        }
        this.mFrom = null;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        View view2 = view;
        Context context2 = context;
        Cursor cursor2 = cursor;
        ViewBinder viewBinder = this.mViewBinder;
        int length = this.mTo.length;
        int[] iArr = this.mFrom;
        int[] iArr2 = this.mTo;
        for (int i = 0; i < length; i++) {
            View findViewById = view2.findViewById(iArr2[i]);
            if (findViewById != null) {
                boolean z = false;
                if (viewBinder != null) {
                    z = viewBinder.setViewValue(findViewById, cursor2, iArr[i]);
                }
                if (!z) {
                    String string = cursor2.getString(iArr[i]);
                    if (string == null) {
                        string = LibrariesRepository.MOJANG_MAVEN_REPO;
                    }
                    if (findViewById instanceof TextView) {
                        setViewText((TextView) findViewById, string);
                    } else if (findViewById instanceof ImageView) {
                        setViewImage((ImageView) findViewById, string);
                    } else {
                        IllegalStateException illegalStateException2 = illegalStateException;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append(findViewById.getClass().getName()).append(" is not a ").append(" view that can be bounds by this SimpleCursorAdapter").toString());
                        throw illegalStateException2;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public void changeCursorAndColumns(Cursor cursor, String[] strArr, int[] iArr) {
        Cursor cursor2 = cursor;
        int[] iArr2 = iArr;
        this.mOriginalFrom = strArr;
        this.mTo = iArr2;
        super.changeCursor(cursor2);
        findColumns(this.mOriginalFrom);
    }

    public CharSequence convertToString(Cursor cursor) {
        Cursor cursor2 = cursor;
        return this.mCursorToStringConverter != null ? this.mCursorToStringConverter.convertToString(cursor2) : this.mStringConversionColumn > -1 ? cursor2.getString(this.mStringConversionColumn) : super.convertToString(cursor2);
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        CursorToStringConverter cursorToStringConverter2 = cursorToStringConverter;
        this.mCursorToStringConverter = cursorToStringConverter2;
    }

    public void setStringConversionColumn(int i) {
        int i2 = i;
        this.mStringConversionColumn = i2;
    }

    public void setViewBinder(ViewBinder viewBinder) {
        ViewBinder viewBinder2 = viewBinder;
        this.mViewBinder = viewBinder2;
    }

    public void setViewImage(ImageView imageView, String str) {
        ImageView imageView2 = imageView;
        String str2 = str;
        try {
            imageView2.setImageResource(Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = e;
            imageView2.setImageURI(Uri.parse(str2));
        }
    }

    public void setViewText(TextView textView, String str) {
        textView.setText(str);
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor swapCursor = super.swapCursor(cursor);
        findColumns(this.mOriginalFrom);
        return swapCursor;
    }
}
