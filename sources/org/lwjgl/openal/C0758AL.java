package org.lwjgl.openal;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;

/* renamed from: org.lwjgl.openal.AL */
public final class C0758AL {
    static ALCcontext context;
    private static boolean created;
    static ALCdevice device;

    static {
        Sys.initialize();
    }

    private C0758AL() {
    }

    public static void create() throws LWJGLException {
        create(null, 44100, 60, false);
    }

    public static void create(String str, int i, int i2, boolean z) throws LWJGLException {
        create(str, i, i2, z, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0168 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void create(java.lang.String r18, int r19, int r20, boolean r21, boolean r22) throws org.lwjgl.LWJGLException {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            boolean r12 = created
            if (r12 == 0) goto L_0x001c
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r17 = r12
            r12 = r17
            r13 = r17
            java.lang.String r14 = "Only one OpenAL context may be instantiated at any one time."
            r13.<init>(r14)
            throw r12
        L_0x001c:
            int r12 = org.lwjgl.LWJGLUtil.getPlatform()
            switch(r12) {
                case 1: goto L_0x00e4;
                case 2: goto L_0x010e;
                case 3: goto L_0x004c;
                case 1337: goto L_0x0122;
                default: goto L_0x0023;
            }
        L_0x0023:
            org.lwjgl.LWJGLException r12 = new org.lwjgl.LWJGLException
            r17 = r12
            r12 = r17
            r13 = r17
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r17 = r14
            r14 = r17
            r15 = r17
            r15.<init>()
            java.lang.String r15 = "Unknown platform: "
            java.lang.StringBuilder r14 = r14.append(r15)
            int r15 = org.lwjgl.LWJGLUtil.getPlatform()
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r12
        L_0x004c:
            java.lang.String r12 = "OpenAL32"
            r5 = r12
            r12 = 2
            java.lang.String[] r12 = new java.lang.String[r12]
            r17 = r12
            r12 = r17
            r13 = r17
            r14 = 0
            java.lang.String r15 = "OpenAL64.dll"
            r13[r14] = r15
            r17 = r12
            r12 = r17
            r13 = r17
            r14 = 1
            java.lang.String r15 = "OpenAL32.dll"
            r13[r14] = r15
            r6 = r12
        L_0x0069:
            r12 = r5
            r13 = r6
            java.lang.Class<org.lwjgl.openal.AL> r14 = org.lwjgl.openal.C0758AL.class
            java.lang.ClassLoader r14 = r14.getClassLoader()
            java.lang.String[] r12 = org.lwjgl.LWJGLUtil.getLibraryPaths(r12, r13, r14)
            r7 = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r17 = r12
            r12 = r17
            r13 = r17
            r13.<init>()
            java.lang.String r13 = "Found "
            java.lang.StringBuilder r12 = r12.append(r13)
            r13 = r7
            int r13 = r13.length
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r13 = " OpenAL paths"
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r12 = r12.toString()
            org.lwjgl.LWJGLUtil.log(r12)
            r12 = r7
            int r12 = r12.length
            r8 = r12
            r12 = 0
            r9 = r12
        L_0x009f:
            r12 = r9
            r13 = r8
            if (r12 >= r13) goto L_0x00b8
            r12 = r7
            r13 = r9
            r12 = r12[r13]
            r10 = r12
            r12 = r10
            nCreate(r12)     // Catch:{ LWJGLException -> 0x0136 }
            r12 = 1
            created = r12     // Catch:{ LWJGLException -> 0x0136 }
            r12 = r0
            r13 = r1
            r14 = r2
            r15 = r3
            r16 = r4
            init(r12, r13, r14, r15, r16)     // Catch:{ LWJGLException -> 0x0136 }
        L_0x00b8:
            boolean r12 = created
            if (r12 != 0) goto L_0x00d2
            int r12 = org.lwjgl.LWJGLUtil.getPlatform()
            r13 = 2
            if (r12 != r13) goto L_0x00d2
            nCreateDefault()
            r12 = 1
            created = r12
            r12 = r0
            r13 = r1
            r14 = r2
            r15 = r3
            r16 = r4
            init(r12, r13, r14, r15, r16)
        L_0x00d2:
            boolean r12 = created
            if (r12 != 0) goto L_0x0168
            org.lwjgl.LWJGLException r12 = new org.lwjgl.LWJGLException
            r17 = r12
            r12 = r17
            r13 = r17
            java.lang.String r14 = "Could not locate OpenAL library."
            r13.<init>(r14)
            throw r12
        L_0x00e4:
            java.lang.String r12 = "openal"
            r5 = r12
            r12 = 3
            java.lang.String[] r12 = new java.lang.String[r12]
            r17 = r12
            r12 = r17
            r13 = r17
            r14 = 0
            java.lang.String r15 = "libopenal64.so"
            r13[r14] = r15
            r17 = r12
            r12 = r17
            r13 = r17
            r14 = 1
            java.lang.String r15 = "libopenal.so"
            r13[r14] = r15
            r17 = r12
            r12 = r17
            r13 = r17
            r14 = 2
            java.lang.String r15 = "libopenal.so.0"
            r13[r14] = r15
            r6 = r12
            goto L_0x0069
        L_0x010e:
            java.lang.String r12 = "openal"
            r5 = r12
            r12 = 1
            java.lang.String[] r12 = new java.lang.String[r12]
            r17 = r12
            r12 = r17
            r13 = r17
            r14 = 0
            java.lang.String r15 = "openal.dylib"
            r13[r14] = r15
            r6 = r12
            goto L_0x0069
        L_0x0122:
            java.lang.String r12 = "openal"
            r5 = r12
            r12 = 1
            java.lang.String[] r12 = new java.lang.String[r12]
            r17 = r12
            r12 = r17
            r13 = r17
            r14 = 0
            java.lang.String r15 = "libopenal.so"
            r13[r14] = r15
            r6 = r12
            goto L_0x0069
        L_0x0136:
            r12 = move-exception
            r11 = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r17 = r12
            r12 = r17
            r13 = r17
            r13.<init>()
            java.lang.String r13 = "Failed to load "
            java.lang.StringBuilder r12 = r12.append(r13)
            r13 = r10
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r13 = ": "
            java.lang.StringBuilder r12 = r12.append(r13)
            r13 = r11
            java.lang.String r13 = r13.getMessage()
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r12 = r12.toString()
            org.lwjgl.LWJGLUtil.log(r12)
            int r9 = r9 + 1
            goto L_0x009f
        L_0x0168:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.openal.C0758AL.create(java.lang.String, int, int, boolean, boolean):void");
    }

    public static void destroy() {
        if (context != null) {
            int alcMakeContextCurrent = ALC10.alcMakeContextCurrent(null);
            ALC10.alcDestroyContext(context);
            context = null;
        }
        if (device != null) {
            boolean alcCloseDevice = ALC10.alcCloseDevice(device);
            device = null;
        }
        resetNativeStubs(AL10.class);
        resetNativeStubs(AL11.class);
        resetNativeStubs(ALC10.class);
        resetNativeStubs(ALC11.class);
        resetNativeStubs(EFX10.class);
        if (created) {
            nDestroy();
        }
        created = false;
    }

    public static ALCcontext getContext() {
        return context;
    }

    public static ALCdevice getDevice() {
        return device;
    }

    private static void init(String str, int i, int i2, boolean z, boolean z2) throws LWJGLException {
        LWJGLException lWJGLException;
        String str2 = str;
        int i3 = i;
        int i4 = i2;
        boolean z3 = z;
        boolean z4 = z2;
        try {
            AL10.initNativeStubs();
            ALC10.initNativeStubs();
            if (z4) {
                device = ALC10.alcOpenDevice(str2);
                if (device == null) {
                    LWJGLException lWJGLException2 = lWJGLException;
                    LWJGLException lWJGLException3 = new LWJGLException("Could not open ALC device");
                    throw lWJGLException2;
                }
                if (i3 == -1) {
                    context = ALC10.alcCreateContext(device, null);
                } else {
                    context = ALC10.alcCreateContext(device, ALCcontext.createAttributeList(i3, i4, z3 ? 1 : 0));
                }
                int alcMakeContextCurrent = ALC10.alcMakeContextCurrent(context);
            }
            boolean initialize = ALC11.initialize();
            if (ALC10.alcIsExtensionPresent(device, EFX10.ALC_EXT_EFX_NAME)) {
                EFX10.initNativeStubs();
            }
        } catch (LWJGLException e) {
            LWJGLException lWJGLException4 = e;
            destroy();
            throw lWJGLException4;
        }
    }

    public static boolean isCreated() {
        return created;
    }

    private static native void nCreate(String str) throws LWJGLException;

    private static native void nCreateDefault() throws LWJGLException;

    private static native void nDestroy();

    private static native void resetNativeStubs(Class cls);
}
