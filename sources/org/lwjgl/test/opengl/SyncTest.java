package org.lwjgl.test.opengl;

import java.io.PrintStream;
import java.util.Random;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.GLSync;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.test.openal.PositionTest;

public final class SyncTest {
    private SyncTest() {
    }

    private static void argsError(String str) {
        StringBuilder sb;
        String str2 = str;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("\nInvalid arguments error: ").append(str2).toString());
        System.out.println("\nUsage: SyncTest <clears> <timeout>:\n");
        System.out.println("clears\t- Number of times to clear the framebuffer.");
        System.out.println("timeout\t- WaitSync timeout in milliseconds.");
        cleanup();
        System.exit(-1);
    }

    private static DisplayMode chooseMode(DisplayMode[] displayModeArr, int i, int i2) {
        DisplayMode[] displayModeArr2 = displayModeArr;
        int i3 = i;
        int i4 = i2;
        DisplayMode displayMode = null;
        int length = displayModeArr2.length;
        for (int i5 = 0; i5 < length; i5++) {
            DisplayMode displayMode2 = displayModeArr2[i5];
            if (displayMode2.getWidth() == i3 && displayMode2.getHeight() == i4 && displayMode2.getFrequency() <= 85 && (displayMode == null || (displayMode2.getBitsPerPixel() >= displayMode.getBitsPerPixel() && displayMode2.getFrequency() > displayMode.getFrequency()))) {
                displayMode = displayMode2;
            }
        }
        return displayMode;
    }

    private static void cleanup() {
        if (Display.isCreated()) {
            Display.destroy();
        }
    }

    static void kill(String str) {
        StringBuilder sb;
        String str2 = str;
        System.out.println("The SyncTest program was terminated because an error occured.\n");
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder append = sb2.append("Reason: ");
        if (str2 == null) {
            str2 = "Unknown";
        }
        printStream.println(append.append(str2).toString());
        cleanup();
        System.exit(-1);
    }

    public static void main(String[] strArr) {
        runTest(strArr);
        cleanup();
        System.exit(0);
    }

    private static void runTest(String[] strArr) {
        int i;
        ContextAttribs contextAttribs;
        StringBuilder sb;
        StringBuilder sb2;
        Random random;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        PixelFormat pixelFormat;
        String[] strArr2 = strArr;
        if (strArr2.length < 2) {
            argsError("Insufficient number of arguments.");
        }
        int i2 = 1;
        try {
            i2 = Integer.parseInt(strArr2[0]);
            i = Integer.parseInt(strArr2[1]);
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = e;
            argsError("Invalid number format.");
            i = 0;
        }
        ContextAttribs contextAttribs2 = contextAttribs;
        ContextAttribs contextAttribs3 = new ContextAttribs();
        ContextAttribs contextAttribs4 = contextAttribs2;
        try {
            DisplayMode[] availableDisplayModes = Display.getAvailableDisplayModes();
            DisplayMode chooseMode = chooseMode(availableDisplayModes, 1024, 768);
            if (chooseMode == null) {
                chooseMode = chooseMode(availableDisplayModes, 800, 600);
            }
            if (chooseMode == null) {
                chooseMode = chooseMode(availableDisplayModes, PositionTest.WINDOW_WIDTH, 480);
            }
            if (chooseMode == null) {
                kill("Failed to set an appropriate display mode.");
            }
            PrintStream printStream = System.out;
            StringBuilder sb8 = sb7;
            StringBuilder sb9 = new StringBuilder();
            printStream.println(sb8.append("Setting display mode to: ").append(chooseMode).toString());
            Display.setDisplayMode(chooseMode);
            PixelFormat pixelFormat2 = pixelFormat;
            PixelFormat pixelFormat3 = new PixelFormat(8, 24, 0);
            Display.create(pixelFormat2, contextAttribs4);
        } catch (LWJGLException e2) {
            kill(e2.getMessage());
        }
        System.out.println("\n---------\n");
        String glGetString = GL11.glGetString(GL11.GL_VERSION);
        PrintStream printStream2 = System.out;
        StringBuilder sb10 = sb;
        StringBuilder sb11 = new StringBuilder();
        printStream2.println(sb10.append("GL Version: ").append(glGetString).toString());
        PrintStream printStream3 = System.out;
        StringBuilder sb12 = sb2;
        StringBuilder sb13 = new StringBuilder();
        printStream3.println(sb12.append("ARB_sync: ").append(GLContext.getCapabilities().GL_ARB_sync).toString());
        if (!GLContext.getCapabilities().OpenGL32 && !GLContext.getCapabilities().GL_ARB_sync) {
            kill("OpenGL3.2 or ARB_sync support is required for this test.");
        }
        System.out.println("\n---------\n");
        System.out.println("Clearing the framebuffer a gazillion times...");
        Random random2 = random;
        Random random3 = new Random(System.currentTimeMillis());
        Random random4 = random2;
        for (int i3 = 0; i3 < i2; i3++) {
            GL11.glClearColor(random4.nextFloat(), random4.nextFloat(), random4.nextFloat(), 1.0f);
            GL11.glClear(16384);
        }
        GLSync glFenceSync = GL32.glFenceSync(37143, 0);
        System.out.println("\nWaiting on fence...");
        long time = Sys.getTime();
        int glClientWaitSync = GL32.glClientWaitSync(glFenceSync, 0, i < 0 ? -1 : (long) (1000 * 1000 * i));
        PrintStream printStream4 = System.out;
        StringBuilder sb14 = sb3;
        StringBuilder sb15 = new StringBuilder();
        printStream4.println(sb14.append("\nFence sync complete after: ").append(((double) (Sys.getTime() - time)) / ((double) Sys.getTimerResolution())).append(" seconds.").toString());
        System.out.print("\nWait Status: ");
        switch (glClientWaitSync) {
            case 37146:
                System.out.println("ALREADY_SIGNALED");
                break;
            case 37147:
                System.out.println("TIMEOUT_EXPIRED");
                break;
            case 37148:
                System.out.println("CONDITION_SATISFIED");
                break;
            case 37149:
                System.out.println("WAIT_FAILED");
                break;
            default:
                PrintStream printStream5 = System.out;
                StringBuilder sb16 = sb6;
                StringBuilder sb17 = new StringBuilder();
                printStream5.println(sb16.append("Unexpected wait status: 0x").append(Integer.toHexString(glClientWaitSync)).toString());
                break;
        }
        PrintStream printStream6 = System.out;
        StringBuilder sb18 = sb4;
        StringBuilder sb19 = new StringBuilder();
        printStream6.println(sb18.append("Sync Status: ").append(GL32.glGetSynci(glFenceSync, 37140) == 37144 ? "UNSIGNALED" : "SIGNALED").toString());
        GL32.glDeleteSync(glFenceSync);
        int glGetError = GL11.glGetError();
        if (glGetError != 0) {
            PrintStream printStream7 = System.out;
            StringBuilder sb20 = sb5;
            StringBuilder sb21 = new StringBuilder();
            printStream7.println(sb20.append("\nTest failed with OpenGL error: ").append(glGetError).toString());
            return;
        }
        System.out.println("\nTest completed successfully.");
    }
}
