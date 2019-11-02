package org.lwjgl.opengl;

import java.nio.IntBuffer;
import java.nio.LongBuffer;

public final class ARBSync {
    public static final int GL_ALREADY_SIGNALED = 37146;
    public static final int GL_CONDITION_SATISFIED = 37148;
    public static final int GL_MAX_SERVER_WAIT_TIMEOUT = 37137;
    public static final int GL_OBJECT_TYPE = 37138;
    public static final int GL_SIGNALED = 37145;
    public static final int GL_SYNC_CONDITION = 37139;
    public static final int GL_SYNC_FENCE = 37142;
    public static final int GL_SYNC_FLAGS = 37141;
    public static final int GL_SYNC_FLUSH_COMMANDS_BIT = 1;
    public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 37143;
    public static final int GL_SYNC_STATUS = 37140;
    public static final int GL_TIMEOUT_EXPIRED = 37147;
    public static final long GL_TIMEOUT_IGNORED = -1;
    public static final int GL_UNSIGNALED = 37144;
    public static final int GL_WAIT_FAILED = 37149;

    private ARBSync() {
    }

    public static int glClientWaitSync(GLSync gLSync, int i, long j) {
        return GL32.glClientWaitSync(gLSync, i, j);
    }

    public static void glDeleteSync(GLSync gLSync) {
        GL32.glDeleteSync(gLSync);
    }

    public static GLSync glFenceSync(int i, int i2) {
        return GL32.glFenceSync(i, i2);
    }

    public static long glGetInteger64(int i) {
        return GL32.glGetInteger64(i);
    }

    public static void glGetInteger64(int i, LongBuffer longBuffer) {
        GL32.glGetInteger64(i, longBuffer);
    }

    @Deprecated
    public static int glGetSync(GLSync gLSync, int i) {
        return GL32.glGetSynci(gLSync, i);
    }

    public static void glGetSync(GLSync gLSync, int i, IntBuffer intBuffer, IntBuffer intBuffer2) {
        GL32.glGetSync(gLSync, i, intBuffer, intBuffer2);
    }

    public static int glGetSynci(GLSync gLSync, int i) {
        return GL32.glGetSynci(gLSync, i);
    }

    public static boolean glIsSync(GLSync gLSync) {
        return GL32.glIsSync(gLSync);
    }

    public static void glWaitSync(GLSync gLSync, int i, long j) {
        GL32.glWaitSync(gLSync, i, j);
    }
}
