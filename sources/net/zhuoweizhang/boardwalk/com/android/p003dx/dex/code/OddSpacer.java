package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.OddSpacer */
public final class OddSpacer extends VariableSizeInsn {
    public OddSpacer(SourcePosition sourcePosition) {
        super(sourcePosition, RegisterSpecList.EMPTY);
    }

    /* access modifiers changed from: protected */
    public String argString() {
        return null;
    }

    public int codeSize() {
        return 1 & getAddress();
    }

    /* access modifiers changed from: protected */
    public String listingString0(boolean z) {
        boolean z2 = z;
        if (codeSize() == 0) {
            return null;
        }
        return "nop // spacer";
    }

    public DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        OddSpacer oddSpacer;
        RegisterSpecList registerSpecList2 = registerSpecList;
        OddSpacer oddSpacer2 = oddSpacer;
        OddSpacer oddSpacer3 = new OddSpacer(getPosition());
        return oddSpacer2;
    }

    public void writeTo(AnnotatedOutput annotatedOutput) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        if (codeSize() != 0) {
            annotatedOutput2.writeShort(InsnFormat.codeUnit(0, 0));
        }
    }
}
