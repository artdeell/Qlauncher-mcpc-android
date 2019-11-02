package org.lwjgl.test.opengl.awt;

import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.AWTGLCanvas;
import org.lwjgl.opengl.GL11;
import org.lwjgl.test.openal.PositionTest;
import org.lwjgl.util.glu.GLU;

public class AWTTest extends Frame {
    /* access modifiers changed from: private */
    public volatile float angle;
    private AWTGLCanvas canvas0;
    private AWTGLCanvas canvas1;

    public AWTTest() throws LWJGLException {
        LayoutManager layoutManager;
        C08241 r9;
        C08252 r92;
        WindowListener windowListener;
        setTitle("LWJGL AWT Canvas Test");
        setSize(PositionTest.WINDOW_WIDTH, 320);
        LayoutManager layoutManager2 = layoutManager;
        LayoutManager gridLayout = new GridLayout(1, 2);
        setLayout(layoutManager2);
        C08241 r4 = r9;
        C08241 r5 = new AWTGLCanvas(this) {
            int current_height;
            int current_width;
            final /* synthetic */ AWTTest this$0;

            {
                this.this$0 = r5;
            }

            public void paintGL() {
                RuntimeException runtimeException;
                try {
                    if (!(getWidth() == this.current_width && getHeight() == this.current_height)) {
                        this.current_width = getWidth();
                        this.current_height = getHeight();
                        GL11.glViewport(0, 0, this.current_width, this.current_height);
                    }
                    GL11.glViewport(0, 0, getWidth(), getHeight());
                    GL11.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glClear(16384);
                    GL11.glMatrixMode(GL11.GL_PROJECTION);
                    GL11.glLoadIdentity();
                    GLU.gluOrtho2D(0.0f, (float) getWidth(), 0.0f, (float) getHeight());
                    GL11.glMatrixMode(5888);
                    GL11.glPushMatrix();
                    GL11.glColor3f(1.0f, 1.0f, 0.0f);
                    GL11.glTranslatef(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, 0.0f);
                    GL11.glRotatef(this.this$0.angle, 0.0f, 0.0f, 1.0f);
                    GL11.glRectf(-50.0f, -50.0f, 50.0f, 50.0f);
                    GL11.glPopMatrix();
                    swapBuffers();
                    repaint();
                } catch (LWJGLException e) {
                    LWJGLException lWJGLException = e;
                    RuntimeException runtimeException2 = runtimeException;
                    RuntimeException runtimeException3 = new RuntimeException(lWJGLException);
                    throw runtimeException2;
                }
            }
        };
        C08241 r1 = r4;
        this.canvas0 = r1;
        Component add = add(r1);
        C08252 r42 = r92;
        C08252 r52 = new AWTGLCanvas(this) {
            int current_height;
            int current_width;
            final /* synthetic */ AWTTest this$0;

            {
                this.this$0 = r5;
            }

            public void paintGL() {
                RuntimeException runtimeException;
                try {
                    float access$016 = AWTTest.access$016(this.this$0, 1.0f);
                    if (!(getWidth() == this.current_width && getHeight() == this.current_height)) {
                        this.current_width = getWidth();
                        this.current_height = getHeight();
                        GL11.glViewport(0, 0, this.current_width, this.current_height);
                    }
                    GL11.glViewport(0, 0, getWidth(), getHeight());
                    GL11.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
                    GL11.glClear(16384);
                    GL11.glMatrixMode(GL11.GL_PROJECTION);
                    GL11.glLoadIdentity();
                    GLU.gluOrtho2D(0.0f, (float) getWidth(), 0.0f, (float) getHeight());
                    GL11.glMatrixMode(5888);
                    GL11.glPushMatrix();
                    GL11.glTranslatef(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, 0.0f);
                    GL11.glRotatef(2.0f * this.this$0.angle, 0.0f, 0.0f, -1.0f);
                    GL11.glRectf(-50.0f, -50.0f, 50.0f, 50.0f);
                    GL11.glPopMatrix();
                    swapBuffers();
                    repaint();
                } catch (LWJGLException e) {
                    LWJGLException lWJGLException = e;
                    RuntimeException runtimeException2 = runtimeException;
                    RuntimeException runtimeException3 = new RuntimeException(lWJGLException);
                    throw runtimeException2;
                }
            }
        };
        C08252 r3 = r42;
        this.canvas1 = r3;
        Component add2 = add(r3);
        WindowListener windowListener2 = windowListener;
        WindowListener r6 = new WindowAdapter(this) {
            final /* synthetic */ AWTTest this$0;

            {
                this.this$0 = r5;
            }

            public void windowClosing(WindowEvent windowEvent) {
                WindowEvent windowEvent2 = windowEvent;
                this.this$0.dispose();
                System.exit(0);
            }
        };
        addWindowListener(windowListener2);
        setResizable(true);
        setVisible(true);
    }

    static /* synthetic */ float access$016(AWTTest aWTTest, float f) {
        AWTTest aWTTest2 = aWTTest;
        float f2 = f + aWTTest2.angle;
        aWTTest2.angle = f2;
        return f2;
    }

    public static void main(String[] strArr) throws LWJGLException {
        AWTTest aWTTest;
        String[] strArr2 = strArr;
        AWTTest aWTTest2 = aWTTest;
        AWTTest aWTTest3 = new AWTTest();
    }
}
