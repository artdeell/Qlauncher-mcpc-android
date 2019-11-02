package org.lwjgl.test.openal;

import java.io.PrintStream;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map.Entry;
import net.zhuoweizhang.boardwalk.com.android.dex.DexFormat;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.ALC11;
import org.lwjgl.openal.ALCdevice;
import org.lwjgl.openal.C0758AL;
import org.lwjgl.openal.EFX10;
import org.lwjgl.openal.EFXUtil;

public class OpenALInfo {
    public OpenALInfo() {
    }

    private void checkForErrors() {
        ALCdevice alcGetContextsDevice = ALC10.alcGetContextsDevice(ALC10.alcGetCurrentContext());
        int alcGetError = ALC10.alcGetError(alcGetContextsDevice);
        if (alcGetError != 0) {
            die("ALC", ALC10.alcGetString(alcGetContextsDevice, alcGetError));
        }
        int alGetError = AL10.alGetError();
        if (alGetError != 0) {
            die("AL", AL10.alGetString(alGetError));
        }
    }

    private void die(String str, String str2) {
        StringBuilder sb;
        String str3 = str;
        String str4 = str2;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append(str3).append(" error ").append(str4).append(" occured").toString());
    }

    public static void main(String[] strArr) {
        OpenALInfo openALInfo;
        String[] strArr2 = strArr;
        OpenALInfo openALInfo2 = openALInfo;
        OpenALInfo openALInfo3 = new OpenALInfo();
        openALInfo2.execute(strArr2);
        System.exit(0);
    }

    private void printALCInfo() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        IntBuffer createIntBuffer = BufferUtils.createIntBuffer(2);
        if (ALC10.alcIsExtensionPresent(null, "ALC_ENUMERATION_EXT")) {
            if (ALC10.alcIsExtensionPresent(null, "ALC_ENUMERATE_ALL_EXT")) {
                printDevices(4115, "playback");
            } else {
                printDevices(4101, "playback");
            }
            printDevices(ALC11.ALC_CAPTURE_DEVICE_SPECIFIER, "capture");
        } else {
            System.out.println("No device enumeration available");
        }
        ALCdevice alcGetContextsDevice = ALC10.alcGetContextsDevice(ALC10.alcGetCurrentContext());
        checkForErrors();
        PrintStream printStream = System.out;
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        printStream.println(sb5.append("Default playback device: ").append(ALC10.alcGetString(alcGetContextsDevice, 4100)).toString());
        PrintStream printStream2 = System.out;
        StringBuilder sb7 = sb2;
        StringBuilder sb8 = new StringBuilder();
        printStream2.println(sb7.append("Default capture device: ").append(ALC10.alcGetString(alcGetContextsDevice, ALC11.ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER)).toString());
        ALC10.alcGetInteger(C0758AL.getDevice(), 4096, createIntBuffer);
        ALC10.alcGetInteger(C0758AL.getDevice(), 4097, (IntBuffer) createIntBuffer.position(1));
        checkForErrors();
        PrintStream printStream3 = System.out;
        StringBuilder sb9 = sb3;
        StringBuilder sb10 = new StringBuilder();
        printStream3.println(sb9.append("ALC version: ").append(createIntBuffer.get(0)).append(".").append(createIntBuffer.get(1)).toString());
        System.out.println("ALC extensions:");
        String[] split = ALC10.alcGetString(alcGetContextsDevice, 4102).split(" ");
        int length = split.length;
        for (int i = 0; i < length; i++) {
            String str = split[i];
            if (str.trim().length() != 0) {
                PrintStream printStream4 = System.out;
                StringBuilder sb11 = sb4;
                StringBuilder sb12 = new StringBuilder();
                printStream4.println(sb11.append("    ").append(str).toString());
            }
        }
        checkForErrors();
    }

    private void printALInfo() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        PrintStream printStream = System.out;
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        printStream.println(sb5.append("OpenAL vendor string: ").append(AL10.alGetString(AL10.AL_VENDOR)).toString());
        PrintStream printStream2 = System.out;
        StringBuilder sb7 = sb2;
        StringBuilder sb8 = new StringBuilder();
        printStream2.println(sb7.append("OpenAL renderer string: ").append(AL10.alGetString(AL10.AL_RENDERER)).toString());
        PrintStream printStream3 = System.out;
        StringBuilder sb9 = sb3;
        StringBuilder sb10 = new StringBuilder();
        printStream3.println(sb9.append("OpenAL version string: ").append(AL10.alGetString(AL10.AL_VERSION)).toString());
        System.out.println("AL extensions:");
        String[] split = AL10.alGetString(AL10.AL_EXTENSIONS).split(" ");
        int length = split.length;
        for (int i = 0; i < length; i++) {
            String str = split[i];
            if (str.trim().length() != 0) {
                PrintStream printStream4 = System.out;
                StringBuilder sb11 = sb4;
                StringBuilder sb12 = new StringBuilder();
                printStream4.println(sb11.append("    ").append(str).toString());
            }
        }
        checkForErrors();
    }

    private void printDevices(int i, String str) {
        StringBuilder sb;
        StringBuilder sb2;
        String str2 = str;
        String[] split = ALC10.alcGetString(null, i).split(DexFormat.MAGIC_SUFFIX);
        checkForErrors();
        PrintStream printStream = System.out;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        printStream.println(sb3.append("Available ").append(str2).append(" devices: ").toString());
        int length = split.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str3 = split[i2];
            PrintStream printStream2 = System.out;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            printStream2.println(sb5.append("    ").append(str3).toString());
        }
    }

    private void printEFXInfo() {
        HashMap hashMap;
        HashMap hashMap2;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        if (!EFXUtil.isEfxSupported()) {
            System.out.println("EFX not available");
            return;
        }
        ALCdevice device = C0758AL.getDevice();
        IntBuffer createIntBuffer = BufferUtils.createIntBuffer(1);
        IntBuffer createIntBuffer2 = BufferUtils.createIntBuffer(1);
        IntBuffer createIntBuffer3 = BufferUtils.createIntBuffer(1);
        ALC10.alcGetInteger(device, EFX10.ALC_EFX_MAJOR_VERSION, createIntBuffer);
        ALC10.alcGetInteger(device, EFX10.ALC_EFX_MINOR_VERSION, createIntBuffer2);
        if (ALC10.alcGetError(device) == 0) {
            PrintStream printStream = System.out;
            StringBuilder sb5 = sb4;
            StringBuilder sb6 = new StringBuilder();
            printStream.println(sb5.append("EFX version: ").append(createIntBuffer.get()).append(".").append(createIntBuffer2.get()).toString());
        }
        ALC10.alcGetInteger(device, EFX10.ALC_MAX_AUXILIARY_SENDS, createIntBuffer3);
        if (ALC10.alcGetError(device) == 0) {
            PrintStream printStream2 = System.out;
            StringBuilder sb7 = sb3;
            StringBuilder sb8 = new StringBuilder();
            printStream2.println(sb7.append("Max auxiliary sends: ").append(createIntBuffer3.get()).toString());
        }
        System.out.println("Supported filters: ");
        HashMap hashMap3 = hashMap;
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = hashMap3;
        Object put = hashMap5.put("Low-pass", Integer.valueOf(1));
        Object put2 = hashMap5.put("High-pass", Integer.valueOf(2));
        Object put3 = hashMap5.put("Band-pass", Integer.valueOf(3));
        for (Entry entry : hashMap5.entrySet()) {
            String str = (String) entry.getKey();
            if (EFXUtil.isFilterSupported(((Integer) entry.getValue()).intValue())) {
                PrintStream printStream3 = System.out;
                StringBuilder sb9 = sb2;
                StringBuilder sb10 = new StringBuilder();
                printStream3.println(sb9.append("    ").append((String) entry.getKey()).toString());
            }
        }
        System.out.println("Supported effects: ");
        HashMap hashMap6 = hashMap2;
        HashMap hashMap7 = new HashMap();
        HashMap hashMap8 = hashMap6;
        Object put4 = hashMap8.put("EAX Reverb", Integer.valueOf(32768));
        Object put5 = hashMap8.put("Reverb", Integer.valueOf(1));
        Object put6 = hashMap8.put("Chorus", Integer.valueOf(2));
        Object put7 = hashMap8.put("Distortion", Integer.valueOf(3));
        Object put8 = hashMap8.put("Echo", Integer.valueOf(4));
        Object put9 = hashMap8.put("Flanger", Integer.valueOf(5));
        Object put10 = hashMap8.put("Frequency Shifter", Integer.valueOf(6));
        Object put11 = hashMap8.put("Vocal Morpher", Integer.valueOf(7));
        Object put12 = hashMap8.put("Pitch Shifter", Integer.valueOf(8));
        Object put13 = hashMap8.put("Ring Modulator", Integer.valueOf(9));
        Object put14 = hashMap8.put("Autowah", Integer.valueOf(10));
        Object put15 = hashMap8.put("Compressor", Integer.valueOf(11));
        Object put16 = hashMap8.put("Equalizer", Integer.valueOf(12));
        for (Entry entry2 : hashMap8.entrySet()) {
            if (EFXUtil.isEffectSupported(((Integer) entry2.getValue()).intValue())) {
                PrintStream printStream4 = System.out;
                StringBuilder sb11 = sb;
                StringBuilder sb12 = new StringBuilder();
                printStream4.println(sb11.append("    ").append((String) entry2.getKey()).toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void execute(String[] strArr) {
        String[] strArr2 = strArr;
        try {
            C0758AL.create(null, -1, 60, false);
            checkForErrors();
        } catch (LWJGLException e) {
            die("Init", e.getMessage());
        }
        printALCInfo();
        printALInfo();
        printEFXInfo();
        checkForErrors();
        C0758AL.destroy();
    }
}
