package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstChar */
public final class CstChar extends CstLiteral32 {
    public static final CstChar VALUE_0 = make(0);

    private CstChar(char c) {
        super(c);
    }

    public static CstChar make(char c) {
        CstChar cstChar;
        CstChar cstChar2 = cstChar;
        CstChar cstChar3 = new CstChar(c);
        return cstChar2;
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [char] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstChar make(int r7) {
        /*
            r0 = r7
            r2 = r0
            char r2 = (char) r2
            r1 = r2
            r2 = r1
            r3 = r0
            if (r2 == r3) goto L_0x0028
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r6 = r2
            r2 = r6
            r3 = r6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r6 = r4
            r4 = r6
            r5 = r6
            r5.<init>()
            java.lang.String r5 = "bogus char value: "
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r0
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r2
        L_0x0028:
            r2 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstChar r2 = make(r2)
            r0 = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstChar.make(int):net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstChar");
    }

    public Type getType() {
        return Type.CHAR;
    }

    public char getValue() {
        return (char) getIntBits();
    }

    public String toHuman() {
        return Integer.toString(getIntBits());
    }

    public String toString() {
        StringBuilder sb;
        int intBits = getIntBits();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("char{0x").append(Hex.m51u2(intBits)).append(" / ").append(intBits).append('}').toString();
    }

    public String typeName() {
        return "char";
    }
}
