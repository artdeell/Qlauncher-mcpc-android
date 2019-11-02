package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.DexOptions;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlockList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.FillArrayDataInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn.BaseVisitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.LocalVariableInfo;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.PlainCstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.PlainInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SwitchInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.ThrowingCstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.ThrowingInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Bits;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.RopTranslator */
public final class RopTranslator {
    /* access modifiers changed from: private */
    public final BlockAddresses addresses;
    private final DexOptions dexOptions;
    private final LocalVariableInfo locals;
    /* access modifiers changed from: private */
    public final RopMethod method;
    private int[] order = null;
    private final OutputCollector output;
    /* access modifiers changed from: private */
    public final int paramSize;
    /* access modifiers changed from: private */
    public boolean paramsAreInOrder;
    private final int positionInfo;
    /* access modifiers changed from: private */
    public final int regCount;
    private final TranslationVisitor translationVisitor;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.RopTranslator$LocalVariableAwareTranslationVisitor */
    private class LocalVariableAwareTranslationVisitor extends TranslationVisitor {
        private LocalVariableInfo locals;
        final /* synthetic */ RopTranslator this$0;

        public LocalVariableAwareTranslationVisitor(RopTranslator ropTranslator, OutputCollector outputCollector, LocalVariableInfo localVariableInfo) {
            RopTranslator ropTranslator2 = ropTranslator;
            OutputCollector outputCollector2 = outputCollector;
            LocalVariableInfo localVariableInfo2 = localVariableInfo;
            this.this$0 = ropTranslator2;
            super(ropTranslator2, outputCollector2);
            this.locals = localVariableInfo2;
        }

        public void addIntroductionIfNecessary(Insn insn) {
            LocalStart localStart;
            Insn insn2 = insn;
            RegisterSpec assignment = this.locals.getAssignment(insn2);
            if (assignment != null) {
                LocalStart localStart2 = localStart;
                LocalStart localStart3 = new LocalStart(insn2.getPosition(), assignment);
                addOutput(localStart2);
            }
        }

        public void visitPlainCstInsn(PlainCstInsn plainCstInsn) {
            PlainCstInsn plainCstInsn2 = plainCstInsn;
            super.visitPlainCstInsn(plainCstInsn2);
            addIntroductionIfNecessary(plainCstInsn2);
        }

        public void visitPlainInsn(PlainInsn plainInsn) {
            PlainInsn plainInsn2 = plainInsn;
            super.visitPlainInsn(plainInsn2);
            addIntroductionIfNecessary(plainInsn2);
        }

        public void visitSwitchInsn(SwitchInsn switchInsn) {
            SwitchInsn switchInsn2 = switchInsn;
            super.visitSwitchInsn(switchInsn2);
            addIntroductionIfNecessary(switchInsn2);
        }

        public void visitThrowingCstInsn(ThrowingCstInsn throwingCstInsn) {
            ThrowingCstInsn throwingCstInsn2 = throwingCstInsn;
            super.visitThrowingCstInsn(throwingCstInsn2);
            addIntroductionIfNecessary(throwingCstInsn2);
        }

        public void visitThrowingInsn(ThrowingInsn throwingInsn) {
            ThrowingInsn throwingInsn2 = throwingInsn;
            super.visitThrowingInsn(throwingInsn2);
            addIntroductionIfNecessary(throwingInsn2);
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.RopTranslator$TranslationVisitor */
    private class TranslationVisitor implements Visitor {
        private BasicBlock block;
        private CodeAddress lastAddress;
        private final OutputCollector output;
        final /* synthetic */ RopTranslator this$0;

        public TranslationVisitor(RopTranslator ropTranslator, OutputCollector outputCollector) {
            OutputCollector outputCollector2 = outputCollector;
            this.this$0 = ropTranslator;
            this.output = outputCollector2;
        }

        private RegisterSpec getNextMoveResultPseudo() {
            int primarySuccessor = this.block.getPrimarySuccessor();
            if (primarySuccessor >= 0) {
                Insn insn = this.this$0.method.getBlocks().labelToBlock(primarySuccessor).getInsns().get(0);
                if (insn.getOpcode().getOpcode() == 56) {
                    return insn.getResult();
                }
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void addOutput(DalvInsn dalvInsn) {
            DalvInsn dalvInsn2 = dalvInsn;
            this.output.add(dalvInsn2);
        }

        /* access modifiers changed from: protected */
        public void addOutputSuffix(DalvInsn dalvInsn) {
            DalvInsn dalvInsn2 = dalvInsn;
            this.output.addSuffix(dalvInsn2);
        }

        public void setBlock(BasicBlock basicBlock, CodeAddress codeAddress) {
            CodeAddress codeAddress2 = codeAddress;
            this.block = basicBlock;
            this.lastAddress = codeAddress2;
        }

        public void visitFillArrayDataInsn(FillArrayDataInsn fillArrayDataInsn) {
            CodeAddress codeAddress;
            ArrayData arrayData;
            TargetInsn targetInsn;
            OddSpacer oddSpacer;
            RuntimeException runtimeException;
            FillArrayDataInsn fillArrayDataInsn2 = fillArrayDataInsn;
            SourcePosition position = fillArrayDataInsn2.getPosition();
            Constant constant = fillArrayDataInsn2.getConstant();
            ArrayList initValues = fillArrayDataInsn2.getInitValues();
            if (fillArrayDataInsn2.getOpcode().getBranchingness() != 1) {
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("shouldn't happen");
                throw runtimeException2;
            }
            CodeAddress codeAddress2 = codeAddress;
            CodeAddress codeAddress3 = new CodeAddress(position);
            CodeAddress codeAddress4 = codeAddress2;
            ArrayData arrayData2 = arrayData;
            ArrayData arrayData3 = new ArrayData(position, this.lastAddress, initValues, constant);
            ArrayData arrayData4 = arrayData2;
            TargetInsn targetInsn2 = targetInsn;
            TargetInsn targetInsn3 = new TargetInsn(Dops.FILL_ARRAY_DATA, position, RopTranslator.getRegs(fillArrayDataInsn2), codeAddress4);
            TargetInsn targetInsn4 = targetInsn2;
            addOutput(this.lastAddress);
            addOutput(targetInsn4);
            OddSpacer oddSpacer2 = oddSpacer;
            OddSpacer oddSpacer3 = new OddSpacer(position);
            addOutputSuffix(oddSpacer2);
            addOutputSuffix(codeAddress4);
            addOutputSuffix(arrayData4);
        }

        public void visitPlainCstInsn(PlainCstInsn plainCstInsn) {
            CstInsn cstInsn;
            SimpleInsn simpleInsn;
            RuntimeException runtimeException;
            PlainCstInsn plainCstInsn2 = plainCstInsn;
            SourcePosition position = plainCstInsn2.getPosition();
            Dop dopFor = RopToDop.dopFor(plainCstInsn2);
            Rop opcode = plainCstInsn2.getOpcode();
            int opcode2 = opcode.getOpcode();
            if (opcode.getBranchingness() != 1) {
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("shouldn't happen");
                throw runtimeException2;
            } else if (opcode2 != 3) {
                CstInsn cstInsn2 = cstInsn;
                CstInsn cstInsn3 = new CstInsn(dopFor, position, RopTranslator.getRegs(plainCstInsn2), plainCstInsn2.getConstant());
                addOutput(cstInsn2);
            } else if (!this.this$0.paramsAreInOrder) {
                RegisterSpec result = plainCstInsn2.getResult();
                SimpleInsn simpleInsn2 = simpleInsn;
                SimpleInsn simpleInsn3 = new SimpleInsn(dopFor, position, RegisterSpecList.make(result, RegisterSpec.make(((CstInteger) plainCstInsn2.getConstant()).getValue() + (this.this$0.regCount - this.this$0.paramSize), result.getType())));
                addOutput(simpleInsn2);
            }
        }

        /* JADX WARNING: type inference failed for: r14v0 */
        /* JADX WARNING: type inference failed for: r7v17 */
        /* JADX WARNING: type inference failed for: r6v0 */
        /* JADX WARNING: type inference failed for: r6v1 */
        /* JADX WARNING: type inference failed for: r8v4, types: [net.zhuoweizhang.boardwalk.com.android.dx.dex.code.DalvInsn] */
        /* JADX WARNING: type inference failed for: r14v1 */
        /* JADX WARNING: type inference failed for: r7v20 */
        /* JADX WARNING: type inference failed for: r6v2 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 6 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void visitPlainInsn(net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.PlainInsn r16) {
            /*
                r15 = this;
                r0 = r15
                r1 = r16
                r7 = r1
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r7 = r7.getOpcode()
                r2 = r7
                r7 = r2
                int r7 = r7.getOpcode()
                r8 = 54
                if (r7 != r8) goto L_0x0013
            L_0x0012:
                return
            L_0x0013:
                r7 = r2
                int r7 = r7.getOpcode()
                r8 = 56
                if (r7 == r8) goto L_0x0012
                r7 = r1
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition r7 = r7.getPosition()
                r3 = r7
                r7 = r1
                net.zhuoweizhang.boardwalk.com.android.dx.dex.code.Dop r7 = net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.RopToDop.dopFor(r7)
                r4 = r7
                r7 = r2
                int r7 = r7.getBranchingness()
                switch(r7) {
                    case 1: goto L_0x003b;
                    case 2: goto L_0x003b;
                    case 3: goto L_0x0012;
                    case 4: goto L_0x0051;
                    case 5: goto L_0x0030;
                    case 6: goto L_0x003b;
                    default: goto L_0x0030;
                }
            L_0x0030:
                java.lang.RuntimeException r7 = new java.lang.RuntimeException
                r14 = r7
                r7 = r14
                r8 = r14
                java.lang.String r9 = "shouldn't happen"
                r8.<init>(r9)
                throw r7
            L_0x003b:
                net.zhuoweizhang.boardwalk.com.android.dx.dex.code.SimpleInsn r7 = new net.zhuoweizhang.boardwalk.com.android.dx.dex.code.SimpleInsn
                r14 = r7
                r7 = r14
                r8 = r14
                r9 = r4
                r10 = r3
                r11 = r1
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r11 = net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.RopTranslator.getRegs(r11)
                r8.<init>(r9, r10, r11)
                r6 = r7
            L_0x004b:
                r7 = r0
                r8 = r6
                r7.addOutput(r8)
                goto L_0x0012
            L_0x0051:
                r7 = r0
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.BasicBlock r7 = r7.block
                net.zhuoweizhang.boardwalk.com.android.dx.util.IntList r7 = r7.getSuccessors()
                r8 = 1
                int r7 = r7.get(r8)
                r5 = r7
                net.zhuoweizhang.boardwalk.com.android.dx.dex.code.TargetInsn r7 = new net.zhuoweizhang.boardwalk.com.android.dx.dex.code.TargetInsn
                r14 = r7
                r7 = r14
                r8 = r14
                r9 = r4
                r10 = r3
                r11 = r1
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r11 = net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.RopTranslator.getRegs(r11)
                r12 = r0
                net.zhuoweizhang.boardwalk.com.android.dx.dex.code.RopTranslator r12 = r12.this$0
                net.zhuoweizhang.boardwalk.com.android.dx.dex.code.BlockAddresses r12 = r12.addresses
                r13 = r5
                net.zhuoweizhang.boardwalk.com.android.dx.dex.code.CodeAddress r12 = r12.getStart(r13)
                r8.<init>(r9, r10, r11, r12)
                r6 = r7
                goto L_0x004b
            */
            throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.RopTranslator.TranslationVisitor.visitPlainInsn(net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn):void");
        }

        public void visitSwitchInsn(SwitchInsn switchInsn) {
            RuntimeException runtimeException;
            CodeAddress codeAddress;
            CodeAddress codeAddress2;
            SwitchData switchData;
            TargetInsn targetInsn;
            OddSpacer oddSpacer;
            SwitchInsn switchInsn2 = switchInsn;
            SourcePosition position = switchInsn2.getPosition();
            IntList cases = switchInsn2.getCases();
            IntList successors = this.block.getSuccessors();
            int size = cases.size();
            int size2 = successors.size();
            int primarySuccessor = this.block.getPrimarySuccessor();
            if (size == size2 - 1 && primarySuccessor == successors.get(size)) {
                CodeAddress[] codeAddressArr = new CodeAddress[size];
                for (int i = 0; i < size; i++) {
                    codeAddressArr[i] = this.this$0.addresses.getStart(successors.get(i));
                }
                CodeAddress codeAddress3 = codeAddress;
                CodeAddress codeAddress4 = new CodeAddress(position);
                CodeAddress codeAddress5 = codeAddress3;
                CodeAddress codeAddress6 = codeAddress2;
                CodeAddress codeAddress7 = new CodeAddress(this.lastAddress.getPosition(), true);
                CodeAddress codeAddress8 = codeAddress6;
                SwitchData switchData2 = switchData;
                SwitchData switchData3 = new SwitchData(position, codeAddress8, cases, codeAddressArr);
                SwitchData switchData4 = switchData2;
                TargetInsn targetInsn2 = targetInsn;
                TargetInsn targetInsn3 = new TargetInsn(switchData4.isPacked() ? Dops.PACKED_SWITCH : Dops.SPARSE_SWITCH, position, RopTranslator.getRegs(switchInsn2), codeAddress5);
                TargetInsn targetInsn4 = targetInsn2;
                addOutput(codeAddress8);
                addOutput(targetInsn4);
                OddSpacer oddSpacer2 = oddSpacer;
                OddSpacer oddSpacer3 = new OddSpacer(position);
                addOutputSuffix(oddSpacer2);
                addOutputSuffix(codeAddress5);
                addOutputSuffix(switchData4);
                return;
            }
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("shouldn't happen");
            throw runtimeException2;
        }

        /* JADX WARNING: type inference failed for: r18v0 */
        /* JADX WARNING: type inference failed for: r11v26 */
        /* JADX WARNING: type inference failed for: r10v0 */
        /* JADX WARNING: type inference failed for: r10v1 */
        /* JADX WARNING: type inference failed for: r12v7, types: [net.zhuoweizhang.boardwalk.com.android.dx.dex.code.DalvInsn] */
        /* JADX WARNING: type inference failed for: r18v1 */
        /* JADX WARNING: type inference failed for: r11v31 */
        /* JADX WARNING: type inference failed for: r10v2 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 6 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void visitThrowingCstInsn(net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.ThrowingCstInsn r20) {
            /*
                r19 = this;
                r0 = r19
                r1 = r20
                r11 = 1
                r2 = r11
                r11 = r1
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition r11 = r11.getPosition()
                r3 = r11
                r11 = r1
                net.zhuoweizhang.boardwalk.com.android.dx.dex.code.Dop r11 = net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.RopToDop.dopFor(r11)
                r4 = r11
                r11 = r1
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r11 = r11.getOpcode()
                r5 = r11
                r11 = r1
                net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r11 = r11.getConstant()
                r6 = r11
                r11 = r5
                int r11 = r11.getBranchingness()
                r12 = 6
                if (r11 == r12) goto L_0x0034
                java.lang.RuntimeException r11 = new java.lang.RuntimeException
                r18 = r11
                r11 = r18
                r12 = r18
                java.lang.String r13 = "shouldn't happen"
                r12.<init>(r13)
                throw r11
            L_0x0034:
                r11 = r0
                r12 = r0
                net.zhuoweizhang.boardwalk.com.android.dx.dex.code.CodeAddress r12 = r12.lastAddress
                r11.addOutput(r12)
                r11 = r5
                boolean r11 = r11.isCallLike()
                if (r11 == 0) goto L_0x005c
                r11 = r0
                net.zhuoweizhang.boardwalk.com.android.dx.dex.code.CstInsn r12 = new net.zhuoweizhang.boardwalk.com.android.dx.dex.code.CstInsn
                r18 = r12
                r12 = r18
                r13 = r18
                r14 = r4
                r15 = r3
                r16 = r1
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r16 = r16.getSources()
                r17 = r6
                r13.<init>(r14, r15, r16, r17)
                r11.addOutput(r12)
            L_0x005b:
                return
            L_0x005c:
                r11 = r0
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r11 = r11.getNextMoveResultPseudo()
                r7 = r11
                r11 = r1
                r12 = r7
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r11 = net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.RopTranslator.getRegs(r11, r12)
                r8 = r11
                r11 = r4
                boolean r11 = r11.hasResult()
                if (r11 != 0) goto L_0x0079
                r11 = r5
                int r11 = r11.getOpcode()
                r12 = 43
                if (r11 != r12) goto L_0x00a8
            L_0x0079:
                r11 = r2
                r9 = r11
            L_0x007b:
                r11 = r7
                if (r11 == 0) goto L_0x00ab
            L_0x007e:
                r11 = r9
                r12 = r2
                if (r11 == r12) goto L_0x00ae
                java.lang.RuntimeException r11 = new java.lang.RuntimeException
                r18 = r11
                r11 = r18
                r12 = r18
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r18 = r13
                r13 = r18
                r14 = r18
                r14.<init>()
                java.lang.String r14 = "Insn with result/move-result-pseudo mismatch "
                java.lang.StringBuilder r13 = r13.append(r14)
                r14 = r1
                java.lang.StringBuilder r13 = r13.append(r14)
                java.lang.String r13 = r13.toString()
                r12.<init>(r13)
                throw r11
            L_0x00a8:
                r11 = 0
                r9 = r11
                goto L_0x007b
            L_0x00ab:
                r11 = 0
                r2 = r11
                goto L_0x007e
            L_0x00ae:
                r11 = r5
                int r11 = r11.getOpcode()
                r12 = 41
                if (r11 != r12) goto L_0x00d5
                r11 = r4
                int r11 = r11.getOpcode()
                r12 = 35
                if (r11 == r12) goto L_0x00d5
                net.zhuoweizhang.boardwalk.com.android.dx.dex.code.SimpleInsn r11 = new net.zhuoweizhang.boardwalk.com.android.dx.dex.code.SimpleInsn
                r18 = r11
                r11 = r18
                r12 = r18
                r13 = r4
                r14 = r3
                r15 = r8
                r12.<init>(r13, r14, r15)
                r10 = r11
            L_0x00cf:
                r11 = r0
                r12 = r10
                r11.addOutput(r12)
                goto L_0x005b
            L_0x00d5:
                net.zhuoweizhang.boardwalk.com.android.dx.dex.code.CstInsn r11 = new net.zhuoweizhang.boardwalk.com.android.dx.dex.code.CstInsn
                r18 = r11
                r11 = r18
                r12 = r18
                r13 = r4
                r14 = r3
                r15 = r8
                r16 = r6
                r12.<init>(r13, r14, r15, r16)
                r10 = r11
                goto L_0x00cf
            */
            throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.RopTranslator.TranslationVisitor.visitThrowingCstInsn(net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingCstInsn):void");
        }

        public void visitThrowingInsn(ThrowingInsn throwingInsn) {
            SimpleInsn simpleInsn;
            RuntimeException runtimeException;
            StringBuilder sb;
            RuntimeException runtimeException2;
            ThrowingInsn throwingInsn2 = throwingInsn;
            SourcePosition position = throwingInsn2.getPosition();
            Dop dopFor = RopToDop.dopFor(throwingInsn2);
            if (throwingInsn2.getOpcode().getBranchingness() != 6) {
                RuntimeException runtimeException3 = runtimeException2;
                RuntimeException runtimeException4 = new RuntimeException("shouldn't happen");
                throw runtimeException3;
            }
            RegisterSpec nextMoveResultPseudo = getNextMoveResultPseudo();
            if (dopFor.hasResult() != (nextMoveResultPseudo != null)) {
                RuntimeException runtimeException5 = runtimeException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                RuntimeException runtimeException6 = new RuntimeException(sb2.append("Insn with result/move-result-pseudo mismatch").append(throwingInsn2).toString());
                throw runtimeException5;
            }
            addOutput(this.lastAddress);
            SimpleInsn simpleInsn2 = simpleInsn;
            SimpleInsn simpleInsn3 = new SimpleInsn(dopFor, position, RopTranslator.getRegs(throwingInsn2, nextMoveResultPseudo));
            addOutput(simpleInsn2);
        }
    }

    private RopTranslator(RopMethod ropMethod, int i, LocalVariableInfo localVariableInfo, int i2, DexOptions dexOptions2) {
        BlockAddresses blockAddresses;
        OutputCollector outputCollector;
        TranslationVisitor translationVisitor2;
        LocalVariableAwareTranslationVisitor localVariableAwareTranslationVisitor;
        RopMethod ropMethod2 = ropMethod;
        int i3 = i;
        LocalVariableInfo localVariableInfo2 = localVariableInfo;
        int i4 = i2;
        DexOptions dexOptions3 = dexOptions2;
        this.dexOptions = dexOptions3;
        this.method = ropMethod2;
        this.positionInfo = i3;
        this.locals = localVariableInfo2;
        BlockAddresses blockAddresses2 = blockAddresses;
        BlockAddresses blockAddresses3 = new BlockAddresses(ropMethod2);
        this.addresses = blockAddresses2;
        this.paramSize = i4;
        this.paramsAreInOrder = calculateParamsAreInOrder(ropMethod2, i4);
        BasicBlockList blocks = ropMethod2.getBlocks();
        int size = blocks.size();
        int instructionCount = (size * 3) + blocks.getInstructionCount();
        if (localVariableInfo2 != null) {
            instructionCount += size + localVariableInfo2.getAssignmentCount();
        }
        this.regCount = (this.paramsAreInOrder ? 0 : this.paramSize) + blocks.getRegCount();
        OutputCollector outputCollector2 = outputCollector;
        OutputCollector outputCollector3 = new OutputCollector(dexOptions3, instructionCount, size * 3, this.regCount);
        this.output = outputCollector2;
        if (localVariableInfo2 != null) {
            LocalVariableAwareTranslationVisitor localVariableAwareTranslationVisitor2 = localVariableAwareTranslationVisitor;
            LocalVariableAwareTranslationVisitor localVariableAwareTranslationVisitor3 = new LocalVariableAwareTranslationVisitor(this, this.output, localVariableInfo2);
            this.translationVisitor = localVariableAwareTranslationVisitor2;
            return;
        }
        TranslationVisitor translationVisitor3 = translationVisitor2;
        TranslationVisitor translationVisitor4 = new TranslationVisitor(this, this.output);
        this.translationVisitor = translationVisitor3;
    }

    private static boolean calculateParamsAreInOrder(RopMethod ropMethod, int i) {
        C06621 r10;
        RopMethod ropMethod2 = ropMethod;
        int i2 = i;
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = zArr;
        zArr[0] = true;
        boolean[] zArr3 = zArr2;
        int regCount2 = ropMethod2.getBlocks().getRegCount();
        BasicBlockList blocks = ropMethod2.getBlocks();
        C06621 r5 = r10;
        final boolean[] zArr4 = zArr3;
        final int i3 = regCount2;
        final int i4 = i2;
        C06621 r6 = new BaseVisitor() {
            {
                int i = r8;
                int i2 = r9;
            }

            public void visitPlainCstInsn(PlainCstInsn plainCstInsn) {
                PlainCstInsn plainCstInsn2 = plainCstInsn;
                if (plainCstInsn2.getOpcode().getOpcode() == 3) {
                    zArr4[0] = zArr4[0] && ((CstInteger) plainCstInsn2.getConstant()).getValue() + (i3 - i4) == plainCstInsn2.getResult().getReg();
                }
            }
        };
        blocks.forEachInsn(r5);
        return zArr3[0];
    }

    /* access modifiers changed from: private */
    public static RegisterSpecList getRegs(Insn insn) {
        Insn insn2 = insn;
        return getRegs(insn2, insn2.getResult());
    }

    /* access modifiers changed from: private */
    public static RegisterSpecList getRegs(Insn insn, RegisterSpec registerSpec) {
        Insn insn2 = insn;
        RegisterSpec registerSpec2 = registerSpec;
        RegisterSpecList sources = insn2.getSources();
        if (insn2.getOpcode().isCommutative() && sources.size() == 2 && registerSpec2.getReg() == sources.get(1).getReg()) {
            sources = RegisterSpecList.make(sources.get(1), sources.get(0));
        }
        return registerSpec2 == null ? sources : sources.withFirst(registerSpec2);
    }

    private void outputBlock(BasicBlock basicBlock, int i) {
        TargetInsn targetInsn;
        LocalSnapshot localSnapshot;
        BasicBlock basicBlock2 = basicBlock;
        int i2 = i;
        CodeAddress start = this.addresses.getStart(basicBlock2);
        this.output.add(start);
        if (this.locals != null) {
            RegisterSpecSet starts = this.locals.getStarts(basicBlock2);
            OutputCollector outputCollector = this.output;
            LocalSnapshot localSnapshot2 = localSnapshot;
            LocalSnapshot localSnapshot3 = new LocalSnapshot(start.getPosition(), starts);
            outputCollector.add(localSnapshot2);
        }
        this.translationVisitor.setBlock(basicBlock2, this.addresses.getLast(basicBlock2));
        basicBlock2.getInsns().forEach(this.translationVisitor);
        this.output.add(this.addresses.getEnd(basicBlock2));
        int primarySuccessor = basicBlock2.getPrimarySuccessor();
        Insn lastInsn = basicBlock2.getLastInsn();
        if (primarySuccessor >= 0 && primarySuccessor != i2) {
            if (lastInsn.getOpcode().getBranchingness() == 4 && basicBlock2.getSecondarySuccessor() == i2) {
                this.output.reverseBranch(1, this.addresses.getStart(primarySuccessor));
                return;
            }
            TargetInsn targetInsn2 = targetInsn;
            TargetInsn targetInsn3 = new TargetInsn(Dops.GOTO, lastInsn.getPosition(), RegisterSpecList.EMPTY, this.addresses.getStart(primarySuccessor));
            this.output.add(targetInsn2);
        }
    }

    private void outputInstructions() {
        BasicBlockList blocks = this.method.getBlocks();
        int[] iArr = this.order;
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i + 1;
            outputBlock(blocks.labelToBlock(iArr[i]), i2 == iArr.length ? -1 : iArr[i2]);
        }
    }

    private void pickOrder() {
        RuntimeException runtimeException;
        int i;
        BasicBlockList blocks = this.method.getBlocks();
        int size = blocks.size();
        int maxLabel = blocks.getMaxLabel();
        int[] makeBitSet = Bits.makeBitSet(maxLabel);
        int[] makeBitSet2 = Bits.makeBitSet(maxLabel);
        for (int i2 = 0; i2 < size; i2++) {
            Bits.set(makeBitSet, blocks.get(i2).getLabel());
        }
        int[] iArr = new int[size];
        int firstLabel = this.method.getFirstLabel();
        int i3 = 0;
        while (firstLabel != -1) {
            while (true) {
                IntList labelToPredecessors = this.method.labelToPredecessors(firstLabel);
                int size2 = labelToPredecessors.size();
                int i4 = 0;
                while (i4 < size2) {
                    int i5 = labelToPredecessors.get(i4);
                    if (Bits.get(makeBitSet2, i5)) {
                        break;
                    } else if (Bits.get(makeBitSet, i5) && blocks.labelToBlock(i5).getPrimarySuccessor() == firstLabel) {
                        Bits.set(makeBitSet2, i5);
                        firstLabel = i5;
                    } else {
                        i4++;
                    }
                }
                break;
            }
            int i6 = firstLabel;
            int i7 = i3;
            while (true) {
                i = i7;
                if (i6 == -1) {
                    break;
                }
                Bits.clear(makeBitSet, i6);
                Bits.clear(makeBitSet2, i6);
                iArr[i] = i6;
                int i8 = i + 1;
                BasicBlock labelToBlock = blocks.labelToBlock(i6);
                BasicBlock preferredSuccessorOf = blocks.preferredSuccessorOf(labelToBlock);
                if (preferredSuccessorOf == null) {
                    i = i8;
                    break;
                }
                int label = preferredSuccessorOf.getLabel();
                int primarySuccessor = labelToBlock.getPrimarySuccessor();
                if (!Bits.get(makeBitSet, label)) {
                    if (primarySuccessor == label || primarySuccessor < 0 || !Bits.get(makeBitSet, primarySuccessor)) {
                        IntList successors = labelToBlock.getSuccessors();
                        int size3 = successors.size();
                        int i9 = 0;
                        while (true) {
                            if (i9 >= size3) {
                                label = -1;
                                break;
                            }
                            label = successors.get(i9);
                            if (Bits.get(makeBitSet, label)) {
                                break;
                            }
                            i9++;
                        }
                    } else {
                        label = primarySuccessor;
                    }
                }
                i6 = label;
                i7 = i8;
            }
            i3 = i;
            firstLabel = Bits.findFirst(makeBitSet, 0);
        }
        if (i3 != size) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("shouldn't happen");
            throw runtimeException2;
        }
        this.order = iArr;
    }

    public static DalvCode translate(RopMethod ropMethod, int i, LocalVariableInfo localVariableInfo, int i2, DexOptions dexOptions2) {
        RopTranslator ropTranslator;
        RopTranslator ropTranslator2 = ropTranslator;
        RopTranslator ropTranslator3 = new RopTranslator(ropMethod, i, localVariableInfo, i2, dexOptions2);
        return ropTranslator2.translateAndGetResult();
    }

    private DalvCode translateAndGetResult() {
        StdCatchBuilder stdCatchBuilder;
        DalvCode dalvCode;
        pickOrder();
        outputInstructions();
        StdCatchBuilder stdCatchBuilder2 = stdCatchBuilder;
        StdCatchBuilder stdCatchBuilder3 = new StdCatchBuilder(this.method, this.order, this.addresses);
        StdCatchBuilder stdCatchBuilder4 = stdCatchBuilder2;
        DalvCode dalvCode2 = dalvCode;
        DalvCode dalvCode3 = new DalvCode(this.positionInfo, this.output.getFinisher(), stdCatchBuilder4);
        return dalvCode2;
    }
}
