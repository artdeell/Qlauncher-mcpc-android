package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArrayAnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.EncodedArrayItem */
public final class EncodedArrayItem extends OffsettedItem {
    private static final int ALIGNMENT = 1;
    private final CstArray array;
    private byte[] encodedForm;

    public EncodedArrayItem(CstArray cstArray) {
        NullPointerException nullPointerException;
        CstArray cstArray2 = cstArray;
        super(1, -1);
        if (cstArray2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("array == null");
            throw nullPointerException2;
        }
        this.array = cstArray2;
        this.encodedForm = null;
    }

    public void addContents(DexFile dexFile) {
        ValueEncoder.addContents(dexFile, (Constant) this.array);
    }

    /* access modifiers changed from: protected */
    public int compareTo0(OffsettedItem offsettedItem) {
        return this.array.compareTo((Constant) ((EncodedArrayItem) offsettedItem).array);
    }

    public int hashCode() {
        return this.array.hashCode();
    }

    public ItemType itemType() {
        return ItemType.TYPE_ENCODED_ARRAY_ITEM;
    }

    /* access modifiers changed from: protected */
    public void place0(Section section, int i) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput;
        ValueEncoder valueEncoder;
        Section section2 = section;
        int i2 = i;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput2 = byteArrayAnnotatedOutput;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput3 = new ByteArrayAnnotatedOutput();
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput4 = byteArrayAnnotatedOutput2;
        ValueEncoder valueEncoder2 = valueEncoder;
        ValueEncoder valueEncoder3 = new ValueEncoder(section2.getFile(), byteArrayAnnotatedOutput4);
        valueEncoder2.writeArray(this.array, false);
        this.encodedForm = byteArrayAnnotatedOutput4.toByteArray();
        setWriteSize(this.encodedForm.length);
    }

    public String toHuman() {
        return this.array.toHuman();
    }

    /* access modifiers changed from: protected */
    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        ValueEncoder valueEncoder;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            annotatedOutput3.annotate(0, sb2.append(offsetString()).append(" encoded array").toString());
            ValueEncoder valueEncoder2 = valueEncoder;
            ValueEncoder valueEncoder3 = new ValueEncoder(dexFile2, annotatedOutput2);
            valueEncoder2.writeArray(this.array, true);
            return;
        }
        annotatedOutput2.write(this.encodedForm);
    }
}
