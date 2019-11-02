package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.LocalVariableList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.MutabilityException;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.BaseLocalVariables */
public abstract class BaseLocalVariables extends BaseAttribute {
    private final LocalVariableList localVariables;

    public BaseLocalVariables(String str, LocalVariableList localVariableList) {
        NullPointerException nullPointerException;
        MutabilityException mutabilityException;
        LocalVariableList localVariableList2 = localVariableList;
        super(str);
        try {
            if (localVariableList2.isMutable()) {
                MutabilityException mutabilityException2 = mutabilityException;
                MutabilityException mutabilityException3 = new MutabilityException("localVariables.isMutable()");
                throw mutabilityException2;
            }
            this.localVariables = localVariableList2;
        } catch (NullPointerException e) {
            NullPointerException nullPointerException2 = e;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("localVariables == null");
            throw nullPointerException3;
        }
    }

    public final int byteLength() {
        return 8 + (10 * this.localVariables.size());
    }

    public final LocalVariableList getLocalVariables() {
        return this.localVariables;
    }
}
