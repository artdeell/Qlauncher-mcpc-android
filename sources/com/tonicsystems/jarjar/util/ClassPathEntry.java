package com.tonicsystems.jarjar.util;

import java.io.IOException;
import java.io.InputStream;

public interface ClassPathEntry {
    String getName();

    String getSource() throws IOException;

    InputStream openStream() throws IOException;
}
