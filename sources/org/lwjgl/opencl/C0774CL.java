package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.MemoryUtil;
import org.lwjgl.Sys;

/* renamed from: org.lwjgl.opencl.CL */
public final class C0774CL {
    private static boolean created;

    static {
        Sys.initialize();
    }

    private C0774CL() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void create() throws org.lwjgl.LWJGLException {
        /*
            boolean r7 = created
            if (r7 == 0) goto L_0x0005
        L_0x0004:
            return
        L_0x0005:
            int r7 = org.lwjgl.LWJGLUtil.getPlatform()
            switch(r7) {
                case 1: goto L_0x00a1;
                case 2: goto L_0x00b9;
                case 3: goto L_0x002f;
                default: goto L_0x000c;
            }
        L_0x000c:
            org.lwjgl.LWJGLException r7 = new org.lwjgl.LWJGLException
            r11 = r7
            r7 = r11
            r8 = r11
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r11 = r9
            r9 = r11
            r10 = r11
            r10.<init>()
            java.lang.String r10 = "Unknown platform: "
            java.lang.StringBuilder r9 = r9.append(r10)
            int r10 = org.lwjgl.LWJGLUtil.getPlatform()
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r7
        L_0x002f:
            java.lang.String r7 = "OpenCL"
            r0 = r7
            r7 = 1
            java.lang.String[] r7 = new java.lang.String[r7]
            r11 = r7
            r7 = r11
            r8 = r11
            r9 = 0
            java.lang.String r10 = "OpenCL.dll"
            r8[r9] = r10
            r1 = r7
        L_0x003e:
            r7 = r0
            r8 = r1
            java.lang.Class<org.lwjgl.opencl.CL> r9 = org.lwjgl.opencl.C0774CL.class
            java.lang.ClassLoader r9 = r9.getClassLoader()
            java.lang.String[] r7 = org.lwjgl.LWJGLUtil.getLibraryPaths(r7, r8, r9)
            r2 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r11 = r7
            r7 = r11
            r8 = r11
            r8.<init>()
            java.lang.String r8 = "Found "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r2
            int r8 = r8.length
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = " OpenCL paths"
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            org.lwjgl.LWJGLUtil.log(r7)
            r7 = r2
            int r7 = r7.length
            r3 = r7
            r7 = 0
            r4 = r7
        L_0x0071:
            r7 = r4
            r8 = r3
            if (r7 >= r8) goto L_0x0081
            r7 = r2
            r8 = r4
            r7 = r7[r8]
            r5 = r7
            r7 = r5
            nCreate(r7)     // Catch:{ LWJGLException -> 0x00ca }
            r7 = 1
            created = r7     // Catch:{ LWJGLException -> 0x00ca }
        L_0x0081:
            boolean r7 = created
            if (r7 != 0) goto L_0x0092
            int r7 = org.lwjgl.LWJGLUtil.getPlatform()
            r8 = 2
            if (r7 != r8) goto L_0x0092
            nCreateDefault()
            r7 = 1
            created = r7
        L_0x0092:
            boolean r7 = created
            if (r7 != 0) goto L_0x00f9
            org.lwjgl.LWJGLException r7 = new org.lwjgl.LWJGLException
            r11 = r7
            r7 = r11
            r8 = r11
            java.lang.String r9 = "Could not locate OpenCL library."
            r8.<init>(r9)
            throw r7
        L_0x00a1:
            java.lang.String r7 = "OpenCL"
            r0 = r7
            r7 = 2
            java.lang.String[] r7 = new java.lang.String[r7]
            r11 = r7
            r7 = r11
            r8 = r11
            r9 = 0
            java.lang.String r10 = "libOpenCL64.so"
            r8[r9] = r10
            r11 = r7
            r7 = r11
            r8 = r11
            r9 = 1
            java.lang.String r10 = "libOpenCL.so"
            r8[r9] = r10
            r1 = r7
            goto L_0x003e
        L_0x00b9:
            java.lang.String r7 = "OpenCL"
            r0 = r7
            r7 = 1
            java.lang.String[] r7 = new java.lang.String[r7]
            r11 = r7
            r7 = r11
            r8 = r11
            r9 = 0
            java.lang.String r10 = "OpenCL.dylib"
            r8[r9] = r10
            r1 = r7
            goto L_0x003e
        L_0x00ca:
            r7 = move-exception
            r6 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r11 = r7
            r7 = r11
            r8 = r11
            r8.<init>()
            java.lang.String r8 = "Failed to load "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r5
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = ": "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r6
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            org.lwjgl.LWJGLUtil.log(r7)
            int r4 = r4 + 1
            goto L_0x0071
        L_0x00f9:
            boolean r7 = org.lwjgl.opencl.CLCapabilities.OpenCL10
            if (r7 != 0) goto L_0x0004
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            r11 = r7
            r7 = r11
            r8 = r11
            java.lang.String r9 = "OpenCL 1.0 not supported."
            r8.<init>(r9)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opencl.C0774CL.create():void");
    }

    public static void destroy() {
    }

    static long getFunctionAddress(String str) {
        return ngetFunctionAddress(MemoryUtil.getAddress(MemoryUtil.encodeASCII(str)));
    }

    static long getFunctionAddress(String[] strArr) {
        String[] strArr2 = strArr;
        int length = strArr2.length;
        for (int i = 0; i < length; i++) {
            long functionAddress = getFunctionAddress(strArr2[i]);
            if (functionAddress != 0) {
                return functionAddress;
            }
        }
        return 0;
    }

    static native ByteBuffer getHostBuffer(long j, int i);

    public static boolean isCreated() {
        return created;
    }

    private static native void nCreate(String str) throws LWJGLException;

    private static native void nCreateDefault() throws LWJGLException;

    private static native void nDestroy();

    private static native long ngetFunctionAddress(long j);

    private static native void resetNativeStubs(Class cls);
}
