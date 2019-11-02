package org.lwjgl.test.opengl.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.Enumeration;
import java.util.Hashtable;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ARBTransposeMatrix;
import org.lwjgl.opengl.AWTGLCanvas;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.test.openal.PositionTest;

public class DemoBox extends Frame {
    /* access modifiers changed from: private */
    public DemoBoxGLCanvas demoCanvas;
    private Hashtable<String, Demo> selectableDemos;
    private Panel selectionPanel;

    public class ClearColorDemoBox implements Demo {
        float color;
        int direction = 1;
        private boolean initialized;
        final /* synthetic */ DemoBox this$0;

        public ClearColorDemoBox(DemoBox demoBox) {
            this.this$0 = demoBox;
        }

        public void destroy() {
            this.initialized = false;
        }

        public boolean initialize() {
            this.initialized = true;
            return true;
        }

        public boolean isInitialized() {
            return this.initialized;
        }

        public void render() {
            GL11.glClearColor(this.color, this.color, this.color, 1.0f);
            GL11.glClear(16384);
            this.color += 0.05f * ((float) this.direction);
            if (this.color > 1.0f) {
                this.color = 1.0f;
                this.direction = -1 * this.direction;
            } else if (this.color < 0.0f) {
                this.direction = -1 * this.direction;
                this.color = 0.0f;
            }
        }
    }

    public interface Demo {
        void destroy();

        boolean initialize();

        boolean isInitialized();

        void render();
    }

    private class DemoBoxGLCanvas extends AWTGLCanvas implements Runnable {
        Demo activeDemo;
        long fps;
        Demo lastActiveDemo;
        DemoBox parent;
        private Thread renderThread;
        long startTime;
        final /* synthetic */ DemoBox this$0;

        private DemoBoxGLCanvas(DemoBox demoBox) throws LWJGLException {
            this.this$0 = demoBox;
        }

        private DemoBoxGLCanvas(DemoBox demoBox, DemoBox demoBox2) throws LWJGLException {
            DemoBox demoBox3 = demoBox2;
            this.this$0 = demoBox;
            this.parent = demoBox3;
        }

        /* synthetic */ DemoBoxGLCanvas(DemoBox demoBox, DemoBox demoBox2, C08271 r10) throws LWJGLException {
            C08271 r3 = r10;
            this(demoBox, demoBox2);
        }

        private void sleep(long j) {
            try {
                Thread.sleep(j);
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
            }
        }

        public void destroyCanvas() {
            setActiveDemo(null);
            this.renderThread = null;
        }

        /* access modifiers changed from: protected */
        public void paintGL() {
            synchronized (this) {
                try {
                    if (!(this.lastActiveDemo == null || this.lastActiveDemo == this.activeDemo)) {
                        this.lastActiveDemo.destroy();
                        this.lastActiveDemo = null;
                        if (this.activeDemo != null) {
                            boolean initialize = this.activeDemo.initialize();
                            this.startTime = 5000 + System.currentTimeMillis();
                        } else {
                            this.parent.updateFPS(-1.0f);
                        }
                    }
                    if (this.activeDemo != null) {
                        if (!this.activeDemo.isInitialized()) {
                            boolean initialize2 = this.activeDemo.initialize();
                        }
                        this.activeDemo.render();
                        swapBuffers();
                        if (this.startTime > System.currentTimeMillis()) {
                            this.fps = 1 + this.fps;
                        } else {
                            long currentTimeMillis = 5000 + (this.startTime - System.currentTimeMillis());
                            this.startTime = 5000 + System.currentTimeMillis();
                            this.parent.updateFPS(((float) this.fps) / (((float) currentTimeMillis) / 1000.0f));
                            this.fps = 0;
                        }
                    }
                } catch (LWJGLException e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }

        /* JADX INFO: finally extract failed */
        public void run() {
            long j;
            while (this.renderThread != null) {
                synchronized (this) {
                    try {
                        if (this.activeDemo == null) {
                            j = 1000;
                        } else {
                            j = 16;
                            repaint();
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        throw th2;
                    }
                }
                sleep(j);
            }
            System.out.println("dead");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
            if (r0.renderThread != null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
            r3 = r0;
            r4 = r7;
            r5 = new java.lang.Thread(r0);
            r3.renderThread = r4;
            r0.renderThread.setName("DemoBox-Renderer");
            r0.renderThread.start();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void setActiveDemo(org.lwjgl.test.opengl.awt.DemoBox.Demo r9) {
            /*
                r8 = this;
                r0 = r8
                r1 = r9
                r3 = r0
                monitor-enter(r3)
                r3 = r1
                if (r3 != 0) goto L_0x0014
                r3 = r0
                r4 = r0
                org.lwjgl.test.opengl.awt.DemoBox$Demo r4 = r4.activeDemo     // Catch:{ all -> 0x0040 }
                r3.lastActiveDemo = r4     // Catch:{ all -> 0x0040 }
                r3 = r0
                r4 = 0
                r3.activeDemo = r4     // Catch:{ all -> 0x0040 }
                r3 = r0
                monitor-exit(r3)     // Catch:{ all -> 0x0040 }
            L_0x0013:
                return
            L_0x0014:
                r3 = r0
                r4 = r0
                org.lwjgl.test.opengl.awt.DemoBox$Demo r4 = r4.activeDemo     // Catch:{ all -> 0x0040 }
                r3.lastActiveDemo = r4     // Catch:{ all -> 0x0040 }
                r3 = r0
                r4 = r1
                r3.activeDemo = r4     // Catch:{ all -> 0x0040 }
                r3 = r0
                monitor-exit(r3)     // Catch:{ all -> 0x0040 }
                r3 = r0
                java.lang.Thread r3 = r3.renderThread
                if (r3 != 0) goto L_0x0046
                r3 = r0
                java.lang.Thread r4 = new java.lang.Thread
                r7 = r4
                r4 = r7
                r5 = r7
                r6 = r0
                r5.<init>(r6)
                r3.renderThread = r4
                r3 = r0
                java.lang.Thread r3 = r3.renderThread
                java.lang.String r4 = "DemoBox-Renderer"
                r3.setName(r4)
                r3 = r0
                java.lang.Thread r3 = r3.renderThread
                r3.start()
                goto L_0x0013
            L_0x0040:
                r3 = move-exception
                r2 = r3
                r3 = r0
                monitor-exit(r3)     // Catch:{ all -> 0x0040 }
                r3 = r2
                throw r3
            L_0x0046:
                goto L_0x0013
            */
            throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.test.opengl.awt.DemoBox.DemoBoxGLCanvas.setActiveDemo(org.lwjgl.test.opengl.awt.DemoBox$Demo):void");
        }
    }

    public class GearsDemoBox implements Demo {
        private float angle;
        private int gear1;
        private int gear2;
        private int gear3;
        private boolean initialized;
        final /* synthetic */ DemoBox this$0;
        private float view_rotx = 20.0f;
        private float view_roty = 30.0f;
        private float view_rotz;

        public GearsDemoBox(DemoBox demoBox) {
            this.this$0 = demoBox;
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

        public void destroy() {
            GL11.glDeleteLists(this.gear1, 1);
            GL11.glDeleteLists(this.gear2, 1);
            GL11.glDeleteLists(this.gear3, 1);
            this.initialized = false;
        }

        public boolean initialize() {
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
            GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
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
            this.initialized = true;
            return true;
        }

        public boolean isInitialized() {
            return this.initialized;
        }

        public void render() {
            this.angle = 2.0f + this.angle;
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
    }

    public class NullDemoBox implements Demo {
        private boolean initialized;
        final /* synthetic */ DemoBox this$0;

        public NullDemoBox(DemoBox demoBox) {
            this.this$0 = demoBox;
        }

        public void destroy() {
            this.initialized = false;
        }

        public boolean initialize() {
            GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            return true;
        }

        public boolean isInitialized() {
            return this.initialized;
        }

        public void render() {
            GL11.glClear(16384);
        }
    }

    public DemoBox() {
        Hashtable<String, Demo> hashtable;
        NullDemoBox nullDemoBox;
        ClearColorDemoBox clearColorDemoBox;
        GearsDemoBox gearsDemoBox;
        Hashtable<String, Demo> hashtable2 = hashtable;
        Hashtable<String, Demo> hashtable3 = new Hashtable<>();
        this.selectableDemos = hashtable2;
        NullDemoBox nullDemoBox2 = nullDemoBox;
        NullDemoBox nullDemoBox3 = new NullDemoBox(this);
        Object put = this.selectableDemos.put("default", nullDemoBox2);
        ClearColorDemoBox clearColorDemoBox2 = clearColorDemoBox;
        ClearColorDemoBox clearColorDemoBox3 = new ClearColorDemoBox(this);
        Object put2 = this.selectableDemos.put("clear_color", clearColorDemoBox2);
        GearsDemoBox gearsDemoBox2 = gearsDemoBox;
        GearsDemoBox gearsDemoBox3 = new GearsDemoBox(this);
        Object put3 = this.selectableDemos.put("gears", gearsDemoBox2);
    }

    public static void main(String[] strArr) throws LWJGLException {
        DemoBox demoBox;
        String[] strArr2 = strArr;
        DemoBox demoBox2 = demoBox;
        DemoBox demoBox3 = new DemoBox();
        DemoBox demoBox4 = demoBox2;
        boolean initialize = demoBox4.initialize();
        demoBox4.setVisible(true);
    }

    /* access modifiers changed from: protected */
    public void demoSelected(String str) {
        StringBuilder sb;
        String str2 = str;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("Selecting demo: ").append(str2).toString());
        this.demoCanvas.setActiveDemo((Demo) this.selectableDemos.get(str2));
    }

    public boolean initialize() {
        LayoutManager layoutManager;
        Panel panel;
        LayoutManager layoutManager2;
        Component component;
        Button button;
        ActionListener actionListener;
        List list;
        ItemListener itemListener;
        GridBagConstraints gridBagConstraints;
        LWJGLException lWJGLException;
        DemoBoxGLCanvas demoBoxGLCanvas;
        GridBagConstraints gridBagConstraints2;
        WindowListener windowListener;
        setTitle("LWJGL - Demo Box");
        setSize(PositionTest.WINDOW_WIDTH, 480);
        LayoutManager layoutManager3 = layoutManager;
        LayoutManager gridBagLayout = new GridBagLayout();
        setLayout(layoutManager3);
        Panel panel2 = panel;
        Panel panel3 = new Panel();
        this.selectionPanel = panel2;
        Panel panel4 = this.selectionPanel;
        LayoutManager layoutManager4 = layoutManager2;
        LayoutManager borderLayout = new BorderLayout();
        panel4.setLayout(layoutManager4);
        Panel panel5 = this.selectionPanel;
        Component component2 = component;
        Component label = new Label("Demo", 1);
        panel5.add(component2, "North");
        Button button2 = button;
        Button button3 = new Button("Fullscreen");
        Button button4 = button2;
        Button button5 = button4;
        ActionListener actionListener2 = actionListener;
        ActionListener r9 = new ActionListener(this) {
            final /* synthetic */ DemoBox this$0;

            {
                this.this$0 = r5;
            }

            public void actionPerformed(ActionEvent actionEvent) {
                ActionEvent actionEvent2 = actionEvent;
                this.this$0.toggleFullscreen();
            }
        };
        button5.addActionListener(actionListener2);
        this.selectionPanel.add(button4, "South");
        List list2 = list;
        List list3 = new List();
        List list4 = list2;
        Enumeration keys = this.selectableDemos.keys();
        while (keys.hasMoreElements()) {
            list4.add(keys.nextElement().toString());
        }
        this.selectionPanel.add(list4, "Center");
        List list5 = list4;
        ItemListener itemListener2 = itemListener;
        ItemListener r92 = new ItemListener(this) {
            final /* synthetic */ DemoBox this$0;

            {
                this.this$0 = r5;
            }

            public void itemStateChanged(ItemEvent itemEvent) {
                this.this$0.demoSelected(itemEvent.getItemSelectable().getSelectedObjects()[0].toString());
            }
        };
        list5.addItemListener(itemListener2);
        GridBagConstraints gridBagConstraints3 = gridBagConstraints;
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
        GridBagConstraints gridBagConstraints5 = gridBagConstraints3;
        gridBagConstraints5.gridx = 0;
        gridBagConstraints5.gridy = 0;
        gridBagConstraints5.fill = 1;
        gridBagConstraints5.weightx = 0.05d;
        gridBagConstraints5.weighty = 1.0d;
        add(this.selectionPanel, gridBagConstraints5);
        try {
            DemoBoxGLCanvas demoBoxGLCanvas2 = demoBoxGLCanvas;
            DemoBoxGLCanvas demoBoxGLCanvas3 = new DemoBoxGLCanvas(this, this, null);
            this.demoCanvas = demoBoxGLCanvas2;
            GridBagConstraints gridBagConstraints6 = gridBagConstraints2;
            GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
            GridBagConstraints gridBagConstraints8 = gridBagConstraints6;
            try {
                gridBagConstraints8.gridx = 1;
                gridBagConstraints8.gridy = 0;
                gridBagConstraints8.fill = 1;
                gridBagConstraints8.weightx = 0.95d;
                gridBagConstraints8.weighty = 1.0d;
                add(this.demoCanvas, gridBagConstraints8);
                WindowListener windowListener2 = windowListener;
                WindowListener r93 = new WindowAdapter(this) {
                    final /* synthetic */ DemoBox this$0;

                    {
                        this.this$0 = r5;
                    }

                    public void windowClosing(WindowEvent windowEvent) {
                        WindowEvent windowEvent2 = windowEvent;
                        this.this$0.demoCanvas.destroyCanvas();
                        this.this$0.dispose();
                        System.exit(0);
                    }
                };
                addWindowListener(windowListener2);
                return true;
            } catch (LWJGLException e) {
                lWJGLException = e;
                lWJGLException.printStackTrace();
                return false;
            }
        } catch (LWJGLException e2) {
            lWJGLException = e2;
            lWJGLException.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void toggleFullscreen() {
        System.out.println("Toggle Fullscreen");
    }

    public void updateFPS(float f) {
        StringBuilder sb;
        float f2 = f;
        if (f2 != -1.0f) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            setTitle(sb2.append("LWJGL - Demo Box (FPS: ").append(f2).append(")").toString());
            return;
        }
        setTitle("LWJGL - Demo Box");
    }
}
