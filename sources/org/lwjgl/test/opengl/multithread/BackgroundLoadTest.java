package org.lwjgl.test.opengl.multithread;

import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.Drawable;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.Pbuffer;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.opengl.SharedDrawable;
import org.lwjgl.opengl.Util;
import org.lwjgl.test.openal.PositionTest;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

public final class BackgroundLoadTest {
    private static BackgroundLoader backgroundLoader;
    private static boolean run = true;
    private static Sphere sphere;

    private BackgroundLoadTest() {
    }

    private static void argsError() {
        System.out.println("\nInvalid program arguments.");
        System.out.println("\nUsage: BackgroundLoadTest <testType>, where <testType> argument can be one of the following:\n");
        System.out.println("PB\t- Use a Pbuffer context for the background thread.");
        System.out.println("SD\t- Use a SharedDrawable context for the background thread.");
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
        backgroundLoader.cleanup();
        Thread.yield();
        if (Display.isCreated()) {
            Display.destroy();
        }
    }

    private static void handleIO() {
        if (Keyboard.getNumKeyboardEvents() != 0) {
            while (Keyboard.next()) {
                if (!Keyboard.getEventKeyState()) {
                    switch (Keyboard.getEventKey()) {
                        case 1:
                            run = false;
                            break;
                    }
                }
            }
        }
        do {
        } while (Mouse.next());
    }

    private static void initialize(String[] strArr) {
        Sphere sphere2;
        C08322 r16;
        C08311 r162;
        StringBuilder sb;
        PixelFormat pixelFormat;
        String[] strArr2 = strArr;
        if (strArr2.length != 1) {
            argsError();
        }
        DisplayMode displayMode = null;
        try {
            DisplayMode[] availableDisplayModes = Display.getAvailableDisplayModes();
            displayMode = chooseMode(availableDisplayModes, 1024, 768);
            if (displayMode == null) {
                displayMode = chooseMode(availableDisplayModes, 800, 600);
            }
            if (displayMode == null) {
                displayMode = chooseMode(availableDisplayModes, PositionTest.WINDOW_WIDTH, 480);
            }
            if (displayMode == null) {
                kill("Failed to set an appropriate display mode.");
            }
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("Setting display mode to: ").append(displayMode).toString());
            Display.setDisplayMode(displayMode);
            Display.setTitle("Background Loading Test");
            PixelFormat pixelFormat2 = pixelFormat;
            PixelFormat pixelFormat3 = new PixelFormat(8, 24, 0);
            Display.create(pixelFormat2);
        } catch (LWJGLException e) {
            kill(e.getMessage());
        }
        GL11.glViewport(0, 0, displayMode.getWidth(), displayMode.getHeight());
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluPerspective(45.0f, ((float) displayMode.getWidth()) / ((float) displayMode.getHeight()), 1.0f, 10.0f);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -4.0f);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glPushMatrix();
        GL11.glClearDepth(1.0d);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, 4354);
        GL11.glFrontFace(2305);
        GL11.glPolygonMode(GL11.GL_FRONT, GL11.GL_FILL);
        GL11.glCullFace(GL11.GL_BACK);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.0f);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        FloatBuffer createFloatBuffer = BufferUtils.createFloatBuffer(4);
        Buffer clear = createFloatBuffer.clear();
        FloatBuffer put = createFloatBuffer.put(0, 1.0f).put(1, 1.0f).put(2, 1.0f).put(3, 1.0f);
        GL11.glLight(16384, 4609, createFloatBuffer);
        FloatBuffer put2 = createFloatBuffer.put(0, 1.0f).put(1, 1.0f).put(2, 1.0f).put(3, 1.0f);
        GL11.glLight(16384, 4608, createFloatBuffer);
        FloatBuffer put3 = createFloatBuffer.put(0, 1.0f).put(1, 1.0f).put(2, 0.5f).put(3, 1.0f);
        GL11.glLight(16384, 4610, createFloatBuffer);
        FloatBuffer put4 = createFloatBuffer.put(0, -0.33333334f).put(1, 0.33333334f).put(2, 0.33333334f).put(3, 0.0f);
        GL11.glLight(16384, 4611, createFloatBuffer);
        FloatBuffer put5 = createFloatBuffer.put(0, 0.2f).put(1, 0.2f).put(2, 0.2f).put(3, 1.0f);
        GL11.glLightModel((int) GL11.GL_LIGHT_MODEL_AMBIENT, createFloatBuffer);
        GL11.glEnable(16384);
        GL11.glEnable(GL11.GL_LIGHTING);
        Sphere sphere3 = sphere2;
        Sphere sphere4 = new Sphere();
        sphere = sphere3;
        if ("PB".equalsIgnoreCase(strArr2[0])) {
            C08311 r11 = r162;
            C08311 r12 = new BackgroundLoader() {
                /* access modifiers changed from: 0000 */
                public Drawable getDrawable() throws LWJGLException {
                    Pbuffer pbuffer;
                    PixelFormat pixelFormat;
                    Pbuffer pbuffer2 = pbuffer;
                    PixelFormat pixelFormat2 = pixelFormat;
                    PixelFormat pixelFormat3 = new PixelFormat(8, 24, 0);
                    Pbuffer pbuffer3 = new Pbuffer(2, 2, pixelFormat2, Display.getDrawable());
                    return pbuffer2;
                }
            };
            backgroundLoader = r11;
        } else if ("SD".equalsIgnoreCase(strArr2[0])) {
            C08322 r112 = r16;
            C08322 r122 = new BackgroundLoader() {
                /* access modifiers changed from: 0000 */
                public Drawable getDrawable() throws LWJGLException {
                    SharedDrawable sharedDrawable;
                    SharedDrawable sharedDrawable2 = sharedDrawable;
                    SharedDrawable sharedDrawable3 = new SharedDrawable(Display.getDrawable());
                    return sharedDrawable2;
                }
            };
            backgroundLoader = r112;
        } else {
            argsError();
        }
    }

    static void kill(String str) {
        StringBuilder sb;
        String str2 = str;
        System.out.println("The BackgroundLoadTest program was terminated because an error occured.\n");
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

    static void kill(String str, Throwable th) {
        StringBuilder sb;
        StringBuilder sb2;
        String str2 = str;
        Throwable th2 = th;
        System.out.println("The BackgroundLoadTest program was terminated because an exception occured.\n");
        PrintStream printStream = System.out;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        StringBuilder append = sb3.append("Reason: ");
        if (str2 == null) {
            str2 = "Unknown";
        }
        printStream.println(append.append(str2).toString());
        PrintStream printStream2 = System.out;
        StringBuilder sb5 = sb2;
        StringBuilder sb6 = new StringBuilder();
        printStream2.println(sb5.append("Exception message: ").append(th2.getMessage()).toString());
        cleanup();
        System.exit(-1);
    }

    public static void main(String[] strArr) {
        initialize(strArr);
        Util.checkGLError();
        try {
            backgroundLoader.start();
        } catch (LWJGLException e) {
            kill("Failed to start background thread.", e);
        }
        Util.checkGLError();
        while (run) {
            if (!Display.isVisible()) {
                Thread.yield();
            } else {
                handleIO();
                GL11.glClear(16640);
                renderObject();
                Util.checkGLError();
                GL11.glPopMatrix();
                GL11.glPushMatrix();
            }
            Display.update();
            if (Display.isCloseRequested()) {
                break;
            }
        }
        cleanup();
        System.exit(0);
    }

    static void renderObject() {
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        int texID = backgroundLoader.getTexID();
        if (texID == 0) {
            sphere.setTextureFlag(false);
            GL11.glDisable(3553);
        } else {
            sphere.setTextureFlag(true);
            GL11.glEnable(3553);
            GL11.glBindTexture(3553, texID);
        }
        sphere.draw(1.0f, 32, 32);
        if (texID != 0) {
            GL11.glBindTexture(3553, 0);
            GL11.glDisable(3553);
        }
    }
}
