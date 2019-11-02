package com.tonicsystems.jarjar.util;

import com.tonicsystems.jarjar.EmptyClassVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.commons.RemappingClassAdapter;

public class RemappingClassTransformer extends RemappingClassAdapter {
    public RemappingClassTransformer(Remapper remapper) {
        EmptyClassVisitor emptyClassVisitor;
        Remapper remapper2 = remapper;
        EmptyClassVisitor emptyClassVisitor2 = emptyClassVisitor;
        EmptyClassVisitor emptyClassVisitor3 = new EmptyClassVisitor();
        super(emptyClassVisitor2, remapper2);
    }

    public void setTarget(ClassVisitor classVisitor) {
        ClassVisitor classVisitor2 = classVisitor;
        this.f285cv = classVisitor2;
    }
}
