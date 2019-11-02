package net.zhuoweizhang.boardwalk.com.android.dex;

import net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section;

public final class Annotation implements Comparable<Annotation> {
    private final Dex dex;
    private final EncodedValue encodedAnnotation;
    private final byte visibility;

    public Annotation(Dex dex2, byte b, EncodedValue encodedValue) {
        byte b2 = b;
        EncodedValue encodedValue2 = encodedValue;
        this.dex = dex2;
        this.visibility = b2;
        this.encodedAnnotation = encodedValue2;
    }

    public int compareTo(Annotation annotation) {
        return this.encodedAnnotation.compareTo(annotation.encodedAnnotation);
    }

    public EncodedValueReader getReader() {
        EncodedValueReader encodedValueReader;
        EncodedValueReader encodedValueReader2 = encodedValueReader;
        EncodedValueReader encodedValueReader3 = new EncodedValueReader(this.encodedAnnotation, 29);
        return encodedValueReader2;
    }

    public int getTypeIndex() {
        EncodedValueReader reader = getReader();
        int readAnnotation = reader.readAnnotation();
        return reader.getAnnotationType();
    }

    public byte getVisibility() {
        return this.visibility;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2;
        if (this.dex == null) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            return sb3.append(this.visibility).append(" ").append(getTypeIndex()).toString();
        }
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        return sb5.append(this.visibility).append(" ").append((String) this.dex.typeNames().get(getTypeIndex())).toString();
    }

    public void writeTo(Section section) {
        Section section2 = section;
        section2.writeByte(this.visibility);
        this.encodedAnnotation.writeTo(section2);
    }
}
