package org.lwjgl.test.input;

import java.io.PrintStream;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.test.openal.PositionTest;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector2f;

public class KeyboardTest {
    private DisplayMode displayMode;
    private Vector2f position;

    public KeyboardTest() {
        Vector2f vector2f;
        Vector2f vector2f2 = vector2f;
        Vector2f vector2f3 = new Vector2f(320.0f, 240.0f);
        this.position = vector2f2;
    }

    private void createKeyboard() {
        try {
            Keyboard.create();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void initialize() {
        setupDisplay(false);
        try {
            Keyboard.create();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void initializeOpenGL() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluOrtho2D(0.0f, (float) Display.getDisplayMode().getWidth(), 0.0f, (float) Display.getDisplayMode().getHeight());
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glViewport(0, 0, Display.getDisplayMode().getWidth(), Display.getDisplayMode().getHeight());
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public static void main(String[] strArr) {
        KeyboardTest keyboardTest;
        String[] strArr2 = strArr;
        KeyboardTest keyboardTest2 = keyboardTest;
        KeyboardTest keyboardTest3 = new KeyboardTest();
        keyboardTest2.executeTest();
        System.exit(0);
    }

    private void render() {
        GL11.glClear(16384);
        GL11.glBegin(9);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glVertex2f(0.0f + this.position.f259x, 0.0f + this.position.f260y);
        GL11.glVertex2f(0.0f + this.position.f259x, 30.0f + this.position.f260y);
        GL11.glVertex2f(40.0f + this.position.f259x, 30.0f + this.position.f260y);
        GL11.glVertex2f(60.0f + this.position.f259x, 15.0f + this.position.f260y);
        GL11.glVertex2f(40.0f + this.position.f259x, 0.0f + this.position.f260y);
        GL11.glEnd();
    }

    private void setupDisplay(boolean z) {
        boolean z2 = z;
        try {
            boolean displayMode2 = setDisplayMode();
            Display.create();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        initializeOpenGL();
    }

    private void wiggleKeyboard() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        while (!Display.isCloseRequested()) {
            Display.update();
            if (!Display.isVisible()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                Keyboard.poll();
                int numKeyboardEvents = Keyboard.getNumKeyboardEvents();
                while (Keyboard.next()) {
                    char eventCharacter = 65535 & Keyboard.getEventCharacter();
                    PrintStream printStream = System.out;
                    StringBuilder sb6 = sb;
                    StringBuilder sb7 = new StringBuilder();
                    printStream.println(sb6.append("Checking key:").append(Keyboard.getKeyName(Keyboard.getEventKey())).toString());
                    PrintStream printStream2 = System.out;
                    StringBuilder sb8 = sb2;
                    StringBuilder sb9 = new StringBuilder();
                    printStream2.println(sb8.append("Pressed:").append(Keyboard.getEventKeyState()).toString());
                    PrintStream printStream3 = System.out;
                    StringBuilder sb10 = sb3;
                    StringBuilder sb11 = new StringBuilder();
                    printStream3.println(sb10.append("Key character code: 0x").append(Integer.toHexString(eventCharacter)).toString());
                    PrintStream printStream4 = System.out;
                    StringBuilder sb12 = sb4;
                    StringBuilder sb13 = new StringBuilder();
                    printStream4.println(sb12.append("Key character: ").append(Keyboard.getEventCharacter()).toString());
                    PrintStream printStream5 = System.out;
                    StringBuilder sb14 = sb5;
                    StringBuilder sb15 = new StringBuilder();
                    printStream5.println(sb14.append("Repeat event: ").append(Keyboard.isRepeatEvent()).toString());
                    if (Keyboard.getEventKey() == 19 && Keyboard.getEventKeyState()) {
                        Keyboard.enableRepeatEvents(!Keyboard.areRepeatEventsEnabled());
                    }
                    if (Keyboard.getEventKey() == 1) {
                        return;
                    }
                }
                if (Keyboard.isKeyDown(205)) {
                    Vector2f vector2f = this.position;
                    vector2f.f259x = 1.0f + vector2f.f259x;
                }
                if (Keyboard.isKeyDown(203)) {
                    this.position.f259x -= 1.0f;
                }
                if (Keyboard.isKeyDown(200)) {
                    Vector2f vector2f2 = this.position;
                    vector2f2.f260y = 1.0f + vector2f2.f260y;
                }
                if (Keyboard.isKeyDown(208)) {
                    this.position.f260y -= 1.0f;
                }
                if (numKeyboardEvents > 0) {
                    System.out.println();
                }
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
                Display.sync(60);
            }
        }
    }

    public void executeTest() {
        initialize();
        createKeyboard();
        wiggleKeyboard();
        Keyboard.destroy();
        Display.destroy();
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
            DisplayMode displayMode2 = org.lwjgl.util.Display.setDisplayMode(availableDisplayModes, strArr);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
