package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class GL33 {
    public static final int GL_ANY_SAMPLES_PASSED = 35887;
    public static final int GL_INT_2_10_10_10_REV = 36255;
    public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068;
    public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067;
    public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
    public static final int GL_RGB10_A2UI = 36975;
    public static final int GL_SAMPLER_BINDING = 35097;
    public static final int GL_SRC1_ALPHA = 34185;
    public static final int GL_SRC1_COLOR = 35065;
    public static final int GL_TEXTURE_SWIZZLE_A = 36421;
    public static final int GL_TEXTURE_SWIZZLE_B = 36420;
    public static final int GL_TEXTURE_SWIZZLE_G = 36419;
    public static final int GL_TEXTURE_SWIZZLE_R = 36418;
    public static final int GL_TEXTURE_SWIZZLE_RGBA = 36422;
    public static final int GL_TIMESTAMP = 36392;
    public static final int GL_TIME_ELAPSED = 35007;
    public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR = 35070;

    private GL33() {
    }

    public static void glBindFragDataLocationIndexed(int i, int i2, int i3, CharSequence charSequence) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glBindFragDataLocationIndexed;
        BufferChecks.checkFunctionAddress(j);
        nglBindFragDataLocationIndexed(i4, i5, i6, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static void glBindFragDataLocationIndexed(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glBindFragDataLocationIndexed;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        nglBindFragDataLocationIndexed(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glBindSampler(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBindSampler;
        BufferChecks.checkFunctionAddress(j);
        nglBindSampler(i3, i4, j);
    }

    public static void glColorP3u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glColorP3uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 3);
        nglColorP3uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glColorP3ui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glColorP3ui;
        BufferChecks.checkFunctionAddress(j);
        nglColorP3ui(i3, i4, j);
    }

    public static void glColorP4u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glColorP4uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglColorP4uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glColorP4ui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glColorP4ui;
        BufferChecks.checkFunctionAddress(j);
        nglColorP4ui(i3, i4, j);
    }

    public static void glDeleteSamplers(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteSamplers;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteSamplers(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteSamplers(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteSamplers;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteSamplers(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGenSamplers() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenSamplers;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenSamplers(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenSamplers(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenSamplers;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenSamplers(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetFragDataIndex(int i, CharSequence charSequence) {
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetFragDataIndex;
        BufferChecks.checkFunctionAddress(j);
        return nglGetFragDataIndex(i2, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glGetFragDataIndex(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetFragDataIndex;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglGetFragDataIndex(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    @Deprecated
    public static long glGetQueryObject(int i, int i2) {
        return glGetQueryObjecti64(i, i2);
    }

    public static void glGetQueryObject(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetQueryObjecti64v;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglGetQueryObjecti64v(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static long glGetQueryObjecti64(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetQueryObjecti64v;
        BufferChecks.checkFunctionAddress(j);
        LongBuffer bufferLong = APIUtil.getBufferLong(capabilities);
        nglGetQueryObjecti64v(i3, i4, MemoryUtil.getAddress(bufferLong), j);
        return bufferLong.get(0);
    }

    @Deprecated
    public static long glGetQueryObjectu(int i, int i2) {
        return glGetQueryObjectui64(i, i2);
    }

    public static void glGetQueryObjectu(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetQueryObjectui64v;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglGetQueryObjectui64v(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static long glGetQueryObjectui64(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetQueryObjectui64v;
        BufferChecks.checkFunctionAddress(j);
        LongBuffer bufferLong = APIUtil.getBufferLong(capabilities);
        nglGetQueryObjectui64v(i3, i4, MemoryUtil.getAddress(bufferLong), j);
        return bufferLong.get(0);
    }

    public static void glGetSamplerParameter(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetSamplerParameterfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetSamplerParameterfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetSamplerParameter(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetSamplerParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetSamplerParameteriv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetSamplerParameterI(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetSamplerParameterIiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetSamplerParameterIiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetSamplerParameterIi(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSamplerParameterIiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetSamplerParameterIiv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetSamplerParameterIu(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetSamplerParameterIuiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetSamplerParameterIuiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetSamplerParameterIui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSamplerParameterIuiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetSamplerParameterIuiv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static float glGetSamplerParameterf(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSamplerParameterfv;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetSamplerParameterfv(i3, i4, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetSamplerParameteri(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSamplerParameteriv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetSamplerParameteriv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static boolean glIsSampler(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsSampler;
        BufferChecks.checkFunctionAddress(j);
        return nglIsSampler(i2, j);
    }

    public static void glMultiTexCoordP1u(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glMultiTexCoordP1uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglMultiTexCoordP1uiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMultiTexCoordP1ui(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glMultiTexCoordP1ui;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoordP1ui(i4, i5, i6, j);
    }

    public static void glMultiTexCoordP2u(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glMultiTexCoordP2uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 2);
        nglMultiTexCoordP2uiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMultiTexCoordP2ui(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glMultiTexCoordP2ui;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoordP2ui(i4, i5, i6, j);
    }

    public static void glMultiTexCoordP3u(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glMultiTexCoordP3uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 3);
        nglMultiTexCoordP3uiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMultiTexCoordP3ui(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glMultiTexCoordP3ui;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoordP3ui(i4, i5, i6, j);
    }

    public static void glMultiTexCoordP4u(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glMultiTexCoordP4uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglMultiTexCoordP4uiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMultiTexCoordP4ui(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glMultiTexCoordP4ui;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoordP4ui(i4, i5, i6, j);
    }

    public static void glNormalP3u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glNormalP3uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 3);
        nglNormalP3uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glNormalP3ui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNormalP3ui;
        BufferChecks.checkFunctionAddress(j);
        nglNormalP3ui(i3, i4, j);
    }

    public static void glQueryCounter(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glQueryCounter;
        BufferChecks.checkFunctionAddress(j);
        nglQueryCounter(i3, i4, j);
    }

    public static void glSamplerParameter(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glSamplerParameterfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglSamplerParameterfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glSamplerParameter(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glSamplerParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglSamplerParameteriv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glSamplerParameterI(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glSamplerParameterIiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglSamplerParameterIiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glSamplerParameterIu(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glSamplerParameterIuiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglSamplerParameterIuiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glSamplerParameterf(int i, int i2, float f) {
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        long j = GLContext.getCapabilities().glSamplerParameterf;
        BufferChecks.checkFunctionAddress(j);
        nglSamplerParameterf(i3, i4, f2, j);
    }

    public static void glSamplerParameteri(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glSamplerParameteri;
        BufferChecks.checkFunctionAddress(j);
        nglSamplerParameteri(i4, i5, i6, j);
    }

    public static void glSecondaryColorP3u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glSecondaryColorP3uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 3);
        nglSecondaryColorP3uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glSecondaryColorP3ui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glSecondaryColorP3ui;
        BufferChecks.checkFunctionAddress(j);
        nglSecondaryColorP3ui(i3, i4, j);
    }

    public static void glTexCoordP1u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTexCoordP1uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglTexCoordP1uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexCoordP1ui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glTexCoordP1ui;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoordP1ui(i3, i4, j);
    }

    public static void glTexCoordP2u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTexCoordP2uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 2);
        nglTexCoordP2uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexCoordP2ui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glTexCoordP2ui;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoordP2ui(i3, i4, j);
    }

    public static void glTexCoordP3u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTexCoordP3uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 3);
        nglTexCoordP3uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexCoordP3ui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glTexCoordP3ui;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoordP3ui(i3, i4, j);
    }

    public static void glTexCoordP4u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTexCoordP4uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglTexCoordP4uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexCoordP4ui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glTexCoordP4ui;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoordP4ui(i3, i4, j);
    }

    public static void glVertexAttribDivisor(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glVertexAttribDivisor;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribDivisor(i3, i4, j);
    }

    public static void glVertexAttribP1u(int i, int i2, boolean z, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribP1uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglVertexAttribP1uiv(i3, i4, z2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribP1ui(int i, int i2, boolean z, int i3) {
        int i4 = i;
        int i5 = i2;
        boolean z2 = z;
        int i6 = i3;
        long j = GLContext.getCapabilities().glVertexAttribP1ui;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribP1ui(i4, i5, z2, i6, j);
    }

    public static void glVertexAttribP2u(int i, int i2, boolean z, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribP2uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 2);
        nglVertexAttribP2uiv(i3, i4, z2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribP2ui(int i, int i2, boolean z, int i3) {
        int i4 = i;
        int i5 = i2;
        boolean z2 = z;
        int i6 = i3;
        long j = GLContext.getCapabilities().glVertexAttribP2ui;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribP2ui(i4, i5, z2, i6, j);
    }

    public static void glVertexAttribP3u(int i, int i2, boolean z, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribP3uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 3);
        nglVertexAttribP3uiv(i3, i4, z2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribP3ui(int i, int i2, boolean z, int i3) {
        int i4 = i;
        int i5 = i2;
        boolean z2 = z;
        int i6 = i3;
        long j = GLContext.getCapabilities().glVertexAttribP3ui;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribP3ui(i4, i5, z2, i6, j);
    }

    public static void glVertexAttribP4u(int i, int i2, boolean z, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribP4uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglVertexAttribP4uiv(i3, i4, z2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribP4ui(int i, int i2, boolean z, int i3) {
        int i4 = i;
        int i5 = i2;
        boolean z2 = z;
        int i6 = i3;
        long j = GLContext.getCapabilities().glVertexAttribP4ui;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribP4ui(i4, i5, z2, i6, j);
    }

    public static void glVertexP2u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexP2uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 2);
        nglVertexP2uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexP2ui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glVertexP2ui;
        BufferChecks.checkFunctionAddress(j);
        nglVertexP2ui(i3, i4, j);
    }

    public static void glVertexP3u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexP3uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 3);
        nglVertexP3uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexP3ui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glVertexP3ui;
        BufferChecks.checkFunctionAddress(j);
        nglVertexP3ui(i3, i4, j);
    }

    public static void glVertexP4u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexP4uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglVertexP4uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexP4ui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glVertexP4ui;
        BufferChecks.checkFunctionAddress(j);
        nglVertexP4ui(i3, i4, j);
    }

    static native void nglBindFragDataLocationIndexed(int i, int i2, int i3, long j, long j2);

    static native void nglBindSampler(int i, int i2, long j);

    static native void nglColorP3ui(int i, int i2, long j);

    static native void nglColorP3uiv(int i, long j, long j2);

    static native void nglColorP4ui(int i, int i2, long j);

    static native void nglColorP4uiv(int i, long j, long j2);

    static native void nglDeleteSamplers(int i, long j, long j2);

    static native void nglGenSamplers(int i, long j, long j2);

    static native int nglGetFragDataIndex(int i, long j, long j2);

    static native void nglGetQueryObjecti64v(int i, int i2, long j, long j2);

    static native void nglGetQueryObjectui64v(int i, int i2, long j, long j2);

    static native void nglGetSamplerParameterIiv(int i, int i2, long j, long j2);

    static native void nglGetSamplerParameterIuiv(int i, int i2, long j, long j2);

    static native void nglGetSamplerParameterfv(int i, int i2, long j, long j2);

    static native void nglGetSamplerParameteriv(int i, int i2, long j, long j2);

    static native boolean nglIsSampler(int i, long j);

    static native void nglMultiTexCoordP1ui(int i, int i2, int i3, long j);

    static native void nglMultiTexCoordP1uiv(int i, int i2, long j, long j2);

    static native void nglMultiTexCoordP2ui(int i, int i2, int i3, long j);

    static native void nglMultiTexCoordP2uiv(int i, int i2, long j, long j2);

    static native void nglMultiTexCoordP3ui(int i, int i2, int i3, long j);

    static native void nglMultiTexCoordP3uiv(int i, int i2, long j, long j2);

    static native void nglMultiTexCoordP4ui(int i, int i2, int i3, long j);

    static native void nglMultiTexCoordP4uiv(int i, int i2, long j, long j2);

    static native void nglNormalP3ui(int i, int i2, long j);

    static native void nglNormalP3uiv(int i, long j, long j2);

    static native void nglQueryCounter(int i, int i2, long j);

    static native void nglSamplerParameterIiv(int i, int i2, long j, long j2);

    static native void nglSamplerParameterIuiv(int i, int i2, long j, long j2);

    static native void nglSamplerParameterf(int i, int i2, float f, long j);

    static native void nglSamplerParameterfv(int i, int i2, long j, long j2);

    static native void nglSamplerParameteri(int i, int i2, int i3, long j);

    static native void nglSamplerParameteriv(int i, int i2, long j, long j2);

    static native void nglSecondaryColorP3ui(int i, int i2, long j);

    static native void nglSecondaryColorP3uiv(int i, long j, long j2);

    static native void nglTexCoordP1ui(int i, int i2, long j);

    static native void nglTexCoordP1uiv(int i, long j, long j2);

    static native void nglTexCoordP2ui(int i, int i2, long j);

    static native void nglTexCoordP2uiv(int i, long j, long j2);

    static native void nglTexCoordP3ui(int i, int i2, long j);

    static native void nglTexCoordP3uiv(int i, long j, long j2);

    static native void nglTexCoordP4ui(int i, int i2, long j);

    static native void nglTexCoordP4uiv(int i, long j, long j2);

    static native void nglVertexAttribDivisor(int i, int i2, long j);

    static native void nglVertexAttribP1ui(int i, int i2, boolean z, int i3, long j);

    static native void nglVertexAttribP1uiv(int i, int i2, boolean z, long j, long j2);

    static native void nglVertexAttribP2ui(int i, int i2, boolean z, int i3, long j);

    static native void nglVertexAttribP2uiv(int i, int i2, boolean z, long j, long j2);

    static native void nglVertexAttribP3ui(int i, int i2, boolean z, int i3, long j);

    static native void nglVertexAttribP3uiv(int i, int i2, boolean z, long j, long j2);

    static native void nglVertexAttribP4ui(int i, int i2, boolean z, int i3, long j);

    static native void nglVertexAttribP4uiv(int i, int i2, boolean z, long j, long j2);

    static native void nglVertexP2ui(int i, int i2, long j);

    static native void nglVertexP2uiv(int i, long j, long j2);

    static native void nglVertexP3ui(int i, int i2, long j);

    static native void nglVertexP3uiv(int i, long j, long j2);

    static native void nglVertexP4ui(int i, int i2, long j);

    static native void nglVertexP4uiv(int i, long j, long j2);
}
