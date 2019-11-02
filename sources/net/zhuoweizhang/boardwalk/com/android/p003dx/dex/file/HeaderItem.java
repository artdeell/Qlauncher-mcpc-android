package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.dex.DexFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.HeaderItem */
public final class HeaderItem extends IndexedItem {
    public HeaderItem() {
    }

    public void addContents(DexFile dexFile) {
    }

    public ItemType itemType() {
        return ItemType.TYPE_HEADER_ITEM;
    }

    public int writeSize() {
        return 112;
    }

    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        CstString cstString;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int fileOffset = dexFile2.getMap().getFileOffset();
        Section firstDataSection = dexFile2.getFirstDataSection();
        Section lastDataSection = dexFile2.getLastDataSection();
        int fileOffset2 = firstDataSection.getFileOffset();
        int fileOffset3 = (lastDataSection.getFileOffset() + lastDataSection.writeSize()) - fileOffset2;
        String magic = dexFile2.getDexOptions().getMagic();
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb8 = sb3;
            StringBuilder sb9 = new StringBuilder();
            StringBuilder append = sb8.append("magic: ");
            CstString cstString2 = cstString;
            CstString cstString3 = new CstString(magic);
            annotatedOutput3.annotate(8, append.append(cstString2.toQuoted()).toString());
            annotatedOutput2.annotate(4, "checksum");
            annotatedOutput2.annotate(20, "signature");
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb10 = sb4;
            StringBuilder sb11 = new StringBuilder();
            annotatedOutput4.annotate(4, sb10.append("file_size:       ").append(Hex.m53u4(dexFile2.getFileSize())).toString());
            AnnotatedOutput annotatedOutput5 = annotatedOutput2;
            StringBuilder sb12 = sb5;
            StringBuilder sb13 = new StringBuilder();
            annotatedOutput5.annotate(4, sb12.append("header_size:     ").append(Hex.m53u4(112)).toString());
            AnnotatedOutput annotatedOutput6 = annotatedOutput2;
            StringBuilder sb14 = sb6;
            StringBuilder sb15 = new StringBuilder();
            annotatedOutput6.annotate(4, sb14.append("endian_tag:      ").append(Hex.m53u4(DexFormat.ENDIAN_TAG)).toString());
            annotatedOutput2.annotate(4, "link_size:       0");
            annotatedOutput2.annotate(4, "link_off:        0");
            AnnotatedOutput annotatedOutput7 = annotatedOutput2;
            StringBuilder sb16 = sb7;
            StringBuilder sb17 = new StringBuilder();
            annotatedOutput7.annotate(4, sb16.append("map_off:         ").append(Hex.m53u4(fileOffset)).toString());
        }
        for (int i = 0; i < 8; i++) {
            annotatedOutput2.writeByte(magic.charAt(i));
        }
        annotatedOutput2.writeZeroes(24);
        annotatedOutput2.writeInt(dexFile2.getFileSize());
        annotatedOutput2.writeInt(112);
        annotatedOutput2.writeInt(DexFormat.ENDIAN_TAG);
        annotatedOutput2.writeZeroes(8);
        annotatedOutput2.writeInt(fileOffset);
        dexFile2.getStringIds().writeHeaderPart(annotatedOutput2);
        dexFile2.getTypeIds().writeHeaderPart(annotatedOutput2);
        dexFile2.getProtoIds().writeHeaderPart(annotatedOutput2);
        dexFile2.getFieldIds().writeHeaderPart(annotatedOutput2);
        dexFile2.getMethodIds().writeHeaderPart(annotatedOutput2);
        dexFile2.getClassDefs().writeHeaderPart(annotatedOutput2);
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput8 = annotatedOutput2;
            StringBuilder sb18 = sb;
            StringBuilder sb19 = new StringBuilder();
            annotatedOutput8.annotate(4, sb18.append("data_size:       ").append(Hex.m53u4(fileOffset3)).toString());
            AnnotatedOutput annotatedOutput9 = annotatedOutput2;
            StringBuilder sb20 = sb2;
            StringBuilder sb21 = new StringBuilder();
            annotatedOutput9.annotate(4, sb20.append("data_off:        ").append(Hex.m53u4(fileOffset2)).toString());
        }
        annotatedOutput2.writeInt(fileOffset3);
        annotatedOutput2.writeInt(fileOffset2);
    }
}
