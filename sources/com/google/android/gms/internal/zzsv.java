package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public final class zzsv {
    private static void zza(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException, InvocationTargetException {
        StringBuilder sb;
        StringBuilder sb2;
        String str2 = str;
        Object obj2 = obj;
        StringBuffer stringBuffer3 = stringBuffer;
        StringBuffer stringBuffer4 = stringBuffer2;
        if (obj2 != null) {
            if (obj2 instanceof zzsu) {
                int length = stringBuffer3.length();
                if (str2 != null) {
                    StringBuffer append = stringBuffer4.append(stringBuffer3).append(zzgP(str2)).append(" <\n");
                    StringBuffer append2 = stringBuffer3.append("  ");
                }
                Class cls = obj2.getClass();
                Field[] fields = cls.getFields();
                int length2 = fields.length;
                for (int i = 0; i < length2; i++) {
                    Field field = fields[i];
                    int modifiers = field.getModifiers();
                    String name = field.getName();
                    if (!"cachedSize".equals(name) && (modifiers & 1) == 1 && (modifiers & 8) != 8 && !name.startsWith("_") && !name.endsWith("_")) {
                        Class type = field.getType();
                        Object obj3 = field.get(obj2);
                        if (type.isArray()) {
                            if (type.getComponentType() == Byte.TYPE) {
                                zza(name, obj3, stringBuffer3, stringBuffer4);
                            } else {
                                int length3 = obj3 == null ? 0 : Array.getLength(obj3);
                                for (int i2 = 0; i2 < length3; i2++) {
                                    zza(name, Array.get(obj3, i2), stringBuffer3, stringBuffer4);
                                }
                            }
                        } else {
                            zza(name, obj3, stringBuffer3, stringBuffer4);
                        }
                    }
                }
                Method[] methods = cls.getMethods();
                int length4 = methods.length;
                for (int i3 = 0; i3 < length4; i3++) {
                    String name2 = methods[i3].getName();
                    if (name2.startsWith("set")) {
                        String substring = name2.substring(3);
                        Class cls2 = cls;
                        try {
                            StringBuilder sb3 = sb;
                            StringBuilder sb4 = new StringBuilder();
                            if (((Boolean) cls2.getMethod(sb3.append("has").append(substring).toString(), new Class[0]).invoke(obj2, new Object[0])).booleanValue()) {
                                Class cls3 = cls;
                                try {
                                    StringBuilder sb5 = sb2;
                                    StringBuilder sb6 = new StringBuilder();
                                    zza(substring, cls3.getMethod(sb5.append("get").append(substring).toString(), new Class[0]).invoke(obj2, new Object[0]), stringBuffer3, stringBuffer4);
                                } catch (NoSuchMethodException e) {
                                    NoSuchMethodException noSuchMethodException = e;
                                }
                            }
                        } catch (NoSuchMethodException e2) {
                            NoSuchMethodException noSuchMethodException2 = e2;
                        }
                    }
                }
                if (str2 != null) {
                    stringBuffer3.setLength(length);
                    StringBuffer append3 = stringBuffer4.append(stringBuffer3).append(">\n");
                    return;
                }
                return;
            }
            StringBuffer append4 = stringBuffer4.append(stringBuffer3).append(zzgP(str2)).append(": ");
            if (obj2 instanceof String) {
                StringBuffer append5 = stringBuffer4.append("\"").append(zzbZ((String) obj2)).append("\"");
            } else if (obj2 instanceof byte[]) {
                zza((byte[]) obj2, stringBuffer4);
            } else {
                StringBuffer append6 = stringBuffer4.append(obj2);
            }
            StringBuffer append7 = stringBuffer4.append("\n");
        }
    }

    private static void zza(byte[] bArr, StringBuffer stringBuffer) {
        byte[] bArr2 = bArr;
        StringBuffer stringBuffer2 = stringBuffer;
        if (bArr2 == null) {
            StringBuffer append = stringBuffer2.append("\"\"");
            return;
        }
        StringBuffer append2 = stringBuffer2.append('\"');
        for (int i = 0; i < bArr2.length; i++) {
            byte b = 255 & bArr2[i];
            if (b == 92 || b == 34) {
                StringBuffer append3 = stringBuffer2.append('\\').append((char) b);
            } else if (b < 32 || b >= Byte.MAX_VALUE) {
                StringBuffer append4 = stringBuffer2.append(String.format("\\%03o", new Object[]{Integer.valueOf(b)}));
            } else {
                StringBuffer append5 = stringBuffer2.append((char) b);
            }
        }
        StringBuffer append6 = stringBuffer2.append('\"');
    }

    private static String zzbZ(String str) {
        StringBuilder sb;
        String str2 = str;
        if (!str2.startsWith("http") && str2.length() > 200) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            str2 = sb2.append(str2.substring(0, 200)).append("[...]").toString();
        }
        return zzcU(str2);
    }

    private static String zzcU(String str) {
        StringBuilder sb;
        String str2 = str;
        int length = str2.length();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(length);
        StringBuilder sb4 = sb2;
        for (int i = 0; i < length; i++) {
            char charAt = str2.charAt(i);
            if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                StringBuilder append = sb4.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
            } else {
                StringBuilder append2 = sb4.append(charAt);
            }
        }
        return sb4.toString();
    }

    public static <T extends zzsu> String zzf(T t) {
        StringBuffer stringBuffer;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuffer stringBuffer2;
        T t2 = t;
        if (t2 == null) {
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        StringBuffer stringBuffer3 = stringBuffer;
        StringBuffer stringBuffer4 = new StringBuffer();
        StringBuffer stringBuffer5 = stringBuffer3;
        T t3 = t2;
        try {
            StringBuffer stringBuffer6 = stringBuffer2;
            StringBuffer stringBuffer7 = new StringBuffer();
            zza(null, t3, stringBuffer6, stringBuffer5);
            return stringBuffer5.toString();
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            return sb3.append("Error printing proto: ").append(illegalAccessException.getMessage()).toString();
        } catch (InvocationTargetException e2) {
            InvocationTargetException invocationTargetException = e2;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            return sb5.append("Error printing proto: ").append(invocationTargetException.getMessage()).toString();
        }
    }

    private static String zzgP(String str) {
        StringBuffer stringBuffer;
        String str2 = str;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = stringBuffer2;
        for (int i = 0; i < str2.length(); i++) {
            char charAt = str2.charAt(i);
            if (i == 0) {
                StringBuffer append = stringBuffer4.append(Character.toLowerCase(charAt));
            } else if (Character.isUpperCase(charAt)) {
                StringBuffer append2 = stringBuffer4.append('_').append(Character.toLowerCase(charAt));
            } else {
                StringBuffer append3 = stringBuffer4.append(charAt);
            }
        }
        return stringBuffer4.toString();
    }
}
