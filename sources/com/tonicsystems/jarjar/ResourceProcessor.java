package com.tonicsystems.jarjar;

import com.tonicsystems.jarjar.util.EntryStruct;
import com.tonicsystems.jarjar.util.JarProcessor;
import java.io.IOException;

class ResourceProcessor implements JarProcessor {

    /* renamed from: pr */
    private PackageRemapper f17pr;

    public ResourceProcessor(PackageRemapper packageRemapper) {
        this.f17pr = packageRemapper;
    }

    public boolean process(EntryStruct entryStruct) throws IOException {
        EntryStruct entryStruct2 = entryStruct;
        if (!entryStruct2.name.endsWith(".class")) {
            entryStruct2.name = this.f17pr.mapPath(entryStruct2.name);
        }
        return true;
    }
}
