package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVVertexBufferUnifiedMemory {
    public static final int GL_COLOR_ARRAY_ADDRESS_NV = 36643;
    public static final int GL_COLOR_ARRAY_LENGTH_NV = 36653;
    public static final int GL_EDGE_FLAG_ARRAY_ADDRESS_NV = 36646;
    public static final int GL_EDGE_FLAG_ARRAY_LENGTH_NV = 36656;
    public static final int GL_ELEMENT_ARRAY_ADDRESS_NV = 36649;
    public static final int GL_ELEMENT_ARRAY_LENGTH_NV = 36659;
    public static final int GL_ELEMENT_ARRAY_UNIFIED_NV = 36639;
    public static final int GL_FOG_COORD_ARRAY_ADDRESS_NV = 36648;
    public static final int GL_FOG_COORD_ARRAY_LENGTH_NV = 36658;
    public static final int GL_INDEX_ARRAY_ADDRESS_NV = 36644;
    public static final int GL_INDEX_ARRAY_LENGTH_NV = 36654;
    public static final int GL_NORMAL_ARRAY_ADDRESS_NV = 36642;
    public static final int GL_NORMAL_ARRAY_LENGTH_NV = 36652;
    public static final int GL_SECONDARY_COLOR_ARRAY_ADDRESS_NV = 36647;
    public static final int GL_SECONDARY_COLOR_ARRAY_LENGTH_NV = 36657;
    public static final int GL_TEXTURE_COORD_ARRAY_ADDRESS_NV = 36645;
    public static final int GL_TEXTURE_COORD_ARRAY_LENGTH_NV = 36655;
    public static final int GL_VERTEX_ARRAY_ADDRESS_NV = 36641;
    public static final int GL_VERTEX_ARRAY_LENGTH_NV = 36651;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ADDRESS_NV = 36640;
    public static final int GL_VERTEX_ATTRIB_ARRAY_LENGTH_NV = 36650;
    public static final int GL_VERTEX_ATTRIB_ARRAY_UNIFIED_NV = 36638;

    private NVVertexBufferUnifiedMemory() {
    }

    public static void glBufferAddressRangeNV(int i, int i2, long j, long j2) {
        int i3 = i;
        int i4 = i2;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glBufferAddressRangeNV;
        BufferChecks.checkFunctionAddress(j5);
        nglBufferAddressRangeNV(i3, i4, j3, j4, j5);
    }

    public static void glColorFormatNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glColorFormatNV;
        BufferChecks.checkFunctionAddress(j);
        nglColorFormatNV(i4, i5, i6, j);
    }

    public static void glEdgeFlagFormatNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glEdgeFlagFormatNV;
        BufferChecks.checkFunctionAddress(j);
        nglEdgeFlagFormatNV(i2, j);
    }

    public static void glFogCoordFormatNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glFogCoordFormatNV;
        BufferChecks.checkFunctionAddress(j);
        nglFogCoordFormatNV(i3, i4, j);
    }

    public static void glGetIntegeruNV(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetIntegerui64i_vNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglGetIntegerui64i_vNV(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static long glGetIntegerui64NV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetIntegerui64i_vNV;
        BufferChecks.checkFunctionAddress(j);
        LongBuffer bufferLong = APIUtil.getBufferLong(capabilities);
        nglGetIntegerui64i_vNV(i3, i4, MemoryUtil.getAddress(bufferLong), j);
        return bufferLong.get(0);
    }

    public static void glIndexFormatNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glIndexFormatNV;
        BufferChecks.checkFunctionAddress(j);
        nglIndexFormatNV(i3, i4, j);
    }

    public static void glNormalFormatNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNormalFormatNV;
        BufferChecks.checkFunctionAddress(j);
        nglNormalFormatNV(i3, i4, j);
    }

    public static void glSecondaryColorFormatNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glSecondaryColorFormatNV;
        BufferChecks.checkFunctionAddress(j);
        nglSecondaryColorFormatNV(i4, i5, i6, j);
    }

    public static void glTexCoordFormatNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glTexCoordFormatNV;
        BufferChecks.checkFunctionAddress(j);
        nglTexCoordFormatNV(i4, i5, i6, j);
    }

    public static void glVertexAttribFormatNV(int i, int i2, int i3, boolean z, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        boolean z2 = z;
        int i8 = i4;
        long j = GLContext.getCapabilities().glVertexAttribFormatNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribFormatNV(i5, i6, i7, z2, i8, j);
    }

    public static void glVertexAttribIFormatNV(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glVertexAttribIFormatNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribIFormatNV(i5, i6, i7, i8, j);
    }

    public static void glVertexFormatNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glVertexFormatNV;
        BufferChecks.checkFunctionAddress(j);
        nglVertexFormatNV(i4, i5, i6, j);
    }

    static native void nglBufferAddressRangeNV(int i, int i2, long j, long j2, long j3);

    static native void nglColorFormatNV(int i, int i2, int i3, long j);

    static native void nglEdgeFlagFormatNV(int i, long j);

    static native void nglFogCoordFormatNV(int i, int i2, long j);

    static native void nglGetIntegerui64i_vNV(int i, int i2, long j, long j2);

    static native void nglIndexFormatNV(int i, int i2, long j);

    static native void nglNormalFormatNV(int i, int i2, long j);

    static native void nglSecondaryColorFormatNV(int i, int i2, int i3, long j);

    static native void nglTexCoordFormatNV(int i, int i2, int i3, long j);

    static native void nglVertexAttribFormatNV(int i, int i2, int i3, boolean z, int i4, long j);

    static native void nglVertexAttribIFormatNV(int i, int i2, int i3, int i4, long j);

    static native void nglVertexFormatNV(int i, int i2, int i3, long j);
}
