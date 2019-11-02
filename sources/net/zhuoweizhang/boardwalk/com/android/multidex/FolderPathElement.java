package net.zhuoweizhang.boardwalk.com.android.multidex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

class FolderPathElement implements ClassPathElement {
    private File baseFolder;

    public FolderPathElement(File file) {
        this.baseFolder = file;
    }

    public void close() {
    }

    public InputStream open(String str) throws FileNotFoundException {
        FileInputStream fileInputStream;
        File file;
        FileInputStream fileInputStream2 = fileInputStream;
        File file2 = file;
        File file3 = new File(this.baseFolder, str.replace(ClassPathElement.SEPARATOR_CHAR, File.separatorChar));
        FileInputStream fileInputStream3 = new FileInputStream(file2);
        return fileInputStream2;
    }
}
