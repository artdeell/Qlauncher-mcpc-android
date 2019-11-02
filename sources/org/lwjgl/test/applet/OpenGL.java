package org.lwjgl.test.applet;

import java.io.PrintStream;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.AWTGLCanvas;
import org.lwjgl.opengl.GL11;

public class OpenGL extends AWTGLCanvas implements Test {
    float angle;

    /* renamed from: x */
    float f202x;

    /* renamed from: y */
    float f203y;

    public OpenGL() throws LWJGLException {
    }

    public void initGL() {
        GL11.glMatrixMode(GL11.GL_PROJECTION_MATRIX);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, 640.0d, 0.0d, 480.0d, 1.0d, -1.0d);
        this.f202x = 320.0f;
        this.f203y = 240.0f;
        GL11.glMatrixMode(2982);
        setVSyncEnabled(true);
    }

    public void paintGL() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        GL11.glClear(16384);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.f202x, this.f203y, 0.0f);
        GL11.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
        GL11.glBegin(7);
        GL11.glVertex2i(-50, -50);
        GL11.glVertex2i(50, -50);
        GL11.glVertex2i(50, 50);
        GL11.glVertex2i(-50, 50);
        GL11.glEnd();
        GL11.glPopMatrix();
        this.angle = 1.0f + this.angle;
        if (Mouse.isCreated()) {
            Mouse.poll();
            while (Mouse.next()) {
                this.f202x += (float) Mouse.getEventDX();
                this.f203y += (float) Mouse.getEventDY();
            }
        }
        if (Keyboard.isCreated()) {
            Keyboard.poll();
        }
        while (Keyboard.isCreated() && Keyboard.next()) {
            if (Keyboard.getEventKey() != 0) {
                String keyName = Keyboard.getKeyName(Keyboard.getEventKey());
                if (Keyboard.getEventKeyState()) {
                    switch (Keyboard.getEventKey()) {
                        case 34:
                            Mouse.setGrabbed(!Mouse.isGrabbed());
                            break;
                    }
                    PrintStream printStream = System.out;
                    StringBuilder sb4 = sb3;
                    StringBuilder sb5 = new StringBuilder();
                    printStream.println(sb4.append("Pressed: ").append(keyName).toString());
                } else {
                    PrintStream printStream2 = System.out;
                    StringBuilder sb6 = sb2;
                    StringBuilder sb7 = new StringBuilder();
                    printStream2.println(sb6.append("Released: ").append(keyName).toString());
                }
            }
            if (Keyboard.getEventCharacter() != 0) {
                PrintStream printStream3 = System.out;
                StringBuilder sb8 = sb;
                StringBuilder sb9 = new StringBuilder();
                printStream3.println(sb8.append("Typed: ").append(Keyboard.getEventCharacter()).toString());
            }
        }
        if (Keyboard.isCreated()) {
            if (Keyboard.isKeyDown(200)) {
                this.f203y = 5.0f + this.f203y;
            } else if (Keyboard.isKeyDown(208)) {
                this.f203y -= 5.0f;
            }
            if (Keyboard.isKeyDown(203)) {
                this.f202x -= 5.0f;
            } else if (Keyboard.isKeyDown(205)) {
                this.f202x = 5.0f + this.f202x;
            }
        }
        try {
            swapBuffers();
            if (isVisible()) {
                Thread.yield();
                repaint();
            }
        } catch (Exception e) {
            Exception exc = e;
        }
    }

    public void start() {
    }

    public void stop() {
    }
}
