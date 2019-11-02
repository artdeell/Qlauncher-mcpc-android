package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstLiteralBits */
public abstract class CstLiteralBits extends TypedConstant {
    public CstLiteralBits() {
    }

    public boolean fitsIn16Bits() {
        if (fitsInInt()) {
            int intBits = getIntBits();
            if (((short) intBits) == intBits) {
                return true;
            }
        }
        return false;
    }

    public boolean fitsIn8Bits() {
        if (fitsInInt()) {
            int intBits = getIntBits();
            if (((byte) intBits) == intBits) {
                return true;
            }
        }
        return false;
    }

    public abstract boolean fitsInInt();

    public abstract int getIntBits();

    public abstract long getLongBits();
}
