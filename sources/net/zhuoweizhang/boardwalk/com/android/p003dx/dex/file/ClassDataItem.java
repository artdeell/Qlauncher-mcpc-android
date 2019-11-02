package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstArray.List;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLiteralBits;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Zeroes;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArrayAnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Writers;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.ClassDataItem */
public final class ClassDataItem extends OffsettedItem {
    private final ArrayList<EncodedMethod> directMethods;
    private byte[] encodedForm;
    private final ArrayList<EncodedField> instanceFields;
    private final ArrayList<EncodedField> staticFields;
    private final HashMap<EncodedField, Constant> staticValues;
    private CstArray staticValuesConstant;
    private final CstType thisClass;
    private final ArrayList<EncodedMethod> virtualMethods;

    public ClassDataItem(CstType cstType) {
        ArrayList<EncodedField> arrayList;
        HashMap<EncodedField, Constant> hashMap;
        ArrayList<EncodedField> arrayList2;
        ArrayList<EncodedMethod> arrayList3;
        ArrayList<EncodedMethod> arrayList4;
        NullPointerException nullPointerException;
        CstType cstType2 = cstType;
        super(1, -1);
        if (cstType2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("thisClass == null");
            throw nullPointerException2;
        }
        this.thisClass = cstType2;
        ArrayList<EncodedField> arrayList5 = arrayList;
        ArrayList<EncodedField> arrayList6 = new ArrayList<>(20);
        this.staticFields = arrayList5;
        HashMap<EncodedField, Constant> hashMap2 = hashMap;
        HashMap<EncodedField, Constant> hashMap3 = new HashMap<>(40);
        this.staticValues = hashMap2;
        ArrayList<EncodedField> arrayList7 = arrayList2;
        ArrayList<EncodedField> arrayList8 = new ArrayList<>(20);
        this.instanceFields = arrayList7;
        ArrayList<EncodedMethod> arrayList9 = arrayList3;
        ArrayList<EncodedMethod> arrayList10 = new ArrayList<>(20);
        this.directMethods = arrayList9;
        ArrayList<EncodedMethod> arrayList11 = arrayList4;
        ArrayList<EncodedMethod> arrayList12 = new ArrayList<>(20);
        this.virtualMethods = arrayList11;
        this.staticValuesConstant = null;
    }

    private static void encodeList(DexFile dexFile, AnnotatedOutput annotatedOutput, String str, ArrayList<? extends EncodedMember> arrayList) {
        StringBuilder sb;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        String str2 = str;
        ArrayList<? extends EncodedMember> arrayList2 = arrayList;
        int size = arrayList2.size();
        if (size != 0) {
            if (annotatedOutput2.annotates()) {
                AnnotatedOutput annotatedOutput3 = annotatedOutput2;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                annotatedOutput3.annotate(0, sb2.append("  ").append(str2).append(":").toString());
            }
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i = ((EncodedMember) arrayList2.get(i2)).encode(dexFile2, annotatedOutput2, i, i2);
            }
        }
    }

    private void encodeOutput(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        boolean annotates = annotatedOutput2.annotates();
        if (annotates) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            annotatedOutput3.annotate(0, sb2.append(offsetString()).append(" class data for ").append(this.thisClass.toHuman()).toString());
        }
        encodeSize(dexFile2, annotatedOutput2, "static_fields", this.staticFields.size());
        encodeSize(dexFile2, annotatedOutput2, "instance_fields", this.instanceFields.size());
        encodeSize(dexFile2, annotatedOutput2, "direct_methods", this.directMethods.size());
        encodeSize(dexFile2, annotatedOutput2, "virtual_methods", this.virtualMethods.size());
        encodeList(dexFile2, annotatedOutput2, "static_fields", this.staticFields);
        encodeList(dexFile2, annotatedOutput2, "instance_fields", this.instanceFields);
        encodeList(dexFile2, annotatedOutput2, "direct_methods", this.directMethods);
        encodeList(dexFile2, annotatedOutput2, "virtual_methods", this.virtualMethods);
        if (annotates) {
            annotatedOutput2.endAnnotation();
        }
    }

    private static void encodeSize(DexFile dexFile, AnnotatedOutput annotatedOutput, String str, int i) {
        StringBuilder sb;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        String str2 = str;
        int i2 = i;
        if (annotatedOutput2.annotates()) {
            Object[] objArr = new Object[2];
            Object[] objArr2 = objArr;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            objArr2[0] = sb2.append(str2).append("_size:").toString();
            objArr[1] = Integer.valueOf(i2);
            annotatedOutput2.annotate(String.format("  %-21s %08x", objArr));
        }
        int writeUleb128 = annotatedOutput2.writeUleb128(i2);
    }

    private CstArray makeStaticValuesConstant() {
        List list;
        CstArray cstArray;
        Collections.sort(this.staticFields);
        int size = this.staticFields.size();
        while (size > 0) {
            Constant constant = (Constant) this.staticValues.get((EncodedField) this.staticFields.get(size - 1));
            if (!(constant instanceof CstLiteralBits)) {
                if (constant != null) {
                    break;
                }
            } else if (((CstLiteralBits) constant).getLongBits() != 0) {
                break;
            }
            size--;
        }
        if (size == 0) {
            return null;
        }
        List list2 = list;
        List list3 = new List(size);
        List list4 = list2;
        for (int i = 0; i < size; i++) {
            EncodedField encodedField = (EncodedField) this.staticFields.get(i);
            Constant constant2 = (Constant) this.staticValues.get(encodedField);
            if (constant2 == null) {
                constant2 = Zeroes.zeroFor(encodedField.getRef().getType());
            }
            list4.set(i, constant2);
        }
        list4.setImmutable();
        CstArray cstArray2 = cstArray;
        CstArray cstArray3 = new CstArray(list4);
        return cstArray2;
    }

    public void addContents(DexFile dexFile) {
        DexFile dexFile2 = dexFile;
        if (!this.staticFields.isEmpty()) {
            CstArray staticValuesConstant2 = getStaticValuesConstant();
            Iterator it = this.staticFields.iterator();
            while (it.hasNext()) {
                ((EncodedField) it.next()).addContents(dexFile2);
            }
        }
        if (!this.instanceFields.isEmpty()) {
            Collections.sort(this.instanceFields);
            Iterator it2 = this.instanceFields.iterator();
            while (it2.hasNext()) {
                ((EncodedField) it2.next()).addContents(dexFile2);
            }
        }
        if (!this.directMethods.isEmpty()) {
            Collections.sort(this.directMethods);
            Iterator it3 = this.directMethods.iterator();
            while (it3.hasNext()) {
                ((EncodedMethod) it3.next()).addContents(dexFile2);
            }
        }
        if (!this.virtualMethods.isEmpty()) {
            Collections.sort(this.virtualMethods);
            Iterator it4 = this.virtualMethods.iterator();
            while (it4.hasNext()) {
                ((EncodedMethod) it4.next()).addContents(dexFile2);
            }
        }
    }

    public void addDirectMethod(EncodedMethod encodedMethod) {
        NullPointerException nullPointerException;
        EncodedMethod encodedMethod2 = encodedMethod;
        if (encodedMethod2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("method == null");
            throw nullPointerException2;
        }
        boolean add = this.directMethods.add(encodedMethod2);
    }

    public void addInstanceField(EncodedField encodedField) {
        NullPointerException nullPointerException;
        EncodedField encodedField2 = encodedField;
        if (encodedField2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("field == null");
            throw nullPointerException2;
        }
        boolean add = this.instanceFields.add(encodedField2);
    }

    public void addStaticField(EncodedField encodedField, Constant constant) {
        UnsupportedOperationException unsupportedOperationException;
        NullPointerException nullPointerException;
        EncodedField encodedField2 = encodedField;
        Constant constant2 = constant;
        if (encodedField2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("field == null");
            throw nullPointerException2;
        } else if (this.staticValuesConstant != null) {
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("static fields already sorted");
            throw unsupportedOperationException2;
        } else {
            boolean add = this.staticFields.add(encodedField2);
            Object put = this.staticValues.put(encodedField2, constant2);
        }
    }

    public void addVirtualMethod(EncodedMethod encodedMethod) {
        NullPointerException nullPointerException;
        EncodedMethod encodedMethod2 = encodedMethod;
        if (encodedMethod2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("method == null");
            throw nullPointerException2;
        }
        boolean add = this.virtualMethods.add(encodedMethod2);
    }

    public void debugPrint(Writer writer, boolean z) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        boolean z2 = z;
        PrintWriter printWriterFor = Writers.printWriterFor(writer);
        int size = this.staticFields.size();
        for (int i = 0; i < size; i++) {
            PrintWriter printWriter = printWriterFor;
            StringBuilder sb5 = sb4;
            StringBuilder sb6 = new StringBuilder();
            printWriter.println(sb5.append("  sfields[").append(i).append("]: ").append(this.staticFields.get(i)).toString());
        }
        int size2 = this.instanceFields.size();
        for (int i2 = 0; i2 < size2; i2++) {
            PrintWriter printWriter2 = printWriterFor;
            StringBuilder sb7 = sb3;
            StringBuilder sb8 = new StringBuilder();
            printWriter2.println(sb7.append("  ifields[").append(i2).append("]: ").append(this.instanceFields.get(i2)).toString());
        }
        int size3 = this.directMethods.size();
        for (int i3 = 0; i3 < size3; i3++) {
            PrintWriter printWriter3 = printWriterFor;
            StringBuilder sb9 = sb2;
            StringBuilder sb10 = new StringBuilder();
            printWriter3.println(sb9.append("  dmeths[").append(i3).append("]:").toString());
            ((EncodedMethod) this.directMethods.get(i3)).debugPrint(printWriterFor, z2);
        }
        int size4 = this.virtualMethods.size();
        for (int i4 = 0; i4 < size4; i4++) {
            PrintWriter printWriter4 = printWriterFor;
            StringBuilder sb11 = sb;
            StringBuilder sb12 = new StringBuilder();
            printWriter4.println(sb11.append("  vmeths[").append(i4).append("]:").toString());
            ((EncodedMethod) this.virtualMethods.get(i4)).debugPrint(printWriterFor, z2);
        }
    }

    public ArrayList<EncodedMethod> getMethods() {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(this.directMethods.size() + this.virtualMethods.size());
        ArrayList arrayList4 = arrayList2;
        boolean addAll = arrayList4.addAll(this.directMethods);
        boolean addAll2 = arrayList4.addAll(this.virtualMethods);
        return arrayList4;
    }

    public CstArray getStaticValuesConstant() {
        if (this.staticValuesConstant == null && this.staticFields.size() != 0) {
            this.staticValuesConstant = makeStaticValuesConstant();
        }
        return this.staticValuesConstant;
    }

    public boolean isEmpty() {
        return this.staticFields.isEmpty() && this.instanceFields.isEmpty() && this.directMethods.isEmpty() && this.virtualMethods.isEmpty();
    }

    public ItemType itemType() {
        return ItemType.TYPE_CLASS_DATA_ITEM;
    }

    /* access modifiers changed from: protected */
    public void place0(Section section, int i) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput;
        Section section2 = section;
        int i2 = i;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput2 = byteArrayAnnotatedOutput;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput3 = new ByteArrayAnnotatedOutput();
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput4 = byteArrayAnnotatedOutput2;
        encodeOutput(section2.getFile(), byteArrayAnnotatedOutput4);
        this.encodedForm = byteArrayAnnotatedOutput4.toByteArray();
        setWriteSize(this.encodedForm.length);
    }

    public String toHuman() {
        return toString();
    }

    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        if (annotatedOutput2.annotates()) {
            encodeOutput(dexFile2, annotatedOutput2);
        } else {
            annotatedOutput2.write(this.encodedForm);
        }
    }
}
