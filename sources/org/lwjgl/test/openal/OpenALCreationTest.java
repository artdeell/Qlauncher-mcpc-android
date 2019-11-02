package org.lwjgl.test.openal;

import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.C0758AL;
import org.lwjgl.util.WaveData;

public class OpenALCreationTest {
    public OpenALCreationTest() {
    }

    private void executeAudioTest() {
        IntBuffer createIntBuffer = createIntBuffer(1);
        IntBuffer createIntBuffer2 = createIntBuffer(1);
        Buffer limit = createIntBuffer.position(0).limit(1);
        AL10.alGenBuffers(createIntBuffer);
        int alGetError = AL10.alGetError();
        if (alGetError != 0) {
            exit(alGetError);
        }
        Buffer limit2 = createIntBuffer2.position(0).limit(1);
        AL10.alGenSources(createIntBuffer2);
        int alGetError2 = AL10.alGetError();
        if (alGetError2 != 0) {
            exit(alGetError2);
        }
        WaveData create = WaveData.create("Footsteps.wav");
        AL10.alBufferData(createIntBuffer.get(0), create.format, create.data, create.samplerate);
        int alGetError3 = AL10.alGetError();
        if (alGetError3 != 0) {
            exit(alGetError3);
        }
        create.dispose();
        AL10.alSourcei(createIntBuffer2.get(0), 4105, createIntBuffer.get(0));
        int alGetError4 = AL10.alGetError();
        if (alGetError4 != 0) {
            exit(alGetError4);
        }
        AL10.alSourcei(createIntBuffer2.get(0), 4103, 1);
        int alGetError5 = AL10.alGetError();
        if (alGetError5 != 0) {
            exit(alGetError5);
        }
        AL10.alSourcePlay(createIntBuffer2.get(0));
        int alGetError6 = AL10.alGetError();
        if (alGetError6 != 0) {
            exit(alGetError6);
        }
        try {
            System.out.print("Playing 'Footsteps.wav' for 2 seconds...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
        }
        System.out.println("done");
        AL10.alSourceStop(createIntBuffer2.get(0));
        int alGetError7 = AL10.alGetError();
        if (alGetError7 != 0) {
            exit(alGetError7);
        }
        Buffer limit3 = createIntBuffer2.position(0).limit(1);
        AL10.alDeleteSources(createIntBuffer2);
        int alGetError8 = AL10.alGetError();
        if (alGetError8 != 0) {
            exit(alGetError8);
        }
        Buffer limit4 = createIntBuffer.position(0).limit(1);
        AL10.alDeleteBuffers(createIntBuffer);
        int alGetError9 = AL10.alGetError();
        if (alGetError9 != 0) {
            exit(alGetError9);
        }
    }

    public static void main(String[] strArr) {
        OpenALCreationTest openALCreationTest;
        String[] strArr2 = strArr;
        OpenALCreationTest openALCreationTest2 = openALCreationTest;
        OpenALCreationTest openALCreationTest3 = new OpenALCreationTest();
        openALCreationTest2.execute(strArr2);
        System.exit(0);
    }

    public void alExit() {
        C0758AL.destroy();
    }

    public void alInitialize() {
        try {
            C0758AL.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public IntBuffer createIntBuffer(int i) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 4);
        ByteBuffer order = allocateDirect.order(ByteOrder.nativeOrder());
        return allocateDirect.asIntBuffer();
    }

    /* access modifiers changed from: protected */
    public void execute(String[] strArr) {
        String[] strArr2 = strArr;
        System.out.print("initialize...");
        alInitialize();
        System.out.println("success");
        executeAudioTest();
        System.out.print("shutdown...");
        alExit();
        System.out.println("success");
        System.out.print("initialize...");
        alInitialize();
        System.out.println("success");
        executeAudioTest();
        System.out.print("shutdown...");
        alExit();
        System.out.println("success");
    }

    /* access modifiers changed from: protected */
    public void exit(int i) {
        StringBuilder sb;
        int i2 = i;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("OpenAL Error: ").append(AL10.alGetString(i2)).toString());
        alExit();
        System.exit(-1);
    }
}
