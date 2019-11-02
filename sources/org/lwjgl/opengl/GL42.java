package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class GL42 {
    public static final int GL_ACTIVE_ATOMIC_COUNTER_BUFFERS = 37593;
    public static final int GL_ALL_BARRIER_BITS = -1;
    public static final int GL_ATOMIC_COUNTER_BARRIER_BIT = 4096;
    public static final int GL_ATOMIC_COUNTER_BUFFER = 37568;
    public static final int GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTERS = 37573;
    public static final int GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTER_INDICES = 37574;
    public static final int GL_ATOMIC_COUNTER_BUFFER_BINDING = 37569;
    public static final int GL_ATOMIC_COUNTER_BUFFER_DATA_SIZE = 37572;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_FRAGMENT_SHADER = 37579;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_GEOMETRY_SHADER = 37578;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_CONTROL_SHADER = 37576;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_EVALUATION_SHADER = 37577;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_VERTEX_SHADER = 37575;
    public static final int GL_ATOMIC_COUNTER_BUFFER_SIZE = 37571;
    public static final int GL_ATOMIC_COUNTER_BUFFER_START = 37570;
    public static final int GL_BUFFER_UPDATE_BARRIER_BIT = 512;
    public static final int GL_COMMAND_BARRIER_BIT = 64;
    public static final int GL_COMPRESSED_RGBA_BPTC_UNORM = 36492;
    public static final int GL_COMPRESSED_RGB_BPTC_SIGNED_FLOAT = 36494;
    public static final int GL_COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT = 36495;
    public static final int GL_COMPRESSED_SRGB_ALPHA_BPTC_UNORM = 36493;
    public static final int GL_ELEMENT_ARRAY_BARRIER_BIT = 2;
    public static final int GL_FRAMEBUFFER_BARRIER_BIT = 1024;
    public static final int GL_IMAGE_1D = 36940;
    public static final int GL_IMAGE_1D_ARRAY = 36946;
    public static final int GL_IMAGE_2D = 36941;
    public static final int GL_IMAGE_2D_ARRAY = 36947;
    public static final int GL_IMAGE_2D_MULTISAMPLE = 36949;
    public static final int GL_IMAGE_2D_MULTISAMPLE_ARRAY = 36950;
    public static final int GL_IMAGE_2D_RECT = 36943;
    public static final int GL_IMAGE_3D = 36942;
    public static final int GL_IMAGE_BINDING_ACCESS = 36670;
    public static final int GL_IMAGE_BINDING_FORMAT = 36974;
    public static final int GL_IMAGE_BINDING_LAYER = 36669;
    public static final int GL_IMAGE_BINDING_LAYERED = 36668;
    public static final int GL_IMAGE_BINDING_LEVEL = 36667;
    public static final int GL_IMAGE_BINDING_NAME = 36666;
    public static final int GL_IMAGE_BUFFER = 36945;
    public static final int GL_IMAGE_CUBE = 36944;
    public static final int GL_IMAGE_CUBE_MAP_ARRAY = 36948;
    public static final int GL_IMAGE_FORMAT_COMPATIBILITY_BY_SIZE = 37064;
    public static final int GL_IMAGE_FORMAT_COMPATIBILITY_TYPE = 37063;
    public static final int GL_INT_IMAGE_1D = 36951;
    public static final int GL_INT_IMAGE_1D_ARRAY = 36957;
    public static final int GL_INT_IMAGE_2D = 36952;
    public static final int GL_INT_IMAGE_2D_ARRAY = 36958;
    public static final int GL_INT_IMAGE_2D_MULTISAMPLE = 36960;
    public static final int GL_INT_IMAGE_2D_MULTISAMPLE_ARRAY = 36961;
    public static final int GL_INT_IMAGE_2D_RECT = 36954;
    public static final int GL_INT_IMAGE_3D = 36953;
    public static final int GL_INT_IMAGE_BUFFER = 36956;
    public static final int GL_INT_IMAGE_CUBE = 36955;
    public static final int GL_INT_IMAGE_CUBE_MAP_ARRAY = 36959;
    public static final int GL_MAX_ATOMIC_COUNTER_BUFFER_BINDINGS = 37596;
    public static final int GL_MAX_ATOMIC_COUNTER_BUFFER_SIZE = 37592;
    public static final int GL_MAX_COMBINED_ATOMIC_COUNTERS = 37591;
    public static final int GL_MAX_COMBINED_ATOMIC_COUNTER_BUFFERS = 37585;
    public static final int GL_MAX_COMBINED_IMAGE_UNIFORMS = 37071;
    public static final int GL_MAX_COMBINED_IMAGE_UNITS_AND_FRAGMENT_OUTPUTS = 36665;
    public static final int GL_MAX_FRAGMENT_ATOMIC_COUNTERS = 37590;
    public static final int GL_MAX_FRAGMENT_ATOMIC_COUNTER_BUFFERS = 37584;
    public static final int GL_MAX_FRAGMENT_IMAGE_UNIFORMS = 37070;
    public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTERS = 37589;
    public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTER_BUFFERS = 37583;
    public static final int GL_MAX_GEOMETRY_IMAGE_UNIFORMS = 37069;
    public static final int GL_MAX_IMAGE_SAMPLES = 36973;
    public static final int GL_MAX_IMAGE_UNITS = 36664;
    public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTERS = 37587;
    public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTER_BUFFERS = 37581;
    public static final int GL_MAX_TESS_CONTROL_IMAGE_UNIFORMS = 37067;
    public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTERS = 37588;
    public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTER_BUFFERS = 37582;
    public static final int GL_MAX_TESS_EVALUATION_IMAGE_UNIFORMS = 37068;
    public static final int GL_MAX_VERTEX_ATOMIC_COUNTERS = 37586;
    public static final int GL_MAX_VERTEX_ATOMIC_COUNTER_BUFFERS = 37580;
    public static final int GL_MAX_VERTEX_IMAGE_UNIFORMS = 37066;
    public static final int GL_MIN_MAP_BUFFER_ALIGNMENT = 37052;
    public static final int GL_NUM_SAMPLE_COUNTS = 37760;
    public static final int GL_PACK_COMPRESSED_BLOCK_DEPTH = 37165;
    public static final int GL_PACK_COMPRESSED_BLOCK_HEIGHT = 37164;
    public static final int GL_PACK_COMPRESSED_BLOCK_SIZE = 37166;
    public static final int GL_PACK_COMPRESSED_BLOCK_WIDTH = 37163;
    public static final int GL_PIXEL_BUFFER_BARRIER_BIT = 128;
    public static final int GL_SHADER_IMAGE_ACCESS_BARRIER_BIT = 32;
    public static final int GL_TEXTURE_FETCH_BARRIER_BIT = 8;
    public static final int GL_TEXTURE_IMMUTABLE_FORMAT = 37167;
    public static final int GL_TEXTURE_UPDATE_BARRIER_BIT = 256;
    public static final int GL_TRANSFORM_FEEDBACK_BARRIER_BIT = 2048;
    public static final int GL_UNIFORM_ATOMIC_COUNTER_BUFFER_INDEX = 37594;
    public static final int GL_UNIFORM_BARRIER_BIT = 4;
    public static final int GL_UNPACK_COMPRESSED_BLOCK_DEPTH = 37161;
    public static final int GL_UNPACK_COMPRESSED_BLOCK_HEIGHT = 37160;
    public static final int GL_UNPACK_COMPRESSED_BLOCK_SIZE = 37162;
    public static final int GL_UNPACK_COMPRESSED_BLOCK_WIDTH = 37159;
    public static final int GL_UNSIGNED_INT_ATOMIC_COUNTER = 37595;
    public static final int GL_UNSIGNED_INT_IMAGE_1D = 36962;
    public static final int GL_UNSIGNED_INT_IMAGE_1D_ARRAY = 36968;
    public static final int GL_UNSIGNED_INT_IMAGE_2D = 36963;
    public static final int GL_UNSIGNED_INT_IMAGE_2D_ARRAY = 36969;
    public static final int GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE = 36971;
    public static final int GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE_ARRAY = 36972;
    public static final int GL_UNSIGNED_INT_IMAGE_2D_RECT = 36965;
    public static final int GL_UNSIGNED_INT_IMAGE_3D = 36964;
    public static final int GL_UNSIGNED_INT_IMAGE_BUFFER = 36967;
    public static final int GL_UNSIGNED_INT_IMAGE_CUBE = 36966;
    public static final int GL_UNSIGNED_INT_IMAGE_CUBE_MAP_ARRAY = 36970;
    public static final int GL_VERTEX_ATTRIB_ARRAY_BARRIER_BIT = 1;
    public static final int IMAGE_FORMAT_COMPATIBILITY_BY_CLASS = 37065;

    private GL42() {
    }

    public static void glBindImageTexture(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        boolean z2 = z;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glBindImageTexture;
        BufferChecks.checkFunctionAddress(j);
        nglBindImageTexture(i7, i8, i9, z2, i10, i11, i12, j);
    }

    public static void glDrawArraysInstancedBaseInstance(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glDrawArraysInstancedBaseInstance;
        BufferChecks.checkFunctionAddress(j);
        nglDrawArraysInstancedBaseInstance(i6, i7, i8, i9, i10, j);
    }

    public static void glDrawElementsInstancedBaseInstance(int i, int i2, int i3, long j, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        long j2 = j;
        int i9 = i4;
        int i10 = i5;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glDrawElementsInstancedBaseInstance;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureElementVBOenabled(capabilities);
        nglDrawElementsInstancedBaseInstanceBO(i6, i7, i8, j2, i9, i10, j3);
    }

    public static void glDrawElementsInstancedBaseInstance(int i, ByteBuffer byteBuffer, int i2, int i3) {
        int i4 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsInstancedBaseInstance;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglDrawElementsInstancedBaseInstance(i4, byteBuffer2.remaining(), GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(byteBuffer2), i5, i6, j);
    }

    public static void glDrawElementsInstancedBaseInstance(int i, IntBuffer intBuffer, int i2, int i3) {
        int i4 = i;
        IntBuffer intBuffer2 = intBuffer;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsInstancedBaseInstance;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglDrawElementsInstancedBaseInstance(i4, intBuffer2.remaining(), GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(intBuffer2), i5, i6, j);
    }

    public static void glDrawElementsInstancedBaseInstance(int i, ShortBuffer shortBuffer, int i2, int i3) {
        int i4 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsInstancedBaseInstance;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglDrawElementsInstancedBaseInstance(i4, shortBuffer2.remaining(), GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(shortBuffer2), i5, i6, j);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(int i, int i2, int i3, long j, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        long j2 = j;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glDrawElementsInstancedBaseVertexBaseInstance;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureElementVBOenabled(capabilities);
        nglDrawElementsInstancedBaseVertexBaseInstanceBO(i7, i8, i9, j2, i10, i11, i12, j3);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(int i, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        int i5 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsInstancedBaseVertexBaseInstance;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglDrawElementsInstancedBaseVertexBaseInstance(i5, byteBuffer2.remaining(), GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(byteBuffer2), i6, i7, i8, j);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(int i, IntBuffer intBuffer, int i2, int i3, int i4) {
        int i5 = i;
        IntBuffer intBuffer2 = intBuffer;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsInstancedBaseVertexBaseInstance;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglDrawElementsInstancedBaseVertexBaseInstance(i5, intBuffer2.remaining(), GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(intBuffer2), i6, i7, i8, j);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(int i, ShortBuffer shortBuffer, int i2, int i3, int i4) {
        int i5 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsInstancedBaseVertexBaseInstance;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglDrawElementsInstancedBaseVertexBaseInstance(i5, shortBuffer2.remaining(), GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(shortBuffer2), i6, i7, i8, j);
    }

    public static void glDrawTransformFeedbackInstanced(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glDrawTransformFeedbackInstanced;
        BufferChecks.checkFunctionAddress(j);
        nglDrawTransformFeedbackInstanced(i4, i5, i6, j);
    }

    public static void glDrawTransformFeedbackStreamInstanced(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glDrawTransformFeedbackStreamInstanced;
        BufferChecks.checkFunctionAddress(j);
        nglDrawTransformFeedbackStreamInstanced(i5, i6, i7, i8, j);
    }

    public static int glGetActiveAtomicCounterBuffer(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveAtomicCounterBufferiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetActiveAtomicCounterBufferiv(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetActiveAtomicCounterBuffer(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetActiveAtomicCounterBufferiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetActiveAtomicCounterBufferiv(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetInternalformat(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetInternalformativ;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetInternalformativ(i4, i5, i6, 1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetInternalformat(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetInternalformativ;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetInternalformativ(i4, i5, i6, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMemoryBarrier(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glMemoryBarrier;
        BufferChecks.checkFunctionAddress(j);
        nglMemoryBarrier(i2, j);
    }

    public static void glTexStorage1D(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glTexStorage1D;
        BufferChecks.checkFunctionAddress(j);
        nglTexStorage1D(i5, i6, i7, i8, j);
    }

    public static void glTexStorage2D(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glTexStorage2D;
        BufferChecks.checkFunctionAddress(j);
        nglTexStorage2D(i6, i7, i8, i9, i10, j);
    }

    public static void glTexStorage3D(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glTexStorage3D;
        BufferChecks.checkFunctionAddress(j);
        nglTexStorage3D(i7, i8, i9, i10, i11, i12, j);
    }

    static native void nglBindImageTexture(int i, int i2, int i3, boolean z, int i4, int i5, int i6, long j);

    static native void nglDrawArraysInstancedBaseInstance(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglDrawElementsInstancedBaseInstance(int i, int i2, int i3, long j, int i4, int i5, long j2);

    static native void nglDrawElementsInstancedBaseInstanceBO(int i, int i2, int i3, long j, int i4, int i5, long j2);

    static native void nglDrawElementsInstancedBaseVertexBaseInstance(int i, int i2, int i3, long j, int i4, int i5, int i6, long j2);

    static native void nglDrawElementsInstancedBaseVertexBaseInstanceBO(int i, int i2, int i3, long j, int i4, int i5, int i6, long j2);

    static native void nglDrawTransformFeedbackInstanced(int i, int i2, int i3, long j);

    static native void nglDrawTransformFeedbackStreamInstanced(int i, int i2, int i3, int i4, long j);

    static native void nglGetActiveAtomicCounterBufferiv(int i, int i2, int i3, long j, long j2);

    static native void nglGetInternalformativ(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglMemoryBarrier(int i, long j);

    static native void nglTexStorage1D(int i, int i2, int i3, int i4, long j);

    static native void nglTexStorage2D(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglTexStorage3D(int i, int i2, int i3, int i4, int i5, int i6, long j);
}
