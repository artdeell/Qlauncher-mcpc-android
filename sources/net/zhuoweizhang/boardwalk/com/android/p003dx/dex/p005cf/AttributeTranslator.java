package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.p005cf;

import java.io.PrintStream;
import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.AnnotationUtils;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttAnnotationDefault;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttEnclosingMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttExceptions;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttInnerClasses;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttRuntimeInvisibleAnnotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttRuntimeInvisibleParameterAnnotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttRuntimeVisibleAnnotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttRuntimeVisibleParameterAnnotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttSignature;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.InnerClassList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.InnerClassList.Item;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.DirectClassFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.AttributeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Method;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.MethodList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotation;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.AnnotationVisibility;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.AnnotationsList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.NameValuePair;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.AccessFlags;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Warning;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.cf.AttributeTranslator */
class AttributeTranslator {
    private AttributeTranslator() {
    }

    public static Annotations getAnnotations(AttributeList attributeList) {
        AttributeList attributeList2 = attributeList;
        Annotations annotations0 = getAnnotations0(attributeList2);
        Annotation signature = getSignature(attributeList2);
        if (signature != null) {
            annotations0 = Annotations.combine(annotations0, signature);
        }
        return annotations0;
    }

    private static Annotations getAnnotations0(AttributeList attributeList) {
        AttributeList attributeList2 = attributeList;
        AttRuntimeVisibleAnnotations attRuntimeVisibleAnnotations = (AttRuntimeVisibleAnnotations) attributeList2.findFirst(AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME);
        AttRuntimeInvisibleAnnotations attRuntimeInvisibleAnnotations = (AttRuntimeInvisibleAnnotations) attributeList2.findFirst(AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME);
        return attRuntimeVisibleAnnotations == null ? attRuntimeInvisibleAnnotations == null ? Annotations.EMPTY : attRuntimeInvisibleAnnotations.getAnnotations() : attRuntimeInvisibleAnnotations == null ? attRuntimeVisibleAnnotations.getAnnotations() : Annotations.combine(attRuntimeVisibleAnnotations.getAnnotations(), attRuntimeInvisibleAnnotations.getAnnotations());
    }

    public static Annotations getClassAnnotations(DirectClassFile directClassFile, CfOptions cfOptions) {
        StringBuilder sb;
        DirectClassFile directClassFile2 = directClassFile;
        CfOptions cfOptions2 = cfOptions;
        CstType thisClass = directClassFile2.getThisClass();
        AttributeList attributes = directClassFile2.getAttributes();
        Annotations annotations = getAnnotations(attributes);
        Annotation translateEnclosingMethod = translateEnclosingMethod(attributes);
        try {
            Annotations translateInnerClasses = translateInnerClasses(thisClass, attributes, translateEnclosingMethod == null);
            if (translateInnerClasses != null) {
                annotations = Annotations.combine(annotations, translateInnerClasses);
            }
        } catch (Warning e) {
            Warning warning = e;
            PrintStream printStream = cfOptions2.warn;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("warning: ").append(warning.getMessage()).toString());
        }
        if (translateEnclosingMethod != null) {
            annotations = Annotations.combine(annotations, translateEnclosingMethod);
        }
        if (AccessFlags.isAnnotation(directClassFile2.getAccessFlags())) {
            Annotation translateAnnotationDefaults = translateAnnotationDefaults(directClassFile2);
            if (translateAnnotationDefaults != null) {
                annotations = Annotations.combine(annotations, translateAnnotationDefaults);
            }
        }
        return annotations;
    }

    public static TypeList getExceptions(Method method) {
        AttExceptions attExceptions = (AttExceptions) method.getAttributes().findFirst(AttExceptions.ATTRIBUTE_NAME);
        return attExceptions == null ? StdTypeList.EMPTY : attExceptions.getExceptions();
    }

    public static Annotations getMethodAnnotations(Method method) {
        Method method2 = method;
        Annotations annotations = getAnnotations(method2.getAttributes());
        TypeList exceptions = getExceptions(method2);
        if (exceptions.size() != 0) {
            annotations = Annotations.combine(annotations, AnnotationUtils.makeThrows(exceptions));
        }
        return annotations;
    }

    public static AnnotationsList getParameterAnnotations(Method method) {
        AttributeList attributes = method.getAttributes();
        AttRuntimeVisibleParameterAnnotations attRuntimeVisibleParameterAnnotations = (AttRuntimeVisibleParameterAnnotations) attributes.findFirst(AttRuntimeVisibleParameterAnnotations.ATTRIBUTE_NAME);
        AttRuntimeInvisibleParameterAnnotations attRuntimeInvisibleParameterAnnotations = (AttRuntimeInvisibleParameterAnnotations) attributes.findFirst(AttRuntimeInvisibleParameterAnnotations.ATTRIBUTE_NAME);
        return attRuntimeVisibleParameterAnnotations == null ? attRuntimeInvisibleParameterAnnotations == null ? AnnotationsList.EMPTY : attRuntimeInvisibleParameterAnnotations.getParameterAnnotations() : attRuntimeInvisibleParameterAnnotations == null ? attRuntimeVisibleParameterAnnotations.getParameterAnnotations() : AnnotationsList.combine(attRuntimeVisibleParameterAnnotations.getParameterAnnotations(), attRuntimeInvisibleParameterAnnotations.getParameterAnnotations());
    }

    private static Annotation getSignature(AttributeList attributeList) {
        AttSignature attSignature = (AttSignature) attributeList.findFirst(AttSignature.ATTRIBUTE_NAME);
        if (attSignature == null) {
            return null;
        }
        return AnnotationUtils.makeSignature(attSignature.getSignature());
    }

    private static Annotation translateAnnotationDefaults(DirectClassFile directClassFile) {
        Annotation annotation;
        boolean z;
        boolean z2;
        NameValuePair nameValuePair;
        DirectClassFile directClassFile2 = directClassFile;
        CstType thisClass = directClassFile2.getThisClass();
        MethodList methods = directClassFile2.getMethods();
        int size = methods.size();
        Annotation annotation2 = annotation;
        Annotation annotation3 = new Annotation(thisClass, AnnotationVisibility.EMBEDDED);
        Annotation annotation4 = annotation2;
        int i = 0;
        boolean z3 = false;
        while (true) {
            z = z3;
            if (i >= size) {
                break;
            }
            Method method = methods.get(i);
            AttAnnotationDefault attAnnotationDefault = (AttAnnotationDefault) method.getAttributes().findFirst(AttAnnotationDefault.ATTRIBUTE_NAME);
            if (attAnnotationDefault != null) {
                Annotation annotation5 = annotation4;
                NameValuePair nameValuePair2 = nameValuePair;
                NameValuePair nameValuePair3 = new NameValuePair(method.getNat().getName(), attAnnotationDefault.getValue());
                annotation5.add(nameValuePair2);
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z3 = z2;
        }
        if (!z) {
            return null;
        }
        annotation4.setImmutable();
        return AnnotationUtils.makeAnnotationDefault(annotation4);
    }

    private static Annotation translateEnclosingMethod(AttributeList attributeList) {
        CstMethodRef cstMethodRef;
        AttEnclosingMethod attEnclosingMethod = (AttEnclosingMethod) attributeList.findFirst(AttEnclosingMethod.ATTRIBUTE_NAME);
        if (attEnclosingMethod == null) {
            return null;
        }
        CstType enclosingClass = attEnclosingMethod.getEnclosingClass();
        CstNat method = attEnclosingMethod.getMethod();
        if (method == null) {
            return AnnotationUtils.makeEnclosingClass(enclosingClass);
        }
        CstMethodRef cstMethodRef2 = cstMethodRef;
        CstMethodRef cstMethodRef3 = new CstMethodRef(enclosingClass, method);
        return AnnotationUtils.makeEnclosingMethod(cstMethodRef2);
    }

    private static Annotations translateInnerClasses(CstType cstType, AttributeList attributeList, boolean z) {
        ArrayList arrayList;
        Item item;
        Annotations annotations;
        StdTypeList stdTypeList;
        Warning warning;
        StringBuilder sb;
        CstType cstType2 = cstType;
        boolean z2 = z;
        AttInnerClasses attInnerClasses = (AttInnerClasses) attributeList.findFirst(AttInnerClasses.ATTRIBUTE_NAME);
        if (attInnerClasses == null) {
            return null;
        }
        InnerClassList innerClasses = attInnerClasses.getInnerClasses();
        int size = innerClasses.size();
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        int i = 0;
        Item item2 = null;
        while (true) {
            item = item2;
            if (i >= size) {
                break;
            }
            Item item3 = innerClasses.get(i);
            CstType innerClass = item3.getInnerClass();
            if (!innerClass.equals(cstType2)) {
                if (cstType2.equals(item3.getOuterClass())) {
                    boolean add = arrayList4.add(innerClass.getClassType());
                }
                item3 = item;
            }
            i++;
            item2 = item3;
        }
        int size2 = arrayList4.size();
        if (item == null && size2 == 0) {
            return null;
        }
        Annotations annotations2 = annotations;
        Annotations annotations3 = new Annotations();
        Annotations annotations4 = annotations2;
        if (item != null) {
            annotations4.add(AnnotationUtils.makeInnerClass(item.getInnerName(), item.getAccessFlags()));
            if (z2) {
                if (item.getOuterClass() == null) {
                    Warning warning2 = warning;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    Warning warning3 = new Warning(sb2.append("Ignoring InnerClasses attribute for an anonymous inner class\n(").append(cstType2.toHuman()).append(") that doesn't come with an\n").append("associated EnclosingMethod attribute. ").append("This class was probably produced by a\n").append("compiler that did not target the modern ").append(".class file format. The recommended\n").append("solution is to recompile the class from ").append("source, using an up-to-date compiler\n").append("and without specifying any \"-target\" type ").append("options. The consequence of ignoring\n").append("this warning is that reflective operations ").append("on this class will incorrectly\n").append("indicate that it is *not* an inner class.").toString());
                    throw warning2;
                }
                annotations4.add(AnnotationUtils.makeEnclosingClass(item.getOuterClass()));
            }
        }
        if (size2 != 0) {
            StdTypeList stdTypeList2 = stdTypeList;
            StdTypeList stdTypeList3 = new StdTypeList(size2);
            StdTypeList stdTypeList4 = stdTypeList2;
            for (int i2 = 0; i2 < size2; i2++) {
                stdTypeList4.set(i2, (Type) arrayList4.get(i2));
            }
            stdTypeList4.setImmutable();
            annotations4.add(AnnotationUtils.makeMemberClasses(stdTypeList4));
        }
        annotations4.setImmutable();
        return annotations4;
    }
}
