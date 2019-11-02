package org.lwjgl.test.openal;

import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.C0758AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.WaveData;
import org.lwjgl.util.glu.GLU;

public class PositionTest extends BasicTest {
    public static final int CENTER = 1;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    public static final int WINDOW_HEIGHT = 480;
    public static final int WINDOW_WIDTH = 640;
    private FloatBuffer centerPosition = createFloatBuffer(new float[]{0.0f, 0.0f, -4.0f});
    private FloatBuffer centerVelocity = createFloatBuffer(new float[]{0.0f, 0.0f, 0.0f});
    private boolean finished;
    private GLUT glut;
    private FloatBuffer leftPosition = createFloatBuffer(new float[]{-2.0f, 0.0f, 0.0f});
    private FloatBuffer leftVelocity = createFloatBuffer(new float[]{0.0f, 0.0f, 0.0f});
    private FloatBuffer listenerOrientation = createFloatBuffer(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f});
    private FloatBuffer listenerPosition = createFloatBuffer(new float[]{0.0f, 0.0f, 0.0f});
    private FloatBuffer listenerVelocity = createFloatBuffer(new float[]{0.0f, 0.0f, 0.0f});
    private boolean pauseMode;
    private FloatBuffer rightPosition = createFloatBuffer(new float[]{2.0f, 0.0f, 0.0f});
    private FloatBuffer rightVelocity = createFloatBuffer(new float[]{0.0f, 0.0f, 0.0f});
    private IntBuffer soundBuffers = BufferUtils.createIntBuffer(3);
    private IntBuffer soundSources = BufferUtils.createIntBuffer(3);

    class GLUT {
        int[][] faces;

        /* renamed from: n */
        float[][] f217n;
        final /* synthetic */ PositionTest this$0;

        /* renamed from: v */
        float[][] f218v = ((float[][]) Array.newInstance(Float.TYPE, new int[]{8, 3}));

        GLUT(PositionTest positionTest) {
            this.this$0 = positionTest;
            float[][] fArr = new float[6][];
            float[][] fArr2 = fArr;
            fArr[0] = new float[]{-1.0f, 0.0f, 0.0f};
            float[][] fArr3 = fArr2;
            float[][] fArr4 = fArr3;
            fArr3[1] = new float[]{0.0f, 1.0f, 0.0f};
            float[][] fArr5 = fArr4;
            float[][] fArr6 = fArr5;
            fArr5[2] = new float[]{1.0f, 0.0f, 0.0f};
            float[][] fArr7 = fArr6;
            float[][] fArr8 = fArr7;
            fArr7[3] = new float[]{0.0f, -1.0f, 0.0f};
            float[][] fArr9 = fArr8;
            float[][] fArr10 = fArr9;
            fArr9[4] = new float[]{0.0f, 0.0f, 1.0f};
            float[][] fArr11 = fArr10;
            float[][] fArr12 = fArr11;
            fArr11[5] = new float[]{0.0f, 0.0f, -1.0f};
            this.f217n = fArr12;
            int[][] iArr = new int[6][];
            int[][] iArr2 = iArr;
            iArr[0] = new int[]{0, 1, 2, 3};
            int[][] iArr3 = iArr2;
            int[][] iArr4 = iArr3;
            iArr3[1] = new int[]{3, 2, 6, 7};
            int[][] iArr5 = iArr4;
            int[][] iArr6 = iArr5;
            iArr5[2] = new int[]{7, 6, 5, 4};
            int[][] iArr7 = iArr6;
            int[][] iArr8 = iArr7;
            iArr7[3] = new int[]{4, 5, 1, 0};
            int[][] iArr9 = iArr8;
            int[][] iArr10 = iArr9;
            iArr9[4] = new int[]{5, 6, 2, 1};
            int[][] iArr11 = iArr10;
            int[][] iArr12 = iArr11;
            iArr11[5] = new int[]{7, 4, 0, 3};
            this.faces = iArr12;
        }

        private void drawBox(float f, int i) {
            float f2 = f;
            int i2 = i;
            float[] fArr = this.f218v[0];
            float[] fArr2 = this.f218v[1];
            float[] fArr3 = this.f218v[2];
            float f3 = (-f2) / 2.0f;
            this.f218v[3][0] = f3;
            fArr3[0] = f3;
            fArr2[0] = f3;
            fArr[0] = f3;
            float[] fArr4 = this.f218v[4];
            float[] fArr5 = this.f218v[5];
            float[] fArr6 = this.f218v[6];
            float f4 = f2 / 2.0f;
            this.f218v[7][0] = f4;
            fArr6[0] = f4;
            fArr5[0] = f4;
            fArr4[0] = f4;
            float[] fArr7 = this.f218v[0];
            float[] fArr8 = this.f218v[1];
            float[] fArr9 = this.f218v[4];
            float f5 = (-f2) / 2.0f;
            this.f218v[5][1] = f5;
            fArr9[1] = f5;
            fArr8[1] = f5;
            fArr7[1] = f5;
            float[] fArr10 = this.f218v[2];
            float[] fArr11 = this.f218v[3];
            float[] fArr12 = this.f218v[6];
            float f6 = f2 / 2.0f;
            this.f218v[7][1] = f6;
            fArr12[1] = f6;
            fArr11[1] = f6;
            fArr10[1] = f6;
            float[] fArr13 = this.f218v[0];
            float[] fArr14 = this.f218v[3];
            float[] fArr15 = this.f218v[4];
            float f7 = (-f2) / 2.0f;
            this.f218v[7][2] = f7;
            fArr15[2] = f7;
            fArr14[2] = f7;
            fArr13[2] = f7;
            float[] fArr16 = this.f218v[1];
            float[] fArr17 = this.f218v[2];
            float[] fArr18 = this.f218v[5];
            float f8 = f2 / 2.0f;
            this.f218v[6][2] = f8;
            fArr18[2] = f8;
            fArr17[2] = f8;
            fArr16[2] = f8;
            for (int i3 = 5; i3 >= 0; i3--) {
                GL11.glBegin(i2);
                GL11.glNormal3f(this.f217n[i3][0], this.f217n[i3][1], this.f217n[i3][2]);
                GL11.glVertex3f(this.f218v[this.faces[i3][0]][0], this.f218v[this.faces[i3][0]][1], this.f218v[this.faces[i3][0]][2]);
                GL11.glVertex3f(this.f218v[this.faces[i3][1]][0], this.f218v[this.faces[i3][1]][1], this.f218v[this.faces[i3][1]][2]);
                GL11.glVertex3f(this.f218v[this.faces[i3][2]][0], this.f218v[this.faces[i3][2]][1], this.f218v[this.faces[i3][2]][2]);
                GL11.glVertex3f(this.f218v[this.faces[i3][3]][0], this.f218v[this.faces[i3][3]][1], this.f218v[this.faces[i3][3]][2]);
                GL11.glEnd();
            }
        }

        public void glutSolidCube(float f) {
            drawBox(f, 7);
        }

        public void glutWireCube(float f) {
            drawBox(f, 2);
        }
    }

    public PositionTest() {
    }

    private void handleInput() {
        this.finished = Display.isCloseRequested() || Keyboard.isKeyDown(1);
        if (!this.finished) {
            boolean z = Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
            if (Keyboard.isKeyDown(2)) {
                AL10.alSourcePlay(this.soundSources.get(0));
                LWJGLUtil.log("Playing left.wav");
            }
            if (Keyboard.isKeyDown(3)) {
                AL10.alSourcePlay(this.soundSources.get(1));
                LWJGLUtil.log("Playing center.wav");
            }
            if (Keyboard.isKeyDown(4)) {
                AL10.alSourcePlay(this.soundSources.get(2));
                LWJGLUtil.log("Playing right.wav");
            }
            if (Keyboard.isKeyDown(5)) {
                AL10.alSourceStop(this.soundSources.get(0));
                LWJGLUtil.log("Stopped left.wav");
            }
            if (Keyboard.isKeyDown(6)) {
                AL10.alSourceStop(this.soundSources.get(1));
                LWJGLUtil.log("Stopped center.wav");
            }
            if (Keyboard.isKeyDown(7)) {
                AL10.alSourceStop(this.soundSources.get(2));
                LWJGLUtil.log("Stopped right.wav");
            }
            if (Keyboard.isKeyDown(203)) {
                FloatBuffer put = this.listenerPosition.put(0, this.listenerPosition.get(0) - 0.1f);
                AL10.alListener(4100, this.listenerPosition);
            }
            if (Keyboard.isKeyDown(205)) {
                FloatBuffer put2 = this.listenerPosition.put(0, 0.1f + this.listenerPosition.get(0));
                AL10.alListener(4100, this.listenerPosition);
            }
            if (Keyboard.isKeyDown(200)) {
                if (z) {
                    FloatBuffer put3 = this.listenerPosition.put(1, 0.1f + this.listenerPosition.get(1));
                } else {
                    FloatBuffer put4 = this.listenerPosition.put(2, this.listenerPosition.get(2) - 0.1f);
                }
                AL10.alListener(4100, this.listenerPosition);
            }
            if (Keyboard.isKeyDown(208)) {
                if (z) {
                    FloatBuffer put5 = this.listenerPosition.put(1, this.listenerPosition.get(1) - 0.1f);
                } else {
                    FloatBuffer put6 = this.listenerPosition.put(2, 0.1f + this.listenerPosition.get(2));
                }
                AL10.alListener(4100, this.listenerPosition);
            }
            FloatBuffer put7 = this.listenerPosition.put(0, this.listenerPosition.get(0) + (0.01f * ((float) Mouse.getDX())));
            FloatBuffer put8 = this.listenerPosition.put(1, this.listenerPosition.get(1) + (0.01f * ((float) Mouse.getDY())));
            if (Mouse.isButtonDown(0)) {
                FloatBuffer put9 = this.listenerPosition.put(2, this.listenerPosition.get(2) - 0.1f);
            }
            if (Mouse.isButtonDown(1)) {
                FloatBuffer put10 = this.listenerPosition.put(2, 0.1f + this.listenerPosition.get(2));
            }
            AL10.alListener(4100, this.listenerPosition);
            do {
            } while (Mouse.next());
        }
    }

    public static void main(String[] strArr) {
        PositionTest positionTest;
        String[] strArr2 = strArr;
        PositionTest positionTest2 = positionTest;
        PositionTest positionTest3 = new PositionTest();
        positionTest2.execute(strArr2);
        System.exit(0);
    }

    private void paused(boolean z) {
        boolean z2 = z;
        if (z2 && !this.pauseMode) {
            this.pauseMode = true;
            AL10.alSourcePause(this.soundSources);
            System.out.println("pauseMode = true");
        } else if (!z2 && this.pauseMode) {
            this.pauseMode = false;
            startSounds();
            System.out.println("pauseMode = false");
        }
    }

    private void render() {
        GL11.glClear(16640);
        GL11.glPushMatrix();
        GL11.glRotatef(20.0f, 1.0f, 1.0f, 0.0f);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.leftPosition.get(0), this.leftPosition.get(1), this.leftPosition.get(2));
        GL11.glColor3f(1.0f, 0.0f, 0.0f);
        this.glut.glutWireCube(0.5f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.centerPosition.get(0), this.centerPosition.get(1), this.centerPosition.get(2));
        GL11.glColor3f(0.0f, 0.0f, 1.0f);
        this.glut.glutWireCube(0.5f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.rightPosition.get(0), this.rightPosition.get(1), this.rightPosition.get(2));
        GL11.glColor3f(0.0f, 1.0f, 0.0f);
        this.glut.glutWireCube(0.5f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.listenerPosition.get(0), this.listenerPosition.get(1), this.listenerPosition.get(2));
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        this.glut.glutSolidCube(0.5f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    private void run() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        boolean z = true;
        System.out.println("Press 1/4 (left), 2/5 (center) or 3/6 (right) to toggle sound");
        System.out.println("Press LEFT/RIGHT to move along x axis");
        System.out.println("Press SHIFT and either UP/DOWN to move along y axis");
        System.out.println("Press UP/DOWN to move along z axis");
        System.out.println("Move along the x and y axis with the mouse");
        System.out.println("Press LEFT or RIGHT mouse button to move along z axis");
        System.out.println("Press ESC to exit demo");
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        LWJGLUtil.log(sb5.append("Listener position: ").append(this.listenerPosition.get(0)).append(", ").append(this.listenerPosition.get(1)).append(", ").append(this.listenerPosition.get(2)).toString());
        StringBuilder sb7 = sb2;
        StringBuilder sb8 = new StringBuilder();
        LWJGLUtil.log(sb7.append("Left position: ").append(this.leftPosition.get(0)).append(", ").append(this.leftPosition.get(1)).append(", ").append(this.leftPosition.get(2)).toString());
        StringBuilder sb9 = sb3;
        StringBuilder sb10 = new StringBuilder();
        LWJGLUtil.log(sb9.append("Center position: ").append(this.centerPosition.get(0)).append(", ").append(this.centerPosition.get(1)).append(", ").append(this.centerPosition.get(2)).toString());
        StringBuilder sb11 = sb4;
        StringBuilder sb12 = new StringBuilder();
        LWJGLUtil.log(sb11.append("Right position: ").append(this.rightPosition.get(0)).append(", ").append(this.rightPosition.get(1)).append(", ").append(this.rightPosition.get(2)).toString());
        while (!this.finished) {
            handleInput();
            Display.update();
            if (Display.isVisible()) {
                render();
            } else {
                pause(100);
            }
            paused(!Display.isVisible() && !Display.isActive());
            if (z && !this.pauseMode) {
                startSounds();
                z = false;
            }
        }
    }

    private void setup() throws Exception {
        GLUT glut2;
        LWJGLUtil.log("Setting up window");
        int width = (-640 + Display.getDisplayMode().getWidth()) / 2;
        int height = (-480 + Display.getDisplayMode().getHeight()) / 2;
        boolean displayMode = setDisplayMode();
        Display.create();
        LWJGLUtil.log("Setting up OpenGL");
        GL11.glViewport(0, 0, WINDOW_WIDTH, 480);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluPerspective(50.0f, 1.3333334f, 0.0f, 50.0f);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -6.6f);
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLUT glut3 = glut2;
        GLUT glut4 = new GLUT(this);
        this.glut = glut3;
        Display.setVSyncEnabled(true);
        LWJGLUtil.log("Setting up OpenAL");
        AL10.alListener(4100, this.listenerPosition);
        AL10.alListener(4102, this.listenerVelocity);
        AL10.alListener(4111, this.listenerOrientation);
        LWJGLUtil.log("Creating buffers");
        AL10.alGenBuffers(this.soundBuffers);
        Buffer rewind = this.soundBuffers.rewind();
        AL10.alGenSources(this.soundSources);
        Buffer rewind2 = this.soundSources.rewind();
        LWJGLUtil.log("Loading soundfiles...");
        LWJGLUtil.log("Loading left.wav");
        WaveData create = WaveData.create("left.wav");
        AL10.alBufferData(this.soundBuffers.get(0), create.format, create.data, create.samplerate);
        AL10.alSourcef(this.soundSources.get(0), 4099, 1.0f);
        AL10.alSourcef(this.soundSources.get(0), 4106, 1.0f);
        AL10.alSource(this.soundSources.get(0), 4100, this.leftPosition);
        AL10.alSource(this.soundSources.get(0), 4102, this.leftVelocity);
        AL10.alSourcei(this.soundSources.get(0), 4105, this.soundBuffers.get(0));
        AL10.alSourcei(this.soundSources.get(0), 4103, 1);
        LWJGLUtil.log("Loading center.wav");
        WaveData create2 = WaveData.create("center.wav");
        AL10.alBufferData(this.soundBuffers.get(1), create2.format, create2.data, create2.samplerate);
        AL10.alSourcef(this.soundSources.get(1), 4099, 1.0f);
        AL10.alSourcef(this.soundSources.get(1), 4106, 1.0f);
        AL10.alSource(this.soundSources.get(1), 4100, this.centerPosition);
        AL10.alSource(this.soundSources.get(1), 4102, this.centerVelocity);
        AL10.alSourcei(this.soundSources.get(1), 4105, this.soundBuffers.get(1));
        AL10.alSourcei(this.soundSources.get(1), 4103, 1);
        LWJGLUtil.log("Loading right.wav");
        WaveData create3 = WaveData.create("right.wav");
        AL10.alBufferData(this.soundBuffers.get(2), create3.format, create3.data, create3.samplerate);
        AL10.alSourcef(this.soundSources.get(2), 4099, 1.0f);
        AL10.alSourcef(this.soundSources.get(2), 4106, 1.0f);
        AL10.alSource(this.soundSources.get(2), 4100, this.rightPosition);
        AL10.alSource(this.soundSources.get(2), 4102, this.rightVelocity);
        AL10.alSourcei(this.soundSources.get(2), 4105, this.soundBuffers.get(2));
        AL10.alSourcei(this.soundSources.get(2), 4103, 1);
        LWJGLUtil.log("Soundfiles loaded successfully");
        Mouse.setGrabbed(true);
    }

    private void shutdown() {
        LWJGLUtil.log("Shutting down OpenAL");
        AL10.alSourceStop(this.soundSources);
        AL10.alDeleteSources(this.soundSources);
        AL10.alDeleteBuffers(this.soundBuffers);
        C0758AL.destroy();
        LWJGLUtil.log("Shutting down Window");
        Display.destroy();
    }

    private void startSounds() {
        AL10.alSourcePlay(this.soundSources.get(0));
        pause(300);
        AL10.alSourcePlay(this.soundSources.get(1));
        pause(500);
        AL10.alSourcePlay(this.soundSources.get(2));
    }

    /* access modifiers changed from: protected */
    public void execute(String[] strArr) {
        String[] strArr2 = strArr;
        try {
            setup();
        } catch (Exception e) {
            Exception exc = e;
            System.out.println("Error setting up demonstration: ");
            exc.printStackTrace();
            System.exit(-1);
        }
        run();
        shutdown();
    }
}
