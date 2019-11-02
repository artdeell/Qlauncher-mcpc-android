package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public class ARBProgram {
    public static final int GL_CURRENT_MATRIX_ARB = 34369;
    public static final int GL_CURRENT_MATRIX_STACK_DEPTH_ARB = 34368;
    public static final int GL_MATRIX0_ARB = 35008;
    public static final int GL_MATRIX10_ARB = 35018;
    public static final int GL_MATRIX11_ARB = 35019;
    public static final int GL_MATRIX12_ARB = 35020;
    public static final int GL_MATRIX13_ARB = 35021;
    public static final int GL_MATRIX14_ARB = 35022;
    public static final int GL_MATRIX15_ARB = 35023;
    public static final int GL_MATRIX16_ARB = 35024;
    public static final int GL_MATRIX17_ARB = 35025;
    public static final int GL_MATRIX18_ARB = 35026;
    public static final int GL_MATRIX19_ARB = 35027;
    public static final int GL_MATRIX1_ARB = 35009;
    public static final int GL_MATRIX20_ARB = 35028;
    public static final int GL_MATRIX21_ARB = 35029;
    public static final int GL_MATRIX22_ARB = 35030;
    public static final int GL_MATRIX23_ARB = 35031;
    public static final int GL_MATRIX24_ARB = 35032;
    public static final int GL_MATRIX25_ARB = 35033;
    public static final int GL_MATRIX26_ARB = 35034;
    public static final int GL_MATRIX27_ARB = 35035;
    public static final int GL_MATRIX28_ARB = 35036;
    public static final int GL_MATRIX29_ARB = 35037;
    public static final int GL_MATRIX2_ARB = 35010;
    public static final int GL_MATRIX30_ARB = 35038;
    public static final int GL_MATRIX31_ARB = 35039;
    public static final int GL_MATRIX3_ARB = 35011;
    public static final int GL_MATRIX4_ARB = 35012;
    public static final int GL_MATRIX5_ARB = 35013;
    public static final int GL_MATRIX6_ARB = 35014;
    public static final int GL_MATRIX7_ARB = 35015;
    public static final int GL_MATRIX8_ARB = 35016;
    public static final int GL_MATRIX9_ARB = 35017;
    public static final int GL_MAX_PROGRAM_ATTRIBS_ARB = 34989;
    public static final int GL_MAX_PROGRAM_ENV_PARAMETERS_ARB = 34997;
    public static final int GL_MAX_PROGRAM_INSTRUCTIONS_ARB = 34977;
    public static final int GL_MAX_PROGRAM_LOCAL_PARAMETERS_ARB = 34996;
    public static final int GL_MAX_PROGRAM_MATRICES_ARB = 34351;
    public static final int GL_MAX_PROGRAM_MATRIX_STACK_DEPTH_ARB = 34350;
    public static final int GL_MAX_PROGRAM_NATIVE_ATTRIBS_ARB = 34991;
    public static final int GL_MAX_PROGRAM_NATIVE_INSTRUCTIONS_ARB = 34979;
    public static final int GL_MAX_PROGRAM_NATIVE_PARAMETERS_ARB = 34987;
    public static final int GL_MAX_PROGRAM_NATIVE_TEMPORARIES_ARB = 34983;
    public static final int GL_MAX_PROGRAM_PARAMETERS_ARB = 34985;
    public static final int GL_MAX_PROGRAM_TEMPORARIES_ARB = 34981;
    public static final int GL_PROGRAM_ATTRIBS_ARB = 34988;
    public static final int GL_PROGRAM_BINDING_ARB = 34423;
    public static final int GL_PROGRAM_ERROR_POSITION_ARB = 34379;
    public static final int GL_PROGRAM_ERROR_STRING_ARB = 34932;
    public static final int GL_PROGRAM_FORMAT_ARB = 34934;
    public static final int GL_PROGRAM_FORMAT_ASCII_ARB = 34933;
    public static final int GL_PROGRAM_INSTRUCTIONS_ARB = 34976;
    public static final int GL_PROGRAM_LENGTH_ARB = 34343;
    public static final int GL_PROGRAM_NATIVE_ATTRIBS_ARB = 34990;
    public static final int GL_PROGRAM_NATIVE_INSTRUCTIONS_ARB = 34978;
    public static final int GL_PROGRAM_NATIVE_PARAMETERS_ARB = 34986;
    public static final int GL_PROGRAM_NATIVE_TEMPORARIES_ARB = 34982;
    public static final int GL_PROGRAM_PARAMETERS_ARB = 34984;
    public static final int GL_PROGRAM_STRING_ARB = 34344;
    public static final int GL_PROGRAM_TEMPORARIES_ARB = 34980;
    public static final int GL_PROGRAM_UNDER_NATIVE_LIMITS_ARB = 34998;
    public static final int GL_TRANSPOSE_CURRENT_MATRIX_ARB = 34999;

    public ARBProgram() {
    }

    public static void glBindProgramARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBindProgramARB;
        BufferChecks.checkFunctionAddress(j);
        nglBindProgramARB(i3, i4, j);
    }

    public static void glDeleteProgramsARB(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteProgramsARB;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteProgramsARB(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteProgramsARB(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteProgramsARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteProgramsARB(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGenProgramsARB() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenProgramsARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenProgramsARB(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenProgramsARB(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenProgramsARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenProgramsARB(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    @Deprecated
    public static int glGetProgramARB(int i, int i2) {
        return glGetProgramiARB(i, i2);
    }

    public static void glGetProgramARB(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetProgramivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetProgramivARB(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetProgramEnvParameterARB(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetProgramEnvParameterdvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglGetProgramEnvParameterdvARB(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetProgramEnvParameterARB(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetProgramEnvParameterfvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetProgramEnvParameterfvARB(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetProgramLocalParameterARB(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetProgramLocalParameterdvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglGetProgramLocalParameterdvARB(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetProgramLocalParameterARB(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetProgramLocalParameterfvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetProgramLocalParameterfvARB(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static String glGetProgramStringARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetProgramStringARB;
        BufferChecks.checkFunctionAddress(j);
        int glGetProgramiARB = glGetProgramiARB(i3, 34343);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, glGetProgramiARB);
        nglGetProgramStringARB(i3, i4, MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(glGetProgramiARB);
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetProgramStringARB(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetProgramStringARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetProgramStringARB(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetProgramiARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetProgramivARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetProgramivARB(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static boolean glIsProgramARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsProgramARB;
        BufferChecks.checkFunctionAddress(j);
        return nglIsProgramARB(i2, j);
    }

    public static void glProgramEnvParameter4ARB(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramEnvParameter4dvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglProgramEnvParameter4dvARB(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramEnvParameter4ARB(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramEnvParameter4fvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglProgramEnvParameter4fvARB(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramEnvParameter4dARB(int i, int i2, double d, double d2, double d3, double d4) {
        int i3 = i;
        int i4 = i2;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glProgramEnvParameter4dARB;
        BufferChecks.checkFunctionAddress(j);
        nglProgramEnvParameter4dARB(i3, i4, d5, d6, d7, d8, j);
    }

    public static void glProgramEnvParameter4fARB(int i, int i2, float f, float f2, float f3, float f4) {
        int i3 = i;
        int i4 = i2;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glProgramEnvParameter4fARB;
        BufferChecks.checkFunctionAddress(j);
        nglProgramEnvParameter4fARB(i3, i4, f5, f6, f7, f8, j);
    }

    public static void glProgramLocalParameter4ARB(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramLocalParameter4dvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglProgramLocalParameter4dvARB(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramLocalParameter4ARB(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramLocalParameter4fvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglProgramLocalParameter4fvARB(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramLocalParameter4dARB(int i, int i2, double d, double d2, double d3, double d4) {
        int i3 = i;
        int i4 = i2;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glProgramLocalParameter4dARB;
        BufferChecks.checkFunctionAddress(j);
        nglProgramLocalParameter4dARB(i3, i4, d5, d6, d7, d8, j);
    }

    public static void glProgramLocalParameter4fARB(int i, int i2, float f, float f2, float f3, float f4) {
        int i3 = i;
        int i4 = i2;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glProgramLocalParameter4fARB;
        BufferChecks.checkFunctionAddress(j);
        nglProgramLocalParameter4fARB(i3, i4, f5, f6, f7, f8, j);
    }

    public static void glProgramStringARB(int i, int i2, CharSequence charSequence) {
        int i3 = i;
        int i4 = i2;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glProgramStringARB;
        BufferChecks.checkFunctionAddress(j);
        nglProgramStringARB(i3, i4, charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), j);
    }

    public static void glProgramStringARB(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glProgramStringARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglProgramStringARB(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    static native void nglBindProgramARB(int i, int i2, long j);

    static native void nglDeleteProgramsARB(int i, long j, long j2);

    static native void nglGenProgramsARB(int i, long j, long j2);

    static native void nglGetProgramEnvParameterdvARB(int i, int i2, long j, long j2);

    static native void nglGetProgramEnvParameterfvARB(int i, int i2, long j, long j2);

    static native void nglGetProgramLocalParameterdvARB(int i, int i2, long j, long j2);

    static native void nglGetProgramLocalParameterfvARB(int i, int i2, long j, long j2);

    static native void nglGetProgramStringARB(int i, int i2, long j, long j2);

    static native void nglGetProgramivARB(int i, int i2, long j, long j2);

    static native boolean nglIsProgramARB(int i, long j);

    static native void nglProgramEnvParameter4dARB(int i, int i2, double d, double d2, double d3, double d4, long j);

    static native void nglProgramEnvParameter4dvARB(int i, int i2, long j, long j2);

    static native void nglProgramEnvParameter4fARB(int i, int i2, float f, float f2, float f3, float f4, long j);

    static native void nglProgramEnvParameter4fvARB(int i, int i2, long j, long j2);

    static native void nglProgramLocalParameter4dARB(int i, int i2, double d, double d2, double d3, double d4, long j);

    static native void nglProgramLocalParameter4dvARB(int i, int i2, long j, long j2);

    static native void nglProgramLocalParameter4fARB(int i, int i2, float f, float f2, float f3, float f4, long j);

    static native void nglProgramLocalParameter4fvARB(int i, int i2, long j, long j2);

    static native void nglProgramStringARB(int i, int i2, int i3, long j, long j2);
}
