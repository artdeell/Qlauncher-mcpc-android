package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.LocalItem */
public class LocalItem implements Comparable<LocalItem> {
    private final CstString name;
    private final CstString signature;

    private LocalItem(CstString cstString, CstString cstString2) {
        CstString cstString3 = cstString2;
        this.name = cstString;
        this.signature = cstString3;
    }

    private static int compareHandlesNulls(CstString cstString, CstString cstString2) {
        CstString cstString3 = cstString;
        CstString cstString4 = cstString2;
        if (cstString3 == cstString4) {
            return 0;
        }
        if (cstString3 == null) {
            return -1;
        }
        if (cstString4 == null) {
            return 1;
        }
        return cstString3.compareTo((Constant) cstString4);
    }

    public static LocalItem make(CstString cstString, CstString cstString2) {
        LocalItem localItem;
        CstString cstString3 = cstString;
        CstString cstString4 = cstString2;
        if (cstString3 == null && cstString4 == null) {
            return null;
        }
        LocalItem localItem2 = localItem;
        LocalItem localItem3 = new LocalItem(cstString3, cstString4);
        return localItem2;
    }

    public int compareTo(LocalItem localItem) {
        LocalItem localItem2 = localItem;
        int compareHandlesNulls = compareHandlesNulls(this.name, localItem2.name);
        return compareHandlesNulls != 0 ? compareHandlesNulls : compareHandlesNulls(this.signature, localItem2.signature);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        return (obj2 instanceof LocalItem) && compareTo((LocalItem) obj2) == 0;
    }

    public CstString getName() {
        return this.name;
    }

    public CstString getSignature() {
        return this.signature;
    }

    public int hashCode() {
        int hashCode = (this.name == null ? 0 : this.name.hashCode()) * 31;
        int i = 0;
        if (this.signature != null) {
            i = this.signature.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb;
        if (this.name != null && this.signature == null) {
            return this.name.toQuoted();
        }
        if (this.name == null && this.signature == null) {
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("[").append(this.name == null ? LibrariesRepository.MOJANG_MAVEN_REPO : this.name.toQuoted()).append("|").append(this.signature == null ? LibrariesRepository.MOJANG_MAVEN_REPO : this.signature.toQuoted()).toString();
    }
}
