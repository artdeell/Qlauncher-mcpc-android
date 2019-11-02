package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Frame */
public final class Frame {
    private final LocalsArray locals;
    private final ExecutionStack stack;
    private final IntList subroutines;

    public Frame(int i, int i2) {
        OneLocalsArray oneLocalsArray;
        ExecutionStack executionStack;
        int i3 = i2;
        OneLocalsArray oneLocalsArray2 = oneLocalsArray;
        OneLocalsArray oneLocalsArray3 = new OneLocalsArray(i);
        ExecutionStack executionStack2 = executionStack;
        ExecutionStack executionStack3 = new ExecutionStack(i3);
        this((LocalsArray) oneLocalsArray2, executionStack2);
    }

    private Frame(LocalsArray localsArray, ExecutionStack executionStack) {
        this(localsArray, executionStack, IntList.EMPTY);
    }

    private Frame(LocalsArray localsArray, ExecutionStack executionStack, IntList intList) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        LocalsArray localsArray2 = localsArray;
        ExecutionStack executionStack2 = executionStack;
        IntList intList2 = intList;
        if (localsArray2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("locals == null");
            throw nullPointerException3;
        } else if (executionStack2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("stack == null");
            throw nullPointerException5;
        } else {
            intList2.throwIfMutable();
            this.locals = localsArray2;
            this.stack = executionStack2;
            this.subroutines = intList2;
        }
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v3, types: [net.zhuoweizhang.boardwalk.com.android.dx.cf.code.LocalsArraySet] */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r0v4, types: [net.zhuoweizhang.boardwalk.com.android.dx.cf.code.LocalsArray] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.LocalsArray adjustLocalsForSubroutines(net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.LocalsArray r3, net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList r4) {
        /*
            r0 = r3
            r1 = r4
            r2 = r0
            boolean r2 = r2 instanceof net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.LocalsArraySet
            if (r2 != 0) goto L_0x000a
        L_0x0007:
            r2 = r0
            r0 = r2
        L_0x0009:
            return r0
        L_0x000a:
            r2 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.LocalsArraySet r2 = (net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.LocalsArraySet) r2
            r0 = r2
            r2 = r1
            int r2 = r2.size()
            if (r2 != 0) goto L_0x0007
            r2 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.OneLocalsArray r2 = r2.getPrimary()
            r0 = r2
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.Frame.adjustLocalsForSubroutines(net.zhuoweizhang.boardwalk.com.android.dx.cf.code.LocalsArray, net.zhuoweizhang.boardwalk.com.android.dx.util.IntList):net.zhuoweizhang.boardwalk.com.android.dx.cf.code.LocalsArray");
    }

    private IntList mergeSubroutineLists(IntList intList) {
        IntList intList2;
        IntList intList3 = intList;
        if (this.subroutines.equals(intList3)) {
            return this.subroutines;
        }
        IntList intList4 = intList2;
        IntList intList5 = new IntList();
        IntList intList6 = intList4;
        int size = this.subroutines.size();
        int size2 = intList3.size();
        int i = 0;
        while (i < size && i < size2 && this.subroutines.get(i) == intList3.get(i)) {
            intList6.add(i);
            i++;
        }
        intList6.setImmutable();
        return intList6;
    }

    public void annotate(ExceptionWithContext exceptionWithContext) {
        ExceptionWithContext exceptionWithContext2 = exceptionWithContext;
        this.locals.annotate(exceptionWithContext2);
        this.stack.annotate(exceptionWithContext2);
    }

    public Frame copy() {
        Frame frame;
        Frame frame2 = frame;
        Frame frame3 = new Frame(this.locals.copy(), this.stack.copy(), this.subroutines);
        return frame2;
    }

    public LocalsArray getLocals() {
        return this.locals;
    }

    public ExecutionStack getStack() {
        return this.stack;
    }

    public IntList getSubroutines() {
        return this.subroutines;
    }

    public void initializeWithParameters(StdTypeList stdTypeList) {
        StdTypeList stdTypeList2 = stdTypeList;
        int size = stdTypeList2.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Type type = stdTypeList2.get(i2);
            this.locals.set(i, type);
            i += type.getCategory();
        }
    }

    public Frame makeExceptionHandlerStartFrame(CstType cstType) {
        Frame frame;
        CstType cstType2 = cstType;
        ExecutionStack copy = getStack().copy();
        copy.clear();
        copy.push(cstType2);
        Frame frame2 = frame;
        Frame frame3 = new Frame(getLocals(), copy, this.subroutines);
        return frame2;
    }

    public void makeInitialized(Type type) {
        Type type2 = type;
        this.locals.makeInitialized(type2);
        this.stack.makeInitialized(type2);
    }

    public Frame makeNewSubroutineStartFrame(int i, int i2) {
        Frame frame;
        int i3 = i;
        int i4 = i2;
        this.subroutines.mutableCopy().add(i3);
        Frame frame2 = frame;
        Frame frame3 = new Frame(this.locals.getPrimary(), this.stack, IntList.makeImmutable(i3));
        return frame2.mergeWithSubroutineCaller(this, i3, i4);
    }

    public Frame mergeWith(Frame frame) {
        Frame frame2;
        Frame frame3 = frame;
        LocalsArray merge = getLocals().merge(frame3.getLocals());
        ExecutionStack merge2 = getStack().merge(frame3.getStack());
        IntList mergeSubroutineLists = mergeSubroutineLists(frame3.subroutines);
        LocalsArray adjustLocalsForSubroutines = adjustLocalsForSubroutines(merge, mergeSubroutineLists);
        if (adjustLocalsForSubroutines == getLocals() && merge2 == getStack() && this.subroutines == mergeSubroutineLists) {
            return this;
        }
        Frame frame4 = frame2;
        Frame frame5 = new Frame(adjustLocalsForSubroutines, merge2, mergeSubroutineLists);
        return frame4;
    }

    public Frame mergeWithSubroutineCaller(Frame frame, int i, int i2) {
        IntList intList;
        RuntimeException runtimeException;
        Frame frame2;
        Frame frame3 = frame;
        int i3 = i;
        LocalsArraySet mergeWithSubroutineCaller = getLocals().mergeWithSubroutineCaller(frame3.getLocals(), i2);
        ExecutionStack merge = getStack().merge(frame3.getStack());
        IntList mutableCopy = frame3.subroutines.mutableCopy();
        mutableCopy.add(i3);
        mutableCopy.setImmutable();
        if (mergeWithSubroutineCaller == getLocals() && merge == getStack() && this.subroutines.equals(mutableCopy)) {
            return this;
        }
        if (this.subroutines.equals(mutableCopy)) {
            intList = this.subroutines;
        } else {
            if (this.subroutines.size() > mutableCopy.size()) {
                intList = this.subroutines;
            } else {
                intList = mutableCopy;
                mutableCopy = this.subroutines;
            }
            int size = intList.size();
            int size2 = mutableCopy.size();
            for (int i4 = size2 - 1; i4 >= 0; i4--) {
                if (mutableCopy.get(i4) != intList.get(i4 + (size - size2))) {
                    RuntimeException runtimeException2 = runtimeException;
                    RuntimeException runtimeException3 = new RuntimeException("Incompatible merged subroutines");
                    throw runtimeException2;
                }
            }
        }
        Frame frame4 = frame2;
        Frame frame5 = new Frame(mergeWithSubroutineCaller, merge, intList);
        return frame4;
    }

    public void setImmutable() {
        this.locals.setImmutable();
        this.stack.setImmutable();
    }

    public Frame subFrameForLabel(int i, int i2) {
        NullPointerException nullPointerException;
        RuntimeException runtimeException;
        Frame frame;
        RuntimeException runtimeException2;
        int i3 = i;
        LocalsArray localsArray = this.locals instanceof LocalsArraySet ? ((LocalsArraySet) this.locals).subArrayForLabel(i2) : null;
        try {
            IntList mutableCopy = this.subroutines.mutableCopy();
            if (mutableCopy.pop() != i3) {
                RuntimeException runtimeException3 = runtimeException2;
                RuntimeException runtimeException4 = new RuntimeException("returning from invalid subroutine");
                throw runtimeException3;
            }
            mutableCopy.setImmutable();
            if (localsArray == null) {
                return null;
            }
            Frame frame2 = frame;
            Frame frame3 = new Frame(localsArray, this.stack, mutableCopy);
            return frame2;
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException indexOutOfBoundsException = e;
            RuntimeException runtimeException5 = runtimeException;
            RuntimeException runtimeException6 = new RuntimeException("returning from invalid subroutine");
            throw runtimeException5;
        } catch (NullPointerException e2) {
            NullPointerException nullPointerException2 = e2;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("can't return from non-subroutine");
            throw nullPointerException3;
        }
    }
}
