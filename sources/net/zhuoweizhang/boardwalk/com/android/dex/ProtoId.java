package net.zhuoweizhang.boardwalk.com.android.dex;

import net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section;
import net.zhuoweizhang.boardwalk.com.android.dex.util.Unsigned;

public final class ProtoId implements Comparable<ProtoId> {
    private final Dex dex;
    private final int parametersOffset;
    private final int returnTypeIndex;
    private final int shortyIndex;

    public ProtoId(Dex dex2, int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        this.dex = dex2;
        this.shortyIndex = i4;
        this.returnTypeIndex = i5;
        this.parametersOffset = i6;
    }

    public int compareTo(ProtoId protoId) {
        ProtoId protoId2 = protoId;
        return this.returnTypeIndex != protoId2.returnTypeIndex ? Unsigned.compare(this.returnTypeIndex, protoId2.returnTypeIndex) : Unsigned.compare(this.parametersOffset, protoId2.parametersOffset);
    }

    public int getParametersOffset() {
        return this.parametersOffset;
    }

    public int getReturnTypeIndex() {
        return this.returnTypeIndex;
    }

    public int getShortyIndex() {
        return this.shortyIndex;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2;
        if (this.dex == null) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            return sb3.append(this.shortyIndex).append(" ").append(this.returnTypeIndex).append(" ").append(this.parametersOffset).toString();
        }
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        return sb5.append((String) this.dex.strings().get(this.shortyIndex)).append(": ").append((String) this.dex.typeNames().get(this.returnTypeIndex)).append(" ").append(this.dex.readTypeList(this.parametersOffset)).toString();
    }

    public void writeTo(Section section) {
        Section section2 = section;
        section2.writeInt(this.shortyIndex);
        section2.writeInt(this.returnTypeIndex);
        section2.writeInt(this.parametersOffset);
    }
}
