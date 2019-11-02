package org.lwjgl.opencl;

public class CLPlatformCapabilities {
    final boolean CL_APPLE_ContextLoggingFunctions;
    public final boolean CL_APPLE_SetMemObjectDestructor;
    public final boolean CL_APPLE_gl_sharing;
    public final boolean CL_KHR_d3d10_sharing;
    public final boolean CL_KHR_gl_event;
    public final boolean CL_KHR_gl_sharing;
    public final boolean CL_KHR_icd;
    public final boolean OpenCL11;
    public final boolean OpenCL12;
    public final int majorVersion;
    public final int minorVersion;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00bb, code lost:
        if (1 <= r2.minorVersion) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00f9, code lost:
        if (2 <= r2.minorVersion) goto L_0x00fb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00db A[Catch:{ RuntimeException -> 0x01d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x019b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CLPlatformCapabilities(org.lwjgl.opencl.CLPlatform r23) {
        /*
            r22 = this;
            r2 = r22
            r3 = r23
            r17 = 1
            r4 = r17
            r17 = r2
            r17.<init>()
            r17 = r3
            r18 = 2308(0x904, float:3.234E-42)
            java.lang.String r17 = r17.getInfoString(r18)
            r5 = r17
            r17 = r3
            r18 = 2305(0x901, float:3.23E-42)
            java.lang.String r17 = r17.getInfoString(r18)
            r6 = r17
            r17 = r6
            java.lang.String r18 = "OpenCL "
            boolean r17 = r17.startsWith(r18)
            if (r17 != 0) goto L_0x0052
            java.lang.RuntimeException r17 = new java.lang.RuntimeException
            r21 = r17
            r17 = r21
            r18 = r21
            java.lang.StringBuilder r19 = new java.lang.StringBuilder
            r21 = r19
            r19 = r21
            r20 = r21
            r20.<init>()
            java.lang.String r20 = "Invalid OpenCL version string: "
            java.lang.StringBuilder r19 = r19.append(r20)
            r20 = r6
            java.lang.StringBuilder r19 = r19.append(r20)
            java.lang.String r19 = r19.toString()
            r18.<init>(r19)
            throw r17
        L_0x0052:
            java.util.StringTokenizer r17 = new java.util.StringTokenizer     // Catch:{ RuntimeException -> 0x01d2 }
            r21 = r17
            r17 = r21
            r18 = r21
            r19 = r6
            r20 = 7
            java.lang.String r19 = r19.substring(r20)     // Catch:{ RuntimeException -> 0x01d2 }
            java.lang.String r20 = ". "
            r18.<init>(r19, r20)     // Catch:{ RuntimeException -> 0x01d2 }
            r7 = r17
            r17 = r2
            r18 = r7
            java.lang.String r18 = r18.nextToken()     // Catch:{ RuntimeException -> 0x01d2 }
            int r18 = java.lang.Integer.parseInt(r18)     // Catch:{ RuntimeException -> 0x01d2 }
            r0 = r18
            r1 = r17
            r1.majorVersion = r0     // Catch:{ RuntimeException -> 0x01d2 }
            r17 = r2
            r18 = r7
            java.lang.String r18 = r18.nextToken()     // Catch:{ RuntimeException -> 0x01d2 }
            int r18 = java.lang.Integer.parseInt(r18)     // Catch:{ RuntimeException -> 0x01d2 }
            r0 = r18
            r1 = r17
            r1.minorVersion = r0     // Catch:{ RuntimeException -> 0x01d2 }
            r17 = r4
            r18 = r2
            r0 = r18
            int r0 = r0.majorVersion     // Catch:{ RuntimeException -> 0x01d2 }
            r18 = r0
            r0 = r17
            r1 = r18
            if (r0 < r1) goto L_0x00bd
            r17 = r4
            r18 = r2
            r0 = r18
            int r0 = r0.majorVersion     // Catch:{ RuntimeException -> 0x01d2 }
            r18 = r0
            r0 = r17
            r1 = r18
            if (r0 != r1) goto L_0x01c6
            r17 = r4
            r18 = r2
            r0 = r18
            int r0 = r0.minorVersion     // Catch:{ RuntimeException -> 0x01d2 }
            r18 = r0
            r0 = r17
            r1 = r18
            if (r0 > r1) goto L_0x01c6
        L_0x00bd:
            r17 = r4
            r9 = r17
        L_0x00c1:
            r17 = r2
            r18 = r9
            r0 = r18
            r1 = r17
            r1.OpenCL11 = r0     // Catch:{ RuntimeException -> 0x01d2 }
            r17 = r4
            r18 = r2
            r0 = r18
            int r0 = r0.majorVersion     // Catch:{ RuntimeException -> 0x01d2 }
            r18 = r0
            r0 = r17
            r1 = r18
            if (r0 < r1) goto L_0x00fb
            r17 = r4
            r18 = r2
            r0 = r18
            int r0 = r0.majorVersion     // Catch:{ RuntimeException -> 0x01d2 }
            r18 = r0
            r0 = r17
            r1 = r18
            if (r0 != r1) goto L_0x01cc
            r17 = 2
            r18 = r2
            r0 = r18
            int r0 = r0.minorVersion     // Catch:{ RuntimeException -> 0x01d2 }
            r18 = r0
            r0 = r17
            r1 = r18
            if (r0 > r1) goto L_0x01cc
        L_0x00fb:
            r17 = r4
            r10 = r17
        L_0x00ff:
            r17 = r2
            r18 = r10
            r0 = r18
            r1 = r17
            r1.OpenCL12 = r0     // Catch:{ RuntimeException -> 0x01d2 }
            r17 = r5
            java.util.Set r17 = org.lwjgl.opencl.APIUtil.getExtensions(r17)
            r11 = r17
            r17 = r11
            java.lang.String r18 = "cl_apple_contextloggingfunctions"
            boolean r17 = r17.contains(r18)
            if (r17 == 0) goto L_0x020c
            boolean r17 = org.lwjgl.opencl.CLCapabilities.CL_APPLE_ContextLoggingFunctions
            if (r17 == 0) goto L_0x020c
            r17 = r4
            r12 = r17
        L_0x0123:
            r17 = r2
            r18 = r12
            r0 = r18
            r1 = r17
            r1.CL_APPLE_ContextLoggingFunctions = r0
            r17 = r11
            java.lang.String r18 = "cl_apple_setmemobjectdestructor"
            boolean r17 = r17.contains(r18)
            if (r17 == 0) goto L_0x0212
            boolean r17 = org.lwjgl.opencl.CLCapabilities.CL_APPLE_SetMemObjectDestructor
            if (r17 == 0) goto L_0x0212
            r17 = r4
            r13 = r17
        L_0x013f:
            r17 = r2
            r18 = r13
            r0 = r18
            r1 = r17
            r1.CL_APPLE_SetMemObjectDestructor = r0
            r17 = r11
            java.lang.String r18 = "cl_apple_gl_sharing"
            boolean r17 = r17.contains(r18)
            if (r17 == 0) goto L_0x0218
            boolean r17 = org.lwjgl.opencl.CLCapabilities.CL_APPLE_gl_sharing
            if (r17 == 0) goto L_0x0218
            r17 = r4
            r14 = r17
        L_0x015b:
            r17 = r2
            r18 = r14
            r0 = r18
            r1 = r17
            r1.CL_APPLE_gl_sharing = r0
            r17 = r2
            r18 = r11
            java.lang.String r19 = "cl_khr_d3d10_sharing"
            boolean r18 = r18.contains(r19)
            r0 = r18
            r1 = r17
            r1.CL_KHR_d3d10_sharing = r0
            r17 = r11
            java.lang.String r18 = "cl_khr_gl_event"
            boolean r17 = r17.contains(r18)
            if (r17 == 0) goto L_0x021e
            boolean r17 = org.lwjgl.opencl.CLCapabilities.CL_KHR_gl_event
            if (r17 == 0) goto L_0x021e
            r17 = r4
            r15 = r17
        L_0x0187:
            r17 = r2
            r18 = r15
            r0 = r18
            r1 = r17
            r1.CL_KHR_gl_event = r0
            r17 = r11
            java.lang.String r18 = "cl_khr_gl_sharing"
            boolean r17 = r17.contains(r18)
            if (r17 == 0) goto L_0x0224
            boolean r17 = org.lwjgl.opencl.CLCapabilities.CL_KHR_gl_sharing
            if (r17 == 0) goto L_0x0224
            r17 = r4
            r16 = r17
        L_0x01a3:
            r17 = r2
            r18 = r16
            r0 = r18
            r1 = r17
            r1.CL_KHR_gl_sharing = r0
            r17 = r11
            java.lang.String r18 = "cl_khr_icd"
            boolean r17 = r17.contains(r18)
            if (r17 == 0) goto L_0x022a
            boolean r17 = org.lwjgl.opencl.CLCapabilities.CL_KHR_icd
            if (r17 == 0) goto L_0x022a
        L_0x01bb:
            r17 = r2
            r18 = r4
            r0 = r18
            r1 = r17
            r1.CL_KHR_icd = r0
            return
        L_0x01c6:
            r17 = 0
            r9 = r17
            goto L_0x00c1
        L_0x01cc:
            r17 = 0
            r10 = r17
            goto L_0x00ff
        L_0x01d2:
            r17 = move-exception
            r8 = r17
            java.lang.RuntimeException r17 = new java.lang.RuntimeException
            r21 = r17
            r17 = r21
            r18 = r21
            java.lang.StringBuilder r19 = new java.lang.StringBuilder
            r21 = r19
            r19 = r21
            r20 = r21
            r20.<init>()
            java.lang.String r20 = "The major and/or minor OpenCL version \""
            java.lang.StringBuilder r19 = r19.append(r20)
            r20 = r6
            java.lang.StringBuilder r19 = r19.append(r20)
            java.lang.String r20 = "\" is malformed: "
            java.lang.StringBuilder r19 = r19.append(r20)
            r20 = r8
            java.lang.String r20 = r20.getMessage()
            java.lang.StringBuilder r19 = r19.append(r20)
            java.lang.String r19 = r19.toString()
            r18.<init>(r19)
            throw r17
        L_0x020c:
            r17 = 0
            r12 = r17
            goto L_0x0123
        L_0x0212:
            r17 = 0
            r13 = r17
            goto L_0x013f
        L_0x0218:
            r17 = 0
            r14 = r17
            goto L_0x015b
        L_0x021e:
            r17 = 0
            r15 = r17
            goto L_0x0187
        L_0x0224:
            r17 = 0
            r16 = r17
            goto L_0x01a3
        L_0x022a:
            r17 = 0
            r4 = r17
            goto L_0x01bb
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opencl.CLPlatformCapabilities.<init>(org.lwjgl.opencl.CLPlatform):void");
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("OpenCL ").append(this.majorVersion).append('.').append(this.minorVersion);
        StringBuilder append2 = sb4.append(" - Extensions: ");
        if (this.CL_APPLE_ContextLoggingFunctions) {
            StringBuilder append3 = sb4.append("cl_apple_contextloggingfunctions ");
        }
        if (this.CL_APPLE_SetMemObjectDestructor) {
            StringBuilder append4 = sb4.append("cl_apple_setmemobjectdestructor ");
        }
        if (this.CL_APPLE_gl_sharing) {
            StringBuilder append5 = sb4.append("cl_apple_gl_sharing ");
        }
        if (this.CL_KHR_d3d10_sharing) {
            StringBuilder append6 = sb4.append("cl_khr_d3d10_sharing ");
        }
        if (this.CL_KHR_gl_event) {
            StringBuilder append7 = sb4.append("cl_khr_gl_event ");
        }
        if (this.CL_KHR_gl_sharing) {
            StringBuilder append8 = sb4.append("cl_khr_gl_sharing ");
        }
        if (this.CL_KHR_icd) {
            StringBuilder append9 = sb4.append("cl_khr_icd ");
        }
        return sb4.toString();
    }
}
