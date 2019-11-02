package org.lwjgl.openal;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLException;
import org.lwjgl.MemoryUtil;

public final class AL11 {
    public static final int AL_BYTE_OFFSET = 4134;
    public static final int AL_EXPONENT_DISTANCE = 53253;
    public static final int AL_EXPONENT_DISTANCE_CLAMPED = 53254;
    public static final int AL_ILLEGAL_COMMAND = 40964;
    public static final int AL_LINEAR_DISTANCE = 53251;
    public static final int AL_LINEAR_DISTANCE_CLAMPED = 53252;
    public static final int AL_SAMPLE_OFFSET = 4133;
    public static final int AL_SEC_OFFSET = 4132;
    public static final int AL_SPEED_OF_SOUND = 49155;
    public static final int AL_STATIC = 4136;
    public static final int AL_STREAMING = 4137;
    public static final int AL_UNDETERMINED = 4144;

    private AL11() {
    }

    public static void alBuffer(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        BufferChecks.checkBuffer(floatBuffer2, 1);
        nalBufferfv(i3, i4, MemoryUtil.getAddress(floatBuffer2));
    }

    public static void alBuffer(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkBuffer(intBuffer2, 1);
        nalBufferiv(i3, i4, MemoryUtil.getAddress(intBuffer2));
    }

    public static void alBuffer3f(int i, int i2, float f, float f2, float f3) {
        nalBuffer3f(i, i2, f, f2, f3);
    }

    public static void alBuffer3i(int i, int i2, int i3, int i4, int i5) {
        nalBuffer3i(i, i2, i3, i4, i5);
    }

    public static void alBufferf(int i, int i2, float f) {
        nalBufferf(i, i2, f);
    }

    public static void alBufferi(int i, int i2, int i3) {
        nalBufferi(i, i2, i3);
    }

    public static void alGetBuffer(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        BufferChecks.checkBuffer(floatBuffer2, 1);
        nalGetBufferfv(i3, i4, MemoryUtil.getAddress(floatBuffer2));
    }

    public static void alGetBuffer(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkBuffer(intBuffer2, 1);
        nalGetBufferiv(i3, i4, MemoryUtil.getAddress(intBuffer2));
    }

    public static float alGetBufferf(int i, int i2) {
        return nalGetBufferf(i, i2);
    }

    public static int alGetBufferi(int i, int i2) {
        return nalGetBufferi(i, i2);
    }

    public static void alGetListeneri(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        BufferChecks.checkBuffer(floatBuffer2, 1);
        nalGetListeneriv(i2, MemoryUtil.getAddress(floatBuffer2));
    }

    public static void alListener3i(int i, int i2, int i3, int i4) {
        nalListener3i(i, i2, i3, i4);
    }

    public static void alSource(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkBuffer(intBuffer2, 1);
        nalSourceiv(i3, i4, MemoryUtil.getAddress(intBuffer2));
    }

    public static void alSource3i(int i, int i2, int i3, int i4, int i5) {
        nalSource3i(i, i2, i3, i4, i5);
    }

    public static void alSpeedOfSound(float f) {
        nalSpeedOfSound(f);
    }

    static native void initNativeStubs() throws LWJGLException;

    static native void nalBuffer3f(int i, int i2, float f, float f2, float f3);

    static native void nalBuffer3i(int i, int i2, int i3, int i4, int i5);

    static native void nalBufferf(int i, int i2, float f);

    static native void nalBufferfv(int i, int i2, long j);

    static native void nalBufferi(int i, int i2, int i3);

    static native void nalBufferiv(int i, int i2, long j);

    static native float nalGetBufferf(int i, int i2);

    static native void nalGetBufferfv(int i, int i2, long j);

    static native int nalGetBufferi(int i, int i2);

    static native void nalGetBufferiv(int i, int i2, long j);

    static native void nalGetListeneriv(int i, long j);

    static native void nalListener3i(int i, int i2, int i3, int i4);

    static native void nalSource3i(int i, int i2, int i3, int i4, int i5);

    static native void nalSourceiv(int i, int i2, long j);

    static native void nalSpeedOfSound(float f);
}
