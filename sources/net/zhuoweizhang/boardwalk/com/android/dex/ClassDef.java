package net.zhuoweizhang.boardwalk.com.android.dex;

public final class ClassDef {
    public static final int NO_INDEX = -1;
    private final int accessFlags;
    private final int annotationsOffset;
    private final Dex buffer;
    private final int classDataOffset;
    private final int interfacesOffset;
    private final int offset;
    private final int sourceFileIndex;
    private final int staticValuesOffset;
    private final int supertypeIndex;
    private final int typeIndex;

    public ClassDef(Dex dex, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        this.buffer = dex;
        this.offset = i10;
        this.typeIndex = i11;
        this.accessFlags = i12;
        this.supertypeIndex = i13;
        this.interfacesOffset = i14;
        this.sourceFileIndex = i15;
        this.annotationsOffset = i16;
        this.classDataOffset = i17;
        this.staticValuesOffset = i18;
    }

    public int getAccessFlags() {
        return this.accessFlags;
    }

    public int getAnnotationsOffset() {
        return this.annotationsOffset;
    }

    public int getClassDataOffset() {
        return this.classDataOffset;
    }

    public short[] getInterfaces() {
        return this.buffer.readTypeList(this.interfacesOffset).getTypes();
    }

    public int getInterfacesOffset() {
        return this.interfacesOffset;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSourceFileIndex() {
        return this.sourceFileIndex;
    }

    public int getStaticValuesOffset() {
        return this.staticValuesOffset;
    }

    public int getSupertypeIndex() {
        return this.supertypeIndex;
    }

    public int getTypeIndex() {
        return this.typeIndex;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2;
        if (this.buffer == null) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            return sb3.append(this.typeIndex).append(" ").append(this.supertypeIndex).toString();
        }
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = sb5;
        StringBuilder append = sb7.append((String) this.buffer.typeNames().get(this.typeIndex));
        if (this.supertypeIndex != -1) {
            StringBuilder append2 = sb7.append(" extends ").append((String) this.buffer.typeNames().get(this.supertypeIndex));
        }
        return sb7.toString();
    }
}
