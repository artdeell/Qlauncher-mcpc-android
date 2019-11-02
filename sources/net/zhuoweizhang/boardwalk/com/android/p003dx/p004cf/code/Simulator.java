package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.BytecodeArray.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.LocalVariableList.Item;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.LocalItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFieldRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInterfaceMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Prototype;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Simulator */
public class Simulator {
    private static final String LOCAL_MISMATCH_ERROR = "This is symptomatic of .class transformation tools that ignore local variable information.";
    private final BytecodeArray code;
    /* access modifiers changed from: private */
    public final LocalVariableList localVariables;
    /* access modifiers changed from: private */
    public final Machine machine;
    private final SimVisitor visitor;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Simulator$SimVisitor */
    private class SimVisitor implements Visitor {
        private Frame frame = null;
        private final Machine machine;
        private int previousOffset;
        final /* synthetic */ Simulator this$0;

        public SimVisitor(Simulator simulator) {
            Simulator simulator2 = simulator;
            this.this$0 = simulator2;
            this.machine = simulator2.machine;
        }

        private void checkReturnType(Type type) {
            SimException simException;
            StringBuilder sb;
            Type type2 = type;
            Type returnType = this.machine.getPrototype().getReturnType();
            if (!Merger.isPossiblyAssignableFrom(returnType, type2)) {
                SimException simException2 = simException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                SimException simException3 = new SimException(sb2.append("return type mismatch: prototype indicates ").append(returnType.toHuman()).append(", but encountered type ").append(type2.toHuman()).toString());
                throw simException2;
            }
        }

        public int getPreviousOffset() {
            return this.previousOffset;
        }

        public void setFrame(Frame frame2) {
            NullPointerException nullPointerException;
            Frame frame3 = frame2;
            if (frame3 == null) {
                NullPointerException nullPointerException2 = nullPointerException;
                NullPointerException nullPointerException3 = new NullPointerException("frame == null");
                throw nullPointerException2;
            }
            this.frame = frame3;
        }

        public void setPreviousOffset(int i) {
            int i2 = i;
            this.previousOffset = i2;
        }

        public void visitBranch(int i, int i2, int i3, int i4) {
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            int i8 = i4;
            switch (i5) {
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                    this.machine.popArgs(this.frame, Type.INT);
                    break;
                case 159:
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                    this.machine.popArgs(this.frame, Type.INT, Type.INT);
                    break;
                case 165:
                case 166:
                    this.machine.popArgs(this.frame, Type.OBJECT, Type.OBJECT);
                    break;
                case 167:
                case 168:
                case 200:
                case 201:
                    this.machine.clearArgs();
                    break;
                case 198:
                case 199:
                    this.machine.popArgs(this.frame, Type.OBJECT);
                    break;
                default:
                    visitInvalid(i5, i6, i7);
                    return;
            }
            this.machine.auxTargetArg(i8);
            this.machine.run(this.frame, i6, i5);
        }

        public void visitConstant(int i, int i2, int i3, Constant constant, int i4) {
            Constant constant2;
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            Constant constant3 = constant;
            int i8 = i4;
            switch (i5) {
                case 179:
                    this.machine.popArgs(this.frame, ((CstFieldRef) constant3).getType());
                    break;
                case 180:
                case 192:
                case 193:
                    this.machine.popArgs(this.frame, Type.OBJECT);
                    break;
                case 181:
                    this.machine.popArgs(this.frame, Type.OBJECT, ((CstFieldRef) constant3).getType());
                    break;
                case 182:
                case 183:
                    constant2 = constant3;
                    break;
                case 184:
                    this.machine.popArgs(this.frame, ((CstMethodRef) constant3).getPrototype(true));
                    break;
                case 185:
                    constant2 = ((CstInterfaceMethodRef) constant3).toMethodRef();
                    break;
                case 189:
                    this.machine.popArgs(this.frame, Type.INT);
                    break;
                case 197:
                    this.machine.popArgs(this.frame, Prototype.internInts(Type.VOID, i8));
                    break;
                default:
                    this.machine.clearArgs();
                    break;
            }
            this.machine.popArgs(this.frame, ((CstMethodRef) constant2).getPrototype(false));
            constant3 = constant2;
            this.machine.auxIntArg(i8);
            this.machine.auxCstArg(constant3);
            this.machine.run(this.frame, i6, i5);
        }

        public void visitInvalid(int i, int i2, int i3) {
            SimException simException;
            StringBuilder sb;
            int i4 = i;
            int i5 = i2;
            int i6 = i3;
            SimException simException2 = simException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            SimException simException3 = new SimException(sb2.append("invalid opcode ").append(Hex.m50u1(i4)).toString());
            throw simException2;
        }

        public void visitLocal(int i, int i2, int i3, int i4, Type type, int i5) {
            Type type2;
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            Type type3 = type;
            int i10 = i5;
            Item pcAndIndexToLocal = this.this$0.localVariables.pcAndIndexToLocal(i6 == 54 ? i7 + i8 : i7, i9);
            if (pcAndIndexToLocal != null) {
                Type type4 = pcAndIndexToLocal.getType();
                if (type4.getBasicFrameType() != type3.getBasicFrameType()) {
                    BaseMachine.throwLocalMismatch(type3, type4);
                    return;
                }
                type2 = type4;
            } else {
                type2 = type3;
            }
            switch (i6) {
                case 21:
                case 169:
                    this.machine.localArg(this.frame, i9);
                    this.machine.localInfo(pcAndIndexToLocal != null);
                    this.machine.auxType(type3);
                    break;
                case 54:
                    LocalItem localItem = pcAndIndexToLocal == null ? null : pcAndIndexToLocal.getLocalItem();
                    this.machine.popArgs(this.frame, type3);
                    this.machine.auxType(type3);
                    this.machine.localTarget(i9, type2, localItem);
                    break;
                case 132:
                    LocalItem localItem2 = null;
                    if (pcAndIndexToLocal != null) {
                        localItem2 = pcAndIndexToLocal.getLocalItem();
                    }
                    this.machine.localArg(this.frame, i9);
                    this.machine.localTarget(i9, type2, localItem2);
                    this.machine.auxType(type3);
                    this.machine.auxIntArg(i10);
                    this.machine.auxCstArg(CstInteger.make(i10));
                    break;
                default:
                    visitInvalid(i6, i7, i8);
                    return;
            }
            this.machine.run(this.frame, i7, i6);
        }

        public void visitNewarray(int i, int i2, CstType cstType, ArrayList<Constant> arrayList) {
            int i3 = i;
            int i4 = i2;
            CstType cstType2 = cstType;
            ArrayList<Constant> arrayList2 = arrayList;
            this.machine.popArgs(this.frame, Type.INT);
            this.machine.auxInitValues(arrayList2);
            this.machine.auxCstArg(cstType2);
            this.machine.run(this.frame, i3, 188);
        }

        public void visitNoArgs(int i, int i2, int i3, Type type) {
            int i4;
            SimException simException;
            StringBuilder sb;
            Type type2;
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            Type type3 = type;
            int i8 = 2;
            switch (i5) {
                case 0:
                    this.machine.clearArgs();
                    break;
                case 46:
                    Type access$200 = Simulator.requiredArrayTypeFor(type3, this.frame.getStack().peekType(1));
                    type3 = access$200.getComponentType();
                    this.machine.popArgs(this.frame, access$200, Type.INT);
                    break;
                case 79:
                    ExecutionStack stack = this.frame.getStack();
                    if (!type3.isCategory1()) {
                        i8 = 3;
                    }
                    Type peekType = stack.peekType(i8);
                    boolean peekLocal = stack.peekLocal(i8);
                    Type access$2002 = Simulator.requiredArrayTypeFor(type3, peekType);
                    if (peekLocal) {
                        type3 = access$2002.getComponentType();
                    }
                    this.machine.popArgs(this.frame, access$2002, Type.INT, type3);
                    break;
                case 87:
                    if (!this.frame.getStack().peekType(0).isCategory2()) {
                        this.machine.popArgs(this.frame, 1);
                        break;
                    } else {
                        throw Simulator.illegalTos();
                    }
                case 88:
                case 92:
                    ExecutionStack stack2 = this.frame.getStack();
                    if (stack2.peekType(0).isCategory2()) {
                        this.machine.popArgs(this.frame, 1);
                        i4 = 17;
                    } else if (stack2.peekType(1).isCategory1()) {
                        this.machine.popArgs(this.frame, 2);
                        i4 = 8481;
                    } else {
                        throw Simulator.illegalTos();
                    }
                    if (i5 == 92) {
                        this.machine.auxIntArg(i4);
                        break;
                    }
                    break;
                case 89:
                    if (!this.frame.getStack().peekType(0).isCategory2()) {
                        this.machine.popArgs(this.frame, 1);
                        this.machine.auxIntArg(17);
                        break;
                    } else {
                        throw Simulator.illegalTos();
                    }
                case 90:
                    ExecutionStack stack3 = this.frame.getStack();
                    if (stack3.peekType(0).isCategory1() && stack3.peekType(1).isCategory1()) {
                        this.machine.popArgs(this.frame, 2);
                        this.machine.auxIntArg(530);
                        break;
                    } else {
                        throw Simulator.illegalTos();
                    }
                    break;
                case 91:
                    ExecutionStack stack4 = this.frame.getStack();
                    if (stack4.peekType(0).isCategory2()) {
                        throw Simulator.illegalTos();
                    } else if (stack4.peekType(1).isCategory2()) {
                        this.machine.popArgs(this.frame, 2);
                        this.machine.auxIntArg(530);
                        break;
                    } else if (stack4.peekType(2).isCategory1()) {
                        this.machine.popArgs(this.frame, 3);
                        this.machine.auxIntArg(12819);
                        break;
                    } else {
                        throw Simulator.illegalTos();
                    }
                case 93:
                    ExecutionStack stack5 = this.frame.getStack();
                    if (!stack5.peekType(0).isCategory2()) {
                        if (!stack5.peekType(1).isCategory2() && !stack5.peekType(2).isCategory2()) {
                            this.machine.popArgs(this.frame, 3);
                            this.machine.auxIntArg(205106);
                            break;
                        } else {
                            throw Simulator.illegalTos();
                        }
                    } else if (!stack5.peekType(2).isCategory2()) {
                        this.machine.popArgs(this.frame, 2);
                        this.machine.auxIntArg(530);
                        break;
                    } else {
                        throw Simulator.illegalTos();
                    }
                    break;
                case 94:
                    ExecutionStack stack6 = this.frame.getStack();
                    if (stack6.peekType(0).isCategory2()) {
                        if (stack6.peekType(2).isCategory2()) {
                            this.machine.popArgs(this.frame, 2);
                            this.machine.auxIntArg(530);
                            break;
                        } else if (stack6.peekType(3).isCategory1()) {
                            this.machine.popArgs(this.frame, 3);
                            this.machine.auxIntArg(12819);
                            break;
                        } else {
                            throw Simulator.illegalTos();
                        }
                    } else if (!stack6.peekType(1).isCategory1()) {
                        throw Simulator.illegalTos();
                    } else if (stack6.peekType(2).isCategory2()) {
                        this.machine.popArgs(this.frame, 3);
                        this.machine.auxIntArg(205106);
                        break;
                    } else if (stack6.peekType(3).isCategory1()) {
                        this.machine.popArgs(this.frame, 4);
                        this.machine.auxIntArg(4399427);
                        break;
                    } else {
                        throw Simulator.illegalTos();
                    }
                case 95:
                    ExecutionStack stack7 = this.frame.getStack();
                    if (stack7.peekType(0).isCategory1() && stack7.peekType(1).isCategory1()) {
                        this.machine.popArgs(this.frame, 2);
                        this.machine.auxIntArg(18);
                        break;
                    } else {
                        throw Simulator.illegalTos();
                    }
                case 96:
                case 100:
                case 104:
                case 108:
                case 112:
                case 126:
                case 128:
                case 130:
                    this.machine.popArgs(this.frame, type3, type3);
                    break;
                case 116:
                    this.machine.popArgs(this.frame, type3);
                    break;
                case 120:
                case 122:
                case 124:
                    this.machine.popArgs(this.frame, type3, Type.INT);
                    break;
                case 133:
                case 134:
                case 135:
                case 145:
                case 146:
                case 147:
                    this.machine.popArgs(this.frame, Type.INT);
                    break;
                case 136:
                case 137:
                case 138:
                    this.machine.popArgs(this.frame, Type.LONG);
                    break;
                case 139:
                case 140:
                case 141:
                    this.machine.popArgs(this.frame, Type.FLOAT);
                    break;
                case 142:
                case 143:
                case 144:
                    this.machine.popArgs(this.frame, Type.DOUBLE);
                    break;
                case 148:
                    this.machine.popArgs(this.frame, Type.LONG, Type.LONG);
                    break;
                case 149:
                case 150:
                    this.machine.popArgs(this.frame, Type.FLOAT, Type.FLOAT);
                    break;
                case 151:
                case 152:
                    this.machine.popArgs(this.frame, Type.DOUBLE, Type.DOUBLE);
                    break;
                case 172:
                    if (type3 == Type.OBJECT) {
                        type2 = this.frame.getStack().peekType(0);
                    } else {
                        type2 = type3;
                    }
                    this.machine.popArgs(this.frame, type3);
                    checkReturnType(type2);
                    break;
                case 177:
                    this.machine.clearArgs();
                    checkReturnType(Type.VOID);
                    break;
                case 190:
                    Type peekType2 = this.frame.getStack().peekType(0);
                    if (peekType2.isArrayOrKnownNull()) {
                        this.machine.popArgs(this.frame, Type.OBJECT);
                        break;
                    } else {
                        SimException simException2 = simException;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        SimException simException3 = new SimException(sb2.append("type mismatch: expected array type but encountered ").append(peekType2.toHuman()).toString());
                        throw simException2;
                    }
                case 191:
                case 194:
                case 195:
                    this.machine.popArgs(this.frame, Type.OBJECT);
                    break;
                default:
                    visitInvalid(i5, i6, i7);
                    return;
            }
            this.machine.auxType(type3);
            this.machine.run(this.frame, i6, i5);
        }

        public void visitSwitch(int i, int i2, int i3, SwitchList switchList, int i4) {
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            SwitchList switchList2 = switchList;
            int i8 = i4;
            this.machine.popArgs(this.frame, Type.INT);
            this.machine.auxIntArg(i8);
            this.machine.auxSwitchArg(switchList2);
            this.machine.run(this.frame, i6, i5);
        }
    }

    public Simulator(Machine machine2, ConcreteMethod concreteMethod) {
        SimVisitor simVisitor;
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        Machine machine3 = machine2;
        ConcreteMethod concreteMethod2 = concreteMethod;
        if (machine3 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("machine == null");
            throw nullPointerException3;
        } else if (concreteMethod2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("method == null");
            throw nullPointerException5;
        } else {
            this.machine = machine3;
            this.code = concreteMethod2.getCode();
            this.localVariables = concreteMethod2.getLocalVariables();
            SimVisitor simVisitor2 = simVisitor;
            SimVisitor simVisitor3 = new SimVisitor(this);
            this.visitor = simVisitor2;
        }
    }

    /* access modifiers changed from: private */
    public static SimException illegalTos() {
        SimException simException;
        SimException simException2 = simException;
        SimException simException3 = new SimException("stack mismatch: illegal top-of-stack for opcode");
        return simException2;
    }

    /* access modifiers changed from: private */
    public static Type requiredArrayTypeFor(Type type, Type type2) {
        Type type3 = type;
        Type type4 = type2;
        if (type4 == Type.KNOWN_NULL) {
            type4 = type3.getArrayType();
        } else if (type3 != Type.OBJECT || !type4.isArray() || !type4.getComponentType().isReference()) {
            return (type3 == Type.BYTE && type4 == Type.BOOLEAN_ARRAY) ? Type.BOOLEAN_ARRAY : type3.getArrayType();
        }
        return type4;
    }

    public int simulate(int i, Frame frame) {
        int i2 = i;
        this.visitor.setFrame(frame);
        return this.code.parseInstruction(i2, this.visitor);
    }

    public void simulate(ByteBlock byteBlock, Frame frame) {
        ByteBlock byteBlock2 = byteBlock;
        Frame frame2 = frame;
        int end = byteBlock2.getEnd();
        this.visitor.setFrame(frame2);
        try {
            int start = byteBlock2.getStart();
            while (true) {
                int i = start;
                if (i < end) {
                    int parseInstruction = this.code.parseInstruction(i, this.visitor);
                    this.visitor.setPreviousOffset(i);
                    start = i + parseInstruction;
                } else {
                    return;
                }
            }
        } catch (SimException e) {
            SimException simException = e;
            frame2.annotate(simException);
            throw simException;
        }
    }
}
