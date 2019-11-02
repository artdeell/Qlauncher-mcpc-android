package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMemberRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.MemberIdItem */
public abstract class MemberIdItem extends IdItem {
    private final CstMemberRef cst;

    public MemberIdItem(CstMemberRef cstMemberRef) {
        CstMemberRef cstMemberRef2 = cstMemberRef;
        super(cstMemberRef2.getDefiningClass());
        this.cst = cstMemberRef2;
    }

    public void addContents(DexFile dexFile) {
        DexFile dexFile2 = dexFile;
        super.addContents(dexFile2);
        StringIdItem intern = dexFile2.getStringIds().intern(getRef().getNat().getName());
    }

    public final CstMemberRef getRef() {
        return this.cst;
    }

    /* access modifiers changed from: protected */
    public abstract int getTypoidIdx(DexFile dexFile);

    /* access modifiers changed from: protected */
    public abstract String getTypoidName();

    public int writeSize() {
        return 8;
    }

    public final void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        TypeIdsSection typeIds = dexFile2.getTypeIds();
        StringIdsSection stringIds = dexFile2.getStringIds();
        CstNat nat = this.cst.getNat();
        int indexOf = typeIds.indexOf(getDefiningClass());
        int indexOf2 = stringIds.indexOf(nat.getName());
        int typoidIdx = getTypoidIdx(dexFile2);
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            annotatedOutput3.annotate(0, sb5.append(indexString()).append(' ').append(this.cst.toHuman()).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb7 = sb2;
            StringBuilder sb8 = new StringBuilder();
            annotatedOutput4.annotate(2, sb7.append("  class_idx: ").append(Hex.m51u2(indexOf)).toString());
            Object[] objArr = new Object[2];
            Object[] objArr2 = objArr;
            StringBuilder sb9 = sb3;
            StringBuilder sb10 = new StringBuilder();
            objArr2[0] = sb9.append(getTypoidName()).append(':').toString();
            objArr[1] = Hex.m51u2(typoidIdx);
            annotatedOutput2.annotate(2, String.format("  %-10s %s", objArr));
            AnnotatedOutput annotatedOutput5 = annotatedOutput2;
            StringBuilder sb11 = sb4;
            StringBuilder sb12 = new StringBuilder();
            annotatedOutput5.annotate(4, sb11.append("  name_idx:  ").append(Hex.m53u4(indexOf2)).toString());
        }
        annotatedOutput2.writeShort(indexOf);
        annotatedOutput2.writeShort(typoidIdx);
        annotatedOutput2.writeInt(indexOf2);
    }
}
