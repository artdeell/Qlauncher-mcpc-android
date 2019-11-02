package net.zhuoweizhang.boardwalk.com.android.dex;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.lwjgl.opencl.KHRGLSharing;

public final class TableOfContents {
    public final Section annotationSetRefLists;
    public final Section annotationSets;
    public final Section annotations;
    public final Section annotationsDirectories;
    public int checksum;
    public final Section classDatas;
    public final Section classDefs;
    public final Section codes;
    public int dataOff;
    public int dataSize;
    public final Section debugInfos;
    public final Section encodedArrays;
    public final Section fieldIds;
    public int fileSize;
    public final Section header;
    public int linkOff;
    public int linkSize;
    public final Section mapList;
    public final Section methodIds;
    public final Section protoIds;
    public final Section[] sections;
    public byte[] signature = new byte[20];
    public final Section stringDatas;
    public final Section stringIds;
    public final Section typeIds;
    public final Section typeLists;

    public static class Section implements Comparable<Section> {
        public int byteCount = 0;
        public int off = -1;
        public int size = 0;
        public final short type;

        public Section(int i) {
            int i2 = i;
            this.type = (short) i2;
        }

        public int compareTo(Section section) {
            Section section2 = section;
            if (this.off != section2.off) {
                return this.off < section2.off ? -1 : 1;
            }
            return 0;
        }

        public boolean exists() {
            return this.size > 0;
        }

        public String toString() {
            return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[]{Short.valueOf(this.type), Integer.valueOf(this.off), Integer.valueOf(this.size)});
        }
    }

    public TableOfContents() {
        Section section;
        Section section2;
        Section section3;
        Section section4;
        Section section5;
        Section section6;
        Section section7;
        Section section8;
        Section section9;
        Section section10;
        Section section11;
        Section section12;
        Section section13;
        Section section14;
        Section section15;
        Section section16;
        Section section17;
        Section section18;
        Section section19 = section;
        Section section20 = new Section(0);
        this.header = section19;
        Section section21 = section2;
        Section section22 = new Section(1);
        this.stringIds = section21;
        Section section23 = section3;
        Section section24 = new Section(2);
        this.typeIds = section23;
        Section section25 = section4;
        Section section26 = new Section(3);
        this.protoIds = section25;
        Section section27 = section5;
        Section section28 = new Section(4);
        this.fieldIds = section27;
        Section section29 = section6;
        Section section30 = new Section(5);
        this.methodIds = section29;
        Section section31 = section7;
        Section section32 = new Section(6);
        this.classDefs = section31;
        Section section33 = section8;
        Section section34 = new Section(4096);
        this.mapList = section33;
        Section section35 = section9;
        Section section36 = new Section(4097);
        this.typeLists = section35;
        Section section37 = section10;
        Section section38 = new Section(4098);
        this.annotationSetRefLists = section37;
        Section section39 = section11;
        Section section40 = new Section(4099);
        this.annotationSets = section39;
        Section section41 = section12;
        Section section42 = new Section(8192);
        this.classDatas = section41;
        Section section43 = section13;
        Section section44 = new Section(8193);
        this.codes = section43;
        Section section45 = section14;
        Section section46 = new Section(8194);
        this.stringDatas = section45;
        Section section47 = section15;
        Section section48 = new Section(8195);
        this.debugInfos = section47;
        Section section49 = section16;
        Section section50 = new Section(8196);
        this.annotations = section49;
        Section section51 = section17;
        Section section52 = new Section(8197);
        this.encodedArrays = section51;
        Section section53 = section18;
        Section section54 = new Section(KHRGLSharing.CL_CURRENT_DEVICE_FOR_GL_CONTEXT_KHR);
        this.annotationsDirectories = section53;
        Section[] sectionArr = new Section[18];
        sectionArr[0] = this.header;
        sectionArr[1] = this.stringIds;
        sectionArr[2] = this.typeIds;
        sectionArr[3] = this.protoIds;
        sectionArr[4] = this.fieldIds;
        sectionArr[5] = this.methodIds;
        sectionArr[6] = this.classDefs;
        sectionArr[7] = this.mapList;
        sectionArr[8] = this.typeLists;
        sectionArr[9] = this.annotationSetRefLists;
        sectionArr[10] = this.annotationSets;
        sectionArr[11] = this.classDatas;
        sectionArr[12] = this.codes;
        sectionArr[13] = this.stringDatas;
        sectionArr[14] = this.debugInfos;
        sectionArr[15] = this.annotations;
        sectionArr[16] = this.encodedArrays;
        sectionArr[17] = this.annotationsDirectories;
        this.sections = sectionArr;
    }

    private Section getSection(short s) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        short s2 = s;
        Section[] sectionArr = this.sections;
        int length = sectionArr.length;
        for (int i = 0; i < length; i++) {
            Section section = sectionArr[i];
            if (section.type == s2) {
                return section;
            }
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("No such map item: ").append(s2).toString());
        throw illegalArgumentException2;
    }

    private void readHeader(net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section section) throws UnsupportedEncodingException {
        DexException dexException;
        DexException dexException2;
        StringBuilder sb;
        DexException dexException3;
        StringBuilder sb2;
        DexException dexException4;
        StringBuilder sb3;
        net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section section2 = section;
        byte[] readByteArray = section2.readByteArray(8);
        if (DexFormat.magicToApi(readByteArray) != 13) {
            DexException dexException5 = dexException4;
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            DexException dexException6 = new DexException(sb4.append("Unexpected magic: ").append(Arrays.toString(readByteArray)).toString());
            throw dexException5;
        }
        this.checksum = section2.readInt();
        this.signature = section2.readByteArray(20);
        this.fileSize = section2.readInt();
        int readInt = section2.readInt();
        if (readInt != 112) {
            DexException dexException7 = dexException3;
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            DexException dexException8 = new DexException(sb6.append("Unexpected header: 0x").append(Integer.toHexString(readInt)).toString());
            throw dexException7;
        }
        int readInt2 = section2.readInt();
        if (readInt2 != 305419896) {
            DexException dexException9 = dexException2;
            StringBuilder sb8 = sb;
            StringBuilder sb9 = new StringBuilder();
            DexException dexException10 = new DexException(sb8.append("Unexpected endian tag: 0x").append(Integer.toHexString(readInt2)).toString());
            throw dexException9;
        }
        this.linkSize = section2.readInt();
        this.linkOff = section2.readInt();
        this.mapList.off = section2.readInt();
        if (this.mapList.off == 0) {
            DexException dexException11 = dexException;
            DexException dexException12 = new DexException("Cannot merge dex files that do not contain a map");
            throw dexException11;
        }
        this.stringIds.size = section2.readInt();
        this.stringIds.off = section2.readInt();
        this.typeIds.size = section2.readInt();
        this.typeIds.off = section2.readInt();
        this.protoIds.size = section2.readInt();
        this.protoIds.off = section2.readInt();
        this.fieldIds.size = section2.readInt();
        this.fieldIds.off = section2.readInt();
        this.methodIds.size = section2.readInt();
        this.methodIds.off = section2.readInt();
        this.classDefs.size = section2.readInt();
        this.classDefs.off = section2.readInt();
        this.dataSize = section2.readInt();
        this.dataOff = section2.readInt();
    }

    private void readMap(net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section section) throws IOException {
        DexException dexException;
        StringBuilder sb;
        DexException dexException2;
        StringBuilder sb2;
        net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section section2 = section;
        int readInt = section2.readInt();
        Section section3 = null;
        int i = 0;
        while (i < readInt) {
            short readShort = section2.readShort();
            short readShort2 = section2.readShort();
            Section section4 = getSection(readShort);
            int readInt2 = section2.readInt();
            int readInt3 = section2.readInt();
            if ((section4.size == 0 || section4.size == readInt2) && (section4.off == -1 || section4.off == readInt3)) {
                section4.size = readInt2;
                section4.off = readInt3;
                if (section3 == null || section3.off <= section4.off) {
                    i++;
                    section3 = section4;
                } else {
                    DexException dexException3 = dexException2;
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    DexException dexException4 = new DexException(sb3.append("Map is unsorted at ").append(section3).append(", ").append(section4).toString());
                    throw dexException3;
                }
            } else {
                DexException dexException5 = dexException;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                DexException dexException6 = new DexException(sb5.append("Unexpected map value for 0x").append(Integer.toHexString(readShort)).toString());
                throw dexException5;
            }
        }
        Arrays.sort(this.sections);
    }

    public void computeSizesFromOffsets() {
        DexException dexException;
        StringBuilder sb;
        int i = this.dataOff + this.dataSize;
        for (int length = -1 + this.sections.length; length >= 0; length--) {
            Section section = this.sections[length];
            if (section.off != -1) {
                if (section.off > i) {
                    DexException dexException2 = dexException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    DexException dexException3 = new DexException(sb2.append("Map is unsorted at ").append(section).toString());
                    throw dexException2;
                }
                section.byteCount = i - section.off;
                i = section.off;
            }
        }
    }

    public void readFrom(Dex dex) throws IOException {
        Dex dex2 = dex;
        readHeader(dex2.open(0));
        readMap(dex2.open(this.mapList.off));
        computeSizesFromOffsets();
    }

    public void writeHeader(net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section section) throws IOException {
        net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section section2 = section;
        section2.write(DexFormat.apiToMagic(13).getBytes("UTF-8"));
        section2.writeInt(this.checksum);
        section2.write(this.signature);
        section2.writeInt(this.fileSize);
        section2.writeInt(112);
        section2.writeInt(DexFormat.ENDIAN_TAG);
        section2.writeInt(this.linkSize);
        section2.writeInt(this.linkOff);
        section2.writeInt(this.mapList.off);
        section2.writeInt(this.stringIds.size);
        section2.writeInt(this.stringIds.off);
        section2.writeInt(this.typeIds.size);
        section2.writeInt(this.typeIds.off);
        section2.writeInt(this.protoIds.size);
        section2.writeInt(this.protoIds.off);
        section2.writeInt(this.fieldIds.size);
        section2.writeInt(this.fieldIds.off);
        section2.writeInt(this.methodIds.size);
        section2.writeInt(this.methodIds.off);
        section2.writeInt(this.classDefs.size);
        section2.writeInt(this.classDefs.off);
        section2.writeInt(this.dataSize);
        section2.writeInt(this.dataOff);
    }

    public void writeMap(net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section section) throws IOException {
        net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section section2 = section;
        Section[] sectionArr = this.sections;
        int length = sectionArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (sectionArr[i2].exists()) {
                i++;
            }
        }
        section2.writeInt(i);
        Section[] sectionArr2 = this.sections;
        int length2 = sectionArr2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            Section section3 = sectionArr2[i3];
            if (section3.exists()) {
                section2.writeShort(section3.type);
                section2.writeShort(0);
                section2.writeInt(section3.size);
                section2.writeInt(section3.off);
            }
        }
    }
}
