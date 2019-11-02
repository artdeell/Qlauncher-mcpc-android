package net.zhuoweizhang.boardwalk.com.android.multidex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class ArchivePathElement implements ClassPathElement {
    private ZipFile archive;

    public ArchivePathElement(ZipFile zipFile) {
        this.archive = zipFile;
    }

    public void close() throws IOException {
        this.archive.close();
    }

    public InputStream open(String str) throws IOException {
        FileNotFoundException fileNotFoundException;
        String str2 = str;
        ZipEntry entry = this.archive.getEntry(str2);
        if (entry != null) {
            return this.archive.getInputStream(entry);
        }
        FileNotFoundException fileNotFoundException2 = fileNotFoundException;
        FileNotFoundException fileNotFoundException3 = new FileNotFoundException(str2);
        throw fileNotFoundException2;
    }
}
