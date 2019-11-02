package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.MutabilityException;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.BaseAnnotations */
public abstract class BaseAnnotations extends BaseAttribute {
    private final Annotations annotations;
    private final int byteLength;

    public BaseAnnotations(String str, Annotations annotations2, int i) {
        NullPointerException nullPointerException;
        MutabilityException mutabilityException;
        Annotations annotations3 = annotations2;
        int i2 = i;
        super(str);
        try {
            if (annotations3.isMutable()) {
                MutabilityException mutabilityException2 = mutabilityException;
                MutabilityException mutabilityException3 = new MutabilityException("annotations.isMutable()");
                throw mutabilityException2;
            }
            this.annotations = annotations3;
            this.byteLength = i2;
        } catch (NullPointerException e) {
            NullPointerException nullPointerException2 = e;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("annotations == null");
            throw nullPointerException3;
        }
    }

    public final int byteLength() {
        return 6 + this.byteLength;
    }

    public final Annotations getAnnotations() {
        return this.annotations;
    }
}
