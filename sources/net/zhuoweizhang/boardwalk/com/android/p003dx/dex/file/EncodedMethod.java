package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.io.PrintWriter;
import net.zhuoweizhang.boardwalk.com.android.dex.Leb128;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvCode;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.AccessFlags;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import org.lwjgl.opengl.GL11;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.EncodedMethod */
public final class EncodedMethod extends EncodedMember implements Comparable<EncodedMethod> {
    private final CodeItem code;
    private final CstMethodRef method;

    public EncodedMethod(CstMethodRef cstMethodRef, int i, DalvCode dalvCode, TypeList typeList) {
        CodeItem codeItem;
        NullPointerException nullPointerException;
        CstMethodRef cstMethodRef2 = cstMethodRef;
        int i2 = i;
        DalvCode dalvCode2 = dalvCode;
        TypeList typeList2 = typeList;
        super(i2);
        if (cstMethodRef2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("method == null");
            throw nullPointerException2;
        }
        this.method = cstMethodRef2;
        if (dalvCode2 == null) {
            this.code = null;
            return;
        }
        CodeItem codeItem2 = codeItem;
        CodeItem codeItem3 = new CodeItem(cstMethodRef2, dalvCode2, (i2 & 8) != 0, typeList2);
        this.code = codeItem2;
    }

    public void addContents(DexFile dexFile) {
        DexFile dexFile2 = dexFile;
        MethodIdsSection methodIds = dexFile2.getMethodIds();
        MixedItemSection wordData = dexFile2.getWordData();
        MethodIdItem intern = methodIds.intern(this.method);
        if (this.code != null) {
            wordData.add(this.code);
        }
    }

    public int compareTo(EncodedMethod encodedMethod) {
        return this.method.compareTo((Constant) encodedMethod.method);
    }

    public void debugPrint(PrintWriter printWriter, boolean z) {
        StringBuilder sb;
        PrintWriter printWriter2 = printWriter;
        boolean z2 = z;
        if (this.code == null) {
            PrintWriter printWriter3 = printWriter2;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printWriter3.println(sb2.append(getRef().toHuman()).append(": abstract or native").toString());
            return;
        }
        this.code.debugPrint(printWriter2, "  ", z2);
    }

    public int encode(DexFile dexFile, AnnotatedOutput annotatedOutput, int i, int i2) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        UnsupportedOperationException unsupportedOperationException;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int i3 = i;
        int i4 = i2;
        int indexOf = dexFile.getMethodIds().indexOf(this.method);
        int i5 = indexOf - i3;
        int accessFlags = getAccessFlags();
        int absoluteOffsetOr0 = OffsettedItem.getAbsoluteOffsetOr0(this.code);
        if ((absoluteOffsetOr0 != 0) != ((accessFlags & GL11.GL_INVALID_ENUM) == 0)) {
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("code vs. access_flags mismatch");
            throw unsupportedOperationException2;
        }
        if (annotatedOutput2.annotates()) {
            annotatedOutput2.annotate(0, String.format("  [%x] %s", new Object[]{Integer.valueOf(i4), this.method.toHuman()}));
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            int unsignedLeb128Size = Leb128.unsignedLeb128Size(i5);
            StringBuilder sb4 = sb;
            StringBuilder sb5 = new StringBuilder();
            annotatedOutput3.annotate(unsignedLeb128Size, sb4.append("    method_idx:   ").append(Hex.m53u4(indexOf)).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            int unsignedLeb128Size2 = Leb128.unsignedLeb128Size(accessFlags);
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            annotatedOutput4.annotate(unsignedLeb128Size2, sb6.append("    access_flags: ").append(AccessFlags.methodString(accessFlags)).toString());
            AnnotatedOutput annotatedOutput5 = annotatedOutput2;
            int unsignedLeb128Size3 = Leb128.unsignedLeb128Size(absoluteOffsetOr0);
            StringBuilder sb8 = sb3;
            StringBuilder sb9 = new StringBuilder();
            annotatedOutput5.annotate(unsignedLeb128Size3, sb8.append("    code_off:     ").append(Hex.m53u4(absoluteOffsetOr0)).toString());
        }
        int writeUleb128 = annotatedOutput2.writeUleb128(i5);
        int writeUleb1282 = annotatedOutput2.writeUleb128(accessFlags);
        int writeUleb1283 = annotatedOutput2.writeUleb128(absoluteOffsetOr0);
        return indexOf;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        return (obj2 instanceof EncodedMethod) && compareTo((EncodedMethod) obj2) == 0;
    }

    public final CstString getName() {
        return this.method.getNat().getName();
    }

    public final CstMethodRef getRef() {
        return this.method;
    }

    public final String toHuman() {
        return this.method.toHuman();
    }

    public String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append(getClass().getName());
        StringBuffer append2 = stringBuffer4.append('{');
        StringBuffer append3 = stringBuffer4.append(Hex.m51u2(getAccessFlags()));
        StringBuffer append4 = stringBuffer4.append(' ');
        StringBuffer append5 = stringBuffer4.append(this.method);
        if (this.code != null) {
            StringBuffer append6 = stringBuffer4.append(' ');
            StringBuffer append7 = stringBuffer4.append(this.code);
        }
        StringBuffer append8 = stringBuffer4.append('}');
        return stringBuffer4.toString();
    }
}
