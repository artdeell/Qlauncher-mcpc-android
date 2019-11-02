package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.AnnotationsList */
public final class AnnotationsList extends FixedSizeList {
    public static final AnnotationsList EMPTY;

    static {
        AnnotationsList annotationsList;
        AnnotationsList annotationsList2 = annotationsList;
        AnnotationsList annotationsList3 = new AnnotationsList(0);
        EMPTY = annotationsList2;
    }

    public AnnotationsList(int i) {
        super(i);
    }

    public static AnnotationsList combine(AnnotationsList annotationsList, AnnotationsList annotationsList2) {
        AnnotationsList annotationsList3;
        IllegalArgumentException illegalArgumentException;
        AnnotationsList annotationsList4 = annotationsList;
        AnnotationsList annotationsList5 = annotationsList2;
        int size = annotationsList4.size();
        if (size != annotationsList5.size()) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("list1.size() != list2.size()");
            throw illegalArgumentException2;
        }
        AnnotationsList annotationsList6 = annotationsList3;
        AnnotationsList annotationsList7 = new AnnotationsList(size);
        AnnotationsList annotationsList8 = annotationsList6;
        for (int i = 0; i < size; i++) {
            annotationsList8.set(i, Annotations.combine(annotationsList4.get(i), annotationsList5.get(i)));
        }
        annotationsList8.setImmutable();
        return annotationsList8;
    }

    public Annotations get(int i) {
        return (Annotations) get0(i);
    }

    public void set(int i, Annotations annotations) {
        int i2 = i;
        Annotations annotations2 = annotations;
        annotations2.throwIfMutable();
        set0(i2, annotations2);
    }
}
