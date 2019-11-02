package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.LocalEnd */
public final class LocalEnd extends ZeroSizeInsn {
    private final RegisterSpec local;

    public LocalEnd(SourcePosition sourcePosition, RegisterSpec registerSpec) {
        NullPointerException nullPointerException;
        RegisterSpec registerSpec2 = registerSpec;
        super(sourcePosition);
        if (registerSpec2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("local == null");
            throw nullPointerException2;
        }
        this.local = registerSpec2;
    }

    /* access modifiers changed from: protected */
    public String argString() {
        return this.local.toString();
    }

    public RegisterSpec getLocal() {
        return this.local;
    }

    /* access modifiers changed from: protected */
    public String listingString0(boolean z) {
        StringBuilder sb;
        boolean z2 = z;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("local-end ").append(LocalStart.localString(this.local)).toString();
    }

    public DalvInsn withRegisterOffset(int i) {
        LocalEnd localEnd;
        LocalEnd localEnd2 = localEnd;
        LocalEnd localEnd3 = new LocalEnd(getPosition(), this.local.withOffset(i));
        return localEnd2;
    }

    public DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        LocalEnd localEnd;
        RegisterSpecList registerSpecList2 = registerSpecList;
        LocalEnd localEnd2 = localEnd;
        LocalEnd localEnd3 = new LocalEnd(getPosition(), this.local);
        return localEnd2;
    }
}
