package org.objectweb.asm.commons;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.FieldVisitor;

public class RemappingFieldAdapter extends FieldVisitor {
    private final Remapper remapper;

    protected RemappingFieldAdapter(int i, FieldVisitor fieldVisitor, Remapper remapper2) {
        Remapper remapper3 = remapper2;
        super(i, fieldVisitor);
        this.remapper = remapper3;
    }

    public RemappingFieldAdapter(FieldVisitor fieldVisitor, Remapper remapper2) {
        this(262144, fieldVisitor, remapper2);
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        RemappingAnnotationAdapter remappingAnnotationAdapter;
        boolean z2 = z;
        AnnotationVisitor visitAnnotation = this.f327fv.visitAnnotation(this.remapper.mapDesc(str), z2);
        if (visitAnnotation == null) {
            return null;
        }
        RemappingAnnotationAdapter remappingAnnotationAdapter2 = remappingAnnotationAdapter;
        RemappingAnnotationAdapter remappingAnnotationAdapter3 = new RemappingAnnotationAdapter(visitAnnotation, this.remapper);
        return remappingAnnotationAdapter2;
    }
}
