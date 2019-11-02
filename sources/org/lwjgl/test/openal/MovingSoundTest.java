package org.lwjgl.test.openal;

import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.AL10;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.WaveData;
import org.lwjgl.util.vector.Vector3f;

public class MovingSoundTest extends BasicTest {
    public static float MOVEMENT = 50.0f;

    public MovingSoundTest() {
    }

    public static void main(String[] strArr) {
        MovingSoundTest movingSoundTest;
        String[] strArr2 = strArr;
        MovingSoundTest movingSoundTest2 = movingSoundTest;
        MovingSoundTest movingSoundTest3 = new MovingSoundTest();
        movingSoundTest2.execute(strArr2);
        System.exit(0);
    }

    /* access modifiers changed from: protected */
    public void execute(String[] strArr) {
        Vector3f vector3f;
        Vector3f vector3f2;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        String[] strArr2 = strArr;
        if (strArr2.length < 1) {
            System.out.println("no argument supplied, assuming Footsteps.wav");
            strArr2 = new String[1];
            strArr2[0] = "Footsteps.wav";
        }
        try {
            boolean displayMode = setDisplayMode();
            Display.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Vector3f vector3f3 = vector3f;
        Vector3f vector3f4 = new Vector3f();
        Vector3f vector3f5 = vector3f3;
        Vector3f vector3f6 = vector3f2;
        Vector3f vector3f7 = new Vector3f();
        Vector3f vector3f8 = vector3f6;
        try {
            Keyboard.create();
        } catch (Exception e2) {
            e2.printStackTrace();
            exit(-1);
        }
        IntBuffer createIntBuffer = BufferUtils.createIntBuffer(1);
        IntBuffer createIntBuffer2 = BufferUtils.createIntBuffer(1);
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
        WaveData create = WaveData.create(strArr2[0]);
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
        AL10.alSourcef(createIntBuffer2.get(0), 4128, 1024.0f);
        AL10.alSourcef(createIntBuffer2.get(0), 4129, 0.5f);
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
        System.out.println("Move source with arrow keys\nMove listener with right shift and arrowkeys\nExit with ESC");
        while (!Keyboard.isKeyDown(1)) {
            Display.update();
            Keyboard.poll();
            if (Keyboard.isKeyDown(203)) {
                if (Keyboard.isKeyDown(54)) {
                    vector3f8.f261x -= MOVEMENT;
                    AL10.alListener3f(4100, vector3f8.f261x, vector3f8.f262y, vector3f8.f263z);
                    PrintStream printStream = System.out;
                    StringBuilder sb5 = sb4;
                    StringBuilder sb6 = new StringBuilder();
                    printStream.println(sb5.append("listenerx: ").append(vector3f8.f261x).toString());
                } else {
                    vector3f5.f261x -= MOVEMENT;
                    AL10.alSource3f(createIntBuffer2.get(0), 4100, vector3f5.f261x, vector3f5.f262y, vector3f5.f263z);
                    PrintStream printStream2 = System.out;
                    StringBuilder sb7 = sb3;
                    StringBuilder sb8 = new StringBuilder();
                    printStream2.println(sb7.append("sourcex: ").append(vector3f5.f261x).toString());
                }
            }
            if (Keyboard.isKeyDown(205)) {
                if (Keyboard.isKeyDown(54)) {
                    vector3f8.f261x += MOVEMENT;
                    AL10.alListener3f(4100, vector3f8.f261x, vector3f8.f262y, vector3f8.f263z);
                    PrintStream printStream3 = System.out;
                    StringBuilder sb9 = sb2;
                    StringBuilder sb10 = new StringBuilder();
                    printStream3.println(sb9.append("listenerx: ").append(vector3f8.f261x).toString());
                } else {
                    vector3f5.f261x += MOVEMENT;
                    AL10.alSource3f(createIntBuffer2.get(0), 4100, vector3f5.f261x, vector3f5.f262y, vector3f5.f263z);
                    PrintStream printStream4 = System.out;
                    StringBuilder sb11 = sb;
                    StringBuilder sb12 = new StringBuilder();
                    printStream4.println(sb11.append("sourcex: ").append(vector3f5.f261x).toString());
                }
            }
            if (Display.isCloseRequested()) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e3) {
                InterruptedException interruptedException = e3;
            }
        }
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
        alExit();
    }
}
