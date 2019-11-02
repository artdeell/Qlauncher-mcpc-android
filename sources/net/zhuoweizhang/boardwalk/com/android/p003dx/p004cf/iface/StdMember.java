package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.StdMember */
public abstract class StdMember implements Member {
    private final int accessFlags;
    private final AttributeList attributes;
    private final CstType definingClass;
    private final CstNat nat;

    public StdMember(CstType cstType, int i, CstNat cstNat, AttributeList attributeList) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        NullPointerException nullPointerException3;
        CstType cstType2 = cstType;
        int i2 = i;
        CstNat cstNat2 = cstNat;
        AttributeList attributeList2 = attributeList;
        if (cstType2 == null) {
            NullPointerException nullPointerException4 = nullPointerException3;
            NullPointerException nullPointerException5 = new NullPointerException("definingClass == null");
            throw nullPointerException4;
        } else if (cstNat2 == null) {
            NullPointerException nullPointerException6 = nullPointerException2;
            NullPointerException nullPointerException7 = new NullPointerException("nat == null");
            throw nullPointerException6;
        } else if (attributeList2 == null) {
            NullPointerException nullPointerException8 = nullPointerException;
            NullPointerException nullPointerException9 = new NullPointerException("attributes == null");
            throw nullPointerException8;
        } else {
            this.definingClass = cstType2;
            this.accessFlags = i2;
            this.nat = cstNat2;
            this.attributes = attributeList2;
        }
    }

    public final int getAccessFlags() {
        return this.accessFlags;
    }

    public final AttributeList getAttributes() {
        return this.attributes;
    }

    public final CstType getDefiningClass() {
        return this.definingClass;
    }

    public final CstString getDescriptor() {
        return this.nat.getDescriptor();
    }

    public final CstString getName() {
        return this.nat.getName();
    }

    public final CstNat getNat() {
        return this.nat;
    }

    public String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append(getClass().getName());
        StringBuffer append2 = stringBuffer4.append('{');
        StringBuffer append3 = stringBuffer4.append(this.nat.toHuman());
        StringBuffer append4 = stringBuffer4.append('}');
        return stringBuffer4.toString();
    }
}
