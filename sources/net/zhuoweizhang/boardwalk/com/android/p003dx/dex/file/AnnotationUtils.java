package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotation;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.AnnotationVisibility;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.NameValuePair;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstAnnotation;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstArray.List;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.AnnotationUtils */
public final class AnnotationUtils {
    private static final CstString ACCESS_FLAGS_STRING;
    private static final CstType ANNOTATION_DEFAULT_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/AnnotationDefault;"));
    public static final int DALVIK_ANNOTATION_NUMBER = 7;
    private static final CstType ENCLOSING_CLASS_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/EnclosingClass;"));
    private static final CstType ENCLOSING_METHOD_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/EnclosingMethod;"));
    private static final CstType INNER_CLASS_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/InnerClass;"));
    private static final CstType MEMBER_CLASSES_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/MemberClasses;"));
    private static final CstString NAME_STRING;
    private static final CstType SIGNATURE_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/Signature;"));
    private static final CstType THROWS_TYPE = CstType.intern(Type.intern("Ldalvik/annotation/Throws;"));
    private static final CstString VALUE_STRING;

    static {
        CstString cstString;
        CstString cstString2;
        CstString cstString3;
        CstString cstString4 = cstString;
        CstString cstString5 = new CstString("accessFlags");
        ACCESS_FLAGS_STRING = cstString4;
        CstString cstString6 = cstString2;
        CstString cstString7 = new CstString("name");
        NAME_STRING = cstString6;
        CstString cstString8 = cstString3;
        CstString cstString9 = new CstString("value");
        VALUE_STRING = cstString8;
    }

    private AnnotationUtils() {
    }

    public static Annotation makeAnnotationDefault(Annotation annotation) {
        Annotation annotation2;
        NameValuePair nameValuePair;
        CstAnnotation cstAnnotation;
        Annotation annotation3 = annotation;
        Annotation annotation4 = annotation2;
        Annotation annotation5 = new Annotation(ANNOTATION_DEFAULT_TYPE, AnnotationVisibility.SYSTEM);
        Annotation annotation6 = annotation4;
        Annotation annotation7 = annotation6;
        NameValuePair nameValuePair2 = nameValuePair;
        CstString cstString = VALUE_STRING;
        CstAnnotation cstAnnotation2 = cstAnnotation;
        CstAnnotation cstAnnotation3 = new CstAnnotation(annotation3);
        NameValuePair nameValuePair3 = new NameValuePair(cstString, cstAnnotation2);
        annotation7.put(nameValuePair2);
        annotation6.setImmutable();
        return annotation6;
    }

    private static CstArray makeCstArray(TypeList typeList) {
        List list;
        CstArray cstArray;
        TypeList typeList2 = typeList;
        int size = typeList2.size();
        List list2 = list;
        List list3 = new List(size);
        List list4 = list2;
        for (int i = 0; i < size; i++) {
            list4.set(i, CstType.intern(typeList2.getType(i)));
        }
        list4.setImmutable();
        CstArray cstArray2 = cstArray;
        CstArray cstArray3 = new CstArray(list4);
        return cstArray2;
    }

    public static Annotation makeEnclosingClass(CstType cstType) {
        Annotation annotation;
        NameValuePair nameValuePair;
        CstType cstType2 = cstType;
        Annotation annotation2 = annotation;
        Annotation annotation3 = new Annotation(ENCLOSING_CLASS_TYPE, AnnotationVisibility.SYSTEM);
        Annotation annotation4 = annotation2;
        Annotation annotation5 = annotation4;
        NameValuePair nameValuePair2 = nameValuePair;
        NameValuePair nameValuePair3 = new NameValuePair(VALUE_STRING, cstType2);
        annotation5.put(nameValuePair2);
        annotation4.setImmutable();
        return annotation4;
    }

    public static Annotation makeEnclosingMethod(CstMethodRef cstMethodRef) {
        Annotation annotation;
        NameValuePair nameValuePair;
        CstMethodRef cstMethodRef2 = cstMethodRef;
        Annotation annotation2 = annotation;
        Annotation annotation3 = new Annotation(ENCLOSING_METHOD_TYPE, AnnotationVisibility.SYSTEM);
        Annotation annotation4 = annotation2;
        Annotation annotation5 = annotation4;
        NameValuePair nameValuePair2 = nameValuePair;
        NameValuePair nameValuePair3 = new NameValuePair(VALUE_STRING, cstMethodRef2);
        annotation5.put(nameValuePair2);
        annotation4.setImmutable();
        return annotation4;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString, code=net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant, for r9v0, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant, net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotation makeInnerClass(net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant r9, int r10) {
        /*
            r0 = r9
            r1 = r10
            net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.Annotation r3 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.Annotation
            r8 = r3
            r3 = r8
            r4 = r8
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r5 = INNER_CLASS_TYPE
            net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.AnnotationVisibility r6 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.AnnotationVisibility.SYSTEM
            r4.<init>(r5, r6)
            r2 = r3
            r3 = r0
            if (r3 == 0) goto L_0x003b
        L_0x0012:
            r3 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.NameValuePair r4 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.NameValuePair
            r8 = r4
            r4 = r8
            r5 = r8
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString r6 = NAME_STRING
            r7 = r0
            r5.<init>(r6, r7)
            r3.put(r4)
            r3 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.NameValuePair r4 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.NameValuePair
            r8 = r4
            r4 = r8
            r5 = r8
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString r6 = ACCESS_FLAGS_STRING
            r7 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstInteger r7 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger.make(r7)
            r5.<init>(r6, r7)
            r3.put(r4)
            r3 = r2
            r3.setImmutable()
            r3 = r2
            r0 = r3
            return r0
        L_0x003b:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstKnownNull r3 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstKnownNull.THE_ONE
            r0 = r3
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.AnnotationUtils.makeInnerClass(net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString, int):net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.Annotation");
    }

    public static Annotation makeMemberClasses(TypeList typeList) {
        Annotation annotation;
        NameValuePair nameValuePair;
        CstArray makeCstArray = makeCstArray(typeList);
        Annotation annotation2 = annotation;
        Annotation annotation3 = new Annotation(MEMBER_CLASSES_TYPE, AnnotationVisibility.SYSTEM);
        Annotation annotation4 = annotation2;
        Annotation annotation5 = annotation4;
        NameValuePair nameValuePair2 = nameValuePair;
        NameValuePair nameValuePair3 = new NameValuePair(VALUE_STRING, makeCstArray);
        annotation5.put(nameValuePair2);
        annotation4.setImmutable();
        return annotation4;
    }

    public static Annotation makeSignature(CstString cstString) {
        Annotation annotation;
        ArrayList arrayList;
        List list;
        NameValuePair nameValuePair;
        CstArray cstArray;
        CstString cstString2;
        CstString cstString3 = cstString;
        Annotation annotation2 = annotation;
        Annotation annotation3 = new Annotation(SIGNATURE_TYPE, AnnotationVisibility.SYSTEM);
        Annotation annotation4 = annotation2;
        String string = cstString3.getString();
        int length = string.length();
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(20);
        ArrayList arrayList4 = arrayList2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            int i3 = i2 + 1;
            if (string.charAt(i2) == 'L') {
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    char charAt = string.charAt(i3);
                    if (charAt != ';') {
                        if (charAt == '<') {
                            break;
                        }
                        i3++;
                    } else {
                        i3++;
                        break;
                    }
                }
            } else {
                while (i3 < length && string.charAt(i3) != 'L') {
                    i3++;
                }
            }
            boolean add = arrayList4.add(string.substring(i2, i3));
            i = i3;
        }
        int size = arrayList4.size();
        List list2 = list;
        List list3 = new List(size);
        List list4 = list2;
        for (int i4 = 0; i4 < size; i4++) {
            List list5 = list4;
            int i5 = i4;
            CstString cstString4 = cstString2;
            CstString cstString5 = new CstString((String) arrayList4.get(i4));
            list5.set(i5, cstString4);
        }
        list4.setImmutable();
        Annotation annotation5 = annotation4;
        NameValuePair nameValuePair2 = nameValuePair;
        CstString cstString6 = VALUE_STRING;
        CstArray cstArray2 = cstArray;
        CstArray cstArray3 = new CstArray(list4);
        NameValuePair nameValuePair3 = new NameValuePair(cstString6, cstArray2);
        annotation5.put(nameValuePair2);
        annotation4.setImmutable();
        return annotation4;
    }

    public static Annotation makeThrows(TypeList typeList) {
        Annotation annotation;
        NameValuePair nameValuePair;
        CstArray makeCstArray = makeCstArray(typeList);
        Annotation annotation2 = annotation;
        Annotation annotation3 = new Annotation(THROWS_TYPE, AnnotationVisibility.SYSTEM);
        Annotation annotation4 = annotation2;
        Annotation annotation5 = annotation4;
        NameValuePair nameValuePair2 = nameValuePair;
        NameValuePair nameValuePair3 = new NameValuePair(VALUE_STRING, makeCstArray);
        annotation5.put(nameValuePair2);
        annotation4.setImmutable();
        return annotation4;
    }
}
