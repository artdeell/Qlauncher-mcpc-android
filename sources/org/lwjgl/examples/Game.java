package org.lwjgl.examples;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.C0758AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Game {
    private static final int FRAMERATE = 60;
    public static final String GAME_TITLE = "My Game";
    private static float angle;
    private static boolean finished;

    private Game() {
    }

    private static void cleanup() {
        C0758AL.destroy();
        Display.destroy();
    }

    private static void init() throws Exception {
        Display.setTitle(GAME_TITLE);
        Display.setFullscreen(true);
        Display.setVSyncEnabled(true);
        Display.create();
        C0758AL.create();
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, (double) Display.getDisplayMode().getWidth(), 0.0d, (double) Display.getDisplayMode().getHeight(), -1.0d, 1.0d);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glViewport(0, 0, Display.getDisplayMode().getWidth(), Display.getDisplayMode().getHeight());
    }

    private static void logic() {
        if (Keyboard.isKeyDown(1)) {
            finished = true;
        }
        angle = 2.0f + angle;
    }

    public static void main(String[] strArr) {
        String[] strArr2 = strArr;
        try {
            init();
            run();
            cleanup();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Sys.alert(GAME_TITLE, "An error occured and the game will exit.");
            cleanup();
        } catch (Throwable th) {
            Throwable th2 = th;
            cleanup();
            throw th2;
        }
        System.exit(0);
    }

    private static void render() {
        GL11.glClear(17408);
        GL11.glClear(16384);
        GL11.glPushMatrix();
        GL11.glTranslatef((float) (Display.getDisplayMode().getWidth() / 2), (float) (Display.getDisplayMode().getHeight() / 2), 0.0f);
        GL11.glRotatef(angle, 0.0f, 0.0f, 1.0f);
        GL11.glBegin(7);
        GL11.glVertex2i(-50, -50);
        GL11.glVertex2i(50, -50);
        GL11.glVertex2i(50, 50);
        GL11.glVertex2i(-50, 50);
        GL11.glEnd();
        GL11.glPopMatrix();
    }

    private static void run() {
        while (!finished) {
            Display.update();
            if (Display.isCloseRequested()) {
                finished = true;
            } else if (Display.isActive()) {
                logic();
                render();
                Display.sync(60);
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    InterruptedException interruptedException = e;
                }
                logic();
                if (Display.isVisible() || Display.isDirty()) {
                    render();
                }
            }
        }
    }
}
