package android.support.p000v4.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import java.io.File;

/* renamed from: android.support.v4.provider.DocumentFile */
public abstract class DocumentFile {
    static final String TAG = "DocumentFile";
    private final DocumentFile mParent;

    DocumentFile(DocumentFile documentFile) {
        this.mParent = documentFile;
    }

    public static DocumentFile fromFile(File file) {
        RawDocumentFile rawDocumentFile;
        RawDocumentFile rawDocumentFile2 = rawDocumentFile;
        RawDocumentFile rawDocumentFile3 = new RawDocumentFile(null, file);
        return rawDocumentFile2;
    }

    public static DocumentFile fromSingleUri(Context context, Uri uri) {
        SingleDocumentFile singleDocumentFile;
        Context context2 = context;
        Uri uri2 = uri;
        if (VERSION.SDK_INT < 19) {
            return null;
        }
        SingleDocumentFile singleDocumentFile2 = singleDocumentFile;
        SingleDocumentFile singleDocumentFile3 = new SingleDocumentFile(null, context2, uri2);
        return singleDocumentFile2;
    }

    public static DocumentFile fromTreeUri(Context context, Uri uri) {
        TreeDocumentFile treeDocumentFile;
        Context context2 = context;
        Uri uri2 = uri;
        if (VERSION.SDK_INT < 21) {
            return null;
        }
        TreeDocumentFile treeDocumentFile2 = treeDocumentFile;
        TreeDocumentFile treeDocumentFile3 = new TreeDocumentFile(null, context2, DocumentsContractApi21.prepareTreeUri(uri2));
        return treeDocumentFile2;
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        Context context2 = context;
        Uri uri2 = uri;
        if (VERSION.SDK_INT >= 19) {
            return DocumentsContractApi19.isDocumentUri(context2, uri2);
        }
        return false;
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String str);

    public abstract DocumentFile createFile(String str, String str2);

    public abstract boolean delete();

    public abstract boolean exists();

    public DocumentFile findFile(String str) {
        String str2 = str;
        DocumentFile[] listFiles = listFiles();
        int length = listFiles.length;
        for (int i = 0; i < length; i++) {
            DocumentFile documentFile = listFiles[i];
            if (str2.equals(documentFile.getName())) {
                return documentFile;
            }
        }
        return null;
    }

    public abstract String getName();

    public DocumentFile getParentFile() {
        return this.mParent;
    }

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String str);
}
