package com.tonicsystems.jarjar;

import com.tonicsystems.jarjar.util.EntryStruct;
import com.tonicsystems.jarjar.util.JarProcessor;
import java.io.IOException;

class ManifestProcessor implements JarProcessor {
    private static final ManifestProcessor INSTANCE;
    private static final String MANIFEST_PATH = "META-INF/MANIFEST.MF";

    static {
        ManifestProcessor manifestProcessor;
        ManifestProcessor manifestProcessor2 = manifestProcessor;
        ManifestProcessor manifestProcessor3 = new ManifestProcessor();
        INSTANCE = manifestProcessor2;
    }

    private ManifestProcessor() {
    }

    public static ManifestProcessor getInstance() {
        return INSTANCE;
    }

    public boolean process(EntryStruct entryStruct) throws IOException {
        return !entryStruct.name.equalsIgnoreCase(MANIFEST_PATH);
    }
}
