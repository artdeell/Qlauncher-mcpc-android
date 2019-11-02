package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ATIVertexAttribArrayObject {
    private ATIVertexAttribArrayObject() {
    }

    public static void glGetVertexAttribArrayObjectATI(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribArrayObjectfvATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetVertexAttribArrayObjectfvATI(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetVertexAttribArrayObjectATI(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribArrayObjectivATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetVertexAttribArrayObjectivATI(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribArrayObjectATI(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        boolean z2 = z;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glVertexAttribArrayObjectATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribArrayObjectATI(i7, i8, i9, z2, i10, i11, i12, j);
    }

    static native void nglGetVertexAttribArrayObjectfvATI(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribArrayObjectivATI(int i, int i2, long j, long j2);

    static native void nglVertexAttribArrayObjectATI(int i, int i2, int i3, boolean z, int i4, int i5, int i6, long j);
}
