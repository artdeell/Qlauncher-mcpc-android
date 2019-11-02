package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class ARBUniformBufferObject {
    public static final int GL_ACTIVE_UNIFORM_BLOCKS = 35382;
    public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 35381;
    public static final int GL_INVALID_INDEX = -1;
    public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 35379;
    public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 35378;
    public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 35374;
    public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 35377;
    public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 35373;
    public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 35372;
    public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 35376;
    public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 35375;
    public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 35371;
    public static final int GL_UNIFORM_ARRAY_STRIDE = 35388;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 35394;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 35395;
    public static final int GL_UNIFORM_BLOCK_BINDING = 35391;
    public static final int GL_UNIFORM_BLOCK_DATA_SIZE = 35392;
    public static final int GL_UNIFORM_BLOCK_INDEX = 35386;
    public static final int GL_UNIFORM_BLOCK_NAME_LENGTH = 35393;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 35398;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 35397;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 35396;
    public static final int GL_UNIFORM_BUFFER = 35345;
    public static final int GL_UNIFORM_BUFFER_BINDING = 35368;
    public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 35380;
    public static final int GL_UNIFORM_BUFFER_SIZE = 35370;
    public static final int GL_UNIFORM_BUFFER_START = 35369;
    public static final int GL_UNIFORM_IS_ROW_MAJOR = 35390;
    public static final int GL_UNIFORM_MATRIX_STRIDE = 35389;
    public static final int GL_UNIFORM_NAME_LENGTH = 35385;
    public static final int GL_UNIFORM_OFFSET = 35387;
    public static final int GL_UNIFORM_SIZE = 35384;
    public static final int GL_UNIFORM_TYPE = 35383;

    private ARBUniformBufferObject() {
    }

    public static void glBindBufferBase(int i, int i2, int i3) {
        GL30.glBindBufferBase(i, i2, i3);
    }

    public static void glBindBufferRange(int i, int i2, int i3, long j, long j2) {
        GL30.glBindBufferRange(i, i2, i3, j, j2);
    }

    @Deprecated
    public static int glGetActiveUniformBlock(int i, int i2, int i3) {
        return GL31.glGetActiveUniformBlocki(i, i2, i3);
    }

    public static void glGetActiveUniformBlock(int i, int i2, int i3, IntBuffer intBuffer) {
        GL31.glGetActiveUniformBlock(i, i2, i3, intBuffer);
    }

    public static String glGetActiveUniformBlockName(int i, int i2, int i3) {
        return GL31.glGetActiveUniformBlockName(i, i2, i3);
    }

    public static void glGetActiveUniformBlockName(int i, int i2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        GL31.glGetActiveUniformBlockName(i, i2, intBuffer, byteBuffer);
    }

    public static int glGetActiveUniformBlocki(int i, int i2, int i3) {
        return GL31.glGetActiveUniformBlocki(i, i2, i3);
    }

    public static String glGetActiveUniformName(int i, int i2, int i3) {
        return GL31.glGetActiveUniformName(i, i2, i3);
    }

    public static void glGetActiveUniformName(int i, int i2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        GL31.glGetActiveUniformName(i, i2, intBuffer, byteBuffer);
    }

    @Deprecated
    public static int glGetActiveUniforms(int i, int i2, int i3) {
        return GL31.glGetActiveUniformsi(i, i2, i3);
    }

    public static void glGetActiveUniforms(int i, IntBuffer intBuffer, int i2, IntBuffer intBuffer2) {
        GL31.glGetActiveUniforms(i, intBuffer, i2, intBuffer2);
    }

    public static int glGetActiveUniformsi(int i, int i2, int i3) {
        return GL31.glGetActiveUniformsi(i, i2, i3);
    }

    public static int glGetInteger(int i, int i2) {
        return GL30.glGetInteger(i, i2);
    }

    public static void glGetInteger(int i, int i2, IntBuffer intBuffer) {
        GL30.glGetInteger(i, i2, intBuffer);
    }

    public static int glGetUniformBlockIndex(int i, CharSequence charSequence) {
        return GL31.glGetUniformBlockIndex(i, charSequence);
    }

    public static int glGetUniformBlockIndex(int i, ByteBuffer byteBuffer) {
        return GL31.glGetUniformBlockIndex(i, byteBuffer);
    }

    public static void glGetUniformIndices(int i, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        GL31.glGetUniformIndices(i, byteBuffer, intBuffer);
    }

    public static void glGetUniformIndices(int i, CharSequence[] charSequenceArr, IntBuffer intBuffer) {
        GL31.glGetUniformIndices(i, charSequenceArr, intBuffer);
    }

    public static void glUniformBlockBinding(int i, int i2, int i3) {
        GL31.glUniformBlockBinding(i, i2, i3);
    }
}
