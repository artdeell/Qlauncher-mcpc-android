package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.MutabilityException;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.AttExceptions */
public final class AttExceptions extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "Exceptions";
    private final TypeList exceptions;

    public AttExceptions(TypeList typeList) {
        NullPointerException nullPointerException;
        MutabilityException mutabilityException;
        TypeList typeList2 = typeList;
        super(ATTRIBUTE_NAME);
        try {
            if (typeList2.isMutable()) {
                MutabilityException mutabilityException2 = mutabilityException;
                MutabilityException mutabilityException3 = new MutabilityException("exceptions.isMutable()");
                throw mutabilityException2;
            }
            this.exceptions = typeList2;
        } catch (NullPointerException e) {
            NullPointerException nullPointerException2 = e;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("exceptions == null");
            throw nullPointerException3;
        }
    }

    public int byteLength() {
        return 8 + (2 * this.exceptions.size());
    }

    public TypeList getExceptions() {
        return this.exceptions;
    }
}
