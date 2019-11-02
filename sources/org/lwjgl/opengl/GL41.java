package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class GL41 {
    public static final int GL_ACTIVE_PROGRAM = 33369;
    public static final int GL_ALL_SHADER_BITS = -1;
    public static final int GL_DEPTH_RANGE = 2928;
    public static final int GL_DOUBLE_MAT2 = 36678;
    public static final int GL_DOUBLE_MAT2x3 = 36681;
    public static final int GL_DOUBLE_MAT2x4 = 36682;
    public static final int GL_DOUBLE_MAT3 = 36679;
    public static final int GL_DOUBLE_MAT3x2 = 36683;
    public static final int GL_DOUBLE_MAT3x4 = 36684;
    public static final int GL_DOUBLE_MAT4 = 36680;
    public static final int GL_DOUBLE_MAT4x2 = 36685;
    public static final int GL_DOUBLE_MAT4x3 = 36686;
    public static final int GL_DOUBLE_VEC2 = 36860;
    public static final int GL_DOUBLE_VEC3 = 36861;
    public static final int GL_DOUBLE_VEC4 = 36862;
    public static final int GL_FIRST_VERTEX_CONVENTION = 36429;
    public static final int GL_FIXED = 5132;
    public static final int GL_FRAGMENT_SHADER_BIT = 2;
    public static final int GL_GEOMETRY_SHADER_BIT = 4;
    public static final int GL_HIGH_FLOAT = 36338;
    public static final int GL_HIGH_INT = 36341;
    public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT = 35739;
    public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE = 35738;
    public static final int GL_LAST_VERTEX_CONVENTION = 36430;
    public static final int GL_LAYER_PROVOKING_VERTEX = 33374;
    public static final int GL_LOW_FLOAT = 36336;
    public static final int GL_LOW_INT = 36339;
    public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS = 36349;
    public static final int GL_MAX_VARYING_VECTORS = 36348;
    public static final int GL_MAX_VERTEX_UNIFORM_VECTORS = 36347;
    public static final int GL_MAX_VIEWPORTS = 33371;
    public static final int GL_MEDIUM_FLOAT = 36337;
    public static final int GL_MEDIUM_INT = 36340;
    public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 34814;
    public static final int GL_NUM_SHADER_BINARY_FORMATS = 36345;
    public static final int GL_PROGRAM_BINARY_FORMATS = 34815;
    public static final int GL_PROGRAM_BINARY_LENGTH = 34625;
    public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 33367;
    public static final int GL_PROGRAM_PIPELINE_BINDING = 33370;
    public static final int GL_PROGRAM_SEPARABLE = 33368;
    public static final int GL_PROVOKING_VERTEX = 36431;
    public static final int GL_RGB565 = 36194;
    public static final int GL_SCISSOR_BOX = 3088;
    public static final int GL_SCISSOR_TEST = 3089;
    public static final int GL_SHADER_COMPILER = 36346;
    public static final int GL_TESS_CONTROL_SHADER_BIT = 8;
    public static final int GL_TESS_EVALUATION_SHADER_BIT = 16;
    public static final int GL_UNDEFINED_VERTEX = 33376;
    public static final int GL_VERTEX_SHADER_BIT = 1;
    public static final int GL_VIEWPORT = 2978;
    public static final int GL_VIEWPORT_BOUNDS_RANGE = 33373;
    public static final int GL_VIEWPORT_INDEX_PROVOKING_VERTEX = 33375;
    public static final int GL_VIEWPORT_SUBPIXEL_BITS = 33372;

    private GL41() {
    }

    public static void glActiveShaderProgram(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glActiveShaderProgram;
        BufferChecks.checkFunctionAddress(j);
        nglActiveShaderProgram(i3, i4, j);
    }

    public static void glBindProgramPipeline(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glBindProgramPipeline;
        BufferChecks.checkFunctionAddress(j);
        nglBindProgramPipeline(i2, j);
    }

    public static void glClearDepthf(float f) {
        float f2 = f;
        long j = GLContext.getCapabilities().glClearDepthf;
        BufferChecks.checkFunctionAddress(j);
        nglClearDepthf(f2, j);
    }

    public static int glCreateShaderProgram(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glCreateShaderProgramv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2, i4);
        return nglCreateShaderProgramv2(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glCreateShaderProgram(int i, CharSequence charSequence) {
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCreateShaderProgramv;
        BufferChecks.checkFunctionAddress(j);
        return nglCreateShaderProgramv(i2, 1, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glCreateShaderProgram(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glCreateShaderProgramv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglCreateShaderProgramv(i2, 1, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glCreateShaderProgram(int i, CharSequence[] charSequenceArr) {
        int i2 = i;
        CharSequence[] charSequenceArr2 = charSequenceArr;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCreateShaderProgramv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkArray(charSequenceArr2);
        return nglCreateShaderProgramv2(i2, charSequenceArr2.length, APIUtil.getBufferNT(capabilities, charSequenceArr2), j);
    }

    public static int glCreateShaderProgram(int i, ByteBuffer[] byteBufferArr) {
        int i2 = i;
        ByteBuffer[] byteBufferArr2 = byteBufferArr;
        long j = GLContext.getCapabilities().glCreateShaderProgramv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkArray((Object[]) byteBufferArr2, 1);
        return nglCreateShaderProgramv3(i2, byteBufferArr2.length, byteBufferArr2, j);
    }

    public static void glDeleteProgramPipelines(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteProgramPipelines;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteProgramPipelines(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteProgramPipelines(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteProgramPipelines;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteProgramPipelines(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDepthRangeArray(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glDepthRangeArrayv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglDepthRangeArrayv(i2, doubleBuffer2.remaining() >> 1, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glDepthRangeIndexed(int i, double d, double d2) {
        int i2 = i;
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glDepthRangeIndexed;
        BufferChecks.checkFunctionAddress(j);
        nglDepthRangeIndexed(i2, d3, d4, j);
    }

    public static void glDepthRangef(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glDepthRangef;
        BufferChecks.checkFunctionAddress(j);
        nglDepthRangef(f3, f4, j);
    }

    public static int glGenProgramPipelines() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenProgramPipelines;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenProgramPipelines(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenProgramPipelines(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenProgramPipelines;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenProgramPipelines(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static double glGetDouble(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetDoublei_v;
        BufferChecks.checkFunctionAddress(j);
        DoubleBuffer bufferDouble = APIUtil.getBufferDouble(capabilities);
        nglGetDoublei_v(i3, i4, MemoryUtil.getAddress(bufferDouble), j);
        return bufferDouble.get(0);
    }

    public static void glGetDouble(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetDoublei_v;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetDoublei_v(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static float glGetFloat(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetFloati_v;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetFloati_v(i3, i4, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static void glGetFloat(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetFloati_v;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetFloati_v(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetProgramBinary(int i, IntBuffer intBuffer, IntBuffer intBuffer2, ByteBuffer byteBuffer) {
        int i2 = i;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetProgramBinary;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer3 != null) {
            BufferChecks.checkBuffer(intBuffer3, 1);
        }
        BufferChecks.checkBuffer(intBuffer4, 1);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetProgramBinary(i2, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer3), MemoryUtil.getAddress(intBuffer4), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetProgramPipeline(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetProgramPipelineiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetProgramPipelineiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static String glGetProgramPipelineInfoLog(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetProgramPipelineInfoLog;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i4);
        nglGetProgramPipelineInfoLog(i3, i4, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetProgramPipelineInfoLog(int i, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetProgramPipelineInfoLog;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        BufferChecks.checkDirect(byteBuffer2);
        nglGetProgramPipelineInfoLog(i2, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetProgramPipelinei(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetProgramPipelineiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetProgramPipelineiv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetShaderPrecisionFormat(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = GLContext.getCapabilities().glGetShaderPrecisionFormat;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer3, 2);
        BufferChecks.checkBuffer(intBuffer4, 1);
        nglGetShaderPrecisionFormat(i3, i4, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetVertexAttribL(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribLdv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglGetVertexAttribLdv(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static boolean glIsProgramPipeline(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsProgramPipeline;
        BufferChecks.checkFunctionAddress(j);
        return nglIsProgramPipeline(i2, j);
    }

    public static void glProgramBinary(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glProgramBinary;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglProgramBinary(i3, i4, MemoryUtil.getAddress(byteBuffer2), byteBuffer2.remaining(), j);
    }

    public static void glProgramParameteri(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glProgramParameteri;
        BufferChecks.checkFunctionAddress(j);
        nglProgramParameteri(i4, i5, i6, j);
    }

    public static void glProgramUniform1(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniform1dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniform1dv(i3, i4, doubleBuffer2.remaining(), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniform1(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniform1fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniform1fv(i3, i4, floatBuffer2.remaining(), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniform1(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform1iv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform1iv(i3, i4, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform1d(int i, int i2, double d) {
        int i3 = i;
        int i4 = i2;
        double d2 = d;
        long j = GLContext.getCapabilities().glProgramUniform1d;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform1d(i3, i4, d2, j);
    }

    public static void glProgramUniform1f(int i, int i2, float f) {
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        long j = GLContext.getCapabilities().glProgramUniform1f;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform1f(i3, i4, f2, j);
    }

    public static void glProgramUniform1i(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glProgramUniform1i;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform1i(i4, i5, i6, j);
    }

    public static void glProgramUniform1u(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform1uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform1uiv(i3, i4, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform1ui(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glProgramUniform1ui;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform1ui(i4, i5, i6, j);
    }

    public static void glProgramUniform2(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniform2dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniform2dv(i3, i4, doubleBuffer2.remaining() >> 1, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniform2(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniform2fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniform2fv(i3, i4, floatBuffer2.remaining() >> 1, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniform2(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform2iv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform2iv(i3, i4, intBuffer2.remaining() >> 1, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform2d(int i, int i2, double d, double d2) {
        int i3 = i;
        int i4 = i2;
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glProgramUniform2d;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform2d(i3, i4, d3, d4, j);
    }

    public static void glProgramUniform2f(int i, int i2, float f, float f2) {
        int i3 = i;
        int i4 = i2;
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glProgramUniform2f;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform2f(i3, i4, f3, f4, j);
    }

    public static void glProgramUniform2i(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glProgramUniform2i;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform2i(i5, i6, i7, i8, j);
    }

    public static void glProgramUniform2u(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform2uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform2uiv(i3, i4, intBuffer2.remaining() >> 1, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform2ui(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glProgramUniform2ui;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform2ui(i5, i6, i7, i8, j);
    }

    public static void glProgramUniform3(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniform3dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniform3dv(i3, i4, doubleBuffer2.remaining() / 3, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniform3(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniform3fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniform3fv(i3, i4, floatBuffer2.remaining() / 3, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniform3(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform3iv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform3iv(i3, i4, intBuffer2.remaining() / 3, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform3d(int i, int i2, double d, double d2, double d3) {
        int i3 = i;
        int i4 = i2;
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glProgramUniform3d;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform3d(i3, i4, d4, d5, d6, j);
    }

    public static void glProgramUniform3f(int i, int i2, float f, float f2, float f3) {
        int i3 = i;
        int i4 = i2;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glProgramUniform3f;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform3f(i3, i4, f4, f5, f6, j);
    }

    public static void glProgramUniform3i(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glProgramUniform3i;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform3i(i6, i7, i8, i9, i10, j);
    }

    public static void glProgramUniform3u(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform3uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform3uiv(i3, i4, intBuffer2.remaining() / 3, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform3ui(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glProgramUniform3ui;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform3ui(i6, i7, i8, i9, i10, j);
    }

    public static void glProgramUniform4(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniform4dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniform4dv(i3, i4, doubleBuffer2.remaining() >> 2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniform4(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniform4fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniform4fv(i3, i4, floatBuffer2.remaining() >> 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniform4(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform4iv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform4iv(i3, i4, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform4d(int i, int i2, double d, double d2, double d3, double d4) {
        int i3 = i;
        int i4 = i2;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glProgramUniform4d;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform4d(i3, i4, d5, d6, d7, d8, j);
    }

    public static void glProgramUniform4f(int i, int i2, float f, float f2, float f3, float f4) {
        int i3 = i;
        int i4 = i2;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glProgramUniform4f;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform4f(i3, i4, f5, f6, f7, f8, j);
    }

    public static void glProgramUniform4i(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glProgramUniform4i;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform4i(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glProgramUniform4u(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform4uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform4uiv(i3, i4, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform4ui(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glProgramUniform4ui;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform4ui(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glProgramUniformMatrix2(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix2dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix2dv(i3, i4, doubleBuffer2.remaining() >> 2, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix2(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix2fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix2fv(i3, i4, floatBuffer2.remaining() >> 2, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix2x3(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix2x3dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix2x3dv(i3, i4, doubleBuffer2.remaining() / 6, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix2x3(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix2x3fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix2x3fv(i3, i4, floatBuffer2.remaining() / 6, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix2x4(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix2x4dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix2x4dv(i3, i4, doubleBuffer2.remaining() >> 3, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix2x4(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix2x4fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix2x4fv(i3, i4, floatBuffer2.remaining() >> 3, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix3(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix3dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix3dv(i3, i4, doubleBuffer2.remaining() / 9, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix3(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix3fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix3fv(i3, i4, floatBuffer2.remaining() / 9, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix3x2(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix3x2dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix3x2dv(i3, i4, doubleBuffer2.remaining() / 6, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix3x2(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix3x2fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix3x2fv(i3, i4, floatBuffer2.remaining() / 6, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix3x4(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix3x4dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix3x4dv(i3, i4, doubleBuffer2.remaining() / 12, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix3x4(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix3x4fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix3x4fv(i3, i4, floatBuffer2.remaining() / 12, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix4(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix4dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix4dv(i3, i4, doubleBuffer2.remaining() >> 4, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix4(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix4fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix4fv(i3, i4, floatBuffer2.remaining() >> 4, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix4x2(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix4x2dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix4x2dv(i3, i4, doubleBuffer2.remaining() >> 3, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix4x2(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix4x2fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix4x2fv(i3, i4, floatBuffer2.remaining() >> 3, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix4x3(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix4x3dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglProgramUniformMatrix4x3dv(i3, i4, doubleBuffer2.remaining() / 12, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glProgramUniformMatrix4x3(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix4x3fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix4x3fv(i3, i4, floatBuffer2.remaining() / 12, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glReleaseShaderCompiler() {
        long j = GLContext.getCapabilities().glReleaseShaderCompiler;
        BufferChecks.checkFunctionAddress(j);
        nglReleaseShaderCompiler(j);
    }

    public static void glScissorArray(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glScissorArrayv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglScissorArrayv(i2, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glScissorIndexed(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glScissorIndexed;
        BufferChecks.checkFunctionAddress(j);
        nglScissorIndexed(i6, i7, i8, i9, i10, j);
    }

    public static void glScissorIndexed(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glScissorIndexedv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglScissorIndexedv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glShaderBinary(IntBuffer intBuffer, int i, ByteBuffer byteBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glShaderBinary;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglShaderBinary(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), i2, MemoryUtil.getAddress(byteBuffer2), byteBuffer2.remaining(), j);
    }

    public static void glUseProgramStages(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glUseProgramStages;
        BufferChecks.checkFunctionAddress(j);
        nglUseProgramStages(i4, i5, i6, j);
    }

    public static void glValidateProgramPipeline(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glValidateProgramPipeline;
        BufferChecks.checkFunctionAddress(j);
        nglValidateProgramPipeline(i2, j);
    }

    public static void glVertexAttribL1(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL1dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 1);
        nglVertexAttribL1dv(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribL1d(int i, double d) {
        int i2 = i;
        double d2 = d;
        long j = GLContext.getCapabilities().glVertexAttribL1d;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribL1d(i2, d2, j);
    }

    public static void glVertexAttribL2(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL2dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 2);
        nglVertexAttribL2dv(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribL2d(int i, double d, double d2) {
        int i2 = i;
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glVertexAttribL2d;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribL2d(i2, d3, d4, j);
    }

    public static void glVertexAttribL3(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL3dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 3);
        nglVertexAttribL3dv(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribL3d(int i, double d, double d2, double d3) {
        int i2 = i;
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glVertexAttribL3d;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribL3d(i2, d4, d5, d6, j);
    }

    public static void glVertexAttribL4(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL4dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglVertexAttribL4dv(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribL4d(int i, double d, double d2, double d3, double d4) {
        int i2 = i;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glVertexAttribL4d;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribL4d(i2, d5, d6, d7, d8, j);
    }

    public static void glVertexAttribLPointer(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glVertexAttribLPointer;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglVertexAttribLPointerBO(i4, i5, 5130, i6, j2, j3);
    }

    public static void glVertexAttribLPointer(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribLPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i4] = doubleBuffer2;
        }
        nglVertexAttribLPointer(i4, i5, 5130, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glViewportArray(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glViewportArrayv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglViewportArrayv(i2, floatBuffer2.remaining() >> 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glViewportIndexed(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glViewportIndexedfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglViewportIndexedfv(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glViewportIndexedf(int i, float f, float f2, float f3, float f4) {
        int i2 = i;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glViewportIndexedf;
        BufferChecks.checkFunctionAddress(j);
        nglViewportIndexedf(i2, f5, f6, f7, f8, j);
    }

    static native void nglActiveShaderProgram(int i, int i2, long j);

    static native void nglBindProgramPipeline(int i, long j);

    static native void nglClearDepthf(float f, long j);

    static native int nglCreateShaderProgramv(int i, int i2, long j, long j2);

    static native int nglCreateShaderProgramv2(int i, int i2, long j, long j2);

    static native int nglCreateShaderProgramv3(int i, int i2, ByteBuffer[] byteBufferArr, long j);

    static native void nglDeleteProgramPipelines(int i, long j, long j2);

    static native void nglDepthRangeArrayv(int i, int i2, long j, long j2);

    static native void nglDepthRangeIndexed(int i, double d, double d2, long j);

    static native void nglDepthRangef(float f, float f2, long j);

    static native void nglGenProgramPipelines(int i, long j, long j2);

    static native void nglGetDoublei_v(int i, int i2, long j, long j2);

    static native void nglGetFloati_v(int i, int i2, long j, long j2);

    static native void nglGetProgramBinary(int i, int i2, long j, long j2, long j3, long j4);

    static native void nglGetProgramPipelineInfoLog(int i, int i2, long j, long j2, long j3);

    static native void nglGetProgramPipelineiv(int i, int i2, long j, long j2);

    static native void nglGetShaderPrecisionFormat(int i, int i2, long j, long j2, long j3);

    static native void nglGetVertexAttribLdv(int i, int i2, long j, long j2);

    static native boolean nglIsProgramPipeline(int i, long j);

    static native void nglProgramBinary(int i, int i2, long j, int i3, long j2);

    static native void nglProgramParameteri(int i, int i2, int i3, long j);

    static native void nglProgramUniform1d(int i, int i2, double d, long j);

    static native void nglProgramUniform1dv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform1f(int i, int i2, float f, long j);

    static native void nglProgramUniform1fv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform1i(int i, int i2, int i3, long j);

    static native void nglProgramUniform1iv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform1ui(int i, int i2, int i3, long j);

    static native void nglProgramUniform1uiv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform2d(int i, int i2, double d, double d2, long j);

    static native void nglProgramUniform2dv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform2f(int i, int i2, float f, float f2, long j);

    static native void nglProgramUniform2fv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform2i(int i, int i2, int i3, int i4, long j);

    static native void nglProgramUniform2iv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform2ui(int i, int i2, int i3, int i4, long j);

    static native void nglProgramUniform2uiv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform3d(int i, int i2, double d, double d2, double d3, long j);

    static native void nglProgramUniform3dv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform3f(int i, int i2, float f, float f2, float f3, long j);

    static native void nglProgramUniform3fv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform3i(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglProgramUniform3iv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform3ui(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglProgramUniform3uiv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform4d(int i, int i2, double d, double d2, double d3, double d4, long j);

    static native void nglProgramUniform4dv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform4f(int i, int i2, float f, float f2, float f3, float f4, long j);

    static native void nglProgramUniform4fv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform4i(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglProgramUniform4iv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform4ui(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglProgramUniform4uiv(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniformMatrix2dv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix2fv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix2x3dv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix2x3fv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix2x4dv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix2x4fv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix3dv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix3fv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix3x2dv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix3x2fv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix3x4dv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix3x4fv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix4dv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix4fv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix4x2dv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix4x2fv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix4x3dv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix4x3fv(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglReleaseShaderCompiler(long j);

    static native void nglScissorArrayv(int i, int i2, long j, long j2);

    static native void nglScissorIndexed(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglScissorIndexedv(int i, long j, long j2);

    static native void nglShaderBinary(int i, long j, int i2, long j2, int i3, long j3);

    static native void nglUseProgramStages(int i, int i2, int i3, long j);

    static native void nglValidateProgramPipeline(int i, long j);

    static native void nglVertexAttribL1d(int i, double d, long j);

    static native void nglVertexAttribL1dv(int i, long j, long j2);

    static native void nglVertexAttribL2d(int i, double d, double d2, long j);

    static native void nglVertexAttribL2dv(int i, long j, long j2);

    static native void nglVertexAttribL3d(int i, double d, double d2, double d3, long j);

    static native void nglVertexAttribL3dv(int i, long j, long j2);

    static native void nglVertexAttribL4d(int i, double d, double d2, double d3, double d4, long j);

    static native void nglVertexAttribL4dv(int i, long j, long j2);

    static native void nglVertexAttribLPointer(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglVertexAttribLPointerBO(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglViewportArrayv(int i, int i2, long j, long j2);

    static native void nglViewportIndexedf(int i, float f, float f2, float f3, float f4, long j);

    static native void nglViewportIndexedfv(int i, long j, long j2);
}
