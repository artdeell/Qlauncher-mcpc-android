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

public final class ARBVertexShader {
    public static final int GL_CURRENT_VERTEX_ATTRIB_ARB = 34342;
    public static final int GL_FLOAT_MAT2_ARB = 35674;
    public static final int GL_FLOAT_MAT3_ARB = 35675;
    public static final int GL_FLOAT_MAT4_ARB = 35676;
    public static final int GL_FLOAT_VEC2_ARB = 35664;
    public static final int GL_FLOAT_VEC3_ARB = 35665;
    public static final int GL_FLOAT_VEC4_ARB = 35666;
    public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS_ARB = 35661;
    public static final int GL_MAX_TEXTURE_COORDS_ARB = 34929;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS_ARB = 34930;
    public static final int GL_MAX_VARYING_FLOATS_ARB = 35659;
    public static final int GL_MAX_VERTEX_ATTRIBS_ARB = 34921;
    public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS_ARB = 35660;
    public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS_ARB = 35658;
    public static final int GL_OBJECT_ACTIVE_ATTRIBUTES_ARB = 35721;
    public static final int GL_OBJECT_ACTIVE_ATTRIBUTE_MAX_LENGTH_ARB = 35722;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB = 34338;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB = 34922;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER_ARB = 34373;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB = 34339;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB = 34340;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE_ARB = 34341;
    public static final int GL_VERTEX_PROGRAM_POINT_SIZE_ARB = 34370;
    public static final int GL_VERTEX_PROGRAM_TWO_SIDE_ARB = 34371;
    public static final int GL_VERTEX_SHADER_ARB = 35633;

    private ARBVertexShader() {
    }

    public static void glBindAttribLocationARB(int i, int i2, CharSequence charSequence) {
        int i3 = i;
        int i4 = i2;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glBindAttribLocationARB;
        BufferChecks.checkFunctionAddress(j);
        nglBindAttribLocationARB(i3, i4, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static void glBindAttribLocationARB(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glBindAttribLocationARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        nglBindAttribLocationARB(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glDisableVertexAttribArrayARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glDisableVertexAttribArrayARB;
        BufferChecks.checkFunctionAddress(j);
        nglDisableVertexAttribArrayARB(i2, j);
    }

    public static void glEnableVertexAttribArrayARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glEnableVertexAttribArrayARB;
        BufferChecks.checkFunctionAddress(j);
        nglEnableVertexAttribArrayARB(i2, j);
    }

    public static String glGetActiveAttribARB(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveAttribARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetActiveAttribARB(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress0((Buffer) APIUtil.getBufferInt(capabilities)), MemoryUtil.getAddress(APIUtil.getBufferInt(capabilities), 1), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static String glGetActiveAttribARB(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveAttribARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 2);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetActiveAttribARB(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(intBuffer2, 1 + intBuffer2.position()), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetActiveAttribARB(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer4 = intBuffer;
        IntBuffer intBuffer5 = intBuffer2;
        IntBuffer intBuffer6 = intBuffer3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetActiveAttribARB;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        BufferChecks.checkBuffer(intBuffer5, 1);
        BufferChecks.checkBuffer(intBuffer6, 1);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetActiveAttribARB(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer4), MemoryUtil.getAddress(intBuffer5), MemoryUtil.getAddress(intBuffer6), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetActiveAttribSizeARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveAttribARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetActiveAttribARB(i3, i4, 0, 0, MemoryUtil.getAddress(bufferInt), MemoryUtil.getAddress(bufferInt, 1), APIUtil.getBufferByte0(capabilities), j);
        return bufferInt.get(0);
    }

    public static int glGetActiveAttribTypeARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveAttribARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetActiveAttribARB(i3, i4, 0, 0, MemoryUtil.getAddress(bufferInt, 1), MemoryUtil.getAddress(bufferInt), APIUtil.getBufferByte0(capabilities), j);
        return bufferInt.get(0);
    }

    public static int glGetAttribLocationARB(int i, CharSequence charSequence) {
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetAttribLocationARB;
        BufferChecks.checkFunctionAddress(j);
        return nglGetAttribLocationARB(i2, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glGetAttribLocationARB(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetAttribLocationARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglGetAttribLocationARB(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetVertexAttribARB(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribdvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglGetVertexAttribdvARB(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetVertexAttribARB(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribfvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetVertexAttribfvARB(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetVertexAttribARB(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetVertexAttribivARB(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static ByteBuffer glGetVertexAttribPointerARB(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glGetVertexAttribPointervARB;
        BufferChecks.checkFunctionAddress(j3);
        ByteBuffer nglGetVertexAttribPointervARB = nglGetVertexAttribPointervARB(i3, i4, j2, j3);
        if (!LWJGLUtil.CHECKS || nglGetVertexAttribPointervARB != null) {
            return nglGetVertexAttribPointervARB.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static void glVertexAttrib1dARB(int i, double d) {
        int i2 = i;
        double d2 = d;
        long j = GLContext.getCapabilities().glVertexAttrib1dARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib1dARB(i2, d2, j);
    }

    public static void glVertexAttrib1fARB(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glVertexAttrib1fARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib1fARB(i2, f2, j);
    }

    public static void glVertexAttrib1sARB(int i, short s) {
        int i2 = i;
        short s2 = s;
        long j = GLContext.getCapabilities().glVertexAttrib1sARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib1sARB(i2, s2, j);
    }

    public static void glVertexAttrib2dARB(int i, double d, double d2) {
        int i2 = i;
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glVertexAttrib2dARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib2dARB(i2, d3, d4, j);
    }

    public static void glVertexAttrib2fARB(int i, float f, float f2) {
        int i2 = i;
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glVertexAttrib2fARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib2fARB(i2, f3, f4, j);
    }

    public static void glVertexAttrib2sARB(int i, short s, short s2) {
        int i2 = i;
        short s3 = s;
        short s4 = s2;
        long j = GLContext.getCapabilities().glVertexAttrib2sARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib2sARB(i2, s3, s4, j);
    }

    public static void glVertexAttrib3dARB(int i, double d, double d2, double d3) {
        int i2 = i;
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glVertexAttrib3dARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib3dARB(i2, d4, d5, d6, j);
    }

    public static void glVertexAttrib3fARB(int i, float f, float f2, float f3) {
        int i2 = i;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glVertexAttrib3fARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib3fARB(i2, f4, f5, f6, j);
    }

    public static void glVertexAttrib3sARB(int i, short s, short s2, short s3) {
        int i2 = i;
        short s4 = s;
        short s5 = s2;
        short s6 = s3;
        long j = GLContext.getCapabilities().glVertexAttrib3sARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib3sARB(i2, s4, s5, s6, j);
    }

    public static void glVertexAttrib4NubARB(int i, byte b, byte b2, byte b3, byte b4) {
        int i2 = i;
        byte b5 = b;
        byte b6 = b2;
        byte b7 = b3;
        byte b8 = b4;
        long j = GLContext.getCapabilities().glVertexAttrib4NubARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib4NubARB(i2, b5, b6, b7, b8, j);
    }

    public static void glVertexAttrib4dARB(int i, double d, double d2, double d3, double d4) {
        int i2 = i;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glVertexAttrib4dARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib4dARB(i2, d5, d6, d7, d8, j);
    }

    public static void glVertexAttrib4fARB(int i, float f, float f2, float f3, float f4) {
        int i2 = i;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glVertexAttrib4fARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib4fARB(i2, f5, f6, f7, f8, j);
    }

    public static void glVertexAttrib4sARB(int i, short s, short s2, short s3, short s4) {
        int i2 = i;
        short s5 = s;
        short s6 = s2;
        short s7 = s3;
        short s8 = s4;
        long j = GLContext.getCapabilities().glVertexAttrib4sARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib4sARB(i2, s5, s6, s7, s8, j);
    }

    public static void glVertexAttribPointerARB(int i, int i2, int i3, boolean z, int i4, long j) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        boolean z2 = z;
        int i8 = i4;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glVertexAttribPointerARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglVertexAttribPointerARBBO(i5, i6, i7, z2, i8, j2, j3);
    }

    public static void glVertexAttribPointerARB(int i, int i2, int i3, boolean z, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        boolean z2 = z;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointerARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i5] = byteBuffer2;
        }
        nglVertexAttribPointerARB(i5, i6, i7, z2, i8, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexAttribPointerARB(int i, int i2, boolean z, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        boolean z2 = z;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointerARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i4] = doubleBuffer2;
        }
        nglVertexAttribPointerARB(i4, i5, 5130, z2, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribPointerARB(int i, int i2, boolean z, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        boolean z2 = z;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointerARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i4] = floatBuffer2;
        }
        nglVertexAttribPointerARB(i4, i5, GL11.GL_FLOAT, z2, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glVertexAttribPointerARB(int i, int i2, boolean z, boolean z2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        boolean z3 = z;
        boolean z4 = z2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointerARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i4] = byteBuffer2;
        }
        nglVertexAttribPointerARB(i4, i5, z3 ? 5121 : 5120, z4, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexAttribPointerARB(int i, int i2, boolean z, boolean z2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        boolean z3 = z;
        boolean z4 = z2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointerARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i4] = intBuffer2;
        }
        nglVertexAttribPointerARB(i4, i5, z3 ? 5125 : 5124, z4, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribPointerARB(int i, int i2, boolean z, boolean z2, int i3, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        boolean z3 = z;
        boolean z4 = z2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribPointerARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i4] = shortBuffer2;
        }
        nglVertexAttribPointerARB(i4, i5, z3 ? 5123 : 5122, z4, i6, MemoryUtil.getAddress(shortBuffer2), j);
    }

    static native void nglBindAttribLocationARB(int i, int i2, long j, long j2);

    static native void nglDisableVertexAttribArrayARB(int i, long j);

    static native void nglEnableVertexAttribArrayARB(int i, long j);

    static native void nglGetActiveAttribARB(int i, int i2, int i3, long j, long j2, long j3, long j4, long j5);

    static native int nglGetAttribLocationARB(int i, long j, long j2);

    static native ByteBuffer nglGetVertexAttribPointervARB(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribdvARB(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribfvARB(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribivARB(int i, int i2, long j, long j2);

    static native void nglVertexAttrib1dARB(int i, double d, long j);

    static native void nglVertexAttrib1fARB(int i, float f, long j);

    static native void nglVertexAttrib1sARB(int i, short s, long j);

    static native void nglVertexAttrib2dARB(int i, double d, double d2, long j);

    static native void nglVertexAttrib2fARB(int i, float f, float f2, long j);

    static native void nglVertexAttrib2sARB(int i, short s, short s2, long j);

    static native void nglVertexAttrib3dARB(int i, double d, double d2, double d3, long j);

    static native void nglVertexAttrib3fARB(int i, float f, float f2, float f3, long j);

    static native void nglVertexAttrib3sARB(int i, short s, short s2, short s3, long j);

    static native void nglVertexAttrib4NubARB(int i, byte b, byte b2, byte b3, byte b4, long j);

    static native void nglVertexAttrib4dARB(int i, double d, double d2, double d3, double d4, long j);

    static native void nglVertexAttrib4fARB(int i, float f, float f2, float f3, float f4, long j);

    static native void nglVertexAttrib4sARB(int i, short s, short s2, short s3, short s4, long j);

    static native void nglVertexAttribPointerARB(int i, int i2, int i3, boolean z, int i4, long j, long j2);

    static native void nglVertexAttribPointerARBBO(int i, int i2, int i3, boolean z, int i4, long j, long j2);
}
