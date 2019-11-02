package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.AttAnnotationDefault */
public final class AttAnnotationDefault extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "AnnotationDefault";
    private final int byteLength;
    private final Constant value;

    public AttAnnotationDefault(Constant constant, int i) {
        NullPointerException nullPointerException;
        Constant constant2 = constant;
        int i2 = i;
        super(ATTRIBUTE_NAME);
        if (constant2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("value == null");
            throw nullPointerException2;
        }
        this.value = constant2;
        this.byteLength = i2;
    }

    public int byteLength() {
        return 6 + this.byteLength;
    }

    public Constant getValue() {
        return this.value;
    }
}
