package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.PointerWrapper;

public final class KHRDebug {
    public static final int GL_BUFFER = 33504;
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
    public static final int GL_DISPLAY_LIST = 33511;
    public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 33388;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 37188;
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 37187;
    public static final int GL_MAX_LABEL_LENGTH = 33512;
    public static final int GL_PROGRAM = 33506;
    public static final int GL_PROGRAM_PIPELINE = 33508;
    public static final int GL_QUERY = 33507;
    public static final int GL_SAMPLER = 33510;
    public static final int GL_SHADER = 33505;
    public static final int GL_STACK_OVERFLOW = 1283;
    public static final int GL_STACK_UNDERFLOW = 1284;

    private KHRDebug() {
    }

    public static void glDebugMessageCallback(KHRDebugCallback kHRDebugCallback) {
        GL43.glDebugMessageCallback(kHRDebugCallback);
    }

    public static void glDebugMessageControl(int i, int i2, int i3, IntBuffer intBuffer, boolean z) {
        GL43.glDebugMessageControl(i, i2, i3, intBuffer, z);
    }

    public static void glDebugMessageInsert(int i, int i2, int i3, int i4, CharSequence charSequence) {
        GL43.glDebugMessageInsert(i, i2, i3, i4, charSequence);
    }

    public static void glDebugMessageInsert(int i, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        GL43.glDebugMessageInsert(i, i2, i3, i4, byteBuffer);
    }

    public static int glGetDebugMessageLog(int i, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, IntBuffer intBuffer4, IntBuffer intBuffer5, ByteBuffer byteBuffer) {
        return GL43.glGetDebugMessageLog(i, intBuffer, intBuffer2, intBuffer3, intBuffer4, intBuffer5, byteBuffer);
    }

    public static String glGetObjectLabel(int i, int i2, int i3) {
        return GL43.glGetObjectLabel(i, i2, i3);
    }

    public static void glGetObjectLabel(int i, int i2, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        GL43.glGetObjectLabel(i, i2, intBuffer, byteBuffer);
    }

    public static String glGetObjectPtrLabel(PointerWrapper pointerWrapper, int i) {
        return GL43.glGetObjectPtrLabel(pointerWrapper, i);
    }

    public static void glGetObjectPtrLabel(PointerWrapper pointerWrapper, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        GL43.glGetObjectPtrLabel(pointerWrapper, intBuffer, byteBuffer);
    }

    public static void glObjectLabel(int i, int i2, CharSequence charSequence) {
        GL43.glObjectLabel(i, i2, charSequence);
    }

    public static void glObjectLabel(int i, int i2, ByteBuffer byteBuffer) {
        GL43.glObjectLabel(i, i2, byteBuffer);
    }

    public static void glObjectPtrLabel(PointerWrapper pointerWrapper, CharSequence charSequence) {
        GL43.glObjectPtrLabel(pointerWrapper, charSequence);
    }

    public static void glObjectPtrLabel(PointerWrapper pointerWrapper, ByteBuffer byteBuffer) {
        GL43.glObjectPtrLabel(pointerWrapper, byteBuffer);
    }

    public static void glPopDebugGroup() {
        GL43.glPopDebugGroup();
    }

    public static void glPushDebugGroup(int i, int i2, CharSequence charSequence) {
        GL43.glPushDebugGroup(i, i2, charSequence);
    }

    public static void glPushDebugGroup(int i, int i2, ByteBuffer byteBuffer) {
        GL43.glPushDebugGroup(i, i2, byteBuffer);
    }
}
