package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.LocalItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.PlainCstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.PlainInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.ThrowingCstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.TypedConstant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.ConstCollector */
public class ConstCollector {
    private static boolean COLLECT_ONE_LOCAL = false;
    private static boolean COLLECT_STRINGS = false;
    private static final int MAX_COLLECTED_CONSTANTS = 5;
    /* access modifiers changed from: private */
    public final SsaMethod ssaMeth;

    private ConstCollector(SsaMethod ssaMethod) {
        this.ssaMeth = ssaMethod;
    }

    private void fixLocalAssignment(RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        PlainInsn plainInsn;
        RegisterSpec registerSpec3 = registerSpec2;
        for (SsaInsn ssaInsn : this.ssaMeth.getUseListForRegister(registerSpec.getReg())) {
            RegisterSpec localAssignment = ssaInsn.getLocalAssignment();
            if (!(localAssignment == null || ssaInsn.getResult() == null)) {
                LocalItem localItem = localAssignment.getLocalItem();
                ssaInsn.setResultLocal(null);
                registerSpec3 = registerSpec3.withLocalItem(localItem);
                PlainInsn plainInsn2 = plainInsn;
                PlainInsn plainInsn3 = new PlainInsn(Rops.opMarkLocal(registerSpec3), SourcePosition.NO_INFO, (RegisterSpec) null, RegisterSpecList.make(registerSpec3));
                SsaInsn makeFromRop = SsaInsn.makeFromRop(plainInsn2, ssaInsn.getBlock());
                ArrayList insns = ssaInsn.getBlock().getInsns();
                insns.add(1 + insns.indexOf(ssaInsn), makeFromRop);
            }
        }
    }

    private ArrayList<TypedConstant> getConstsSortedByCountUse() {
        HashMap hashMap;
        HashSet hashSet;
        ArrayList arrayList;
        C07141 r26;
        int regCount = this.ssaMeth.getRegCount();
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = hashMap2;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        for (int i = 0; i < regCount; i++) {
            SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i);
            if (!(definitionForRegister == null || definitionForRegister.getOpcode() == null)) {
                RegisterSpec result = definitionForRegister.getResult();
                TypeBearer typeBearer = result.getTypeBearer();
                if (typeBearer.isConstant()) {
                    TypedConstant typedConstant = (TypedConstant) typeBearer;
                    if (definitionForRegister.getOpcode().getOpcode() == 56) {
                        ArrayList insns = ((SsaBasicBlock) this.ssaMeth.getBlocks().get(definitionForRegister.getBlock().getPredecessors().nextSetBit(0))).getInsns();
                        definitionForRegister = (SsaInsn) insns.get(-1 + insns.size());
                    }
                    if (!definitionForRegister.canThrow() || ((typedConstant instanceof CstString) && COLLECT_STRINGS && definitionForRegister.getBlock().getSuccessors().cardinality() <= 1)) {
                        if (this.ssaMeth.isRegALocal(result)) {
                            if (COLLECT_ONE_LOCAL && !hashSet4.contains(typedConstant)) {
                                boolean add = hashSet4.add(typedConstant);
                            }
                        }
                        Integer num = (Integer) hashMap4.get(typedConstant);
                        if (num == null) {
                            Object put = hashMap4.put(typedConstant, Integer.valueOf(1));
                        } else {
                            Object put2 = hashMap4.put(typedConstant, Integer.valueOf(1 + num.intValue()));
                        }
                    }
                }
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (Entry entry : hashMap4.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > 1) {
                boolean add2 = arrayList4.add(entry.getKey());
            }
        }
        ArrayList arrayList5 = arrayList4;
        C07141 r22 = r26;
        final HashMap hashMap5 = hashMap4;
        C07141 r23 = new Comparator<Constant>(this) {
            final /* synthetic */ ConstCollector this$0;

            {
                HashMap hashMap = r7;
                this.this$0 = r6;
            }

            public int compare(Constant constant, Constant constant2) {
                Constant constant3 = constant;
                Constant constant4 = constant2;
                int intValue = ((Integer) hashMap5.get(constant4)).intValue() - ((Integer) hashMap5.get(constant3)).intValue();
                if (intValue == 0) {
                    intValue = constant3.compareTo(constant4);
                }
                return intValue;
            }

            public boolean equals(Object obj) {
                return obj == this;
            }
        };
        Collections.sort(arrayList5, r22);
        return arrayList4;
    }

    public static void process(SsaMethod ssaMethod) {
        ConstCollector constCollector;
        ConstCollector constCollector2 = constCollector;
        ConstCollector constCollector3 = new ConstCollector(ssaMethod);
        constCollector2.run();
    }

    private void run() {
        HashMap hashMap;
        ThrowingCstInsn throwingCstInsn;
        PlainInsn plainInsn;
        PlainCstInsn plainCstInsn;
        int regCount = this.ssaMeth.getRegCount();
        ArrayList constsSortedByCountUse = getConstsSortedByCountUse();
        int min = Math.min(constsSortedByCountUse.size(), 5);
        SsaBasicBlock entryBlock = this.ssaMeth.getEntryBlock();
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap(min);
        HashMap hashMap4 = hashMap2;
        for (int i = 0; i < min; i++) {
            TypedConstant typedConstant = (TypedConstant) constsSortedByCountUse.get(i);
            RegisterSpec make = RegisterSpec.make(this.ssaMeth.makeNewSsaReg(), typedConstant);
            Rop opConst = Rops.opConst(typedConstant);
            if (opConst.getBranchingness() == 1) {
                SsaBasicBlock ssaBasicBlock = entryBlock;
                PlainCstInsn plainCstInsn2 = plainCstInsn;
                PlainCstInsn plainCstInsn3 = new PlainCstInsn(Rops.opConst(typedConstant), SourcePosition.NO_INFO, make, RegisterSpecList.EMPTY, typedConstant);
                ssaBasicBlock.addInsnToHead(plainCstInsn2);
            } else {
                SsaBasicBlock entryBlock2 = this.ssaMeth.getEntryBlock();
                SsaBasicBlock primarySuccessor = entryBlock2.getPrimarySuccessor();
                SsaBasicBlock insertNewSuccessor = entryBlock2.insertNewSuccessor(primarySuccessor);
                SsaBasicBlock ssaBasicBlock2 = insertNewSuccessor;
                ThrowingCstInsn throwingCstInsn2 = throwingCstInsn;
                ThrowingCstInsn throwingCstInsn3 = new ThrowingCstInsn(opConst, SourcePosition.NO_INFO, RegisterSpecList.EMPTY, StdTypeList.EMPTY, typedConstant);
                ssaBasicBlock2.replaceLastInsn(throwingCstInsn2);
                SsaBasicBlock insertNewSuccessor2 = insertNewSuccessor.insertNewSuccessor(primarySuccessor);
                PlainInsn plainInsn2 = plainInsn;
                PlainInsn plainInsn3 = new PlainInsn(Rops.opMoveResultPseudo(make.getTypeBearer()), SourcePosition.NO_INFO, make, RegisterSpecList.EMPTY);
                insertNewSuccessor2.addInsnToHead(plainInsn2);
            }
            Object put = hashMap4.put(typedConstant, make);
        }
        updateConstUses(hashMap4, regCount);
    }

    private void updateConstUses(HashMap<TypedConstant, RegisterSpec> hashMap, int i) {
        HashSet hashSet;
        C07152 r19;
        HashMap<TypedConstant, RegisterSpec> hashMap2 = hashMap;
        int i2 = i;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        ArrayList[] useListCopy = this.ssaMeth.getUseListCopy();
        for (int i3 = 0; i3 < i2; i3++) {
            SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i3);
            if (definitionForRegister != null) {
                RegisterSpec result = definitionForRegister.getResult();
                TypeBearer typeBearer = definitionForRegister.getResult().getTypeBearer();
                if (typeBearer.isConstant()) {
                    TypedConstant typedConstant = (TypedConstant) typeBearer;
                    RegisterSpec registerSpec = (RegisterSpec) hashMap2.get(typedConstant);
                    if (registerSpec != null) {
                        if (this.ssaMeth.isRegALocal(result)) {
                            if (COLLECT_ONE_LOCAL && !hashSet4.contains(typedConstant)) {
                                boolean add = hashSet4.add(typedConstant);
                                fixLocalAssignment(result, (RegisterSpec) hashMap2.get(typedConstant));
                            }
                        }
                        C07152 r14 = r19;
                        final RegisterSpec registerSpec2 = result;
                        final RegisterSpec registerSpec3 = registerSpec;
                        C07152 r15 = new RegisterMapper(this) {
                            final /* synthetic */ ConstCollector this$0;

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
                                    registerSpec2 = registerSpec3.withLocalItem(registerSpec2.getLocalItem());
                                }
                                return registerSpec2;
                            }
                        };
                        C07152 r11 = r14;
                        Iterator it = useListCopy[result.getReg()].iterator();
                        while (it.hasNext()) {
                            SsaInsn ssaInsn = (SsaInsn) it.next();
                            if (!ssaInsn.canThrow() || ssaInsn.getBlock().getSuccessors().cardinality() <= 1) {
                                ssaInsn.mapSourceRegisters(r11);
                            }
                        }
                    }
                }
            }
        }
    }
}
