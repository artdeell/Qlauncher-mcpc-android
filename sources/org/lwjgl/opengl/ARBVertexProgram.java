package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ARBVertexProgram extends ARBProgram {
    public static final int GL_COLOR_SUM_ARB = 33880;
    public static final int GL_CURRENT_VERTEX_ATTRIB_ARB = 34342;
    public static final int GL_MAX_PROGRAM_ADDRESS_REGISTERS_ARB = 34993;
    public static final int GL_MAX_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB = 34995;
    public static final int GL_MAX_VERTEX_ATTRIBS_ARB = 34921;
    public static final int GL_PROGRAM_ADDRESS_REGISTERS_ARB = 34992;
    public static final int GL_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB = 34994;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB = 34338;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB = 34922;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER_ARB = 34373;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB = 34339;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB = 34340;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE_ARB = 34341;
    public static final int GL_VERTEX_PROGRAM_ARB = 34336;
    public static final int GL_VERTEX_PROGRAM_POINT_SIZE_ARB = 34370;
    public static final int GL_VERTEX_PROGRAM_TWO_SIDE_ARB = 34371;

    private ARBVertexProgram() {
    }

    public static void glDisableVertexAttribArrayARB(int i) {
        ARBVertexShader.glDisableVertexAttribArrayARB(i);
    }

    public static void glEnableVertexAttribArrayARB(int i) {
        ARBVertexShader.glEnableVertexAttribArrayARB(i);
    }

    public static void glGetVertexAttribARB(int i, int i2, DoubleBuffer doubleBuffer) {
        ARBVertexShader.glGetVertexAttribARB(i, i2, doubleBuffer);
    }

    public static void glGetVertexAttribARB(int i, int i2, FloatBuffer floatBuffer) {
        ARBVertexShader.glGetVertexAttribARB(i, i2, floatBuffer);
    }

    public static void glGetVertexAttribARB(int i, int i2, IntBuffer intBuffer) {
        ARBVertexShader.glGetVertexAttribARB(i, i2, intBuffer);
    }

    public static ByteBuffer glGetVertexAttribPointerARB(int i, int i2, long j) {
        return ARBVertexShader.glGetVertexAttribPointerARB(i, i2, j);
    }

    public static void glVertexAttrib1dARB(int i, double d) {
        ARBVertexShader.glVertexAttrib1dARB(i, d);
    }

    public static void glVertexAttrib1fARB(int i, float f) {
        ARBVertexShader.glVertexAttrib1fARB(i, f);
    }

    public static void glVertexAttrib1sARB(int i, short s) {
        ARBVertexShader.glVertexAttrib1sARB(i, s);
    }

    public static void glVertexAttrib2dARB(int i, double d, double d2) {
        ARBVertexShader.glVertexAttrib2dARB(i, d, d2);
    }

    public static void glVertexAttrib2fARB(int i, float f, float f2) {
        ARBVertexShader.glVertexAttrib2fARB(i, f, f2);
    }

    public static void glVertexAttrib2sARB(int i, short s, short s2) {
        ARBVertexShader.glVertexAttrib2sARB(i, s, s2);
    }

    public static void glVertexAttrib3dARB(int i, double d, double d2, double d3) {
        ARBVertexShader.glVertexAttrib3dARB(i, d, d2, d3);
    }

    public static void glVertexAttrib3fARB(int i, float f, float f2, float f3) {
        ARBVertexShader.glVertexAttrib3fARB(i, f, f2, f3);
    }

    public static void glVertexAttrib3sARB(int i, short s, short s2, short s3) {
        ARBVertexShader.glVertexAttrib3sARB(i, s, s2, s3);
    }

    public static void glVertexAttrib4NubARB(int i, byte b, byte b2, byte b3, byte b4) {
        ARBVertexShader.glVertexAttrib4NubARB(i, b, b2, b3, b4);
    }

    public static void glVertexAttrib4dARB(int i, double d, double d2, double d3, double d4) {
        ARBVertexShader.glVertexAttrib4dARB(i, d, d2, d3, d4);
    }

    public static void glVertexAttrib4fARB(int i, float f, float f2, float f3, float f4) {
        ARBVertexShader.glVertexAttrib4fARB(i, f, f2, f3, f4);
    }

    public static void glVertexAttrib4sARB(int i, short s, short s2, short s3, short s4) {
        ARBVertexShader.glVertexAttrib4sARB(i, s, s2, s3, s4);
    }

    public static void glVertexAttribPointerARB(int i, int i2, int i3, boolean z, int i4, long j) {
        ARBVertexShader.glVertexAttribPointerARB(i, i2, i3, z, i4, j);
    }

    public static void glVertexAttribPointerARB(int i, int i2, boolean z, int i3, DoubleBuffer doubleBuffer) {
        ARBVertexShader.glVertexAttribPointerARB(i, i2, z, i3, doubleBuffer);
    }

    public static void glVertexAttribPointerARB(int i, int i2, boolean z, int i3, FloatBuffer floatBuffer) {
        ARBVertexShader.glVertexAttribPointerARB(i, i2, z, i3, floatBuffer);
    }

    public static void glVertexAttribPointerARB(int i, int i2, boolean z, boolean z2, int i3, ByteBuffer byteBuffer) {
        ARBVertexShader.glVertexAttribPointerARB(i, i2, z, z2, i3, byteBuffer);
    }

    public static void glVertexAttribPointerARB(int i, int i2, boolean z, boolean z2, int i3, IntBuffer intBuffer) {
        ARBVertexShader.glVertexAttribPointerARB(i, i2, z, z2, i3, intBuffer);
    }

    public static void glVertexAttribPointerARB(int i, int i2, boolean z, boolean z2, int i3, ShortBuffer shortBuffer) {
        ARBVertexShader.glVertexAttribPointerARB(i, i2, z, z2, i3, shortBuffer);
    }
}
