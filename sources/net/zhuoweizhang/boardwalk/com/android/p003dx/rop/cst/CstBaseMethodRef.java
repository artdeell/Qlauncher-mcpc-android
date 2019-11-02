package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Prototype;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstBaseMethodRef */
public abstract class CstBaseMethodRef extends CstMemberRef {
    private Prototype instancePrototype = null;
    private final Prototype prototype = Prototype.intern(getNat().getDescriptor().getString());

    CstBaseMethodRef(CstType cstType, CstNat cstNat) {
        super(cstType, cstNat);
    }

    /* access modifiers changed from: protected */
    public final int compareTo0(Constant constant) {
        Constant constant2 = constant;
        int compareTo0 = super.compareTo0(constant2);
        if (compareTo0 != 0) {
            return compareTo0;
        }
        return this.prototype.compareTo(((CstBaseMethodRef) constant2).prototype);
    }

    public final int getParameterWordCount(boolean z) {
        return getPrototype(z).getParameterTypes().getWordCount();
    }

    public final Prototype getPrototype() {
        return this.prototype;
    }

    public final Prototype getPrototype(boolean z) {
        if (z) {
            return this.prototype;
        }
        if (this.instancePrototype == null) {
            this.instancePrototype = this.prototype.withFirstParameter(getDefiningClass().getClassType());
        }
        return this.instancePrototype;
    }

    public final Type getType() {
        return this.prototype.getReturnType();
    }

    public final boolean isClassInit() {
        return getNat().isClassInit();
    }

    public final boolean isInstanceInit() {
        return getNat().isInstanceInit();
    }
}
