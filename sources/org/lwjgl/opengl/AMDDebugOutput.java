package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class AMDDebugOutput {
    public static final int GL_DEBUG_CATEGORY_API_ERROR_AMD = 37193;
    public static final int GL_DEBUG_CATEGORY_APPLICATION_AMD = 37199;
    public static final int GL_DEBUG_CATEGORY_DEPRECATION_AMD = 37195;
    public static final int GL_DEBUG_CATEGORY_OTHER_AMD = 37200;
    public static final int GL_DEBUG_CATEGORY_PERFORMANCE_AMD = 37197;
    public static final int GL_DEBUG_CATEGORY_SHADER_COMPILER_AMD = 37198;
    public static final int GL_DEBUG_CATEGORY_UNDEFINED_BEHAVIOR_AMD = 37196;
    public static final int GL_DEBUG_CATEGORY_WINDOW_SYSTEM_AMD = 37194;
    public static final int GL_DEBUG_LOGGED_MESSAGES_AMD = 37189;
    public static final int GL_DEBUG_SEVERITY_HIGH_AMD = 37190;
    public static final int GL_DEBUG_SEVERITY_LOW_AMD = 37192;
    public static final int GL_DEBUG_SEVERITY_MEDIUM_AMD = 37191;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES_AMD = 37188;
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH_AMD = 37187;

    private AMDDebugOutput() {
    }

    public static void glDebugMessageCallbackAMD(AMDDebugOutputCallback aMDDebugOutputCallback) {
        AMDDebugOutputCallback aMDDebugOutputCallback2 = aMDDebugOutputCallback;
        long j = 0;
        long j2 = GLContext.getCapabilities().glDebugMessageCallbackAMD;
        BufferChecks.checkFunctionAddress(j2);
        long createGlobalRef = aMDDebugOutputCallback2 == null ? 0 : CallbackUtil.createGlobalRef(aMDDebugOutputCallback2.getHandler());
        CallbackUtil.registerContextCallbackAMD(createGlobalRef);
        if (aMDDebugOutputCallback2 != null) {
            j = aMDDebugOutputCallback2.getPointer();
        }
        nglDebugMessageCallbackAMD(j, createGlobalRef, j2);
    }

    public static void glDebugMessageEnableAMD(int i, int i2, IntBuffer intBuffer, boolean z) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glDebugMessageEnableAMD;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkDirect(intBuffer2);
        }
        nglDebugMessageEnableAMD(i3, i4, intBuffer2 == null ? 0 : intBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), z2, j);
    }

    public static void glDebugMessageInsertAMD(int i, int i2, int i3, CharSequence charSequence) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDebugMessageInsertAMD;
        BufferChecks.checkFunctionAddress(j);
        nglDebugMessageInsertAMD(i4, i5, i6, charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), j);
    }

    public static void glDebugMessageInsertAMD(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glDebugMessageInsertAMD;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglDebugMessageInsertAMD(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetDebugMessageLogAMD(int i, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, IntBuffer intBuffer4, ByteBuffer byteBuffer) {
        int i2 = i;
        IntBuffer intBuffer5 = intBuffer;
        IntBuffer intBuffer6 = intBuffer2;
        IntBuffer intBuffer7 = intBuffer3;
        IntBuffer intBuffer8 = intBuffer4;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetDebugMessageLogAMD;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer5 != null) {
            BufferChecks.checkBuffer(intBuffer5, i2);
        }
        if (intBuffer6 != null) {
            BufferChecks.checkBuffer(intBuffer6, i2);
        }
        if (intBuffer7 != null) {
            BufferChecks.checkBuffer(intBuffer7, i2);
        }
        if (intBuffer8 != null) {
            BufferChecks.checkBuffer(intBuffer8, i2);
        }
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        return nglGetDebugMessageLogAMD(i2, byteBuffer2 == null ? 0 : byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer5), MemoryUtil.getAddressSafe(intBuffer6), MemoryUtil.getAddressSafe(intBuffer7), MemoryUtil.getAddressSafe(intBuffer8), MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    static native void nglDebugMessageCallbackAMD(long j, long j2, long j3);

    static native void nglDebugMessageEnableAMD(int i, int i2, int i3, long j, boolean z, long j2);

    static native void nglDebugMessageInsertAMD(int i, int i2, int i3, int i4, long j, long j2);

    static native int nglGetDebugMessageLogAMD(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6);
}
