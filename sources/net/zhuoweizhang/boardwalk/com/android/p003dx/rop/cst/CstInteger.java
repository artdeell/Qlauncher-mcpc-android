package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstInteger */
public final class CstInteger extends CstLiteral32 {
    public static final CstInteger VALUE_0 = make(0);
    public static final CstInteger VALUE_1 = make(1);
    public static final CstInteger VALUE_2 = make(2);
    public static final CstInteger VALUE_3 = make(3);
    public static final CstInteger VALUE_4 = make(4);
    public static final CstInteger VALUE_5 = make(5);
    public static final CstInteger VALUE_M1 = make(-1);
    private static final CstInteger[] cache = new CstInteger[511];

    private CstInteger(int i) {
        super(i);
    }

    public static CstInteger make(int i) {
        CstInteger cstInteger;
        int i2 = i;
        int length = (Integer.MAX_VALUE & i2) % cache.length;
        CstInteger cstInteger2 = cache[length];
        if (cstInteger2 != null && cstInteger2.getValue() == i2) {
            return cstInteger2;
        }
        CstInteger cstInteger3 = cstInteger;
        CstInteger cstInteger4 = new CstInteger(i2);
        CstInteger cstInteger5 = cstInteger3;
        cache[length] = cstInteger5;
        return cstInteger5;
    }

    public Type getType() {
        return Type.INT;
    }

    public int getValue() {
        return getIntBits();
    }

    public String toHuman() {
        return Integer.toString(getIntBits());
    }

    public String toString() {
        StringBuilder sb;
        int intBits = getIntBits();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("int{0x").append(Hex.m53u4(intBits)).append(" / ").append(intBits).append('}').toString();
    }

    public String typeName() {
        return "int";
    }
}
