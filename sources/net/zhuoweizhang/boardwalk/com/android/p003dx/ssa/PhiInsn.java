package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.LocalItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.PhiInsn */
public final class PhiInsn extends SsaInsn {
    private final ArrayList<Operand> operands;
    private final int ropResultReg;
    private RegisterSpecList sources;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.PhiInsn$Operand */
    private static class Operand {
        public final int blockIndex;
        public RegisterSpec regSpec;
        public final int ropLabel;

        public Operand(RegisterSpec registerSpec, int i, int i2) {
            int i3 = i;
            int i4 = i2;
            this.regSpec = registerSpec;
            this.blockIndex = i3;
            this.ropLabel = i4;
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.PhiInsn$Visitor */
    public interface Visitor {
        void visitPhiInsn(PhiInsn phiInsn);
    }

    public PhiInsn(int i, SsaBasicBlock ssaBasicBlock) {
        ArrayList<Operand> arrayList;
        int i2 = i;
        super(RegisterSpec.make(i2, Type.VOID), ssaBasicBlock);
        ArrayList<Operand> arrayList2 = arrayList;
        ArrayList<Operand> arrayList3 = new ArrayList<>();
        this.operands = arrayList2;
        this.ropResultReg = i2;
    }

    public PhiInsn(RegisterSpec registerSpec, SsaBasicBlock ssaBasicBlock) {
        ArrayList<Operand> arrayList;
        RegisterSpec registerSpec2 = registerSpec;
        super(registerSpec2, ssaBasicBlock);
        ArrayList<Operand> arrayList2 = arrayList;
        ArrayList<Operand> arrayList3 = new ArrayList<>();
        this.operands = arrayList2;
        this.ropResultReg = registerSpec2.getReg();
    }

    public void accept(net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn.Visitor visitor) {
        visitor.visitPhiInsn(this);
    }

    public void addPhiOperand(RegisterSpec registerSpec, SsaBasicBlock ssaBasicBlock) {
        Operand operand;
        RegisterSpec registerSpec2 = registerSpec;
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        ArrayList<Operand> arrayList = this.operands;
        Operand operand2 = operand;
        Operand operand3 = new Operand(registerSpec2, ssaBasicBlock2.getIndex(), ssaBasicBlock2.getRopLabel());
        boolean add = arrayList.add(operand2);
        this.sources = null;
    }

    public boolean areAllOperandsEqual() {
        if (this.operands.size() == 0) {
            return true;
        }
        int reg = ((Operand) this.operands.get(0)).regSpec.getReg();
        Iterator it = this.operands.iterator();
        while (it.hasNext()) {
            if (reg != ((Operand) it.next()).regSpec.getReg()) {
                return false;
            }
        }
        return true;
    }

    public boolean canThrow() {
        return false;
    }

    public void changeResultType(TypeBearer typeBearer, LocalItem localItem) {
        setResult(RegisterSpec.makeLocalOptional(getResult().getReg(), typeBearer, localItem));
    }

    public PhiInsn clone() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("can't clone phi");
        throw unsupportedOperationException2;
    }

    public Rop getOpcode() {
        return null;
    }

    public Insn getOriginalRopInsn() {
        return null;
    }

    public int getRopResultReg() {
        return this.ropResultReg;
    }

    public RegisterSpecList getSources() {
        RegisterSpecList registerSpecList;
        if (this.sources != null) {
            return this.sources;
        }
        if (this.operands.size() == 0) {
            return RegisterSpecList.EMPTY;
        }
        int size = this.operands.size();
        RegisterSpecList registerSpecList2 = registerSpecList;
        RegisterSpecList registerSpecList3 = new RegisterSpecList(size);
        this.sources = registerSpecList2;
        for (int i = 0; i < size; i++) {
            this.sources.set(i, ((Operand) this.operands.get(i)).regSpec);
        }
        this.sources.setImmutable();
        return this.sources;
    }

    public boolean hasSideEffect() {
        return Optimizer.getPreserveLocals() && getLocalAssignment() != null;
    }

    public boolean isPhiOrMove() {
        return true;
    }

    public boolean isRegASource(int i) {
        int i2 = i;
        Iterator it = this.operands.iterator();
        while (it.hasNext()) {
            if (((Operand) it.next()).regSpec.getReg() == i2) {
                return true;
            }
        }
        return false;
    }

    public final void mapSourceRegisters(RegisterMapper registerMapper) {
        RegisterMapper registerMapper2 = registerMapper;
        Iterator it = this.operands.iterator();
        while (it.hasNext()) {
            Operand operand = (Operand) it.next();
            RegisterSpec registerSpec = operand.regSpec;
            operand.regSpec = registerMapper2.map(registerSpec);
            if (registerSpec != operand.regSpec) {
                getBlock().getParent().onSourceChanged(this, registerSpec, operand.regSpec);
            }
        }
        this.sources = null;
    }

    public int predBlockIndexForSourcesIndex(int i) {
        return ((Operand) this.operands.get(i)).blockIndex;
    }

    public List<SsaBasicBlock> predBlocksForReg(int i, SsaMethod ssaMethod) {
        ArrayList arrayList;
        int i2 = i;
        SsaMethod ssaMethod2 = ssaMethod;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        Iterator it = this.operands.iterator();
        while (it.hasNext()) {
            Operand operand = (Operand) it.next();
            if (operand.regSpec.getReg() == i2) {
                boolean add = arrayList4.add(ssaMethod2.getBlocks().get(operand.blockIndex));
            }
        }
        return arrayList4;
    }

    public void removePhiRegister(RegisterSpec registerSpec) {
        ArrayList arrayList;
        RegisterSpec registerSpec2 = registerSpec;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        Iterator it = this.operands.iterator();
        while (it.hasNext()) {
            Operand operand = (Operand) it.next();
            if (operand.regSpec.getReg() == registerSpec2.getReg()) {
                boolean add = arrayList4.add(operand);
            }
        }
        boolean removeAll = this.operands.removeAll(arrayList4);
        this.sources = null;
    }

    public String toHuman() {
        return toHumanWithInline(null);
    }

    /* access modifiers changed from: protected */
    public final String toHumanWithInline(String str) {
        StringBuffer stringBuffer;
        StringBuilder sb;
        String str2 = str;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(80);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append(SourcePosition.NO_INFO);
        StringBuffer append2 = stringBuffer4.append(": phi");
        if (str2 != null) {
            StringBuffer append3 = stringBuffer4.append("(");
            StringBuffer append4 = stringBuffer4.append(str2);
            StringBuffer append5 = stringBuffer4.append(")");
        }
        RegisterSpec result = getResult();
        if (result == null) {
            StringBuffer append6 = stringBuffer4.append(" .");
        } else {
            StringBuffer append7 = stringBuffer4.append(" ");
            StringBuffer append8 = stringBuffer4.append(result.toHuman());
        }
        StringBuffer append9 = stringBuffer4.append(" <-");
        int size = getSources().size();
        if (size == 0) {
            StringBuffer append10 = stringBuffer4.append(" .");
        } else {
            for (int i = 0; i < size; i++) {
                StringBuffer append11 = stringBuffer4.append(" ");
                StringBuffer stringBuffer5 = stringBuffer4;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                StringBuffer append12 = stringBuffer5.append(sb2.append(this.sources.get(i).toHuman()).append("[b=").append(Hex.m51u2(((Operand) this.operands.get(i)).ropLabel)).append("]").toString());
            }
        }
        return stringBuffer4.toString();
    }

    public Insn toRopInsn() {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Cannot convert phi insns to rop form");
        throw illegalArgumentException2;
    }

    public void updateSourcesToDefinitions(SsaMethod ssaMethod) {
        SsaMethod ssaMethod2 = ssaMethod;
        Iterator it = this.operands.iterator();
        while (it.hasNext()) {
            Operand operand = (Operand) it.next();
            Operand operand2 = operand;
            operand2.regSpec = operand.regSpec.withType(ssaMethod2.getDefinitionForRegister(operand.regSpec.getReg()).getResult().getType());
        }
        this.sources = null;
    }
}
