package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstLong */
public final class CstLong extends CstLiteral64 {
    public static final CstLong VALUE_0 = make(0);
    public static final CstLong VALUE_1 = make(1);

    private CstLong(long j) {
        super(j);
    }

    public static CstLong make(long j) {
        CstLong cstLong;
        CstLong cstLong2 = cstLong;
        CstLong cstLong3 = new CstLong(j);
        return cstLong2;
    }

    public Type getType() {
        return Type.LONG;
    }

    public long getValue() {
        return getLongBits();
    }

    public String toHuman() {
        return Long.toString(getLongBits());
    }

    public String toString() {
        StringBuilder sb;
        long longBits = getLongBits();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("long{0x").append(Hex.m54u8(longBits)).append(" / ").append(longBits).append('}').toString();
    }

    public String typeName() {
        return "long";
    }
}
