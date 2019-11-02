package org.lwjgl.openal;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class ALC11 {
    public static final int ALC_ALL_DEVICES_SPECIFIER = 4115;
    public static final int ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER = 785;
    public static final int ALC_CAPTURE_DEVICE_SPECIFIER = 784;
    public static final int ALC_CAPTURE_SAMPLES = 786;
    public static final int ALC_DEFAULT_ALL_DEVICES_SPECIFIER = 4114;
    public static final int ALC_MONO_SOURCES = 4112;
    public static final int ALC_STEREO_SOURCES = 4113;

    public ALC11() {
    }

    public static boolean alcCaptureCloseDevice(ALCdevice aLCdevice) {
        Long l;
        ALCdevice aLCdevice2 = aLCdevice;
        th = nalcCaptureCloseDevice(ALC10.getDevice(aLCdevice2));
        HashMap<Long, ALCdevice> hashMap = ALC10.devices;
        synchronized (hashMap) {
            try {
                aLCdevice2.setInvalid();
                HashMap<Long, ALCdevice> hashMap2 = ALC10.devices;
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

    public static ALCdevice alcCaptureOpenDevice(String str, int i, int i2, int i3) {
        ALCdevice aLCdevice;
        long nalcCaptureOpenDevice = nalcCaptureOpenDevice(MemoryUtil.getAddressSafe(MemoryUtil.encodeASCII(str)), i, i2, i3);
        if (nalcCaptureOpenDevice == 0) {
            return null;
        }
        ALCdevice aLCdevice2 = aLCdevice;
        ALCdevice aLCdevice3 = new ALCdevice(nalcCaptureOpenDevice);
        th = aLCdevice2;
        HashMap<Long, ALCdevice> hashMap = ALC10.devices;
        synchronized (hashMap) {
            try {
                Object put = ALC10.devices.put(Long.valueOf(nalcCaptureOpenDevice), th);
            } finally {
                Throwable th = th;
                HashMap<Long, ALCdevice> hashMap2 = hashMap;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public static void alcCaptureSamples(ALCdevice aLCdevice, ByteBuffer byteBuffer, int i) {
        int i2 = i;
        nalcCaptureSamples(ALC10.getDevice(aLCdevice), MemoryUtil.getAddress(byteBuffer), i2);
    }

    public static void alcCaptureStart(ALCdevice aLCdevice) {
        nalcCaptureStart(ALC10.getDevice(aLCdevice));
    }

    public static void alcCaptureStop(ALCdevice aLCdevice) {
        nalcCaptureStop(ALC10.getDevice(aLCdevice));
    }

    static native void initNativeStubs() throws LWJGLException;

    static boolean initialize() {
        StringBuilder sb;
        try {
            IntBuffer createIntBuffer = BufferUtils.createIntBuffer(2);
            ALC10.alcGetInteger(C0758AL.getDevice(), 4096, createIntBuffer);
            Buffer position = createIntBuffer.position(1);
            ALC10.alcGetInteger(C0758AL.getDevice(), 4097, createIntBuffer);
            int i = createIntBuffer.get(0);
            int i2 = createIntBuffer.get(1);
            if (i >= 1 && (i > 1 || i2 >= 1)) {
                initNativeStubs();
                AL11.initNativeStubs();
            }
            return true;
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("failed to initialize ALC11: ").append(lWJGLException).toString());
            return false;
        }
    }

    static native boolean nalcCaptureCloseDevice(long j);

    private static native long nalcCaptureOpenDevice(long j, int i, int i2, int i3);

    static native void nalcCaptureSamples(long j, long j2, int i);

    static native void nalcCaptureStart(long j);

    static native void nalcCaptureStop(long j);
}
