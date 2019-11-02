package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstShort */
public final class CstShort extends CstLiteral32 {
    public static final CstShort VALUE_0 = make(0);

    private CstShort(short s) {
        super(s);
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstShort make(int r7) {
        /*
            r0 = r7
            r2 = r0
            short r2 = (short) r2
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
            java.lang.String r5 = "bogus short value: "
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r0
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r2
        L_0x0028:
            r2 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstShort r2 = make(r2)
            r0 = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstShort.make(int):net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstShort");
    }

    public static CstShort make(short s) {
        CstShort cstShort;
        CstShort cstShort2 = cstShort;
        CstShort cstShort3 = new CstShort(s);
        return cstShort2;
    }

    public Type getType() {
        return Type.SHORT;
    }

    public short getValue() {
        return (short) getIntBits();
    }

    public String toHuman() {
        return Integer.toString(getIntBits());
    }

    public String toString() {
        StringBuilder sb;
        int intBits = getIntBits();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("short{0x").append(Hex.m51u2(intBits)).append(" / ").append(intBits).append('}').toString();
    }

    public String typeName() {
        return "short";
    }
}
