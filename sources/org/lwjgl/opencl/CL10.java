package org.lwjgl.opencl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;

public final class CL10 {
    public static final int CL_A = 4273;
    public static final int CL_ADDRESS_CLAMP = 4402;
    public static final int CL_ADDRESS_CLAMP_TO_EDGE = 4401;
    public static final int CL_ADDRESS_NONE = 4400;
    public static final int CL_ADDRESS_REPEAT = 4403;
    public static final int CL_ARGB = 4279;
    public static final int CL_BGRA = 4278;
    public static final int CL_BUILD_ERROR = -2;
    public static final int CL_BUILD_IN_PROGRESS = -3;
    public static final int CL_BUILD_NONE = -1;
    public static final int CL_BUILD_PROGRAM_FAILURE = -11;
    public static final int CL_BUILD_SUCCESS = 0;
    public static final int CL_COMMAND_ACQUIRE_GL_OBJECTS = 4607;
    public static final int CL_COMMAND_COPY_BUFFER = 4597;
    public static final int CL_COMMAND_COPY_BUFFER_TO_IMAGE = 4602;
    public static final int CL_COMMAND_COPY_IMAGE = 4600;
    public static final int CL_COMMAND_COPY_IMAGE_TO_BUFFER = 4601;
    public static final int CL_COMMAND_MAP_BUFFER = 4603;
    public static final int CL_COMMAND_MAP_IMAGE = 4604;
    public static final int CL_COMMAND_MARKER = 4606;
    public static final int CL_COMMAND_NATIVE_KERNEL = 4594;
    public static final int CL_COMMAND_NDRANGE_KERNEL = 4592;
    public static final int CL_COMMAND_READ_BUFFER = 4595;
    public static final int CL_COMMAND_READ_IMAGE = 4598;
    public static final int CL_COMMAND_RELEASE_GL_OBJECTS = 4608;
    public static final int CL_COMMAND_TASK = 4593;
    public static final int CL_COMMAND_UNMAP_MEM_OBJECT = 4605;
    public static final int CL_COMMAND_WRITE_BUFFER = 4596;
    public static final int CL_COMMAND_WRITE_IMAGE = 4599;
    public static final int CL_COMPILER_NOT_AVAILABLE = -3;
    public static final int CL_COMPLETE = 0;
    public static final int CL_CONTEXT_DEVICES = 4225;
    public static final int CL_CONTEXT_PLATFORM = 4228;
    public static final int CL_CONTEXT_PROPERTIES = 4226;
    public static final int CL_CONTEXT_REFERENCE_COUNT = 4224;
    public static final int CL_DEVICE_ADDRESS_BITS = 4109;
    public static final int CL_DEVICE_AVAILABLE = 4135;
    public static final int CL_DEVICE_COMPILER_AVAILABLE = 4136;
    public static final int CL_DEVICE_ENDIAN_LITTLE = 4134;
    public static final int CL_DEVICE_ERROR_CORRECTION_SUPPORT = 4132;
    public static final int CL_DEVICE_EXECUTION_CAPABILITIES = 4137;
    public static final int CL_DEVICE_EXTENSIONS = 4144;
    public static final int CL_DEVICE_GLOBAL_MEM_CACHELINE_SIZE = 4125;
    public static final int CL_DEVICE_GLOBAL_MEM_CACHE_SIZE = 4126;
    public static final int CL_DEVICE_GLOBAL_MEM_CACHE_TYPE = 4124;
    public static final int CL_DEVICE_GLOBAL_MEM_SIZE = 4127;
    public static final int CL_DEVICE_IMAGE2D_MAX_HEIGHT = 4114;
    public static final int CL_DEVICE_IMAGE2D_MAX_WIDTH = 4113;
    public static final int CL_DEVICE_IMAGE3D_MAX_DEPTH = 4117;
    public static final int CL_DEVICE_IMAGE3D_MAX_HEIGHT = 4116;
    public static final int CL_DEVICE_IMAGE3D_MAX_WIDTH = 4115;
    public static final int CL_DEVICE_IMAGE_SUPPORT = 4118;
    public static final int CL_DEVICE_LOCAL_MEM_SIZE = 4131;
    public static final int CL_DEVICE_LOCAL_MEM_TYPE = 4130;
    public static final int CL_DEVICE_MAX_CLOCK_FREQUENCY = 4108;
    public static final int CL_DEVICE_MAX_COMPUTE_UNITS = 4098;
    public static final int CL_DEVICE_MAX_CONSTANT_ARGS = 4129;
    public static final int CL_DEVICE_MAX_CONSTANT_BUFFER_SIZE = 4128;
    public static final int CL_DEVICE_MAX_MEM_ALLOC_SIZE = 4112;
    public static final int CL_DEVICE_MAX_PARAMETER_SIZE = 4119;
    public static final int CL_DEVICE_MAX_READ_IMAGE_ARGS = 4110;
    public static final int CL_DEVICE_MAX_SAMPLERS = 4120;
    public static final int CL_DEVICE_MAX_WORK_GROUP_SIZE = 4100;
    public static final int CL_DEVICE_MAX_WORK_ITEM_DIMENSIONS = 4099;
    public static final int CL_DEVICE_MAX_WORK_ITEM_SIZES = 4101;
    public static final int CL_DEVICE_MAX_WRITE_IMAGE_ARGS = 4111;
    public static final int CL_DEVICE_MEM_BASE_ADDR_ALIGN = 4121;
    public static final int CL_DEVICE_MIN_DATA_TYPE_ALIGN_SIZE = 4122;
    public static final int CL_DEVICE_NAME = 4139;
    public static final int CL_DEVICE_NOT_AVAILABLE = -2;
    public static final int CL_DEVICE_NOT_FOUND = -1;
    public static final int CL_DEVICE_PLATFORM = 4145;
    public static final int CL_DEVICE_PREFERRED_VECTOR_WIDTH_ = 4104;
    public static final int CL_DEVICE_PREFERRED_VECTOR_WIDTH_CHAR = 4102;
    public static final int CL_DEVICE_PREFERRED_VECTOR_WIDTH_DOUBLE = 4107;
    public static final int CL_DEVICE_PREFERRED_VECTOR_WIDTH_FLOAT = 4106;
    public static final int CL_DEVICE_PREFERRED_VECTOR_WIDTH_LONG = 4105;
    public static final int CL_DEVICE_PREFERRED_VECTOR_WIDTH_SHORT = 4103;
    public static final int CL_DEVICE_PROFILE = 4142;
    public static final int CL_DEVICE_PROFILING_TIMER_RESOLUTION = 4133;
    public static final int CL_DEVICE_QUEUE_PROPERTIES = 4138;
    public static final int CL_DEVICE_SINGLE_FP_CONFIG = 4123;
    public static final int CL_DEVICE_TYPE = 4096;
    public static final int CL_DEVICE_TYPE_ACCELERATOR = 8;
    public static final int CL_DEVICE_TYPE_ALL = -1;
    public static final int CL_DEVICE_TYPE_CPU = 2;
    public static final int CL_DEVICE_TYPE_DEFAULT = 1;
    public static final int CL_DEVICE_TYPE_GPU = 4;
    public static final int CL_DEVICE_VENDOR = 4140;
    public static final int CL_DEVICE_VENDOR_ID = 4097;
    public static final int CL_DEVICE_VERSION = 4143;
    public static final int CL_DRIVER_VERSION = 4141;
    public static final int CL_EVENT_COMMAND_EXECUTION_STATUS = 4563;
    public static final int CL_EVENT_COMMAND_QUEUE = 4560;
    public static final int CL_EVENT_COMMAND_TYPE = 4561;
    public static final int CL_EVENT_REFERENCE_COUNT = 4562;
    public static final int CL_EXEC_KERNEL = 1;
    public static final int CL_EXEC_NATIVE_KERNEL = 2;
    public static final int CL_FALSE = 0;
    public static final int CL_FILTER_LINEAR = 4417;
    public static final int CL_FILTER_NEAREST = 4416;
    public static final int CL_FLOAT = 4318;
    public static final int CL_FP_DENORM = 1;
    public static final int CL_FP_FMA = 32;
    public static final int CL_FP_INF_NAN = 2;
    public static final int CL_FP_ROUND_TO_INF = 16;
    public static final int CL_FP_ROUND_TO_NEAREST = 4;
    public static final int CL_FP_ROUND_TO_ZERO = 8;
    public static final int CL_GLOBAL = 2;
    public static final int CL_HALF_FLOAT = 4317;
    public static final int CL_IMAGE_DEPTH = 4374;
    public static final int CL_IMAGE_ELEMENT_SIZE = 4369;
    public static final int CL_IMAGE_FORMAT = 4368;
    public static final int CL_IMAGE_FORMAT_MISMATCH = -9;
    public static final int CL_IMAGE_FORMAT_NOT_SUPPORTED = -10;
    public static final int CL_IMAGE_HEIGHT = 4373;
    public static final int CL_IMAGE_ROW_PITCH = 4370;
    public static final int CL_IMAGE_SLICE_PITCH = 4371;
    public static final int CL_IMAGE_WIDTH = 4372;
    public static final int CL_INTENSITY = 4280;
    public static final int CL_INVALID_ARG_INDEX = -49;
    public static final int CL_INVALID_ARG_SIZE = -51;
    public static final int CL_INVALID_ARG_VALUE = -50;
    public static final int CL_INVALID_BINARY = -42;
    public static final int CL_INVALID_BUFFER_SIZE = -61;
    public static final int CL_INVALID_BUILD_OPTIONS = -43;
    public static final int CL_INVALID_COMMAND_QUEUE = -36;
    public static final int CL_INVALID_CONTEXT = -34;
    public static final int CL_INVALID_DEVICE = -33;
    public static final int CL_INVALID_DEVICE_TYPE = -31;
    public static final int CL_INVALID_EVENT = -58;
    public static final int CL_INVALID_EVENT_WAIT_LIST = -57;
    public static final int CL_INVALID_GLOBAL_OFFSET = -56;
    public static final int CL_INVALID_GLOBAL_WORK_SIZE = -63;
    public static final int CL_INVALID_GL_OBJECT = -60;
    public static final int CL_INVALID_HOST_PTR = -37;
    public static final int CL_INVALID_IMAGE_FORMAT_DESCRIPTOR = -39;
    public static final int CL_INVALID_IMAGE_SIZE = -40;
    public static final int CL_INVALID_KERNEL = -48;
    public static final int CL_INVALID_KERNEL_ARGS = -52;
    public static final int CL_INVALID_KERNEL_DEFINITION = -47;
    public static final int CL_INVALID_KERNEL_NAME = -46;
    public static final int CL_INVALID_MEM_OBJECT = -38;
    public static final int CL_INVALID_MIP_LEVEL = -62;
    public static final int CL_INVALID_OPERATION = -59;
    public static final int CL_INVALID_PLATFORM = -32;
    public static final int CL_INVALID_PROGRAM = -44;
    public static final int CL_INVALID_PROGRAM_EXECUTABLE = -45;
    public static final int CL_INVALID_QUEUE_PROPERTIES = -35;
    public static final int CL_INVALID_SAMPLER = -41;
    public static final int CL_INVALID_VALUE = -30;
    public static final int CL_INVALID_WORK_DIMENSION = -53;
    public static final int CL_INVALID_WORK_GROUP_SIZE = -54;
    public static final int CL_INVALID_WORK_ITEM_SIZE = -55;
    public static final int CL_KERNEL_COMPILE_WORK_GROUP_SIZE = 4529;
    public static final int CL_KERNEL_CONTEXT = 4499;
    public static final int CL_KERNEL_FUNCTION_NAME = 4496;
    public static final int CL_KERNEL_LOCAL_MEM_SIZE = 4530;
    public static final int CL_KERNEL_NUM_ARGS = 4497;
    public static final int CL_KERNEL_PROGRAM = 4500;
    public static final int CL_KERNEL_REFERENCE_COUNT = 4498;
    public static final int CL_KERNEL_WORK_GROUP_SIZE = 4528;
    public static final int CL_LOCAL = 1;
    public static final int CL_LUMINANCE = 4281;
    public static final int CL_MAP_FAILURE = -12;
    public static final int CL_MAP_READ = 1;
    public static final int CL_MAP_WRITE = 2;
    public static final int CL_MEM_ALLOC_HOST_PTR = 16;
    public static final int CL_MEM_CONTEXT = 4358;
    public static final int CL_MEM_COPY_HOST_PTR = 32;
    public static final int CL_MEM_COPY_OVERLAP = -8;
    public static final int CL_MEM_FLAGS = 4353;
    public static final int CL_MEM_HOST_PTR = 4355;
    public static final int CL_MEM_MAP_COUNT = 4356;
    public static final int CL_MEM_OBJECT_ALLOCATION_FAILURE = -4;
    public static final int CL_MEM_OBJECT_BUFFER = 4336;
    public static final int CL_MEM_OBJECT_IMAGE2D = 4337;
    public static final int CL_MEM_OBJECT_IMAGE3D = 4338;
    public static final int CL_MEM_READ_ONLY = 4;
    public static final int CL_MEM_READ_WRITE = 1;
    public static final int CL_MEM_REFERENCE_COUNT = 4357;
    public static final int CL_MEM_SIZE = 4354;
    public static final int CL_MEM_TYPE = 4352;
    public static final int CL_MEM_USE_HOST_PTR = 8;
    public static final int CL_MEM_WRITE_ONLY = 2;
    public static final int CL_NONE = 0;
    public static final int CL_OUT_OF_HOST_MEMORY = -6;
    public static final int CL_OUT_OF_RESOURCES = -5;
    public static final int CL_PLATFORM_EXTENSIONS = 2308;
    public static final int CL_PLATFORM_NAME = 2306;
    public static final int CL_PLATFORM_PROFILE = 2304;
    public static final int CL_PLATFORM_VENDOR = 2307;
    public static final int CL_PLATFORM_VERSION = 2305;
    public static final int CL_PROFILING_COMMAND_END = 4739;
    public static final int CL_PROFILING_COMMAND_QUEUED = 4736;
    public static final int CL_PROFILING_COMMAND_START = 4738;
    public static final int CL_PROFILING_COMMAND_SUBMIT = 4737;
    public static final int CL_PROFILING_INFO_NOT_AVAILABLE = -7;
    public static final int CL_PROGRAM_BINARIES = 4454;
    public static final int CL_PROGRAM_BINARY_SIZES = 4453;
    public static final int CL_PROGRAM_BUILD_LOG = 4483;
    public static final int CL_PROGRAM_BUILD_OPTIONS = 4482;
    public static final int CL_PROGRAM_BUILD_STATUS = 4481;
    public static final int CL_PROGRAM_CONTEXT = 4449;
    public static final int CL_PROGRAM_DEVICES = 4451;
    public static final int CL_PROGRAM_NUM_DEVICES = 4450;
    public static final int CL_PROGRAM_REFERENCE_COUNT = 4448;
    public static final int CL_PROGRAM_SOURCE = 4452;
    public static final int CL_QUEUED = 3;
    public static final int CL_QUEUE_CONTEXT = 4240;
    public static final int CL_QUEUE_DEVICE = 4241;
    public static final int CL_QUEUE_OUT_OF_ORDER_EXEC_MODE_ENABLE = 1;
    public static final int CL_QUEUE_PROFILING_ENABLE = 2;
    public static final int CL_QUEUE_PROPERTIES = 4243;
    public static final int CL_QUEUE_REFERENCE_COUNT = 4242;
    public static final int CL_R = 4272;
    public static final int CL_RA = 4275;
    public static final int CL_READ_ONLY_CACHE = 1;
    public static final int CL_READ_WRITE_CACHE = 2;
    public static final int CL_RG = 4274;
    public static final int CL_RGB = 4276;
    public static final int CL_RGBA = 4277;
    public static final int CL_RUNNING = 1;
    public static final int CL_SAMPLER_ADDRESSING_MODE = 4435;
    public static final int CL_SAMPLER_CONTEXT = 4433;
    public static final int CL_SAMPLER_FILTER_MODE = 4436;
    public static final int CL_SAMPLER_NORMALIZED_COORDS = 4434;
    public static final int CL_SAMPLER_REFERENCE_COUNT = 4432;
    public static final int CL_SIGNED_INT16 = 4312;
    public static final int CL_SIGNED_INT32 = 4313;
    public static final int CL_SIGNED_INT8 = 4311;
    public static final int CL_SNORM_INT16 = 4305;
    public static final int CL_SNORM_INT8 = 4304;
    public static final int CL_SUBMITTED = 2;
    public static final int CL_SUCCESS = 0;
    public static final int CL_TRUE = 1;
    public static final int CL_UNORM_INT16 = 4307;
    public static final int CL_UNORM_INT8 = 4306;
    public static final int CL_UNORM_INT_101010 = 4310;
    public static final int CL_UNORM_SHORT_555 = 4309;
    public static final int CL_UNORM_SHORT_565 = 4308;
    public static final int CL_UNSIGNED_INT16 = 4315;
    public static final int CL_UNSIGNED_INT32 = 4316;
    public static final int CL_UNSIGNED_INT8 = 4314;
    public static final int CL_VERSION_1_0 = 1;

    private CL10() {
    }

    public static int clBuildProgram(CLProgram cLProgram, PointerBuffer pointerBuffer, CharSequence charSequence, CLBuildProgramCallback cLBuildProgramCallback) {
        CLProgram cLProgram2 = cLProgram;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        CharSequence charSequence2 = charSequence;
        CLBuildProgramCallback cLBuildProgramCallback2 = cLBuildProgramCallback;
        long j = CLCapabilities.clBuildProgram;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer2 != null) {
            BufferChecks.checkDirect(pointerBuffer2);
        }
        long createGlobalRef = CallbackUtil.createGlobalRef(cLBuildProgramCallback2);
        if (cLBuildProgramCallback2 != null) {
            cLBuildProgramCallback2.setContext((CLContext) cLProgram2.getParent());
        }
        try {
            int nclBuildProgram = nclBuildProgram(cLProgram2.getPointer(), pointerBuffer2 == null ? 0 : pointerBuffer2.remaining(), MemoryUtil.getAddressSafe(pointerBuffer2), APIUtil.getBufferNT(charSequence2), cLBuildProgramCallback2 == null ? 0 : cLBuildProgramCallback2.getPointer(), createGlobalRef, j);
            CallbackUtil.checkCallback(nclBuildProgram, createGlobalRef);
            return nclBuildProgram;
        } catch (Throwable th) {
            Throwable th2 = th;
            CallbackUtil.checkCallback(0, createGlobalRef);
            throw th2;
        }
    }

    public static int clBuildProgram(CLProgram cLProgram, PointerBuffer pointerBuffer, ByteBuffer byteBuffer, CLBuildProgramCallback cLBuildProgramCallback) {
        CLProgram cLProgram2 = cLProgram;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        CLBuildProgramCallback cLBuildProgramCallback2 = cLBuildProgramCallback;
        long j = CLCapabilities.clBuildProgram;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer2 != null) {
            BufferChecks.checkDirect(pointerBuffer2);
        }
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        long createGlobalRef = CallbackUtil.createGlobalRef(cLBuildProgramCallback2);
        if (cLBuildProgramCallback2 != null) {
            cLBuildProgramCallback2.setContext((CLContext) cLProgram2.getParent());
        }
        try {
            int nclBuildProgram = nclBuildProgram(cLProgram2.getPointer(), pointerBuffer2 == null ? 0 : pointerBuffer2.remaining(), MemoryUtil.getAddressSafe(pointerBuffer2), MemoryUtil.getAddress(byteBuffer2), cLBuildProgramCallback2 == null ? 0 : cLBuildProgramCallback2.getPointer(), createGlobalRef, j);
            CallbackUtil.checkCallback(nclBuildProgram, createGlobalRef);
            return nclBuildProgram;
        } catch (Throwable th) {
            Throwable th2 = th;
            CallbackUtil.checkCallback(0, createGlobalRef);
            throw th2;
        }
    }

    public static int clBuildProgram(CLProgram cLProgram, CLDevice cLDevice, CharSequence charSequence, CLBuildProgramCallback cLBuildProgramCallback) {
        CLProgram cLProgram2 = cLProgram;
        CLDevice cLDevice2 = cLDevice;
        CharSequence charSequence2 = charSequence;
        CLBuildProgramCallback cLBuildProgramCallback2 = cLBuildProgramCallback;
        long j = CLCapabilities.clBuildProgram;
        BufferChecks.checkFunctionAddress(j);
        long createGlobalRef = CallbackUtil.createGlobalRef(cLBuildProgramCallback2);
        if (cLBuildProgramCallback2 != null) {
            cLBuildProgramCallback2.setContext((CLContext) cLProgram2.getParent());
        }
        try {
            int nclBuildProgram = nclBuildProgram(cLProgram2.getPointer(), 1, APIUtil.getPointer(cLDevice2), APIUtil.getBufferNT(charSequence2), cLBuildProgramCallback2 == null ? 0 : cLBuildProgramCallback2.getPointer(), createGlobalRef, j);
            CallbackUtil.checkCallback(nclBuildProgram, createGlobalRef);
            return nclBuildProgram;
        } catch (Throwable th) {
            Throwable th2 = th;
            CallbackUtil.checkCallback(0, createGlobalRef);
            throw th2;
        }
    }

    public static CLMem clCreateBuffer(CLContext cLContext, long j, long j2, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j3 = j;
        long j4 = j2;
        IntBuffer intBuffer2 = intBuffer;
        long j5 = CLCapabilities.clCreateBuffer;
        BufferChecks.checkFunctionAddress(j5);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateBuffer(cLContext2.getPointer(), j3, j4, 0, MemoryUtil.getAddressSafe(intBuffer2), j5), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateBuffer(CLContext cLContext, long j, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(byteBuffer2);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateBuffer(cLContext2.getPointer(), j2, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j3), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateBuffer(CLContext cLContext, long j, DoubleBuffer doubleBuffer, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(doubleBuffer2);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateBuffer(cLContext2.getPointer(), j2, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j3), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateBuffer(CLContext cLContext, long j, FloatBuffer floatBuffer, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(floatBuffer2);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateBuffer(cLContext2.getPointer(), j2, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j3), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateBuffer(CLContext cLContext, long j, IntBuffer intBuffer, IntBuffer intBuffer2) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j3 = CLCapabilities.clCreateBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(intBuffer3);
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateBuffer(cLContext2.getPointer(), j2, (long) (intBuffer3.remaining() << 2), MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddressSafe(intBuffer4), j3), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateBuffer(CLContext cLContext, long j, LongBuffer longBuffer, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        LongBuffer longBuffer2 = longBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(longBuffer2);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateBuffer(cLContext2.getPointer(), j2, (long) (longBuffer2.remaining() << 3), MemoryUtil.getAddress(longBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j3), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateBuffer(CLContext cLContext, long j, ShortBuffer shortBuffer, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j2 = j;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(shortBuffer2);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateBuffer(cLContext2.getPointer(), j2, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j3), cLContext2);
        return cLMem2;
    }

    public static CLCommandQueue clCreateCommandQueue(CLContext cLContext, CLDevice cLDevice, long j, IntBuffer intBuffer) {
        CLCommandQueue cLCommandQueue;
        CLContext cLContext2 = cLContext;
        CLDevice cLDevice2 = cLDevice;
        long j2 = j;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateCommandQueue;
        BufferChecks.checkFunctionAddress(j3);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLCommandQueue cLCommandQueue3 = new CLCommandQueue(nclCreateCommandQueue(cLContext2.getPointer(), cLDevice2.getPointer(), j2, MemoryUtil.getAddressSafe(intBuffer2), j3), cLContext2, cLDevice2);
        return cLCommandQueue2;
    }

    public static CLContext clCreateContext(PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, CLContextCallback cLContextCallback, IntBuffer intBuffer) {
        CLContext cLContext;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        CLContextCallback cLContextCallback2 = cLContextCallback;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateContext;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(pointerBuffer3, 3);
        BufferChecks.checkNullTerminated(pointerBuffer3);
        BufferChecks.checkBuffer(pointerBuffer4, 1);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        long createGlobalRef = (cLContextCallback2 == null || cLContextCallback2.isCustom()) ? 0 : CallbackUtil.createGlobalRef(cLContextCallback2);
        try {
            CLContext cLContext2 = cLContext;
            CLContext cLContext3 = new CLContext(nclCreateContext(MemoryUtil.getAddress(pointerBuffer3), pointerBuffer4.remaining(), MemoryUtil.getAddress(pointerBuffer4), cLContextCallback2 == null ? 0 : cLContextCallback2.getPointer(), createGlobalRef, MemoryUtil.getAddressSafe(intBuffer2), j), APIUtil.getCLPlatform(pointerBuffer3));
            CLContext cLContext4 = cLContext2;
            if (cLContext4 != null) {
                cLContext4.setContextCallback(createGlobalRef);
            }
            return cLContext4;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (0 != 0) {
                CLContext cLContext5 = null;
                cLContext5.setContextCallback(createGlobalRef);
            }
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public static CLContext clCreateContext(PointerBuffer pointerBuffer, CLDevice cLDevice, CLContextCallback cLContextCallback, IntBuffer intBuffer) {
        CLContext cLContext;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        CLDevice cLDevice2 = cLDevice;
        CLContextCallback cLContextCallback2 = cLContextCallback;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateContext;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(pointerBuffer2, 3);
        BufferChecks.checkNullTerminated(pointerBuffer2);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        long createGlobalRef = (cLContextCallback2 == null || cLContextCallback2.isCustom()) ? 0 : CallbackUtil.createGlobalRef(cLContextCallback2);
        try {
            CLContext cLContext2 = cLContext;
            CLContext cLContext3 = new CLContext(nclCreateContext(MemoryUtil.getAddress(pointerBuffer2), 1, APIUtil.getPointer(cLDevice2), cLContextCallback2 == null ? 0 : cLContextCallback2.getPointer(), createGlobalRef, MemoryUtil.getAddressSafe(intBuffer2), j), APIUtil.getCLPlatform(pointerBuffer2));
            CLContext cLContext4 = cLContext2;
            if (cLContext4 != null) {
                cLContext4.setContextCallback(createGlobalRef);
            }
            return cLContext4;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (0 != 0) {
                CLContext cLContext5 = null;
                cLContext5.setContextCallback(createGlobalRef);
            }
            throw th2;
        }
    }

    public static CLContext clCreateContextFromType(PointerBuffer pointerBuffer, long j, CLContextCallback cLContextCallback, IntBuffer intBuffer) {
        CLContext cLContext;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j2 = j;
        CLContextCallback cLContextCallback2 = cLContextCallback;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clCreateContextFromType;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkBuffer(pointerBuffer2, 3);
        BufferChecks.checkNullTerminated(pointerBuffer2);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        long createGlobalRef = (cLContextCallback2 == null || cLContextCallback2.isCustom()) ? 0 : CallbackUtil.createGlobalRef(cLContextCallback2);
        try {
            CLContext cLContext2 = cLContext;
            CLContext cLContext3 = new CLContext(nclCreateContextFromType(MemoryUtil.getAddress(pointerBuffer2), j2, cLContextCallback2 == null ? 0 : cLContextCallback2.getPointer(), createGlobalRef, MemoryUtil.getAddressSafe(intBuffer2), j3), APIUtil.getCLPlatform(pointerBuffer2));
            CLContext cLContext4 = cLContext2;
            if (cLContext4 != null) {
                cLContext4.setContextCallback(createGlobalRef);
            }
            return cLContext4;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (0 != 0) {
                CLContext cLContext5 = null;
                cLContext5.setContextCallback(createGlobalRef);
            }
            throw th2;
        }
    }

    public static CLMem clCreateImage2D(CLContext cLContext, long j, ByteBuffer byteBuffer, long j2, long j3, long j4, ByteBuffer byteBuffer2, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j5 = j;
        ByteBuffer byteBuffer3 = byteBuffer;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        ByteBuffer byteBuffer4 = byteBuffer2;
        IntBuffer intBuffer2 = intBuffer;
        long j9 = CLCapabilities.clCreateImage2D;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(byteBuffer3, 8);
        if (byteBuffer4 != null) {
            BufferChecks.checkBuffer(byteBuffer4, CLChecks.calculateImage2DSize(byteBuffer3, j6, j7, j8));
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateImage2D(cLContext2.getPointer(), j5, MemoryUtil.getAddress(byteBuffer3), j6, j7, j8, MemoryUtil.getAddressSafe(byteBuffer4), MemoryUtil.getAddressSafe(intBuffer2), j9), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateImage2D(CLContext cLContext, long j, ByteBuffer byteBuffer, long j2, long j3, long j4, FloatBuffer floatBuffer, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j5 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j9 = CLCapabilities.clCreateImage2D;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(byteBuffer2, 8);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, CLChecks.calculateImage2DSize(byteBuffer2, j6, j7, j8));
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateImage2D(cLContext2.getPointer(), j5, MemoryUtil.getAddress(byteBuffer2), j6, j7, j8, MemoryUtil.getAddressSafe(floatBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j9), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateImage2D(CLContext cLContext, long j, ByteBuffer byteBuffer, long j2, long j3, long j4, IntBuffer intBuffer, IntBuffer intBuffer2) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j5 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j9 = CLCapabilities.clCreateImage2D;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(byteBuffer2, 8);
        if (intBuffer3 != null) {
            BufferChecks.checkBuffer(intBuffer3, CLChecks.calculateImage2DSize(byteBuffer2, j6, j7, j8));
        }
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateImage2D(cLContext2.getPointer(), j5, MemoryUtil.getAddress(byteBuffer2), j6, j7, j8, MemoryUtil.getAddressSafe(intBuffer3), MemoryUtil.getAddressSafe(intBuffer4), j9), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateImage2D(CLContext cLContext, long j, ByteBuffer byteBuffer, long j2, long j3, long j4, ShortBuffer shortBuffer, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j5 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j9 = CLCapabilities.clCreateImage2D;
        BufferChecks.checkFunctionAddress(j9);
        BufferChecks.checkBuffer(byteBuffer2, 8);
        if (shortBuffer2 != null) {
            BufferChecks.checkBuffer(shortBuffer2, CLChecks.calculateImage2DSize(byteBuffer2, j6, j7, j8));
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateImage2D(cLContext2.getPointer(), j5, MemoryUtil.getAddress(byteBuffer2), j6, j7, j8, MemoryUtil.getAddressSafe(shortBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j9), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateImage3D(CLContext cLContext, long j, ByteBuffer byteBuffer, long j2, long j3, long j4, long j5, long j6, ByteBuffer byteBuffer2, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j7 = j;
        ByteBuffer byteBuffer3 = byteBuffer;
        long j8 = j2;
        long j9 = j3;
        long j10 = j4;
        long j11 = j5;
        long j12 = j6;
        ByteBuffer byteBuffer4 = byteBuffer2;
        IntBuffer intBuffer2 = intBuffer;
        long j13 = CLCapabilities.clCreateImage3D;
        BufferChecks.checkFunctionAddress(j13);
        BufferChecks.checkBuffer(byteBuffer3, 8);
        if (byteBuffer4 != null) {
            BufferChecks.checkBuffer(byteBuffer4, CLChecks.calculateImage3DSize(byteBuffer3, j8, j9, j9, j11, j12));
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateImage3D(cLContext2.getPointer(), j7, MemoryUtil.getAddress(byteBuffer3), j8, j9, j10, j11, j12, MemoryUtil.getAddressSafe(byteBuffer4), MemoryUtil.getAddressSafe(intBuffer2), j13), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateImage3D(CLContext cLContext, long j, ByteBuffer byteBuffer, long j2, long j3, long j4, long j5, long j6, FloatBuffer floatBuffer, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j7 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j8 = j2;
        long j9 = j3;
        long j10 = j4;
        long j11 = j5;
        long j12 = j6;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j13 = CLCapabilities.clCreateImage3D;
        BufferChecks.checkFunctionAddress(j13);
        BufferChecks.checkBuffer(byteBuffer2, 8);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, CLChecks.calculateImage3DSize(byteBuffer2, j8, j9, j9, j11, j12));
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateImage3D(cLContext2.getPointer(), j7, MemoryUtil.getAddress(byteBuffer2), j8, j9, j10, j11, j12, MemoryUtil.getAddressSafe(floatBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j13), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateImage3D(CLContext cLContext, long j, ByteBuffer byteBuffer, long j2, long j3, long j4, long j5, long j6, IntBuffer intBuffer, IntBuffer intBuffer2) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j7 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j8 = j2;
        long j9 = j3;
        long j10 = j4;
        long j11 = j5;
        long j12 = j6;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j13 = CLCapabilities.clCreateImage3D;
        BufferChecks.checkFunctionAddress(j13);
        BufferChecks.checkBuffer(byteBuffer2, 8);
        if (intBuffer3 != null) {
            BufferChecks.checkBuffer(intBuffer3, CLChecks.calculateImage3DSize(byteBuffer2, j8, j9, j9, j11, j12));
        }
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateImage3D(cLContext2.getPointer(), j7, MemoryUtil.getAddress(byteBuffer2), j8, j9, j10, j11, j12, MemoryUtil.getAddressSafe(intBuffer3), MemoryUtil.getAddressSafe(intBuffer4), j13), cLContext2);
        return cLMem2;
    }

    public static CLMem clCreateImage3D(CLContext cLContext, long j, ByteBuffer byteBuffer, long j2, long j3, long j4, long j5, long j6, ShortBuffer shortBuffer, IntBuffer intBuffer) {
        CLMem cLMem;
        CLContext cLContext2 = cLContext;
        long j7 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j8 = j2;
        long j9 = j3;
        long j10 = j4;
        long j11 = j5;
        long j12 = j6;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j13 = CLCapabilities.clCreateImage3D;
        BufferChecks.checkFunctionAddress(j13);
        BufferChecks.checkBuffer(byteBuffer2, 8);
        if (shortBuffer2 != null) {
            BufferChecks.checkBuffer(shortBuffer2, CLChecks.calculateImage3DSize(byteBuffer2, j8, j9, j9, j11, j12));
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLMem cLMem2 = cLMem;
        CLMem cLMem3 = new CLMem(nclCreateImage3D(cLContext2.getPointer(), j7, MemoryUtil.getAddress(byteBuffer2), j8, j9, j10, j11, j12, MemoryUtil.getAddressSafe(shortBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j13), cLContext2);
        return cLMem2;
    }

    public static CLKernel clCreateKernel(CLProgram cLProgram, CharSequence charSequence, IntBuffer intBuffer) {
        CLKernel cLKernel;
        CLProgram cLProgram2 = cLProgram;
        CharSequence charSequence2 = charSequence;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateKernel;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLKernel cLKernel2 = cLKernel;
        CLKernel cLKernel3 = new CLKernel(nclCreateKernel(cLProgram2.getPointer(), APIUtil.getBufferNT(charSequence2), MemoryUtil.getAddressSafe(intBuffer2), j), cLProgram2);
        return cLKernel2;
    }

    public static CLKernel clCreateKernel(CLProgram cLProgram, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        CLKernel cLKernel;
        CLProgram cLProgram2 = cLProgram;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateKernel;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLKernel cLKernel2 = cLKernel;
        CLKernel cLKernel3 = new CLKernel(nclCreateKernel(cLProgram2.getPointer(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j), cLProgram2);
        return cLKernel2;
    }

    public static int clCreateKernelsInProgram(CLProgram cLProgram, PointerBuffer pointerBuffer, IntBuffer intBuffer) {
        CLProgram cLProgram2 = cLProgram;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateKernelsInProgram;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer2 != null) {
            BufferChecks.checkDirect(pointerBuffer2);
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        int nclCreateKernelsInProgram = nclCreateKernelsInProgram(cLProgram2.getPointer(), pointerBuffer2 == null ? 0 : pointerBuffer2.remaining(), MemoryUtil.getAddressSafe(pointerBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j);
        if (nclCreateKernelsInProgram == 0 && pointerBuffer2 != null) {
            cLProgram2.registerCLKernels(pointerBuffer2);
        }
        return nclCreateKernelsInProgram;
    }

    public static CLProgram clCreateProgramWithBinary(CLContext cLContext, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, ByteBuffer byteBuffer, IntBuffer intBuffer, IntBuffer intBuffer2) {
        CLProgram cLProgram;
        CLContext cLContext2 = cLContext;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = CLCapabilities.clCreateProgramWithBinary;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(pointerBuffer3, 1);
        BufferChecks.checkBuffer(pointerBuffer4, pointerBuffer3.remaining());
        BufferChecks.checkBuffer(byteBuffer2, APIUtil.getSize(pointerBuffer4));
        BufferChecks.checkBuffer(intBuffer3, pointerBuffer3.remaining());
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        CLProgram cLProgram2 = cLProgram;
        CLProgram cLProgram3 = new CLProgram(nclCreateProgramWithBinary2(cLContext2.getPointer(), pointerBuffer3.remaining(), MemoryUtil.getAddress(pointerBuffer3), MemoryUtil.getAddress(pointerBuffer4), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddressSafe(intBuffer4), j), cLContext2);
        return cLProgram2;
    }

    public static CLProgram clCreateProgramWithBinary(CLContext cLContext, PointerBuffer pointerBuffer, ByteBuffer[] byteBufferArr, IntBuffer intBuffer, IntBuffer intBuffer2) {
        CLProgram cLProgram;
        CLContext cLContext2 = cLContext;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        ByteBuffer[] byteBufferArr2 = byteBufferArr;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = CLCapabilities.clCreateProgramWithBinary;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(pointerBuffer2, byteBufferArr2.length);
        BufferChecks.checkArray((Object[]) byteBufferArr2, 1);
        BufferChecks.checkBuffer(intBuffer3, byteBufferArr2.length);
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        CLProgram cLProgram2 = cLProgram;
        CLProgram cLProgram3 = new CLProgram(nclCreateProgramWithBinary3(cLContext2.getPointer(), byteBufferArr2.length, MemoryUtil.getAddress(pointerBuffer2), APIUtil.getLengths(byteBufferArr2), byteBufferArr2, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddressSafe(intBuffer4), j), cLContext2);
        return cLProgram2;
    }

    public static CLProgram clCreateProgramWithBinary(CLContext cLContext, CLDevice cLDevice, ByteBuffer byteBuffer, IntBuffer intBuffer, IntBuffer intBuffer2) {
        CLProgram cLProgram;
        CLContext cLContext2 = cLContext;
        CLDevice cLDevice2 = cLDevice;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = CLCapabilities.clCreateProgramWithBinary;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkBuffer(intBuffer3, 1);
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        CLProgram cLProgram2 = cLProgram;
        CLProgram cLProgram3 = new CLProgram(nclCreateProgramWithBinary(cLContext2.getPointer(), 1, cLDevice2.getPointer(), (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddressSafe(intBuffer4), j), cLContext2);
        return cLProgram2;
    }

    public static CLProgram clCreateProgramWithSource(CLContext cLContext, CharSequence charSequence, IntBuffer intBuffer) {
        CLProgram cLProgram;
        CLContext cLContext2 = cLContext;
        CharSequence charSequence2 = charSequence;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateProgramWithSource;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLProgram cLProgram2 = cLProgram;
        CLProgram cLProgram3 = new CLProgram(nclCreateProgramWithSource(cLContext2.getPointer(), 1, APIUtil.getBuffer(charSequence2), (long) charSequence2.length(), MemoryUtil.getAddressSafe(intBuffer2), j), cLContext2);
        return cLProgram2;
    }

    public static CLProgram clCreateProgramWithSource(CLContext cLContext, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        CLProgram cLProgram;
        CLContext cLContext2 = cLContext;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateProgramWithSource;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLProgram cLProgram2 = cLProgram;
        CLProgram cLProgram3 = new CLProgram(nclCreateProgramWithSource(cLContext2.getPointer(), 1, MemoryUtil.getAddress(byteBuffer2), (long) byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), j), cLContext2);
        return cLProgram2;
    }

    public static CLProgram clCreateProgramWithSource(CLContext cLContext, ByteBuffer byteBuffer, PointerBuffer pointerBuffer, IntBuffer intBuffer) {
        CLProgram cLProgram;
        CLContext cLContext2 = cLContext;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateProgramWithSource;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, APIUtil.getSize(pointerBuffer2));
        BufferChecks.checkBuffer(pointerBuffer2, 1);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLProgram cLProgram2 = cLProgram;
        CLProgram cLProgram3 = new CLProgram(nclCreateProgramWithSource2(cLContext2.getPointer(), pointerBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(pointerBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j), cLContext2);
        return cLProgram2;
    }

    public static CLProgram clCreateProgramWithSource(CLContext cLContext, CharSequence[] charSequenceArr, IntBuffer intBuffer) {
        CLProgram cLProgram;
        CLContext cLContext2 = cLContext;
        CharSequence[] charSequenceArr2 = charSequenceArr;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateProgramWithSource;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkArray(charSequenceArr2);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLProgram cLProgram2 = cLProgram;
        CLProgram cLProgram3 = new CLProgram(nclCreateProgramWithSource4(cLContext2.getPointer(), charSequenceArr2.length, APIUtil.getBuffer(charSequenceArr2), APIUtil.getLengths(charSequenceArr2), MemoryUtil.getAddressSafe(intBuffer2), j), cLContext2);
        return cLProgram2;
    }

    public static CLProgram clCreateProgramWithSource(CLContext cLContext, ByteBuffer[] byteBufferArr, IntBuffer intBuffer) {
        CLProgram cLProgram;
        CLContext cLContext2 = cLContext;
        ByteBuffer[] byteBufferArr2 = byteBufferArr;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateProgramWithSource;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkArray((Object[]) byteBufferArr2, 1);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLProgram cLProgram2 = cLProgram;
        CLProgram cLProgram3 = new CLProgram(nclCreateProgramWithSource3(cLContext2.getPointer(), byteBufferArr2.length, byteBufferArr2, APIUtil.getLengths(byteBufferArr2), MemoryUtil.getAddressSafe(intBuffer2), j), cLContext2);
        return cLProgram2;
    }

    public static CLSampler clCreateSampler(CLContext cLContext, int i, int i2, int i3, IntBuffer intBuffer) {
        CLSampler cLSampler;
        CLContext cLContext2 = cLContext;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateSampler;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLSampler cLSampler2 = cLSampler;
        CLSampler cLSampler3 = new CLSampler(nclCreateSampler(cLContext2.getPointer(), i4, i5, i6, MemoryUtil.getAddressSafe(intBuffer2), j), cLContext2);
        return cLSampler2;
    }

    public static int clEnqueueBarrier(CLCommandQueue cLCommandQueue) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        long j = CLCapabilities.clEnqueueBarrier;
        BufferChecks.checkFunctionAddress(j);
        return nclEnqueueBarrier(cLCommandQueue2.getPointer(), j);
    }

    public static int clEnqueueCopyBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, CLMem cLMem2, long j, long j2, long j3, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem3 = cLMem;
        CLMem cLMem4 = cLMem2;
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j7 = CLCapabilities.clEnqueueCopyBuffer;
        BufferChecks.checkFunctionAddress(j7);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueCopyBuffer = nclEnqueueCopyBuffer(cLCommandQueue2.getPointer(), cLMem3.getPointer(), cLMem4.getPointer(), j4, j5, j6, pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j7);
        if (nclEnqueueCopyBuffer == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueCopyBuffer;
    }

    public static int clEnqueueCopyBufferToImage(CLCommandQueue cLCommandQueue, CLMem cLMem, CLMem cLMem2, long j, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, PointerBuffer pointerBuffer4) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem3 = cLMem;
        CLMem cLMem4 = cLMem2;
        long j2 = j;
        PointerBuffer pointerBuffer5 = pointerBuffer;
        PointerBuffer pointerBuffer6 = pointerBuffer2;
        PointerBuffer pointerBuffer7 = pointerBuffer3;
        PointerBuffer pointerBuffer8 = pointerBuffer4;
        long j3 = CLCapabilities.clEnqueueCopyBufferToImage;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkBuffer(pointerBuffer5, 3);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        if (pointerBuffer7 != null) {
            BufferChecks.checkDirect(pointerBuffer7);
        }
        if (pointerBuffer8 != null) {
            BufferChecks.checkBuffer(pointerBuffer8, 1);
        }
        int nclEnqueueCopyBufferToImage = nclEnqueueCopyBufferToImage(cLCommandQueue2.getPointer(), cLMem3.getPointer(), cLMem4.getPointer(), j2, MemoryUtil.getAddress(pointerBuffer5), MemoryUtil.getAddress(pointerBuffer6), pointerBuffer7 == null ? 0 : pointerBuffer7.remaining(), MemoryUtil.getAddressSafe(pointerBuffer7), MemoryUtil.getAddressSafe(pointerBuffer8), j3);
        if (nclEnqueueCopyBufferToImage == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer8);
        }
        return nclEnqueueCopyBufferToImage;
    }

    public static int clEnqueueCopyImage(CLCommandQueue cLCommandQueue, CLMem cLMem, CLMem cLMem2, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem3 = cLMem;
        CLMem cLMem4 = cLMem2;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j = CLCapabilities.clEnqueueCopyImage;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueCopyImage = nclEnqueueCopyImage(cLCommandQueue2.getPointer(), cLMem3.getPointer(), cLMem4.getPointer(), MemoryUtil.getAddress(pointerBuffer6), MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j);
        if (nclEnqueueCopyImage == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueCopyImage;
    }

    public static int clEnqueueCopyImageToBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, CLMem cLMem2, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, long j, PointerBuffer pointerBuffer3, PointerBuffer pointerBuffer4) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem3 = cLMem;
        CLMem cLMem4 = cLMem2;
        PointerBuffer pointerBuffer5 = pointerBuffer;
        PointerBuffer pointerBuffer6 = pointerBuffer2;
        long j2 = j;
        PointerBuffer pointerBuffer7 = pointerBuffer3;
        PointerBuffer pointerBuffer8 = pointerBuffer4;
        long j3 = CLCapabilities.clEnqueueCopyImageToBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkBuffer(pointerBuffer5, 3);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        if (pointerBuffer7 != null) {
            BufferChecks.checkDirect(pointerBuffer7);
        }
        if (pointerBuffer8 != null) {
            BufferChecks.checkBuffer(pointerBuffer8, 1);
        }
        int nclEnqueueCopyImageToBuffer = nclEnqueueCopyImageToBuffer(cLCommandQueue2.getPointer(), cLMem3.getPointer(), cLMem4.getPointer(), MemoryUtil.getAddress(pointerBuffer5), MemoryUtil.getAddress(pointerBuffer6), j2, pointerBuffer7 == null ? 0 : pointerBuffer7.remaining(), MemoryUtil.getAddressSafe(pointerBuffer7), MemoryUtil.getAddressSafe(pointerBuffer8), j3);
        if (nclEnqueueCopyImageToBuffer == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer8);
        }
        return nclEnqueueCopyImageToBuffer;
    }

    public static ByteBuffer clEnqueueMapBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, long j, long j2, long j3, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, IntBuffer intBuffer) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        IntBuffer intBuffer2 = intBuffer;
        long j7 = CLCapabilities.clEnqueueMapBuffer;
        BufferChecks.checkFunctionAddress(j7);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        ByteBuffer nclEnqueueMapBuffer = nclEnqueueMapBuffer(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, j4, j5, j6, pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), MemoryUtil.getAddressSafe(intBuffer2), j6, j7);
        if (nclEnqueueMapBuffer != null) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        if (!LWJGLUtil.CHECKS || nclEnqueueMapBuffer != null) {
            return nclEnqueueMapBuffer.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static ByteBuffer clEnqueueMapImage(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, long j, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5, PointerBuffer pointerBuffer6, IntBuffer intBuffer) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        long j2 = j;
        PointerBuffer pointerBuffer7 = pointerBuffer;
        PointerBuffer pointerBuffer8 = pointerBuffer2;
        PointerBuffer pointerBuffer9 = pointerBuffer3;
        PointerBuffer pointerBuffer10 = pointerBuffer4;
        PointerBuffer pointerBuffer11 = pointerBuffer5;
        PointerBuffer pointerBuffer12 = pointerBuffer6;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clEnqueueMapImage;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkBuffer(pointerBuffer7, 3);
        BufferChecks.checkBuffer(pointerBuffer8, 3);
        BufferChecks.checkBuffer(pointerBuffer9, 1);
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        if (pointerBuffer11 != null) {
            BufferChecks.checkDirect(pointerBuffer11);
        }
        if (pointerBuffer12 != null) {
            BufferChecks.checkBuffer(pointerBuffer12, 1);
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        ByteBuffer nclEnqueueMapImage = nclEnqueueMapImage(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, j2, MemoryUtil.getAddress(pointerBuffer7), MemoryUtil.getAddress(pointerBuffer8), MemoryUtil.getAddress(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), pointerBuffer11 == null ? 0 : pointerBuffer11.remaining(), MemoryUtil.getAddressSafe(pointerBuffer11), MemoryUtil.getAddressSafe(pointerBuffer12), MemoryUtil.getAddressSafe(intBuffer2), j3);
        if (nclEnqueueMapImage != null) {
            cLCommandQueue2.registerCLEvent(pointerBuffer12);
        }
        if (!LWJGLUtil.CHECKS || nclEnqueueMapImage != null) {
            return nclEnqueueMapImage.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static int clEnqueueMarker(CLCommandQueue cLCommandQueue, PointerBuffer pointerBuffer) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clEnqueueMarker;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(pointerBuffer2, 1);
        int nclEnqueueMarker = nclEnqueueMarker(cLCommandQueue2.getPointer(), MemoryUtil.getAddress(pointerBuffer2), j);
        if (nclEnqueueMarker == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer2);
        }
        return nclEnqueueMarker;
    }

    public static int clEnqueueNDRangeKernel(CLCommandQueue cLCommandQueue, CLKernel cLKernel, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3, PointerBuffer pointerBuffer4, PointerBuffer pointerBuffer5) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLKernel cLKernel2 = cLKernel;
        int i2 = i;
        PointerBuffer pointerBuffer6 = pointerBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer2;
        PointerBuffer pointerBuffer8 = pointerBuffer3;
        PointerBuffer pointerBuffer9 = pointerBuffer4;
        PointerBuffer pointerBuffer10 = pointerBuffer5;
        long j = CLCapabilities.clEnqueueNDRangeKernel;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer6 != null) {
            BufferChecks.checkBuffer(pointerBuffer6, i2);
        }
        if (pointerBuffer7 != null) {
            BufferChecks.checkBuffer(pointerBuffer7, i2);
        }
        if (pointerBuffer8 != null) {
            BufferChecks.checkBuffer(pointerBuffer8, i2);
        }
        if (pointerBuffer9 != null) {
            BufferChecks.checkDirect(pointerBuffer9);
        }
        if (pointerBuffer10 != null) {
            BufferChecks.checkBuffer(pointerBuffer10, 1);
        }
        int nclEnqueueNDRangeKernel = nclEnqueueNDRangeKernel(cLCommandQueue2.getPointer(), cLKernel2.getPointer(), i2, MemoryUtil.getAddressSafe(pointerBuffer6), MemoryUtil.getAddressSafe(pointerBuffer7), MemoryUtil.getAddressSafe(pointerBuffer8), pointerBuffer9 == null ? 0 : pointerBuffer9.remaining(), MemoryUtil.getAddressSafe(pointerBuffer9), MemoryUtil.getAddressSafe(pointerBuffer10), j);
        if (nclEnqueueNDRangeKernel == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer10);
        }
        return nclEnqueueNDRangeKernel;
    }

    public static int clEnqueueNativeKernel(CLCommandQueue cLCommandQueue, CLNativeKernel cLNativeKernel, CLMem[] cLMemArr, long[] jArr, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLNativeKernel cLNativeKernel2 = cLNativeKernel;
        CLMem[] cLMemArr2 = cLMemArr;
        long[] jArr2 = jArr;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j = CLCapabilities.clEnqueueNativeKernel;
        BufferChecks.checkFunctionAddress(j);
        if (cLMemArr2 != null) {
            BufferChecks.checkArray((Object[]) cLMemArr2, 1);
        }
        if (jArr2 != null) {
            BufferChecks.checkArray(jArr2, cLMemArr2.length);
        }
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        long createGlobalRef = CallbackUtil.createGlobalRef(cLNativeKernel2);
        ByteBuffer nativeKernelArgs = APIUtil.getNativeKernelArgs(createGlobalRef, cLMemArr2, jArr2);
        try {
            int nclEnqueueNativeKernel = nclEnqueueNativeKernel(cLCommandQueue2.getPointer(), cLNativeKernel2.getPointer(), MemoryUtil.getAddress0((Buffer) nativeKernelArgs), (long) nativeKernelArgs.remaining(), cLMemArr2 == null ? 0 : cLMemArr2.length, cLMemArr2, pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j);
            if (nclEnqueueNativeKernel == 0) {
                cLCommandQueue2.registerCLEvent(pointerBuffer4);
            }
            CallbackUtil.checkCallback(nclEnqueueNativeKernel, createGlobalRef);
            return nclEnqueueNativeKernel;
        } catch (Throwable th) {
            Throwable th2 = th;
            CallbackUtil.checkCallback(0, createGlobalRef);
            throw th2;
        }
    }

    public static int clEnqueueReadBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, long j, ByteBuffer byteBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        long j2 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j3 = CLCapabilities.clEnqueueReadBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(byteBuffer2);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueReadBuffer = nclEnqueueReadBuffer(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, j2, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j3);
        if (nclEnqueueReadBuffer == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueReadBuffer;
    }

    public static int clEnqueueReadBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, long j, DoubleBuffer doubleBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        long j2 = j;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j3 = CLCapabilities.clEnqueueReadBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(doubleBuffer2);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueReadBuffer = nclEnqueueReadBuffer(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, j2, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j3);
        if (nclEnqueueReadBuffer == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueReadBuffer;
    }

    public static int clEnqueueReadBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, long j, FloatBuffer floatBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        long j2 = j;
        FloatBuffer floatBuffer2 = floatBuffer;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j3 = CLCapabilities.clEnqueueReadBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(floatBuffer2);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueReadBuffer = nclEnqueueReadBuffer(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, j2, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j3);
        if (nclEnqueueReadBuffer == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueReadBuffer;
    }

    public static int clEnqueueReadBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, long j, IntBuffer intBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        long j2 = j;
        IntBuffer intBuffer2 = intBuffer;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j3 = CLCapabilities.clEnqueueReadBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(intBuffer2);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueReadBuffer = nclEnqueueReadBuffer(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, j2, (long) (intBuffer2.remaining() << 2), MemoryUtil.getAddress(intBuffer2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j3);
        if (nclEnqueueReadBuffer == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueReadBuffer;
    }

    public static int clEnqueueReadBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, long j, LongBuffer longBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        long j2 = j;
        LongBuffer longBuffer2 = longBuffer;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j3 = CLCapabilities.clEnqueueReadBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(longBuffer2);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueReadBuffer = nclEnqueueReadBuffer(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, j2, (long) (longBuffer2.remaining() << 3), MemoryUtil.getAddress(longBuffer2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j3);
        if (nclEnqueueReadBuffer == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueReadBuffer;
    }

    public static int clEnqueueReadBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, long j, ShortBuffer shortBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        long j2 = j;
        ShortBuffer shortBuffer2 = shortBuffer;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j3 = CLCapabilities.clEnqueueReadBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(shortBuffer2);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueReadBuffer = nclEnqueueReadBuffer(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, j2, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j3);
        if (nclEnqueueReadBuffer == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueReadBuffer;
    }

    public static int clEnqueueReadImage(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, long j, long j2, ByteBuffer byteBuffer, PointerBuffer pointerBuffer3, PointerBuffer pointerBuffer4) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer5 = pointerBuffer;
        PointerBuffer pointerBuffer6 = pointerBuffer2;
        long j3 = j;
        long j4 = j2;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer3;
        PointerBuffer pointerBuffer8 = pointerBuffer4;
        long j5 = CLCapabilities.clEnqueueReadImage;
        BufferChecks.checkFunctionAddress(j5);
        BufferChecks.checkBuffer(pointerBuffer5, 3);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(byteBuffer2, CLChecks.calculateImageSize(pointerBuffer6, j3, j4));
        if (pointerBuffer7 != null) {
            BufferChecks.checkDirect(pointerBuffer7);
        }
        if (pointerBuffer8 != null) {
            BufferChecks.checkBuffer(pointerBuffer8, 1);
        }
        int nclEnqueueReadImage = nclEnqueueReadImage(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer5), MemoryUtil.getAddress(pointerBuffer6), j3, j4, MemoryUtil.getAddress(byteBuffer2), pointerBuffer7 == null ? 0 : pointerBuffer7.remaining(), MemoryUtil.getAddressSafe(pointerBuffer7), MemoryUtil.getAddressSafe(pointerBuffer8), j5);
        if (nclEnqueueReadImage == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer8);
        }
        return nclEnqueueReadImage;
    }

    public static int clEnqueueReadImage(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, long j, long j2, FloatBuffer floatBuffer, PointerBuffer pointerBuffer3, PointerBuffer pointerBuffer4) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer5 = pointerBuffer;
        PointerBuffer pointerBuffer6 = pointerBuffer2;
        long j3 = j;
        long j4 = j2;
        FloatBuffer floatBuffer2 = floatBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer3;
        PointerBuffer pointerBuffer8 = pointerBuffer4;
        long j5 = CLCapabilities.clEnqueueReadImage;
        BufferChecks.checkFunctionAddress(j5);
        BufferChecks.checkBuffer(pointerBuffer5, 3);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(floatBuffer2, CLChecks.calculateImageSize(pointerBuffer6, j3, j4));
        if (pointerBuffer7 != null) {
            BufferChecks.checkDirect(pointerBuffer7);
        }
        if (pointerBuffer8 != null) {
            BufferChecks.checkBuffer(pointerBuffer8, 1);
        }
        int nclEnqueueReadImage = nclEnqueueReadImage(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer5), MemoryUtil.getAddress(pointerBuffer6), j3, j4, MemoryUtil.getAddress(floatBuffer2), pointerBuffer7 == null ? 0 : pointerBuffer7.remaining(), MemoryUtil.getAddressSafe(pointerBuffer7), MemoryUtil.getAddressSafe(pointerBuffer8), j5);
        if (nclEnqueueReadImage == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer8);
        }
        return nclEnqueueReadImage;
    }

    public static int clEnqueueReadImage(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, long j, long j2, IntBuffer intBuffer, PointerBuffer pointerBuffer3, PointerBuffer pointerBuffer4) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer5 = pointerBuffer;
        PointerBuffer pointerBuffer6 = pointerBuffer2;
        long j3 = j;
        long j4 = j2;
        IntBuffer intBuffer2 = intBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer3;
        PointerBuffer pointerBuffer8 = pointerBuffer4;
        long j5 = CLCapabilities.clEnqueueReadImage;
        BufferChecks.checkFunctionAddress(j5);
        BufferChecks.checkBuffer(pointerBuffer5, 3);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(intBuffer2, CLChecks.calculateImageSize(pointerBuffer6, j3, j4));
        if (pointerBuffer7 != null) {
            BufferChecks.checkDirect(pointerBuffer7);
        }
        if (pointerBuffer8 != null) {
            BufferChecks.checkBuffer(pointerBuffer8, 1);
        }
        int nclEnqueueReadImage = nclEnqueueReadImage(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer5), MemoryUtil.getAddress(pointerBuffer6), j3, j4, MemoryUtil.getAddress(intBuffer2), pointerBuffer7 == null ? 0 : pointerBuffer7.remaining(), MemoryUtil.getAddressSafe(pointerBuffer7), MemoryUtil.getAddressSafe(pointerBuffer8), j5);
        if (nclEnqueueReadImage == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer8);
        }
        return nclEnqueueReadImage;
    }

    public static int clEnqueueReadImage(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, long j, long j2, ShortBuffer shortBuffer, PointerBuffer pointerBuffer3, PointerBuffer pointerBuffer4) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer5 = pointerBuffer;
        PointerBuffer pointerBuffer6 = pointerBuffer2;
        long j3 = j;
        long j4 = j2;
        ShortBuffer shortBuffer2 = shortBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer3;
        PointerBuffer pointerBuffer8 = pointerBuffer4;
        long j5 = CLCapabilities.clEnqueueReadImage;
        BufferChecks.checkFunctionAddress(j5);
        BufferChecks.checkBuffer(pointerBuffer5, 3);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(shortBuffer2, CLChecks.calculateImageSize(pointerBuffer6, j3, j4));
        if (pointerBuffer7 != null) {
            BufferChecks.checkDirect(pointerBuffer7);
        }
        if (pointerBuffer8 != null) {
            BufferChecks.checkBuffer(pointerBuffer8, 1);
        }
        int nclEnqueueReadImage = nclEnqueueReadImage(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer5), MemoryUtil.getAddress(pointerBuffer6), j3, j4, MemoryUtil.getAddress(shortBuffer2), pointerBuffer7 == null ? 0 : pointerBuffer7.remaining(), MemoryUtil.getAddressSafe(pointerBuffer7), MemoryUtil.getAddressSafe(pointerBuffer8), j5);
        if (nclEnqueueReadImage == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer8);
        }
        return nclEnqueueReadImage;
    }

    public static int clEnqueueTask(CLCommandQueue cLCommandQueue, CLKernel cLKernel, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLKernel cLKernel2 = cLKernel;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j = CLCapabilities.clEnqueueTask;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueTask = nclEnqueueTask(cLCommandQueue2.getPointer(), cLKernel2.getPointer(), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j);
        if (nclEnqueueTask == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueTask;
    }

    public static int clEnqueueUnmapMemObject(CLCommandQueue cLCommandQueue, CLMem cLMem, ByteBuffer byteBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j = CLCapabilities.clEnqueueUnmapMemObject;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueUnmapMemObject = nclEnqueueUnmapMemObject(cLCommandQueue2.getPointer(), cLMem2.getPointer(), MemoryUtil.getAddress(byteBuffer2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j);
        if (nclEnqueueUnmapMemObject == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueUnmapMemObject;
    }

    public static int clEnqueueWaitForEvents(CLCommandQueue cLCommandQueue, PointerBuffer pointerBuffer) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clEnqueueWaitForEvents;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(pointerBuffer2, 1);
        return nclEnqueueWaitForEvents(cLCommandQueue2.getPointer(), pointerBuffer2.remaining(), MemoryUtil.getAddress(pointerBuffer2), j);
    }

    public static int clEnqueueWaitForEvents(CLCommandQueue cLCommandQueue, CLEvent cLEvent) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLEvent cLEvent2 = cLEvent;
        long j = CLCapabilities.clEnqueueWaitForEvents;
        BufferChecks.checkFunctionAddress(j);
        return nclEnqueueWaitForEvents(cLCommandQueue2.getPointer(), 1, APIUtil.getPointer(cLEvent2), j);
    }

    public static int clEnqueueWriteBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, long j, ByteBuffer byteBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        long j2 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j3 = CLCapabilities.clEnqueueWriteBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(byteBuffer2);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueWriteBuffer = nclEnqueueWriteBuffer(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, j2, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j3);
        if (nclEnqueueWriteBuffer == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueWriteBuffer;
    }

    public static int clEnqueueWriteBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, long j, DoubleBuffer doubleBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        long j2 = j;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j3 = CLCapabilities.clEnqueueWriteBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(doubleBuffer2);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueWriteBuffer = nclEnqueueWriteBuffer(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, j2, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j3);
        if (nclEnqueueWriteBuffer == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueWriteBuffer;
    }

    public static int clEnqueueWriteBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, long j, FloatBuffer floatBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        long j2 = j;
        FloatBuffer floatBuffer2 = floatBuffer;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j3 = CLCapabilities.clEnqueueWriteBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(floatBuffer2);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueWriteBuffer = nclEnqueueWriteBuffer(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, j2, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j3);
        if (nclEnqueueWriteBuffer == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueWriteBuffer;
    }

    public static int clEnqueueWriteBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, long j, IntBuffer intBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        long j2 = j;
        IntBuffer intBuffer2 = intBuffer;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j3 = CLCapabilities.clEnqueueWriteBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(intBuffer2);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueWriteBuffer = nclEnqueueWriteBuffer(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, j2, (long) (intBuffer2.remaining() << 2), MemoryUtil.getAddress(intBuffer2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j3);
        if (nclEnqueueWriteBuffer == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueWriteBuffer;
    }

    public static int clEnqueueWriteBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, long j, LongBuffer longBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        long j2 = j;
        LongBuffer longBuffer2 = longBuffer;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j3 = CLCapabilities.clEnqueueWriteBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(longBuffer2);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueWriteBuffer = nclEnqueueWriteBuffer(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, j2, (long) (longBuffer2.remaining() << 3), MemoryUtil.getAddress(longBuffer2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j3);
        if (nclEnqueueWriteBuffer == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueWriteBuffer;
    }

    public static int clEnqueueWriteBuffer(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, long j, ShortBuffer shortBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        long j2 = j;
        ShortBuffer shortBuffer2 = shortBuffer;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j3 = CLCapabilities.clEnqueueWriteBuffer;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(shortBuffer2);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueWriteBuffer = nclEnqueueWriteBuffer(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, j2, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j3);
        if (nclEnqueueWriteBuffer == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueWriteBuffer;
    }

    public static int clEnqueueWriteImage(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, long j, long j2, ByteBuffer byteBuffer, PointerBuffer pointerBuffer3, PointerBuffer pointerBuffer4) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer5 = pointerBuffer;
        PointerBuffer pointerBuffer6 = pointerBuffer2;
        long j3 = j;
        long j4 = j2;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer3;
        PointerBuffer pointerBuffer8 = pointerBuffer4;
        long j5 = CLCapabilities.clEnqueueWriteImage;
        BufferChecks.checkFunctionAddress(j5);
        BufferChecks.checkBuffer(pointerBuffer5, 3);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(byteBuffer2, CLChecks.calculateImageSize(pointerBuffer6, j3, j4));
        if (pointerBuffer7 != null) {
            BufferChecks.checkDirect(pointerBuffer7);
        }
        if (pointerBuffer8 != null) {
            BufferChecks.checkBuffer(pointerBuffer8, 1);
        }
        int nclEnqueueWriteImage = nclEnqueueWriteImage(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer5), MemoryUtil.getAddress(pointerBuffer6), j3, j4, MemoryUtil.getAddress(byteBuffer2), pointerBuffer7 == null ? 0 : pointerBuffer7.remaining(), MemoryUtil.getAddressSafe(pointerBuffer7), MemoryUtil.getAddressSafe(pointerBuffer8), j5);
        if (nclEnqueueWriteImage == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer8);
        }
        return nclEnqueueWriteImage;
    }

    public static int clEnqueueWriteImage(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, long j, long j2, FloatBuffer floatBuffer, PointerBuffer pointerBuffer3, PointerBuffer pointerBuffer4) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer5 = pointerBuffer;
        PointerBuffer pointerBuffer6 = pointerBuffer2;
        long j3 = j;
        long j4 = j2;
        FloatBuffer floatBuffer2 = floatBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer3;
        PointerBuffer pointerBuffer8 = pointerBuffer4;
        long j5 = CLCapabilities.clEnqueueWriteImage;
        BufferChecks.checkFunctionAddress(j5);
        BufferChecks.checkBuffer(pointerBuffer5, 3);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(floatBuffer2, CLChecks.calculateImageSize(pointerBuffer6, j3, j4));
        if (pointerBuffer7 != null) {
            BufferChecks.checkDirect(pointerBuffer7);
        }
        if (pointerBuffer8 != null) {
            BufferChecks.checkBuffer(pointerBuffer8, 1);
        }
        int nclEnqueueWriteImage = nclEnqueueWriteImage(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer5), MemoryUtil.getAddress(pointerBuffer6), j3, j4, MemoryUtil.getAddress(floatBuffer2), pointerBuffer7 == null ? 0 : pointerBuffer7.remaining(), MemoryUtil.getAddressSafe(pointerBuffer7), MemoryUtil.getAddressSafe(pointerBuffer8), j5);
        if (nclEnqueueWriteImage == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer8);
        }
        return nclEnqueueWriteImage;
    }

    public static int clEnqueueWriteImage(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, long j, long j2, IntBuffer intBuffer, PointerBuffer pointerBuffer3, PointerBuffer pointerBuffer4) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer5 = pointerBuffer;
        PointerBuffer pointerBuffer6 = pointerBuffer2;
        long j3 = j;
        long j4 = j2;
        IntBuffer intBuffer2 = intBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer3;
        PointerBuffer pointerBuffer8 = pointerBuffer4;
        long j5 = CLCapabilities.clEnqueueWriteImage;
        BufferChecks.checkFunctionAddress(j5);
        BufferChecks.checkBuffer(pointerBuffer5, 3);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(intBuffer2, CLChecks.calculateImageSize(pointerBuffer6, j3, j4));
        if (pointerBuffer7 != null) {
            BufferChecks.checkDirect(pointerBuffer7);
        }
        if (pointerBuffer8 != null) {
            BufferChecks.checkBuffer(pointerBuffer8, 1);
        }
        int nclEnqueueWriteImage = nclEnqueueWriteImage(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer5), MemoryUtil.getAddress(pointerBuffer6), j3, j4, MemoryUtil.getAddress(intBuffer2), pointerBuffer7 == null ? 0 : pointerBuffer7.remaining(), MemoryUtil.getAddressSafe(pointerBuffer7), MemoryUtil.getAddressSafe(pointerBuffer8), j5);
        if (nclEnqueueWriteImage == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer8);
        }
        return nclEnqueueWriteImage;
    }

    public static int clEnqueueWriteImage(CLCommandQueue cLCommandQueue, CLMem cLMem, int i, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2, long j, long j2, ShortBuffer shortBuffer, PointerBuffer pointerBuffer3, PointerBuffer pointerBuffer4) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        int i2 = i;
        PointerBuffer pointerBuffer5 = pointerBuffer;
        PointerBuffer pointerBuffer6 = pointerBuffer2;
        long j3 = j;
        long j4 = j2;
        ShortBuffer shortBuffer2 = shortBuffer;
        PointerBuffer pointerBuffer7 = pointerBuffer3;
        PointerBuffer pointerBuffer8 = pointerBuffer4;
        long j5 = CLCapabilities.clEnqueueWriteImage;
        BufferChecks.checkFunctionAddress(j5);
        BufferChecks.checkBuffer(pointerBuffer5, 3);
        BufferChecks.checkBuffer(pointerBuffer6, 3);
        BufferChecks.checkBuffer(shortBuffer2, CLChecks.calculateImageSize(pointerBuffer6, j3, j4));
        if (pointerBuffer7 != null) {
            BufferChecks.checkDirect(pointerBuffer7);
        }
        if (pointerBuffer8 != null) {
            BufferChecks.checkBuffer(pointerBuffer8, 1);
        }
        int nclEnqueueWriteImage = nclEnqueueWriteImage(cLCommandQueue2.getPointer(), cLMem2.getPointer(), i2, MemoryUtil.getAddress(pointerBuffer5), MemoryUtil.getAddress(pointerBuffer6), j3, j4, MemoryUtil.getAddress(shortBuffer2), pointerBuffer7 == null ? 0 : pointerBuffer7.remaining(), MemoryUtil.getAddressSafe(pointerBuffer7), MemoryUtil.getAddressSafe(pointerBuffer8), j5);
        if (nclEnqueueWriteImage == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer8);
        }
        return nclEnqueueWriteImage;
    }

    public static int clFinish(CLCommandQueue cLCommandQueue) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        long j = CLCapabilities.clFinish;
        BufferChecks.checkFunctionAddress(j);
        return nclFinish(cLCommandQueue2.getPointer(), j);
    }

    public static int clFlush(CLCommandQueue cLCommandQueue) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        long j = CLCapabilities.clFlush;
        BufferChecks.checkFunctionAddress(j);
        return nclFlush(cLCommandQueue2.getPointer(), j);
    }

    public static int clGetCommandQueueInfo(CLCommandQueue cLCommandQueue, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetCommandQueueInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetCommandQueueInfo(cLCommandQueue2.getPointer(), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    public static int clGetContextInfo(CLContext cLContext, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLContext cLContext2 = cLContext;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetContextInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        if (pointerBuffer2 == null && APIUtil.isDevicesParam(i2)) {
            pointerBuffer2 = APIUtil.getBufferPointer();
        }
        int nclGetContextInfo = nclGetContextInfo(cLContext2.getPointer(), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
        if (nclGetContextInfo == 0 && byteBuffer2 != null && APIUtil.isDevicesParam(i2)) {
            ((CLPlatform) cLContext2.getParent()).registerCLDevices(byteBuffer2, pointerBuffer2);
        }
        return nclGetContextInfo;
    }

    public static int clGetDeviceIDs(CLPlatform cLPlatform, long j, PointerBuffer pointerBuffer, IntBuffer intBuffer) {
        CLPlatform cLPlatform2 = cLPlatform;
        long j2 = j;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clGetDeviceIDs;
        BufferChecks.checkFunctionAddress(j3);
        if (pointerBuffer2 != null) {
            BufferChecks.checkDirect(pointerBuffer2);
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        } else {
            intBuffer2 = APIUtil.getBufferInt();
        }
        int nclGetDeviceIDs = nclGetDeviceIDs(cLPlatform2.getPointer(), j2, pointerBuffer2 == null ? 0 : pointerBuffer2.remaining(), MemoryUtil.getAddressSafe(pointerBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j3);
        if (nclGetDeviceIDs == 0 && pointerBuffer2 != null) {
            cLPlatform2.registerCLDevices(pointerBuffer2, intBuffer2);
        }
        return nclGetDeviceIDs;
    }

    public static int clGetDeviceInfo(CLDevice cLDevice, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLDevice cLDevice2 = cLDevice;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetDeviceInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetDeviceInfo(cLDevice2.getPointer(), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    public static int clGetEventInfo(CLEvent cLEvent, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLEvent cLEvent2 = cLEvent;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetEventInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetEventInfo(cLEvent2.getPointer(), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    public static int clGetEventProfilingInfo(CLEvent cLEvent, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLEvent cLEvent2 = cLEvent;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetEventProfilingInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetEventProfilingInfo(cLEvent2.getPointer(), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    static CLFunctionAddress clGetExtensionFunctionAddress(CharSequence charSequence) {
        CLFunctionAddress cLFunctionAddress;
        CharSequence charSequence2 = charSequence;
        long j = CLCapabilities.clGetExtensionFunctionAddress;
        BufferChecks.checkFunctionAddress(j);
        CLFunctionAddress cLFunctionAddress2 = cLFunctionAddress;
        CLFunctionAddress cLFunctionAddress3 = new CLFunctionAddress(nclGetExtensionFunctionAddress(APIUtil.getBufferNT(charSequence2), j));
        return cLFunctionAddress2;
    }

    static CLFunctionAddress clGetExtensionFunctionAddress(ByteBuffer byteBuffer) {
        CLFunctionAddress cLFunctionAddress;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = CLCapabilities.clGetExtensionFunctionAddress;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        CLFunctionAddress cLFunctionAddress2 = cLFunctionAddress;
        CLFunctionAddress cLFunctionAddress3 = new CLFunctionAddress(nclGetExtensionFunctionAddress(MemoryUtil.getAddress(byteBuffer2), j));
        return cLFunctionAddress2;
    }

    public static int clGetImageInfo(CLMem cLMem, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLMem cLMem2 = cLMem;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetImageInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetImageInfo(cLMem2.getPointer(), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    public static int clGetKernelInfo(CLKernel cLKernel, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLKernel cLKernel2 = cLKernel;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetKernelInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetKernelInfo(cLKernel2.getPointer(), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    public static int clGetKernelWorkGroupInfo(CLKernel cLKernel, CLDevice cLDevice, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLKernel cLKernel2 = cLKernel;
        CLDevice cLDevice2 = cLDevice;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetKernelWorkGroupInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetKernelWorkGroupInfo(cLKernel2.getPointer(), cLDevice2 == null ? 0 : cLDevice2.getPointer(), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    public static int clGetMemObjectInfo(CLMem cLMem, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLMem cLMem2 = cLMem;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetMemObjectInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetMemObjectInfo(cLMem2.getPointer(), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    public static int clGetPlatformIDs(PointerBuffer pointerBuffer, IntBuffer intBuffer) {
        PointerBuffer pointerBuffer2 = pointerBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clGetPlatformIDs;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer2 != null) {
            BufferChecks.checkDirect(pointerBuffer2);
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        if (intBuffer2 == null) {
            intBuffer2 = APIUtil.getBufferInt();
        }
        int nclGetPlatformIDs = nclGetPlatformIDs(pointerBuffer2 == null ? 0 : pointerBuffer2.remaining(), MemoryUtil.getAddressSafe(pointerBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j);
        if (nclGetPlatformIDs == 0 && pointerBuffer2 != null) {
            CLPlatform.registerCLPlatforms(pointerBuffer2, intBuffer2);
        }
        return nclGetPlatformIDs;
    }

    public static int clGetPlatformInfo(CLPlatform cLPlatform, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLPlatform cLPlatform2 = cLPlatform;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetPlatformInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetPlatformInfo(cLPlatform2 == null ? 0 : cLPlatform2.getPointer(), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    public static int clGetProgramBuildInfo(CLProgram cLProgram, CLDevice cLDevice, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLProgram cLProgram2 = cLProgram;
        CLDevice cLDevice2 = cLDevice;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetProgramBuildInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetProgramBuildInfo(cLProgram2.getPointer(), cLDevice2.getPointer(), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    public static int clGetProgramInfo(CLProgram cLProgram, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLProgram cLProgram2 = cLProgram;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetProgramInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetProgramInfo(cLProgram2.getPointer(), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    public static int clGetProgramInfo(CLProgram cLProgram, PointerBuffer pointerBuffer, ByteBuffer byteBuffer, PointerBuffer pointerBuffer2) {
        CLProgram cLProgram2 = cLProgram;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j = CLCapabilities.clGetProgramInfo;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(pointerBuffer3, 1);
        BufferChecks.checkBuffer(byteBuffer2, APIUtil.getSize(pointerBuffer3));
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        return nclGetProgramInfo2(cLProgram2.getPointer(), CL_PROGRAM_BINARIES, (long) pointerBuffer3.remaining(), MemoryUtil.getAddress(pointerBuffer3), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer4), j);
    }

    public static int clGetProgramInfo(CLProgram cLProgram, ByteBuffer[] byteBufferArr, PointerBuffer pointerBuffer) {
        CLProgram cLProgram2 = cLProgram;
        ByteBuffer[] byteBufferArr2 = byteBufferArr;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetProgramInfo;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkArray(byteBufferArr2);
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetProgramInfo3(cLProgram2.getPointer(), CL_PROGRAM_BINARIES, (long) byteBufferArr2.length, byteBufferArr2, MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    public static int clGetSamplerInfo(CLSampler cLSampler, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLSampler cLSampler2 = cLSampler;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetSamplerInfo;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetSamplerInfo(cLSampler2.getPointer(), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    public static int clGetSupportedImageFormats(CLContext cLContext, long j, int i, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        CLContext cLContext2 = cLContext;
        long j2 = j;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = CLCapabilities.clGetSupportedImageFormats;
        BufferChecks.checkFunctionAddress(j3);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        return nclGetSupportedImageFormats(cLContext2.getPointer(), j2, i2, (byteBuffer2 == null ? 0 : byteBuffer2.remaining()) / 8, MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j3);
    }

    public static int clReleaseCommandQueue(CLCommandQueue cLCommandQueue) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        long j = CLCapabilities.clReleaseCommandQueue;
        BufferChecks.checkFunctionAddress(j);
        APIUtil.releaseObjects(cLCommandQueue2);
        int nclReleaseCommandQueue = nclReleaseCommandQueue(cLCommandQueue2.getPointer(), j);
        if (nclReleaseCommandQueue == 0) {
            int release = cLCommandQueue2.release();
        }
        return nclReleaseCommandQueue;
    }

    public static int clReleaseContext(CLContext cLContext) {
        CLContext cLContext2 = cLContext;
        long j = CLCapabilities.clReleaseContext;
        BufferChecks.checkFunctionAddress(j);
        APIUtil.releaseObjects(cLContext2);
        int nclReleaseContext = nclReleaseContext(cLContext2.getPointer(), j);
        if (nclReleaseContext == 0) {
            cLContext2.releaseImpl();
        }
        return nclReleaseContext;
    }

    public static int clReleaseEvent(CLEvent cLEvent) {
        CLEvent cLEvent2 = cLEvent;
        long j = CLCapabilities.clReleaseEvent;
        BufferChecks.checkFunctionAddress(j);
        int nclReleaseEvent = nclReleaseEvent(cLEvent2.getPointer(), j);
        if (nclReleaseEvent == 0) {
            int release = cLEvent2.release();
        }
        return nclReleaseEvent;
    }

    public static int clReleaseKernel(CLKernel cLKernel) {
        CLKernel cLKernel2 = cLKernel;
        long j = CLCapabilities.clReleaseKernel;
        BufferChecks.checkFunctionAddress(j);
        int nclReleaseKernel = nclReleaseKernel(cLKernel2.getPointer(), j);
        if (nclReleaseKernel == 0) {
            int release = cLKernel2.release();
        }
        return nclReleaseKernel;
    }

    public static int clReleaseMemObject(CLMem cLMem) {
        CLMem cLMem2 = cLMem;
        long j = CLCapabilities.clReleaseMemObject;
        BufferChecks.checkFunctionAddress(j);
        int nclReleaseMemObject = nclReleaseMemObject(cLMem2.getPointer(), j);
        if (nclReleaseMemObject == 0) {
            int release = cLMem2.release();
        }
        return nclReleaseMemObject;
    }

    public static int clReleaseProgram(CLProgram cLProgram) {
        CLProgram cLProgram2 = cLProgram;
        long j = CLCapabilities.clReleaseProgram;
        BufferChecks.checkFunctionAddress(j);
        APIUtil.releaseObjects(cLProgram2);
        int nclReleaseProgram = nclReleaseProgram(cLProgram2.getPointer(), j);
        if (nclReleaseProgram == 0) {
            int release = cLProgram2.release();
        }
        return nclReleaseProgram;
    }

    public static int clReleaseSampler(CLSampler cLSampler) {
        CLSampler cLSampler2 = cLSampler;
        long j = CLCapabilities.clReleaseSampler;
        BufferChecks.checkFunctionAddress(j);
        int nclReleaseSampler = nclReleaseSampler(cLSampler2.getPointer(), j);
        if (nclReleaseSampler == 0) {
            int release = cLSampler2.release();
        }
        return nclReleaseSampler;
    }

    public static int clRetainCommandQueue(CLCommandQueue cLCommandQueue) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        long j = CLCapabilities.clRetainCommandQueue;
        BufferChecks.checkFunctionAddress(j);
        int nclRetainCommandQueue = nclRetainCommandQueue(cLCommandQueue2.getPointer(), j);
        if (nclRetainCommandQueue == 0) {
            int retain = cLCommandQueue2.retain();
        }
        return nclRetainCommandQueue;
    }

    public static int clRetainContext(CLContext cLContext) {
        CLContext cLContext2 = cLContext;
        long j = CLCapabilities.clRetainContext;
        BufferChecks.checkFunctionAddress(j);
        int nclRetainContext = nclRetainContext(cLContext2.getPointer(), j);
        if (nclRetainContext == 0) {
            int retain = cLContext2.retain();
        }
        return nclRetainContext;
    }

    public static int clRetainEvent(CLEvent cLEvent) {
        CLEvent cLEvent2 = cLEvent;
        long j = CLCapabilities.clRetainEvent;
        BufferChecks.checkFunctionAddress(j);
        int nclRetainEvent = nclRetainEvent(cLEvent2.getPointer(), j);
        if (nclRetainEvent == 0) {
            int retain = cLEvent2.retain();
        }
        return nclRetainEvent;
    }

    public static int clRetainKernel(CLKernel cLKernel) {
        CLKernel cLKernel2 = cLKernel;
        long j = CLCapabilities.clRetainKernel;
        BufferChecks.checkFunctionAddress(j);
        int nclRetainKernel = nclRetainKernel(cLKernel2.getPointer(), j);
        if (nclRetainKernel == 0) {
            int retain = cLKernel2.retain();
        }
        return nclRetainKernel;
    }

    public static int clRetainMemObject(CLMem cLMem) {
        CLMem cLMem2 = cLMem;
        long j = CLCapabilities.clRetainMemObject;
        BufferChecks.checkFunctionAddress(j);
        int nclRetainMemObject = nclRetainMemObject(cLMem2.getPointer(), j);
        if (nclRetainMemObject == 0) {
            int retain = cLMem2.retain();
        }
        return nclRetainMemObject;
    }

    public static int clRetainProgram(CLProgram cLProgram) {
        CLProgram cLProgram2 = cLProgram;
        long j = CLCapabilities.clRetainProgram;
        BufferChecks.checkFunctionAddress(j);
        int nclRetainProgram = nclRetainProgram(cLProgram2.getPointer(), j);
        if (nclRetainProgram == 0) {
            int retain = cLProgram2.retain();
        }
        return nclRetainProgram;
    }

    public static int clRetainSampler(CLSampler cLSampler) {
        CLSampler cLSampler2 = cLSampler;
        long j = CLCapabilities.clRetainSampler;
        BufferChecks.checkFunctionAddress(j);
        int nclRetainSampler = nclRetainSampler(cLSampler2.getPointer(), j);
        if (nclRetainSampler == 0) {
            int retain = cLSampler2.retain();
        }
        return nclRetainSampler;
    }

    public static int clSetKernelArg(CLKernel cLKernel, int i, long j) {
        CLKernel cLKernel2 = cLKernel;
        int i2 = i;
        long j2 = j;
        long j3 = CLCapabilities.clSetKernelArg;
        BufferChecks.checkFunctionAddress(j3);
        return nclSetKernelArg(cLKernel2.getPointer(), i2, j2, 0, j3);
    }

    static int clSetKernelArg(CLKernel cLKernel, int i, long j, Buffer buffer) {
        CLKernel cLKernel2 = cLKernel;
        int i2 = i;
        long j2 = j;
        Buffer buffer2 = buffer;
        long j3 = CLCapabilities.clSetKernelArg;
        BufferChecks.checkFunctionAddress(j3);
        return nclSetKernelArg(cLKernel2.getPointer(), i2, j2, MemoryUtil.getAddress0(buffer2), j3);
    }

    public static int clSetKernelArg(CLKernel cLKernel, int i, ByteBuffer byteBuffer) {
        CLKernel cLKernel2 = cLKernel;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = CLCapabilities.clSetKernelArg;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        return nclSetKernelArg(cLKernel2.getPointer(), i2, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int clSetKernelArg(CLKernel cLKernel, int i, DoubleBuffer doubleBuffer) {
        CLKernel cLKernel2 = cLKernel;
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = CLCapabilities.clSetKernelArg;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        return nclSetKernelArg(cLKernel2.getPointer(), i2, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static int clSetKernelArg(CLKernel cLKernel, int i, FloatBuffer floatBuffer) {
        CLKernel cLKernel2 = cLKernel;
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = CLCapabilities.clSetKernelArg;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        return nclSetKernelArg(cLKernel2.getPointer(), i2, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static int clSetKernelArg(CLKernel cLKernel, int i, IntBuffer intBuffer) {
        CLKernel cLKernel2 = cLKernel;
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clSetKernelArg;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        return nclSetKernelArg(cLKernel2.getPointer(), i2, (long) (intBuffer2.remaining() << 2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int clSetKernelArg(CLKernel cLKernel, int i, LongBuffer longBuffer) {
        CLKernel cLKernel2 = cLKernel;
        int i2 = i;
        LongBuffer longBuffer2 = longBuffer;
        long j = CLCapabilities.clSetKernelArg;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        return nclSetKernelArg(cLKernel2.getPointer(), i2, (long) (longBuffer2.remaining() << 3), MemoryUtil.getAddress(longBuffer2), j);
    }

    public static int clSetKernelArg(CLKernel cLKernel, int i, ShortBuffer shortBuffer) {
        CLKernel cLKernel2 = cLKernel;
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = CLCapabilities.clSetKernelArg;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        return nclSetKernelArg(cLKernel2.getPointer(), i2, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static int clSetKernelArg(CLKernel cLKernel, int i, CLObject cLObject) {
        CLKernel cLKernel2 = cLKernel;
        int i2 = i;
        CLObject cLObject2 = cLObject;
        long j = CLCapabilities.clSetKernelArg;
        BufferChecks.checkFunctionAddress(j);
        return nclSetKernelArg(cLKernel2.getPointer(), i2, (long) PointerBuffer.getPointerSize(), APIUtil.getPointerSafe(cLObject2), j);
    }

    public static int clUnloadCompiler() {
        long j = CLCapabilities.clUnloadCompiler;
        BufferChecks.checkFunctionAddress(j);
        return nclUnloadCompiler(j);
    }

    public static int clWaitForEvents(PointerBuffer pointerBuffer) {
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clWaitForEvents;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(pointerBuffer2, 1);
        return nclWaitForEvents(pointerBuffer2.remaining(), MemoryUtil.getAddress(pointerBuffer2), j);
    }

    public static int clWaitForEvents(CLEvent cLEvent) {
        CLEvent cLEvent2 = cLEvent;
        long j = CLCapabilities.clWaitForEvents;
        BufferChecks.checkFunctionAddress(j);
        return nclWaitForEvents(1, APIUtil.getPointer(cLEvent2), j);
    }

    static native int nclBuildProgram(long j, int i, long j2, long j3, long j4, long j5, long j6);

    static native long nclCreateBuffer(long j, long j2, long j3, long j4, long j5, long j6);

    static native long nclCreateCommandQueue(long j, long j2, long j3, long j4, long j5);

    static native long nclCreateContext(long j, int i, long j2, long j3, long j4, long j5, long j6);

    static native long nclCreateContextFromType(long j, long j2, long j3, long j4, long j5, long j6);

    static native long nclCreateImage2D(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9);

    static native long nclCreateImage3D(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11);

    static native long nclCreateKernel(long j, long j2, long j3, long j4);

    static native int nclCreateKernelsInProgram(long j, int i, long j2, long j3, long j4);

    static native long nclCreateProgramWithBinary(long j, int i, long j2, long j3, long j4, long j5, long j6, long j7);

    static native long nclCreateProgramWithBinary2(long j, int i, long j2, long j3, long j4, long j5, long j6, long j7);

    static native long nclCreateProgramWithBinary3(long j, int i, long j2, long j3, ByteBuffer[] byteBufferArr, long j4, long j5, long j6);

    static native long nclCreateProgramWithSource(long j, int i, long j2, long j3, long j4, long j5);

    static native long nclCreateProgramWithSource2(long j, int i, long j2, long j3, long j4, long j5);

    static native long nclCreateProgramWithSource3(long j, int i, ByteBuffer[] byteBufferArr, long j2, long j3, long j4);

    static native long nclCreateProgramWithSource4(long j, int i, long j2, long j3, long j4, long j5);

    static native long nclCreateSampler(long j, int i, int i2, int i3, long j2, long j3);

    static native int nclEnqueueBarrier(long j, long j2);

    static native int nclEnqueueCopyBuffer(long j, long j2, long j3, long j4, long j5, long j6, int i, long j7, long j8, long j9);

    static native int nclEnqueueCopyBufferToImage(long j, long j2, long j3, long j4, long j5, long j6, int i, long j7, long j8, long j9);

    static native int nclEnqueueCopyImage(long j, long j2, long j3, long j4, long j5, long j6, int i, long j7, long j8, long j9);

    static native int nclEnqueueCopyImageToBuffer(long j, long j2, long j3, long j4, long j5, long j6, int i, long j7, long j8, long j9);

    static native ByteBuffer nclEnqueueMapBuffer(long j, long j2, int i, long j3, long j4, long j5, int i2, long j6, long j7, long j8, long j9, long j10);

    static native ByteBuffer nclEnqueueMapImage(long j, long j2, int i, long j3, long j4, long j5, long j6, long j7, int i2, long j8, long j9, long j10, long j11);

    static native int nclEnqueueMarker(long j, long j2, long j3);

    static native int nclEnqueueNDRangeKernel(long j, long j2, int i, long j3, long j4, long j5, int i2, long j6, long j7, long j8);

    static native int nclEnqueueNativeKernel(long j, long j2, long j3, long j4, int i, CLMem[] cLMemArr, int i2, long j5, long j6, long j7);

    static native int nclEnqueueReadBuffer(long j, long j2, int i, long j3, long j4, long j5, int i2, long j6, long j7, long j8);

    static native int nclEnqueueReadImage(long j, long j2, int i, long j3, long j4, long j5, long j6, long j7, int i2, long j8, long j9, long j10);

    static native int nclEnqueueTask(long j, long j2, int i, long j3, long j4, long j5);

    static native int nclEnqueueUnmapMemObject(long j, long j2, long j3, int i, long j4, long j5, long j6);

    static native int nclEnqueueWaitForEvents(long j, int i, long j2, long j3);

    static native int nclEnqueueWriteBuffer(long j, long j2, int i, long j3, long j4, long j5, int i2, long j6, long j7, long j8);

    static native int nclEnqueueWriteImage(long j, long j2, int i, long j3, long j4, long j5, long j6, long j7, int i2, long j8, long j9, long j10);

    static native int nclFinish(long j, long j2);

    static native int nclFlush(long j, long j2);

    static native int nclGetCommandQueueInfo(long j, int i, long j2, long j3, long j4, long j5);

    static native int nclGetContextInfo(long j, int i, long j2, long j3, long j4, long j5);

    static native int nclGetDeviceIDs(long j, long j2, int i, long j3, long j4, long j5);

    static native int nclGetDeviceInfo(long j, int i, long j2, long j3, long j4, long j5);

    static native int nclGetEventInfo(long j, int i, long j2, long j3, long j4, long j5);

    static native int nclGetEventProfilingInfo(long j, int i, long j2, long j3, long j4, long j5);

    static native long nclGetExtensionFunctionAddress(long j, long j2);

    static native int nclGetImageInfo(long j, int i, long j2, long j3, long j4, long j5);

    static native int nclGetKernelInfo(long j, int i, long j2, long j3, long j4, long j5);

    static native int nclGetKernelWorkGroupInfo(long j, long j2, int i, long j3, long j4, long j5, long j6);

    static native int nclGetMemObjectInfo(long j, int i, long j2, long j3, long j4, long j5);

    static native int nclGetPlatformIDs(int i, long j, long j2, long j3);

    static native int nclGetPlatformInfo(long j, int i, long j2, long j3, long j4, long j5);

    static native int nclGetProgramBuildInfo(long j, long j2, int i, long j3, long j4, long j5, long j6);

    static native int nclGetProgramInfo(long j, int i, long j2, long j3, long j4, long j5);

    static native int nclGetProgramInfo2(long j, int i, long j2, long j3, long j4, long j5, long j6);

    static native int nclGetProgramInfo3(long j, int i, long j2, ByteBuffer[] byteBufferArr, long j3, long j4);

    static native int nclGetSamplerInfo(long j, int i, long j2, long j3, long j4, long j5);

    static native int nclGetSupportedImageFormats(long j, long j2, int i, int i2, long j3, long j4, long j5);

    static native int nclReleaseCommandQueue(long j, long j2);

    static native int nclReleaseContext(long j, long j2);

    static native int nclReleaseEvent(long j, long j2);

    static native int nclReleaseKernel(long j, long j2);

    static native int nclReleaseMemObject(long j, long j2);

    static native int nclReleaseProgram(long j, long j2);

    static native int nclReleaseSampler(long j, long j2);

    static native int nclRetainCommandQueue(long j, long j2);

    static native int nclRetainContext(long j, long j2);

    static native int nclRetainEvent(long j, long j2);

    static native int nclRetainKernel(long j, long j2);

    static native int nclRetainMemObject(long j, long j2);

    static native int nclRetainProgram(long j, long j2);

    static native int nclRetainSampler(long j, long j2);

    static native int nclSetKernelArg(long j, int i, long j2, long j3, long j4);

    static native int nclUnloadCompiler(long j);

    static native int nclWaitForEvents(int i, long j, long j2);
}
