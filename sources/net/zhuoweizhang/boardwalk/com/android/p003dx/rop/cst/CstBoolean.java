package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstBoolean */
public final class CstBoolean extends CstLiteral32 {
    public static final CstBoolean VALUE_FALSE;
    public static final CstBoolean VALUE_TRUE;

    static {
        CstBoolean cstBoolean;
        CstBoolean cstBoolean2;
        CstBoolean cstBoolean3 = cstBoolean;
        CstBoolean cstBoolean4 = new CstBoolean(false);
        VALUE_FALSE = cstBoolean3;
        CstBoolean cstBoolean5 = cstBoolean2;
        CstBoolean cstBoolean6 = new CstBoolean(true);
        VALUE_TRUE = cstBoolean5;
    }

    private CstBoolean(boolean z) {
        super(z ? 1 : 0);
    }

    public static CstBoolean make(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        if (i2 == 0) {
            return VALUE_FALSE;
        }
        if (i2 == 1) {
            return VALUE_TRUE;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("bogus value: ").append(i2).toString());
        throw illegalArgumentException2;
    }

    public static CstBoolean make(boolean z) {
        return z ? VALUE_TRUE : VALUE_FALSE;
    }

    public Type getType() {
        return Type.BOOLEAN;
    }

    public boolean getValue() {
        return getIntBits() != 0;
    }

    public String toHuman() {
        return getValue() ? "true" : "false";
    }

    public String toString() {
        return getValue() ? "boolean{true}" : "boolean{false}";
    }

    public String typeName() {
        return "boolean";
    }
}
