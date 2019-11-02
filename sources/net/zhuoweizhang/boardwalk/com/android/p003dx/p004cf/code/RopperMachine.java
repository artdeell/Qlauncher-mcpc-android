package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.TranslationAdvice;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.RopperMachine */
final class RopperMachine extends ValueAwareMachine {
    private static final CstType ARRAY_REFLECT_TYPE;
    private static final CstMethodRef MULTIANEWARRAY_METHOD;
    private final TranslationAdvice advice;
    private boolean blockCanThrow;
    private TypeList catches;
    private boolean catchesUsed;
    private int extraBlockCount;
    private boolean hasJsr;
    private final ArrayList<Insn> insns;
    private final int maxLocals;
    private final ConcreteMethod method;
    private int primarySuccessorIndex;
    private ReturnAddress returnAddress;
    private Rop returnOp;
    private SourcePosition returnPosition;
    private boolean returns;
    private final Ropper ropper;

    static {
        CstType cstType;
        CstMethodRef cstMethodRef;
        CstNat cstNat;
        CstString cstString;
        CstString cstString2;
        CstType cstType2 = cstType;
        CstType cstType3 = new CstType(Type.internClassName("java/lang/reflect/Array"));
        ARRAY_REFLECT_TYPE = cstType2;
        CstMethodRef cstMethodRef2 = cstMethodRef;
        CstType cstType4 = ARRAY_REFLECT_TYPE;
        CstNat cstNat2 = cstNat;
        CstString cstString3 = cstString;
        CstString cstString4 = new CstString("newInstance");
        CstString cstString5 = cstString2;
        CstString cstString6 = new CstString("(Ljava/lang/Class;[I)Ljava/lang/Object;");
        CstNat cstNat3 = new CstNat(cstString3, cstString5);
        CstMethodRef cstMethodRef3 = new CstMethodRef(cstType4, cstNat2);
        MULTIANEWARRAY_METHOD = cstMethodRef2;
    }

    public RopperMachine(Ropper ropper2, ConcreteMethod concreteMethod, TranslationAdvice translationAdvice) {
        ArrayList<Insn> arrayList;
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        Ropper ropper3 = ropper2;
        ConcreteMethod concreteMethod2 = concreteMethod;
        TranslationAdvice translationAdvice2 = translationAdvice;
        super(concreteMethod2.getEffectiveDescriptor());
        if (ropper3 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("ropper == null");
            throw nullPointerException3;
        } else if (translationAdvice2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("advice == null");
            throw nullPointerException5;
        } else {
            this.ropper = ropper3;
            this.method = concreteMethod2;
            this.advice = translationAdvice2;
            this.maxLocals = concreteMethod2.getMaxLocals();
            ArrayList<Insn> arrayList2 = arrayList;
            ArrayList<Insn> arrayList3 = new ArrayList<>(25);
            this.insns = arrayList2;
            this.catches = null;
            this.catchesUsed = false;
            this.returns = false;
            this.primarySuccessorIndex = -1;
            this.extraBlockCount = 0;
            this.blockCanThrow = false;
            this.returnOp = null;
            this.returnPosition = null;
        }
    }

    private RegisterSpecList getSources(int i, int i2) {
        RegisterSpecList registerSpecList;
        RegisterSpecList registerSpecList2;
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        RegisterSpecList registerSpecList3;
        int i3 = i;
        int i4 = i2;
        int argCount = argCount();
        if (argCount == 0) {
            return RegisterSpecList.EMPTY;
        }
        int localIndex = getLocalIndex();
        if (localIndex < 0) {
            RegisterSpecList registerSpecList4 = registerSpecList;
            RegisterSpecList registerSpecList5 = new RegisterSpecList(argCount);
            registerSpecList2 = registerSpecList4;
            for (int i5 = 0; i5 < argCount; i5++) {
                RegisterSpec make = RegisterSpec.make(i4, arg(i5));
                registerSpecList2.set(i5, make);
                i4 += make.getCategory();
            }
            switch (i3) {
                case 79:
                    if (argCount == 3) {
                        RegisterSpec registerSpec = registerSpecList2.get(0);
                        RegisterSpec registerSpec2 = registerSpecList2.get(1);
                        registerSpecList2.set(0, registerSpecList2.get(2));
                        registerSpecList2.set(1, registerSpec);
                        registerSpecList2.set(2, registerSpec2);
                        break;
                    } else {
                        RuntimeException runtimeException3 = runtimeException2;
                        RuntimeException runtimeException4 = new RuntimeException("shouldn't happen");
                        throw runtimeException3;
                    }
                case 181:
                    if (argCount == 2) {
                        RegisterSpec registerSpec3 = registerSpecList2.get(0);
                        registerSpecList2.set(0, registerSpecList2.get(1));
                        registerSpecList2.set(1, registerSpec3);
                        break;
                    } else {
                        RuntimeException runtimeException5 = runtimeException;
                        RuntimeException runtimeException6 = new RuntimeException("shouldn't happen");
                        throw runtimeException5;
                    }
            }
        } else {
            RegisterSpecList registerSpecList6 = registerSpecList3;
            RegisterSpecList registerSpecList7 = new RegisterSpecList(1);
            registerSpecList2 = registerSpecList6;
            registerSpecList2.set(0, RegisterSpec.make(localIndex, arg(0)));
        }
        registerSpecList2.setImmutable();
        return registerSpecList2;
    }

    private int jopToRopOpcode(int i, Constant constant) {
        RuntimeException runtimeException;
        Constant constant2 = constant;
        switch (i) {
            case 0:
                return 1;
            case 18:
            case 20:
                return 5;
            case 21:
            case 54:
                return 2;
            case 46:
                return 38;
            case 79:
                return 39;
            case 96:
            case 132:
                return 14;
            case 100:
                return 15;
            case 104:
                return 16;
            case 108:
                return 17;
            case 112:
                return 18;
            case 116:
                return 19;
            case 120:
                return 23;
            case 122:
                return 24;
            case 124:
                return 25;
            case 126:
                return 20;
            case 128:
                return 21;
            case 130:
                return 22;
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
                return 29;
            case 145:
                return 30;
            case 146:
                return 31;
            case 147:
                return 32;
            case 148:
            case 149:
            case 151:
                return 27;
            case 150:
            case 152:
                return 28;
            case 153:
            case 159:
            case 165:
            case 198:
                return 7;
            case 154:
            case 160:
            case 166:
            case 199:
                return 8;
            case 155:
            case 161:
                return 9;
            case 156:
            case 162:
                return 10;
            case 157:
            case 163:
                return 12;
            case 158:
            case 164:
                return 11;
            case 167:
                return 6;
            case 171:
                return 13;
            case 172:
            case 177:
                return 33;
            case 178:
                return 46;
            case 179:
                return 48;
            case 180:
                return 45;
            case 181:
                return 47;
            case 182:
                return 50;
            case 183:
                CstMethodRef cstMethodRef = (CstMethodRef) constant2;
                return (cstMethodRef.isInstanceInit() || cstMethodRef.getDefiningClass() == this.method.getDefiningClass() || !this.method.getAccSuper()) ? 52 : 51;
            case 184:
                return 49;
            case 185:
                return 53;
            case 187:
                return 40;
            case 188:
            case 189:
                return 41;
            case 190:
                return 34;
            case 191:
                return 35;
            case 192:
                return 43;
            case 193:
                return 44;
            case 194:
                return 36;
            case 195:
                return 37;
            default:
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("shouldn't happen");
                throw runtimeException2;
        }
    }

    private void updateReturnOp(Rop rop, SourcePosition sourcePosition) {
        SimException simException;
        StringBuilder sb;
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        Rop rop2 = rop;
        SourcePosition sourcePosition2 = sourcePosition;
        if (rop2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("op == null");
            throw nullPointerException3;
        } else if (sourcePosition2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("pos == null");
            throw nullPointerException5;
        } else if (this.returnOp == null) {
            this.returnOp = rop2;
            this.returnPosition = sourcePosition2;
        } else if (this.returnOp != rop2) {
            SimException simException2 = simException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            SimException simException3 = new SimException(sb2.append("return op mismatch: ").append(rop2).append(", ").append(this.returnOp).toString());
            throw simException2;
        } else if (sourcePosition2.getLine() > this.returnPosition.getLine()) {
            this.returnPosition = sourcePosition2;
        }
    }

    public boolean canThrow() {
        return this.blockCanThrow;
    }

    public int getExtraBlockCount() {
        return this.extraBlockCount;
    }

    public ArrayList<Insn> getInsns() {
        return this.insns;
    }

    public int getPrimarySuccessorIndex() {
        return this.primarySuccessorIndex;
    }

    public ReturnAddress getReturnAddress() {
        return this.returnAddress;
    }

    public Rop getReturnOp() {
        return this.returnOp;
    }

    public SourcePosition getReturnPosition() {
        return this.returnPosition;
    }

    public boolean hasJsr() {
        return this.hasJsr;
    }

    public boolean hasRet() {
        return this.returnAddress != null;
    }

    public boolean returns() {
        return this.returns;
    }

    /* JADX WARNING: type inference failed for: r75v14, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec] */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r75v18 */
    /* JADX WARNING: type inference failed for: r75v55, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec] */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r75v56 */
    /* JADX WARNING: type inference failed for: r75v57, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type] */
    /* JADX WARNING: type inference failed for: r13v0 */
    /* JADX WARNING: type inference failed for: r13v1 */
    /* JADX WARNING: type inference failed for: r76v36, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer] */
    /* JADX WARNING: type inference failed for: r75v73 */
    /* JADX WARNING: type inference failed for: r75v74 */
    /* JADX WARNING: type inference failed for: r75v75 */
    /* JADX WARNING: type inference failed for: r18v0 */
    /* JADX WARNING: type inference failed for: r18v1 */
    /* JADX WARNING: type inference failed for: r18v2 */
    /* JADX WARNING: type inference failed for: r76v45, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer] */
    /* JADX WARNING: type inference failed for: r84v4 */
    /* JADX WARNING: type inference failed for: r75v140 */
    /* JADX WARNING: type inference failed for: r25v0 */
    /* JADX WARNING: type inference failed for: r84v5 */
    /* JADX WARNING: type inference failed for: r75v142 */
    /* JADX WARNING: type inference failed for: r25v1 */
    /* JADX WARNING: type inference failed for: r84v6 */
    /* JADX WARNING: type inference failed for: r75v149 */
    /* JADX WARNING: type inference failed for: r25v2 */
    /* JADX WARNING: type inference failed for: r84v7 */
    /* JADX WARNING: type inference failed for: r75v153 */
    /* JADX WARNING: type inference failed for: r31v0 */
    /* JADX WARNING: type inference failed for: r75v156 */
    /* JADX WARNING: type inference failed for: r25v3 */
    /* JADX WARNING: type inference failed for: r84v8 */
    /* JADX WARNING: type inference failed for: r75v160 */
    /* JADX WARNING: type inference failed for: r25v4 */
    /* JADX WARNING: type inference failed for: r25v5 */
    /* JADX WARNING: type inference failed for: r76v71, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r84v11 */
    /* JADX WARNING: type inference failed for: r75v192 */
    /* JADX WARNING: type inference failed for: r25v6 */
    /* JADX WARNING: type inference failed for: r84v12 */
    /* JADX WARNING: type inference failed for: r75v195 */
    /* JADX WARNING: type inference failed for: r25v7 */
    /* JADX WARNING: type inference failed for: r18v3 */
    /* JADX WARNING: type inference failed for: r75v268 */
    /* JADX WARNING: type inference failed for: r13v2 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r25v8 */
    /* JADX WARNING: type inference failed for: r25v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 33 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run(net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.Frame r86, int r87, int r88) {
        /*
            r85 = this;
            r2 = r85
            r3 = r86
            r4 = r87
            r5 = r88
            r75 = r2
            r0 = r75
            int r0 = r0.maxLocals
            r75 = r0
            r76 = r3
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ExecutionStack r76 = r76.getStack()
            int r76 = r76.size()
            int r75 = r75 + r76
            r6 = r75
            r75 = r2
            r76 = r5
            r77 = r6
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r75 = r75.getSources(r76, r77)
            r7 = r75
            r75 = r7
            int r75 = r75.size()
            r8 = r75
            r75 = r2
            r76 = r3
            r77 = r4
            r78 = r5
            super.run(r76, r77, r78)
            r75 = r2
            r0 = r75
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ConcreteMethod r0 = r0.method
            r75 = r0
            r76 = r4
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition r75 = r75.makeSourcePosistion(r76)
            r9 = r75
            r75 = r5
            r76 = 54
            r0 = r75
            r1 = r76
            if (r0 != r1) goto L_0x0139
            r75 = 1
            r10 = r75
        L_0x005b:
            r75 = r2
            r76 = r10
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r75 = r75.getLocalTarget(r76)
            r11 = r75
            r75 = r2
            int r75 = r75.resultCount()
            r12 = r75
            r75 = r12
            if (r75 != 0) goto L_0x013f
            r75 = 0
            r11 = r75
            r75 = r5
            switch(r75) {
                case 87: goto L_0x0478;
                case 88: goto L_0x0478;
                default: goto L_0x007a;
            }
        L_0x007a:
            r75 = r11
            if (r75 == 0) goto L_0x0241
            r75 = r11
            r13 = r75
        L_0x0082:
            r75 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r75 = r75.getAuxCst()
            r14 = r75
            r75 = r5
            r76 = 197(0xc5, float:2.76E-43)
            r0 = r75
            r1 = r76
            if (r0 != r1) goto L_0x04a3
            r75 = r2
            r76 = 1
            r0 = r76
            r1 = r75
            r1.blockCanThrow = r0
            r75 = r2
            r76 = 6
            r0 = r76
            r1 = r75
            r1.extraBlockCount = r0
            r75 = r11
            int r75 = r75.getNextReg()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r76 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.INT_ARRAY
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r75 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec.make(r75, r76)
            r45 = r75
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingCstInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingCstInsn
            r84 = r75
            r75 = r84
            r76 = r84
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r77 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.INT_ARRAY
            r78 = r8
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r77 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.opFilledNewArray(r77, r78)
            r78 = r9
            r79 = r7
            r80 = r2
            r0 = r80
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeList r0 = r0.catches
            r80 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r81 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType.INT_ARRAY
            r76.<init>(r77, r78, r79, r80, r81)
            r46 = r75
            r75 = r2
            r0 = r75
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn> r0 = r0.insns
            r75 = r0
            r76 = r46
            boolean r75 = r75.add(r76)
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r84 = r75
            r75 = r84
            r76 = r84
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r77 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.INT_ARRAY
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r77 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.opMoveResult(r77)
            r78 = r9
            r79 = r45
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r80 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.EMPTY
            r76.<init>(r77, r78, r79, r80)
            r48 = r75
            r75 = r2
            r0 = r75
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn> r0 = r0.insns
            r75 = r0
            r76 = r48
            boolean r75 = r75.add(r76)
            r75 = r14
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r75 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType) r75
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r75 = r75.getClassType()
            r50 = r75
            r75 = 0
            r51 = r75
            r75 = r50
            r52 = r75
        L_0x0120:
            r75 = r51
            r76 = r8
            r0 = r75
            r1 = r76
            if (r0 >= r1) goto L_0x0247
            r75 = r52
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r75 = r75.getComponentType()
            r64 = r75
            int r51 = r51 + 1
            r75 = r64
            r52 = r75
            goto L_0x0120
        L_0x0139:
            r75 = 0
            r10 = r75
            goto L_0x005b
        L_0x013f:
            r75 = r11
            if (r75 != 0) goto L_0x007a
            r75 = r12
            r76 = 1
            r0 = r75
            r1 = r76
            if (r0 != r1) goto L_0x015f
            r75 = r6
            r76 = r2
            r77 = 0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer r76 = r76.result(r77)
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r75 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec.make(r75, r76)
            r11 = r75
            goto L_0x007a
        L_0x015f:
            r75 = r2
            r0 = r75
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper r0 = r0.ropper
            r75 = r0
            int r75 = r75.getFirstTempStackReg()
            r65 = r75
            r75 = r8
            r0 = r75
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec[] r0 = new net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec[r0]
            r75 = r0
            r66 = r75
            r75 = 0
            r67 = r75
        L_0x017b:
            r75 = r67
            r76 = r8
            r0 = r75
            r1 = r76
            if (r0 >= r1) goto L_0x01db
            r75 = r7
            r76 = r67
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r75 = r75.get(r76)
            r72 = r75
            r75 = r72
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer r75 = r75.getTypeBearer()
            r73 = r75
            r75 = r72
            r76 = r65
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r75 = r75.withReg(r76)
            r74 = r75
            r75 = r2
            r0 = r75
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn> r0 = r0.insns
            r75 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r76 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r84 = r76
            r76 = r84
            r77 = r84
            r78 = r73
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r78 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.opMove(r78)
            r79 = r9
            r80 = r74
            r81 = r72
            r77.<init>(r78, r79, r80, r81)
            boolean r75 = r75.add(r76)
            r75 = r66
            r76 = r67
            r77 = r74
            r75[r76] = r77
            r75 = r65
            r76 = r72
            int r76 = r76.getCategory()
            int r75 = r75 + r76
            r65 = r75
            int r67 = r67 + 1
            goto L_0x017b
        L_0x01db:
            r75 = r2
            int r75 = r75.getAuxInt()
            r68 = r75
        L_0x01e3:
            r75 = r68
            if (r75 == 0) goto L_0x0478
            r75 = r66
            r76 = -1
            r77 = r68
            r78 = 15
            r77 = r77 & 15
            int r76 = r76 + r77
            r75 = r75[r76]
            r69 = r75
            r75 = r69
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer r75 = r75.getTypeBearer()
            r70 = r75
            r75 = r2
            r0 = r75
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn> r0 = r0.insns
            r75 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r76 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r84 = r76
            r76 = r84
            r77 = r84
            r78 = r70
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r78 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.opMove(r78)
            r79 = r9
            r80 = r69
            r81 = r6
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r80 = r80.withReg(r81)
            r81 = r69
            r77.<init>(r78, r79, r80, r81)
            boolean r75 = r75.add(r76)
            r75 = r6
            r76 = r70
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r76 = r76.getType()
            int r76 = r76.getCategory()
            int r75 = r75 + r76
            r6 = r75
            r75 = r68
            r76 = 4
            int r75 = r75 >> 4
            r68 = r75
            goto L_0x01e3
        L_0x0241:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r75 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.VOID
            r13 = r75
            goto L_0x0082
        L_0x0247:
            r75 = r11
            int r75 = r75.getReg()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r76 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.CLASS
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r75 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec.make(r75, r76)
            r53 = r75
            r75 = r52
            boolean r75 = r75.isPrimitive()
            if (r75 == 0) goto L_0x0479
            r75 = r52
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstFieldRef r75 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFieldRef.forPrimitiveType(r75)
            r63 = r75
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingCstInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingCstInsn
            r84 = r75
            r75 = r84
            r76 = r84
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r77 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.GET_STATIC_OBJECT
            r78 = r9
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r79 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.EMPTY
            r80 = r2
            r0 = r80
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeList r0 = r0.catches
            r80 = r0
            r81 = r63
            r76.<init>(r77, r78, r79, r80, r81)
            r54 = r75
        L_0x0282:
            r75 = r2
            r0 = r75
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn> r0 = r0.insns
            r75 = r0
            r76 = r54
            boolean r75 = r75.add(r76)
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r84 = r75
            r75 = r84
            r76 = r84
            r77 = r53
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r77 = r77.getType()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r77 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.opMoveResultPseudo(r77)
            r78 = r9
            r79 = r53
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r80 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.EMPTY
            r76.<init>(r77, r78, r79, r80)
            r56 = r75
            r75 = r2
            r0 = r75
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn> r0 = r0.insns
            r75 = r0
            r76 = r56
            boolean r75 = r75.add(r76)
            r75 = r11
            int r75 = r75.getReg()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r76 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.OBJECT
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r75 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec.make(r75, r76)
            r58 = r75
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingCstInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingCstInsn
            r84 = r75
            r75 = r84
            r76 = r84
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstMethodRef r77 = MULTIANEWARRAY_METHOD
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Prototype r77 = r77.getPrototype()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r77 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.opInvokeStatic(r77)
            r78 = r9
            r79 = r53
            r80 = r45
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r79 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.make(r79, r80)
            r80 = r2
            r0 = r80
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeList r0 = r0.catches
            r80 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstMethodRef r81 = MULTIANEWARRAY_METHOD
            r76.<init>(r77, r78, r79, r80, r81)
            r59 = r75
            r75 = r2
            r0 = r75
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn> r0 = r0.insns
            r75 = r0
            r76 = r59
            boolean r75 = r75.add(r76)
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r84 = r75
            r75 = r84
            r76 = r84
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstMethodRef r77 = MULTIANEWARRAY_METHOD
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Prototype r77 = r77.getPrototype()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r77 = r77.getReturnType()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r77 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.opMoveResult(r77)
            r78 = r9
            r79 = r58
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r80 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.EMPTY
            r76.<init>(r77, r78, r79, r80)
            r61 = r75
            r75 = r2
            r0 = r75
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn> r0 = r0.insns
            r75 = r0
            r76 = r61
            boolean r75 = r75.add(r76)
            r75 = 192(0xc0, float:2.69E-43)
            r5 = r75
            r75 = r58
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r75 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.make(r75)
            r15 = r75
        L_0x033d:
            r75 = r2
            r76 = r5
            r77 = r14
            int r75 = r75.jopToRopOpcode(r76, r77)
            r16 = r75
            r75 = r16
            r76 = r13
            r77 = r15
            r78 = r14
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r75 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.ropFor(r75, r76, r77, r78)
            r17 = r75
            r75 = r11
            if (r75 == 0) goto L_0x04e8
            r75 = r17
            boolean r75 = r75.isCallLike()
            if (r75 == 0) goto L_0x04e8
            r75 = r2
            r76 = 1
            r77 = r2
            r0 = r77
            int r0 = r0.extraBlockCount
            r77 = r0
            int r76 = r76 + r77
            r0 = r76
            r1 = r75
            r1.extraBlockCount = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r84 = r75
            r75 = r84
            r76 = r84
            r77 = r14
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstMethodRef r77 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef) r77
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Prototype r77 = r77.getPrototype()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r77 = r77.getReturnType()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r77 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.opMoveResult(r77)
            r78 = r9
            r79 = r11
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r80 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.EMPTY
            r76.<init>(r77, r78, r79, r80)
            r19 = r75
            r75 = 0
            r18 = r75
        L_0x039e:
            r75 = r16
            r76 = 41
            r0 = r75
            r1 = r76
            if (r0 != r1) goto L_0x052b
            r75 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r75 = r75.getResult()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r75 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType.intern(r75)
            r43 = r75
            r75 = r17
            r20 = r75
            r75 = r43
            r21 = r75
        L_0x03bc:
            r75 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.SwitchList r75 = r75.getAuxCases()
            r22 = r75
            r75 = r2
            java.util.ArrayList r75 = r75.getInitValues()
            r23 = r75
            r75 = r20
            boolean r75 = r75.canThrow()
            r24 = r75
            r75 = r2
            r76 = r24
            r77 = r2
            r0 = r77
            boolean r0 = r0.blockCanThrow
            r77 = r0
            r76 = r76 | r77
            r0 = r76
            r1 = r75
            r1.blockCanThrow = r0
            r75 = r22
            if (r75 == 0) goto L_0x0622
            r75 = r22
            int r75 = r75.size()
            if (r75 != 0) goto L_0x05f3
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r84 = r75
            r75 = r84
            r76 = r84
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r77 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.GOTO
            r78 = r9
            r79 = 0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r80 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.EMPTY
            r76.<init>(r77, r78, r79, r80)
            r25 = r75
            r75 = r2
            r76 = 0
            r0 = r76
            r1 = r75
            r1.primarySuccessorIndex = r0
        L_0x0413:
            r75 = r2
            r0 = r75
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn> r0 = r0.insns
            r75 = r0
            r76 = r25
            boolean r75 = r75.add(r76)
            r75 = r19
            if (r75 == 0) goto L_0x0433
            r75 = r2
            r0 = r75
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn> r0 = r0.insns
            r75 = r0
            r76 = r19
            boolean r75 = r75.add(r76)
        L_0x0433:
            r75 = r23
            if (r75 == 0) goto L_0x0478
            r75 = r2
            r76 = 1
            r77 = r2
            r0 = r77
            int r0 = r0.extraBlockCount
            r77 = r0
            int r76 = r76 + r77
            r0 = r76
            r1 = r75
            r1.extraBlockCount = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.FillArrayDataInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.FillArrayDataInsn
            r84 = r75
            r75 = r84
            r76 = r84
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r77 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.FILL_ARRAY_DATA
            r78 = r9
            r79 = r19
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r79 = r79.getResult()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r79 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.make(r79)
            r80 = r23
            r81 = r21
            r76.<init>(r77, r78, r79, r80, r81)
            r27 = r75
            r75 = r2
            r0 = r75
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn> r0 = r0.insns
            r75 = r0
            r76 = r27
            boolean r75 = r75.add(r76)
        L_0x0478:
            return
        L_0x0479:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingCstInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingCstInsn
            r84 = r75
            r75 = r84
            r76 = r84
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r77 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.CONST_OBJECT
            r78 = r9
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r79 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.EMPTY
            r80 = r2
            r0 = r80
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeList r0 = r0.catches
            r80 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r81 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType
            r84 = r81
            r81 = r84
            r82 = r84
            r83 = r52
            r82.<init>(r83)
            r76.<init>(r77, r78, r79, r80, r81)
            r54 = r75
            goto L_0x0282
        L_0x04a3:
            r75 = r5
            r76 = 168(0xa8, float:2.35E-43)
            r0 = r75
            r1 = r76
            if (r0 != r1) goto L_0x04b8
            r75 = r2
            r76 = 1
            r0 = r76
            r1 = r75
            r1.hasJsr = r0
            goto L_0x0478
        L_0x04b8:
            r75 = r5
            r76 = 169(0xa9, float:2.37E-43)
            r0 = r75
            r1 = r76
            if (r0 != r1) goto L_0x079b
            r75 = r2
            r76 = r2
            r77 = 0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer r76 = r76.arg(r77)     // Catch:{ ClassCastException -> 0x04d5 }
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ReturnAddress r76 = (net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ReturnAddress) r76     // Catch:{ ClassCastException -> 0x04d5 }
            r0 = r76
            r1 = r75
            r1.returnAddress = r0     // Catch:{ ClassCastException -> 0x04d5 }
            goto L_0x0478
        L_0x04d5:
            r75 = move-exception
            r44 = r75
            java.lang.RuntimeException r75 = new java.lang.RuntimeException
            r84 = r75
            r75 = r84
            r76 = r84
            java.lang.String r77 = "Argument to RET was not a ReturnAddress"
            r78 = r44
            r76.<init>(r77, r78)
            throw r75
        L_0x04e8:
            r75 = r11
            if (r75 == 0) goto L_0x0791
            r75 = r17
            boolean r75 = r75.canThrow()
            if (r75 == 0) goto L_0x0791
            r75 = r2
            r76 = 1
            r77 = r2
            r0 = r77
            int r0 = r0.extraBlockCount
            r77 = r0
            int r76 = r76 + r77
            r0 = r76
            r1 = r75
            r1.extraBlockCount = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r84 = r75
            r75 = r84
            r76 = r84
            r77 = r11
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer r77 = r77.getTypeBearer()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r77 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.opMoveResultPseudo(r77)
            r78 = r9
            r79 = r11
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r80 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.EMPTY
            r76.<init>(r77, r78, r79, r80)
            r19 = r75
            r75 = 0
            r18 = r75
            goto L_0x039e
        L_0x052b:
            r75 = r14
            if (r75 != 0) goto L_0x0787
            r75 = r8
            r76 = 2
            r0 = r75
            r1 = r76
            if (r0 != r1) goto L_0x0787
            r75 = r15
            r76 = 0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r75 = r75.get(r76)
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer r75 = r75.getTypeBearer()
            r36 = r75
            r75 = r15
            r76 = 1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r75 = r75.get(r76)
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer r75 = r75.getTypeBearer()
            r37 = r75
            r75 = r37
            boolean r75 = r75.isConstant()
            if (r75 != 0) goto L_0x0565
            r75 = r36
            boolean r75 = r75.isConstant()
            if (r75 == 0) goto L_0x0787
        L_0x0565:
            r75 = r2
            r0 = r75
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.TranslationAdvice r0 = r0.advice
            r75 = r0
            r76 = r17
            r77 = r15
            r78 = 0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r77 = r77.get(r78)
            r78 = r15
            r79 = 1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r78 = r78.get(r79)
            boolean r75 = r75.hasConstantOperation(r76, r77, r78)
            if (r75 == 0) goto L_0x0787
            r75 = r37
            boolean r75 = r75.isConstant()
            if (r75 == 0) goto L_0x05dc
            r75 = r37
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r75 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant) r75
            r42 = r75
            r75 = r15
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r75 = r75.withoutLast()
            r15 = r75
            r75 = r17
            int r75 = r75.getOpcode()
            r76 = 15
            r0 = r75
            r1 = r76
            if (r0 != r1) goto L_0x077d
            r75 = 14
            r40 = r75
            r75 = r37
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstInteger r75 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger) r75
            int r75 = r75.getValue()
            r0 = r75
            int r0 = -r0
            r75 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstInteger r75 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger.make(r75)
            r39 = r75
        L_0x05c0:
            r75 = r40
            r76 = r13
            r77 = r15
            r78 = r39
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r75 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.ropFor(r75, r76, r77, r78)
            r41 = r75
            r75 = r39
            r21 = r75
            r75 = r41
            r20 = r75
            r75 = r40
            r16 = r75
            goto L_0x03bc
        L_0x05dc:
            r75 = r36
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r75 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant) r75
            r38 = r75
            r75 = r15
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r75 = r75.withoutFirst()
            r15 = r75
            r75 = r38
            r39 = r75
            r75 = r16
            r40 = r75
            goto L_0x05c0
        L_0x05f3:
            r75 = r22
            net.zhuoweizhang.boardwalk.com.android.dx.util.IntList r75 = r75.getValues()
            r35 = r75
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SwitchInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SwitchInsn
            r84 = r75
            r75 = r84
            r76 = r84
            r77 = r20
            r78 = r9
            r79 = r18
            r80 = r15
            r81 = r35
            r76.<init>(r77, r78, r79, r80, r81)
            r25 = r75
            r75 = r2
            r76 = r35
            int r76 = r76.size()
            r0 = r76
            r1 = r75
            r1.primarySuccessorIndex = r0
            goto L_0x0413
        L_0x0622:
            r75 = r16
            r76 = 33
            r0 = r75
            r1 = r76
            if (r0 != r1) goto L_0x06ab
            r75 = r15
            int r75 = r75.size()
            if (r75 == 0) goto L_0x0677
            r75 = r15
            r76 = 0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r75 = r75.get(r76)
            r32 = r75
            r75 = r32
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer r75 = r75.getTypeBearer()
            r33 = r75
            r75 = r32
            int r75 = r75.getReg()
            if (r75 == 0) goto L_0x0677
            r75 = r2
            r0 = r75
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn> r0 = r0.insns
            r75 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r76 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r84 = r76
            r76 = r84
            r77 = r84
            r78 = r33
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r78 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.opMove(r78)
            r79 = r9
            r80 = 0
            r81 = r33
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r80 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec.make(r80, r81)
            r81 = r32
            r77.<init>(r78, r79, r80, r81)
            boolean r75 = r75.add(r76)
        L_0x0677:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r84 = r75
            r75 = r84
            r76 = r84
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r77 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.GOTO
            r78 = r9
            r79 = 0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r80 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.EMPTY
            r76.<init>(r77, r78, r79, r80)
            r25 = r75
            r75 = r2
            r76 = 0
            r0 = r76
            r1 = r75
            r1.primarySuccessorIndex = r0
            r75 = r2
            r76 = r20
            r77 = r9
            r75.updateReturnOp(r76, r77)
            r75 = r2
            r76 = 1
            r0 = r76
            r1 = r75
            r1.returns = r0
            goto L_0x0413
        L_0x06ab:
            r75 = r21
            if (r75 == 0) goto L_0x0711
            r75 = r24
            if (r75 == 0) goto L_0x06f8
            r75 = r2
            r0 = r75
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeList r0 = r0.catches
            r75 = r0
            r30 = r75
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingCstInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingCstInsn
            r84 = r75
            r75 = r84
            r76 = r84
            r77 = r20
            r78 = r9
            r79 = r15
            r80 = r30
            r81 = r21
            r76.<init>(r77, r78, r79, r80, r81)
            r31 = r75
            r75 = r2
            r76 = 1
            r0 = r76
            r1 = r75
            r1.catchesUsed = r0
            r75 = r2
            r76 = r2
            r0 = r76
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeList r0 = r0.catches
            r76 = r0
            int r76 = r76.size()
            r0 = r76
            r1 = r75
            r1.primarySuccessorIndex = r0
            r75 = r31
            r25 = r75
            goto L_0x0413
        L_0x06f8:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainCstInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainCstInsn
            r84 = r75
            r75 = r84
            r76 = r84
            r77 = r20
            r78 = r9
            r79 = r18
            r80 = r15
            r81 = r21
            r76.<init>(r77, r78, r79, r80, r81)
            r25 = r75
            goto L_0x0413
        L_0x0711:
            r75 = r24
            if (r75 == 0) goto L_0x0766
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingInsn
            r84 = r75
            r75 = r84
            r76 = r84
            r77 = r20
            r78 = r9
            r79 = r15
            r80 = r2
            r0 = r80
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeList r0 = r0.catches
            r80 = r0
            r76.<init>(r77, r78, r79, r80)
            r25 = r75
            r75 = r2
            r76 = 1
            r0 = r76
            r1 = r75
            r1.catchesUsed = r0
            r75 = r5
            r76 = 191(0xbf, float:2.68E-43)
            r0 = r75
            r1 = r76
            if (r0 != r1) goto L_0x0750
            r75 = r2
            r76 = -1
            r0 = r76
            r1 = r75
            r1.primarySuccessorIndex = r0
            goto L_0x0413
        L_0x0750:
            r75 = r2
            r76 = r2
            r0 = r76
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeList r0 = r0.catches
            r76 = r0
            int r76 = r76.size()
            r0 = r76
            r1 = r75
            r1.primarySuccessorIndex = r0
            goto L_0x0413
        L_0x0766:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r75 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r84 = r75
            r75 = r84
            r76 = r84
            r77 = r20
            r78 = r9
            r79 = r18
            r80 = r15
            r76.<init>(r77, r78, r79, r80)
            r25 = r75
            goto L_0x0413
        L_0x077d:
            r75 = r42
            r39 = r75
            r75 = r16
            r40 = r75
            goto L_0x05c0
        L_0x0787:
            r75 = r17
            r20 = r75
            r75 = r14
            r21 = r75
            goto L_0x03bc
        L_0x0791:
            r75 = r11
            r18 = r75
            r75 = 0
            r19 = r75
            goto L_0x039e
        L_0x079b:
            r75 = r7
            r15 = r75
            goto L_0x033d
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.RopperMachine.run(net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Frame, int, int):void");
    }

    public void startBlock(TypeList typeList) {
        this.catches = typeList;
        this.insns.clear();
        this.catchesUsed = false;
        this.returns = false;
        this.primarySuccessorIndex = 0;
        this.extraBlockCount = 0;
        this.blockCanThrow = false;
        this.hasJsr = false;
        this.returnAddress = null;
    }

    public boolean wereCatchesUsed() {
        return this.catchesUsed;
    }
}
