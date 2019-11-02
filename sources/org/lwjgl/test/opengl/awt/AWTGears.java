package org.lwjgl.test.opengl.awt;

import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import org.lwjgl.LWJGLException;

public class AWTGears extends Frame {
    public AWTGears() throws LWJGLException {
        AWTGearsCanvas aWTGearsCanvas;
        WindowListener windowListener;
        setTitle("Gears");
        setBackground(Color.BLACK);
        AWTGearsCanvas aWTGearsCanvas2 = aWTGearsCanvas;
        AWTGearsCanvas aWTGearsCanvas3 = new AWTGearsCanvas();
        AWTGearsCanvas aWTGearsCanvas4 = aWTGearsCanvas2;
        aWTGearsCanvas4.setSize(300, 300);
        Component add = add(aWTGearsCanvas4);
        WindowListener windowListener2 = windowListener;
        WindowListener r4 = new WindowAdapter(this) {
            final /* synthetic */ AWTGears this$0;

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
        pack();
        setVisible(true);
    }

    public static void main(String[] strArr) throws LWJGLException {
        AWTGears aWTGears;
        String[] strArr2 = strArr;
        AWTGears aWTGears2 = aWTGears;
        AWTGears aWTGears3 = new AWTGears();
    }
}
