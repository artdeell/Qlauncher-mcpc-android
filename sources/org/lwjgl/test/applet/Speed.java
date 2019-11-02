package org.lwjgl.test.applet;

import java.io.PrintStream;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.AWTGLCanvas;
import org.lwjgl.opengl.GL11;

public class Speed extends AWTGLCanvas implements Test {
    private float angle;
    private long fps;
    private long startTime = (5000 + System.currentTimeMillis());

    public Speed() throws LWJGLException {
    }

    public void paintGL() {
        StringBuilder sb;
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
            if (isVisible()) {
                Thread.yield();
                repaint();
            }
        } catch (Exception e) {
            Exception exc = e;
        }
        if (this.startTime > System.currentTimeMillis()) {
            this.fps = 1 + this.fps;
            return;
        }
        long currentTimeMillis = 5000 + (this.startTime - System.currentTimeMillis());
        this.startTime = 5000 + System.currentTimeMillis();
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append(this.fps).append(" frames in ").append(((float) currentTimeMillis) / 1000.0f).append(" seconds = ").append(((float) this.fps) / (((float) currentTimeMillis) / 1000.0f)).toString());
        this.fps = 0;
    }

    public void start() {
    }

    public void stop() {
    }
}
