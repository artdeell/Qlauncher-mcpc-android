package com.tonicsystems.jarjar.util;

import java.io.IOException;

public interface JarProcessor {
    boolean process(EntryStruct entryStruct) throws IOException;
}
