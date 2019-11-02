package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstDouble;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFloat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLong;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.TypedConstant;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.AttConstantValue */
public final class AttConstantValue extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "ConstantValue";
    private final TypedConstant constantValue;

    public AttConstantValue(TypedConstant typedConstant) {
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException;
        TypedConstant typedConstant2 = typedConstant;
        super(ATTRIBUTE_NAME);
        if ((typedConstant2 instanceof CstString) || (typedConstant2 instanceof CstInteger) || (typedConstant2 instanceof CstLong) || (typedConstant2 instanceof CstFloat) || (typedConstant2 instanceof CstDouble)) {
            this.constantValue = typedConstant2;
        } else if (typedConstant2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("constantValue == null");
            throw nullPointerException2;
        } else {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bad type for constantValue");
            throw illegalArgumentException2;
        }
    }

    public int byteLength() {
        return 8;
    }

    public TypedConstant getConstantValue() {
        return this.constantValue;
    }
}
