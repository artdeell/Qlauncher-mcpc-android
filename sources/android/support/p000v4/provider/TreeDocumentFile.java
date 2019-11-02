package android.support.p000v4.provider;

import android.content.Context;
import android.net.Uri;

/* renamed from: android.support.v4.provider.TreeDocumentFile */
class TreeDocumentFile extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    TreeDocumentFile(DocumentFile documentFile, Context context, Uri uri) {
        Context context2 = context;
        Uri uri2 = uri;
        super(documentFile);
        this.mContext = context2;
        this.mUri = uri2;
    }

    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.mContext, this.mUri);
    }

    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
    }

    public DocumentFile createDirectory(String str) {
        TreeDocumentFile treeDocumentFile;
        Uri createDirectory = DocumentsContractApi21.createDirectory(this.mContext, this.mUri, str);
        if (createDirectory == null) {
            return null;
        }
        TreeDocumentFile treeDocumentFile2 = treeDocumentFile;
        TreeDocumentFile treeDocumentFile3 = new TreeDocumentFile(this, this.mContext, createDirectory);
        return treeDocumentFile2;
    }

    public DocumentFile createFile(String str, String str2) {
        TreeDocumentFile treeDocumentFile;
        Uri createFile = DocumentsContractApi21.createFile(this.mContext, this.mUri, str, str2);
        if (createFile == null) {
            return null;
        }
        TreeDocumentFile treeDocumentFile2 = treeDocumentFile;
        TreeDocumentFile treeDocumentFile3 = new TreeDocumentFile(this, this.mContext, createFile);
        return treeDocumentFile2;
    }

    public boolean delete() {
        return DocumentsContractApi19.delete(this.mContext, this.mUri);
    }

    public boolean exists() {
        return DocumentsContractApi19.exists(this.mContext, this.mUri);
    }

    public String getName() {
        return DocumentsContractApi19.getName(this.mContext, this.mUri);
    }

    public String getType() {
        return DocumentsContractApi19.getType(this.mContext, this.mUri);
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
    }

    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.mContext, this.mUri);
    }

    public long lastModified() {
        return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
    }

    public long length() {
        return DocumentsContractApi19.length(this.mContext, this.mUri);
    }

    public DocumentFile[] listFiles() {
        TreeDocumentFile treeDocumentFile;
        Uri[] listFiles = DocumentsContractApi21.listFiles(this.mContext, this.mUri);
        DocumentFile[] documentFileArr = new DocumentFile[listFiles.length];
        for (int i = 0; i < listFiles.length; i++) {
            DocumentFile[] documentFileArr2 = documentFileArr;
            int i2 = i;
            TreeDocumentFile treeDocumentFile2 = treeDocumentFile;
            TreeDocumentFile treeDocumentFile3 = new TreeDocumentFile(this, this.mContext, listFiles[i]);
            documentFileArr2[i2] = treeDocumentFile2;
        }
        return documentFileArr;
    }

    public boolean renameTo(String str) {
        Uri renameTo = DocumentsContractApi21.renameTo(this.mContext, this.mUri, str);
        if (renameTo == null) {
            return false;
        }
        this.mUri = renameTo;
        return true;
    }
}
