package org.lwjgl.opencl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class CL12GL {
    public static final int CL_GL_OBJECT_TEXTURE1D = 8207;
    public static final int CL_GL_OBJECT_TEXTURE1D_ARRAY = 8208;
    public static final int CL_GL_OBJECT_TEXTURE2D_ARRAY = 8206;
    public static final int CL_GL_OBJECT_TEXTURE_BUFFER = 8209;

    private CL12GL() {
    }

    public static CLMem clCreateFromGLTexture(CLContext cLContext, long j, int i, int i2, int i3, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateFromGLTexture;
        BufferChecks.checkFunctionAddress(j3);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateFromGLTexture(cLContext2.getPointer(), j2, i4, i5, i6, MemoryUtil.getAddressSafe(intBuffer2), j3), cLContext2);
        return cLMem2;
    }

    static native long nclCreateFromGLTexture(long j, long j2, int i, int i2, int i3, long j3, long j4);
}
