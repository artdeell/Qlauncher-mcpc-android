package org.lwjgl.test.opengl.awt;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.test.openal.PositionTest;
import org.lwjgl.util.glu.GLU;

public class DisplayParentTest extends Frame {
    boolean killswitch;

    public DisplayParentTest() throws LWJGLException {
        LayoutManager layoutManager;
        Canvas canvas;
        WindowListener windowListener;
        int width;
        int height;
        setTitle("LWJGL Display Parent Test");
        setSize(PositionTest.WINDOW_WIDTH, 320);
        LayoutManager layoutManager2 = layoutManager;
        LayoutManager gridLayout = new GridLayout(1, 2);
        setLayout(layoutManager2);
        Canvas canvas2 = canvas;
        Canvas canvas3 = new Canvas();
        Canvas canvas4 = canvas2;
        canvas4.setFocusable(true);
        canvas4.setIgnoreRepaint(true);
        Component add = add(canvas4);
        WindowListener windowListener2 = windowListener;
        WindowListener r10 = new WindowAdapter(this) {
            final /* synthetic */ DisplayParentTest this$0;

            {
                this.this$0 = r5;
            }

            public void windowClosing(WindowEvent windowEvent) {
                WindowEvent windowEvent2 = windowEvent;
                this.this$0.killswitch = true;
            }
        };
        addWindowListener(windowListener2);
        setResizable(true);
        setVisible(true);
        Display.setParent(canvas4);
        Display.setVSyncEnabled(true);
        Display.create();
        float f = 0.0f;
        while (isVisible() && !this.killswitch) {
            f += 1.0f;
            if (!Display.isFullscreen()) {
                width = canvas4.getWidth();
                height = canvas4.getHeight();
            } else {
                width = Display.getDisplayMode().getWidth();
                height = Display.getDisplayMode().getHeight();
            }
            if (width >= 1 && height >= 1) {
                GL11.glViewport(0, 0, width, height);
                GL11.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
                GL11.glClear(16384);
                GL11.glMatrixMode(GL11.GL_PROJECTION);
                GL11.glLoadIdentity();
                GLU.gluOrtho2D(0.0f, (float) width, 0.0f, (float) height);
                GL11.glMatrixMode(5888);
                GL11.glPushMatrix();
                GL11.glTranslatef(((float) width) / 2.0f, ((float) height) / 2.0f, 0.0f);
                GL11.glRotatef(2.0f * f, 0.0f, 0.0f, -1.0f);
                GL11.glRectf(-50.0f, -50.0f, 50.0f, 50.0f);
                GL11.glPopMatrix();
                Display.update();
                while (true) {
                    if (Keyboard.next()) {
                        if (Keyboard.getEventKey() == 1 && Keyboard.getEventKeyState()) {
                            Display.destroy();
                            dispose();
                            break;
                        }
                        if (Keyboard.getEventKey() == 57 && Keyboard.getEventKeyState()) {
                            Mouse.setGrabbed(!Mouse.isGrabbed());
                        }
                        if (Keyboard.getEventKey() == 33 && Keyboard.getEventKeyState()) {
                            Display.setFullscreen(!Display.isFullscreen());
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        Display.destroy();
        dispose();
    }

    public static void main(String[] strArr) throws LWJGLException {
        DisplayParentTest displayParentTest;
        String[] strArr2 = strArr;
        DisplayParentTest displayParentTest2 = displayParentTest;
        DisplayParentTest displayParentTest3 = new DisplayParentTest();
    }
}
