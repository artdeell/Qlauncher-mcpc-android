package org.lwjgl.test.input;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.test.openal.PositionTest;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class MouseTest {
    public static final boolean FULLSCREEN = false;
    private static int WINDOW_HEIGHT = PositionTest.WINDOW_WIDTH;
    private static int WINDOW_WIDTH = PositionTest.WINDOW_WIDTH;
    private boolean closing;
    private int direction;
    private int lastButton;
    private int lastScrollDirection = -1;
    private Vector3f[] quadColors;
    private Vector3f[] triangleColors;
    private Vector2f triangleSize;
    private Vector2f[] triangles;

    public MouseTest() {
        Vector2f vector2f;
        Vector3f vector3f;
        Vector3f vector3f2;
        Vector3f vector3f3;
        Vector3f vector3f4;
        Vector3f vector3f5;
        Vector3f vector3f6;
        Vector3f vector3f7;
        Vector3f vector3f8;
        Vector2f vector2f2;
        Vector2f vector2f3;
        Vector2f vector2f4;
        Vector2f vector2f5;
        Vector2f vector2f6 = vector2f;
        Vector2f vector2f7 = new Vector2f(120.0f, 100.0f);
        this.triangleSize = vector2f6;
        Vector3f[] vector3fArr = new Vector3f[4];
        Vector3f[] vector3fArr2 = vector3fArr;
        Vector3f vector3f9 = vector3f;
        Vector3f vector3f10 = new Vector3f(1.0f, 1.0f, 1.0f);
        vector3fArr2[0] = vector3f9;
        Vector3f[] vector3fArr3 = vector3fArr;
        Vector3f vector3f11 = vector3f2;
        Vector3f vector3f12 = new Vector3f(1.0f, 0.0f, 0.0f);
        vector3fArr3[1] = vector3f11;
        Vector3f[] vector3fArr4 = vector3fArr;
        Vector3f vector3f13 = vector3f3;
        Vector3f vector3f14 = new Vector3f(0.0f, 1.0f, 0.0f);
        vector3fArr4[2] = vector3f13;
        Vector3f[] vector3fArr5 = vector3fArr;
        Vector3f vector3f15 = vector3f4;
        Vector3f vector3f16 = new Vector3f(0.0f, 0.0f, 1.0f);
        vector3fArr5[3] = vector3f15;
        this.triangleColors = vector3fArr;
        Vector3f[] vector3fArr6 = new Vector3f[4];
        Vector3f[] vector3fArr7 = vector3fArr6;
        Vector3f vector3f17 = vector3f5;
        Vector3f vector3f18 = new Vector3f(1.0f, 1.0f, 1.0f);
        vector3fArr7[0] = vector3f17;
        Vector3f[] vector3fArr8 = vector3fArr6;
        Vector3f vector3f19 = vector3f6;
        Vector3f vector3f20 = new Vector3f(1.0f, 0.0f, 0.0f);
        vector3fArr8[1] = vector3f19;
        Vector3f[] vector3fArr9 = vector3fArr6;
        Vector3f vector3f21 = vector3f7;
        Vector3f vector3f22 = new Vector3f(0.0f, 1.0f, 0.0f);
        vector3fArr9[2] = vector3f21;
        Vector3f[] vector3fArr10 = vector3fArr6;
        Vector3f vector3f23 = vector3f8;
        Vector3f vector3f24 = new Vector3f(0.0f, 0.0f, 1.0f);
        vector3fArr10[3] = vector3f23;
        this.quadColors = vector3fArr6;
        Vector2f[] vector2fArr = new Vector2f[4];
        Vector2f[] vector2fArr2 = vector2fArr;
        Vector2f vector2f8 = vector2f2;
        Vector2f vector2f9 = new Vector2f((float) (WINDOW_WIDTH / 2), ((float) WINDOW_HEIGHT) - this.triangleSize.f260y);
        vector2fArr2[0] = vector2f8;
        Vector2f[] vector2fArr3 = vector2fArr;
        Vector2f vector2f10 = vector2f3;
        Vector2f vector2f11 = new Vector2f(this.triangleSize.f260y, (float) (WINDOW_HEIGHT / 2));
        vector2fArr3[1] = vector2f10;
        Vector2f[] vector2fArr4 = vector2fArr;
        Vector2f vector2f12 = vector2f4;
        Vector2f vector2f13 = new Vector2f((float) (WINDOW_WIDTH / 2), this.triangleSize.f260y);
        vector2fArr4[2] = vector2f12;
        Vector2f[] vector2fArr5 = vector2fArr;
        Vector2f vector2f14 = vector2f5;
        Vector2f vector2f15 = new Vector2f(((float) WINDOW_WIDTH) - this.triangleSize.f260y, (float) (WINDOW_HEIGHT / 2));
        vector2fArr5[3] = vector2f14;
        this.triangles = vector2fArr;
    }

    private void handleKeyboard() {
        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == 1 && Keyboard.getEventKeyState()) {
                this.closing = true;
            }
            if (Keyboard.getEventKey() == 57 && Keyboard.getEventKeyState()) {
                Mouse.setGrabbed(!Mouse.isGrabbed());
            }
            if (Keyboard.getEventKey() == 19 && Keyboard.getEventKeyState()) {
                Display.setResizable(!Display.isResizable());
            }
        }
    }

    private void handleMouse() {
        StringBuilder sb;
        readBufferedMouse();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        Display.setTitle(sb2.append("x: ").append(Mouse.getX()).append(", y: ").append(Mouse.getY()).append(", [0]: ").append(Mouse.isButtonDown(0)).append(", [1]: ").append(Mouse.isButtonDown(1)).append(", [2]: ").append(Mouse.isButtonDown(2)).append(", inside: ").append(Mouse.isInsideWindow()).toString());
    }

    private void handleWindow() {
        Display.update();
        this.closing = Display.isCloseRequested();
    }

    private void initialize() {
        setupDisplay();
        setupMouse();
        setupKeyboard();
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

    private void logic() {
        Vector3f[] vector3fArr = this.triangleColors;
        int length = vector3fArr.length;
        for (int i = 0; i < length; i++) {
            Vector3f vector3f = vector3fArr[i];
            vector3f.f261x = (float) (((double) vector3f.f261x) - 0.01d);
            vector3f.f262y = (float) (((double) vector3f.f262y) - 0.01d);
            vector3f.f263z = (float) (((double) vector3f.f263z) - 0.01d);
        }
        Vector3f[] vector3fArr2 = this.quadColors;
        int length2 = vector3fArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            Vector3f vector3f2 = vector3fArr2[i2];
            vector3f2.f261x = (float) (((double) vector3f2.f261x) - 0.01d);
            vector3f2.f262y = (float) (((double) vector3f2.f262y) - 0.01d);
            vector3f2.f263z = (float) (((double) vector3f2.f263z) - 0.01d);
        }
    }

    public static void main(String[] strArr) {
        MouseTest mouseTest;
        String[] strArr2 = strArr;
        MouseTest mouseTest2 = mouseTest;
        MouseTest mouseTest3 = new MouseTest();
        mouseTest2.executeTest();
        System.exit(0);
    }

    private void pause(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void readBufferedMouse() {
        while (Mouse.next()) {
            if (Mouse.getEventButton() != -1 && Mouse.getEventButtonState()) {
                this.lastButton = Mouse.getEventButton();
            }
        }
        updateState();
    }

    private void render() {
        GL11.glClear(16384);
        for (int i = 0; i < this.triangles.length; i++) {
            GL11.glPushMatrix();
            GL11.glTranslatef(this.triangles[i].f259x, this.triangles[i].f260y, 0.0f);
            GL11.glRotatef((float) (i * 90), 0.0f, 0.0f, 1.0f);
            GL11.glColor3f(this.triangleColors[i].f261x, this.triangleColors[i].f262y, this.triangleColors[i].f263z);
            GL11.glBegin(4);
            GL11.glVertex2f(0.0f, this.triangleSize.f260y);
            GL11.glVertex2f(-this.triangleSize.f259x, -this.triangleSize.f260y);
            GL11.glVertex2f(this.triangleSize.f259x, -this.triangleSize.f260y);
            GL11.glEnd();
            GL11.glPopMatrix();
        }
        GL11.glBegin(7);
        GL11.glColor3f(this.quadColors[0].f261x, this.quadColors[0].f262y, this.quadColors[0].f263z);
        GL11.glVertex2f(((float) (WINDOW_WIDTH / 2)) - this.triangleSize.f259x, ((float) (WINDOW_HEIGHT / 2)) - this.triangleSize.f259x);
        GL11.glColor3f(this.quadColors[1].f261x, this.quadColors[1].f262y, this.quadColors[1].f263z);
        GL11.glVertex2f(((float) (WINDOW_WIDTH / 2)) + this.triangleSize.f259x, ((float) (WINDOW_HEIGHT / 2)) - this.triangleSize.f259x);
        GL11.glColor3f(this.quadColors[2].f261x, this.quadColors[2].f262y, this.quadColors[2].f263z);
        GL11.glVertex2f(((float) (WINDOW_WIDTH / 2)) + this.triangleSize.f259x, ((float) (WINDOW_HEIGHT / 2)) + this.triangleSize.f259x);
        GL11.glColor3f(this.quadColors[3].f261x, this.quadColors[3].f262y, this.quadColors[3].f263z);
        GL11.glVertex2f(((float) (WINDOW_WIDTH / 2)) - this.triangleSize.f259x, ((float) (WINDOW_HEIGHT / 2)) + this.triangleSize.f259x);
        GL11.glEnd();
    }

    private void runTest() {
        while (!this.closing) {
            handleWindow();
            if (!this.closing) {
                handleKeyboard();
                handleMouse();
                if (!Display.isVisible()) {
                    if (Display.isDirty()) {
                        render();
                    }
                    pause(100);
                } else {
                    logic();
                    render();
                }
            }
            Thread.yield();
        }
    }

    private void setupDisplay() {
        try {
            boolean displayMode = setDisplayMode();
            Display.setFullscreen(false);
            Display.setVSyncEnabled(true);
            Display.create();
            Mouse.setGrabbed(true);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        initializeOpenGL();
    }

    private void setupKeyboard() {
    }

    private void setupMouse() {
    }

    private void updateState() {
        this.direction = -1;
        int dx = Mouse.getDX();
        int dy = Mouse.getDY();
        int dWheel = Mouse.getDWheel();
        if (dx != dy || dx != 0 || dWheel != 0) {
            if (dx > 0) {
                this.direction = 3;
            }
            if (dx < 0) {
                this.direction = 1;
            }
            if (dy > 0) {
                this.direction = 0;
            }
            if (dy < 0) {
                this.direction = 2;
            }
            if (this.direction > -1) {
                switch (this.lastButton) {
                    case -1:
                        break;
                    case 1:
                        this.triangleColors[this.direction].f262y = 1.0f;
                        break;
                    case 2:
                        this.triangleColors[this.direction].f263z = 1.0f;
                        break;
                    case 3:
                        this.triangleColors[this.direction].f261x = 1.0f;
                        this.triangleColors[this.direction].f262y = 1.0f;
                        this.triangleColors[this.direction].f263z = 1.0f;
                        break;
                    default:
                        this.triangleColors[this.direction].f261x = 1.0f;
                        break;
                }
            }
            if (dWheel > 0) {
                this.lastScrollDirection = 1 + this.lastScrollDirection;
            } else if (dWheel < 0) {
                this.lastScrollDirection = -1 + this.lastScrollDirection;
            } else if (dWheel == 0) {
                return;
            }
            if (this.lastScrollDirection < 0) {
                this.lastScrollDirection = 3;
            }
            if (this.lastScrollDirection > 3) {
                this.lastScrollDirection = 0;
            }
            this.quadColors[this.lastScrollDirection].f261x = (float) Math.random();
            this.quadColors[this.lastScrollDirection].f262y = (float) Math.random();
            this.quadColors[this.lastScrollDirection].f263z = (float) Math.random();
        }
    }

    public void executeTest() {
        initialize();
        runTest();
        Display.destroy();
    }

    /* access modifiers changed from: protected */
    public boolean setDisplayMode() {
        DisplayMode displayMode;
        DisplayMode displayMode2 = displayMode;
        DisplayMode displayMode3 = new DisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT);
        try {
            Display.setDisplayMode(displayMode2);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
