package org.lwjgl.test.openal;

import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import net.zhuoweizhang.boardwalk.com.android.dex.DexFormat;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.C0758AL;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.Display;

public abstract class BasicTest {
    protected BasicTest() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        try {
            C0758AL.create();
            PrintStream printStream = System.out;
            StringBuilder sb4 = sb2;
            StringBuilder sb5 = new StringBuilder();
            printStream.println(sb4.append("Default device: ").append(ALC10.alcGetString(null, 4100)).toString());
            if (ALC10.alcIsExtensionPresent(null, "ALC_ENUMERATION_EXT")) {
                String[] split = ALC10.alcGetString(null, 4101).split(DexFormat.MAGIC_SUFFIX);
                System.out.println("Available devices: ");
                for (int i = 0; i < split.length; i++) {
                    PrintStream printStream2 = System.out;
                    StringBuilder sb6 = sb3;
                    StringBuilder sb7 = new StringBuilder();
                    printStream2.println(sb6.append(i).append(": ").append(split[i]).toString());
                }
            }
        } catch (Exception e) {
            Exception exc = e;
            PrintStream printStream3 = System.out;
            StringBuilder sb8 = sb;
            StringBuilder sb9 = new StringBuilder();
            printStream3.println(sb8.append("Unable to create OpenAL.\nPlease make sure that OpenAL is available on this system. Exception: ").append(exc).toString());
        }
    }

    /* access modifiers changed from: protected */
    public void alExit() {
        if (C0758AL.isCreated()) {
            C0758AL.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public FloatBuffer createFloatBuffer(float[] fArr) {
        float[] fArr2 = fArr;
        FloatBuffer put = BufferUtils.createFloatBuffer(fArr2.length).put(fArr2);
        Buffer flip = put.flip();
        return put;
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

    /* access modifiers changed from: protected */
    public void pause(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
        }
    }

    /* access modifiers changed from: protected */
    public boolean setDisplayMode() {
        StringBuilder sb;
        try {
            DisplayMode[] availableDisplayModes = Display.getAvailableDisplayModes(PositionTest.WINDOW_WIDTH, 480, -1, -1, -1, -1, 60, 60);
            String[] strArr = new String[4];
            strArr[0] = "width=640";
            strArr[1] = "height=480";
            strArr[2] = "freq=60";
            String[] strArr2 = strArr;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            strArr2[3] = sb2.append("bpp=").append(org.lwjgl.opengl.Display.getDisplayMode().getBitsPerPixel()).toString();
            DisplayMode displayMode = Display.setDisplayMode(availableDisplayModes, strArr);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
