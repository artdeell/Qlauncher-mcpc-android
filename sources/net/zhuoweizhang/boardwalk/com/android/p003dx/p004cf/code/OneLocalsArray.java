package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.OneLocalsArray */
public class OneLocalsArray extends LocalsArray {
    private final TypeBearer[] locals;

    public OneLocalsArray(int i) {
        int i2 = i;
        super(i2 != 0);
        this.locals = new TypeBearer[i2];
    }

    private static TypeBearer throwSimException(int i, String str) {
        SimException simException;
        StringBuilder sb;
        int i2 = i;
        String str2 = str;
        SimException simException2 = simException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        SimException simException3 = new SimException(sb2.append("local ").append(Hex.m51u2(i2)).append(": ").append(str2).toString());
        throw simException2;
    }

    public void annotate(ExceptionWithContext exceptionWithContext) {
        StringBuilder sb;
        ExceptionWithContext exceptionWithContext2 = exceptionWithContext;
        for (int i = 0; i < this.locals.length; i++) {
            TypeBearer typeBearer = this.locals[i];
            String obj = typeBearer == null ? "<invalid>" : typeBearer.toString();
            ExceptionWithContext exceptionWithContext3 = exceptionWithContext2;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            exceptionWithContext3.addContext(sb2.append("locals[").append(Hex.m51u2(i)).append("]: ").append(obj).toString());
        }
    }

    public OneLocalsArray copy() {
        OneLocalsArray oneLocalsArray;
        OneLocalsArray oneLocalsArray2 = oneLocalsArray;
        OneLocalsArray oneLocalsArray3 = new OneLocalsArray(this.locals.length);
        OneLocalsArray oneLocalsArray4 = oneLocalsArray2;
        System.arraycopy(this.locals, 0, oneLocalsArray4.locals, 0, this.locals.length);
        return oneLocalsArray4;
    }

    public TypeBearer get(int i) {
        int i2 = i;
        TypeBearer typeBearer = this.locals[i2];
        if (typeBearer == null) {
            typeBearer = throwSimException(i2, "invalid");
        }
        return typeBearer;
    }

    public TypeBearer getCategory1(int i) {
        int i2 = i;
        TypeBearer typeBearer = get(i2);
        Type type = typeBearer.getType();
        if (type.isUninitialized()) {
            typeBearer = throwSimException(i2, "uninitialized instance");
        } else if (type.isCategory2()) {
            return throwSimException(i2, "category-2");
        }
        return typeBearer;
    }

    public TypeBearer getCategory2(int i) {
        int i2 = i;
        TypeBearer typeBearer = get(i2);
        if (typeBearer.getType().isCategory1()) {
            typeBearer = throwSimException(i2, "category-1");
        }
        return typeBearer;
    }

    public int getMaxLocals() {
        return this.locals.length;
    }

    public TypeBearer getOrNull(int i) {
        return this.locals[i];
    }

    /* access modifiers changed from: protected */
    public OneLocalsArray getPrimary() {
        return this;
    }

    public void invalidate(int i) {
        int i2 = i;
        throwIfImmutable();
        this.locals[i2] = null;
    }

    public void makeInitialized(Type type) {
        Type type2 = type;
        int length = this.locals.length;
        if (length != 0) {
            throwIfImmutable();
            Type initializedType = type2.getInitializedType();
            for (int i = 0; i < length; i++) {
                if (this.locals[i] == type2) {
                    this.locals[i] = initializedType;
                }
            }
        }
    }

    public LocalsArray merge(LocalsArray localsArray) {
        LocalsArray localsArray2 = localsArray;
        return localsArray2 instanceof OneLocalsArray ? merge((OneLocalsArray) localsArray2) : localsArray2.merge(this);
    }

    public OneLocalsArray merge(OneLocalsArray oneLocalsArray) {
        OneLocalsArray oneLocalsArray2 = oneLocalsArray;
        try {
            return Merger.mergeLocals(this, oneLocalsArray2);
        } catch (SimException e) {
            SimException simException = e;
            simException.addContext("underlay locals:");
            annotate(simException);
            simException.addContext("overlay locals:");
            oneLocalsArray2.annotate(simException);
            throw simException;
        }
    }

    public LocalsArraySet mergeWithSubroutineCaller(LocalsArray localsArray, int i) {
        LocalsArraySet localsArraySet;
        LocalsArray localsArray2 = localsArray;
        int i2 = i;
        LocalsArraySet localsArraySet2 = localsArraySet;
        LocalsArraySet localsArraySet3 = new LocalsArraySet(getMaxLocals());
        return localsArraySet2.mergeWithSubroutineCaller(localsArray2, i2);
    }

    public void set(int i, TypeBearer typeBearer) {
        NullPointerException nullPointerException;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i2 = i;
        TypeBearer typeBearer2 = typeBearer;
        throwIfImmutable();
        try {
            TypeBearer frameType = typeBearer2.getFrameType();
            if (i2 < 0) {
                IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
                IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException("idx < 0");
                throw indexOutOfBoundsException2;
            }
            if (frameType.getType().isCategory2()) {
                this.locals[i2 + 1] = null;
            }
            this.locals[i2] = frameType;
            if (i2 != 0) {
                TypeBearer typeBearer3 = this.locals[i2 - 1];
                if (typeBearer3 != null && typeBearer3.getType().isCategory2()) {
                    this.locals[i2 - 1] = null;
                }
            }
        } catch (NullPointerException e) {
            NullPointerException nullPointerException2 = e;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("type == null");
            throw nullPointerException3;
        }
    }

    public void set(RegisterSpec registerSpec) {
        RegisterSpec registerSpec2 = registerSpec;
        set(registerSpec2.getReg(), registerSpec2);
    }

    public String toHuman() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = sb3;
        for (int i = 0; i < this.locals.length; i++) {
            TypeBearer typeBearer = this.locals[i];
            String obj = typeBearer == null ? "<invalid>" : typeBearer.toString();
            StringBuilder sb6 = sb5;
            StringBuilder sb7 = sb2;
            StringBuilder sb8 = new StringBuilder();
            StringBuilder append = sb6.append(sb7.append("locals[").append(Hex.m51u2(i)).append("]: ").append(obj).append("\n").toString());
        }
        return sb5.toString();
    }
}
