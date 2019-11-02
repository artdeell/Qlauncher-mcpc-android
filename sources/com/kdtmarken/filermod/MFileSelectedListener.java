package com.kdtmarken.filermod;

import java.io.File;

public interface MFileSelectedListener {
    void onFileLongClick(File file, String str, String str2, String str3);

    void onFileSelected(File file, String str, String str2, String str3);
}
