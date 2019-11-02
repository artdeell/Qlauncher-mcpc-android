package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.io.PrintWriter;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvCode;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsnList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.LocalList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.PositionList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoItem */
public class DebugInfoItem extends OffsettedItem {
    private static final int ALIGNMENT = 1;
    private static final boolean ENABLE_ENCODER_SELF_CHECK = false;
    private final DalvCode code;
    private byte[] encoded;
    private final boolean isStatic;
    private final CstMethodRef ref;

    public DebugInfoItem(DalvCode dalvCode, boolean z, CstMethodRef cstMethodRef) {
        NullPointerException nullPointerException;
        DalvCode dalvCode2 = dalvCode;
        boolean z2 = z;
        CstMethodRef cstMethodRef2 = cstMethodRef;
        super(1, -1);
        if (dalvCode2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("code == null");
            throw nullPointerException2;
        }
        this.code = dalvCode2;
        this.isStatic = z2;
        this.ref = cstMethodRef2;
    }

    private byte[] encode(DexFile dexFile, String str, PrintWriter printWriter, AnnotatedOutput annotatedOutput, boolean z) {
        return encode0(dexFile, str, printWriter, annotatedOutput, z);
    }

    private byte[] encode0(DexFile dexFile, String str, PrintWriter printWriter, AnnotatedOutput annotatedOutput, boolean z) {
        DebugInfoEncoder debugInfoEncoder;
        DexFile dexFile2 = dexFile;
        String str2 = str;
        PrintWriter printWriter2 = printWriter;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        boolean z2 = z;
        PositionList positions = this.code.getPositions();
        LocalList locals = this.code.getLocals();
        DalvInsnList insns = this.code.getInsns();
        DebugInfoEncoder debugInfoEncoder2 = debugInfoEncoder;
        DebugInfoEncoder debugInfoEncoder3 = new DebugInfoEncoder(positions, locals, dexFile2, insns.codeSize(), insns.getRegistersSize(), this.isStatic, this.ref);
        DebugInfoEncoder debugInfoEncoder4 = debugInfoEncoder2;
        return (printWriter2 == null && annotatedOutput2 == null) ? debugInfoEncoder4.convert() : debugInfoEncoder4.convertAndAnnotate(str2, printWriter2, annotatedOutput2, z2);
    }

    public void addContents(DexFile dexFile) {
    }

    public void annotateTo(DexFile dexFile, AnnotatedOutput annotatedOutput, String str) {
        byte[] encode = encode(dexFile, str, null, annotatedOutput, false);
    }

    public void debugPrint(PrintWriter printWriter, String str) {
        byte[] encode = encode(null, str, printWriter, null, false);
    }

    public ItemType itemType() {
        return ItemType.TYPE_DEBUG_INFO_ITEM;
    }

    /* access modifiers changed from: protected */
    public void place0(Section section, int i) {
        StringBuilder sb;
        int i2 = i;
        try {
            this.encoded = encode(section.getFile(), null, null, null, false);
            setWriteSize(this.encoded.length);
        } catch (RuntimeException e) {
            RuntimeException runtimeException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            throw ExceptionWithContext.withContext(runtimeException, sb2.append("...while placing debug info for ").append(this.ref.toHuman()).toString());
        }
    }

    public String toHuman() {
        RuntimeException runtimeException;
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("unsupported");
        throw runtimeException2;
    }

    /* access modifiers changed from: protected */
    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            annotatedOutput3.annotate(sb2.append(offsetString()).append(" debug info").toString());
            byte[] encode = encode(dexFile2, null, null, annotatedOutput2, true);
        }
        annotatedOutput2.write(this.encoded);
    }
}
