package org.objectweb.asm.commons;

import org.objectweb.asm.AnnotationVisitor;

public class RemappingAnnotationAdapter extends AnnotationVisitor {
    protected final Remapper remapper;

    protected RemappingAnnotationAdapter(int i, AnnotationVisitor annotationVisitor, Remapper remapper2) {
        Remapper remapper3 = remapper2;
        super(i, annotationVisitor);
        this.remapper = remapper3;
    }

    public RemappingAnnotationAdapter(AnnotationVisitor annotationVisitor, Remapper remapper2) {
        this(262144, annotationVisitor, remapper2);
    }

    public void visit(String str, Object obj) {
        this.f268av.visit(str, this.remapper.mapValue(obj));
    }

    public AnnotationVisitor visitAnnotation(String str, String str2) {
        RemappingAnnotationAdapter remappingAnnotationAdapter;
        RemappingAnnotationAdapter remappingAnnotationAdapter2 = this;
        AnnotationVisitor visitAnnotation = remappingAnnotationAdapter2.f268av.visitAnnotation(str, remappingAnnotationAdapter2.remapper.mapDesc(str2));
        if (visitAnnotation == null) {
            remappingAnnotationAdapter2 = null;
        } else if (visitAnnotation != remappingAnnotationAdapter2.f268av) {
            RemappingAnnotationAdapter remappingAnnotationAdapter3 = remappingAnnotationAdapter;
            RemappingAnnotationAdapter remappingAnnotationAdapter4 = new RemappingAnnotationAdapter(visitAnnotation, remappingAnnotationAdapter2.remapper);
            return remappingAnnotationAdapter3;
        }
        return remappingAnnotationAdapter2;
    }

    public AnnotationVisitor visitArray(String str) {
        RemappingAnnotationAdapter remappingAnnotationAdapter;
        RemappingAnnotationAdapter remappingAnnotationAdapter2 = this;
        AnnotationVisitor visitArray = remappingAnnotationAdapter2.f268av.visitArray(str);
        if (visitArray == null) {
            remappingAnnotationAdapter2 = null;
        } else if (visitArray != remappingAnnotationAdapter2.f268av) {
            RemappingAnnotationAdapter remappingAnnotationAdapter3 = remappingAnnotationAdapter;
            RemappingAnnotationAdapter remappingAnnotationAdapter4 = new RemappingAnnotationAdapter(visitArray, remappingAnnotationAdapter2.remapper);
            return remappingAnnotationAdapter3;
        }
        return remappingAnnotationAdapter2;
    }

    public void visitEnum(String str, String str2, String str3) {
        String str4 = str3;
        this.f268av.visitEnum(str, this.remapper.mapDesc(str2), str4);
    }
}
