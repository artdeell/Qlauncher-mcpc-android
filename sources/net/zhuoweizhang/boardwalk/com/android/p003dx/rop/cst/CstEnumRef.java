package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstEnumRef */
public final class CstEnumRef extends CstMemberRef {
    private CstFieldRef fieldRef = null;

    public CstEnumRef(CstNat cstNat) {
        CstType cstType;
        CstNat cstNat2 = cstNat;
        CstType cstType2 = cstType;
        CstType cstType3 = new CstType(cstNat2.getFieldType());
        super(cstType2, cstNat2);
    }

    public CstFieldRef getFieldRef() {
        CstFieldRef cstFieldRef;
        if (this.fieldRef == null) {
            CstFieldRef cstFieldRef2 = cstFieldRef;
            CstFieldRef cstFieldRef3 = new CstFieldRef(getDefiningClass(), getNat());
            this.fieldRef = cstFieldRef2;
        }
        return this.fieldRef;
    }

    public Type getType() {
        return getDefiningClass().getClassType();
    }

    public String typeName() {
        return "enum";
    }
}
