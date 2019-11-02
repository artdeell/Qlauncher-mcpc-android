package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerWrapper;

public final class GL43 {
    public static final int GL_ACTIVE_RESOURCES = 37621;
    public static final int GL_ACTIVE_VARIABLES = 37637;
    public static final int GL_ANY_SAMPLES_PASSED_CONSERVATIVE = 36202;
    public static final int GL_ARRAY_SIZE = 37627;
    public static final int GL_ARRAY_STRIDE = 37630;
    public static final int GL_ATOMIC_COUNTER_BUFFER_INDEX = 37633;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_COMPUTE_SHADER = 37101;
    public static final int GL_AUTO_GENERATE_MIPMAP = 33429;
    public static final int GL_BLOCK_INDEX = 37629;
    public static final int GL_BUFFER = 33504;
    public static final int GL_BUFFER_BINDING = 37634;
    public static final int GL_BUFFER_DATA_SIZE = 37635;
    public static final int GL_BUFFER_VARIABLE = 37605;
    public static final int GL_CAVEAT_SUPPORT = 33464;
    public static final int GL_CLEAR_BUFFER = 33460;
    public static final int GL_COLOR_COMPONENTS = 33411;
    public static final int GL_COLOR_ENCODING = 33430;
    public static final int GL_COLOR_RENDERABLE = 33414;
    public static final int GL_COMPRESSED_R11_EAC = 37488;
    public static final int GL_COMPRESSED_RG11_EAC = 37490;
    public static final int GL_COMPRESSED_RGB8_ETC2 = 37492;
    public static final int GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 37494;
    public static final int GL_COMPRESSED_RGBA8_ETC2_EAC = 37496;
    public static final int GL_COMPRESSED_SIGNED_R11_EAC = 37489;
    public static final int GL_COMPRESSED_SIGNED_RG11_EAC = 37491;
    public static final int GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC = 37497;
    public static final int GL_COMPRESSED_SRGB8_ETC2 = 37493;
    public static final int GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 37495;
    public static final int GL_COMPUTE_SHADER = 37305;
    public static final int GL_COMPUTE_SHADER_BIT = 32;
    public static final int GL_COMPUTE_SUBROUTINE = 37613;
    public static final int GL_COMPUTE_SUBROUTINE_UNIFORM = 37619;
    public static final int GL_COMPUTE_TEXTURE = 33440;
    public static final int GL_COMPUTE_WORK_GROUP_SIZE = 33383;
    public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 2;
    public static final int GL_DEBUG_CALLBACK_FUNCTION = 33348;
    public static final int GL_DEBUG_CALLBACK_USER_PARAM = 33349;
    public static final int GL_DEBUG_GROUP_STACK_DEPTH = 33389;
    public static final int GL_DEBUG_LOGGED_MESSAGES = 37189;
    public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 33347;
    public static final int GL_DEBUG_OUTPUT = 37600;
    public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 33346;
    public static final int GL_DEBUG_SEVERITY_HIGH = 37190;
    public static final int GL_DEBUG_SEVERITY_LOW = 37192;
    public static final int GL_DEBUG_SEVERITY_MEDIUM = 37191;
    public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 33387;
    public static final int GL_DEBUG_SOURCE_API = 33350;
    public static final int GL_DEBUG_SOURCE_APPLICATION = 33354;
    public static final int GL_DEBUG_SOURCE_OTHER = 33355;
    public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 33352;
    public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 33353;
    public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 33351;
    public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 33357;
    public static final int GL_DEBUG_TYPE_ERROR = 33356;
    public static final int GL_DEBUG_TYPE_MARKER = 33384;
    public static final int GL_DEBUG_TYPE_OTHER = 33361;
    public static final int GL_DEBUG_TYPE_PERFORMANCE = 33360;
    public static final int GL_DEBUG_TYPE_POP_GROUP = 33386;
    public static final int GL_DEBUG_TYPE_PORTABILITY = 33359;
    public static final int GL_DEBUG_TYPE_PUSH_GROUP = 33385;
    public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 33358;
    public static final int GL_DEPTH_COMPONENTS = 33412;
    public static final int GL_DEPTH_RENDERABLE = 33415;
    public static final int GL_DEPTH_STENCIL_TEXTURE_MODE = 37098;
    public static final int GL_DISPATCH_INDIRECT_BUFFER = 37102;
    public static final int GL_DISPATCH_INDIRECT_BUFFER_BINDING = 37103;
    public static final int GL_DISPLAY_LIST = 33511;
    public static final int GL_FILTER = 33434;
    public static final int GL_FRAGMENT_SUBROUTINE = 37612;
    public static final int GL_FRAGMENT_SUBROUTINE_UNIFORM = 37618;
    public static final int GL_FRAGMENT_TEXTURE = 33439;
    public static final int GL_FRAMEBUFFER_BLEND = 33419;
    public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 37652;
    public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 37649;
    public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650;
    public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 37651;
    public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 37648;
    public static final int GL_FRAMEBUFFER_RENDERABLE = 33417;
    public static final int GL_FRAMEBUFFER_RENDERABLE_LAYERED = 33418;
    public static final int GL_FULL_SUPPORT = 33463;
    public static final int GL_GEOMETRY_SUBROUTINE = 37611;
    public static final int GL_GEOMETRY_SUBROUTINE_UNIFORM = 37617;
    public static final int GL_GEOMETRY_TEXTURE = 33438;
    public static final int GL_GET_TEXTURE_IMAGE_FORMAT = 33425;
    public static final int GL_GET_TEXTURE_IMAGE_TYPE = 33426;
    public static final int GL_IMAGE_CLASS_10_10_10_2 = 33475;
    public static final int GL_IMAGE_CLASS_11_11_10 = 33474;
    public static final int GL_IMAGE_CLASS_1_X_16 = 33470;
    public static final int GL_IMAGE_CLASS_1_X_32 = 33467;
    public static final int GL_IMAGE_CLASS_1_X_8 = 33473;
    public static final int GL_IMAGE_CLASS_2_X_16 = 33469;
    public static final int GL_IMAGE_CLASS_2_X_32 = 33466;
    public static final int GL_IMAGE_CLASS_2_X_8 = 33472;
    public static final int GL_IMAGE_CLASS_4_X_16 = 33468;
    public static final int GL_IMAGE_CLASS_4_X_32 = 33465;
    public static final int GL_IMAGE_CLASS_4_X_8 = 33471;
    public static final int GL_IMAGE_COMPATIBILITY_CLASS = 33448;
    public static final int GL_IMAGE_FORMAT_COMPATIBILITY_TYPE = 37063;
    public static final int GL_IMAGE_PIXEL_FORMAT = 33449;
    public static final int GL_IMAGE_PIXEL_TYPE = 33450;
    public static final int GL_IMAGE_TEXEL_SIZE = 33447;
    public static final int GL_INTERNALFORMAT_ALPHA_SIZE = 33396;
    public static final int GL_INTERNALFORMAT_ALPHA_TYPE = 33403;
    public static final int GL_INTERNALFORMAT_BLUE_SIZE = 33395;
    public static final int GL_INTERNALFORMAT_BLUE_TYPE = 33402;
    public static final int GL_INTERNALFORMAT_DEPTH_SIZE = 33397;
    public static final int GL_INTERNALFORMAT_DEPTH_TYPE = 33404;
    public static final int GL_INTERNALFORMAT_GREEN_SIZE = 33394;
    public static final int GL_INTERNALFORMAT_GREEN_TYPE = 33401;
    public static final int GL_INTERNALFORMAT_PREFERRED = 33392;
    public static final int GL_INTERNALFORMAT_RED_SIZE = 33393;
    public static final int GL_INTERNALFORMAT_RED_TYPE = 33400;
    public static final int GL_INTERNALFORMAT_SHARED_SIZE = 33399;
    public static final int GL_INTERNALFORMAT_STENCIL_SIZE = 33398;
    public static final int GL_INTERNALFORMAT_STENCIL_TYPE = 33405;
    public static final int GL_INTERNALFORMAT_SUPPORTED = 33391;
    public static final int GL_IS_PER_PATCH = 37607;
    public static final int GL_IS_ROW_MAJOR = 37632;
    public static final int GL_LOCATION = 37646;
    public static final int GL_LOCATION_INDEX = 37647;
    public static final int GL_MANUAL_GENERATE_MIPMAP = 33428;
    public static final int GL_MATRIX_STRIDE = 37631;
    public static final int GL_MAX_COMBINED_COMPUTE_UNIFORM_COMPONENTS = 33382;
    public static final int GL_MAX_COMBINED_DIMENSIONS = 33410;
    public static final int GL_MAX_COMBINED_SHADER_OUTPUT_RESOURCES = 36665;
    public static final int GL_MAX_COMBINED_SHADER_STORAGE_BLOCKS = 37084;
    public static final int GL_MAX_COMPUTE_ATOMIC_COUNTERS = 33381;
    public static final int GL_MAX_COMPUTE_ATOMIC_COUNTER_BUFFERS = 33380;
    public static final int GL_MAX_COMPUTE_IMAGE_UNIFORMS = 37309;
    public static final int GL_MAX_COMPUTE_SHADER_STORAGE_BLOCKS = 37083;
    public static final int GL_MAX_COMPUTE_SHARED_MEMORY_SIZE = 33378;
    public static final int GL_MAX_COMPUTE_TEXTURE_IMAGE_UNITS = 37308;
    public static final int GL_MAX_COMPUTE_UNIFORM_BLOCKS = 37307;
    public static final int GL_MAX_COMPUTE_UNIFORM_COMPONENTS = 33379;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_COUNT = 37310;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_INVOCATIONS = 37099;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_SIZE = 37311;
    public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 33388;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 37188;
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 37187;
    public static final int GL_MAX_DEPTH = 33408;
    public static final int GL_MAX_ELEMENT_INDEX = 36203;
    public static final int GL_MAX_FRAGMENT_SHADER_STORAGE_BLOCKS = 37082;
    public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 37654;
    public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655;
    public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 37656;
    public static final int GL_MAX_FRAMEBUFFER_WIDTH = 37653;
    public static final int GL_MAX_GEOMETRY_SHADER_STORAGE_BLOCKS = 37079;
    public static final int GL_MAX_HEIGHT = 33407;
    public static final int GL_MAX_LABEL_LENGTH = 33512;
    public static final int GL_MAX_LAYERS = 33409;
    public static final int GL_MAX_NAME_LENGTH = 37622;
    public static final int GL_MAX_NUM_ACTIVE_VARIABLES = 37623;
    public static final int GL_MAX_NUM_COMPATIBLE_SUBROUTINES = 37624;
    public static final int GL_MAX_SHADER_STORAGE_BLOCK_SIZE = 37086;
    public static final int GL_MAX_SHADER_STORAGE_BUFFER_BINDINGS = 37085;
    public static final int GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS = 37080;
    public static final int GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS = 37081;
    public static final int GL_MAX_UNIFORM_LOCATIONS = 33390;
    public static final int GL_MAX_VERTEX_ATTRIB_BINDINGS = 33498;
    public static final int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = 33497;
    public static final int GL_MAX_VERTEX_SHADER_STORAGE_BLOCKS = 37078;
    public static final int GL_MAX_WIDTH = 33406;
    public static final int GL_MIPMAP = 33427;
    public static final int GL_NAME_LENGTH = 37625;
    public static final int GL_NUM_ACTIVE_VARIABLES = 37636;
    public static final int GL_NUM_SAMPLE_COUNTS = 37760;
    public static final int GL_NUM_SHADING_LANGUAGE_VERSIONS = 33513;
    public static final int GL_OFFSET = 37628;
    public static final int GL_PRIMITIVE_RESTART_FIXED_INDEX = 36201;
    public static final int GL_PROGRAM = 33506;
    public static final int GL_PROGRAM_INPUT = 37603;
    public static final int GL_PROGRAM_OUTPUT = 37604;
    public static final int GL_PROGRAM_PIPELINE = 33508;
    public static final int GL_QUERY = 33507;
    public static final int GL_READ_PIXELS = 33420;
    public static final int GL_READ_PIXELS_FORMAT = 33421;
    public static final int GL_READ_PIXELS_TYPE = 33422;
    public static final int GL_REFERENCED_BY_COMPUTE_SHADER = 37643;
    public static final int GL_REFERENCED_BY_FRAGMENT_SHADER = 37642;
    public static final int GL_REFERENCED_BY_GEOMETRY_SHADER = 37641;
    public static final int GL_REFERENCED_BY_TESS_CONTROL_SHADER = 37639;
    public static final int GL_REFERENCED_BY_TESS_EVALUATION_SHADER = 37640;
    public static final int GL_REFERENCED_BY_VERTEX_SHADER = 37638;
    public static final int GL_RENDERBUFFER = 36161;
    public static final int GL_SAMPLER = 33510;
    public static final int GL_SAMPLES = 32937;
    public static final int GL_SHADER = 33505;
    public static final int GL_SHADER_IMAGE_ATOMIC = 33446;
    public static final int GL_SHADER_IMAGE_LOAD = 33444;
    public static final int GL_SHADER_IMAGE_STORE = 33445;
    public static final int GL_SHADER_STORAGE_BARRIER_BIT = 8192;
    public static final int GL_SHADER_STORAGE_BLOCK = 37606;
    public static final int GL_SHADER_STORAGE_BUFFER = 37074;
    public static final int GL_SHADER_STORAGE_BUFFER_BINDING = 37075;
    public static final int GL_SHADER_STORAGE_BUFFER_OFFSET_ALIGNMENT = 37087;
    public static final int GL_SHADER_STORAGE_BUFFER_SIZE = 37077;
    public static final int GL_SHADER_STORAGE_BUFFER_START = 37076;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_TEST = 33452;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_WRITE = 33454;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_TEST = 33453;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_WRITE = 33455;
    public static final int GL_SRGB_DECODE_ARB = 33433;
    public static final int GL_SRGB_READ = 33431;
    public static final int GL_SRGB_WRITE = 33432;
    public static final int GL_STACK_OVERFLOW = 1283;
    public static final int GL_STACK_UNDERFLOW = 1284;
    public static final int GL_STENCIL_COMPONENTS = 33413;
    public static final int GL_STENCIL_RENDERABLE = 33416;
    public static final int GL_TESS_CONTROL_SUBROUTINE = 37609;
    public static final int GL_TESS_CONTROL_SUBROUTINE_UNIFORM = 37615;
    public static final int GL_TESS_CONTROL_TEXTURE = 33436;
    public static final int GL_TESS_EVALUATION_SUBROUTINE = 37610;
    public static final int GL_TESS_EVALUATION_SUBROUTINE_UNIFORM = 37616;
    public static final int GL_TESS_EVALUATION_TEXTURE = 33437;
    public static final int GL_TEXTURE_1D = 3552;
    public static final int GL_TEXTURE_1D_ARRAY = 35864;
    public static final int GL_TEXTURE_2D = 3553;
    public static final int GL_TEXTURE_2D_ARRAY = 35866;
    public static final int GL_TEXTURE_2D_MULTISAMPLE = 37120;
    public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 37122;
    public static final int GL_TEXTURE_3D = 32879;
    public static final int GL_TEXTURE_BUFFER = 35882;
    public static final int GL_TEXTURE_BUFFER_OFFSET = 37277;
    public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 37279;
    public static final int GL_TEXTURE_BUFFER_SIZE = 37278;
    public static final int GL_TEXTURE_COMPRESSED = 34465;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_HEIGHT = 33458;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_SIZE = 33459;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_WIDTH = 33457;
    public static final int GL_TEXTURE_CUBE_MAP = 34067;
    public static final int GL_TEXTURE_CUBE_MAP_ARRAY = 36873;
    public static final int GL_TEXTURE_GATHER = 33442;
    public static final int GL_TEXTURE_GATHER_SHADOW = 33443;
    public static final int GL_TEXTURE_IMAGE_FORMAT = 33423;
    public static final int GL_TEXTURE_IMAGE_TYPE = 33424;
    public static final int GL_TEXTURE_IMMUTABLE_LEVELS = 33503;
    public static final int GL_TEXTURE_RECTANGLE = 34037;
    public static final int GL_TEXTURE_SHADOW = 33441;
    public static final int GL_TEXTURE_VIEW = 33461;
    public static final int GL_TEXTURE_VIEW_MIN_LAYER = 33501;
    public static final int GL_TEXTURE_VIEW_MIN_LEVEL = 33499;
    public static final int GL_TEXTURE_VIEW_NUM_LAYERS = 33502;
    public static final int GL_TEXTURE_VIEW_NUM_LEVELS = 33500;
    public static final int GL_TOP_LEVEL_ARRAY_SIZE = 37644;
    public static final int GL_TOP_LEVEL_ARRAY_STRIDE = 37645;
    public static final int GL_TRANSFORM_FEEDBACK_VARYING = 37620;
    public static final int GL_TYPE = 37626;
    public static final int GL_UNIFORM = 37601;
    public static final int GL_UNIFORM_BLOCK = 37602;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_COMPUTE_SHADER = 37100;
    public static final int GL_VERTEX_ATTRIB_ARRAY_LONG = 34638;
    public static final int GL_VERTEX_ATTRIB_BINDING = 33492;
    public static final int GL_VERTEX_ATTRIB_RELATIVE_OFFSET = 33493;
    public static final int GL_VERTEX_BINDING_DIVISOR = 33494;
    public static final int GL_VERTEX_BINDING_OFFSET = 33495;
    public static final int GL_VERTEX_BINDING_STRIDE = 33496;
    public static final int GL_VERTEX_SUBROUTINE = 37608;
    public static final int GL_VERTEX_SUBROUTINE_UNIFORM = 37614;
    public static final int GL_VERTEX_TEXTURE = 33435;
    public static final int GL_VIEW_CLASS_128_BITS = 33476;
    public static final int GL_VIEW_CLASS_16_BITS = 33482;
    public static final int GL_VIEW_CLASS_24_BITS = 33481;
    public static final int GL_VIEW_CLASS_32_BITS = 33480;
    public static final int GL_VIEW_CLASS_48_BITS = 33479;
    public static final int GL_VIEW_CLASS_64_BITS = 33478;
    public static final int GL_VIEW_CLASS_8_BITS = 33483;
    public static final int GL_VIEW_CLASS_96_BITS = 33477;
    public static final int GL_VIEW_CLASS_BPTC_FLOAT = 33491;
    public static final int GL_VIEW_CLASS_BPTC_UNORM = 33490;
    public static final int GL_VIEW_CLASS_RGTC1_RED = 33488;
    public static final int GL_VIEW_CLASS_RGTC2_RG = 33489;
    public static final int GL_VIEW_CLASS_S3TC_DXT1_RGB = 33484;
    public static final int GL_VIEW_CLASS_S3TC_DXT1_RGBA = 33485;
    public static final int GL_VIEW_CLASS_S3TC_DXT3_RGBA = 33486;
    public static final int GL_VIEW_CLASS_S3TC_DXT5_RGBA = 33487;
    public static final int GL_VIEW_COMPATIBILITY_CLASS = 33462;

    private GL43() {
    }

    public static void glBindVertexBuffer(int i, int i2, long j, int i3) {
        int i4 = i;
        int i5 = i2;
        long j2 = j;
        int i6 = i3;
        long j3 = GLContext.getCapabilities().glBindVertexBuffer;
        BufferChecks.checkFunctionAddress(j3);
        nglBindVertexBuffer(i4, i5, j2, i6, j3);
    }

    public static void glClearBufferData(int i, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glClearBufferData;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 1);
        nglClearBufferData(i5, i6, i7, i8, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glClearBufferSubData(int i, int i2, long j, int i3, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        long j2 = j;
        int i7 = i3;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = GLContext.getCapabilities().glClearBufferSubData;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(byteBuffer2);
        nglClearBufferSubData(i5, i6, j2, (long) byteBuffer2.remaining(), i7, i8, MemoryUtil.getAddress(byteBuffer2), j3);
    }

    public static void glCopyImageSubData(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        int i16 = i;
        int i17 = i2;
        int i18 = i3;
        int i19 = i4;
        int i20 = i5;
        int i21 = i6;
        int i22 = i7;
        int i23 = i8;
        int i24 = i9;
        int i25 = i10;
        int i26 = i11;
        int i27 = i12;
        int i28 = i13;
        int i29 = i14;
        int i30 = i15;
        long j = GLContext.getCapabilities().glCopyImageSubData;
        BufferChecks.checkFunctionAddress(j);
        nglCopyImageSubData(i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, j);
    }

    public static void glDebugMessageCallback(KHRDebugCallback kHRDebugCallback) {
        KHRDebugCallback kHRDebugCallback2 = kHRDebugCallback;
        long j = 0;
        long j2 = GLContext.getCapabilities().glDebugMessageCallback;
        BufferChecks.checkFunctionAddress(j2);
        long createGlobalRef = kHRDebugCallback2 == null ? 0 : CallbackUtil.createGlobalRef(kHRDebugCallback2.getHandler());
        CallbackUtil.registerContextCallbackKHR(createGlobalRef);
        if (kHRDebugCallback2 != null) {
            j = kHRDebugCallback2.getPointer();
        }
        nglDebugMessageCallback(j, createGlobalRef, j2);
    }

    public static void glDebugMessageControl(int i, int i2, int i3, IntBuffer intBuffer, boolean z) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glDebugMessageControl;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkDirect(intBuffer2);
        }
        nglDebugMessageControl(i4, i5, i6, intBuffer2 == null ? 0 : intBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), z2, j);
    }

    public static void glDebugMessageInsert(int i, int i2, int i3, int i4, CharSequence charSequence) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDebugMessageInsert;
        BufferChecks.checkFunctionAddress(j);
        nglDebugMessageInsert(i5, i6, i7, i8, charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), j);
    }

    public static void glDebugMessageInsert(int i, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glDebugMessageInsert;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglDebugMessageInsert(i5, i6, i7, i8, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glDispatchCompute(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glDispatchCompute;
        BufferChecks.checkFunctionAddress(j);
        nglDispatchCompute(i4, i5, i6, j);
    }

    public static void glDispatchComputeIndirect(long j) {
        long j2 = j;
        long j3 = GLContext.getCapabilities().glDispatchComputeIndirect;
        BufferChecks.checkFunctionAddress(j3);
        nglDispatchComputeIndirect(j2, j3);
    }

    public static void glFramebufferParameteri(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glFramebufferParameteri;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferParameteri(i4, i5, i6, j);
    }

    public static int glGetDebugMessageLog(int i, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, IntBuffer intBuffer4, IntBuffer intBuffer5, ByteBuffer byteBuffer) {
        int i2 = i;
        IntBuffer intBuffer6 = intBuffer;
        IntBuffer intBuffer7 = intBuffer2;
        IntBuffer intBuffer8 = intBuffer3;
        IntBuffer intBuffer9 = intBuffer4;
        IntBuffer intBuffer10 = intBuffer5;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetDebugMessageLog;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer6 != null) {
            BufferChecks.checkBuffer(intBuffer6, i2);
        }
        if (intBuffer7 != null) {
            BufferChecks.checkBuffer(intBuffer7, i2);
        }
        if (intBuffer8 != null) {
            BufferChecks.checkBuffer(intBuffer8, i2);
        }
        if (intBuffer9 != null) {
            BufferChecks.checkBuffer(intBuffer9, i2);
        }
        if (intBuffer10 != null) {
            BufferChecks.checkBuffer(intBuffer10, i2);
        }
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        return nglGetDebugMessageLog(i2, byteBuffer2 == null ? 0 : byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer6), MemoryUtil.getAddressSafe(intBuffer7), MemoryUtil.getAddressSafe(intBuffer8), MemoryUtil.getAddressSafe(intBuffer9), MemoryUtil.getAddressSafe(intBuffer10), MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glGetFramebufferParameter(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetFramebufferParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetFramebufferParameteriv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetFramebufferParameteri(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetFramebufferParameteriv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetFramebufferParameteriv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetInternalformat(int i, int i2, int i3, LongBuffer longBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetInternalformati64v;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglGetInternalformati64v(i4, i5, i6, longBuffer2.remaining(), MemoryUtil.getAddress(longBuffer2), j);
    }

    public static long glGetInternalformati64(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetInternalformati64v;
        BufferChecks.checkFunctionAddress(j);
        LongBuffer bufferLong = APIUtil.getBufferLong(capabilities);
        nglGetInternalformati64v(i4, i5, i6, 1, MemoryUtil.getAddress(bufferLong), j);
        return bufferLong.get(0);
    }

    public static String glGetObjectLabel(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetObjectLabel;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetObjectLabel(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetObjectLabel(int i, int i2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetObjectLabel;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        BufferChecks.checkDirect(byteBuffer2);
        nglGetObjectLabel(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static String glGetObjectPtrLabel(PointerWrapper pointerWrapper, int i) {
        PointerWrapper pointerWrapper2 = pointerWrapper;
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetObjectPtrLabel;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i2);
        nglGetObjectPtrLabel(pointerWrapper2.getPointer(), i2, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetObjectPtrLabel(PointerWrapper pointerWrapper, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        PointerWrapper pointerWrapper2 = pointerWrapper;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetObjectPtrLabel;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        BufferChecks.checkDirect(byteBuffer2);
        nglGetObjectPtrLabel(pointerWrapper2.getPointer(), byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetProgramInterface(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetProgramInterfaceiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetProgramInterfaceiv(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetProgramInterfacei(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetProgramInterfaceiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetProgramInterfaceiv(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetProgramResource(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer4 = intBuffer;
        IntBuffer intBuffer5 = intBuffer2;
        IntBuffer intBuffer6 = intBuffer3;
        long j = GLContext.getCapabilities().glGetProgramResourceiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer4);
        if (intBuffer5 != null) {
            BufferChecks.checkBuffer(intBuffer5, 1);
        }
        BufferChecks.checkDirect(intBuffer6);
        nglGetProgramResourceiv(i4, i5, i6, intBuffer4.remaining(), MemoryUtil.getAddress(intBuffer4), intBuffer6.remaining(), MemoryUtil.getAddressSafe(intBuffer5), MemoryUtil.getAddress(intBuffer6), j);
    }

    public static int glGetProgramResourceIndex(int i, int i2, CharSequence charSequence) {
        int i3 = i;
        int i4 = i2;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetProgramResourceIndex;
        BufferChecks.checkFunctionAddress(j);
        return nglGetProgramResourceIndex(i3, i4, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glGetProgramResourceIndex(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetProgramResourceIndex;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglGetProgramResourceIndex(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetProgramResourceLocation(int i, int i2, CharSequence charSequence) {
        int i3 = i;
        int i4 = i2;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetProgramResourceLocation;
        BufferChecks.checkFunctionAddress(j);
        return nglGetProgramResourceLocation(i3, i4, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glGetProgramResourceLocation(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetProgramResourceLocation;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglGetProgramResourceLocation(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetProgramResourceLocationIndex(int i, int i2, CharSequence charSequence) {
        int i3 = i;
        int i4 = i2;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetProgramResourceLocationIndex;
        BufferChecks.checkFunctionAddress(j);
        return nglGetProgramResourceLocationIndex(i3, i4, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glGetProgramResourceLocationIndex(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetProgramResourceLocationIndex;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglGetProgramResourceLocationIndex(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static String glGetProgramResourceName(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetProgramResourceName;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i8);
        nglGetProgramResourceName(i5, i6, i7, i8, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetProgramResourceName(int i, int i2, int i3, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetProgramResourceName;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        nglGetProgramResourceName(i4, i5, i6, byteBuffer2 == null ? 0 : byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glInvalidateBufferData(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glInvalidateBufferData;
        BufferChecks.checkFunctionAddress(j);
        nglInvalidateBufferData(i2, j);
    }

    public static void glInvalidateBufferSubData(int i, long j, long j2) {
        int i2 = i;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glInvalidateBufferSubData;
        BufferChecks.checkFunctionAddress(j5);
        nglInvalidateBufferSubData(i2, j3, j4, j5);
    }

    public static void glInvalidateFramebuffer(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glInvalidateFramebuffer;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglInvalidateFramebuffer(i2, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glInvalidateSubFramebuffer(int i, IntBuffer intBuffer, int i2, int i3, int i4, int i5) {
        int i6 = i;
        IntBuffer intBuffer2 = intBuffer;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glInvalidateSubFramebuffer;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglInvalidateSubFramebuffer(i6, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), i7, i8, i9, i10, j);
    }

    public static void glInvalidateTexImage(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glInvalidateTexImage;
        BufferChecks.checkFunctionAddress(j);
        nglInvalidateTexImage(i3, i4, j);
    }

    public static void glInvalidateTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        long j = GLContext.getCapabilities().glInvalidateTexSubImage;
        BufferChecks.checkFunctionAddress(j);
        nglInvalidateTexSubImage(i9, i10, i11, i12, i13, i14, i15, i16, j);
    }

    public static void glMultiDrawArraysIndirect(int i, long j, int i2, int i3) {
        int i4 = i;
        long j2 = j;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiDrawArraysIndirect;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureIndirectBOenabled(capabilities);
        nglMultiDrawArraysIndirectBO(i4, j2, i5, i6, j3);
    }

    public static void glMultiDrawArraysIndirect(int i, ByteBuffer byteBuffer, int i2, int i3) {
        int i4 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiDrawArraysIndirect;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, (i6 == 0 ? 16 : i6) * i5);
        nglMultiDrawArraysIndirect(i4, MemoryUtil.getAddress(byteBuffer2), i5, i6, j);
    }

    public static void glMultiDrawArraysIndirect(int i, IntBuffer intBuffer, int i2, int i3) {
        int i4 = i;
        IntBuffer intBuffer2 = intBuffer;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiDrawArraysIndirect;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, (i6 == 0 ? 4 : i6 >> 2) * i5);
        nglMultiDrawArraysIndirect(i4, MemoryUtil.getAddress(intBuffer2), i5, i6, j);
    }

    public static void glMultiDrawElementsIndirect(int i, int i2, long j, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        long j2 = j;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiDrawElementsIndirect;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureIndirectBOenabled(capabilities);
        nglMultiDrawElementsIndirectBO(i5, i6, j2, i7, i8, j3);
    }

    public static void glMultiDrawElementsIndirect(int i, int i2, ByteBuffer byteBuffer, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiDrawElementsIndirect;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, (i8 == 0 ? 20 : i8) * i7);
        nglMultiDrawElementsIndirect(i5, i6, MemoryUtil.getAddress(byteBuffer2), i7, i8, j);
    }

    public static void glMultiDrawElementsIndirect(int i, int i2, IntBuffer intBuffer, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        IntBuffer intBuffer2 = intBuffer;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiDrawElementsIndirect;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, (i8 == 0 ? 5 : i8 >> 2) * i7);
        nglMultiDrawElementsIndirect(i5, i6, MemoryUtil.getAddress(intBuffer2), i7, i8, j);
    }

    public static void glObjectLabel(int i, int i2, CharSequence charSequence) {
        int i3 = i;
        int i4 = i2;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glObjectLabel;
        BufferChecks.checkFunctionAddress(j);
        nglObjectLabel(i3, i4, charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), j);
    }

    public static void glObjectLabel(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glObjectLabel;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        nglObjectLabel(i3, i4, byteBuffer2 == null ? 0 : byteBuffer2.remaining(), MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glObjectPtrLabel(PointerWrapper pointerWrapper, CharSequence charSequence) {
        PointerWrapper pointerWrapper2 = pointerWrapper;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glObjectPtrLabel;
        BufferChecks.checkFunctionAddress(j);
        nglObjectPtrLabel(pointerWrapper2.getPointer(), charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), j);
    }

    public static void glObjectPtrLabel(PointerWrapper pointerWrapper, ByteBuffer byteBuffer) {
        PointerWrapper pointerWrapper2 = pointerWrapper;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glObjectPtrLabel;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        nglObjectPtrLabel(pointerWrapper2.getPointer(), byteBuffer2 == null ? 0 : byteBuffer2.remaining(), MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glPopDebugGroup() {
        long j = GLContext.getCapabilities().glPopDebugGroup;
        BufferChecks.checkFunctionAddress(j);
        nglPopDebugGroup(j);
    }

    public static void glPushDebugGroup(int i, int i2, CharSequence charSequence) {
        int i3 = i;
        int i4 = i2;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glPushDebugGroup;
        BufferChecks.checkFunctionAddress(j);
        nglPushDebugGroup(i3, i4, charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), j);
    }

    public static void glPushDebugGroup(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glPushDebugGroup;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglPushDebugGroup(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glShaderStorageBlockBinding(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glShaderStorageBlockBinding;
        BufferChecks.checkFunctionAddress(j);
        nglShaderStorageBlockBinding(i4, i5, i6, j);
    }

    public static void glTexBufferRange(int i, int i2, int i3, long j, long j2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glTexBufferRange;
        BufferChecks.checkFunctionAddress(j5);
        nglTexBufferRange(i4, i5, i6, j3, j4, j5);
    }

    public static void glTexStorage2DMultisample(int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glTexStorage2DMultisample;
        BufferChecks.checkFunctionAddress(j);
        nglTexStorage2DMultisample(i6, i7, i8, i9, i10, z2, j);
    }

    public static void glTexStorage3DMultisample(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glTexStorage3DMultisample;
        BufferChecks.checkFunctionAddress(j);
        nglTexStorage3DMultisample(i7, i8, i9, i10, i11, i12, z2, j);
    }

    public static void glTextureView(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        long j = GLContext.getCapabilities().glTextureView;
        BufferChecks.checkFunctionAddress(j);
        nglTextureView(i9, i10, i11, i12, i13, i14, i15, i16, j);
    }

    public static void glVertexAttribBinding(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glVertexAttribBinding;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribBinding(i3, i4, j);
    }

    public static void glVertexAttribFormat(int i, int i2, int i3, boolean z, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        boolean z2 = z;
        int i8 = i4;
        long j = GLContext.getCapabilities().glVertexAttribFormat;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribFormat(i5, i6, i7, z2, i8, j);
    }

    public static void glVertexAttribIFormat(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glVertexAttribIFormat;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribIFormat(i5, i6, i7, i8, j);
    }

    public static void glVertexAttribLFormat(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glVertexAttribLFormat;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribLFormat(i5, i6, i7, i8, j);
    }

    public static void glVertexBindingDivisor(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glVertexBindingDivisor;
        BufferChecks.checkFunctionAddress(j);
        nglVertexBindingDivisor(i3, i4, j);
    }

    static native void nglBindVertexBuffer(int i, int i2, long j, int i3, long j2);

    static native void nglClearBufferData(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglClearBufferSubData(int i, int i2, long j, long j2, int i3, int i4, long j3, long j4);

    static native void nglCopyImageSubData(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, long j);

    static native void nglDebugMessageCallback(long j, long j2, long j3);

    static native void nglDebugMessageControl(int i, int i2, int i3, int i4, long j, boolean z, long j2);

    static native void nglDebugMessageInsert(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglDispatchCompute(int i, int i2, int i3, long j);

    static native void nglDispatchComputeIndirect(long j, long j2);

    static native void nglFramebufferParameteri(int i, int i2, int i3, long j);

    static native int nglGetDebugMessageLog(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7);

    static native void nglGetFramebufferParameteriv(int i, int i2, long j, long j2);

    static native void nglGetInternalformati64v(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglGetObjectLabel(int i, int i2, int i3, long j, long j2, long j3);

    static native void nglGetObjectPtrLabel(long j, int i, long j2, long j3, long j4);

    static native void nglGetProgramInterfaceiv(int i, int i2, int i3, long j, long j2);

    static native int nglGetProgramResourceIndex(int i, int i2, long j, long j2);

    static native int nglGetProgramResourceLocation(int i, int i2, long j, long j2);

    static native int nglGetProgramResourceLocationIndex(int i, int i2, long j, long j2);

    static native void nglGetProgramResourceName(int i, int i2, int i3, int i4, long j, long j2, long j3);

    static native void nglGetProgramResourceiv(int i, int i2, int i3, int i4, long j, int i5, long j2, long j3, long j4);

    static native void nglInvalidateBufferData(int i, long j);

    static native void nglInvalidateBufferSubData(int i, long j, long j2, long j3);

    static native void nglInvalidateFramebuffer(int i, int i2, long j, long j2);

    static native void nglInvalidateSubFramebuffer(int i, int i2, long j, int i3, int i4, int i5, int i6, long j2);

    static native void nglInvalidateTexImage(int i, int i2, long j);

    static native void nglInvalidateTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j);

    static native void nglMultiDrawArraysIndirect(int i, long j, int i2, int i3, long j2);

    static native void nglMultiDrawArraysIndirectBO(int i, long j, int i2, int i3, long j2);

    static native void nglMultiDrawElementsIndirect(int i, int i2, long j, int i3, int i4, long j2);

    static native void nglMultiDrawElementsIndirectBO(int i, int i2, long j, int i3, int i4, long j2);

    static native void nglObjectLabel(int i, int i2, int i3, long j, long j2);

    static native void nglObjectPtrLabel(long j, int i, long j2, long j3);

    static native void nglPopDebugGroup(long j);

    static native void nglPushDebugGroup(int i, int i2, int i3, long j, long j2);

    static native void nglShaderStorageBlockBinding(int i, int i2, int i3, long j);

    static native void nglTexBufferRange(int i, int i2, int i3, long j, long j2, long j3);

    static native void nglTexStorage2DMultisample(int i, int i2, int i3, int i4, int i5, boolean z, long j);

    static native void nglTexStorage3DMultisample(int i, int i2, int i3, int i4, int i5, int i6, boolean z, long j);

    static native void nglTextureView(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j);

    static native void nglVertexAttribBinding(int i, int i2, long j);

    static native void nglVertexAttribFormat(int i, int i2, int i3, boolean z, int i4, long j);

    static native void nglVertexAttribIFormat(int i, int i2, int i3, int i4, long j);

    static native void nglVertexAttribLFormat(int i, int i2, int i3, int i4, long j);

    static native void nglVertexBindingDivisor(int i, int i2, long j);
}
