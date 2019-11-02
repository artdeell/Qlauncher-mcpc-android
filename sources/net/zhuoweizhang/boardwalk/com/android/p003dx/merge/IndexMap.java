package net.zhuoweizhang.boardwalk.com.android.p003dx.merge;

import java.util.HashMap;
import net.zhuoweizhang.boardwalk.com.android.dex.Annotation;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassDef;
import net.zhuoweizhang.boardwalk.com.android.dex.Dex;
import net.zhuoweizhang.boardwalk.com.android.dex.DexException;
import net.zhuoweizhang.boardwalk.com.android.dex.EncodedValue;
import net.zhuoweizhang.boardwalk.com.android.dex.EncodedValueCodec;
import net.zhuoweizhang.boardwalk.com.android.dex.EncodedValueReader;
import net.zhuoweizhang.boardwalk.com.android.dex.FieldId;
import net.zhuoweizhang.boardwalk.com.android.dex.Leb128;
import net.zhuoweizhang.boardwalk.com.android.dex.MethodId;
import net.zhuoweizhang.boardwalk.com.android.dex.ProtoId;
import net.zhuoweizhang.boardwalk.com.android.dex.TableOfContents;
import net.zhuoweizhang.boardwalk.com.android.dex.TypeList;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ByteOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArrayAnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.merge.IndexMap */
public final class IndexMap {
    private final HashMap<Integer, Integer> annotationDirectoryOffsets;
    private final HashMap<Integer, Integer> annotationOffsets;
    private final HashMap<Integer, Integer> annotationSetOffsets;
    private final HashMap<Integer, Integer> annotationSetRefListOffsets;
    public final short[] fieldIds;
    public final short[] methodIds;
    public final short[] protoIds;
    private final HashMap<Integer, Integer> staticValuesOffsets;
    public final int[] stringIds;
    private final Dex target;
    public final short[] typeIds;
    private final HashMap<Integer, Integer> typeListOffsets;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.merge.IndexMap$EncodedValueTransformer */
    private final class EncodedValueTransformer {
        private final ByteOutput out;
        final /* synthetic */ IndexMap this$0;

        public EncodedValueTransformer(IndexMap indexMap, ByteOutput byteOutput) {
            ByteOutput byteOutput2 = byteOutput;
            this.this$0 = indexMap;
            this.out = byteOutput2;
        }

        /* access modifiers changed from: private */
        public void transformAnnotation(EncodedValueReader encodedValueReader) {
            EncodedValueReader encodedValueReader2 = encodedValueReader;
            int readAnnotation = encodedValueReader2.readAnnotation();
            Leb128.writeUnsignedLeb128(this.out, this.this$0.adjustType(encodedValueReader2.getAnnotationType()));
            Leb128.writeUnsignedLeb128(this.out, readAnnotation);
            for (int i = 0; i < readAnnotation; i++) {
                Leb128.writeUnsignedLeb128(this.out, this.this$0.adjustString(encodedValueReader2.readAnnotationName()));
                transform(encodedValueReader2);
            }
        }

        /* access modifiers changed from: private */
        public void transformArray(EncodedValueReader encodedValueReader) {
            EncodedValueReader encodedValueReader2 = encodedValueReader;
            int readArray = encodedValueReader2.readArray();
            Leb128.writeUnsignedLeb128(this.out, readArray);
            for (int i = 0; i < readArray; i++) {
                transform(encodedValueReader2);
            }
        }

        private void writeTypeAndArg(int i, int i2) {
            this.out.writeByte(i | (i2 << 5));
        }

        public void transform(EncodedValueReader encodedValueReader) {
            DexException dexException;
            StringBuilder sb;
            EncodedValueReader encodedValueReader2 = encodedValueReader;
            switch (encodedValueReader2.peek()) {
                case 0:
                    EncodedValueCodec.writeSignedIntegralValue(this.out, 0, (long) encodedValueReader2.readByte());
                    return;
                case 2:
                    EncodedValueCodec.writeSignedIntegralValue(this.out, 2, (long) encodedValueReader2.readShort());
                    return;
                case 3:
                    EncodedValueCodec.writeUnsignedIntegralValue(this.out, 3, (long) encodedValueReader2.readChar());
                    return;
                case 4:
                    EncodedValueCodec.writeSignedIntegralValue(this.out, 4, (long) encodedValueReader2.readInt());
                    return;
                case 6:
                    EncodedValueCodec.writeSignedIntegralValue(this.out, 6, encodedValueReader2.readLong());
                    return;
                case 16:
                    EncodedValueCodec.writeRightZeroExtendedValue(this.out, 16, ((long) Float.floatToIntBits(encodedValueReader2.readFloat())) << 32);
                    return;
                case 17:
                    EncodedValueCodec.writeRightZeroExtendedValue(this.out, 17, Double.doubleToLongBits(encodedValueReader2.readDouble()));
                    return;
                case 23:
                    EncodedValueCodec.writeUnsignedIntegralValue(this.out, 23, (long) this.this$0.adjustString(encodedValueReader2.readString()));
                    return;
                case 24:
                    EncodedValueCodec.writeUnsignedIntegralValue(this.out, 24, (long) this.this$0.adjustType(encodedValueReader2.readType()));
                    return;
                case 25:
                    EncodedValueCodec.writeUnsignedIntegralValue(this.out, 25, (long) this.this$0.adjustField(encodedValueReader2.readField()));
                    return;
                case 26:
                    EncodedValueCodec.writeUnsignedIntegralValue(this.out, 26, (long) this.this$0.adjustMethod(encodedValueReader2.readMethod()));
                    return;
                case 27:
                    EncodedValueCodec.writeUnsignedIntegralValue(this.out, 27, (long) this.this$0.adjustField(encodedValueReader2.readEnum()));
                    return;
                case 28:
                    writeTypeAndArg(28, 0);
                    transformArray(encodedValueReader2);
                    return;
                case 29:
                    writeTypeAndArg(29, 0);
                    transformAnnotation(encodedValueReader2);
                    return;
                case 30:
                    encodedValueReader2.readNull();
                    writeTypeAndArg(30, 0);
                    return;
                case 31:
                    int i = 0;
                    if (encodedValueReader2.readBoolean()) {
                        i = 1;
                    }
                    writeTypeAndArg(31, i);
                    return;
                default:
                    DexException dexException2 = dexException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    DexException dexException3 = new DexException(sb2.append("Unexpected type: ").append(Integer.toHexString(encodedValueReader2.peek())).toString());
                    throw dexException2;
            }
        }
    }

    public IndexMap(Dex dex, TableOfContents tableOfContents) {
        HashMap<Integer, Integer> hashMap;
        HashMap<Integer, Integer> hashMap2;
        HashMap<Integer, Integer> hashMap3;
        HashMap<Integer, Integer> hashMap4;
        HashMap<Integer, Integer> hashMap5;
        HashMap<Integer, Integer> hashMap6;
        TableOfContents tableOfContents2 = tableOfContents;
        this.target = dex;
        this.stringIds = new int[tableOfContents2.stringIds.size];
        this.typeIds = new short[tableOfContents2.typeIds.size];
        this.protoIds = new short[tableOfContents2.protoIds.size];
        this.fieldIds = new short[tableOfContents2.fieldIds.size];
        this.methodIds = new short[tableOfContents2.methodIds.size];
        HashMap<Integer, Integer> hashMap7 = hashMap;
        HashMap<Integer, Integer> hashMap8 = new HashMap<>();
        this.typeListOffsets = hashMap7;
        HashMap<Integer, Integer> hashMap9 = hashMap2;
        HashMap<Integer, Integer> hashMap10 = new HashMap<>();
        this.annotationOffsets = hashMap9;
        HashMap<Integer, Integer> hashMap11 = hashMap3;
        HashMap<Integer, Integer> hashMap12 = new HashMap<>();
        this.annotationSetOffsets = hashMap11;
        HashMap<Integer, Integer> hashMap13 = hashMap4;
        HashMap<Integer, Integer> hashMap14 = new HashMap<>();
        this.annotationSetRefListOffsets = hashMap13;
        HashMap<Integer, Integer> hashMap15 = hashMap5;
        HashMap<Integer, Integer> hashMap16 = new HashMap<>();
        this.annotationDirectoryOffsets = hashMap15;
        HashMap<Integer, Integer> hashMap17 = hashMap6;
        HashMap<Integer, Integer> hashMap18 = new HashMap<>();
        this.staticValuesOffsets = hashMap17;
        Object put = this.typeListOffsets.put(Integer.valueOf(0), Integer.valueOf(0));
        Object put2 = this.annotationSetOffsets.put(Integer.valueOf(0), Integer.valueOf(0));
        Object put3 = this.annotationDirectoryOffsets.put(Integer.valueOf(0), Integer.valueOf(0));
        Object put4 = this.staticValuesOffsets.put(Integer.valueOf(0), Integer.valueOf(0));
    }

    public Annotation adjust(Annotation annotation) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput;
        EncodedValueTransformer encodedValueTransformer;
        Annotation annotation2;
        EncodedValue encodedValue;
        Annotation annotation3 = annotation;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput2 = byteArrayAnnotatedOutput;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput3 = new ByteArrayAnnotatedOutput(32);
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput4 = byteArrayAnnotatedOutput2;
        EncodedValueTransformer encodedValueTransformer2 = encodedValueTransformer;
        EncodedValueTransformer encodedValueTransformer3 = new EncodedValueTransformer(this, byteArrayAnnotatedOutput4);
        encodedValueTransformer2.transformAnnotation(annotation3.getReader());
        Annotation annotation4 = annotation2;
        Dex dex = this.target;
        byte visibility = annotation3.getVisibility();
        EncodedValue encodedValue2 = encodedValue;
        EncodedValue encodedValue3 = new EncodedValue(byteArrayAnnotatedOutput4.toByteArray());
        Annotation annotation5 = new Annotation(dex, visibility, encodedValue2);
        return annotation4;
    }

    public ClassDef adjust(ClassDef classDef) {
        ClassDef classDef2;
        ClassDef classDef3 = classDef;
        ClassDef classDef4 = classDef2;
        ClassDef classDef5 = new ClassDef(this.target, classDef3.getOffset(), adjustType(classDef3.getTypeIndex()), classDef3.getAccessFlags(), adjustType(classDef3.getSupertypeIndex()), adjustTypeListOffset(classDef3.getInterfacesOffset()), classDef3.getSourceFileIndex(), classDef3.getAnnotationsOffset(), classDef3.getClassDataOffset(), classDef3.getStaticValuesOffset());
        return classDef4;
    }

    public FieldId adjust(FieldId fieldId) {
        FieldId fieldId2;
        FieldId fieldId3 = fieldId;
        FieldId fieldId4 = fieldId2;
        FieldId fieldId5 = new FieldId(this.target, adjustType(fieldId3.getDeclaringClassIndex()), adjustType(fieldId3.getTypeIndex()), adjustString(fieldId3.getNameIndex()));
        return fieldId4;
    }

    public MethodId adjust(MethodId methodId) {
        MethodId methodId2;
        MethodId methodId3 = methodId;
        MethodId methodId4 = methodId2;
        MethodId methodId5 = new MethodId(this.target, adjustType(methodId3.getDeclaringClassIndex()), adjustProto(methodId3.getProtoIndex()), adjustString(methodId3.getNameIndex()));
        return methodId4;
    }

    public ProtoId adjust(ProtoId protoId) {
        ProtoId protoId2;
        ProtoId protoId3 = protoId;
        ProtoId protoId4 = protoId2;
        ProtoId protoId5 = new ProtoId(this.target, adjustString(protoId3.getShortyIndex()), adjustType(protoId3.getReturnTypeIndex()), adjustTypeListOffset(protoId3.getParametersOffset()));
        return protoId4;
    }

    public SortableType adjust(SortableType sortableType) {
        SortableType sortableType2;
        SortableType sortableType3 = sortableType;
        SortableType sortableType4 = sortableType2;
        SortableType sortableType5 = new SortableType(sortableType3.getDex(), adjust(sortableType3.getClassDef()));
        return sortableType4;
    }

    public int adjustAnnotation(int i) {
        return ((Integer) this.annotationOffsets.get(Integer.valueOf(i))).intValue();
    }

    public int adjustAnnotationDirectory(int i) {
        return ((Integer) this.annotationDirectoryOffsets.get(Integer.valueOf(i))).intValue();
    }

    public int adjustAnnotationSet(int i) {
        return ((Integer) this.annotationSetOffsets.get(Integer.valueOf(i))).intValue();
    }

    public int adjustAnnotationSetRefList(int i) {
        return ((Integer) this.annotationSetRefListOffsets.get(Integer.valueOf(i))).intValue();
    }

    public EncodedValue adjustEncodedArray(EncodedValue encodedValue) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput;
        EncodedValueTransformer encodedValueTransformer;
        EncodedValueReader encodedValueReader;
        EncodedValue encodedValue2;
        EncodedValue encodedValue3 = encodedValue;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput2 = byteArrayAnnotatedOutput;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput3 = new ByteArrayAnnotatedOutput(32);
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput4 = byteArrayAnnotatedOutput2;
        EncodedValueTransformer encodedValueTransformer2 = encodedValueTransformer;
        EncodedValueTransformer encodedValueTransformer3 = new EncodedValueTransformer(this, byteArrayAnnotatedOutput4);
        EncodedValueReader encodedValueReader2 = encodedValueReader;
        EncodedValueReader encodedValueReader3 = new EncodedValueReader(encodedValue3, 28);
        encodedValueTransformer2.transformArray(encodedValueReader2);
        EncodedValue encodedValue4 = encodedValue2;
        EncodedValue encodedValue5 = new EncodedValue(byteArrayAnnotatedOutput4.toByteArray());
        return encodedValue4;
    }

    public EncodedValue adjustEncodedValue(EncodedValue encodedValue) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput;
        EncodedValueTransformer encodedValueTransformer;
        EncodedValueReader encodedValueReader;
        EncodedValue encodedValue2;
        EncodedValue encodedValue3 = encodedValue;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput2 = byteArrayAnnotatedOutput;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput3 = new ByteArrayAnnotatedOutput(32);
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput4 = byteArrayAnnotatedOutput2;
        EncodedValueTransformer encodedValueTransformer2 = encodedValueTransformer;
        EncodedValueTransformer encodedValueTransformer3 = new EncodedValueTransformer(this, byteArrayAnnotatedOutput4);
        EncodedValueReader encodedValueReader2 = encodedValueReader;
        EncodedValueReader encodedValueReader3 = new EncodedValueReader(encodedValue3);
        encodedValueTransformer2.transform(encodedValueReader2);
        EncodedValue encodedValue4 = encodedValue2;
        EncodedValue encodedValue5 = new EncodedValue(byteArrayAnnotatedOutput4.toByteArray());
        return encodedValue4;
    }

    public int adjustField(int i) {
        return 65535 & this.fieldIds[i];
    }

    public int adjustMethod(int i) {
        return 65535 & this.methodIds[i];
    }

    public int adjustProto(int i) {
        return 65535 & this.protoIds[i];
    }

    public int adjustStaticValues(int i) {
        return ((Integer) this.staticValuesOffsets.get(Integer.valueOf(i))).intValue();
    }

    public int adjustString(int i) {
        int i2 = i;
        if (i2 == -1) {
            return -1;
        }
        return this.stringIds[i2];
    }

    public int adjustType(int i) {
        int i2 = i;
        if (i2 == -1) {
            return -1;
        }
        return 65535 & this.typeIds[i2];
    }

    public TypeList adjustTypeList(TypeList typeList) {
        TypeList typeList2;
        TypeList typeList3 = typeList;
        if (typeList3 == TypeList.EMPTY) {
            return typeList3;
        }
        short[] sArr = (short[]) typeList3.getTypes().clone();
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) adjustType(sArr[i]);
        }
        TypeList typeList4 = typeList2;
        TypeList typeList5 = new TypeList(this.target, sArr);
        return typeList4;
    }

    public int adjustTypeListOffset(int i) {
        return ((Integer) this.typeListOffsets.get(Integer.valueOf(i))).intValue();
    }

    public void putAnnotationDirectoryOffset(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        int i3 = i;
        int i4 = i2;
        if (i3 <= 0 || i4 <= 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
            throw illegalArgumentException2;
        }
        Object put = this.annotationDirectoryOffsets.put(Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public void putAnnotationOffset(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        int i3 = i;
        int i4 = i2;
        if (i3 <= 0 || i4 <= 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
            throw illegalArgumentException2;
        }
        Object put = this.annotationOffsets.put(Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public void putAnnotationSetOffset(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        int i3 = i;
        int i4 = i2;
        if (i3 <= 0 || i4 <= 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
            throw illegalArgumentException2;
        }
        Object put = this.annotationSetOffsets.put(Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public void putAnnotationSetRefListOffset(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        int i3 = i;
        int i4 = i2;
        if (i3 <= 0 || i4 <= 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
            throw illegalArgumentException2;
        }
        Object put = this.annotationSetRefListOffsets.put(Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public void putStaticValuesOffset(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        int i3 = i;
        int i4 = i2;
        if (i3 <= 0 || i4 <= 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
            throw illegalArgumentException2;
        }
        Object put = this.staticValuesOffsets.put(Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public void putTypeListOffset(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        int i3 = i;
        int i4 = i2;
        if (i3 <= 0 || i4 <= 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
            throw illegalArgumentException2;
        }
        Object put = this.typeListOffsets.put(Integer.valueOf(i3), Integer.valueOf(i4));
    }
}
