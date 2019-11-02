package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.LocalItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Prototype;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.BaseMachine */
public abstract class BaseMachine implements Machine {
    private int argCount;
    private TypeBearer[] args;
    private SwitchList auxCases;
    private Constant auxCst;
    private ArrayList<Constant> auxInitValues;
    private int auxInt;
    private int auxTarget;
    private Type auxType;
    private int localIndex;
    private boolean localInfo;
    private RegisterSpec localTarget;
    private final Prototype prototype;
    private int resultCount;
    private TypeBearer[] results;

    public BaseMachine(Prototype prototype2) {
        NullPointerException nullPointerException;
        Prototype prototype3 = prototype2;
        if (prototype3 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("prototype == null");
            throw nullPointerException2;
        }
        this.prototype = prototype3;
        this.args = new TypeBearer[10];
        this.results = new TypeBearer[6];
        clearArgs();
    }

    public static void throwLocalMismatch(TypeBearer typeBearer, TypeBearer typeBearer2) {
        SimException simException;
        StringBuilder sb;
        TypeBearer typeBearer3 = typeBearer;
        TypeBearer typeBearer4 = typeBearer2;
        SimException simException2 = simException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        SimException simException3 = new SimException(sb2.append("local variable type mismatch: attempt to set or access a value of type ").append(typeBearer3.toHuman()).append(" using a local variable of type ").append(typeBearer4.toHuman()).append(". This is symptomatic of .class transformation tools ").append("that ignore local variable information.").toString());
        throw simException2;
    }

    /* access modifiers changed from: protected */
    public final void addResult(TypeBearer typeBearer) {
        NullPointerException nullPointerException;
        TypeBearer typeBearer2 = typeBearer;
        if (typeBearer2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("result == null");
            throw nullPointerException2;
        }
        this.results[this.resultCount] = typeBearer2;
        this.resultCount = 1 + this.resultCount;
    }

    /* access modifiers changed from: protected */
    public final TypeBearer arg(int i) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        int i2 = i;
        if (i2 >= this.argCount) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("n >= argCount");
            throw illegalArgumentException3;
        }
        try {
            return this.args[i2];
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("n < 0");
            throw illegalArgumentException5;
        }
    }

    /* access modifiers changed from: protected */
    public final int argCount() {
        return this.argCount;
    }

    /* access modifiers changed from: protected */
    public final int argWidth() {
        int i = 0;
        for (int i2 = 0; i2 < this.argCount; i2++) {
            i += this.args[i2].getType().getCategory();
        }
        return i;
    }

    public final void auxCstArg(Constant constant) {
        NullPointerException nullPointerException;
        Constant constant2 = constant;
        if (constant2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("cst == null");
            throw nullPointerException2;
        }
        this.auxCst = constant2;
    }

    public final void auxInitValues(ArrayList<Constant> arrayList) {
        ArrayList<Constant> arrayList2 = arrayList;
        this.auxInitValues = arrayList2;
    }

    public final void auxIntArg(int i) {
        int i2 = i;
        this.auxInt = i2;
    }

    public final void auxSwitchArg(SwitchList switchList) {
        NullPointerException nullPointerException;
        SwitchList switchList2 = switchList;
        if (switchList2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("cases == null");
            throw nullPointerException2;
        }
        this.auxCases = switchList2;
    }

    public final void auxTargetArg(int i) {
        int i2 = i;
        this.auxTarget = i2;
    }

    public final void auxType(Type type) {
        Type type2 = type;
        this.auxType = type2;
    }

    public final void clearArgs() {
        this.argCount = 0;
        this.auxType = null;
        this.auxInt = 0;
        this.auxCst = null;
        this.auxTarget = 0;
        this.auxCases = null;
        this.auxInitValues = null;
        this.localIndex = -1;
        this.localInfo = false;
        this.localTarget = null;
        this.resultCount = -1;
    }

    /* access modifiers changed from: protected */
    public final void clearResult() {
        this.resultCount = 0;
    }

    /* access modifiers changed from: protected */
    public final SwitchList getAuxCases() {
        return this.auxCases;
    }

    /* access modifiers changed from: protected */
    public final Constant getAuxCst() {
        return this.auxCst;
    }

    /* access modifiers changed from: protected */
    public final int getAuxInt() {
        return this.auxInt;
    }

    /* access modifiers changed from: protected */
    public final int getAuxTarget() {
        return this.auxTarget;
    }

    /* access modifiers changed from: protected */
    public final Type getAuxType() {
        return this.auxType;
    }

    /* access modifiers changed from: protected */
    public final ArrayList<Constant> getInitValues() {
        return this.auxInitValues;
    }

    /* access modifiers changed from: protected */
    public final int getLocalIndex() {
        return this.localIndex;
    }

    /* access modifiers changed from: protected */
    public final boolean getLocalInfo() {
        return this.localInfo;
    }

    /* access modifiers changed from: protected */
    public final RegisterSpec getLocalTarget(boolean z) {
        StringBuilder sb;
        SimException simException;
        boolean z2 = z;
        if (this.localTarget == null) {
            return null;
        }
        if (this.resultCount != 1) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            StringBuilder append = sb2.append("local target with ");
            SimException simException2 = simException;
            SimException simException3 = new SimException(append.append(this.resultCount == 0 ? "no" : "multiple").append(" results").toString());
            throw simException2;
        }
        TypeBearer typeBearer = this.results[0];
        Type type = typeBearer.getType();
        Type type2 = this.localTarget.getType();
        if (type == type2) {
            return z2 ? this.localTarget.withType(typeBearer) : this.localTarget;
        }
        if (!Merger.isPossiblyAssignableFrom(type2, type)) {
            throwLocalMismatch(type, type2);
            return null;
        }
        if (type2 == Type.OBJECT) {
            this.localTarget = this.localTarget.withType(typeBearer);
        }
        return this.localTarget;
    }

    public Prototype getPrototype() {
        return this.prototype;
    }

    public final void localArg(Frame frame, int i) {
        Frame frame2 = frame;
        int i2 = i;
        clearArgs();
        this.args[0] = frame2.getLocals().get(i2);
        this.argCount = 1;
        this.localIndex = i2;
    }

    public final void localInfo(boolean z) {
        boolean z2 = z;
        this.localInfo = z2;
    }

    public final void localTarget(int i, Type type, LocalItem localItem) {
        this.localTarget = RegisterSpec.makeLocalOptional(i, type, localItem);
    }

    public final void popArgs(Frame frame, int i) {
        int i2 = i;
        ExecutionStack stack = frame.getStack();
        clearArgs();
        if (i2 > this.args.length) {
            this.args = new TypeBearer[(i2 + 10)];
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            this.args[i3] = stack.pop();
        }
        this.argCount = i2;
    }

    public void popArgs(Frame frame, Prototype prototype2) {
        SimException simException;
        StringBuilder sb;
        Frame frame2 = frame;
        StdTypeList parameterTypes = prototype2.getParameterTypes();
        int size = parameterTypes.size();
        popArgs(frame2, size);
        for (int i = 0; i < size; i++) {
            if (!Merger.isPossiblyAssignableFrom(parameterTypes.getType(i), this.args[i])) {
                SimException simException2 = simException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                SimException simException3 = new SimException(sb2.append("at stack depth ").append((size - 1) - i).append(", expected type ").append(parameterTypes.getType(i).toHuman()).append(" but found ").append(this.args[i].getType().toHuman()).toString());
                throw simException2;
            }
        }
    }

    public final void popArgs(Frame frame, Type type) {
        SimException simException;
        StringBuilder sb;
        Type type2 = type;
        popArgs(frame, 1);
        if (!Merger.isPossiblyAssignableFrom(type2, this.args[0])) {
            SimException simException2 = simException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            SimException simException3 = new SimException(sb2.append("expected type ").append(type2.toHuman()).append(" but found ").append(this.args[0].getType().toHuman()).toString());
            throw simException2;
        }
    }

    public final void popArgs(Frame frame, Type type, Type type2) {
        SimException simException;
        StringBuilder sb;
        SimException simException2;
        StringBuilder sb2;
        Type type3 = type;
        Type type4 = type2;
        popArgs(frame, 2);
        if (!Merger.isPossiblyAssignableFrom(type3, this.args[0])) {
            SimException simException3 = simException2;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            SimException simException4 = new SimException(sb3.append("expected type ").append(type3.toHuman()).append(" but found ").append(this.args[0].getType().toHuman()).toString());
            throw simException3;
        } else if (!Merger.isPossiblyAssignableFrom(type4, this.args[1])) {
            SimException simException5 = simException;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            SimException simException6 = new SimException(sb5.append("expected type ").append(type4.toHuman()).append(" but found ").append(this.args[1].getType().toHuman()).toString());
            throw simException5;
        }
    }

    public final void popArgs(Frame frame, Type type, Type type2, Type type3) {
        SimException simException;
        StringBuilder sb;
        SimException simException2;
        StringBuilder sb2;
        SimException simException3;
        StringBuilder sb3;
        Type type4 = type;
        Type type5 = type2;
        Type type6 = type3;
        popArgs(frame, 3);
        if (!Merger.isPossiblyAssignableFrom(type4, this.args[0])) {
            SimException simException4 = simException3;
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            SimException simException5 = new SimException(sb4.append("expected type ").append(type4.toHuman()).append(" but found ").append(this.args[0].getType().toHuman()).toString());
            throw simException4;
        } else if (!Merger.isPossiblyAssignableFrom(type5, this.args[1])) {
            SimException simException6 = simException2;
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            SimException simException7 = new SimException(sb6.append("expected type ").append(type5.toHuman()).append(" but found ").append(this.args[1].getType().toHuman()).toString());
            throw simException6;
        } else if (!Merger.isPossiblyAssignableFrom(type6, this.args[2])) {
            SimException simException8 = simException;
            StringBuilder sb8 = sb;
            StringBuilder sb9 = new StringBuilder();
            SimException simException9 = new SimException(sb8.append("expected type ").append(type6.toHuman()).append(" but found ").append(this.args[2].getType().toHuman()).toString());
            throw simException8;
        }
    }

    /* access modifiers changed from: protected */
    public final TypeBearer result(int i) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        int i2 = i;
        if (i2 >= this.resultCount) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("n >= resultCount");
            throw illegalArgumentException3;
        }
        try {
            return this.results[i2];
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("n < 0");
            throw illegalArgumentException5;
        }
    }

    /* access modifiers changed from: protected */
    public final int resultCount() {
        SimException simException;
        if (this.resultCount >= 0) {
            return this.resultCount;
        }
        SimException simException2 = simException;
        SimException simException3 = new SimException("results never set");
        throw simException2;
    }

    /* access modifiers changed from: protected */
    public final int resultWidth() {
        int i = 0;
        for (int i2 = 0; i2 < this.resultCount; i2++) {
            i += this.results[i2].getType().getCategory();
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public final void setResult(TypeBearer typeBearer) {
        NullPointerException nullPointerException;
        TypeBearer typeBearer2 = typeBearer;
        if (typeBearer2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("result == null");
            throw nullPointerException2;
        }
        this.results[0] = typeBearer2;
        this.resultCount = 1;
    }

    /* access modifiers changed from: protected */
    public final void storeResults(Frame frame) {
        SimException simException;
        Frame frame2 = frame;
        if (this.resultCount < 0) {
            SimException simException2 = simException;
            SimException simException3 = new SimException("results never set");
            throw simException2;
        } else if (this.resultCount != 0) {
            if (this.localTarget != null) {
                frame2.getLocals().set(getLocalTarget(false));
                return;
            }
            ExecutionStack stack = frame2.getStack();
            for (int i = 0; i < this.resultCount; i++) {
                if (this.localInfo) {
                    stack.setLocal();
                }
                stack.push(this.results[i]);
            }
        }
    }
}
