package com.tonicsystems.jarjar.util;

import java.io.IOException;

public class JarProcessorChain implements JarProcessor {
    private final JarProcessor[] chain;

    public JarProcessorChain(JarProcessor[] jarProcessorArr) {
        this.chain = (JarProcessor[]) jarProcessorArr.clone();
    }

    public boolean process(EntryStruct entryStruct) throws IOException {
        EntryStruct entryStruct2 = entryStruct;
        JarProcessor[] jarProcessorArr = this.chain;
        int length = jarProcessorArr.length;
        for (int i = 0; i < length; i++) {
            if (!jarProcessorArr[i].process(entryStruct2)) {
                return false;
            }
        }
        return true;
    }
}
