package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLException;
import org.lwjgl.MemoryUtil;

public final class ALC10 {
    public static final int ALC_ALL_ATTRIBUTES = 4099;
    public static final int ALC_ATTRIBUTES_SIZE = 4098;
    public static final int ALC_DEFAULT_DEVICE_SPECIFIER = 4100;
    public static final int ALC_DEVICE_SPECIFIER = 4101;
    public static final int ALC_EXTENSIONS = 4102;
    public static final int ALC_FALSE = 0;
    public static final int ALC_FREQUENCY = 4103;
    public static final int ALC_INVALID = 0;
    public static final int ALC_INVALID_CONTEXT = 40962;
    public static final int ALC_INVALID_DEVICE = 40961;
    public static final int ALC_INVALID_ENUM = 40963;
    public static final int ALC_INVALID_VALUE = 40964;
    public static final int ALC_MAJOR_VERSION = 4096;
    public static final int ALC_MINOR_VERSION = 4097;
    public static final int ALC_NO_ERROR = 0;
    public static final int ALC_OUT_OF_MEMORY = 40965;
    public static final int ALC_REFRESH = 4104;
    public static final int ALC_SYNC = 4105;
    public static final int ALC_TRUE = 1;
    static final HashMap<Long, ALCcontext> contexts;
    static final HashMap<Long, ALCdevice> devices;

    static {
        HashMap<Long, ALCcontext> hashMap;
        HashMap<Long, ALCdevice> hashMap2;
        HashMap<Long, ALCcontext> hashMap3 = hashMap;
        HashMap<Long, ALCcontext> hashMap4 = new HashMap<>();
        contexts = hashMap3;
        HashMap<Long, ALCdevice> hashMap5 = hashMap2;
        HashMap<Long, ALCdevice> hashMap6 = new HashMap<>();
        devices = hashMap5;
    }

    public ALC10() {
    }

    public static boolean alcCloseDevice(ALCdevice aLCdevice) {
        Long l;
        ALCdevice aLCdevice2 = aLCdevice;
        th = nalcCloseDevice(getDevice(aLCdevice2));
        HashMap<Long, ALCdevice> hashMap = devices;
        synchronized (hashMap) {
            try {
                aLCdevice2.setInvalid();
                HashMap<Long, ALCdevice> hashMap2 = devices;
                Long l2 = l;
                Long l3 = new Long(aLCdevice2.device);
                Object remove = hashMap2.remove(l2);
            } finally {
                Throwable th = th;
                HashMap<Long, ALCdevice> hashMap3 = hashMap;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static ALCcontext alcCreateContext(ALCdevice aLCdevice, IntBuffer intBuffer) {
        ALCcontext aLCcontext;
        ALCdevice aLCdevice2 = aLCdevice;
        long nalcCreateContext = nalcCreateContext(getDevice(aLCdevice2), MemoryUtil.getAddressSafe(intBuffer));
        Util.checkALCError(aLCdevice2);
        if (nalcCreateContext == 0) {
            return null;
        }
        ALCcontext aLCcontext2 = aLCcontext;
        ALCcontext aLCcontext3 = new ALCcontext(nalcCreateContext);
        th = aLCcontext2;
        HashMap<Long, ALCcontext> hashMap = contexts;
        synchronized (hashMap) {
            try {
                Object put = contexts.put(Long.valueOf(nalcCreateContext), th);
                aLCdevice2.addContext(th);
            } finally {
                Throwable th = th;
                HashMap<Long, ALCcontext> hashMap2 = hashMap;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static void alcDestroyContext(ALCcontext aLCcontext) {
        ALCcontext aLCcontext2 = aLCcontext;
        HashMap<Long, ALCcontext> hashMap = contexts;
        synchronized (hashMap) {
            try {
                ALCdevice alcGetContextsDevice = alcGetContextsDevice(aLCcontext2);
                nalcDestroyContext(getContext(aLCcontext2));
                alcGetContextsDevice.removeContext(aLCcontext2);
                aLCcontext2.setInvalid();
            } catch (Throwable th) {
                Throwable th2 = th;
                HashMap<Long, ALCcontext> hashMap2 = hashMap;
                throw th2;
            }
        }
    }

    public static ALCdevice alcGetContextsDevice(ALCcontext aLCcontext) {
        long nalcGetContextsDevice = nalcGetContextsDevice(getContext(aLCcontext));
        if (nalcGetContextsDevice == 0) {
            return null;
        }
        ALCdevice aLCdevice = devices;
        synchronized (aLCdevice) {
            try {
                th = (ALCdevice) devices.get(Long.valueOf(nalcGetContextsDevice));
            } finally {
                Throwable th = th;
                ALCdevice aLCdevice2 = aLCdevice;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static ALCcontext alcGetCurrentContext() {
        long nalcGetCurrentContext = nalcGetCurrentContext();
        if (nalcGetCurrentContext == 0) {
            return null;
        }
        ALCcontext aLCcontext = contexts;
        synchronized (aLCcontext) {
            try {
                th = (ALCcontext) contexts.get(Long.valueOf(nalcGetCurrentContext));
            } finally {
                Throwable th = th;
                ALCcontext aLCcontext2 = aLCcontext;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static int alcGetEnumValue(ALCdevice aLCdevice, String str) {
        ALCdevice aLCdevice2 = aLCdevice;
        int nalcGetEnumValue = nalcGetEnumValue(getDevice(aLCdevice2), MemoryUtil.getAddress(MemoryUtil.encodeASCII(str)));
        Util.checkALCError(aLCdevice2);
        return nalcGetEnumValue;
    }

    public static int alcGetError(ALCdevice aLCdevice) {
        return nalcGetError(getDevice(aLCdevice));
    }

    public static void alcGetInteger(ALCdevice aLCdevice, int i, IntBuffer intBuffer) {
        ALCdevice aLCdevice2 = aLCdevice;
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        BufferChecks.checkDirect(intBuffer2);
        nalcGetIntegerv(getDevice(aLCdevice2), i2, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2));
        Util.checkALCError(aLCdevice2);
    }

    public static String alcGetString(ALCdevice aLCdevice, int i) {
        ALCdevice aLCdevice2 = aLCdevice;
        ByteBuffer nalcGetString = nalcGetString(getDevice(aLCdevice2), i);
        Util.checkALCError(aLCdevice2);
        return MemoryUtil.decodeUTF8(nalcGetString);
    }

    public static boolean alcIsExtensionPresent(ALCdevice aLCdevice, String str) {
        ALCdevice aLCdevice2 = aLCdevice;
        boolean nalcIsExtensionPresent = nalcIsExtensionPresent(getDevice(aLCdevice2), MemoryUtil.getAddress(MemoryUtil.encodeASCII(str)));
        Util.checkALCError(aLCdevice2);
        return nalcIsExtensionPresent;
    }

    public static int alcMakeContextCurrent(ALCcontext aLCcontext) {
        return nalcMakeContextCurrent(getContext(aLCcontext));
    }

    public static ALCdevice alcOpenDevice(String str) {
        ALCdevice aLCdevice;
        long nalcOpenDevice = nalcOpenDevice(MemoryUtil.getAddressSafe(MemoryUtil.encodeUTF8(str)));
        if (nalcOpenDevice == 0) {
            return null;
        }
        ALCdevice aLCdevice2 = aLCdevice;
        ALCdevice aLCdevice3 = new ALCdevice(nalcOpenDevice);
        th = aLCdevice2;
        HashMap<Long, ALCdevice> hashMap = devices;
        synchronized (hashMap) {
            try {
                Object put = devices.put(Long.valueOf(nalcOpenDevice), th);
            } finally {
                Throwable th = th;
                HashMap<Long, ALCdevice> hashMap2 = hashMap;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static void alcProcessContext(ALCcontext aLCcontext) {
        nalcProcessContext(getContext(aLCcontext));
    }

    public static void alcSuspendContext(ALCcontext aLCcontext) {
        nalcSuspendContext(getContext(aLCcontext));
    }

    static long getContext(ALCcontext aLCcontext) {
        ALCcontext aLCcontext2 = aLCcontext;
        if (aLCcontext2 == null) {
            return 0;
        }
        Util.checkALCValidContext(aLCcontext2);
        return aLCcontext2.context;
    }

    static long getDevice(ALCdevice aLCdevice) {
        ALCdevice aLCdevice2 = aLCdevice;
        if (aLCdevice2 == null) {
            return 0;
        }
        Util.checkALCValidDevice(aLCdevice2);
        return aLCdevice2.device;
    }

    static native void initNativeStubs() throws LWJGLException;

    static native boolean nalcCloseDevice(long j);

    static native long nalcCreateContext(long j, long j2);

    static native void nalcDestroyContext(long j);

    static native long nalcGetContextsDevice(long j);

    static native long nalcGetCurrentContext();

    private static native int nalcGetEnumValue(long j, long j2);

    static native int nalcGetError(long j);

    static native void nalcGetIntegerv(long j, int i, int i2, long j2);

    static native ByteBuffer nalcGetString(long j, int i);

    private static native boolean nalcIsExtensionPresent(long j, long j2);

    static native int nalcMakeContextCurrent(long j);

    static native long nalcOpenDevice(long j);

    static native void nalcProcessContext(long j);

    static native void nalcSuspendContext(long j);
}
