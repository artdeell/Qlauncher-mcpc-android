package org.lwjgl.test.opengl.pbuffers;

import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.Pbuffer;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector2f;

public final class PbufferTest {
    private static final float MAX_SPEED = 20.0f;
    private static final int QUAD_SIZE = 64;
    private static final int TEXTURE_SIZE = 512;
    private static int texID;
    private float angle;
    private float angleRotation = 1.0f;
    private DisplayMode mode;
    private Vector2f quadPosition;
    private Vector2f quadVelocity;
    private TextureRenderer texRenderer;
    private float texScaleX;
    private float texScaleY;

    public PbufferTest(int i) {
        PixelFormat pixelFormat;
        UniqueRendererRTT uniqueRendererRTT;
        UniqueRenderer uniqueRenderer;
        Vector2f vector2f;
        Vector2f vector2f2;
        int i2 = i;
        try {
            this.mode = findDisplayMode(800, 600, 16);
            Display.setDisplayMode(this.mode);
            PixelFormat pixelFormat2 = pixelFormat;
            PixelFormat pixelFormat3 = new PixelFormat(16, 0, 0, 0, 0);
            Display.create(pixelFormat2);
            glInit();
            if ((1 & Pbuffer.getCapabilities()) == 0) {
                System.out.println("No Pbuffer support!");
                System.exit(-1);
            }
            System.out.println("Pbuffer support detected. Initializing...\n");
            switch (i2) {
                case 1:
                    System.out.print("Creating pbuffer with unique context...");
                    UniqueRenderer uniqueRenderer2 = uniqueRenderer;
                    UniqueRenderer uniqueRenderer3 = new UniqueRenderer(512, 512, texID);
                    this.texRenderer = uniqueRenderer2;
                    break;
                case 2:
                    System.out.print("Creating render-to-texture pbuffer with unique context...");
                    UniqueRendererRTT uniqueRendererRTT2 = uniqueRendererRTT;
                    UniqueRendererRTT uniqueRendererRTT3 = new UniqueRendererRTT(512, 512, texID);
                    this.texRenderer = uniqueRendererRTT2;
                    break;
            }
            System.out.println("OK");
            Vector2f vector2f3 = vector2f;
            Vector2f vector2f4 = new Vector2f(100.0f, 100.0f);
            this.quadPosition = vector2f3;
            Vector2f vector2f5 = vector2f2;
            Vector2f vector2f6 = new Vector2f(1.0f, 1.0f);
            this.quadVelocity = vector2f5;
            this.texScaleX = 512.0f / ((float) this.mode.getWidth());
            this.texScaleY = 512.0f / ((float) this.mode.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cleanup() {
        IntBuffer createIntBuffer = BufferUtils.createIntBuffer(1);
        IntBuffer put = createIntBuffer.put(0, texID);
        GL11.glDeleteTextures(createIntBuffer);
        this.texRenderer.destroy();
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
            if (displayMode.getWidth() == i4 && displayMode.getHeight() == i5 && displayMode.getBitsPerPixel() >= i6) {
                return displayMode;
            }
        }
        return null;
    }

    private void glInit() {
        Display.setVSyncEnabled(true);
        IntBuffer createIntBuffer = BufferUtils.createIntBuffer(1);
        GL11.glGenTextures(createIntBuffer);
        texID = createIntBuffer.get(0);
        GL11.glTexEnvf(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE, 8448.0f);
        GL11.glEnable(3553);
        GL11.glBindTexture(3553, texID);
        GL11.glTexParameteri(3553, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
        GL11.glTexParameteri(3553, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
        GL11.glTexParameteri(3553, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(3553, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        initGLState(this.mode.getWidth(), this.mode.getHeight(), 0.0f);
    }

    static void initGLState(int i, int i2, float f) {
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluOrtho2D(0.0f, (float) i3, 0.0f, (float) i4);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glViewport(0, 0, i3, i4);
        GL11.glClearColor(f2, f2, f2, 0.0f);
    }

    private static void kill(String str) {
        System.out.println(str);
        System.out.println("-------");
        System.out.println("Usage: java org.lwjgl.test.opengl.pbuffer.PbufferTest <mode>");
        System.out.println("\n<mode>.");
        System.out.println("\t1: no render-to-texture");
        System.out.println("\t2: with render-to-texture");
        System.exit(-1);
    }

    private void logic() {
        this.angle += this.angleRotation;
        if (this.angle > 360.0f) {
            this.angle -= 360.0f;
        }
        this.quadPosition.f259x += this.quadVelocity.f259x;
        this.quadPosition.f260y += this.quadVelocity.f260y;
        if (64.0f + this.quadPosition.f259x >= ((float) this.mode.getWidth()) || this.quadPosition.f259x - 64.0f <= 0.0f) {
            Vector2f vector2f = this.quadVelocity;
            vector2f.f259x = -1.0f * vector2f.f259x;
        }
        if (64.0f + this.quadPosition.f260y >= ((float) this.mode.getHeight()) || this.quadPosition.f260y - 64.0f <= 0.0f) {
            Vector2f vector2f2 = this.quadVelocity;
            vector2f2.f260y = -1.0f * vector2f2.f260y;
        }
    }

    public static void main(String[] strArr) {
        PbufferTest pbufferTest;
        String[] strArr2 = strArr;
        if (strArr2.length != 1) {
            kill("Invalid arguments length.");
        }
        int i = -1;
        try {
            i = Integer.parseInt(strArr2[0]);
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = e;
            kill("Invalid mode.");
        }
        if (!(i == 1 || i == 2)) {
            kill("Invalid mode.");
        }
        System.out.println("Change between fullscreen and windowed mode, by pressing F and W respectively");
        System.out.println("Move quad using arrowkeys, and change rotation using +/-");
        PbufferTest pbufferTest2 = pbufferTest;
        PbufferTest pbufferTest3 = new PbufferTest(i);
        pbufferTest2.execute();
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
            Display.sync(100);
        }
    }

    private void processKeyboard() {
        Keyboard.poll();
        if (Keyboard.isKeyDown(33)) {
            try {
                Display.setDisplayMode(this.mode);
                Display.setFullscreen(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (Keyboard.isKeyDown(17)) {
            try {
                Display.setFullscreen(false);
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
    }

    private void render() {
        RuntimeException runtimeException;
        this.texRenderer.enable();
        GL11.glClear(16384);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.quadPosition.f259x * this.texScaleX, this.quadPosition.f260y * this.texScaleY, 0.0f);
        GL11.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
        GL11.glBegin(7);
        GL11.glColor3f(1.0f, 0.0f, 0.0f);
        GL11.glVertex2i(-64, -64);
        GL11.glVertex2i(64, -64);
        GL11.glColor3f(0.0f, 0.0f, 1.0f);
        GL11.glVertex2i(64, 64);
        GL11.glVertex2i(-64, 64);
        GL11.glEnd();
        GL11.glPopMatrix();
        this.texRenderer.updateTexture();
        try {
            Display.makeCurrent();
            GL11.glClear(16384);
            GL11.glPushMatrix();
            GL11.glTranslatef(this.quadPosition.f259x, this.quadPosition.f260y, 0.0f);
            GL11.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            GL11.glBegin(7);
            GL11.glTexCoord2f(0.0f, 0.0f);
            GL11.glVertex2i(-64, -64);
            GL11.glTexCoord2f(1.0f, 0.0f);
            GL11.glVertex2i(64, -64);
            GL11.glTexCoord2f(1.0f, 1.0f);
            GL11.glVertex2i(64, 64);
            GL11.glTexCoord2f(0.0f, 1.0f);
            GL11.glVertex2i(-64, 64);
            GL11.glEnd();
            GL11.glPopMatrix();
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(lWJGLException);
            throw runtimeException2;
        }
    }

    public void execute() {
        mainLoop();
        cleanup();
    }
}
