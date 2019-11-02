package net.zhuoweizhang.boardwalk.com.android.p003dx.command.annotool;

import java.lang.annotation.ElementType;
import java.util.EnumSet;
import java.util.Locale;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.annotool.Main */
public class Main {

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.annotool.Main$Arguments */
    static class Arguments {
        String aclass;
        EnumSet<ElementType> eTypes = EnumSet.noneOf(ElementType.class);
        String[] files;
        EnumSet<PrintType> printTypes = EnumSet.noneOf(PrintType.class);

        Arguments() {
        }

        /* access modifiers changed from: 0000 */
        public void parse(String[] strArr) throws InvalidArgumentException {
            InvalidArgumentException invalidArgumentException;
            InvalidArgumentException invalidArgumentException2;
            InvalidArgumentException invalidArgumentException3;
            InvalidArgumentException invalidArgumentException4;
            InvalidArgumentException invalidArgumentException5;
            String[] strArr2 = strArr;
            int i = 0;
            while (true) {
                if (i >= strArr2.length) {
                    break;
                }
                String str = strArr2[i];
                if (!str.startsWith("--annotation=")) {
                    if (!str.startsWith("--element=")) {
                        if (!str.startsWith("--print=")) {
                            this.files = new String[(strArr2.length - i)];
                            System.arraycopy(strArr2, i, this.files, 0, this.files.length);
                            break;
                        }
                        try {
                            String[] split = str.substring(1 + str.indexOf(61)).split(",");
                            int length = split.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                boolean add = this.printTypes.add(PrintType.valueOf(split[i2].toUpperCase(Locale.ROOT)));
                            }
                        } catch (IllegalArgumentException e) {
                            IllegalArgumentException illegalArgumentException = e;
                            InvalidArgumentException invalidArgumentException6 = invalidArgumentException3;
                            InvalidArgumentException invalidArgumentException7 = new InvalidArgumentException("invalid --print");
                            throw invalidArgumentException6;
                        }
                    } else {
                        try {
                            String[] split2 = str.substring(1 + str.indexOf(61)).split(",");
                            int length2 = split2.length;
                            for (int i3 = 0; i3 < length2; i3++) {
                                boolean add2 = this.eTypes.add(ElementType.valueOf(split2[i3].toUpperCase(Locale.ROOT)));
                            }
                        } catch (IllegalArgumentException e2) {
                            IllegalArgumentException illegalArgumentException2 = e2;
                            InvalidArgumentException invalidArgumentException8 = invalidArgumentException4;
                            InvalidArgumentException invalidArgumentException9 = new InvalidArgumentException("invalid --element");
                            throw invalidArgumentException8;
                        }
                    }
                } else {
                    String substring = str.substring(1 + str.indexOf(61));
                    if (this.aclass != null) {
                        InvalidArgumentException invalidArgumentException10 = invalidArgumentException5;
                        InvalidArgumentException invalidArgumentException11 = new InvalidArgumentException("--annotation can only be specified once.");
                        throw invalidArgumentException10;
                    }
                    this.aclass = substring.replace('.', ClassPathElement.SEPARATOR_CHAR);
                }
                i++;
            }
            if (this.aclass == null) {
                InvalidArgumentException invalidArgumentException12 = invalidArgumentException2;
                InvalidArgumentException invalidArgumentException13 = new InvalidArgumentException("--annotation must be specified");
                throw invalidArgumentException12;
            }
            if (this.printTypes.isEmpty()) {
                boolean add3 = this.printTypes.add(PrintType.CLASS);
            }
            if (this.eTypes.isEmpty()) {
                boolean add4 = this.eTypes.add(ElementType.TYPE);
            }
            EnumSet clone = this.eTypes.clone();
            boolean remove = clone.remove(ElementType.TYPE);
            boolean remove2 = clone.remove(ElementType.PACKAGE);
            if (!clone.isEmpty()) {
                InvalidArgumentException invalidArgumentException14 = invalidArgumentException;
                InvalidArgumentException invalidArgumentException15 = new InvalidArgumentException("only --element parameters 'type' and 'package' supported");
                throw invalidArgumentException14;
            }
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.annotool.Main$InvalidArgumentException */
    private static class InvalidArgumentException extends Exception {
        InvalidArgumentException() {
        }

        InvalidArgumentException(String str) {
            super(str);
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.annotool.Main$PrintType */
    enum PrintType {
    }

    private Main() {
    }

    public static void main(String[] strArr) {
        Arguments arguments;
        RuntimeException runtimeException;
        AnnotationLister annotationLister;
        String[] strArr2 = strArr;
        Arguments arguments2 = arguments;
        Arguments arguments3 = new Arguments();
        Arguments arguments4 = arguments2;
        try {
            arguments4.parse(strArr2);
            AnnotationLister annotationLister2 = annotationLister;
            AnnotationLister annotationLister3 = new AnnotationLister(arguments4);
            annotationLister2.process();
        } catch (InvalidArgumentException e) {
            System.err.println(e.getMessage());
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("usage");
            throw runtimeException2;
        }
    }
}
