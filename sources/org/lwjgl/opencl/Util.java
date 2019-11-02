package org.lwjgl.opencl;

import java.lang.reflect.Field;
import java.util.Map;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.LWJGLUtil.TokenFilter;

public final class Util {
    private static final Map<Integer, String> CL_ERROR_TOKENS;

    static {
        C07771 r6;
        C07771 r0 = r6;
        C07771 r1 = new TokenFilter() {
            public boolean accept(Field field, int i) {
                Field field2 = field;
                return i < 0;
            }
        };
        Class[] clsArr = new Class[6];
        Class[] clsArr2 = clsArr;
        clsArr[0] = CL10.class;
        Class[] clsArr3 = clsArr2;
        Class[] clsArr4 = clsArr3;
        clsArr3[1] = CL11.class;
        Class[] clsArr5 = clsArr4;
        Class[] clsArr6 = clsArr5;
        clsArr5[2] = KHRGLSharing.class;
        Class[] clsArr7 = clsArr6;
        Class[] clsArr8 = clsArr7;
        clsArr7[3] = KHRICD.class;
        Class[] clsArr9 = clsArr8;
        Class[] clsArr10 = clsArr9;
        clsArr9[4] = APPLEGLSharing.class;
        Class[] clsArr11 = clsArr10;
        Class[] clsArr12 = clsArr11;
        clsArr11[5] = EXTDeviceFission.class;
        CL_ERROR_TOKENS = LWJGLUtil.getClassTokens((TokenFilter) r0, null, clsArr12);
    }

    private Util() {
    }

    public static void checkCLError(int i) {
        int i2 = i;
        if (i2 != 0) {
            throwCLError(i2);
        }
    }

    private static void throwCLError(int i) {
        OpenCLException openCLException;
        StringBuilder sb;
        int i2 = i;
        String str = (String) CL_ERROR_TOKENS.get(Integer.valueOf(i2));
        if (str == null) {
            str = "UNKNOWN";
        }
        OpenCLException openCLException2 = openCLException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        OpenCLException openCLException3 = new OpenCLException(sb2.append("Error Code: ").append(str).append(" (").append(LWJGLUtil.toHexString(i2)).append(")").toString());
        throw openCLException2;
    }
}
