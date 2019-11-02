package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.back;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.PlainInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.NormalSsaInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.RegisterMapper;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaBasicBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntIterator;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.back.RegisterAllocator */
public abstract class RegisterAllocator {
    protected final InterferenceGraph interference;
    protected final SsaMethod ssaMeth;

    public RegisterAllocator(SsaMethod ssaMethod, InterferenceGraph interferenceGraph) {
        InterferenceGraph interferenceGraph2 = interferenceGraph;
        this.ssaMeth = ssaMethod;
        this.interference = interferenceGraph2;
    }

    public abstract RegisterMapper allocateRegisters();

    /* access modifiers changed from: protected */
    public final int getCategoryForSsaReg(int i) {
        int i2 = i;
        SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i2);
        if (definitionForRegister == null) {
            return 1;
        }
        return definitionForRegister.getResult().getCategory();
    }

    /* access modifiers changed from: protected */
    public final RegisterSpec getDefinitionSpecForSsaReg(int i) {
        int i2 = i;
        SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i2);
        if (definitionForRegister == null) {
            return null;
        }
        return definitionForRegister.getResult();
    }

    /* access modifiers changed from: protected */
    public final RegisterSpec insertMoveBefore(SsaInsn ssaInsn, RegisterSpec registerSpec) {
        PlainInsn plainInsn;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException2;
        SsaInsn ssaInsn2 = ssaInsn;
        RegisterSpec registerSpec2 = registerSpec;
        SsaBasicBlock block = ssaInsn2.getBlock();
        ArrayList insns = block.getInsns();
        int indexOf = insns.indexOf(ssaInsn2);
        if (indexOf < 0) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("specified insn is not in this block");
            throw illegalArgumentException3;
        } else if (indexOf != -1 + insns.size()) {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb2.append("Adding move here not supported:").append(ssaInsn2.toHuman()).toString());
            throw illegalArgumentException5;
        } else {
            RegisterSpec make = RegisterSpec.make(this.ssaMeth.makeNewSsaReg(), registerSpec2.getTypeBearer());
            ArrayList arrayList = insns;
            int i = indexOf;
            PlainInsn plainInsn2 = plainInsn;
            PlainInsn plainInsn3 = new PlainInsn(Rops.opMove(make.getType()), SourcePosition.NO_INFO, make, RegisterSpecList.make(registerSpec2));
            arrayList.add(i, SsaInsn.makeFromRop(plainInsn2, block));
            int reg = make.getReg();
            IntIterator it = block.getLiveOutRegs().iterator();
            while (it.hasNext()) {
                this.interference.add(reg, it.next());
            }
            RegisterSpecList sources = ssaInsn2.getSources();
            int size = sources.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.interference.add(reg, sources.get(i2).getReg());
            }
            this.ssaMeth.onInsnsChanged();
            return make;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isDefinitionMoveParam(int i) {
        SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i);
        if (definitionForRegister instanceof NormalSsaInsn) {
            return ((NormalSsaInsn) definitionForRegister).getOpcode().getOpcode() == 3;
        }
        return false;
    }

    public abstract boolean wantsParamsMovedHigh();
}
