package org.lwjgl.test.opengl.shaders;

import java.io.PrintStream;
import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.GL11;

abstract class Shader {
    protected static ByteBuffer fileBuffer = BufferUtils.createByteBuffer(GL11.GL_TEXTURE_MAG_FILTER);

    protected Shader() {
    }

    protected static void checkProgramError(String str, String str2) {
        StringBuilder sb;
        String str3 = str;
        String str4 = str2;
        if (GL11.glGetError() == 1282) {
            int glGetInteger = GL11.glGetInteger(34379);
            int i = 0;
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= str4.length()) {
                    break;
                }
                if (str4.charAt(i3) == 10) {
                    if (i3 > glGetInteger) {
                        i2 = i3;
                        break;
                    }
                    i = i3 + 1;
                }
                i3++;
            }
            if (i2 == -1) {
                i2 = str4.length();
            }
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            ShadersTest.kill(sb2.append("Low-level program error in file: ").append(str3).append("\n\tError line: ").append(str4.substring(i, i2)).append("\n\tError message: ").append(GL11.glGetString(34932)).toString());
        }
    }

    /* JADX WARNING: type inference failed for: r11v9, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r11v10 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r13v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r15v3 */
    /* JADX WARNING: type inference failed for: r11v35 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static java.lang.String getShaderText(java.lang.String r16) {
        /*
            r0 = r16
            r11 = 0
            r1 = r11
            java.lang.Class<org.lwjgl.test.opengl.shaders.ShadersTest> r11 = org.lwjgl.test.opengl.shaders.ShadersTest.class
            r12 = r0
            java.io.InputStream r11 = r11.getResourceAsStream(r12)     // Catch:{ IOException -> 0x004c }
            r3 = r11
            r11 = r3
            if (r11 != 0) goto L_0x002f
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ IOException -> 0x004c }
            r15 = r11
            r11 = r15
            r12 = r15
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004c }
            r15 = r13
            r13 = r15
            r14 = r15
            r14.<init>()     // Catch:{ IOException -> 0x004c }
            java.lang.String r14 = "src/java/org/lwjgl/test/opengl/shaders/"
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ IOException -> 0x004c }
            r14 = r0
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ IOException -> 0x004c }
            java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x004c }
            r12.<init>(r13)     // Catch:{ IOException -> 0x004c }
            r3 = r11
        L_0x002f:
            java.io.BufferedInputStream r11 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x004c }
            r15 = r11
            r11 = r15
            r12 = r15
            r13 = r3
            r12.<init>(r13)     // Catch:{ IOException -> 0x004c }
            r4 = r11
        L_0x0039:
            r11 = r4
            int r11 = r11.read()     // Catch:{ IOException -> 0x004c }
            byte r11 = (byte) r11     // Catch:{ IOException -> 0x004c }
            r5 = r11
            r11 = r5
            r12 = -1
            if (r11 == r12) goto L_0x006c
            java.nio.ByteBuffer r11 = fileBuffer     // Catch:{ IOException -> 0x004c }
            r12 = r5
            java.nio.ByteBuffer r11 = r11.put(r12)     // Catch:{ IOException -> 0x004c }
            goto L_0x0039
        L_0x004c:
            r11 = move-exception
            r2 = r11
        L_0x004e:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r15 = r11
            r11 = r15
            r12 = r15
            r12.<init>()
            java.lang.String r12 = "Failed to read the shader source file: "
            java.lang.StringBuilder r11 = r11.append(r12)
            r12 = r0
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r11 = r11.toString()
            r12 = r2
            org.lwjgl.test.opengl.shaders.ShadersTest.kill(r11, r12)
            r11 = r1
            r0 = r11
        L_0x006b:
            return r0
        L_0x006c:
            r11 = r4
            r11.close()     // Catch:{ IOException -> 0x004c }
            java.nio.ByteBuffer r11 = fileBuffer     // Catch:{ IOException -> 0x004c }
            java.nio.Buffer r11 = r11.flip()     // Catch:{ IOException -> 0x004c }
            java.nio.ByteBuffer r11 = fileBuffer     // Catch:{ IOException -> 0x004c }
            int r11 = r11.remaining()     // Catch:{ IOException -> 0x004c }
            byte[] r11 = new byte[r11]     // Catch:{ IOException -> 0x004c }
            r8 = r11
            java.nio.ByteBuffer r11 = fileBuffer     // Catch:{ IOException -> 0x004c }
            r12 = r8
            java.nio.ByteBuffer r11 = r11.get(r12)     // Catch:{ IOException -> 0x004c }
            java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x004c }
            r15 = r11
            r11 = r15
            r12 = r15
            r13 = r8
            r12.<init>(r13)     // Catch:{ IOException -> 0x004c }
            r10 = r11
            java.nio.ByteBuffer r11 = fileBuffer     // Catch:{ IOException -> 0x0099 }
            java.nio.Buffer r11 = r11.clear()     // Catch:{ IOException -> 0x0099 }
            r11 = r10
            r0 = r11
            goto L_0x006b
        L_0x0099:
            r11 = move-exception
            r2 = r11
            r11 = r10
            r1 = r11
            goto L_0x004e
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.test.opengl.shaders.Shader.getShaderText(java.lang.String):java.lang.String");
    }

    protected static int getUniformLocation(int i, String str) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        String str2 = str;
        int glGetUniformLocationARB = ARBShaderObjects.glGetUniformLocationARB(i, (CharSequence) str2);
        if (glGetUniformLocationARB != -1) {
            return glGetUniformLocationARB;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("The uniform \"").append(str2).append("\" does not exist in the Shader Program.").toString());
        throw illegalArgumentException2;
    }

    protected static void printShaderObjectInfoLog(String str, int i) {
        StringBuilder sb;
        String str2 = str;
        int i2 = i;
        int glGetObjectParameteriARB = ARBShaderObjects.glGetObjectParameteriARB(i2, 35716);
        if (glGetObjectParameteriARB > 1) {
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("\nInfo Log of Shader Object: ").append(str2).toString());
            System.out.println("--------------------------");
            System.out.println(ARBShaderObjects.glGetInfoLogARB(i2, glGetObjectParameteriARB));
        }
    }

    protected static void printShaderProgramInfoLog(int i) {
        int i2 = i;
        int glGetObjectParameteriARB = ARBShaderObjects.glGetObjectParameteriARB(i2, 35716);
        if (glGetObjectParameteriARB > 1) {
            System.out.println("\nShader Program Info Log: ");
            System.out.println("--------------------------");
            System.out.println(ARBShaderObjects.glGetInfoLogARB(i2, glGetObjectParameteriARB));
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract void cleanup();

    /* access modifiers changed from: 0000 */
    public abstract void render();
}
