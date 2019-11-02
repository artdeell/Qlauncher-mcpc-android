package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.back;

import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.BasicRegisterMapper;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.RegisterMapper;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaMethod;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.back.NullRegisterAllocator */
public class NullRegisterAllocator extends RegisterAllocator {
    public NullRegisterAllocator(SsaMethod ssaMethod, InterferenceGraph interferenceGraph) {
        super(ssaMethod, interferenceGraph);
    }

    public RegisterMapper allocateRegisters() {
        BasicRegisterMapper basicRegisterMapper;
        int regCount = this.ssaMeth.getRegCount();
        BasicRegisterMapper basicRegisterMapper2 = basicRegisterMapper;
        BasicRegisterMapper basicRegisterMapper3 = new BasicRegisterMapper(regCount);
        BasicRegisterMapper basicRegisterMapper4 = basicRegisterMapper2;
        for (int i = 0; i < regCount; i++) {
            basicRegisterMapper4.addMapping(i, i * 2, 2);
        }
        return basicRegisterMapper4;
    }

    public boolean wantsParamsMovedHigh() {
        return false;
    }
}
