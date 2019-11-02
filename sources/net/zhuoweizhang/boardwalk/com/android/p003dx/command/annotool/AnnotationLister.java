package net.zhuoweizhang.boardwalk.com.android.p003dx.command.annotool;

import java.io.File;
import java.lang.annotation.ElementType;
import java.util.HashSet;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttRuntimeInvisibleAnnotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttRuntimeVisibleAnnotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.BaseAnnotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.ClassPathOpener;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.ClassPathOpener.Consumer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.DirectClassFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.StdAttributeFactory;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Attribute;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.AttributeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotation;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.annotool.AnnotationLister */
class AnnotationLister {
    private static final String PACKAGE_INFO = "package-info";
    private final Arguments args;
    HashSet<String> matchInnerClassesOf;
    HashSet<String> matchPackages;

    AnnotationLister(Arguments arguments) {
        HashSet<String> hashSet;
        HashSet<String> hashSet2;
        Arguments arguments2 = arguments;
        HashSet<String> hashSet3 = hashSet;
        HashSet<String> hashSet4 = new HashSet<>();
        this.matchInnerClassesOf = hashSet3;
        HashSet<String> hashSet5 = hashSet2;
        HashSet<String> hashSet6 = new HashSet<>();
        this.matchPackages = hashSet5;
        this.args = arguments2;
    }

    /* access modifiers changed from: private */
    public boolean isMatchingInnerClass(String str) {
        boolean z;
        String str2 = str;
        while (true) {
            int lastIndexOf = str2.lastIndexOf(36);
            z = false;
            if (lastIndexOf <= 0) {
                break;
            }
            str2 = str2.substring(0, lastIndexOf);
            if (this.matchInnerClassesOf.contains(str2)) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public boolean isMatchingPackage(String str) {
        String str2 = str;
        int lastIndexOf = str2.lastIndexOf(47);
        return this.matchPackages.contains(lastIndexOf == -1 ? LibrariesRepository.MOJANG_MAVEN_REPO : str2.substring(0, lastIndexOf));
    }

    /* access modifiers changed from: private */
    public void printMatch(DirectClassFile directClassFile) {
        DirectClassFile directClassFile2 = directClassFile;
        Iterator it = this.args.printTypes.iterator();
        while (it.hasNext()) {
            switch ((PrintType) it.next()) {
                case CLASS:
                    System.out.println(directClassFile2.getThisClass().getClassType().getClassName().replace(ClassPathElement.SEPARATOR_CHAR, '.'));
                    break;
                case INNERCLASS:
                    boolean add = this.matchInnerClassesOf.add(directClassFile2.getThisClass().getClassType().getClassName());
                    break;
            }
        }
    }

    private void printMatchPackage(String str) {
        String str2 = str;
        Iterator it = this.args.printTypes.iterator();
        while (it.hasNext()) {
            switch ((PrintType) it.next()) {
                case CLASS:
                case INNERCLASS:
                case METHOD:
                    boolean add = this.matchPackages.add(str2);
                    break;
                case PACKAGE:
                    System.out.println(str2.replace(ClassPathElement.SEPARATOR_CHAR, '.'));
                    break;
            }
        }
    }

    /* access modifiers changed from: private */
    public void visitClassAnnotation(DirectClassFile directClassFile, BaseAnnotations baseAnnotations) {
        DirectClassFile directClassFile2 = directClassFile;
        BaseAnnotations baseAnnotations2 = baseAnnotations;
        if (this.args.eTypes.contains(ElementType.TYPE)) {
            for (Annotation type : baseAnnotations2.getAnnotations().getAnnotations()) {
                if (this.args.aclass.equals(type.getType().getClassType().getClassName())) {
                    printMatch(directClassFile2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void visitPackageAnnotation(DirectClassFile directClassFile, BaseAnnotations baseAnnotations) {
        DirectClassFile directClassFile2 = directClassFile;
        BaseAnnotations baseAnnotations2 = baseAnnotations;
        if (this.args.eTypes.contains(ElementType.PACKAGE)) {
            String className = directClassFile2.getThisClass().getClassType().getClassName();
            int lastIndexOf = className.lastIndexOf(47);
            String substring = lastIndexOf == -1 ? LibrariesRepository.MOJANG_MAVEN_REPO : className.substring(0, lastIndexOf);
            for (Annotation type : baseAnnotations2.getAnnotations().getAnnotations()) {
                if (this.args.aclass.equals(type.getType().getClassType().getClassName())) {
                    printMatchPackage(substring);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void process() {
        ClassPathOpener classPathOpener;
        C06551 r11;
        String[] strArr = this.args.files;
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            ClassPathOpener classPathOpener2 = classPathOpener;
            String str = strArr[i];
            C06551 r8 = r11;
            C06551 r9 = new Consumer(this) {
                final /* synthetic */ AnnotationLister this$0;

                {
                    this.this$0 = r5;
                }

                public void onException(Exception exc) {
                    RuntimeException runtimeException;
                    RuntimeException runtimeException2 = runtimeException;
                    RuntimeException runtimeException3 = new RuntimeException(exc);
                    throw runtimeException2;
                }

                public void onProcessArchiveStart(File file) {
                }

                public boolean processFileBytes(String str, long j, byte[] bArr) {
                    DirectClassFile directClassFile;
                    ByteArray byteArray;
                    String str2 = str;
                    long j2 = j;
                    byte[] bArr2 = bArr;
                    if (str2.endsWith(".class")) {
                        DirectClassFile directClassFile2 = directClassFile;
                        ByteArray byteArray2 = byteArray;
                        ByteArray byteArray3 = new ByteArray(bArr2);
                        DirectClassFile directClassFile3 = new DirectClassFile(byteArray2, str2, true);
                        DirectClassFile directClassFile4 = directClassFile2;
                        directClassFile4.setAttributeFactory(StdAttributeFactory.THE_ONE);
                        AttributeList attributes = directClassFile4.getAttributes();
                        String className = directClassFile4.getThisClass().getClassType().getClassName();
                        if (className.endsWith(AnnotationLister.PACKAGE_INFO)) {
                            Attribute findFirst = attributes.findFirst(AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME);
                            while (true) {
                                Attribute attribute = findFirst;
                                if (attribute == null) {
                                    break;
                                }
                                this.this$0.visitPackageAnnotation(directClassFile4, (BaseAnnotations) attribute);
                                findFirst = attributes.findNext(attribute);
                            }
                            Attribute findFirst2 = attributes.findFirst(AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME);
                            while (true) {
                                Attribute attribute2 = findFirst2;
                                if (attribute2 == null) {
                                    break;
                                }
                                this.this$0.visitPackageAnnotation(directClassFile4, (BaseAnnotations) attribute2);
                                findFirst2 = attributes.findNext(attribute2);
                            }
                        } else {
                            if (!this.this$0.isMatchingInnerClass(className)) {
                                if (!this.this$0.isMatchingPackage(className)) {
                                    Attribute findFirst3 = attributes.findFirst(AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME);
                                    while (true) {
                                        Attribute attribute3 = findFirst3;
                                        if (attribute3 == null) {
                                            break;
                                        }
                                        this.this$0.visitClassAnnotation(directClassFile4, (BaseAnnotations) attribute3);
                                        findFirst3 = attributes.findNext(attribute3);
                                    }
                                    Attribute findFirst4 = attributes.findFirst(AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME);
                                    while (true) {
                                        Attribute attribute4 = findFirst4;
                                        if (attribute4 == null) {
                                            break;
                                        }
                                        this.this$0.visitClassAnnotation(directClassFile4, (BaseAnnotations) attribute4);
                                        findFirst4 = attributes.findNext(attribute4);
                                    }
                                }
                            }
                            this.this$0.printMatch(directClassFile4);
                            return true;
                        }
                    }
                    return true;
                }
            };
            ClassPathOpener classPathOpener3 = new ClassPathOpener(str, true, r8);
            boolean process = classPathOpener2.process();
        }
    }
}
