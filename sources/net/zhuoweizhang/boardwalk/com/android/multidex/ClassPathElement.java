package net.zhuoweizhang.boardwalk.com.android.multidex;

import java.io.IOException;
import java.io.InputStream;

interface ClassPathElement {
    public static final char SEPARATOR_CHAR = '/';

    void close() throws IOException;

    InputStream open(String str) throws IOException;
}
