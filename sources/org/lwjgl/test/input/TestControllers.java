package org.lwjgl.test.input;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;

public class TestControllers extends JPanel {
    public static int total;
    private int buttonCount = this.controller.getButtonCount();
    private Controller controller;
    private int itemCount = (2 + (this.controller.getButtonCount() + this.controller.getAxisCount()));
    private JTextField[] names = new JTextField[this.itemCount];
    private JTextField[] values = new JTextField[this.itemCount];

    public TestControllers(int i) {
        JTextField jTextField;
        JTextField jTextField2;
        JTextField jTextField3;
        JTextField jTextField4;
        Dimension dimension;
        JFrame jFrame;
        Container container;
        WindowListener windowListener;
        JTextField jTextField5;
        JTextField jTextField6;
        JTextField jTextField7;
        JTextField jTextField8;
        int i2 = i;
        this.controller = Controllers.getController(i2);
        setLayout(null);
        for (int i3 = 0; i3 < this.controller.getButtonCount(); i3++) {
            JTextField[] jTextFieldArr = this.names;
            int i4 = i3;
            JTextField jTextField9 = jTextField7;
            JTextField jTextField10 = new JTextField();
            jTextFieldArr[i4] = jTextField9;
            this.names[i3].setEditable(false);
            this.names[i3].setBounds(0, i3 * 30, 100, 30);
            this.names[i3].setText(this.controller.getButtonName(i3));
            Component add = add(this.names[i3]);
            JTextField[] jTextFieldArr2 = this.values;
            int i5 = i3;
            JTextField jTextField11 = jTextField8;
            JTextField jTextField12 = new JTextField();
            jTextFieldArr2[i5] = jTextField11;
            this.values[i3].setEditable(false);
            this.values[i3].setBounds(100, i3 * 30, 100, 30);
            Component add2 = add(this.values[i3]);
        }
        for (int i6 = this.buttonCount; i6 < this.buttonCount + this.controller.getAxisCount(); i6++) {
            JTextField[] jTextFieldArr3 = this.names;
            int i7 = i6;
            JTextField jTextField13 = jTextField5;
            JTextField jTextField14 = new JTextField();
            jTextFieldArr3[i7] = jTextField13;
            this.names[i6].setEditable(false);
            this.names[i6].setBounds(0, i6 * 30, 100, 30);
            this.names[i6].setText(this.controller.getAxisName(i6 - this.buttonCount));
            Component add3 = add(this.names[i6]);
            JTextField[] jTextFieldArr4 = this.values;
            int i8 = i6;
            JTextField jTextField15 = jTextField6;
            JTextField jTextField16 = new JTextField();
            jTextFieldArr4[i8] = jTextField15;
            this.values[i6].setEditable(false);
            this.values[i6].setBounds(100, i6 * 30, 100, 30);
            Component add4 = add(this.values[i6]);
        }
        int i9 = -2 + this.itemCount;
        JTextField[] jTextFieldArr5 = this.names;
        int i10 = i9;
        JTextField jTextField17 = jTextField;
        JTextField jTextField18 = new JTextField();
        jTextFieldArr5[i10] = jTextField17;
        this.names[i9].setEditable(false);
        this.names[i9].setBounds(0, i9 * 30, 100, 30);
        this.names[i9].setText("POV X");
        Component add5 = add(this.names[i9]);
        JTextField[] jTextFieldArr6 = this.values;
        int i11 = i9;
        JTextField jTextField19 = jTextField2;
        JTextField jTextField20 = new JTextField();
        jTextFieldArr6[i11] = jTextField19;
        this.values[i9].setEditable(false);
        this.values[i9].setBounds(100, i9 * 30, 100, 30);
        Component add6 = add(this.values[i9]);
        int i12 = -1 + this.itemCount;
        JTextField[] jTextFieldArr7 = this.names;
        int i13 = i12;
        JTextField jTextField21 = jTextField3;
        JTextField jTextField22 = new JTextField();
        jTextFieldArr7[i13] = jTextField21;
        this.names[i12].setEditable(false);
        this.names[i12].setBounds(0, i12 * 30, 100, 30);
        this.names[i12].setText("POV Y");
        Component add7 = add(this.names[i12]);
        JTextField[] jTextFieldArr8 = this.values;
        int i14 = i12;
        JTextField jTextField23 = jTextField4;
        JTextField jTextField24 = new JTextField();
        jTextFieldArr8[i14] = jTextField23;
        this.values[i12].setEditable(false);
        this.values[i12].setBounds(100, i12 * 30, 100, 30);
        Component add8 = add(this.values[i12]);
        total = 1 + total;
        Dimension dimension2 = dimension;
        Dimension dimension3 = new Dimension(200, 30 * this.itemCount);
        setPreferredSize(dimension2);
        JFrame jFrame2 = jFrame;
        JFrame jFrame3 = new JFrame(this.controller.getName());
        JFrame jFrame4 = jFrame2;
        JFrame jFrame5 = jFrame4;
        Container container2 = container;
        Container jScrollPane = new JScrollPane(this);
        jFrame5.setContentPane(container2);
        JFrame jFrame6 = jFrame4;
        WindowListener windowListener2 = windowListener;
        WindowListener r14 = new WindowAdapter(this) {
            final /* synthetic */ TestControllers this$0;

            {
                this.this$0 = r5;
            }

            public void windowClosing(WindowEvent windowEvent) {
                WindowEvent windowEvent2 = windowEvent;
                TestControllers.total = -1 + TestControllers.total;
                if (TestControllers.total == 0) {
                    System.exit(0);
                }
            }
        };
        jFrame6.addWindowListener(windowListener2);
        jFrame4.setSize(230, NativeDefinitions.KEY_YELLOW);
        jFrame4.setLocation(i2 * 30, i2 * 30);
        jFrame4.setVisible(true);
    }

    public static void main(String[] strArr) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        TestControllers testControllers;
        String[] strArr2 = strArr;
        try {
            Controllers.create();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        int controllerCount = Controllers.getControllerCount();
        PrintStream printStream = System.out;
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        printStream.println(sb5.append(controllerCount).append(" Controllers Found").toString());
        for (int i = 0; i < controllerCount; i++) {
            System.out.println(Controllers.getController(i).getName());
        }
        if (controllerCount == 0) {
            System.exit(0);
        }
        TestControllers[] testControllersArr = new TestControllers[controllerCount];
        for (int i2 = 0; i2 < controllerCount; i2++) {
            TestControllers[] testControllersArr2 = testControllersArr;
            int i3 = i2;
            TestControllers testControllers2 = testControllers;
            TestControllers testControllers3 = new TestControllers(i2);
            testControllersArr2[i3] = testControllers2;
        }
        while (1 != 0) {
            try {
                Thread.sleep(100);
            } catch (Exception e2) {
                Exception exc = e2;
            }
            Controllers.poll();
            while (Controllers.next()) {
                System.out.println("Event Fired: ");
                PrintStream printStream2 = System.out;
                StringBuilder sb7 = sb2;
                StringBuilder sb8 = new StringBuilder();
                printStream2.println(sb7.append("\t").append(Controllers.getEventNanoseconds()).toString());
                PrintStream printStream3 = System.out;
                StringBuilder sb9 = sb3;
                StringBuilder sb10 = new StringBuilder();
                printStream3.println(sb9.append("\t").append(Controllers.getEventSource()).append(":").append(Controllers.getEventControlIndex()).append(":").append(Controllers.isEventButton()).toString());
                PrintStream printStream4 = System.out;
                StringBuilder sb11 = sb4;
                StringBuilder sb12 = new StringBuilder();
                printStream4.println(sb11.append("\t").append(Controllers.isEventXAxis()).append(":").append(Controllers.isEventYAxis()).toString());
            }
            for (int i4 = 0; i4 < controllerCount; i4++) {
                testControllersArr[i4].updateDetails();
            }
        }
    }

    public void updateDetails() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        for (int i = 0; i < this.controller.getButtonCount(); i++) {
            JTextField jTextField = this.values[i];
            StringBuilder sb5 = sb4;
            StringBuilder sb6 = new StringBuilder();
            jTextField.setText(sb5.append(LibrariesRepository.MOJANG_MAVEN_REPO).append(this.controller.isButtonPressed(i)).toString());
        }
        for (int i2 = this.buttonCount; i2 < this.buttonCount + this.controller.getAxisCount(); i2++) {
            JTextField jTextField2 = this.values[i2];
            StringBuilder sb7 = sb3;
            StringBuilder sb8 = new StringBuilder();
            jTextField2.setText(sb7.append(LibrariesRepository.MOJANG_MAVEN_REPO).append(this.controller.getAxisValue(i2 - this.buttonCount)).toString());
        }
        JTextField jTextField3 = this.values[-2 + this.itemCount];
        StringBuilder sb9 = sb;
        StringBuilder sb10 = new StringBuilder();
        jTextField3.setText(sb9.append(LibrariesRepository.MOJANG_MAVEN_REPO).append(this.controller.getPovX()).toString());
        JTextField jTextField4 = this.values[-1 + this.itemCount];
        StringBuilder sb11 = sb2;
        StringBuilder sb12 = new StringBuilder();
        jTextField4.setText(sb11.append(LibrariesRepository.MOJANG_MAVEN_REPO).append(this.controller.getPovY()).toString());
    }
}
