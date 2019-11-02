package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.VariableSizeInsn */
public abstract class VariableSizeInsn extends DalvInsn {
    public VariableSizeInsn(SourcePosition sourcePosition, RegisterSpecList registerSpecList) {
        super(Dops.SPECIAL_FORMAT, sourcePosition, registerSpecList);
    }

    public final DalvInsn withOpcode(Dop dop) {
        RuntimeException runtimeException;
        Dop dop2 = dop;
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("unsupported");
        throw runtimeException2;
    }

    public final DalvInsn withRegisterOffset(int i) {
        return withRegisters(getRegisters().withOffset(i));
    }
}
