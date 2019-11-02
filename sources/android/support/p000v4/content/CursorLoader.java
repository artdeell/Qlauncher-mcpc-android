package android.support.p000v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.p000v4.content.Loader.ForceLoadContentObserver;
import android.support.p000v4.p002os.CancellationSignal;
import android.support.p000v4.p002os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* renamed from: android.support.v4.content.CursorLoader */
public class CursorLoader extends AsyncTaskLoader<Cursor> {
    CancellationSignal mCancellationSignal;
    Cursor mCursor;
    final ForceLoadContentObserver mObserver;
    String[] mProjection;
    String mSelection;
    String[] mSelectionArgs;
    String mSortOrder;
    Uri mUri;

    public CursorLoader(Context context) {
        ForceLoadContentObserver forceLoadContentObserver;
        super(context);
        ForceLoadContentObserver forceLoadContentObserver2 = forceLoadContentObserver;
        ForceLoadContentObserver forceLoadContentObserver3 = new ForceLoadContentObserver<>(this);
        this.mObserver = forceLoadContentObserver2;
    }

    public CursorLoader(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        ForceLoadContentObserver forceLoadContentObserver;
        Uri uri2 = uri;
        String[] strArr3 = strArr;
        String str3 = str;
        String[] strArr4 = strArr2;
        String str4 = str2;
        super(context);
        ForceLoadContentObserver forceLoadContentObserver2 = forceLoadContentObserver;
        ForceLoadContentObserver forceLoadContentObserver3 = new ForceLoadContentObserver<>(this);
        this.mObserver = forceLoadContentObserver2;
        this.mUri = uri2;
        this.mProjection = strArr3;
        this.mSelection = str3;
        this.mSelectionArgs = strArr4;
        this.mSortOrder = str4;
    }

    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            try {
                if (this.mCancellationSignal != null) {
                    this.mCancellationSignal.cancel();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void deliverResult(Cursor cursor) {
        Cursor cursor2 = cursor;
        if (!isReset()) {
            Cursor cursor3 = this.mCursor;
            this.mCursor = cursor2;
            if (isStarted()) {
                super.deliverResult(cursor2);
            }
            if (cursor3 != null && cursor3 != cursor2 && !cursor3.isClosed()) {
                cursor3.close();
            }
        } else if (cursor2 != null) {
            cursor2.close();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str;
        PrintWriter printWriter2 = printWriter;
        super.dump(str2, fileDescriptor, printWriter2, strArr);
        printWriter2.print(str2);
        printWriter2.print("mUri=");
        printWriter2.println(this.mUri);
        printWriter2.print(str2);
        printWriter2.print("mProjection=");
        printWriter2.println(Arrays.toString(this.mProjection));
        printWriter2.print(str2);
        printWriter2.print("mSelection=");
        printWriter2.println(this.mSelection);
        printWriter2.print(str2);
        printWriter2.print("mSelectionArgs=");
        printWriter2.println(Arrays.toString(this.mSelectionArgs));
        printWriter2.print(str2);
        printWriter2.print("mSortOrder=");
        printWriter2.println(this.mSortOrder);
        printWriter2.print(str2);
        printWriter2.print("mCursor=");
        printWriter2.println(this.mCursor);
        printWriter2.print(str2);
        printWriter2.print("mContentChanged=");
        printWriter2.println(this.mContentChanged);
    }

    public String[] getProjection() {
        return this.mProjection;
    }

    public String getSelection() {
        return this.mSelection;
    }

    public String[] getSelectionArgs() {
        return this.mSelectionArgs;
    }

    public String getSortOrder() {
        return this.mSortOrder;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public Cursor loadInBackground() {
        CancellationSignal cancellationSignal;
        OperationCanceledException operationCanceledException;
        synchronized (this) {
            try {
                if (isLoadInBackgroundCanceled()) {
                    OperationCanceledException operationCanceledException2 = operationCanceledException;
                    OperationCanceledException operationCanceledException3 = new OperationCanceledException();
                    throw operationCanceledException2;
                }
                CancellationSignal cancellationSignal2 = cancellationSignal;
                CancellationSignal cancellationSignal3 = new CancellationSignal();
                this.mCancellationSignal = cancellationSignal2;
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        try {
            th = ContentResolverCompat.query(getContext().getContentResolver(), this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder, this.mCancellationSignal);
            if (th != null) {
                int count = th.getCount();
                th.registerContentObserver(this.mObserver);
            }
            synchronized (this) {
                try {
                    this.mCancellationSignal = null;
                } finally {
                    while (true) {
                        Throwable th3 = th;
                        Throwable th4 = th3;
                    }
                }
            }
            return th;
        } catch (RuntimeException e) {
            RuntimeException runtimeException = e;
            th.close();
            throw runtimeException;
        } catch (Throwable th5) {
            Throwable th6 = th5;
            synchronized (this) {
                try {
                    this.mCancellationSignal = null;
                    throw th6;
                } catch (Throwable th7) {
                    while (true) {
                        Throwable th8 = th7;
                        throw th8;
                    }
                }
            }
        }
    }

    public void onCanceled(Cursor cursor) {
        Cursor cursor2 = cursor;
        if (cursor2 != null && !cursor2.isClosed()) {
            cursor2.close();
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        super.onReset();
        onStopLoading();
        if (this.mCursor != null && !this.mCursor.isClosed()) {
            this.mCursor.close();
        }
        this.mCursor = null;
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
        if (this.mCursor != null) {
            deliverResult(this.mCursor);
        }
        if (takeContentChanged() || this.mCursor == null) {
            forceLoad();
        }
    }

    /* access modifiers changed from: protected */
    public void onStopLoading() {
        boolean cancelLoad = cancelLoad();
    }

    public void setProjection(String[] strArr) {
        String[] strArr2 = strArr;
        this.mProjection = strArr2;
    }

    public void setSelection(String str) {
        String str2 = str;
        this.mSelection = str2;
    }

    public void setSelectionArgs(String[] strArr) {
        String[] strArr2 = strArr;
        this.mSelectionArgs = strArr2;
    }

    public void setSortOrder(String str) {
        String str2 = str;
        this.mSortOrder = str2;
    }

    public void setUri(Uri uri) {
        Uri uri2 = uri;
        this.mUri = uri2;
    }
}
