package android.support.p000v4.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

/* renamed from: android.support.v4.provider.DocumentsContractApi19 */
class DocumentsContractApi19 {
    private static final String TAG = "DocumentFile";

    DocumentsContractApi19() {
    }

    public static boolean canRead(Context context, Uri uri) {
        Context context2 = context;
        Uri uri2 = uri;
        return context2.checkCallingOrSelfUriPermission(uri2, 1) == 0 && !TextUtils.isEmpty(getRawType(context2, uri2));
    }

    public static boolean canWrite(Context context, Uri uri) {
        Context context2 = context;
        Uri uri2 = uri;
        if (context2.checkCallingOrSelfUriPermission(uri2, 2) == 0) {
            String rawType = getRawType(context2, uri2);
            int queryForInt = queryForInt(context2, uri2, "flags", 0);
            if (!TextUtils.isEmpty(rawType)) {
                if ((queryForInt & 4) != 0) {
                    return true;
                }
                if ("vnd.android.document/directory".equals(rawType) && (queryForInt & 8) != 0) {
                    return true;
                }
                if (!TextUtils.isEmpty(rawType) && (queryForInt & 2) != 0) {
                    return true;
                }
            }
        }
        return false;
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

    public static boolean delete(Context context, Uri uri) {
        return DocumentsContract.deleteDocument(context.getContentResolver(), uri);
    }

    public static boolean exists(Context context, Uri uri) {
        StringBuilder sb;
        Uri uri2 = uri;
        Cursor cursor = null;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri3 = uri2;
        try {
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = "document_id";
            cursor = contentResolver.query(uri3, strArr2, null, null, null);
            boolean z = cursor.getCount() > 0;
            closeQuietly(cursor);
            return z;
        } catch (Exception e) {
            Exception exc = e;
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int w = Log.w(str, sb2.append("Failed query: ").append(exc).toString());
            closeQuietly(cursor);
            return false;
        } catch (Throwable th) {
            Throwable th2 = th;
            closeQuietly(cursor);
            throw th2;
        }
    }

    public static String getName(Context context, Uri uri) {
        return queryForString(context, uri, "_display_name", null);
    }

    private static String getRawType(Context context, Uri uri) {
        return queryForString(context, uri, "mime_type", null);
    }

    public static String getType(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        if ("vnd.android.document/directory".equals(rawType)) {
            rawType = null;
        }
        return rawType;
    }

    public static boolean isDirectory(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(getRawType(context, uri));
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public static boolean isFile(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        return !"vnd.android.document/directory".equals(rawType) && !TextUtils.isEmpty(rawType);
    }

    public static long lastModified(Context context, Uri uri) {
        return queryForLong(context, uri, "last_modified", 0);
    }

    public static long length(Context context, Uri uri) {
        return queryForLong(context, uri, "_size", 0);
    }

    private static int queryForInt(Context context, Uri uri, String str, int i) {
        return (int) queryForLong(context, uri, str, (long) i);
    }

    private static long queryForLong(Context context, Uri uri, String str, long j) {
        StringBuilder sb;
        Uri uri2 = uri;
        String str2 = str;
        long j2 = j;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri3 = uri2;
        try {
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = str2;
            Cursor query = contentResolver.query(uri3, strArr2, null, null, null);
            if (!query.moveToFirst() || query.isNull(0)) {
                closeQuietly(query);
                return j2;
            }
            long j3 = query.getLong(0);
            closeQuietly(query);
            return j3;
        } catch (Exception e) {
            Exception exc = e;
            String str3 = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int w = Log.w(str3, sb2.append("Failed query: ").append(exc).toString());
            closeQuietly(null);
            return j2;
        } catch (Throwable th) {
            Throwable th2 = th;
            closeQuietly(null);
            throw th2;
        }
    }

    private static String queryForString(Context context, Uri uri, String str, String str2) {
        StringBuilder sb;
        Uri uri2 = uri;
        String str3 = str;
        String str4 = str2;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri3 = uri2;
        try {
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = str3;
            Cursor query = contentResolver.query(uri3, strArr2, null, null, null);
            if (!query.moveToFirst() || query.isNull(0)) {
                closeQuietly(query);
                return str4;
            }
            String string = query.getString(0);
            closeQuietly(query);
            return string;
        } catch (Exception e) {
            Exception exc = e;
            String str5 = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int w = Log.w(str5, sb2.append("Failed query: ").append(exc).toString());
            closeQuietly(null);
            return str4;
        } catch (Throwable th) {
            Throwable th2 = th;
            closeQuietly(null);
            throw th2;
        }
    }
}
