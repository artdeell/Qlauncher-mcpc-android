package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.HighRegisterPrefix */
public final class HighRegisterPrefix extends VariableSizeInsn {
    private SimpleInsn[] insns;

    public HighRegisterPrefix(SourcePosition sourcePosition, RegisterSpecList registerSpecList) {
        IllegalArgumentException illegalArgumentException;
        RegisterSpecList registerSpecList2 = registerSpecList;
        super(sourcePosition, registerSpecList2);
        if (registerSpecList2.size() == 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("registers.size() == 0");
            throw illegalArgumentException2;
        }
        this.insns = null;
    }

    private void calculateInsnsIfNecessary() {
        int i = 0;
        if (this.insns == null) {
            RegisterSpecList registers = getRegisters();
            int size = registers.size();
            this.insns = new SimpleInsn[size];
            for (int i2 = 0; i2 < size; i2++) {
                RegisterSpec registerSpec = registers.get(i2);
                this.insns[i2] = moveInsnFor(registerSpec, i);
                i += registerSpec.getCategory();
            }
        }
    }

    private static SimpleInsn moveInsnFor(RegisterSpec registerSpec, int i) {
        RegisterSpec registerSpec2 = registerSpec;
        return DalvInsn.makeMove(SourcePosition.NO_INFO, RegisterSpec.make(i, registerSpec2.getType()), registerSpec2);
    }

    /* access modifiers changed from: protected */
    public String argString() {
        return null;
    }

    public int codeSize() {
        calculateInsnsIfNecessary();
        SimpleInsn[] simpleInsnArr = this.insns;
        int i = 0;
        for (int i2 = 0; i2 < simpleInsnArr.length; i2++) {
            i += simpleInsnArr[i2].codeSize();
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public String listingString0(boolean z) {
        StringBuffer stringBuffer;
        boolean z2 = z;
        int i = 0;
        RegisterSpecList registers = getRegisters();
        int size = registers.size();
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        for (int i2 = 0; i2 < size; i2++) {
            RegisterSpec registerSpec = registers.get(i2);
            SimpleInsn moveInsnFor = moveInsnFor(registerSpec, i);
            if (i2 != 0) {
                StringBuffer append = stringBuffer4.append(10);
            }
            StringBuffer append2 = stringBuffer4.append(moveInsnFor.listingString0(z2));
            i += registerSpec.getCategory();
        }
        return stringBuffer4.toString();
    }

    public DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        HighRegisterPrefix highRegisterPrefix;
        RegisterSpecList registerSpecList2 = registerSpecList;
        HighRegisterPrefix highRegisterPrefix2 = highRegisterPrefix;
        HighRegisterPrefix highRegisterPrefix3 = new HighRegisterPrefix(getPosition(), registerSpecList2);
        return highRegisterPrefix2;
    }

    public void writeTo(AnnotatedOutput annotatedOutput) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        calculateInsnsIfNecessary();
        SimpleInsn[] simpleInsnArr = this.insns;
        int length = simpleInsnArr.length;
        for (int i = 0; i < length; i++) {
            simpleInsnArr[i].writeTo(annotatedOutput2);
        }
    }
}
