package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;

public final class GL20 {
    public static final int GL_ACTIVE_ATTRIBUTES = 35721;
    public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 35722;
    public static final int GL_ACTIVE_UNIFORMS = 35718;
    public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH = 35719;
    public static final int GL_ATTACHED_SHADERS = 35717;
    public static final int GL_BLEND_EQUATION_ALPHA = 34877;
    public static final int GL_BLEND_EQUATION_RGB = 32777;
    public static final int GL_BOOL = 35670;
    public static final int GL_BOOL_VEC2 = 35671;
    public static final int GL_BOOL_VEC3 = 35672;
    public static final int GL_BOOL_VEC4 = 35673;
    public static final int GL_COMPILE_STATUS = 35713;
    public static final int GL_COORD_REPLACE = 34914;
    public static final int GL_CURRENT_PROGRAM = 35725;
    public static final int GL_CURRENT_VERTEX_ATTRIB = 34342;
    public static final int GL_DELETE_STATUS = 35712;
    public static final int GL_DRAW_BUFFER0 = 34853;
    public static final int GL_DRAW_BUFFER1 = 34854;
    public static final int GL_DRAW_BUFFER10 = 34863;
    public static final int GL_DRAW_BUFFER11 = 34864;
    public static final int GL_DRAW_BUFFER12 = 34865;
    public static final int GL_DRAW_BUFFER13 = 34866;
    public static final int GL_DRAW_BUFFER14 = 34867;
    public static final int GL_DRAW_BUFFER15 = 34868;
    public static final int GL_DRAW_BUFFER2 = 34855;
    public static final int GL_DRAW_BUFFER3 = 34856;
    public static final int GL_DRAW_BUFFER4 = 34857;
    public static final int GL_DRAW_BUFFER5 = 34858;
    public static final int GL_DRAW_BUFFER6 = 34859;
    public static final int GL_DRAW_BUFFER7 = 34860;
    public static final int GL_DRAW_BUFFER8 = 34861;
    public static final int GL_DRAW_BUFFER9 = 34862;
    public static final int GL_FLOAT_MAT2 = 35674;
    public static final int GL_FLOAT_MAT3 = 35675;
    public static final int GL_FLOAT_MAT4 = 35676;
    public static final int GL_FLOAT_VEC2 = 35664;
    public static final int GL_FLOAT_VEC3 = 35665;
    public static final int GL_FLOAT_VEC4 = 35666;
    public static final int GL_FRAGMENT_SHADER = 35632;
    public static final int GL_FRAGMENT_SHADER_DERIVATIVE_HINT = 35723;
    public static final int GL_INFO_LOG_LENGTH = 35716;
    public static final int GL_INT_VEC2 = 35667;
    public static final int GL_INT_VEC3 = 35668;
    public static final int GL_INT_VEC4 = 35669;
    public static final int GL_LINK_STATUS = 35714;
    public static final int GL_LOWER_LEFT = 36001;
    public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 35661;
    public static final int GL_MAX_DRAW_BUFFERS = 34852;
    public static final int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = 35657;
    public static final int GL_MAX_TEXTURE_COORDS = 34929;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS = 34930;
    public static final int GL_MAX_VARYING_FLOATS = 35659;
    public static final int GL_MAX_VERTEX_ATTRIBS = 34921;
    public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 35660;
    public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS = 35658;
    public static final int GL_POINT_SPRITE = 34913;
    public static final int GL_POINT_SPRITE_COORD_ORIGIN = 36000;
    public static final int GL_SAMPLER_1D = 35677;
    public static final int GL_SAMPLER_1D_SHADOW = 35681;
    public static final int GL_SAMPLER_2D = 35678;
    public static final int GL_SAMPLER_2D_SHADOW = 35682;
    public static final int GL_SAMPLER_3D = 35679;
    public static final int GL_SAMPLER_CUBE = 35680;
    public static final int GL_SHADER_OBJECT = 35656;
    public static final int GL_SHADER_SOURCE_LENGTH = 35720;
    public static final int GL_SHADER_TYPE = 35663;
    public static final int GL_SHADING_LANGUAGE_VERSION = 35724;
    public static final int GL_STENCIL_BACK_FAIL = 34817;
    public static final int GL_STENCIL_BACK_FUNC = 34816;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL = 34818;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS = 34819;
    public static final int GL_STENCIL_BACK_REF = 36003;
    public static final int GL_STENCIL_BACK_VALUE_MASK = 36004;
    public static final int GL_STENCIL_BACK_WRITEMASK = 36005;
    public static final int GL_UPPER_LEFT = 36002;
    public static final int GL_VALIDATE_STATUS = 35715;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 34338;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 34922;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 34373;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE = 34339;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 34340;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE = 34341;
    public static final int GL_VERTEX_PROGRAM_POINT_SIZE = 34370;
    public static final int GL_VERTEX_PROGRAM_TWO_SIDE = 34371;
    public static final int GL_VERTEX_SHADER = 35633;

    private GL20() {
    }

    public static void glAttachShader(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glAttachShader;
        BufferChecks.checkFunctionAddress(j);
        nglAttachShader(i3, i4, j);
    }

    public static void glBindAttribLocation(int i, int i2, CharSequence charSequence) {
        int i3 = i;
        int i4 = i2;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glBindAttribLocation;
        BufferChecks.checkFunctionAddress(j);
        nglBindAttribLocation(i3, i4, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static void glBindAttribLocation(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glBindAttribLocation;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        nglBindAttribLocation(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glBlendEquationSeparate(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBlendEquationSeparate;
        BufferChecks.checkFunctionAddress(j);
        nglBlendEquationSeparate(i3, i4, j);
    }

    public static void glCompileShader(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glCompileShader;
        BufferChecks.checkFunctionAddress(j);
        nglCompileShader(i2, j);
    }

    public static int glCreateProgram() {
        long j = GLContext.getCapabilities().glCreateProgram;
        BufferChecks.checkFunctionAddress(j);
        return nglCreateProgram(j);
    }

    public static int glCreateShader(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glCreateShader;
        BufferChecks.checkFunctionAddress(j);
        return nglCreateShader(i2, j);
    }

    public static void glDeleteProgram(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glDeleteProgram;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteProgram(i2, j);
    }

    public static void glDeleteShader(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glDeleteShader;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteShader(i2, j);
    }

    public static void glDetachShader(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glDetachShader;
        BufferChecks.checkFunctionAddress(j);
        nglDetachShader(i3, i4, j);
    }

    public static void glDisableVertexAttribArray(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glDisableVertexAttribArray;
        BufferChecks.checkFunctionAddress(j);
        nglDisableVertexAttribArray(i2, j);
    }

    public static void glDrawBuffers(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawBuffers;
        BufferChecks.checkFunctionAddress(j);
        nglDrawBuffers(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDrawBuffers(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDrawBuffers;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDrawBuffers(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glEnableVertexAttribArray(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glEnableVertexAttribArray;
        BufferChecks.checkFunctionAddress(j);
        nglEnableVertexAttribArray(i2, j);
    }

    public static String glGetActiveAttrib(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveAttrib;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetActiveAttrib(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress0((Buffer) APIUtil.getBufferInt(capabilities)), MemoryUtil.getAddress(APIUtil.getBufferInt(capabilities), 1), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static String glGetActiveAttrib(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveAttrib;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 2);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetActiveAttrib(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(intBuffer2, 1 + intBuffer2.position()), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetActiveAttrib(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer4 = intBuffer;
        IntBuffer intBuffer5 = intBuffer2;
        IntBuffer intBuffer6 = intBuffer3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetActiveAttrib;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        BufferChecks.checkBuffer(intBuffer5, 1);
        BufferChecks.checkBuffer(intBuffer6, 1);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetActiveAttrib(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer4), MemoryUtil.getAddress(intBuffer5), MemoryUtil.getAddress(intBuffer6), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetActiveAttribSize(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveAttrib;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetActiveAttrib(i3, i4, 0, 0, MemoryUtil.getAddress(bufferInt), MemoryUtil.getAddress(bufferInt, 1), APIUtil.getBufferByte0(capabilities), j);
        return bufferInt.get(0);
    }

    public static int glGetActiveAttribType(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveAttrib;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetActiveAttrib(i3, i4, 0, 0, MemoryUtil.getAddress(bufferInt, 1), MemoryUtil.getAddress(bufferInt), APIUtil.getBufferByte0(capabilities), j);
        return bufferInt.get(0);
    }

    public static String glGetActiveUniform(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveUniform;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetActiveUniform(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress0((Buffer) APIUtil.getBufferInt(capabilities)), MemoryUtil.getAddress(APIUtil.getBufferInt(capabilities), 1), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static String glGetActiveUniform(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveUniform;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 2);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetActiveUniform(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(intBuffer2, 1 + intBuffer2.position()), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetActiveUniform(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer4 = intBuffer;
        IntBuffer intBuffer5 = intBuffer2;
        IntBuffer intBuffer6 = intBuffer3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetActiveUniform;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        BufferChecks.checkBuffer(intBuffer5, 1);
        BufferChecks.checkBuffer(intBuffer6, 1);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetActiveUniform(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer4), MemoryUtil.getAddress(intBuffer5), MemoryUtil.getAddress(intBuffer6), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetActiveUniformSize(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveUniform;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetActiveUniform(i3, i4, 1, 0, MemoryUtil.getAddress(bufferInt), MemoryUtil.getAddress(bufferInt, 1), APIUtil.getBufferByte0(capabilities), j);
        return bufferInt.get(0);
    }

    public static int glGetActiveUniformType(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveUniform;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetActiveUniform(i3, i4, 0, 0, MemoryUtil.getAddress(bufferInt, 1), MemoryUtil.getAddress(bufferInt), APIUtil.getBufferByte0(capabilities), j);
        return bufferInt.get(0);
    }

    public static void glGetAttachedShaders(int i, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i2 = i;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = GLContext.getCapabilities().glGetAttachedShaders;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer3 != null) {
            BufferChecks.checkBuffer(intBuffer3, 1);
        }
        BufferChecks.checkDirect(intBuffer4);
        nglGetAttachedShaders(i2, intBuffer4.remaining(), MemoryUtil.getAddressSafe(intBuffer3), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static int glGetAttribLocation(int i, CharSequence charSequence) {
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetAttribLocation;
        BufferChecks.checkFunctionAddress(j);
        return nglGetAttribLocation(i2, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glGetAttribLocation(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetAttribLocation;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglGetAttribLocation(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    @Deprecated
    public static int glGetProgram(int i, int i2) {
        return glGetProgrami(i, i2);
    }

    public static void glGetProgram(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetProgramiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetProgramiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static String glGetProgramInfoLog(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetProgramInfoLog;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i4);
        nglGetProgramInfoLog(i3, i4, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetProgramInfoLog(int i, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetProgramInfoLog;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        BufferChecks.checkDirect(byteBuffer2);
        nglGetProgramInfoLog(i2, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetProgrami(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetProgramiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetProgramiv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    @Deprecated
    public static int glGetShader(int i, int i2) {
        return glGetShaderi(i, i2);
    }

    public static void glGetShader(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetShaderiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetShaderiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static String glGetShaderInfoLog(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetShaderInfoLog;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i4);
        nglGetShaderInfoLog(i3, i4, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetShaderInfoLog(int i, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetShaderInfoLog;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        BufferChecks.checkDirect(byteBuffer2);
        nglGetShaderInfoLog(i2, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static String glGetShaderSource(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetShaderSource;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i4);
        nglGetShaderSource(i3, i4, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetShaderSource(int i, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetShaderSource;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        BufferChecks.checkDirect(byteBuffer2);
        nglGetShaderSource(i2, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetShaderi(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetShaderiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetShaderiv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetUniform(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetUniformfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetUniformfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetUniform(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetUniformiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetUniformiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetUniformLocation(int i, CharSequence charSequence) {
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetUniformLocation;
        BufferChecks.checkFunctionAddress(j);
        return nglGetUniformLocation(i2, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glGetUniformLocation(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetUniformLocation;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 1);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglGetUniformLocation(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetVertexAttrib(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribdv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglGetVertexAttribdv(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetVertexAttrib(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetVertexAttribfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetVertexAttrib(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetVertexAttribiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static ByteBuffer glGetVertexAttribPointer(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glGetVertexAttribPointerv;
        BufferChecks.checkFunctionAddress(j3);
        ByteBuffer nglGetVertexAttribPointerv = nglGetVertexAttribPointerv(i3, i4, j2, j3);
        if (!LWJGLUtil.CHECKS || nglGetVertexAttribPointerv != null) {
            return nglGetVertexAttribPointerv.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static void glGetVertexAttribPointer(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribPointerv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, PointerBuffer.getPointerSize());
        nglGetVertexAttribPointerv2(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static boolean glIsProgram(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsProgram;
        BufferChecks.checkFunctionAddress(j);
        return nglIsProgram(i2, j);
    }

    public static boolean glIsShader(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsShader;
        BufferChecks.checkFunctionAddress(j);
        return nglIsShader(i2, j);
    }

    public static void glLinkProgram(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glLinkProgram;
        BufferChecks.checkFunctionAddress(j);
        nglLinkProgram(i2, j);
    }

    public static void glShaderSource(int i, CharSequence charSequence) {
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glShaderSource;
        BufferChecks.checkFunctionAddress(j);
        nglShaderSource(i2, 1, APIUtil.getBuffer(capabilities, charSequence2), charSequence2.length(), j);
    }

    public static void glShaderSource(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glShaderSource;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglShaderSource(i2, 1, MemoryUtil.getAddress(byteBuffer2), byteBuffer2.remaining(), j);
    }

    public static void glShaderSource(int i, CharSequence[] charSequenceArr) {
        int i2 = i;
        CharSequence[] charSequenceArr2 = charSequenceArr;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glShaderSource;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkArray(charSequenceArr2);
        nglShaderSource3(i2, charSequenceArr2.length, APIUtil.getBuffer(capabilities, charSequenceArr2), APIUtil.getLengths(capabilities, charSequenceArr2), j);
    }

    public static void glStencilFuncSeparate(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glStencilFuncSeparate;
        BufferChecks.checkFunctionAddress(j);
        nglStencilFuncSeparate(i5, i6, i7, i8, j);
    }

    public static void glStencilMaskSeparate(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glStencilMaskSeparate;
        BufferChecks.checkFunctionAddress(j);
        nglStencilMaskSeparate(i3, i4, j);
    }

    public static void glStencilOpSeparate(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glStencilOpSeparate;
        BufferChecks.checkFunctionAddress(j);
        nglStencilOpSeparate(i5, i6, i7, i8, j);
    }

    public static void glUniform1(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniform1fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniform1fv(i2, floatBuffer2.remaining(), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniform1(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform1iv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform1iv(i2, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform1f(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glUniform1f;
        BufferChecks.checkFunctionAddress(j);
        nglUniform1f(i2, f2, j);
    }

    public static void glUniform1i(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glUniform1i;
        BufferChecks.checkFunctionAddress(j);
        nglUniform1i(i3, i4, j);
    }

    public static void glUniform2(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniform2fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniform2fv(i2, floatBuffer2.remaining() >> 1, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniform2(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform2iv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform2iv(i2, intBuffer2.remaining() >> 1, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform2f(int i, float f, float f2) {
        int i2 = i;
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glUniform2f;
        BufferChecks.checkFunctionAddress(j);
        nglUniform2f(i2, f3, f4, j);
    }

    public static void glUniform2i(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glUniform2i;
        BufferChecks.checkFunctionAddress(j);
        nglUniform2i(i4, i5, i6, j);
    }

    public static void glUniform3(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniform3fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniform3fv(i2, floatBuffer2.remaining() / 3, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniform3(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform3iv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform3iv(i2, intBuffer2.remaining() / 3, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform3f(int i, float f, float f2, float f3) {
        int i2 = i;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glUniform3f;
        BufferChecks.checkFunctionAddress(j);
        nglUniform3f(i2, f4, f5, f6, j);
    }

    public static void glUniform3i(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glUniform3i;
        BufferChecks.checkFunctionAddress(j);
        nglUniform3i(i5, i6, i7, i8, j);
    }

    public static void glUniform4(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniform4fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniform4fv(i2, floatBuffer2.remaining() >> 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniform4(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform4iv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform4iv(i2, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform4f(int i, float f, float f2, float f3, float f4) {
        int i2 = i;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glUniform4f;
        BufferChecks.checkFunctionAddress(j);
        nglUniform4f(i2, f5, f6, f7, f8, j);
    }

    public static void glUniform4i(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glUniform4i;
        BufferChecks.checkFunctionAddress(j);
        nglUniform4i(i6, i7, i8, i9, i10, j);
    }

    public static void glUniformMatrix2(int i, boolean z, FloatBuffer floatBuffer) {
        int i2 = i;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix2fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniformMatrix2fv(i2, floatBuffer2.remaining() >> 2, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniformMatrix3(int i, boolean z, FloatBuffer floatBuffer) {
        int i2 = i;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix3fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniformMatrix3fv(i2, floatBuffer2.remaining() / 9, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUniformMatrix4(int i, boolean z, FloatBuffer floatBuffer) {
        int i2 = i;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix4fv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUniformMatrix4fv(i2, floatBuffer2.remaining() >> 4, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glUseProgram(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glUseProgram;
        BufferChecks.checkFunctionAddress(j);
        nglUseProgram(i2, j);
    }

    public static void glValidateProgram(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glValidateProgram;
        BufferChecks.checkFunctionAddress(j);
        nglValidateProgram(i2, j);
    }

    public static void glVertexAttrib1d(int i, double d) {
        int i2 = i;
        double d2 = d;
        long j = GLContext.getCapabilities().glVertexAttrib1d;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib1d(i2, d2, j);
    }

    public static void glVertexAttrib1f(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glVertexAttrib1f;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib1f(i2, f2, j);
    }

    public static void glVertexAttrib1s(int i, short s) {
        int i2 = i;
        short s2 = s;
        long j = GLContext.getCapabilities().glVertexAttrib1s;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib1s(i2, s2, j);
    }

    public static void glVertexAttrib2d(int i, double d, double d2) {
        int i2 = i;
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glVertexAttrib2d;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib2d(i2, d3, d4, j);
    }

    public static void glVertexAttrib2f(int i, float f, float f2) {
        int i2 = i;
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glVertexAttrib2f;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib2f(i2, f3, f4, j);
    }

    public static void glVertexAttrib2s(int i, short s, short s2) {
        int i2 = i;
        short s3 = s;
        short s4 = s2;
        long j = GLContext.getCapabilities().glVertexAttrib2s;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib2s(i2, s3, s4, j);
    }

    public static void glVertexAttrib3d(int i, double d, double d2, double d3) {
        int i2 = i;
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glVertexAttrib3d;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib3d(i2, d4, d5, d6, j);
    }

    public static void glVertexAttrib3f(int i, float f, float f2, float f3) {
        int i2 = i;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glVertexAttrib3f;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib3f(i2, f4, f5, f6, j);
    }

    public static void glVertexAttrib3s(int i, short s, short s2, short s3) {
        int i2 = i;
        short s4 = s;
        short s5 = s2;
        short s6 = s3;
        long j = GLContext.getCapabilities().glVertexAttrib3s;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib3s(i2, s4, s5, s6, j);
    }

    public static void glVertexAttrib4Nub(int i, byte b, byte b2, byte b3, byte b4) {
        int i2 = i;
        byte b5 = b;
        byte b6 = b2;
        byte b7 = b3;
        byte b8 = b4;
        long j = GLContext.getCapabilities().glVertexAttrib4Nub;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib4Nub(i2, b5, b6, b7, b8, j);
    }

    public static void glVertexAttrib4d(int i, double d, double d2, double d3, double d4) {
        int i2 = i;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glVertexAttrib4d;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib4d(i2, d5, d6, d7, d8, j);
    }

    public static void glVertexAttrib4f(int i, float f, float f2, float f3, float f4) {
        int i2 = i;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glVertexAttrib4f;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib4f(i2, f5, f6, f7, f8, j);
    }

    public static void glVertexAttrib4s(int i, short s, short s2, short s3, short s4) {
        int i2 = i;
        short s5 = s;
        short s6 = s2;
        short s7 = s3;
        short s8 = s4;
        long j = GLContext.getCapabilities().glVertexAttrib4s;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib4s(i2, s5, s6, s7, s8, j);
    }

    public static void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, long j) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        boolean z2 = z;
        int i8 = i4;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glVertexAttribPointer;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglVertexAttribPointerBO(i5, i6, i7, z2, i8, j2, j3);
    }

    public static void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        boolean z2 = z;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i5] = byteBuffer2;
        }
        nglVertexAttribPointer(i5, i6, i7, z2, i8, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexAttribPointer(int i, int i2, boolean z, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        boolean z2 = z;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i4] = doubleBuffer2;
        }
        nglVertexAttribPointer(i4, i5, 5130, z2, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribPointer(int i, int i2, boolean z, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        boolean z2 = z;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i4] = floatBuffer2;
        }
        nglVertexAttribPointer(i4, i5, GL11.GL_FLOAT, z2, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glVertexAttribPointer(int i, int i2, boolean z, boolean z2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        boolean z3 = z;
        boolean z4 = z2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i4] = byteBuffer2;
        }
        nglVertexAttribPointer(i4, i5, z3 ? 5121 : 5120, z4, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexAttribPointer(int i, int i2, boolean z, boolean z2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        boolean z3 = z;
        boolean z4 = z2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i4] = intBuffer2;
        }
        nglVertexAttribPointer(i4, i5, z3 ? 5125 : 5124, z4, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribPointer(int i, int i2, boolean z, boolean z2, int i3, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        boolean z3 = z;
        boolean z4 = z2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i4] = shortBuffer2;
        }
        nglVertexAttribPointer(i4, i5, z3 ? 5123 : 5122, z4, i6, MemoryUtil.getAddress(shortBuffer2), j);
    }

    static native void nglAttachShader(int i, int i2, long j);

    static native void nglBindAttribLocation(int i, int i2, long j, long j2);

    static native void nglBlendEquationSeparate(int i, int i2, long j);

    static native void nglCompileShader(int i, long j);

    static native int nglCreateProgram(long j);

    static native int nglCreateShader(int i, long j);

    static native void nglDeleteProgram(int i, long j);

    static native void nglDeleteShader(int i, long j);

    static native void nglDetachShader(int i, int i2, long j);

    static native void nglDisableVertexAttribArray(int i, long j);

    static native void nglDrawBuffers(int i, long j, long j2);

    static native void nglEnableVertexAttribArray(int i, long j);

    static native void nglGetActiveAttrib(int i, int i2, int i3, long j, long j2, long j3, long j4, long j5);

    static native void nglGetActiveUniform(int i, int i2, int i3, long j, long j2, long j3, long j4, long j5);

    static native void nglGetAttachedShaders(int i, int i2, long j, long j2, long j3);

    static native int nglGetAttribLocation(int i, long j, long j2);

    static native void nglGetProgramInfoLog(int i, int i2, long j, long j2, long j3);

    static native void nglGetProgramiv(int i, int i2, long j, long j2);

    static native void nglGetShaderInfoLog(int i, int i2, long j, long j2, long j3);

    static native void nglGetShaderSource(int i, int i2, long j, long j2, long j3);

    static native void nglGetShaderiv(int i, int i2, long j, long j2);

    static native int nglGetUniformLocation(int i, long j, long j2);

    static native void nglGetUniformfv(int i, int i2, long j, long j2);

    static native void nglGetUniformiv(int i, int i2, long j, long j2);

    static native ByteBuffer nglGetVertexAttribPointerv(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribPointerv2(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribdv(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribfv(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribiv(int i, int i2, long j, long j2);

    static native boolean nglIsProgram(int i, long j);

    static native boolean nglIsShader(int i, long j);

    static native void nglLinkProgram(int i, long j);

    static native void nglShaderSource(int i, int i2, long j, int i3, long j2);

    static native void nglShaderSource3(int i, int i2, long j, long j2, long j3);

    static native void nglStencilFuncSeparate(int i, int i2, int i3, int i4, long j);

    static native void nglStencilMaskSeparate(int i, int i2, long j);

    static native void nglStencilOpSeparate(int i, int i2, int i3, int i4, long j);

    static native void nglUniform1f(int i, float f, long j);

    static native void nglUniform1fv(int i, int i2, long j, long j2);

    static native void nglUniform1i(int i, int i2, long j);

    static native void nglUniform1iv(int i, int i2, long j, long j2);

    static native void nglUniform2f(int i, float f, float f2, long j);

    static native void nglUniform2fv(int i, int i2, long j, long j2);

    static native void nglUniform2i(int i, int i2, int i3, long j);

    static native void nglUniform2iv(int i, int i2, long j, long j2);

    static native void nglUniform3f(int i, float f, float f2, float f3, long j);

    static native void nglUniform3fv(int i, int i2, long j, long j2);

    static native void nglUniform3i(int i, int i2, int i3, int i4, long j);

    static native void nglUniform3iv(int i, int i2, long j, long j2);

    static native void nglUniform4f(int i, float f, float f2, float f3, float f4, long j);

    static native void nglUniform4fv(int i, int i2, long j, long j2);

    static native void nglUniform4i(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglUniform4iv(int i, int i2, long j, long j2);

    static native void nglUniformMatrix2fv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix3fv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix4fv(int i, int i2, boolean z, long j, long j2);

    static native void nglUseProgram(int i, long j);

    static native void nglValidateProgram(int i, long j);

    static native void nglVertexAttrib1d(int i, double d, long j);

    static native void nglVertexAttrib1f(int i, float f, long j);

    static native void nglVertexAttrib1s(int i, short s, long j);

    static native void nglVertexAttrib2d(int i, double d, double d2, long j);

    static native void nglVertexAttrib2f(int i, float f, float f2, long j);

    static native void nglVertexAttrib2s(int i, short s, short s2, long j);

    static native void nglVertexAttrib3d(int i, double d, double d2, double d3, long j);

    static native void nglVertexAttrib3f(int i, float f, float f2, float f3, long j);

    static native void nglVertexAttrib3s(int i, short s, short s2, short s3, long j);

    static native void nglVertexAttrib4Nub(int i, byte b, byte b2, byte b3, byte b4, long j);

    static native void nglVertexAttrib4d(int i, double d, double d2, double d3, double d4, long j);

    static native void nglVertexAttrib4f(int i, float f, float f2, float f3, float f4, long j);

    static native void nglVertexAttrib4s(int i, short s, short s2, short s3, short s4, long j);

    static native void nglVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, long j, long j2);

    static native void nglVertexAttribPointerBO(int i, int i2, int i3, boolean z, int i4, long j, long j2);
}
