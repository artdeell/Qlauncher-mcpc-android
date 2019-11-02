package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBDebugOutput {
    public static final int GL_DEBUG_CALLBACK_FUNCTION_ARB = 33348;
    public static final int GL_DEBUG_CALLBACK_USER_PARAM_ARB = 33349;
    public static final int GL_DEBUG_LOGGED_MESSAGES_ARB = 37189;
    public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH_ARB = 33347;
    public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS_ARB = 33346;
    public static final int GL_DEBUG_SEVERITY_HIGH_ARB = 37190;
    public static final int GL_DEBUG_SEVERITY_LOW_ARB = 37192;
    public static final int GL_DEBUG_SEVERITY_MEDIUM_ARB = 37191;
    public static final int GL_DEBUG_SOURCE_API_ARB = 33350;
    public static final int GL_DEBUG_SOURCE_APPLICATION_ARB = 33354;
    public static final int GL_DEBUG_SOURCE_OTHER_ARB = 33355;
    public static final int GL_DEBUG_SOURCE_SHADER_COMPILER_ARB = 33352;
    public static final int GL_DEBUG_SOURCE_THIRD_PARTY_ARB = 33353;
    public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM_ARB = 33351;
    public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR_ARB = 33357;
    public static final int GL_DEBUG_TYPE_ERROR_ARB = 33356;
    public static final int GL_DEBUG_TYPE_OTHER_ARB = 33361;
    public static final int GL_DEBUG_TYPE_PERFORMANCE_ARB = 33360;
    public static final int GL_DEBUG_TYPE_PORTABILITY_ARB = 33359;
    public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR_ARB = 33358;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES_ARB = 37188;
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH_ARB = 37187;

    private ARBDebugOutput() {
    }

    public static void glDebugMessageCallbackARB(ARBDebugOutputCallback aRBDebugOutputCallback) {
        ARBDebugOutputCallback aRBDebugOutputCallback2 = aRBDebugOutputCallback;
        long j = 0;
        long j2 = GLContext.getCapabilities().glDebugMessageCallbackARB;
        BufferChecks.checkFunctionAddress(j2);
        long createGlobalRef = aRBDebugOutputCallback2 == null ? 0 : CallbackUtil.createGlobalRef(aRBDebugOutputCallback2.getHandler());
        CallbackUtil.registerContextCallbackARB(createGlobalRef);
        if (aRBDebugOutputCallback2 != null) {
            j = aRBDebugOutputCallback2.getPointer();
        }
        nglDebugMessageCallbackARB(j, createGlobalRef, j2);
    }

    public static void glDebugMessageControlARB(int i, int i2, int i3, IntBuffer intBuffer, boolean z) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glDebugMessageControlARB;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkDirect(intBuffer2);
        }
        nglDebugMessageControlARB(i4, i5, i6, intBuffer2 == null ? 0 : intBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), z2, j);
    }

    public static void glDebugMessageInsertARB(int i, int i2, int i3, int i4, CharSequence charSequence) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDebugMessageInsertARB;
        BufferChecks.checkFunctionAddress(j);
        nglDebugMessageInsertARB(i5, i6, i7, i8, charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), j);
    }

    public static void glDebugMessageInsertARB(int i, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glDebugMessageInsertARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglDebugMessageInsertARB(i5, i6, i7, i8, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetDebugMessageLogARB(int i, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, IntBuffer intBuffer4, IntBuffer intBuffer5, ByteBuffer byteBuffer) {
        int i2 = i;
        IntBuffer intBuffer6 = intBuffer;
        IntBuffer intBuffer7 = intBuffer2;
        IntBuffer intBuffer8 = intBuffer3;
        IntBuffer intBuffer9 = intBuffer4;
        IntBuffer intBuffer10 = intBuffer5;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetDebugMessageLogARB;
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
        return nglGetDebugMessageLogARB(i2, byteBuffer2 == null ? 0 : byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer6), MemoryUtil.getAddressSafe(intBuffer7), MemoryUtil.getAddressSafe(intBuffer8), MemoryUtil.getAddressSafe(intBuffer9), MemoryUtil.getAddressSafe(intBuffer10), MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    static native void nglDebugMessageCallbackARB(long j, long j2, long j3);

    static native void nglDebugMessageControlARB(int i, int i2, int i3, int i4, long j, boolean z, long j2);

    static native void nglDebugMessageInsertARB(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native int nglGetDebugMessageLogARB(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
}
