package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.AccessFlags;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Prototype;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.StdMethod */
public final class StdMethod extends StdMember implements Method {
    private final Prototype effectiveDescriptor;

    public StdMethod(CstType cstType, int i, CstNat cstNat, AttributeList attributeList) {
        CstType cstType2 = cstType;
        int i2 = i;
        CstNat cstNat2 = cstNat;
        super(cstType2, i2, cstNat2, attributeList);
        this.effectiveDescriptor = Prototype.intern(getDescriptor().getString(), cstType2.getClassType(), AccessFlags.isStatic(i2), cstNat2.isInstanceInit());
    }

    public Prototype getEffectiveDescriptor() {
        return this.effectiveDescriptor;
    }
}
