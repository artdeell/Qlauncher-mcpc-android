package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.AttEnclosingMethod */
public final class AttEnclosingMethod extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "EnclosingMethod";
    private final CstNat method;
    private final CstType type;

    public AttEnclosingMethod(CstType cstType, CstNat cstNat) {
        NullPointerException nullPointerException;
        CstType cstType2 = cstType;
        CstNat cstNat2 = cstNat;
        super(ATTRIBUTE_NAME);
        if (cstType2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("type == null");
            throw nullPointerException2;
        }
        this.type = cstType2;
        this.method = cstNat2;
    }

    public int byteLength() {
        return 10;
    }

    public CstType getEnclosingClass() {
        return this.type;
    }

    public CstNat getMethod() {
        return this.method;
    }
}
