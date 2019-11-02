package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.AttSignature */
public final class AttSignature extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "Signature";
    private final CstString signature;

    public AttSignature(CstString cstString) {
        NullPointerException nullPointerException;
        CstString cstString2 = cstString;
        super(ATTRIBUTE_NAME);
        if (cstString2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("signature == null");
            throw nullPointerException2;
        }
        this.signature = cstString2;
    }

    public int byteLength() {
        return 8;
    }

    public CstString getSignature() {
        return this.signature;
    }
}
