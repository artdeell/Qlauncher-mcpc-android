package net.zhuoweizhang.boardwalk.com.android.dex;

import net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section;
import net.zhuoweizhang.boardwalk.com.android.dex.util.Unsigned;

public final class MethodId implements Comparable<MethodId> {
    private final int declaringClassIndex;
    private final Dex dex;
    private final int nameIndex;
    private final int protoIndex;

    public MethodId(Dex dex2, int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        this.dex = dex2;
        this.declaringClassIndex = i4;
        this.protoIndex = i5;
        this.nameIndex = i6;
    }

    public int compareTo(MethodId methodId) {
        MethodId methodId2 = methodId;
        return this.declaringClassIndex != methodId2.declaringClassIndex ? Unsigned.compare(this.declaringClassIndex, methodId2.declaringClassIndex) : this.nameIndex != methodId2.nameIndex ? Unsigned.compare(this.nameIndex, methodId2.nameIndex) : Unsigned.compare(this.protoIndex, methodId2.protoIndex);
    }

    public int getDeclaringClassIndex() {
        return this.declaringClassIndex;
    }

    public int getNameIndex() {
        return this.nameIndex;
    }

    public int getProtoIndex() {
        return this.protoIndex;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2;
        if (this.dex == null) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            return sb3.append(this.declaringClassIndex).append(" ").append(this.protoIndex).append(" ").append(this.nameIndex).toString();
        }
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        return sb5.append((String) this.dex.typeNames().get(this.declaringClassIndex)).append(".").append((String) this.dex.strings().get(this.nameIndex)).append(this.dex.readTypeList(((ProtoId) this.dex.protoIds().get(this.protoIndex)).getParametersOffset())).toString();
    }

    public void writeTo(Section section) {
        Section section2 = section;
        section2.writeUnsignedShort(this.declaringClassIndex);
        section2.writeUnsignedShort(this.protoIndex);
        section2.writeInt(this.nameIndex);
    }
}
