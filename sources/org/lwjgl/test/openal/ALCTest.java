package org.lwjgl.test.openal;

import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.C0758AL;

public class ALCTest extends BasicTest {
    public ALCTest() {
    }

    public static void main(String[] strArr) {
        ALCTest aLCTest;
        String[] strArr2 = strArr;
        ALCTest aLCTest2 = aLCTest;
        ALCTest aLCTest3 = new ALCTest();
        aLCTest2.execute(strArr2);
        System.exit(0);
    }

    /* access modifiers changed from: protected */
    public void execute(String[] strArr) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        String[] strArr2 = strArr;
        IntBuffer createIntBuffer = BufferUtils.createIntBuffer(7);
        int alcGetError = ALC10.alcGetError(C0758AL.getDevice());
        if (alcGetError != 0) {
            PrintStream printStream = System.out;
            StringBuilder sb8 = sb7;
            StringBuilder sb9 = new StringBuilder();
            printStream.println(sb8.append("ALC Error: ").append(ALC10.alcGetString(C0758AL.getDevice(), alcGetError)).toString());
            System.exit(-1);
        }
        PrintStream printStream2 = System.out;
        StringBuilder sb10 = sb;
        StringBuilder sb11 = new StringBuilder();
        printStream2.println(sb10.append("DEFAULT_DEVICE_SPECIFIER: ").append(ALC10.alcGetString(C0758AL.getDevice(), 4100)).toString());
        PrintStream printStream3 = System.out;
        StringBuilder sb12 = sb2;
        StringBuilder sb13 = new StringBuilder();
        printStream3.println(sb12.append("DEVICE_SPECIFIER: ").append(ALC10.alcGetString(C0758AL.getDevice(), 4101)).toString());
        PrintStream printStream4 = System.out;
        StringBuilder sb14 = sb3;
        StringBuilder sb15 = new StringBuilder();
        printStream4.println(sb14.append("EXTENSIONS: ").append(ALC10.alcGetString(C0758AL.getDevice(), 4102)).toString());
        Buffer rewind = createIntBuffer.rewind();
        Buffer position = createIntBuffer.position(0);
        ALC10.alcGetInteger(C0758AL.getDevice(), 4096, createIntBuffer);
        ALC10.alcGetInteger(C0758AL.getDevice(), 4097, (IntBuffer) createIntBuffer.position(1));
        PrintStream printStream5 = System.out;
        StringBuilder sb16 = sb4;
        StringBuilder sb17 = new StringBuilder();
        printStream5.println(sb16.append("ALC_MAJOR_VERSION: ").append(createIntBuffer.get(0)).toString());
        PrintStream printStream6 = System.out;
        StringBuilder sb18 = sb5;
        StringBuilder sb19 = new StringBuilder();
        printStream6.println(sb18.append("ALC_MINOR_VERSION: ").append(createIntBuffer.get(1)).toString());
        PrintStream printStream7 = System.out;
        StringBuilder sb20 = sb6;
        StringBuilder sb21 = new StringBuilder();
        printStream7.println(sb20.append("Value of ALC_MAJOR_VERSION: ").append(ALC10.alcGetEnumValue(C0758AL.getDevice(), "ALC_MAJOR_VERSION")).toString());
        alExit();
    }
}
