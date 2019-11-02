package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstInterfaceMethodRef */
public final class CstInterfaceMethodRef extends CstBaseMethodRef {
    private CstMethodRef methodRef = null;

    public CstInterfaceMethodRef(CstType cstType, CstNat cstNat) {
        super(cstType, cstNat);
    }

    public CstMethodRef toMethodRef() {
        CstMethodRef cstMethodRef;
        if (this.methodRef == null) {
            CstMethodRef cstMethodRef2 = cstMethodRef;
            CstMethodRef cstMethodRef3 = new CstMethodRef(getDefiningClass(), getNat());
            this.methodRef = cstMethodRef2;
        }
        return this.methodRef;
    }

    public String typeName() {
        return "ifaceMethod";
    }
}
