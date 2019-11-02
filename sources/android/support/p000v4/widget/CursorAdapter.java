package android.support.p000v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

/* renamed from: android.support.v4.widget.CursorAdapter */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilterClient {
    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    protected boolean mAutoRequery;
    protected ChangeObserver mChangeObserver;
    protected Context mContext;
    protected Cursor mCursor;
    protected CursorFilter mCursorFilter;
    protected DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected FilterQueryProvider mFilterQueryProvider;
    protected int mRowIDColumn;

    /* renamed from: android.support.v4.widget.CursorAdapter$ChangeObserver */
    private class ChangeObserver extends ContentObserver {
        final /* synthetic */ CursorAdapter this$0;

        public ChangeObserver(CursorAdapter cursorAdapter) {
            Handler handler;
            this.this$0 = cursorAdapter;
            Handler handler2 = handler;
            Handler handler3 = new Handler();
            super(handler2);
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            boolean z2 = z;
            this.this$0.onContentChanged();
        }
    }

    /* renamed from: android.support.v4.widget.CursorAdapter$MyDataSetObserver */
    private class MyDataSetObserver extends DataSetObserver {
        final /* synthetic */ CursorAdapter this$0;

        private MyDataSetObserver(CursorAdapter cursorAdapter) {
            this.this$0 = cursorAdapter;
        }

        /* synthetic */ MyDataSetObserver(CursorAdapter cursorAdapter, C01291 r7) {
            C01291 r2 = r7;
            this(cursorAdapter);
        }

        public void onChanged() {
            this.this$0.mDataValid = true;
            this.this$0.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.this$0.mDataValid = false;
            this.this$0.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public CursorAdapter(Context context, Cursor cursor) {
        init(context, cursor, 1);
    }

    public CursorAdapter(Context context, Cursor cursor, int i) {
        init(context, cursor, i);
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        init(context, cursor, z ? 1 : 2);
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    public void changeCursor(Cursor cursor) {
        Cursor swapCursor = swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        Cursor cursor2 = cursor;
        return cursor2 == null ? LibrariesRepository.MOJANG_MAVEN_REPO : cursor2.toString();
    }

    public int getCount() {
        if (!this.mDataValid || this.mCursor == null) {
            return 0;
        }
        return this.mCursor.getCount();
    }

    public Cursor getCursor() {
        return this.mCursor;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        int i2 = i;
        View view2 = view;
        ViewGroup viewGroup2 = viewGroup;
        if (!this.mDataValid) {
            return null;
        }
        boolean moveToPosition = this.mCursor.moveToPosition(i2);
        View view3 = view2 == null ? newDropDownView(this.mContext, this.mCursor, viewGroup2) : view2;
        bindView(view3, this.mContext, this.mCursor);
        return view3;
    }

    public Filter getFilter() {
        CursorFilter cursorFilter;
        if (this.mCursorFilter == null) {
            CursorFilter cursorFilter2 = cursorFilter;
            CursorFilter cursorFilter3 = new CursorFilter(this);
            this.mCursorFilter = cursorFilter2;
        }
        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    public Object getItem(int i) {
        int i2 = i;
        if (!this.mDataValid || this.mCursor == null) {
            return null;
        }
        boolean moveToPosition = this.mCursor.moveToPosition(i2);
        return this.mCursor;
    }

    public long getItemId(int i) {
        int i2 = i;
        long j = 0;
        if (this.mDataValid && this.mCursor != null && this.mCursor.moveToPosition(i2)) {
            j = this.mCursor.getLong(this.mRowIDColumn);
        }
        return j;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        IllegalStateException illegalStateException2;
        int i2 = i;
        View view2 = view;
        ViewGroup viewGroup2 = viewGroup;
        if (!this.mDataValid) {
            IllegalStateException illegalStateException3 = illegalStateException2;
            IllegalStateException illegalStateException4 = new IllegalStateException("this should only be called when the cursor is valid");
            throw illegalStateException3;
        } else if (!this.mCursor.moveToPosition(i2)) {
            IllegalStateException illegalStateException5 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException6 = new IllegalStateException(sb2.append("couldn't move cursor to position ").append(i2).toString());
            throw illegalStateException5;
        } else {
            View view3 = view2 == null ? newView(this.mContext, this.mCursor, viewGroup2) : view2;
            bindView(view3, this.mContext, this.mCursor);
            return view3;
        }
    }

    public boolean hasStableIds() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void init(Context context, Cursor cursor, int i) {
        ChangeObserver changeObserver;
        MyDataSetObserver myDataSetObserver;
        Context context2 = context;
        Cursor cursor2 = cursor;
        int i2 = i;
        boolean z = true;
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.mAutoRequery = true;
        } else {
            this.mAutoRequery = false;
        }
        if (cursor2 == null) {
            z = false;
        }
        this.mCursor = cursor2;
        this.mDataValid = z;
        this.mContext = context2;
        this.mRowIDColumn = z ? cursor2.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            ChangeObserver changeObserver2 = changeObserver;
            ChangeObserver changeObserver3 = new ChangeObserver(this);
            this.mChangeObserver = changeObserver2;
            MyDataSetObserver myDataSetObserver2 = myDataSetObserver;
            MyDataSetObserver myDataSetObserver3 = new MyDataSetObserver(this, null);
            this.mDataSetObserver = myDataSetObserver2;
        } else {
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }
        if (z) {
            if (this.mChangeObserver != null) {
                cursor2.registerContentObserver(this.mChangeObserver);
            }
            if (this.mDataSetObserver != null) {
                cursor2.registerDataSetObserver(this.mDataSetObserver);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void init(Context context, Cursor cursor, boolean z) {
        init(context, cursor, z ? 1 : 2);
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public void onContentChanged() {
        if (this.mAutoRequery && this.mCursor != null && !this.mCursor.isClosed()) {
            this.mDataValid = this.mCursor.requery();
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        return this.mFilterQueryProvider != null ? this.mFilterQueryProvider.runQuery(charSequence) : this.mCursor;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        FilterQueryProvider filterQueryProvider2 = filterQueryProvider;
        this.mFilterQueryProvider = filterQueryProvider2;
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = cursor;
        if (cursor2 == this.mCursor) {
            return null;
        }
        Cursor cursor3 = this.mCursor;
        if (cursor3 != null) {
            if (this.mChangeObserver != null) {
                cursor3.unregisterContentObserver(this.mChangeObserver);
            }
            if (this.mDataSetObserver != null) {
                cursor3.unregisterDataSetObserver(this.mDataSetObserver);
            }
        }
        this.mCursor = cursor2;
        if (cursor2 != null) {
            if (this.mChangeObserver != null) {
                cursor2.registerContentObserver(this.mChangeObserver);
            }
            if (this.mDataSetObserver != null) {
                cursor2.registerDataSetObserver(this.mDataSetObserver);
            }
            this.mRowIDColumn = cursor2.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            notifyDataSetChanged();
            return cursor3;
        }
        this.mRowIDColumn = -1;
        this.mDataValid = false;
        notifyDataSetInvalidated();
        return cursor3;
    }
}
