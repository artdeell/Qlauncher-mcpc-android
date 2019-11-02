package org.lwjgl.test.opengl.awt;

import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ARBTransposeMatrix;
import org.lwjgl.opengl.AWTGLCanvas;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.test.applet.Test;

public class AWTGearsCanvas extends AWTGLCanvas implements Test {
    private float angle;
    int current_height;
    int current_width;
    long fps;
    private int gear1;
    private int gear2;
    private int gear3;
    long startTime;
    private float view_rotx = 20.0f;
    private float view_roty = 30.0f;
    private float view_rotz;

    public AWTGearsCanvas() throws LWJGLException {
    }

    private void gear(float f, float f2, float f3, int i, float f4) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        int i2 = i;
        float f8 = f4;
        float f9 = f6 - (f8 / 2.0f);
        float f10 = f6 + (f8 / 2.0f);
        float f11 = (6.2831855f / ((float) i2)) / 4.0f;
        GL11.glShadeModel(GL11.GL_FLAT);
        GL11.glNormal3f(0.0f, 0.0f, 1.0f);
        GL11.glBegin(8);
        for (int i3 = 0; i3 <= i2; i3++) {
            float f12 = (3.1415927f * (2.0f * ((float) i3))) / ((float) i2);
            GL11.glVertex3f(f5 * ((float) Math.cos((double) f12)), f5 * ((float) Math.sin((double) f12)), 0.5f * f7);
            GL11.glVertex3f(f9 * ((float) Math.cos((double) f12)), f9 * ((float) Math.sin((double) f12)), 0.5f * f7);
            if (i3 < i2) {
                GL11.glVertex3f(f5 * ((float) Math.cos((double) f12)), f5 * ((float) Math.sin((double) f12)), 0.5f * f7);
                GL11.glVertex3f(f9 * ((float) Math.cos((double) (f12 + (3.0f * f11)))), f9 * ((float) Math.sin((double) (f12 + (3.0f * f11)))), 0.5f * f7);
            }
        }
        GL11.glEnd();
        GL11.glBegin(7);
        for (int i4 = 0; i4 < i2; i4++) {
            float f13 = (3.1415927f * (2.0f * ((float) i4))) / ((float) i2);
            GL11.glVertex3f(f9 * ((float) Math.cos((double) f13)), f9 * ((float) Math.sin((double) f13)), 0.5f * f7);
            GL11.glVertex3f(f10 * ((float) Math.cos((double) (f13 + f11))), f10 * ((float) Math.sin((double) (f13 + f11))), 0.5f * f7);
            GL11.glVertex3f(f10 * ((float) Math.cos((double) (f13 + (2.0f * f11)))), f10 * ((float) Math.sin((double) (f13 + (2.0f * f11)))), 0.5f * f7);
            GL11.glVertex3f(f9 * ((float) Math.cos((double) (f13 + (3.0f * f11)))), f9 * ((float) Math.sin((double) (f13 + (3.0f * f11)))), 0.5f * f7);
        }
        GL11.glEnd();
        GL11.glBegin(8);
        for (int i5 = 0; i5 <= i2; i5++) {
            float f14 = (3.1415927f * (2.0f * ((float) i5))) / ((float) i2);
            GL11.glVertex3f(f9 * ((float) Math.cos((double) f14)), f9 * ((float) Math.sin((double) f14)), 0.5f * (-f7));
            GL11.glVertex3f(f5 * ((float) Math.cos((double) f14)), f5 * ((float) Math.sin((double) f14)), 0.5f * (-f7));
            GL11.glVertex3f(f9 * ((float) Math.cos((double) (f14 + (3.0f * f11)))), f9 * ((float) Math.sin((double) (f14 + (3.0f * f11)))), 0.5f * (-f7));
            GL11.glVertex3f(f5 * ((float) Math.cos((double) f14)), f5 * ((float) Math.sin((double) f14)), 0.5f * (-f7));
        }
        GL11.glEnd();
        GL11.glBegin(7);
        for (int i6 = 0; i6 < i2; i6++) {
            float f15 = (3.1415927f * (2.0f * ((float) i6))) / ((float) i2);
            GL11.glVertex3f(f9 * ((float) Math.cos((double) (f15 + (3.0f * f11)))), f9 * ((float) Math.sin((double) (f15 + (3.0f * f11)))), 0.5f * (-f7));
            GL11.glVertex3f(f10 * ((float) Math.cos((double) (f15 + (2.0f * f11)))), f10 * ((float) Math.sin((double) (f15 + (2.0f * f11)))), 0.5f * (-f7));
            GL11.glVertex3f(f10 * ((float) Math.cos((double) (f15 + f11))), f10 * ((float) Math.sin((double) (f15 + f11))), 0.5f * (-f7));
            GL11.glVertex3f(f9 * ((float) Math.cos((double) f15)), f9 * ((float) Math.sin((double) f15)), 0.5f * (-f7));
        }
        GL11.glEnd();
        GL11.glBegin(8);
        for (int i7 = 0; i7 < i2; i7++) {
            float f16 = (3.1415927f * (2.0f * ((float) i7))) / ((float) i2);
            GL11.glVertex3f(f9 * ((float) Math.cos((double) f16)), f9 * ((float) Math.sin((double) f16)), 0.5f * f7);
            GL11.glVertex3f(f9 * ((float) Math.cos((double) f16)), f9 * ((float) Math.sin((double) f16)), 0.5f * (-f7));
            float cos = (f10 * ((float) Math.cos((double) (f16 + f11)))) - (f9 * ((float) Math.cos((double) f16)));
            float sin = (f10 * ((float) Math.sin((double) (f16 + f11)))) - (f9 * ((float) Math.sin((double) f16)));
            float sqrt = (float) Math.sqrt((double) ((cos * cos) + (sin * sin)));
            GL11.glNormal3f(sin / sqrt, -(cos / sqrt), 0.0f);
            GL11.glVertex3f(f10 * ((float) Math.cos((double) (f16 + f11))), f10 * ((float) Math.sin((double) (f16 + f11))), 0.5f * f7);
            GL11.glVertex3f(f10 * ((float) Math.cos((double) (f16 + f11))), f10 * ((float) Math.sin((double) (f16 + f11))), 0.5f * (-f7));
            GL11.glNormal3f((float) Math.cos((double) f16), (float) Math.sin((double) f16), 0.0f);
            GL11.glVertex3f(f10 * ((float) Math.cos((double) (f16 + (2.0f * f11)))), f10 * ((float) Math.sin((double) (f16 + (2.0f * f11)))), 0.5f * f7);
            GL11.glVertex3f(f10 * ((float) Math.cos((double) (f16 + (2.0f * f11)))), f10 * ((float) Math.sin((double) (f16 + (2.0f * f11)))), 0.5f * (-f7));
            GL11.glNormal3f((f9 * ((float) Math.sin((double) (f16 + (3.0f * f11))))) - (f10 * ((float) Math.sin((double) (f16 + (2.0f * f11))))), -((f9 * ((float) Math.cos((double) (f16 + (3.0f * f11))))) - (f10 * ((float) Math.cos((double) (f16 + (2.0f * f11)))))), 0.0f);
            GL11.glVertex3f(f9 * ((float) Math.cos((double) (f16 + (3.0f * f11)))), f9 * ((float) Math.sin((double) (f16 + (3.0f * f11)))), 0.5f * f7);
            GL11.glVertex3f(f9 * ((float) Math.cos((double) (f16 + (3.0f * f11)))), f9 * ((float) Math.sin((double) (f16 + (3.0f * f11)))), 0.5f * (-f7));
            GL11.glNormal3f((float) Math.cos((double) f16), (float) Math.sin((double) f16), 0.0f);
        }
        GL11.glVertex3f(f9 * ((float) Math.cos(0.0d)), f9 * ((float) Math.sin(0.0d)), 0.5f * f7);
        GL11.glVertex3f(f9 * ((float) Math.cos(0.0d)), f9 * ((float) Math.sin(0.0d)), 0.5f * (-f7));
        GL11.glEnd();
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glBegin(8);
        for (int i8 = 0; i8 <= i2; i8++) {
            float f17 = (3.1415927f * (2.0f * ((float) i8))) / ((float) i2);
            GL11.glNormal3f(-((float) Math.cos((double) f17)), -((float) Math.sin((double) f17)), 0.0f);
            GL11.glVertex3f(f5 * ((float) Math.cos((double) f17)), f5 * ((float) Math.sin((double) f17)), 0.5f * (-f7));
            GL11.glVertex3f(f5 * ((float) Math.cos((double) f17)), f5 * ((float) Math.sin((double) f17)), 0.5f * f7);
        }
        GL11.glEnd();
    }

    private void setup() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        FloatBuffer put = BufferUtils.createFloatBuffer(4).put(new float[]{5.0f, 5.0f, 10.0f, 0.0f});
        FloatBuffer put2 = BufferUtils.createFloatBuffer(4).put(new float[]{0.8f, 0.1f, 0.0f, 1.0f});
        FloatBuffer put3 = BufferUtils.createFloatBuffer(4).put(new float[]{0.0f, 0.8f, 0.2f, 1.0f});
        FloatBuffer put4 = BufferUtils.createFloatBuffer(4).put(new float[]{0.2f, 0.2f, 1.0f, 1.0f});
        Buffer flip = put.flip();
        Buffer flip2 = put2.flip();
        Buffer flip3 = put3.flip();
        Buffer flip4 = put4.flip();
        GL11.glLight(16384, 4611, put);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(16384);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        this.gear1 = GL11.glGenLists(1);
        GL11.glNewList(this.gear1, GL11.GL_COMPILE);
        GL11.glMaterial((int) GL11.GL_FRONT, (int) GL11.GL_AMBIENT_AND_DIFFUSE, put2);
        gear(1.0f, 4.0f, 1.0f, 20, 0.7f);
        GL11.glEndList();
        this.gear2 = GL11.glGenLists(1);
        GL11.glNewList(this.gear2, GL11.GL_COMPILE);
        GL11.glMaterial((int) GL11.GL_FRONT, (int) GL11.GL_AMBIENT_AND_DIFFUSE, put3);
        gear(0.5f, 2.0f, 2.0f, 10, 0.7f);
        GL11.glEndList();
        this.gear3 = GL11.glGenLists(1);
        GL11.glNewList(this.gear3, GL11.GL_COMPILE);
        GL11.glMaterial((int) GL11.GL_FRONT, (int) GL11.GL_AMBIENT_AND_DIFFUSE, put4);
        gear(1.3f, 2.0f, 0.5f, 10, 0.7f);
        GL11.glEndList();
        GL11.glEnable(GL11.GL_NORMALIZE);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        PrintStream printStream = System.err;
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        printStream.println(sb5.append("GL_VENDOR: ").append(GL11.glGetString(GL11.GL_VENDOR)).toString());
        PrintStream printStream2 = System.err;
        StringBuilder sb7 = sb2;
        StringBuilder sb8 = new StringBuilder();
        printStream2.println(sb7.append("GL_RENDERER: ").append(GL11.glGetString(GL11.GL_RENDERER)).toString());
        PrintStream printStream3 = System.err;
        StringBuilder sb9 = sb3;
        StringBuilder sb10 = new StringBuilder();
        printStream3.println(sb9.append("GL_VERSION: ").append(GL11.glGetString(GL11.GL_VERSION)).toString());
        System.err.println();
        PrintStream printStream4 = System.err;
        StringBuilder sb11 = sb4;
        StringBuilder sb12 = new StringBuilder();
        printStream4.println(sb11.append("glLoadTransposeMatrixfARB() supported: ").append(GLContext.getCapabilities().GL_ARB_transpose_matrix).toString());
        if (!GLContext.getCapabilities().GL_ARB_transpose_matrix) {
            GL11.glLoadIdentity();
        } else {
            FloatBuffer put5 = BufferUtils.createFloatBuffer(16).put(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f});
            Buffer flip5 = put5.flip();
            ARBTransposeMatrix.glLoadTransposeMatrixARB(put5);
        }
        GL11.glFrustum(-1.0d, 1.0d, (double) (-1.0f), (double) 1.0f, 5.0d, 60.0d);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -40.0f);
    }

    public void paintGL() {
        RuntimeException runtimeException;
        StringBuilder sb;
        if (this.startTime == 0) {
            setup();
            this.startTime = 5000 + System.currentTimeMillis();
        }
        try {
            this.angle = 2.0f + this.angle;
            if (!(getWidth() == this.current_width && getHeight() == this.current_height)) {
                this.current_width = getWidth();
                this.current_height = getHeight();
                GL11.glViewport(0, 0, this.current_width, this.current_height);
            }
            GL11.glClear(16640);
            GL11.glPushMatrix();
            GL11.glRotatef(this.view_rotx, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(this.view_roty, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(this.view_rotz, 0.0f, 0.0f, 1.0f);
            GL11.glPushMatrix();
            GL11.glTranslatef(-3.0f, -2.0f, 0.0f);
            GL11.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
            GL11.glCallList(this.gear1);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(3.1f, -2.0f, 0.0f);
            GL11.glRotatef((-2.0f * this.angle) - 9.0f, 0.0f, 0.0f, 1.0f);
            GL11.glCallList(this.gear2);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(-3.1f, 4.2f, 0.0f);
            GL11.glRotatef((-2.0f * this.angle) - 25.0f, 0.0f, 0.0f, 1.0f);
            GL11.glCallList(this.gear3);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            swapBuffers();
            repaint();
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
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(lWJGLException);
            throw runtimeException2;
        }
    }

    public void start() {
    }

    public void stop() {
    }
}
