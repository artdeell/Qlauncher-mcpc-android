package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttSourceFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Attribute;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.AttributeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ClassFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.FieldList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.MethodList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseObserver;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.StdAttributeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.ConstantPool;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.StdConstantPool;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.DirectClassFile */
public class DirectClassFile implements ClassFile {
    private static final int CLASS_FILE_MAGIC = -889275714;
    private static final int CLASS_FILE_MAX_MAJOR_VERSION = 51;
    private static final int CLASS_FILE_MAX_MINOR_VERSION = 0;
    private static final int CLASS_FILE_MIN_MAJOR_VERSION = 45;
    private int accessFlags;
    private AttributeFactory attributeFactory;
    private StdAttributeList attributes;
    private final ByteArray bytes;
    private FieldList fields;
    private final String filePath;
    private TypeList interfaces;
    private MethodList methods;
    private ParseObserver observer;
    private StdConstantPool pool;
    private final boolean strictParse;
    private CstType superClass;
    private CstType thisClass;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.DirectClassFile$DcfTypeList */
    private static class DcfTypeList implements TypeList {
        private final ByteArray bytes;
        private final StdConstantPool pool;
        private final int size;

        public DcfTypeList(ByteArray byteArray, int i, int i2, StdConstantPool stdConstantPool, ParseObserver parseObserver) {
            RuntimeException runtimeException;
            StringBuilder sb;
            IllegalArgumentException illegalArgumentException;
            ByteArray byteArray2 = byteArray;
            int i3 = i;
            int i4 = i2;
            StdConstantPool stdConstantPool2 = stdConstantPool;
            ParseObserver parseObserver2 = parseObserver;
            if (i4 < 0) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("size < 0");
                throw illegalArgumentException2;
            }
            ByteArray slice = byteArray2.slice(i3, i3 + (i4 * 2));
            this.bytes = slice;
            this.size = i4;
            this.pool = stdConstantPool2;
            int i5 = 0;
            while (i5 < i4) {
                int i6 = i5 * 2;
                try {
                    CstType cstType = (CstType) stdConstantPool2.get(slice.getUnsignedShort(i6));
                    if (parseObserver2 != null) {
                        ParseObserver parseObserver3 = parseObserver2;
                        ByteArray byteArray3 = slice;
                        int i7 = i6;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        parseObserver3.parsed(byteArray3, i7, 2, sb2.append("  ").append(cstType).toString());
                    }
                    i5++;
                } catch (ClassCastException e) {
                    ClassCastException classCastException = e;
                    RuntimeException runtimeException2 = runtimeException;
                    RuntimeException runtimeException3 = new RuntimeException("bogus class cpi", classCastException);
                    throw runtimeException2;
                }
            }
        }

        public Type getType(int i) {
            return ((CstType) this.pool.get(this.bytes.getUnsignedShort(i * 2))).getClassType();
        }

        public int getWordCount() {
            return this.size;
        }

        public boolean isMutable() {
            return false;
        }

        public int size() {
            return this.size;
        }

        public TypeList withAddedType(Type type) {
            UnsupportedOperationException unsupportedOperationException;
            Type type2 = type;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("unsupported");
            throw unsupportedOperationException2;
        }
    }

    public DirectClassFile(ByteArray byteArray, String str, boolean z) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        ByteArray byteArray2 = byteArray;
        String str2 = str;
        boolean z2 = z;
        if (byteArray2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("bytes == null");
            throw nullPointerException3;
        } else if (str2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("filePath == null");
            throw nullPointerException5;
        } else {
            this.filePath = str2;
            this.bytes = byteArray2;
            this.strictParse = z2;
            this.accessFlags = -1;
        }
    }

    public DirectClassFile(byte[] bArr, String str, boolean z) {
        ByteArray byteArray;
        String str2 = str;
        boolean z2 = z;
        ByteArray byteArray2 = byteArray;
        ByteArray byteArray3 = new ByteArray(bArr);
        this(byteArray2, str2, z2);
    }

    private boolean isGoodVersion(int i, int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        return i == CLASS_FILE_MAGIC && i4 >= 0 && (i5 != 51 ? !(i5 >= 51 || i5 < 45) : i4 <= 0);
    }

    private void parse() {
        ParseException parseException;
        StringBuilder sb;
        StringBuilder sb2;
        try {
            parse0();
        } catch (ParseException e) {
            ParseException parseException2 = e;
            ParseException parseException3 = parseException2;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            parseException3.addContext(sb3.append("...while parsing ").append(this.filePath).toString());
            throw parseException2;
        } catch (RuntimeException e2) {
            RuntimeException runtimeException = e2;
            ParseException parseException4 = parseException;
            ParseException parseException5 = new ParseException((Throwable) runtimeException);
            ParseException parseException6 = parseException4;
            ParseException parseException7 = parseException6;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            parseException7.addContext(sb5.append("...while parsing ").append(this.filePath).toString());
            throw parseException6;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x03c8, code lost:
        if (r2.filePath.length() != (6 + r16.length())) goto L_0x03ca;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parse0() {
        /*
            r24 = this;
            r2 = r24
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r17 = r0
            int r17 = r17.size()
            r18 = 10
            r0 = r17
            r1 = r18
            if (r0 >= r1) goto L_0x0024
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException r17 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException
            r23 = r17
            r17 = r23
            r18 = r23
            java.lang.String r19 = "severely truncated class file"
            r18.<init>(r19)
            throw r17
        L_0x0024:
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r17 = r0
            if (r17 == 0) goto L_0x00f5
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r17 = r0
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r18 = r0
            r19 = 0
            r20 = 0
            java.lang.String r21 = "begin classfile"
            r17.parsed(r18, r19, r20, r21)
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r17 = r0
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r18 = r0
            r19 = 0
            r20 = 4
            java.lang.StringBuilder r21 = new java.lang.StringBuilder
            r23 = r21
            r21 = r23
            r22 = r23
            r22.<init>()
            java.lang.String r22 = "magic: "
            java.lang.StringBuilder r21 = r21.append(r22)
            r22 = r2
            int r22 = r22.getMagic0()
            java.lang.String r22 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m53u4(r22)
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r21 = r21.toString()
            r17.parsed(r18, r19, r20, r21)
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r17 = r0
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r18 = r0
            r19 = 4
            r20 = 2
            java.lang.StringBuilder r21 = new java.lang.StringBuilder
            r23 = r21
            r21 = r23
            r22 = r23
            r22.<init>()
            java.lang.String r22 = "minor_version: "
            java.lang.StringBuilder r21 = r21.append(r22)
            r22 = r2
            int r22 = r22.getMinorVersion0()
            java.lang.String r22 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m51u2(r22)
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r21 = r21.toString()
            r17.parsed(r18, r19, r20, r21)
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r17 = r0
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r18 = r0
            r19 = 6
            r20 = 2
            java.lang.StringBuilder r21 = new java.lang.StringBuilder
            r23 = r21
            r21 = r23
            r22 = r23
            r22.<init>()
            java.lang.String r22 = "major_version: "
            java.lang.StringBuilder r21 = r21.append(r22)
            r22 = r2
            int r22 = r22.getMajorVersion0()
            java.lang.String r22 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m51u2(r22)
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r21 = r21.toString()
            r17.parsed(r18, r19, r20, r21)
        L_0x00f5:
            r17 = r2
            r0 = r17
            boolean r0 = r0.strictParse
            r17 = r0
            if (r17 == 0) goto L_0x0176
            r17 = r2
            r18 = r2
            int r18 = r18.getMagic0()
            r19 = r2
            int r19 = r19.getMinorVersion0()
            r20 = r2
            int r20 = r20.getMajorVersion0()
            boolean r17 = r17.isGoodVersion(r18, r19, r20)
            if (r17 != 0) goto L_0x0176
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException r17 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException
            r23 = r17
            r17 = r23
            r18 = r23
            java.lang.StringBuilder r19 = new java.lang.StringBuilder
            r23 = r19
            r19 = r23
            r20 = r23
            r20.<init>()
            java.lang.String r20 = "bad class file magic ("
            java.lang.StringBuilder r19 = r19.append(r20)
            r20 = r2
            int r20 = r20.getMagic0()
            java.lang.String r20 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m53u4(r20)
            java.lang.StringBuilder r19 = r19.append(r20)
            java.lang.String r20 = ") or version ("
            java.lang.StringBuilder r19 = r19.append(r20)
            r20 = r2
            int r20 = r20.getMajorVersion0()
            java.lang.String r20 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m51u2(r20)
            java.lang.StringBuilder r19 = r19.append(r20)
            java.lang.String r20 = "."
            java.lang.StringBuilder r19 = r19.append(r20)
            r20 = r2
            int r20 = r20.getMinorVersion0()
            java.lang.String r20 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m51u2(r20)
            java.lang.StringBuilder r19 = r19.append(r20)
            java.lang.String r20 = ")"
            java.lang.StringBuilder r19 = r19.append(r20)
            java.lang.String r19 = r19.toString()
            r18.<init>(r19)
            throw r17
        L_0x0176:
            net.zhuoweizhang.boardwalk.com.android.dx.cf.cst.ConstantPoolParser r17 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.cst.ConstantPoolParser
            r23 = r17
            r17 = r23
            r18 = r23
            r19 = r2
            r0 = r19
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r19 = r0
            r18.<init>(r19)
            r3 = r17
            r17 = r3
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r18 = r0
            r17.setObserver(r18)
            r17 = r2
            r18 = r3
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.StdConstantPool r18 = r18.getPool()
            r0 = r18
            r1 = r17
            r1.pool = r0
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.StdConstantPool r0 = r0.pool
            r17 = r0
            r17.setImmutable()
            r17 = r3
            int r17 = r17.getEndOffset()
            r4 = r17
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r17 = r0
            r18 = r4
            int r17 = r17.getUnsignedShort(r18)
            r5 = r17
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r17 = r0
            r18 = r4
            r19 = 2
            int r18 = r18 + 2
            int r17 = r17.getUnsignedShort(r18)
            r6 = r17
            r17 = r2
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.StdConstantPool r0 = r0.pool
            r18 = r0
            r19 = r6
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r18 = r18.get(r19)
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r18 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType) r18
            r0 = r18
            r1 = r17
            r1.thisClass = r0
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r17 = r0
            r18 = r4
            r19 = 4
            int r18 = r18 + 4
            int r17 = r17.getUnsignedShort(r18)
            r7 = r17
            r17 = r2
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.StdConstantPool r0 = r0.pool
            r18 = r0
            r19 = r7
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r18 = r18.get0Ok(r19)
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r18 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType) r18
            r0 = r18
            r1 = r17
            r1.superClass = r0
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r17 = r0
            r18 = r4
            r19 = 6
            int r18 = r18 + 6
            int r17 = r17.getUnsignedShort(r18)
            r8 = r17
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r17 = r0
            if (r17 == 0) goto L_0x034c
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r17 = r0
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r18 = r0
            r19 = r4
            r20 = 2
            java.lang.StringBuilder r21 = new java.lang.StringBuilder
            r23 = r21
            r21 = r23
            r22 = r23
            r22.<init>()
            java.lang.String r22 = "access_flags: "
            java.lang.StringBuilder r21 = r21.append(r22)
            r22 = r5
            java.lang.String r22 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.AccessFlags.classString(r22)
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r21 = r21.toString()
            r17.parsed(r18, r19, r20, r21)
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r17 = r0
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r18 = r0
            r19 = r4
            r20 = 2
            int r19 = r19 + 2
            r20 = 2
            java.lang.StringBuilder r21 = new java.lang.StringBuilder
            r23 = r21
            r21 = r23
            r22 = r23
            r22.<init>()
            java.lang.String r22 = "this_class: "
            java.lang.StringBuilder r21 = r21.append(r22)
            r22 = r2
            r0 = r22
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r0 = r0.thisClass
            r22 = r0
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r21 = r21.toString()
            r17.parsed(r18, r19, r20, r21)
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r17 = r0
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r18 = r0
            r19 = r4
            r20 = 4
            int r19 = r19 + 4
            r20 = 2
            java.lang.StringBuilder r21 = new java.lang.StringBuilder
            r23 = r21
            r21 = r23
            r22 = r23
            r22.<init>()
            java.lang.String r22 = "super_class: "
            java.lang.StringBuilder r21 = r21.append(r22)
            r22 = r2
            r0 = r22
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r0 = r0.superClass
            r22 = r0
            java.lang.String r22 = stringOrNone(r22)
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r21 = r21.toString()
            r17.parsed(r18, r19, r20, r21)
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r17 = r0
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r18 = r0
            r19 = r4
            r20 = 6
            int r19 = r19 + 6
            r20 = 2
            java.lang.StringBuilder r21 = new java.lang.StringBuilder
            r23 = r21
            r21 = r23
            r22 = r23
            r22.<init>()
            java.lang.String r22 = "interfaces_count: "
            java.lang.StringBuilder r21 = r21.append(r22)
            r22 = r8
            java.lang.String r22 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m51u2(r22)
            java.lang.StringBuilder r21 = r21.append(r22)
            java.lang.String r21 = r21.toString()
            r17.parsed(r18, r19, r20, r21)
            r17 = r8
            if (r17 == 0) goto L_0x034c
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r17 = r0
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r18 = r0
            r19 = r4
            r20 = 8
            int r19 = r19 + 8
            r20 = 0
            java.lang.String r21 = "interfaces:"
            r17.parsed(r18, r19, r20, r21)
        L_0x034c:
            r17 = r4
            r18 = 8
            int r17 = r17 + 8
            r9 = r17
            r17 = r2
            r18 = r2
            r19 = r9
            r20 = r8
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeList r18 = r18.makeTypeList(r19, r20)
            r0 = r18
            r1 = r17
            r1.interfaces = r0
            r17 = r9
            r18 = r8
            r19 = 2
            int r18 = r18 * 2
            int r17 = r17 + r18
            r10 = r17
            r17 = r2
            r0 = r17
            boolean r0 = r0.strictParse
            r17 = r0
            if (r17 == 0) goto L_0x0409
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r0 = r0.thisClass
            r17 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r17 = r17.getClassType()
            java.lang.String r17 = r17.getClassName()
            r16 = r17
            r17 = r2
            r0 = r17
            java.lang.String r0 = r0.filePath
            r17 = r0
            java.lang.String r18 = ".class"
            boolean r17 = r17.endsWith(r18)
            if (r17 == 0) goto L_0x03ca
            r17 = r2
            r0 = r17
            java.lang.String r0 = r0.filePath
            r17 = r0
            r18 = r16
            boolean r17 = r17.startsWith(r18)
            if (r17 == 0) goto L_0x03ca
            r17 = r2
            r0 = r17
            java.lang.String r0 = r0.filePath
            r17 = r0
            int r17 = r17.length()
            r18 = 6
            r19 = r16
            int r19 = r19.length()
            int r18 = r18 + r19
            r0 = r17
            r1 = r18
            if (r0 == r1) goto L_0x0409
        L_0x03ca:
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException r17 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException
            r23 = r17
            r17 = r23
            r18 = r23
            java.lang.StringBuilder r19 = new java.lang.StringBuilder
            r23 = r19
            r19 = r23
            r20 = r23
            r20.<init>()
            java.lang.String r20 = "class name ("
            java.lang.StringBuilder r19 = r19.append(r20)
            r20 = r16
            java.lang.StringBuilder r19 = r19.append(r20)
            java.lang.String r20 = ") does not match path ("
            java.lang.StringBuilder r19 = r19.append(r20)
            r20 = r2
            r0 = r20
            java.lang.String r0 = r0.filePath
            r20 = r0
            java.lang.StringBuilder r19 = r19.append(r20)
            java.lang.String r20 = ")"
            java.lang.StringBuilder r19 = r19.append(r20)
            java.lang.String r19 = r19.toString()
            r18.<init>(r19)
            throw r17
        L_0x0409:
            r17 = r2
            r18 = r5
            r0 = r18
            r1 = r17
            r1.accessFlags = r0
            net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.FieldListParser r17 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.FieldListParser
            r23 = r17
            r17 = r23
            r18 = r23
            r19 = r2
            r20 = r2
            r0 = r20
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r0 = r0.thisClass
            r20 = r0
            r21 = r10
            r22 = r2
            r0 = r22
            net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.AttributeFactory r0 = r0.attributeFactory
            r22 = r0
            r18.<init>(r19, r20, r21, r22)
            r11 = r17
            r17 = r11
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r18 = r0
            r17.setObserver(r18)
            r17 = r2
            r18 = r11
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.StdFieldList r18 = r18.getList()
            r0 = r18
            r1 = r17
            r1.fields = r0
            r17 = r11
            int r17 = r17.getEndOffset()
            r12 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.MethodListParser r17 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.MethodListParser
            r23 = r17
            r17 = r23
            r18 = r23
            r19 = r2
            r20 = r2
            r0 = r20
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r0 = r0.thisClass
            r20 = r0
            r21 = r12
            r22 = r2
            r0 = r22
            net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.AttributeFactory r0 = r0.attributeFactory
            r22 = r0
            r18.<init>(r19, r20, r21, r22)
            r13 = r17
            r17 = r13
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r18 = r0
            r17.setObserver(r18)
            r17 = r2
            r18 = r13
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.StdMethodList r18 = r18.getList()
            r0 = r18
            r1 = r17
            r1.methods = r0
            net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.AttributeListParser r17 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.AttributeListParser
            r23 = r17
            r17 = r23
            r18 = r23
            r19 = r2
            r20 = 0
            r21 = r13
            int r21 = r21.getEndOffset()
            r22 = r2
            r0 = r22
            net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.AttributeFactory r0 = r0.attributeFactory
            r22 = r0
            r18.<init>(r19, r20, r21, r22)
            r14 = r17
            r17 = r14
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r18 = r0
            r17.setObserver(r18)
            r17 = r2
            r18 = r14
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.StdAttributeList r18 = r18.getList()
            r0 = r18
            r1 = r17
            r1.attributes = r0
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.StdAttributeList r0 = r0.attributes
            r17 = r0
            r17.setImmutable()
            r17 = r14
            int r17 = r17.getEndOffset()
            r15 = r17
            r17 = r15
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r18 = r0
            int r18 = r18.size()
            r0 = r17
            r1 = r18
            if (r0 == r1) goto L_0x051f
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException r17 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException
            r23 = r17
            r17 = r23
            r18 = r23
            java.lang.StringBuilder r19 = new java.lang.StringBuilder
            r23 = r19
            r19 = r23
            r20 = r23
            r20.<init>()
            java.lang.String r20 = "extra bytes at end of class file, at offset "
            java.lang.StringBuilder r19 = r19.append(r20)
            r20 = r15
            java.lang.String r20 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m53u4(r20)
            java.lang.StringBuilder r19 = r19.append(r20)
            java.lang.String r19 = r19.toString()
            r18.<init>(r19)
            throw r17
        L_0x051f:
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r17 = r0
            if (r17 == 0) goto L_0x0542
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseObserver r0 = r0.observer
            r17 = r0
            r18 = r2
            r0 = r18
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r18 = r0
            r19 = r15
            r20 = 0
            java.lang.String r21 = "end classfile"
            r17.parsed(r18, r19, r20, r21)
        L_0x0542:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.DirectClassFile.parse0():void");
    }

    private void parseToEndIfNecessary() {
        if (this.attributes == null) {
            parse();
        }
    }

    private void parseToInterfacesIfNecessary() {
        if (this.accessFlags == -1) {
            parse();
        }
    }

    public static String stringOrNone(Object obj) {
        Object obj2 = obj;
        return obj2 == null ? "(none)" : obj2.toString();
    }

    public int getAccessFlags() {
        parseToInterfacesIfNecessary();
        return this.accessFlags;
    }

    public AttributeList getAttributes() {
        parseToEndIfNecessary();
        return this.attributes;
    }

    public ByteArray getBytes() {
        return this.bytes;
    }

    public ConstantPool getConstantPool() {
        parseToInterfacesIfNecessary();
        return this.pool;
    }

    public FieldList getFields() {
        parseToEndIfNecessary();
        return this.fields;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public TypeList getInterfaces() {
        parseToInterfacesIfNecessary();
        return this.interfaces;
    }

    public int getMagic() {
        parseToInterfacesIfNecessary();
        return getMagic0();
    }

    public int getMagic0() {
        return this.bytes.getInt(0);
    }

    public int getMajorVersion() {
        parseToInterfacesIfNecessary();
        return getMajorVersion0();
    }

    public int getMajorVersion0() {
        return this.bytes.getUnsignedShort(6);
    }

    public MethodList getMethods() {
        parseToEndIfNecessary();
        return this.methods;
    }

    public int getMinorVersion() {
        parseToInterfacesIfNecessary();
        return getMinorVersion0();
    }

    public int getMinorVersion0() {
        return this.bytes.getUnsignedShort(4);
    }

    public CstString getSourceFile() {
        Attribute findFirst = getAttributes().findFirst(AttSourceFile.ATTRIBUTE_NAME);
        if (findFirst instanceof AttSourceFile) {
            return ((AttSourceFile) findFirst).getSourceFile();
        }
        return null;
    }

    public CstType getSuperclass() {
        parseToInterfacesIfNecessary();
        return this.superClass;
    }

    public CstType getThisClass() {
        parseToInterfacesIfNecessary();
        return this.thisClass;
    }

    public TypeList makeTypeList(int i, int i2) {
        DcfTypeList dcfTypeList;
        IllegalStateException illegalStateException;
        int i3 = i;
        int i4 = i2;
        if (i4 == 0) {
            return StdTypeList.EMPTY;
        }
        if (this.pool == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("pool not yet initialized");
            throw illegalStateException2;
        }
        DcfTypeList dcfTypeList2 = dcfTypeList;
        DcfTypeList dcfTypeList3 = new DcfTypeList(this.bytes, i3, i4, this.pool, this.observer);
        return dcfTypeList2;
    }

    public void setAttributeFactory(AttributeFactory attributeFactory2) {
        NullPointerException nullPointerException;
        AttributeFactory attributeFactory3 = attributeFactory2;
        if (attributeFactory3 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("attributeFactory == null");
            throw nullPointerException2;
        }
        this.attributeFactory = attributeFactory3;
    }

    public void setObserver(ParseObserver parseObserver) {
        ParseObserver parseObserver2 = parseObserver;
        this.observer = parseObserver2;
    }
}
