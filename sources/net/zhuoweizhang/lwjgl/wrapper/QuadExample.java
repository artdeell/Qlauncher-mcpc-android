package net.zhuoweizhang.lwjgl.wrapper;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class QuadExample {
    public QuadExample() {
    }

    public static void main(String[] strArr) {
        QuadExample quadExample;
        String[] strArr2 = strArr;
        QuadExample quadExample2 = quadExample;
        QuadExample quadExample3 = new QuadExample();
        quadExample2.start();
    }

    public void start() {
        DisplayMode displayMode;
        try {
            DisplayMode displayMode2 = displayMode;
            DisplayMode displayMode3 = new DisplayMode(800, 600);
            Display.setDisplayMode(displayMode2);
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, 800.0d, 0.0d, 600.0d, 1.0d, -1.0d);
        GL11.glMatrixMode(5888);
    }

    public void tick() {
        GL11.glClear(16640);
        GL11.glColor3f(0.5f, 0.5f, 1.0f);
        GL11.glBegin(7);
        GL11.glVertex2f(100.0f, 100.0f);
        GL11.glVertex2f(300.0f, 100.0f);
        GL11.glVertex2f(300.0f, 300.0f);
        GL11.glVertex2f(100.0f, 300.0f);
        GL11.glEnd();
    }
}
