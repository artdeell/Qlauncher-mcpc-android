package org.lwjgl.test.applet;

import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.C0758AL;
import org.lwjgl.opengl.AWTGLCanvas;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.WaveData;

public class OpenAL extends AWTGLCanvas implements Test {
    float angle;
    IntBuffer buffers = BufferUtils.createIntBuffer(1);
    IntBuffer sources = BufferUtils.createIntBuffer(1);

    public OpenAL() throws LWJGLException {
        StringBuilder sb;
        C08131 r6;
        try {
            C0758AL.create();
            C08131 r3 = r6;
            C08131 r4 = new Thread(this) {
                final /* synthetic */ OpenAL this$0;

                {
                    this.this$0 = r5;
                }

                public void run() {
                    while (true) {
                        if (this.this$0.isVisible()) {
                            this.this$0.repaint();
                        }
                        Display.sync(60);
                    }
                }
            };
            C08131 r2 = r3;
            r2.setDaemon(true);
            r2.start();
        } catch (Exception e) {
            Exception exc = e;
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("Unable to create OpenAL.\nPlease make sure that OpenAL is available on this system. Exception: ").append(exc).toString());
        }
    }

    private void exit(int i) {
        StringBuilder sb;
        int i2 = i;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("OpenAL Error: ").append(AL10.alGetString(i2)).toString());
    }

    private void playOpenAL() {
        Buffer limit = this.buffers.position(0).limit(1);
        AL10.alGenBuffers(this.buffers);
        int alGetError = AL10.alGetError();
        if (alGetError != 0) {
            exit(alGetError);
        }
        Buffer limit2 = this.sources.position(0).limit(1);
        AL10.alGenSources(this.sources);
        int alGetError2 = AL10.alGetError();
        if (alGetError2 != 0) {
            exit(alGetError2);
        }
        WaveData create = WaveData.create(getClass().getClassLoader().getResourceAsStream("Footsteps.wav"));
        AL10.alBufferData(this.buffers.get(0), create.format, create.data, create.samplerate);
        create.dispose();
        int alGetError3 = AL10.alGetError();
        if (alGetError3 != 0) {
            exit(alGetError3);
        }
        AL10.alSourcei(this.sources.get(0), 4105, this.buffers.get(0));
        int alGetError4 = AL10.alGetError();
        if (alGetError4 != 0) {
            exit(alGetError4);
        }
        AL10.alSourcei(this.sources.get(0), 4103, 1);
        int alGetError5 = AL10.alGetError();
        if (alGetError5 != 0) {
            exit(alGetError5);
        }
        AL10.alSourcePlay(this.sources.get(0));
        int alGetError6 = AL10.alGetError();
        if (alGetError6 != 0) {
            exit(alGetError6);
        }
    }

    public void paintGL() {
        GL11.glClear(16384);
        GL11.glMatrixMode(GL11.GL_PROJECTION_MATRIX);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, 640.0d, 0.0d, 480.0d, 1.0d, -1.0d);
        GL11.glMatrixMode(2982);
        GL11.glPushMatrix();
        GL11.glTranslatef(320.0f, 240.0f, 0.0f);
        GL11.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
        GL11.glBegin(7);
        GL11.glVertex2i(-50, -50);
        GL11.glVertex2i(50, -50);
        GL11.glVertex2i(50, 50);
        GL11.glVertex2i(-50, 50);
        GL11.glEnd();
        GL11.glPopMatrix();
        this.angle = 1.0f + this.angle;
        try {
            swapBuffers();
        } catch (Exception e) {
            Exception exc = e;
        }
    }

    public void start() {
        playOpenAL();
    }

    public void stop() {
        AL10.alSourceStop(this.sources.get(0));
        int alGetError = AL10.alGetError();
        if (alGetError != 0) {
            exit(alGetError);
        }
        Buffer limit = this.sources.position(0).limit(1);
        AL10.alDeleteSources(this.sources);
        int alGetError2 = AL10.alGetError();
        if (alGetError2 != 0) {
            exit(alGetError2);
        }
        Buffer limit2 = this.buffers.position(0).limit(1);
        AL10.alDeleteBuffers(this.buffers);
        int alGetError3 = AL10.alGetError();
        if (alGetError3 != 0) {
            exit(alGetError3);
        }
        C0758AL.destroy();
    }
}
