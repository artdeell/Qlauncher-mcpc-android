package android.support.p000v4.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: android.support.v4.util.AtomicFile */
public class AtomicFile {
    private final File mBackupName;
    private final File mBaseName;

    public AtomicFile(File file) {
        File file2;
        StringBuilder sb;
        File file3 = file;
        this.mBaseName = file3;
        File file4 = file2;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        File file5 = new File(sb2.append(file3.getPath()).append(".bak").toString());
        this.mBackupName = file4;
    }

    static boolean sync(FileOutputStream fileOutputStream) {
        FileOutputStream fileOutputStream2 = fileOutputStream;
        if (fileOutputStream2 != null) {
            try {
                fileOutputStream2.getFD().sync();
            } catch (IOException e) {
                IOException iOException = e;
                return false;
            }
        }
        return true;
    }

    public void delete() {
        boolean delete = this.mBaseName.delete();
        boolean delete2 = this.mBackupName.delete();
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        FileOutputStream fileOutputStream2 = fileOutputStream;
        if (fileOutputStream2 != null) {
            boolean sync = sync(fileOutputStream2);
            try {
                fileOutputStream2.close();
                boolean delete = this.mBaseName.delete();
                boolean renameTo = this.mBackupName.renameTo(this.mBaseName);
            } catch (IOException e) {
                int w = Log.w("AtomicFile", "failWrite: Got exception:", e);
            }
        }
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        FileOutputStream fileOutputStream2 = fileOutputStream;
        if (fileOutputStream2 != null) {
            boolean sync = sync(fileOutputStream2);
            try {
                fileOutputStream2.close();
                boolean delete = this.mBackupName.delete();
            } catch (IOException e) {
                int w = Log.w("AtomicFile", "finishWrite: Got exception:", e);
            }
        }
    }

    public File getBaseFile() {
        return this.mBaseName;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        FileInputStream fileInputStream;
        if (this.mBackupName.exists()) {
            boolean delete = this.mBaseName.delete();
            boolean renameTo = this.mBackupName.renameTo(this.mBaseName);
        }
        FileInputStream fileInputStream2 = fileInputStream;
        FileInputStream fileInputStream3 = new FileInputStream(this.mBaseName);
        return fileInputStream2;
    }

    public byte[] readFully() throws IOException {
        FileInputStream openRead = openRead();
        int i = 0;
        try {
            byte[] bArr = new byte[openRead.available()];
            while (true) {
                int read = openRead.read(bArr, i, bArr.length - i);
                if (read <= 0) {
                    openRead.close();
                    return bArr;
                }
                i += read;
                int available = openRead.available();
                if (available > bArr.length - i) {
                    byte[] bArr2 = new byte[(i + available)];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    bArr = bArr2;
                }
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            openRead.close();
            throw th2;
        }
    }

    public FileOutputStream startWrite() throws IOException {
        IOException iOException;
        StringBuilder sb;
        FileOutputStream fileOutputStream;
        IOException iOException2;
        StringBuilder sb2;
        FileOutputStream fileOutputStream2;
        StringBuilder sb3;
        if (this.mBaseName.exists()) {
            if (this.mBackupName.exists()) {
                boolean delete = this.mBaseName.delete();
            } else if (!this.mBaseName.renameTo(this.mBackupName)) {
                StringBuilder sb4 = sb3;
                StringBuilder sb5 = new StringBuilder();
                int w = Log.w("AtomicFile", sb4.append("Couldn't rename file ").append(this.mBaseName).append(" to backup file ").append(this.mBackupName).toString());
            }
        }
        try {
            FileOutputStream fileOutputStream3 = fileOutputStream2;
            FileOutputStream fileOutputStream4 = new FileOutputStream(this.mBaseName);
            return fileOutputStream3;
        } catch (FileNotFoundException e) {
            FileNotFoundException fileNotFoundException = e;
            if (!this.mBaseName.getParentFile().mkdir()) {
                IOException iOException3 = iOException2;
                StringBuilder sb6 = sb2;
                StringBuilder sb7 = new StringBuilder();
                IOException iOException4 = new IOException(sb6.append("Couldn't create directory ").append(this.mBaseName).toString());
                throw iOException3;
            }
            try {
                FileOutputStream fileOutputStream5 = fileOutputStream;
                FileOutputStream fileOutputStream6 = new FileOutputStream(this.mBaseName);
                return fileOutputStream5;
            } catch (FileNotFoundException e2) {
                FileNotFoundException fileNotFoundException2 = e2;
                IOException iOException5 = iOException;
                StringBuilder sb8 = sb;
                StringBuilder sb9 = new StringBuilder();
                IOException iOException6 = new IOException(sb8.append("Couldn't create ").append(this.mBaseName).toString());
                throw iOException5;
            }
        }
    }
}
