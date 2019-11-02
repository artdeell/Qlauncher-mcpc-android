package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.CstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.PlainInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.TypedConstant;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.SCCP */
public class SCCP {
    private static final int CONSTANT = 1;
    private static final int TOP = 0;
    private static final int VARYING = 2;
    private ArrayList<SsaInsn> branchWorklist;
    private ArrayList<SsaBasicBlock> cfgPhiWorklist;
    private ArrayList<SsaBasicBlock> cfgWorklist;
    private BitSet executableBlocks;
    private Constant[] latticeConstants = new Constant[this.regCount];
    private int[] latticeValues = new int[this.regCount];
    private int regCount;
    private SsaMethod ssaMeth;
    private ArrayList<SsaInsn> ssaWorklist;
    private ArrayList<SsaInsn> varyingWorklist;

    private SCCP(SsaMethod ssaMethod) {
        ArrayList<SsaBasicBlock> arrayList;
        ArrayList<SsaBasicBlock> arrayList2;
        BitSet bitSet;
        ArrayList<SsaInsn> arrayList3;
        ArrayList<SsaInsn> arrayList4;
        ArrayList<SsaInsn> arrayList5;
        SsaMethod ssaMethod2 = ssaMethod;
        this.ssaMeth = ssaMethod2;
        this.regCount = ssaMethod2.getRegCount();
        ArrayList<SsaBasicBlock> arrayList6 = arrayList;
        ArrayList<SsaBasicBlock> arrayList7 = new ArrayList<>();
        this.cfgWorklist = arrayList6;
        ArrayList<SsaBasicBlock> arrayList8 = arrayList2;
        ArrayList<SsaBasicBlock> arrayList9 = new ArrayList<>();
        this.cfgPhiWorklist = arrayList8;
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(ssaMethod2.getBlocks().size());
        this.executableBlocks = bitSet2;
        ArrayList<SsaInsn> arrayList10 = arrayList3;
        ArrayList<SsaInsn> arrayList11 = new ArrayList<>();
        this.ssaWorklist = arrayList10;
        ArrayList<SsaInsn> arrayList12 = arrayList4;
        ArrayList<SsaInsn> arrayList13 = new ArrayList<>();
        this.varyingWorklist = arrayList12;
        ArrayList<SsaInsn> arrayList14 = arrayList5;
        ArrayList<SsaInsn> arrayList15 = new ArrayList<>();
        this.branchWorklist = arrayList14;
        for (int i = 0; i < this.regCount; i++) {
            this.latticeValues[i] = 0;
            this.latticeConstants[i] = null;
        }
    }

    private void addBlockToWorklist(SsaBasicBlock ssaBasicBlock) {
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        if (!this.executableBlocks.get(ssaBasicBlock2.getIndex())) {
            boolean add = this.cfgWorklist.add(ssaBasicBlock2);
            this.executableBlocks.set(ssaBasicBlock2.getIndex());
            return;
        }
        boolean add2 = this.cfgPhiWorklist.add(ssaBasicBlock2);
    }

    private void addUsersToWorklist(int i, int i2) {
        int i3 = i;
        if (i2 == 2) {
            for (SsaInsn add : this.ssaMeth.getUseListForRegister(i3)) {
                boolean add2 = this.varyingWorklist.add(add);
            }
            return;
        }
        for (SsaInsn add3 : this.ssaMeth.getUseListForRegister(i3)) {
            boolean add4 = this.ssaWorklist.add(add3);
        }
    }

    private static String latticeValName(int i) {
        switch (i) {
            case 0:
                return "TOP";
            case 1:
                return "CONSTANT";
            case 2:
                return "VARYING";
            default:
                return "UNKNOWN";
        }
    }

    public static void process(SsaMethod ssaMethod) {
        SCCP sccp;
        SCCP sccp2 = sccp;
        SCCP sccp3 = new SCCP(ssaMethod);
        sccp2.run();
    }

    private void replaceBranches() {
        int i;
        PlainInsn plainInsn;
        Iterator it = this.branchWorklist.iterator();
        while (it.hasNext()) {
            SsaInsn ssaInsn = (SsaInsn) it.next();
            SsaBasicBlock block = ssaInsn.getBlock();
            int size = block.getSuccessorList().size();
            int i2 = 0;
            int i3 = -1;
            while (true) {
                i = i3;
                if (i2 >= size) {
                    break;
                }
                int i4 = block.getSuccessorList().get(i2);
                if (this.executableBlocks.get(i4)) {
                    i4 = i;
                }
                i2++;
                i3 = i4;
            }
            if (size == 2 && i != -1) {
                SsaBasicBlock ssaBasicBlock = block;
                PlainInsn plainInsn2 = plainInsn;
                PlainInsn plainInsn3 = new PlainInsn(Rops.GOTO, ssaInsn.getOriginalRopInsn().getPosition(), (RegisterSpec) null, RegisterSpecList.EMPTY);
                ssaBasicBlock.replaceLastInsn(plainInsn2);
                block.removeSuccessor(i);
            }
        }
    }

    private void replaceConstants() {
        for (int i = 0; i < this.regCount; i++) {
            if (this.latticeValues[i] == 1 && (this.latticeConstants[i] instanceof TypedConstant)) {
                SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i);
                if (!definitionForRegister.getResult().getTypeBearer().isConstant()) {
                    definitionForRegister.setResult(definitionForRegister.getResult().withType((TypedConstant) this.latticeConstants[i]));
                    for (SsaInsn ssaInsn : this.ssaMeth.getUseListForRegister(i)) {
                        if (!ssaInsn.isPhiOrMove()) {
                            NormalSsaInsn normalSsaInsn = (NormalSsaInsn) ssaInsn;
                            RegisterSpecList sources = ssaInsn.getSources();
                            int indexOfRegister = sources.indexOfRegister(i);
                            normalSsaInsn.changeOneSource(indexOfRegister, sources.get(indexOfRegister).withType((TypedConstant) this.latticeConstants[i]));
                        }
                    }
                }
            }
        }
    }

    private void run() {
        addBlockToWorklist(this.ssaMeth.getEntryBlock());
        while (true) {
            if (!this.cfgWorklist.isEmpty() || !this.cfgPhiWorklist.isEmpty() || !this.ssaWorklist.isEmpty() || !this.varyingWorklist.isEmpty()) {
                while (!this.cfgWorklist.isEmpty()) {
                    simulateBlock((SsaBasicBlock) this.cfgWorklist.remove(-1 + this.cfgWorklist.size()));
                }
                while (!this.cfgPhiWorklist.isEmpty()) {
                    simulatePhiBlock((SsaBasicBlock) this.cfgPhiWorklist.remove(-1 + this.cfgPhiWorklist.size()));
                }
                while (!this.varyingWorklist.isEmpty()) {
                    SsaInsn ssaInsn = (SsaInsn) this.varyingWorklist.remove(-1 + this.varyingWorklist.size());
                    if (this.executableBlocks.get(ssaInsn.getBlock().getIndex())) {
                        if (ssaInsn instanceof PhiInsn) {
                            simulatePhi((PhiInsn) ssaInsn);
                        } else {
                            simulateStmt(ssaInsn);
                        }
                    }
                }
                while (!this.ssaWorklist.isEmpty()) {
                    SsaInsn ssaInsn2 = (SsaInsn) this.ssaWorklist.remove(-1 + this.ssaWorklist.size());
                    if (this.executableBlocks.get(ssaInsn2.getBlock().getIndex())) {
                        if (ssaInsn2 instanceof PhiInsn) {
                            simulatePhi((PhiInsn) ssaInsn2);
                        } else {
                            simulateStmt(ssaInsn2);
                        }
                    }
                }
            } else {
                replaceConstants();
                replaceBranches();
                return;
            }
        }
    }

    private boolean setLatticeValueTo(int i, int i2, Constant constant) {
        int i3 = i;
        int i4 = i2;
        Constant constant2 = constant;
        if (i4 != 1) {
            if (this.latticeValues[i3] == i4) {
                return false;
            }
            this.latticeValues[i3] = i4;
            return true;
        } else if (this.latticeValues[i3] == i4 && this.latticeConstants[i3].equals(constant2)) {
            return false;
        } else {
            this.latticeValues[i3] = i4;
            this.latticeConstants[i3] = constant2;
            return true;
        }
    }

    private void simulateBlock(SsaBasicBlock ssaBasicBlock) {
        Iterator it = ssaBasicBlock.getInsns().iterator();
        while (it.hasNext()) {
            SsaInsn ssaInsn = (SsaInsn) it.next();
            if (ssaInsn instanceof PhiInsn) {
                simulatePhi((PhiInsn) ssaInsn);
            } else {
                simulateStmt(ssaInsn);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r22v127 */
    /* JADX WARNING: type inference failed for: r16v2 */
    /* JADX WARNING: type inference failed for: r22v133 */
    /* JADX WARNING: type inference failed for: r15v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0074  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void simulateBranch(net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn r27) {
        /*
            r26 = this;
            r2 = r26
            r3 = r27
            r22 = r3
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r22 = r22.getOpcode()
            r4 = r22
            r22 = r3
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r22 = r22.getSources()
            r5 = r22
            r22 = r4
            int r22 = r22.getBranchingness()
            r23 = 4
            r0 = r22
            r1 = r23
            if (r0 != r1) goto L_0x00d5
            r22 = r5
            r23 = 0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r22 = r22.get(r23)
            r13 = r22
            r22 = r13
            int r22 = r22.getReg()
            r14 = r22
            r22 = r2
            r0 = r22
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaMethod r0 = r0.ssaMeth
            r22 = r0
            r23 = r13
            boolean r22 = r22.isRegALocal(r23)
            if (r22 != 0) goto L_0x02e1
            r22 = r2
            r0 = r22
            int[] r0 = r0.latticeValues
            r22 = r0
            r23 = r14
            r22 = r22[r23]
            r23 = 1
            r0 = r22
            r1 = r23
            if (r0 != r1) goto L_0x02e1
            r22 = r2
            r0 = r22
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant[] r0 = r0.latticeConstants
            r22 = r0
            r23 = r14
            r22 = r22[r23]
            r15 = r22
        L_0x0066:
            r22 = r5
            int r22 = r22.size()
            r23 = 2
            r0 = r22
            r1 = r23
            if (r0 != r1) goto L_0x02db
            r22 = r5
            r23 = 1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r22 = r22.get(r23)
            r20 = r22
            r22 = r20
            int r22 = r22.getReg()
            r21 = r22
            r22 = r2
            r0 = r22
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaMethod r0 = r0.ssaMeth
            r22 = r0
            r23 = r20
            boolean r22 = r22.isRegALocal(r23)
            if (r22 != 0) goto L_0x02db
            r22 = r2
            r0 = r22
            int[] r0 = r0.latticeValues
            r22 = r0
            r23 = r21
            r22 = r22[r23]
            r23 = 1
            r0 = r22
            r1 = r23
            if (r0 != r1) goto L_0x02db
            r22 = r2
            r0 = r22
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant[] r0 = r0.latticeConstants
            r22 = r0
            r23 = r21
            r22 = r22[r23]
            r16 = r22
        L_0x00b8:
            r22 = r15
            if (r22 == 0) goto L_0x01b9
            r22 = r5
            int r22 = r22.size()
            r23 = 1
            r0 = r22
            r1 = r23
            if (r0 != r1) goto L_0x01b9
            r22 = r15
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.TypedConstant r22 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.TypedConstant) r22
            int r22 = r22.getBasicType()
            switch(r22) {
                case 6: goto L_0x0127;
                default: goto L_0x00d5;
            }
        L_0x00d5:
            r22 = 0
            r6 = r22
            r22 = 0
            r7 = r22
        L_0x00dd:
            r22 = r3
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock r22 = r22.getBlock()
            r8 = r22
            r22 = 0
            r9 = r22
            r22 = r7
            if (r22 == 0) goto L_0x029f
            r22 = r6
            if (r22 == 0) goto L_0x028f
            r22 = r8
            net.zhuoweizhang.boardwalk.com.android.dx.util.IntList r22 = r22.getSuccessorList()
            r23 = 1
            int r22 = r22.get(r23)
            r11 = r22
        L_0x00ff:
            r22 = r2
            r23 = r2
            r0 = r23
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaMethod r0 = r0.ssaMeth
            r23 = r0
            java.util.ArrayList r23 = r23.getBlocks()
            r24 = r11
            java.lang.Object r23 = r23.get(r24)
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock r23 = (net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaBasicBlock) r23
            r22.addBlockToWorklist(r23)
            r22 = r2
            r0 = r22
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaInsn> r0 = r0.branchWorklist
            r22 = r0
            r23 = r3
            boolean r22 = r22.add(r23)
        L_0x0126:
            return
        L_0x0127:
            r22 = r15
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstInteger r22 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger) r22
            int r22 = r22.getValue()
            r19 = r22
            r22 = r4
            int r22 = r22.getOpcode()
            switch(r22) {
                case 7: goto L_0x0148;
                case 8: goto L_0x015a;
                case 9: goto L_0x016d;
                case 10: goto L_0x0180;
                case 11: goto L_0x0193;
                case 12: goto L_0x01a6;
                default: goto L_0x013a;
            }
        L_0x013a:
            java.lang.RuntimeException r22 = new java.lang.RuntimeException
            r25 = r22
            r22 = r25
            r23 = r25
            java.lang.String r24 = "Unexpected op"
            r23.<init>(r24)
            throw r22
        L_0x0148:
            r22 = r19
            if (r22 != 0) goto L_0x0155
            r22 = 1
            r6 = r22
        L_0x0150:
            r22 = 1
            r7 = r22
            goto L_0x00dd
        L_0x0155:
            r22 = 0
            r6 = r22
            goto L_0x0150
        L_0x015a:
            r22 = r19
            if (r22 == 0) goto L_0x0168
            r22 = 1
            r6 = r22
        L_0x0162:
            r22 = 1
            r7 = r22
            goto L_0x00dd
        L_0x0168:
            r22 = 0
            r6 = r22
            goto L_0x0162
        L_0x016d:
            r22 = r19
            if (r22 >= 0) goto L_0x017b
            r22 = 1
            r6 = r22
        L_0x0175:
            r22 = 1
            r7 = r22
            goto L_0x00dd
        L_0x017b:
            r22 = 0
            r6 = r22
            goto L_0x0175
        L_0x0180:
            r22 = r19
            if (r22 < 0) goto L_0x018e
            r22 = 1
            r6 = r22
        L_0x0188:
            r22 = 1
            r7 = r22
            goto L_0x00dd
        L_0x018e:
            r22 = 0
            r6 = r22
            goto L_0x0188
        L_0x0193:
            r22 = r19
            if (r22 > 0) goto L_0x01a1
            r22 = 1
            r6 = r22
        L_0x019b:
            r22 = 1
            r7 = r22
            goto L_0x00dd
        L_0x01a1:
            r22 = 0
            r6 = r22
            goto L_0x019b
        L_0x01a6:
            r22 = r19
            if (r22 <= 0) goto L_0x01b4
            r22 = 1
            r6 = r22
        L_0x01ae:
            r22 = 1
            r7 = r22
            goto L_0x00dd
        L_0x01b4:
            r22 = 0
            r6 = r22
            goto L_0x01ae
        L_0x01b9:
            r22 = r15
            if (r22 == 0) goto L_0x00d5
            r22 = r16
            if (r22 == 0) goto L_0x00d5
            r22 = r15
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.TypedConstant r22 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.TypedConstant) r22
            int r22 = r22.getBasicType()
            switch(r22) {
                case 6: goto L_0x01ce;
                default: goto L_0x01cc;
            }
        L_0x01cc:
            goto L_0x00d5
        L_0x01ce:
            r22 = r15
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstInteger r22 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger) r22
            int r22 = r22.getValue()
            r17 = r22
            r22 = r16
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstInteger r22 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger) r22
            int r22 = r22.getValue()
            r18 = r22
            r22 = r4
            int r22 = r22.getOpcode()
            switch(r22) {
                case 7: goto L_0x01f9;
                case 8: goto L_0x0212;
                case 9: goto L_0x022b;
                case 10: goto L_0x0244;
                case 11: goto L_0x025d;
                case 12: goto L_0x0276;
                default: goto L_0x01eb;
            }
        L_0x01eb:
            java.lang.RuntimeException r22 = new java.lang.RuntimeException
            r25 = r22
            r22 = r25
            r23 = r25
            java.lang.String r24 = "Unexpected op"
            r23.<init>(r24)
            throw r22
        L_0x01f9:
            r22 = r17
            r23 = r18
            r0 = r22
            r1 = r23
            if (r0 != r1) goto L_0x020d
            r22 = 1
            r6 = r22
        L_0x0207:
            r22 = 1
            r7 = r22
            goto L_0x00dd
        L_0x020d:
            r22 = 0
            r6 = r22
            goto L_0x0207
        L_0x0212:
            r22 = r17
            r23 = r18
            r0 = r22
            r1 = r23
            if (r0 == r1) goto L_0x0226
            r22 = 1
            r6 = r22
        L_0x0220:
            r22 = 1
            r7 = r22
            goto L_0x00dd
        L_0x0226:
            r22 = 0
            r6 = r22
            goto L_0x0220
        L_0x022b:
            r22 = r17
            r23 = r18
            r0 = r22
            r1 = r23
            if (r0 >= r1) goto L_0x023f
            r22 = 1
            r6 = r22
        L_0x0239:
            r22 = 1
            r7 = r22
            goto L_0x00dd
        L_0x023f:
            r22 = 0
            r6 = r22
            goto L_0x0239
        L_0x0244:
            r22 = r17
            r23 = r18
            r0 = r22
            r1 = r23
            if (r0 < r1) goto L_0x0258
            r22 = 1
            r6 = r22
        L_0x0252:
            r22 = 1
            r7 = r22
            goto L_0x00dd
        L_0x0258:
            r22 = 0
            r6 = r22
            goto L_0x0252
        L_0x025d:
            r22 = r17
            r23 = r18
            r0 = r22
            r1 = r23
            if (r0 > r1) goto L_0x0271
            r22 = 1
            r6 = r22
        L_0x026b:
            r22 = 1
            r7 = r22
            goto L_0x00dd
        L_0x0271:
            r22 = 0
            r6 = r22
            goto L_0x026b
        L_0x0276:
            r22 = r17
            r23 = r18
            r0 = r22
            r1 = r23
            if (r0 <= r1) goto L_0x028a
            r22 = 1
            r6 = r22
        L_0x0284:
            r22 = 1
            r7 = r22
            goto L_0x00dd
        L_0x028a:
            r22 = 0
            r6 = r22
            goto L_0x0284
        L_0x028f:
            r22 = r8
            net.zhuoweizhang.boardwalk.com.android.dx.util.IntList r22 = r22.getSuccessorList()
            r23 = 0
            int r22 = r22.get(r23)
            r11 = r22
            goto L_0x00ff
        L_0x029f:
            r22 = r9
            r23 = r8
            net.zhuoweizhang.boardwalk.com.android.dx.util.IntList r23 = r23.getSuccessorList()
            int r23 = r23.size()
            r0 = r22
            r1 = r23
            if (r0 >= r1) goto L_0x0126
            r22 = r8
            net.zhuoweizhang.boardwalk.com.android.dx.util.IntList r22 = r22.getSuccessorList()
            r23 = r9
            int r22 = r22.get(r23)
            r10 = r22
            r22 = r2
            r23 = r2
            r0 = r23
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaMethod r0 = r0.ssaMeth
            r23 = r0
            java.util.ArrayList r23 = r23.getBlocks()
            r24 = r10
            java.lang.Object r23 = r23.get(r24)
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock r23 = (net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaBasicBlock) r23
            r22.addBlockToWorklist(r23)
            int r9 = r9 + 1
            goto L_0x029f
        L_0x02db:
            r22 = 0
            r16 = r22
            goto L_0x00b8
        L_0x02e1:
            r22 = 0
            r15 = r22
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SCCP.simulateBranch(net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaInsn):void");
    }

    private Constant simulateMath(SsaInsn ssaInsn, int i) {
        Constant constant;
        int i2;
        boolean z;
        RuntimeException runtimeException;
        SsaInsn ssaInsn2 = ssaInsn;
        int i3 = i;
        Insn originalRopInsn = ssaInsn2.getOriginalRopInsn();
        int opcode = ssaInsn2.getOpcode().getOpcode();
        RegisterSpecList sources = ssaInsn2.getSources();
        int reg = sources.get(0).getReg();
        Constant constant2 = this.latticeValues[reg] != 1 ? null : this.latticeConstants[reg];
        if (sources.size() == 1) {
            constant = ((CstInsn) originalRopInsn).getConstant();
        } else {
            int reg2 = sources.get(1).getReg();
            constant = this.latticeValues[reg2] != 1 ? null : this.latticeConstants[reg2];
        }
        if (!(constant2 == null || constant == null)) {
            switch (i3) {
                case 6:
                    int value = ((CstInteger) constant2).getValue();
                    int value2 = ((CstInteger) constant).getValue();
                    switch (opcode) {
                        case 14:
                            i2 = value2 + value;
                            z = false;
                            break;
                        case 15:
                            if (sources.size() != 1) {
                                i2 = value - value2;
                                z = false;
                                break;
                            } else {
                                i2 = value2 - value;
                                z = false;
                                break;
                            }
                        case 16:
                            i2 = value2 * value;
                            z = false;
                            break;
                        case 17:
                            if (value2 != 0) {
                                i2 = value / value2;
                                z = false;
                                break;
                            } else {
                                z = true;
                                i2 = 0;
                                break;
                            }
                        case 18:
                            if (value2 != 0) {
                                i2 = value % value2;
                                z = false;
                                break;
                            } else {
                                z = true;
                                i2 = 0;
                                break;
                            }
                        case 20:
                            i2 = value2 & value;
                            z = false;
                            break;
                        case 21:
                            i2 = value2 | value;
                            z = false;
                            break;
                        case 22:
                            i2 = value2 ^ value;
                            z = false;
                            break;
                        case 23:
                            i2 = value << value2;
                            z = false;
                            break;
                        case 24:
                            i2 = value >> value2;
                            z = false;
                            break;
                        case 25:
                            i2 = value >>> value2;
                            z = false;
                            break;
                        default:
                            RuntimeException runtimeException2 = runtimeException;
                            RuntimeException runtimeException3 = new RuntimeException("Unexpected op");
                            throw runtimeException2;
                    }
                    if (!z) {
                        return CstInteger.make(i2);
                    }
                    break;
                default:
                    return null;
            }
        }
        return null;
    }

    private void simulatePhi(PhiInsn phiInsn) {
        PhiInsn phiInsn2 = phiInsn;
        int reg = phiInsn2.getResult().getReg();
        if (this.latticeValues[reg] != 2) {
            RegisterSpecList sources = phiInsn2.getSources();
            int size = sources.size();
            int i = 0;
            int i2 = 0;
            Constant constant = null;
            while (true) {
                if (i >= size) {
                    break;
                }
                int predBlockIndexForSourcesIndex = phiInsn2.predBlockIndexForSourcesIndex(i);
                int reg2 = sources.get(i).getReg();
                int i3 = this.latticeValues[reg2];
                if (this.executableBlocks.get(predBlockIndexForSourcesIndex)) {
                    if (i3 != 1) {
                        i2 = i3;
                        break;
                    } else if (constant == null) {
                        constant = this.latticeConstants[reg2];
                        i2 = 1;
                    } else if (!this.latticeConstants[reg2].equals(constant)) {
                        i2 = 2;
                        break;
                    }
                }
                i++;
            }
            if (setLatticeValueTo(reg, i2, constant)) {
                addUsersToWorklist(reg, i2);
            }
        }
    }

    private void simulatePhiBlock(SsaBasicBlock ssaBasicBlock) {
        Iterator it = ssaBasicBlock.getInsns().iterator();
        while (it.hasNext()) {
            SsaInsn ssaInsn = (SsaInsn) it.next();
            if (ssaInsn instanceof PhiInsn) {
                simulatePhi((PhiInsn) ssaInsn);
            } else {
                return;
            }
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void simulateStmt(net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn r14) {
        /*
            r13 = this;
            r0 = r13
            r1 = r14
            r9 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn r9 = r9.getOriginalRopInsn()
            r2 = r9
            r9 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r9 = r9.getOpcode()
            int r9 = r9.getBranchingness()
            r10 = 1
            if (r9 != r10) goto L_0x001f
            r9 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r9 = r9.getOpcode()
            boolean r9 = r9.isCallLike()
            if (r9 == 0) goto L_0x0024
        L_0x001f:
            r9 = r0
            r10 = r1
            r9.simulateBranch(r10)
        L_0x0024:
            r9 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r9 = r9.getOpcode()
            int r9 = r9.getOpcode()
            r3 = r9
            r9 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r9 = r9.getResult()
            r4 = r9
            r9 = r4
            if (r9 != 0) goto L_0x005a
            r9 = r3
            r10 = 17
            if (r9 == r10) goto L_0x0041
            r9 = r3
            r10 = 18
            if (r9 != r10) goto L_0x0078
        L_0x0041:
            r9 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock r9 = r9.getBlock()
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock r9 = r9.getPrimarySuccessor()
            java.util.ArrayList r9 = r9.getInsns()
            r10 = 0
            java.lang.Object r9 = r9.get(r10)
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaInsn r9 = (net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn) r9
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r9 = r9.getResult()
            r4 = r9
        L_0x005a:
            r9 = r4
            int r9 = r9.getReg()
            r5 = r9
            r9 = r3
            switch(r9) {
                case 2: goto L_0x0084;
                case 5: goto L_0x0079;
                case 14: goto L_0x00ae;
                case 15: goto L_0x00ae;
                case 16: goto L_0x00ae;
                case 17: goto L_0x00ae;
                case 18: goto L_0x00ae;
                case 20: goto L_0x00ae;
                case 21: goto L_0x00ae;
                case 22: goto L_0x00ae;
                case 23: goto L_0x00ae;
                case 24: goto L_0x00ae;
                case 25: goto L_0x00ae;
                case 56: goto L_0x00c0;
                default: goto L_0x0064;
            }
        L_0x0064:
            r9 = 0
            r7 = r9
            r9 = 2
            r6 = r9
        L_0x0068:
            r9 = r0
            r10 = r5
            r11 = r6
            r12 = r7
            boolean r9 = r9.setLatticeValueTo(r10, r11, r12)
            if (r9 == 0) goto L_0x0078
            r9 = r0
            r10 = r5
            r11 = r6
            r9.addUsersToWorklist(r10, r11)
        L_0x0078:
            return
        L_0x0079:
            r9 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.CstInsn r9 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.CstInsn) r9
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r9 = r9.getConstant()
            r7 = r9
            r9 = 1
            r6 = r9
            goto L_0x0068
        L_0x0084:
            r9 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r9 = r9.getSources()
            int r9 = r9.size()
            r10 = 1
            if (r9 != r10) goto L_0x0064
            r9 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r9 = r9.getSources()
            r10 = 0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r9 = r9.get(r10)
            int r9 = r9.getReg()
            r8 = r9
            r9 = r0
            int[] r9 = r9.latticeValues
            r10 = r8
            r9 = r9[r10]
            r6 = r9
            r9 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant[] r9 = r9.latticeConstants
            r10 = r8
            r9 = r9[r10]
            r7 = r9
            goto L_0x0068
        L_0x00ae:
            r9 = r0
            r10 = r1
            r11 = r4
            int r11 = r11.getBasicType()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r9 = r9.simulateMath(r10, r11)
            r7 = r9
            r9 = r7
            if (r9 == 0) goto L_0x00d8
            r9 = 1
            r6 = r9
            goto L_0x0068
        L_0x00c0:
            r9 = r0
            int[] r9 = r9.latticeValues
            r10 = r5
            r9 = r9[r10]
            r10 = 1
            if (r9 != r10) goto L_0x0064
            r9 = r0
            int[] r9 = r9.latticeValues
            r10 = r5
            r9 = r9[r10]
            r6 = r9
            r9 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant[] r9 = r9.latticeConstants
            r10 = r5
            r9 = r9[r10]
            r7 = r9
            goto L_0x0068
        L_0x00d8:
            r9 = 2
            r6 = r9
            goto L_0x0068
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SCCP.simulateStmt(net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaInsn):void");
    }
}
