package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.io.PrintWriter;
import net.zhuoweizhang.boardwalk.com.android.dex.Leb128;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.AccessFlags;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFieldRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.EncodedField */
public final class EncodedField extends EncodedMember implements Comparable<EncodedField> {
    private final CstFieldRef field;

    public EncodedField(CstFieldRef cstFieldRef, int i) {
        NullPointerException nullPointerException;
        CstFieldRef cstFieldRef2 = cstFieldRef;
        super(i);
        if (cstFieldRef2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("field == null");
            throw nullPointerException2;
        }
        this.field = cstFieldRef2;
    }

    public void addContents(DexFile dexFile) {
        FieldIdItem intern = dexFile.getFieldIds().intern(this.field);
    }

    public int compareTo(EncodedField encodedField) {
        return this.field.compareTo((Constant) encodedField.field);
    }

    public void debugPrint(PrintWriter printWriter, boolean z) {
        boolean z2 = z;
        printWriter.println(toString());
    }

    public int encode(DexFile dexFile, AnnotatedOutput annotatedOutput, int i, int i2) {
        StringBuilder sb;
        StringBuilder sb2;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int i3 = i;
        int i4 = i2;
        int indexOf = dexFile.getFieldIds().indexOf(this.field);
        int i5 = indexOf - i3;
        int accessFlags = getAccessFlags();
        if (annotatedOutput2.annotates()) {
            annotatedOutput2.annotate(0, String.format("  [%x] %s", new Object[]{Integer.valueOf(i4), this.field.toHuman()}));
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            int unsignedLeb128Size = Leb128.unsignedLeb128Size(i5);
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            annotatedOutput3.annotate(unsignedLeb128Size, sb3.append("    field_idx:    ").append(Hex.m53u4(indexOf)).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            int unsignedLeb128Size2 = Leb128.unsignedLeb128Size(accessFlags);
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            annotatedOutput4.annotate(unsignedLeb128Size2, sb5.append("    access_flags: ").append(AccessFlags.fieldString(accessFlags)).toString());
        }
        int writeUleb128 = annotatedOutput2.writeUleb128(i5);
        int writeUleb1282 = annotatedOutput2.writeUleb128(accessFlags);
        return indexOf;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        return (obj2 instanceof EncodedField) && compareTo((EncodedField) obj2) == 0;
    }

    public CstString getName() {
        return this.field.getNat().getName();
    }

    public CstFieldRef getRef() {
        return this.field;
    }

    public int hashCode() {
        return this.field.hashCode();
    }

    public String toHuman() {
        return this.field.toHuman();
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
        StringBuffer append5 = stringBuffer4.append(this.field);
        StringBuffer append6 = stringBuffer4.append('}');
        return stringBuffer4.toString();
    }
}
