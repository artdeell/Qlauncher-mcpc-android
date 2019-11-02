package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVTransformFeedback {
    public static final int GL_ACTIVE_VARYINGS_NV = 35969;
    public static final int GL_ACTIVE_VARYING_MAX_LENGTH_NV = 35970;
    public static final int GL_BACK_PRIMARY_COLOR_NV = 35959;
    public static final int GL_BACK_SECONDARY_COLOR_NV = 35960;
    public static final int GL_CLIP_DISTANCE_NV = 35962;
    public static final int GL_GENERIC_ATTRIB_NV = 35965;
    public static final int GL_INTERLEAVED_ATTRIBS_NV = 35980;
    public static final int GL_LAYER_NV = 36266;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS_NV = 35978;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS_NV = 35979;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS_NV = 35968;
    public static final int GL_PRIMITIVES_GENERATED_NV = 35975;
    public static final int GL_PRIMITIVE_ID_NV = 35964;
    public static final int GL_RASTERIZER_DISCARD_NV = 35977;
    public static final int GL_SEPARATE_ATTRIBS_NV = 35981;
    public static final int GL_TEXTURE_COORD_NV = 35961;
    public static final int GL_TRANSFORM_FEEDBACK_ATTRIBS_NV = 35966;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING_NV = 35983;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE_NV = 35967;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_NV = 35982;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE_NV = 35973;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START_NV = 35972;
    public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN_NV = 35976;
    public static final int GL_TRANSFORM_FEEDBACK_RECORD_NV = 35974;
    public static final int GL_TRANSFORM_FEEDBACK_VARYINGS_NV = 35971;
    public static final int GL_VERTEX_ID_NV = 35963;

    private NVTransformFeedback() {
    }

    public static void glActiveVaryingNV(int i, CharSequence charSequence) {
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glActiveVaryingNV;
        BufferChecks.checkFunctionAddress(j);
        nglActiveVaryingNV(i2, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static void glActiveVaryingNV(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glActiveVaryingNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        nglActiveVaryingNV(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glBeginTransformFeedbackNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glBeginTransformFeedbackNV;
        BufferChecks.checkFunctionAddress(j);
        nglBeginTransformFeedbackNV(i2, j);
    }

    public static void glBindBufferBaseNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glBindBufferBaseNV;
        BufferChecks.checkFunctionAddress(j);
        nglBindBufferBaseNV(i4, i5, i6, j);
    }

    public static void glBindBufferOffsetNV(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glBindBufferOffsetNV;
        BufferChecks.checkFunctionAddress(j3);
        nglBindBufferOffsetNV(i4, i5, i6, j2, j3);
    }

    public static void glBindBufferRangeNV(int i, int i2, int i3, long j, long j2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glBindBufferRangeNV;
        BufferChecks.checkFunctionAddress(j5);
        nglBindBufferRangeNV(i4, i5, i6, j3, j4, j5);
    }

    public static void glEndTransformFeedbackNV() {
        long j = GLContext.getCapabilities().glEndTransformFeedbackNV;
        BufferChecks.checkFunctionAddress(j);
        nglEndTransformFeedbackNV(j);
    }

    public static String glGetActiveVaryingNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveVaryingNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetActiveVaryingNV(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress0((Buffer) APIUtil.getBufferInt(capabilities)), MemoryUtil.getAddress(APIUtil.getBufferInt(capabilities), 1), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static String glGetActiveVaryingNV(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveVaryingNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 2);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetActiveVaryingNV(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(intBuffer2, 1 + intBuffer2.position()), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetActiveVaryingNV(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer4 = intBuffer;
        IntBuffer intBuffer5 = intBuffer2;
        IntBuffer intBuffer6 = intBuffer3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetActiveVaryingNV;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        BufferChecks.checkBuffer(intBuffer5, 1);
        BufferChecks.checkBuffer(intBuffer6, 1);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetActiveVaryingNV(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer4), MemoryUtil.getAddress(intBuffer5), MemoryUtil.getAddress(intBuffer6), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetActiveVaryingSizeNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveVaryingNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetActiveVaryingNV(i3, i4, 0, 0, MemoryUtil.getAddress(bufferInt), MemoryUtil.getAddress(bufferInt, 1), APIUtil.getBufferByte0(capabilities), j);
        return bufferInt.get(0);
    }

    public static int glGetActiveVaryingTypeNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveVaryingNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetActiveVaryingNV(i3, i4, 0, 0, MemoryUtil.getAddress(bufferInt, 1), MemoryUtil.getAddress(bufferInt), APIUtil.getBufferByte0(capabilities), j);
        return bufferInt.get(0);
    }

    public static int glGetTransformFeedbackVaryingNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTransformFeedbackVaryingNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetTransformFeedbackVaryingNV(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetTransformFeedbackVaryingNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTransformFeedbackVaryingNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetTransformFeedbackVaryingNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetVaryingLocationNV(int i, CharSequence charSequence) {
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetVaryingLocationNV;
        BufferChecks.checkFunctionAddress(j);
        return nglGetVaryingLocationNV(i2, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glGetVaryingLocationNV(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetVaryingLocationNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglGetVaryingLocationNV(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glTransformFeedbackAttribsNV(IntBuffer intBuffer, int i) {
        IntBuffer intBuffer2 = intBuffer;
        int i2 = i;
        long j = GLContext.getCapabilities().glTransformFeedbackAttribsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 3);
        nglTransformFeedbackAttribsNV(intBuffer2.remaining() / 3, MemoryUtil.getAddress(intBuffer2), i2, j);
    }

    public static void glTransformFeedbackVaryingsNV(int i, IntBuffer intBuffer, int i2) {
        int i3 = i;
        IntBuffer intBuffer2 = intBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glTransformFeedbackVaryingsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglTransformFeedbackVaryingsNV(i3, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), i4, j);
    }

    static native void nglActiveVaryingNV(int i, long j, long j2);

    static native void nglBeginTransformFeedbackNV(int i, long j);

    static native void nglBindBufferBaseNV(int i, int i2, int i3, long j);

    static native void nglBindBufferOffsetNV(int i, int i2, int i3, long j, long j2);

    static native void nglBindBufferRangeNV(int i, int i2, int i3, long j, long j2, long j3);

    static native void nglEndTransformFeedbackNV(long j);

    static native void nglGetActiveVaryingNV(int i, int i2, int i3, long j, long j2, long j3, long j4, long j5);

    static native void nglGetTransformFeedbackVaryingNV(int i, int i2, long j, long j2);

    static native int nglGetVaryingLocationNV(int i, long j, long j2);

    static native void nglTransformFeedbackAttribsNV(int i, long j, int i2, long j2);

    static native void nglTransformFeedbackVaryingsNV(int i, int i2, long j, int i3, long j2);
}
