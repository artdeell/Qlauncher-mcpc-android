package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct;

import java.io.IOException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttAnnotationDefault;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttCode;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttConstantValue;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttDeprecated;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttEnclosingMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttExceptions;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttInnerClasses;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttLineNumberTable;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttLocalVariableTable;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttLocalVariableTypeTable;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttRuntimeInvisibleAnnotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttRuntimeInvisibleParameterAnnotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttRuntimeVisibleAnnotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttRuntimeVisibleParameterAnnotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttSignature;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttSourceFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttSynthetic;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.InnerClassList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ByteCatchList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.BytecodeArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.LineNumberList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.LocalVariableList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Attribute;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseObserver;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.StdAttributeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.AnnotationVisibility;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.AccessFlags;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.ConstantPool;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.TypedConstant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray.MyDataInputStream;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.StdAttributeFactory */
public class StdAttributeFactory extends AttributeFactory {
    public static final StdAttributeFactory THE_ONE;

    static {
        StdAttributeFactory stdAttributeFactory;
        StdAttributeFactory stdAttributeFactory2 = stdAttributeFactory;
        StdAttributeFactory stdAttributeFactory3 = new StdAttributeFactory();
        THE_ONE = stdAttributeFactory2;
    }

    public StdAttributeFactory() {
    }

    private Attribute annotationDefault(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        AttAnnotationDefault attAnnotationDefault;
        AnnotationParser annotationParser;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        int i4 = i2;
        ParseObserver parseObserver2 = parseObserver;
        if (i4 < 2) {
            Attribute throwSeverelyTruncated = throwSeverelyTruncated();
        }
        AttAnnotationDefault attAnnotationDefault2 = attAnnotationDefault;
        AnnotationParser annotationParser2 = annotationParser;
        AnnotationParser annotationParser3 = new AnnotationParser(directClassFile2, i3, i4, parseObserver2);
        AttAnnotationDefault attAnnotationDefault3 = new AttAnnotationDefault(annotationParser2.parseValueAttribute(), i4);
        return attAnnotationDefault2;
    }

    private Attribute code(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        BytecodeArray bytecodeArray;
        ByteCatchList byteCatchList;
        ByteCatchList byteCatchList2;
        int i3;
        AttributeListParser attributeListParser;
        AttCode attCode;
        StringBuilder sb;
        StringBuilder sb2;
        CodeObserver codeObserver;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        DirectClassFile directClassFile2 = directClassFile;
        int i4 = i;
        int i5 = i2;
        ParseObserver parseObserver2 = parseObserver;
        if (i5 < 12) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile2.getBytes();
        ConstantPool constantPool = directClassFile2.getConstantPool();
        int unsignedShort = bytes.getUnsignedShort(i4);
        int unsignedShort2 = bytes.getUnsignedShort(i4 + 2);
        int i6 = bytes.getInt(i4 + 4);
        if (parseObserver2 != null) {
            ParseObserver parseObserver3 = parseObserver2;
            ByteArray byteArray = bytes;
            int i7 = i4;
            StringBuilder sb6 = sb3;
            StringBuilder sb7 = new StringBuilder();
            parseObserver3.parsed(byteArray, i7, 2, sb6.append("max_stack: ").append(Hex.m51u2(unsignedShort)).toString());
            ParseObserver parseObserver4 = parseObserver2;
            ByteArray byteArray2 = bytes;
            int i8 = i4 + 2;
            StringBuilder sb8 = sb4;
            StringBuilder sb9 = new StringBuilder();
            parseObserver4.parsed(byteArray2, i8, 2, sb8.append("max_locals: ").append(Hex.m51u2(unsignedShort2)).toString());
            ParseObserver parseObserver5 = parseObserver2;
            ByteArray byteArray3 = bytes;
            int i9 = i4 + 4;
            StringBuilder sb10 = sb5;
            StringBuilder sb11 = new StringBuilder();
            parseObserver5.parsed(byteArray3, i9, 4, sb10.append("code_length: ").append(Hex.m53u4(i6)).toString());
        }
        int i10 = i4 + 8;
        int i11 = i5 - 8;
        if (i11 < i6 + 4) {
            return throwTruncated();
        }
        int i12 = i10 + i6;
        int i13 = i11 - i6;
        BytecodeArray bytecodeArray2 = bytecodeArray;
        BytecodeArray bytecodeArray3 = new BytecodeArray(bytes.slice(i10, i6 + i10), constantPool);
        BytecodeArray bytecodeArray4 = bytecodeArray2;
        if (parseObserver2 != null) {
            BytecodeArray bytecodeArray5 = bytecodeArray4;
            CodeObserver codeObserver2 = codeObserver;
            CodeObserver codeObserver3 = new CodeObserver(bytecodeArray4.getBytes(), parseObserver2);
            bytecodeArray5.forEach(codeObserver2);
        }
        int unsignedShort3 = bytes.getUnsignedShort(i12);
        if (unsignedShort3 == 0) {
            byteCatchList2 = ByteCatchList.EMPTY;
        } else {
            ByteCatchList byteCatchList3 = byteCatchList;
            ByteCatchList byteCatchList4 = new ByteCatchList(unsignedShort3);
            byteCatchList2 = byteCatchList3;
        }
        if (parseObserver2 != null) {
            ParseObserver parseObserver6 = parseObserver2;
            ByteArray byteArray4 = bytes;
            int i14 = i12;
            StringBuilder sb12 = sb2;
            StringBuilder sb13 = new StringBuilder();
            parseObserver6.parsed(byteArray4, i14, 2, sb12.append("exception_table_length: ").append(Hex.m51u2(unsignedShort3)).toString());
        }
        int i15 = i12 + 2;
        int i16 = i13 - 2;
        if (i16 < 2 + (unsignedShort3 * 8)) {
            return throwTruncated();
        }
        int i17 = 0;
        int i18 = i16;
        int i19 = i15;
        while (true) {
            i3 = i19;
            if (i17 >= unsignedShort3) {
                break;
            }
            if (parseObserver2 != null) {
                parseObserver2.changeIndent(1);
            }
            int unsignedShort4 = bytes.getUnsignedShort(i3);
            int unsignedShort5 = bytes.getUnsignedShort(i3 + 2);
            int unsignedShort6 = bytes.getUnsignedShort(i3 + 4);
            CstType cstType = (CstType) constantPool.get0Ok(bytes.getUnsignedShort(i3 + 6));
            byteCatchList2.set(i17, unsignedShort4, unsignedShort5, unsignedShort6, cstType);
            if (parseObserver2 != null) {
                StringBuilder sb14 = sb;
                StringBuilder sb15 = new StringBuilder();
                parseObserver2.parsed(bytes, i3, 8, sb14.append(Hex.m51u2(unsignedShort4)).append("..").append(Hex.m51u2(unsignedShort5)).append(" -> ").append(Hex.m51u2(unsignedShort6)).append(" ").append(cstType == null ? "<any>" : cstType.toHuman()).toString());
            }
            int i20 = i3 + 8;
            int i21 = i18 - 8;
            if (parseObserver2 != null) {
                parseObserver2.changeIndent(-1);
            }
            i17++;
            i18 = i21;
            i19 = i20;
        }
        byteCatchList2.setImmutable();
        AttributeListParser attributeListParser2 = attributeListParser;
        AttributeListParser attributeListParser3 = new AttributeListParser(directClassFile2, 3, i3, this);
        AttributeListParser attributeListParser4 = attributeListParser2;
        attributeListParser4.setObserver(parseObserver2);
        StdAttributeList list = attributeListParser4.getList();
        list.setImmutable();
        int endOffset = attributeListParser4.getEndOffset() - i3;
        if (endOffset != i18) {
            return throwBadLength(endOffset + (i3 - i4));
        }
        AttCode attCode2 = attCode;
        AttCode attCode3 = new AttCode(unsignedShort, unsignedShort2, bytecodeArray4, byteCatchList2, list);
        return attCode2;
    }

    private Attribute constantValue(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        AttConstantValue attConstantValue;
        StringBuilder sb;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        ParseObserver parseObserver2 = parseObserver;
        if (i2 != 2) {
            return throwBadLength(2);
        }
        ByteArray bytes = directClassFile2.getBytes();
        TypedConstant typedConstant = (TypedConstant) directClassFile2.getConstantPool().get(bytes.getUnsignedShort(i3));
        AttConstantValue attConstantValue2 = attConstantValue;
        AttConstantValue attConstantValue3 = new AttConstantValue(typedConstant);
        AttConstantValue attConstantValue4 = attConstantValue2;
        if (parseObserver2 != null) {
            ParseObserver parseObserver3 = parseObserver2;
            ByteArray byteArray = bytes;
            int i4 = i3;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            parseObserver3.parsed(byteArray, i4, 2, sb2.append("value: ").append(typedConstant).toString());
        }
        return attConstantValue4;
    }

    private Attribute deprecated(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        AttDeprecated attDeprecated;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        ParseObserver parseObserver2 = parseObserver;
        if (i2 != 0) {
            return throwBadLength(0);
        }
        AttDeprecated attDeprecated2 = attDeprecated;
        AttDeprecated attDeprecated3 = new AttDeprecated();
        return attDeprecated2;
    }

    private Attribute enclosingMethod(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        AttEnclosingMethod attEnclosingMethod;
        StringBuilder sb;
        StringBuilder sb2;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        ParseObserver parseObserver2 = parseObserver;
        if (i2 != 4) {
            Attribute throwBadLength = throwBadLength(4);
        }
        ByteArray bytes = directClassFile2.getBytes();
        ConstantPool constantPool = directClassFile2.getConstantPool();
        CstType cstType = (CstType) constantPool.get(bytes.getUnsignedShort(i3));
        CstNat cstNat = (CstNat) constantPool.get0Ok(bytes.getUnsignedShort(i3 + 2));
        AttEnclosingMethod attEnclosingMethod2 = attEnclosingMethod;
        AttEnclosingMethod attEnclosingMethod3 = new AttEnclosingMethod(cstType, cstNat);
        AttEnclosingMethod attEnclosingMethod4 = attEnclosingMethod2;
        if (parseObserver2 != null) {
            ParseObserver parseObserver3 = parseObserver2;
            ByteArray byteArray = bytes;
            int i4 = i3;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            parseObserver3.parsed(byteArray, i4, 2, sb3.append("class: ").append(cstType).toString());
            ParseObserver parseObserver4 = parseObserver2;
            ByteArray byteArray2 = bytes;
            int i5 = i3 + 2;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            parseObserver4.parsed(byteArray2, i5, 2, sb5.append("method: ").append(DirectClassFile.stringOrNone(cstNat)).toString());
        }
        return attEnclosingMethod4;
    }

    private Attribute exceptions(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        AttExceptions attExceptions;
        StringBuilder sb;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        int i4 = i2;
        ParseObserver parseObserver2 = parseObserver;
        if (i4 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile2.getBytes();
        int unsignedShort = bytes.getUnsignedShort(i3);
        if (parseObserver2 != null) {
            ParseObserver parseObserver3 = parseObserver2;
            ByteArray byteArray = bytes;
            int i5 = i3;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            parseObserver3.parsed(byteArray, i5, 2, sb2.append("number_of_exceptions: ").append(Hex.m51u2(unsignedShort)).toString());
        }
        int i6 = i3 + 2;
        if (i4 - 2 != unsignedShort * 2) {
            Attribute throwBadLength = throwBadLength(2 + (unsignedShort * 2));
        }
        AttExceptions attExceptions2 = attExceptions;
        AttExceptions attExceptions3 = new AttExceptions(directClassFile2.makeTypeList(i6, unsignedShort));
        return attExceptions2;
    }

    private Attribute innerClasses(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        InnerClassList innerClassList;
        AttInnerClasses attInnerClasses;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        int i4 = i2;
        ParseObserver parseObserver2 = parseObserver;
        if (i4 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile2.getBytes();
        ConstantPool constantPool = directClassFile2.getConstantPool();
        int unsignedShort = bytes.getUnsignedShort(i3);
        if (parseObserver2 != null) {
            ParseObserver parseObserver3 = parseObserver2;
            ByteArray byteArray = bytes;
            int i5 = i3;
            StringBuilder sb6 = sb5;
            StringBuilder sb7 = new StringBuilder();
            parseObserver3.parsed(byteArray, i5, 2, sb6.append("number_of_classes: ").append(Hex.m51u2(unsignedShort)).toString());
        }
        int i6 = i3 + 2;
        if (i4 - 2 != unsignedShort * 8) {
            Attribute throwBadLength = throwBadLength(2 + (unsignedShort * 8));
        }
        InnerClassList innerClassList2 = innerClassList;
        InnerClassList innerClassList3 = new InnerClassList(unsignedShort);
        InnerClassList innerClassList4 = innerClassList2;
        int i7 = 0;
        int i8 = i6;
        while (true) {
            int i9 = i8;
            if (i7 < unsignedShort) {
                int unsignedShort2 = bytes.getUnsignedShort(i9);
                int unsignedShort3 = bytes.getUnsignedShort(i9 + 2);
                int unsignedShort4 = bytes.getUnsignedShort(i9 + 4);
                int unsignedShort5 = bytes.getUnsignedShort(i9 + 6);
                CstType cstType = (CstType) constantPool.get(unsignedShort2);
                CstType cstType2 = (CstType) constantPool.get0Ok(unsignedShort3);
                CstString cstString = (CstString) constantPool.get0Ok(unsignedShort4);
                innerClassList4.set(i7, cstType, cstType2, cstString, unsignedShort5);
                if (parseObserver2 != null) {
                    ParseObserver parseObserver4 = parseObserver2;
                    ByteArray byteArray2 = bytes;
                    int i10 = i9;
                    StringBuilder sb8 = sb;
                    StringBuilder sb9 = new StringBuilder();
                    parseObserver4.parsed(byteArray2, i10, 2, sb8.append("inner_class: ").append(DirectClassFile.stringOrNone(cstType)).toString());
                    ParseObserver parseObserver5 = parseObserver2;
                    ByteArray byteArray3 = bytes;
                    int i11 = i9 + 2;
                    StringBuilder sb10 = sb2;
                    StringBuilder sb11 = new StringBuilder();
                    parseObserver5.parsed(byteArray3, i11, 2, sb10.append("  outer_class: ").append(DirectClassFile.stringOrNone(cstType2)).toString());
                    ParseObserver parseObserver6 = parseObserver2;
                    ByteArray byteArray4 = bytes;
                    int i12 = i9 + 4;
                    StringBuilder sb12 = sb3;
                    StringBuilder sb13 = new StringBuilder();
                    parseObserver6.parsed(byteArray4, i12, 2, sb12.append("  name: ").append(DirectClassFile.stringOrNone(cstString)).toString());
                    ParseObserver parseObserver7 = parseObserver2;
                    ByteArray byteArray5 = bytes;
                    int i13 = i9 + 6;
                    StringBuilder sb14 = sb4;
                    StringBuilder sb15 = new StringBuilder();
                    parseObserver7.parsed(byteArray5, i13, 2, sb14.append("  access_flags: ").append(AccessFlags.innerClassString(unsignedShort5)).toString());
                }
                i7++;
                i8 = i9 + 8;
            } else {
                innerClassList4.setImmutable();
                AttInnerClasses attInnerClasses2 = attInnerClasses;
                AttInnerClasses attInnerClasses3 = new AttInnerClasses(innerClassList4);
                return attInnerClasses2;
            }
        }
    }

    private Attribute lineNumberTable(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        LineNumberList lineNumberList;
        AttLineNumberTable attLineNumberTable;
        StringBuilder sb;
        StringBuilder sb2;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        int i4 = i2;
        ParseObserver parseObserver2 = parseObserver;
        if (i4 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile2.getBytes();
        int unsignedShort = bytes.getUnsignedShort(i3);
        if (parseObserver2 != null) {
            ParseObserver parseObserver3 = parseObserver2;
            ByteArray byteArray = bytes;
            int i5 = i3;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            parseObserver3.parsed(byteArray, i5, 2, sb3.append("line_number_table_length: ").append(Hex.m51u2(unsignedShort)).toString());
        }
        int i6 = i3 + 2;
        if (i4 - 2 != unsignedShort * 4) {
            Attribute throwBadLength = throwBadLength(2 + (unsignedShort * 4));
        }
        LineNumberList lineNumberList2 = lineNumberList;
        LineNumberList lineNumberList3 = new LineNumberList(unsignedShort);
        LineNumberList lineNumberList4 = lineNumberList2;
        for (int i7 = 0; i7 < unsignedShort; i7++) {
            int unsignedShort2 = bytes.getUnsignedShort(i6);
            int unsignedShort3 = bytes.getUnsignedShort(i6 + 2);
            lineNumberList4.set(i7, unsignedShort2, unsignedShort3);
            if (parseObserver2 != null) {
                ParseObserver parseObserver4 = parseObserver2;
                ByteArray byteArray2 = bytes;
                int i8 = i6;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                parseObserver4.parsed(byteArray2, i8, 4, sb5.append(Hex.m51u2(unsignedShort2)).append(" ").append(unsignedShort3).toString());
            }
            i6 += 4;
        }
        lineNumberList4.setImmutable();
        AttLineNumberTable attLineNumberTable2 = attLineNumberTable;
        AttLineNumberTable attLineNumberTable3 = new AttLineNumberTable(lineNumberList4);
        return attLineNumberTable2;
    }

    private Attribute localVariableTable(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        AttLocalVariableTable attLocalVariableTable;
        StringBuilder sb;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        int i4 = i2;
        ParseObserver parseObserver2 = parseObserver;
        if (i4 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile2.getBytes();
        int unsignedShort = bytes.getUnsignedShort(i3);
        if (parseObserver2 != null) {
            ParseObserver parseObserver3 = parseObserver2;
            ByteArray byteArray = bytes;
            int i5 = i3;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            parseObserver3.parsed(byteArray, i5, 2, sb2.append("local_variable_table_length: ").append(Hex.m51u2(unsignedShort)).toString());
        }
        AttLocalVariableTable attLocalVariableTable2 = attLocalVariableTable;
        AttLocalVariableTable attLocalVariableTable3 = new AttLocalVariableTable(parseLocalVariables(bytes.slice(i3 + 2, i3 + i4), directClassFile2.getConstantPool(), parseObserver2, unsignedShort, false));
        return attLocalVariableTable2;
    }

    private Attribute localVariableTypeTable(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        AttLocalVariableTypeTable attLocalVariableTypeTable;
        StringBuilder sb;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        int i4 = i2;
        ParseObserver parseObserver2 = parseObserver;
        if (i4 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile2.getBytes();
        int unsignedShort = bytes.getUnsignedShort(i3);
        if (parseObserver2 != null) {
            ParseObserver parseObserver3 = parseObserver2;
            ByteArray byteArray = bytes;
            int i5 = i3;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            parseObserver3.parsed(byteArray, i5, 2, sb2.append("local_variable_type_table_length: ").append(Hex.m51u2(unsignedShort)).toString());
        }
        AttLocalVariableTypeTable attLocalVariableTypeTable2 = attLocalVariableTypeTable;
        AttLocalVariableTypeTable attLocalVariableTypeTable3 = new AttLocalVariableTypeTable(parseLocalVariables(bytes.slice(i3 + 2, i3 + i4), directClassFile2.getConstantPool(), parseObserver2, unsignedShort, true));
        return attLocalVariableTypeTable2;
    }

    private LocalVariableList parseLocalVariables(ByteArray byteArray, ConstantPool constantPool, ParseObserver parseObserver, int i, boolean z) {
        LocalVariableList localVariableList;
        RuntimeException runtimeException;
        CstString cstString;
        StringBuilder sb;
        ByteArray byteArray2 = byteArray;
        ConstantPool constantPool2 = constantPool;
        ParseObserver parseObserver2 = parseObserver;
        int i2 = i;
        boolean z2 = z;
        if (byteArray2.size() != i2 * 10) {
            Attribute throwBadLength = throwBadLength(2 + (i2 * 10));
        }
        MyDataInputStream makeDataInputStream = byteArray2.makeDataInputStream();
        LocalVariableList localVariableList2 = localVariableList;
        LocalVariableList localVariableList3 = new LocalVariableList(i2);
        LocalVariableList localVariableList4 = localVariableList2;
        int i3 = 0;
        while (i3 < i2) {
            try {
                int readUnsignedShort = makeDataInputStream.readUnsignedShort();
                int readUnsignedShort2 = makeDataInputStream.readUnsignedShort();
                int readUnsignedShort3 = makeDataInputStream.readUnsignedShort();
                int readUnsignedShort4 = makeDataInputStream.readUnsignedShort();
                int readUnsignedShort5 = makeDataInputStream.readUnsignedShort();
                CstString cstString2 = (CstString) constantPool2.get(readUnsignedShort3);
                CstString cstString3 = (CstString) constantPool2.get(readUnsignedShort4);
                CstString cstString4 = null;
                if (z2) {
                    cstString = cstString3;
                } else {
                    cstString4 = cstString3;
                    cstString = null;
                }
                localVariableList4.set(i3, readUnsignedShort, readUnsignedShort2, cstString2, cstString4, cstString, readUnsignedShort5);
                if (parseObserver2 != null) {
                    ParseObserver parseObserver3 = parseObserver2;
                    ByteArray byteArray3 = byteArray2;
                    int i4 = i3 * 10;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    parseObserver3.parsed(byteArray3, i4, 10, sb2.append(Hex.m51u2(readUnsignedShort)).append("..").append(Hex.m51u2(readUnsignedShort + readUnsignedShort2)).append(" ").append(Hex.m51u2(readUnsignedShort5)).append(" ").append(cstString2.toHuman()).append(" ").append(cstString3.toHuman()).toString());
                }
                i3++;
            } catch (IOException e) {
                IOException iOException = e;
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("shouldn't happen", iOException);
                throw runtimeException2;
            }
        }
        localVariableList4.setImmutable();
        return localVariableList4;
    }

    private Attribute runtimeInvisibleAnnotations(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        AttRuntimeInvisibleAnnotations attRuntimeInvisibleAnnotations;
        AnnotationParser annotationParser;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        int i4 = i2;
        ParseObserver parseObserver2 = parseObserver;
        if (i4 < 2) {
            Attribute throwSeverelyTruncated = throwSeverelyTruncated();
        }
        AttRuntimeInvisibleAnnotations attRuntimeInvisibleAnnotations2 = attRuntimeInvisibleAnnotations;
        AnnotationParser annotationParser2 = annotationParser;
        AnnotationParser annotationParser3 = new AnnotationParser(directClassFile2, i3, i4, parseObserver2);
        AttRuntimeInvisibleAnnotations attRuntimeInvisibleAnnotations3 = new AttRuntimeInvisibleAnnotations(annotationParser2.parseAnnotationAttribute(AnnotationVisibility.BUILD), i4);
        return attRuntimeInvisibleAnnotations2;
    }

    private Attribute runtimeInvisibleParameterAnnotations(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        AttRuntimeInvisibleParameterAnnotations attRuntimeInvisibleParameterAnnotations;
        AnnotationParser annotationParser;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        int i4 = i2;
        ParseObserver parseObserver2 = parseObserver;
        if (i4 < 2) {
            Attribute throwSeverelyTruncated = throwSeverelyTruncated();
        }
        AttRuntimeInvisibleParameterAnnotations attRuntimeInvisibleParameterAnnotations2 = attRuntimeInvisibleParameterAnnotations;
        AnnotationParser annotationParser2 = annotationParser;
        AnnotationParser annotationParser3 = new AnnotationParser(directClassFile2, i3, i4, parseObserver2);
        AttRuntimeInvisibleParameterAnnotations attRuntimeInvisibleParameterAnnotations3 = new AttRuntimeInvisibleParameterAnnotations(annotationParser2.parseParameterAttribute(AnnotationVisibility.BUILD), i4);
        return attRuntimeInvisibleParameterAnnotations2;
    }

    private Attribute runtimeVisibleAnnotations(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        AttRuntimeVisibleAnnotations attRuntimeVisibleAnnotations;
        AnnotationParser annotationParser;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        int i4 = i2;
        ParseObserver parseObserver2 = parseObserver;
        if (i4 < 2) {
            Attribute throwSeverelyTruncated = throwSeverelyTruncated();
        }
        AttRuntimeVisibleAnnotations attRuntimeVisibleAnnotations2 = attRuntimeVisibleAnnotations;
        AnnotationParser annotationParser2 = annotationParser;
        AnnotationParser annotationParser3 = new AnnotationParser(directClassFile2, i3, i4, parseObserver2);
        AttRuntimeVisibleAnnotations attRuntimeVisibleAnnotations3 = new AttRuntimeVisibleAnnotations(annotationParser2.parseAnnotationAttribute(AnnotationVisibility.RUNTIME), i4);
        return attRuntimeVisibleAnnotations2;
    }

    private Attribute runtimeVisibleParameterAnnotations(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        AttRuntimeVisibleParameterAnnotations attRuntimeVisibleParameterAnnotations;
        AnnotationParser annotationParser;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        int i4 = i2;
        ParseObserver parseObserver2 = parseObserver;
        if (i4 < 2) {
            Attribute throwSeverelyTruncated = throwSeverelyTruncated();
        }
        AttRuntimeVisibleParameterAnnotations attRuntimeVisibleParameterAnnotations2 = attRuntimeVisibleParameterAnnotations;
        AnnotationParser annotationParser2 = annotationParser;
        AnnotationParser annotationParser3 = new AnnotationParser(directClassFile2, i3, i4, parseObserver2);
        AttRuntimeVisibleParameterAnnotations attRuntimeVisibleParameterAnnotations3 = new AttRuntimeVisibleParameterAnnotations(annotationParser2.parseParameterAttribute(AnnotationVisibility.RUNTIME), i4);
        return attRuntimeVisibleParameterAnnotations2;
    }

    private Attribute signature(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        AttSignature attSignature;
        StringBuilder sb;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        ParseObserver parseObserver2 = parseObserver;
        if (i2 != 2) {
            Attribute throwBadLength = throwBadLength(2);
        }
        ByteArray bytes = directClassFile2.getBytes();
        CstString cstString = (CstString) directClassFile2.getConstantPool().get(bytes.getUnsignedShort(i3));
        AttSignature attSignature2 = attSignature;
        AttSignature attSignature3 = new AttSignature(cstString);
        AttSignature attSignature4 = attSignature2;
        if (parseObserver2 != null) {
            ParseObserver parseObserver3 = parseObserver2;
            ByteArray byteArray = bytes;
            int i4 = i3;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            parseObserver3.parsed(byteArray, i4, 2, sb2.append("signature: ").append(cstString).toString());
        }
        return attSignature4;
    }

    private Attribute sourceFile(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        AttSourceFile attSourceFile;
        StringBuilder sb;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        ParseObserver parseObserver2 = parseObserver;
        if (i2 != 2) {
            Attribute throwBadLength = throwBadLength(2);
        }
        ByteArray bytes = directClassFile2.getBytes();
        CstString cstString = (CstString) directClassFile2.getConstantPool().get(bytes.getUnsignedShort(i3));
        AttSourceFile attSourceFile2 = attSourceFile;
        AttSourceFile attSourceFile3 = new AttSourceFile(cstString);
        AttSourceFile attSourceFile4 = attSourceFile2;
        if (parseObserver2 != null) {
            ParseObserver parseObserver3 = parseObserver2;
            ByteArray byteArray = bytes;
            int i4 = i3;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            parseObserver3.parsed(byteArray, i4, 2, sb2.append("source: ").append(cstString).toString());
        }
        return attSourceFile4;
    }

    private Attribute synthetic(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        AttSynthetic attSynthetic;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        ParseObserver parseObserver2 = parseObserver;
        if (i2 != 0) {
            return throwBadLength(0);
        }
        AttSynthetic attSynthetic2 = attSynthetic;
        AttSynthetic attSynthetic3 = new AttSynthetic();
        return attSynthetic2;
    }

    private static Attribute throwBadLength(int i) {
        ParseException parseException;
        StringBuilder sb;
        int i2 = i;
        ParseException parseException2 = parseException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        ParseException parseException3 = new ParseException(sb2.append("bad attribute length; expected length ").append(Hex.m53u4(i2)).toString());
        throw parseException2;
    }

    private static Attribute throwSeverelyTruncated() {
        ParseException parseException;
        ParseException parseException2 = parseException;
        ParseException parseException3 = new ParseException("severely truncated attribute");
        throw parseException2;
    }

    private static Attribute throwTruncated() {
        ParseException parseException;
        ParseException parseException2 = parseException;
        ParseException parseException3 = new ParseException("truncated attribute");
        throw parseException2;
    }

    /* access modifiers changed from: protected */
    public Attribute parse0(DirectClassFile directClassFile, int i, String str, int i2, int i3, ParseObserver parseObserver) {
        DirectClassFile directClassFile2 = directClassFile;
        int i4 = i;
        String str2 = str;
        int i5 = i2;
        int i6 = i3;
        ParseObserver parseObserver2 = parseObserver;
        switch (i4) {
            case 0:
                if (str2 == AttDeprecated.ATTRIBUTE_NAME) {
                    return deprecated(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttEnclosingMethod.ATTRIBUTE_NAME) {
                    return enclosingMethod(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttInnerClasses.ATTRIBUTE_NAME) {
                    return innerClasses(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME) {
                    return runtimeInvisibleAnnotations(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME) {
                    return runtimeVisibleAnnotations(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttSynthetic.ATTRIBUTE_NAME) {
                    return synthetic(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttSignature.ATTRIBUTE_NAME) {
                    return signature(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttSourceFile.ATTRIBUTE_NAME) {
                    return sourceFile(directClassFile2, i5, i6, parseObserver2);
                }
                break;
            case 1:
                if (str2 == AttConstantValue.ATTRIBUTE_NAME) {
                    return constantValue(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttDeprecated.ATTRIBUTE_NAME) {
                    return deprecated(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME) {
                    return runtimeInvisibleAnnotations(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME) {
                    return runtimeVisibleAnnotations(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttSignature.ATTRIBUTE_NAME) {
                    return signature(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttSynthetic.ATTRIBUTE_NAME) {
                    return synthetic(directClassFile2, i5, i6, parseObserver2);
                }
                break;
            case 2:
                if (str2 == AttAnnotationDefault.ATTRIBUTE_NAME) {
                    return annotationDefault(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttCode.ATTRIBUTE_NAME) {
                    return code(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttDeprecated.ATTRIBUTE_NAME) {
                    return deprecated(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttExceptions.ATTRIBUTE_NAME) {
                    return exceptions(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME) {
                    return runtimeInvisibleAnnotations(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME) {
                    return runtimeVisibleAnnotations(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttRuntimeInvisibleParameterAnnotations.ATTRIBUTE_NAME) {
                    return runtimeInvisibleParameterAnnotations(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttRuntimeVisibleParameterAnnotations.ATTRIBUTE_NAME) {
                    return runtimeVisibleParameterAnnotations(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttSignature.ATTRIBUTE_NAME) {
                    return signature(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttSynthetic.ATTRIBUTE_NAME) {
                    return synthetic(directClassFile2, i5, i6, parseObserver2);
                }
                break;
            case 3:
                if (str2 == AttLineNumberTable.ATTRIBUTE_NAME) {
                    return lineNumberTable(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttLocalVariableTable.ATTRIBUTE_NAME) {
                    return localVariableTable(directClassFile2, i5, i6, parseObserver2);
                }
                if (str2 == AttLocalVariableTypeTable.ATTRIBUTE_NAME) {
                    return localVariableTypeTable(directClassFile2, i5, i6, parseObserver2);
                }
                break;
        }
        return super.parse0(directClassFile2, i4, str2, i5, i6, parseObserver2);
    }
}
