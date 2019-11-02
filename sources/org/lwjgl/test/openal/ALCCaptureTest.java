package org.lwjgl.test.openal;

import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import net.zhuoweizhang.boardwalk.com.android.dex.DexFormat;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.ALC11;
import org.lwjgl.openal.ALCdevice;
import org.lwjgl.openal.C0758AL;
import org.lwjgl.openal.OpenALException;

public class ALCCaptureTest extends BasicTest {
    public ALCCaptureTest() {
    }

    public static void main(String[] strArr) {
        ALCCaptureTest aLCCaptureTest;
        String[] strArr2 = strArr;
        ALCCaptureTest aLCCaptureTest2 = aLCCaptureTest;
        ALCCaptureTest aLCCaptureTest3 = new ALCCaptureTest();
        aLCCaptureTest2.execute(strArr2);
        System.exit(0);
    }

    /* access modifiers changed from: protected */
    public void execute(String[] strArr) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        OpenALException openALException;
        String[] strArr2 = strArr;
        IntBuffer createIntBuffer = BufferUtils.createIntBuffer(1);
        int i = 44100 * 5;
        ByteBuffer createByteBuffer = BufferUtils.createByteBuffer(441000);
        if (!ALC10.alcIsExtensionPresent(C0758AL.getDevice(), "ALC_EXT_CAPTURE")) {
            OpenALException openALException2 = openALException;
            OpenALException openALException3 = new OpenALException("ALC_EXT_CAPTURE extension not available");
            throw openALException2;
        }
        String[] split = ALC10.alcGetString(null, ALC11.ALC_CAPTURE_DEVICE_SPECIFIER).split(DexFormat.MAGIC_SUFFIX);
        System.out.println("Available Capture Devices: ");
        for (int i2 = 0; i2 < split.length; i2++) {
            PrintStream printStream = System.out;
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            printStream.println(sb4.append(i2).append(": ").append(split[i2]).toString());
        }
        String alcGetString = ALC10.alcGetString(C0758AL.getDevice(), ALC11.ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER);
        PrintStream printStream2 = System.out;
        StringBuilder sb6 = sb;
        StringBuilder sb7 = new StringBuilder();
        printStream2.println(sb6.append("Default capture device: ").append(alcGetString).toString());
        ALCdevice alcCaptureOpenDevice = ALC11.alcCaptureOpenDevice(null, 44100, 4353, i);
        if (alcCaptureOpenDevice != null) {
            PrintStream printStream3 = System.out;
            StringBuilder sb8 = sb2;
            StringBuilder sb9 = new StringBuilder();
            printStream3.print(sb8.append("Recording using ").append(ALC10.alcGetString(alcCaptureOpenDevice, ALC11.ALC_CAPTURE_DEVICE_SPECIFIER)).append("...").toString());
            ALC11.alcCaptureStart(alcCaptureOpenDevice);
            while (createIntBuffer.get(0) < i) {
                pause(1000);
                ALC10.alcGetInteger(alcCaptureOpenDevice, ALC11.ALC_CAPTURE_SAMPLES, createIntBuffer);
            }
            System.out.println("done");
            ALC11.alcCaptureStop(alcCaptureOpenDevice);
            ALC11.alcCaptureSamples(alcCaptureOpenDevice, createByteBuffer, i);
            boolean alcCaptureCloseDevice = ALC11.alcCaptureCloseDevice(alcCaptureOpenDevice);
            IntBuffer createIntBuffer2 = BufferUtils.createIntBuffer(1);
            IntBuffer createIntBuffer3 = BufferUtils.createIntBuffer(1);
            Buffer limit = createIntBuffer2.position(0).limit(1);
            AL10.alGenBuffers(createIntBuffer2);
            Buffer limit2 = createIntBuffer3.position(0).limit(1);
            AL10.alGenSources(createIntBuffer3);
            System.out.print("Playing...");
            AL10.alBufferData(createIntBuffer2.get(0), 4353, createByteBuffer, 44100);
            AL10.alSourcei(createIntBuffer3.get(0), 4105, createIntBuffer2.get(0));
            AL10.alSourcei(createIntBuffer3.get(0), 4103, 0);
            AL10.alSourcePlay(createIntBuffer3.get(0));
            for (int i3 = 4114; i3 == 4114; i3 = AL10.alGetSourcei(createIntBuffer3.get(0), 4112)) {
                pause(100);
            }
            System.out.println("done");
            AL10.alDeleteSources(createIntBuffer3);
            AL10.alDeleteBuffers(createIntBuffer2);
        }
        alExit();
    }
}
