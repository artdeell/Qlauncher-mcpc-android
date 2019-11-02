package android.support.p000v4.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: android.support.v4.provider.RawDocumentFile */
class RawDocumentFile extends DocumentFile {
    private File mFile;

    RawDocumentFile(DocumentFile documentFile, File file) {
        File file2 = file;
        super(documentFile);
        this.mFile = file2;
    }

    private static boolean deleteContents(File file) {
        StringBuilder sb;
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    z &= deleteContents(file2);
                }
                if (!file2.delete()) {
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int w = Log.w("DocumentFile", sb2.append("Failed to delete ").append(file2).toString());
                    z = false;
                }
            }
        }
        return z;
    }

    private static String getTypeForName(String str) {
        String str2 = str;
        int lastIndexOf = str2.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2.substring(lastIndexOf + 1).toLowerCase());
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }

    public boolean canRead() {
        return this.mFile.canRead();
    }

    public boolean canWrite() {
        return this.mFile.canWrite();
    }

    public DocumentFile createDirectory(String str) {
        File file;
        RawDocumentFile rawDocumentFile;
        File file2 = file;
        File file3 = new File(this.mFile, str);
        File file4 = file2;
        if (!file4.isDirectory() && !file4.mkdir()) {
            return null;
        }
        RawDocumentFile rawDocumentFile2 = rawDocumentFile;
        RawDocumentFile rawDocumentFile3 = new RawDocumentFile(this, file4);
        return rawDocumentFile2;
    }

    public DocumentFile createFile(String str, String str2) {
        File file;
        StringBuilder sb;
        RawDocumentFile rawDocumentFile;
        StringBuilder sb2;
        String str3 = str2;
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            str3 = sb3.append(str3).append(".").append(extensionFromMimeType).toString();
        }
        File file2 = file;
        File file3 = new File(this.mFile, str3);
        File file4 = file2;
        try {
            boolean createNewFile = file4.createNewFile();
            RawDocumentFile rawDocumentFile2 = rawDocumentFile;
            RawDocumentFile rawDocumentFile3 = new RawDocumentFile(this, file4);
            return rawDocumentFile2;
        } catch (IOException e) {
            IOException iOException = e;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            int w = Log.w("DocumentFile", sb5.append("Failed to createFile: ").append(iOException).toString());
            return null;
        }
    }

    public boolean delete() {
        boolean deleteContents = deleteContents(this.mFile);
        return this.mFile.delete();
    }

    public boolean exists() {
        return this.mFile.exists();
    }

    public String getName() {
        return this.mFile.getName();
    }

    public String getType() {
        if (this.mFile.isDirectory()) {
            return null;
        }
        return getTypeForName(this.mFile.getName());
    }

    public Uri getUri() {
        return Uri.fromFile(this.mFile);
    }

    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    public boolean isFile() {
        return this.mFile.isFile();
    }

    public long lastModified() {
        return this.mFile.lastModified();
    }

    public long length() {
        return this.mFile.length();
    }

    public DocumentFile[] listFiles() {
        ArrayList arrayList;
        RawDocumentFile rawDocumentFile;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        File[] listFiles = this.mFile.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                ArrayList arrayList5 = arrayList4;
                RawDocumentFile rawDocumentFile2 = rawDocumentFile;
                RawDocumentFile rawDocumentFile3 = new RawDocumentFile(this, listFiles[i]);
                boolean add = arrayList5.add(rawDocumentFile2);
            }
        }
        return (DocumentFile[]) arrayList4.toArray(new DocumentFile[arrayList4.size()]);
    }

    public boolean renameTo(String str) {
        File file;
        File file2 = file;
        File file3 = new File(this.mFile.getParentFile(), str);
        File file4 = file2;
        if (!this.mFile.renameTo(file4)) {
            return false;
        }
        this.mFile = file4;
        return true;
    }
}
