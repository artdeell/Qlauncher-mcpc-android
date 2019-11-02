package com.tonicsystems.jarjar;

import com.tonicsystems.jarjar.util.EntryStruct;
import com.tonicsystems.jarjar.util.JarProcessor;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

class ExcludeProcessor implements JarProcessor {
    private final Set<String> excludes;
    private final boolean verbose;

    public ExcludeProcessor(Set<String> set, boolean z) {
        boolean z2 = z;
        this.excludes = set;
        this.verbose = z2;
    }

    public boolean process(EntryStruct entryStruct) throws IOException {
        StringBuilder sb;
        EntryStruct entryStruct2 = entryStruct;
        boolean z = !this.excludes.contains(entryStruct2.name);
        if (this.verbose && !z) {
            PrintStream printStream = System.err;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("Excluding ").append(entryStruct2.name).toString());
        }
        return z;
    }
}
