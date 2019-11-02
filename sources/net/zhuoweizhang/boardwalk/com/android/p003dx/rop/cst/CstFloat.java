package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstFloat */
public final class CstFloat extends CstLiteral32 {
    public static final CstFloat VALUE_0 = make(Float.floatToIntBits(0.0f));
    public static final CstFloat VALUE_1 = make(Float.floatToIntBits(1.0f));
    public static final CstFloat VALUE_2 = make(Float.floatToIntBits(2.0f));

    private CstFloat(int i) {
        super(i);
    }

    public static CstFloat make(int i) {
        CstFloat cstFloat;
        CstFloat cstFloat2 = cstFloat;
        CstFloat cstFloat3 = new CstFloat(i);
        return cstFloat2;
    }

    public Type getType() {
        return Type.FLOAT;
    }

    public float getValue() {
        return Float.intBitsToFloat(getIntBits());
    }

    public String toHuman() {
        return Float.toString(Float.intBitsToFloat(getIntBits()));
    }

    public String toString() {
        StringBuilder sb;
        int intBits = getIntBits();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("float{0x").append(Hex.m53u4(intBits)).append(" / ").append(Float.intBitsToFloat(intBits)).append('}').toString();
    }

    public String typeName() {
        return "float";
    }
}
