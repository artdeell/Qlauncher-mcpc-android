package net.zhuoweizhang.boardwalk.com.android.dex;

import java.io.Serializable;
import net.zhuoweizhang.boardwalk.com.android.dex.util.Unsigned;

public final class TypeList implements Comparable<TypeList> {
    public static final TypeList EMPTY;
    private final Dex dex;
    private final short[] types;

    static {
        TypeList typeList;
        TypeList typeList2 = typeList;
        TypeList typeList3 = new TypeList(null, Dex.EMPTY_SHORT_ARRAY);
        EMPTY = typeList2;
    }

    public TypeList(Dex dex2, short[] sArr) {
        short[] sArr2 = sArr;
        this.dex = dex2;
        this.types = sArr2;
    }

    public int compareTo(TypeList typeList) {
        TypeList typeList2 = typeList;
        int i = 0;
        while (i < this.types.length && i < typeList2.types.length) {
            if (this.types[i] != typeList2.types[i]) {
                return Unsigned.compare(this.types[i], typeList2.types[i]);
            }
            i++;
        }
        return Unsigned.compare(this.types.length, typeList2.types.length);
    }

    public short[] getTypes() {
        return this.types;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("(");
        int length = this.types.length;
        for (int i = 0; i < length; i++) {
            StringBuilder append2 = sb4.append(this.dex != null ? (Serializable) this.dex.typeNames().get(this.types[i]) : Short.valueOf(this.types[i]));
        }
        StringBuilder append3 = sb4.append(")");
        return sb4.toString();
    }
}
