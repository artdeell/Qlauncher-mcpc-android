package org.lwjgl;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

abstract class J2SESysImplementation extends DefaultSysImplementation {
    J2SESysImplementation() {
    }

    public void alert(String str, String str2) {
        StringBuilder sb;
        String str3 = str;
        String str4 = str2;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            Exception exc = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Caught exception while setting LAF: ").append(exc).toString());
        }
        JOptionPane.showMessageDialog(null, str4, str3, 2);
    }

    public String getClipboard() {
        StringBuilder sb;
        try {
            Transferable contents = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            if (contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return (String) contents.getTransferData(DataFlavor.stringFlavor);
            }
        } catch (Exception e) {
            Exception exc = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Exception while getting clipboard: ").append(exc).toString());
        }
        return null;
    }

    public long getTime() {
        return System.currentTimeMillis();
    }
}
