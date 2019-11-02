package android.support.p000v4.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: android.support.v4.provider.DocumentsContractApi21 */
class DocumentsContractApi21 {
    private static final String TAG = "DocumentFile";

    DocumentsContractApi21() {
    }

    private static void closeQuietly(AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2 = autoCloseable;
        if (autoCloseable2 != null) {
            try {
                autoCloseable2.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                Exception exc = e2;
            }
        }
    }

    public static Uri createDirectory(Context context, Uri uri, String str) {
        return createFile(context, uri, "vnd.android.document/directory", str);
    }

    public static Uri createFile(Context context, Uri uri, String str, String str2) {
        return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
    }

    public static Uri[] listFiles(Context context, Uri uri) {
        ArrayList arrayList;
        StringBuilder sb;
        Uri uri2 = uri;
        ContentResolver contentResolver = context.getContentResolver();
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri2, DocumentsContract.getDocumentId(uri2));
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        ContentResolver contentResolver2 = contentResolver;
        Uri uri3 = buildChildDocumentsUriUsingTree;
        try {
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = "document_id";
            Cursor query = contentResolver2.query(uri3, strArr2, null, null, null);
            while (query.moveToNext()) {
                boolean add = arrayList4.add(DocumentsContract.buildDocumentUriUsingTree(uri2, query.getString(0)));
            }
            closeQuietly(query);
        } catch (Exception e) {
            Exception exc = e;
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int w = Log.w(str, sb2.append("Failed query: ").append(exc).toString());
            closeQuietly(null);
        } catch (Throwable th) {
            Throwable th2 = th;
            closeQuietly(null);
            throw th2;
        }
        return (Uri[]) arrayList4.toArray(new Uri[arrayList4.size()]);
    }

    public static Uri prepareTreeUri(Uri uri) {
        Uri uri2 = uri;
        return DocumentsContract.buildDocumentUriUsingTree(uri2, DocumentsContract.getTreeDocumentId(uri2));
    }

    public static Uri renameTo(Context context, Uri uri, String str) {
        return DocumentsContract.renameDocument(context.getContentResolver(), uri, str);
    }
}
