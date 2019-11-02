package net.zhuoweizhang.boardwalk.com.android.dex;

import net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section;
import net.zhuoweizhang.boardwalk.com.android.dex.util.Unsigned;

public final class FieldId implements Comparable<FieldId> {
    private final int declaringClassIndex;
    private final Dex dex;
    private final int nameIndex;
    private final int typeIndex;

    public FieldId(Dex dex2, int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        this.dex = dex2;
        this.declaringClassIndex = i4;
        this.typeIndex = i5;
        this.nameIndex = i6;
    }

    public int compareTo(FieldId fieldId) {
        FieldId fieldId2 = fieldId;
        return this.declaringClassIndex != fieldId2.declaringClassIndex ? Unsigned.compare(this.declaringClassIndex, fieldId2.declaringClassIndex) : this.nameIndex != fieldId2.nameIndex ? Unsigned.compare(this.nameIndex, fieldId2.nameIndex) : Unsigned.compare(this.typeIndex, fieldId2.typeIndex);
    }

    public int getDeclaringClassIndex() {
        return this.declaringClassIndex;
    }

    public int getNameIndex() {
        return this.nameIndex;
    }

    public int getTypeIndex() {
        return this.typeIndex;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2;
        if (this.dex == null) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            return sb3.append(this.declaringClassIndex).append(" ").append(this.typeIndex).append(" ").append(this.nameIndex).toString();
        }
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        return sb5.append((String) this.dex.typeNames().get(this.typeIndex)).append(".").append((String) this.dex.strings().get(this.nameIndex)).toString();
    }

    public void writeTo(Section section) {
        Section section2 = section;
        section2.writeUnsignedShort(this.declaringClassIndex);
        section2.writeUnsignedShort(this.typeIndex);
        section2.writeInt(this.nameIndex);
    }
}
