package org.lwjgl.test.input;

import java.io.PrintStream;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.test.openal.PositionTest;
import org.lwjgl.util.vector.Vector2f;

public class MouseCreationTest {
    private Vector2f position;

    public MouseCreationTest() {
        Vector2f vector2f;
        Vector2f vector2f2 = vector2f;
        Vector2f vector2f3 = new Vector2f(320.0f, 240.0f);
        this.position = vector2f2;
    }

    private void initialize(boolean z) {
        boolean z2 = z;
        try {
            boolean displayMode = setDisplayMode();
            Display.setFullscreen(z2);
            Display.create();
            Mouse.setGrabbed(true);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        initializeOpenGL();
    }

    private void initializeOpenGL() {
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, (double) Display.getDisplayMode().getWidth(), 0.0d, (double) Display.getDisplayMode().getHeight(), -1.0d, 1.0d);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glViewport(0, 0, Display.getDisplayMode().getWidth(), Display.getDisplayMode().getHeight());
    }

    public static void main(String[] strArr) {
        MouseCreationTest mouseCreationTest;
        String[] strArr2 = strArr;
        MouseCreationTest mouseCreationTest2 = mouseCreationTest;
        MouseCreationTest mouseCreationTest3 = new MouseCreationTest();
        mouseCreationTest2.executeTest();
        System.exit(0);
    }

    private void render() {
        GL11.glClear(16384);
        GL11.glBegin(9);
        float f = 1.0f;
        int i = 0;
        while (true) {
            if (i >= Mouse.getButtonCount()) {
                break;
            } else if (Mouse.isButtonDown(i)) {
                f = (1.0f / ((float) Mouse.getButtonCount())) * ((float) (i + 1));
                break;
            } else {
                i++;
            }
        }
        GL11.glColor3f(f, f, f);
        GL11.glVertex2f(0.0f + this.position.f259x, 0.0f + this.position.f260y);
        GL11.glVertex2f(0.0f + this.position.f259x, 30.0f + this.position.f260y);
        GL11.glVertex2f(40.0f + this.position.f259x, 30.0f + this.position.f260y);
        GL11.glVertex2f(60.0f + this.position.f259x, 15.0f + this.position.f260y);
        GL11.glVertex2f(40.0f + this.position.f259x, 0.0f + this.position.f260y);
        GL11.glEnd();
    }

    private void wiggleMouse() {
        System.out.print("Please move the mouse around");
        long time = Sys.getTime();
        long time2 = Sys.getTime() + (5 * Sys.getTimerResolution());
        while (Sys.getTime() < time2) {
            Display.update();
            do {
            } while (Mouse.next());
            this.position.f259x += (float) Mouse.getDX();
            this.position.f260y += (float) Mouse.getDY();
            if (this.position.f259x < 0.0f) {
                this.position.f259x = 0.0f;
            } else if (this.position.f259x > 580.0f) {
                this.position.f259x = 580.0f;
            }
            if (this.position.f260y < 0.0f) {
                this.position.f260y = 0.0f;
            } else if (this.position.f260y > 450.0f) {
                this.position.f260y = 450.0f;
            }
            render();
            if (Sys.getTime() - time > Sys.getTimerResolution()) {
                System.out.print(".");
                time = Sys.getTime();
            }
        }
        System.out.println("thank you");
    }

    public void executeTest() {
        StringBuilder sb;
        StringBuilder sb2;
        initialize(false);
        System.out.println("Test ready:\n");
        System.out.println("=========== WINDOWED MODE ==============");
        for (int i = 0; i < 2; i++) {
            PrintStream printStream = System.out;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            printStream.println(sb3.append("Test ").append(i + 1).append(":").toString());
            wiggleMouse();
            System.out.println(LibrariesRepository.MOJANG_MAVEN_REPO);
        }
        System.out.print("Destroying display...");
        System.out.println("success");
        System.out.print("Entering fullscreen mode...");
        try {
            Display.destroy();
            initialize(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("success");
        System.out.println("=========== FULLSCREEN MODE ==============");
        for (int i2 = 0; i2 < 2; i2++) {
            PrintStream printStream2 = System.out;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            printStream2.println(sb5.append("Test ").append(i2 + 3).append(":").toString());
            wiggleMouse();
            System.out.println(LibrariesRepository.MOJANG_MAVEN_REPO);
        }
        System.out.println("Test completed successfully!");
        System.out.print("Shutting down...");
        Display.destroy();
        System.out.println("shutdown complete");
    }

    /* access modifiers changed from: protected */
    public boolean setDisplayMode() {
        StringBuilder sb;
        try {
            DisplayMode[] availableDisplayModes = org.lwjgl.util.Display.getAvailableDisplayModes(PositionTest.WINDOW_WIDTH, 480, -1, -1, -1, -1, 60, 60);
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
