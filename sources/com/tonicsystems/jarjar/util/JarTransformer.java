package com.tonicsystems.jarjar.util;

import java.io.IOException;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;

public abstract class JarTransformer implements JarProcessor {
    public JarTransformer() {
    }

    private static String pathFromName(String str) {
        StringBuilder sb;
        String str2 = str;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(str2.replace('.', ClassPathElement.SEPARATOR_CHAR)).append(".class").toString();
    }

    public boolean process(EntryStruct entryStruct) throws IOException {
        ClassReader classReader;
        GetNameClassWriter getNameClassWriter;
        EntryStruct entryStruct2 = entryStruct;
        if (entryStruct2.name.endsWith(".class")) {
            try {
                ClassReader classReader2 = classReader;
                ClassReader classReader3 = new ClassReader(entryStruct2.data);
                ClassReader classReader4 = classReader2;
                GetNameClassWriter getNameClassWriter2 = getNameClassWriter;
                GetNameClassWriter getNameClassWriter3 = new GetNameClassWriter(1);
                GetNameClassWriter getNameClassWriter4 = getNameClassWriter2;
                classReader4.accept(transform(getNameClassWriter4), 8);
                entryStruct2.data = getNameClassWriter4.toByteArray();
                entryStruct2.name = pathFromName(getNameClassWriter4.getClassName());
            } catch (Exception e) {
                Exception exc = e;
                return true;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract ClassVisitor transform(ClassVisitor classVisitor);
}
