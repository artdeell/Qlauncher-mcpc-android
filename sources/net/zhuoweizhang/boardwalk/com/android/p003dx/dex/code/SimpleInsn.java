package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.SimpleInsn */
public final class SimpleInsn extends FixedSizeInsn {
    public SimpleInsn(Dop dop, SourcePosition sourcePosition, RegisterSpecList registerSpecList) {
        super(dop, sourcePosition, registerSpecList);
    }

    /* access modifiers changed from: protected */
    public String argString() {
        return null;
    }

    public DalvInsn withOpcode(Dop dop) {
        SimpleInsn simpleInsn;
        SimpleInsn simpleInsn2 = simpleInsn;
        SimpleInsn simpleInsn3 = new SimpleInsn(dop, getPosition(), getRegisters());
        return simpleInsn2;
    }

    public DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        SimpleInsn simpleInsn;
        SimpleInsn simpleInsn2 = simpleInsn;
        SimpleInsn simpleInsn3 = new SimpleInsn(getOpcode(), getPosition(), registerSpecList);
        return simpleInsn2;
    }
}
