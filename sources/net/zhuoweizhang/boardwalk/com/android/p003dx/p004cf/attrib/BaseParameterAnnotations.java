package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.AnnotationsList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.MutabilityException;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.BaseParameterAnnotations */
public abstract class BaseParameterAnnotations extends BaseAttribute {
    private final int byteLength;
    private final AnnotationsList parameterAnnotations;

    public BaseParameterAnnotations(String str, AnnotationsList annotationsList, int i) {
        NullPointerException nullPointerException;
        MutabilityException mutabilityException;
        AnnotationsList annotationsList2 = annotationsList;
        int i2 = i;
        super(str);
        try {
            if (annotationsList2.isMutable()) {
                MutabilityException mutabilityException2 = mutabilityException;
                MutabilityException mutabilityException3 = new MutabilityException("parameterAnnotations.isMutable()");
                throw mutabilityException2;
            }
            this.parameterAnnotations = annotationsList2;
            this.byteLength = i2;
        } catch (NullPointerException e) {
            NullPointerException nullPointerException2 = e;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("parameterAnnotations == null");
            throw nullPointerException3;
        }
    }

    public final int byteLength() {
        return 6 + this.byteLength;
    }

    public final AnnotationsList getParameterAnnotations() {
        return this.parameterAnnotations;
    }
}
