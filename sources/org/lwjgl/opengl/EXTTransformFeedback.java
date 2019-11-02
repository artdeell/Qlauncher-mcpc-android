package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class EXTTransformFeedback {
    public static final int GL_INTERLEAVED_ATTRIBS_EXT = 35980;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS_EXT = 35978;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS_EXT = 35979;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS_EXT = 35968;
    public static final int GL_PRIMITIVES_GENERATED_EXT = 35975;
    public static final int GL_RASTERIZER_DISCARD_EXT = 35977;
    public static final int GL_SEPARATE_ATTRIBS_EXT = 35981;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING_EXT = 35983;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_EXT = 35982;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE_EXT = 35967;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE_EXT = 35973;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START_EXT = 35972;
    public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN_EXT = 35976;
    public static final int GL_TRANSFORM_FEEDBACK_VARYINGS_EXT = 35971;
    public static final int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH_EXT = 35958;

    private EXTTransformFeedback() {
    }

    public static void glBeginTransformFeedbackEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glBeginTransformFeedbackEXT;
        BufferChecks.checkFunctionAddress(j);
        nglBeginTransformFeedbackEXT(i2, j);
    }

    public static void glBindBufferBaseEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glBindBufferBaseEXT;
        BufferChecks.checkFunctionAddress(j);
        nglBindBufferBaseEXT(i4, i5, i6, j);
    }

    public static void glBindBufferOffsetEXT(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glBindBufferOffsetEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglBindBufferOffsetEXT(i4, i5, i6, j2, j3);
    }

    public static void glBindBufferRangeEXT(int i, int i2, int i3, long j, long j2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glBindBufferRangeEXT;
        BufferChecks.checkFunctionAddress(j5);
        nglBindBufferRangeEXT(i4, i5, i6, j3, j4, j5);
    }

    public static void glEndTransformFeedbackEXT() {
        long j = GLContext.getCapabilities().glEndTransformFeedbackEXT;
        BufferChecks.checkFunctionAddress(j);
        nglEndTransformFeedbackEXT(j);
    }

    public static String glGetTransformFeedbackVaryingEXT(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTransformFeedbackVaryingEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer3, 1);
        BufferChecks.checkBuffer(intBuffer4, 1);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetTransformFeedbackVaryingEXT(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetTransformFeedbackVaryingEXT(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer4 = intBuffer;
        IntBuffer intBuffer5 = intBuffer2;
        IntBuffer intBuffer6 = intBuffer3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetTransformFeedbackVaryingEXT;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        BufferChecks.checkBuffer(intBuffer5, 1);
        BufferChecks.checkBuffer(intBuffer6, 1);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetTransformFeedbackVaryingEXT(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer4), MemoryUtil.getAddress(intBuffer5), MemoryUtil.getAddress(intBuffer6), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glTransformFeedbackVaryingsEXT(int i, int i2, ByteBuffer byteBuffer, int i3) {
        int i4 = i;
        int i5 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i6 = i3;
        long j = GLContext.getCapabilities().glTransformFeedbackVaryingsEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2, i5);
        nglTransformFeedbackVaryingsEXT(i4, i5, MemoryUtil.getAddress(byteBuffer2), i6, j);
    }

    public static void glTransformFeedbackVaryingsEXT(int i, CharSequence[] charSequenceArr, int i2) {
        int i3 = i;
        CharSequence[] charSequenceArr2 = charSequenceArr;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTransformFeedbackVaryingsEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkArray(charSequenceArr2);
        nglTransformFeedbackVaryingsEXT(i3, charSequenceArr2.length, APIUtil.getBufferNT(capabilities, charSequenceArr2), i4, j);
    }

    static native void nglBeginTransformFeedbackEXT(int i, long j);

    static native void nglBindBufferBaseEXT(int i, int i2, int i3, long j);

    static native void nglBindBufferOffsetEXT(int i, int i2, int i3, long j, long j2);

    static native void nglBindBufferRangeEXT(int i, int i2, int i3, long j, long j2, long j3);

    static native void nglEndTransformFeedbackEXT(long j);

    static native void nglGetTransformFeedbackVaryingEXT(int i, int i2, int i3, long j, long j2, long j3, long j4, long j5);

    static native void nglTransformFeedbackVaryingsEXT(int i, int i2, long j, int i3, long j2);
}
