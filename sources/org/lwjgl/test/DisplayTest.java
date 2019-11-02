package org.lwjgl.test;

import java.io.PrintStream;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class DisplayTest {
    public DisplayTest() {
    }

    private void changeConfig(float f, float f2, float f3) {
        StringBuilder sb;
        StringBuilder sb2;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        try {
            Display.setDisplayConfiguration(f4, f5, f6);
            PrintStream printStream = System.out;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            printStream.println(sb3.append("Configuration changed, gamma = ").append(f4).append(" brightness = ").append(f5).append(" contrast = ").append(f6).toString());
        } catch (Exception e) {
            Exception exc = e;
            PrintStream printStream2 = System.out;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            printStream2.println(sb5.append("Failed on: gamma = ").append(f4).append(" brightness = ").append(f5).append(" contrast = ").append(f6).toString());
        }
        pause(3000);
    }

    private void currentTest() {
        StringBuilder sb;
        StringBuilder sb2;
        System.out.println("==== Test Current ====");
        System.out.println("Info about current:");
        PrintStream printStream = System.out;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        printStream.println(sb3.append("Graphics card: ").append(Display.getAdapter()).append(", version: ").append(Display.getVersion()).toString());
        PrintStream printStream2 = System.out;
        StringBuilder sb5 = sb2;
        StringBuilder sb6 = new StringBuilder();
        printStream2.println(sb5.append("Resolution: ").append(Display.getDisplayMode().getWidth()).append("x").append(Display.getDisplayMode().getHeight()).append("x").append(Display.getDisplayMode().getBitsPerPixel()).append("@").append(Display.getDisplayMode().getFrequency()).append("Hz").toString());
        System.out.println("---- Test Current ----");
    }

    public static void main(String[] strArr) throws LWJGLException {
        DisplayTest displayTest;
        String[] strArr2 = strArr;
        DisplayTest displayTest2 = displayTest;
        DisplayTest displayTest3 = new DisplayTest();
        displayTest2.executeTest();
        System.exit(0);
    }

    private void pause(long j) {
        long j2 = j;
        for (int i = 0; ((long) i) < j2; i += 100) {
            try {
                Display.processMessages();
                Thread.sleep((long) 100);
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
            }
        }
    }

    private void queryModesTest() throws LWJGLException {
        StringBuilder sb;
        System.out.println("==== Test query ====");
        System.out.println("Retrieving available displaymodes");
        DisplayMode[] availableDisplayModes = Display.getAvailableDisplayModes();
        if (availableDisplayModes == null) {
            System.out.println("FATAL: unable to find any modes!");
            System.exit(-1);
        }
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("Found ").append(availableDisplayModes.length).append(" modes").toString());
        System.out.println("The first 5 are:");
        for (int i = 0; i < availableDisplayModes.length; i++) {
            System.out.println(availableDisplayModes[i]);
            if (i == 5) {
                break;
            }
        }
        System.out.println("---- Test query ----");
    }

    private void setDisplayConfigurationTest() {
        System.out.println("==== Test setDisplayConfigurationTest ====");
        System.out.println("Testing normal setting");
        changeConfig(1.0f, 0.0f, 1.0f);
        System.out.println("Testing gamma settings");
        changeConfig(5.0f, 0.0f, 1.0f);
        changeConfig(0.5f, 0.0f, 1.0f);
        System.out.println("Testing brightness settings");
        changeConfig(1.0f, -1.0f, 1.0f);
        changeConfig(1.0f, -0.5f, 1.0f);
        changeConfig(1.0f, 0.5f, 1.0f);
        changeConfig(1.0f, 1.0f, 1.0f);
        System.out.println("Testing contrast settings");
        changeConfig(1.0f, 0.0f, 0.0f);
        changeConfig(1.0f, 0.0f, 0.5f);
        changeConfig(1.0f, 0.0f, 10000.0f);
        System.out.print("resetting...");
        try {
            Display.setFullscreen(false);
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        System.out.println("done");
        System.out.println("---- Test setDisplayConfigurationTest ----");
    }

    private void setDisplayModeTest() throws LWJGLException {
        DisplayMode displayMode;
        StringBuilder sb;
        System.out.println("==== Test setDisplayMode ====");
        System.out.println("Retrieving available displaymodes");
        DisplayMode[] availableDisplayModes = Display.getAvailableDisplayModes();
        if (availableDisplayModes == null) {
            System.out.println("FATAL: unable to find any modes!");
            System.exit(-1);
        }
        System.out.print("Looking for 640x480...");
        int length = availableDisplayModes.length;
        int i = 0;
        while (true) {
            displayMode = null;
            if (i >= length) {
                break;
            }
            DisplayMode displayMode2 = availableDisplayModes[i];
            if (displayMode2.getWidth() == 640 && displayMode2.getHeight() == 480) {
                displayMode = displayMode2;
                System.out.println("found!");
                break;
            }
            i++;
        }
        if (displayMode == null) {
            System.out.println("error\nFATAL: Unable to find basic mode.");
            System.exit(-1);
        }
        System.out.print("Changing to mode...");
        try {
            Display.setDisplayMode(displayMode);
            Display.setFullscreen(true);
            Display.create();
        } catch (Exception e) {
            Exception exc = e;
            System.out.println("error\nFATAL: Error setting mode");
            System.exit(-1);
        }
        System.out.println("done");
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("Resolution: ").append(Display.getDisplayMode().getWidth()).append("x").append(Display.getDisplayMode().getHeight()).append("x").append(Display.getDisplayMode().getBitsPerPixel()).append("@").append(Display.getDisplayMode().getFrequency()).append("Hz").toString());
        pause(5000);
        System.out.print("Resetting mode...");
        try {
            Display.setFullscreen(false);
        } catch (LWJGLException e2) {
            e2.printStackTrace();
        }
        System.out.println("done");
        System.out.println("---- Test setDisplayMode ----");
    }

    public void executeTest() throws LWJGLException {
        currentTest();
        queryModesTest();
        setDisplayModeTest();
        setDisplayConfigurationTest();
    }
}
