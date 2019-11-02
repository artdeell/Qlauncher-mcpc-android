package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.LocalSnapshot */
public final class LocalSnapshot extends ZeroSizeInsn {
    private final RegisterSpecSet locals;

    public LocalSnapshot(SourcePosition sourcePosition, RegisterSpecSet registerSpecSet) {
        NullPointerException nullPointerException;
        RegisterSpecSet registerSpecSet2 = registerSpecSet;
        super(sourcePosition);
        if (registerSpecSet2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("locals == null");
            throw nullPointerException2;
        }
        this.locals = registerSpecSet2;
    }

    /* access modifiers changed from: protected */
    public String argString() {
        return this.locals.toString();
    }

    public RegisterSpecSet getLocals() {
        return this.locals;
    }

    /* access modifiers changed from: protected */
    public String listingString0(boolean z) {
        StringBuffer stringBuffer;
        boolean z2 = z;
        int size = this.locals.size();
        int maxSize = this.locals.getMaxSize();
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100 + (size * 40));
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append("local-snapshot");
        for (int i = 0; i < maxSize; i++) {
            RegisterSpec registerSpec = this.locals.get(i);
            if (registerSpec != null) {
                StringBuffer append2 = stringBuffer4.append("\n  ");
                StringBuffer append3 = stringBuffer4.append(LocalStart.localString(registerSpec));
            }
        }
        return stringBuffer4.toString();
    }

    public DalvInsn withRegisterOffset(int i) {
        LocalSnapshot localSnapshot;
        LocalSnapshot localSnapshot2 = localSnapshot;
        LocalSnapshot localSnapshot3 = new LocalSnapshot(getPosition(), this.locals.withOffset(i));
        return localSnapshot2;
    }

    public DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        LocalSnapshot localSnapshot;
        RegisterSpecList registerSpecList2 = registerSpecList;
        LocalSnapshot localSnapshot2 = localSnapshot;
        LocalSnapshot localSnapshot3 = new LocalSnapshot(getPosition(), this.locals);
        return localSnapshot2;
    }
}
