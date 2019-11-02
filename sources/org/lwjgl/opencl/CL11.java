package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;

public final class CL11 {
    public static final int CL_ADDRESS_MIRRORED_REPEAT = 4404;
    public static final int CL_BUFFER_CREATE_TYPE_REGION = 4640;
    public static final int CL_COMMAND_COPY_BUFFER_RECT = 4611;
    public static final int CL_COMMAND_READ_BUFFER_RECT = 4609;
    public static final int CL_COMMAND_USER = 4612;
    public static final int CL_COMMAND_WRITE_BUFFER_RECT = 4610;
    public static final int CL_CONTEXT_NUM_DEVICES = 4227;
    public static final int CL_DEVICE_HOST_UNIFIED_MEMORY = 4149;
    public static final int CL_DEVICE_NATIVE_VECTOR_WIDTH_CHAR = 4150;
    public static final int CL_DEVICE_NATIVE_VECTOR_WIDTH_DOUBLE = 4155;
    public static final int CL_DEVICE_NATIVE_VECTOR_WIDTH_FLOAT = 4154;
    public static final int CL_DEVICE_NATIVE_VECTOR_WIDTH_HALF = 4156;
    public static final int CL_DEVICE_NATIVE_VECTOR_WIDTH_INT = 4152;
    public static final int CL_DEVICE_NATIVE_VECTOR_WIDTH_LONG = 4153;
    public static final int CL_DEVICE_NATIVE_VECTOR_WIDTH_SHORT = 4151;
    public static final int CL_DEVICE_OPENCL_C_VERSION = 4157;
    public static final int CL_DEVICE_PREFERRED_VECTOR_WIDTH_HALF = 4148;
    public static final int CL_EVENT_CONTEXT = 4564;
    public static final int CL_EXEC_STATUS_ERROR_FOR_EVENTS_IN_WAIT_LIST = -14;
    public static final int CL_FP_SOFT_FLOAT = 64;
    public static final int CL_INVALID_PROPERTY = -64;
    public static final int CL_KERNEL_PREFERRED_WORK_GROUP_SIZE_MULTIPLE = 4531;
    public static final int CL_KERNEL_PRIVATE_MEM_SIZE = 4532;
    public static final int CL_MEM_ASSOCIATED_MEMOBJECT = 4359;
    public static final int CL_MEM_OFFSET = 4360;
    public static final int CL_MISALIGNED_SUB_BUFFER_OFFSET = -13;
    public static final int CL_RGBx = 4284;
    public static final int CL_RGx = 4283;
    public static final int CL_Rx = 4282;
    public static final int CL_VERSION_1_1 = 1;

    private CL11() {
    }

    public static CLMem clCreateSubBuffer(CLMem cLMem, long j, int i, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        CLMem cLMem2 = cLMem;
        long j2 = j;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateSubBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkBuffer(byteBuffer2, 2 * PointerBuffer.getPointerSize());
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        return CLMem.create(nclCreateSubBuffer(cLMem2.getPointer(), j2, i2, MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j3), (CLContext) cLMem2.getParent());
    }

    public static CLEvent clCreateUserEvent(CLContext cLContext, IntBuffer intBuffer) {
        CLEvent cLEvent;
        CLContext cLContext2 = cLContext;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateUserEvent;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLEvent cLEvent2 = cLEvent;
        CLEvent cLEvent3 = new CLEvent(nclCreateUserEvent(cLContext2.getPointer(), MemoryUtil.getAddressSafe(intBuffer2), j), cLContext2);
        return cLEvent2;
    }

    public static int clEnqueueCopyBufferRect(CLCommandQueue cLCommandQueue, CLMem cLMem, CLMem cLMem2, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, long j, long j2, long j3, long j4, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem3 = cLMem;
        CLMem cLMem4 = cLMem2;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j9 = CLCapabilities.clEnqueueCopyBufferRect;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueCopyBufferRect = nclEnqueueCopyBufferRect(cLCommandQueue2.getPointer(), cLMem3.getPointer(), cLMem4.getPointer(), MemoryUtil.getAddress(pointerBuffer6), MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), j5, j6, j7, j8, pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j9);
        if (nclEnqueueCopyBufferRect == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueCopyBufferRect;
    }

    public static int clEnqueueReadBufferRect(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, long j, long j2, long j3, long j4, ByteBuffer byteBuffer, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j9 = CLCapabilities.clEnqueueReadBufferRect;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        BufferChecks.checkBuffer(byteBuffer2, CLChecks.calculateBufferRectSize(pointerBuffer7, pointerBuffer8, j7, j8));
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueReadBufferRect = nclEnqueueReadBufferRect(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer6), MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), j5, j6, j7, j8, MemoryUtil.getAddress(byteBuffer2), pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j9);
        if (nclEnqueueReadBufferRect == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueReadBufferRect;
    }

    public static int clEnqueueReadBufferRect(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, long j, long j2, long j3, long j4, DoubleBuffer doubleBuffer, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j9 = CLCapabilities.clEnqueueReadBufferRect;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        BufferChecks.checkBuffer(doubleBuffer2, CLChecks.calculateBufferRectSize(pointerBuffer7, pointerBuffer8, j7, j8));
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueReadBufferRect = nclEnqueueReadBufferRect(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer6), MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), j5, j6, j7, j8, MemoryUtil.getAddress(doubleBuffer2), pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j9);
        if (nclEnqueueReadBufferRect == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueReadBufferRect;
    }

    public static int clEnqueueReadBufferRect(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, long j, long j2, long j3, long j4, FloatBuffer floatBuffer, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        FloatBuffer floatBuffer2 = floatBuffer;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j9 = CLCapabilities.clEnqueueReadBufferRect;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        BufferChecks.checkBuffer(floatBuffer2, CLChecks.calculateBufferRectSize(pointerBuffer7, pointerBuffer8, j7, j8));
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueReadBufferRect = nclEnqueueReadBufferRect(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer6), MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), j5, j6, j7, j8, MemoryUtil.getAddress(floatBuffer2), pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j9);
        if (nclEnqueueReadBufferRect == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueReadBufferRect;
    }

    public static int clEnqueueReadBufferRect(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, long j, long j2, long j3, long j4, IntBuffer intBuffer, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        IntBuffer intBuffer2 = intBuffer;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j9 = CLCapabilities.clEnqueueReadBufferRect;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        BufferChecks.checkBuffer(intBuffer2, CLChecks.calculateBufferRectSize(pointerBuffer7, pointerBuffer8, j7, j8));
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueReadBufferRect = nclEnqueueReadBufferRect(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer6), MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), j5, j6, j7, j8, MemoryUtil.getAddress(intBuffer2), pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j9);
        if (nclEnqueueReadBufferRect == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueReadBufferRect;
    }

    public static int clEnqueueReadBufferRect(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, long j, long j2, long j3, long j4, LongBuffer longBuffer, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        LongBuffer longBuffer2 = longBuffer;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j9 = CLCapabilities.clEnqueueReadBufferRect;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        BufferChecks.checkBuffer(longBuffer2, CLChecks.calculateBufferRectSize(pointerBuffer7, pointerBuffer8, j7, j8));
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueReadBufferRect = nclEnqueueReadBufferRect(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer6), MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), j5, j6, j7, j8, MemoryUtil.getAddress(longBuffer2), pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j9);
        if (nclEnqueueReadBufferRect == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueReadBufferRect;
    }

    public static int clEnqueueReadBufferRect(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, long j, long j2, long j3, long j4, ShortBuffer shortBuffer, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        ShortBuffer shortBuffer2 = shortBuffer;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j9 = CLCapabilities.clEnqueueReadBufferRect;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        BufferChecks.checkBuffer(shortBuffer2, CLChecks.calculateBufferRectSize(pointerBuffer7, pointerBuffer8, j7, j8));
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueReadBufferRect = nclEnqueueReadBufferRect(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer6), MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), j5, j6, j7, j8, MemoryUtil.getAddress(shortBuffer2), pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j9);
        if (nclEnqueueReadBufferRect == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueReadBufferRect;
    }

    public static int clEnqueueWriteBufferRect(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, long j, long j2, long j3, long j4, ByteBuffer byteBuffer, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j9 = CLCapabilities.clEnqueueWriteBufferRect;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        BufferChecks.checkBuffer(byteBuffer2, CLChecks.calculateBufferRectSize(pointerBuffer7, pointerBuffer8, j7, j8));
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueWriteBufferRect = nclEnqueueWriteBufferRect(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer6), MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), j5, j6, j7, j8, MemoryUtil.getAddress(byteBuffer2), pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j9);
        if (nclEnqueueWriteBufferRect == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueWriteBufferRect;
    }

    public static int clEnqueueWriteBufferRect(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, long j, long j2, long j3, long j4, DoubleBuffer doubleBuffer, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j9 = CLCapabilities.clEnqueueWriteBufferRect;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        BufferChecks.checkBuffer(doubleBuffer2, CLChecks.calculateBufferRectSize(pointerBuffer7, pointerBuffer8, j7, j8));
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueWriteBufferRect = nclEnqueueWriteBufferRect(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer6), MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), j5, j6, j7, j8, MemoryUtil.getAddress(doubleBuffer2), pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j9);
        if (nclEnqueueWriteBufferRect == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueWriteBufferRect;
    }

    public static int clEnqueueWriteBufferRect(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, long j, long j2, long j3, long j4, FloatBuffer floatBuffer, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        FloatBuffer floatBuffer2 = floatBuffer;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j9 = CLCapabilities.clEnqueueWriteBufferRect;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        BufferChecks.checkBuffer(floatBuffer2, CLChecks.calculateBufferRectSize(pointerBuffer7, pointerBuffer8, j7, j8));
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueWriteBufferRect = nclEnqueueWriteBufferRect(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer6), MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), j5, j6, j7, j8, MemoryUtil.getAddress(floatBuffer2), pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j9);
        if (nclEnqueueWriteBufferRect == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueWriteBufferRect;
    }

    public static int clEnqueueWriteBufferRect(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, long j, long j2, long j3, long j4, IntBuffer intBuffer, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        IntBuffer intBuffer2 = intBuffer;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j9 = CLCapabilities.clEnqueueWriteBufferRect;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        BufferChecks.checkBuffer(intBuffer2, CLChecks.calculateBufferRectSize(pointerBuffer7, pointerBuffer8, j7, j8));
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueWriteBufferRect = nclEnqueueWriteBufferRect(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer6), MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), j5, j6, j7, j8, MemoryUtil.getAddress(intBuffer2), pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j9);
        if (nclEnqueueWriteBufferRect == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueWriteBufferRect;
    }

    public static int clEnqueueWriteBufferRect(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, long j, long j2, long j3, long j4, LongBuffer longBuffer, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        LongBuffer longBuffer2 = longBuffer;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j9 = CLCapabilities.clEnqueueWriteBufferRect;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        BufferChecks.checkBuffer(longBuffer2, CLChecks.calculateBufferRectSize(pointerBuffer7, pointerBuffer8, j7, j8));
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueWriteBufferRect = nclEnqueueWriteBufferRect(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer6), MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), j5, j6, j7, j8, MemoryUtil.getAddress(longBuffer2), pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j9);
        if (nclEnqueueWriteBufferRect == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueWriteBufferRect;
    }

    public static int clEnqueueWriteBufferRect(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, long j, long j2, long j3, long j4, ShortBuffer shortBuffer, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        long j5 = j;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        ShortBuffer shortBuffer2 = shortBuffer;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j9 = CLCapabilities.clEnqueueWriteBufferRect;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        BufferChecks.checkBuffer(shortBuffer2, CLChecks.calculateBufferRectSize(pointerBuffer7, pointerBuffer8, j7, j8));
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueWriteBufferRect = nclEnqueueWriteBufferRect(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer6), MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), j5, j6, j7, j8, MemoryUtil.getAddress(shortBuffer2), pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j9);
        if (nclEnqueueWriteBufferRect == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueWriteBufferRect;
    }

    public static int clSetEventCallback(CLEvent cLEvent, int i, CLEventCallback cLEventCallback) {
        CLEvent cLEvent2 = cLEvent;
        int i2 = i;
        CLEventCallback cLEventCallback2 = cLEventCallback;
        long j = CLCapabilities.clSetEventCallback;
        BufferChecks.checkFunctionAddress(j);
        long createGlobalRef = CallbackUtil.createGlobalRef(cLEventCallback2);
        cLEventCallback2.setRegistry(cLEvent2.getParentRegistry());
        try {
            int nclSetEventCallback = nclSetEventCallback(cLEvent2.getPointer(), i2, cLEventCallback2.getPointer(), createGlobalRef, j);
            CallbackUtil.checkCallback(nclSetEventCallback, createGlobalRef);
            return nclSetEventCallback;
        } catch (Throwable th) {
            Throwable th2 = th;
            CallbackUtil.checkCallback(0, createGlobalRef);
            throw th2;
        }
    }

    public static int clSetMemObjectDestructorCallback(CLMem cLMem, CLMemObjectDestructorCallback cLMemObjectDestructorCallback) {
        CLMem cLMem2 = cLMem;
        CLMemObjectDestructorCallback cLMemObjectDestructorCallback2 = cLMemObjectDestructorCallback;
        long j = CLCapabilities.clSetMemObjectDestructorCallback;
        BufferChecks.checkFunctionAddress(j);
        long createGlobalRef = CallbackUtil.createGlobalRef(cLMemObjectDestructorCallback2);
        try {
            int nclSetMemObjectDestructorCallback = nclSetMemObjectDestructorCallback(cLMem2.getPointer(), cLMemObjectDestructorCallback2.getPointer(), createGlobalRef, j);
            CallbackUtil.checkCallback(nclSetMemObjectDestructorCallback, createGlobalRef);
            return nclSetMemObjectDestructorCallback;
        } catch (Throwable th) {
            Throwable th2 = th;
            CallbackUtil.checkCallback(0, createGlobalRef);
            throw th2;
        }
    }

    public static int clSetUserEventStatus(CLEvent cLEvent, int i) {
        CLEvent cLEvent2 = cLEvent;
        int i2 = i;
        long j = CLCapabilities.clSetUserEventStatus;
        BufferChecks.checkFunctionAddress(j);
        return nclSetUserEventStatus(cLEvent2.getPointer(), i2, j);
    }

    static native long nclCreateSubBuffer(long j, long j2, int i, long j3, long j4, long j5);

    static native long nclCreateUserEvent(long j, long j2, long j3);

    static native int nclEnqueueCopyBufferRect(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, int i, long j11, long j12, long j13);

    static native int nclEnqueueReadBufferRect(long j, long j2, int i, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, int i2, long j11, long j12, long j13);

    static native int nclEnqueueWriteBufferRect(long j, long j2, int i, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, int i2, long j11, long j12, long j13);

    static native int nclSetEventCallback(long j, int i, long j2, long j3, long j4);

    static native int nclSetMemObjectDestructorCallback(long j, long j2, long j3, long j4);

    static native int nclSetUserEventStatus(long j, int i, long j2);
}
