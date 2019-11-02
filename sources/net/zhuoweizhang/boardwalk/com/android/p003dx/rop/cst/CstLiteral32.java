package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstLiteral32 */
public abstract class CstLiteral32 extends CstLiteralBits {
    private final int bits;

    CstLiteral32(int i) {
        this.bits = i;
    }

    /* access modifiers changed from: protected */
    public int compareTo0(Constant constant) {
        int i = ((CstLiteral32) constant).bits;
        if (this.bits < i) {
            return -1;
        }
        return this.bits > i ? 1 : 0;
    }

    public final boolean equals(Object obj) {
        Object obj2 = obj;
        return obj2 != null && getClass() == obj2.getClass() && this.bits == ((CstLiteral32) obj2).bits;
    }

    public final boolean fitsInInt() {
        return true;
    }

    public final int getIntBits() {
        return this.bits;
    }

    public final long getLongBits() {
        return (long) this.bits;
    }

    public final int hashCode() {
        return this.bits;
    }

    public final boolean isCategory2() {
        return false;
    }
}
