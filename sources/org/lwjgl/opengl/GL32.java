package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class GL32 {
    public static final int GL_ALREADY_SIGNALED = 37146;
    public static final int GL_CONDITION_SATISFIED = 37148;
    public static final int GL_CONTEXT_COMPATIBILITY_PROFILE_BIT = 2;
    public static final int GL_CONTEXT_CORE_PROFILE_BIT = 1;
    public static final int GL_CONTEXT_PROFILE_MASK = 37158;
    public static final int GL_DEPTH_CLAMP = 34383;
    public static final int GL_FIRST_VERTEX_CONVENTION = 36429;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED = 36263;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 36052;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS = 36264;
    public static final int GL_GEOMETRY_INPUT_TYPE = 36315;
    public static final int GL_GEOMETRY_OUTPUT_TYPE = 36316;
    public static final int GL_GEOMETRY_SHADER = 36313;
    public static final int GL_GEOMETRY_VERTICES_OUT = 36314;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE = 37129;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37132;
    public static final int GL_LAST_VERTEX_CONVENTION = 36430;
    public static final int GL_LINES_ADJACENCY = 10;
    public static final int GL_LINE_STRIP_ADJACENCY = 11;
    public static final int GL_MAX_COLOR_TEXTURE_SAMPLES = 37134;
    public static final int GL_MAX_DEPTH_TEXTURE_SAMPLES = 37135;
    public static final int GL_MAX_FRAGMENT_INPUT_COMPONENTS = 37157;
    public static final int GL_MAX_GEOMETRY_INPUT_COMPONENTS = 37155;
    public static final int GL_MAX_GEOMETRY_OUTPUT_COMPONENTS = 37156;
    public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES = 36320;
    public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS = 35881;
    public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS = 36321;
    public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS = 36319;
    public static final int GL_MAX_INTEGER_SAMPLES = 37136;
    public static final int GL_MAX_SAMPLE_MASK_WORDS = 36441;
    public static final int GL_MAX_SERVER_WAIT_TIMEOUT = 37137;
    public static final int GL_MAX_VARYING_COMPONENTS = 35659;
    public static final int GL_MAX_VERTEX_OUTPUT_COMPONENTS = 37154;
    public static final int GL_OBJECT_TYPE = 37138;
    public static final int GL_PROGRAM_POINT_SIZE = 34370;
    public static final int GL_PROVOKING_VERTEX = 36431;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE = 37121;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY = 37123;
    public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION = 36428;
    public static final int GL_SAMPLER_2D_MULTISAMPLE = 37128;
    public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 37131;
    public static final int GL_SAMPLE_MASK = 36433;
    public static final int GL_SAMPLE_MASK_VALUE = 36434;
    public static final int GL_SAMPLE_POSITION = 36432;
    public static final int GL_SIGNALED = 37145;
    public static final int GL_SYNC_CONDITION = 37139;
    public static final int GL_SYNC_FENCE = 37142;
    public static final int GL_SYNC_FLAGS = 37141;
    public static final int GL_SYNC_FLUSH_COMMANDS_BIT = 1;
    public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 37143;
    public static final int GL_SYNC_STATUS = 37140;
    public static final int GL_TEXTURE_2D_MULTISAMPLE = 37120;
    public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 37122;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 37124;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 37125;
    public static final int GL_TEXTURE_CUBE_MAP_SEAMLESS = 34895;
    public static final int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS = 37127;
    public static final int GL_TEXTURE_SAMPLES = 37126;
    public static final int GL_TIMEOUT_EXPIRED = 37147;
    public static final long GL_TIMEOUT_IGNORED = -1;
    public static final int GL_TRIANGLES_ADJACENCY = 12;
    public static final int GL_TRIANGLE_STRIP_ADJACENCY = 13;
    public static final int GL_UNSIGNALED = 37144;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = 37130;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37133;
    public static final int GL_WAIT_FAILED = 37149;

    private GL32() {
    }

    public static int glClientWaitSync(GLSync gLSync, int i, long j) {
        GLSync gLSync2 = gLSync;
        int i2 = i;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glClientWaitSync;
        BufferChecks.checkFunctionAddress(j3);
        return nglClientWaitSync(gLSync2.getPointer(), i2, j2, j3);
    }

    public static void glDeleteSync(GLSync gLSync) {
        GLSync gLSync2 = gLSync;
        long j = GLContext.getCapabilities().glDeleteSync;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteSync(gLSync2.getPointer(), j);
    }

    public static void glDrawElementsBaseVertex(int i, int i2, int i3, long j, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        long j2 = j;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glDrawElementsBaseVertex;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureElementVBOenabled(capabilities);
        nglDrawElementsBaseVertexBO(i5, i6, i7, j2, i8, j3);
    }

    public static void glDrawElementsBaseVertex(int i, ByteBuffer byteBuffer, int i2) {
        int i3 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsBaseVertex;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglDrawElementsBaseVertex(i3, byteBuffer2.remaining(), GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(byteBuffer2), i4, j);
    }

    public static void glDrawElementsBaseVertex(int i, IntBuffer intBuffer, int i2) {
        int i3 = i;
        IntBuffer intBuffer2 = intBuffer;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsBaseVertex;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglDrawElementsBaseVertex(i3, intBuffer2.remaining(), GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(intBuffer2), i4, j);
    }

    public static void glDrawElementsBaseVertex(int i, ShortBuffer shortBuffer, int i2) {
        int i3 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsBaseVertex;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglDrawElementsBaseVertex(i3, shortBuffer2.remaining(), GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(shortBuffer2), i4, j);
    }

    public static void glDrawElementsInstancedBaseVertex(int i, int i2, int i3, long j, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        long j2 = j;
        int i9 = i4;
        int i10 = i5;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glDrawElementsInstancedBaseVertex;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureElementVBOenabled(capabilities);
        nglDrawElementsInstancedBaseVertexBO(i6, i7, i8, j2, i9, i10, j3);
    }

    public static void glDrawElementsInstancedBaseVertex(int i, ByteBuffer byteBuffer, int i2, int i3) {
        int i4 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsInstancedBaseVertex;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglDrawElementsInstancedBaseVertex(i4, byteBuffer2.remaining(), GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(byteBuffer2), i5, i6, j);
    }

    public static void glDrawElementsInstancedBaseVertex(int i, IntBuffer intBuffer, int i2, int i3) {
        int i4 = i;
        IntBuffer intBuffer2 = intBuffer;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsInstancedBaseVertex;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglDrawElementsInstancedBaseVertex(i4, intBuffer2.remaining(), GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(intBuffer2), i5, i6, j);
    }

    public static void glDrawElementsInstancedBaseVertex(int i, ShortBuffer shortBuffer, int i2, int i3) {
        int i4 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsInstancedBaseVertex;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglDrawElementsInstancedBaseVertex(i4, shortBuffer2.remaining(), GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(shortBuffer2), i5, i6, j);
    }

    public static void glDrawRangeElementsBaseVertex(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        long j2 = j;
        int i12 = i6;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glDrawRangeElementsBaseVertex;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureElementVBOenabled(capabilities);
        nglDrawRangeElementsBaseVertexBO(i7, i8, i9, i10, i11, j2, i12, j3);
    }

    public static void glDrawRangeElementsBaseVertex(int i, int i2, int i3, ByteBuffer byteBuffer, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawRangeElementsBaseVertex;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglDrawRangeElementsBaseVertex(i5, i6, i7, byteBuffer2.remaining(), GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(byteBuffer2), i8, j);
    }

    public static void glDrawRangeElementsBaseVertex(int i, int i2, int i3, IntBuffer intBuffer, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        IntBuffer intBuffer2 = intBuffer;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawRangeElementsBaseVertex;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglDrawRangeElementsBaseVertex(i5, i6, i7, intBuffer2.remaining(), GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(intBuffer2), i8, j);
    }

    public static void glDrawRangeElementsBaseVertex(int i, int i2, int i3, ShortBuffer shortBuffer, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawRangeElementsBaseVertex;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglDrawRangeElementsBaseVertex(i5, i6, i7, shortBuffer2.remaining(), GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(shortBuffer2), i8, j);
    }

    public static GLSync glFenceSync(int i, int i2) {
        GLSync gLSync;
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glFenceSync;
        BufferChecks.checkFunctionAddress(j);
        GLSync gLSync2 = gLSync;
        GLSync gLSync3 = new GLSync(nglFenceSync(i3, i4, j));
        return gLSync2;
    }

    public static void glFramebufferTexture(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glFramebufferTexture;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferTexture(i5, i6, i7, i8, j);
    }

    @Deprecated
    public static long glGetBufferParameter(int i, int i2) {
        return glGetBufferParameteri64(i, i2);
    }

    public static void glGetBufferParameter(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetBufferParameteri64v;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 4);
        nglGetBufferParameteri64v(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static long glGetBufferParameteri64(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetBufferParameteri64v;
        BufferChecks.checkFunctionAddress(j);
        LongBuffer bufferLong = APIUtil.getBufferLong(capabilities);
        nglGetBufferParameteri64v(i3, i4, MemoryUtil.getAddress(bufferLong), j);
        return bufferLong.get(0);
    }

    public static long glGetInteger64(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetInteger64v;
        BufferChecks.checkFunctionAddress(j);
        LongBuffer bufferLong = APIUtil.getBufferLong(capabilities);
        nglGetInteger64v(i2, MemoryUtil.getAddress(bufferLong), j);
        return bufferLong.get(0);
    }

    public static long glGetInteger64(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetInteger64i_v;
        BufferChecks.checkFunctionAddress(j);
        LongBuffer bufferLong = APIUtil.getBufferLong(capabilities);
        nglGetInteger64i_v(i3, i4, MemoryUtil.getAddress(bufferLong), j);
        return bufferLong.get(0);
    }

    public static void glGetInteger64(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetInteger64i_v;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 4);
        nglGetInteger64i_v(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glGetInteger64(int i, LongBuffer longBuffer) {
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetInteger64v;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglGetInteger64v(i2, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static void glGetMultisample(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetMultisamplefv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 2);
        nglGetMultisamplefv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    @Deprecated
    public static int glGetSync(GLSync gLSync, int i) {
        return glGetSynci(gLSync, i);
    }

    public static void glGetSync(GLSync gLSync, int i, IntBuffer intBuffer, IntBuffer intBuffer2) {
        GLSync gLSync2 = gLSync;
        int i2 = i;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = GLContext.getCapabilities().glGetSynciv;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer3 != null) {
            BufferChecks.checkBuffer(intBuffer3, 1);
        }
        BufferChecks.checkDirect(intBuffer4);
        nglGetSynciv(gLSync2.getPointer(), i2, intBuffer4.remaining(), MemoryUtil.getAddressSafe(intBuffer3), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static int glGetSynci(GLSync gLSync, int i) {
        GLSync gLSync2 = gLSync;
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSynciv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetSynciv(gLSync2.getPointer(), i2, 1, 0, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static boolean glIsSync(GLSync gLSync) {
        GLSync gLSync2 = gLSync;
        long j = GLContext.getCapabilities().glIsSync;
        BufferChecks.checkFunctionAddress(j);
        return nglIsSync(gLSync2.getPointer(), j);
    }

    public static void glProvokingVertex(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glProvokingVertex;
        BufferChecks.checkFunctionAddress(j);
        nglProvokingVertex(i2, j);
    }

    public static void glSampleMaski(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glSampleMaski;
        BufferChecks.checkFunctionAddress(j);
        nglSampleMaski(i3, i4, j);
    }

    public static void glTexImage2DMultisample(int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glTexImage2DMultisample;
        BufferChecks.checkFunctionAddress(j);
        nglTexImage2DMultisample(i6, i7, i8, i9, i10, z2, j);
    }

    public static void glTexImage3DMultisample(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glTexImage3DMultisample;
        BufferChecks.checkFunctionAddress(j);
        nglTexImage3DMultisample(i7, i8, i9, i10, i11, i12, z2, j);
    }

    public static void glWaitSync(GLSync gLSync, int i, long j) {
        GLSync gLSync2 = gLSync;
        int i2 = i;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glWaitSync;
        BufferChecks.checkFunctionAddress(j3);
        nglWaitSync(gLSync2.getPointer(), i2, j2, j3);
    }

    static native int nglClientWaitSync(long j, int i, long j2, long j3);

    static native void nglDeleteSync(long j, long j2);

    static native void nglDrawElementsBaseVertex(int i, int i2, int i3, long j, int i4, long j2);

    static native void nglDrawElementsBaseVertexBO(int i, int i2, int i3, long j, int i4, long j2);

    static native void nglDrawElementsInstancedBaseVertex(int i, int i2, int i3, long j, int i4, int i5, long j2);

    static native void nglDrawElementsInstancedBaseVertexBO(int i, int i2, int i3, long j, int i4, int i5, long j2);

    static native void nglDrawRangeElementsBaseVertex(int i, int i2, int i3, int i4, int i5, long j, int i6, long j2);

    static native void nglDrawRangeElementsBaseVertexBO(int i, int i2, int i3, int i4, int i5, long j, int i6, long j2);

    static native long nglFenceSync(int i, int i2, long j);

    static native void nglFramebufferTexture(int i, int i2, int i3, int i4, long j);

    static native void nglGetBufferParameteri64v(int i, int i2, long j, long j2);

    static native void nglGetInteger64i_v(int i, int i2, long j, long j2);

    static native void nglGetInteger64v(int i, long j, long j2);

    static native void nglGetMultisamplefv(int i, int i2, long j, long j2);

    static native void nglGetSynciv(long j, int i, int i2, long j2, long j3, long j4);

    static native boolean nglIsSync(long j, long j2);

    static native void nglProvokingVertex(int i, long j);

    static native void nglSampleMaski(int i, int i2, long j);

    static native void nglTexImage2DMultisample(int i, int i2, int i3, int i4, int i5, boolean z, long j);

    static native void nglTexImage3DMultisample(int i, int i2, int i3, int i4, int i5, int i6, boolean z, long j);

    static native void nglWaitSync(long j, int i, long j2, long j3);
}
