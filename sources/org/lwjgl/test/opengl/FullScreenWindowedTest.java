package org.lwjgl.test.opengl;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.test.openal.PositionTest;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector2f;

public class FullScreenWindowedTest {
    private static final float MAX_SPEED = 20.0f;
    private float angle;
    private float angleRotation = 1.0f;
    private DisplayMode mode;
    private Vector2f quadPosition;
    private Vector2f quadVelocity;

    public FullScreenWindowedTest() {
    }

    private void cleanup() {
        Display.destroy();
    }

    private DisplayMode findDisplayMode(int i, int i2, int i3) throws LWJGLException {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DisplayMode[] availableDisplayModes = Display.getAvailableDisplayModes();
        int length = availableDisplayModes.length;
        for (int i7 = 0; i7 < length; i7++) {
            DisplayMode displayMode = availableDisplayModes[i7];
            if (displayMode.getWidth() == i4 && displayMode.getHeight() == i5 && displayMode.getBitsPerPixel() >= i6 && displayMode.getFrequency() <= 60) {
                return displayMode;
            }
        }
        return Display.getDesktopDisplayMode();
    }

    private void glInit() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluOrtho2D(0.0f, (float) this.mode.getWidth(), 0.0f, (float) this.mode.getHeight());
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glViewport(0, 0, this.mode.getWidth(), this.mode.getHeight());
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        Display.setVSyncEnabled(true);
    }

    private void initialize() {
        Vector2f vector2f;
        Vector2f vector2f2;
        try {
            switchMode();
            Display.create();
            glInit();
            Vector2f vector2f3 = vector2f;
            Vector2f vector2f4 = new Vector2f(100.0f, 100.0f);
            this.quadPosition = vector2f3;
            Vector2f vector2f5 = vector2f2;
            Vector2f vector2f6 = new Vector2f(1.0f, 1.0f);
            this.quadVelocity = vector2f5;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void logic() {
        this.angle += this.angleRotation;
        if (this.angle > 90.0f) {
            this.angle = 0.0f;
        }
        this.quadPosition.f259x += this.quadVelocity.f259x;
        this.quadPosition.f260y += this.quadVelocity.f260y;
        if (50.0f + this.quadPosition.f259x >= ((float) this.mode.getWidth()) || this.quadPosition.f259x - 50.0f <= 0.0f) {
            Vector2f vector2f = this.quadVelocity;
            vector2f.f259x = -1.0f * vector2f.f259x;
        }
        if (50.0f + this.quadPosition.f260y >= ((float) this.mode.getHeight()) || this.quadPosition.f260y - 50.0f <= 0.0f) {
            Vector2f vector2f2 = this.quadVelocity;
            vector2f2.f260y = -1.0f * vector2f2.f260y;
        }
    }

    public static void main(String[] strArr) {
        FullScreenWindowedTest fullScreenWindowedTest;
        String[] strArr2 = strArr;
        System.out.println("Change between fullscreen and windowed mode, by pressing F and W respectively");
        System.out.println("Move quad using arrowkeys, and change rotation using +/-");
        FullScreenWindowedTest fullScreenWindowedTest2 = fullScreenWindowedTest;
        FullScreenWindowedTest fullScreenWindowedTest3 = new FullScreenWindowedTest();
        fullScreenWindowedTest2.execute();
        System.exit(0);
    }

    private void mainLoop() {
        while (!Keyboard.isKeyDown(1) && !Display.isCloseRequested()) {
            if (Display.isVisible()) {
                processKeyboard();
                logic();
                render();
            } else {
                if (Display.isDirty()) {
                    render();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    InterruptedException interruptedException = e;
                }
            }
            Display.update();
        }
    }

    private void processKeyboard() {
        DisplayMode displayMode;
        if (Keyboard.isKeyDown(33)) {
            try {
                switchMode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (Keyboard.isKeyDown(17)) {
            try {
                DisplayMode displayMode2 = displayMode;
                DisplayMode displayMode3 = new DisplayMode(PositionTest.WINDOW_WIDTH, 480);
                this.mode = displayMode2;
                Display.setDisplayModeAndFullscreen(this.mode);
                glInit();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (Keyboard.isKeyDown(200)) {
            Vector2f vector2f = this.quadVelocity;
            vector2f.f260y = 0.1f + vector2f.f260y;
        }
        if (Keyboard.isKeyDown(208)) {
            this.quadVelocity.f260y -= 0.1f;
        }
        if (Keyboard.isKeyDown(205)) {
            Vector2f vector2f2 = this.quadVelocity;
            vector2f2.f259x = 0.1f + vector2f2.f259x;
        }
        if (Keyboard.isKeyDown(203)) {
            this.quadVelocity.f259x -= 0.1f;
        }
        if (Keyboard.isKeyDown(78)) {
            this.angleRotation = 0.1f + this.angleRotation;
        }
        if (Keyboard.isKeyDown(74)) {
            this.angleRotation -= 0.1f;
        }
        if (this.quadVelocity.f259x < -20.0f) {
            this.quadVelocity.f259x = -20.0f;
        }
        if (this.quadVelocity.f259x > 20.0f) {
            this.quadVelocity.f259x = 20.0f;
        }
        if (this.quadVelocity.f260y < -20.0f) {
            this.quadVelocity.f260y = -20.0f;
        }
        if (this.quadVelocity.f260y > 20.0f) {
            this.quadVelocity.f260y = 20.0f;
        }
        if (this.angleRotation < 0.0f) {
            this.angleRotation = 0.0f;
        }
        if (this.angleRotation > 20.0f) {
            this.angleRotation = 20.0f;
        }
        do {
        } while (Mouse.next());
    }

    private void render() {
        GL11.glClear(16384);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.quadPosition.f259x, this.quadPosition.f260y, 0.0f);
        GL11.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glBegin(7);
        GL11.glVertex2i(-50, -50);
        GL11.glVertex2i(50, -50);
        GL11.glVertex2i(50, 50);
        GL11.glVertex2i(-50, 50);
        GL11.glEnd();
        GL11.glPopMatrix();
    }

    private void switchMode() throws LWJGLException {
        this.mode = findDisplayMode(800, 600, Display.getDisplayMode().getBitsPerPixel());
        Display.setDisplayModeAndFullscreen(this.mode);
    }

    public void execute() {
        initialize();
        mainLoop();
        cleanup();
    }
}
