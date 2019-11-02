package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.MutabilityControl;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.StdConstantPool */
public final class StdConstantPool extends MutabilityControl implements ConstantPool {
    private final Constant[] entries;

    public StdConstantPool(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        super(i2 > 1);
        if (i2 < 1) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("size < 1");
            throw illegalArgumentException2;
        }
        this.entries = new Constant[i2];
    }

    private static Constant throwInvalid(int i) {
        ExceptionWithContext exceptionWithContext;
        StringBuilder sb;
        int i2 = i;
        ExceptionWithContext exceptionWithContext2 = exceptionWithContext;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        ExceptionWithContext exceptionWithContext3 = new ExceptionWithContext(sb2.append("invalid constant pool index ").append(Hex.m51u2(i2)).toString());
        throw exceptionWithContext2;
    }

    public Constant get(int i) {
        int i2 = i;
        try {
            Constant constant = this.entries[i2];
            if (constant == null) {
                Constant throwInvalid = throwInvalid(i2);
            }
            return constant;
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException indexOutOfBoundsException = e;
            return throwInvalid(i2);
        }
    }

    public Constant get0Ok(int i) {
        int i2 = i;
        if (i2 == 0) {
            return null;
        }
        return get(i2);
    }

    public Constant[] getEntries() {
        return this.entries;
    }

    public Constant getOrNull(int i) {
        int i2 = i;
        try {
            return this.entries[i2];
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException indexOutOfBoundsException = e;
            return throwInvalid(i2);
        }
    }

    public void set(int i, Constant constant) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        int i2 = i;
        Constant constant2 = constant;
        throwIfImmutable();
        boolean z = constant2 != null && constant2.isCategory2();
        if (i2 < 1) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("n < 1");
            throw illegalArgumentException3;
        }
        if (z) {
            if (i2 == -1 + this.entries.length) {
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("(n == size - 1) && cst.isCategory2()");
                throw illegalArgumentException5;
            }
            this.entries[i2 + 1] = null;
        }
        if (constant2 != null && this.entries[i2] == null) {
            Constant constant3 = this.entries[i2 - 1];
            if (constant3 != null && constant3.isCategory2()) {
                this.entries[i2 - 1] = null;
            }
        }
        this.entries[i2] = constant2;
    }

    public int size() {
        return this.entries.length;
    }
}
