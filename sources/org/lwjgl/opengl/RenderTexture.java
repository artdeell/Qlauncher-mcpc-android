package org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class RenderTexture {
    public static final int RENDER_TEXTURE_1D = 8313;
    public static final int RENDER_TEXTURE_2D = 8314;
    public static final int RENDER_TEXTURE_CUBE_MAP = 8312;
    public static final int RENDER_TEXTURE_RECTANGLE = 8354;
    static final int WGL_BACK_LEFT_ARB = 8325;
    static final int WGL_BACK_RIGHT_ARB = 8326;
    private static final int WGL_BIND_TO_TEXTURE_DEPTH_NV = 8355;
    private static final int WGL_BIND_TO_TEXTURE_RECTANGLE_DEPTH_NV = 8356;
    private static final int WGL_BIND_TO_TEXTURE_RECTANGLE_RGBA_NV = 8353;
    private static final int WGL_BIND_TO_TEXTURE_RECTANGLE_RGB_NV = 8352;
    private static final int WGL_BIND_TO_TEXTURE_RGBA_ARB = 8305;
    private static final int WGL_BIND_TO_TEXTURE_RGB_ARB = 8304;
    static final int WGL_CUBE_MAP_FACE_ARB = 8316;
    static final int WGL_DEPTH_COMPONENT_NV = 8359;
    private static final int WGL_DEPTH_TEXTURE_FORMAT_NV = 8357;
    static final int WGL_FRONT_LEFT_ARB = 8323;
    static final int WGL_FRONT_RIGHT_ARB = 8324;
    static final int WGL_MIPMAP_LEVEL_ARB = 8315;
    private static final int WGL_MIPMAP_TEXTURE_ARB = 8308;
    private static final int WGL_NO_TEXTURE_ARB = 8311;
    private static final int WGL_TEXTURE_1D_ARB = 8313;
    private static final int WGL_TEXTURE_2D_ARB = 8314;
    private static final int WGL_TEXTURE_CUBE_MAP_ARB = 8312;
    static final int WGL_TEXTURE_CUBE_MAP_NEGATIVE_X_ARB = 8318;
    static final int WGL_TEXTURE_CUBE_MAP_NEGATIVE_Y_ARB = 8320;
    static final int WGL_TEXTURE_CUBE_MAP_NEGATIVE_Z_ARB = 8322;
    static final int WGL_TEXTURE_CUBE_MAP_POSITIVE_X_ARB = 8317;
    static final int WGL_TEXTURE_CUBE_MAP_POSITIVE_Y_ARB = 8319;
    static final int WGL_TEXTURE_CUBE_MAP_POSITIVE_Z_ARB = 8321;
    private static final int WGL_TEXTURE_DEPTH_COMPONENT_NV = 8358;
    private static final int WGL_TEXTURE_FORMAT_ARB = 8306;
    private static final int WGL_TEXTURE_RECTANGLE_NV = 8354;
    private static final int WGL_TEXTURE_RGBA_ARB = 8310;
    private static final int WGL_TEXTURE_RGB_ARB = 8309;
    private static final int WGL_TEXTURE_TARGET_ARB = 8307;
    IntBuffer pBufferAttribs;
    IntBuffer pixelFormatCaps;

    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r30v4, types: [int] */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r22v0 */
    /* JADX WARNING: type inference failed for: r22v1 */
    /* JADX WARNING: type inference failed for: r30v12, types: [int] */
    /* JADX WARNING: type inference failed for: r22v2 */
    /* JADX WARNING: type inference failed for: r28v0 */
    /* JADX WARNING: type inference failed for: r28v1 */
    /* JADX WARNING: type inference failed for: r30v16, types: [int] */
    /* JADX WARNING: type inference failed for: r28v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RenderTexture(boolean r34, boolean r35, boolean r36, boolean r37, int r38, int r39) {
        /*
            r33 = this;
            r2 = r33
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r37
            r7 = r38
            r8 = r39
            r29 = r2
            r29.<init>()
            r29 = r3
            if (r29 == 0) goto L_0x0029
            r29 = r4
            if (r29 == 0) goto L_0x0029
            java.lang.IllegalArgumentException r29 = new java.lang.IllegalArgumentException
            r32 = r29
            r29 = r32
            r30 = r32
            java.lang.String r31 = "A RenderTexture can't be both RGB and RGBA."
            r30.<init>(r31)
            throw r29
        L_0x0029:
            r29 = r8
            if (r29 >= 0) goto L_0x003b
            java.lang.IllegalArgumentException r29 = new java.lang.IllegalArgumentException
            r32 = r29
            r29 = r32
            r30 = r32
            java.lang.String r31 = "The mipmap levels can't be negative."
            r30.<init>(r31)
            throw r29
        L_0x003b:
            r29 = r6
            if (r29 == 0) goto L_0x0057
            r29 = r7
            r30 = 8354(0x20a2, float:1.1706E-41)
            r0 = r29
            r1 = r30
            if (r0 == r1) goto L_0x0057
            java.lang.IllegalArgumentException r29 = new java.lang.IllegalArgumentException
            r32 = r29
            r29 = r32
            r30 = r32
            java.lang.String r31 = "When the RenderTexture is rectangle the target must be RENDER_TEXTURE_RECTANGLE."
            r30.<init>(r31)
            throw r29
        L_0x0057:
            r29 = r2
            r30 = 4
            java.nio.IntBuffer r30 = org.lwjgl.BufferUtils.createIntBuffer(r30)
            r0 = r30
            r1 = r29
            r1.pixelFormatCaps = r0
            r29 = r2
            r30 = 8
            java.nio.IntBuffer r30 = org.lwjgl.BufferUtils.createIntBuffer(r30)
            r0 = r30
            r1 = r29
            r1.pBufferAttribs = r0
            r29 = r3
            if (r29 == 0) goto L_0x015e
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pixelFormatCaps
            r29 = r0
            r27 = r29
            r29 = r6
            if (r29 == 0) goto L_0x0158
            r29 = 8352(0x20a0, float:1.1704E-41)
            r28 = r29
        L_0x0089:
            r29 = r27
            r30 = r28
            java.nio.IntBuffer r29 = r29.put(r30)
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pixelFormatCaps
            r29 = r0
            r30 = 1
            java.nio.IntBuffer r29 = r29.put(r30)
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pBufferAttribs
            r29 = r0
            r30 = 8306(0x2072, float:1.1639E-41)
            java.nio.IntBuffer r29 = r29.put(r30)
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pBufferAttribs
            r29 = r0
            r30 = 8309(0x2075, float:1.1643E-41)
            java.nio.IntBuffer r29 = r29.put(r30)
        L_0x00bb:
            r29 = r5
            if (r29 == 0) goto L_0x0103
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pixelFormatCaps
            r29 = r0
            r21 = r29
            r29 = r6
            if (r29 == 0) goto L_0x01ad
            r29 = 8356(0x20a4, float:1.1709E-41)
            r22 = r29
        L_0x00d1:
            r29 = r21
            r30 = r22
            java.nio.IntBuffer r29 = r29.put(r30)
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pixelFormatCaps
            r29 = r0
            r30 = 1
            java.nio.IntBuffer r29 = r29.put(r30)
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pBufferAttribs
            r29 = r0
            r30 = 8357(0x20a5, float:1.171E-41)
            java.nio.IntBuffer r29 = r29.put(r30)
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pBufferAttribs
            r29 = r0
            r30 = 8358(0x20a6, float:1.1712E-41)
            java.nio.IntBuffer r29 = r29.put(r30)
        L_0x0103:
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pBufferAttribs
            r29 = r0
            r30 = 8307(0x2073, float:1.164E-41)
            java.nio.IntBuffer r29 = r29.put(r30)
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pBufferAttribs
            r29 = r0
            r30 = r7
            java.nio.IntBuffer r29 = r29.put(r30)
            r29 = r8
            if (r29 == 0) goto L_0x013f
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pBufferAttribs
            r29 = r0
            r30 = 8308(0x2074, float:1.1642E-41)
            java.nio.IntBuffer r29 = r29.put(r30)
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pBufferAttribs
            r29 = r0
            r30 = r8
            java.nio.IntBuffer r29 = r29.put(r30)
        L_0x013f:
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pixelFormatCaps
            r29 = r0
            java.nio.Buffer r29 = r29.flip()
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pBufferAttribs
            r29 = r0
            java.nio.Buffer r29 = r29.flip()
            return
        L_0x0158:
            r29 = 8304(0x2070, float:1.1636E-41)
            r28 = r29
            goto L_0x0089
        L_0x015e:
            r29 = r4
            if (r29 == 0) goto L_0x00bb
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pixelFormatCaps
            r29 = r0
            r9 = r29
            r29 = r6
            if (r29 == 0) goto L_0x01a8
            r29 = 8353(0x20a1, float:1.1705E-41)
            r10 = r29
        L_0x0174:
            r29 = r9
            r30 = r10
            java.nio.IntBuffer r29 = r29.put(r30)
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pixelFormatCaps
            r29 = r0
            r30 = 1
            java.nio.IntBuffer r29 = r29.put(r30)
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pBufferAttribs
            r29 = r0
            r30 = 8306(0x2072, float:1.1639E-41)
            java.nio.IntBuffer r29 = r29.put(r30)
            r29 = r2
            r0 = r29
            java.nio.IntBuffer r0 = r0.pBufferAttribs
            r29 = r0
            r30 = 8310(0x2076, float:1.1645E-41)
            java.nio.IntBuffer r29 = r29.put(r30)
            goto L_0x00bb
        L_0x01a8:
            r29 = 8305(0x2071, float:1.1638E-41)
            r10 = r29
            goto L_0x0174
        L_0x01ad:
            r29 = 8355(0x20a3, float:1.1708E-41)
            r22 = r29
            goto L_0x00d1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.RenderTexture.<init>(boolean, boolean, boolean, boolean, int, int):void");
    }
}
