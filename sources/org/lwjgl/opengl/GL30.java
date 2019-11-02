package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class GL30 {
    public static final int GL_ALPHA16F = 34844;
    public static final int GL_ALPHA16I = 36234;
    public static final int GL_ALPHA16UI = 36216;
    public static final int GL_ALPHA32F = 34838;
    public static final int GL_ALPHA32I = 36228;
    public static final int GL_ALPHA32UI = 36210;
    public static final int GL_ALPHA8I = 36240;
    public static final int GL_ALPHA8UI = 36222;
    public static final int GL_ALPHA_INTEGER = 36247;
    public static final int GL_BGRA_INTEGER = 36251;
    public static final int GL_BGR_INTEGER = 36250;
    public static final int GL_BLUE_INTEGER = 36246;
    public static final int GL_BUFFER_ACCESS_FLAGS = 37151;
    public static final int GL_BUFFER_MAP_LENGTH = 37152;
    public static final int GL_BUFFER_MAP_OFFSET = 37153;
    public static final int GL_CLAMP_FRAGMENT_COLOR = 35099;
    public static final int GL_CLAMP_READ_COLOR = 35100;
    public static final int GL_CLAMP_VERTEX_COLOR = 35098;
    public static final int GL_CLIP_DISTANCE0 = 12288;
    public static final int GL_CLIP_DISTANCE1 = 12289;
    public static final int GL_CLIP_DISTANCE2 = 12290;
    public static final int GL_CLIP_DISTANCE3 = 12291;
    public static final int GL_CLIP_DISTANCE4 = 12292;
    public static final int GL_CLIP_DISTANCE5 = 12293;
    public static final int GL_CLIP_DISTANCE6 = 12294;
    public static final int GL_CLIP_DISTANCE7 = 12295;
    public static final int GL_COLOR_ATTACHMENT0 = 36064;
    public static final int GL_COLOR_ATTACHMENT1 = 36065;
    public static final int GL_COLOR_ATTACHMENT10 = 36074;
    public static final int GL_COLOR_ATTACHMENT11 = 36075;
    public static final int GL_COLOR_ATTACHMENT12 = 36076;
    public static final int GL_COLOR_ATTACHMENT13 = 36077;
    public static final int GL_COLOR_ATTACHMENT14 = 36078;
    public static final int GL_COLOR_ATTACHMENT15 = 36079;
    public static final int GL_COLOR_ATTACHMENT2 = 36066;
    public static final int GL_COLOR_ATTACHMENT3 = 36067;
    public static final int GL_COLOR_ATTACHMENT4 = 36068;
    public static final int GL_COLOR_ATTACHMENT5 = 36069;
    public static final int GL_COLOR_ATTACHMENT6 = 36070;
    public static final int GL_COLOR_ATTACHMENT7 = 36071;
    public static final int GL_COLOR_ATTACHMENT8 = 36072;
    public static final int GL_COLOR_ATTACHMENT9 = 36073;
    public static final int GL_COMPARE_REF_DEPTH_TO_TEXTURE = 34894;
    public static final int GL_COMPARE_REF_TO_TEXTURE = 34894;
    public static final int GL_COMPRESSED_RED = 33317;
    public static final int GL_COMPRESSED_RED_RGTC1 = 36283;
    public static final int GL_COMPRESSED_RG = 33318;
    public static final int GL_COMPRESSED_RG_RGTC2 = 36285;
    public static final int GL_COMPRESSED_SIGNED_RED_RGTC1 = 36284;
    public static final int GL_COMPRESSED_SIGNED_RG_RGTC2 = 36286;
    public static final int GL_CONTEXT_FLAGS = 33310;
    public static final int GL_CONTEXT_FLAG_FORWARD_COMPATIBLE_BIT = 1;
    public static final int GL_DEPTH24_STENCIL8 = 35056;
    public static final int GL_DEPTH32F_STENCIL8 = 36013;
    public static final int GL_DEPTH_ATTACHMENT = 36096;
    public static final int GL_DEPTH_BUFFER = 33315;
    public static final int GL_DEPTH_COMPONENT32F = 36012;
    public static final int GL_DEPTH_STENCIL = 34041;
    public static final int GL_DEPTH_STENCIL_ATTACHMENT = 33306;
    public static final int GL_DRAW_FRAMEBUFFER = 36009;
    public static final int GL_DRAW_FRAMEBUFFER_BINDING = 36006;
    public static final int GL_FIXED_ONLY = 35101;
    public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV = 36269;
    public static final int GL_FRAMEBUFFER = 36160;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE = 33301;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE = 33300;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING = 33296;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE = 33297;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE = 33302;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE = 33299;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 36049;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 36048;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE = 33298;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE = 33303;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 36051;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 36052;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 36050;
    public static final int GL_FRAMEBUFFER_BINDING = 36006;
    public static final int GL_FRAMEBUFFER_COMPLETE = 36053;
    public static final int GL_FRAMEBUFFER_DEFAULT = 33304;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 36054;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = 36059;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 36055;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 36182;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER = 36060;
    public static final int GL_FRAMEBUFFER_SRGB = 36281;
    public static final int GL_FRAMEBUFFER_SRGB_CAPABLE = 36282;
    public static final int GL_FRAMEBUFFER_UNDEFINED = 33305;
    public static final int GL_FRAMEBUFFER_UNSUPPORTED = 36061;
    public static final int GL_GREEN_INTEGER = 36245;
    public static final int GL_HALF_FLOAT = 5131;
    public static final int GL_INDEX = 33314;
    public static final int GL_INTERLEAVED_ATTRIBS = 35980;
    public static final int GL_INT_SAMPLER_1D = 36297;
    public static final int GL_INT_SAMPLER_1D_ARRAY = 36302;
    public static final int GL_INT_SAMPLER_2D = 36298;
    public static final int GL_INT_SAMPLER_2D_ARRAY = 36303;
    public static final int GL_INT_SAMPLER_2D_RECT = 36301;
    public static final int GL_INT_SAMPLER_3D = 36299;
    public static final int GL_INT_SAMPLER_BUFFER = 36304;
    public static final int GL_INT_SAMPLER_CUBE = 36300;
    public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 1286;
    public static final int GL_MAJOR_VERSION = 33307;
    public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 16;
    public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 8;
    public static final int GL_MAP_INVALIDATE_RANGE_BIT = 4;
    public static final int GL_MAP_READ_BIT = 1;
    public static final int GL_MAP_UNSYNCHRONIZED_BIT = 32;
    public static final int GL_MAP_WRITE_BIT = 2;
    public static final int GL_MAX_ARRAY_TEXTURE_LAYERS = 35071;
    public static final int GL_MAX_CLIP_DISTANCES = 3378;
    public static final int GL_MAX_COLOR_ATTACHMENTS = 36063;
    public static final int GL_MAX_PROGRAM_TEXEL_OFFSET = 35077;
    public static final int GL_MAX_RENDERBUFFER_SIZE = 34024;
    public static final int GL_MAX_SAMPLES = 36183;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS = 35978;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS = 35979;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS = 35968;
    public static final int GL_MAX_VARYING_COMPONENTS = 35659;
    public static final int GL_MINOR_VERSION = 33308;
    public static final int GL_MIN_PROGRAM_TEXEL_OFFSET = 35076;
    public static final int GL_NUM_EXTENSIONS = 33309;
    public static final int GL_PRIMITIVES_GENERATED = 35975;
    public static final int GL_PROXY_TEXTURE_1D_ARRAY = 35865;
    public static final int GL_PROXY_TEXTURE_2D_ARRAY = 35867;
    public static final int GL_QUERY_BY_REGION_NO_WAIT = 36374;
    public static final int GL_QUERY_BY_REGION_WAIT = 36373;
    public static final int GL_QUERY_NO_WAIT = 36372;
    public static final int GL_QUERY_WAIT = 36371;
    public static final int GL_R11F_G11F_B10F = 35898;
    public static final int GL_R16 = 33322;
    public static final int GL_R16F = 33325;
    public static final int GL_R16I = 33331;
    public static final int GL_R16UI = 33332;
    public static final int GL_R32F = 33326;
    public static final int GL_R32I = 33333;
    public static final int GL_R32UI = 33334;
    public static final int GL_R8 = 33321;
    public static final int GL_R8I = 33329;
    public static final int GL_R8UI = 33330;
    public static final int GL_RASTERIZER_DISCARD = 35977;
    public static final int GL_READ_FRAMEBUFFER = 36008;
    public static final int GL_READ_FRAMEBUFFER_BINDING = 36010;
    public static final int GL_RED_INTEGER = 36244;
    public static final int GL_RENDERBUFFER = 36161;
    public static final int GL_RENDERBUFFER_ALPHA_SIZE = 36179;
    public static final int GL_RENDERBUFFER_BINDING = 36007;
    public static final int GL_RENDERBUFFER_BLUE_SIZE = 36178;
    public static final int GL_RENDERBUFFER_DEPTH_SIZE = 36180;
    public static final int GL_RENDERBUFFER_GREEN_SIZE = 36177;
    public static final int GL_RENDERBUFFER_HEIGHT = 36163;
    public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 36164;
    public static final int GL_RENDERBUFFER_RED_SIZE = 36176;
    public static final int GL_RENDERBUFFER_SAMPLES = 36011;
    public static final int GL_RENDERBUFFER_STENCIL_SIZE = 36181;
    public static final int GL_RENDERBUFFER_WIDTH = 36162;
    public static final int GL_RG = 33319;
    public static final int GL_RG16 = 33324;
    public static final int GL_RG16F = 33327;
    public static final int GL_RG16I = 33337;
    public static final int GL_RG16UI = 33338;
    public static final int GL_RG32F = 33328;
    public static final int GL_RG32I = 33339;
    public static final int GL_RG32UI = 33340;
    public static final int GL_RG8 = 33323;
    public static final int GL_RG8I = 33335;
    public static final int GL_RG8UI = 33336;
    public static final int GL_RGB16F = 34843;
    public static final int GL_RGB16I = 36233;
    public static final int GL_RGB16UI = 36215;
    public static final int GL_RGB32F = 34837;
    public static final int GL_RGB32I = 36227;
    public static final int GL_RGB32UI = 36209;
    public static final int GL_RGB8I = 36239;
    public static final int GL_RGB8UI = 36221;
    public static final int GL_RGB9_E5 = 35901;
    public static final int GL_RGBA16F = 34842;
    public static final int GL_RGBA16I = 36232;
    public static final int GL_RGBA16UI = 36214;
    public static final int GL_RGBA32F = 34836;
    public static final int GL_RGBA32I = 36226;
    public static final int GL_RGBA32UI = 36208;
    public static final int GL_RGBA8I = 36238;
    public static final int GL_RGBA8UI = 36220;
    public static final int GL_RGBA_INTEGER = 36249;
    public static final int GL_RGBA_INTEGER_MODE = 36254;
    public static final int GL_RGB_INTEGER = 36248;
    public static final int GL_RG_INTEGER = 33320;
    public static final int GL_SAMPLER_1D_ARRAY = 36288;
    public static final int GL_SAMPLER_1D_ARRAY_SHADOW = 36291;
    public static final int GL_SAMPLER_2D_ARRAY = 36289;
    public static final int GL_SAMPLER_2D_ARRAY_SHADOW = 36292;
    public static final int GL_SAMPLER_BUFFER = 36290;
    public static final int GL_SAMPLER_CUBE_SHADOW = 36293;
    public static final int GL_SEPARATE_ATTRIBS = 35981;
    public static final int GL_STENCIL_ATTACHMENT = 36128;
    public static final int GL_STENCIL_BUFFER = 33316;
    public static final int GL_STENCIL_INDEX1 = 36166;
    public static final int GL_STENCIL_INDEX16 = 36169;
    public static final int GL_STENCIL_INDEX4 = 36167;
    public static final int GL_STENCIL_INDEX8 = 36168;
    public static final int GL_TEXTURE_1D_ARRAY = 35864;
    public static final int GL_TEXTURE_2D_ARRAY = 35866;
    public static final int GL_TEXTURE_ALPHA_TYPE = 35859;
    public static final int GL_TEXTURE_BINDING_1D_ARRAY = 35868;
    public static final int GL_TEXTURE_BINDING_2D_ARRAY = 35869;
    public static final int GL_TEXTURE_BLUE_TYPE = 35858;
    public static final int GL_TEXTURE_DEPTH_TYPE = 35862;
    public static final int GL_TEXTURE_GREEN_TYPE = 35857;
    public static final int GL_TEXTURE_INTENSITY_TYPE = 35861;
    public static final int GL_TEXTURE_LUMINANCE_TYPE = 35860;
    public static final int GL_TEXTURE_RED_TYPE = 35856;
    public static final int GL_TEXTURE_SHARED_SIZE = 35903;
    public static final int GL_TEXTURE_STENCIL_SIZE = 35057;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER = 35982;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING = 35983;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE = 35967;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE = 35973;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START = 35972;
    public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN = 35976;
    public static final int GL_TRANSFORM_FEEDBACK_VARYINGS = 35971;
    public static final int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH = 35958;
    public static final int GL_UNSIGNED_INT_10F_11F_11F_REV = 35899;
    public static final int GL_UNSIGNED_INT_24_8 = 34042;
    public static final int GL_UNSIGNED_INT_5_9_9_9_REV = 35902;
    public static final int GL_UNSIGNED_INT_SAMPLER_1D = 36305;
    public static final int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY = 36310;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D = 36306;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY = 36311;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT = 36309;
    public static final int GL_UNSIGNED_INT_SAMPLER_3D = 36307;
    public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER = 36312;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE = 36308;
    public static final int GL_UNSIGNED_INT_VEC2 = 36294;
    public static final int GL_UNSIGNED_INT_VEC3 = 36295;
    public static final int GL_UNSIGNED_INT_VEC4 = 36296;
    public static final int GL_UNSIGNED_NORMALIZED = 35863;
    public static final int GL_VERTEX_ARRAY_BINDING = 34229;
    public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER = 35069;

    private GL30() {
    }

    public static void glBeginConditionalRender(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBeginConditionalRender;
        BufferChecks.checkFunctionAddress(j);
        nglBeginConditionalRender(i3, i4, j);
    }

    public static void glBeginTransformFeedback(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glBeginTransformFeedback;
        BufferChecks.checkFunctionAddress(j);
        nglBeginTransformFeedback(i2, j);
    }

    public static void glBindBufferBase(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glBindBufferBase;
        BufferChecks.checkFunctionAddress(j);
        nglBindBufferBase(i4, i5, i6, j);
    }

    public static void glBindBufferRange(int i, int i2, int i3, long j, long j2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glBindBufferRange;
        BufferChecks.checkFunctionAddress(j5);
        nglBindBufferRange(i4, i5, i6, j3, j4, j5);
    }

    public static void glBindFragDataLocation(int i, int i2, CharSequence charSequence) {
        int i3 = i;
        int i4 = i2;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glBindFragDataLocation;
        BufferChecks.checkFunctionAddress(j);
        nglBindFragDataLocation(i3, i4, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static void glBindFragDataLocation(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glBindFragDataLocation;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        nglBindFragDataLocation(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glBindFramebuffer(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBindFramebuffer;
        BufferChecks.checkFunctionAddress(j);
        nglBindFramebuffer(i3, i4, j);
    }

    public static void glBindRenderbuffer(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBindRenderbuffer;
        BufferChecks.checkFunctionAddress(j);
        nglBindRenderbuffer(i3, i4, j);
    }

    public static void glBindVertexArray(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glBindVertexArray;
        BufferChecks.checkFunctionAddress(j);
        StateTracker.bindVAO(capabilities, i2);
        nglBindVertexArray(i2, j);
    }

    public static void glBlitFramebuffer(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = i;
        int i12 = i2;
        int i13 = i3;
        int i14 = i4;
        int i15 = i5;
        int i16 = i6;
        int i17 = i7;
        int i18 = i8;
        int i19 = i9;
        int i20 = i10;
        long j = GLContext.getCapabilities().glBlitFramebuffer;
        BufferChecks.checkFunctionAddress(j);
        nglBlitFramebuffer(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, j);
    }

    public static int glCheckFramebufferStatus(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glCheckFramebufferStatus;
        BufferChecks.checkFunctionAddress(j);
        return nglCheckFramebufferStatus(i2, j);
    }

    public static void glClampColor(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glClampColor;
        BufferChecks.checkFunctionAddress(j);
        nglClampColor(i3, i4, j);
    }

    public static void glClearBuffer(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glClearBufferfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglClearBufferfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glClearBuffer(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glClearBufferiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglClearBufferiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glClearBufferfi(int i, int i2, float f, int i3) {
        int i4 = i;
        int i5 = i2;
        float f2 = f;
        int i6 = i3;
        long j = GLContext.getCapabilities().glClearBufferfi;
        BufferChecks.checkFunctionAddress(j);
        nglClearBufferfi(i4, i5, f2, i6, j);
    }

    public static void glClearBufferu(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glClearBufferuiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglClearBufferuiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glColorMaski(int i, boolean z, boolean z2, boolean z3, boolean z4) {
        int i2 = i;
        boolean z5 = z;
        boolean z6 = z2;
        boolean z7 = z3;
        boolean z8 = z4;
        long j = GLContext.getCapabilities().glColorMaski;
        BufferChecks.checkFunctionAddress(j);
        nglColorMaski(i2, z5, z6, z7, z8, j);
    }

    public static void glDeleteFramebuffers(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteFramebuffers;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteFramebuffers(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteFramebuffers(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteFramebuffers;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteFramebuffers(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDeleteRenderbuffers(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteRenderbuffers;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteRenderbuffers(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteRenderbuffers(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteRenderbuffers;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteRenderbuffers(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDeleteVertexArrays(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteVertexArrays;
        BufferChecks.checkFunctionAddress(j);
        StateTracker.deleteVAO(capabilities, i2);
        nglDeleteVertexArrays(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteVertexArrays(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteVertexArrays;
        BufferChecks.checkFunctionAddress(j);
        StateTracker.deleteVAO(capabilities, intBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteVertexArrays(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDisablei(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glDisablei;
        BufferChecks.checkFunctionAddress(j);
        nglDisablei(i3, i4, j);
    }

    public static void glEnablei(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glEnablei;
        BufferChecks.checkFunctionAddress(j);
        nglEnablei(i3, i4, j);
    }

    public static void glEndConditionalRender() {
        long j = GLContext.getCapabilities().glEndConditionalRender;
        BufferChecks.checkFunctionAddress(j);
        nglEndConditionalRender(j);
    }

    public static void glEndTransformFeedback() {
        long j = GLContext.getCapabilities().glEndTransformFeedback;
        BufferChecks.checkFunctionAddress(j);
        nglEndTransformFeedback(j);
    }

    public static void glFlushMappedBufferRange(int i, long j, long j2) {
        int i2 = i;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glFlushMappedBufferRange;
        BufferChecks.checkFunctionAddress(j5);
        nglFlushMappedBufferRange(i2, j3, j4, j5);
    }

    public static void glFramebufferRenderbuffer(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glFramebufferRenderbuffer;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferRenderbuffer(i5, i6, i7, i8, j);
    }

    public static void glFramebufferTexture1D(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glFramebufferTexture1D;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferTexture1D(i6, i7, i8, i9, i10, j);
    }

    public static void glFramebufferTexture2D(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glFramebufferTexture2D;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferTexture2D(i6, i7, i8, i9, i10, j);
    }

    public static void glFramebufferTexture3D(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glFramebufferTexture3D;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferTexture3D(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glFramebufferTextureLayer(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glFramebufferTextureLayer;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferTextureLayer(i6, i7, i8, i9, i10, j);
    }

    public static int glGenFramebuffers() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenFramebuffers;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenFramebuffers(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenFramebuffers(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenFramebuffers;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenFramebuffers(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGenRenderbuffers() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenRenderbuffers;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenRenderbuffers(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenRenderbuffers(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenRenderbuffers;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenRenderbuffers(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGenVertexArrays() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenVertexArrays;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenVertexArrays(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenVertexArrays(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenVertexArrays;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenVertexArrays(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGenerateMipmap(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glGenerateMipmap;
        BufferChecks.checkFunctionAddress(j);
        nglGenerateMipmap(i2, j);
    }

    public static void glGetBoolean(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetBooleani_v;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 4);
        nglGetBooleani_v(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static boolean glGetBoolean(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetBooleani_v;
        BufferChecks.checkFunctionAddress(j);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, 1);
        nglGetBooleani_v(i3, i4, MemoryUtil.getAddress(bufferByte), j);
        return bufferByte.get(0) == 1;
    }

    public static int glGetFragDataLocation(int i, CharSequence charSequence) {
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetFragDataLocation;
        BufferChecks.checkFunctionAddress(j);
        return nglGetFragDataLocation(i2, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glGetFragDataLocation(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetFragDataLocation;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglGetFragDataLocation(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    @Deprecated
    public static int glGetFramebufferAttachmentParameter(int i, int i2, int i3) {
        return glGetFramebufferAttachmentParameteri(i, i2, i3);
    }

    public static void glGetFramebufferAttachmentParameter(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetFramebufferAttachmentParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetFramebufferAttachmentParameteriv(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetFramebufferAttachmentParameteri(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetFramebufferAttachmentParameteriv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetFramebufferAttachmentParameteriv(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static int glGetInteger(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetIntegeri_v;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetIntegeri_v(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetInteger(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetIntegeri_v;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetIntegeri_v(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    @Deprecated
    public static int glGetRenderbufferParameter(int i, int i2) {
        return glGetRenderbufferParameteri(i, i2);
    }

    public static void glGetRenderbufferParameter(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetRenderbufferParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetRenderbufferParameteriv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetRenderbufferParameteri(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetRenderbufferParameteriv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetRenderbufferParameteriv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static String glGetStringi(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glGetStringi;
        BufferChecks.checkFunctionAddress(j);
        return nglGetStringi(i3, i4, j);
    }

    public static void glGetTexParameterI(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTexParameterIiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetTexParameterIiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetTexParameterIi(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexParameterIiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetTexParameterIiv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetTexParameterIu(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTexParameterIuiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetTexParameterIuiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetTexParameterIui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexParameterIuiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetTexParameterIuiv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static String glGetTransformFeedbackVarying(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTransformFeedbackVarying;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer3, 1);
        BufferChecks.checkBuffer(intBuffer4, 1);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i6);
        nglGetTransformFeedbackVarying(i4, i5, i6, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetTransformFeedbackVarying(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer4 = intBuffer;
        IntBuffer intBuffer5 = intBuffer2;
        IntBuffer intBuffer6 = intBuffer3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetTransformFeedbackVarying;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, 1);
        }
        BufferChecks.checkBuffer(intBuffer5, 1);
        BufferChecks.checkBuffer(intBuffer6, 1);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetTransformFeedbackVarying(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer4), MemoryUtil.getAddress(intBuffer5), MemoryUtil.getAddress(intBuffer6), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetUniformu(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetUniformuiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetUniformuiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetVertexAttribI(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribIiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetVertexAttribIiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetVertexAttribIu(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribIuiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetVertexAttribIuiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static boolean glIsEnabledi(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glIsEnabledi;
        BufferChecks.checkFunctionAddress(j);
        return nglIsEnabledi(i3, i4, j);
    }

    public static boolean glIsFramebuffer(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsFramebuffer;
        BufferChecks.checkFunctionAddress(j);
        return nglIsFramebuffer(i2, j);
    }

    public static boolean glIsRenderbuffer(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsRenderbuffer;
        BufferChecks.checkFunctionAddress(j);
        return nglIsRenderbuffer(i2, j);
    }

    public static boolean glIsVertexArray(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsVertexArray;
        BufferChecks.checkFunctionAddress(j);
        return nglIsVertexArray(i2, j);
    }

    public static ByteBuffer glMapBufferRange(int i, long j, long j2, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        long j3 = j;
        long j4 = j2;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j5 = GLContext.getCapabilities().glMapBufferRange;
        BufferChecks.checkFunctionAddress(j5);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        ByteBuffer nglMapBufferRange = nglMapBufferRange(i3, j3, j4, i4, byteBuffer2, j5);
        if (!LWJGLUtil.CHECKS || nglMapBufferRange != null) {
            return nglMapBufferRange.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static void glRenderbufferStorage(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glRenderbufferStorage;
        BufferChecks.checkFunctionAddress(j);
        nglRenderbufferStorage(i5, i6, i7, i8, j);
    }

    public static void glRenderbufferStorageMultisample(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glRenderbufferStorageMultisample;
        BufferChecks.checkFunctionAddress(j);
        nglRenderbufferStorageMultisample(i6, i7, i8, i9, i10, j);
    }

    public static void glTexParameterI(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTexParameterIiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglTexParameterIiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexParameterIi(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexParameterIiv;
        BufferChecks.checkFunctionAddress(j);
        nglTexParameterIiv(i4, i5, APIUtil.getInt(capabilities, i6), j);
    }

    public static void glTexParameterIu(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTexParameterIuiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglTexParameterIuiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexParameterIui(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexParameterIuiv;
        BufferChecks.checkFunctionAddress(j);
        nglTexParameterIuiv(i4, i5, APIUtil.getInt(capabilities, i6), j);
    }

    public static void glTransformFeedbackVaryings(int i, int i2, ByteBuffer byteBuffer, int i3) {
        int i4 = i;
        int i5 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i6 = i3;
        long j = GLContext.getCapabilities().glTransformFeedbackVaryings;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2, i5);
        nglTransformFeedbackVaryings(i4, i5, MemoryUtil.getAddress(byteBuffer2), i6, j);
    }

    public static void glTransformFeedbackVaryings(int i, CharSequence[] charSequenceArr, int i2) {
        int i3 = i;
        CharSequence[] charSequenceArr2 = charSequenceArr;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTransformFeedbackVaryings;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkArray(charSequenceArr2);
        nglTransformFeedbackVaryings(i3, charSequenceArr2.length, APIUtil.getBufferNT(capabilities, charSequenceArr2), i4, j);
    }

    public static void glUniform1u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform1uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform1uiv(i2, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform1ui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glUniform1ui;
        BufferChecks.checkFunctionAddress(j);
        nglUniform1ui(i3, i4, j);
    }

    public static void glUniform2u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform2uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform2uiv(i2, intBuffer2.remaining() >> 1, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform2ui(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glUniform2ui;
        BufferChecks.checkFunctionAddress(j);
        nglUniform2ui(i4, i5, i6, j);
    }

    public static void glUniform3u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform3uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform3uiv(i2, intBuffer2.remaining() / 3, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform3ui(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glUniform3ui;
        BufferChecks.checkFunctionAddress(j);
        nglUniform3ui(i5, i6, i7, i8, j);
    }

    public static void glUniform4u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniform4uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniform4uiv(i2, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glUniform4ui(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glUniform4ui;
        BufferChecks.checkFunctionAddress(j);
        nglUniform4ui(i6, i7, i8, i9, i10, j);
    }

    public static void glVertexAttribI1(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI1iv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglVertexAttribI1iv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI1i(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glVertexAttribI1i;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI1i(i3, i4, j);
    }

    public static void glVertexAttribI1u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI1uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglVertexAttribI1uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI1ui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glVertexAttribI1ui;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI1ui(i3, i4, j);
    }

    public static void glVertexAttribI2(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI2iv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 2);
        nglVertexAttribI2iv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI2i(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glVertexAttribI2i;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI2i(i4, i5, i6, j);
    }

    public static void glVertexAttribI2u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI2uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 2);
        nglVertexAttribI2uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI2ui(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glVertexAttribI2ui;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI2ui(i4, i5, i6, j);
    }

    public static void glVertexAttribI3(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI3iv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 3);
        nglVertexAttribI3iv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI3i(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glVertexAttribI3i;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI3i(i5, i6, i7, i8, j);
    }

    public static void glVertexAttribI3u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI3uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 3);
        nglVertexAttribI3uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI3ui(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glVertexAttribI3ui;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI3ui(i5, i6, i7, i8, j);
    }

    public static void glVertexAttribI4(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI4bv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 4);
        nglVertexAttribI4bv(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexAttribI4(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI4iv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglVertexAttribI4iv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI4(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI4sv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(shortBuffer2, 4);
        nglVertexAttribI4sv(i2, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glVertexAttribI4i(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glVertexAttribI4i;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI4i(i6, i7, i8, i9, i10, j);
    }

    public static void glVertexAttribI4u(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI4ubv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 4);
        nglVertexAttribI4ubv(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexAttribI4u(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI4uiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglVertexAttribI4uiv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribI4u(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVertexAttribI4usv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(shortBuffer2, 4);
        nglVertexAttribI4usv(i2, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glVertexAttribI4ui(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glVertexAttribI4ui;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribI4ui(i6, i7, i8, i9, i10, j);
    }

    public static void glVertexAttribIPointer(int i, int i2, int i3, int i4, long j) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glVertexAttribIPointer;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglVertexAttribIPointerBO(i5, i6, i7, i8, j2, j3);
    }

    public static void glVertexAttribIPointer(int i, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribIPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i5] = byteBuffer2;
        }
        nglVertexAttribIPointer(i5, i6, i7, i8, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVertexAttribIPointer(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribIPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i5] = intBuffer2;
        }
        nglVertexAttribIPointer(i5, i6, i7, i8, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVertexAttribIPointer(int i, int i2, int i3, int i4, ShortBuffer shortBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribIPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i5] = shortBuffer2;
        }
        nglVertexAttribIPointer(i5, i6, i7, i8, MemoryUtil.getAddress(shortBuffer2), j);
    }

    static native void nglBeginConditionalRender(int i, int i2, long j);

    static native void nglBeginTransformFeedback(int i, long j);

    static native void nglBindBufferBase(int i, int i2, int i3, long j);

    static native void nglBindBufferRange(int i, int i2, int i3, long j, long j2, long j3);

    static native void nglBindFragDataLocation(int i, int i2, long j, long j2);

    static native void nglBindFramebuffer(int i, int i2, long j);

    static native void nglBindRenderbuffer(int i, int i2, long j);

    static native void nglBindVertexArray(int i, long j);

    static native void nglBlitFramebuffer(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j);

    static native int nglCheckFramebufferStatus(int i, long j);

    static native void nglClampColor(int i, int i2, long j);

    static native void nglClearBufferfi(int i, int i2, float f, int i3, long j);

    static native void nglClearBufferfv(int i, int i2, long j, long j2);

    static native void nglClearBufferiv(int i, int i2, long j, long j2);

    static native void nglClearBufferuiv(int i, int i2, long j, long j2);

    static native void nglColorMaski(int i, boolean z, boolean z2, boolean z3, boolean z4, long j);

    static native void nglDeleteFramebuffers(int i, long j, long j2);

    static native void nglDeleteRenderbuffers(int i, long j, long j2);

    static native void nglDeleteVertexArrays(int i, long j, long j2);

    static native void nglDisablei(int i, int i2, long j);

    static native void nglEnablei(int i, int i2, long j);

    static native void nglEndConditionalRender(long j);

    static native void nglEndTransformFeedback(long j);

    static native void nglFlushMappedBufferRange(int i, long j, long j2, long j3);

    static native void nglFramebufferRenderbuffer(int i, int i2, int i3, int i4, long j);

    static native void nglFramebufferTexture1D(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglFramebufferTexture2D(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglFramebufferTexture3D(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglFramebufferTextureLayer(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglGenFramebuffers(int i, long j, long j2);

    static native void nglGenRenderbuffers(int i, long j, long j2);

    static native void nglGenVertexArrays(int i, long j, long j2);

    static native void nglGenerateMipmap(int i, long j);

    static native void nglGetBooleani_v(int i, int i2, long j, long j2);

    static native int nglGetFragDataLocation(int i, long j, long j2);

    static native void nglGetFramebufferAttachmentParameteriv(int i, int i2, int i3, long j, long j2);

    static native void nglGetIntegeri_v(int i, int i2, long j, long j2);

    static native void nglGetRenderbufferParameteriv(int i, int i2, long j, long j2);

    static native String nglGetStringi(int i, int i2, long j);

    static native void nglGetTexParameterIiv(int i, int i2, long j, long j2);

    static native void nglGetTexParameterIuiv(int i, int i2, long j, long j2);

    static native void nglGetTransformFeedbackVarying(int i, int i2, int i3, long j, long j2, long j3, long j4, long j5);

    static native void nglGetUniformuiv(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribIiv(int i, int i2, long j, long j2);

    static native void nglGetVertexAttribIuiv(int i, int i2, long j, long j2);

    static native boolean nglIsEnabledi(int i, int i2, long j);

    static native boolean nglIsFramebuffer(int i, long j);

    static native boolean nglIsRenderbuffer(int i, long j);

    static native boolean nglIsVertexArray(int i, long j);

    static native ByteBuffer nglMapBufferRange(int i, long j, long j2, int i2, ByteBuffer byteBuffer, long j3);

    static native void nglRenderbufferStorage(int i, int i2, int i3, int i4, long j);

    static native void nglRenderbufferStorageMultisample(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglTexParameterIiv(int i, int i2, long j, long j2);

    static native void nglTexParameterIuiv(int i, int i2, long j, long j2);

    static native void nglTransformFeedbackVaryings(int i, int i2, long j, int i3, long j2);

    static native void nglUniform1ui(int i, int i2, long j);

    static native void nglUniform1uiv(int i, int i2, long j, long j2);

    static native void nglUniform2ui(int i, int i2, int i3, long j);

    static native void nglUniform2uiv(int i, int i2, long j, long j2);

    static native void nglUniform3ui(int i, int i2, int i3, int i4, long j);

    static native void nglUniform3uiv(int i, int i2, long j, long j2);

    static native void nglUniform4ui(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglUniform4uiv(int i, int i2, long j, long j2);

    static native void nglVertexAttribI1i(int i, int i2, long j);

    static native void nglVertexAttribI1iv(int i, long j, long j2);

    static native void nglVertexAttribI1ui(int i, int i2, long j);

    static native void nglVertexAttribI1uiv(int i, long j, long j2);

    static native void nglVertexAttribI2i(int i, int i2, int i3, long j);

    static native void nglVertexAttribI2iv(int i, long j, long j2);

    static native void nglVertexAttribI2ui(int i, int i2, int i3, long j);

    static native void nglVertexAttribI2uiv(int i, long j, long j2);

    static native void nglVertexAttribI3i(int i, int i2, int i3, int i4, long j);

    static native void nglVertexAttribI3iv(int i, long j, long j2);

    static native void nglVertexAttribI3ui(int i, int i2, int i3, int i4, long j);

    static native void nglVertexAttribI3uiv(int i, long j, long j2);

    static native void nglVertexAttribI4bv(int i, long j, long j2);

    static native void nglVertexAttribI4i(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglVertexAttribI4iv(int i, long j, long j2);

    static native void nglVertexAttribI4sv(int i, long j, long j2);

    static native void nglVertexAttribI4ubv(int i, long j, long j2);

    static native void nglVertexAttribI4ui(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglVertexAttribI4uiv(int i, long j, long j2);

    static native void nglVertexAttribI4usv(int i, long j, long j2);

    static native void nglVertexAttribIPointer(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglVertexAttribIPointerBO(int i, int i2, int i3, int i4, long j, long j2);
}
