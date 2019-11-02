package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.AccessFlags */
public final class AccessFlags {
    public static final int ACC_ABSTRACT = 1024;
    public static final int ACC_ANNOTATION = 8192;
    public static final int ACC_BRIDGE = 64;
    public static final int ACC_CONSTRUCTOR = 65536;
    public static final int ACC_DECLARED_SYNCHRONIZED = 131072;
    public static final int ACC_ENUM = 16384;
    public static final int ACC_FINAL = 16;
    public static final int ACC_INTERFACE = 512;
    public static final int ACC_NATIVE = 256;
    public static final int ACC_PRIVATE = 2;
    public static final int ACC_PROTECTED = 4;
    public static final int ACC_PUBLIC = 1;
    public static final int ACC_STATIC = 8;
    public static final int ACC_STRICT = 2048;
    public static final int ACC_SUPER = 32;
    public static final int ACC_SYNCHRONIZED = 32;
    public static final int ACC_SYNTHETIC = 4096;
    public static final int ACC_TRANSIENT = 128;
    public static final int ACC_VARARGS = 128;
    public static final int ACC_VOLATILE = 64;
    public static final int CLASS_FLAGS = 30257;
    private static final int CONV_CLASS = 1;
    private static final int CONV_FIELD = 2;
    private static final int CONV_METHOD = 3;
    public static final int FIELD_FLAGS = 20703;
    public static final int INNER_CLASS_FLAGS = 30239;
    public static final int METHOD_FLAGS = 204287;

    private AccessFlags() {
    }

    public static String classString(int i) {
        return humanHelper(i, CLASS_FLAGS, 1);
    }

    public static String fieldString(int i) {
        return humanHelper(i, FIELD_FLAGS, 2);
    }

    private static String humanHelper(int i, int i2, int i3) {
        StringBuffer stringBuffer;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(80);
        StringBuffer stringBuffer4 = stringBuffer2;
        int i7 = i4 & (i5 ^ -1);
        int i8 = i4 & i5;
        if ((i8 & 1) != 0) {
            StringBuffer append = stringBuffer4.append("|public");
        }
        if ((i8 & 2) != 0) {
            StringBuffer append2 = stringBuffer4.append("|private");
        }
        if ((i8 & 4) != 0) {
            StringBuffer append3 = stringBuffer4.append("|protected");
        }
        if ((i8 & 8) != 0) {
            StringBuffer append4 = stringBuffer4.append("|static");
        }
        if ((i8 & 16) != 0) {
            StringBuffer append5 = stringBuffer4.append("|final");
        }
        if ((i8 & 32) != 0) {
            if (i6 == 1) {
                StringBuffer append6 = stringBuffer4.append("|super");
            } else {
                StringBuffer append7 = stringBuffer4.append("|synchronized");
            }
        }
        if ((i8 & 64) != 0) {
            if (i6 == 3) {
                StringBuffer append8 = stringBuffer4.append("|bridge");
            } else {
                StringBuffer append9 = stringBuffer4.append("|volatile");
            }
        }
        if ((i8 & 128) != 0) {
            if (i6 == 3) {
                StringBuffer append10 = stringBuffer4.append("|varargs");
            } else {
                StringBuffer append11 = stringBuffer4.append("|transient");
            }
        }
        if ((i8 & 256) != 0) {
            StringBuffer append12 = stringBuffer4.append("|native");
        }
        if ((i8 & 512) != 0) {
            StringBuffer append13 = stringBuffer4.append("|interface");
        }
        if ((i8 & 1024) != 0) {
            StringBuffer append14 = stringBuffer4.append("|abstract");
        }
        if ((i8 & 2048) != 0) {
            StringBuffer append15 = stringBuffer4.append("|strictfp");
        }
        if ((i8 & 4096) != 0) {
            StringBuffer append16 = stringBuffer4.append("|synthetic");
        }
        if ((i8 & 8192) != 0) {
            StringBuffer append17 = stringBuffer4.append("|annotation");
        }
        if ((i8 & 16384) != 0) {
            StringBuffer append18 = stringBuffer4.append("|enum");
        }
        if ((65536 & i8) != 0) {
            StringBuffer append19 = stringBuffer4.append("|constructor");
        }
        if ((i8 & 131072) != 0) {
            StringBuffer append20 = stringBuffer4.append("|declared_synchronized");
        }
        if (i7 != 0 || stringBuffer4.length() == 0) {
            StringBuffer append21 = stringBuffer4.append('|');
            StringBuffer append22 = stringBuffer4.append(Hex.m51u2(i7));
        }
        return stringBuffer4.substring(1);
    }

    public static String innerClassString(int i) {
        return humanHelper(i, INNER_CLASS_FLAGS, 1);
    }

    public static boolean isAbstract(int i) {
        return (i & 1024) != 0;
    }

    public static boolean isAnnotation(int i) {
        return (i & 8192) != 0;
    }

    public static boolean isConstructor(int i) {
        return (65536 & i) != 0;
    }

    public static boolean isDeclaredSynchronized(int i) {
        return (131072 & i) != 0;
    }

    public static boolean isEnum(int i) {
        return (i & 16384) != 0;
    }

    public static boolean isInterface(int i) {
        return (i & 512) != 0;
    }

    public static boolean isNative(int i) {
        return (i & 256) != 0;
    }

    public static boolean isPrivate(int i) {
        return (i & 2) != 0;
    }

    public static boolean isProtected(int i) {
        return (i & 4) != 0;
    }

    public static boolean isPublic(int i) {
        return (i & 1) != 0;
    }

    public static boolean isStatic(int i) {
        return (i & 8) != 0;
    }

    public static boolean isSynchronized(int i) {
        return (i & 32) != 0;
    }

    public static String methodString(int i) {
        return humanHelper(i, METHOD_FLAGS, 3);
    }
}
