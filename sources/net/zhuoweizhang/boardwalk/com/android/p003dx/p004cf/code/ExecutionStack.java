package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.MutabilityControl;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ExecutionStack */
public final class ExecutionStack extends MutabilityControl {
    private final boolean[] local;
    private final TypeBearer[] stack;
    private int stackPtr;

    public ExecutionStack(int i) {
        int i2 = i;
        super(i2 != 0);
        this.stack = new TypeBearer[i2];
        this.local = new boolean[i2];
        this.stackPtr = 0;
    }

    private static String stackElementString(TypeBearer typeBearer) {
        TypeBearer typeBearer2 = typeBearer;
        return typeBearer2 == null ? "<invalid>" : typeBearer2.toString();
    }

    private static TypeBearer throwSimException(String str) {
        SimException simException;
        StringBuilder sb;
        String str2 = str;
        SimException simException2 = simException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        SimException simException3 = new SimException(sb2.append("stack: ").append(str2).toString());
        throw simException2;
    }

    public void annotate(ExceptionWithContext exceptionWithContext) {
        StringBuilder sb;
        ExceptionWithContext exceptionWithContext2 = exceptionWithContext;
        int i = -1 + this.stackPtr;
        int i2 = 0;
        while (i2 <= i) {
            String u2 = i2 == i ? "top0" : Hex.m51u2(i - i2);
            ExceptionWithContext exceptionWithContext3 = exceptionWithContext2;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            exceptionWithContext3.addContext(sb2.append("stack[").append(u2).append("]: ").append(stackElementString(this.stack[i2])).toString());
            i2++;
        }
    }

    public void change(int i, TypeBearer typeBearer) {
        NullPointerException nullPointerException;
        StringBuilder sb;
        int i2 = i;
        TypeBearer typeBearer2 = typeBearer;
        throwIfImmutable();
        try {
            TypeBearer frameType = typeBearer2.getFrameType();
            int i3 = -1 + (this.stackPtr - i2);
            TypeBearer typeBearer3 = this.stack[i3];
            if (typeBearer3 == null || typeBearer3.getType().getCategory() != frameType.getType().getCategory()) {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                TypeBearer throwSimException = throwSimException(sb2.append("incompatible substitution: ").append(stackElementString(typeBearer3)).append(" -> ").append(stackElementString(frameType)).toString());
            }
            this.stack[i3] = frameType;
        } catch (NullPointerException e) {
            NullPointerException nullPointerException2 = e;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("type == null");
            throw nullPointerException3;
        }
    }

    public void clear() {
        throwIfImmutable();
        for (int i = 0; i < this.stackPtr; i++) {
            this.stack[i] = null;
            this.local[i] = false;
        }
        this.stackPtr = 0;
    }

    public ExecutionStack copy() {
        ExecutionStack executionStack;
        ExecutionStack executionStack2 = executionStack;
        ExecutionStack executionStack3 = new ExecutionStack(this.stack.length);
        ExecutionStack executionStack4 = executionStack2;
        System.arraycopy(this.stack, 0, executionStack4.stack, 0, this.stack.length);
        System.arraycopy(this.local, 0, executionStack4.local, 0, this.local.length);
        executionStack4.stackPtr = this.stackPtr;
        return executionStack4;
    }

    public int getMaxStack() {
        return this.stack.length;
    }

    public void makeInitialized(Type type) {
        Type type2 = type;
        if (this.stackPtr != 0) {
            throwIfImmutable();
            Type initializedType = type2.getInitializedType();
            for (int i = 0; i < this.stackPtr; i++) {
                if (this.stack[i] == type2) {
                    this.stack[i] = initializedType;
                }
            }
        }
    }

    public ExecutionStack merge(ExecutionStack executionStack) {
        ExecutionStack executionStack2 = executionStack;
        try {
            return Merger.mergeStack(this, executionStack2);
        } catch (SimException e) {
            SimException simException = e;
            simException.addContext("underlay stack:");
            annotate(simException);
            simException.addContext("overlay stack:");
            executionStack2.annotate(simException);
            throw simException;
        }
    }

    public TypeBearer peek(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 >= 0) {
            return i2 >= this.stackPtr ? throwSimException("underflow") : this.stack[-1 + (this.stackPtr - i2)];
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("n < 0");
        throw illegalArgumentException2;
    }

    public boolean peekLocal(int i) {
        SimException simException;
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("n < 0");
            throw illegalArgumentException2;
        } else if (i2 < this.stackPtr) {
            return this.local[-1 + (this.stackPtr - i2)];
        } else {
            SimException simException2 = simException;
            SimException simException3 = new SimException("stack: underflow");
            throw simException2;
        }
    }

    public Type peekType(int i) {
        return peek(i).getType();
    }

    public TypeBearer pop() {
        throwIfImmutable();
        TypeBearer peek = peek(0);
        this.stack[-1 + this.stackPtr] = null;
        this.local[-1 + this.stackPtr] = false;
        this.stackPtr -= peek.getType().getCategory();
        return peek;
    }

    public void push(TypeBearer typeBearer) {
        NullPointerException nullPointerException;
        TypeBearer typeBearer2 = typeBearer;
        throwIfImmutable();
        try {
            TypeBearer frameType = typeBearer2.getFrameType();
            int category = frameType.getType().getCategory();
            if (category + this.stackPtr > this.stack.length) {
                TypeBearer throwSimException = throwSimException("overflow");
                return;
            }
            if (category == 2) {
                this.stack[this.stackPtr] = null;
                this.stackPtr = 1 + this.stackPtr;
            }
            this.stack[this.stackPtr] = frameType;
            this.stackPtr = 1 + this.stackPtr;
        } catch (NullPointerException e) {
            NullPointerException nullPointerException2 = e;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("type == null");
            throw nullPointerException3;
        }
    }

    public void setLocal() {
        throwIfImmutable();
        this.local[this.stackPtr] = true;
    }

    public int size() {
        return this.stackPtr;
    }
}
