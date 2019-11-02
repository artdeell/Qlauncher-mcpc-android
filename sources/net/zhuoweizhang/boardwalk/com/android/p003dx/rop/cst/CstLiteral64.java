package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstLiteral64 */
public abstract class CstLiteral64 extends CstLiteralBits {
    private final long bits;

    CstLiteral64(long j) {
        this.bits = j;
    }

    /* access modifiers changed from: protected */
    public int compareTo0(Constant constant) {
        long j = ((CstLiteral64) constant).bits;
        if (this.bits < j) {
            return -1;
        }
        return this.bits > j ? 1 : 0;
    }

    public final boolean equals(Object obj) {
        Object obj2 = obj;
        return obj2 != null && getClass() == obj2.getClass() && this.bits == ((CstLiteral64) obj2).bits;
    }

    public final boolean fitsInInt() {
        return ((long) ((int) this.bits)) == this.bits;
    }

    public final int getIntBits() {
        return (int) this.bits;
    }

    public final long getLongBits() {
        return this.bits;
    }

    public final int hashCode() {
        return ((int) this.bits) ^ ((int) (this.bits >> 32));
    }

    public final boolean isCategory2() {
        return true;
    }
}
