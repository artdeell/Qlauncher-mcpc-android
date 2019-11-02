package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.back;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.CstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.BasicRegisterMapper;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.NormalSsaInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.RegisterMapper;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.BitIntSet;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.back.FirstFitAllocator */
public class FirstFitAllocator extends RegisterAllocator {
    private static final boolean PRESLOT_PARAMS = true;
    private final BitSet mapped;

    public FirstFitAllocator(SsaMethod ssaMethod, InterferenceGraph interferenceGraph) {
        BitSet bitSet;
        SsaMethod ssaMethod2 = ssaMethod;
        super(ssaMethod2, interferenceGraph);
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(ssaMethod2.getRegCount());
        this.mapped = bitSet2;
    }

    private int paramNumberFromMoveParam(NormalSsaInsn normalSsaInsn) {
        return ((CstInteger) ((CstInsn) normalSsaInsn.getOriginalRopInsn()).getConstant()).getValue();
    }

    public RegisterMapper allocateRegisters() {
        BasicRegisterMapper basicRegisterMapper;
        BitIntSet bitIntSet;
        int i;
        boolean z;
        int regCount = this.ssaMeth.getRegCount();
        BasicRegisterMapper basicRegisterMapper2 = basicRegisterMapper;
        BasicRegisterMapper basicRegisterMapper3 = new BasicRegisterMapper(regCount);
        BasicRegisterMapper basicRegisterMapper4 = basicRegisterMapper2;
        int paramWidth = this.ssaMeth.getParamWidth();
        for (int i2 = 0; i2 < regCount; i2++) {
            if (!this.mapped.get(i2)) {
                int categoryForSsaReg = getCategoryForSsaReg(i2);
                BitIntSet bitIntSet2 = bitIntSet;
                BitIntSet bitIntSet3 = new BitIntSet(regCount);
                BitIntSet bitIntSet4 = bitIntSet2;
                this.interference.mergeInterferenceSet(i2, bitIntSet4);
                if (isDefinitionMoveParam(i2)) {
                    i = paramNumberFromMoveParam((NormalSsaInsn) this.ssaMeth.getDefinitionForRegister(i2));
                    basicRegisterMapper4.addMapping(i2, i, categoryForSsaReg);
                    z = true;
                } else {
                    basicRegisterMapper4.addMapping(i2, paramWidth, categoryForSsaReg);
                    i = paramWidth;
                    z = false;
                }
                int i3 = categoryForSsaReg;
                for (int i4 = i2 + 1; i4 < regCount; i4++) {
                    if (!this.mapped.get(i4) && !isDefinitionMoveParam(i4) && !bitIntSet4.has(i4) && (!z || i3 >= getCategoryForSsaReg(i4))) {
                        this.interference.mergeInterferenceSet(i4, bitIntSet4);
                        i3 = Math.max(i3, getCategoryForSsaReg(i4));
                        basicRegisterMapper4.addMapping(i4, i, i3);
                        this.mapped.set(i4);
                    }
                }
                this.mapped.set(i2);
                if (!z) {
                    paramWidth += i3;
                }
            }
        }
        return basicRegisterMapper4;
    }

    public boolean wantsParamsMovedHigh() {
        return true;
    }
}
