package org.lwjgl.examples.spaceinvaders;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.LayoutManager;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

public class GameApplet extends Applet {
    Canvas display_parent;
    Game game;
    Thread gameThread;

    public GameApplet() {
    }

    /* access modifiers changed from: private */
    public void stopLWJGL() {
        Game.gameRunning = false;
        try {
            this.gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        remove(this.display_parent);
        GameApplet.super.destroy();
        System.out.println("Clear up");
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
                final /* synthetic */ GameApplet this$0;

                {
                    this.this$0 = r5;
                }

                public void addNotify() {
                    GameApplet.super.addNotify();
                    this.this$0.startLWJGL();
                }

                public void removeNotify() {
                    this.this$0.stopLWJGL();
                    GameApplet.super.removeNotify();
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

    public void start() {
    }

    public void startLWJGL() {
        C07521 r5;
        C07521 r2 = r5;
        C07521 r3 = new Thread(this) {
            final /* synthetic */ GameApplet this$0;

            {
                this.this$0 = r5;
            }

            public void run() {
                Game game;
                try {
                    Display.setParent(this.this$0.display_parent);
                } catch (LWJGLException e) {
                    e.printStackTrace();
                }
                GameApplet gameApplet = this.this$0;
                Game game2 = game;
                Game game3 = new Game(false);
                gameApplet.game = game2;
                this.this$0.game.execute();
            }
        };
        this.gameThread = r2;
        this.gameThread.start();
    }

    public void stop() {
    }
}
