package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class GL40 {
    public static final int GL_ACTIVE_SUBROUTINES = 36325;
    public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 36424;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 36326;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 36423;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 36425;
    public static final int GL_COMPATIBLE_SUBROUTINES = 36427;
    public static final int GL_DOUBLE_MAT2 = 36678;
    public static final int GL_DOUBLE_MAT2x3 = 36681;
    public static final int GL_DOUBLE_MAT2x4 = 36682;
    public static final int GL_DOUBLE_MAT3 = 36679;
    public static final int GL_DOUBLE_MAT3x2 = 36683;
    public static final int GL_DOUBLE_MAT3x4 = 36684;
    public static final int GL_DOUBLE_MAT4 = 36680;
    public static final int GL_DOUBLE_MAT4x2 = 36685;
    public static final int GL_DOUBLE_MAT4x3 = 36686;
    public static final int GL_DOUBLE_VEC2 = 36860;
    public static final int GL_DOUBLE_VEC3 = 36861;
    public static final int GL_DOUBLE_VEC4 = 36862;
    public static final int GL_DRAW_INDIRECT_BUFFER = 36671;
    public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675;
    public static final int GL_FRACTIONAL_EVEN = 36476;
    public static final int GL_FRACTIONAL_ODD = 36475;
    public static final int GL_FRAGMENT_INTERPOLATION_OFFSET_BITS = 36445;
    public static final int GL_GEOMETRY_SHADER_INVOCATIONS = 34943;
    public static final int GL_INT_SAMPLER_CUBE_MAP_ARRAY = 36878;
    public static final int GL_ISOLINES = 36474;
    public static final int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS = 36382;
    public static final int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS = 36383;
    public static final int GL_MAX_FRAGMENT_INTERPOLATION_OFFSET = 36444;
    public static final int GL_MAX_GEOMETRY_SHADER_INVOCATIONS = 36442;
    public static final int GL_MAX_PATCH_VERTICES = 36477;
    public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_COMPONENTS_ARB = 36767;
    public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET_ARB = 36447;
    public static final int GL_MAX_SUBROUTINES = 36327;
    public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 36328;
    public static final int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS = 34924;
    public static final int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS = 36483;
    public static final int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS = 36481;
    public static final int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS = 36485;
    public static final int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS = 36489;
    public static final int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS = 36479;
    public static final int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS = 34925;
    public static final int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS = 36486;
    public static final int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS = 36482;
    public static final int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS = 36490;
    public static final int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS = 36480;
    public static final int GL_MAX_TESS_GEN_LEVEL = 36478;
    public static final int GL_MAX_TESS_PATCH_COMPONENTS = 36484;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 36464;
    public static final int GL_MAX_VERTEX_STREAMS = 36465;
    public static final int GL_MIN_FRAGMENT_INTERPOLATION_OFFSET = 36443;
    public static final int GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET_ARB = 36446;
    public static final int GL_MIN_SAMPLE_SHADING_VALUE = 35895;
    public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 36426;
    public static final int GL_PATCHES = 14;
    public static final int GL_PATCH_DEFAULT_INNER_LEVEL = 36467;
    public static final int GL_PATCH_DEFAULT_OUTER_LEVEL = 36468;
    public static final int GL_PATCH_VERTICES = 36466;
    public static final int GL_PROXY_TEXTURE_CUBE_MAP_ARRAY = 36875;
    public static final int GL_SAMPLER_CUBE_MAP_ARRAY = 36876;
    public static final int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW = 36877;
    public static final int GL_SAMPLE_SHADING = 35894;
    public static final int GL_TESS_CONTROL_OUTPUT_VERTICES = 36469;
    public static final int GL_TESS_CONTROL_SHADER = 36488;
    public static final int GL_TESS_EVALUATION_SHADER = 36487;
    public static final int GL_TESS_GEN_MODE = 36470;
    public static final int GL_TESS_GEN_POINT_MODE = 36473;
    public static final int GL_TESS_GEN_SPACING = 36471;
    public static final int GL_TESS_GEN_VERTEX_ORDER = 36472;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY = 36874;
    public static final int GL_TEXTURE_CUBE_MAP_ARRAY = 36873;
    public static final int GL_TRANSFORM_FEEDBACK = 36386;
    public static final int GL_TRANSFORM_FEEDBACK_ACTIVE = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 36387;
    public static final int GL_TRANSFORM_FEEDBACK_PAUSED = 36387;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER = 34032;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER = 34033;
    public static final int GL_UNIFORM_NAME_LENGTH = 35385;
    public static final int GL_UNIFORM_SIZE = 35384;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY = 36879;

    private GL40() {
    }

    public static void glBeginQueryIndexed(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glBeginQueryIndexed;
        BufferChecks.checkFunctionAddress(j);
        nglBeginQueryIndexed(i4, i5, i6, j);
    }

    public static void glBindTransformFeedback(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBindTransformFeedback;
        BufferChecks.checkFunctionAddress(j);
        nglBindTransformFeedback(i3, i4, j);
    }

    public static void glBlendEquationSeparatei(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glBlendEquationSeparatei;
        BufferChecks.checkFunctionAddress(j);
        nglBlendEquationSeparatei(i4, i5, i6, j);
    }

    public static void glBlendEquationi(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBlendEquationi;
        BufferChecks.checkFunctionAddress(j);
        nglBlendEquationi(i3, i4, j);
    }

    public static void glBlendFuncSeparatei(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glBlendFuncSeparatei;
        BufferChecks.checkFunctionAddress(j);
        nglBlendFuncSeparatei(i6, i7, i8, i9, i10, j);
    }

    public static void glBlendFunci(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glBlendFunci;
        BufferChecks.checkFunctionAddress(j);
        nglBlendFunci(i4, i5, i6, j);
    }

    public static void glDeleteTransformFeedbacks(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteTransformFeedbacks;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteTransformFeedbacks(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteTransformFeedbacks(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteTransformFeedbacks;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteTransformFeedbacks(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDrawArraysIndirect(int i, long j) {
        int i2 = i;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glDrawArraysIndirect;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureIndirectBOenabled(capabilities);
        nglDrawArraysIndirectBO(i2, j2, j3);
    }

    public static void glDrawArraysIndirect(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawArraysIndirect;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, 16);
        nglDrawArraysIndirect(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glDrawArraysIndirect(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawArraysIndirect;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglDrawArraysIndirect(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDrawElementsIndirect(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glDrawElementsIndirect;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureIndirectBOenabled(capabilities);
        nglDrawElementsIndirectBO(i3, i4, j2, j3);
    }

    public static void glDrawElementsIndirect(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsIndirect;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, 20);
        nglDrawElementsIndirect(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glDrawElementsIndirect(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawElementsIndirect;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureIndirectBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, 5);
        nglDrawElementsIndirect(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDrawTransformFeedback(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glDrawTransformFeedback;
        BufferChecks.checkFunctionAddress(j);
        nglDrawTransformFeedback(i3, i4, j);
    }

    public static void glDrawTransformFeedbackStream(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glDrawTransformFeedbackStream;
        BufferChecks.checkFunctionAddress(j);
        nglDrawTransformFeedbackStream(i4, i5, i6, j);
    }

    public static void glEndQueryIndexed(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glEndQueryIndexed;
        BufferChecks.checkFunctionAddress(j);
        nglEndQueryIndexed(i3, i4, j);
    }

    public static int glGenTransformFeedbacks() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenTransformFeedbacks;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenTransformFeedbacks(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenTransformFeedbacks(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenTransformFeedbacks;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenTransformFeedbacks(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static String glGetActiveSubroutineName(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveSubroutineName;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i8);
        nglGetActiveSubroutineName(i5, i6, i7, i8, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetActiveSubroutineName(int i, int i2, int i3, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetActiveSubroutineName;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        BufferChecks.checkDirect(byteBuffer2);
        nglGetActiveSubroutineName(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    @Deprecated
    public static int glGetActiveSubroutineUniform(int i, int i2, int i3, int i4) {
        return glGetActiveSubroutineUniformi(i, i2, i3, i4);
    }

    public static void glGetActiveSubroutineUniform(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetActiveSubroutineUniformiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetActiveSubroutineUniformiv(i5, i6, i7, i8, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static String glGetActiveSubroutineUniformName(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveSubroutineUniformName;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i8);
        nglGetActiveSubroutineUniformName(i5, i6, i7, i8, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetActiveSubroutineUniformName(int i, int i2, int i3, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetActiveSubroutineUniformName;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        BufferChecks.checkDirect(byteBuffer2);
        nglGetActiveSubroutineUniformName(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetActiveSubroutineUniformi(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetActiveSubroutineUniformiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetActiveSubroutineUniformiv(i5, i6, i7, i8, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    @Deprecated
    public static int glGetProgramStage(int i, int i2, int i3) {
        return glGetProgramStagei(i, i2, i3);
    }

    public static void glGetProgramStage(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetProgramStageiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetProgramStageiv(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetProgramStagei(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetProgramStageiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetProgramStageiv(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    @Deprecated
    public static int glGetQueryIndexed(int i, int i2, int i3) {
        return glGetQueryIndexedi(i, i2, i3);
    }

    public static void glGetQueryIndexed(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetQueryIndexediv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetQueryIndexediv(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetQueryIndexedi(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetQueryIndexediv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetQueryIndexediv(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static int glGetSubroutineIndex(int i, int i2, CharSequence charSequence) {
        int i3 = i;
        int i4 = i2;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSubroutineIndex;
        BufferChecks.checkFunctionAddress(j);
        return nglGetSubroutineIndex(i3, i4, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glGetSubroutineIndex(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetSubroutineIndex;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglGetSubroutineIndex(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetSubroutineUniformLocation(int i, int i2, CharSequence charSequence) {
        int i3 = i;
        int i4 = i2;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSubroutineUniformLocation;
        BufferChecks.checkFunctionAddress(j);
        return nglGetSubroutineUniformLocation(i3, i4, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glGetSubroutineUniformLocation(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetSubroutineUniformLocation;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglGetSubroutineUniformLocation(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetUniform(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetUniformdv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetUniformdv(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    @Deprecated
    public static int glGetUniformSubroutineu(int i, int i2) {
        return glGetUniformSubroutineui(i, i2);
    }

    public static void glGetUniformSubroutineu(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetUniformSubroutineuiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetUniformSubroutineuiv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetUniformSubroutineui(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetUniformSubroutineuiv;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetUniformSubroutineuiv(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static boolean glIsTransformFeedback(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsTransformFeedback;
        BufferChecks.checkFunctionAddress(j);
        return nglIsTransformFeedback(i2, j);
    }

    public static void glMinSampleShading(float f) {
        float f2 = f;
        long j = GLContext.getCapabilities().glMinSampleShading;
        BufferChecks.checkFunctionAddress(j);
        nglMinSampleShading(f2, j);
    }

    public static void glPatchParameter(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glPatchParameterfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglPatchParameterfv(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glPatchParameteri(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glPatchParameteri;
        BufferChecks.checkFunctionAddress(j);
        nglPatchParameteri(i3, i4, j);
    }

    public static void glPauseTransformFeedback() {
        long j = GLContext.getCapabilities().glPauseTransformFeedback;
        BufferChecks.checkFunctionAddress(j);
        nglPauseTransformFeedback(j);
    }

    public static void glResumeTransformFeedback() {
        long j = GLContext.getCapabilities().glResumeTransformFeedback;
        BufferChecks.checkFunctionAddress(j);
        nglResumeTransformFeedback(j);
    }

    public static void glUniform1(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glUniform1dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglUniform1dv(i2, doubleBuffer2.remaining(), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glUniform1d(int i, double d) {
        int i2 = i;
        double d2 = d;
        long j = GLContext.getCapabilities().glUniform1d;
        BufferChecks.checkFunctionAddress(j);
        nglUniform1d(i2, d2, j);
    }

    public static void glUniform2(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glUniform2dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglUniform2dv(i2, doubleBuffer2.remaining() >> 1, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glUniform2d(int i, double d, double d2) {
        int i2 = i;
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glUniform2d;
        BufferChecks.checkFunctionAddress(j);
        nglUniform2d(i2, d3, d4, j);
    }

    public static void glUniform3(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glUniform3dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglUniform3dv(i2, doubleBuffer2.remaining() / 3, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glUniform3d(int i, double d, double d2, double d3) {
        int i2 = i;
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glUniform3d;
        BufferChecks.checkFunctionAddress(j);
        nglUniform3d(i2, d4, d5, d6, j);
    }

    public static void glUniform4(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glUniform4dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglUniform4dv(i2, doubleBuffer2.remaining() >> 2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glUniform4d(int i, double d, double d2, double d3, double d4) {
        int i2 = i;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glUniform4d;
        BufferChecks.checkFunctionAddress(j);
        nglUniform4d(i2, d5, d6, d7, d8, j);
    }

    public static void glUniformMatrix2(int i, boolean z, DoubleBuffer doubleBuffer) {
        int i2 = i;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix2dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglUniformMatrix2dv(i2, doubleBuffer2.remaining() >> 2, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glUniformMatrix2x3(int i, boolean z, DoubleBuffer doubleBuffer) {
        int i2 = i;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix2x3dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglUniformMatrix2x3dv(i2, doubleBuffer2.remaining() / 6, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glUniformMatrix2x4(int i, boolean z, DoubleBuffer doubleBuffer) {
        int i2 = i;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix2x4dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglUniformMatrix2x4dv(i2, doubleBuffer2.remaining() >> 3, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glUniformMatrix3(int i, boolean z, DoubleBuffer doubleBuffer) {
        int i2 = i;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix3dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglUniformMatrix3dv(i2, doubleBuffer2.remaining() / 9, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glUniformMatrix3x2(int i, boolean z, DoubleBuffer doubleBuffer) {
        int i2 = i;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix3x2dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglUniformMatrix3x2dv(i2, doubleBuffer2.remaining() / 6, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glUniformMatrix3x4(int i, boolean z, DoubleBuffer doubleBuffer) {
        int i2 = i;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix3x4dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglUniformMatrix3x4dv(i2, doubleBuffer2.remaining() / 12, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glUniformMatrix4(int i, boolean z, DoubleBuffer doubleBuffer) {
        int i2 = i;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix4dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglUniformMatrix4dv(i2, doubleBuffer2.remaining() >> 4, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glUniformMatrix4x2(int i, boolean z, DoubleBuffer doubleBuffer) {
        int i2 = i;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix4x2dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglUniformMatrix4x2dv(i2, doubleBuffer2.remaining() >> 3, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glUniformMatrix4x3(int i, boolean z, DoubleBuffer doubleBuffer) {
        int i2 = i;
        boolean z2 = z;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glUniformMatrix4x3dv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglUniformMatrix4x3dv(i2, doubleBuffer2.remaining() / 12, z2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glUniformSubroutinesu(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glUniformSubroutinesuiv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUniformSubroutinesuiv(i2, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    static native void nglBeginQueryIndexed(int i, int i2, int i3, long j);

    static native void nglBindTransformFeedback(int i, int i2, long j);

    static native void nglBlendEquationSeparatei(int i, int i2, int i3, long j);

    static native void nglBlendEquationi(int i, int i2, long j);

    static native void nglBlendFuncSeparatei(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglBlendFunci(int i, int i2, int i3, long j);

    static native void nglDeleteTransformFeedbacks(int i, long j, long j2);

    static native void nglDrawArraysIndirect(int i, long j, long j2);

    static native void nglDrawArraysIndirectBO(int i, long j, long j2);

    static native void nglDrawElementsIndirect(int i, int i2, long j, long j2);

    static native void nglDrawElementsIndirectBO(int i, int i2, long j, long j2);

    static native void nglDrawTransformFeedback(int i, int i2, long j);

    static native void nglDrawTransformFeedbackStream(int i, int i2, int i3, long j);

    static native void nglEndQueryIndexed(int i, int i2, long j);

    static native void nglGenTransformFeedbacks(int i, long j, long j2);

    static native void nglGetActiveSubroutineName(int i, int i2, int i3, int i4, long j, long j2, long j3);

    static native void nglGetActiveSubroutineUniformName(int i, int i2, int i3, int i4, long j, long j2, long j3);

    static native void nglGetActiveSubroutineUniformiv(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglGetProgramStageiv(int i, int i2, int i3, long j, long j2);

    static native void nglGetQueryIndexediv(int i, int i2, int i3, long j, long j2);

    static native int nglGetSubroutineIndex(int i, int i2, long j, long j2);

    static native int nglGetSubroutineUniformLocation(int i, int i2, long j, long j2);

    static native void nglGetUniformSubroutineuiv(int i, int i2, long j, long j2);

    static native void nglGetUniformdv(int i, int i2, long j, long j2);

    static native boolean nglIsTransformFeedback(int i, long j);

    static native void nglMinSampleShading(float f, long j);

    static native void nglPatchParameterfv(int i, long j, long j2);

    static native void nglPatchParameteri(int i, int i2, long j);

    static native void nglPauseTransformFeedback(long j);

    static native void nglResumeTransformFeedback(long j);

    static native void nglUniform1d(int i, double d, long j);

    static native void nglUniform1dv(int i, int i2, long j, long j2);

    static native void nglUniform2d(int i, double d, double d2, long j);

    static native void nglUniform2dv(int i, int i2, long j, long j2);

    static native void nglUniform3d(int i, double d, double d2, double d3, long j);

    static native void nglUniform3dv(int i, int i2, long j, long j2);

    static native void nglUniform4d(int i, double d, double d2, double d3, double d4, long j);

    static native void nglUniform4dv(int i, int i2, long j, long j2);

    static native void nglUniformMatrix2dv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix2x3dv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix2x4dv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix3dv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix3x2dv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix3x4dv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix4dv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix4x2dv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformMatrix4x3dv(int i, int i2, boolean z, long j, long j2);

    static native void nglUniformSubroutinesuiv(int i, int i2, long j, long j2);
}
