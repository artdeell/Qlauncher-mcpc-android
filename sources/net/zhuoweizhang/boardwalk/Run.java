package net.zhuoweizhang.boardwalk;

import dalvik.system.VMRuntime;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Run {
    public Run() {
    }

    public static void main(String[] strArr) throws Exception {
        String[] strArr2 = strArr;
        VMRuntime.getRuntime().startJitCompilation();
        String[] strArr3 = (String[]) Arrays.copyOfRange(strArr2, 1, strArr2.length);
        Class[] clsArr = new Class[1];
        Class[] clsArr2 = clsArr;
        clsArr[0] = String[].class;
        Method method = Class.forName(strArr2[0]).getMethod("main", clsArr2);
        Object[] objArr = new Object[1];
        Object[] objArr2 = objArr;
        objArr[0] = strArr3;
        Object invoke = method.invoke(null, objArr2);
    }
}
