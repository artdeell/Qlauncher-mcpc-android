package org.lwjgl.test.input;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.test.openal.PositionTest;
import org.lwjgl.util.glu.GLU;

public class HWCursorTest {
    private static Cursor[] cursors;
    private static int mouse_btn;
    private static int mouse_x;
    private static int mouse_y;

    public HWCursorTest() {
    }

    private void cleanup() {
        try {
            Cursor nativeCursor = Mouse.setNativeCursor(null);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        Cursor[] cursorArr = cursors;
        int length = cursorArr.length;
        for (int i = 0; i < length; i++) {
            cursorArr[i].destroy();
        }
        Display.destroy();
    }

    private void glInit() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluOrtho2D(0.0f, (float) Display.getDisplayMode().getWidth(), 0.0f, (float) Display.getDisplayMode().getHeight());
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glViewport(0, 0, Display.getDisplayMode().getWidth(), Display.getDisplayMode().getHeight());
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        Display.setVSyncEnabled(true);
    }

    private static void initNativeCursors() throws Exception {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        if ((1 & Cursor.getCapabilities()) == 0) {
            System.out.println("No HW cursor support!");
            System.exit(0);
        }
        cursors = new Cursor[3];
        int min = Math.min(64, Cursor.getMaxCursorSize());
        IntBuffer asIntBuffer = ByteBuffer.allocateDirect(4 * 1 * min * min).order(ByteOrder.nativeOrder()).asIntBuffer();
        for (int i = 0; i < min; i++) {
            for (int i2 = 0; i2 < min; i2++) {
                IntBuffer put = asIntBuffer.put(-1);
            }
        }
        Buffer flip = asIntBuffer.flip();
        Cursor[] cursorArr = cursors;
        Cursor cursor4 = cursor;
        Cursor cursor5 = new Cursor(min, min, min / 2, min / 2, 1, asIntBuffer, null);
        cursorArr[0] = cursor4;
        IntBuffer asIntBuffer2 = ByteBuffer.allocateDirect(4 * 3 * min * min).order(ByteOrder.nativeOrder()).asIntBuffer();
        IntBuffer asIntBuffer3 = ByteBuffer.allocateDirect(12).order(ByteOrder.nativeOrder()).asIntBuffer();
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = -65536;
            if (i3 == 1) {
                i4 = -16711936;
            } else if (i3 == 2) {
                i4 = -16776961;
            }
            int i5 = (min / 5) * (i3 + 1);
            int i6 = (min / 2) - (i5 / 2);
            int i7 = (min / 2) + (i5 / 2);
            for (int i8 = 0; i8 < min; i8++) {
                for (int i9 = 0; i9 < min; i9++) {
                    if (i8 < i6 || i8 >= i7 || i9 < i6 || i9 >= i7) {
                        IntBuffer put2 = asIntBuffer2.put(i4);
                    } else {
                        IntBuffer put3 = asIntBuffer2.put(0);
                    }
                }
            }
        }
        IntBuffer put4 = asIntBuffer3.put(2000).put(2000).put(2000);
        Buffer flip2 = asIntBuffer3.flip();
        Buffer flip3 = asIntBuffer2.flip();
        Cursor[] cursorArr2 = cursors;
        Cursor cursor6 = cursor2;
        Cursor cursor7 = new Cursor(min, min, min / 2, min / 2, 3, asIntBuffer2, asIntBuffer3);
        cursorArr2[1] = cursor6;
        IntBuffer asIntBuffer4 = ByteBuffer.allocateDirect(4 * 20 * min * min).order(ByteOrder.nativeOrder()).asIntBuffer();
        IntBuffer asIntBuffer5 = ByteBuffer.allocateDirect(80).order(ByteOrder.nativeOrder()).asIntBuffer();
        IntBuffer put5 = asIntBuffer5.put(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100});
        float f = -0.05f;
        for (int i10 = 0; i10 < 20; i10++) {
            for (int i11 = 0; i11 < min; i11++) {
                for (int i12 = 0; i12 < min; i12++) {
                    IntBuffer put6 = asIntBuffer4.put((int) f);
                }
            }
            f += f;
        }
        Buffer flip4 = asIntBuffer4.flip();
        Buffer flip5 = asIntBuffer5.flip();
        Cursor[] cursorArr3 = cursors;
        Cursor cursor8 = cursor3;
        Cursor cursor9 = new Cursor(min, min, min / 2, min / 2, 20, asIntBuffer4, asIntBuffer5);
        cursorArr3[2] = cursor8;
        Cursor nativeCursor = Mouse.setNativeCursor(cursors[0]);
    }

    private void initialize() {
        try {
            boolean displayMode = setDisplayMode();
            Display.create();
            glInit();
            initNativeCursors();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static void main(String[] strArr) {
        HWCursorTest hWCursorTest;
        String[] strArr2 = strArr;
        System.out.println("Change between fullscreen and windowed mode, by pressing F and W respectively. Enable hw cursor with N and disable it with M.");
        HWCursorTest hWCursorTest2 = hWCursorTest;
        HWCursorTest hWCursorTest3 = new HWCursorTest();
        hWCursorTest2.execute();
        System.exit(0);
    }

    private void mainLoop() {
        while (!Keyboard.isKeyDown(1) && !Display.isCloseRequested()) {
            Display.update();
            if (Display.isVisible()) {
                processKeyboard();
                processMouse();
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
        }
    }

    private void processKeyboard() {
        if (Keyboard.isKeyDown(33)) {
            try {
                Cursor nativeCursor = Mouse.setNativeCursor(null);
                try {
                    Cursor[] cursorArr = cursors;
                    int length = cursorArr.length;
                    for (int i = 0; i < length; i++) {
                        cursorArr[i].destroy();
                    }
                    Display.setFullscreen(true);
                    glInit();
                    initNativeCursors();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                System.exit(1);
            }
        }
        if (Keyboard.isKeyDown(17)) {
            try {
                Cursor nativeCursor2 = Mouse.setNativeCursor(null);
                try {
                    Cursor[] cursorArr2 = cursors;
                    int length2 = cursorArr2.length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        cursorArr2[i2].destroy();
                    }
                    Display.setFullscreen(false);
                    glInit();
                    initNativeCursors();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                System.exit(1);
            }
        }
        if (Keyboard.isKeyDown(50)) {
            try {
                Cursor nativeCursor3 = Mouse.setNativeCursor(null);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        if (Keyboard.isKeyDown(49)) {
            switchCursor();
        }
        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == 57 && Keyboard.getEventKeyState()) {
                Mouse.setGrabbed(!Mouse.isGrabbed());
            }
        }
    }

    private void processMouse() {
        mouse_x = Mouse.getX();
        mouse_y = Mouse.getY();
        while (Mouse.next()) {
            int eventButton = Mouse.getEventButton();
            if (eventButton >= 0 && eventButton < 3 && Mouse.getEventButtonState()) {
                mouse_btn = Mouse.getEventButton();
                switchCursor();
            }
        }
    }

    private void render() {
        GL11.glClear(16384);
        GL11.glPushMatrix();
        GL11.glTranslatef((float) mouse_x, (float) mouse_y, 0.0f);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glBegin(7);
        GL11.glColor3f(1.0f, 0.0f, 0.0f);
        GL11.glVertex2i(-50, -50);
        GL11.glColor3f(0.0f, 1.0f, 0.0f);
        GL11.glVertex2i(50, -50);
        GL11.glColor3f(0.0f, 0.0f, 1.0f);
        GL11.glVertex2i(50, 50);
        GL11.glColor3f(1.0f, 0.0f, 1.0f);
        GL11.glVertex2i(-50, 50);
        GL11.glEnd();
        GL11.glPopMatrix();
    }

    private void switchCursor() {
        try {
            Cursor nativeCursor = Mouse.setNativeCursor(cursors[mouse_btn]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void execute() {
        initialize();
        mainLoop();
        cleanup();
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
