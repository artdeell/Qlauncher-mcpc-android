package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBShaderObjects {
    public static final int GL_BOOL_ARB = 35670;
    public static final int GL_BOOL_VEC2_ARB = 35671;
    public static final int GL_BOOL_VEC3_ARB = 35672;
    public static final int GL_BOOL_VEC4_ARB = 35673;
    public static final int GL_FLOAT_MAT2_ARB = 35674;
    public static final int GL_FLOAT_MAT3_ARB = 35675;
    public static final int GL_FLOAT_MAT4_ARB = 35676;
    public static final int GL_FLOAT_VEC2_ARB = 35664;
    public static final int GL_FLOAT_VEC3_ARB = 35665;
    public static final int GL_FLOAT_VEC4_ARB = 35666;
    public static final int GL_INT_VEC2_ARB = 35667;
    public static final int GL_INT_VEC3_ARB = 35668;
    public static final int GL_INT_VEC4_ARB = 35669;
    public static final int GL_OBJECT_ACTIVE_UNIFORMS_ARB = 35718;
    public static final int GL_OBJECT_ACTIVE_UNIFORM_MAX_LENGTH_ARB = 35719;
    public static final int GL_OBJECT_ATTACHED_OBJECTS_ARB = 35717;
    public static final int GL_OBJECT_COMPILE_STATUS_ARB = 35713;
    public static final int GL_OBJECT_DELETE_STATUS_ARB = 35712;
    public static final int GL_OBJECT_INFO_LOG_LENGTH_ARB = 35716;
    public static final int GL_OBJECT_LINK_STATUS_ARB = 35714;
    public static final int GL_OBJECT_SHADER_SOURCE_LENGTH_ARB = 35720;
    public static final int GL_OBJECT_SUBTYPE_ARB = 35663;
    public static final int GL_OBJECT_TYPE_ARB = 35662;
    public static final int GL_OBJECT_VALIDATE_STATUS_ARB = 35715;
    public static final int GL_PROGRAM_OBJECT_ARB = 35648;
    public static final int GL_SAMPLER_1D_ARB = 35677;
    public static final int GL_SAMPLER_1D_SHADOW_ARB = 35681;
    public static final int GL_SAMPLER_2D_ARB = 35678;
    public static final int GL_SAMPLER_2D_RECT_ARB = 35683;
    public static final int GL_SAMPLER_2D_RECT_SHADOW_ARB = 35684;
    public static final int GL_SAMPLER_2D_SHADOW_ARB = 35682;
    public static final int GL_SAMPLER_3D_ARB = 35679;
    public static final int GL_SAMPLER_CUBE_ARB = 35680;
    public static final int GL_SHADER_OBJECT_ARB = 35656;

    private ARBShaderObjects() {
    }

    public static void glAttachObjectARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glAttachObjectARB;
        BufferChecks.checkFunctionAddress(j);
        nglAttachObjectARB(i3, i4, j);
    }

    public static void glCompileShaderARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glCompileShaderARB;
        BufferChecks.checkFunctionAddress(j);
        nglCompileShaderARB(i2, j);
    }

    public static int glCreateProgramObjectARB() {
        long j = GLContext.getCapabilities().glCreateProgramObjectARB;
        BufferChecks.checkFunctionAddress(j);
        return nglCreateProgramObjectARB(j);
    }

    public static int glCreateShaderObjectARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glCreateShaderObjectARB;
        BufferChecks.checkFunctionAddress(j);
        return nglCreateShaderObjectARB(i2, j);
    }

    public static void glDeleteObjectARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glDeleteObjectARB;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteObjectARB(i2, j);
    }

    public static void glDetachObjectARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glDetachObjectARB;
        BufferChecks.checkFunctionAddress(j);
        nglDetachObjectARB(i3, i4, j);
    }

    public static String glGetActiveUniformARB(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveUniformARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetActiveUniformARB(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress0((Buffer) APIUtil.getBufferInt(capabilities)), MemoryUtil.getAddress(APIUtil.getBufferInt(capabilities), 1), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static String glGetActiveUniformARB(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveUniformARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 2);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetActiveUniformARB(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(intBuffer2, 1 + intBuffer2.position()), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetActiveUniformARB(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer4 = intBuffer;
        IntBuffer intBuffer5 = intBuffer2;
        IntBuffer intBuffer6 = intBuffer3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetActiveUniformARB;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        BufferChecks.checkBuffer(intBuffer5, 1);
        BufferChecks.checkBuffer(intBuffer6, 1);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetActiveUniformARB(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer4), MemoryUtil.getAddress(intBuffer5), MemoryUtil.getAddress(intBuffer6), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetActiveUniformSizeARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveUniformARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetActiveUniformARB(i3, i4, 0, 0, MemoryUtil.getAddress(bufferInt), MemoryUtil.getAddress(bufferInt, 1), APIUtil.getBufferByte0(capabilities), j);
        return bufferInt.get(0);
    }

    public static int glGetActiveUniformTypeARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveUniformARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetActiveUniformARB(i3, i4, 0, 0, MemoryUtil.getAddress(bufferInt, 1), MemoryUtil.getAddress(bufferInt), APIUtil.getBufferByte0(capabilities), j);
        return bufferInt.get(0);
    }

    public static void glGetAttachedObjectsARB(int i, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i2 = i;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = GLContext.getCapabilities().glGetAttachedObjectsARB;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer3 != null) {
            BufferChecks.checkBuffer(intBuffer3, 1);
        }
        BufferChecks.checkDirect(intBuffer4);
        nglGetAttachedObjectsARB(i2, intBuffer4.remaining(), MemoryUtil.getAddressSafe(intBuffer3), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static int glGetHandleARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glGetHandleARB;
        BufferChecks.checkFunctionAddress(j);
        return nglGetHandleARB(i2, j);
    }

    public static String glGetInfoLogARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetInfoLogARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i4);
        nglGetInfoLogARB(i3, i4, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetInfoLogARB(int i, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetInfoLogARB;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        BufferChecks.checkDirect(byteBuffer2);
        nglGetInfoLogARB(i2, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetObjectParameterARB(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetObjectParameterfvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetObjectParameterfvARB(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetObjectParameterARB(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetObjectParameterivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetObjectParameterivARB(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static float glGetObjectParameterfARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetObjectParameterfvARB;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetObjectParameterfvARB(i3, i4, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetObjectParameteriARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetObjectParameterivARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetObjectParameterivARB(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static String glGetShaderSourceARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetShaderSourceARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i4);
        nglGetShaderSourceARB(i3, i4, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetShaderSourceARB(int i, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetShaderSourceARB;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        BufferChecks.checkDirect(byteBuffer2);
        nglGetShaderSourceARB(i2, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetUniformARB(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetUniformfvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetUniformfvARB(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetUniformARB(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetUniformivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetUniformivARB(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetUniformLocationARB(int i, CharSequence charSequence) {
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetUniformLocationARB;
        BufferChecks.checkFunctionAddress(j);
        return nglGetUniformLocationARB(i2, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glGetUniformLocationARB(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetUniformLocationARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglGetUniformLocationARB(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glLinkProgramARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glLinkProgramARB;
        BufferChecks.checkFunctionAddress(j);
        nglLinkProgramARB(i2, j);
    }

    public static void glShaderSourceARB(int i, CharSequence charSequence) {
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glShaderSourceARB;
        BufferChecks.checkFunctionAddress(j);
        nglShaderSourceARB(i2, 1, APIUtil.getBuffer(capabilities, charSequence2), charSequence2.length(), j);
    }

    public static void glShaderSourceARB(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glShaderSourceARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglShaderSourceARB(i2, 1, MemoryUtil.getAddress(byteBuffer2), byteBuffer2.remaining(), j);
    }

    public static void glShaderSourceARB(int i, CharSequence[] charSequenceArr) {
        int i2 = i;
        CharSequence[] charSequenceArr2 = charSequenceArr;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glShaderSourceARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkArray(charSequenceArr2);
        nglShaderSourceARB3(i2, charSequenceArr2.length, APIUtil.getBuffer(capabilities, charSequenceArr2), APIUtil.getLengths(capabilities, charSequenceArr2), j);
    }

    public static void glUniform1ARB(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniform1fvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniform1fvARB(i2, floatBuffer2.remaining(), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniform1ARB(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform1ivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform1ivARB(i2, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform1fARB(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glUniform1fARB;
        BufferChecks.checkFunctionAddress(j);
        nglUniform1fARB(i2, f2, j);
    }

    public static void glUniform1iARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glUniform1iARB;
        BufferChecks.checkFunctionAddress(j);
        nglUniform1iARB(i3, i4, j);
    }

    public static void glUniform2ARB(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniform2fvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniform2fvARB(i2, floatBuffer2.remaining() >> 1, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniform2ARB(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform2ivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform2ivARB(i2, intBuffer2.remaining() >> 1, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform2fARB(int i, float f, float f2) {
        int i2 = i;
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glUniform2fARB;
        BufferChecks.checkFunctionAddress(j);
        nglUniform2fARB(i2, f3, f4, j);
    }

    public static void glUniform2iARB(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glUniform2iARB;
        BufferChecks.checkFunctionAddress(j);
        nglUniform2iARB(i4, i5, i6, j);
    }

    public static void glUniform3ARB(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniform3fvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniform3fvARB(i2, floatBuffer2.remaining() / 3, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniform3ARB(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform3ivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform3ivARB(i2, intBuffer2.remaining() / 3, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform3fARB(int i, float f, float f2, float f3) {
        int i2 = i;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glUniform3fARB;
        BufferChecks.checkFunctionAddress(j);
        nglUniform3fARB(i2, f4, f5, f6, j);
    }

    public static void glUniform3iARB(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glUniform3iARB;
        BufferChecks.checkFunctionAddress(j);
        nglUniform3iARB(i5, i6, i7, i8, j);
    }

    public static void glUniform4ARB(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniform4fvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniform4fvARB(i2, floatBuffer2.remaining() >> 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniform4ARB(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform4ivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform4ivARB(i2, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform4fARB(int i, float f, float f2, float f3, float f4) {
        int i2 = i;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glUniform4fARB;
        BufferChecks.checkFunctionAddress(j);
        nglUniform4fARB(i2, f5, f6, f7, f8, j);
    }

    public static void glUniform4iARB(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glUniform4iARB;
        BufferChecks.checkFunctionAddress(j);
        nglUniform4iARB(i6, i7, i8, i9, i10, j);
    }

    public static void glUniformMatrix2ARB(int i, boolean z, FloatBuffer floatBuffer) {
        int i2 = i;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix2fvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniformMatrix2fvARB(i2, floatBuffer2.remaining() >> 2, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniformMatrix3ARB(int i, boolean z, FloatBuffer floatBuffer) {
        int i2 = i;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix3fvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniformMatrix3fvARB(i2, floatBuffer2.remaining() / 9, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniformMatrix4ARB(int i, boolean z, FloatBuffer floatBuffer) {
        int i2 = i;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix4fvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniformMatrix4fvARB(i2, floatBuffer2.remaining() >> 4, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUseProgramObjectARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glUseProgramObjectARB;
        BufferChecks.checkFunctionAddress(j);
        nglUseProgramObjectARB(i2, j);
    }

    public static void glValidateProgramARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glValidateProgramARB;
        BufferChecks.checkFunctionAddress(j);
        nglValidateProgramARB(i2, j);
    }

    static native void nglAttachObjectARB(int i, int i2, long j);

    static native void nglCompileShaderARB(int i, long j);

    static native int nglCreateProgramObjectARB(long j);

    static native int nglCreateShaderObjectARB(int i, long j);

    static native void nglDeleteObjectARB(int i, long j);

    static native void nglDetachObjectARB(int i, int i2, long j);

    static native void nglGetActiveUniformARB(int i, int i2, int i3, long j, long j2, long j3, long j4, long j5);

    static native void nglGetAttachedObjectsARB(int i, int i2, long j, long j2, long j3);

    static native int nglGetHandleARB(int i, long j);

    static native void nglGetInfoLogARB(int i, int i2, long j, long j2, long j3);

    static native void nglGetObjectParameterfvARB(int i, int i2, long j, long j2);

    static native void nglGetObjectParameterivARB(int i, int i2, long j, long j2);

    static native void nglGetShaderSourceARB(int i, int i2, long j, long j2, long j3);

    static native int nglGetUniformLocationARB(int i, long j, long j2);

    static native void nglGetUniformfvARB(int i, int i2, long j, long j2);

    static native void nglGetUniformivARB(int i, int i2, long j, long j2);

    static native void nglLinkProgramARB(int i, long j);

    static native void nglShaderSourceARB(int i, int i2, long j, int i3, long j2);

    static native void nglShaderSourceARB3(int i, int i2, long j, long j2, long j3);

    static native void nglUniform1fARB(int i, float f, long j);

    static native void nglUniform1fvARB(int i, int i2, long j, long j2);

    static native void nglUniform1iARB(int i, int i2, long j);

    static native void nglUniform1ivARB(int i, int i2, long j, long j2);

    static native void nglUniform2fARB(int i, float f, float f2, long j);

    static native void nglUniform2fvARB(int i, int i2, long j, long j2);

    static native void nglUniform2iARB(int i, int i2, int i3, long j);

    static native void nglUniform2ivARB(int i, int i2, long j, long j2);

    static native void nglUniform3fARB(int i, float f, float f2, float f3, long j);

    static native void nglUniform3fvARB(int i, int i2, long j, long j2);

    static native void nglUniform3iARB(int i, int i2, int i3, int i4, long j);

    static native void nglUniform3ivARB(int i, int i2, long j, long j2);

    static native void nglUniform4fARB(int i, float f, float f2, float f3, float f4, long j);

    static native void nglUniform4fvARB(int i, int i2, long j, long j2);

    static native void nglUniform4iARB(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglUniform4ivARB(int i, int i2, long j, long j2);

    static native void nglUniformMatrix2fvARB(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix3fvARB(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix4fvARB(int i, int i2, boolean z, long j, long j2);

    static native void nglUseProgramObjectARB(int i, long j);

    static native void nglValidateProgramARB(int i, long j);
}
