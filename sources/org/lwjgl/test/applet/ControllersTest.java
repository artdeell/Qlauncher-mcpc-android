package org.lwjgl.test.applet;

import java.awt.Canvas;
import java.io.PrintStream;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controllers;

public class ControllersTest extends Canvas implements Test {
    public ControllersTest() {
    }

    public void start() {
        StringBuilder sb;
        try {
            Controllers.create();
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("Controllers.getControllerCount() = ").append(Controllers.getControllerCount()).toString());
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
    }
}
