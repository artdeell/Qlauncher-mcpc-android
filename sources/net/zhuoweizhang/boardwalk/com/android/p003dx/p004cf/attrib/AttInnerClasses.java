package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.MutabilityException;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.AttInnerClasses */
public final class AttInnerClasses extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "InnerClasses";
    private final InnerClassList innerClasses;

    public AttInnerClasses(InnerClassList innerClassList) {
        NullPointerException nullPointerException;
        MutabilityException mutabilityException;
        InnerClassList innerClassList2 = innerClassList;
        super(ATTRIBUTE_NAME);
        try {
            if (innerClassList2.isMutable()) {
                MutabilityException mutabilityException2 = mutabilityException;
                MutabilityException mutabilityException3 = new MutabilityException("innerClasses.isMutable()");
                throw mutabilityException2;
            }
            this.innerClasses = innerClassList2;
        } catch (NullPointerException e) {
            NullPointerException nullPointerException2 = e;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("innerClasses == null");
            throw nullPointerException3;
        }
    }

    public int byteLength() {
        return 8 + (8 * this.innerClasses.size());
    }

    public InnerClassList getInnerClasses() {
        return this.innerClasses;
    }
}
