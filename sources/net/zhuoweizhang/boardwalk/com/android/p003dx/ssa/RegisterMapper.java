package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.RegisterMapper */
public abstract class RegisterMapper {
    public RegisterMapper() {
    }

    public abstract int getNewRegisterCount();

    public abstract RegisterSpec map(RegisterSpec registerSpec);

    public final RegisterSpecList map(RegisterSpecList registerSpecList) {
        RegisterSpecList registerSpecList2;
        RegisterSpecList registerSpecList3 = registerSpecList;
        int size = registerSpecList3.size();
        RegisterSpecList registerSpecList4 = registerSpecList2;
        RegisterSpecList registerSpecList5 = new RegisterSpecList(size);
        RegisterSpecList registerSpecList6 = registerSpecList4;
        for (int i = 0; i < size; i++) {
            registerSpecList6.set(i, map(registerSpecList3.get(i)));
        }
        registerSpecList6.setImmutable();
        return registerSpecList6.equals(registerSpecList3) ? registerSpecList3 : registerSpecList6;
    }
}
