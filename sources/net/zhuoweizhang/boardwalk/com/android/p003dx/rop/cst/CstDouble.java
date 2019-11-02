package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstDouble */
public final class CstDouble extends CstLiteral64 {
    public static final CstDouble VALUE_0;
    public static final CstDouble VALUE_1;

    static {
        CstDouble cstDouble;
        CstDouble cstDouble2;
        CstDouble cstDouble3 = cstDouble;
        CstDouble cstDouble4 = new CstDouble(Double.doubleToLongBits(0.0d));
        VALUE_0 = cstDouble3;
        CstDouble cstDouble5 = cstDouble2;
        CstDouble cstDouble6 = new CstDouble(Double.doubleToLongBits(1.0d));
        VALUE_1 = cstDouble5;
    }

    private CstDouble(long j) {
        super(j);
    }

    public static CstDouble make(long j) {
        CstDouble cstDouble;
        CstDouble cstDouble2 = cstDouble;
        CstDouble cstDouble3 = new CstDouble(j);
        return cstDouble2;
    }

    public Type getType() {
        return Type.DOUBLE;
    }

    public double getValue() {
        return Double.longBitsToDouble(getLongBits());
    }

    public String toHuman() {
        return Double.toString(Double.longBitsToDouble(getLongBits()));
    }

    public String toString() {
        StringBuilder sb;
        long longBits = getLongBits();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("double{0x").append(Hex.m54u8(longBits)).append(" / ").append(Double.longBitsToDouble(longBits)).append('}').toString();
    }

    public String typeName() {
        return "double";
    }
}
