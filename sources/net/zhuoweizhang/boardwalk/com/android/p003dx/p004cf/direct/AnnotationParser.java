package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct;

import java.io.IOException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseObserver;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotation;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.AnnotationVisibility;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.AnnotationsList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.NameValuePair;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.ConstantPool;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstAnnotation;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstArray.List;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstBoolean;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstByte;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstChar;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstDouble;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstEnumRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFloat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLong;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstShort;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray.MyDataInputStream;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.AnnotationParser */
public final class AnnotationParser {
    private final ByteArray bytes;

    /* renamed from: cf */
    private final DirectClassFile f163cf;
    private final MyDataInputStream input;
    private final ParseObserver observer;
    private int parseCursor;
    private final ConstantPool pool;

    public AnnotationParser(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        NullPointerException nullPointerException;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        int i4 = i2;
        ParseObserver parseObserver2 = parseObserver;
        if (directClassFile2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("cf == null");
            throw nullPointerException2;
        }
        this.f163cf = directClassFile2;
        this.pool = directClassFile2.getConstantPool();
        this.observer = parseObserver2;
        this.bytes = directClassFile2.getBytes().slice(i3, i3 + i4);
        this.input = this.bytes.makeDataInputStream();
        this.parseCursor = 0;
    }

    private void changeIndent(int i) {
        int i2 = i;
        this.observer.changeIndent(i2);
    }

    private Annotation parseAnnotation(AnnotationVisibility annotationVisibility) throws IOException {
        CstType cstType;
        Annotation annotation;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        AnnotationVisibility annotationVisibility2 = annotationVisibility;
        requireLength(4);
        int readUnsignedShort = this.input.readUnsignedShort();
        int readUnsignedShort2 = this.input.readUnsignedShort();
        CstType cstType2 = cstType;
        CstType cstType3 = new CstType(Type.intern(((CstString) this.pool.get(readUnsignedShort)).getString()));
        CstType cstType4 = cstType2;
        if (this.observer != null) {
            StringBuilder sb4 = sb2;
            StringBuilder sb5 = new StringBuilder();
            parsed(2, sb4.append("type: ").append(cstType4.toHuman()).toString());
            StringBuilder sb6 = sb3;
            StringBuilder sb7 = new StringBuilder();
            parsed(2, sb6.append("num_elements: ").append(readUnsignedShort2).toString());
        }
        Annotation annotation2 = annotation;
        Annotation annotation3 = new Annotation(cstType4, annotationVisibility2);
        Annotation annotation4 = annotation2;
        for (int i = 0; i < readUnsignedShort2; i++) {
            if (this.observer != null) {
                StringBuilder sb8 = sb;
                StringBuilder sb9 = new StringBuilder();
                parsed(0, sb8.append("elements[").append(i).append("]:").toString());
                changeIndent(1);
            }
            annotation4.add(parseElement());
            if (this.observer != null) {
                changeIndent(-1);
            }
        }
        annotation4.setImmutable();
        return annotation4;
    }

    private Annotations parseAnnotations(AnnotationVisibility annotationVisibility) throws IOException {
        Annotations annotations;
        StringBuilder sb;
        StringBuilder sb2;
        AnnotationVisibility annotationVisibility2 = annotationVisibility;
        int readUnsignedShort = this.input.readUnsignedShort();
        if (this.observer != null) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            parsed(2, sb3.append("num_annotations: ").append(Hex.m51u2(readUnsignedShort)).toString());
        }
        Annotations annotations2 = annotations;
        Annotations annotations3 = new Annotations();
        Annotations annotations4 = annotations2;
        for (int i = 0; i < readUnsignedShort; i++) {
            if (this.observer != null) {
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                parsed(0, sb5.append("annotations[").append(i).append("]:").toString());
                changeIndent(1);
            }
            annotations4.add(parseAnnotation(annotationVisibility2));
            if (this.observer != null) {
                this.observer.changeIndent(-1);
            }
        }
        annotations4.setImmutable();
        return annotations4;
    }

    private AnnotationsList parseAnnotationsList(AnnotationVisibility annotationVisibility) throws IOException {
        AnnotationsList annotationsList;
        StringBuilder sb;
        StringBuilder sb2;
        AnnotationVisibility annotationVisibility2 = annotationVisibility;
        int readUnsignedByte = this.input.readUnsignedByte();
        if (this.observer != null) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            parsed(1, sb3.append("num_parameters: ").append(Hex.m50u1(readUnsignedByte)).toString());
        }
        AnnotationsList annotationsList2 = annotationsList;
        AnnotationsList annotationsList3 = new AnnotationsList(readUnsignedByte);
        AnnotationsList annotationsList4 = annotationsList2;
        for (int i = 0; i < readUnsignedByte; i++) {
            if (this.observer != null) {
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                parsed(0, sb5.append("parameter_annotations[").append(i).append("]:").toString());
                changeIndent(1);
            }
            annotationsList4.set(i, parseAnnotations(annotationVisibility2));
            if (this.observer != null) {
                this.observer.changeIndent(-1);
            }
        }
        annotationsList4.setImmutable();
        return annotationsList4;
    }

    private Constant parseConstant() throws IOException {
        StringBuilder sb;
        Constant constant = this.pool.get(this.input.readUnsignedShort());
        if (this.observer != null) {
            String human = constant instanceof CstString ? ((CstString) constant).toQuoted() : constant.toHuman();
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            parsed(2, sb2.append("constant_value: ").append(human).toString());
        }
        return constant;
    }

    private NameValuePair parseElement() throws IOException {
        NameValuePair nameValuePair;
        StringBuilder sb;
        requireLength(5);
        CstString cstString = (CstString) this.pool.get(this.input.readUnsignedShort());
        if (this.observer != null) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            parsed(2, sb2.append("element_name: ").append(cstString.toHuman()).toString());
            parsed(0, "value: ");
            changeIndent(1);
        }
        Constant parseValue = parseValue();
        if (this.observer != null) {
            changeIndent(-1);
        }
        NameValuePair nameValuePair2 = nameValuePair;
        NameValuePair nameValuePair3 = new NameValuePair(cstString, parseValue);
        return nameValuePair2;
    }

    private Constant parseValue() throws IOException {
        List list;
        CstArray cstArray;
        StringBuilder sb;
        StringBuilder sb2;
        CstAnnotation cstAnnotation;
        CstEnumRef cstEnumRef;
        CstNat cstNat;
        StringBuilder sb3;
        StringBuilder sb4;
        CstType cstType;
        StringBuilder sb5;
        ParseException parseException;
        StringBuilder sb6;
        CstString cstString;
        StringBuilder sb7;
        int readUnsignedByte = this.input.readUnsignedByte();
        if (this.observer != null) {
            CstString cstString2 = cstString;
            CstString cstString3 = new CstString(Character.toString((char) readUnsignedByte));
            CstString cstString4 = cstString2;
            StringBuilder sb8 = sb7;
            StringBuilder sb9 = new StringBuilder();
            parsed(1, sb8.append("tag: ").append(cstString4.toQuoted()).toString());
        }
        switch (readUnsignedByte) {
            case 64:
                CstAnnotation cstAnnotation2 = cstAnnotation;
                CstAnnotation cstAnnotation3 = new CstAnnotation(parseAnnotation(AnnotationVisibility.EMBEDDED));
                return cstAnnotation2;
            case 66:
                return CstByte.make(((CstInteger) parseConstant()).getValue());
            case 67:
                CstInteger cstInteger = (CstInteger) parseConstant();
                int value = cstInteger.getValue();
                return CstChar.make(cstInteger.getValue());
            case 68:
                return (CstDouble) parseConstant();
            case 70:
                return (CstFloat) parseConstant();
            case 73:
                return (CstInteger) parseConstant();
            case 74:
                return (CstLong) parseConstant();
            case 83:
                return CstShort.make(((CstInteger) parseConstant()).getValue());
            case 90:
                return CstBoolean.make(((CstInteger) parseConstant()).getValue());
            case 91:
                requireLength(2);
                int readUnsignedShort = this.input.readUnsignedShort();
                List list2 = list;
                List list3 = new List(readUnsignedShort);
                List list4 = list2;
                if (this.observer != null) {
                    StringBuilder sb10 = sb2;
                    StringBuilder sb11 = new StringBuilder();
                    parsed(2, sb10.append("num_values: ").append(readUnsignedShort).toString());
                    changeIndent(1);
                }
                for (int i = 0; i < readUnsignedShort; i++) {
                    if (this.observer != null) {
                        changeIndent(-1);
                        StringBuilder sb12 = sb;
                        StringBuilder sb13 = new StringBuilder();
                        parsed(0, sb12.append("element_value[").append(i).append("]:").toString());
                        changeIndent(1);
                    }
                    list4.set(i, parseValue());
                }
                if (this.observer != null) {
                    changeIndent(-1);
                }
                list4.setImmutable();
                CstArray cstArray2 = cstArray;
                CstArray cstArray3 = new CstArray(list4);
                return cstArray2;
            case 99:
                Type internReturnType = Type.internReturnType(((CstString) this.pool.get(this.input.readUnsignedShort())).getString());
                if (this.observer != null) {
                    StringBuilder sb14 = sb5;
                    StringBuilder sb15 = new StringBuilder();
                    parsed(2, sb14.append("class_info: ").append(internReturnType.toHuman()).toString());
                }
                CstType cstType2 = cstType;
                CstType cstType3 = new CstType(internReturnType);
                return cstType2;
            case 101:
                requireLength(4);
                int readUnsignedShort2 = this.input.readUnsignedShort();
                CstString cstString5 = (CstString) this.pool.get(readUnsignedShort2);
                CstString cstString6 = (CstString) this.pool.get(this.input.readUnsignedShort());
                if (this.observer != null) {
                    StringBuilder sb16 = sb3;
                    StringBuilder sb17 = new StringBuilder();
                    parsed(2, sb16.append("type_name: ").append(cstString5.toHuman()).toString());
                    StringBuilder sb18 = sb4;
                    StringBuilder sb19 = new StringBuilder();
                    parsed(2, sb18.append("const_name: ").append(cstString6.toHuman()).toString());
                }
                CstEnumRef cstEnumRef2 = cstEnumRef;
                CstNat cstNat2 = cstNat;
                CstNat cstNat3 = new CstNat(cstString6, cstString5);
                CstEnumRef cstEnumRef3 = new CstEnumRef(cstNat2);
                return cstEnumRef2;
            case 115:
                return parseConstant();
            default:
                ParseException parseException2 = parseException;
                StringBuilder sb20 = sb6;
                StringBuilder sb21 = new StringBuilder();
                ParseException parseException3 = new ParseException(sb20.append("unknown annotation tag: ").append(Hex.m50u1(readUnsignedByte)).toString());
                throw parseException2;
        }
    }

    private void parsed(int i, String str) {
        int i2 = i;
        this.observer.parsed(this.bytes, this.parseCursor, i2, str);
        this.parseCursor = i2 + this.parseCursor;
    }

    private void requireLength(int i) throws IOException {
        ParseException parseException;
        if (this.input.available() < i) {
            ParseException parseException2 = parseException;
            ParseException parseException3 = new ParseException("truncated annotation attribute");
            throw parseException2;
        }
    }

    public Annotations parseAnnotationAttribute(AnnotationVisibility annotationVisibility) {
        RuntimeException runtimeException;
        ParseException parseException;
        try {
            Annotations parseAnnotations = parseAnnotations(annotationVisibility);
            if (this.input.available() == 0) {
                return parseAnnotations;
            }
            ParseException parseException2 = parseException;
            ParseException parseException3 = new ParseException("extra data in attribute");
            throw parseException2;
        } catch (IOException e) {
            IOException iOException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("shouldn't happen", iOException);
            throw runtimeException2;
        }
    }

    public AnnotationsList parseParameterAttribute(AnnotationVisibility annotationVisibility) {
        RuntimeException runtimeException;
        ParseException parseException;
        try {
            AnnotationsList parseAnnotationsList = parseAnnotationsList(annotationVisibility);
            if (this.input.available() == 0) {
                return parseAnnotationsList;
            }
            ParseException parseException2 = parseException;
            ParseException parseException3 = new ParseException("extra data in attribute");
            throw parseException2;
        } catch (IOException e) {
            IOException iOException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("shouldn't happen", iOException);
            throw runtimeException2;
        }
    }

    public Constant parseValueAttribute() {
        RuntimeException runtimeException;
        ParseException parseException;
        try {
            Constant parseValue = parseValue();
            if (this.input.available() == 0) {
                return parseValue;
            }
            ParseException parseException2 = parseException;
            ParseException parseException3 = new ParseException("extra data in attribute");
            throw parseException2;
        } catch (IOException e) {
            IOException iOException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("shouldn't happen", iOException);
            throw runtimeException2;
        }
    }
}
