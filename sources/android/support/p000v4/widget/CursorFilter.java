package android.support.p000v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* renamed from: android.support.v4.widget.CursorFilter */
class CursorFilter extends Filter {
    CursorFilterClient mClient;

    /* renamed from: android.support.v4.widget.CursorFilter$CursorFilterClient */
    interface CursorFilterClient {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    CursorFilter(CursorFilterClient cursorFilterClient) {
        this.mClient = cursorFilterClient;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.mClient.convertToString((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public FilterResults performFiltering(CharSequence charSequence) {
        FilterResults filterResults;
        CharSequence charSequence2 = charSequence;
        Cursor runQueryOnBackgroundThread = this.mClient.runQueryOnBackgroundThread(charSequence2);
        FilterResults filterResults2 = filterResults;
        FilterResults filterResults3 = new FilterResults();
        FilterResults filterResults4 = filterResults2;
        if (runQueryOnBackgroundThread != null) {
            filterResults4.count = runQueryOnBackgroundThread.getCount();
            filterResults4.values = runQueryOnBackgroundThread;
            return filterResults4;
        }
        filterResults4.count = 0;
        filterResults4.values = null;
        return filterResults4;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, FilterResults filterResults) {
        CharSequence charSequence2 = charSequence;
        FilterResults filterResults2 = filterResults;
        Cursor cursor = this.mClient.getCursor();
        if (filterResults2.values != null && filterResults2.values != cursor) {
            this.mClient.changeCursor((Cursor) filterResults2.values);
        }
    }
}
