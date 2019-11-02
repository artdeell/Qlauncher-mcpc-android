package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvCode;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvCode.AssignIndicesCallback;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsnList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.CodeItem */
public final class CodeItem extends OffsettedItem {
    private static final int ALIGNMENT = 4;
    private static final int HEADER_SIZE = 16;
    private CatchStructs catches;
    private final DalvCode code;
    private DebugInfoItem debugInfo;
    private final boolean isStatic;
    private final CstMethodRef ref;
    private final TypeList throwsList;

    public CodeItem(CstMethodRef cstMethodRef, DalvCode dalvCode, boolean z, TypeList typeList) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        NullPointerException nullPointerException3;
        CstMethodRef cstMethodRef2 = cstMethodRef;
        DalvCode dalvCode2 = dalvCode;
        boolean z2 = z;
        TypeList typeList2 = typeList;
        super(4, -1);
        if (cstMethodRef2 == null) {
            NullPointerException nullPointerException4 = nullPointerException3;
            NullPointerException nullPointerException5 = new NullPointerException("ref == null");
            throw nullPointerException4;
        } else if (dalvCode2 == null) {
            NullPointerException nullPointerException6 = nullPointerException2;
            NullPointerException nullPointerException7 = new NullPointerException("code == null");
            throw nullPointerException6;
        } else if (typeList2 == null) {
            NullPointerException nullPointerException8 = nullPointerException;
            NullPointerException nullPointerException9 = new NullPointerException("throwsList == null");
            throw nullPointerException8;
        } else {
            this.ref = cstMethodRef2;
            this.code = dalvCode2;
            this.isStatic = z2;
            this.throwsList = typeList2;
            this.catches = null;
            this.debugInfo = null;
        }
    }

    private int getInsSize() {
        return this.ref.getParameterWordCount(this.isStatic);
    }

    private int getOutsSize() {
        return this.code.getInsns().getOutsSize();
    }

    private int getRegistersSize() {
        return this.code.getInsns().getRegistersSize();
    }

    private void writeCodes(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        DexFile dexFile2 = dexFile;
        try {
            this.code.getInsns().writeTo(annotatedOutput);
        } catch (RuntimeException e) {
            RuntimeException runtimeException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            throw ExceptionWithContext.withContext(runtimeException, sb2.append("...while writing instructions for ").append(this.ref.toHuman()).toString());
        }
    }

    public void addContents(DexFile dexFile) {
        CatchStructs catchStructs;
        DebugInfoItem debugInfoItem;
        DexFile dexFile2 = dexFile;
        MixedItemSection byteData = dexFile2.getByteData();
        TypeIdsSection typeIds = dexFile2.getTypeIds();
        if (this.code.hasPositions() || this.code.hasLocals()) {
            DebugInfoItem debugInfoItem2 = debugInfoItem;
            DebugInfoItem debugInfoItem3 = new DebugInfoItem(this.code, this.isStatic, this.ref);
            this.debugInfo = debugInfoItem2;
            byteData.add(this.debugInfo);
        }
        if (this.code.hasAnyCatches()) {
            Iterator it = this.code.getCatchTypes().iterator();
            while (it.hasNext()) {
                TypeIdItem intern = typeIds.intern((Type) it.next());
            }
            CatchStructs catchStructs2 = catchStructs;
            CatchStructs catchStructs3 = new CatchStructs(this.code);
            this.catches = catchStructs2;
        }
        Iterator it2 = this.code.getInsnConstants().iterator();
        while (it2.hasNext()) {
            dexFile2.internIfAppropriate((Constant) it2.next());
        }
    }

    public void debugPrint(PrintWriter printWriter, String str, boolean z) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        PrintWriter printWriter2 = printWriter;
        String str2 = str;
        boolean z2 = z;
        PrintWriter printWriter3 = printWriter2;
        StringBuilder sb4 = sb;
        StringBuilder sb5 = new StringBuilder();
        printWriter3.println(sb4.append(this.ref.toHuman()).append(":").toString());
        DalvInsnList insns = this.code.getInsns();
        PrintWriter printWriter4 = printWriter2;
        StringBuilder sb6 = sb2;
        StringBuilder sb7 = new StringBuilder();
        printWriter4.println(sb6.append("regs: ").append(Hex.m51u2(getRegistersSize())).append("; ins: ").append(Hex.m51u2(getInsSize())).append("; outs: ").append(Hex.m51u2(getOutsSize())).toString());
        insns.debugPrint((Writer) printWriter2, str2, z2);
        StringBuilder sb8 = sb3;
        StringBuilder sb9 = new StringBuilder();
        String sb10 = sb8.append(str2).append("  ").toString();
        if (this.catches != null) {
            printWriter2.print(str2);
            printWriter2.println("catches");
            this.catches.debugPrint(printWriter2, sb10);
        }
        if (this.debugInfo != null) {
            printWriter2.print(str2);
            printWriter2.println("debug info");
            this.debugInfo.debugPrint(printWriter2, sb10);
        }
    }

    public CstMethodRef getRef() {
        return this.ref;
    }

    public ItemType itemType() {
        return ItemType.TYPE_CODE_ITEM;
    }

    /* access modifiers changed from: protected */
    public void place0(Section section, int i) {
        C06641 r11;
        int i2;
        int i3 = i;
        DexFile file = section.getFile();
        DalvCode dalvCode = this.code;
        C06641 r7 = r11;
        final DexFile dexFile = file;
        C06641 r8 = new AssignIndicesCallback(this) {
            final /* synthetic */ CodeItem this$0;

            {
                DexFile dexFile = r7;
                this.this$0 = r6;
            }

            public int getIndex(Constant constant) {
                Constant constant2 = constant;
                IndexedItem findItemOrNull = dexFile.findItemOrNull(constant2);
                if (findItemOrNull == null) {
                    return -1;
                }
                return findItemOrNull.getIndex();
            }
        };
        dalvCode.assignIndices(r7);
        if (this.catches != null) {
            this.catches.encode(file);
            i2 = this.catches.writeSize();
        } else {
            i2 = 0;
        }
        int codeSize = this.code.getInsns().codeSize();
        if ((codeSize & 1) != 0) {
            codeSize++;
        }
        setWriteSize(i2 + 16 + (codeSize * 2));
    }

    public String toHuman() {
        return this.ref.toHuman();
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("CodeItem{").append(toHuman()).append("}").toString();
    }

    /* access modifiers changed from: protected */
    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        StringBuilder sb8;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        boolean annotates = annotatedOutput2.annotates();
        int registersSize = getRegistersSize();
        int outsSize = getOutsSize();
        int insSize = getInsSize();
        int codeSize = this.code.getInsns().codeSize();
        boolean z = (codeSize & 1) != 0;
        int triesSize = this.catches == null ? 0 : this.catches.triesSize();
        int absoluteOffset = this.debugInfo == null ? 0 : this.debugInfo.getAbsoluteOffset();
        if (annotates) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb9 = sb;
            StringBuilder sb10 = new StringBuilder();
            annotatedOutput3.annotate(0, sb9.append(offsetString()).append(' ').append(this.ref.toHuman()).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb11 = sb2;
            StringBuilder sb12 = new StringBuilder();
            annotatedOutput4.annotate(2, sb11.append("  registers_size: ").append(Hex.m51u2(registersSize)).toString());
            AnnotatedOutput annotatedOutput5 = annotatedOutput2;
            StringBuilder sb13 = sb3;
            StringBuilder sb14 = new StringBuilder();
            annotatedOutput5.annotate(2, sb13.append("  ins_size:       ").append(Hex.m51u2(insSize)).toString());
            AnnotatedOutput annotatedOutput6 = annotatedOutput2;
            StringBuilder sb15 = sb4;
            StringBuilder sb16 = new StringBuilder();
            annotatedOutput6.annotate(2, sb15.append("  outs_size:      ").append(Hex.m51u2(outsSize)).toString());
            AnnotatedOutput annotatedOutput7 = annotatedOutput2;
            StringBuilder sb17 = sb5;
            StringBuilder sb18 = new StringBuilder();
            annotatedOutput7.annotate(2, sb17.append("  tries_size:     ").append(Hex.m51u2(triesSize)).toString());
            AnnotatedOutput annotatedOutput8 = annotatedOutput2;
            StringBuilder sb19 = sb6;
            StringBuilder sb20 = new StringBuilder();
            annotatedOutput8.annotate(4, sb19.append("  debug_off:      ").append(Hex.m53u4(absoluteOffset)).toString());
            AnnotatedOutput annotatedOutput9 = annotatedOutput2;
            StringBuilder sb21 = sb7;
            StringBuilder sb22 = new StringBuilder();
            annotatedOutput9.annotate(4, sb21.append("  insns_size:     ").append(Hex.m53u4(codeSize)).toString());
            if (this.throwsList.size() != 0) {
                AnnotatedOutput annotatedOutput10 = annotatedOutput2;
                StringBuilder sb23 = sb8;
                StringBuilder sb24 = new StringBuilder();
                annotatedOutput10.annotate(0, sb23.append("  throws ").append(StdTypeList.toHuman(this.throwsList)).toString());
            }
        }
        annotatedOutput2.writeShort(registersSize);
        annotatedOutput2.writeShort(insSize);
        annotatedOutput2.writeShort(outsSize);
        annotatedOutput2.writeShort(triesSize);
        annotatedOutput2.writeInt(absoluteOffset);
        annotatedOutput2.writeInt(codeSize);
        writeCodes(dexFile2, annotatedOutput2);
        if (this.catches != null) {
            if (z) {
                if (annotates) {
                    annotatedOutput2.annotate(2, "  padding: 0");
                }
                annotatedOutput2.writeShort(0);
            }
            this.catches.writeTo(dexFile2, annotatedOutput2);
        }
        if (annotates && this.debugInfo != null) {
            annotatedOutput2.annotate(0, "  debug info");
            this.debugInfo.annotateTo(dexFile2, annotatedOutput2, "    ");
        }
    }
}
