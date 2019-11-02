package org.lwjgl.test.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.Pbuffer;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector2f;

public class PbufferTest {
    private static final float MAX_SPEED = 20.0f;
    private static Pbuffer pbuffer;
    private static int tex_handle;
    private float angle;
    private float angleRotation = 1.0f;
    private DisplayMode mode;
    private Vector2f quadPosition;
    private Vector2f quadVelocity;

    public PbufferTest() {
    }

    private void cleanup() {
        destroyTexture();
        pbuffer.destroy();
        Display.destroy();
    }

    private void destroyTexture() {
        IntBuffer asIntBuffer = ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder()).asIntBuffer();
        IntBuffer put = asIntBuffer.put(0, tex_handle);
        GL11.glDeleteTextures(asIntBuffer);
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
        GL11.glTexEnvf(GL11.GL_TEXTURE_ENV, GL11.GL_TEXTURE_ENV_MODE, 7681.0f);
        GL11.glEnable(3553);
        IntBuffer asIntBuffer = ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder()).asIntBuffer();
        GL11.glGenTextures(asIntBuffer);
        tex_handle = asIntBuffer.get(0);
        GL11.glBindTexture(3553, tex_handle);
        GL11.glTexParameteri(3553, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
        GL11.glTexParameteri(3553, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
        GL11.glTexParameteri(3553, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(3553, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        initGLState(this.mode.getWidth(), this.mode.getHeight(), 0.0f);
    }

    private void initGLState(int i, int i2, float f) {
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluOrtho2D(0.0f, (float) this.mode.getWidth(), 0.0f, (float) this.mode.getHeight());
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glViewport(0, 0, i3, i4);
        GL11.glClearColor(f2, f2, f2, 0.0f);
    }

    private void initPbuffer() {
        try {
            pbuffer.makeCurrent();
            initGLState(256, 256, 0.5f);
            GL11.glBindTexture(3553, tex_handle);
            Display.makeCurrent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        Pbuffer pbuffer2;
        PixelFormat pixelFormat;
        Vector2f vector2f;
        Vector2f vector2f2;
        try {
            Pbuffer pbuffer3 = pbuffer2;
            PixelFormat pixelFormat2 = pixelFormat;
            PixelFormat pixelFormat3 = new PixelFormat();
            Pbuffer pbuffer4 = new Pbuffer(512, 512, pixelFormat2, null, null);
            pbuffer = pbuffer3;
            this.mode = findDisplayMode(800, 600, 16);
            Display.setDisplayMode(this.mode);
            Display.create();
            if ((1 & Pbuffer.getCapabilities()) == 0) {
                System.out.println("No Pbuffer support!");
                System.exit(1);
            }
            System.out.println("Pbuffer support detected");
            glInit();
            initPbuffer();
            Keyboard.create();
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
        PbufferTest pbufferTest;
        String[] strArr2 = strArr;
        System.out.println("Change between fullscreen and windowed mode, by pressing F and W respectively");
        System.out.println("Move quad using arrowkeys, and change rotation using +/-");
        PbufferTest pbufferTest2 = pbufferTest;
        PbufferTest pbufferTest3 = new PbufferTest();
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
        RuntimeException runtimeException2;
        Pbuffer pbuffer2;
        PixelFormat pixelFormat;
        if (pbuffer.isBufferLost()) {
            System.out.println("Buffer contents lost - will recreate the buffer");
            pbuffer.destroy();
            try {
                Pbuffer pbuffer3 = pbuffer2;
                PixelFormat pixelFormat2 = pixelFormat;
                PixelFormat pixelFormat3 = new PixelFormat();
                Pbuffer pbuffer4 = new Pbuffer(512, 512, pixelFormat2, null, null);
                pbuffer = pbuffer3;
                initPbuffer();
            } catch (LWJGLException e) {
                e.printStackTrace();
            }
        }
        try {
            pbuffer.makeCurrent();
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
            GL11.glCopyTexImage2D(3553, 0, GL11.GL_RGB, 0, 0, 512, 512, 0);
            try {
                Display.makeCurrent();
                GL11.glClear(16384);
                GL11.glPushMatrix();
                GL11.glTranslatef(this.quadPosition.f259x, this.quadPosition.f260y, 0.0f);
                GL11.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
                GL11.glColor3f(1.0f, 1.0f, 0.0f);
                GL11.glBegin(7);
                GL11.glTexCoord2f(0.0f, 0.0f);
                GL11.glVertex2i(-50, -50);
                GL11.glTexCoord2f(1.0f, 0.0f);
                GL11.glVertex2i(50, -50);
                GL11.glTexCoord2f(1.0f, 1.0f);
                GL11.glVertex2i(50, 50);
                GL11.glTexCoord2f(0.0f, 1.0f);
                GL11.glVertex2i(-50, 50);
                GL11.glEnd();
                GL11.glPopMatrix();
            } catch (LWJGLException e2) {
                LWJGLException lWJGLException = e2;
                RuntimeException runtimeException3 = runtimeException2;
                RuntimeException runtimeException4 = new RuntimeException(lWJGLException);
                throw runtimeException3;
            }
        } catch (LWJGLException e3) {
            LWJGLException lWJGLException2 = e3;
            RuntimeException runtimeException5 = runtimeException;
            RuntimeException runtimeException6 = new RuntimeException(lWJGLException2);
            throw runtimeException5;
        }
    }

    public void execute() {
        initialize();
        mainLoop();
        cleanup();
    }
}
