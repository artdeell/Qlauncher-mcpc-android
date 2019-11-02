package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class EXTGpuShader4 {
    public static final int GL_INT_SAMPLER_1D_ARRAY_EXT = 36302;
    public static final int GL_INT_SAMPLER_1D_EXT = 36297;
    public static final int GL_INT_SAMPLER_2D_ARRAY_EXT = 36303;
    public static final int GL_INT_SAMPLER_2D_EXT = 36298;
    public static final int GL_INT_SAMPLER_2D_RECT_EXT = 36301;
    public static final int GL_INT_SAMPLER_3D_EXT = 36299;
    public static final int GL_INT_SAMPLER_BUFFER_EXT = 36304;
    public static final int GL_INT_SAMPLER_CUBE_EXT = 36300;
    public static final int GL_MAX_PROGRAM_TEXEL_OFFSET_EXT = 35077;
    public static final int GL_MIN_PROGRAM_TEXEL_OFFSET_EXT = 35076;
    public static final int GL_SAMPLER_1D_ARRAY_EXT = 36288;
    public static final int GL_SAMPLER_1D_ARRAY_SHADOW_EXT = 36291;
    public static final int GL_SAMPLER_2D_ARRAY_EXT = 36289;
    public static final int GL_SAMPLER_2D_ARRAY_SHADOW_EXT = 36292;
    public static final int GL_SAMPLER_BUFFER_EXT = 36290;
    public static final int GL_SAMPLER_CUBE_SHADOW_EXT = 36293;
    public static final int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY_EXT = 36310;
    public static final int GL_UNSIGNED_INT_SAMPLER_1D_EXT = 36305;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY_EXT = 36311;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_EXT = 36306;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT_EXT = 36309;
    public static final int GL_UNSIGNED_INT_SAMPLER_3D_EXT = 36307;
    public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER_EXT = 36312;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_EXT = 36308;
    public static final int GL_UNSIGNED_INT_VEC2_EXT = 36294;
    public static final int GL_UNSIGNED_INT_VEC3_EXT = 36295;
    public static final int GL_UNSIGNED_INT_VEC4_EXT = 36296;
    public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER_EXT = 35069;

    private EXTGpuShader4() {
    }

    public static void glBindFragDataLocationEXT(int i, int i2, CharSequence charSequence) {
        int i3 = i;
        int i4 = i2;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glBindFragDataLocationEXT;
        BufferChecks.checkFunctionAddress(j);
        nglBindFragDataLocationEXT(i3, i4, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static void glBindFragDataLocationEXT(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glBindFragDataLocationEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        nglBindFragDataLocationEXT(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetFragDataLocationEXT(int i, CharSequence charSequence) {
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetFragDataLocationEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglGetFragDataLocationEXT(i2, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glGetFragDataLocationEXT(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetFragDataLocationEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglGetFragDataLocationEXT(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetUniformuEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetUniformuivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetUniformuivEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetVertexAttribIEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribIivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetVertexAttribIivEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetVertexAttribIuEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribIuivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetVertexAttribIuivEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform1uEXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform1uivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform1uivEXT(i2, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform1uiEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glUniform1uiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglUniform1uiEXT(i3, i4, j);
    }

    public static void glUniform2uEXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform2uivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform2uivEXT(i2, intBuffer2.remaining() >> 1, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform2uiEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glUniform2uiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglUniform2uiEXT(i4, i5, i6, j);
    }

    public static void glUniform3uEXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform3uivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform3uivEXT(i2, intBuffer2.remaining() / 3, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform3uiEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glUniform3uiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglUniform3uiEXT(i5, i6, i7, i8, j);
    }

    public static void glUniform4uEXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform4uivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform4uivEXT(i2, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform4uiEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glUniform4uiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglUniform4uiEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glVertexAttribI1EXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI1ivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglVertexAttribI1ivEXT(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI1iEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glVertexAttribI1iEXT;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI1iEXT(i3, i4, j);
    }

    public static void glVertexAttribI1uEXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI1uivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglVertexAttribI1uivEXT(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI1uiEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glVertexAttribI1uiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI1uiEXT(i3, i4, j);
    }

    public static void glVertexAttribI2EXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI2ivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 2);
        nglVertexAttribI2ivEXT(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI2iEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glVertexAttribI2iEXT;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI2iEXT(i4, i5, i6, j);
    }

    public static void glVertexAttribI2uEXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI2uivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 2);
        nglVertexAttribI2uivEXT(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI2uiEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glVertexAttribI2uiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI2uiEXT(i4, i5, i6, j);
    }

    public static void glVertexAttribI3EXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI3ivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 3);
        nglVertexAttribI3ivEXT(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI3iEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glVertexAttribI3iEXT;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI3iEXT(i5, i6, i7, i8, j);
    }

    public static void glVertexAttribI3uEXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI3uivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 3);
        nglVertexAttribI3uivEXT(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI3uiEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glVertexAttribI3uiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI3uiEXT(i5, i6, i7, i8, j);
    }

    public static void glVertexAttribI4EXT(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI4bvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 4);
        nglVertexAttribI4bvEXT(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexAttribI4EXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI4ivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglVertexAttribI4ivEXT(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI4EXT(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI4svEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(shortBuffer2, 4);
        nglVertexAttribI4svEXT(i2, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glVertexAttribI4iEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glVertexAttribI4iEXT;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI4iEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glVertexAttribI4uEXT(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI4ubvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 4);
        nglVertexAttribI4ubvEXT(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexAttribI4uEXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI4uivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglVertexAttribI4uivEXT(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI4uEXT(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI4usvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(shortBuffer2, 4);
        nglVertexAttribI4usvEXT(i2, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glVertexAttribI4uiEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glVertexAttribI4uiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI4uiEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glVertexAttribIPointerEXT(int i, int i2, int i3, int i4, long j) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glVertexAttribIPointerEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglVertexAttribIPointerEXTBO(i5, i6, i7, i8, j2, j3);
    }

    public static void glVertexAttribIPointerEXT(int i, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribIPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i5] = byteBuffer2;
        }
        nglVertexAttribIPointerEXT(i5, i6, i7, i8, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexAttribIPointerEXT(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribIPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i5] = intBuffer2;
        }
        nglVertexAttribIPointerEXT(i5, i6, i7, i8, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribIPointerEXT(int i, int i2, int i3, int i4, ShortBuffer shortBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribIPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i5] = shortBuffer2;
        }
        nglVertexAttribIPointerEXT(i5, i6, i7, i8, MemoryUtil.getAddress(shortBuffer2), j);
    }

    static native void nglBindFragDataLocationEXT(int i, int i2, long j, long j2);

    static native int nglGetFragDataLocationEXT(int i, long j, long j2);

    static native void nglGetUniformuivEXT(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribIivEXT(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribIuivEXT(int i, int i2, long j, long j2);

    static native void nglUniform1uiEXT(int i, int i2, long j);

    static native void nglUniform1uivEXT(int i, int i2, long j, long j2);

    static native void nglUniform2uiEXT(int i, int i2, int i3, long j);

    static native void nglUniform2uivEXT(int i, int i2, long j, long j2);

    static native void nglUniform3uiEXT(int i, int i2, int i3, int i4, long j);

    static native void nglUniform3uivEXT(int i, int i2, long j, long j2);

    static native void nglUniform4uiEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglUniform4uivEXT(int i, int i2, long j, long j2);

    static native void nglVertexAttribI1iEXT(int i, int i2, long j);

    static native void nglVertexAttribI1ivEXT(int i, long j, long j2);

    static native void nglVertexAttribI1uiEXT(int i, int i2, long j);

    static native void nglVertexAttribI1uivEXT(int i, long j, long j2);

    static native void nglVertexAttribI2iEXT(int i, int i2, int i3, long j);

    static native void nglVertexAttribI2ivEXT(int i, long j, long j2);

    static native void nglVertexAttribI2uiEXT(int i, int i2, int i3, long j);

    static native void nglVertexAttribI2uivEXT(int i, long j, long j2);

    static native void nglVertexAttribI3iEXT(int i, int i2, int i3, int i4, long j);

    static native void nglVertexAttribI3ivEXT(int i, long j, long j2);

    static native void nglVertexAttribI3uiEXT(int i, int i2, int i3, int i4, long j);

    static native void nglVertexAttribI3uivEXT(int i, long j, long j2);

    static native void nglVertexAttribI4bvEXT(int i, long j, long j2);

    static native void nglVertexAttribI4iEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglVertexAttribI4ivEXT(int i, long j, long j2);

    static native void nglVertexAttribI4svEXT(int i, long j, long j2);

    static native void nglVertexAttribI4ubvEXT(int i, long j, long j2);

    static native void nglVertexAttribI4uiEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglVertexAttribI4uivEXT(int i, long j, long j2);

    static native void nglVertexAttribI4usvEXT(int i, long j, long j2);

    static native void nglVertexAttribIPointerEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglVertexAttribIPointerEXTBO(int i, int i2, int i3, int i4, long j, long j2);
}
