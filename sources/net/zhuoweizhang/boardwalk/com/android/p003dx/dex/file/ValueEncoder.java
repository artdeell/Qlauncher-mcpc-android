package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.dex.EncodedValueCodec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotation;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.NameValuePair;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstAnnotation;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstArray.List;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstBoolean;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstByte;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstChar;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstDouble;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstEnumRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFieldRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFloat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstKnownNull;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLiteralBits;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLong;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstShort;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.ValueEncoder */
public final class ValueEncoder {
    private static final int VALUE_ANNOTATION = 29;
    private static final int VALUE_ARRAY = 28;
    private static final int VALUE_BOOLEAN = 31;
    private static final int VALUE_BYTE = 0;
    private static final int VALUE_CHAR = 3;
    private static final int VALUE_DOUBLE = 17;
    private static final int VALUE_ENUM = 27;
    private static final int VALUE_FIELD = 25;
    private static final int VALUE_FLOAT = 16;
    private static final int VALUE_INT = 4;
    private static final int VALUE_LONG = 6;
    private static final int VALUE_METHOD = 26;
    private static final int VALUE_NULL = 30;
    private static final int VALUE_SHORT = 2;
    private static final int VALUE_STRING = 23;
    private static final int VALUE_TYPE = 24;
    private final DexFile file;
    private final AnnotatedOutput out;

    public ValueEncoder(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        if (dexFile2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("file == null");
            throw nullPointerException3;
        } else if (annotatedOutput2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("out == null");
            throw nullPointerException5;
        } else {
            this.file = dexFile2;
            this.out = annotatedOutput2;
        }
    }

    public static void addContents(DexFile dexFile, Annotation annotation) {
        DexFile dexFile2 = dexFile;
        Annotation annotation2 = annotation;
        TypeIdsSection typeIds = dexFile2.getTypeIds();
        StringIdsSection stringIds = dexFile2.getStringIds();
        TypeIdItem intern = typeIds.intern(annotation2.getType());
        for (NameValuePair nameValuePair : annotation2.getNameValuePairs()) {
            StringIdItem intern2 = stringIds.intern(nameValuePair.getName());
            addContents(dexFile2, nameValuePair.getValue());
        }
    }

    public static void addContents(DexFile dexFile, Constant constant) {
        DexFile dexFile2 = dexFile;
        Constant constant2 = constant;
        if (constant2 instanceof CstAnnotation) {
            addContents(dexFile2, ((CstAnnotation) constant2).getAnnotation());
        } else if (constant2 instanceof CstArray) {
            List list = ((CstArray) constant2).getList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                addContents(dexFile2, list.get(i));
            }
        } else {
            dexFile2.internIfAppropriate(constant2);
        }
    }

    public static String constantToHuman(Constant constant) {
        StringBuilder sb;
        Constant constant2 = constant;
        if (constantToValueType(constant2) == 30) {
            return "null";
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(constant2.typeName());
        StringBuilder append2 = sb4.append(' ');
        StringBuilder append3 = sb4.append(constant2.toHuman());
        return sb4.toString();
    }

    private static int constantToValueType(Constant constant) {
        RuntimeException runtimeException;
        Constant constant2 = constant;
        if (constant2 instanceof CstByte) {
            return 0;
        }
        if (constant2 instanceof CstShort) {
            return 2;
        }
        if (constant2 instanceof CstChar) {
            return 3;
        }
        if (constant2 instanceof CstInteger) {
            return 4;
        }
        if (constant2 instanceof CstLong) {
            return 6;
        }
        if (constant2 instanceof CstFloat) {
            return 16;
        }
        if (constant2 instanceof CstDouble) {
            return 17;
        }
        if (constant2 instanceof CstString) {
            return 23;
        }
        if (constant2 instanceof CstType) {
            return 24;
        }
        if (constant2 instanceof CstFieldRef) {
            return 25;
        }
        if (constant2 instanceof CstMethodRef) {
            return 26;
        }
        if (constant2 instanceof CstEnumRef) {
            return 27;
        }
        if (constant2 instanceof CstArray) {
            return 28;
        }
        if (constant2 instanceof CstAnnotation) {
            return 29;
        }
        if (constant2 instanceof CstKnownNull) {
            return 30;
        }
        if (constant2 instanceof CstBoolean) {
            return 31;
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("Shouldn't happen");
        throw runtimeException2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x01e7 A[EDGE_INSN: B:26:0x01e7->B:22:0x01e7 ?: BREAK  
    EDGE_INSN: B:26:0x01e7->B:22:0x01e7 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeAnnotation(net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotation r26, boolean r27) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            r3 = r27
            r20 = r3
            if (r20 == 0) goto L_0x01e1
            r20 = r1
            r0 = r20
            net.zhuoweizhang.boardwalk.com.android.dx.util.AnnotatedOutput r0 = r0.out
            r20 = r0
            boolean r20 = r20.annotates()
            if (r20 == 0) goto L_0x01e1
            r20 = 1
            r4 = r20
        L_0x001c:
            r20 = r1
            r0 = r20
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DexFile r0 = r0.file
            r20 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.StringIdsSection r20 = r20.getStringIds()
            r5 = r20
            r20 = r1
            r0 = r20
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DexFile r0 = r0.file
            r20 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.TypeIdsSection r20 = r20.getTypeIds()
            r6 = r20
            r20 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r20 = r20.getType()
            r7 = r20
            r20 = r6
            r21 = r7
            int r20 = r20.indexOf(r21)
            r8 = r20
            r20 = r4
            if (r20 == 0) goto L_0x0088
            r20 = r1
            r0 = r20
            net.zhuoweizhang.boardwalk.com.android.dx.util.AnnotatedOutput r0 = r0.out
            r20 = r0
            java.lang.StringBuilder r21 = new java.lang.StringBuilder
            r24 = r21
            r21 = r24
            r22 = r24
            r22.<init>()
            java.lang.String r22 = "  type_idx: "
            java.lang.StringBuilder r21 = r21.append(r22)
            r22 = r8
            java.lang.String r22 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m53u4(r22)
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r22 = " // "
            java.lang.StringBuilder r21 = r21.append(r22)
            r22 = r7
            java.lang.String r22 = r22.toHuman()
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r21 = r21.toString()
            r20.annotate(r21)
        L_0x0088:
            r20 = r1
            r0 = r20
            net.zhuoweizhang.boardwalk.com.android.dx.util.AnnotatedOutput r0 = r0.out
            r20 = r0
            r21 = r6
            r22 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r22 = r22.getType()
            int r21 = r21.indexOf(r22)
            int r20 = r20.writeUleb128(r21)
            r20 = r2
            java.util.Collection r20 = r20.getNameValuePairs()
            r10 = r20
            r20 = r10
            int r20 = r20.size()
            r11 = r20
            r20 = r4
            if (r20 == 0) goto L_0x00de
            r20 = r1
            r0 = r20
            net.zhuoweizhang.boardwalk.com.android.dx.util.AnnotatedOutput r0 = r0.out
            r20 = r0
            java.lang.StringBuilder r21 = new java.lang.StringBuilder
            r24 = r21
            r21 = r24
            r22 = r24
            r22.<init>()
            java.lang.String r22 = "  size: "
            java.lang.StringBuilder r21 = r21.append(r22)
            r22 = r11
            java.lang.String r22 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m53u4(r22)
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r21 = r21.toString()
            r20.annotate(r21)
        L_0x00de:
            r20 = r1
            r0 = r20
            net.zhuoweizhang.boardwalk.com.android.dx.util.AnnotatedOutput r0 = r0.out
            r20 = r0
            r21 = r11
            int r20 = r20.writeUleb128(r21)
            r20 = r10
            java.util.Iterator r20 = r20.iterator()
            r13 = r20
            r20 = 0
            r14 = r20
        L_0x00f8:
            r20 = r13
            boolean r20 = r20.hasNext()
            if (r20 == 0) goto L_0x01e7
            r20 = r13
            java.lang.Object r20 = r20.next()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.NameValuePair r20 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.NameValuePair) r20
            r15 = r20
            r20 = r15
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString r20 = r20.getName()
            r16 = r20
            r20 = r5
            r21 = r16
            int r20 = r20.indexOf(r21)
            r17 = r20
            r20 = r15
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r20 = r20.getValue()
            r18 = r20
            r20 = r4
            if (r20 == 0) goto L_0x01f7
            r20 = r1
            r0 = r20
            net.zhuoweizhang.boardwalk.com.android.dx.util.AnnotatedOutput r0 = r0.out
            r20 = r0
            r21 = 0
            java.lang.StringBuilder r22 = new java.lang.StringBuilder
            r24 = r22
            r22 = r24
            r23 = r24
            r23.<init>()
            java.lang.String r23 = "  elements["
            java.lang.StringBuilder r22 = r22.append(r23)
            r23 = r14
            java.lang.StringBuilder r22 = r22.append(r23)
            java.lang.String r23 = "]:"
            java.lang.StringBuilder r22 = r22.append(r23)
            java.lang.String r22 = r22.toString()
            r20.annotate(r21, r22)
            r20 = r14
            r21 = 1
            int r20 = r20 + 1
            r19 = r20
            r20 = r1
            r0 = r20
            net.zhuoweizhang.boardwalk.com.android.dx.util.AnnotatedOutput r0 = r0.out
            r20 = r0
            java.lang.StringBuilder r21 = new java.lang.StringBuilder
            r24 = r21
            r21 = r24
            r22 = r24
            r22.<init>()
            java.lang.String r22 = "    name_idx: "
            java.lang.StringBuilder r21 = r21.append(r22)
            r22 = r17
            java.lang.String r22 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m53u4(r22)
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r22 = " // "
            java.lang.StringBuilder r21 = r21.append(r22)
            r22 = r16
            java.lang.String r22 = r22.toHuman()
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r21 = r21.toString()
            r20.annotate(r21)
        L_0x0198:
            r20 = r1
            r0 = r20
            net.zhuoweizhang.boardwalk.com.android.dx.util.AnnotatedOutput r0 = r0.out
            r20 = r0
            r21 = r17
            int r20 = r20.writeUleb128(r21)
            r20 = r4
            if (r20 == 0) goto L_0x01d4
            r20 = r1
            r0 = r20
            net.zhuoweizhang.boardwalk.com.android.dx.util.AnnotatedOutput r0 = r0.out
            r20 = r0
            java.lang.StringBuilder r21 = new java.lang.StringBuilder
            r24 = r21
            r21 = r24
            r22 = r24
            r22.<init>()
            java.lang.String r22 = "    value: "
            java.lang.StringBuilder r21 = r21.append(r22)
            r22 = r18
            java.lang.String r22 = constantToHuman(r22)
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r21 = r21.toString()
            r20.annotate(r21)
        L_0x01d4:
            r20 = r1
            r21 = r18
            r20.writeConstant(r21)
            r20 = r19
            r14 = r20
            goto L_0x00f8
        L_0x01e1:
            r20 = 0
            r4 = r20
            goto L_0x001c
        L_0x01e7:
            r20 = r4
            if (r20 == 0) goto L_0x01f6
            r20 = r1
            r0 = r20
            net.zhuoweizhang.boardwalk.com.android.dx.util.AnnotatedOutput r0 = r0.out
            r20 = r0
            r20.endAnnotation()
        L_0x01f6:
            return
        L_0x01f7:
            r20 = r14
            r19 = r20
            goto L_0x0198
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.ValueEncoder.writeAnnotation(net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.Annotation, boolean):void");
    }

    public void writeArray(CstArray cstArray, boolean z) {
        StringBuilder sb;
        StringBuilder sb2;
        CstArray cstArray2 = cstArray;
        boolean z2 = z && this.out.annotates();
        List list = cstArray2.getList();
        int size = list.size();
        if (z2) {
            AnnotatedOutput annotatedOutput = this.out;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            annotatedOutput.annotate(sb3.append("  size: ").append(Hex.m53u4(size)).toString());
        }
        int writeUleb128 = this.out.writeUleb128(size);
        for (int i = 0; i < size; i++) {
            Constant constant = list.get(i);
            if (z2) {
                AnnotatedOutput annotatedOutput2 = this.out;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                annotatedOutput2.annotate(sb5.append("  [").append(Integer.toHexString(i)).append("] ").append(constantToHuman(constant)).toString());
            }
            writeConstant(constant);
        }
        if (z2) {
            this.out.endAnnotation();
        }
    }

    public void writeConstant(Constant constant) {
        RuntimeException runtimeException;
        Constant constant2 = constant;
        int constantToValueType = constantToValueType(constant2);
        switch (constantToValueType) {
            case 0:
            case 2:
            case 4:
            case 6:
                EncodedValueCodec.writeSignedIntegralValue(this.out, constantToValueType, ((CstLiteralBits) constant2).getLongBits());
                return;
            case 3:
                EncodedValueCodec.writeUnsignedIntegralValue(this.out, constantToValueType, ((CstLiteralBits) constant2).getLongBits());
                return;
            case 16:
                EncodedValueCodec.writeRightZeroExtendedValue(this.out, constantToValueType, ((CstFloat) constant2).getLongBits() << 32);
                return;
            case 17:
                EncodedValueCodec.writeRightZeroExtendedValue(this.out, constantToValueType, ((CstDouble) constant2).getLongBits());
                return;
            case 23:
                int indexOf = this.file.getStringIds().indexOf((CstString) constant2);
                EncodedValueCodec.writeUnsignedIntegralValue(this.out, constantToValueType, (long) indexOf);
                return;
            case 24:
                int indexOf2 = this.file.getTypeIds().indexOf((CstType) constant2);
                EncodedValueCodec.writeUnsignedIntegralValue(this.out, constantToValueType, (long) indexOf2);
                return;
            case 25:
                int indexOf3 = this.file.getFieldIds().indexOf((CstFieldRef) constant2);
                EncodedValueCodec.writeUnsignedIntegralValue(this.out, constantToValueType, (long) indexOf3);
                return;
            case 26:
                int indexOf4 = this.file.getMethodIds().indexOf((CstMethodRef) constant2);
                EncodedValueCodec.writeUnsignedIntegralValue(this.out, constantToValueType, (long) indexOf4);
                return;
            case 27:
                int indexOf5 = this.file.getFieldIds().indexOf(((CstEnumRef) constant2).getFieldRef());
                EncodedValueCodec.writeUnsignedIntegralValue(this.out, constantToValueType, (long) indexOf5);
                return;
            case 28:
                this.out.writeByte(constantToValueType);
                writeArray((CstArray) constant2, false);
                return;
            case 29:
                this.out.writeByte(constantToValueType);
                writeAnnotation(((CstAnnotation) constant2).getAnnotation(), false);
                return;
            case 30:
                this.out.writeByte(constantToValueType);
                return;
            case 31:
                this.out.writeByte(constantToValueType | (((CstBoolean) constant2).getIntBits() << 5));
                return;
            default:
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("Shouldn't happen");
                throw runtimeException2;
        }
    }
}
