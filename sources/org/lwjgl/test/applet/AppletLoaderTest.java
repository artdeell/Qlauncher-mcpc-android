package org.lwjgl.test.applet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.LayoutManager;

public class AppletLoaderTest extends Applet {
    Test test;

    public AppletLoaderTest() {
    }

    public void destroy() {
        AppletLoaderTest.super.destroy();
        System.out.println("*** destroy ***");
    }

    public void init() {
        LayoutManager layoutManager;
        System.out.println("*** init ***");
        LayoutManager layoutManager2 = layoutManager;
        LayoutManager borderLayout = new BorderLayout();
        setLayout(layoutManager2);
        try {
            this.test = (Test) Class.forName(getParameter("test")).newInstance();
            Canvas canvas = this.test;
            canvas.setSize(getWidth(), getHeight());
            Component add = add(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.test.start();
    }

    public void start() {
        AppletLoaderTest.super.start();
        System.out.println("*** start ***");
    }

    public void stop() {
        AppletLoaderTest.super.stop();
        System.out.println("*** stop ***");
        this.test.stop();
    }
}
