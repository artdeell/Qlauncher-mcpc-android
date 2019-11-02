package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;

public final class CL12 {
    public static final int CL_BLOCKING = 1;
    public static final int CL_COMMAND_BARRIER = 4613;
    public static final int CL_COMMAND_FILL_BUFFER = 4615;
    public static final int CL_COMMAND_FILL_IMAGE = 4616;
    public static final int CL_COMMAND_MIGRATE_MEM_OBJECTS = 4614;
    public static final int CL_COMPILE_PROGRAM_FAILURE = -15;
    public static final int CL_CONTEXT_INTEROP_USER_SYNC = 4229;
    public static final int CL_DEVICE_AFFINITY_DOMAIN_L1_CACHE = 16;
    public static final int CL_DEVICE_AFFINITY_DOMAIN_L2_CACHE = 8;
    public static final int CL_DEVICE_AFFINITY_DOMAIN_L3_CACHE = 4;
    public static final int CL_DEVICE_AFFINITY_DOMAIN_L4_CACHE = 2;
    public static final int CL_DEVICE_AFFINITY_DOMAIN_NEXT_PARTITIONABLE = 32;
    public static final int CL_DEVICE_AFFINITY_DOMAIN_NUMA = 1;
    public static final int CL_DEVICE_BUILT_IN_KERNELS = 4159;
    public static final int CL_DEVICE_DOUBLE_FP_CONFIG = 4146;
    public static final int CL_DEVICE_IMAGE_MAX_ARRAY_SIZE = 4161;
    public static final int CL_DEVICE_IMAGE_MAX_BUFFER_SIZE = 4160;
    public static final int CL_DEVICE_LINKER_AVAILABLE = 4158;
    public static final int CL_DEVICE_PARENT_DEVICE = 4162;
    public static final int CL_DEVICE_PARTITION_AFFINITY_DOMAIN = 4165;
    public static final int CL_DEVICE_PARTITION_BY_AFFINITY_DOMAIN = 4232;
    public static final int CL_DEVICE_PARTITION_BY_COUNTS = 4231;
    public static final int CL_DEVICE_PARTITION_BY_COUNTS_LIST_END = 0;
    public static final int CL_DEVICE_PARTITION_EQUALLY = 4230;
    public static final int CL_DEVICE_PARTITION_FAILED = -18;
    public static final int CL_DEVICE_PARTITION_MAX_SUB_DEVICES = 4163;
    public static final int CL_DEVICE_PARTITION_PROPERTIES = 4164;
    public static final int CL_DEVICE_PARTITION_TYPE = 4166;
    public static final int CL_DEVICE_PREFERRED_INTEROP_USER_SYNC = 4168;
    public static final int CL_DEVICE_PRINTF_BUFFER_SIZE = 4169;
    public static final int CL_DEVICE_REFERENCE_COUNT = 4167;
    public static final int CL_DEVICE_TYPE_CUSTOM = 16;
    public static final int CL_FP_CORRECTLY_ROUNDED_DIVIDE_SQRT = 128;
    public static final int CL_IMAGE_ARRAY_SIZE = 4375;
    public static final int CL_IMAGE_BUFFER = 4376;
    public static final int CL_IMAGE_NUM_MIP_LEVELS = 4377;
    public static final int CL_IMAGE_NUM_SAMPLES = 4378;
    public static final int CL_INVALID_COMPILER_OPTIONS = -66;
    public static final int CL_INVALID_DEVICE_PARTITION_COUNT = -68;
    public static final int CL_INVALID_IMAGE_DESCRIPTOR = -65;
    public static final int CL_INVALID_LINKER_OPTIONS = -67;
    public static final int CL_KERNEL_ARG_ACCESS_NONE = 4515;
    public static final int CL_KERNEL_ARG_ACCESS_QUALIFIER = 4503;
    public static final int CL_KERNEL_ARG_ACCESS_READ_ONLY = 4512;
    public static final int CL_KERNEL_ARG_ACCESS_READ_WRITE = 4514;
    public static final int CL_KERNEL_ARG_ACCESS_WRITE_ONLY = 4513;
    public static final int CL_KERNEL_ARG_ADDRESS_CONSTANT = 4508;
    public static final int CL_KERNEL_ARG_ADDRESS_GLOBAL = 4506;
    public static final int CL_KERNEL_ARG_ADDRESS_LOCAL = 4507;
    public static final int CL_KERNEL_ARG_ADDRESS_PRIVATE = 4509;
    public static final int CL_KERNEL_ARG_ADDRESS_QUALIFIER = 4502;
    public static final int CL_KERNEL_ARG_INFO_NOT_AVAILABLE = -19;
    public static final int CL_KERNEL_ARG_NAME = 4506;
    public static final int CL_KERNEL_ARG_TYPE_CONST = 1;
    public static final int CL_KERNEL_ARG_TYPE_NAME = 4504;
    public static final int CL_KERNEL_ARG_TYPE_NONE = 0;
    public static final int CL_KERNEL_ARG_TYPE_QUALIFIER = 4505;
    public static final int CL_KERNEL_ARG_TYPE_RESTRICT = 2;
    public static final int CL_KERNEL_ARG_TYPE_VOLATILE = 4;
    public static final int CL_KERNEL_ATTRIBUTES = 4501;
    public static final int CL_KERNEL_GLOBAL_WORK_SIZE = 4533;
    public static final int CL_LINKER_NOT_AVAILABLE = -16;
    public static final int CL_LINK_PROGRAM_FAILURE = -17;
    public static final int CL_MAP_WRITE_INVALIDATE_REGION = 4;
    public static final int CL_MEM_HOST_NO_ACCESS = 512;
    public static final int CL_MEM_HOST_READ_ONLY = 256;
    public static final int CL_MEM_HOST_WRITE_ONLY = 128;
    public static final int CL_MEM_OBJECT_IMAGE1D = 4340;
    public static final int CL_MEM_OBJECT_IMAGE1D_ARRAY = 4341;
    public static final int CL_MEM_OBJECT_IMAGE1D_BUFFER = 4342;
    public static final int CL_MEM_OBJECT_IMAGE2D_ARRAY = 4339;
    public static final int CL_MIGRATE_MEM_OBJECT_CONTENT_UNDEFINED = 2;
    public static final int CL_MIGRATE_MEM_OBJECT_HOST = 1;
    public static final int CL_NON_BLOCKING = 0;
    public static final int CL_PROGRAM_BINARY_TYPE = 4484;
    public static final int CL_PROGRAM_BINARY_TYPE_COMPILED_OBJECT = 1;
    public static final int CL_PROGRAM_BINARY_TYPE_EXECUTABLE = 4;
    public static final int CL_PROGRAM_BINARY_TYPE_LIBRARY = 2;
    public static final int CL_PROGRAM_BINARY_TYPE_NONE = 0;
    public static final int CL_PROGRAM_KERNEL_NAMES = 4456;
    public static final int CL_PROGRAM_NUM_KERNELS = 4455;
    public static final int CL_VERSION_1_2 = 1;

    private CL12() {
    }

    public static int clCompileProgram(CLProgram cLProgram, PointerBuffer pointerBuffer, CharSequence charSequence, PointerBuffer pointerBuffer2, CharSequence charSequence2, CLCompileProgramCallback cLCompileProgramCallback) {
        CLProgram cLProgram2 = cLProgram;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        CharSequence charSequence3 = charSequence;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        CharSequence charSequence4 = charSequence2;
        CLCompileProgramCallback cLCompileProgramCallback2 = cLCompileProgramCallback;
        long j = CLCapabilities.clCompileProgram;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        BufferChecks.checkBuffer(pointerBuffer4, 1);
        long createGlobalRef = CallbackUtil.createGlobalRef(cLCompileProgramCallback2);
        if (cLCompileProgramCallback2 != null) {
            cLCompileProgramCallback2.setContext((CLContext) cLProgram2.getParent());
        }
        try {
            int nclCompileProgram = nclCompileProgram(cLProgram2.getPointer(), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), APIUtil.getBufferNT(charSequence3), 1, MemoryUtil.getAddress(pointerBuffer4), APIUtil.getBufferNT(charSequence4), cLCompileProgramCallback2 == null ? 0 : cLCompileProgramCallback2.getPointer(), createGlobalRef, j);
            CallbackUtil.checkCallback(nclCompileProgram, createGlobalRef);
            return nclCompileProgram;
        } catch (Throwable th) {
            Throwable th2 = th;
            CallbackUtil.checkCallback(0, createGlobalRef);
            throw th2;
        }
    }

    public static int clCompileProgram(CLProgram cLProgram, PointerBuffer pointerBuffer, CharSequence charSequence, PointerBuffer pointerBuffer2, CharSequence[] charSequenceArr, CLCompileProgramCallback cLCompileProgramCallback) {
        CLProgram cLProgram2 = cLProgram;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        CharSequence charSequence2 = charSequence;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        CharSequence[] charSequenceArr2 = charSequenceArr;
        CLCompileProgramCallback cLCompileProgramCallback2 = cLCompileProgramCallback;
        long j = CLCapabilities.clCompileProgram;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        BufferChecks.checkBuffer(pointerBuffer4, 1);
        BufferChecks.checkArray(charSequenceArr2);
        long createGlobalRef = CallbackUtil.createGlobalRef(cLCompileProgramCallback2);
        if (cLCompileProgramCallback2 != null) {
            cLCompileProgramCallback2.setContext((CLContext) cLProgram2.getParent());
        }
        try {
            int nclCompileProgramMulti = nclCompileProgramMulti(cLProgram2.getPointer(), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), APIUtil.getBufferNT(charSequence2), pointerBuffer4.remaining(), MemoryUtil.getAddress(pointerBuffer4), APIUtil.getBufferNT(charSequenceArr2), cLCompileProgramCallback2 == null ? 0 : cLCompileProgramCallback2.getPointer(), createGlobalRef, j);
            CallbackUtil.checkCallback(nclCompileProgramMulti, createGlobalRef);
            return nclCompileProgramMulti;
        } catch (Throwable th) {
            Throwable th2 = th;
            CallbackUtil.checkCallback(0, createGlobalRef);
            throw th2;
        }
    }

    public static int clCompileProgram(CLProgram cLProgram, PointerBuffer pointerBuffer, ByteBuffer byteBuffer, PointerBuffer pointerBuffer2, ByteBuffer byteBuffer2, CLCompileProgramCallback cLCompileProgramCallback) {
        CLProgram cLProgram2 = cLProgram;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        ByteBuffer byteBuffer3 = byteBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        ByteBuffer byteBuffer4 = byteBuffer2;
        CLCompileProgramCallback cLCompileProgramCallback2 = cLCompileProgramCallback;
        long j = CLCapabilities.clCompileProgram;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkNullTerminated(byteBuffer3);
        BufferChecks.checkBuffer(pointerBuffer4, 1);
        BufferChecks.checkDirect(byteBuffer4);
        BufferChecks.checkNullTerminated(byteBuffer4);
        long createGlobalRef = CallbackUtil.createGlobalRef(cLCompileProgramCallback2);
        if (cLCompileProgramCallback2 != null) {
            cLCompileProgramCallback2.setContext((CLContext) cLProgram2.getParent());
        }
        try {
            int nclCompileProgram = nclCompileProgram(cLProgram2.getPointer(), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddress(byteBuffer3), 1, MemoryUtil.getAddress(pointerBuffer4), MemoryUtil.getAddress(byteBuffer4), cLCompileProgramCallback2 == null ? 0 : cLCompileProgramCallback2.getPointer(), createGlobalRef, j);
            CallbackUtil.checkCallback(nclCompileProgram, createGlobalRef);
            return nclCompileProgram;
        } catch (Throwable th) {
            Throwable th2 = th;
            CallbackUtil.checkCallback(0, createGlobalRef);
            throw th2;
        }
    }

    public static int clCompileProgram(CLProgram cLProgram, PointerBuffer pointerBuffer, ByteBuffer byteBuffer, PointerBuffer pointerBuffer2, ByteBuffer[] byteBufferArr, CLCompileProgramCallback cLCompileProgramCallback) {
        CLProgram cLProgram2 = cLProgram;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        ByteBuffer[] byteBufferArr2 = byteBufferArr;
        CLCompileProgramCallback cLCompileProgramCallback2 = cLCompileProgramCallback;
        long j = CLCapabilities.clCompileProgram;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        BufferChecks.checkBuffer(pointerBuffer4, byteBufferArr2.length);
        BufferChecks.checkArray((Object[]) byteBufferArr2, 1);
        long createGlobalRef = CallbackUtil.createGlobalRef(cLCompileProgramCallback2);
        if (cLCompileProgramCallback2 != null) {
            cLCompileProgramCallback2.setContext((CLContext) cLProgram2.getParent());
        }
        try {
            int nclCompileProgram3 = nclCompileProgram3(cLProgram2.getPointer(), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddress(byteBuffer2), byteBufferArr2.length, MemoryUtil.getAddress(pointerBuffer4), byteBufferArr2, cLCompileProgramCallback2 == null ? 0 : cLCompileProgramCallback2.getPointer(), createGlobalRef, j);
            CallbackUtil.checkCallback(nclCompileProgram3, createGlobalRef);
            return nclCompileProgram3;
        } catch (Throwable th) {
            Throwable th2 = th;
            CallbackUtil.checkCallback(0, createGlobalRef);
            throw th2;
        }
    }

    public static int clCompileProgramMulti(CLProgram cLProgram, PointerBuffer pointerBuffer, ByteBuffer byteBuffer, PointerBuffer pointerBuffer2, ByteBuffer byteBuffer2, CLCompileProgramCallback cLCompileProgramCallback) {
        CLProgram cLProgram2 = cLProgram;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        ByteBuffer byteBuffer3 = byteBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        ByteBuffer byteBuffer4 = byteBuffer2;
        CLCompileProgramCallback cLCompileProgramCallback2 = cLCompileProgramCallback;
        long j = CLCapabilities.clCompileProgram;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkNullTerminated(byteBuffer3);
        BufferChecks.checkBuffer(pointerBuffer4, 1);
        BufferChecks.checkDirect(byteBuffer4);
        BufferChecks.checkNullTerminated(byteBuffer4, pointerBuffer4.remaining());
        long createGlobalRef = CallbackUtil.createGlobalRef(cLCompileProgramCallback2);
        if (cLCompileProgramCallback2 != null) {
            cLCompileProgramCallback2.setContext((CLContext) cLProgram2.getParent());
        }
        try {
            int nclCompileProgramMulti = nclCompileProgramMulti(cLProgram2.getPointer(), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddress(byteBuffer3), pointerBuffer4.remaining(), MemoryUtil.getAddress(pointerBuffer4), MemoryUtil.getAddress(byteBuffer4), cLCompileProgramCallback2 == null ? 0 : cLCompileProgramCallback2.getPointer(), createGlobalRef, j);
            CallbackUtil.checkCallback(nclCompileProgramMulti, createGlobalRef);
            return nclCompileProgramMulti;
        } catch (Throwable th) {
            Throwable th2 = th;
            CallbackUtil.checkCallback(0, createGlobalRef);
            throw th2;
        }
    }

    public static CLMem clCreateImage(CLContext cLContext, long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        ByteBuffer byteBuffer4 = byteBuffer;
        ByteBuffer byteBuffer5 = byteBuffer2;
        ByteBuffer byteBuffer6 = byteBuffer3;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateImage;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkBuffer(byteBuffer4, 8);
        BufferChecks.checkBuffer(byteBuffer5, 8 + (7 * PointerBuffer.getPointerSize()) + PointerBuffer.getPointerSize());
        if (byteBuffer6 != null) {
            BufferChecks.checkDirect(byteBuffer6);
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateImage(cLContext2.getPointer(), j2, MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddress(byteBuffer5), MemoryUtil.getAddressSafe(byteBuffer6), MemoryUtil.getAddressSafe(intBuffer2), j3), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateImage(CLContext cLContext, long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, FloatBuffer floatBuffer, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateImage;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkBuffer(byteBuffer3, 8);
        BufferChecks.checkBuffer(byteBuffer4, 8 + (7 * PointerBuffer.getPointerSize()) + PointerBuffer.getPointerSize());
        if (floatBuffer2 != null) {
            BufferChecks.checkDirect(floatBuffer2);
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateImage(cLContext2.getPointer(), j2, MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddressSafe(floatBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j3), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateImage(CLContext cLContext, long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j3 = CLCapabilities.clCreateImage;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkBuffer(byteBuffer3, 8);
        BufferChecks.checkBuffer(byteBuffer4, 8 + (7 * PointerBuffer.getPointerSize()) + PointerBuffer.getPointerSize());
        if (intBuffer3 != null) {
            BufferChecks.checkDirect(intBuffer3);
        }
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateImage(cLContext2.getPointer(), j2, MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddressSafe(intBuffer3), MemoryUtil.getAddressSafe(intBuffer4), j3), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateImage(CLContext cLContext, long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ShortBuffer shortBuffer, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateImage;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkBuffer(byteBuffer3, 8);
        BufferChecks.checkBuffer(byteBuffer4, 8 + (7 * PointerBuffer.getPointerSize()) + PointerBuffer.getPointerSize());
        if (shortBuffer2 != null) {
            BufferChecks.checkDirect(shortBuffer2);
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateImage(cLContext2.getPointer(), j2, MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddressSafe(shortBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j3), cLContext2);
        return cLMem2;
    }

    public static CLProgram clCreateProgramWithBuiltInKernels(CLContext cLContext, PointerBuffer pointerBuffer, CharSequence charSequence, IntBuffer intBuffer) {
        CLProgram cLProgram;
        CLContext cLContext2 = cLContext;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        CharSequence charSequence2 = charSequence;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateProgramWithBuiltInKernels;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(pointerBuffer2, 1);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLProgram cLProgram2 = cLProgram;
        CLProgram cLProgram3 = new CLProgram(nclCreateProgramWithBuiltInKernels(cLContext2.getPointer(), pointerBuffer2.remaining(), MemoryUtil.getAddress(pointerBuffer2), APIUtil.getBuffer(charSequence2), MemoryUtil.getAddressSafe(intBuffer2), j), cLContext2);
        return cLProgram2;
    }

    public static CLProgram clCreateProgramWithBuiltInKernels(CLContext cLContext, PointerBuffer pointerBuffer, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        CLProgram cLProgram;
        CLContext cLContext2 = cLContext;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateProgramWithBuiltInKernels;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(pointerBuffer2, 1);
        BufferChecks.checkDirect(byteBuffer2);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLProgram cLProgram2 = cLProgram;
        CLProgram cLProgram3 = new CLProgram(nclCreateProgramWithBuiltInKernels(cLContext2.getPointer(), pointerBuffer2.remaining(), MemoryUtil.getAddress(pointerBuffer2), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j), cLContext2);
        return cLProgram2;
    }

    public static int clCreateSubDevices(CLDevice cLDevice, LongBuffer longBuffer, PointerBuffer pointerBuffer, IntBuffer intBuffer) {
        CLDevice cLDevice2 = cLDevice;
        LongBuffer longBuffer2 = longBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateSubDevices;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        BufferChecks.checkNullTerminated(longBuffer2);
        if (pointerBuffer2 != null) {
            BufferChecks.checkDirect(pointerBuffer2);
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        int nclCreateSubDevices = nclCreateSubDevices(cLDevice2.getPointer(), MemoryUtil.getAddress(longBuffer2), pointerBuffer2 == null ? 0 : pointerBuffer2.remaining(), MemoryUtil.getAddressSafe(pointerBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j);
        if (nclCreateSubDevices == 0 && pointerBuffer2 != null) {
            cLDevice2.registerSubCLDevices(pointerBuffer2);
        }
        return nclCreateSubDevices;
    }

    public static int clEnqueueBarrierWithWaitList(CLCommandQueue cLCommandQueue, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j = CLCapabilities.clEnqueueBarrierWithWaitList;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        return nclEnqueueBarrierWithWaitList(cLCommandQueue2.getPointer(), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j);
    }

    public static int clEnqueueFillBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, ByteBuffer byteBuffer, long j, long j2, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = j;
        long j4 = j2;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j5 = CLCapabilities.clEnqueueFillBuffer;
        BufferChecks.checkFunctionAddress(j5);
        BufferChecks.checkDirect(byteBuffer2);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        return nclEnqueueFillBuffer(cLCommandQueue2.getPointer(), cLMem2.getPointer(), MemoryUtil.getAddress(byteBuffer2), (long) byteBuffer2.remaining(), j3, j4, pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j5);
    }

    public static int clEnqueueFillImage(CLCommandQueue cLCommandQueue, CLMem cLMem, ByteBuffer byteBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, PointerBuffer pointerBuffer4) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer5 = pointerBuffer;
        PointerBuffer pointerBuffer6 = pointerBuffer2;
        PointerBuffer pointerBuffer7 = pointerBuffer3;
        PointerBuffer pointerBuffer8 = pointerBuffer4;
        long j = CLCapabilities.clEnqueueFillImage;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 16);
        BufferChecks.checkBuffer(pointerBuffer5, 3);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        if (pointerBuffer7 != null) {
            BufferChecks.checkDirect(pointerBuffer7);
        }
        if (pointerBuffer8 != null) {
            BufferChecks.checkBuffer(pointerBuffer8, 1);
        }
        return nclEnqueueFillImage(cLCommandQueue2.getPointer(), cLMem2.getPointer(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(pointerBuffer5), MemoryUtil.getAddress(pointerBuffer6), pointerBuffer7 == null ? 0 : pointerBuffer7.remaining(), MemoryUtil.getAddressSafe(pointerBuffer7), MemoryUtil.getAddressSafe(pointerBuffer8), j);
    }

    public static int clEnqueueMarkerWithWaitList(CLCommandQueue cLCommandQueue, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j = CLCapabilities.clEnqueueMarkerWithWaitList;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        return nclEnqueueMarkerWithWaitList(cLCommandQueue2.getPointer(), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j);
    }

    public static int clEnqueueMigrateMemObjects(CLCommandQueue cLCommandQueue, PointerBuffer pointerBuffer, long j, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        PointerBuffer pointerBuffer4 = pointerBuffer;
        long j2 = j;
        PointerBuffer pointerBuffer5 = pointerBuffer2;
        PointerBuffer pointerBuffer6 = pointerBuffer3;
        long j3 = CLCapabilities.clEnqueueMigrateMemObjects;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(pointerBuffer4);
        if (pointerBuffer5 != null) {
            BufferChecks.checkDirect(pointerBuffer5);
        }
        if (pointerBuffer6 != null) {
            BufferChecks.checkBuffer(pointerBuffer6, 1);
        }
        return nclEnqueueMigrateMemObjects(cLCommandQueue2.getPointer(), pointerBuffer4.remaining(), MemoryUtil.getAddress(pointerBuffer4), j2, pointerBuffer5 == null ? 0 : pointerBuffer5.remaining(), MemoryUtil.getAddressSafe(pointerBuffer5), MemoryUtil.getAddressSafe(pointerBuffer6), j3);
    }

    static CLFunctionAddress clGetExtensionFunctionAddressForPlatform(CLPlatform cLPlatform, CharSequence charSequence) {
        CLFunctionAddress cLFunctionAddress;
        CLPlatform cLPlatform2 = cLPlatform;
        CharSequence charSequence2 = charSequence;
        long j = CLCapabilities.clGetExtensionFunctionAddressForPlatform;
        BufferChecks.checkFunctionAddress(j);
        CLFunctionAddress cLFunctionAddress2 = cLFunctionAddress;
        CLFunctionAddress cLFunctionAddress3 = new CLFunctionAddress(nclGetExtensionFunctionAddressForPlatform(cLPlatform2.getPointer(), APIUtil.getBufferNT(charSequence2), j));
        return cLFunctionAddress2;
    }

    static CLFunctionAddress clGetExtensionFunctionAddressForPlatform(CLPlatform cLPlatform, ByteBuffer byteBuffer) {
        CLFunctionAddress cLFunctionAddress;
        CLPlatform cLPlatform2 = cLPlatform;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = CLCapabilities.clGetExtensionFunctionAddressForPlatform;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        CLFunctionAddress cLFunctionAddress2 = cLFunctionAddress;
        CLFunctionAddress cLFunctionAddress3 = new CLFunctionAddress(nclGetExtensionFunctionAddressForPlatform(cLPlatform2.getPointer(), MemoryUtil.getAddress(byteBuffer2), j));
        return cLFunctionAddress2;
    }

    public static int clGetKernelArgInfo(CLKernel cLKernel, int i, int i2, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLKernel cLKernel2 = cLKernel;
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetKernelArgInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetKernelArgInfo(cLKernel2.getPointer(), i3, i4, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    /* JADX INFO: finally extract failed */
    public static CLProgram clLinkProgram(CLContext cLContext, PointerBuffer pointerBuffer, CharSequence charSequence, PointerBuffer pointerBuffer2, CLLinkProgramCallback cLLinkProgramCallback, IntBuffer intBuffer) {
        CLProgram cLProgram;
        CLContext cLContext2 = cLContext;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        CharSequence charSequence2 = charSequence;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        CLLinkProgramCallback cLLinkProgramCallback2 = cLLinkProgramCallback;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clLinkProgram;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        BufferChecks.checkDirect(pointerBuffer4);
        BufferChecks.checkBuffer(intBuffer2, 1);
        long createGlobalRef = CallbackUtil.createGlobalRef(cLLinkProgramCallback2);
        if (cLLinkProgramCallback2 != null) {
            cLLinkProgramCallback2.setContext(cLContext2);
        }
        try {
            CLProgram cLProgram2 = cLProgram;
            CLProgram cLProgram3 = new CLProgram(nclLinkProgram(cLContext2.getPointer(), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), APIUtil.getBufferNT(charSequence2), pointerBuffer4.remaining(), MemoryUtil.getAddress(pointerBuffer4), cLLinkProgramCallback2 == null ? 0 : cLLinkProgramCallback2.getPointer(), createGlobalRef, MemoryUtil.getAddress(intBuffer2), j), cLContext2);
            CLProgram cLProgram4 = cLProgram2;
            CallbackUtil.checkCallback(intBuffer2.get(intBuffer2.position()), createGlobalRef);
            return cLProgram4;
        } catch (Throwable th) {
            Throwable th2 = th;
            CallbackUtil.checkCallback(intBuffer2.get(intBuffer2.position()), createGlobalRef);
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public static CLProgram clLinkProgram(CLContext cLContext, PointerBuffer pointerBuffer, ByteBuffer byteBuffer, PointerBuffer pointerBuffer2, CLLinkProgramCallback cLLinkProgramCallback, IntBuffer intBuffer) {
        CLProgram cLProgram;
        CLContext cLContext2 = cLContext;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        CLLinkProgramCallback cLLinkProgramCallback2 = cLLinkProgramCallback;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clLinkProgram;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        BufferChecks.checkDirect(pointerBuffer4);
        BufferChecks.checkBuffer(intBuffer2, 1);
        long createGlobalRef = CallbackUtil.createGlobalRef(cLLinkProgramCallback2);
        if (cLLinkProgramCallback2 != null) {
            cLLinkProgramCallback2.setContext(cLContext2);
        }
        try {
            CLProgram cLProgram2 = cLProgram;
            CLProgram cLProgram3 = new CLProgram(nclLinkProgram(cLContext2.getPointer(), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddress(byteBuffer2), pointerBuffer4.remaining(), MemoryUtil.getAddress(pointerBuffer4), cLLinkProgramCallback2 == null ? 0 : cLLinkProgramCallback2.getPointer(), createGlobalRef, MemoryUtil.getAddress(intBuffer2), j), cLContext2);
            CLProgram cLProgram4 = cLProgram2;
            CallbackUtil.checkCallback(intBuffer2.get(intBuffer2.position()), createGlobalRef);
            return cLProgram4;
        } catch (Throwable th) {
            Throwable th2 = th;
            CallbackUtil.checkCallback(intBuffer2.get(intBuffer2.position()), createGlobalRef);
            throw th2;
        }
    }

    public static int clReleaseDevice(CLDevice cLDevice) {
        CLDevice cLDevice2 = cLDevice;
        long j = CLCapabilities.clReleaseDevice;
        BufferChecks.checkFunctionAddress(j);
        APIUtil.releaseObjects(cLDevice2);
        int nclReleaseDevice = nclReleaseDevice(cLDevice2.getPointer(), j);
        if (nclReleaseDevice == 0) {
            int release = cLDevice2.release();
        }
        return nclReleaseDevice;
    }

    public static int clRetainDevice(CLDevice cLDevice) {
        CLDevice cLDevice2 = cLDevice;
        long j = CLCapabilities.clRetainDevice;
        BufferChecks.checkFunctionAddress(j);
        int nclRetainDevice = nclRetainDevice(cLDevice2.getPointer(), j);
        if (nclRetainDevice == 0) {
            int retain = cLDevice2.retain();
        }
        return nclRetainDevice;
    }

    public static int clSetPrintfCallback(CLContext cLContext, CLPrintfCallback cLPrintfCallback) {
        CLContext cLContext2 = cLContext;
        CLPrintfCallback cLPrintfCallback2 = cLPrintfCallback;
        long j = CLCapabilities.clSetPrintfCallback;
        BufferChecks.checkFunctionAddress(j);
        long createGlobalRef = CallbackUtil.createGlobalRef(cLPrintfCallback2);
        try {
            int nclSetPrintfCallback = nclSetPrintfCallback(cLContext2.getPointer(), cLPrintfCallback2.getPointer(), createGlobalRef, j);
            cLContext2.setPrintfCallback(createGlobalRef, nclSetPrintfCallback);
            return nclSetPrintfCallback;
        } catch (Throwable th) {
            Throwable th2 = th;
            cLContext2.setPrintfCallback(createGlobalRef, 0);
            throw th2;
        }
    }

    public static int clUnloadPlatformCompiler(CLPlatform cLPlatform) {
        CLPlatform cLPlatform2 = cLPlatform;
        long j = CLCapabilities.clUnloadPlatformCompiler;
        BufferChecks.checkFunctionAddress(j);
        return nclUnloadPlatformCompiler(cLPlatform2.getPointer(), j);
    }

    static native int nclCompileProgram(long j, int i, long j2, long j3, int i2, long j4, long j5, long j6, long j7, long j8);

    static native int nclCompileProgram3(long j, int i, long j2, long j3, int i2, long j4, ByteBuffer[] byteBufferArr, long j5, long j6, long j7);

    static native int nclCompileProgramMulti(long j, int i, long j2, long j3, int i2, long j4, long j5, long j6, long j7, long j8);

    static native long nclCreateImage(long j, long j2, long j3, long j4, long j5, long j6, long j7);

    static native long nclCreateProgramWithBuiltInKernels(long j, int i, long j2, long j3, long j4, long j5);

    static native int nclCreateSubDevices(long j, long j2, int i, long j3, long j4, long j5);

    static native int nclEnqueueBarrierWithWaitList(long j, int i, long j2, long j3, long j4);

    static native int nclEnqueueFillBuffer(long j, long j2, long j3, long j4, long j5, long j6, int i, long j7, long j8, long j9);

    static native int nclEnqueueFillImage(long j, long j2, long j3, long j4, long j5, int i, long j6, long j7, long j8);

    static native int nclEnqueueMarkerWithWaitList(long j, int i, long j2, long j3, long j4);

    static native int nclEnqueueMigrateMemObjects(long j, int i, long j2, long j3, int i2, long j4, long j5, long j6);

    static native long nclGetExtensionFunctionAddressForPlatform(long j, long j2, long j3);

    static native int nclGetKernelArgInfo(long j, int i, int i2, long j2, long j3, long j4, long j5);

    static native long nclLinkProgram(long j, int i, long j2, long j3, int i2, long j4, long j5, long j6, long j7, long j8);

    static native int nclReleaseDevice(long j, long j2);

    static native int nclRetainDevice(long j, long j2);

    static native int nclSetPrintfCallback(long j, long j2, long j3, long j4);

    static native int nclUnloadPlatformCompiler(long j, long j2);
}
