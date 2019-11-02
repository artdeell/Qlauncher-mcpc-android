package org.lwjgl.openal;

public final class EFXUtil {
    private static final int EFFECT = 1111;
    private static final int FILTER = 2222;

    private EFXUtil() {
    }

    public static boolean isEffectSupported(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 32768:
                return testSupportGeneric(EFFECT, i2);
            default:
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unknown or invalid effect type: ").append(i2).toString());
                throw illegalArgumentException2;
        }
    }

    public static boolean isEfxSupported() {
        OpenALException openALException;
        if (C0758AL.isCreated()) {
            return ALC10.alcIsExtensionPresent(C0758AL.getDevice(), EFX10.ALC_EXT_EFX_NAME);
        }
        OpenALException openALException2 = openALException;
        OpenALException openALException3 = new OpenALException("OpenAL has not been created.");
        throw openALException2;
    }

    public static boolean isFilterSupported(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
                return testSupportGeneric(FILTER, i2);
            default:
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unknown or invalid filter type: ").append(i2).toString());
                throw illegalArgumentException2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f1, code lost:
        r7 = org.lwjgl.openal.AL10.alGetError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x010d, code lost:
        r9 = org.lwjgl.openal.AL10.alGetError();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean testSupportGeneric(int r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            r13 = r0
            switch(r13) {
                case 1111: goto L_0x002f;
                case 2222: goto L_0x002f;
                default: goto L_0x0008;
            }
        L_0x0008:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            r17 = r13
            r13 = r17
            r14 = r17
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r17 = r15
            r15 = r17
            r16 = r17
            r16.<init>()
            java.lang.String r16 = "Invalid objectType: "
            java.lang.StringBuilder r15 = r15.append(r16)
            r16 = r0
            java.lang.StringBuilder r15 = r15.append(r16)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r13
        L_0x002f:
            boolean r13 = isEfxSupported()
            r2 = r13
            r13 = 0
            r3 = r13
            r13 = r2
            if (r13 == 0) goto L_0x00e9
            int r13 = org.lwjgl.openal.AL10.alGetError()
            r13 = 0
            r5 = r13
            r13 = r0
            switch(r13) {
                case 1111: goto L_0x00ec;
                case 2222: goto L_0x00f7;
                default: goto L_0x0043;
            }
        L_0x0043:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException     // Catch:{ OpenALException -> 0x006a }
            r17 = r13
            r13 = r17
            r14 = r17
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ OpenALException -> 0x006a }
            r17 = r15
            r15 = r17
            r16 = r17
            r16.<init>()     // Catch:{ OpenALException -> 0x006a }
            java.lang.String r16 = "Invalid objectType: "
            java.lang.StringBuilder r15 = r15.append(r16)     // Catch:{ OpenALException -> 0x006a }
            r16 = r0
            java.lang.StringBuilder r15 = r15.append(r16)     // Catch:{ OpenALException -> 0x006a }
            java.lang.String r15 = r15.toString()     // Catch:{ OpenALException -> 0x006a }
            r14.<init>(r15)     // Catch:{ OpenALException -> 0x006a }
            throw r13     // Catch:{ OpenALException -> 0x006a }
        L_0x006a:
            r13 = move-exception
            r12 = r13
            r13 = r12
            java.lang.String r13 = r13.getMessage()
            java.lang.String r14 = "AL_OUT_OF_MEMORY"
            boolean r13 = r13.contains(r14)
            if (r13 == 0) goto L_0x00ff
            r13 = 40965(0xa005, float:5.7404E-41)
            r7 = r13
        L_0x007d:
            r13 = r7
            if (r13 != 0) goto L_0x012a
            int r13 = org.lwjgl.openal.AL10.alGetError()
            r13 = r0
            switch(r13) {
                case 1111: goto L_0x0105;
                case 2222: goto L_0x0113;
                default: goto L_0x0088;
            }
        L_0x0088:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException     // Catch:{ OpenALException -> 0x00af }
            r17 = r13
            r13 = r17
            r14 = r17
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ OpenALException -> 0x00af }
            r17 = r15
            r15 = r17
            r16 = r17
            r16.<init>()     // Catch:{ OpenALException -> 0x00af }
            java.lang.String r16 = "Invalid objectType: "
            java.lang.StringBuilder r15 = r15.append(r16)     // Catch:{ OpenALException -> 0x00af }
            r16 = r0
            java.lang.StringBuilder r15 = r15.append(r16)     // Catch:{ OpenALException -> 0x00af }
            java.lang.String r15 = r15.toString()     // Catch:{ OpenALException -> 0x00af }
            r14.<init>(r15)     // Catch:{ OpenALException -> 0x00af }
            throw r13     // Catch:{ OpenALException -> 0x00af }
        L_0x00af:
            r13 = move-exception
            r11 = r13
            r13 = 40963(0xa003, float:5.7401E-41)
            r9 = r13
        L_0x00b5:
            r13 = 0
            r3 = r13
            r13 = r9
            if (r13 != 0) goto L_0x00bc
            r13 = 1
            r3 = r13
        L_0x00bc:
            r13 = r0
            switch(r13) {
                case 1111: goto L_0x011c;
                case 2222: goto L_0x0123;
                default: goto L_0x00c0;
            }
        L_0x00c0:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException     // Catch:{ OpenALException -> 0x00e7 }
            r17 = r13
            r13 = r17
            r14 = r17
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ OpenALException -> 0x00e7 }
            r17 = r15
            r15 = r17
            r16 = r17
            r16.<init>()     // Catch:{ OpenALException -> 0x00e7 }
            java.lang.String r16 = "Invalid objectType: "
            java.lang.StringBuilder r15 = r15.append(r16)     // Catch:{ OpenALException -> 0x00e7 }
            r16 = r0
            java.lang.StringBuilder r15 = r15.append(r16)     // Catch:{ OpenALException -> 0x00e7 }
            java.lang.String r15 = r15.toString()     // Catch:{ OpenALException -> 0x00e7 }
            r14.<init>(r15)     // Catch:{ OpenALException -> 0x00e7 }
            throw r13     // Catch:{ OpenALException -> 0x00e7 }
        L_0x00e7:
            r13 = move-exception
            r10 = r13
        L_0x00e9:
            r13 = r3
            r0 = r13
        L_0x00eb:
            return r0
        L_0x00ec:
            int r13 = org.lwjgl.openal.EFX10.alGenEffects()     // Catch:{ OpenALException -> 0x006a }
            r5 = r13
        L_0x00f1:
            int r13 = org.lwjgl.openal.AL10.alGetError()     // Catch:{ OpenALException -> 0x006a }
            r7 = r13
            goto L_0x007d
        L_0x00f7:
            int r13 = org.lwjgl.openal.EFX10.alGenFilters()     // Catch:{ OpenALException -> 0x006a }
            r6 = r13
            r13 = r6
            r5 = r13
            goto L_0x00f1
        L_0x00ff:
            r13 = 40964(0xa004, float:5.7403E-41)
            r7 = r13
            goto L_0x007d
        L_0x0105:
            r13 = r5
            r14 = 32769(0x8001, float:4.5919E-41)
            r15 = r1
            org.lwjgl.openal.EFX10.alEffecti(r13, r14, r15)     // Catch:{ OpenALException -> 0x00af }
        L_0x010d:
            int r13 = org.lwjgl.openal.AL10.alGetError()     // Catch:{ OpenALException -> 0x00af }
            r9 = r13
            goto L_0x00b5
        L_0x0113:
            r13 = r5
            r14 = 32769(0x8001, float:4.5919E-41)
            r15 = r1
            org.lwjgl.openal.EFX10.alFilteri(r13, r14, r15)     // Catch:{ OpenALException -> 0x00af }
            goto L_0x010d
        L_0x011c:
            r13 = r5
            org.lwjgl.openal.EFX10.alDeleteEffects(r13)     // Catch:{ OpenALException -> 0x00e7 }
            r13 = r3
            r0 = r13
            goto L_0x00eb
        L_0x0123:
            r13 = r5
            org.lwjgl.openal.EFX10.alDeleteFilters(r13)     // Catch:{ OpenALException -> 0x00e7 }
            r13 = r3
            r0 = r13
            goto L_0x00eb
        L_0x012a:
            r13 = 0
            r3 = r13
            r13 = r7
            r14 = 40965(0xa005, float:5.7404E-41)
            if (r13 != r14) goto L_0x00e9
            org.lwjgl.openal.OpenALException r13 = new org.lwjgl.openal.OpenALException
            r17 = r13
            r13 = r17
            r14 = r17
            r15 = r7
            r14.<init>(r15)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.openal.EFXUtil.testSupportGeneric(int, int):boolean");
    }
}
