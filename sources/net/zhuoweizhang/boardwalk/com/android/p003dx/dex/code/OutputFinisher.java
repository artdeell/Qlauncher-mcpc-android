package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.com.android.dex.DexException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.DexOptions;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvCode.AssignIndicesCallback;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.LocalItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMemberRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.OutputFinisher */
public final class OutputFinisher {
    private final DexOptions dexOptions;
    private boolean hasAnyLocalInfo = false;
    private boolean hasAnyPositionInfo = false;
    private ArrayList<DalvInsn> insns;
    private int reservedCount = -1;
    private final int unreservedRegCount;

    public OutputFinisher(DexOptions dexOptions2, int i, int i2) {
        ArrayList<DalvInsn> arrayList;
        int i3 = i;
        int i4 = i2;
        this.dexOptions = dexOptions2;
        this.unreservedRegCount = i4;
        ArrayList<DalvInsn> arrayList2 = arrayList;
        ArrayList<DalvInsn> arrayList3 = new ArrayList<>(i3);
        this.insns = arrayList2;
    }

    private static void addConstants(HashSet<Constant> hashSet, DalvInsn dalvInsn) {
        HashSet<Constant> hashSet2 = hashSet;
        DalvInsn dalvInsn2 = dalvInsn;
        if (dalvInsn2 instanceof CstInsn) {
            boolean add = hashSet2.add(((CstInsn) dalvInsn2).getConstant());
        } else if (dalvInsn2 instanceof LocalSnapshot) {
            RegisterSpecSet locals = ((LocalSnapshot) dalvInsn2).getLocals();
            int size = locals.size();
            for (int i = 0; i < size; i++) {
                addConstants(hashSet2, locals.get(i));
            }
        } else if (dalvInsn2 instanceof LocalStart) {
            addConstants(hashSet2, ((LocalStart) dalvInsn2).getLocal());
        }
    }

    private static void addConstants(HashSet<Constant> hashSet, RegisterSpec registerSpec) {
        HashSet<Constant> hashSet2 = hashSet;
        RegisterSpec registerSpec2 = registerSpec;
        if (registerSpec2 != null) {
            LocalItem localItem = registerSpec2.getLocalItem();
            CstString name = localItem.getName();
            CstString signature = localItem.getSignature();
            Type type = registerSpec2.getType();
            if (type != Type.KNOWN_NULL) {
                boolean add = hashSet2.add(CstType.intern(type));
            }
            if (name != null) {
                boolean add2 = hashSet2.add(name);
            }
            if (signature != null) {
                boolean add3 = hashSet2.add(signature);
            }
        }
    }

    private void assignAddresses() {
        int size = this.insns.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            DalvInsn dalvInsn = (DalvInsn) this.insns.get(i2);
            dalvInsn.setAddress(i);
            i += dalvInsn.codeSize();
        }
    }

    private void assignAddressesAndFixBranches() {
        do {
            assignAddresses();
        } while (fixBranches());
    }

    private static void assignIndices(CstInsn cstInsn, AssignIndicesCallback assignIndicesCallback) {
        CstInsn cstInsn2 = cstInsn;
        AssignIndicesCallback assignIndicesCallback2 = assignIndicesCallback;
        Constant constant = cstInsn2.getConstant();
        int index = assignIndicesCallback2.getIndex(constant);
        if (index >= 0) {
            cstInsn2.setIndex(index);
        }
        if (constant instanceof CstMemberRef) {
            int index2 = assignIndicesCallback2.getIndex(((CstMemberRef) constant).getDefiningClass());
            if (index2 >= 0) {
                cstInsn2.setClassIndex(index2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0046, code lost:
        if (r8 > r3) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int calculateReservedCount(net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.Dop[] r13) {
        /*
            r12 = this;
            r0 = r12
            r1 = r13
            r9 = r0
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.dex.code.DalvInsn> r9 = r9.insns
            int r9 = r9.size()
            r2 = r9
            r9 = r0
            int r9 = r9.reservedCount
            r3 = r9
            r9 = 0
            r4 = r9
        L_0x0010:
            r9 = r4
            r10 = r2
            if (r9 >= r10) goto L_0x0059
            r9 = r0
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.dex.code.DalvInsn> r9 = r9.insns
            r10 = r4
            java.lang.Object r9 = r9.get(r10)
            net.zhuoweizhang.boardwalk.com.android.dx.dex.code.DalvInsn r9 = (net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn) r9
            r5 = r9
            r9 = r1
            r10 = r4
            r9 = r9[r10]
            r6 = r9
            r9 = r0
            r10 = r5
            r11 = r6
            net.zhuoweizhang.boardwalk.com.android.dx.dex.code.Dop r9 = r9.findOpcodeForInsn(r10, r11)
            r7 = r9
            r9 = r7
            if (r9 != 0) goto L_0x0052
            r9 = r5
            r10 = r0
            r11 = r5
            net.zhuoweizhang.boardwalk.com.android.dx.dex.code.Dop r10 = r10.findExpandedOpcodeForInsn(r11)
            net.zhuoweizhang.boardwalk.com.android.dx.dex.code.InsnFormat r10 = r10.getFormat()
            r11 = r5
            java.util.BitSet r10 = r10.compatibleRegs(r11)
            int r9 = r9.getMinimumRegisterRequirement(r10)
            r8 = r9
            r9 = r8
            r10 = r3
            if (r9 <= r10) goto L_0x0056
        L_0x0048:
            r9 = r1
            r10 = r4
            r11 = r7
            r9[r10] = r11
            r9 = r8
            r3 = r9
        L_0x004f:
            int r4 = r4 + 1
            goto L_0x0010
        L_0x0052:
            r9 = r6
            r10 = r7
            if (r9 == r10) goto L_0x004f
        L_0x0056:
            r9 = r3
            r8 = r9
            goto L_0x0048
        L_0x0059:
            r9 = r3
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.OutputFinisher.calculateReservedCount(net.zhuoweizhang.boardwalk.com.android.dx.dex.code.Dop[]):int");
    }

    private Dop findExpandedOpcodeForInsn(DalvInsn dalvInsn) {
        DexException dexException;
        StringBuilder sb;
        DalvInsn dalvInsn2 = dalvInsn;
        Dop findOpcodeForInsn = findOpcodeForInsn(dalvInsn2.getLowRegVersion(), dalvInsn2.getOpcode());
        if (findOpcodeForInsn != null) {
            return findOpcodeForInsn;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("No expanded opcode for ").append(dalvInsn2).toString());
        throw dexException2;
    }

    private Dop findOpcodeForInsn(DalvInsn dalvInsn, Dop dop) {
        DalvInsn dalvInsn2 = dalvInsn;
        Dop dop2 = dop;
        while (dop2 != null && (!dop2.getFormat().isCompatible(dalvInsn2) || (this.dexOptions.forceJumbo && dop2.getOpcode() == 26))) {
            dop2 = Dops.getNextOrNull(dop2, this.dexOptions);
        }
        return dop2;
    }

    private boolean fixBranches() {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2;
        TargetInsn targetInsn;
        int i;
        int i2;
        boolean z;
        UnsupportedOperationException unsupportedOperationException;
        int i3 = 0;
        int size = this.insns.size();
        boolean z2 = false;
        while (true) {
            boolean z3 = z2;
            if (i3 >= size) {
                return z3;
            }
            DalvInsn dalvInsn = (DalvInsn) this.insns.get(i3);
            if (!(dalvInsn instanceof TargetInsn)) {
                z = z3;
            } else {
                Dop opcode = dalvInsn.getOpcode();
                TargetInsn targetInsn2 = (TargetInsn) dalvInsn;
                if (opcode.getFormat().branchFits(targetInsn2)) {
                    z = z3;
                } else {
                    if (opcode.getFamily() == 40) {
                        Dop findOpcodeForInsn = findOpcodeForInsn(dalvInsn, opcode);
                        if (findOpcodeForInsn == null) {
                            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("method too long");
                            throw unsupportedOperationException2;
                        }
                        Object obj = this.insns.set(i3, dalvInsn.withOpcode(findOpcodeForInsn));
                        i2 = i3;
                        i = size;
                    } else {
                        try {
                            CodeAddress codeAddress = (CodeAddress) this.insns.get(i3 + 1);
                            TargetInsn targetInsn3 = targetInsn;
                            TargetInsn targetInsn4 = new TargetInsn(Dops.GOTO, targetInsn2.getPosition(), RegisterSpecList.EMPTY, targetInsn2.getTarget());
                            Object obj2 = this.insns.set(i3, targetInsn3);
                            this.insns.add(i3, targetInsn2.withNewTargetAndReversed(codeAddress));
                            i = size + 1;
                            i2 = i3 + 1;
                        } catch (IndexOutOfBoundsException e) {
                            IndexOutOfBoundsException indexOutOfBoundsException = e;
                            IllegalStateException illegalStateException3 = illegalStateException2;
                            IllegalStateException illegalStateException4 = new IllegalStateException("unpaired TargetInsn (dangling)");
                            throw illegalStateException3;
                        } catch (ClassCastException e2) {
                            ClassCastException classCastException = e2;
                            IllegalStateException illegalStateException5 = illegalStateException;
                            IllegalStateException illegalStateException6 = new IllegalStateException("unpaired TargetInsn");
                            throw illegalStateException5;
                        }
                    }
                    size = i;
                    i3 = i2;
                    z = true;
                }
            }
            i3++;
            z2 = z;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        if (hasLocalInfo(((net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.LocalStart) r0).getLocal()) != false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean hasLocalInfo(net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn r6) {
        /*
            r0 = r6
            r4 = r0
            boolean r4 = r4 instanceof net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.LocalSnapshot
            if (r4 == 0) goto L_0x002c
            r4 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.dex.code.LocalSnapshot r4 = (net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.LocalSnapshot) r4
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecSet r4 = r4.getLocals()
            r1 = r4
            r4 = r1
            int r4 = r4.size()
            r2 = r4
            r4 = 0
            r3 = r4
        L_0x0016:
            r4 = r3
            r5 = r2
            if (r4 >= r5) goto L_0x003e
            r4 = r1
            r5 = r3
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r4 = r4.get(r5)
            boolean r4 = hasLocalInfo(r4)
            if (r4 == 0) goto L_0x0029
        L_0x0026:
            r4 = 1
            r0 = r4
        L_0x0028:
            return r0
        L_0x0029:
            int r3 = r3 + 1
            goto L_0x0016
        L_0x002c:
            r4 = r0
            boolean r4 = r4 instanceof net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.LocalStart
            if (r4 == 0) goto L_0x003e
            r4 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.dex.code.LocalStart r4 = (net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.LocalStart) r4
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r4 = r4.getLocal()
            boolean r4 = hasLocalInfo(r4)
            if (r4 != 0) goto L_0x0026
        L_0x003e:
            r4 = 0
            r0 = r4
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.OutputFinisher.hasLocalInfo(net.zhuoweizhang.boardwalk.com.android.dx.dex.code.DalvInsn):boolean");
    }

    private static boolean hasLocalInfo(RegisterSpec registerSpec) {
        RegisterSpec registerSpec2 = registerSpec;
        return (registerSpec2 == null || registerSpec2.getLocalItem().getName() == null) ? false : true;
    }

    private Dop[] makeOpcodesArray() {
        int size = this.insns.size();
        Dop[] dopArr = new Dop[size];
        for (int i = 0; i < size; i++) {
            dopArr[i] = ((DalvInsn) this.insns.get(i)).getOpcode();
        }
        return dopArr;
    }

    private void massageInstructions(Dop[] dopArr) {
        Dop[] dopArr2 = dopArr;
        if (this.reservedCount == 0) {
            int size = this.insns.size();
            for (int i = 0; i < size; i++) {
                DalvInsn dalvInsn = (DalvInsn) this.insns.get(i);
                Dop opcode = dalvInsn.getOpcode();
                Dop dop = dopArr2[i];
                if (opcode != dop) {
                    Object obj = this.insns.set(i, dalvInsn.withOpcode(dop));
                }
            }
            return;
        }
        this.insns = performExpansion(dopArr2);
    }

    private ArrayList<DalvInsn> performExpansion(Dop[] dopArr) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Dop dop;
        DalvInsn dalvInsn;
        DalvInsn dalvInsn2;
        DalvInsn expandedVersion;
        Dop[] dopArr2 = dopArr;
        int size = this.insns.size();
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = new ArrayList(size * 2);
        ArrayList arrayList5 = arrayList3;
        ArrayList arrayList6 = arrayList2;
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = arrayList6;
        for (int i = 0; i < size; i++) {
            DalvInsn dalvInsn3 = (DalvInsn) this.insns.get(i);
            Dop opcode = dalvInsn3.getOpcode();
            Dop dop2 = dopArr2[i];
            if (dop2 != null) {
                dalvInsn2 = null;
                dalvInsn = null;
                dop = dop2;
                expandedVersion = dalvInsn3;
            } else {
                Dop findExpandedOpcodeForInsn = findExpandedOpcodeForInsn(dalvInsn3);
                BitSet compatibleRegs = findExpandedOpcodeForInsn.getFormat().compatibleRegs(dalvInsn3);
                DalvInsn expandedPrefix = dalvInsn3.expandedPrefix(compatibleRegs);
                DalvInsn expandedSuffix = dalvInsn3.expandedSuffix(compatibleRegs);
                dop = findExpandedOpcodeForInsn;
                dalvInsn = expandedPrefix;
                dalvInsn2 = expandedSuffix;
                expandedVersion = dalvInsn3.expandedVersion(compatibleRegs);
            }
            if (!(expandedVersion instanceof CodeAddress) || !((CodeAddress) expandedVersion).getBindsClosely()) {
                if (dalvInsn != null) {
                    boolean add = arrayList5.add(dalvInsn);
                }
                if (!(expandedVersion instanceof ZeroSizeInsn) && arrayList8.size() > 0) {
                    Iterator it = arrayList8.iterator();
                    while (it.hasNext()) {
                        boolean add2 = arrayList5.add((CodeAddress) it.next());
                    }
                    arrayList8.clear();
                }
                if (dop != opcode) {
                    expandedVersion = expandedVersion.withOpcode(dop);
                }
                boolean add3 = arrayList5.add(expandedVersion);
                if (dalvInsn2 != null) {
                    boolean add4 = arrayList5.add(dalvInsn2);
                }
            } else {
                boolean add5 = arrayList8.add((CodeAddress) expandedVersion);
            }
        }
        return arrayList5;
    }

    private void reserveRegisters(Dop[] dopArr) {
        Dop[] dopArr2 = dopArr;
        int i = this.reservedCount < 0 ? 0 : this.reservedCount;
        while (true) {
            int i2 = i;
            int calculateReservedCount = calculateReservedCount(dopArr2);
            if (i2 >= calculateReservedCount) {
                this.reservedCount = i2;
                return;
            }
            int i3 = calculateReservedCount - i2;
            int size = this.insns.size();
            for (int i4 = 0; i4 < size; i4++) {
                DalvInsn dalvInsn = (DalvInsn) this.insns.get(i4);
                if (!(dalvInsn instanceof CodeAddress)) {
                    Object obj = this.insns.set(i4, dalvInsn.withRegisterOffset(i3));
                }
            }
            i = calculateReservedCount;
        }
    }

    private void updateInfo(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        if (!this.hasAnyPositionInfo && dalvInsn2.getPosition().getLine() >= 0) {
            this.hasAnyPositionInfo = true;
        }
        if (!this.hasAnyLocalInfo && hasLocalInfo(dalvInsn2)) {
            this.hasAnyLocalInfo = true;
        }
    }

    public void add(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        boolean add = this.insns.add(dalvInsn2);
        updateInfo(dalvInsn2);
    }

    public void assignIndices(AssignIndicesCallback assignIndicesCallback) {
        AssignIndicesCallback assignIndicesCallback2 = assignIndicesCallback;
        Iterator it = this.insns.iterator();
        while (it.hasNext()) {
            DalvInsn dalvInsn = (DalvInsn) it.next();
            if (dalvInsn instanceof CstInsn) {
                assignIndices((CstInsn) dalvInsn, assignIndicesCallback2);
            }
        }
    }

    public DalvInsnList finishProcessingAndGetList() {
        UnsupportedOperationException unsupportedOperationException;
        if (this.reservedCount >= 0) {
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("already processed");
            throw unsupportedOperationException2;
        }
        Dop[] makeOpcodesArray = makeOpcodesArray();
        reserveRegisters(makeOpcodesArray);
        massageInstructions(makeOpcodesArray);
        assignAddressesAndFixBranches();
        return DalvInsnList.makeImmutable(this.insns, this.reservedCount + this.unreservedRegCount);
    }

    public HashSet<Constant> getAllConstants() {
        HashSet hashSet;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet(20);
        HashSet hashSet4 = hashSet2;
        Iterator it = this.insns.iterator();
        while (it.hasNext()) {
            addConstants(hashSet4, (DalvInsn) it.next());
        }
        return hashSet4;
    }

    public boolean hasAnyLocalInfo() {
        return this.hasAnyLocalInfo;
    }

    public boolean hasAnyPositionInfo() {
        return this.hasAnyPositionInfo;
    }

    public void insert(int i, DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        this.insns.add(i, dalvInsn2);
        updateInfo(dalvInsn2);
    }

    public void reverseBranch(int i, CodeAddress codeAddress) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        int size = -1 + (this.insns.size() - i);
        try {
            Object obj = this.insns.set(size, ((TargetInsn) this.insns.get(size)).withNewTargetAndReversed(codeAddress));
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException indexOutOfBoundsException = e;
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("too few instructions");
            throw illegalArgumentException3;
        } catch (ClassCastException e2) {
            ClassCastException classCastException = e2;
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("non-reversible instruction");
            throw illegalArgumentException5;
        }
    }
}
