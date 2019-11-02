package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.LabeledList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.BasicBlockList */
public final class BasicBlockList extends LabeledList {
    private int regCount;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.BasicBlockList$RegCountVisitor */
    private static class RegCountVisitor implements Visitor {
        private int regCount = 0;

        public RegCountVisitor() {
        }

        private void processReg(RegisterSpec registerSpec) {
            int nextReg = registerSpec.getNextReg();
            if (nextReg > this.regCount) {
                this.regCount = nextReg;
            }
        }

        private void visit(Insn insn) {
            Insn insn2 = insn;
            RegisterSpec result = insn2.getResult();
            if (result != null) {
                processReg(result);
            }
            RegisterSpecList sources = insn2.getSources();
            int size = sources.size();
            for (int i = 0; i < size; i++) {
                processReg(sources.get(i));
            }
        }

        public int getRegCount() {
            return this.regCount;
        }

        public void visitFillArrayDataInsn(FillArrayDataInsn fillArrayDataInsn) {
            visit(fillArrayDataInsn);
        }

        public void visitPlainCstInsn(PlainCstInsn plainCstInsn) {
            visit(plainCstInsn);
        }

        public void visitPlainInsn(PlainInsn plainInsn) {
            visit(plainInsn);
        }

        public void visitSwitchInsn(SwitchInsn switchInsn) {
            visit(switchInsn);
        }

        public void visitThrowingCstInsn(ThrowingCstInsn throwingCstInsn) {
            visit(throwingCstInsn);
        }

        public void visitThrowingInsn(ThrowingInsn throwingInsn) {
            visit(throwingInsn);
        }
    }

    public BasicBlockList(int i) {
        super(i);
        this.regCount = -1;
    }

    private BasicBlockList(BasicBlockList basicBlockList) {
        BasicBlockList basicBlockList2 = basicBlockList;
        super((LabeledList) basicBlockList2);
        this.regCount = basicBlockList2.regCount;
    }

    public boolean catchesEqual(BasicBlock basicBlock, BasicBlock basicBlock2) {
        BasicBlock basicBlock3 = basicBlock;
        BasicBlock basicBlock4 = basicBlock2;
        if (StdTypeList.equalContents(basicBlock3.getExceptionHandlerTypes(), basicBlock4.getExceptionHandlerTypes())) {
            IntList successors = basicBlock3.getSuccessors();
            IntList successors2 = basicBlock4.getSuccessors();
            int size = successors.size();
            int primarySuccessor = basicBlock3.getPrimarySuccessor();
            int primarySuccessor2 = basicBlock4.getPrimarySuccessor();
            if (!(primarySuccessor == -1 || primarySuccessor2 == -1) || primarySuccessor == primarySuccessor2) {
                for (int i = 0; i < size; i++) {
                    int i2 = successors.get(i);
                    int i3 = successors2.get(i);
                    if (i2 == primarySuccessor) {
                        if (i3 == primarySuccessor2) {
                        }
                    } else if (i2 != i3) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void forEachInsn(Visitor visitor) {
        Visitor visitor2 = visitor;
        int size = size();
        for (int i = 0; i < size; i++) {
            get(i).getInsns().forEach(visitor2);
        }
    }

    public BasicBlock get(int i) {
        return (BasicBlock) get0(i);
    }

    public int getEffectiveInstructionCount() {
        int i;
        int size = size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= size) {
                return i4;
            }
            BasicBlock basicBlock = (BasicBlock) getOrNull0(i2);
            if (basicBlock != null) {
                InsnList insns = basicBlock.getInsns();
                int size2 = insns.size();
                i = i4;
                for (int i5 = 0; i5 < size2; i5++) {
                    if (insns.get(i5).getOpcode().getOpcode() != 54) {
                        i++;
                    }
                }
            } else {
                i = i4;
            }
            i2++;
            i3 = i;
        }
    }

    public int getInstructionCount() {
        int size = size();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= size) {
                return i3;
            }
            BasicBlock basicBlock = (BasicBlock) getOrNull0(i);
            i++;
            i2 = basicBlock != null ? i3 + basicBlock.getInsns().size() : i3;
        }
    }

    public BasicBlockList getMutableCopy() {
        BasicBlockList basicBlockList;
        BasicBlockList basicBlockList2 = basicBlockList;
        BasicBlockList basicBlockList3 = new BasicBlockList(this);
        return basicBlockList2;
    }

    public int getRegCount() {
        RegCountVisitor regCountVisitor;
        if (this.regCount == -1) {
            RegCountVisitor regCountVisitor2 = regCountVisitor;
            RegCountVisitor regCountVisitor3 = new RegCountVisitor();
            RegCountVisitor regCountVisitor4 = regCountVisitor2;
            forEachInsn(regCountVisitor4);
            this.regCount = regCountVisitor4.getRegCount();
        }
        return this.regCount;
    }

    public BasicBlock labelToBlock(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        int indexOfLabel = indexOfLabel(i2);
        if (indexOfLabel >= 0) {
            return get(indexOfLabel);
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("no such label: ").append(Hex.m51u2(i2)).toString());
        throw illegalArgumentException2;
    }

    public BasicBlock preferredSuccessorOf(BasicBlock basicBlock) {
        BasicBlock basicBlock2 = basicBlock;
        int primarySuccessor = basicBlock2.getPrimarySuccessor();
        IntList successors = basicBlock2.getSuccessors();
        switch (successors.size()) {
            case 0:
                return null;
            case 1:
                return labelToBlock(successors.get(0));
            default:
                return primarySuccessor != -1 ? labelToBlock(primarySuccessor) : labelToBlock(successors.get(0));
        }
    }

    public void set(int i, BasicBlock basicBlock) {
        super.set(i, basicBlock);
        this.regCount = -1;
    }

    public BasicBlockList withRegisterOffset(int i) {
        BasicBlockList basicBlockList;
        int i2 = i;
        int size = size();
        BasicBlockList basicBlockList2 = basicBlockList;
        BasicBlockList basicBlockList3 = new BasicBlockList(size);
        BasicBlockList basicBlockList4 = basicBlockList2;
        for (int i3 = 0; i3 < size; i3++) {
            BasicBlock basicBlock = (BasicBlock) get0(i3);
            if (basicBlock != null) {
                basicBlockList4.set(i3, basicBlock.withRegisterOffset(i2));
            }
        }
        if (isImmutable()) {
            basicBlockList4.setImmutable();
        }
        return basicBlockList4;
    }
}
