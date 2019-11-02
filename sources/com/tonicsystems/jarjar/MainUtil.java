package com.tonicsystems.jarjar;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

class MainUtil {
    MainUtil() {
    }

    private static Object[] bindParameters(Method method, String[] strArr) {
        ArrayList arrayList;
        Method method2 = method;
        String[] strArr2 = strArr;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        Class[] parameterTypes = method2.getParameterTypes();
        int length = parameterTypes.length;
        for (int i = 0; i < length; i++) {
            Class cls = parameterTypes[i];
            int max = Math.max(0, strArr2.length - i);
            if (cls.equals(String[].class)) {
                String[] strArr3 = new String[max];
                System.arraycopy(strArr2, 1, strArr3, 0, max);
                boolean add = arrayList4.add(strArr3);
            } else if (max > 0) {
                boolean add2 = arrayList4.add(convertParameter(strArr2[i], parameterTypes[i]));
            } else {
                boolean add3 = arrayList4.add(null);
            }
        }
        return arrayList4.toArray();
    }

    private static Object convertParameter(String str, Class cls) {
        UnsupportedOperationException unsupportedOperationException;
        StringBuilder sb;
        File file;
        String str2 = str;
        Class cls2 = cls;
        if (cls2.equals(String.class)) {
            return str2;
        }
        if (cls2.equals(Integer.class)) {
            return Integer.valueOf(str2, 10);
        }
        if (cls2.equals(File.class)) {
            File file2 = file;
            File file3 = new File(str2);
            return file2;
        }
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(sb2.append("Unknown type ").append(cls2).toString());
        throw unsupportedOperationException2;
    }

    public static void runMain(Object obj, String[] strArr, String str) throws Exception {
        StringBuilder sb;
        Object obj2 = obj;
        String[] strArr2 = strArr;
        String str2 = str;
        if (strArr2.length > 0) {
            String str3 = strArr2[0];
            Method[] methods = obj2.getClass().getMethods();
            int i = 0;
            while (i < methods.length) {
                Method method = methods[i];
                if (method.getName().equals(str3)) {
                    String[] strArr3 = new String[(-1 + strArr2.length)];
                    System.arraycopy(strArr2, 1, strArr3, 0, strArr3.length);
                    try {
                        Object invoke = method.invoke(obj2, bindParameters(method, strArr3));
                        return;
                    } catch (InvocationTargetException e) {
                        InvocationTargetException invocationTargetException = e;
                        Throwable cause = invocationTargetException.getCause();
                        if (cause instanceof IllegalArgumentException) {
                            PrintStream printStream = System.err;
                            StringBuilder sb2 = sb;
                            StringBuilder sb3 = new StringBuilder();
                            printStream.println(sb2.append("Syntax error: ").append(cause.getMessage()).toString());
                            return;
                        } else if (cause instanceof Exception) {
                            throw ((Exception) cause);
                        } else {
                            throw invocationTargetException;
                        }
                    }
                } else {
                    i++;
                }
            }
        }
        if (str2 != null) {
            Object obj3 = obj2;
            String[] strArr4 = new String[1];
            String[] strArr5 = strArr4;
            strArr4[0] = str2;
            runMain(obj3, strArr5, null);
        }
    }
}
