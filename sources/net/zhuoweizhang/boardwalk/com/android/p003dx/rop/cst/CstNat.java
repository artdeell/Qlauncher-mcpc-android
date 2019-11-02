package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstNat */
public final class CstNat extends Constant {
    public static final CstNat PRIMITIVE_TYPE_NAT;
    private final CstString descriptor;
    private final CstString name;

    static {
        CstNat cstNat;
        CstString cstString;
        CstString cstString2;
        CstNat cstNat2 = cstNat;
        CstString cstString3 = cstString;
        CstString cstString4 = new CstString("TYPE");
        CstString cstString5 = cstString2;
        CstString cstString6 = new CstString("Ljava/lang/Class;");
        CstNat cstNat3 = new CstNat(cstString3, cstString5);
        PRIMITIVE_TYPE_NAT = cstNat2;
    }

    public CstNat(CstString cstString, CstString cstString2) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        CstString cstString3 = cstString;
        CstString cstString4 = cstString2;
        if (cstString3 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("name == null");
            throw nullPointerException3;
        } else if (cstString4 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("descriptor == null");
            throw nullPointerException5;
        } else {
            this.name = cstString3;
            this.descriptor = cstString4;
        }
    }

    /* access modifiers changed from: protected */
    public int compareTo0(Constant constant) {
        CstNat cstNat = (CstNat) constant;
        int compareTo = this.name.compareTo((Constant) cstNat.name);
        return compareTo != 0 ? compareTo : this.descriptor.compareTo((Constant) cstNat.descriptor);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof CstNat) {
            CstNat cstNat = (CstNat) obj2;
            if (this.name.equals(cstNat.name) && this.descriptor.equals(cstNat.descriptor)) {
                return true;
            }
        }
        return false;
    }

    public CstString getDescriptor() {
        return this.descriptor;
    }

    public Type getFieldType() {
        return Type.intern(this.descriptor.getString());
    }

    public CstString getName() {
        return this.name;
    }

    public int hashCode() {
        return (31 * this.name.hashCode()) ^ this.descriptor.hashCode();
    }

    public boolean isCategory2() {
        return false;
    }

    public final boolean isClassInit() {
        return this.name.getString().equals("<clinit>");
    }

    public final boolean isInstanceInit() {
        return this.name.getString().equals("<init>");
    }

    public String toHuman() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(this.name.toHuman()).append(':').append(this.descriptor.toHuman()).toString();
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("nat{").append(toHuman()).append('}').toString();
    }

    public String typeName() {
        return "nat";
    }
}
