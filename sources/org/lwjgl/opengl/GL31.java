package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class GL31 {
    public static final int GL_ACTIVE_UNIFORM_BLOCKS = 35382;
    public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 35381;
    public static final int GL_COPY_READ_BUFFER = 36662;
    public static final int GL_COPY_READ_BUFFER_BINDING = 36662;
    public static final int GL_COPY_WRITE_BUFFER = 36663;
    public static final int GL_COPY_WRITE_BUFFER_BINDING = 36663;
    public static final int GL_INVALID_INDEX = -1;
    public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 35379;
    public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 35378;
    public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 35374;
    public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 35377;
    public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 35373;
    public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 35372;
    public static final int GL_MAX_RECTANGLE_TEXTURE_SIZE = 34040;
    public static final int GL_MAX_TEXTURE_BUFFER_SIZE = 35883;
    public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 35376;
    public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 35375;
    public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 35371;
    public static final int GL_PRIMITIVE_RESTART = 36765;
    public static final int GL_PRIMITIVE_RESTART_INDEX = 36766;
    public static final int GL_PROXY_TEXTURE_RECTANGLE = 34039;
    public static final int GL_R16_SNORM = 36760;
    public static final int GL_R8_SNORM = 36756;
    public static final int GL_RED_SNORM = 36752;
    public static final int GL_RG16_SNORM = 36761;
    public static final int GL_RG8_SNORM = 36757;
    public static final int GL_RGB16_SNORM = 36762;
    public static final int GL_RGB8_SNORM = 36758;
    public static final int GL_RGBA16_SNORM = 36763;
    public static final int GL_RGBA8_SNORM = 36759;
    public static final int GL_RGBA_SNORM = 36755;
    public static final int GL_RGB_SNORM = 36754;
    public static final int GL_RG_SNORM = 36753;
    public static final int GL_SAMPLER_2D_RECT = 35683;
    public static final int GL_SAMPLER_2D_RECT_SHADOW = 35684;
    public static final int GL_SIGNED_NORMALIZED = 36764;
    public static final int GL_TEXTURE_BINDING_BUFFER = 35884;
    public static final int GL_TEXTURE_BINDING_RECTANGLE = 34038;
    public static final int GL_TEXTURE_BUFFER = 35882;
    public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 35885;
    public static final int GL_TEXTURE_BUFFER_FORMAT = 35886;
    public static final int GL_TEXTURE_RECTANGLE = 34037;
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

    private GL31() {
    }

    public static void glCopyBufferSubData(int i, int i2, long j, long j2, long j3) {
        int i3 = i;
        int i4 = i2;
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        long j7 = GLContext.getCapabilities().glCopyBufferSubData;
        BufferChecks.checkFunctionAddress(j7);
        nglCopyBufferSubData(i3, i4, j4, j5, j6, j7);
    }

    public static void glDrawArraysInstanced(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glDrawArraysInstanced;
        BufferChecks.checkFunctionAddress(j);
        nglDrawArraysInstanced(i5, i6, i7, i8, j);
    }

    public static void glDrawElementsInstanced(int i, int i2, int i3, long j, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        long j2 = j;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glDrawElementsInstanced;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureElementVBOenabled(capabilities);
        nglDrawElementsInstancedBO(i5, i6, i7, j2, i8, j3);
    }

    public static void glDrawElementsInstanced(int i, ByteBuffer byteBuffer, int i2) {
        int i3 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsInstanced;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglDrawElementsInstanced(i3, byteBuffer2.remaining(), GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(byteBuffer2), i4, j);
    }

    public static void glDrawElementsInstanced(int i, IntBuffer intBuffer, int i2) {
        int i3 = i;
        IntBuffer intBuffer2 = intBuffer;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsInstanced;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglDrawElementsInstanced(i3, intBuffer2.remaining(), GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(intBuffer2), i4, j);
    }

    public static void glDrawElementsInstanced(int i, ShortBuffer shortBuffer, int i2) {
        int i3 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsInstanced;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglDrawElementsInstanced(i3, shortBuffer2.remaining(), GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(shortBuffer2), i4, j);
    }

    @Deprecated
    public static int glGetActiveUniformBlock(int i, int i2, int i3) {
        return glGetActiveUniformBlocki(i, i2, i3);
    }

    public static void glGetActiveUniformBlock(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetActiveUniformBlockiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 16);
        nglGetActiveUniformBlockiv(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static String glGetActiveUniformBlockName(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveUniformBlockName;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetActiveUniformBlockName(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetActiveUniformBlockName(int i, int i2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetActiveUniformBlockName;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        BufferChecks.checkDirect(byteBuffer2);
        nglGetActiveUniformBlockName(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetActiveUniformBlocki(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveUniformBlockiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetActiveUniformBlockiv(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static String glGetActiveUniformName(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveUniformName;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetActiveUniformName(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetActiveUniformName(int i, int i2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetActiveUniformName;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        BufferChecks.checkDirect(byteBuffer2);
        nglGetActiveUniformName(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    @Deprecated
    public static int glGetActiveUniforms(int i, int i2, int i3) {
        return glGetActiveUniformsi(i, i2, i3);
    }

    public static void glGetActiveUniforms(int i, IntBuffer intBuffer, int i2, IntBuffer intBuffer2) {
        int i3 = i;
        IntBuffer intBuffer3 = intBuffer;
        int i4 = i2;
        IntBuffer intBuffer4 = intBuffer2;
        long j = GLContext.getCapabilities().glGetActiveUniformsiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkBuffer(intBuffer4, intBuffer3.remaining());
        nglGetActiveUniformsiv(i3, intBuffer3.remaining(), MemoryUtil.getAddress(intBuffer3), i4, MemoryUtil.getAddress(intBuffer4), j);
    }

    public static int glGetActiveUniformsi(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveUniformsiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetActiveUniformsiv(i4, 1, MemoryUtil.getAddress(bufferInt.put(1, i5), 1), i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static int glGetUniformBlockIndex(int i, CharSequence charSequence) {
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetUniformBlockIndex;
        BufferChecks.checkFunctionAddress(j);
        return nglGetUniformBlockIndex(i2, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glGetUniformBlockIndex(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetUniformBlockIndex;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglGetUniformBlockIndex(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetUniformIndices(int i, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetUniformIndices;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2, intBuffer2.remaining());
        BufferChecks.checkDirect(intBuffer2);
        nglGetUniformIndices(i2, intBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetUniformIndices(int i, CharSequence[] charSequenceArr, IntBuffer intBuffer) {
        int i2 = i;
        CharSequence[] charSequenceArr2 = charSequenceArr;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetUniformIndices;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkArray(charSequenceArr2);
        BufferChecks.checkBuffer(intBuffer2, charSequenceArr2.length);
        nglGetUniformIndices(i2, charSequenceArr2.length, APIUtil.getBufferNT(capabilities, charSequenceArr2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glPrimitiveRestartIndex(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glPrimitiveRestartIndex;
        BufferChecks.checkFunctionAddress(j);
        nglPrimitiveRestartIndex(i2, j);
    }

    public static void glTexBuffer(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glTexBuffer;
        BufferChecks.checkFunctionAddress(j);
        nglTexBuffer(i4, i5, i6, j);
    }

    public static void glUniformBlockBinding(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glUniformBlockBinding;
        BufferChecks.checkFunctionAddress(j);
        nglUniformBlockBinding(i4, i5, i6, j);
    }

    static native void nglCopyBufferSubData(int i, int i2, long j, long j2, long j3, long j4);

    static native void nglDrawArraysInstanced(int i, int i2, int i3, int i4, long j);

    static native void nglDrawElementsInstanced(int i, int i2, int i3, long j, int i4, long j2);

    static native void nglDrawElementsInstancedBO(int i, int i2, int i3, long j, int i4, long j2);

    static native void nglGetActiveUniformBlockName(int i, int i2, int i3, long j, long j2, long j3);

    static native void nglGetActiveUniformBlockiv(int i, int i2, int i3, long j, long j2);

    static native void nglGetActiveUniformName(int i, int i2, int i3, long j, long j2, long j3);

    static native void nglGetActiveUniformsiv(int i, int i2, long j, int i3, long j2, long j3);

    static native int nglGetUniformBlockIndex(int i, long j, long j2);

    static native void nglGetUniformIndices(int i, int i2, long j, long j2, long j3);

    static native void nglPrimitiveRestartIndex(int i, long j);

    static native void nglTexBuffer(int i, int i2, int i3, long j);

    static native void nglUniformBlockBinding(int i, int i2, int i3, long j);
}
