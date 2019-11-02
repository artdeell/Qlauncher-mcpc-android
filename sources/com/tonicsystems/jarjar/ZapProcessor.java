package com.tonicsystems.jarjar;

import com.tonicsystems.jarjar.util.EntryStruct;
import com.tonicsystems.jarjar.util.JarProcessor;
import java.io.IOException;
import java.util.List;

class ZapProcessor implements JarProcessor {
    private List<Wildcard> wildcards;

    public ZapProcessor(List<Zap> list) {
        this.wildcards = PatternElement.createWildcards(list);
    }

    private boolean zap(String str) {
        String str2 = str;
        for (Wildcard matches : this.wildcards) {
            if (matches.matches(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean process(EntryStruct entryStruct) throws IOException {
        String str = entryStruct.name;
        return !str.endsWith(".class") || !zap(str.substring(0, -6 + str.length()));
    }
}
