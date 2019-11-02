package org.lwjgl.test;

import java.io.PrintStream;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class SysTest {
    public SysTest() {
    }

    private void busyWait(int i, int i2, String str) {
        int i3 = i;
        long time = Sys.getTime() + (Sys.getTimerResolution() * ((long) i2));
        System.out.print(str);
        do {
        } while (Sys.getTime() < time);
        System.out.println("done");
    }

    public static void main(String[] strArr) {
        SysTest sysTest;
        String[] strArr2 = strArr;
        SysTest sysTest2 = sysTest;
        SysTest sysTest3 = new SysTest();
        sysTest2.executeTest();
        System.exit(0);
    }

    private void pause(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
        }
    }

    private void testAlert() {
        System.out.println("==== Test Alert ====");
        System.out.println("Opening native alert window");
        Sys.alert("SysTest", "Hello World!");
        System.out.println("---- Test Alert ----\n");
    }

    private void testClipboard() {
        StringBuilder sb;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("Contents of clipboard: '").append(Sys.getClipboard()).append("'").toString());
    }

    private void testDebug() {
        RuntimeException runtimeException;
        System.out.println("==== Test Debug ====");
        if (LWJGLUtil.DEBUG) {
            LWJGLUtil.log("Debug is enabled, you should now see output from LWJGL during the following tests.");
        } else {
            System.out.println("Debug is not enabled. Please set the org.lwjgl.Sys.debug property to true to enable debugging");
            System.out.println("Example:\n  java -Dorg.lwjgl.util.Debug=true ...");
            System.out.println("You will not see any debug output in the following tests.");
        }
        try {
            DisplayMode[] availableDisplayModes = Display.getAvailableDisplayModes();
            System.out.println("---- Test Debug ----\n");
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(lWJGLException);
            throw runtimeException2;
        }
    }

    private void testTimer() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        long timerResolution = Sys.getTimerResolution();
        long time = Sys.getTime();
        System.out.println("==== Test Timer ====");
        PrintStream printStream = System.out;
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        printStream.println(sb5.append("Resolution of timer (ticks per second): ").append(timerResolution).toString());
        PrintStream printStream2 = System.out;
        StringBuilder sb7 = sb2;
        StringBuilder sb8 = new StringBuilder();
        printStream2.println(sb7.append("Current time: ").append(time).toString());
        System.out.println("Sleeping for 2 seconds, using Thread.sleep()");
        pause(2000);
        long time2 = Sys.getTime();
        PrintStream printStream3 = System.out;
        StringBuilder sb9 = sb3;
        StringBuilder sb10 = new StringBuilder();
        printStream3.println(sb9.append("Current time: ").append(time2).toString());
        PrintStream printStream4 = System.out;
        StringBuilder sb11 = sb4;
        StringBuilder sb12 = new StringBuilder();
        printStream4.println(sb11.append("Actually slept for: ").append(((float) (time2 - time)) / ((float) timerResolution)).append(" seconds").toString());
        System.out.println("---- Test Timer ----\n");
    }

    private void testUrl() {
        System.out.println("==== Test URL ====");
        System.out.println("Opening a browser window to http://www.lwjgl.org");
        boolean openURL = Sys.openURL("http://www.lwjgl.org");
        System.out.println("---- Test URL ----\n");
    }

    public void executeTest() {
        testAlert();
        testDebug();
        testTimer();
        testUrl();
        testClipboard();
    }
}
