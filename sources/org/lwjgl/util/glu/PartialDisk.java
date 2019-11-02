package org.lwjgl.util.glu;

public class PartialDisk extends Quadric {
    private static final int CACHE_SIZE = 240;

    public PartialDisk() {
    }

    /* JADX WARNING: type inference failed for: r53v1 */
    /* JADX WARNING: type inference failed for: r53v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(float r59, float r60, int r61, int r62, float r63, float r64) {
        /*
            r58 = this;
            r2 = r58
            r3 = r59
            r4 = r60
            r5 = r61
            r6 = r62
            r7 = r63
            r8 = r64
            r53 = 240(0xf0, float:3.36E-43)
            r0 = r53
            float[] r0 = new float[r0]
            r53 = r0
            r9 = r53
            r53 = 240(0xf0, float:3.36E-43)
            r0 = r53
            float[] r0 = new float[r0]
            r53 = r0
            r10 = r53
            r53 = 0
            r11 = r53
            r53 = 0
            r12 = r53
            r53 = r5
            r54 = 240(0xf0, float:3.36E-43)
            r0 = r53
            r1 = r54
            if (r0 < r1) goto L_0x0038
            r53 = 239(0xef, float:3.35E-43)
            r5 = r53
        L_0x0038:
            r53 = r5
            r54 = 2
            r0 = r53
            r1 = r54
            if (r0 < r1) goto L_0x0064
            r53 = r6
            r54 = 1
            r0 = r53
            r1 = r54
            if (r0 < r1) goto L_0x0064
            r53 = r4
            r54 = 0
            int r53 = (r53 > r54 ? 1 : (r53 == r54 ? 0 : -1))
            if (r53 <= 0) goto L_0x0064
            r53 = r3
            r54 = 0
            int r53 = (r53 > r54 ? 1 : (r53 == r54 ? 0 : -1))
            if (r53 < 0) goto L_0x0064
            r53 = r3
            r54 = r4
            int r53 = (r53 > r54 ? 1 : (r53 == r54 ? 0 : -1))
            if (r53 <= 0) goto L_0x006c
        L_0x0064:
            java.io.PrintStream r53 = java.lang.System.err
            java.lang.String r54 = "PartialDisk: GLU_INVALID_VALUE"
            r53.println(r54)
        L_0x006b:
            return
        L_0x006c:
            r53 = r8
            r54 = -1011613696(0xffffffffc3b40000, float:-360.0)
            int r53 = (r53 > r54 ? 1 : (r53 == r54 ? 0 : -1))
            if (r53 >= 0) goto L_0x0078
            r53 = 1135869952(0x43b40000, float:360.0)
            r8 = r53
        L_0x0078:
            r53 = r8
            r54 = 1135869952(0x43b40000, float:360.0)
            int r53 = (r53 > r54 ? 1 : (r53 == r54 ? 0 : -1))
            if (r53 <= 0) goto L_0x0084
            r53 = 1135869952(0x43b40000, float:360.0)
            r8 = r53
        L_0x0084:
            r53 = r8
            r54 = 0
            int r53 = (r53 > r54 ? 1 : (r53 == r54 ? 0 : -1))
            if (r53 >= 0) goto L_0x009d
            r53 = r7
            r54 = r8
            float r53 = r53 + r54
            r7 = r53
            r53 = r8
            r0 = r53
            float r0 = -r0
            r53 = r0
            r8 = r53
        L_0x009d:
            r53 = r8
            r54 = 1135869952(0x43b40000, float:360.0)
            int r53 = (r53 > r54 ? 1 : (r53 == r54 ? 0 : -1))
            if (r53 != 0) goto L_0x010e
            r53 = r5
            r13 = r53
        L_0x00a9:
            r53 = r4
            r54 = r3
            float r53 = r53 - r54
            r14 = r53
            r53 = 1078530011(0x40490fdb, float:3.1415927)
            r54 = r7
            r55 = 1127481344(0x43340000, float:180.0)
            float r54 = r54 / r55
            float r53 = r53 * r54
            r15 = r53
            r53 = 0
            r16 = r53
        L_0x00c2:
            r53 = r16
            r54 = r5
            r0 = r53
            r1 = r54
            if (r0 > r1) goto L_0x0117
            r53 = r15
            r54 = 1078530011(0x40490fdb, float:3.1415927)
            r55 = r8
            float r54 = r54 * r55
            r55 = 1127481344(0x43340000, float:180.0)
            float r54 = r54 / r55
            r55 = r16
            r0 = r55
            float r0 = (float) r0
            r55 = r0
            float r54 = r54 * r55
            r55 = r5
            r0 = r55
            float r0 = (float) r0
            r55 = r0
            float r54 = r54 / r55
            float r53 = r53 + r54
            r52 = r53
            r53 = r9
            r54 = r16
            r55 = r2
            r56 = r52
            float r55 = r55.sin(r56)
            r53[r54] = r55
            r53 = r10
            r54 = r16
            r55 = r2
            r56 = r52
            float r55 = r55.cos(r56)
            r53[r54] = r55
            int r16 = r16 + 1
            goto L_0x00c2
        L_0x010e:
            r53 = r5
            r54 = 1
            int r53 = r53 + 1
            r13 = r53
            goto L_0x00a9
        L_0x0117:
            r53 = r8
            r54 = 1135869952(0x43b40000, float:360.0)
            int r53 = (r53 > r54 ? 1 : (r53 == r54 ? 0 : -1))
            if (r53 != 0) goto L_0x0137
            r53 = r9
            r54 = r5
            r55 = r9
            r56 = 0
            r55 = r55[r56]
            r53[r54] = r55
            r53 = r10
            r54 = r5
            r55 = r10
            r56 = 0
            r55 = r55[r56]
            r53[r54] = r55
        L_0x0137:
            r53 = r2
            r0 = r53
            int r0 = r0.normals
            r53 = r0
            switch(r53) {
                case 100000: goto L_0x01e3;
                case 100001: goto L_0x01e3;
                default: goto L_0x0142;
            }
        L_0x0142:
            r53 = r2
            r0 = r53
            int r0 = r0.drawStyle
            r53 = r0
            switch(r53) {
                case 100010: goto L_0x014f;
                case 100011: goto L_0x04dd;
                case 100012: goto L_0x020a;
                case 100013: goto L_0x0684;
                default: goto L_0x014d;
            }
        L_0x014d:
            goto L_0x006b
        L_0x014f:
            r53 = 0
            org.lwjgl.opengl.GL11.glBegin(r53)
            r53 = 0
            r46 = r53
        L_0x0158:
            r53 = r46
            r54 = r13
            r0 = r53
            r1 = r54
            if (r0 >= r1) goto L_0x04d8
            r53 = r9
            r54 = r46
            r53 = r53[r54]
            r47 = r53
            r53 = r10
            r54 = r46
            r53 = r53[r54]
            r48 = r53
            r53 = 0
            r49 = r53
        L_0x0176:
            r53 = r49
            r54 = r6
            r0 = r53
            r1 = r54
            if (r0 > r1) goto L_0x04d4
            r53 = r4
            r54 = r14
            r55 = r49
            r0 = r55
            float r0 = (float) r0
            r55 = r0
            r56 = r6
            r0 = r56
            float r0 = (float) r0
            r56 = r0
            float r55 = r55 / r56
            float r54 = r54 * r55
            float r53 = r53 - r54
            r50 = r53
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x01cf
            r53 = r50
            r54 = r4
            float r53 = r53 / r54
            r54 = 1073741824(0x40000000, float:2.0)
            float r53 = r53 / r54
            r51 = r53
            r53 = 1056964608(0x3f000000, float:0.5)
            r54 = r51
            r55 = r9
            r56 = r46
            r55 = r55[r56]
            float r54 = r54 * r55
            float r53 = r53 + r54
            r54 = 1056964608(0x3f000000, float:0.5)
            r55 = r51
            r56 = r10
            r57 = r46
            r56 = r56[r57]
            float r55 = r55 * r56
            float r54 = r54 + r55
            org.lwjgl.opengl.GL11.glTexCoord2f(r53, r54)
        L_0x01cf:
            r53 = r50
            r54 = r47
            float r53 = r53 * r54
            r54 = r50
            r55 = r48
            float r54 = r54 * r55
            r55 = 0
            org.lwjgl.opengl.GL11.glVertex3f(r53, r54, r55)
            int r49 = r49 + 1
            goto L_0x0176
        L_0x01e3:
            r53 = r2
            r0 = r53
            int r0 = r0.orientation
            r53 = r0
            r54 = 100020(0x186b4, float:1.40158E-40)
            r0 = r53
            r1 = r54
            if (r0 != r1) goto L_0x01ff
            r53 = 0
            r54 = 0
            r55 = 1065353216(0x3f800000, float:1.0)
            org.lwjgl.opengl.GL11.glNormal3f(r53, r54, r55)
            goto L_0x0142
        L_0x01ff:
            r53 = 0
            r54 = 0
            r55 = -1082130432(0xffffffffbf800000, float:-1.0)
            org.lwjgl.opengl.GL11.glNormal3f(r53, r54, r55)
            goto L_0x0142
        L_0x020a:
            r53 = r3
            r54 = 0
            int r53 = (r53 > r54 ? 1 : (r53 == r54 ? 0 : -1))
            if (r53 != 0) goto L_0x043d
            r53 = r6
            r54 = 1
            int r53 = r53 + -1
            r36 = r53
            r53 = 6
            org.lwjgl.opengl.GL11.glBegin(r53)
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x0230
            r53 = 1056964608(0x3f000000, float:0.5)
            r54 = 1056964608(0x3f000000, float:0.5)
            org.lwjgl.opengl.GL11.glTexCoord2f(r53, r54)
        L_0x0230:
            r53 = 0
            r54 = 0
            r55 = 0
            org.lwjgl.opengl.GL11.glVertex3f(r53, r54, r55)
            r53 = r4
            r54 = r14
            r55 = r6
            r56 = 1
            int r55 = r55 + -1
            r0 = r55
            float r0 = (float) r0
            r55 = r0
            r56 = r6
            r0 = r56
            float r0 = (float) r0
            r56 = r0
            float r55 = r55 / r56
            float r54 = r54 * r55
            float r53 = r53 - r54
            r42 = r53
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            r43 = r53
            r53 = 0
            r37 = r53
            r53 = r43
            if (r53 == 0) goto L_0x0275
            r53 = r42
            r54 = r4
            float r53 = r53 / r54
            r54 = 1073741824(0x40000000, float:2.0)
            float r53 = r53 / r54
            r37 = r53
        L_0x0275:
            r53 = r2
            r0 = r53
            int r0 = r0.orientation
            r53 = r0
            r54 = 100020(0x186b4, float:1.40158E-40)
            r0 = r53
            r1 = r54
            if (r0 != r1) goto L_0x02d3
            r53 = r5
            r45 = r53
        L_0x028a:
            r53 = r45
            if (r53 < 0) goto L_0x0326
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x02b7
            r53 = 1056964608(0x3f000000, float:0.5)
            r54 = r37
            r55 = r9
            r56 = r45
            r55 = r55[r56]
            float r54 = r54 * r55
            float r53 = r53 + r54
            r54 = 1056964608(0x3f000000, float:0.5)
            r55 = r37
            r56 = r10
            r57 = r45
            r56 = r56[r57]
            float r55 = r55 * r56
            float r54 = r54 + r55
            org.lwjgl.opengl.GL11.glTexCoord2f(r53, r54)
        L_0x02b7:
            r53 = r42
            r54 = r9
            r55 = r45
            r54 = r54[r55]
            float r53 = r53 * r54
            r54 = r42
            r55 = r10
            r56 = r45
            r55 = r55[r56]
            float r54 = r54 * r55
            r55 = 0
            org.lwjgl.opengl.GL11.glVertex3f(r53, r54, r55)
            int r45 = r45 + -1
            goto L_0x028a
        L_0x02d3:
            r53 = 0
            r44 = r53
        L_0x02d7:
            r53 = r44
            r54 = r5
            r0 = r53
            r1 = r54
            if (r0 > r1) goto L_0x0326
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x030a
            r53 = 1056964608(0x3f000000, float:0.5)
            r54 = r37
            r55 = r9
            r56 = r44
            r55 = r55[r56]
            float r54 = r54 * r55
            float r53 = r53 + r54
            r54 = 1056964608(0x3f000000, float:0.5)
            r55 = r37
            r56 = r10
            r57 = r44
            r56 = r56[r57]
            float r55 = r55 * r56
            float r54 = r54 + r55
            org.lwjgl.opengl.GL11.glTexCoord2f(r53, r54)
        L_0x030a:
            r53 = r42
            r54 = r9
            r55 = r44
            r54 = r54[r55]
            float r53 = r53 * r54
            r54 = r42
            r55 = r10
            r56 = r44
            r55 = r55[r56]
            float r54 = r54 * r55
            r55 = 0
            org.lwjgl.opengl.GL11.glVertex3f(r53, r54, r55)
            int r44 = r44 + 1
            goto L_0x02d7
        L_0x0326:
            org.lwjgl.opengl.GL11.glEnd()
        L_0x0329:
            r53 = 0
            r38 = r53
        L_0x032d:
            r53 = r38
            r54 = r36
            r0 = r53
            r1 = r54
            if (r0 >= r1) goto L_0x006b
            r53 = r4
            r54 = r14
            r55 = r38
            r0 = r55
            float r0 = (float) r0
            r55 = r0
            r56 = r6
            r0 = r56
            float r0 = (float) r0
            r56 = r0
            float r55 = r55 / r56
            float r54 = r54 * r55
            float r53 = r53 - r54
            r39 = r53
            r53 = r4
            r54 = r14
            r55 = r38
            r56 = 1
            int r55 = r55 + 1
            r0 = r55
            float r0 = (float) r0
            r55 = r0
            r56 = r6
            r0 = r56
            float r0 = (float) r0
            r56 = r0
            float r55 = r55 / r56
            float r54 = r54 * r55
            float r53 = r53 - r54
            r40 = r53
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x0391
            r53 = r39
            r54 = r4
            float r53 = r53 / r54
            r54 = 1073741824(0x40000000, float:2.0)
            float r53 = r53 / r54
            r37 = r53
            r53 = r40
            r54 = r4
            float r53 = r53 / r54
            r54 = 1073741824(0x40000000, float:2.0)
            float r53 = r53 / r54
            r12 = r53
        L_0x0391:
            r53 = 8
            org.lwjgl.opengl.GL11.glBegin(r53)
            r53 = 0
            r41 = r53
        L_0x039a:
            r53 = r41
            r54 = r5
            r0 = r53
            r1 = r54
            if (r0 > r1) goto L_0x04cd
            r53 = r2
            r0 = r53
            int r0 = r0.orientation
            r53 = r0
            r54 = 100020(0x186b4, float:1.40158E-40)
            r0 = r53
            r1 = r54
            if (r0 != r1) goto L_0x0447
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x03de
            r53 = 1056964608(0x3f000000, float:0.5)
            r54 = r37
            r55 = r9
            r56 = r41
            r55 = r55[r56]
            float r54 = r54 * r55
            float r53 = r53 + r54
            r54 = 1056964608(0x3f000000, float:0.5)
            r55 = r37
            r56 = r10
            r57 = r41
            r56 = r56[r57]
            float r55 = r55 * r56
            float r54 = r54 + r55
            org.lwjgl.opengl.GL11.glTexCoord2f(r53, r54)
        L_0x03de:
            r53 = r39
            r54 = r9
            r55 = r41
            r54 = r54[r55]
            float r53 = r53 * r54
            r54 = r39
            r55 = r10
            r56 = r41
            r55 = r55[r56]
            float r54 = r54 * r55
            r55 = 0
            org.lwjgl.opengl.GL11.glVertex3f(r53, r54, r55)
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x0420
            r53 = 1056964608(0x3f000000, float:0.5)
            r54 = r12
            r55 = r9
            r56 = r41
            r55 = r55[r56]
            float r54 = r54 * r55
            float r53 = r53 + r54
            r54 = 1056964608(0x3f000000, float:0.5)
            r55 = r12
            r56 = r10
            r57 = r41
            r56 = r56[r57]
            float r55 = r55 * r56
            float r54 = r54 + r55
            org.lwjgl.opengl.GL11.glTexCoord2f(r53, r54)
        L_0x0420:
            r53 = r40
            r54 = r9
            r55 = r41
            r54 = r54[r55]
            float r53 = r53 * r54
            r54 = r40
            r55 = r10
            r56 = r41
            r55 = r55[r56]
            float r54 = r54 * r55
            r55 = 0
            org.lwjgl.opengl.GL11.glVertex3f(r53, r54, r55)
        L_0x0439:
            int r41 = r41 + 1
            goto L_0x039a
        L_0x043d:
            r53 = r6
            r36 = r53
            r53 = 0
            r37 = r53
            goto L_0x0329
        L_0x0447:
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x0470
            r53 = 1056964608(0x3f000000, float:0.5)
            r54 = r12
            r55 = r9
            r56 = r41
            r55 = r55[r56]
            float r54 = r54 * r55
            float r53 = r53 + r54
            r54 = 1056964608(0x3f000000, float:0.5)
            r55 = r12
            r56 = r10
            r57 = r41
            r56 = r56[r57]
            float r55 = r55 * r56
            float r54 = r54 + r55
            org.lwjgl.opengl.GL11.glTexCoord2f(r53, r54)
        L_0x0470:
            r53 = r40
            r54 = r9
            r55 = r41
            r54 = r54[r55]
            float r53 = r53 * r54
            r54 = r40
            r55 = r10
            r56 = r41
            r55 = r55[r56]
            float r54 = r54 * r55
            r55 = 0
            org.lwjgl.opengl.GL11.glVertex3f(r53, r54, r55)
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x04b2
            r53 = 1056964608(0x3f000000, float:0.5)
            r54 = r37
            r55 = r9
            r56 = r41
            r55 = r55[r56]
            float r54 = r54 * r55
            float r53 = r53 + r54
            r54 = 1056964608(0x3f000000, float:0.5)
            r55 = r37
            r56 = r10
            r57 = r41
            r56 = r56[r57]
            float r55 = r55 * r56
            float r54 = r54 + r55
            org.lwjgl.opengl.GL11.glTexCoord2f(r53, r54)
        L_0x04b2:
            r53 = r39
            r54 = r9
            r55 = r41
            r54 = r54[r55]
            float r53 = r53 * r54
            r54 = r39
            r55 = r10
            r56 = r41
            r55 = r55[r56]
            float r54 = r54 * r55
            r55 = 0
            org.lwjgl.opengl.GL11.glVertex3f(r53, r54, r55)
            goto L_0x0439
        L_0x04cd:
            org.lwjgl.opengl.GL11.glEnd()
            int r38 = r38 + 1
            goto L_0x032d
        L_0x04d4:
            int r46 = r46 + 1
            goto L_0x0158
        L_0x04d8:
            org.lwjgl.opengl.GL11.glEnd()
            goto L_0x006b
        L_0x04dd:
            r53 = r3
            r54 = r4
            int r53 = (r53 > r54 ? 1 : (r53 == r54 ? 0 : -1))
            if (r53 != 0) goto L_0x0542
            r53 = 3
            org.lwjgl.opengl.GL11.glBegin(r53)
            r53 = 0
            r35 = r53
        L_0x04ee:
            r53 = r35
            r54 = r5
            r0 = r53
            r1 = r54
            if (r0 > r1) goto L_0x053d
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x0521
            r53 = 1056964608(0x3f000000, float:0.5)
            r54 = r9
            r55 = r35
            r54 = r54[r55]
            r55 = 1073741824(0x40000000, float:2.0)
            float r54 = r54 / r55
            float r53 = r53 + r54
            r54 = 1056964608(0x3f000000, float:0.5)
            r55 = r10
            r56 = r35
            r55 = r55[r56]
            r56 = 1073741824(0x40000000, float:2.0)
            float r55 = r55 / r56
            float r54 = r54 + r55
            org.lwjgl.opengl.GL11.glTexCoord2f(r53, r54)
        L_0x0521:
            r53 = r3
            r54 = r9
            r55 = r35
            r54 = r54[r55]
            float r53 = r53 * r54
            r54 = r3
            r55 = r10
            r56 = r35
            r55 = r55[r56]
            float r54 = r54 * r55
            r55 = 0
            org.lwjgl.opengl.GL11.glVertex3f(r53, r54, r55)
            int r35 = r35 + 1
            goto L_0x04ee
        L_0x053d:
            org.lwjgl.opengl.GL11.glEnd()
            goto L_0x006b
        L_0x0542:
            r53 = 0
            r27 = r53
        L_0x0546:
            r53 = r27
            r54 = r6
            r0 = r53
            r1 = r54
            if (r0 > r1) goto L_0x05df
            r53 = r4
            r54 = r14
            r55 = r27
            r0 = r55
            float r0 = (float) r0
            r55 = r0
            r56 = r6
            r0 = r56
            float r0 = (float) r0
            r56 = r0
            float r55 = r55 / r56
            float r54 = r54 * r55
            float r53 = r53 - r54
            r33 = r53
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x0580
            r53 = r33
            r54 = r4
            float r53 = r53 / r54
            r54 = 1073741824(0x40000000, float:2.0)
            float r53 = r53 / r54
            r11 = r53
        L_0x0580:
            r53 = 3
            org.lwjgl.opengl.GL11.glBegin(r53)
            r53 = 0
            r34 = r53
        L_0x0589:
            r53 = r34
            r54 = r5
            r0 = r53
            r1 = r54
            if (r0 > r1) goto L_0x05d8
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x05bc
            r53 = 1056964608(0x3f000000, float:0.5)
            r54 = r11
            r55 = r9
            r56 = r34
            r55 = r55[r56]
            float r54 = r54 * r55
            float r53 = r53 + r54
            r54 = 1056964608(0x3f000000, float:0.5)
            r55 = r11
            r56 = r10
            r57 = r34
            r56 = r56[r57]
            float r55 = r55 * r56
            float r54 = r54 + r55
            org.lwjgl.opengl.GL11.glTexCoord2f(r53, r54)
        L_0x05bc:
            r53 = r33
            r54 = r9
            r55 = r34
            r54 = r54[r55]
            float r53 = r53 * r54
            r54 = r33
            r55 = r10
            r56 = r34
            r55 = r55[r56]
            float r54 = r54 * r55
            r55 = 0
            org.lwjgl.opengl.GL11.glVertex3f(r53, r54, r55)
            int r34 = r34 + 1
            goto L_0x0589
        L_0x05d8:
            org.lwjgl.opengl.GL11.glEnd()
            int r27 = r27 + 1
            goto L_0x0546
        L_0x05df:
            r53 = 0
            r28 = r53
        L_0x05e3:
            r53 = r28
            r54 = r13
            r0 = r53
            r1 = r54
            if (r0 >= r1) goto L_0x006b
            r53 = r9
            r54 = r28
            r53 = r53[r54]
            r29 = r53
            r53 = r10
            r54 = r28
            r53 = r53[r54]
            r30 = r53
            r53 = 3
            org.lwjgl.opengl.GL11.glBegin(r53)
            r53 = 0
            r31 = r53
        L_0x0606:
            r53 = r31
            r54 = r6
            r0 = r53
            r1 = r54
            if (r0 > r1) goto L_0x067d
            r53 = r4
            r54 = r14
            r55 = r31
            r0 = r55
            float r0 = (float) r0
            r55 = r0
            r56 = r6
            r0 = r56
            float r0 = (float) r0
            r56 = r0
            float r55 = r55 / r56
            float r54 = r54 * r55
            float r53 = r53 - r54
            r32 = r53
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x0640
            r53 = r32
            r54 = r4
            float r53 = r53 / r54
            r54 = 1073741824(0x40000000, float:2.0)
            float r53 = r53 / r54
            r11 = r53
        L_0x0640:
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x0669
            r53 = 1056964608(0x3f000000, float:0.5)
            r54 = r11
            r55 = r9
            r56 = r28
            r55 = r55[r56]
            float r54 = r54 * r55
            float r53 = r53 + r54
            r54 = 1056964608(0x3f000000, float:0.5)
            r55 = r11
            r56 = r10
            r57 = r28
            r56 = r56[r57]
            float r55 = r55 * r56
            float r54 = r54 + r55
            org.lwjgl.opengl.GL11.glTexCoord2f(r53, r54)
        L_0x0669:
            r53 = r32
            r54 = r29
            float r53 = r53 * r54
            r54 = r32
            r55 = r30
            float r54 = r54 * r55
            r55 = 0
            org.lwjgl.opengl.GL11.glVertex3f(r53, r54, r55)
            int r31 = r31 + 1
            goto L_0x0606
        L_0x067d:
            org.lwjgl.opengl.GL11.glEnd()
            int r28 = r28 + 1
            goto L_0x05e3
        L_0x0684:
            r53 = r8
            r54 = 1135869952(0x43b40000, float:360.0)
            int r53 = (r53 > r54 ? 1 : (r53 == r54 ? 0 : -1))
            r17 = r53
            r53 = 0
            r18 = r53
            r53 = r17
            if (r53 >= 0) goto L_0x0735
            r53 = 0
            r22 = r53
        L_0x0698:
            r53 = r22
            r54 = r5
            r0 = r53
            r1 = r54
            if (r0 > r1) goto L_0x0735
            r53 = r9
            r54 = r22
            r53 = r53[r54]
            r23 = r53
            r53 = r10
            r54 = r22
            r53 = r53[r54]
            r24 = r53
            r53 = 3
            org.lwjgl.opengl.GL11.glBegin(r53)
            r53 = 0
            r25 = r53
        L_0x06bb:
            r53 = r25
            r54 = r6
            r0 = r53
            r1 = r54
            if (r0 > r1) goto L_0x0728
            r53 = r4
            r54 = r14
            r55 = r25
            r0 = r55
            float r0 = (float) r0
            r55 = r0
            r56 = r6
            r0 = r56
            float r0 = (float) r0
            r56 = r0
            float r55 = r55 / r56
            float r54 = r54 * r55
            float r53 = r53 - r54
            r26 = r53
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x0714
            r53 = r26
            r54 = r4
            float r53 = r53 / r54
            r54 = 1073741824(0x40000000, float:2.0)
            float r53 = r53 / r54
            r18 = r53
            r53 = 1056964608(0x3f000000, float:0.5)
            r54 = r18
            r55 = r9
            r56 = r22
            r55 = r55[r56]
            float r54 = r54 * r55
            float r53 = r53 + r54
            r54 = 1056964608(0x3f000000, float:0.5)
            r55 = r18
            r56 = r10
            r57 = r22
            r56 = r56[r57]
            float r55 = r55 * r56
            float r54 = r54 + r55
            org.lwjgl.opengl.GL11.glTexCoord2f(r53, r54)
        L_0x0714:
            r53 = r26
            r54 = r23
            float r53 = r53 * r54
            r54 = r26
            r55 = r24
            float r54 = r54 * r55
            r55 = 0
            org.lwjgl.opengl.GL11.glVertex3f(r53, r54, r55)
            int r25 = r25 + 1
            goto L_0x06bb
        L_0x0728:
            org.lwjgl.opengl.GL11.glEnd()
            r53 = r22
            r54 = r5
            int r53 = r53 + r54
            r22 = r53
            goto L_0x0698
        L_0x0735:
            r53 = 0
            r19 = r53
        L_0x0739:
            r53 = r19
            r54 = r6
            r0 = r53
            r1 = r54
            if (r0 > r1) goto L_0x006b
            r53 = r4
            r54 = r14
            r55 = r19
            r0 = r55
            float r0 = (float) r0
            r55 = r0
            r56 = r6
            r0 = r56
            float r0 = (float) r0
            r56 = r0
            float r55 = r55 / r56
            float r54 = r54 * r55
            float r53 = r53 - r54
            r20 = r53
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x0773
            r53 = r20
            r54 = r4
            float r53 = r53 / r54
            r54 = 1073741824(0x40000000, float:2.0)
            float r53 = r53 / r54
            r18 = r53
        L_0x0773:
            r53 = 3
            org.lwjgl.opengl.GL11.glBegin(r53)
            r53 = 0
            r21 = r53
        L_0x077c:
            r53 = r21
            r54 = r5
            r0 = r53
            r1 = r54
            if (r0 > r1) goto L_0x07cb
            r53 = r2
            r0 = r53
            boolean r0 = r0.textureFlag
            r53 = r0
            if (r53 == 0) goto L_0x07af
            r53 = 1056964608(0x3f000000, float:0.5)
            r54 = r18
            r55 = r9
            r56 = r21
            r55 = r55[r56]
            float r54 = r54 * r55
            float r53 = r53 + r54
            r54 = 1056964608(0x3f000000, float:0.5)
            r55 = r18
            r56 = r10
            r57 = r21
            r56 = r56[r57]
            float r55 = r55 * r56
            float r54 = r54 + r55
            org.lwjgl.opengl.GL11.glTexCoord2f(r53, r54)
        L_0x07af:
            r53 = r20
            r54 = r9
            r55 = r21
            r54 = r54[r55]
            float r53 = r53 * r54
            r54 = r20
            r55 = r10
            r56 = r21
            r55 = r55[r56]
            float r54 = r54 * r55
            r55 = 0
            org.lwjgl.opengl.GL11.glVertex3f(r53, r54, r55)
            int r21 = r21 + 1
            goto L_0x077c
        L_0x07cb:
            org.lwjgl.opengl.GL11.glEnd()
            r53 = r3
            r54 = r4
            int r53 = (r53 > r54 ? 1 : (r53 == r54 ? 0 : -1))
            if (r53 == 0) goto L_0x006b
            r53 = r19
            r54 = r6
            int r53 = r53 + r54
            r19 = r53
            goto L_0x0739
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.glu.PartialDisk.draw(float, float, int, int, float, float):void");
    }
}
