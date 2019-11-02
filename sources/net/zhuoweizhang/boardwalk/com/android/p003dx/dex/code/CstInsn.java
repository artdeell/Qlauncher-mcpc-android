package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.CstInsn */
public final class CstInsn extends FixedSizeInsn {
    private int classIndex;
    private final Constant constant;
    private int index;

    public CstInsn(Dop dop, SourcePosition sourcePosition, RegisterSpecList registerSpecList, Constant constant2) {
        NullPointerException nullPointerException;
        Constant constant3 = constant2;
        super(dop, sourcePosition, registerSpecList);
        if (constant3 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("constant == null");
            throw nullPointerException2;
        }
        this.constant = constant3;
        this.index = -1;
        this.classIndex = -1;
    }

    /* access modifiers changed from: protected */
    public String argString() {
        return this.constant.toHuman();
    }

    public int getClassIndex() {
        RuntimeException runtimeException;
        if (this.classIndex >= 0) {
            return this.classIndex;
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("class index not yet set");
        throw runtimeException2;
    }

    public Constant getConstant() {
        return this.constant;
    }

    public int getIndex() {
        RuntimeException runtimeException;
        StringBuilder sb;
        if (this.index >= 0) {
            return this.index;
        }
        RuntimeException runtimeException2 = runtimeException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        RuntimeException runtimeException3 = new RuntimeException(sb2.append("index not yet set for ").append(this.constant).toString());
        throw runtimeException2;
    }

    public boolean hasClassIndex() {
        return this.classIndex >= 0;
    }

    public boolean hasIndex() {
        return this.index >= 0;
    }

    public void setClassIndex(int i) {
        RuntimeException runtimeException;
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("index < 0");
            throw illegalArgumentException2;
        } else if (this.classIndex >= 0) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("class index already set");
            throw runtimeException2;
        } else {
            this.classIndex = i2;
        }
    }

    public void setIndex(int i) {
        RuntimeException runtimeException;
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("index < 0");
            throw illegalArgumentException2;
        } else if (this.index >= 0) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("index already set");
            throw runtimeException2;
        } else {
            this.index = i2;
        }
    }

    public DalvInsn withOpcode(Dop dop) {
        CstInsn cstInsn;
        CstInsn cstInsn2 = cstInsn;
        CstInsn cstInsn3 = new CstInsn(dop, getPosition(), getRegisters(), this.constant);
        CstInsn cstInsn4 = cstInsn2;
        if (this.index >= 0) {
            cstInsn4.setIndex(this.index);
        }
        if (this.classIndex >= 0) {
            cstInsn4.setClassIndex(this.classIndex);
        }
        return cstInsn4;
    }

    public DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        CstInsn cstInsn;
        CstInsn cstInsn2 = cstInsn;
        CstInsn cstInsn3 = new CstInsn(getOpcode(), getPosition(), registerSpecList, this.constant);
        CstInsn cstInsn4 = cstInsn2;
        if (this.index >= 0) {
            cstInsn4.setIndex(this.index);
        }
        if (this.classIndex >= 0) {
            cstInsn4.setClassIndex(this.classIndex);
        }
        return cstInsn4;
    }
}
