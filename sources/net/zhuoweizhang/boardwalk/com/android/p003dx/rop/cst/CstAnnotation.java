package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotation;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstAnnotation */
public final class CstAnnotation extends Constant {
    private final Annotation annotation;

    public CstAnnotation(Annotation annotation2) {
        NullPointerException nullPointerException;
        Annotation annotation3 = annotation2;
        if (annotation3 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("annotation == null");
            throw nullPointerException2;
        }
        annotation3.throwIfMutable();
        this.annotation = annotation3;
    }

    /* access modifiers changed from: protected */
    public int compareTo0(Constant constant) {
        return this.annotation.compareTo(((CstAnnotation) constant).annotation);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof CstAnnotation)) {
            return false;
        }
        return this.annotation.equals(((CstAnnotation) obj2).annotation);
    }

    public Annotation getAnnotation() {
        return this.annotation;
    }

    public int hashCode() {
        return this.annotation.hashCode();
    }

    public boolean isCategory2() {
        return false;
    }

    public String toHuman() {
        return this.annotation.toString();
    }

    public String toString() {
        return this.annotation.toString();
    }

    public String typeName() {
        return "annotation";
    }
}
