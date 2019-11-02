package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;

public final class CL10GL {
    public static final int CL_GL_MIPMAP_LEVEL = 8197;
    public static final int CL_GL_OBJECT_BUFFER = 8192;
    public static final int CL_GL_OBJECT_RENDERBUFFER = 8195;
    public static final int CL_GL_OBJECT_TEXTURE2D = 8193;
    public static final int CL_GL_OBJECT_TEXTURE3D = 8194;
    public static final int CL_GL_TEXTURE_TARGET = 8196;

    private CL10GL() {
    }

    public static CLMem clCreateFromGLBuffer(CLContext cLContext, long j, int i, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateFromGLBuffer;
        BufferChecks.checkFunctionAddress(j3);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateFromGLBuffer(cLContext2.getPointer(), j2, i2, MemoryUtil.getAddressSafe(intBuffer2), j3), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateFromGLRenderbuffer(CLContext cLContext, long j, int i, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateFromGLRenderbuffer;
        BufferChecks.checkFunctionAddress(j3);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateFromGLRenderbuffer(cLContext2.getPointer(), j2, i2, MemoryUtil.getAddressSafe(intBuffer2), j3), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateFromGLTexture2D(CLContext cLContext, long j, int i, int i2, int i3, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateFromGLTexture2D;
        BufferChecks.checkFunctionAddress(j3);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateFromGLTexture2D(cLContext2.getPointer(), j2, i4, i5, i6, MemoryUtil.getAddressSafe(intBuffer2), j3), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateFromGLTexture3D(CLContext cLContext, long j, int i, int i2, int i3, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateFromGLTexture3D;
        BufferChecks.checkFunctionAddress(j3);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateFromGLTexture3D(cLContext2.getPointer(), j2, i4, i5, i6, MemoryUtil.getAddressSafe(intBuffer2), j3), cLContext2);
        return cLMem2;
    }

    public static int clEnqueueAcquireGLObjects(CLCommandQueue cLCommandQueue, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        PointerBuffer pointerBuffer4 = pointerBuffer;
        PointerBuffer pointerBuffer5 = pointerBuffer2;
        PointerBuffer pointerBuffer6 = pointerBuffer3;
        long j = CLCapabilities.clEnqueueAcquireGLObjects;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(pointerBuffer4, 1);
        if (pointerBuffer5 != null) {
            BufferChecks.checkDirect(pointerBuffer5);
        }
        if (pointerBuffer6 != null) {
            BufferChecks.checkBuffer(pointerBuffer6, 1);
        }
        int nclEnqueueAcquireGLObjects = nclEnqueueAcquireGLObjects(cLCommandQueue2.getPointer(), pointerBuffer4.remaining(), MemoryUtil.getAddress(pointerBuffer4), pointerBuffer5 == null ? 0 : pointerBuffer5.remaining(), MemoryUtil.getAddressSafe(pointerBuffer5), MemoryUtil.getAddressSafe(pointerBuffer6), j);
        if (nclEnqueueAcquireGLObjects == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer6);
        }
        return nclEnqueueAcquireGLObjects;
    }

    public static int clEnqueueAcquireGLObjects(CLCommandQueue cLCommandQueue, CLMem cLMem, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j = CLCapabilities.clEnqueueAcquireGLObjects;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueAcquireGLObjects = nclEnqueueAcquireGLObjects(cLCommandQueue2.getPointer(), 1, APIUtil.getPointer(cLMem2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j);
        if (nclEnqueueAcquireGLObjects == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueAcquireGLObjects;
    }

    public static int clEnqueueReleaseGLObjects(CLCommandQueue cLCommandQueue, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        PointerBuffer pointerBuffer4 = pointerBuffer;
        PointerBuffer pointerBuffer5 = pointerBuffer2;
        PointerBuffer pointerBuffer6 = pointerBuffer3;
        long j = CLCapabilities.clEnqueueReleaseGLObjects;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(pointerBuffer4, 1);
        if (pointerBuffer5 != null) {
            BufferChecks.checkDirect(pointerBuffer5);
        }
        if (pointerBuffer6 != null) {
            BufferChecks.checkBuffer(pointerBuffer6, 1);
        }
        int nclEnqueueReleaseGLObjects = nclEnqueueReleaseGLObjects(cLCommandQueue2.getPointer(), pointerBuffer4.remaining(), MemoryUtil.getAddress(pointerBuffer4), pointerBuffer5 == null ? 0 : pointerBuffer5.remaining(), MemoryUtil.getAddressSafe(pointerBuffer5), MemoryUtil.getAddressSafe(pointerBuffer6), j);
        if (nclEnqueueReleaseGLObjects == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer6);
        }
        return nclEnqueueReleaseGLObjects;
    }

    public static int clEnqueueReleaseGLObjects(CLCommandQueue cLCommandQueue, CLMem cLMem, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j = CLCapabilities.clEnqueueReleaseGLObjects;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueReleaseGLObjects = nclEnqueueReleaseGLObjects(cLCommandQueue2.getPointer(), 1, APIUtil.getPointer(cLMem2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j);
        if (nclEnqueueReleaseGLObjects == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueReleaseGLObjects;
    }

    public static int clGetGLObjectInfo(CLMem cLMem, IntBuffer intBuffer, IntBuffer intBuffer2) {
        CLMem cLMem2 = cLMem;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = CLCapabilities.clGetGLObjectInfo;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer3 != null) {
            BufferChecks.checkBuffer(intBuffer3, 1);
        }
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        return nclGetGLObjectInfo(cLMem2.getPointer(), MemoryUtil.getAddressSafe(intBuffer3), MemoryUtil.getAddressSafe(intBuffer4), j);
    }

    public static int clGetGLTextureInfo(CLMem cLMem, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLMem cLMem2 = cLMem;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetGLTextureInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetGLTextureInfo(cLMem2.getPointer(), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    static native long nclCreateFromGLBuffer(long j, long j2, int i, long j3, long j4);

    static native long nclCreateFromGLRenderbuffer(long j, long j2, int i, long j3, long j4);

    static native long nclCreateFromGLTexture2D(long j, long j2, int i, int i2, int i3, long j3, long j4);

    static native long nclCreateFromGLTexture3D(long j, long j2, int i, int i2, int i3, long j3, long j4);

    static native int nclEnqueueAcquireGLObjects(long j, int i, long j2, int i2, long j3, long j4, long j5);

    static native int nclEnqueueReleaseGLObjects(long j, int i, long j2, int i2, long j3, long j4, long j5);

    static native int nclGetGLObjectInfo(long j, long j2, long j3, long j4);

    static native int nclGetGLTextureInfo(long j, int i, long j2, long j3, long j4, long j5);
}
