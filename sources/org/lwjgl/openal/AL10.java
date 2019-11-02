package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLException;
import org.lwjgl.MemoryUtil;

public final class AL10 {
    public static final int AL_BITS = 8194;
    public static final int AL_BUFFER = 4105;
    public static final int AL_BUFFERS_PROCESSED = 4118;
    public static final int AL_BUFFERS_QUEUED = 4117;
    public static final int AL_CHANNELS = 8195;
    public static final int AL_CHANNEL_MASK = 12288;
    public static final int AL_CONE_INNER_ANGLE = 4097;
    public static final int AL_CONE_OUTER_ANGLE = 4098;
    public static final int AL_CONE_OUTER_GAIN = 4130;
    public static final int AL_DATA = 8197;
    public static final int AL_DIRECTION = 4101;
    public static final int AL_DISTANCE_MODEL = 53248;
    public static final int AL_DOPPLER_FACTOR = 49152;
    public static final int AL_DOPPLER_VELOCITY = 49153;
    public static final int AL_EXTENSIONS = 45060;
    public static final int AL_FALSE = 0;
    public static final int AL_FORMAT_MONO16 = 4353;
    public static final int AL_FORMAT_MONO8 = 4352;
    public static final int AL_FORMAT_STEREO16 = 4355;
    public static final int AL_FORMAT_STEREO8 = 4354;
    public static final int AL_FORMAT_VORBIS_EXT = 65539;
    public static final int AL_FREQUENCY = 8193;
    public static final int AL_GAIN = 4106;
    public static final int AL_INITIAL = 4113;
    public static final int AL_INVALID = -1;
    public static final int AL_INVALID_ENUM = 40962;
    public static final int AL_INVALID_NAME = 40961;
    public static final int AL_INVALID_OPERATION = 40964;
    public static final int AL_INVALID_VALUE = 40963;
    public static final int AL_INVERSE_DISTANCE = 53249;
    public static final int AL_INVERSE_DISTANCE_CLAMPED = 53250;
    public static final int AL_LOOPING = 4103;
    public static final int AL_MAX_DISTANCE = 4131;
    public static final int AL_MAX_GAIN = 4110;
    public static final int AL_MIN_GAIN = 4109;
    public static final int AL_NONE = 0;
    public static final int AL_NO_ERROR = 0;
    public static final int AL_ORIENTATION = 4111;
    public static final int AL_OUT_OF_MEMORY = 40965;
    public static final int AL_PAUSED = 4115;
    public static final int AL_PENDING = 8209;
    public static final int AL_PITCH = 4099;
    public static final int AL_PLAYING = 4114;
    public static final int AL_POSITION = 4100;
    public static final int AL_PROCESSED = 8210;
    public static final int AL_REFERENCE_DISTANCE = 4128;
    public static final int AL_RENDERER = 45059;
    public static final int AL_ROLLOFF_FACTOR = 4129;
    public static final int AL_SIZE = 8196;
    public static final int AL_SOURCE_ABSOLUTE = 513;
    public static final int AL_SOURCE_RELATIVE = 514;
    public static final int AL_SOURCE_STATE = 4112;
    public static final int AL_SOURCE_TYPE = 4135;
    public static final int AL_STOPPED = 4116;
    public static final int AL_TRUE = 1;
    public static final int AL_UNUSED = 8208;
    public static final int AL_VELOCITY = 4102;
    public static final int AL_VENDOR = 45057;
    public static final int AL_VERSION = 45058;

    private AL10() {
    }

    public static void alBufferData(int i, int i2, ByteBuffer byteBuffer, int i3) {
        int i4 = i;
        int i5 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i6 = i3;
        BufferChecks.checkDirect(byteBuffer2);
        nalBufferData(i4, i5, MemoryUtil.getAddress(byteBuffer2), byteBuffer2.remaining(), i6);
    }

    public static void alBufferData(int i, int i2, IntBuffer intBuffer, int i3) {
        int i4 = i;
        int i5 = i2;
        IntBuffer intBuffer2 = intBuffer;
        int i6 = i3;
        BufferChecks.checkDirect(intBuffer2);
        nalBufferData(i4, i5, MemoryUtil.getAddress(intBuffer2), intBuffer2.remaining() << 2, i6);
    }

    public static void alBufferData(int i, int i2, ShortBuffer shortBuffer, int i3) {
        int i4 = i;
        int i5 = i2;
        ShortBuffer shortBuffer2 = shortBuffer;
        int i6 = i3;
        BufferChecks.checkDirect(shortBuffer2);
        nalBufferData(i4, i5, MemoryUtil.getAddress(shortBuffer2), shortBuffer2.remaining() << 1, i6);
    }

    public static void alDeleteBuffers(int i) {
        nalDeleteBuffers2(1, i);
    }

    public static void alDeleteBuffers(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkDirect(intBuffer2);
        nalDeleteBuffers(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2));
    }

    public static void alDeleteSources(int i) {
        nalDeleteSources2(1, i);
    }

    public static void alDeleteSources(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkDirect(intBuffer2);
        nalDeleteSources(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2));
    }

    public static void alDisable(int i) {
        nalDisable(i);
    }

    public static void alDistanceModel(int i) {
        nalDistanceModel(i);
    }

    public static void alDopplerFactor(float f) {
        nalDopplerFactor(f);
    }

    public static void alDopplerVelocity(float f) {
        nalDopplerVelocity(f);
    }

    public static void alEnable(int i) {
        nalEnable(i);
    }

    public static int alGenBuffers() {
        return nalGenBuffers2(1);
    }

    public static void alGenBuffers(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkDirect(intBuffer2);
        nalGenBuffers(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2));
    }

    public static int alGenSources() {
        return nalGenSources2(1);
    }

    public static void alGenSources(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkDirect(intBuffer2);
        nalGenSources(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2));
    }

    public static boolean alGetBoolean(int i) {
        return nalGetBoolean(i);
    }

    public static float alGetBufferf(int i, int i2) {
        return nalGetBufferf(i, i2);
    }

    public static int alGetBufferi(int i, int i2) {
        return nalGetBufferi(i, i2);
    }

    public static double alGetDouble(int i) {
        return nalGetDouble(i);
    }

    public static void alGetDouble(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        BufferChecks.checkBuffer(doubleBuffer2, 1);
        nalGetDoublev(i2, MemoryUtil.getAddress(doubleBuffer2));
    }

    public static int alGetEnumValue(String str) {
        String str2 = str;
        BufferChecks.checkNotNull(str2);
        return nalGetEnumValue(str2);
    }

    public static int alGetError() {
        return nalGetError();
    }

    public static float alGetFloat(int i) {
        return nalGetFloat(i);
    }

    public static void alGetFloat(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        BufferChecks.checkBuffer(floatBuffer2, 1);
        nalGetFloatv(i2, MemoryUtil.getAddress(floatBuffer2));
    }

    public static int alGetInteger(int i) {
        return nalGetInteger(i);
    }

    public static void alGetInteger(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkBuffer(intBuffer2, 1);
        nalGetIntegerv(i2, MemoryUtil.getAddress(intBuffer2));
    }

    public static void alGetListener(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        BufferChecks.checkBuffer(floatBuffer2, 1);
        nalGetListenerfv(i2, MemoryUtil.getAddress(floatBuffer2));
    }

    public static float alGetListenerf(int i) {
        return nalGetListenerf(i);
    }

    public static int alGetListeneri(int i) {
        return nalGetListeneri(i);
    }

    public static void alGetSource(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        BufferChecks.checkBuffer(floatBuffer2, 1);
        nalGetSourcefv(i3, i4, MemoryUtil.getAddress(floatBuffer2));
    }

    public static float alGetSourcef(int i, int i2) {
        return nalGetSourcef(i, i2);
    }

    public static int alGetSourcei(int i, int i2) {
        return nalGetSourcei(i, i2);
    }

    public static String alGetString(int i) {
        return nalGetString(i);
    }

    public static boolean alIsBuffer(int i) {
        return nalIsBuffer(i);
    }

    public static boolean alIsEnabled(int i) {
        return nalIsEnabled(i);
    }

    public static boolean alIsExtensionPresent(String str) {
        String str2 = str;
        BufferChecks.checkNotNull(str2);
        return nalIsExtensionPresent(str2);
    }

    public static boolean alIsSource(int i) {
        return nalIsSource(i);
    }

    public static void alListener(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        BufferChecks.checkBuffer(floatBuffer2, 1);
        nalListenerfv(i2, MemoryUtil.getAddress(floatBuffer2));
    }

    public static void alListener3f(int i, float f, float f2, float f3) {
        nalListener3f(i, f, f2, f3);
    }

    public static void alListenerf(int i, float f) {
        nalListenerf(i, f);
    }

    public static void alListeneri(int i, int i2) {
        nalListeneri(i, i2);
    }

    public static void alSource(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        BufferChecks.checkBuffer(floatBuffer2, 1);
        nalSourcefv(i3, i4, MemoryUtil.getAddress(floatBuffer2));
    }

    public static void alSource3f(int i, int i2, float f, float f2, float f3) {
        nalSource3f(i, i2, f, f2, f3);
    }

    public static void alSourcePause(int i) {
        nalSourcePause(i);
    }

    public static void alSourcePause(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkDirect(intBuffer2);
        nalSourcePausev(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2));
    }

    public static void alSourcePlay(int i) {
        nalSourcePlay(i);
    }

    public static void alSourcePlay(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkDirect(intBuffer2);
        nalSourcePlayv(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2));
    }

    public static void alSourceQueueBuffers(int i, int i2) {
        nalSourceQueueBuffers2(i, 1, i2);
    }

    public static void alSourceQueueBuffers(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkDirect(intBuffer2);
        nalSourceQueueBuffers(i2, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2));
    }

    public static void alSourceRewind(int i) {
        nalSourceRewind(i);
    }

    public static void alSourceRewind(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkDirect(intBuffer2);
        nalSourceRewindv(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2));
    }

    public static void alSourceStop(int i) {
        nalSourceStop(i);
    }

    public static void alSourceStop(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkDirect(intBuffer2);
        nalSourceStopv(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2));
    }

    public static int alSourceUnqueueBuffers(int i) {
        return nalSourceUnqueueBuffers2(i, 1);
    }

    public static void alSourceUnqueueBuffers(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkDirect(intBuffer2);
        nalSourceUnqueueBuffers(i2, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2));
    }

    public static void alSourcef(int i, int i2, float f) {
        nalSourcef(i, i2, f);
    }

    public static void alSourcei(int i, int i2, int i3) {
        nalSourcei(i, i2, i3);
    }

    static native void initNativeStubs() throws LWJGLException;

    static native void nalBufferData(int i, int i2, long j, int i3, int i4);

    static native void nalDeleteBuffers(int i, long j);

    static native void nalDeleteBuffers2(int i, int i2);

    static native void nalDeleteSources(int i, long j);

    static native void nalDeleteSources2(int i, int i2);

    static native void nalDisable(int i);

    static native void nalDistanceModel(int i);

    static native void nalDopplerFactor(float f);

    static native void nalDopplerVelocity(float f);

    static native void nalEnable(int i);

    static native void nalGenBuffers(int i, long j);

    static native int nalGenBuffers2(int i);

    static native void nalGenSources(int i, long j);

    static native int nalGenSources2(int i);

    static native boolean nalGetBoolean(int i);

    static native float nalGetBufferf(int i, int i2);

    static native int nalGetBufferi(int i, int i2);

    static native double nalGetDouble(int i);

    static native void nalGetDoublev(int i, long j);

    static native int nalGetEnumValue(String str);

    static native int nalGetError();

    static native float nalGetFloat(int i);

    static native void nalGetFloatv(int i, long j);

    static native int nalGetInteger(int i);

    static native void nalGetIntegerv(int i, long j);

    static native float nalGetListenerf(int i);

    static native void nalGetListenerfv(int i, long j);

    static native int nalGetListeneri(int i);

    static native float nalGetSourcef(int i, int i2);

    static native void nalGetSourcefv(int i, int i2, long j);

    static native int nalGetSourcei(int i, int i2);

    static native String nalGetString(int i);

    static native boolean nalIsBuffer(int i);

    static native boolean nalIsEnabled(int i);

    static native boolean nalIsExtensionPresent(String str);

    static native boolean nalIsSource(int i);

    static native void nalListener3f(int i, float f, float f2, float f3);

    static native void nalListenerf(int i, float f);

    static native void nalListenerfv(int i, long j);

    static native void nalListeneri(int i, int i2);

    static native void nalSource3f(int i, int i2, float f, float f2, float f3);

    static native void nalSourcePause(int i);

    static native void nalSourcePausev(int i, long j);

    static native void nalSourcePlay(int i);

    static native void nalSourcePlayv(int i, long j);

    static native void nalSourceQueueBuffers(int i, int i2, long j);

    static native void nalSourceQueueBuffers2(int i, int i2, int i3);

    static native void nalSourceRewind(int i);

    static native void nalSourceRewindv(int i, long j);

    static native void nalSourceStop(int i);

    static native void nalSourceStopv(int i, long j);

    static native void nalSourceUnqueueBuffers(int i, int i2, long j);

    static native int nalSourceUnqueueBuffers2(int i, int i2);

    static native void nalSourcef(int i, int i2, float f);

    static native void nalSourcefv(int i, int i2, long j);

    static native void nalSourcei(int i, int i2, int i3);
}
