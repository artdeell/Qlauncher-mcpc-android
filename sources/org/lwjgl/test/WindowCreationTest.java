package org.lwjgl.test;

import java.io.PrintStream;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.test.openal.PositionTest;

public class WindowCreationTest {
    private float color = 0.0f;
    private int direction = 1;
    private DisplayMode[] fixed_modes = new DisplayMode[10];
    private boolean fullscreen;
    private DisplayMode[] located_modes;
    private boolean running;
    private int window_x;
    private int window_y;

    public WindowCreationTest() {
    }

    private void execute() {
        this.running = true;
        while (!Display.isCloseRequested() && this.running) {
            handleInput();
            render();
            Display.update();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void findFixedModes() {
        this.fixed_modes[0] = getDisplayMode(PositionTest.WINDOW_WIDTH, 480, 16, -1);
        this.fixed_modes[1] = getDisplayMode(PositionTest.WINDOW_WIDTH, 480, 24, -1);
        this.fixed_modes[2] = getDisplayMode(PositionTest.WINDOW_WIDTH, 480, 32, -1);
        this.fixed_modes[3] = getDisplayMode(800, 600, 16, -1);
        this.fixed_modes[4] = getDisplayMode(800, 600, 24, -1);
        this.fixed_modes[5] = getDisplayMode(800, 600, 32, -1);
        this.fixed_modes[6] = getDisplayMode(1024, 768, 16, -1);
        this.fixed_modes[7] = getDisplayMode(1024, 768, 24, -1);
        this.fixed_modes[8] = getDisplayMode(1024, 768, 32, -1);
    }

    private DisplayMode getDisplayMode(int i, int i2, int i3, int i4) {
        StringBuilder sb;
        StringBuilder sb2;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        DisplayMode[] displayModeArr = null;
        try {
            displayModeArr = org.lwjgl.util.Display.getAvailableDisplayModes(i5, i6, i5, i6, i7, i7, i8, i8);
            if (displayModeArr == null || displayModeArr.length == 0) {
                PrintStream printStream = System.out;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                printStream.println(sb3.append("Problem retrieving mode with ").append(i5).append("x").append(i6).append("x").append(i7).append("@").append(i8).toString());
            }
        } catch (LWJGLException e) {
            e.printStackTrace();
            PrintStream printStream2 = System.out;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            printStream2.println(sb5.append("Problem retrieving mode with ").append(i5).append("x").append(i6).append("x").append(i7).append("@").append(i8).toString());
        }
        if (displayModeArr == null || displayModeArr.length == 0) {
            return null;
        }
        return displayModeArr[0];
    }

    private void handleInput() {
        StringBuilder sb;
        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                if (Keyboard.getEventKey() == 1) {
                    this.running = false;
                }
                if (Keyboard.getEventKey() == 38) {
                    for (int i = 0; i < this.fixed_modes.length; i++) {
                        PrintStream printStream = System.out;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        printStream.println(sb2.append("[").append(i).append("]: ").append(this.fixed_modes[i]).toString());
                    }
                }
                if (Keyboard.getEventKey() == 11) {
                    setMode(0);
                }
                if (Keyboard.getEventKey() == 2) {
                    setMode(1);
                }
                if (Keyboard.getEventKey() == 3) {
                    setMode(2);
                }
                if (Keyboard.getEventKey() == 4) {
                    setMode(3);
                }
                if (Keyboard.getEventKey() == 5) {
                    setMode(4);
                }
                if (Keyboard.getEventKey() == 6) {
                    setMode(5);
                }
                if (Keyboard.getEventKey() == 7) {
                    setMode(6);
                }
                if (Keyboard.getEventKey() == 8) {
                    setMode(7);
                }
                if (Keyboard.getEventKey() == 9) {
                    setMode(8);
                }
                if (Keyboard.getEventKey() == 203 && !Display.isFullscreen()) {
                    int i2 = -10 + this.window_x;
                    this.window_x = i2;
                    Display.setLocation(i2, this.window_y);
                }
                if (Keyboard.getEventKey() == 205 && !Display.isFullscreen()) {
                    int i3 = 10 + this.window_x;
                    this.window_x = i3;
                    Display.setLocation(i3, this.window_y);
                }
                if (Keyboard.getEventKey() == 200 && !Display.isFullscreen()) {
                    int i4 = this.window_x;
                    int i5 = -10 + this.window_y;
                    this.window_y = i5;
                    Display.setLocation(i4, i5);
                }
                if (Keyboard.getEventKey() == 208 && !Display.isFullscreen()) {
                    int i6 = this.window_x;
                    int i7 = 10 + this.window_y;
                    this.window_y = i7;
                    Display.setLocation(i6, i7);
                }
                if (Keyboard.getEventKey() == 33) {
                    try {
                        if (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54)) {
                            System.out.println("Performing Display.destroy()/create() cycle");
                            DisplayMode displayMode = Display.getDisplayMode();
                            Display.destroy();
                            Display.setDisplayMode(displayMode);
                            boolean z = !this.fullscreen;
                            this.fullscreen = z;
                            Display.setFullscreen(z);
                            Display.create();
                        } else {
                            boolean z2 = !this.fullscreen;
                            this.fullscreen = z2;
                            Display.setFullscreen(z2);
                        }
                    } catch (LWJGLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] strArr) throws LWJGLException {
        WindowCreationTest windowCreationTest;
        String[] strArr2 = strArr;
        System.out.println("The following keys are available:\nESCAPE:\t\tExit test\nARROW Keys:\tMove window when in non-fullscreen mode\nL:\t\tList selectable display modes\n0-8:\t\tSelection of display modes\nF:\t\tToggle fullscreen\nSHIFT-F:\tToggle fullscreen with Display.destroy()/create() cycle");
        WindowCreationTest windowCreationTest2 = windowCreationTest;
        WindowCreationTest windowCreationTest3 = new WindowCreationTest();
        WindowCreationTest windowCreationTest4 = windowCreationTest2;
        if (windowCreationTest4.initialize()) {
            windowCreationTest4.execute();
            windowCreationTest4.destroy();
        }
        System.exit(0);
    }

    private void render() {
        GL11.glClearColor(this.color, this.color, this.color, 1.0f);
        GL11.glClear(16384);
        this.color += 0.05f * ((float) this.direction);
        if (this.color > 1.0f) {
            this.color = 1.0f;
            this.direction = -1 * this.direction;
        } else if (this.color < 0.0f) {
            this.direction = -1 * this.direction;
            this.color = 0.0f;
        }
    }

    private void setMode(int i) {
        StringBuilder sb;
        StringBuilder sb2;
        int i2 = i;
        if (this.fixed_modes[i2] == null) {
            PrintStream printStream = System.out;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            printStream.println(sb3.append("Unable to set mode. Not valid: ").append(i2).toString());
            return;
        }
        try {
            Display.setDisplayMode(this.fixed_modes[i2]);
        } catch (LWJGLException e) {
            e.printStackTrace();
            PrintStream printStream2 = System.out;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            printStream2.println(sb5.append("Exception while setting mode: ").append(this.fixed_modes[i2]).toString());
        }
    }

    public void destroy() {
        Display.destroy();
    }

    public boolean initialize() {
        StringBuilder sb;
        try {
            this.located_modes = Display.getAvailableDisplayModes();
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("Found ").append(this.located_modes.length).append(" display modes").toString());
            findFixedModes();
            boolean defaultDisplayMode = setDefaultDisplayMode();
            this.window_y = 100;
            this.window_x = 100;
            Display.setLocation(this.window_x, this.window_y);
            Display.create();
            return true;
        } catch (LWJGLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean setDefaultDisplayMode() {
        StringBuilder sb;
        try {
            DisplayMode[] availableDisplayModes = org.lwjgl.util.Display.getAvailableDisplayModes(PositionTest.WINDOW_WIDTH, 480, -1, -1, -1, -1, -1, -1);
            String[] strArr = new String[4];
            strArr[0] = "width=640";
            strArr[1] = "height=480";
            strArr[2] = "freq=60";
            String[] strArr2 = strArr;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            strArr2[3] = sb2.append("bpp=").append(Display.getDisplayMode().getBitsPerPixel()).toString();
            DisplayMode displayMode = org.lwjgl.util.Display.setDisplayMode(availableDisplayModes, strArr);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
