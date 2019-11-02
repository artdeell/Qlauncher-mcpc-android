package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.LocalStart */
public final class LocalStart extends ZeroSizeInsn {
    private final RegisterSpec local;

    public LocalStart(SourcePosition sourcePosition, RegisterSpec registerSpec) {
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

    public static String localString(RegisterSpec registerSpec) {
        StringBuilder sb;
        RegisterSpec registerSpec2 = registerSpec;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(registerSpec2.regString()).append(' ').append(registerSpec2.getLocalItem().toString()).append(": ").append(registerSpec2.getTypeBearer().toHuman()).toString();
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
        return sb2.append("local-start ").append(localString(this.local)).toString();
    }

    public DalvInsn withRegisterOffset(int i) {
        LocalStart localStart;
        LocalStart localStart2 = localStart;
        LocalStart localStart3 = new LocalStart(getPosition(), this.local.withOffset(i));
        return localStart2;
    }

    public DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        LocalStart localStart;
        RegisterSpecList registerSpecList2 = registerSpecList;
        LocalStart localStart2 = localStart;
        LocalStart localStart3 = new LocalStart(getPosition(), this.local);
        return localStart2;
    }
}
