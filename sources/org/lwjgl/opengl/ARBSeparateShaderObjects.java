package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class ARBSeparateShaderObjects {
    public static final int GL_ACTIVE_PROGRAM = 33369;
    public static final int GL_ALL_SHADER_BITS = -1;
    public static final int GL_FRAGMENT_SHADER_BIT = 2;
    public static final int GL_GEOMETRY_SHADER_BIT = 4;
    public static final int GL_PROGRAM_PIPELINE_BINDING = 33370;
    public static final int GL_PROGRAM_SEPARABLE = 33368;
    public static final int GL_TESS_CONTROL_SHADER_BIT = 8;
    public static final int GL_TESS_EVALUATION_SHADER_BIT = 16;
    public static final int GL_VERTEX_SHADER_BIT = 1;

    private ARBSeparateShaderObjects() {
    }

    public static void glActiveShaderProgram(int i, int i2) {
        GL41.glActiveShaderProgram(i, i2);
    }

    public static void glBindProgramPipeline(int i) {
        GL41.glBindProgramPipeline(i);
    }

    public static int glCreateShaderProgram(int i, int i2, ByteBuffer byteBuffer) {
        return GL41.glCreateShaderProgram(i, i2, byteBuffer);
    }

    public static int glCreateShaderProgram(int i, CharSequence charSequence) {
        return GL41.glCreateShaderProgram(i, charSequence);
    }

    public static int glCreateShaderProgram(int i, ByteBuffer byteBuffer) {
        return GL41.glCreateShaderProgram(i, byteBuffer);
    }

    public static int glCreateShaderProgram(int i, CharSequence[] charSequenceArr) {
        return GL41.glCreateShaderProgram(i, charSequenceArr);
    }

    public static int glCreateShaderProgram(int i, ByteBuffer[] byteBufferArr) {
        return GL41.glCreateShaderProgram(i, byteBufferArr);
    }

    public static void glDeleteProgramPipelines(int i) {
        GL41.glDeleteProgramPipelines(i);
    }

    public static void glDeleteProgramPipelines(IntBuffer intBuffer) {
        GL41.glDeleteProgramPipelines(intBuffer);
    }

    public static int glGenProgramPipelines() {
        return GL41.glGenProgramPipelines();
    }

    public static void glGenProgramPipelines(IntBuffer intBuffer) {
        GL41.glGenProgramPipelines(intBuffer);
    }

    public static void glGetProgramPipeline(int i, int i2, IntBuffer intBuffer) {
        GL41.glGetProgramPipeline(i, i2, intBuffer);
    }

    public static String glGetProgramPipelineInfoLog(int i, int i2) {
        return GL41.glGetProgramPipelineInfoLog(i, i2);
    }

    public static void glGetProgramPipelineInfoLog(int i, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        GL41.glGetProgramPipelineInfoLog(i, intBuffer, byteBuffer);
    }

    public static int glGetProgramPipelinei(int i, int i2) {
        return GL41.glGetProgramPipelinei(i, i2);
    }

    public static boolean glIsProgramPipeline(int i) {
        return GL41.glIsProgramPipeline(i);
    }

    public static void glProgramParameteri(int i, int i2, int i3) {
        GL41.glProgramParameteri(i, i2, i3);
    }

    public static void glProgramUniform1(int i, int i2, DoubleBuffer doubleBuffer) {
        GL41.glProgramUniform1(i, i2, doubleBuffer);
    }

    public static void glProgramUniform1(int i, int i2, FloatBuffer floatBuffer) {
        GL41.glProgramUniform1(i, i2, floatBuffer);
    }

    public static void glProgramUniform1(int i, int i2, IntBuffer intBuffer) {
        GL41.glProgramUniform1(i, i2, intBuffer);
    }

    public static void glProgramUniform1d(int i, int i2, double d) {
        GL41.glProgramUniform1d(i, i2, d);
    }

    public static void glProgramUniform1f(int i, int i2, float f) {
        GL41.glProgramUniform1f(i, i2, f);
    }

    public static void glProgramUniform1i(int i, int i2, int i3) {
        GL41.glProgramUniform1i(i, i2, i3);
    }

    public static void glProgramUniform1u(int i, int i2, IntBuffer intBuffer) {
        GL41.glProgramUniform1u(i, i2, intBuffer);
    }

    public static void glProgramUniform1ui(int i, int i2, int i3) {
        GL41.glProgramUniform1ui(i, i2, i3);
    }

    public static void glProgramUniform2(int i, int i2, DoubleBuffer doubleBuffer) {
        GL41.glProgramUniform2(i, i2, doubleBuffer);
    }

    public static void glProgramUniform2(int i, int i2, FloatBuffer floatBuffer) {
        GL41.glProgramUniform2(i, i2, floatBuffer);
    }

    public static void glProgramUniform2(int i, int i2, IntBuffer intBuffer) {
        GL41.glProgramUniform2(i, i2, intBuffer);
    }

    public static void glProgramUniform2d(int i, int i2, double d, double d2) {
        GL41.glProgramUniform2d(i, i2, d, d2);
    }

    public static void glProgramUniform2f(int i, int i2, float f, float f2) {
        GL41.glProgramUniform2f(i, i2, f, f2);
    }

    public static void glProgramUniform2i(int i, int i2, int i3, int i4) {
        GL41.glProgramUniform2i(i, i2, i3, i4);
    }

    public static void glProgramUniform2u(int i, int i2, IntBuffer intBuffer) {
        GL41.glProgramUniform2u(i, i2, intBuffer);
    }

    public static void glProgramUniform2ui(int i, int i2, int i3, int i4) {
        GL41.glProgramUniform2ui(i, i2, i3, i4);
    }

    public static void glProgramUniform3(int i, int i2, DoubleBuffer doubleBuffer) {
        GL41.glProgramUniform3(i, i2, doubleBuffer);
    }

    public static void glProgramUniform3(int i, int i2, FloatBuffer floatBuffer) {
        GL41.glProgramUniform3(i, i2, floatBuffer);
    }

    public static void glProgramUniform3(int i, int i2, IntBuffer intBuffer) {
        GL41.glProgramUniform3(i, i2, intBuffer);
    }

    public static void glProgramUniform3d(int i, int i2, double d, double d2, double d3) {
        GL41.glProgramUniform3d(i, i2, d, d2, d3);
    }

    public static void glProgramUniform3f(int i, int i2, float f, float f2, float f3) {
        GL41.glProgramUniform3f(i, i2, f, f2, f3);
    }

    public static void glProgramUniform3i(int i, int i2, int i3, int i4, int i5) {
        GL41.glProgramUniform3i(i, i2, i3, i4, i5);
    }

    public static void glProgramUniform3u(int i, int i2, IntBuffer intBuffer) {
        GL41.glProgramUniform3u(i, i2, intBuffer);
    }

    public static void glProgramUniform3ui(int i, int i2, int i3, int i4, int i5) {
        GL41.glProgramUniform3ui(i, i2, i3, i4, i5);
    }

    public static void glProgramUniform4(int i, int i2, DoubleBuffer doubleBuffer) {
        GL41.glProgramUniform4(i, i2, doubleBuffer);
    }

    public static void glProgramUniform4(int i, int i2, FloatBuffer floatBuffer) {
        GL41.glProgramUniform4(i, i2, floatBuffer);
    }

    public static void glProgramUniform4(int i, int i2, IntBuffer intBuffer) {
        GL41.glProgramUniform4(i, i2, intBuffer);
    }

    public static void glProgramUniform4d(int i, int i2, double d, double d2, double d3, double d4) {
        GL41.glProgramUniform4d(i, i2, d, d2, d3, d4);
    }

    public static void glProgramUniform4f(int i, int i2, float f, float f2, float f3, float f4) {
        GL41.glProgramUniform4f(i, i2, f, f2, f3, f4);
    }

    public static void glProgramUniform4i(int i, int i2, int i3, int i4, int i5, int i6) {
        GL41.glProgramUniform4i(i, i2, i3, i4, i5, i6);
    }

    public static void glProgramUniform4u(int i, int i2, IntBuffer intBuffer) {
        GL41.glProgramUniform4u(i, i2, intBuffer);
    }

    public static void glProgramUniform4ui(int i, int i2, int i3, int i4, int i5, int i6) {
        GL41.glProgramUniform4ui(i, i2, i3, i4, i5, i6);
    }

    public static void glProgramUniformMatrix2(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        GL41.glProgramUniformMatrix2(i, i2, z, doubleBuffer);
    }

    public static void glProgramUniformMatrix2(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GL41.glProgramUniformMatrix2(i, i2, z, floatBuffer);
    }

    public static void glProgramUniformMatrix2x3(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        GL41.glProgramUniformMatrix2x3(i, i2, z, doubleBuffer);
    }

    public static void glProgramUniformMatrix2x3(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GL41.glProgramUniformMatrix2x3(i, i2, z, floatBuffer);
    }

    public static void glProgramUniformMatrix2x4(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        GL41.glProgramUniformMatrix2x4(i, i2, z, doubleBuffer);
    }

    public static void glProgramUniformMatrix2x4(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GL41.glProgramUniformMatrix2x4(i, i2, z, floatBuffer);
    }

    public static void glProgramUniformMatrix3(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        GL41.glProgramUniformMatrix3(i, i2, z, doubleBuffer);
    }

    public static void glProgramUniformMatrix3(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GL41.glProgramUniformMatrix3(i, i2, z, floatBuffer);
    }

    public static void glProgramUniformMatrix3x2(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        GL41.glProgramUniformMatrix3x2(i, i2, z, doubleBuffer);
    }

    public static void glProgramUniformMatrix3x2(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GL41.glProgramUniformMatrix3x2(i, i2, z, floatBuffer);
    }

    public static void glProgramUniformMatrix3x4(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        GL41.glProgramUniformMatrix3x4(i, i2, z, doubleBuffer);
    }

    public static void glProgramUniformMatrix3x4(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GL41.glProgramUniformMatrix3x4(i, i2, z, floatBuffer);
    }

    public static void glProgramUniformMatrix4(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        GL41.glProgramUniformMatrix4(i, i2, z, doubleBuffer);
    }

    public static void glProgramUniformMatrix4(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GL41.glProgramUniformMatrix4(i, i2, z, floatBuffer);
    }

    public static void glProgramUniformMatrix4x2(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        GL41.glProgramUniformMatrix4x2(i, i2, z, doubleBuffer);
    }

    public static void glProgramUniformMatrix4x2(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GL41.glProgramUniformMatrix4x2(i, i2, z, floatBuffer);
    }

    public static void glProgramUniformMatrix4x3(int i, int i2, boolean z, DoubleBuffer doubleBuffer) {
        GL41.glProgramUniformMatrix4x3(i, i2, z, doubleBuffer);
    }

    public static void glProgramUniformMatrix4x3(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GL41.glProgramUniformMatrix4x3(i, i2, z, floatBuffer);
    }

    public static void glUseProgramStages(int i, int i2, int i3) {
        GL41.glUseProgramStages(i, i2, i3);
    }

    public static void glValidateProgramPipeline(int i) {
        GL41.glValidateProgramPipeline(i);
    }
}
