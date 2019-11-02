package com.kdtmarken.filerapi;

import java.io.File;
import java.util.Comparator;

public class SortFileName implements Comparator<File> {
    public /* bridge */ int compare(Object obj, Object obj2) {
        return compare((File) obj, (File) obj2);
    }

    @Override
    public int compare(File file, File file2) {
        return file.getName().compareToIgnoreCase(file2.getName());
    }

    public SortFileName() {
    }
}
