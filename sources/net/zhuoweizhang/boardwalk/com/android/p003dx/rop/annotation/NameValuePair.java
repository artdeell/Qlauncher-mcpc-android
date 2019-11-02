package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.NameValuePair */
public final class NameValuePair implements Comparable<NameValuePair> {
    private final CstString name;
    private final Constant value;

    public NameValuePair(CstString cstString, Constant constant) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        CstString cstString2 = cstString;
        Constant constant2 = constant;
        if (cstString2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("name == null");
            throw nullPointerException3;
        } else if (constant2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("value == null");
            throw nullPointerException5;
        } else {
            this.name = cstString2;
            this.value = constant2;
        }
    }

    public int compareTo(NameValuePair nameValuePair) {
        NameValuePair nameValuePair2 = nameValuePair;
        int compareTo = this.name.compareTo((Constant) nameValuePair2.name);
        return compareTo != 0 ? compareTo : this.value.compareTo(nameValuePair2.value);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof NameValuePair) {
            NameValuePair nameValuePair = (NameValuePair) obj2;
            if (this.name.equals(nameValuePair.name) && this.value.equals(nameValuePair.value)) {
                return true;
            }
        }
        return false;
    }

    public CstString getName() {
        return this.name;
    }

    public Constant getValue() {
        return this.value;
    }

    public int hashCode() {
        return (31 * this.name.hashCode()) + this.value.hashCode();
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(this.name.toHuman()).append(":").append(this.value).toString();
    }
}
