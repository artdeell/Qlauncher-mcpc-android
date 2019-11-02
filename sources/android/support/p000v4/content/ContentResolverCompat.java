package android.support.p000v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.p000v4.p002os.CancellationSignal;
import android.support.p000v4.p002os.OperationCanceledException;

/* renamed from: android.support.v4.content.ContentResolverCompat */
public class ContentResolverCompat {
    private static final ContentResolverCompatImpl IMPL;

    /* renamed from: android.support.v4.content.ContentResolverCompat$ContentResolverCompatImpl */
    interface ContentResolverCompatImpl {
        Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);
    }

    /* renamed from: android.support.v4.content.ContentResolverCompat$ContentResolverCompatImplBase */
    static class ContentResolverCompatImplBase implements ContentResolverCompatImpl {
        ContentResolverCompatImplBase() {
        }

        public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentResolver contentResolver2 = contentResolver;
            Uri uri2 = uri;
            String[] strArr3 = strArr;
            String str3 = str;
            String[] strArr4 = strArr2;
            String str4 = str2;
            CancellationSignal cancellationSignal2 = cancellationSignal;
            if (cancellationSignal2 != null) {
                cancellationSignal2.throwIfCanceled();
            }
            return contentResolver2.query(uri2, strArr3, str3, strArr4, str4);
        }
    }

    /* renamed from: android.support.v4.content.ContentResolverCompat$ContentResolverCompatImplJB */
    static class ContentResolverCompatImplJB extends ContentResolverCompatImplBase {
        ContentResolverCompatImplJB() {
        }

        public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            Object obj;
            OperationCanceledException operationCanceledException;
            ContentResolver contentResolver2 = contentResolver;
            Uri uri2 = uri;
            String[] strArr3 = strArr;
            String str3 = str;
            String[] strArr4 = strArr2;
            String str4 = str2;
            CancellationSignal cancellationSignal2 = cancellationSignal;
            if (cancellationSignal2 != null) {
                try {
                    obj = cancellationSignal2.getCancellationSignalObject();
                } catch (Exception e) {
                    Exception exc = e;
                    if (ContentResolverCompatJellybean.isFrameworkOperationCanceledException(exc)) {
                        OperationCanceledException operationCanceledException2 = operationCanceledException;
                        OperationCanceledException operationCanceledException3 = new OperationCanceledException();
                        throw operationCanceledException2;
                    }
                    throw exc;
                }
            } else {
                obj = null;
            }
            return ContentResolverCompatJellybean.query(contentResolver2, uri2, strArr3, str3, strArr4, str4, obj);
        }
    }

    static {
        ContentResolverCompatImplBase contentResolverCompatImplBase;
        ContentResolverCompatImplJB contentResolverCompatImplJB;
        if (VERSION.SDK_INT >= 16) {
            ContentResolverCompatImplJB contentResolverCompatImplJB2 = contentResolverCompatImplJB;
            ContentResolverCompatImplJB contentResolverCompatImplJB3 = new ContentResolverCompatImplJB();
            IMPL = contentResolverCompatImplJB2;
            return;
        }
        ContentResolverCompatImplBase contentResolverCompatImplBase2 = contentResolverCompatImplBase;
        ContentResolverCompatImplBase contentResolverCompatImplBase3 = new ContentResolverCompatImplBase();
        IMPL = contentResolverCompatImplBase2;
    }

    private ContentResolverCompat() {
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return IMPL.query(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal);
    }
}
