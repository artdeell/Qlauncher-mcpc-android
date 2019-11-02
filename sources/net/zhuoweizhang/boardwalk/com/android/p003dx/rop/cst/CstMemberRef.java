package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstMemberRef */
public abstract class CstMemberRef extends TypedConstant {
    private final CstType definingClass;
    private final CstNat nat;

    CstMemberRef(CstType cstType, CstNat cstNat) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        CstType cstType2 = cstType;
        CstNat cstNat2 = cstNat;
        if (cstType2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("definingClass == null");
            throw nullPointerException3;
        } else if (cstNat2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("nat == null");
            throw nullPointerException5;
        } else {
            this.definingClass = cstType2;
            this.nat = cstNat2;
        }
    }

    /* access modifiers changed from: protected */
    public int compareTo0(Constant constant) {
        CstMemberRef cstMemberRef = (CstMemberRef) constant;
        int compareTo = this.definingClass.compareTo((Constant) cstMemberRef.definingClass);
        return compareTo != 0 ? compareTo : this.nat.getName().compareTo((Constant) cstMemberRef.nat.getName());
    }

    public final boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 != null && getClass() == obj2.getClass()) {
            CstMemberRef cstMemberRef = (CstMemberRef) obj2;
            if (this.definingClass.equals(cstMemberRef.definingClass) && this.nat.equals(cstMemberRef.nat)) {
                return true;
            }
        }
        return false;
    }

    public final CstType getDefiningClass() {
        return this.definingClass;
    }

    public final CstNat getNat() {
        return this.nat;
    }

    public final int hashCode() {
        return (31 * this.definingClass.hashCode()) ^ this.nat.hashCode();
    }

    public final boolean isCategory2() {
        return false;
    }

    public final String toHuman() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(this.definingClass.toHuman()).append('.').append(this.nat.toHuman()).toString();
    }

    public final String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(typeName()).append('{').append(toHuman()).append('}').toString();
    }
}
