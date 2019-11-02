package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstFieldRef */
public final class CstFieldRef extends CstMemberRef {
    public CstFieldRef(CstType cstType, CstNat cstNat) {
        super(cstType, cstNat);
    }

    public static CstFieldRef forPrimitiveType(Type type) {
        CstFieldRef cstFieldRef;
        CstFieldRef cstFieldRef2 = cstFieldRef;
        CstFieldRef cstFieldRef3 = new CstFieldRef(CstType.forBoxedPrimitiveType(type), CstNat.PRIMITIVE_TYPE_NAT);
        return cstFieldRef2;
    }

    /* access modifiers changed from: protected */
    public int compareTo0(Constant constant) {
        Constant constant2 = constant;
        int compareTo0 = super.compareTo0(constant2);
        if (compareTo0 != 0) {
            return compareTo0;
        }
        return getNat().getDescriptor().compareTo((Constant) ((CstFieldRef) constant2).getNat().getDescriptor());
    }

    public Type getType() {
        return getNat().getFieldType();
    }

    public String typeName() {
        return "field";
    }
}
