package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Zeroes */
public final class Zeroes {
    private Zeroes() {
    }

    public static Constant zeroFor(Type type) {
        UnsupportedOperationException unsupportedOperationException;
        StringBuilder sb;
        Type type2 = type;
        switch (type2.getBasicType()) {
            case 1:
                return CstBoolean.VALUE_FALSE;
            case 2:
                return CstByte.VALUE_0;
            case 3:
                return CstChar.VALUE_0;
            case 4:
                return CstDouble.VALUE_0;
            case 5:
                return CstFloat.VALUE_0;
            case 6:
                return CstInteger.VALUE_0;
            case 7:
                return CstLong.VALUE_0;
            case 8:
                return CstShort.VALUE_0;
            case 9:
                return CstKnownNull.THE_ONE;
            default:
                UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(sb2.append("no zero for type: ").append(type2.toHuman()).toString());
                throw unsupportedOperationException2;
        }
    }
}
