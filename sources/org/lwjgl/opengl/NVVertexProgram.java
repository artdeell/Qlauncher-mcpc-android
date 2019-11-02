package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class NVVertexProgram extends NVProgram {
    public static final int GL_ATTRIB_ARRAY_POINTER_NV = 34373;
    public static final int GL_ATTRIB_ARRAY_SIZE_NV = 34339;
    public static final int GL_ATTRIB_ARRAY_STRIDE_NV = 34340;
    public static final int GL_ATTRIB_ARRAY_TYPE_NV = 34341;
    public static final int GL_CURRENT_ATTRIB_NV = 34342;
    public static final int GL_CURRENT_MATRIX_NV = 34369;
    public static final int GL_CURRENT_MATRIX_STACK_DEPTH_NV = 34368;
    public static final int GL_IDENTITY_NV = 34346;
    public static final int GL_INVERSE_NV = 34347;
    public static final int GL_INVERSE_TRANSPOSE_NV = 34349;
    public static final int GL_MAP1_VERTEX_ATTRIB0_4_NV = 34400;
    public static final int GL_MAP1_VERTEX_ATTRIB10_4_NV = 34410;
    public static final int GL_MAP1_VERTEX_ATTRIB11_4_NV = 34411;
    public static final int GL_MAP1_VERTEX_ATTRIB12_4_NV = 34412;
    public static final int GL_MAP1_VERTEX_ATTRIB13_4_NV = 34413;
    public static final int GL_MAP1_VERTEX_ATTRIB14_4_NV = 34414;
    public static final int GL_MAP1_VERTEX_ATTRIB15_4_NV = 34415;
    public static final int GL_MAP1_VERTEX_ATTRIB1_4_NV = 34401;
    public static final int GL_MAP1_VERTEX_ATTRIB2_4_NV = 34402;
    public static final int GL_MAP1_VERTEX_ATTRIB3_4_NV = 34403;
    public static final int GL_MAP1_VERTEX_ATTRIB4_4_NV = 34404;
    public static final int GL_MAP1_VERTEX_ATTRIB5_4_NV = 34405;
    public static final int GL_MAP1_VERTEX_ATTRIB6_4_NV = 34406;
    public static final int GL_MAP1_VERTEX_ATTRIB7_4_NV = 34407;
    public static final int GL_MAP1_VERTEX_ATTRIB8_4_NV = 34408;
    public static final int GL_MAP1_VERTEX_ATTRIB9_4_NV = 34409;
    public static final int GL_MAP2_VERTEX_ATTRIB0_4_NV = 34416;
    public static final int GL_MAP2_VERTEX_ATTRIB10_4_NV = 34426;
    public static final int GL_MAP2_VERTEX_ATTRIB11_4_NV = 34427;
    public static final int GL_MAP2_VERTEX_ATTRIB12_4_NV = 34428;
    public static final int GL_MAP2_VERTEX_ATTRIB13_4_NV = 34429;
    public static final int GL_MAP2_VERTEX_ATTRIB14_4_NV = 34430;
    public static final int GL_MAP2_VERTEX_ATTRIB15_4_NV = 34431;
    public static final int GL_MAP2_VERTEX_ATTRIB1_4_NV = 34417;
    public static final int GL_MAP2_VERTEX_ATTRIB2_4_NV = 34418;
    public static final int GL_MAP2_VERTEX_ATTRIB3_4_NV = 34419;
    public static final int GL_MAP2_VERTEX_ATTRIB4_4_NV = 34420;
    public static final int GL_MAP2_VERTEX_ATTRIB5_4_NV = 34421;
    public static final int GL_MAP2_VERTEX_ATTRIB6_4_NV = 34422;
    public static final int GL_MAP2_VERTEX_ATTRIB7_4_NV = 34423;
    public static final int GL_MAP2_VERTEX_ATTRIB8_4_NV = 34424;
    public static final int GL_MAP2_VERTEX_ATTRIB9_4_NV = 34425;
    public static final int GL_MATRIX0_NV = 34352;
    public static final int GL_MATRIX1_NV = 34353;
    public static final int GL_MATRIX2_NV = 34354;
    public static final int GL_MATRIX3_NV = 34355;
    public static final int GL_MATRIX4_NV = 34356;
    public static final int GL_MATRIX5_NV = 34357;
    public static final int GL_MATRIX6_NV = 34358;
    public static final int GL_MATRIX7_NV = 34359;
    public static final int GL_MAX_TRACK_MATRICES_NV = 34351;
    public static final int GL_MAX_TRACK_MATRIX_STACK_DEPTH_NV = 34350;
    public static final int GL_MODELVIEW_PROJECTION_NV = 34345;
    public static final int GL_PROGRAM_PARAMETER_NV = 34372;
    public static final int GL_TRACK_MATRIX_NV = 34376;
    public static final int GL_TRACK_MATRIX_TRANSFORM_NV = 34377;
    public static final int GL_TRANSPOSE_NV = 34348;
    public static final int GL_VERTEX_ATTRIB_ARRAY0_NV = 34384;
    public static final int GL_VERTEX_ATTRIB_ARRAY10_NV = 34394;
    public static final int GL_VERTEX_ATTRIB_ARRAY11_NV = 34395;
    public static final int GL_VERTEX_ATTRIB_ARRAY12_NV = 34396;
    public static final int GL_VERTEX_ATTRIB_ARRAY13_NV = 34397;
    public static final int GL_VERTEX_ATTRIB_ARRAY14_NV = 34398;
    public static final int GL_VERTEX_ATTRIB_ARRAY15_NV = 34399;
    public static final int GL_VERTEX_ATTRIB_ARRAY1_NV = 34385;
    public static final int GL_VERTEX_ATTRIB_ARRAY2_NV = 34386;
    public static final int GL_VERTEX_ATTRIB_ARRAY3_NV = 34387;
    public static final int GL_VERTEX_ATTRIB_ARRAY4_NV = 34388;
    public static final int GL_VERTEX_ATTRIB_ARRAY5_NV = 34389;
    public static final int GL_VERTEX_ATTRIB_ARRAY6_NV = 34390;
    public static final int GL_VERTEX_ATTRIB_ARRAY7_NV = 34391;
    public static final int GL_VERTEX_ATTRIB_ARRAY8_NV = 34392;
    public static final int GL_VERTEX_ATTRIB_ARRAY9_NV = 34393;
    public static final int GL_VERTEX_PROGRAM_BINDING_NV = 34378;
    public static final int GL_VERTEX_PROGRAM_NV = 34336;
    public static final int GL_VERTEX_PROGRAM_POINT_SIZE_NV = 34370;
    public static final int GL_VERTEX_PROGRAM_TWO_SIDE_NV = 34371;
    public static final int GL_VERTEX_STATE_PROGRAM_NV = 34337;

    private NVVertexProgram() {
    }

    public static void glExecuteProgramNV(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glExecuteProgramNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglExecuteProgramNV(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetProgramParameterNV(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetProgramParameterdvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglGetProgramParameterdvNV(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetProgramParameterNV(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetProgramParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetProgramParameterfvNV(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetTrackMatrixNV(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTrackMatrixivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetTrackMatrixivNV(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetVertexAttribNV(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribdvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglGetVertexAttribdvNV(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetVertexAttribNV(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetVertexAttribfvNV(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetVertexAttribNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetVertexAttribivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static ByteBuffer glGetVertexAttribPointerNV(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glGetVertexAttribPointervNV;
        BufferChecks.checkFunctionAddress(j3);
        ByteBuffer nglGetVertexAttribPointervNV = nglGetVertexAttribPointervNV(i3, i4, j2, j3);
        if (!LWJGLUtil.CHECKS || nglGetVertexAttribPointervNV != null) {
            return nglGetVertexAttribPointervNV.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static void glProgramParameter4dNV(int i, int i2, double d, double d2, double d3, double d4) {
        int i3 = i;
        int i4 = i2;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glProgramParameter4dNV;
        BufferChecks.checkFunctionAddress(j);
        nglProgramParameter4dNV(i3, i4, d5, d6, d7, d8, j);
    }

    public static void glProgramParameter4fNV(int i, int i2, float f, float f2, float f3, float f4) {
        int i3 = i;
        int i4 = i2;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glProgramParameter4fNV;
        BufferChecks.checkFunctionAddress(j);
        nglProgramParameter4fNV(i3, i4, f5, f6, f7, f8, j);
    }

    public static void glProgramParameters4NV(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramParameters4dvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramParameters4dvNV(i3, i4, doubleBuffer2.remaining() >> 2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramParameters4NV(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramParameters4fvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramParameters4fvNV(i3, i4, floatBuffer2.remaining() >> 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glTrackMatrixNV(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glTrackMatrixNV;
        BufferChecks.checkFunctionAddress(j);
        nglTrackMatrixNV(i5, i6, i7, i8, j);
    }

    public static void glVertexAttrib1dNV(int i, double d) {
        int i2 = i;
        double d2 = d;
        long j = GLContext.getCapabilities().glVertexAttrib1dNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib1dNV(i2, d2, j);
    }

    public static void glVertexAttrib1fNV(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glVertexAttrib1fNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib1fNV(i2, f2, j);
    }

    public static void glVertexAttrib1sNV(int i, short s) {
        int i2 = i;
        short s2 = s;
        long j = GLContext.getCapabilities().glVertexAttrib1sNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib1sNV(i2, s2, j);
    }

    public static void glVertexAttrib2dNV(int i, double d, double d2) {
        int i2 = i;
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glVertexAttrib2dNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib2dNV(i2, d3, d4, j);
    }

    public static void glVertexAttrib2fNV(int i, float f, float f2) {
        int i2 = i;
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glVertexAttrib2fNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib2fNV(i2, f3, f4, j);
    }

    public static void glVertexAttrib2sNV(int i, short s, short s2) {
        int i2 = i;
        short s3 = s;
        short s4 = s2;
        long j = GLContext.getCapabilities().glVertexAttrib2sNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib2sNV(i2, s3, s4, j);
    }

    public static void glVertexAttrib3dNV(int i, double d, double d2, double d3) {
        int i2 = i;
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glVertexAttrib3dNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib3dNV(i2, d4, d5, d6, j);
    }

    public static void glVertexAttrib3fNV(int i, float f, float f2, float f3) {
        int i2 = i;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glVertexAttrib3fNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib3fNV(i2, f4, f5, f6, j);
    }

    public static void glVertexAttrib3sNV(int i, short s, short s2, short s3) {
        int i2 = i;
        short s4 = s;
        short s5 = s2;
        short s6 = s3;
        long j = GLContext.getCapabilities().glVertexAttrib3sNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib3sNV(i2, s4, s5, s6, j);
    }

    public static void glVertexAttrib4dNV(int i, double d, double d2, double d3, double d4) {
        int i2 = i;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glVertexAttrib4dNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib4dNV(i2, d5, d6, d7, d8, j);
    }

    public static void glVertexAttrib4fNV(int i, float f, float f2, float f3, float f4) {
        int i2 = i;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glVertexAttrib4fNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib4fNV(i2, f5, f6, f7, f8, j);
    }

    public static void glVertexAttrib4sNV(int i, short s, short s2, short s3, short s4) {
        int i2 = i;
        short s5 = s;
        short s6 = s2;
        short s7 = s3;
        short s8 = s4;
        long j = GLContext.getCapabilities().glVertexAttrib4sNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib4sNV(i2, s5, s6, s7, s8, j);
    }

    public static void glVertexAttrib4ubNV(int i, byte b, byte b2, byte b3, byte b4) {
        int i2 = i;
        byte b5 = b;
        byte b6 = b2;
        byte b7 = b3;
        byte b8 = b4;
        long j = GLContext.getCapabilities().glVertexAttrib4ubNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib4ubNV(i2, b5, b6, b7, b8, j);
    }

    public static void glVertexAttribPointerNV(int i, int i2, int i3, int i4, long j) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glVertexAttribPointerNV;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglVertexAttribPointerNVBO(i5, i6, i7, i8, j2, j3);
    }

    public static void glVertexAttribPointerNV(int i, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointerNV;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i5] = byteBuffer2;
        }
        nglVertexAttribPointerNV(i5, i6, i7, i8, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexAttribPointerNV(int i, int i2, int i3, int i4, DoubleBuffer doubleBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointerNV;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i5] = doubleBuffer2;
        }
        nglVertexAttribPointerNV(i5, i6, i7, i8, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribPointerNV(int i, int i2, int i3, int i4, FloatBuffer floatBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointerNV;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i5] = floatBuffer2;
        }
        nglVertexAttribPointerNV(i5, i6, i7, i8, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glVertexAttribPointerNV(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointerNV;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i5] = intBuffer2;
        }
        nglVertexAttribPointerNV(i5, i6, i7, i8, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribPointerNV(int i, int i2, int i3, int i4, ShortBuffer shortBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointerNV;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i5] = shortBuffer2;
        }
        nglVertexAttribPointerNV(i5, i6, i7, i8, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glVertexAttribs1NV(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs1dvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglVertexAttribs1dvNV(i2, doubleBuffer2.remaining(), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribs1NV(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs1fvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglVertexAttribs1fvNV(i2, floatBuffer2.remaining(), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glVertexAttribs1NV(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs1svNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglVertexAttribs1svNV(i2, shortBuffer2.remaining(), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glVertexAttribs2NV(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs2dvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglVertexAttribs2dvNV(i2, doubleBuffer2.remaining() >> 1, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribs2NV(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs2fvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglVertexAttribs2fvNV(i2, floatBuffer2.remaining() >> 1, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glVertexAttribs2NV(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs2svNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglVertexAttribs2svNV(i2, shortBuffer2.remaining() >> 1, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glVertexAttribs3NV(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs3dvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglVertexAttribs3dvNV(i2, doubleBuffer2.remaining() / 3, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribs3NV(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs3fvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglVertexAttribs3fvNV(i2, floatBuffer2.remaining() / 3, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glVertexAttribs3NV(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs3svNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglVertexAttribs3svNV(i2, shortBuffer2.remaining() / 3, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glVertexAttribs4NV(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs4dvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglVertexAttribs4dvNV(i2, doubleBuffer2.remaining() >> 2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribs4NV(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs4fvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglVertexAttribs4fvNV(i2, floatBuffer2.remaining() >> 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glVertexAttribs4NV(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs4svNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglVertexAttribs4svNV(i2, shortBuffer2.remaining() >> 2, MemoryUtil.getAddress(shortBuffer2), j);
    }

    static native void nglExecuteProgramNV(int i, int i2, long j, long j2);

    static native void nglGetProgramParameterdvNV(int i, int i2, int i3, long j, long j2);

    static native void nglGetProgramParameterfvNV(int i, int i2, int i3, long j, long j2);

    static native void nglGetTrackMatrixivNV(int i, int i2, int i3, long j, long j2);

    static native ByteBuffer nglGetVertexAttribPointervNV(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribdvNV(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribfvNV(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribivNV(int i, int i2, long j, long j2);

    static native void nglProgramParameter4dNV(int i, int i2, double d, double d2, double d3, double d4, long j);

    static native void nglProgramParameter4fNV(int i, int i2, float f, float f2, float f3, float f4, long j);

    static native void nglProgramParameters4dvNV(int i, int i2, int i3, long j, long j2);

    static native void nglProgramParameters4fvNV(int i, int i2, int i3, long j, long j2);

    static native void nglTrackMatrixNV(int i, int i2, int i3, int i4, long j);

    static native void nglVertexAttrib1dNV(int i, double d, long j);

    static native void nglVertexAttrib1fNV(int i, float f, long j);

    static native void nglVertexAttrib1sNV(int i, short s, long j);

    static native void nglVertexAttrib2dNV(int i, double d, double d2, long j);

    static native void nglVertexAttrib2fNV(int i, float f, float f2, long j);

    static native void nglVertexAttrib2sNV(int i, short s, short s2, long j);

    static native void nglVertexAttrib3dNV(int i, double d, double d2, double d3, long j);

    static native void nglVertexAttrib3fNV(int i, float f, float f2, float f3, long j);

    static native void nglVertexAttrib3sNV(int i, short s, short s2, short s3, long j);

    static native void nglVertexAttrib4dNV(int i, double d, double d2, double d3, double d4, long j);

    static native void nglVertexAttrib4fNV(int i, float f, float f2, float f3, float f4, long j);

    static native void nglVertexAttrib4sNV(int i, short s, short s2, short s3, short s4, long j);

    static native void nglVertexAttrib4ubNV(int i, byte b, byte b2, byte b3, byte b4, long j);

    static native void nglVertexAttribPointerNV(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglVertexAttribPointerNVBO(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglVertexAttribs1dvNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribs1fvNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribs1svNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribs2dvNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribs2fvNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribs2svNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribs3dvNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribs3fvNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribs3svNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribs4dvNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribs4fvNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribs4svNV(int i, int i2, long j, long j2);
}
