package org.lwjgl.opengl;

import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVHalfFloat {
    public static final int GL_HALF_FLOAT_NV = 5131;

    private NVHalfFloat() {
    }

    public static void glColor3hNV(short s, short s2, short s3) {
        short s4 = s;
        short s5 = s2;
        short s6 = s3;
        long j = GLContext.getCapabilities().glColor3hNV;
        BufferChecks.checkFunctionAddress(j);
        nglColor3hNV(s4, s5, s6, j);
    }

    public static void glColor4hNV(short s, short s2, short s3, short s4) {
        short s5 = s;
        short s6 = s2;
        short s7 = s3;
        short s8 = s4;
        long j = GLContext.getCapabilities().glColor4hNV;
        BufferChecks.checkFunctionAddress(j);
        nglColor4hNV(s5, s6, s7, s8, j);
    }

    public static void glFogCoordhNV(short s) {
        short s2 = s;
        long j = GLContext.getCapabilities().glFogCoordhNV;
        BufferChecks.checkFunctionAddress(j);
        nglFogCoordhNV(s2, j);
    }

    public static void glMultiTexCoord1hNV(int i, short s) {
        int i2 = i;
        short s2 = s;
        long j = GLContext.getCapabilities().glMultiTexCoord1hNV;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord1hNV(i2, s2, j);
    }

    public static void glMultiTexCoord2hNV(int i, short s, short s2) {
        int i2 = i;
        short s3 = s;
        short s4 = s2;
        long j = GLContext.getCapabilities().glMultiTexCoord2hNV;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord2hNV(i2, s3, s4, j);
    }

    public static void glMultiTexCoord3hNV(int i, short s, short s2, short s3) {
        int i2 = i;
        short s4 = s;
        short s5 = s2;
        short s6 = s3;
        long j = GLContext.getCapabilities().glMultiTexCoord3hNV;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord3hNV(i2, s4, s5, s6, j);
    }

    public static void glMultiTexCoord4hNV(int i, short s, short s2, short s3, short s4) {
        int i2 = i;
        short s5 = s;
        short s6 = s2;
        short s7 = s3;
        short s8 = s4;
        long j = GLContext.getCapabilities().glMultiTexCoord4hNV;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord4hNV(i2, s5, s6, s7, s8, j);
    }

    public static void glNormal3hNV(short s, short s2, short s3) {
        short s4 = s;
        short s5 = s2;
        short s6 = s3;
        long j = GLContext.getCapabilities().glNormal3hNV;
        BufferChecks.checkFunctionAddress(j);
        nglNormal3hNV(s4, s5, s6, j);
    }

    public static void glSecondaryColor3hNV(short s, short s2, short s3) {
        short s4 = s;
        short s5 = s2;
        short s6 = s3;
        long j = GLContext.getCapabilities().glSecondaryColor3hNV;
        BufferChecks.checkFunctionAddress(j);
        nglSecondaryColor3hNV(s4, s5, s6, j);
    }

    public static void glTexCoord1hNV(short s) {
        short s2 = s;
        long j = GLContext.getCapabilities().glTexCoord1hNV;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoord1hNV(s2, j);
    }

    public static void glTexCoord2hNV(short s, short s2) {
        short s3 = s;
        short s4 = s2;
        long j = GLContext.getCapabilities().glTexCoord2hNV;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoord2hNV(s3, s4, j);
    }

    public static void glTexCoord3hNV(short s, short s2, short s3) {
        short s4 = s;
        short s5 = s2;
        short s6 = s3;
        long j = GLContext.getCapabilities().glTexCoord3hNV;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoord3hNV(s4, s5, s6, j);
    }

    public static void glTexCoord4hNV(short s, short s2, short s3, short s4) {
        short s5 = s;
        short s6 = s2;
        short s7 = s3;
        short s8 = s4;
        long j = GLContext.getCapabilities().glTexCoord4hNV;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoord4hNV(s5, s6, s7, s8, j);
    }

    public static void glVertex2hNV(short s, short s2) {
        short s3 = s;
        short s4 = s2;
        long j = GLContext.getCapabilities().glVertex2hNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertex2hNV(s3, s4, j);
    }

    public static void glVertex3hNV(short s, short s2, short s3) {
        short s4 = s;
        short s5 = s2;
        short s6 = s3;
        long j = GLContext.getCapabilities().glVertex3hNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertex3hNV(s4, s5, s6, j);
    }

    public static void glVertex4hNV(short s, short s2, short s3, short s4) {
        short s5 = s;
        short s6 = s2;
        short s7 = s3;
        short s8 = s4;
        long j = GLContext.getCapabilities().glVertex4hNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertex4hNV(s5, s6, s7, s8, j);
    }

    public static void glVertexAttrib1hNV(int i, short s) {
        int i2 = i;
        short s2 = s;
        long j = GLContext.getCapabilities().glVertexAttrib1hNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib1hNV(i2, s2, j);
    }

    public static void glVertexAttrib2hNV(int i, short s, short s2) {
        int i2 = i;
        short s3 = s;
        short s4 = s2;
        long j = GLContext.getCapabilities().glVertexAttrib2hNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib2hNV(i2, s3, s4, j);
    }

    public static void glVertexAttrib3hNV(int i, short s, short s2, short s3) {
        int i2 = i;
        short s4 = s;
        short s5 = s2;
        short s6 = s3;
        long j = GLContext.getCapabilities().glVertexAttrib3hNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib3hNV(i2, s4, s5, s6, j);
    }

    public static void glVertexAttrib4hNV(int i, short s, short s2, short s3, short s4) {
        int i2 = i;
        short s5 = s;
        short s6 = s2;
        short s7 = s3;
        short s8 = s4;
        long j = GLContext.getCapabilities().glVertexAttrib4hNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttrib4hNV(i2, s5, s6, s7, s8, j);
    }

    public static void glVertexAttribs1NV(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs1hvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglVertexAttribs1hvNV(i2, shortBuffer2.remaining(), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glVertexAttribs2NV(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs2hvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglVertexAttribs2hvNV(i2, shortBuffer2.remaining() >> 1, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glVertexAttribs3NV(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs3hvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglVertexAttribs3hvNV(i2, shortBuffer2.remaining() / 3, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glVertexAttribs4NV(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVertexAttribs4hvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglVertexAttribs4hvNV(i2, shortBuffer2.remaining() >> 2, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glVertexWeighthNV(short s) {
        short s2 = s;
        long j = GLContext.getCapabilities().glVertexWeighthNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexWeighthNV(s2, j);
    }

    static native void nglColor3hNV(short s, short s2, short s3, long j);

    static native void nglColor4hNV(short s, short s2, short s3, short s4, long j);

    static native void nglFogCoordhNV(short s, long j);

    static native void nglMultiTexCoord1hNV(int i, short s, long j);

    static native void nglMultiTexCoord2hNV(int i, short s, short s2, long j);

    static native void nglMultiTexCoord3hNV(int i, short s, short s2, short s3, long j);

    static native void nglMultiTexCoord4hNV(int i, short s, short s2, short s3, short s4, long j);

    static native void nglNormal3hNV(short s, short s2, short s3, long j);

    static native void nglSecondaryColor3hNV(short s, short s2, short s3, long j);

    static native void nglTexCoord1hNV(short s, long j);

    static native void nglTexCoord2hNV(short s, short s2, long j);

    static native void nglTexCoord3hNV(short s, short s2, short s3, long j);

    static native void nglTexCoord4hNV(short s, short s2, short s3, short s4, long j);

    static native void nglVertex2hNV(short s, short s2, long j);

    static native void nglVertex3hNV(short s, short s2, short s3, long j);

    static native void nglVertex4hNV(short s, short s2, short s3, short s4, long j);

    static native void nglVertexAttrib1hNV(int i, short s, long j);

    static native void nglVertexAttrib2hNV(int i, short s, short s2, long j);

    static native void nglVertexAttrib3hNV(int i, short s, short s2, short s3, long j);

    static native void nglVertexAttrib4hNV(int i, short s, short s2, short s3, short s4, long j);

    static native void nglVertexAttribs1hvNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribs2hvNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribs3hvNV(int i, int i2, long j, long j2);

    static native void nglVertexAttribs4hvNV(int i, int i2, long j, long j2);

    static native void nglVertexWeighthNV(short s, long j);
}
