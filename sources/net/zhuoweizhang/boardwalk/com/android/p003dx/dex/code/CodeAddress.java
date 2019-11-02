package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.CodeAddress */
public final class CodeAddress extends ZeroSizeInsn {
    private final boolean bindsClosely;

    public CodeAddress(SourcePosition sourcePosition) {
        this(sourcePosition, false);
    }

    public CodeAddress(SourcePosition sourcePosition, boolean z) {
        boolean z2 = z;
        super(sourcePosition);
        this.bindsClosely = z2;
    }

    /* access modifiers changed from: protected */
    public String argString() {
        return null;
    }

    public boolean getBindsClosely() {
        return this.bindsClosely;
    }

    /* access modifiers changed from: protected */
    public String listingString0(boolean z) {
        boolean z2 = z;
        return "code-address";
    }

    public final DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        CodeAddress codeAddress;
        RegisterSpecList registerSpecList2 = registerSpecList;
        CodeAddress codeAddress2 = codeAddress;
        CodeAddress codeAddress3 = new CodeAddress(getPosition());
        return codeAddress2;
    }
}
