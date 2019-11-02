package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Exceptions;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.FillArrayDataInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLiteralBits;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.TypedConstant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Zeroes;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaBasicBlock.Visitor;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.EscapeAnalysis */
public class EscapeAnalysis {
    private ArrayList<EscapeSet> latticeValues;
    private int regCount;
    /* access modifiers changed from: private */
    public SsaMethod ssaMeth;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.EscapeAnalysis$EscapeSet */
    static class EscapeSet {
        ArrayList<EscapeSet> childSets;
        EscapeState escape;
        ArrayList<EscapeSet> parentSets;
        BitSet regSet;
        boolean replaceableArray = false;

        EscapeSet(int i, int i2, EscapeState escapeState) {
            BitSet bitSet;
            ArrayList<EscapeSet> arrayList;
            ArrayList<EscapeSet> arrayList2;
            int i3 = i;
            EscapeState escapeState2 = escapeState;
            BitSet bitSet2 = bitSet;
            BitSet bitSet3 = new BitSet(i2);
            this.regSet = bitSet2;
            this.regSet.set(i3);
            this.escape = escapeState2;
            ArrayList<EscapeSet> arrayList3 = arrayList;
            ArrayList<EscapeSet> arrayList4 = new ArrayList<>();
            this.childSets = arrayList3;
            ArrayList<EscapeSet> arrayList5 = arrayList2;
            ArrayList<EscapeSet> arrayList6 = new ArrayList<>();
            this.parentSets = arrayList5;
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.EscapeAnalysis$EscapeState */
    public enum EscapeState {
    }

    private EscapeAnalysis(SsaMethod ssaMethod) {
        ArrayList<EscapeSet> arrayList;
        SsaMethod ssaMethod2 = ssaMethod;
        this.ssaMeth = ssaMethod2;
        this.regCount = ssaMethod2.getRegCount();
        ArrayList<EscapeSet> arrayList2 = arrayList;
        ArrayList<EscapeSet> arrayList3 = new ArrayList<>();
        this.latticeValues = arrayList2;
    }

    private void addEdge(EscapeSet escapeSet, EscapeSet escapeSet2) {
        EscapeSet escapeSet3 = escapeSet;
        EscapeSet escapeSet4 = escapeSet2;
        if (!escapeSet4.parentSets.contains(escapeSet3)) {
            boolean add = escapeSet4.parentSets.add(escapeSet3);
        }
        if (!escapeSet3.childSets.contains(escapeSet4)) {
            boolean add2 = escapeSet3.childSets.add(escapeSet4);
        }
    }

    private int findSetIndex(RegisterSpec registerSpec) {
        RegisterSpec registerSpec2 = registerSpec;
        int i = 0;
        while (i < this.latticeValues.size() && !((EscapeSet) this.latticeValues.get(i)).regSet.get(registerSpec2.getReg())) {
            i++;
        }
        return i;
    }

    private SsaInsn getInsnForMove(SsaInsn ssaInsn) {
        ArrayList insns = ((SsaBasicBlock) this.ssaMeth.getBlocks().get(ssaInsn.getBlock().getPredecessors().nextSetBit(0))).getInsns();
        return (SsaInsn) insns.get(-1 + insns.size());
    }

    private SsaInsn getMoveForInsn(SsaInsn ssaInsn) {
        return (SsaInsn) ((SsaBasicBlock) this.ssaMeth.getBlocks().get(ssaInsn.getBlock().getSuccessors().nextSetBit(0))).getInsns().get(0);
    }

    private void insertExceptionThrow(SsaInsn ssaInsn, RegisterSpec registerSpec, HashSet<SsaInsn> hashSet) {
        CstType cstType;
        CstMethodRef cstMethodRef;
        CstNat cstNat;
        CstString cstString;
        CstString cstString2;
        SsaInsn ssaInsn2 = ssaInsn;
        RegisterSpec registerSpec2 = registerSpec;
        HashSet<SsaInsn> hashSet2 = hashSet;
        CstType cstType2 = cstType;
        CstType cstType3 = new CstType(Exceptions.TYPE_ArrayIndexOutOfBoundsException);
        CstType cstType4 = cstType2;
        insertThrowingInsnBefore(ssaInsn2, RegisterSpecList.EMPTY, null, 40, cstType4);
        SsaBasicBlock block = ssaInsn2.getBlock();
        SsaBasicBlock insertNewSuccessor = block.insertNewSuccessor(block.getPrimarySuccessor());
        SsaInsn ssaInsn3 = (SsaInsn) insertNewSuccessor.getInsns().get(0);
        RegisterSpec make = RegisterSpec.make(this.ssaMeth.makeNewSsaReg(), cstType4);
        insertPlainInsnBefore(ssaInsn3, RegisterSpecList.EMPTY, make, 56, null);
        SsaBasicBlock insertNewSuccessor2 = insertNewSuccessor.insertNewSuccessor(insertNewSuccessor.getPrimarySuccessor());
        SsaInsn ssaInsn4 = (SsaInsn) insertNewSuccessor2.getInsns().get(0);
        CstMethodRef cstMethodRef2 = cstMethodRef;
        CstType cstType5 = cstType4;
        CstNat cstNat2 = cstNat;
        CstString cstString3 = cstString;
        CstString cstString4 = new CstString("<init>");
        CstString cstString5 = cstString2;
        CstString cstString6 = new CstString("(I)V");
        CstNat cstNat3 = new CstNat(cstString3, cstString5);
        CstMethodRef cstMethodRef3 = new CstMethodRef(cstType5, cstNat2);
        insertThrowingInsnBefore(ssaInsn4, RegisterSpecList.make(make, registerSpec2), null, 52, cstMethodRef2);
        boolean add = hashSet2.add(ssaInsn4);
        SsaBasicBlock insertNewSuccessor3 = insertNewSuccessor2.insertNewSuccessor(insertNewSuccessor2.getPrimarySuccessor());
        SsaInsn ssaInsn5 = (SsaInsn) insertNewSuccessor3.getInsns().get(0);
        insertThrowingInsnBefore(ssaInsn5, RegisterSpecList.make(make), null, 35, null);
        insertNewSuccessor3.replaceSuccessor(insertNewSuccessor3.getPrimarySuccessorIndex(), this.ssaMeth.getExitBlock().getIndex());
        boolean add2 = hashSet2.add(ssaInsn5);
    }

    /* JADX WARNING: type inference failed for: r18v0 */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r13v2, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn] */
    /* JADX WARNING: type inference failed for: r18v2 */
    /* JADX WARNING: type inference failed for: r11v17 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void insertPlainInsnBefore(net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn r20, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList r21, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec r22, int r23, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant r24) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r11 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn r11 = r11.getOriginalRopInsn()
            r6 = r11
            r11 = r4
            r12 = 56
            if (r11 != r12) goto L_0x0068
            r11 = r3
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r11 = r11.getType()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r11 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.opMoveResultPseudo(r11)
            r7 = r11
        L_0x0021:
            r11 = r5
            if (r11 != 0) goto L_0x0072
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r11 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r18 = r11
            r11 = r18
            r12 = r18
            r13 = r7
            r14 = r6
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition r14 = r14.getPosition()
            r15 = r3
            r16 = r2
            r12.<init>(r13, r14, r15, r16)
            r8 = r11
        L_0x0039:
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.NormalSsaInsn r11 = new net.zhuoweizhang.boardwalk.com.android.dx.ssa.NormalSsaInsn
            r18 = r11
            r11 = r18
            r12 = r18
            r13 = r8
            r14 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock r14 = r14.getBlock()
            r12.<init>(r13, r14)
            r9 = r11
            r11 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock r11 = r11.getBlock()
            java.util.ArrayList r11 = r11.getInsns()
            r10 = r11
            r11 = r10
            r12 = r10
            r13 = r1
            int r12 = r12.lastIndexOf(r13)
            r13 = r9
            r11.add(r12, r13)
            r11 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaMethod r11 = r11.ssaMeth
            r12 = r9
            r11.onInsnAdded(r12)
            return
        L_0x0068:
            r11 = r4
            r12 = r3
            r13 = r2
            r14 = r5
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r11 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.ropFor(r11, r12, r13, r14)
            r7 = r11
            goto L_0x0021
        L_0x0072:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainCstInsn r11 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainCstInsn
            r18 = r11
            r11 = r18
            r12 = r18
            r13 = r7
            r14 = r6
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition r14 = r14.getPosition()
            r15 = r3
            r16 = r2
            r17 = r5
            r12.<init>(r13, r14, r15, r16, r17)
            r8 = r11
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.EscapeAnalysis.insertPlainInsnBefore(net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaInsn, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec, int, net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant):void");
    }

    /* JADX WARNING: type inference failed for: r18v0 */
    /* JADX WARNING: type inference failed for: r11v6 */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r13v2, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn] */
    /* JADX WARNING: type inference failed for: r18v2 */
    /* JADX WARNING: type inference failed for: r11v16 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void insertThrowingInsnBefore(net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn r20, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList r21, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec r22, int r23, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant r24) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r11 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn r11 = r11.getOriginalRopInsn()
            r6 = r11
            r11 = r4
            r12 = r3
            r13 = r2
            r14 = r5
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r11 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.ropFor(r11, r12, r13, r14)
            r7 = r11
            r11 = r5
            if (r11 != 0) goto L_0x0062
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingInsn r11 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingInsn
            r18 = r11
            r11 = r18
            r12 = r18
            r13 = r7
            r14 = r6
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition r14 = r14.getPosition()
            r15 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.StdTypeList r16 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList.EMPTY
            r12.<init>(r13, r14, r15, r16)
            r8 = r11
        L_0x0033:
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.NormalSsaInsn r11 = new net.zhuoweizhang.boardwalk.com.android.dx.ssa.NormalSsaInsn
            r18 = r11
            r11 = r18
            r12 = r18
            r13 = r8
            r14 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock r14 = r14.getBlock()
            r12.<init>(r13, r14)
            r9 = r11
            r11 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock r11 = r11.getBlock()
            java.util.ArrayList r11 = r11.getInsns()
            r10 = r11
            r11 = r10
            r12 = r10
            r13 = r1
            int r12 = r12.lastIndexOf(r13)
            r13 = r9
            r11.add(r12, r13)
            r11 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaMethod r11 = r11.ssaMeth
            r12 = r9
            r11.onInsnAdded(r12)
            return
        L_0x0062:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingCstInsn r11 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingCstInsn
            r18 = r11
            r11 = r18
            r12 = r18
            r13 = r7
            r14 = r6
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition r14 = r14.getPosition()
            r15 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.StdTypeList r16 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList.EMPTY
            r17 = r5
            r12.<init>(r13, r14, r15, r16, r17)
            r8 = r11
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.EscapeAnalysis.insertThrowingInsnBefore(net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaInsn, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec, int, net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant):void");
    }

    private void movePropagate() {
        C07171 r13;
        for (int i = 0; i < this.ssaMeth.getRegCount(); i++) {
            SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i);
            if (!(definitionForRegister == null || definitionForRegister.getOpcode() == null || definitionForRegister.getOpcode().getOpcode() != 2)) {
                ArrayList[] useListCopy = this.ssaMeth.getUseListCopy();
                RegisterSpec registerSpec = definitionForRegister.getSources().get(0);
                RegisterSpec result = definitionForRegister.getResult();
                if (registerSpec.getReg() >= this.regCount || result.getReg() >= this.regCount) {
                    C07171 r8 = r13;
                    final RegisterSpec registerSpec2 = result;
                    final RegisterSpec registerSpec3 = registerSpec;
                    C07171 r9 = new RegisterMapper(this) {
                        final /* synthetic */ EscapeAnalysis this$0;

                        {
                            RegisterSpec registerSpec = r8;
                            RegisterSpec registerSpec2 = r9;
                            this.this$0 = r7;
                        }

                        public int getNewRegisterCount() {
                            return this.this$0.ssaMeth.getRegCount();
                        }

                        public RegisterSpec map(RegisterSpec registerSpec) {
                            RegisterSpec registerSpec2 = registerSpec;
                            if (registerSpec2.getReg() == registerSpec2.getReg()) {
                                registerSpec2 = registerSpec3;
                            }
                            return registerSpec2;
                        }
                    };
                    C07171 r6 = r8;
                    Iterator it = useListCopy[result.getReg()].iterator();
                    while (it.hasNext()) {
                        ((SsaInsn) it.next()).mapSourceRegisters(r6);
                    }
                }
            }
        }
    }

    public static void process(SsaMethod ssaMethod) {
        EscapeAnalysis escapeAnalysis;
        EscapeAnalysis escapeAnalysis2 = escapeAnalysis;
        EscapeAnalysis escapeAnalysis3 = new EscapeAnalysis(ssaMethod);
        escapeAnalysis2.run();
    }

    /* access modifiers changed from: private */
    public void processInsn(SsaInsn ssaInsn) {
        EscapeSet escapeSet;
        EscapeSet escapeSet2;
        SsaInsn ssaInsn2 = ssaInsn;
        int opcode = ssaInsn2.getOpcode().getOpcode();
        RegisterSpec result = ssaInsn2.getResult();
        if (opcode == 56 && result.getTypeBearer().getBasicType() == 9) {
            processRegister(result, processMoveResultPseudoInsn(ssaInsn2));
        } else if (opcode == 3 && result.getTypeBearer().getBasicType() == 9) {
            EscapeSet escapeSet3 = escapeSet2;
            EscapeSet escapeSet4 = new EscapeSet(result.getReg(), this.regCount, EscapeState.NONE);
            EscapeSet escapeSet5 = escapeSet3;
            boolean add = this.latticeValues.add(escapeSet5);
            processRegister(result, escapeSet5);
        } else if (opcode == 55 && result.getTypeBearer().getBasicType() == 9) {
            EscapeSet escapeSet6 = escapeSet;
            EscapeSet escapeSet7 = new EscapeSet(result.getReg(), this.regCount, EscapeState.NONE);
            EscapeSet escapeSet8 = escapeSet6;
            boolean add2 = this.latticeValues.add(escapeSet8);
            processRegister(result, escapeSet8);
        }
    }

    private EscapeSet processMoveResultPseudoInsn(SsaInsn ssaInsn) {
        EscapeSet escapeSet;
        EscapeSet escapeSet2;
        EscapeSet escapeSet3;
        EscapeSet escapeSet4;
        EscapeSet escapeSet5;
        EscapeSet escapeSet6;
        EscapeSet escapeSet7;
        SsaInsn ssaInsn2 = ssaInsn;
        RegisterSpec result = ssaInsn2.getResult();
        SsaInsn insnForMove = getInsnForMove(ssaInsn2);
        switch (insnForMove.getOpcode().getOpcode()) {
            case 5:
            case 40:
                EscapeSet escapeSet8 = escapeSet7;
                EscapeSet escapeSet9 = new EscapeSet(result.getReg(), this.regCount, EscapeState.NONE);
                escapeSet2 = escapeSet8;
                break;
            case 38:
            case 43:
            case 45:
                RegisterSpec registerSpec = insnForMove.getSources().get(0);
                int findSetIndex = findSetIndex(registerSpec);
                if (findSetIndex == this.latticeValues.size()) {
                    if (registerSpec.getType() != Type.KNOWN_NULL) {
                        EscapeSet escapeSet10 = escapeSet;
                        EscapeSet escapeSet11 = new EscapeSet(result.getReg(), this.regCount, EscapeState.GLOBAL);
                        escapeSet2 = escapeSet10;
                        break;
                    } else {
                        EscapeSet escapeSet12 = escapeSet3;
                        EscapeSet escapeSet13 = new EscapeSet(result.getReg(), this.regCount, EscapeState.NONE);
                        escapeSet2 = escapeSet12;
                        break;
                    }
                } else {
                    EscapeSet escapeSet14 = (EscapeSet) this.latticeValues.get(findSetIndex);
                    escapeSet14.regSet.set(result.getReg());
                    return escapeSet14;
                }
            case 41:
            case 42:
                if (!insnForMove.getSources().get(0).getTypeBearer().isConstant()) {
                    EscapeSet escapeSet15 = escapeSet5;
                    EscapeSet escapeSet16 = new EscapeSet(result.getReg(), this.regCount, EscapeState.GLOBAL);
                    escapeSet2 = escapeSet15;
                    break;
                } else {
                    EscapeSet escapeSet17 = escapeSet6;
                    EscapeSet escapeSet18 = new EscapeSet(result.getReg(), this.regCount, EscapeState.NONE);
                    escapeSet2 = escapeSet17;
                    escapeSet2.replaceableArray = true;
                    break;
                }
            case 46:
                EscapeSet escapeSet19 = escapeSet4;
                EscapeSet escapeSet20 = new EscapeSet(result.getReg(), this.regCount, EscapeState.GLOBAL);
                escapeSet2 = escapeSet19;
                break;
            default:
                return null;
        }
        boolean add = this.latticeValues.add(escapeSet2);
        return escapeSet2;
    }

    private void processPhiUse(SsaInsn ssaInsn, EscapeSet escapeSet, ArrayList<RegisterSpec> arrayList) {
        SsaInsn ssaInsn2 = ssaInsn;
        EscapeSet escapeSet2 = escapeSet;
        ArrayList<RegisterSpec> arrayList2 = arrayList;
        int findSetIndex = findSetIndex(ssaInsn2.getResult());
        if (findSetIndex != this.latticeValues.size()) {
            EscapeSet escapeSet3 = (EscapeSet) this.latticeValues.get(findSetIndex);
            if (escapeSet3 != escapeSet2) {
                escapeSet2.replaceableArray = false;
                escapeSet2.regSet.or(escapeSet3.regSet);
                if (escapeSet2.escape.compareTo(escapeSet3.escape) < 0) {
                    escapeSet2.escape = escapeSet3.escape;
                }
                replaceNode(escapeSet2, escapeSet3);
                Object remove = this.latticeValues.remove(findSetIndex);
                return;
            }
            return;
        }
        escapeSet2.regSet.set(ssaInsn2.getResult().getReg());
        boolean add = arrayList2.add(ssaInsn2.getResult());
    }

    private void processRegister(RegisterSpec registerSpec, EscapeSet escapeSet) {
        ArrayList arrayList;
        RegisterSpec registerSpec2 = registerSpec;
        EscapeSet escapeSet2 = escapeSet;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        boolean add = arrayList4.add(registerSpec2);
        while (!arrayList4.isEmpty()) {
            RegisterSpec registerSpec3 = (RegisterSpec) arrayList4.remove(-1 + arrayList4.size());
            for (SsaInsn ssaInsn : this.ssaMeth.getUseListForRegister(registerSpec3.getReg())) {
                if (ssaInsn.getOpcode() == null) {
                    processPhiUse(ssaInsn, escapeSet2, arrayList4);
                } else {
                    processUse(registerSpec3, ssaInsn, escapeSet2, arrayList4);
                }
            }
        }
    }

    private void processUse(RegisterSpec registerSpec, SsaInsn ssaInsn, EscapeSet escapeSet, ArrayList<RegisterSpec> arrayList) {
        RegisterSpec registerSpec2 = registerSpec;
        SsaInsn ssaInsn2 = ssaInsn;
        EscapeSet escapeSet2 = escapeSet;
        ArrayList<RegisterSpec> arrayList2 = arrayList;
        switch (ssaInsn2.getOpcode().getOpcode()) {
            case 2:
                escapeSet2.regSet.set(ssaInsn2.getResult().getReg());
                boolean add = arrayList2.add(ssaInsn2.getResult());
                return;
            case 7:
            case 8:
            case 43:
                if (escapeSet2.escape.compareTo(EscapeState.METHOD) < 0) {
                    escapeSet2.escape = EscapeState.METHOD;
                    return;
                }
                return;
            case 33:
            case 35:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
                escapeSet2.escape = EscapeState.INTER;
                return;
            case 38:
                if (!ssaInsn2.getSources().get(1).getTypeBearer().isConstant()) {
                    escapeSet2.replaceableArray = false;
                    return;
                }
                return;
            case 39:
                if (!ssaInsn2.getSources().get(2).getTypeBearer().isConstant()) {
                    escapeSet2.replaceableArray = false;
                    break;
                }
                break;
            case 47:
                break;
            case 48:
                escapeSet2.escape = EscapeState.GLOBAL;
                return;
            default:
                return;
        }
        if (ssaInsn2.getSources().get(0).getTypeBearer().getBasicType() == 9) {
            escapeSet2.replaceableArray = false;
            RegisterSpecList sources = ssaInsn2.getSources();
            if (sources.get(0).getReg() == registerSpec2.getReg()) {
                int findSetIndex = findSetIndex(sources.get(1));
                if (findSetIndex != this.latticeValues.size()) {
                    EscapeSet escapeSet3 = (EscapeSet) this.latticeValues.get(findSetIndex);
                    addEdge(escapeSet3, escapeSet2);
                    if (escapeSet2.escape.compareTo(escapeSet3.escape) < 0) {
                        escapeSet2.escape = escapeSet3.escape;
                        return;
                    }
                    return;
                }
                return;
            }
            int findSetIndex2 = findSetIndex(sources.get(0));
            if (findSetIndex2 != this.latticeValues.size()) {
                EscapeSet escapeSet4 = (EscapeSet) this.latticeValues.get(findSetIndex2);
                addEdge(escapeSet2, escapeSet4);
                if (escapeSet4.escape.compareTo(escapeSet2.escape) < 0) {
                    escapeSet4.escape = escapeSet2.escape;
                }
            }
        }
    }

    private void replaceDef(SsaInsn ssaInsn, SsaInsn ssaInsn2, int i, ArrayList<RegisterSpec> arrayList) {
        SsaInsn ssaInsn3 = ssaInsn;
        SsaInsn ssaInsn4 = ssaInsn2;
        int i2 = i;
        ArrayList<RegisterSpec> arrayList2 = arrayList;
        Type type = ssaInsn3.getResult().getType();
        for (int i3 = 0; i3 < i2; i3++) {
            Constant zeroFor = Zeroes.zeroFor(type.getComponentType());
            RegisterSpec make = RegisterSpec.make(this.ssaMeth.makeNewSsaReg(), (TypedConstant) zeroFor);
            boolean add = arrayList2.add(make);
            insertPlainInsnBefore(ssaInsn3, RegisterSpecList.EMPTY, make, 5, zeroFor);
        }
    }

    private void replaceNode(EscapeSet escapeSet, EscapeSet escapeSet2) {
        EscapeSet escapeSet3 = escapeSet;
        EscapeSet escapeSet4 = escapeSet2;
        Iterator it = escapeSet4.parentSets.iterator();
        while (it.hasNext()) {
            EscapeSet escapeSet5 = (EscapeSet) it.next();
            boolean remove = escapeSet5.childSets.remove(escapeSet4);
            boolean add = escapeSet5.childSets.add(escapeSet3);
            boolean add2 = escapeSet3.parentSets.add(escapeSet5);
        }
        Iterator it2 = escapeSet4.childSets.iterator();
        while (it2.hasNext()) {
            EscapeSet escapeSet6 = (EscapeSet) it2.next();
            boolean remove2 = escapeSet6.parentSets.remove(escapeSet4);
            boolean add3 = escapeSet6.parentSets.add(escapeSet3);
            boolean add4 = escapeSet3.childSets.add(escapeSet6);
        }
    }

    private void replaceUse(SsaInsn ssaInsn, SsaInsn ssaInsn2, ArrayList<RegisterSpec> arrayList, HashSet<SsaInsn> hashSet) {
        SsaInsn ssaInsn3 = ssaInsn;
        SsaInsn ssaInsn4 = ssaInsn2;
        ArrayList<RegisterSpec> arrayList2 = arrayList;
        HashSet<SsaInsn> hashSet2 = hashSet;
        int size = arrayList2.size();
        switch (ssaInsn3.getOpcode().getOpcode()) {
            case 34:
                TypeBearer typeBearer = ssaInsn4.getSources().get(0).getTypeBearer();
                SsaInsn moveForInsn = getMoveForInsn(ssaInsn3);
                insertPlainInsnBefore(moveForInsn, RegisterSpecList.EMPTY, moveForInsn.getResult(), 5, (Constant) typeBearer);
                boolean add = hashSet2.add(moveForInsn);
                return;
            case 38:
                SsaInsn moveForInsn2 = getMoveForInsn(ssaInsn3);
                RegisterSpecList sources = ssaInsn3.getSources();
                int intBits = ((CstLiteralBits) sources.get(1).getTypeBearer()).getIntBits();
                if (intBits < size) {
                    RegisterSpec registerSpec = (RegisterSpec) arrayList2.get(intBits);
                    insertPlainInsnBefore(moveForInsn2, RegisterSpecList.make(registerSpec), registerSpec.withReg(moveForInsn2.getResult().getReg()), 2, null);
                } else {
                    insertExceptionThrow(moveForInsn2, sources.get(1), hashSet2);
                    boolean add2 = hashSet2.add(moveForInsn2.getBlock().getInsns().get(2));
                }
                boolean add3 = hashSet2.add(moveForInsn2);
                return;
            case 39:
                RegisterSpecList sources2 = ssaInsn3.getSources();
                int intBits2 = ((CstLiteralBits) sources2.get(2).getTypeBearer()).getIntBits();
                if (intBits2 < size) {
                    RegisterSpec registerSpec2 = sources2.get(0);
                    RegisterSpec withReg = registerSpec2.withReg(((RegisterSpec) arrayList2.get(intBits2)).getReg());
                    insertPlainInsnBefore(ssaInsn3, RegisterSpecList.make(registerSpec2), withReg, 2, null);
                    Object obj = arrayList2.set(intBits2, withReg.withSimpleType());
                    return;
                }
                insertExceptionThrow(ssaInsn3, sources2.get(2), hashSet2);
                return;
            case 57:
                ArrayList initValues = ((FillArrayDataInsn) ssaInsn3.getOriginalRopInsn()).getInitValues();
                for (int i = 0; i < size; i++) {
                    RegisterSpec make = RegisterSpec.make(((RegisterSpec) arrayList2.get(i)).getReg(), (TypeBearer) initValues.get(i));
                    insertPlainInsnBefore(ssaInsn3, RegisterSpecList.EMPTY, make, 5, (Constant) initValues.get(i));
                    Object obj2 = arrayList2.set(i, make);
                }
                return;
            default:
                return;
        }
    }

    private void run() {
        C07182 r9;
        SsaMethod ssaMethod = this.ssaMeth;
        C07182 r6 = r9;
        C07182 r7 = new Visitor(this) {
            final /* synthetic */ EscapeAnalysis this$0;

            {
                this.this$0 = r5;
            }

            public void visitBlock(SsaBasicBlock ssaBasicBlock, SsaBasicBlock ssaBasicBlock2) {
                C07191 r7;
                SsaBasicBlock ssaBasicBlock3 = ssaBasicBlock2;
                SsaBasicBlock ssaBasicBlock4 = ssaBasicBlock;
                C07191 r4 = r7;
                C07191 r5 = new SsaInsn.Visitor(this) {
                    final /* synthetic */ C07182 this$1;

                    {
                        this.this$1 = r5;
                    }

                    public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
                    }

                    public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
                        NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
                        this.this$1.this$0.processInsn(normalSsaInsn2);
                    }

                    public void visitPhiInsn(PhiInsn phiInsn) {
                    }
                };
                ssaBasicBlock4.forEachInsn(r4);
            }
        };
        ssaMethod.forEachBlockDepthFirstDom(r6);
        Iterator it = this.latticeValues.iterator();
        while (it.hasNext()) {
            EscapeSet escapeSet = (EscapeSet) it.next();
            if (escapeSet.escape != EscapeState.NONE) {
                Iterator it2 = escapeSet.childSets.iterator();
                while (it2.hasNext()) {
                    EscapeSet escapeSet2 = (EscapeSet) it2.next();
                    if (escapeSet.escape.compareTo(escapeSet2.escape) > 0) {
                        escapeSet2.escape = escapeSet.escape;
                    }
                }
            }
        }
        scalarReplacement();
    }

    private void scalarReplacement() {
        ArrayList arrayList;
        HashSet hashSet;
        Iterator it = this.latticeValues.iterator();
        while (it.hasNext()) {
            EscapeSet escapeSet = (EscapeSet) it.next();
            if (escapeSet.replaceableArray && escapeSet.escape == EscapeState.NONE) {
                int nextSetBit = escapeSet.regSet.nextSetBit(0);
                SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(nextSetBit);
                SsaInsn insnForMove = getInsnForMove(definitionForRegister);
                int intBits = ((CstLiteralBits) insnForMove.getSources().get(0).getTypeBearer()).getIntBits();
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(intBits);
                ArrayList arrayList4 = arrayList2;
                HashSet hashSet2 = hashSet;
                HashSet hashSet3 = new HashSet();
                HashSet hashSet4 = hashSet2;
                replaceDef(definitionForRegister, insnForMove, intBits, arrayList4);
                boolean add = hashSet4.add(insnForMove);
                boolean add2 = hashSet4.add(definitionForRegister);
                for (SsaInsn ssaInsn : this.ssaMeth.getUseListForRegister(nextSetBit)) {
                    replaceUse(ssaInsn, insnForMove, arrayList4, hashSet4);
                    boolean add3 = hashSet4.add(ssaInsn);
                }
                this.ssaMeth.deleteInsns(hashSet4);
                this.ssaMeth.onInsnsChanged();
                SsaConverter.updateSsaMethod(this.ssaMeth, this.regCount);
                movePropagate();
            }
        }
    }
}
