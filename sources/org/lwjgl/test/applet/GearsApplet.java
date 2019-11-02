package org.lwjgl.test.applet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.LayoutManager;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ARBTransposeMatrix;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

public class GearsApplet extends Applet {
    private float angle;
    Canvas display_parent;
    Thread gameThread;
    private int gear1;
    private int gear2;
    private int gear3;
    boolean keyDown;
    private boolean mouseButtonDown;
    private int prevMouseX;
    private int prevMouseY;
    boolean running;
    private float view_rotx = 20.0f;
    private float view_roty = 30.0f;
    private float view_rotz;

    public GearsApplet() {
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

    /* access modifiers changed from: private */
    public void stopLWJGL() {
        this.running = false;
        try {
            this.gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        remove(this.display_parent);
        GearsApplet.super.destroy();
        System.out.println("Clear up");
    }

    public void drawLoop() {
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
    }

    public void gameLoop() {
        StringBuilder sb;
        long currentTimeMillis = 5000 + System.currentTimeMillis();
        long j = 0;
        while (this.running) {
            this.angle = 2.0f + this.angle;
            drawLoop();
            Display.update();
            if (currentTimeMillis > System.currentTimeMillis()) {
                j++;
            } else {
                long currentTimeMillis2 = 5000 + (currentTimeMillis - System.currentTimeMillis());
                currentTimeMillis = 5000 + System.currentTimeMillis();
                PrintStream printStream = System.out;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                printStream.println(sb2.append(j).append(" frames 2 in ").append(((float) currentTimeMillis2) / 1000.0f).append(" seconds = ").append(((float) j) / (((float) currentTimeMillis2) / 1000.0f)).toString());
                j = 0;
            }
            if (Mouse.isButtonDown(0)) {
                if (!this.mouseButtonDown) {
                    this.prevMouseX = Mouse.getX();
                    this.prevMouseY = Mouse.getY();
                }
                this.mouseButtonDown = true;
            } else {
                this.mouseButtonDown = false;
            }
            if (this.mouseButtonDown) {
                int x = Mouse.getX();
                int y = Mouse.getY();
                float width = 360.0f * (((float) (x - this.prevMouseX)) / ((float) this.display_parent.getWidth()));
                float height = 360.0f * (((float) (this.prevMouseY - y)) / ((float) this.display_parent.getHeight()));
                this.prevMouseX = x;
                this.prevMouseY = y;
                this.view_rotx = height + this.view_rotx;
                this.view_roty = width + this.view_roty;
            }
            if (this.keyDown && !Keyboard.isKeyDown(33)) {
                this.keyDown = false;
                try {
                    if (Display.isFullscreen()) {
                        Display.setFullscreen(false);
                    } else {
                        Display.setFullscreen(true);
                    }
                } catch (LWJGLException e) {
                    e.printStackTrace();
                }
            }
        }
        Display.destroy();
    }

    public void init() {
        LayoutManager layoutManager;
        RuntimeException runtimeException;
        Canvas canvas;
        LayoutManager layoutManager2 = layoutManager;
        LayoutManager borderLayout = new BorderLayout();
        setLayout(layoutManager2);
        try {
            Canvas canvas2 = canvas;
            Canvas r4 = new Canvas(this) {
                final /* synthetic */ GearsApplet this$0;

                {
                    this.this$0 = r5;
                }

                public void addNotify() {
                    GearsApplet.super.addNotify();
                    this.this$0.startLWJGL();
                }

                public void removeNotify() {
                    this.this$0.stopLWJGL();
                    GearsApplet.super.removeNotify();
                }
            };
            this.display_parent = canvas2;
            this.display_parent.setSize(getWidth(), getHeight());
            Component add = add(this.display_parent);
            this.display_parent.setFocusable(true);
            this.display_parent.requestFocus();
            this.display_parent.setIgnoreRepaint(true);
            setVisible(true);
        } catch (Exception e) {
            System.err.println(e);
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("Unable to create display");
            throw runtimeException2;
        }
    }

    /* access modifiers changed from: protected */
    public void initGL() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        try {
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
            StringBuilder sb6 = sb;
            StringBuilder sb7 = new StringBuilder();
            printStream.println(sb6.append("LWJGL: ").append(Sys.getVersion()).append(" / ").append(LWJGLUtil.getPlatformName()).toString());
            PrintStream printStream2 = System.err;
            StringBuilder sb8 = sb2;
            StringBuilder sb9 = new StringBuilder();
            printStream2.println(sb8.append("GL_VENDOR: ").append(GL11.glGetString(GL11.GL_VENDOR)).toString());
            PrintStream printStream3 = System.err;
            StringBuilder sb10 = sb3;
            StringBuilder sb11 = new StringBuilder();
            printStream3.println(sb10.append("GL_RENDERER: ").append(GL11.glGetString(GL11.GL_RENDERER)).toString());
            PrintStream printStream4 = System.err;
            StringBuilder sb12 = sb4;
            StringBuilder sb13 = new StringBuilder();
            printStream4.println(sb12.append("GL_VERSION: ").append(GL11.glGetString(GL11.GL_VERSION)).toString());
            System.err.println();
            PrintStream printStream5 = System.err;
            StringBuilder sb14 = sb5;
            StringBuilder sb15 = new StringBuilder();
            printStream5.println(sb14.append("glLoadTransposeMatrixfARB() supported: ").append(GLContext.getCapabilities().GL_ARB_transpose_matrix).toString());
            if (!GLContext.getCapabilities().GL_ARB_transpose_matrix) {
                GL11.glLoadIdentity();
            } else {
                FloatBuffer put5 = BufferUtils.createFloatBuffer(16).put(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f});
                Buffer flip5 = put5.flip();
                ARBTransposeMatrix.glLoadTransposeMatrixARB(put5);
            }
            float height = ((float) this.display_parent.getHeight()) / ((float) this.display_parent.getWidth());
            GL11.glFrustum(-1.0d, 1.0d, (double) (-height), (double) height, 5.0d, 60.0d);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0f, 0.0f, -40.0f);
        } catch (Exception e) {
            System.err.println(e);
            this.running = false;
        }
    }

    public void start() {
    }

    public void startLWJGL() {
        C08111 r5;
        C08111 r2 = r5;
        C08111 r3 = new Thread(this) {
            final /* synthetic */ GearsApplet this$0;

            {
                this.this$0 = r5;
            }

            public void run() {
                this.this$0.running = true;
                try {
                    Display.setParent(this.this$0.display_parent);
                    Display.create();
                    this.this$0.initGL();
                } catch (LWJGLException e) {
                    e.printStackTrace();
                }
                this.this$0.gameLoop();
            }
        };
        this.gameThread = r2;
        this.gameThread.start();
    }

    public void stop() {
    }
}
